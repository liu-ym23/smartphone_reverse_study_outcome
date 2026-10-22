package s;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import t.o;
import t.p;

/* JADX INFO: loaded from: classes.dex */
public final class f extends m {
    public int A0;
    public int B0;
    public int C0;
    public c[] D0;
    public c[] E0;
    public int F0;
    public boolean G0;
    public boolean H0;
    public WeakReference<d> I0;
    public WeakReference<d> J0;
    public WeakReference<d> K0;
    public WeakReference<d> L0;
    public final HashSet<e> M0;
    public final t.b.a N0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final t.b f11896t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final t.e f11897u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f11898v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public t.b.InterfaceC0157b f11899w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f11900x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final p.d f11901y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f11902z0;

    public f() {
        this.f11896t0 = new t.b(this);
        this.f11897u0 = new t.e(this);
        this.f11899w0 = null;
        this.f11900x0 = false;
        this.f11901y0 = new p.d();
        this.B0 = 0;
        this.C0 = 0;
        this.D0 = new c[4];
        this.E0 = new c[4];
        this.F0 = 257;
        this.G0 = false;
        this.H0 = false;
        this.I0 = null;
        this.J0 = null;
        this.K0 = null;
        this.L0 = null;
        this.M0 = new HashSet();
        this.N0 = new t.b.a();
    }

