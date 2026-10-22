package com.larus.slides.sdk.impl;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.office.IOfficeSdkService;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.plugins.attachment.OpenImagePluginV2;
import com.larus.office.base.plugins.authorization.LarkAuthorizationPluginV2;
import com.larus.office.base.plugins.dialog.AlertPluginV2;
import com.larus.office.base.plugins.editpanel.HostEditPanelPlugin;
import com.larus.office.base.plugins.permission.PermissionChangeHandlePluginV2;
import com.larus.office.base.plugins.share.OfficeSharePermissionPlugin;
import com.larus.office.base.plugins.statistics.ReportEventPluginV2;
import com.larus.office.base.plugins.titlebar.FlowDocTitleMenuPluginV2;
import com.larus.office.base.plugins.toast.ToastPluginV2;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.office.base.utils.f;
import com.larus.platform.service.z2;
import com.larus.slides.sdk.api.ISlidesSdkServiceV2;
import com.larus.slides.sdk.impl.plugins.cot.RenderFinishPluginV2;
import com.larus.slides.sdk.impl.plugins.event.GetTrackInfoPluginV2;
import com.larus.slides.sdk.impl.plugins.event.SlidesLoadEventPluginV2;
import com.larus.slides.sdk.impl.plugins.media.AIGenerateImagePluginV2;
import com.larus.slides.sdk.impl.plugins.media.SlidesSelectMediaPluginV2;
import com.larus.slides.sdk.impl.plugins.orientation.GetOrientationPluginV2;
import com.larus.slides.sdk.impl.plugins.orientation.SetFullscreenPluginV2;
import com.larus.slides.sdk.impl.plugins.orientation.SetOrientationPluginV2;
import com.larus.slides.sdk.impl.plugins.orientation.SlidesStateChangedPluginV2;
import com.larus.slides.sdk.impl.plugins.orientation.ToggleTitleBarPluginV2;
import com.larus.slides.sdk.impl.plugins.selection.SlidesSelectionChangePluginV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Locale;
import kk5.h;
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
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 >2\u00020\u0001:\u0002>?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J<\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096@¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0002Jj\u0010,\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u00010\u00122\b\u00100\u001a\u0004\u0018\u00010\u00122\b\u00101\u001a\u0004\u0018\u00010\u00122*\u00102\u001a&\u0012\u0004\u0012\u00020)\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u001403H\u0016J\b\u00105\u001a\u00020\u0014H\u0016J\u000e\u00106\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u00107J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u0010.\u001a\u00020\u0012H\u0002J\u0014\u0010:\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120;H\u0002J\b\u0010<\u001a\u00020\u0014H\u0002J\u0010\u0010=\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006@"}, d2 = {"Lcom/larus/slides/sdk/impl/SlidesSdkServiceImplV2;", "Lcom/larus/slides/sdk/api/ISlidesSdkServiceV2;", "<init>", "()V", "docSdk", "Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "documentExportExecutor", "Lcom/bytedance/ee/bear/document/export/net/DocumentExportExecutor;", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "lifecycleOrder", "", "lifecycleCategory", "", "preInitDocSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "initDocSdk", "postInitDocSdk", "destroyDocSdk", "openAndGetSlidesFragment", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "inputParam", "Lcom/larus/office/OfficeInputParam;", "listener", "Lcom/larus/office/permission/IOfficePermissionListener;", "hostAbilityProvider", "Lcom/larus/office/OfficeHostAbilityProvider;", "reloadInterceptor", "Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "(Landroid/content/Context;Lcom/larus/office/OfficeInputParam;Lcom/larus/office/permission/IOfficePermissionListener;Lcom/larus/office/OfficeHostAbilityProvider;Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadDocumentData", "tryPrefetchData", "", "buildTargetUrl", "host", "startDocExport", "fileName", "fileType", "type", "token", "eventSource", "callback", "Lkotlin/Function4;", "Landroid/net/Uri;", "cancelDocExport", "initSdkIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fileTypeToExportFormat", "Lcom/bytedance/ee/bear/contract/export/ExportFormatEnum;", "getHost", "Lkotlin/Pair;", "initOfficeSdkIfNeeded", "injectUserHostAbility", "Companion", "SlidesOpenStrategy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesSdkServiceImplV2 implements ISlidesSdkServiceV2 {
    public static final /* synthetic */ int d = 0;
    public ik5.a a;
    public j15.a b;
    public final Lazy c;

    public static final class a {
    }

    public static final class b extends h {
        public b(ik5.a r2) {
            Intrinsics.checkNotNullParameter(r2, "docSdk");
            super(r2);
        }

        public final n getBizPluginList(ChameleonPluginHost r9) {
            Intrinsics.checkNotNullParameter(r9, "pluginHost");
            IOfficeSdkService r1 = (IOfficeSdkService) ServiceManager.get().getService(IOfficeSdkService.class);
            if (r1 == null) goto L5;
            n r2 = r1.g("slides");
        L6:
            OfficeSharePermissionPlugin r4 = new OfficeSharePermissionPlugin();
            z2 r5 = z2.a;
            boolean r6 = r5.f4();
            PluginMountStrategy r7 = PluginMountStrategy.Immediate;
            n r8 = new n(new n.a[]{n.i(r4, r6, r7)});
            if (r5.f4() == false) goto L14;
            Intrinsics.checkNotNullParameter(r9, "pluginHost");
            n r10 = ((h) this).a.getBizPluginList(r9);
            if (r2 == null) goto L13;
            r8 = n.c(r2, r8);
        L13:
            return n.c(r10, r8);
        L14:
            Intrinsics.checkNotNullParameter(r9, "pluginHost");
            n r11 = ((h) this).a.getBizPluginList(r9);
            SlidesSelectionChangePluginV2 r3 = new SlidesSelectionChangePluginV2();
            PluginMountStrategy r12 = PluginMountStrategy.LoadFinish;
            ToastPluginV2 r13 = new ToastPluginV2();
            PluginMountStrategy r14 = PluginMountStrategy.FirstJSCall;
            return n.c(r11, n.c(r8, new n(new n.a[]{n.i(new ReportEventPluginV2(), true, r7), n.i(new LarkAuthorizationPluginV2(), true, r7), n.i(new HostEditPanelPlugin(new com.larus.slides.sdk.impl.b()), true, r7), n.i(new SlidesLoadEventPluginV2(), true, r7), n.i(new FlowDocTitleMenuPluginV2(false), true, r7), n.i(r3, true, r12), n.i(r13, true, r14), n.i(new AlertPluginV2(), true, r14), n.i(new OpenImagePluginV2(), true, r12), n.i(new ToggleTitleBarPluginV2(), true, r7), n.i(new GetOrientationPluginV2(), true, r7), n.i(new GetTrackInfoPluginV2(), true, r7), n.i(new PermissionChangeHandlePluginV2(), true, r7), n.i(new AIGenerateImagePluginV2(), true, r12), n.i(new SlidesSelectMediaPluginV2(), true, r12), n.i(new SetOrientationPluginV2(), true, r7), n.i(new SetFullscreenPluginV2(), true, r7), n.i(new SlidesStateChangedPluginV2(), true, r7), n.i(new RenderFinishPluginV2(), true, r14)})));
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
        return "slides";
    }

    public final int lifecycleOrder() {
        return 2;
    }

    public final Pair<Boolean, String> W() {
        AppHost.Companion r0 = AppHost.a;
        boolean r2 = true;
        if (r0.isDebug() == false) goto L5;
    L6:
        String r1 = ((Keva) this.c.getValue()).getString("doc_host", "");
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
        FLogger.a.i("SlidesSdkServiceImplV2", "Init Office sdk if needed");
        IOfficeSdkServiceV2 r0 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r0 == null) goto L6;
        IOfficeSdkServiceV2.a.b(r0, true, null, 6);
        return;
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkServiceV2
    public final void cancelDocExport() {
        FLogger.a.i("SlidesSdkServiceImplV2", "cancelDocExport");
        j15.a r0 = this.b;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.b = null;
    }

    public SlidesSdkServiceImplV2() {
        this.c = LazyKt.lazy(new com.larus.slides.sdk.impl.a());
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkServiceV2
    public final Object a(Continuation<? super Unit> r5) {
        if ((r5 instanceof SlidesSdkServiceImplV2$initSdkIfNeeded$1) == false) goto L7;
        SlidesSdkServiceImplV2$initSdkIfNeeded$1 r0 = (SlidesSdkServiceImplV2$initSdkIfNeeded$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        SlidesSdkServiceImplV2 r4 = (SlidesSdkServiceImplV2) r0.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L30
    L24:
        ik5.a r7 = (ik5.a) r6;     // Catch: Exception -> L30
    L26:
        r4.a = r7;     // Catch: Exception -> L30
        ik5.a r8 = this.a;     // Catch: Exception -> L30
        if (r8 == null) goto L33;
        r8.Ka(e.m, new b(r8));     // Catch: Exception -> L30
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
        FLogger.a.e("SlidesSdkServiceImplV2", "Load docSdk failed: " + e.getMessage());
    L7:
        r0 = new SlidesSdkServiceImplV2$initSdkIfNeeded$1(this, r5);
        goto L8
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkServiceV2
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
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("tryPrefetchData skipped, docSdk not ready, token=");
        int r4 = f.a;
        r3.append(f.b(r7.getSlidesToken()));
        r2.i("SlidesSdkServiceImplV2", r3.toString());
        return false;
    L14:
        String r5 = V((String) W().getSecond(), r7);
        FLogger r6 = FLogger.a;
        StringBuilder r8 = new StringBuilder("tryPrefetchData, token=");
        int r9 = f.a;
        r8.append(f.b(r7.getSlidesToken()));
        r6.i("SlidesSdkServiceImplV2", r8.toString());
        r0.r2(r5, "doubao");
        return true;
    }

    public final void initDocSdk(OfficeSDKUserApi r3) {
        Intrinsics.checkNotNullParameter(r3, "officeSDKUserApi");
        IOfficeSdkServiceV2 r4 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r4 == null) goto L5;
        ik5.a r5 = r4.c0();
    L6:
        this.a = r5;
        FLogger.a.i("SlidesSdkServiceImplV2", "initDocSdk: docSdk:" + this.a);
        ik5.a r6 = this.a;
        if (r6 == null) goto L10;
        r6.Ka(e.m, new b(r6));
        return;
    L10:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkServiceV2
    public final void j(OfficeInputParam r7) {
        Intrinsics.checkNotNullParameter(r7, "inputParam");
        ik5.a r0 = this.a;
        if (r0 != null) goto L6;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("preloadDocumentData skipped, docSdk not ready, token=");
        int r3 = f.a;
        r2.append(f.b(r7.getSlidesToken()));
        r1.i("SlidesSdkServiceImplV2", r2.toString());
        return;
    L6:
        String r4 = V((String) W().getSecond(), r7);
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("preloadDocumentData, token=");
        int r8 = f.a;
        r6.append(f.b(r7.getSlidesToken()));
        r5.i("SlidesSdkServiceImplV2", r6.toString());
        r0.Qd(r4);
    }

    public final void postInitDocSdk(OfficeSDKUserApi r3) {
        Intrinsics.checkNotNullParameter(r3, "officeSDKUserApi");
        FLogger.a.i("SlidesSdkServiceImplV2", "postInitDocSdk: docSdk:" + this.a);
    }

    public final void preInitDocSdk(OfficeSDKUserApi r3) {
        Intrinsics.checkNotNullParameter(r3, "officeSDKUserApi");
        FLogger.a.i("SlidesSdkServiceImplV2", "preInitDocSdk: docSdk:" + this.a);
    }

    public final String V(String r6, OfficeInputParam r7) {
        int r0 = r7.getResourceVersion();
        String r1 = r7.getSlidesToken();
        String r2 = r7.getEnterMethod();
        if (r2.length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L9;
        r2 = "unknown";
    L9:
        if (r0 > 0) goto L11;
        String r8 = r6 + "/slides/" + r1 + "?from=" + r2;
    L12:
        com.larus.office.base.preview.c r4 = com.larus.office.base.preview.c.a;
        String r9 = r7.getSourceUrlForParams();
        r4.getClass();
        String r10 = com.larus.office.base.preview.c.j(r8, r9);
        FLogger.a.d("SlidesSdkServiceImplV2", "buildTargetUrl merged, url=" + f.c(r10));
        return r10;
    L11:
        r8 = r6 + "/slides/" + r1 + "?version=" + r0 + "&from=" + r2;
        goto L12
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkServiceV2
    public final Object s(OfficeInputParam r15, fo9.b r16, com.larus.office.h r17, com.bytedance.ee.bear.container.f r18, Continuation r19) {
        if ((r19 instanceof SlidesSdkServiceImplV2$openAndGetSlidesFragment$1) == false) goto L7;
        SlidesSdkServiceImplV2$openAndGetSlidesFragment$1 r2 = (SlidesSdkServiceImplV2$openAndGetSlidesFragment$1) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        SlidesSdkServiceImplV2 r6 = (SlidesSdkServiceImplV2) r2.L$4;
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
        ex9.e.b = r10;
        c r12 = new c(new an9.a(r9), r8, r10);
        String r11 = V((String) W().getSecond(), r10);
        if (r10.getDocPreloaded() == false) goto L54;
        FLogger r14 = FLogger.a;
        StringBuilder r20 = new StringBuilder("skip preload in openAndGetSlidesFragment, already preloaded upstream, token=");
        int r21 = f.a;
        r20.append(f.b(r10.getSlidesToken()));
        r14.i("SlidesSdkServiceImplV2", r20.toString());
    L57:
        ik5.a r22 = this.a;
        if (r22 == null) goto L62;
        Fragment r23 = r22.C6(r11, Boxing.boxLong(r10.getClickTimestamp()), null, r12, r13);
        if (r23 == null) goto L62;
        return r23;
    L62:
        return new Fragment();
    L54:
        FLogger r24 = FLogger.a;
        StringBuilder r25 = new StringBuilder("preload in openAndGetSlidesFragment, token=");
        int r26 = f.a;
        r25.append(f.b(r10.getSlidesToken()));
        r24.i("SlidesSdkServiceImplV2", r25.toString());
        ik5.a r27 = this.a;
        if (r27 == null) goto L57;
        r27.Qd(r11);
    L14:
        e = e;
    L48:
        FLogger.a.e("SlidesSdkServiceImplV2", "Load docSdk failed: " + e.getMessage());
        goto L49
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        FLogger.a.i("SlidesSdkServiceImplV2", "Get slides fragment, docSdk:" + this.a);
        ((Keva) this.c.getValue()).storeBoolean("has_opened_fusion_doc", true);
        if (this.a == null) goto L69;
        r9 = r16;
        r10 = r15;
        r8 = r17;
        r13 = r18;
        goto L51
    L69:
        X();     // Catch: Exception -> L45
        IOfficeSdkServiceV2 r28 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Exception -> L45
        OfficeInputParam r29 = r15;
        if (r28 != null) goto L71;
        r9 = r16;
        r1 = null;
        r6 = this;
        r10 = r29;
        r8 = r17;
        r7 = r18;
        goto L43
    L71:
        r2.L$0 = r29;     // Catch: Exception -> L40
        r9 = r16;
        r2.L$1 = r9;     // Catch: Exception -> L38
        com.larus.office.h r30 = r17;
        r2.L$2 = r30;     // Catch: Exception -> L36
        com.bytedance.ee.bear.container.f r31 = r18;
        r2.L$3 = r31;     // Catch: Exception -> L34
        r2.L$4 = this;     // Catch: Exception -> L34
        r2.label = 1;     // Catch: Exception -> L34
        r0 = r28.o0(15000, r2);     // Catch: Exception -> L34
        if (r0 != r4) goto L32;
        return r4;
    L32:
        r6 = this;
        r10 = r29;
        r8 = r30;
        r7 = r31;
    L34:
        e = e;
    L47:
        r10 = r29;
        r8 = r30;
        r7 = r31;
    L36:
        e = e;
    L37:
        r31 = r18;
    L38:
        e = e;
    L39:
        r30 = r17;
    L40:
        e = e;
    L41:
        r9 = r16;
    L45:
        e = e;
        r29 = r15;
    L7:
        r2 = new SlidesSdkServiceImplV2$openAndGetSlidesFragment$1(this, r19);
        goto L8
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkServiceV2
    public final void y(Context r10, String r11, String r12, String r13, String r14, com.larus.slides.operation.download.a r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        Intrinsics.checkNotNullParameter(r12, "fileType");
        Intrinsics.checkNotNullParameter(r15, "callback");
        ik5.a r0 = this.a;
        if (r0 == null) goto L5;
        j15.a r2 = r0.R4(r10, r11);
    L6:
        if (r2 != null) goto L9;
        r15.invoke(Boolean.FALSE, null, null, "export executor is null");
        return;
    L9:
        String r16 = r12.toLowerCase(Locale.ROOT);
        switch(r16.hashCode()) {
            case 110834: goto L25;
            case 115312: goto L21;
            case 3088960: goto L17;
            case 3447940: goto L13;
            default: goto L29;
        };
    L29:
        rw4.n r3 = null;
    L30:
        if (r3 != null) goto L33;
        r15.invoke(Boolean.FALSE, null, null, "unsupported fileType: ".concat(r12));
        return;
    L33:
        if (r14 != null) goto L35;
    L37:
        String r5 = null;
    L38:
        if (r5 != null) goto L41;
        r15.invoke(Boolean.FALSE, null, null, "token is empty");
        return;
    L41:
        this.b = r2;
        r2.a(r3, r13, r5, "41", null, new d(r15));
        return;
    L35:
        if ((!StringsKt.isBlank(r14)) == false) goto L37;
        r5 = r14;
        goto L38
    L13:
        if (r16.equals("pptx") == false) goto L43;
        rw4.n r17 = rw4.n.h;
    L28:
        r3 = r17;
        goto L30
    L43:
        r3 = null;
        goto L30
    L17:
        if (r16.equals("docx") == false) goto L44;
        r17 = rw4.n.c;
        goto L28
    L44:
        r3 = null;
        goto L30
    L21:
        if (r16.equals("txt") == false) goto L45;
        r17 = rw4.n.i;
        goto L28
    L45:
        r3 = null;
        goto L30
    L25:
        if (r16.equals("pdf") == false) goto L46;
        r17 = rw4.n.d;
        goto L28
    L46:
        r3 = null;
        goto L30
    L5:
        r2 = null;
        goto L6
    }
}
