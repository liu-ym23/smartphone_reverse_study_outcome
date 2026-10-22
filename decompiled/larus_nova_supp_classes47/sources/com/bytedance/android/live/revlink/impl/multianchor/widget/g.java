package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.graphics.RectF;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.WindowClickImpl;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.p;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import fr2.g0;
import fr2.h1;
import fr2.i1;
import fr2.v;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends com.bytedance.android.live.revenuelink.rtc.e implements com.bytedance.android.live.revlink.link.domain.anchorimpl.f {
    public final Map<String, u11.a> a;
    public final Map<String, u11.a> b;
    public List<p> c;
    public List<WindowClickImpl> d;
    public u11.a e;
    public boolean f;
    public final Function0<v> g;
    public final com.bytedance.android.live.revenuelink.rtc.i h;
    public final FrameLayout i;
    public final String j;
    public final Function0<Integer> k;

    public static final class a {
    }

    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((p) r1).e), Integer.valueOf(((p) r2).e));
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.f
    public final void c() {
        this.f = false;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.f
    public final void h() {
        if (this.h.G() == false) goto L14;
        v r0 = (v) this.g.invoke();
        if (r0 == null) goto L13;
        fr2.p r1 = r0.getLiveCore();
        if (r1 == null) goto L13;
        i1 r2 = r1.f3();
        if (r2 == null) goto L13;
        h1 r3 = r2.K0();
        if (r3 == null) goto L13;
        u11.a r4 = new com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.b(r3, true);
    L15:
        this.e = r4;
        if (r4 == null) goto L18;
        j(this.j, r4, "attach");
    L18:
        jy0.b.c("FrameRenderImpl", "onRtcStart with singleViewMode: " + this.h.G(), null, 4);
        return;
    L13:
        r4 = null;
        goto L15
    L14:
        r4 = new com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.a();
        goto L15
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.f
    public final void d(String r5) {
        Intrinsics.checkNotNullParameter(r5, "linkmicId");
        jy0.b.c("FrameRenderImpl", "removeStreamXFrame for linkInd: " + r5 + "  renderMap: " + this.a.size(), null, 4);
        u11.a r0 = this.a.remove(r5);
        if (r0 == null) goto L5;
        r0.detach();
    L5:
        this.b.remove(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.Object, java.util.List<com.bytedance.android.live.revlink.link.domain.anchorimpl.p>] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.util.List<com.bytedance.android.live.revlink.link.domain.anchorimpl.p>] */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.util.ArrayList] */
    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.f
    public final void a(List<p> r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "renderStates");
        jy0.b.c("FrameRenderImpl", "updateRenderStatus with renderStates: " + r14 + " and frame: " + this.a, null, 4);
        Iterator r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        WindowClickImpl r1 = (WindowClickImpl) r0.next();
        r1.e.removeView(r1.a);
        goto L4
    L6:
        Iterable r2 = (Iterable) r14;
        List r3 = CollectionsKt.sortedWith(r2, new b());
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L14;
        p r6 = (p) r5.next();
        FrameLayout r7 = this.i;
        WindowClickImpl r8 = new WindowClickImpl(r7, r6, r7.getContext(), this.j);
        Function0<Unit> r9 = r8.f.f;
        if (r9 == null) goto L13;
        View r10 = new View(r8.g);
        r8.a = r10;
        RectF r12 = r8.f.c;
        r10.setOnClickListener(new com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.d(r9));
        FrameLayout r13 = r8.e;
        View r16 = r8.a;
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams((int) r12.width(), (int) r12.height());
        r17.leftMargin = (int) r12.left;
        r17.topMargin = (int) r12.top;
        Unit r18 = Unit.INSTANCE;
        r13.addView(r16, r17);
    L13:
        r4.add(r8);
        goto L8
    L14:
        this.d = r4;
        if (r15 == false) goto L71;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r19 = ILiveWrappedLivePusher.a.b();
        if (r19 == null) goto L24;
        vc0.a r20 = this.h.getLiveCore();
        if (r20 == null) goto L22;
        Object r22 = r20.a;
    L23:
        d0 r110 = r19.buildLiveCore(r22);
    L25:
        if (r110 == null) goto L71;
        View r111 = r110.Y();
        if (r111 == null) goto L71;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r23 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r23 == null) goto L32;
        Pair<Integer, Integer> r24 = r23.getPreviewSize();
    L33:
        int r25 = 0;
        if (r24 == null) goto L38;
        Integer r26 = (Integer) r24.getFirst();
        if (r26 == null) goto L38;
        int r27 = r26.intValue();
    L39:
        if (r24 == null) goto L43;
        Integer r28 = (Integer) r24.getSecond();
        if (r28 == null) goto L43;
        r25 = r28.intValue();
    L43:
        ArrayList r29 = new ArrayList();
        Iterator r30 = r2.iterator();
    L45:
        if (r30.hasNext() == false) goto L49;
        Object r32 = r30.next();
        if (((p) r32).b == false) goto L45;
        r29.add(r32);
        goto L45
    L49:
        ArrayList r33 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));
        Iterator r34 = r29.iterator();
    L51:
        if (r34.hasNext() == false) goto L53;
        r33.add(((p) r34.next()).d);
        goto L51
    L53:
        Intrinsics.checkNotNullParameter(r33, "$this$total");
        Iterator r35 = r33.iterator();
        float r36 = Float.MIN_VALUE;
        float r37 = Float.MIN_VALUE;
        float r38 = Float.MAX_VALUE;
        float r112 = Float.MAX_VALUE;
    L55:
        if (r35.hasNext() == false) goto L57;
        RectF r113 = (RectF) r35.next();
        r38 = RangesKt.coerceAtMost(r38, r113.left);
        r112 = RangesKt.coerceAtMost(r112, r113.top);
        r36 = RangesKt.coerceAtLeast(r36, r113.right);
        r37 = RangesKt.coerceAtLeast(r37, r113.bottom);
        goto L55
    L57:
        RectF r39 = new RectF(r38, r112, r36, r37);
        float r40 = r27;
        float r42 = r39.left * r40;
        float r43 = r25;
        float r44 = r39.top * r43;
        float r45 = r39.width() * r40;
        float r46 = r39.height() * r43;
        UtilityKotlinExtentionsKt.z(r111, true);
        ViewGroup.LayoutParams r47 = r111.getLayoutParams();
        if ((r47 instanceof FrameLayout.LayoutParams) == true) goto L60;
        r47 = null;
    L60:
        FrameLayout.LayoutParams r48 = (FrameLayout.LayoutParams) r47;
        if (r48 == null) goto L71;
        r48.leftMargin = (int) r42;
        r48.topMargin = (int) r44;
        r48.width = (int) r45;
        r48.height = (int) r46;
        r111.setLayoutParams(r48);
        r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r114 = r2.iterator();
    L65:
        if (r114.hasNext() == false) goto L71;
        p r49 = (p) r114.next();
        RectF r50 = r49.d;
        if (r49.b == false) goto L69;
        RectF r52 = new RectF((r50.left - r39.left) / r39.width(), (r50.top - r39.top) / r39.height(), (r50.right - r39.left) / r39.width(), (r50.bottom - r39.top) / r39.height());
    L70:
        RectF r115 = r52;
        String r53 = r49.a;
        boolean r54 = r49.b;
        RectF r55 = r49.c;
        int r116 = r49.e;
        Function0<Unit> r117 = r49.f;
        Intrinsics.checkNotNullParameter(r53, "linkerID");
        Intrinsics.checkNotNullParameter(r55, "screenRectF");
        Intrinsics.checkNotNullParameter(r115, "layerRectF");
        r14.add(new p(r53, r54, r55, r115, r116, r117));
        goto L65
    L69:
        r52 = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
    L38:
        r27 = 0;
        goto L39
    L32:
        r24 = null;
        goto L33
    L22:
        r22 = null;
        goto L23
    L24:
        r110 = null;
    L71:
        Map<String, u11.a> r118 = this.b;
        LinkedHashMap r56 = new LinkedHashMap(MapsKt.mapCapacity(r118.size()));
        Iterator r119 = ((LinkedHashMap) r118).entrySet().iterator();
    L73:
        if (r119.hasNext() == false) goto L75;
        r56.put(((Map.Entry) r119.next()).getKey(), Boolean.FALSE);
        goto L73
    L75:
        Map r120 = MapsKt.toMutableMap(r56);
        Iterator r57 = ((Iterable) r14).iterator();
    L77:
        if (r57.hasNext() == false) goto L87;
        p r58 = (p) r57.next();
        u11.a r59 = (u11.a) ((LinkedHashMap) this.b).get(r58.a);
        if (r59 != null) goto L84;
        r59 = (u11.a) ((LinkedHashMap) this.a).get(r58.a);
        if (r59 == null) goto L83;
        this.b.put(r58.a, r59);
        goto L84
    L83:
        r59 = null;
    L84:
        if (r59 == null) goto L86;
        r59.b(r58);
    L86:
        r120.put(r58.a, Boolean.TRUE);
        goto L77
    L87:
        LinkedHashMap r60 = new LinkedHashMap();
        Iterator r121 = r120.entrySet().iterator();
    L89:
        if (r121.hasNext() == false) goto L93;
        Map.Entry r62 = (Map.Entry) r121.next();
        if ((!((Boolean) r62.getValue()).booleanValue()) == false) goto L89;
        r60.put(r62.getKey(), r62.getValue());
        goto L89
    L93:
        Iterator r122 = r60.entrySet().iterator();
    L95:
        if (r122.hasNext() == false) goto L100;
        String r63 = (String) ((Map.Entry) r122.next()).getKey();
        u11.a r64 = (u11.a) ((LinkedHashMap) this.b).get(r63);
        if (r64 == null) goto L99;
        r64.detach();
    L99:
        this.b.remove(r63);
        goto L95
    L100:
        this.c = r14;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void e1(String r1, long r2) {
        Map<String, u11.a> r3 = this.a;
        if (r3 == null) goto L14;
        u11.a r4 = (u11.a) TypeIntrinsics.asMutableMap(r3).remove(r1);
        if (r4 == null) goto L7;
        r4.detach();
    L7:
        Map<String, u11.a> r5 = this.b;
        if (r5 == null) goto L12;
        TypeIntrinsics.asMutableMap(r5).remove(r1);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public final void j(String r5, u11.a r6, String r7) {
        Object r1 = null;
        jy0.b.c("FrameRenderImpl", "addRenderFrame for linkerID: " + r5 + " and frame: " + r6 + " from source: " + r7, null, 4);
        if (StringsKt.startsWith$default(r5, "output_view_stream_x", false, 2, null) == true) goto L11;
        if (StringsKt.startsWith$default(r5, "group_view_stream_x", false, 2, null) == true) goto L11;
        if (StringsKt.startsWith$default(r5, "director_view_stream_x", false, 2, null) == true) goto L11;
        this.a.put(r5, r6);
    L13:
        Iterator<T> r8 = this.c.iterator();
    L15:
        if (r8.hasNext() == false) goto L19;
        Object r0 = r8.next();
        if (Intrinsics.areEqual(((p) r0).a, r5) == false) goto L15;
        r1 = r0;
    L19:
        p r2 = (p) r1;
        if (r2 == null) goto L26;
        r6.b(r2);
        this.b.put(r5, r6);
        return;
    L26:
        return;
    L11:
        if (StringsKt.startsWith$default(r5, "output_view_stream_x", false, 2, null) == false) goto L13;
        this.a.put(r5, r6);
        r6.a();
        goto L13
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void L0(String r1, TextureView r2, int r3, int r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        j(r1, new com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.c(this.i, r2), "onFirstFrameTextureView");
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void T3(String r2, vc0.a r3, int r4, int r5) {
        if (r3 == null) goto L20;
        Object r6 = r3.b;
        fr2.l r0 = null;
        if ((r6 instanceof xh6.c) == true) goto L6;
        fr2.l r7 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(fr2.l.class), r3.a);
        if ((r7 instanceof fr2.l) == false) goto L13;
        r0 = r7;
    L13:
        fr2.l r8 = r0;
    L14:
        if (r8 == null) goto L21;
        if (r2 != null) goto L18;
        return;
    L18:
        j(r2, new com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.b(r8, false), "onFirstFrameLayer");
        return;
    L21:
        return;
    L6:
        if ((r6 instanceof fr2.l) == true) goto L8;
        r6 = null;
    L8:
        r8 = (fr2.l) r6;
        goto L14
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void V3(String r2, vc0.a r3, int r4, int r5) {
        if (r3 == null) goto L20;
        Object r6 = r3.b;
        fr2.l r0 = null;
        if ((r6 instanceof xh6.c) == true) goto L6;
        fr2.l r7 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(fr2.l.class), r3.a);
        if ((r7 instanceof fr2.l) == false) goto L13;
        r0 = r7;
    L13:
        fr2.l r8 = r0;
    L14:
        if (r8 == null) goto L21;
        if (r2 != null) goto L18;
        return;
    L18:
        j(r2, new com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.b(r8, false), "onFirstFrameLayer");
        return;
    L21:
        return;
    L6:
        if ((r6 instanceof fr2.l) == true) goto L8;
        r6 = null;
    L8:
        r8 = (fr2.l) r6;
        goto L14
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void h1(String r1, SurfaceView r2, int r3, int r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        j(r1, new com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.c(this.i, r2), "onFirstFrameSurfaceView");
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void j0(String r1, TextureView r2, int r3, int r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        j(r1, new com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.c(this.i, r2), "onFirstFrameTextureView");
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void y0(String r1, SurfaceView r2, int r3, int r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        j(r1, new com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.c(this.i, r2), "onFirstFrameSurfaceView");
    }

    public g(Function0<? extends v> r2, com.bytedance.android.live.revenuelink.rtc.i r3, FrameLayout r4, String r5, Function0<Integer> r6) {
        Intrinsics.checkNotNullParameter(r2, "liveVideoClientFactoryGetter");
        Intrinsics.checkNotNullParameter(r3, "anchorRtcManager");
        Intrinsics.checkNotNullParameter(r4, "renderContainer");
        Intrinsics.checkNotNullParameter(r5, "selfLinkerID");
        Intrinsics.checkNotNullParameter(r6, "sceneFn");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = CollectionsKt.emptyList();
        this.d = CollectionsKt.emptyList();
        this.f = true;
    }
}
