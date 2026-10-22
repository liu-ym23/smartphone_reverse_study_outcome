package com.bytedance.android.livesdk.dslservice.lynxair;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.annie.xbridge.mix.StateMethodFinder;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.live.core.setting.n0;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.dslservice.gecko.GeckoUtils;
import com.bytedance.android.livesdk.dslservice.lynxair.view.LynxAirBehaviorFactory$create$1;
import com.bytedance.android.livesdk.dslservice.lynxair.view.LynxAirBehaviorFactory$create$3;
import com.bytedance.android.livesdk.dslservice.util.m;
import com.bytedance.android.livesdk.dslservice.util.p;
import com.bytedance.android.livesdk.dslservice.util.r;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.bullet.core.t;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.BDXBridge;
import com.bytedance.sdk.xbridge.cn.registry.core.RefType;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.q1;
import com.lynx.tasm.ui.image.FlattenUIImage;
import com.lynx.tasm.ui.image.UIImage;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.SingleSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yt1.k;
import yt1.l;
import yt1.n;
import yt1.o;
import yt1.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LynxAirDSLProcess implements n {
    public static final /* synthetic */ int i = 0;
    public final cu1.b a;
    public final HashMap<String, com.lynx.tasm.behavior.a> b;
    public final CompositeDisposable c;
    public final com.bytedance.android.livesdk.dslservice.util.b<com.bytedance.android.livesdk.dslservice.lynxair.a> d;
    public ArrayList<yt1.h> e;
    public final et2.a f;
    public l g;
    public final boolean h;

    public static final class a {
    }

    public static final class b extends com.lynx.tasm.behavior.a {
        public b() {
            super("image", true, true);
        }

        public final ShadowNode createShadowNode() {
            return new AutoSizeImage();
        }

        public final LynxFlattenUI createFlattenUI(LynxContext r2) {
            return new FlattenUIImage(r2);
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            return new UIImage(r2);
        }
    }

    static {
    }

    @Override // yt1.n
    public final void g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final List<com.lynx.tasm.behavior.a> i() {
        Map r0 = MapsKt.plus(com.bytedance.android.livesdk.dslservice.view.b.c, com.bytedance.android.livesdk.dslservice.view.b.b);
        Iterator r1 = r0.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L20;
        String r2 = (String) r1.next();
        yt1.f r3 = (yt1.f) r0.get(r2);
        if (this.b.get(r2) != null) goto L4;
        if (r3 == null) goto L4;
        HashMap<String, com.lynx.tasm.behavior.a> r4 = this.b;
        if (r2 == null) goto L19;
        String r5 = r2.toLowerCase();
        int r6 = com.bytedance.android.livesdk.dslservice.lynxair.view.d.a;
        Intrinsics.checkNotNullParameter(r5, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r3, "dslCustomViewInterface");
        int r7 = r3.getType();
        if (r7 != 2) goto L13;
        com.lynx.tasm.behavior.a r8 = new com.bytedance.android.livesdk.dslservice.lynxair.view.c(r3, r5, r5);
    L17:
        r4.put(r2, r8);
        goto L4
    L13:
        if (r7 == 3) goto L15;
        r8 = new LynxAirBehaviorFactory$create$3(r3, r5, r5);
        goto L17
    L15:
        r8 = new LynxAirBehaviorFactory$create$1(r3, r5, r5);
        goto L17
    L19:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L20:
        this.b.put("image", new b());
        return CollectionsKt.toList(this.b.values());
    }

    @Override // yt1.n
    public final void release() {
        m.h.d(AnonymousClass1.INSTANCE);
        this.c.clear();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        this.d.c(LynxAirDSLProcess$release$2$1.INSTANCE);     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        final Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L10;
        m.h.d(new LynxAirDSLProcess$release$3$1(r2));
    L10:
        this.d.a.clear();
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public LynxAirDSLProcess() {
        this.a = cu1.b.b;
        this.b = new HashMap();
        this.c = new CompositeDisposable();
        this.d = new com.bytedance.android.livesdk.dslservice.util.b(m.h);
        this.f = (et2.a) dt2.b.a.getValue();
        Integer r0 = (Integer) ev1.f.a.getValue();
        if (r0 == null) goto L8;
        boolean r1 = true;
        if (r0.intValue() != 1) goto L8;
    L9:
        this.h = r1;
        return;
    L8:
        r1 = false;
        goto L9
    }

    public final m16.b h(final q r5) {
        final m16.b r0 = new m16.b();
        r0.e(t.class, new LynxAirDSLProcess$buildContextProvider$$inlined$apply$lambda$1(this, r5));
        if (this.h == false) goto L7;
        TemplateBundle r1 = cu1.a.b.a(r5);
        if (r1 == null) goto L7;
        m.h.a(new LynxAirDSLProcess$buildContextProvider$$inlined$apply$lambda$2(r0, this, r5));
        r0.d(TemplateBundle.class, r1);
    L7:
        return r0;
    }

    @Override // yt1.n
    public final void a(final q r7, final k r8) {
        Intrinsics.checkNotNullParameter(r7, "key");
        m r1 = m.h;
        r1.d(new LynxAirDSLProcess$recycleTemplate$1(r7));
        if ((r8 instanceof com.bytedance.android.livesdk.dslservice.lynxair.a) == false) goto L39;
        com.bytedance.android.livesdk.dslservice.lynxair.a r2 = (com.bytedance.android.livesdk.dslservice.lynxair.a) r8;
        this.d.b(r7, r2);
        boolean r4 = false;
        r2.b(au1.a.C0001a.b, false);
        int r3 = r.a;
        r.a(r8.getView());
        com.bytedance.android.livesdk.dslservice.lynxair.a r5 = (com.bytedance.android.livesdk.dslservice.lynxair.a) r8;
        if (r5.b == 1) goto L9;
        r5.b = 3;
        r5.g.destroy();
        r1.d(new LynxAirDSLProcess$recycleTemplate$2(r8));
        return;
    L9:
        if (this.f.a() != 1) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L40;
        q1 r9 = r5.e;
        if (r9 == null) goto L16;
        r5.g.removeLynxViewClient(r9);
    L16:
        cu1.b r10 = this.a;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter(r8, "component");
        if (r7.b.length() != 0) goto L19;
        boolean r0 = true;
    L20:
        if (r0 == false) goto L27;
        if (r7.c.length() != 0) goto L24;
        r4 = true;
    L24:
        if (r4 == false) goto L27;
    L32:
        AnnieXLynxView r11 = r5.g;
        r11.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.android.livesdk.dslservice.lynxair.jsb.c.class, "clazz");
        LynxBDXBridge r12 = r11.c;
        if (r12 == null) goto L41;
        Intrinsics.checkNotNullParameter(com.bytedance.android.livesdk.dslservice.lynxair.jsb.c.class, "clazz");
        me7.c r13 = ((BDXBridge) r12).h;
        if (r13 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("containerContext");
        r13 = null;
    L37:
        r13.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.android.livesdk.dslservice.lynxair.jsb.c.class, "clazz");
        ((ConcurrentHashMap) r13.d).remove(com.bytedance.android.livesdk.dslservice.lynxair.jsb.c.class);
        return;
    L41:
        return;
    L27:
        if (r10.b().get(r7) != null) goto L29;
        r10.b().put(r7, new LinkedList());
    L29:
        LinkedList<k> r14 = r10.b().get(r7);
        if (r14 == null) goto L32;
        r14.offer(r8);
        goto L32
    L19:
        r0 = false;
        goto L20
    L40:
        return;
    L11:
        r6 = false;
        goto L12
    }

    @Override // yt1.n
    public final boolean b(String r3, q r4) {
        if (r4 == null) goto L13;
        cu1.b r0 = cu1.b.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "key");
        LinkedList<k> r5 = r0.b().get(r4);
        if (r5 != null) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 != true) goto L14;
        return true;
    L14:
        return false;
    L7:
        if ((!r5.isEmpty()) != true) goto L9;
        r6 = true;
        goto L10
    L13:
        return false;
    }

    @Override // yt1.n
    public final void e(q r5, final Map r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        final String r1 = "";
        Intrinsics.checkNotNullParameter("", "data");
        final int r3 = 1;
        this.d.d(r5, new LynxAirDSLProcess$refreshTemplate$1(r1, r6, r3));
    }

    @Override // yt1.n
    public final void f(Context r2, l r3, ArrayList<yt1.h> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.e = r4;
        this.g = r3;
    }

    public final void k(com.bytedance.android.livesdk.dslservice.lynxair.a r3, AnnieXLynxView r4, ArrayList<yt1.h> r5) {
        if (r5 != null) goto L4;
        r5 = new ArrayList();
    L4:
        List r0 = this.e;
        if (r0 != null) goto L8;
        r0 = CollectionsKt.emptyList();
    L8:
        r5.addAll(r0);
        com.bytedance.android.livesdk.dslservice.lynxair.jsb.c r1 = new com.bytedance.android.livesdk.dslservice.lynxair.jsb.c(r5);
        r3.d = r1;
        RefType r6 = RefType.NORMAL;
        r4.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.android.livesdk.dslservice.lynxair.jsb.c.class, "clazz");
        Intrinsics.checkNotNullParameter(r6, "refType");
        LynxBDXBridge r7 = r4.c;
        if (r7 == null) goto L12;
        r7.y(com.bytedance.android.livesdk.dslservice.lynxair.jsb.c.class, r1, r6);
        return;
    }

    public final LynxAirDSLProcess$getLifecycleObserve$3 j(com.bytedance.android.livesdk.dslservice.lynxair.a r10, yt1.m r11, p r12, Long r13) {
        String r0 = r10.h.a;
        SingleSubject r7 = SingleSubject.create();
        RxUtilKt.c(r7.subscribe(new d(this, r10, r12, r0, r11), new e(r10, r11)), this.c);
        return new LynxAirDSLProcess$getLifecycleObserve$3(this, r11, r10, r0, r7, r13);
    }

    @Override // yt1.n
    public final k c(o r7, String r8, Context r9, yt1.r r10, yt1.m r11) {
        Intrinsics.checkNotNullParameter(r7, "template");
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r9, "context");
        return l(this, r7, r8, r10, r9, r11);
    }

    @Override // yt1.n
    public final k d(o r8, String r9, ViewGroup r10, yt1.r r11, yt1.m r12) {
        Intrinsics.checkNotNullParameter(r8, "template");
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r10, "viewGroup");
        com.bytedance.android.livesdk.dslservice.lynxair.a r13 = l(this, r8, r9, r11, r10.getContext(), r12);
        if (((Boolean) n0.a.getValue()).booleanValue() == false) goto L15;
        yt1.e r14 = r8.a;
        if (r14 == null) goto L15;
        AnnieXLynxView r15 = r13.g;
        int r1 = (int) r14.b;
        if (r1 < 0) goto L10;
        r1 = UtilityKotlinExtentionsKt.i(r1);
    L10:
        int r16 = (int) r14.a;
        if (r16 < 0) goto L14;
        r16 = UtilityKotlinExtentionsKt.i(r16);
    L14:
        r10.addView(r15, new ViewGroup.LayoutParams(r1, r16));
    L16:
        return r13;
    L15:
        r10.addView(r13.g);
        goto L16
    }

    public static com.bytedance.android.livesdk.dslservice.lynxair.a l(final LynxAirDSLProcess r49, final o r50, String r51, final yt1.r r52, Context r53, yt1.m r54) {
        final String r8 = "";
        r49.getClass();
        if (v.a() == false) goto L37;
        com.bytedance.android.livesdk.chatroom.q r1 = iv1.a.a(null, 3);
        if (r1 == null) goto L37;
        j r2 = r1.G1();
        if (r2 == null) goto L37;
        zt1.c r3 = (zt1.c) r2.getValue();
        if (r3 == null) goto L37;
        com.bytedance.android.livesdk.dsl.util.d r4 = r3.c(r50.b);
        if (r4 == null) goto L37;
        o r5 = r4.a;
        if (r5 == null) goto L32;
        yt1.p r6 = r5.c;
        if (r6 == null) goto L32;
        String r7 = r6.b;
        if (r7 == null) goto L32;
        if (r7.length() <= 0) goto L22;
        boolean r9 = true;
    L23:
        if (r9 != true) goto L32;
        yt1.p r10 = r50.c;
        o r11 = r4.a;
        if (r11 == null) goto L29;
        yt1.p r12 = r11.c;
        if (r12 == null) goto L29;
        String r13 = r12.b;
    L30:
        r10.b = r13;
    L29:
        r13 = null;
        goto L30
    L22:
        r9 = false;
    L32:
        if (r4.b.length() <= 0) goto L34;
        boolean r14 = true;
    L35:
        if (r14 == false) goto L37;
        String r15 = r4.b;
    L38:
        if (r15 != null) goto L40;
        r15 = r51;
    L40:
        m r16 = m.h;
        r16.d(new LynxAirDSLProcess$realLoad$1(r50, r8));
        q r17 = r50.b;
        final String r18 = r17.a;
        String r19 = r50.c.b;
        if (r19 != null) goto L43;
        String r20 = "";
    L44:
        final p r21 = new p();
        long r22 = System.currentTimeMillis();
        if (r15.length() != 0) goto L47;
        boolean r110 = true;
    L48:
        if (r110 == false) goto L50;
        r15 = "";
    L50:
        final LynxAirDSLProcess$wrapCallback$1 r23 = new LynxAirDSLProcess$wrapCallback$1(r18, r54);
        if (r49.f.a() != 1) goto L53;
        boolean r111 = true;
    L55:
        if (r111 == true) goto L57;
        r22 = r22;
    L73:
        com.bytedance.android.livesdk.dslservice.lynxair.a r24 = null;
    L75:
        if (r24 == null) goto L81;
        r16.d(new LynxAirDSLProcess$realLoad$2(r50, r8));
        r24.c = r52;
        AnnieXLynxView r0 = r24.g;
        if (r52 == null) goto L79;
        ArrayList<yt1.h> r25 = r52.a;
    L80:
        r49.k(r24, r0, r25);
        r24.g.N(com.bytedance.android.anniex.api.d.j(new com.bytedance.android.anniex.api.d("webcast", MapsKt.emptyMap(), null, 12), new byte[1], UriProtector.parse(r20), TemplateData.fromString(r15)), r49.h(r24.h), r49.j(r24, r23, null, null));
        final String r26 = r24.h.a;
        r16.d(new LynxAirDSLProcess$reBindDataLynxAir$1(r26));
        r21.a(new f(r26));
        r24.b(au1.a.c.b, false);
        r49.d.a(r17, r24);
        int r27 = r.a;
        r.a(r24.g);
        return r24;
    L79:
        r25 = null;
        goto L80
    L81:
        TemplateData r28 = TemplateData.fromString(r15);
        int r29 = com.bytedance.android.livesdk.dslservice.util.e.a;
        l r30 = r49.g;
        Intrinsics.checkNotNullParameter(r28, "dataMap");
        if (r52 == null) goto L87;
        Map<String, ? extends Object> r112 = r52.c;
        if (r112 == null) goto L87;
        r28.put("__local_custom_data", r112);
    L87:
        if (r30 == null) goto L92;
        HashMap<String, Object> r31 = r30.b();
        if (r31 == null) goto L92;
        r28.put("__local_global_data", r31);
    L92:
        if (r49.h == true) goto L98;
        Map r113 = MapsKt.emptyMap();
        List<com.lynx.tasm.behavior.a> r33 = r49.i();
        if (((Boolean) dt2.c.a.getValue()).booleanValue() == false) goto L96;
        ThreadStrategyForRendering r114 = ThreadStrategyForRendering.PART_ON_LAYOUT;
    L97:
        ra.a r32 = com.bytedance.android.anniex.api.d.j(new com.bytedance.android.anniex.api.d("webcast", r113, new ra.b(false, r114, null, null, 0, 0, 0.0f, false, false, LynxAirDSLProcess$createLynxModel$1.INSTANCE, false, 0, 0, r33, false, false, true, false, null, false, 0.0f, 16244221), 8), new byte[1], UriProtector.parse(r20), r28);
    L103:
        final ra.a r34 = r32;
        int r35 = com.bytedance.android.anniex.api.b.a;
        final AnnieXLynxView r115 = com.bytedance.android.anniex.api.b.e(r53, r34);
        int r36 = com.bytedance.android.livesdk.dslservice.lynxair.a.i;
        Function2<q, k, Unit> r37 = new LynxAirDSLProcess$realLoad$component$1(r49);
        Intrinsics.checkNotNullParameter(r17, "key");
        Intrinsics.checkNotNullParameter(r115, "lynxView");
        Intrinsics.checkNotNullParameter(r37, "onRelease");
        final com.bytedance.android.livesdk.dslservice.lynxair.a r116 = new com.bytedance.android.livesdk.dslservice.lynxair.a(r115, r17);
        r116.c = r52;
        r116.a = r37;
        if (r52 == null) goto L106;
        ArrayList<yt1.h> r38 = r52.a;
    L107:
        r49.k(r116, r115, r38);
        if (r49.h == true) goto L110;
        ConcurrentHashMap<String, com.bytedance.android.livesdk.dslservice.gecko.a> r39 = GeckoUtils.a;
        GeckoUtils.a(m.d, r18, r20, new LynxAirDSLProcess$realLoad$3(r49, r116, r115, r34, r23, r52, r21, r8, r18), new LynxAirDSLProcess$realLoad$4(r116, r23));
        LynxAirDSLProcess r40 = r49;
        AnnieXLynxView r41 = r115;
    L127:
        r40.d.a(r17, r116);
        int r42 = r.a;
        r.a(r116.g);
        com.bytedance.android.livesdk.dslservice.view.c.a("Air", r116.g, r41, r50, null);
        r16.d(LynxAirDSLProcess$realLoad$6.INSTANCE);
        return r116;
    L110:
        LynxAirDSLProcess$realLoad$lynxClient$1 r43 = new LynxAirDSLProcess$realLoad$lynxClient$1(r17);
        r116.e = r43;
        r41 = r115;
        r41.addLynxViewClient(r43);
        r40 = r49;
        m16.b r44 = r40.h(r116.h);
        boolean r45 = true;
        if ((!Intrinsics.areEqual("", "PreLoad")) == false) goto L113;
        p r46 = r21;
    L114:
        LynxAirDSLProcess$getLifecycleObserve$3 r47 = r40.j(r116, r23, r46, Long.valueOf(r22));
        r41.n(new StateMethodFinder(r44), 0);
        r41.A(r34, r44, r47);
        if (((Boolean) n0.a.getValue()).booleanValue() == true) goto L127;
        String r48 = r116.f;
        if (r48 != null) goto L120;
        r48 = "UnKnown";
    L120:
        if (Intrinsics.areEqual(r48, "NodeCache") == false) goto L122;
    L125:
        if (r45 == false) goto L127;
        r21.a(new g(r18, r48));
        r116.b(au1.a.c.b, false);
        goto L127
    L122:
        if (Intrinsics.areEqual(r48, "LocalRawData") == true) goto L125;
        r45 = false;
        goto L125
    L113:
        r46 = null;
        goto L114
    L106:
        r38 = null;
        goto L107
    L96:
        r114 = ThreadStrategyForRendering.ALL_ON_UI;
        goto L97
    L98:
        Map r55 = MapsKt.emptyMap();
        List<com.lynx.tasm.behavior.a> r410 = r49.i();
        if (((Boolean) dt2.c.a.getValue()).booleanValue() == false) goto L101;
        ThreadStrategyForRendering r117 = ThreadStrategyForRendering.PART_ON_LAYOUT;
    L102:
        r32 = com.bytedance.android.anniex.api.d.i(new com.bytedance.android.anniex.api.d("webcast", r55, new ra.b(false, r117, null, null, 0, 0, 0.0f, false, false, LynxAirDSLProcess$createLynxModelWithUrl$1.INSTANCE, false, 0, 0, r410, false, false, true, false, null, false, 0.0f, 16244221), 8), UriProtector.parse(r20), false, r28, true, 32);
        goto L103
    L101:
        r117 = ThreadStrategyForRendering.ALL_ON_UI;
        goto L102
    L57:
        cu1.b r118 = r49.a;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r17, "key");
        LinkedList<k> r119 = r118.b().get(r17);
        if (r119 == null) goto L60;
        k r120 = r119.poll();
    L62:
        if ((r120 instanceof com.bytedance.android.livesdk.dslservice.lynxair.a) == true) goto L64;
        r120 = null;
    L64:
        r24 = (com.bytedance.android.livesdk.dslservice.lynxair.a) r120;
        if (r24 == null) goto L69;
        AnnieXLynxView r56 = r24.g;
        if (r56 == null) goto L69;
        Context r57 = r56.getContext();
    L71:
        if (Intrinsics.areEqual(r57, r53) == false) goto L73;
    L69:
        r57 = null;
        goto L71
    L60:
        r120 = null;
        goto L62
    L53:
        r111 = false;
        goto L55
    L47:
        r110 = false;
        goto L48
    L43:
        r20 = r19;
        goto L44
    L34:
        r14 = false;
    L37:
        r15 = null;
        goto L38
    }
}
