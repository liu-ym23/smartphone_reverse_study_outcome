package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.barrage.widget.CarnivalDanmakuWidget;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.data.Danmaku;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n extends com.bytedance.android.livesdk.interactivity.zdanmaku.a<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {
    public q72.a a;
    public final uc2.k b;
    public final List<com.bytedance.android.livesdk.interactivity.zdanmaku.i> c;
    public final List<com.bytedance.android.livesdk.interactivity.zdanmaku.i> d;
    public int e;
    public int f;
    public final LinearInterpolator g;
    public final int h;
    public float i;
    public float j;
    public float k;
    public float l;
    public final int m;
    public final double n;
    public final float o;

    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void a() {
        ((ArrayList) this.c).clear();
        ((ArrayList) this.d).clear();
    }

    public n(q72.a r3) {
        c r0 = c.a;
        Intrinsics.checkNotNullParameter(r3, "initialConfig");
        Intrinsics.checkNotNullParameter(r0, "linePriorityStrategy");
        super(r3);
        this.a = r3;
        this.b = new uc2.k(r3);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = 5;
        this.g = new LinearInterpolator();
        this.h = UtilityKotlinExtentionsKt.i(36);
        this.m = UtilityKotlinExtentionsKt.i(2);
        this.n = Math.toRadians(30);
        this.o = 0.8f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void d(q72.a r11) {
        Intrinsics.checkNotNullParameter(r11, "newConfig");
        this.a = r11;
        this.f = 0;
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r11, "newDanmakuConfig");
        q72.a r13 = this.a;
        this.k = r13.b;
        float r14 = r13.c;
        this.l = r14;
        float r1 = (this.h + (r14 / 2.0f)) + this.m;
        this.j = r1;
        this.i = (float) (((double) r1) / Math.tan(this.n));
        ArrayList<uc2.c> r15 = this.b.b;
        float r2 = this.l * 0.5f;
        float r3 = this.k * 0.5f;
        uc2.j r4 = new uc2.j(r3, r2);
        Iterator<uc2.c> r5 = r15.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        uc2.c r6 = r5.next();
        if (r6 == null) goto L9;
        uc2.i r7 = (uc2.i) r6;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    L11:
        if (r15.size() != 12) goto L65;
        Object r0 = ListProtector.get(r15, 0);
        if (r0 == null) goto L62;
        uc2.i r8 = (uc2.i) r0;
        uc2.j r9 = new uc2.j(r3, r2 - this.j);
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r8.b = r9;
        r8.c = this.j;
        r8.d = r2;
        Object r10 = ListProtector.get(r15, 1);
        if (r10 == null) goto L60;
        uc2.i r16 = (uc2.i) r10;
        uc2.j r17 = new uc2.j((this.j * ((float) Math.tan(this.n))) + r3, r2 - this.j);
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r16.b = r17;
        r16.c = this.j / ((float) Math.cos(this.n));
        r16.d = r2 / ((float) Math.cos(this.n));
        Object r18 = ListProtector.get(r15, 2);
        if (r18 == null) goto L58;
        uc2.i r19 = (uc2.i) r18;
        uc2.j r20 = new uc2.j(this.i + r3, r2 - this.j);
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r19.b = r20;
        r19.c = this.i / ((float) Math.cos(this.n));
        r19.d = r3 / ((float) Math.cos(this.n));
        Object r21 = ListProtector.get(r15, 3);
        if (r21 == null) goto L56;
        uc2.i r23 = (uc2.i) r21;
        uc2.j r24 = new uc2.j(this.i + r3, r2);
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r23.b = r24;
        r23.c = this.i;
        r23.d = r3;
        Object r25 = ListProtector.get(r15, 4);
        if (r25 == null) goto L54;
        uc2.i r26 = (uc2.i) r25;
        uc2.j r27 = new uc2.j(this.i + r3, this.j + r2);
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        r26.b = r27;
        r26.c = this.i / ((float) Math.cos(this.n));
        r26.d = r3 / ((float) Math.cos(this.n));
        Object r28 = ListProtector.get(r15, 5);
        if (r28 == null) goto L52;
        uc2.i r29 = (uc2.i) r28;
        uc2.j r30 = new uc2.j((this.j * ((float) Math.tan(this.n))) + r3, this.j + r2);
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        r29.b = r30;
        r29.c = this.j / ((float) Math.cos(this.n));
        r29.d = r2 / ((float) Math.cos(this.n));
        Object r31 = ListProtector.get(r15, 6);
        if (r31 == null) goto L50;
        uc2.i r33 = (uc2.i) r31;
        uc2.j r34 = new uc2.j(r3, this.j + r2);
        Intrinsics.checkNotNullParameter(r34, "<set-?>");
        r33.b = r34;
        r33.c = this.j;
        r33.d = r2;
        Object r35 = ListProtector.get(r15, 7);
        if (r35 == null) goto L48;
        uc2.i r36 = (uc2.i) r35;
        uc2.j r37 = new uc2.j(r3 - (this.j * ((float) Math.tan(this.n))), this.j + r2);
        Intrinsics.checkNotNullParameter(r37, "<set-?>");
        r36.b = r37;
        r36.c = this.j / ((float) Math.cos(this.n));
        r36.d = r2 / ((float) Math.cos(this.n));
        Object r38 = ListProtector.get(r15, 8);
        if (r38 == null) goto L46;
        uc2.i r39 = (uc2.i) r38;
        uc2.j r40 = new uc2.j(r3 - this.i, this.j + r2);
        Intrinsics.checkNotNullParameter(r40, "<set-?>");
        r39.b = r40;
        r39.c = this.i / ((float) Math.cos(this.n));
        r39.d = r3 / ((float) Math.cos(this.n));
        Object r41 = ListProtector.get(r15, 9);
        if (r41 == null) goto L44;
        uc2.i r43 = (uc2.i) r41;
        uc2.j r44 = new uc2.j(r3 - this.i, r2);
        Intrinsics.checkNotNullParameter(r44, "<set-?>");
        r43.b = r44;
        r43.c = this.i;
        r43.d = r3;
        Object r45 = ListProtector.get(r15, 10);
        if (r45 == null) goto L42;
        uc2.i r46 = (uc2.i) r45;
        uc2.j r47 = new uc2.j(r3 - this.i, r2 - this.j);
        Intrinsics.checkNotNullParameter(r47, "<set-?>");
        r46.b = r47;
        r46.c = this.i / ((float) Math.cos(this.n));
        r46.d = r3 / ((float) Math.cos(this.n));
        Object r110 = ListProtector.get(r15, 11);
        if (r110 == null) goto L40;
        uc2.i r111 = (uc2.i) r110;
        uc2.j r48 = new uc2.j(r3 - (this.j * ((float) Math.tan(this.n))), r2 - this.j);
        Intrinsics.checkNotNullParameter(r48, "<set-?>");
        r111.b = r48;
        r111.d = r2 / ((float) Math.cos(this.n));
        r111.c = this.j / ((float) Math.cos(this.n));
        return;
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    L42:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    L46:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    L48:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    L50:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    L52:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    L56:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    L58:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    L60:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    L62:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void e(int r1) {
        this.e = r1;
    }

    public final void b(final vk6.e r33, float r34, final Function0 r35) {
        n r8 = this;
        vk6.e r9 = r33;
        Intrinsics.checkNotNullParameter(r9, "runningDanmakuList");
        Intrinsics.checkNotNullParameter(r35, "nextPreparedDanmakuSupplier");
        vk6.e.a r0 = r33.iterator();
    L3:
        vk6.e.a r1 = r0;
        String r11 = "renderEntity";
        int r13 = 0;
        if (r1.hasNext() == false) goto L23;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r2 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r1.next();
        RenderEntity r3 = ((Danmaku) r2).c;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L8:
        float r4 = r3.d.b;
        RenderEntity r5 = ((Danmaku) r2).c;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L11:
        float r6 = r4 + r5.c.b;
        float r7 = 0;
        if (r6 <= r7) goto L22;
        if (r2.a() >= r8.k) goto L22;
        RenderEntity r10 = ((Danmaku) r2).c;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L19:
        if (r10.d.b >= r8.l) goto L22;
        if (r2.c() > r7) goto L3;
    L22:
        r1.remove();
        r8.b.a(r2.f, r2);
        goto L3
    L23:
        float r14 = 0.5f;
        float r15 = r8.k * 0.5f;
        float r16 = r8.l * 0.5f;
        uc2.j r17 = new uc2.j(r15, r16);
        uc2.k r18 = r8.b;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r17, "pivot");
        r18.a.clear();
        Iterator<uc2.c> r19 = r18.b.iterator();
    L24:
        int r20 = 3;
        String r110 = "null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine";
        if (r19.hasNext() == false) goto L51;
        uc2.c r21 = r19.next();
        if (r21 == null) goto L50;
        uc2.i r23 = (uc2.i) r21;
        if (r23.e.isEmpty() == true) goto L30;
        if (r23.e.size() > 3) goto L24;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r24 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) CollectionsKt.last(r23.e);
        if (ArraysKt.contains(r18.c, r23.a) == false) goto L40;
        if (Math.abs(r24.b().e.a - r17.a) <= ((r24.b().c.a * r14) + UtilityKotlinExtentionsKt.i(r18.d))) goto L42;
        r18.a.add(Integer.valueOf(r23.a));
    L42:
        ArrayList<Integer> r25 = r18.a;
        ArrayList<Integer> r26 = new ArrayList();
        int[] r111 = r18.e;
        int r112 = r111.length;
        int r113 = 0;
    L43:
        if (r113 >= r112) goto L48;
        int r114 = r111[r113];
        if (r25.contains(Integer.valueOf(r114)) == true) goto L46;
        r113 = r113 + 1;
        goto L43
    L46:
        r26.add(Integer.valueOf(r114));
    L48:
        r18.a = r26;
        r14 = 0.5f;
        goto L24
    L40:
        if (Math.abs(r24.b().e.b - r17.b) <= ((r24.b().c.b * r14) + UtilityKotlinExtentionsKt.i(r18.d))) goto L42;
        r18.a.add(Integer.valueOf(r23.a));
        goto L42
    L30:
        r18.a.add(Integer.valueOf(r23.a));
        goto L24
    L50:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    L51:
        Iterator<Integer> r27 = r18.a.iterator();
        n r28 = r8;
    L53:
        if (r27.hasNext() == false) goto L110;
        final int r29 = r27.next().intValue();
        final Ref.ObjectRef r30 = new Ref.ObjectRef();
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r31 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r35.invoke();
        boolean r36 = true;
        if (r31 == null) goto L69;
        r30.element = r31;
        if (r31.getType() != DanmakuType.CarnivalEgg) goto L60;
        ((ArrayList) r28.c).add((com.bytedance.android.livesdk.interactivity.zdanmaku.i) r30.element);
    L62:
        if (CarnivalDanmakuWidget.A == false) goto L71;
        if (r28.f < r28.e) goto L71;
        if (((ArrayList) r28.c).size() <= 0) goto L68;
        r30.element = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) ListProtector.remove(r28.c, r13);
        r28.f = r13;
    L73:
        RenderEntity r37 = ((Danmaku) ((com.bytedance.android.livesdk.interactivity.zdanmaku.i) r30.element)).c;
        if (r37 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException(r11);
    L76:
        com.bytedance.live.artist.render.b r38 = r37.e;
        r38.a = r15;
        r38.b = r16;
        com.bytedance.live.artist.render.f r39 = r37.c;
        float r115 = r15 - (r39.a / 2.0f);
        float r40 = r16 - (r39.b / 2.0f);
        com.bytedance.live.artist.render.b r41 = r37.d;
        r41.a = r115;
        r41.b = r40;
        RenderEntity r43 = ((com.bytedance.android.livesdk.interactivity.zdanmaku.i) r30.element).b();
        sk6.a r44 = r43.e(sk6.a.class);
        Object r116 = ListProtector.get(r28.b.b, r29);
        if (r116 == null) goto L103;
        uc2.i r117 = (uc2.i) r116;
        uc2.j r118 = r117.b;
        float r119 = r118.a;
        float r120 = r118.b;
        float r45 = r117.c;
        if (r29 != r20) goto L81;
        String r210 = r11;
        r119 = r119 + Math.max(0.0f, (((com.bytedance.android.livesdk.interactivity.zdanmaku.i) r30.element).b().c.a / 2.0f) - (r28.i - r28.k));
        float r46 = Math.max(0.0f, (((com.bytedance.android.livesdk.interactivity.zdanmaku.i) r30.element).b().c.a / 2.0f) - (r28.i - r28.k));
    L84:
        r45 = r45 + r46;
    L85:
        float r121 = r119;
        float r47 = r45 / 150.0f;
        float r122 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        float r211 = r16;
        long r48 = (long) (r47 * r122);
        if (r44 == null) goto L88;
        nf6.b r123 = r44.c;
    L89:
        LinearInterpolator r124 = r28.g;
        String r212 = r110;
        ok6.c r125 = new ok6.c(r48, r123, r15, r211, r121, r120, r124);
        long r49 = (long) (((r117.d / 150.0f) * r28.o) * r122);
        if (r44 == null) goto L92;
        nf6.c r50 = r44.b;
    L93:
        ok6.b r126 = new ok6.b(r49, r50, r124);
        if (r44 == null) goto L96;
        pk6.a r51 = r44.a;
    L97:
        ok6.a r53 = new ok6.a(r49, r51);
        final float r54 = r15;
        final float r127 = r211;
        mf6.c r128 = new mf6.c((long) r47, new RadiusCarnivalDanmakuLayoutManger$layout$$inlined$loopInIndices$interactivity_platform_impl_saasRelease$lambda$1(r29, r30, this, r35, r54, r127, r33));
        ((ArrayList) ((mf6.b) r128).d).add(r125);
        ((ArrayList) ((mf6.b) r128).d).add(r126);
        ((ArrayList) ((mf6.b) r128).d).add(r53);
        r43.i = r128;
        n r55 = this;
        uc2.k r56 = r55.b;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r57 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r30.element;
        r56.getClass();
        Intrinsics.checkNotNullParameter(r57, "danmaku");
        r57.f = r29;
        Object r58 = ListProtector.get(r56.b, r29);
        if (r58 == null) goto L101;
        ((uc2.i) r58).e.add(r57);
        vk6.e r59 = r33;
        r59.add((com.bytedance.android.livesdk.interactivity.zdanmaku.i) r30.element);
        r28 = r55;
        String r60 = r212;
    L105:
        boolean r61 = false;
    L106:
        if (r61 == true) goto L134;
        r8 = r55;
        r9 = r59;
        r110 = r60;
        r16 = r127;
        r15 = r15;
        r11 = r210;
        r20 = 3;
        r13 = 0;
        goto L53
    L134:
        return;
    L101:
        throw new NullPointerException(r212);
    L96:
        r51 = null;
        goto L97
    L92:
        r50 = null;
        goto L93
    L88:
        r123 = null;
        goto L89
    L81:
        r210 = r11;
        if (r29 != 9) goto L85;
        r119 = r119 - ((((com.bytedance.android.livesdk.interactivity.zdanmaku.i) r30.element).b().c.a / 2.0f) - (r28.i - r28.k));
        r46 = Math.max(0.0f, (((com.bytedance.android.livesdk.interactivity.zdanmaku.i) r30.element).b().c.a / 2.0f) - (r28.i - r28.k));
        goto L84
    L103:
        throw new NullPointerException(r110);
    L68:
        r36 = false;
    L71:
        if (((ArrayList) r28.d).size() <= 0) goto L104;
        r30.element = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) ListProtector.remove(r28.d, r13);
        r28.f++;
        goto L73
    L104:
        r127 = r16;
        r55 = r8;
        r59 = r9;
        r210 = r11;
        r60 = r110;
        goto L105
    L60:
        ((ArrayList) r28.d).add((com.bytedance.android.livesdk.interactivity.zdanmaku.i) r30.element);
    L69:
        r61 = r36;
        r127 = r16;
        r15 = r15;
        r55 = r8;
        r59 = r9;
        r210 = r11;
        r60 = r110;
        goto L106
    }
}
