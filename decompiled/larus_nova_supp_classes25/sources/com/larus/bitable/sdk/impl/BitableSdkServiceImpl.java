package com.larus.bitable.sdk.impl;

import android.net.Uri;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.document.SubStrategyType;
import com.bytedance.ee.bear.document.w4;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bitable.sdk.api.IBitableSdkService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.office.IOfficeSdkService;
import com.larus.office.OfficeBitableScene;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.office.h;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ew4.a0;
import ew4.c0;
import ew4.x;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import pa8.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 42\u00020\u0001:\u000545678B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J<\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096@¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\bH\u0016J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020$H\u0016J\u000e\u0010)\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010*J\f\u0010-\u001a\u00020\f*\u00020\u0005H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u00103\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/bitable/sdk/impl/BitableSdkServiceImpl;", "Lcom/larus/bitable/sdk/api/IBitableSdkService;", "<init>", "()V", "docSdk", "Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "bitableStrategiesRegisteredSdk", "lifecycleOrder", "", "lifecycleCategory", "", "preInitDocSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "initDocSdk", "postInitDocSdk", "destroyDocSdk", "createBaseMainAIChatVisibilityAbilities", "", "Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "hostAbilityProvider", "Lcom/larus/office/OfficeHostAbilityProvider;", "openAndGetBitableFragment", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "inputParam", "Lcom/larus/office/OfficeInputParam;", "listener", "Lcom/larus/office/permission/IOfficePermissionListener;", "reloadInterceptor", "Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "(Landroid/content/Context;Lcom/larus/office/OfficeInputParam;Lcom/larus/office/permission/IOfficePermissionListener;Lcom/larus/office/OfficeHostAbilityProvider;Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadDocumentData", "tryPrefetchData", "", "notifyBottomPanelHeightChanged", "height", "notifyAIChatListFoldStatusChanged", "isFold", "initSdkIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectUserHostAbility", "ensureDocsSdk", "registerBitableOpenStrategiesIfNeeded", "createBitableOfficePlugins", "Lcom/bytedance/ee/bear/browser/plugin/PluginList;", "scene", "Lcom/larus/office/OfficeBitableScene;", "buildTargetUrl", "buildFallbackTargetUrl", "Companion", "BaseAddOpenStrategy", "BaseRecordOpenStrategy", "BaseAppOpenStrategy", "BaseMainOpenStrategy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BitableSdkServiceImpl implements IBitableSdkService {
    public static final /* synthetic */ int c = 0;
    public ik5.a a;
    public ik5.a b;

    public final class a extends kk5.a {
        public final /* synthetic */ BitableSdkServiceImpl c;

        public final n getBizPluginList(ChameleonPluginHost r3) {
            Intrinsics.checkNotNullParameter(r3, "pluginHost");
            Intrinsics.checkNotNullParameter(r3, "pluginHost");
            return n.c(((kk5.a) this).a.getBizPluginList(r3), BitableSdkServiceImpl.V(this.c, OfficeBitableScene.BASE_ADD));
        }

        public a(BitableSdkServiceImpl r2, ik5.a r3) {
            Intrinsics.checkNotNullParameter(r3, "docSdk");
            this.c = r2;
            super(r3);
        }
    }

    public final class b extends kk5.b {
        public final /* synthetic */ BitableSdkServiceImpl c;

        public final n getBizPluginList(ChameleonPluginHost r3) {
            Intrinsics.checkNotNullParameter(r3, "pluginHost");
            Intrinsics.checkNotNullParameter(r3, "pluginHost");
            return n.c(((kk5.b) this).a.getBizPluginList(r3), BitableSdkServiceImpl.V(this.c, OfficeBitableScene.BASE_APP));
        }

        public b(BitableSdkServiceImpl r2, ik5.a r3) {
            Intrinsics.checkNotNullParameter(r3, "docSdk");
            this.c = r2;
            super(r3);
        }
    }

    public final class c extends kk5.c {
        public final /* synthetic */ BitableSdkServiceImpl c;

        public final n getBizPluginList(ChameleonPluginHost r3) {
            Intrinsics.checkNotNullParameter(r3, "pluginHost");
            Intrinsics.checkNotNullParameter(r3, "pluginHost");
            return n.c(((kk5.c) this).a.getBizPluginList(r3), BitableSdkServiceImpl.V(this.c, OfficeBitableScene.BASE_MAIN));
        }

        public c(BitableSdkServiceImpl r2, ik5.a r3) {
            Intrinsics.checkNotNullParameter(r3, "docSdk");
            this.c = r2;
            super(r3);
        }
    }

    public final class d extends kk5.d {
        public final /* synthetic */ BitableSdkServiceImpl c;

        public final n getBizPluginList(ChameleonPluginHost r3) {
            Intrinsics.checkNotNullParameter(r3, "pluginHost");
            Intrinsics.checkNotNullParameter(r3, "pluginHost");
            return n.c(((kk5.d) this).a.getBizPluginList(r3), BitableSdkServiceImpl.V(this.c, OfficeBitableScene.BASE_RECORD));
        }

        public d(BitableSdkServiceImpl r2, ik5.a r3) {
            Intrinsics.checkNotNullParameter(r3, "docSdk");
            this.c = r2;
            super(r3);
        }
    }

    public static final class e {
    }

    public static final class f implements x {
        public f() {
        }

        public final int s() {
            int r0 = qa8.a.a;
            return qa8.a.a;
        }

        public final void g1(ew4.a r3) {
            Intrinsics.checkNotNullParameter(r3, "listener");
            int r1 = qa8.a.a;
            Intrinsics.checkNotNullParameter(r3, "listener");
            qa8.a.c.remove(r3);
        }

        public final void j(ew4.a r3) {
            Intrinsics.checkNotNullParameter(r3, "listener");
            int r1 = qa8.a.a;
            Intrinsics.checkNotNullParameter(r3, "listener");
            qa8.a.c.addIfAbsent(r3);
            r3.a(qa8.a.a);
            r3.b(qa8.a.b);
        }
    }

    static {
    }

    public BitableSdkServiceImpl() {
    }

    public final String lifecycleCategory() {
        return "bitable";
    }

    public final int lifecycleOrder() {
        return 2;
    }

    public final void destroyDocSdk() {
        FLogger.a.i("BitableSdkServiceImpl", "destroyDocSdk");
        this.a = null;
        this.b = null;
        int r0 = qa8.a.a;
        qa8.a.a = 0;
        qa8.a.b = true;
        qa8.a.c.clear();
    }

    public static String W(OfficeInputParam r4) {
        String r0 = r4.getSourceUrlForParams();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L20:
        String r2 = r4.getSlidesToken();
        if (StringsKt.isBlank(r2) == false) goto L23;
        r2 = r4.getResourceId();
    L23:
        Uri.Builder r3 = UriProtector.parse("https://feishu.doubao.com").buildUpon().appendPath("base").appendPath(r2);
        if ((!StringsKt.isBlank(r4.getEnterMethod())) == false) goto L27;
        r3.appendQueryParameter("from", r4.getEnterMethod());
    L30:
        return r3.build().toString();
    L27:
        if ((true ^ StringsKt.isBlank(r4.getEnterFrom())) == false) goto L30;
        r3.appendQueryParameter("from", r4.getEnterFrom());
        goto L30
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L20;
        Lazy r5 = com.larus.office.base.utils.n.a;
        Intrinsics.checkNotNullParameter(r0, "sourceUrl");
        Intrinsics.checkNotNullParameter("feishu.doubao.com", "targetHost");
        Uri r6 = UriProtector.parse(r0);
        com.larus.office.base.utils.n.a r7 = com.larus.office.base.utils.n.m(r6.getPathSegments());
        Uri.Builder r8 = r6.buildUpon().authority("feishu.doubao.com");
        if (r7 != null) goto L13;
    L15:
        r1 = false;
    L16:
        if (r1 == false) goto L19;
        r8.path("/share/base/" + r7.a + '/' + r7.b);
    L19:
        return r8.build().toString();
    L13:
        if (r7.c != true) goto L15;
        goto L15
    }

    @Override // com.larus.bitable.sdk.api.IBitableSdkService
    public final List<i> D(h r2) {
        Intrinsics.checkNotNullParameter(r2, "hostAbilityProvider");
        return CollectionsKt.listOf(new oa8.a(r2));
    }

    public final Object X(Continuation<? super ik5.a> r7) {
        if ((r7 instanceof BitableSdkServiceImpl$ensureDocsSdk$1) == false) goto L7;
        BitableSdkServiceImpl$ensureDocsSdk$1 r0 = (BitableSdkServiceImpl$ensureDocsSdk$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L27
    L23:
        ik5.a r9 = (ik5.a) r8;     // Catch: Throwable -> L27
    L25:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L27
    L29:
        Throwable r4 = Result.exceptionOrNull-impl(r10);
        if (r4 == null) goto L33;
        FLogger.a.e("BitableSdkServiceImpl", "ensureDocsSdk failed", r4);
    L33:
        if (Result.isFailure-impl(r10) == false) goto L35;
        r10 = null;
    L35:
        ik5.a r11 = (ik5.a) r10;
        if (r11 == null) goto L41;
        this.a = r11;
        Y(r11);
        return r11;
    L41:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
        ik5.a r12 = this.a;
        if (r12 == null) goto L18;
        return r12;
    L18:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L27
        IOfficeSdkServiceV2 r14 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Throwable -> L27
        if (r14 == null) goto L24;
        IOfficeSdkServiceV2.a.b(r14, true, "bitable", 4);     // Catch: Throwable -> L27
        r0.label = 1;     // Catch: Throwable -> L27
        r8 = r14.o0(15000, r0);     // Catch: Throwable -> L27
        if (r8 != r2) goto L23;
        return r2;
    L24:
        r9 = null;
    L27:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new BitableSdkServiceImpl$ensureDocsSdk$1(this, r7);
        goto L8
    }

    public final void Y(ik5.a r5) {
        if (this.b != r5) goto L6;
        FLogger.a.i("BitableSdkServiceImpl", "registerBitableOpenStrategies skipped, already registered");
        return;
    L6:
        w4 r0 = r5.a5(sbb.e.i);
        if ((r0 instanceof w4) == false) goto L9;
        w4 r1 = r0;
    L10:
        if (r1 != null) goto L13;
        FLogger.a.e("BitableSdkServiceImpl", "registerBitableOpenStrategies failed, BITABLE strategy is not router strategy");
        return;
    L13:
        r1.b(SubStrategyType.BaseAdd, new a(this, r5));
        r1.b(SubStrategyType.BaseRecord, new d(this, r5));
        r1.b(SubStrategyType.BaseApp, new b(this, r5));
        r1.b(SubStrategyType.BaseMain, new c(this, r5));
        r5.Ka(sbb.e.j, new a(this, r5));
        this.b = r5;
        FLogger.a.i("BitableSdkServiceImpl", "registerBitableOpenStrategies success");
        return;
    L9:
        r1 = null;
        goto L10
    }

    @Override // com.larus.bitable.sdk.api.IBitableSdkService
    public final Object a(Continuation<? super Unit> r2) {
        Object r3 = X(r2);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bitable.sdk.api.IBitableSdkService
    public final boolean c(OfficeInputParam r7) {
        Intrinsics.checkNotNullParameter(r7, "inputParam");
        ik5.a r0 = this.a;
        if (r0 != null) goto L11;
        IOfficeSdkServiceV2 r1 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r1 == null) goto L9;
        r0 = r1.c0();
        if (r0 == null) goto L9;
        this.a = r0;
        Y(r0);
    L9:
        r0 = null;
    L11:
        if (r0 != null) goto L14;
        FLogger.a.i("BitableSdkServiceImpl", "tryPrefetchData skipped, docSdk not ready, token=" + r7.getSlidesToken());
        return false;
    L14:
        String r2 = W(r7);
        FLogger.a.i("BitableSdkServiceImpl", "tryPrefetchData, token=" + r7.getSlidesToken());
        r0.r2(r2, "doubao");
        return true;
    }

    @Override // com.larus.bitable.sdk.api.IBitableSdkService
    public final void d(boolean r3) {
        int r0 = qa8.a.a;
        if (qa8.a.b == r3) goto L9;
        qa8.a.b = r3;
        Iterator<ew4.a> r1 = qa8.a.c.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        r1.next().b(r3);
        goto L7
    L11:
        return;
    }

    @Override // com.larus.bitable.sdk.api.IBitableSdkService
    public final void i(int r3) {
        int r0 = qa8.a.a;
        int r4 = RangesKt.coerceAtLeast(r3, 0);
        if (qa8.a.a == r4) goto L9;
        qa8.a.a = r4;
        Iterator<ew4.a> r1 = qa8.a.c.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        r1.next().a(r4);
        goto L7
    L11:
        return;
    }

    public final void initDocSdk(OfficeSDKUserApi r3) {
        Intrinsics.checkNotNullParameter(r3, "officeSDKUserApi");
        IOfficeSdkServiceV2 r4 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r4 == null) goto L5;
        ik5.a r5 = r4.c0();
    L6:
        this.a = r5;
        FLogger.a.i("BitableSdkServiceImpl", "initDocSdk: docSdk=" + this.a);
        ik5.a r6 = this.a;
        if (r6 == null) goto L10;
        Y(r6);
        return;
    L10:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void postInitDocSdk(OfficeSDKUserApi r4) {
        Intrinsics.checkNotNullParameter(r4, "officeSDKUserApi");
        FLogger.a.i("BitableSdkServiceImpl", "postInitDocSdk");
        r4.setHostService(x.class, new f());
    }

    public final void preInitDocSdk(OfficeSDKUserApi r4) {
        Intrinsics.checkNotNullParameter(r4, "officeSDKUserApi");
        FLogger.a.i("BitableSdkServiceImpl", "preInitDocSdk");
        r4.setHostService(c0.class, new pa8.n());
        r4.setHostService(a0.class, new g());
    }

    public static final n V(BitableSdkServiceImpl r1, OfficeBitableScene r2) {
        r1.getClass();
        IOfficeSdkService r3 = (IOfficeSdkService) ServiceManager.get().getService(IOfficeSdkService.class);
        if (r3 == null) goto L7;
        n r4 = r3.d("base", r2);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new n(new n.a[0]);
    }

    @Override // com.larus.bitable.sdk.api.IBitableSdkService
    public final Object v(OfficeInputParam r16, fo9.a r17, h r18, com.larus.office.container.impl.applet.i r19, Continuation r20) {
        if ((r20 instanceof BitableSdkServiceImpl$openAndGetBitableFragment$1) == false) goto L7;
        BitableSdkServiceImpl$openAndGetBitableFragment$1 r2 = (BitableSdkServiceImpl$openAndGetBitableFragment$1) r20;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        com.larus.office.container.impl.applet.i r6 = (com.bytedance.ee.bear.container.f) r2.L$3;
        h r7 = (h) r2.L$2;
        fo9.a r8 = (fo9.b) r2.L$1;
        OfficeInputParam r9 = (OfficeInputParam) r2.L$0;
        ResultKt.throwOnFailure(r1);
        com.larus.office.container.impl.applet.i r13 = r6;
        h r10 = r7;
        fo9.a r11 = r8;
        Object r12 = r1;
        OfficeInputParam r14 = r9;
    L18:
        ik5.a r15 = (ik5.a) r12;
        if (r15 == null) goto L26;
        com.larus.bitable.sdk.impl.a r110 = new com.larus.bitable.sdk.impl.a(r11, r10, r14, this);
        String r21 = W(r14);
        if (r14.getDocPreloaded() == false) goto L23;
        FLogger.a.i("BitableSdkServiceImpl", "skip preload in openAndGetBitableFragment, already preloaded upstream");
    L25:
        return r15.C6(r21, Boxing.boxLong(r14.getClickTimestamp()), null, r110, r13);
    L23:
        r15.Qd(r21);
        goto L25
    L26:
        FLogger.a.e("BitableSdkServiceImpl", "openAndGetBitableFragment failed, docSdk is null");
        throw new IllegalStateException("Bitable docSdk is null");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        FLogger.a.i("BitableSdkServiceImpl", "openAndGetBitableFragment, token=" + r16.getSlidesToken() + ", docSdk=" + this.a);
        r14 = r16;
        r2.L$0 = r14;
        r11 = r17;
        r2.L$1 = r11;
        r10 = r18;
        r2.L$2 = r10;
        r2.L$3 = r19;
        r2.label = 1;
        r12 = X(r2);
        if (r12 != r4) goto L17;
        return r4;
    L17:
        r13 = r19;
    L7:
        r2 = new BitableSdkServiceImpl$openAndGetBitableFragment$1(this, r20);
        goto L8
    }
}