    public static void U(e r8, t.b.InterfaceC0157b r10, t.b.a r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r8.f11866j0 != 8) goto L7;
    L91:
        r11.f12143e = 0;
        r11.f12144f = 0;
        return;
    L7:
        if ((r8 instanceof h) == true) goto L91;
        if ((r8 instanceof a) == true) goto L91;
        e.a[] r12 = r8.V;
        r11.f12139a = r12[0];
        boolean r13 = true;
        r11.f12140b = r12[1];
        r11.f12141c = r8.q();
        r11.f12142d = r8.l();
        r11.f12147i = false;
        r11.f12148j = 0;
        e.a r14 = r11.f12139a;
        e.a r15 = e.a.f11893m;
        if (r14 != r15) goto L14;
        boolean r16 = true;
    L16:
        if (r11.f12140b != r15) goto L18;
        boolean r17 = true;
    L20:
        if (r16 == true) goto L22;
    L24:
        boolean r18 = false;
    L25:
        if (r17 == true) goto L27;
    L29:
        boolean r19 = false;
    L30:
        if (r16 == true) goto L32;
    L42:
        if (r17 == false) goto L55;
        if (r8.t(1) == false) goto L55;
        if (r8.f11884t != 0) goto L55;
        if (r19 == true) goto L55;
        r11.f12140b = e.a.f11892b;
        if (r16 == true) goto L51;
    L53:
        r17 = false;
        goto L55
    L51:
        if (r8.f11883s != 0) goto L53;
        r11.f12140b = e.a.f11891a;
    L55:
        if (r8.A() == false) goto L58;
        r11.f12139a = e.a.f11891a;
        r16 = false;
    L58:
        if (r8.B() == false) goto L60;
        r11.f12140b = e.a.f11891a;
        r17 = false;
    L60:
        int[] r20 = r8.f11885u;
        if (r18 == true) goto L63;
    L71:
        if (r19 == true) goto L73;
    L85:
        ((ConstraintLayout.b) r10).b(r8, r11);
        r8.N(r11.f12143e);
        r8.K(r11.f12144f);
        r8.F = r11.f12146h;
        int r21 = r11.f12145g;
        r8.d0 = r21;
        if (r21 > 0) goto L89;
        r13 = false;
    L89:
        r8.F = r13;
        r11.f12148j = 0;
        return;
    L73:
        if (r20[1] != 4) goto L75;
        r11.f12140b = e.a.f11891a;
        goto L85
    L75:
        if (r16 == true) goto L85;
        e.a r22 = r11.f12139a;
        e.a r23 = e.a.f11891a;
        if (r22 != r23) goto L79;
        int r24 = r11.f12141c;
    L80:
        r11.f12140b = r23;
        if (r8.f11849a0 != (-1)) goto L83;
        int r25 = (int) (r24 / r8.Z);
    L84:
        r11.f12142d = r25;
        goto L85
    L83:
        r25 = (int) (r8.Z * r24);
        goto L84
    L79:
        r11.f12140b = e.a.f11892b;
        ((ConstraintLayout.b) r10).b(r8, r11);
        r24 = r11.f12143e;
        goto L80
    L63:
        if (r20[0] != 4) goto L65;
        r11.f12139a = e.a.f11891a;
        goto L71
    L65:
        if (r17 == true) goto L71;
        e.a r26 = r11.f12140b;
        e.a r27 = e.a.f11891a;
        if (r26 != r27) goto L69;
        int r28 = r11.f12142d;
    L70:
        r11.f12139a = r27;
        r11.f12141c = (int) (r8.Z * r28);
        goto L71
    L69:
        r11.f12139a = e.a.f11892b;
        ((ConstraintLayout.b) r10).b(r8, r11);
        r28 = r11.f12144f;
        goto L70
    L32:
        if (r8.t(0) == false) goto L42;
        if (r8.f11883s != 0) goto L42;
        if (r18 == true) goto L42;
        r11.f12139a = e.a.f11892b;
        if (r17 == true) goto L39;
    L41:
        r16 = false;
        goto L42
    L39:
        if (r8.f11884t != 0) goto L41;
        r11.f12139a = e.a.f11891a;
        goto L41
    L27:
        if (r8.Z <= 0.0f) goto L29;
        r19 = true;
        goto L30
    L22:
        if (r8.Z <= 0.0f) goto L24;
        r18 = true;
        goto L25
    L18:
        r17 = false;
        goto L20
    L14:
        r16 = false;
        goto L16
    }

    @Override // s.m, s.e
    public final void C() {
        this.f11901y0.u();
        this.f11902z0 = 0;
        this.A0 = 0;
        super.C();
    }

    @Override // s.e
    public final void O(boolean r8, boolean r10) {
        super.O(r8, r10);
        int r11 = this.f11940s0.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.f11940s0.get(r12).O(r8, r10);
        r12 = r12 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v59 */
    /* JADX WARN: Type inference failed for: r12v60 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r20v10 */
    /* JADX WARN: Type inference failed for: r20v11 */
    /* JADX WARN: Type inference failed for: r20v12 */
    /* JADX WARN: Type inference failed for: r20v30 */
    /* JADX WARN: Type inference failed for: r20v31 */
    /* JADX WARN: Type inference failed for: r20v32 */
    /* JADX WARN: Type inference failed for: r20v33 */
    /* JADX WARN: Type inference failed for: r20v34 */
    /* JADX WARN: Type inference failed for: r20v35 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v7 */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r20v9 */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r29v0, types: [s.e, s.f, s.m] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v16 */
    @Override // s.m
    public final void Q() {
        this.f11851b0 = 0;
        this.f11853c0 = 0;
        this.G0 = false;
        this.H0 = false;
        int r8 = this.f11940s0.size();
        int r10 = Math.max(0, q());
        int r11 = Math.max(0, l());
        e.a[] r12 = this.V;
        e.a r13 = r12[1];
        e.a r14 = r12[0];
        int r15 = this.f11898v0;
        d r16 = this.L;
        d r17 = this.K;
        if (r15 == 0) goto L5;
    L152:
        int r20 = r11;
        e.a[] r22 = r12;
        d r21 = r17;
    L153:
        p.d r18 = this.f11901y0;
        if (r8 <= 2) goto L394;
        e.a r19 = e.a.f11892b;
        if (r14 == r19) goto L159;
        if (r13 != r19) goto L394;
    L159:
        if (k.b(this.F0, 1024) == false) goto L394;
        t.b.InterfaceC0157b r23 = this.f11899w0;
        ArrayList<e> r24 = this.f11940s0;
        int r110 = r24.size();
        int r111 = 0;
    L161:
        if (r111 >= r110) goto L169;
        e r112 = r24.get(r111);
        e.a r113 = r22[0];
        e.a r25 = r22[1];
        e.a[] r26 = r112.V;
        d r27 = r16;
        if (t.i.b(r113, r25, r26[0], r26[1]) == false) goto L167;
        if ((r112 instanceof g) == true) goto L167;
        r111 = r111 + 1;
        r16 = r27;
    L167:
        int r28 = r10;
        int r29 = r8;
        p.d r30 = r18;
        e.a r210 = r13;
        e.a r211 = r14;
    L371:
        boolean r31 = false;
    L373:
        if (r31 == false) goto L393;
        e.a r32 = e.a.f11892b;
        e.a r33 = r211;
        if (r33 != r32) goto L381;
        int r34 = r28;
        if (r34 >= q()) goto L380;
        if (r34 <= 0) goto L380;
        N(r34);
        this.G0 = true;
    L382:
        int r35 = r34;
    L383:
        e.a r36 = r210;
        if (r36 != r32) goto L390;
        int r37 = r20;
        if (r37 >= l()) goto L389;
        if (r37 <= 0) goto L389;
        K(r37);
        this.H0 = true;
    L391:
        int r38 = r37;
    L392:
        boolean r39 = true;
    L397:
        if (V(64) == false) goto L399;
    L402:
        boolean r40 = true;
    L403:
        r30.getClass();
        r30.f9878h = false;
        if (this.F0 == 0) goto L407;
        if (r40 == false) goto L407;
        char r41 = 1;
        r30.f9878h = true;
    L408:
        ArrayList<e> r114 = this.f11940s0;
        e.a r115 = r22[0];
        e.a r116 = e.a.f11892b;
        if (r115 != r116) goto L411;
    L414:
        boolean r117 = true;
    L415:
        this.B0 = 0;
        this.C0 = 0;
        int r42 = r29;
        int r43 = 0;
    L416:
        if (r43 >= r42) goto L421;
        e r118 = this.f11940s0.get(r43);
        if ((r118 instanceof m) == false) goto L420;
        ((m) r118).Q();
    L420:
        r43 = r43 + 1;
        goto L416
    L421:
        boolean r44 = V(64);
        boolean r119 = r39;
        int r45 = 0;
        ?? r120 = 1;
    L422:
        if (r120 == 0) goto L537;
        int r121 = r45 + 1;
        r30.u();     // Catch: Exception -> L473
        this.B0 = 0;     // Catch: Exception -> L473
        this.C0 = 0;     // Catch: Exception -> L473
        h(r30);     // Catch: Exception -> L473
        int r46 = 0;
    L425:
        if (r46 >= r42) goto L427;
        this.f11940s0.get(r46).h(r30);     // Catch: Exception -> L473
        r46 = r46 + 1;     // Catch: Exception -> L473
        goto L425
    L427:
        S(r30);     // Catch: Exception -> L473
        WeakReference<d> r47 = this.I0;     // Catch: Exception -> L466
        if (r47 != null) goto L431;
    L439:
        WeakReference<d> r48 = this.K0;     // Catch: Exception -> L466
        if (r48 != null) goto L442;
    L444:
        WeakReference<d> r49 = this.J0;     // Catch: Exception -> L466
        if (r49 != null) goto L447;
    L459:
        WeakReference<d> r50 = this.L0;     // Catch: Exception -> L466
        if (r50 == null) goto L469;
        if (r50.get() == null) goto L469;
        r30.f(r30.l(this.M), r30.l(this.L0.get()), 0, 5);     // Catch: Exception -> L466
        this.L0 = null;     // Catch: Exception -> L471
    L469:
        r30.q();     // Catch: Exception -> L471
        ?? r212 = 1;
    L476:
        boolean[] r51 = k.f11933a;
        if (r212 == 0) goto L491;
        r51[2] = false;
        boolean r122 = V(64);
        P(r30, r122);
        int r123 = this.f11940s0.size();
        int r52 = 0;
        boolean r213 = false;
    L479:
        if (r52 >= r123) goto L490;
        int r214 = r123;
        e r124 = this.f11940s0.get(r52);
        r124.P(r30, r122);
        boolean r215 = r122;
        boolean r216 = r119;
        if (r124.f11863i == (-1)) goto L483;
    L486:
        boolean r125 = true;
    L487:
        if (r125 == false) goto L489;
        r213 = true;
    L489:
        r52 = r52 + 1;
        r123 = r214;
        r122 = r215;
        r119 = r216 ? 1 : 0;
        r213 = r213;
        goto L479
    L483:
        if (r124.f11865j != (-1)) goto L486;
        r125 = false;
        goto L487
    L490:
        boolean r217 = r119;
        boolean r218 = r213;
    L496:
        if (r117 == false) goto L512;
        if (r121 >= 8) goto L512;
        if (r51[2] == false) goto L512;
        int r53 = 0;
        int r126 = 0;
        int r127 = 0;
    L501:
        if (r53 >= r42) goto L503;
        e r128 = this.f11940s0.get(r53);
        r127 = Math.max(r127, r128.q() + r128.f11851b0);
        r126 = Math.max(r126, r128.l() + r128.f11853c0);
        r53 = r53 + 1;
        goto L501
    L503:
        int r54 = Math.max(this.f11856e0, r127);
        int r55 = Math.max(this.f11858f0, r126);
        e.a r129 = e.a.f11892b;
        r218 = r218;
        if (r33 != r129) goto L508;
        r218 = r218;
        if (q() >= r54) goto L508;
        N(r54);
        r22[0] = r129;
        r218 = true;
        r217 = true;
    L508:
        if (r36 != r129) goto L512;
        if (l() >= r55) goto L512;
        K(r55);
        r22[1] = r129;
        r218 = true;
        r217 = true;
    L512:
        int r56 = Math.max(this.f11856e0, q());
        boolean r219 = r218;
        if (r56 <= q()) goto L515;
        N(r56);
        r22[0] = e.a.f11891a;
        r219 = true;
        r217 = true;
    L515:
        int r57 = Math.max(this.f11858f0, l());
        if (r57 <= l()) goto L518;
        K(r57);
        ?? r58 = 1;
        r22[1] = e.a.f11891a;
        ?? r220 = 1;
        r217 = true;
    L519:
        if (r217 == true) goto L532;
        e.a r59 = r22[0];
        e.a r130 = e.a.f11892b;
        r220 = r220;
        r220 = r220;
        if (r59 != r130) goto L527;
        if (r35 <= 0) goto L527;
        r220 = r220;
        if (q() <= r35) goto L527;
        this.G0 = r58;
        r22[0] = e.a.f11891a;
        N(r35);
        ?? r221 = r58;
        r217 = r221 == true ? 1 : 0;
        r220 = r221;
    L527:
        if (r22[r58] != r130) goto L532;
        if (r38 <= 0) goto L532;
        if (l() <= r38) goto L532;
        this.H0 = r58;
        r22[r58] = e.a.f11891a;
        K(r38);
        int r60 = 8;
        r119 = true;
        ?? r222 = 1;
    L533:
        if (r121 <= r60) goto L535;
        ?? r131 = 0;
    L536:
        r45 = r121;
        r120 = r131;
        goto L422
    L535:
        r131 = r222;
    L532:
        r119 = r217;
        r60 = 8;
        r222 = r220;
        goto L533
    L518:
        r58 = 1;
        r220 = r219;
        goto L519
    L491:
        r217 = r119 ? 1 : 0;
        P(r30, r44);
        int r61 = 0;
    L492:
        if (r61 >= r42) goto L494;
        this.f11940s0.get(r61).P(r30, r44);
        r61 = r61 + 1;
        goto L492
    L494:
        r218 = false;
        goto L496
    L447:
        if (r49.get() == null) goto L459;
        d r62 = this.J0.get();     // Catch: Exception -> L466
        d r63 = r21;
        r21 = r63;
        r30.f(r30.l(r62), r30.l(r63), 0, 5);     // Catch: Exception -> L466
        this.J0 = null;     // Catch: Exception -> L471
    L471:
        e = e;
    L472:
        ?? r132 = 1;
    L475:
        e.printStackTrace();
        r212 = r132;
        System.out.println("EXCEPTION : " + e);
    L456:
        e = e;
        r21 = r63;
        goto L472
    L442:
        if (r48.get() == null) goto L444;
        r30.f(r30.l(this.N), r30.l(this.K0.get()), 0, 5);     // Catch: Exception -> L466
        this.K0 = null;     // Catch: Exception -> L466
        goto L444
    L431:
        if (r47.get() == null) goto L439;
        d r64 = this.I0.get();     // Catch: Exception -> L466
        d r133 = r27;
        r27 = r133;
        r30.f(r30.l(r64), r30.l(r133), 0, 5);     // Catch: Exception -> L466
        this.I0 = null;     // Catch: Exception -> L466
    L437:
        e = e;
        r27 = r133;
    L466:
        e = e;
    L473:
        e = e;
        r132 = r120;
        goto L475
    L537:
        boolean r223 = r119 ? 1 : 0;
        this.f11940s0 = r114;
        if (r223 == false) goto L540;
        r22[0] = r33;
        r22[1] = r36;
    L540:
        F(r30.f9883m);
        return;
    L411:
        if (r22[r41] == r116) goto L414;
        r117 = false;
    L407:
        r41 = 1;
        goto L408
    L399:
        if (V(128) == true) goto L402;
        r40 = false;
    L389:
        r38 = l();
        goto L392
    L390:
        r37 = r20;
    L380:
        r35 = q();
        goto L383
    L381:
        r34 = r28;
        goto L382
    L393:
        r36 = r210;
        int r65 = r28;
        r33 = r211;
    L395:
        r35 = r65;
        r38 = r20;
        r39 = false;
        goto L397
    L169:
        r27 = r16;
        int r66 = 0;
        ArrayList r67 = null;
        ArrayList r134 = null;
        ArrayList r135 = null;
        ArrayList r136 = null;
        ArrayList r137 = null;
        ArrayList r138 = null;
    L170:
        if (r66 >= r110) goto L230;
        int r224 = r8;
        e r68 = r24.get(r66);
        e.a r225 = r13;
        e.a r69 = r22[0];
        int r226 = r10;
        e.a r70 = r22[1];
        e.a r227 = r14;
        e.a[] r71 = r68.V;
        p.d r228 = r18;
        if (t.i.b(r69, r70, r71[0], r71[1]) == true) goto L174;
        U(r68, r23, this.N0);
    L174:
        boolean r72 = r68 instanceof h;
        if (r72 == false) goto L187;
        h r73 = (h) r68;
        if (r73.f11929w0 != 0) goto L182;
        if (r135 != null) goto L180;
        r135 = new ArrayList();
    L180:
        r135.add(r73);
    L182:
        if (r73.f11929w0 != 1) goto L187;
        if (r67 != null) goto L185;
        r67 = new ArrayList();
    L185:
        r67.add(r73);
    L187:
        if ((r68 instanceof j) == false) goto L208;
        if ((r68 instanceof a) == false) goto L199;
        a r74 = (a) r68;
        if (r74.S() != 0) goto L195;
        if (r134 != null) goto L194;
        r134 = new ArrayList();
    L194:
        r134.add(r74);
    L195:
        int r75 = r74.S();
        Object r76 = r74;
        if (r75 != 1) goto L208;
        if (r136 != null) goto L206;
        ArrayList r77 = new ArrayList();
        Object r78 = r74;
    L205:
        r136 = r77;
        r76 = r78;
    L206:
        r136.add(r76);
        goto L208
    L199:
        j r79 = (j) r68;
        if (r134 != null) goto L202;
        r134 = new ArrayList();
    L202:
        r134.add(r79);
        r76 = r79;
        if (r136 != null) goto L206;
        r77 = new ArrayList();
        r78 = r79;
    L208:
        if (r68.K.f11835f != null) goto L218;
        if (r68.M.f11835f != null) goto L218;
        if (r72 == true) goto L218;
        if ((r68 instanceof a) == true) goto L218;
        if (r137 != null) goto L216;
        r137 = new ArrayList();
    L216:
        r137.add(r68);
    L218:
        if (r68.L.f11835f != null) goto L229;
        if (r68.N.f11835f != null) goto L229;
        if (r68.O.f11835f != null) goto L229;
        if (r72 == true) goto L229;
        if ((r68 instanceof a) == true) goto L229;
        if (r138 != null) goto L228;
        r138 = new ArrayList();
    L228:
        r138.add(r68);
    L229:
        r66 = r66 + 1;
        r13 = r225;
        r8 = r224;
        r10 = r226;
        r14 = r227;
        r18 = r228;
        goto L170
    L230:
        r28 = r10;
        r29 = r8;
        p.d r229 = r18;
        r210 = r13;
        r211 = r14;
        ArrayList<o> r80 = new ArrayList();
        if (r67 == null) goto L236;
        Iterator r81 = r67.iterator();
    L234:
        if (r81.hasNext() == false) goto L236;
        t.i.a((h) r81.next(), 0, r80, null);
    L236:
        o r82 = null;
        int r83 = 0;
        if (r134 == null) goto L242;
        Iterator r84 = r134.iterator();
    L240:
        if (r84.hasNext() == false) goto L242;
        j r85 = (j) r84.next();
        o r86 = t.i.a(r85, r83, r80, r82);
        r85.Q(r83, r86, r80);
        r86.a(r80);
        r82 = null;
        r83 = 0;
    L242:
        HashSet<d> r87 = j(d.a.f11839a).f11830a;
        if (r87 == null) goto L248;
        Iterator<d> r88 = r87.iterator();
    L246:
        if (r88.hasNext() == false) goto L248;
        t.i.a(r88.next().f11833d, 0, r80, null);
    L248:
        HashSet<d> r89 = j(d.a.f11841m).f11830a;
        if (r89 == null) goto L254;
        Iterator<d> r90 = r89.iterator();
    L252:
        if (r90.hasNext() == false) goto L254;
        t.i.a(r90.next().f11833d, 0, r80, null);
    L254:
        HashSet<d> r91 = j(d.a.f11844p).f11830a;
        if (r91 == null) goto L260;
        Iterator<d> r92 = r91.iterator();
    L258:
        if (r92.hasNext() == false) goto L260;
        t.i.a(r92.next().f11833d, 0, r80, null);
    L260:
        o r93 = null;
        if (r137 == null) goto L266;
        Iterator r94 = r137.iterator();
    L264:
        if (r94.hasNext() == false) goto L266;
        t.i.a((e) r94.next(), 0, r80, null);
    L266:
        if (r135 == null) goto L271;
        Iterator r95 = r135.iterator();
    L269:
        if (r95.hasNext() == false) goto L271;
        t.i.a((h) r95.next(), 1, r80, null);
    L271:
        int r96 = 1;
        if (r136 == null) goto L277;
        Iterator r97 = r136.iterator();
    L275:
        if (r97.hasNext() == false) goto L277;
        j r98 = (j) r97.next();
        o r99 = t.i.a(r98, r96, r80, r93);
        r98.Q(r96, r99, r80);
        r99.a(r80);
        r93 = null;
        r96 = 1;
    L277:
        HashSet<d> r100 = j(d.a.f11840b).f11830a;
        if (r100 == null) goto L283;
        Iterator<d> r101 = r100.iterator();
    L281:
        if (r101.hasNext() == false) goto L283;
        t.i.a(r101.next().f11833d, 1, r80, null);
    L283:
        HashSet<d> r102 = j(d.a.f11843o).f11830a;
        if (r102 == null) goto L289;
        Iterator<d> r103 = r102.iterator();
    L287:
        if (r103.hasNext() == false) goto L289;
        t.i.a(r103.next().f11833d, 1, r80, null);
    L289:
        HashSet<d> r104 = j(d.a.f11842n).f11830a;
        if (r104 == null) goto L295;
        Iterator<d> r105 = r104.iterator();
    L293:
        if (r105.hasNext() == false) goto L295;
        t.i.a(r105.next().f11833d, 1, r80, null);
    L295:
        HashSet<d> r106 = j(d.a.f11844p).f11830a;
        if (r106 == null) goto L302;
        Iterator<d> r107 = r106.iterator();
    L299:
        if (r107.hasNext() == false) goto L302;
        t.i.a(r107.next().f11833d, 1, r80, null);
    L302:
        if (r138 == null) goto L307;
        Iterator r108 = r138.iterator();
    L305:
        if (r108.hasNext() == false) goto L307;
        t.i.a((e) r108.next(), 1, r80, null);
    L307:
        int r109 = 0;
    L308:
        if (r109 >= r110) goto L335;
        e r139 = r24.get(r109);
        e.a[] r140 = r139.V;
        e.a r141 = r140[0];
        e.a r142 = e.a.f11893m;
        if (r141 == r142) goto L312;
    L314:
        boolean r143 = false;
    L315:
        if (r143 == false) goto L333;
        int r144 = r139.f11880q0;
        int r145 = r80.size();
        int r146 = 0;
    L317:
        if (r146 >= r145) goto L322;
        o r147 = r80.get(r146);
        if (r144 == r147.f12189b) goto L323;
        r146 = r146 + 1;
    L323:
        int r148 = r139.f11882r0;
        int r149 = r80.size();
        int r150 = 0;
    L324:
        if (r150 >= r149) goto L329;
        o r151 = r80.get(r150);
        if (r148 == r151.f12189b) goto L330;
        r150 = r150 + 1;
    L330:
        if (r147 == null) goto L333;
        if (r151 == null) goto L333;
        r147.c(0, r151);
        r151.f12190c = 2;
        r80.remove(r147);
        goto L333
    L329:
        r151 = null;
        goto L330
    L322:
        r147 = null;
    L333:
        r109 = r109 + 1;
        goto L308
    L312:
        if (r140[1] != r142) goto L314;
        r143 = true;
        goto L315
    L335:
        if (r80.size() > 1) goto L338;
        r30 = r229;
        goto L371
    L338:
        if (r22[0] != e.a.f11892b) goto L352;
        Iterator<o> r152 = r80.iterator();
        int r153 = 0;
        o r154 = null;
    L341:
        if (r152.hasNext() == false) goto L349;
        o r155 = r152.next();
        if (r155.f12190c == 1) goto L344;
        p.d r156 = r229;
        int r157 = r155.b(r156, 0);
        if (r157 <= r153) goto L348;
        r154 = r155;
        r229 = r156;
        r153 = r157;
    L348:
        r229 = r156;
        goto L341
    L344:
        r156 = r229;
        goto L348
    L349:
        r30 = r229;
        if (r154 == null) goto L353;
        L(e.a.f11891a);
        N(r153);
        char r158 = 1;
    L355:
        if (r22[r158] != e.a.f11892b) goto L367;
        Iterator<o> r159 = r80.iterator();
        int r160 = 0;
        o r161 = null;
    L358:
        if (r159.hasNext() == false) goto L365;
        o r162 = r159.next();
        if (r162.f12190c == 0) goto L358;
        int r163 = r162.b(r30, 1);
        if (r163 <= r160) goto L358;
        r161 = r162;
        r160 = r163;
        goto L358
    L365:
        if (r161 == null) goto L367;
        M(e.a.f11891a);
        K(r160);
    L368:
        if (r154 != null) goto L372;
        if (r161 == null) goto L371;
    L372:
        r31 = true;
    L367:
        r161 = null;
    L353:
        r158 = 1;
        r154 = null;
        goto L355
    L352:
        r30 = r229;
    L394:
        r29 = r8;
        r30 = r18;
        r36 = r13;
        r33 = r14;
        r27 = r16;
        r65 = r10;
        goto L395
    L5:
        if (k.b(this.F0, 1) == false) goto L152;
        t.b.InterfaceC0157b r164 = this.f11899w0;
        e.a r165 = r12[0];
        e.a r166 = r12[1];
        E();
        ArrayList<e> r167 = this.f11940s0;
        int r168 = r167.size();
        int r169 = 0;
    L7:
        if (r169 >= r168) goto L9;
        r167.get(r169).E();
        r169 = r169 + 1;
        goto L7
    L9:
        boolean r170 = this.f11900x0;
        if (r165 != e.a.f11891a) goto L12;
        I(0, q());
    L13:
        boolean r171 = false;
        int r172 = 0;
        boolean r173 = false;
    L15:
        if (r172 >= r168) goto L39;
        d r230 = r17;
        e r174 = r167.get(r172);
        int r231 = r11;
        if ((r174 instanceof h) == false) goto L33;
        h r175 = (h) r174;
        e.a[] r232 = r12;
        if (r175.f11929w0 != 1) goto L38;
        int r176 = r175.f11926t0;
        if (r176 == (-1)) goto L24;
    L31:
        r175.f11928v0.l(r176);
        r175.f11930x0 = true;
    L32:
        r171 = true;
        goto L38
    L24:
        if (r175.f11927u0 == (-1)) goto L29;
        if (A() == false) goto L29;
        r176 = q() - r175.f11927u0;
    L29:
        if (A() == false) goto L32;
        r176 = (int) ((r175.f11925s0 * q()) + 0.5f);
    L38:
        r172 = r172 + 1;
        r11 = r231;
        r17 = r230;
        r12 = r232;
        goto L15
    L33:
        r232 = r12;
        if ((r174 instanceof a) == false) goto L38;
        if (((a) r174).S() != 0) goto L38;
        r173 = true;
        goto L38
    L39:
        r20 = r11;
        r22 = r12;
        r21 = r17;
        if (r171 == false) goto L50;
        int r177 = 0;
    L42:
        if (r177 >= r168) goto L50;
        e r178 = r167.get(r177);
        if ((r178 instanceof h) == false) goto L49;
        h r179 = (h) r178;
        if (r179.f11929w0 != 1) goto L49;
        t.h.b(0, r179, r164, r170);
    L49:
        r177 = r177 + 1;
    L50:
        t.h.b(0, this, r164, r170);
        if (r173 == false) goto L63;
        int r180 = 0;
    L53:
        if (r180 >= r168) goto L63;
        e r181 = r167.get(r180);
        if ((r181 instanceof a) == false) goto L61;
        a r182 = (a) r181;
        if (r182.S() != 0) goto L61;
        if (r182.R() == false) goto L61;
        t.h.b(1, r182, r164, r170);
    L61:
        r180 = r180 + 1;
    L63:
        if (r166 != e.a.f11891a) goto L65;
        J(0, l());
    L66:
        boolean r183 = false;
        int r184 = 0;
        boolean r185 = false;
    L67:
        if (r184 >= r168) goto L92;
        e r186 = r167.get(r184);
        if ((r186 instanceof h) == false) goto L87;
        h r187 = (h) r186;
        if (r187.f11929w0 != 0) goto L91;
        int r188 = r187.f11926t0;
        if (r188 == (-1)) goto L76;
    L83:
        r187.f11928v0.l(r188);
        boolean r189 = true;
        r187.f11930x0 = true;
    L85:
        r183 = r189;
        goto L91
    L76:
        if (r187.f11927u0 == (-1)) goto L81;
        if (B() == false) goto L81;
        r188 = l() - r187.f11927u0;
    L81:
        if (B() == false) goto L84;
        r188 = (int) ((r187.f11925s0 * l()) + 0.5f);
        goto L83
    L84:
        r189 = true;
    L91:
        r184 = r184 + 1;
        goto L67
    L87:
        if ((r186 instanceof a) == false) goto L91;
        if (((a) r186).S() != 1) goto L91;
        r185 = true;
        goto L91
    L92:
        if (r183 == false) goto L101;
        int r190 = 0;
    L94:
        if (r190 >= r168) goto L101;
        e r191 = r167.get(r190);
        if ((r191 instanceof h) == false) goto L100;
        h r192 = (h) r191;
        if (r192.f11929w0 != 0) goto L100;
        t.h.g(1, r192, r164);
    L100:
        r190 = r190 + 1;
    L101:
        t.h.g(0, this, r164);
        if (r185 == false) goto L113;
        int r193 = 0;
    L104:
        if (r193 >= r168) goto L113;
        e r194 = r167.get(r193);
        if ((r194 instanceof a) == false) goto L112;
        a r195 = (a) r194;
        if (r195.S() != 1) goto L112;
        if (r195.R() == false) goto L112;
        t.h.g(1, r195, r164);
    L112:
        r193 = r193 + 1;
    L113:
        int r196 = 0;
    L114:
        if (r196 >= r168) goto L128;
        e r197 = r167.get(r196);
        if (r197.z() == false) goto L127;
        if (t.h.a(r197) == false) goto L127;
        U(r197, r164, t.h.f12181a);
        if ((r197 instanceof h) == true) goto L122;
        int r198 = 0;
        t.h.b(0, r197, r164, r170);
    L126:
        t.h.g(r198, r197, r164);
        goto L127
    L122:
        if (((h) r197).f11929w0 != 0) goto L124;
        r198 = 0;
        goto L126
    L124:
        t.h.b(0, r197, r164, r170);
    L127:
        r196 = r196 + 1;
        goto L114
    L128:
        int r199 = 0;
    L129:
        if (r199 >= r8) goto L153;
        e r200 = this.f11940s0.get(r199);
        if (r200.z() == false) goto L151;
        if ((r200 instanceof h) == true) goto L151;
        if ((r200 instanceof a) == true) goto L151;
        if ((r200 instanceof l) == true) goto L151;
        if (r200.H == true) goto L151;
        e.a r201 = r200.k(0);
        e.a r202 = r200.k(1);
        e.a r1100 = e.a.f11893m;
        if (r201 == r1100) goto L143;
    L148:
        boolean r203 = false;
    L149:
        if (r203 == true) goto L151;
        U(r200, this.f11899w0, new t.b.a());
        goto L151
    L143:
        if (r200.f11883s == 1) goto L148;
        if (r202 != r1100) goto L148;
        if (r200.f11884t == 1) goto L148;
        r203 = true;
    L151:
        r199 = r199 + 1;
        goto L129
    L65:
        r16.l(0);
        this.f11853c0 = 0;
        goto L66
    L12:
        r17.l(0);
        this.f11851b0 = 0;
        goto L13
    }

    public final void R(int r8, e r10) {
        if (r8 != 0) goto L8;
        int r11 = this.B0 + 1;
        c[] r12 = this.E0;
        if (r11 < r12.length) goto L7;
        this.E0 = (c[]) Arrays.copyOf(r12, r12.length * 2);
    L7:
        c[] r13 = this.E0;
        int r14 = this.B0;
        r13[r14] = new c(r10, 0, this.f11900x0);
        this.B0 = r14 + 1;
        return;
    L8:
        if (r8 != 1) goto L15;
        int r15 = this.C0 + 1;
        c[] r16 = this.D0;
        if (r15 < r16.length) goto L12;
        this.D0 = (c[]) Arrays.copyOf(r16, r16.length * 2);
    L12:
        c[] r17 = this.D0;
        int r18 = this.C0;
        r17[r18] = new c(r10, 1, this.f11900x0);
        this.C0 = r18 + 1;
        return;
    }

    public final void S(p.d r13) {
        boolean r8 = V(64);
        c(r13, r8);
        int r10 = this.f11940s0.size();
        int r11 = 0;
        boolean r12 = false;
    L4:
        if (r11 >= r10) goto L9;
        e r14 = this.f11940s0.get(r11);
        boolean[] r15 = r14.U;
        r15[0] = false;
        r15[1] = false;
        if ((r14 instanceof a) == false) goto L8;
        r12 = true;
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        if (r12 == false) goto L34;
        int r16 = 0;
    L11:
        if (r16 >= r10) goto L34;
        e r17 = this.f11940s0.get(r16);
        if ((r17 instanceof a) == false) goto L33;
        a r18 = (a) r17;
        int r19 = 0;
    L16:
        if (r19 >= r18.f11932t0) goto L33;
        e r20 = r18.f11931s0[r19];
        if (r18.f11810v0 == false) goto L20;
    L22:
        int r21 = r18.f11809u0;
        if (r21 == 0) goto L31;
        if (r21 == 1) goto L31;
        if (r21 != 2) goto L29;
    L30:
        r20.U[1] = true;
    L32:
        r19 = r19 + 1;
        goto L16
    L29:
        if (r21 != 3) goto L32;
    L31:
        r20.U[0] = true;
        goto L32
    L20:
        if (r20.d() == true) goto L22;
    L33:
        r16 = r16 + 1;
    L34:
        HashSet<e> r22 = this.M0;
        r22.clear();
        int r23 = 0;
    L35:
        if (r23 >= r10) goto L50;
        e r24 = this.f11940s0.get(r23);
        r24.getClass();
        if ((r24 instanceof l) == false) goto L39;
    L42:
        boolean r25 = true;
    L43:
        if (r25 == false) goto L48;
        if ((r24 instanceof l) == false) goto L47;
        r22.add(r24);
        goto L48
    L47:
        r24.c(r13, r8);
    L48:
        r23 = r23 + 1;
        goto L35
    L39:
        if ((r24 instanceof h) == true) goto L42;
        r25 = false;
    L50:
        if (r22.size() <= 0) goto L72;
        int r26 = r22.size();
        Iterator<e> r27 = r22.iterator();
    L53:
        if (r27.hasNext() == false) goto L65;
        l r28 = (l) r27.next();
        int r29 = 0;
    L56:
        if (r29 >= r28.f11932t0) goto L61;
        if (r22.contains(r28.f11931s0[r29]) == true) goto L59;
        r29 = r29 + 1;
        goto L56
    L59:
        boolean r30 = true;
    L62:
        if (r30 == false) goto L53;
        r28.c(r13, r8);
        r22.remove(r28);
        goto L65
    L61:
        r30 = false;
    L65:
        if (r26 != r22.size()) goto L50;
        Iterator<e> r31 = r22.iterator();
    L68:
        if (r31.hasNext() == false) goto L70;
        r31.next().c(r13, r8);
        goto L68
    L70:
        r22.clear();
        goto L50
    L72:
        if (p.d.f9870q == false) goto L93;
        HashSet<e> r32 = new HashSet();
        int r33 = 0;
    L74:
        if (r33 >= r10) goto L86;
        e r34 = this.f11940s0.get(r33);
        r34.getClass();
        if ((r34 instanceof l) == false) goto L78;
    L81:
        boolean r35 = true;
    L82:
        if (r35 == true) goto L84;
        r32.add(r34);
    L84:
        r33 = r33 + 1;
        goto L74
    L78:
        if ((r34 instanceof h) == true) goto L81;
        r35 = false;
        goto L82
    L86:
        if (this.V[0] != e.a.f11892b) goto L88;
        int r110 = 0;
    L89:
        b(this, r13, r32, r110, false);
        Iterator<e> r36 = r32.iterator();
    L91:
        if (r36.hasNext() == false) goto L118;
        e r37 = r36.next();
        k.a(this, r13, r37);
        r37.c(r13, r8);
    L118:
        if (this.B0 <= 0) goto L121;
        b.a(this, r13, null, 0);
    L121:
        if (this.C0 <= 0) goto L160;
        b.a(this, r13, null, 1);
        return;
    L160:
        return;
    L88:
        r110 = 1;
        goto L89
    L93:
        int r38 = 0;
    L94:
        if (r38 >= r10) goto L118;
        e r39 = this.f11940s0.get(r38);
        if ((r39 instanceof f) == false) goto L107;
        e.a[] r40 = r39.V;
        e.a r41 = r40[0];
        e.a r42 = r40[1];
        e.a r43 = e.a.f11892b;
        if (r41 != r43) goto L100;
        r39.L(e.a.f11891a);
    L100:
        if (r42 != r43) goto L102;
        r39.M(e.a.f11891a);
    L102:
        r39.c(r13, r8);
        if (r41 != r43) goto L105;
        r39.L(r41);
    L105:
        if (r42 != r43) goto L116;
        r39.M(r42);
    L116:
        r38 = r38 + 1;
        goto L94
    L107:
        k.a(this, r13, r39);
        if ((r39 instanceof l) == false) goto L110;
    L113:
        boolean r44 = true;
    L114:
        if (r44 == true) goto L116;
        r39.c(r13, r8);
        goto L116
    L110:
        if ((r39 instanceof h) == true) goto L113;
        r44 = false;
        goto L114
    }

    public final boolean T(int r12, boolean r13) {
        boolean r8 = true;
        boolean r14 = r13 & true;
        t.e r11 = this.f11897u0;
        f r10 = r11.f12151a;
        e.a r15 = r10.k(0);
        e.a r16 = r10.k(1);
        int r17 = r10.r();
        int r18 = r10.s();
        ArrayList<p> r19 = r11.f12155e;
        if (r14 == false) goto L25;
        e.a r20 = e.a.f11892b;
        if (r15 == r20) goto L7;
        if (r16 != r20) goto L25;
    L7:
        Iterator<p> r21 = r19.iterator();
    L9:
        if (r21.hasNext() == false) goto L15;
        p r22 = r21.next();
        if (r22.f12198f != r12) goto L9;
        if (r22.k() == true) goto L9;
        r14 = false;
    L15:
        if (r12 != 0) goto L20;
        if (r14 == false) goto L25;
        if (r15 != e.a.f11892b) goto L25;
        r10.L(e.a.f11891a);
        r10.N(r11.d(r10, 0));
        t.g r110 = r10.f11854d.f12197e;
        int r23 = r10.q();
    L24:
        r110.d(r23);
        goto L25
    L20:
        if (r14 == false) goto L25;
        if (r16 != e.a.f11892b) goto L25;
        r10.M(e.a.f11891a);
        r10.K(r11.d(r10, 1));
        r110 = r10.f11855e.f12197e;
        r23 = r10.l();
    L25:
        e.a[] r111 = r10.V;
        if (r12 != 0) goto L32;
        e.a r112 = r111[0];
        if (r112 != e.a.f11891a) goto L30;
    L31:
        int r113 = r10.q() + r17;
        r10.f11854d.f12201i.d(r113);
        r10.f11854d.f12197e.d(r113 - r17);
    L39:
        boolean r114 = true;
    L40:
        r11.g();
        Iterator<p> r115 = r19.iterator();
    L42:
        if (r115.hasNext() == false) goto L52;
        p r24 = r115.next();
        if (r24.f12198f != r12) goto L42;
        if (r24.f12194b != r10) goto L51;
        if (r24.f12199g == false) goto L42;
    L51:
        r24.e();
        goto L42
    L52:
        Iterator<p> r116 = r19.iterator();
    L54:
        if (r116.hasNext() == false) goto L73;
        p r25 = r116.next();
        if (r25.f12198f != r12) goto L54;
        if (r114 == true) goto L63;
        if (r25.f12194b == r10) goto L54;
    L63:
        if (r25.f12200h.f12168j == false) goto L72;
        if (r25.f12201i.f12168j == false) goto L72;
        if ((r25 instanceof t.c) == true) goto L54;
        if (r25.f12197e.f12168j == true) goto L54;
    L72:
        r8 = false;
    L73:
        r10.L(r15);
        r10.M(r16);
        return r8;
    L30:
        if (r112 == e.a.f11894n) goto L31;
    L37:
        r114 = false;
        goto L40
    L32:
        e.a r117 = r111[1];
        if (r117 != e.a.f11891a) goto L35;
    L38:
        int r118 = r10.l() + r18;
        r10.f11855e.f12201i.d(r118);
        r10.f11855e.f12197e.d(r118 - r18);
        goto L39
    L35:
        if (r117 != e.a.f11894n) goto L37;
        goto L37
    }

    public final boolean V(int r8) {
        if ((this.F0 & r8) != r8) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // s.e
    public final void n(StringBuilder r8) {
        r8.append(this.f11867k + ":{\n");
        StringBuilder r10 = new StringBuilder("  actualWidth:");
        r10.append(this.X);
        r8.append(r10.toString());
        r8.append("\n");
        r8.append("  actualHeight:" + this.Y);
        r8.append("\n");
        Iterator<e> r11 = this.f11940s0.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().n(r8);
        r8.append(",\n");
        goto L4
    L6:
        r8.append("}");
    }
}
