package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.IHeatChangeController;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.data.Danmaku;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p22.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends com.bytedance.android.livesdk.interactivity.zdanmaku.b<com.bytedance.android.livesdk.interactivity.zdanmaku.i> implements com.bytedance.android.livesdk.interactivity.api.d {
    public a a;
    public final uc2.e b;
    public final uc2.e c;
    public final List<com.bytedance.android.livesdk.interactivity.zdanmaku.i> d;
    public final List<com.bytedance.android.livesdk.interactivity.zdanmaku.i> e;
    public int[] f;
    public int[] g;
    public final l h;
    public final h80.d<p22.k> i;
    public final h80.d<p> j;

    @Override // com.bytedance.android.livesdk.interactivity.api.d
    public final IHeatChangeController.DanmakuHeat a() {
        return this.c.e;
    }

    public final boolean c() {
        if ((!this.d.isEmpty()) == false) goto L5;
        return true;
    L5:
        if ((!this.e.isEmpty()) == true) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.d
    public final boolean d() {
        uc2.e r0 = this.c;
        IHeatChangeController.DanmakuHeat r1 = r0.e;
        int r2 = uc2.d.c[r1.ordinal()];
        boolean r3 = false;
        if (r2 != 1) goto L5;
        return false;
    L5:
        if (r2 != 2) goto L7;
        r0.d.g();
    L34:
        return true;
    L7:
        if (r2 != 3) goto L9;
    L11:
        uc2.e r4 = r0.d;
        int r5 = r4.a.size();
        int r6 = 0;
        boolean r7 = true;
    L12:
        if (r6 >= r5) goto L19;
        if (((uc2.b) ListProtector.get(r4.a, r6)).d() == false) goto L17;
        if (r7 == false) goto L17;
        r7 = true;
    L18:
        r6 = r6 + 1;
    L17:
        r7 = false;
        goto L18
    L19:
        int r8 = r4.a.size();
        int r9 = 0;
        boolean r10 = true;
    L20:
        if (r9 >= r8) goto L27;
        if (((uc2.b) ListProtector.get(r4.a, r9)).e() == false) goto L25;
        if (r10 == false) goto L25;
        r10 = true;
    L26:
        r9 = r9 + 1;
    L25:
        r10 = false;
        goto L26
    L27:
        if (r7 == true) goto L29;
        if (r10 == true) goto L29;
    L30:
        if (r3 == true) goto L34;
        r0.e = IHeatChangeController.DanmakuHeat.MEDIUM;
        r0.d.g();
    L29:
        r3 = true;
        goto L30
    L9:
        if (r2 == 4) goto L11;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.d
    public final boolean e() {
        uc2.e r0 = this.c;
        IHeatChangeController.DanmakuHeat r1 = r0.e;
        int r2 = uc2.d.b[r1.ordinal()];
        if (r2 == 1) goto L23;
        if (r2 == 2) goto L16;
        if (r2 == 3) goto L12;
        if (r2 != 4) goto L28;
    L25:
        return false;
    L28:
        return true;
    L12:
        if (r0.d.d() == true) goto L29;
        r0.e = IHeatChangeController.DanmakuHeat.HIGH_MAX;
        goto L25
    L29:
        return true;
    L16:
        if (r0.d.h() == true) goto L30;
        r0.e = IHeatChangeController.DanmakuHeat.HIGH;
        if (r0.d.d() == true) goto L31;
        r0.e = IHeatChangeController.DanmakuHeat.HIGH_MAX;
        goto L25
    L31:
        return true;
    L30:
        return true;
    L23:
        if (r0.d.h() == false) goto L25;
        r0.e = IHeatChangeController.DanmakuHeat.MEDIUM;
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.d
    public final int f() {
        uc2.e r0 = this.b;
        int r1 = r0.c.b.a;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L11;
        if (r0.i(r2) == true) goto L11;
        if (((uc2.b) ListProtector.get(r0.a, r2)).e == false) goto L10;
        r3 = r3 + 1;
    L10:
        r2 = r2 + 1;
    L11:
        return r3;
    }

    public final void h(a r9) {
        Intrinsics.checkNotNullParameter(r9, "newConfig");
        uc2.e r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r9, "newDanmakuConfig");
        int r1 = r0.c.b.a;
        int r2 = r9.a;
        int r3 = 0;
        if (r2 <= r1) goto L18;
        int r4 = r2 - r1;
        int r5 = uc2.d.a[r0.e.ordinal()];
        if (r5 != 1) goto L7;
    L11:
        int r6 = r0.a.size();
        int r7 = r4 + r6;
    L12:
        if (r6 >= r7) goto L24;
        ArrayList<uc2.b> r8 = r0.a;
        if ((r6 % 2) != 0) goto L16;
        boolean r10 = true;
    L17:
        r8.add(new uc2.h(r6, r10, false, r0));
        r6 = r6 + 1;
        goto L12
    L16:
        r10 = false;
    L24:
        b r11 = r0.c;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r11.b = r9;
        int r13 = r0.a.size();
        int[] r14 = new int[r13];
    L25:
        if (r3 >= r13) goto L27;
        r14[r3] = r3;
        r3 = r3 + 1;
        goto L25
    L27:
        r0.j(r14);
        this.a = r9;
        return;
    L7:
        if (r5 == 2) goto L11;
        int r15 = r0.a.size();
        int r16 = r4 + r15;
    L9:
        if (r15 >= r16) goto L24;
        r0.a.add(new uc2.h(r15, true, false, r0));
        r15 = r15 + 1;
        goto L9
    L18:
        if (r1 >= r2) goto L24;
        int r17 = r1 - r2;
        if (r17 >= r0.a.size()) goto L24;
    L22:
        if (r17 <= 0) goto L24;
        ArrayList<uc2.b> r18 = r0.a;
        ListProtector.remove(r18, r18.size() - 1);
        r17 = r17 - 1;
        goto L22
    }

    public final void g(com.bytedance.android.livesdk.interactivity.zdanmaku.i r3, int[] r4) {
        if (r3.getType() == DanmakuType.Privilege) goto L5;
        return;
    L5:
        if (r3.l() == false) goto L7;
        this.b.f(this.f);
        return;
    L7:
        this.b.f(r4);
    }

    public final void b(vk6.e r18, float r19, Function0 r20) {
        Intrinsics.checkNotNullParameter(r18, "runningDanmakuList");
        Intrinsics.checkNotNullParameter(r20, "nextPreparedDanmakuSupplier");
        a r3 = this.a;
        int r5 = r3.b;
        int r4 = r3.c;
        this.f = ((p22.k) this.i.get()).e;
        this.g = ((p) this.j.get()).d;
        vk6.e.a r6 = r18.iterator();
    L3:
        vk6.e.a r7 = r6;
        int r11 = 0;
        if (r7.hasNext() == false) goto L85;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r8 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r7.next();
        float r14 = 0;
        if (r8.c() < r14) goto L7;
        if (r8.getType() == DanmakuType.Official) goto L31;
        r8.m(r19, false);
    L77:
        this.b.k(r8.f, r8);
        if (r8.getType() != DanmakuType.Privilege) goto L3;
        if ((this.b.b(r8.f) + r8.k()) >= r5) goto L3;
        if (r8.l() == true) goto L83;
        this.b.j(new int[]{r8.f});
        goto L3
    L83:
        uc2.e r9 = this.b;
        int r10 = r8.f;
        r9.j(new int[]{r10, r10 + 1});
        goto L3
    L31:
        if (r8.i() <= 0) goto L33;
        boolean r13 = true;
    L35:
        if (r8.j() < 0) goto L37;
        boolean r15 = true;
    L38:
        if (r13 == true) goto L43;
        if (r15 == true) goto L43;
        r8.m(r19, false);
        if (r8.n == false) goto L77;
        r8.n = false;
        this.b.j(new int[]{r8.f});
    L43:
        int r16 = this.a.b;
        RenderEntity r17 = ((Danmaku) r8).c;
        if (r17 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L47:
        if (Math.abs(((r17.c.a * 0.5f) + r8.b().d.a) - (r16 * 0.5f)) >= 6.0f) goto L49;
        boolean r21 = true;
    L51:
        if (r8.m >= r8.j()) goto L56;
        r8.m = r8.j();
        r8.l = 0.0f;
        if (r8.k <= r14) goto L56;
        r8.k = r8.i();
    L56:
        if (r8.c() < 6.0f) goto L73;
        if (r15 == true) goto L64;
        if (r8.k >= r8.i()) goto L73;
        if (r8.a() < r14) goto L73;
    L64:
        if (r8.m == 0) goto L68;
        float r23 = r8.l;
        if (r23 >= r8.j) goto L68;
        r8.n = true;
        r8.l = r23 + r19;
    L68:
        if (r21 == true) goto L70;
    L72:
        r8.n = true;
        r8.m(r19, false);
        goto L77
    L70:
        if (r8.k >= r8.i()) goto L72;
        r8.n = true;
        r8.k += r19;
    L73:
        r8.m(r19, false);
        if (r8.n == false) goto L77;
        r8.n = false;
        this.b.j(new int[]{r8.f});
        goto L77
    L49:
        r21 = false;
        goto L51
    L37:
        r15 = false;
        goto L38
    L33:
        r13 = false;
        goto L35
    L7:
        r7.remove();
        uc2.e r24 = this.b;
        r24.getClass();
        Intrinsics.checkNotNullParameter(r8, "danmaku");
        if (r8.l() == true) goto L9;
        uc2.b r25 = r8.e;
        if (r25 == null) goto L22;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r26 = r25.c;
    L24:
        if (Intrinsics.areEqual(r26, r8) == false) goto L3;
        uc2.b r27 = r8.e;
        if (r27 == null) goto L3;
        r27.c = null;
        goto L3
    L22:
        r26 = null;
        goto L24
    L9:
        int[] r28 = r8.o;
        if (r28 == null) goto L3;
        int r110 = r28.length;
    L12:
        if (r11 >= r110) goto L3;
        int r111 = r28[r11];
        if (r111 >= r24.a.size()) goto L18;
        if (Intrinsics.areEqual(((uc2.b) ListProtector.get(r24.a, r111)).c, r8) == false) goto L18;
        ((uc2.b) ListProtector.get(r24.a, r111)).c = null;
    L18:
        r11 = r11 + 1;
        goto L12
    L85:
        uc2.e r2 = this.b;
        l r29 = this.h;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r29, "comparator");
        r2.b.clear();
        int r30 = r2.c.b.b;
        int r31 = 0;
    L87:
        if (r31 >= r2.c.b.a) goto L105;
        if (r2.i(r31) == false) goto L91;
        boolean r33 = false;
    L92:
        if (r33 == false) goto L104;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r34 = r2.c(r31);
        if (r34 != null) goto L97;
        r2.b.add(Integer.valueOf(r31));
        goto L104
    L97:
        float r112 = r2.b(r31);
        float r113 = r34.i;
        com.bytedance.android.livesdk.interactivity.zdanmaku.g r114 = r34.h;
        if (r114 == null) goto L100;
        float r35 = r114.a(r34);
    L102:
        if ((r112 + (r113 + r35)) >= r30) goto L104;
        r2.b.add(Integer.valueOf(r31));
        goto L104
    L100:
        r35 = 0.0f;
    L104:
        r31 = r31 + 1;
        goto L87
    L91:
        r33 = ((uc2.b) ListProtector.get(r2.a, r31)).e;
        goto L92
    L105:
        Collections.sort(r2.b, r29);
        Iterator<Integer> r36 = r2.b.iterator();
    L107:
        if (r36.hasNext() == false) goto L246;
        int r37 = r36.next().intValue();
        if ((this.a.d * r37) <= r4) goto L112;
    L187:
        boolean r38 = true;
    L197:
        if (r38 == false) goto L107;
        return;
    L112:
        if ((!((ArrayList) this.d).isEmpty()) == false) goto L149;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r39 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) CollectionsKt.first(this.d);
        if (r39.l() == false) goto L132;
        g(r39, this.f);
        int[] r40 = this.f;
        int r41 = r40.length;
        int r43 = 0;
    L116:
        if (r43 >= r41) goto L129;
        int r115 = r40[r43];
        if ((this.b.b(r115) + r39.k()) > this.a.b) goto L128;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r116 = this.b.c(r115);
        if (r116 != null) goto L122;
    L124:
        boolean r117 = false;
    L125:
        if (r117 == true) goto L128;
        r43 = r43 + 1;
        goto L116
    L122:
        if (r116.n != true) goto L124;
        r117 = true;
    L128:
        boolean r44 = false;
    L130:
        if (r44 == false) goto L149;
        this.b.e(this.f[0], r39);
        this.b.k(this.f[1], r39);
        int[] r45 = this.f;
        r39.o = new int[]{r45[0], r45[1]};
        r18.add(r39);
        ((ArrayList) this.d).remove(r39);
        goto L149
    L129:
        r44 = true;
        goto L130
    L132:
        int[] r46 = this.f;
        int r47 = r46.length;
        int r48 = 0;
    L133:
        if (r48 >= r47) goto L145;
        int r118 = r46[r48];
        if ((this.b.b(r118) + r39.k()) >= this.a.b) goto L144;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r119 = this.b.c(r118);
        if (r119 != null) goto L139;
    L141:
        boolean r120 = false;
    L142:
        if (r120 == true) goto L144;
        this.b.e(r118, r39);
        g(r39, new int[]{r118});
        r18.add(r39);
        ((ArrayList) this.d).remove(r39);
        boolean r49 = true;
    L146:
        if (r49 == true) goto L149;
        g(r39, new int[]{this.f[0]});
        goto L149
    L139:
        if (r119.n != true) goto L141;
        r120 = true;
    L144:
        r48 = r48 + 1;
        goto L133
    L145:
        r49 = false;
    L149:
        if ((!((ArrayList) this.e).isEmpty()) == false) goto L176;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r50 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) CollectionsKt.first(this.e);
        int[] r51 = this.g;
        int r53 = r51.length;
        int r54 = 0;
    L151:
        if (r54 >= r53) goto L171;
        int r121 = r51[r54];
        if (this.b.b(r121) >= this.a.b) goto L170;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r122 = this.b.c(r121);
        if (r122 == null) goto L158;
        if (r122.n == true) goto L170;
    L158:
        this.b.e(r121, r50);
        if (r50.i() <= 0) goto L161;
        boolean r55 = true;
    L163:
        if (r50.j() < 0) goto L165;
        boolean r56 = true;
    L166:
        if (r55 == true) goto L168;
        if (r56 == true) goto L168;
    L169:
        r18.add(r50);
        ((ArrayList) this.e).remove(r50);
        boolean r57 = true;
    L172:
        if (r57 == true) goto L176;
        this.b.f(new int[]{this.g[0]});
    L168:
        this.b.f(new int[]{r121});
        goto L169
    L165:
        r56 = false;
        goto L166
    L161:
        r55 = false;
    L170:
        r54 = r54 + 1;
        goto L151
    L171:
        r57 = false;
    L176:
        if (((uc2.b) ListProtector.get(this.b.a, r37)).f == true) goto L196;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r58 = this.b.c(r37);
        if (r58 != null) goto L180;
    L182:
        boolean r59 = false;
    L183:
        if (r59 == true) goto L196;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r60 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r20.invoke();
        if (r60 == null) goto L187;
        int r61 = k.a[r60.getType().ordinal()];
        if (r61 != 1) goto L191;
        ((ArrayList) this.d).add(r60);
        goto L196
    L191:
        if (r61 == 2) goto L193;
        this.b.e(r37, r60);
        r18.add(r60);
        goto L196
    L193:
        ((ArrayList) this.e).add(r60);
        goto L196
    L180:
        if (r58.n != true) goto L182;
        r59 = true;
    L196:
        r38 = false;
        goto L197
    }

    public m(b r2, h80.d r3, h80.d r4, boolean r5, int r6) {
        if ((r6 & 8) == 0) goto L5;
        c r0 = c.a;
    L7:
        if ((r6 & 16) == 0) goto L9;
        r5 = false;
    L9:
        Intrinsics.checkNotNullParameter(r2, "initialConfig");
        Intrinsics.checkNotNullParameter(r3, "privilegeDanmakuSettingSupplier");
        Intrinsics.checkNotNullParameter(r4, "officialDanmakuSettingSupplier");
        Intrinsics.checkNotNullParameter(r0, "linePriorityStrategy");
        super(r2);
        this.i = r3;
        this.j = r4;
        this.a = r2.b;
        uc2.e r7 = new uc2.e(r2, r5);
        this.b = r7;
        this.c = r7.d;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = ((p22.k) r3.get()).e;
        this.g = ((p) r4.get()).d;
        this.h = new l(this, r0);
        return;
    L5:
        r0 = null;
        goto L7
    }
}
