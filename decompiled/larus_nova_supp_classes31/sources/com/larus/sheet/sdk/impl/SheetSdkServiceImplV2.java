package com.larus.sheet.sdk.impl;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.office.IOfficeSdkService;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.plugins.attachment.OpenImagePluginV2;
import com.larus.office.base.plugins.authorization.LarkAuthorizationPluginV2;
import com.larus.office.base.plugins.editpanel.HostEditPanelPlugin;
import com.larus.office.base.plugins.media.SheetSelectMediaPluginV2;
import com.larus.office.base.plugins.permission.PermissionChangeHandlePluginV2;
import com.larus.office.base.plugins.share.OfficeSharePermissionPlugin;
import com.larus.office.base.plugins.statistics.ReportEventPluginV2;
import com.larus.office.base.plugins.titlebar.FlowDocTitleMenuPluginV2;
import com.larus.office.base.plugins.toast.ToastPluginV2;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.office.base.service.m;
import com.larus.platform.service.z2;
import com.larus.sheet.sdk.api.ISheetSdkServiceV2;
import com.larus.sheet.sdk.impl.plugins.chat_input.SheetChatInputVisibilityPlugin;
import com.larus.sheet.sdk.impl.plugins.event.GetTrackInfoPluginV2;
import com.larus.sheet.sdk.impl.plugins.event.SheetLoadEventPluginV2;
import com.larus.sheet.sdk.impl.plugins.orientation.OrientationInfoPlugin;
import com.larus.sheet.sdk.impl.plugins.orientation.ToggleTitleBarPluginV2;
import com.larus.sheet.sdk.impl.plugins.selection.SheetSelectionChangePluginV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import ew4.b0;
import ew4.e0;
import ew4.f0;
import ew4.g0;
import ew4.w;
import ew4.z;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 C2\u00020\u0001:\u0002CDB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J<\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096@¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010(\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0010H\u0016Jr\u0010.\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u00010\u00102\b\u00102\u001a\u0004\u0018\u00010\u00102\b\u00103\u001a\u0004\u0018\u00010\u001022\u00104\u001a.\u0012\u0004\u0012\u00020'\u0012\u0006\u0012\u0004\u0018\u000106\u0012\u0006\u0012\u0004\u0018\u000107\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u001205H\u0016J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u00100\u001a\u00020\u0010H\u0002J\u0014\u0010:\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100;H\u0002J\b\u0010<\u001a\u00020\u0012H\u0002J\u0010\u0010=\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J0\u0010>\u001a\u00020\u00122\b\u0010?\u001a\u0004\u0018\u00010\u00102\b\u0010@\u001a\u0004\u0018\u00010\u00102\b\u0010A\u001a\u0004\u0018\u00010\u00102\b\u0010B\u001a\u0004\u0018\u00010\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006E"}, d2 = {"Lcom/larus/sheet/sdk/impl/SheetSdkServiceImplV2;", "Lcom/larus/sheet/sdk/api/ISheetSdkServiceV2;", "<init>", "()V", "docSdk", "Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "lifecycleOrder", "", "lifecycleCategory", "", "preInitDocSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "initDocSdk", "postInitDocSdk", "destroyDocSdk", "openAndGetSheetFragment", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "inputParam", "Lcom/larus/office/OfficeInputParam;", "listener", "Lcom/larus/office/permission/IOfficePermissionListener;", "hostAbilityProvider", "Lcom/larus/office/OfficeHostAbilityProvider;", "reloadInterceptor", "Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "(Landroid/content/Context;Lcom/larus/office/OfficeInputParam;Lcom/larus/office/permission/IOfficePermissionListener;Lcom/larus/office/OfficeHostAbilityProvider;Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadDocumentData", "tryPrefetchData", "", "initSdkIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildTargetUrl", "host", "onContextMenuShow", "key", "startDocExport", "fileName", "fileType", "type", "token", "eventSource", "callback", "Lkotlin/Function5;", "Landroid/net/Uri;", "", "fileTypeToExportFormat", "Lcom/bytedance/ee/bear/contract/export/ExportFormatEnum;", "getHost", "Lkotlin/Pair;", "initOfficeSdkIfNeeded", "injectUserHostAbility", "updateTrackParams", "artifactMetaId", "conversationId", "messageId", "botId", "Companion", "SheetOpenStrategy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetSdkServiceImplV2 implements ISheetSdkServiceV2 {
    public static final /* synthetic */ int c = 0;
    public ik5.a a;
    public final Lazy b;

    public static final class a {
    }

    public static final class b extends kk5.g {
        public b(ik5.a r2) {
            Intrinsics.checkNotNullParameter(r2, "docSdk");
            super(r2);
        }

        public final n getBizPluginList(ChameleonPluginHost r12) {
            Intrinsics.checkNotNullParameter(r12, "pluginHost");
            IOfficeSdkService r1 = (IOfficeSdkService) ServiceManager.get().getService(IOfficeSdkService.class);
            if (r1 == null) goto L5;
            n r2 = r1.g("sheet");
        L6:
            SheetSelectMediaPluginV2 r4 = new SheetSelectMediaPluginV2(new com.larus.office.base.plugins.media.a());
            PluginMountStrategy r5 = PluginMountStrategy.LoadFinish;
            OfficeSharePermissionPlugin r6 = new OfficeSharePermissionPlugin();
            z2 r8 = z2.a;
            boolean r9 = r8.f4();
            PluginMountStrategy r10 = PluginMountStrategy.Immediate;
            n r7 = new n(new n.a[]{n.i(r4, true, r5), n.i(r6, r9, r10)});
            if (r8.f4() == false) goto L14;
            Intrinsics.checkNotNullParameter(r12, "pluginHost");
            n r13 = ((kk5.g) this).a.getBizPluginList(r12);
            if (r2 == null) goto L13;
            r7 = n.c(r2, r7);
        L13:
            return n.c(r13, r7);
        L14:
            Intrinsics.checkNotNullParameter(r12, "pluginHost");
            return n.c(((kk5.g) this).a.getBizPluginList(r12), n.c(r7, new n(new n.a[]{n.i(new SheetLoadEventPluginV2(), true, r10), n.i(new LarkAuthorizationPluginV2(), true, r10), n.i(new ReportEventPluginV2(), true, r10), n.i(new ReportEventPluginV2(), true, r10), n.i(new FlowDocTitleMenuPluginV2(false), true, r10), n.i(new ToastPluginV2(), true, PluginMountStrategy.FirstJSCall), n.i(new SheetSelectionChangePluginV2(), true, r5), n.i(new OpenImagePluginV2(), true, r5), n.i(new ToggleTitleBarPluginV2(), true, r10), n.i(new HostEditPanelPlugin(new com.larus.sheet.sdk.impl.b()), true, r10), n.i(new OrientationInfoPlugin(), true, r10), n.i(new SheetChatInputVisibilityPlugin(), true, r5), n.i(new GetTrackInfoPluginV2(), true, r10), n.i(new GetTrackInfoPluginV2(), true, r10), n.i(new PermissionChangeHandlePluginV2(), true, r10)})));
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
    }

    public final void destroyDocSdk() {
        this.a = null;
    }

    public final String lifecycleCategory() {
        return "sheet";
    }

    public final int lifecycleOrder() {
        return 2;
    }

    public final Pair<Boolean, String> W() {
        AppHost.Companion r0 = AppHost.a;
        boolean r2 = true;
        if (r0.isDebug() == false) goto L5;
    L6:
        String r1 = ((Keva) this.b.getValue()).getString("doc_host", "");
        Intrinsics.checkNotNull(r1);
        if (r1.length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L12;
    L18:
        r1 = "https://www.doubao.com";
    L20:
        return new Pair(Boolean.valueOf(r2), r1);
    L12:
        if (StringsKt.startsWith$default(r1, "http://", false, 2, null) == false) goto L14;
    L17:
        r2 = false;
        goto L20
    L14:
        if (StringsKt.startsWith$default(r1, "https://", false, 2, null) == true) goto L17;
        r1 = "http://".concat(r1);
        goto L17
    L9:
        r3 = false;
        goto L10
    L5:
        if (r0.isTestChannel() == false) goto L18;
        goto L6
    }

    public final void X() {
        FLogger.a.i("SheetSdkServiceImplV2", "Init Office sdk if needed");
        IOfficeSdkServiceV2 r0 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r0 == null) goto L6;
        IOfficeSdkServiceV2.a.b(r0, false, null, 7);
        return;
    }

    public SheetSdkServiceImplV2() {
        this.b = LazyKt.lazy(new com.larus.sheet.sdk.impl.a());
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkServiceV2
    public final void G() {
        Lazy r0 = m.a;
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkServiceV2
    public final Object a(Continuation<? super Unit> r5) {
        if ((r5 instanceof SheetSdkServiceImplV2$initSdkIfNeeded$1) == false) goto L7;
        SheetSdkServiceImplV2$initSdkIfNeeded$1 r0 = (SheetSdkServiceImplV2$initSdkIfNeeded$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        SheetSdkServiceImplV2 r4 = (SheetSdkServiceImplV2) r0.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L30
    L24:
        ik5.a r7 = (ik5.a) r6;     // Catch: Exception -> L30
    L26:
        r4.a = r7;     // Catch: Exception -> L30
        ik5.a r8 = this.a;     // Catch: Exception -> L30
        if (r8 == null) goto L33;
        r8.Ka(sbb.e.h, new b(r8));     // Catch: Exception -> L30
    L33:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r6);
        if (this.a != null) goto L33;
        X();     // Catch: Exception -> L30
        IOfficeSdkServiceV2 r9 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Exception -> L30
        if (r9 == null) goto L25;
        r0.L$0 = this;     // Catch: Exception -> L30
        r0.label = 1;     // Catch: Exception -> L30
        r6 = r9.o0(15000, r0);     // Catch: Exception -> L30
        if (r6 != r2) goto L23;
        return r2;
    L23:
        r4 = this;
        goto L24
    L25:
        r7 = null;
        r4 = this;
    L30:
        e = move-exception;
        FLogger.a.e("SheetSdkServiceImplV2", "Load docSdk failed: " + e.getMessage());
    L7:
        r0 = new SheetSdkServiceImplV2$initSdkIfNeeded$1(this, r5);
        goto L8
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkServiceV2
    public final boolean c(OfficeInputParam r7) {
        Intrinsics.checkNotNullParameter(r7, "inputParam");
        ik5.a r0 = this.a;
        if (r0 != null) goto L11;
        IOfficeSdkServiceV2 r1 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r1 == null) goto L9;
        r0 = r1.c0();
        if (r0 == null) goto L9;
        this.a = r0;
    L9:
        r0 = null;
    L11:
        if (r0 != null) goto L14;
        FLogger.a.i("SheetSdkServiceImplV2", "tryPrefetchData skipped, docSdk not ready, token=" + r7.getSlidesToken());
        return false;
    L14:
        String r2 = V((String) W().getSecond(), r7);
        FLogger.a.i("SheetSdkServiceImplV2", "tryPrefetchData, token=" + r7.getSlidesToken());
        r0.r2(r2, "doubao");
        return true;
    }

    public final void initDocSdk(OfficeSDKUserApi r3) {
        Intrinsics.checkNotNullParameter(r3, "officeSDKUserApi");
        IOfficeSdkServiceV2 r4 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r4 == null) goto L5;
        ik5.a r5 = r4.c0();
    L6:
        this.a = r5;
        FLogger.a.i("SheetSdkServiceImplV2", "initDocSdk: docSdk:" + this.a);
        ik5.a r6 = this.a;
        if (r6 == null) goto L10;
        r6.Ka(sbb.e.h, new b(r6));
        return;
    L10:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkServiceV2
    public final void j(OfficeInputParam r7) {
        Intrinsics.checkNotNullParameter(r7, "inputParam");
        ik5.a r0 = this.a;
        if (r0 != null) goto L6;
        FLogger.a.i("SheetSdkServiceImplV2", "preloadDocumentData skipped, docSdk not ready, token=" + r7.getSlidesToken());
        return;
    L6:
        String r2 = V((String) W().getSecond(), r7);
        FLogger.a.i("SheetSdkServiceImplV2", "preloadDocumentData, token=" + r7.getSlidesToken());
        r0.Qd(r2);
    }

    public final void postInitDocSdk(OfficeSDKUserApi r3) {
        Intrinsics.checkNotNullParameter(r3, "officeSDKUserApi");
        FLogger.a.i("SheetSdkServiceImplV2", "postInitDocSdk: docSdk:" + this.a);
    }

    public final void preInitDocSdk(OfficeSDKUserApi r4) {
        Intrinsics.checkNotNullParameter(r4, "officeSDKUserApi");
        FLogger.a.i("SheetSdkServiceImplV2", "preInitDocSdk: docSdk:" + this.a);
        r4.setHostService(z.class, new c());
        r4.setHostService(f0.class, new d());
        r4.setHostService(g0.class, new e());
        r4.setHostService(gm5.a.class, new g(this));
        r4.setHostService(e0.class, new h());
        r4.setHostService(b0.class, new i());
        r4.setHostService(w.class, new j());
    }

    public final String V(String r6, OfficeInputParam r7) {
        int r0 = r7.getResourceVersion();
        String r1 = r7.getSlidesToken();
        String r2 = r7.getEnterFrom();
        String r3 = r7.getSheet();
        Uri.Builder r8 = UriProtector.parse(r6).buildUpon().appendPath("sheets").appendPath(r1);
        if (r0 < 0) goto L6;
        r8.appendQueryParameter("version", String.valueOf(r0));
    L6:
        if ((!StringsKt.isBlank(r2)) == false) goto L9;
        r8.appendQueryParameter("from", r2);
    L9:
        if ((!StringsKt.isBlank(r3)) == false) goto L11;
        r8.appendQueryParameter("sheet", r3);
    L11:
        com.larus.office.base.preview.c r4 = com.larus.office.base.preview.c.a;
        String r9 = r8.build().toString();
        String r10 = r7.getSourceUrlForParams();
        r4.getClass();
        return com.larus.office.base.preview.c.j(r9, r10);
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkServiceV2
    public final Object T(OfficeInputParam r15, fo9.b r16, com.larus.office.h r17, com.bytedance.ee.bear.container.f r18, Continuation r19) {
        if ((r19 instanceof SheetSdkServiceImplV2$openAndGetSheetFragment$1) == false) goto L7;
        SheetSdkServiceImplV2$openAndGetSheetFragment$1 r2 = (SheetSdkServiceImplV2$openAndGetSheetFragment$1) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        SheetSdkServiceImplV2 r6 = (SheetSdkServiceImplV2) r2.L$4;
        com.bytedance.ee.bear.container.f r7 = (com.bytedance.ee.bear.container.f) r2.L$3;
        com.larus.office.h r8 = (com.larus.office.h) r2.L$2;
        fo9.b r9 = (fo9.b) r2.L$1;
        OfficeInputParam r10 = (OfficeInputParam) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14
    L33:
        ik5.a r1 = (ik5.a) r0;     // Catch: Exception -> L14
    L43:
        r6.a = r1;     // Catch: Exception -> L14
    L49:
        com.bytedance.ee.bear.container.f r13 = r7;
    L51:
        sw9.g.f = r10;
        k r12 = new k(new an9.a(r9), r8, r10);
        String r11 = V((String) W().getSecond(), r10);
        if (r10.getDocPreloaded() == false) goto L54;
        FLogger.a.i("SheetSdkServiceImplV2", "skip preload in openAndGetSheetFragment, already preloaded upstream, token=" + r10.getSlidesToken());
    L57:
        ik5.a r14 = this.a;
        if (r14 == null) goto L62;
        Fragment r20 = r14.C6(r11, Boxing.boxLong(r10.getClickTimestamp()), null, r12, r13);
        if (r20 == null) goto L62;
        return r20;
    L62:
        return new Fragment();
    L54:
        FLogger.a.i("SheetSdkServiceImplV2", "preload in openAndGetSheetFragment, token=" + r10.getSlidesToken());
        ik5.a r21 = this.a;
        if (r21 == null) goto L57;
        r21.Qd(r11);
    L14:
        e = e;
    L48:
        FLogger.a.e("SheetSdkServiceImplV2", "Load docSdk failed: " + e.getMessage());
        goto L49
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        FLogger.a.i("SheetSdkServiceImplV2", "Get slides fragment, docSdk:" + this.a);
        ((Keva) this.b.getValue()).storeBoolean("has_opened_fusion_doc", true);
        if (this.a == null) goto L69;
        r9 = r16;
        r10 = r15;
        r8 = r17;
        r13 = r18;
        goto L51
    L69:
        X();     // Catch: Exception -> L45
        IOfficeSdkServiceV2 r22 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Exception -> L45
        OfficeInputParam r23 = r15;
        if (r22 != null) goto L71;
        r9 = r16;
        r1 = null;
        r6 = this;
        r10 = r23;
        r8 = r17;
        r7 = r18;
        goto L43
    L71:
        r2.L$0 = r23;     // Catch: Exception -> L40
        r9 = r16;
        r2.L$1 = r9;     // Catch: Exception -> L38
        com.larus.office.h r24 = r17;
        r2.L$2 = r24;     // Catch: Exception -> L36
        com.bytedance.ee.bear.container.f r25 = r18;
        r2.L$3 = r25;     // Catch: Exception -> L34
        r2.L$4 = this;     // Catch: Exception -> L34
        r2.label = 1;     // Catch: Exception -> L34
        r0 = r22.o0(15000, r2);     // Catch: Exception -> L34
        if (r0 != r4) goto L32;
        return r4;
    L32:
        r6 = this;
        r10 = r23;
        r8 = r24;
        r7 = r25;
    L34:
        e = e;
    L47:
        r10 = r23;
        r8 = r24;
        r7 = r25;
    L36:
        e = e;
    L37:
        r25 = r18;
    L38:
        e = e;
    L39:
        r24 = r17;
    L40:
        e = e;
    L41:
        r9 = r16;
    L45:
        e = e;
        r23 = r15;
    L7:
        r2 = new SheetSdkServiceImplV2$openAndGetSheetFragment$1(this, r19);
        goto L8
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkServiceV2
    public final void n(Context r10, String r11, String r12, String r13, String r14, com.larus.sheet.operation.download.b r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        Intrinsics.checkNotNullParameter(r12, "fileType");
        Intrinsics.checkNotNullParameter(r15, "callback");
        ik5.a r0 = this.a;
        if (r0 == null) goto L5;
        j15.a r2 = r0.R4(r10, r11);
    L6:
        if (r2 != null) goto L9;
        r15.invoke(Boolean.FALSE, null, null, null, "export executor is null");
        return;
    L9:
        String r16 = r12.toLowerCase(Locale.ROOT);
        switch(r16.hashCode()) {
            case 110834: goto L29;
            case 115312: goto L25;
            case 3088960: goto L21;
            case 3447940: goto L17;
            case 96948919: goto L13;
            default: goto L33;
        };
    L33:
        rw4.n r3 = null;
    L34:
        if (r3 != null) goto L37;
        r15.invoke(Boolean.FALSE, null, null, null, "unsupported fileType: ".concat(r12));
        return;
    L37:
        if (r14 != null) goto L39;
    L41:
        String r5 = null;
    L42:
        if (r5 != null) goto L45;
        r15.invoke(Boolean.FALSE, null, null, null, "token is empty");
        return;
    L45:
        r2.a(r3, r13, r5, "41", null, new l(r15));
        return;
    L39:
        if ((!StringsKt.isBlank(r14)) == false) goto L41;
        r5 = r14;
        goto L42
    L13:
        if (r16.equals("excel") == false) goto L47;
        rw4.n r17 = rw4.n.g;
    L32:
        r3 = r17;
        goto L34
    L47:
        r3 = null;
        goto L34
    L17:
        if (r16.equals("pptx") == false) goto L48;
        r17 = rw4.n.h;
        goto L32
    L48:
        r3 = null;
        goto L34
    L21:
        if (r16.equals("docx") == false) goto L49;
        r17 = rw4.n.c;
        goto L32
    L49:
        r3 = null;
        goto L34
    L25:
        if (r16.equals("txt") == false) goto L50;
        r17 = rw4.n.i;
        goto L32
    L50:
        r3 = null;
        goto L34
    L29:
        if (r16.equals("pdf") == false) goto L51;
        r17 = rw4.n.d;
        goto L32
    L51:
        r3 = null;
        goto L34
    L5:
        r2 = null;
        goto L6
    }
}
