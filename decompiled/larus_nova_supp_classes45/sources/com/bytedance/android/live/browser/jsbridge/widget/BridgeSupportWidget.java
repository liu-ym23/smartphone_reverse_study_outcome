package com.bytedance.android.live.browser.jsbridge.widget;

import com.bytedance.android.annie.api.data.subscribe.BaseDataObsProvider;
import com.bytedance.android.annie.service.data.b;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.browser.jsbridge.newmethods.ha;
import com.bytedance.android.live.browser.jsbridge.newmethods.q6;
import com.bytedance.android.live.browser.jsbridge.newmethods.s4;
import com.bytedance.android.live.browser.jsbridge.newmethods.u4;
import com.bytedance.android.live.browser.jsbridge.state.StateObservingService;
import com.bytedance.android.live.browser.jsbridge.state.annieObservable.h;
import com.bytedance.android.live.browser.jsbridge.state.c;
import com.bytedance.android.live.browser.jsbridge.state.observable.CurrentRoomState;
import com.bytedance.android.live.browser.jsbridge.state.observable.e;
import com.bytedance.android.live.browser.v;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.revenue.ILiveRevenueService;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.google.gson.Gson;
import j30.d;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/widget/BridgeSupportWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BridgeSupportWidget extends LiveRecyclableWidget {
    public v a;
    public StateObservingService b;
    public Gson c;

    public static final class a extends BaseJsBridgeMethodFactory {
        public final /* synthetic */ BridgeSupportWidget a;

        public a(BridgeSupportWidget r1) {
            this.a = r1;
        }

        public final Map<String, g<?, ?>> provideStatelessMethods(IJsBridgeManager r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            return MapsKt.mapOf(TuplesKt.to("gotoLive", new i30.a(ContextUtil.contextToActivity(((Widget) this.a).context), ((Widget) this.a).dataCenter)));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.widget.BridgeSupportWidget$onLoad$2, reason: invalid class name */
    public static final class AnonymousClass2 extends BaseJsBridgeMethodFactory {
        public final /* synthetic */ BridgeSupportWidget a;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.widget.BridgeSupportWidget$onLoad$2$a */
        public static final class a implements f.b {
            public final /* synthetic */ AnonymousClass2 a;

            public a(AnonymousClass2 r1) {
                this.a = r1;
            }

            public final f<Object, Object> a() {
                return new ha(((Widget) this.a.a).dataCenter, null);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.widget.BridgeSupportWidget$onLoad$2$b */
        public static final class b implements f.b {
            public final /* synthetic */ AnonymousClass2 a;

            public b(AnonymousClass2 r1) {
                this.a = r1;
            }

            public final f<Object, Object> a() {
                return new s4(((Widget) this.a.a).dataCenter);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.widget.BridgeSupportWidget$onLoad$2$c */
        public static final class c implements f.b {
            public c() {
            }

            public final f<?, ?> a() {
                return new u4();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.widget.BridgeSupportWidget$onLoad$2$d */
        public static final class d implements f.b {
            public d() {
            }

            public final f<?, ?> a() {
                return new q6();
            }
        }

        public AnonymousClass2(BridgeSupportWidget r1) {
            this.a = r1;
        }

        public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("registerMessage", new a(this)), TuplesKt.to("registerMessageLatch", new BridgeSupportWidget$onLoad$2$provideStatefulMethods$2(this)), TuplesKt.to("getLatestWRDSData", new b(this)), TuplesKt.to("registerWrds", new BridgeSupportWidget$onLoad$2$provideStatefulMethods$4(this)), TuplesKt.to("getLiveNtpTime", new c()), TuplesKt.to("live.notifyLongPress", new d())});
        }

        public final Map<String, g<?, ?>> provideStatelessMethods(IJsBridgeManager r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            return MapsKt.mapOf(TuplesKt.to("gotoLive", new i30.a(ContextUtil.contextToActivity(((Widget) this.a).context), ((Widget) this.a).dataCenter)));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.widget.BridgeSupportWidget$onLoad$3, reason: invalid class name */
    public static final class AnonymousClass3 extends BaseJsBridgeMethodFactory {
        public final /* synthetic */ BridgeSupportWidget a;

        public AnonymousClass3(BridgeSupportWidget r1) {
            this.a = r1;
        }

        public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return MapsKt.mapOf(TuplesKt.to("getBackAnchor", new BridgeSupportWidget$onLoad$3$provideStatefulMethods$1(this)));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.widget.BridgeSupportWidget$onLoad$4, reason: invalid class name */
    public static final class AnonymousClass4 extends BaseJsBridgeMethodFactory {
        public final /* synthetic */ BridgeSupportWidget a;

        public AnonymousClass4(BridgeSupportWidget r1) {
            this.a = r1;
        }

        public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return MapsKt.mapOf(TuplesKt.to("getDiscussions", new BridgeSupportWidget$onLoad$4$provideStatefulMethods$1(this)));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.widget.BridgeSupportWidget$onLoad$5, reason: invalid class name */
    public static final class AnonymousClass5 extends BaseJsBridgeMethodFactory {
        public final /* synthetic */ BridgeSupportWidget a;

        public AnonymousClass5(BridgeSupportWidget r1) {
            this.a = r1;
        }

        public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return MapsKt.mapOf(TuplesKt.to("openCustomEmojiPreview", new BridgeSupportWidget$onLoad$5$provideStatefulMethods$1(this)));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.widget.BridgeSupportWidget$onLoad$6, reason: invalid class name */
    public static final class AnonymousClass6 extends BaseJsBridgeMethodFactory {
        public final /* synthetic */ BridgeSupportWidget a;

        public AnonymousClass6(BridgeSupportWidget r1) {
            this.a = r1;
        }

        public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return MapsKt.mapOf(TuplesKt.to("recordVideoCommentReport", new BridgeSupportWidget$onLoad$6$provideStatefulMethods$1(this)));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.widget.BridgeSupportWidget$onLoad$7, reason: invalid class name */
    public static final class AnonymousClass7 extends BaseJsBridgeMethodFactory {
        public final /* synthetic */ BridgeSupportWidget a;

        public AnonymousClass7(BridgeSupportWidget r1) {
            this.a = r1;
        }

        public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return MapsKt.mapOf(TuplesKt.to("live.switchVSMultiTab", new BridgeSupportWidget$onLoad$7$provideStatefulMethods$1(this)));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.widget.BridgeSupportWidget$onLoad$8, reason: invalid class name */
    public static final class AnonymousClass8 extends BaseJsBridgeMethodFactory {
        public final /* synthetic */ DataCenter a;

        public AnonymousClass8(DataCenter r1) {
            this.a = r1;
        }

        public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return MapsKt.mapOf(TuplesKt.to("getInteractGameLiveScene", new BridgeSupportWidget$onLoad$8$provideStatefulMethods$1(this)));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.widget.BridgeSupportWidget$onLoad$9, reason: invalid class name */
    public static final class AnonymousClass9 extends BaseJsBridgeMethodFactory {
        public final /* synthetic */ DataCenter a;

        public AnonymousClass9(DataCenter r1) {
            this.a = r1;
        }

        public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return MapsKt.mapOf(TuplesKt.to("live.updateDiggAnimStyle", new BridgeSupportWidget$onLoad$9$provideStatefulMethods$1(this)));
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final String getSpm() {
        return "a100.a100.a136";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        StateObservingService r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stateObservingService");
    L5:
        Map<String, com.bytedance.android.live.browser.jsbridge.state.a<?>> r1 = r0.a;
        i.e.d r2 = i.e.d.b;
        Object r3 = ((ConcurrentHashMap) r1).get("current_user");
        if ((r3 instanceof e) == true) goto L8;
        r3 = null;
    L8:
        e r4 = (e) r3;
        if (r4 == null) goto L11;
        r4.f = null;
    L11:
        b r5 = b.a;
        com.bytedance.android.annie.api.data.subscribe.g r6 = b.a("current_user");
        if ((r6 instanceof com.bytedance.android.live.browser.jsbridge.state.annieObservable.g) == true) goto L14;
        r6 = null;
    L14:
        com.bytedance.android.live.browser.jsbridge.state.annieObservable.g r7 = (com.bytedance.android.live.browser.jsbridge.state.annieObservable.g) r6;
        if (r7 == null) goto L17;
        r7.c = null;
    L17:
        StateObservingService r8 = this.b;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("stateObservingService");
    L20:
        Iterator r9 = CollectionsKt.filterIsInstance(((ConcurrentHashMap) r8.a).values(), c.class).iterator();
    L22:
        if (r9.hasNext() == false) goto L27;
        c r11 = (c) r9.next();
        StateObservingService r12 = this.b;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("stateObservingService");
    L26:
        r12.e(r11);
        goto L22
    L27:
        b r13 = b.a;
        Intrinsics.checkNotNullParameter(com.bytedance.android.annie.api.data.subscribe.b.class, "klass");
        Iterator r14 = CollectionsKt.filterIsInstance(((ConcurrentHashMap) b.b).values(), com.bytedance.android.annie.api.data.subscribe.b.class).iterator();
    L29:
        if (r14.hasNext() == false) goto L31;
        b.a.d((com.bytedance.android.annie.api.data.subscribe.b) r14.next());
        goto L29
    L31:
        k.n(ILiveRevenueService.class).getHybridService().P2(((Widget) this).dataCenter);
    }

    public BridgeSupportWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r3) {
        BrowserServiceImpl.Companion.getClass();
        s20.a r4 = ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).a();
        v r0 = (v) r4.a.e.get();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.a = r0;
        StateObservingService r1 = (StateObservingService) r4.a.j.get();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.b = r1;
        Gson r5 = (Gson) r4.a.i.get();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.c = r5;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r8) {
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r9 != null) goto L5;
        return;
    L5:
        v r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L8:
        ((ObservableSubscribeProxy) r0.registerExternalMethodFactory(new a(this)).as(autoDispose())).subscribe();
        v r1 = this.a;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L11:
        ((ObservableSubscribeProxy) r1.registerExternalMethodFactory(new AnonymousClass2(this)).as(autoDispose())).subscribe();
        v r2 = this.a;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L14:
        ((ObservableSubscribeProxy) r2.registerExternalMethodFactory(new AnonymousClass3(this)).as(autoDispose())).subscribe();
        v r3 = this.a;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L17:
        ((ObservableSubscribeProxy) r3.registerExternalMethodFactory(new AnonymousClass4(this)).as(autoDispose())).subscribe();
        v r4 = this.a;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L20:
        ((ObservableSubscribeProxy) r4.registerExternalMethodFactory(new AnonymousClass5(this)).as(autoDispose())).subscribe();
        v r5 = this.a;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L23:
        ((ObservableSubscribeProxy) r5.registerExternalMethodFactory(new AnonymousClass6(this)).as(autoDispose())).subscribe();
        v r6 = this.a;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L26:
        ((ObservableSubscribeProxy) r6.registerExternalMethodFactory(new AnonymousClass7(this)).as(autoDispose())).subscribe();
        v r7 = this.a;
        if (r7 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L29:
        ((ObservableSubscribeProxy) r7.registerExternalMethodFactory(new AnonymousClass8(r9)).as(autoDispose())).subscribe();
        v r11 = this.a;
        if (r11 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L32:
        ((ObservableSubscribeProxy) r11.registerExternalMethodFactory(new AnonymousClass9(r9)).as(autoDispose())).subscribe();
        StateObservingService r12 = this.b;
        if (r12 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("stateObservingService");
    L35:
        xq(r12, new CurrentRoomState(r9));
        xq(r12, new j30.b(r9));
        xq(r12, new d(r9));
        Gson r13 = this.c;
        if (r13 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("jsGson");
    L38:
        xq(r12, new com.bytedance.android.live.browser.jsbridge.state.observable.f(r13, r9));
        Map<String, com.bytedance.android.live.browser.jsbridge.state.a<?>> r14 = r12.a;
        i.e.d r15 = i.e.d.b;
        Object r16 = ((ConcurrentHashMap) r14).get("current_user");
        com.bytedance.android.live.browser.jsbridge.state.annieObservable.g r17 = null;
        if ((r16 instanceof e) == true) goto L41;
        r16 = null;
    L41:
        e r18 = (e) r16;
        if (r18 == null) goto L44;
        r18.f = r9;
    L44:
        Iterator r19 = r12.b.iterator();
    L46:
        if (r19.hasNext() == false) goto L48;
        xq(r12, new com.bytedance.android.live.browser.jsbridge.state.d((i.a) ((Function1) r19.next()).invoke(r9)));
        goto L46
    L48:
        b r21 = b.a;
        wq(new com.bytedance.android.live.browser.jsbridge.state.annieObservable.CurrentRoomState(r9));
        wq(new com.bytedance.android.live.browser.jsbridge.state.annieObservable.e());
        Gson r22 = this.c;
        if (r22 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("jsGson");
    L51:
        wq(new h(r22, r9));
        Gson r23 = this.c;
        if (r23 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("jsGson");
    L54:
        b.b(new com.bytedance.android.live.browser.jsbridge.state.annieStatic.d(r23, r9));
        b.b(new com.bytedance.android.live.browser.jsbridge.state.annieStatic.g(r9));
        b.b(new com.bytedance.android.live.browser.jsbridge.state.annieStatic.f());
        wq(new com.bytedance.android.live.browser.jsbridge.state.annieObservable.a(r9));
        i.e.d r24 = i.e.d.b;
        com.bytedance.android.live.browser.jsbridge.state.annieObservable.g r25 = b.a("current_user");
        if ((r25 instanceof com.bytedance.android.live.browser.jsbridge.state.annieObservable.g) == false) goto L58;
        r17 = r25;
    L58:
        com.bytedance.android.live.browser.jsbridge.state.annieObservable.g r26 = r17;
        if (r26 == null) goto L61;
        r26.c = r9;
    L61:
        gy0.a r27 = k.n(ILiveRevenueService.class).getHybridService();
        Gson r28 = this.c;
        if (r28 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("jsGson");
    L64:
        r27.m5(r28, ((Widget) this).dataCenter, AnonymousClass11.INSTANCE);
    }

    public final void wq(BaseDataObsProvider r2) {
        ((ObservableSubscribeProxy) b.a.c(r2).as(autoDispose())).subscribe();
    }

    public final void xq(StateObservingService r1, com.bytedance.android.live.browser.jsbridge.state.a<?> r2) {
        ((ObservableSubscribeProxy) r1.c(r2).as(autoDispose())).subscribe();
    }
}
