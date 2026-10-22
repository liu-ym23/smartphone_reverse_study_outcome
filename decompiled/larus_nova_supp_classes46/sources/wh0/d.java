package wh0;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfigKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import ti6.f;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public List<m.d> a;
    public final tc0.b b;
    public final g c;
    public final cg6.a d;
    public final b e;
    public final bn0.b f;
    public m g;

    public static final class a {
    }

    static {
    }

    public static List a(m r6) {
        List<m.d> r0 = r6.h();
        if (r0 == null) goto L8;
        List<m.d> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        r2.add(((m.d) r3.next()).a());
    L10:
        if (r6.getUiLayout() != 7) goto L12;
    L17:
        if (r2 == null) goto L24;
        Iterator r7 = r2.iterator();
    L20:
        if (r7.hasNext() == false) goto L24;
        m.d r4 = (m.d) r7.next();
        if (r4.c() <= 0) goto L20;
        r4.l(r4.f() - ((double) 41));
    L24:
        return r2;
    L12:
        if (r6.getUiLayout() == 110) goto L17;
        if (r6.getUiLayout() == 109) goto L17;
        if (r6.getUiLayout() != 111) goto L24;
    L8:
        r2 = null;
        goto L10
    }

    public final Pair<Double, Double> b(m.d r9) {
        m.c r0 = this.g.d();
        m.a r1 = this.g.c();
        if (r9 == null) goto L8;
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        return new Pair(Double.valueOf(r9.e() / ((double) r1.f())), Double.valueOf((r9.f() + ((double) r0.e())) / ((double) r1.d())));
    L8:
        double r2 = 0.0f;
        return new Pair(Double.valueOf(r2), Double.valueOf(r2));
    }

    public final Pair<Double, Double> c(m.d r8) {
        m.a r0 = this.g.c();
        if (r0 == null) goto L7;
        if (r8 == null) goto L7;
        return new Pair(Double.valueOf(r8.d() / ((double) r0.f())), Double.valueOf(r8.b() / ((double) r0.d())));
    L7:
        double r1 = 0.0f;
        return new Pair(Double.valueOf(r1), Double.valueOf(r1));
    }

    public final boolean d(String r2) {
        if (this.e.o(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (e(r2) == false) goto L7;
        return true;
    }

    public final boolean e(String r3) {
        if (ILiveLinkCameraBackUpConfigKt.supportMixStreamOpt(vm2.g.c()) == false) goto L5;
    L10:
        int r4 = this.e.l(r3);
        if (r4 != 1) goto L13;
        return true;
    L13:
        if (r4 == 3) goto L18;
        return false;
    L18:
        return true;
    L5:
        if (this.e.currentIsMultipleKtvMode() == true) goto L10;
        if (this.e.currentIsAudienceSingEnable() == true) goto L10;
        return true;
    }

    public d(com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c.b r2, bn0.b r3, m r4) {
        Intrinsics.checkNotNullParameter(r2, "hostService");
        Intrinsics.checkNotNullParameter(r4, "layoutConfig");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        cg6.a r5 = null;
        if (r3 == null) goto L5;
        KClass r6 = Reflection.getOrCreateKotlinClass(tc0.b.class);
        com.bytedance.android.scope.m.e.getClass();
        tc0.b r7 = (tc0.b) com.bytedance.android.scope.m.b(r3).a(r6);
    L6:
        this.b = r7;
        if (r3 == null) goto L9;
        KClass r8 = Reflection.getOrCreateKotlinClass(g.class);
        com.bytedance.android.scope.m.e.getClass();
        g r9 = (g) com.bytedance.android.scope.m.b(r3).a(r8);
    L10:
        this.c = r9;
        if (r3 == null) goto L13;
        KClass r10 = Reflection.getOrCreateKotlinClass(cg6.a.class);
        com.bytedance.android.scope.m.e.getClass();
        r5 = (cg6.a) com.bytedance.android.scope.m.b(r3).a(r10);
    L13:
        this.d = r5;
        this.a = a(this.g);
        return;
    L9:
        r9 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }

    public final void f(List<f> r13, Map<String, Integer> r14, wh0.a r15) {
        Iterator<f> r0 = r13.iterator();
    L3:
        boolean r2 = false;
        m.d r4 = null;
        Object r5 = null;
        m.d r6 = null;
        Object r7 = null;
        if (r0.hasNext() == false) goto L48;
        f r1 = r0.next();
        if (r15.a(r1.b) == false) goto L14;
        String r8 = r1.b;
        tc0.b r9 = this.b;
        if (r9 == null) goto L10;
        String r10 = r9.Vd();
    L12:
        if (Intrinsics.areEqual(r8, r10) == false) goto L14;
        boolean r11 = e(r1.b);
    L15:
        int r12 = r15.b(r1.b);
        r1.n = !r11;
        if (r12 >= 0) goto L17;
        r0.remove();
        goto L3
    L17:
        r14.put(r1.b, Integer.valueOf(r12));
        List<m.d> r16 = this.g.h();
        if (r16 == null) goto L29;
        Iterator<T> r17 = r16.iterator();
    L21:
        if (r17.hasNext() == false) goto L28;
        Object r18 = r17.next();
        if (((m.d) r18).c() != r12) goto L25;
        boolean r19 = true;
    L26:
        if (r19 == false) goto L21;
        r5 = r18;
        goto L28
    L25:
        r19 = false;
    L28:
        r6 = (m.d) r5;
    L29:
        String r3 = this.e.i(r1.b);
        if (r3 != null) goto L32;
        r3 = "";
    L32:
        if (r6 == null) goto L46;
        Pair<Double, Double> r20 = c(r6);
        Pair<Double, Double> r21 = b(r6);
        double r22 = ((Number) r20.getFirst()).doubleValue();
        double r110 = ((Number) r20.getSecond()).doubleValue();
        r1.f = r22;
        r1.g = r110;
        double r23 = 1.0d;
        if (r11 == false) goto L36;
        double r24 = ((Number) r21.getFirst()).doubleValue();
    L37:
        if (r11 == false) goto L39;
        r23 = ((Number) r21.getSecond()).doubleValue();
    L39:
        r1.d = r24;
        r1.e = r23;
        if (r11 == false) goto L42;
        int r25 = 1;
    L43:
        r1.a = r25;
        r1.c(r3);
        r1.l = true;
        if (r15.a(r1.b) == false) goto L46;
        this.e.j(r1);
        goto L46
    L42:
        r25 = 2;
        goto L43
    L36:
        r24 = 1.0d;
    L46:
        b r26 = this.e;
        this.g.getClass();
        r26.n(r1, r12);
        goto L3
    L10:
        r10 = null;
    L14:
        r11 = d(r1.b);
        goto L15
    L48:
        Iterator<T> r111 = r13.iterator();
    L50:
        if (r111.hasNext() == false) goto L52;
        this.e.d((f) r111.next());
        goto L50
    L52:
        int r112 = qi0.f.a;
        if (this.g.getUiLayout() != 16) goto L55;
        int r113 = 8;
    L56:
        List<m.d> r114 = this.g.h();
        if (r114 == null) goto L68;
        Iterator<T> r115 = r114.iterator();
    L60:
        if (r115.hasNext() == false) goto L67;
        Object r27 = r115.next();
        if (((m.d) r27).c() != r113) goto L64;
        boolean r28 = true;
    L65:
        if (r28 == false) goto L60;
        r7 = r27;
        goto L67
    L64:
        r28 = false;
    L67:
        r4 = (m.d) r7;
    L68:
        Pair<Double, Double> r116 = c(r4);
        Pair<Double, Double> r117 = b(r4);
        f r29 = new f();
        r29.a = 1;
        double r30 = ((Number) r116.getFirst()).doubleValue();
        double r31 = ((Number) r116.getSecond()).doubleValue();
        r29.f = r30;
        r29.g = r31;
        double r32 = ((Number) r117.getFirst()).doubleValue();
        double r118 = ((Number) r117.getSecond()).doubleValue();
        r29.d = r32;
        r29.e = r118;
        r29.l = false;
        r29.o = 0;
        int r119 = e.a;
        if (e.a(Integer.valueOf(this.g.m()), Integer.valueOf(this.g.getUiLayout())) == false) goto L72;
        this.e.b(r13, r29);
        return;
    L72:
        if (e.b(Integer.valueOf(this.g.m()), Integer.valueOf(this.g.getUiLayout())) == false) goto L74;
        this.e.a(r13, r29);
        return;
    L74:
        Integer r120 = Integer.valueOf(this.g.m());
        Integer r121 = Integer.valueOf(this.g.getUiLayout());
        if (r121 != null) goto L78;
    L80:
        if (r120 != null) goto L83;
    L85:
        if (r2 == false) goto L107;
        this.e.k(r13, r29);
        return;
    L107:
        return;
    L83:
        if (r120.intValue() != 37) goto L85;
    L79:
        r2 = true;
        goto L85
    L78:
        if (r121.intValue() != 65) goto L80;
    L55:
        r113 = 0;
        goto L56
    }

    public final void g(List<f> r17, Map<String, Integer> r18, Map<String, ? extends Object> r19, wh0.a r20) {
        Iterator<f> r3 = r17.iterator();
    L4:
        if (r3.hasNext() == false) goto L48;
        f r4 = r3.next();
        boolean r5 = d(r4.b);
        int r6 = r20.b(r4.b);
        r4.n = !r5;
        if (aj0.b.a(r20.b(r4.b), this.g.getUiLayout()) == false) goto L9;
        r4.A = true;
    L9:
        if (r6 < 0) goto L43;
        r18.put(r4.b, Integer.valueOf(r6));
        List<m.d> r12 = this.a;
        if (r12 == null) goto L23;
        Iterator<T> r13 = r12.iterator();
    L14:
        if (r13.hasNext() == false) goto L21;
        Object r14 = r13.next();
        if (((m.d) r14).c() != r6) goto L18;
        boolean r15 = true;
    L19:
        if (r15 == false) goto L14;
    L22:
        m.d r16 = (m.d) r14;
    L24:
        String r7 = this.e.i(r4.b);
        if (r7 != null) goto L27;
        r7 = "";
    L27:
        if (r16 == null) goto L42;
        Pair<Double, Double> r110 = c(r16);
        Pair<Double, Double> r111 = b(r16);
        double r9 = ((Number) r110.getFirst()).doubleValue();
        double r11 = ((Number) r110.getSecond()).doubleValue();
        r4.f = r9;
        r4.g = r11;
        if (r5 == false) goto L31;
        double r10 = ((Number) r111.getFirst()).doubleValue();
    L32:
        if (r5 == false) goto L34;
        double r112 = ((Number) r111.getSecond()).doubleValue();
    L35:
        r4.d = r10;
        r4.e = r112;
        if (r5 == false) goto L38;
        int r8 = 1;
    L39:
        r4.a = r8;
        r4.c(r7);
        r4.l = true;
        if (r20.a(r4.b) == false) goto L42;
        this.e.j(r4);
        goto L42
    L38:
        r8 = 2;
        goto L39
    L34:
        r112 = 1.0d;
        goto L35
    L31:
        r10 = 1.0d;
    L42:
        b r21 = this.e;
        this.g.getClass();
        r21.n(r4, r6);
    L44:
        if (r19 == null) goto L46;
        Object r22 = r19.get("mcu_client_mix");
    L47:
        Intrinsics.areEqual(r22, Boolean.TRUE);
        this.e.p(r4);
        goto L4
    L46:
        r22 = null;
        goto L47
    L18:
        r15 = false;
        goto L19
    L21:
        r14 = null;
        goto L22
    L23:
        r16 = null;
        goto L24
    L43:
        r4.f = 0.1d;
        r4.g = 0.1d;
        r4.d = 1.0d;
        r4.e = 1.0d;
        r4.l = false;
        goto L44
    }
}
