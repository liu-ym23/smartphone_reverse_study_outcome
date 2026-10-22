package ah0;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static m a(LayoutConfigModel r9) {
        Intrinsics.checkNotNullParameter(r9, "layoutConfigModel");
        m r0 = new m();
        r0.z(r9.k());
        r0.F(r9.q());
        r0.w(r9.g());
        r0.x(r9.h());
        r0.D(r9.o());
        r0.C(r9.n());
        r0.B(r9.m());
        r0.E(new m.f());
        m.f r1 = r0.t();
        int r2 = 0;
        if (r1 == null) goto L21;
        LayoutConfigModel.g r3 = r9.p();
        if (r3 == null) goto L7;
        int r4 = r3.c();
    L8:
        r1.g(r4);
        LayoutConfigModel.g r5 = r9.p();
        if (r5 == null) goto L11;
        int r6 = r5.e();
    L12:
        r1.i(r6);
        LayoutConfigModel.g r7 = r9.p();
        if (r7 == null) goto L15;
        int r8 = r7.d();
    L16:
        r1.h(r8);
        LayoutConfigModel.g r10 = r9.p();
        if (r10 == null) goto L19;
        int r11 = r10.b();
    L20:
        r1.f(r11);
        goto L21
    L19:
        r11 = 0;
        goto L20
    L15:
        r8 = 0;
        goto L16
    L11:
        r6 = 0;
        goto L12
    L7:
        r4 = 0;
    L21:
        r0.u(new m.a());
        m.a r12 = r0.c();
        if (r12 == null) goto L37;
        LayoutConfigModel.b r13 = r9.e();
        if (r13 == null) goto L26;
        int r14 = r13.d();
    L27:
        r12.k(r14);
        LayoutConfigModel.b r15 = r9.e();
        if (r15 == null) goto L30;
        int r16 = r15.c();
    L31:
        r12.i(r16);
        r12.j(r9.j());
        r12.g(r9.d());
        LayoutConfigModel.b r17 = r9.e();
        if (r17 == null) goto L35;
        String r18 = r17.b();
        if (r18 == null) goto L35;
    L36:
        r12.h(r18);
    L35:
        r18 = "#322542";
        goto L36
    L30:
        r16 = 0;
        goto L31
    L26:
        r14 = 0;
    L37:
        r0.v(new m.c());
        m.c r19 = r0.d();
        if (r19 == null) goto L55;
        LayoutConfigModel.d r20 = r9.f();
        if (r20 == null) goto L42;
        int r21 = (int) r20.d();
    L43:
        r19.h(r21);
        LayoutConfigModel.d r22 = r9.f();
        if (r22 == null) goto L46;
        int r23 = (int) r22.e();
    L47:
        r19.i(r23);
        LayoutConfigModel.d r24 = r9.f();
        if (r24 == null) goto L50;
        int r25 = r24.c();
    L51:
        r19.g(r25);
        LayoutConfigModel.d r26 = r9.f();
        if (r26 == null) goto L54;
        r2 = r26.b();
    L54:
        r19.f(r2);
        goto L55
    L50:
        r25 = 0;
        goto L51
    L46:
        r23 = 0;
        goto L47
    L42:
        r21 = 0;
    L55:
        List<LayoutConfigModel.e> r27 = r9.i();
        ArrayList r28 = null;
        if (r27 == null) goto L61;
        List<LayoutConfigModel.e> r29 = r27;
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));
        Iterator<T> r31 = r29.iterator();
    L59:
        if (r31.hasNext() == false) goto L62;
        LayoutConfigModel.e r32 = (LayoutConfigModel.e) r31.next();
        m.d r33 = new m.d();
        r33.m(r32.g());
        r33.i(r32.c());
        r33.k(r32.e());
        r33.l(r32.f());
        r33.j(r32.d());
        r33.h(r32.b());
        r30.add(r33);
    L62:
        r0.y(r30);
        List<LayoutConfigModel.f> r34 = r9.l();
        if (r34 == null) goto L68;
        List<LayoutConfigModel.f> r35 = r34;
        r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10));
        Iterator<T> r36 = r35.iterator();
    L66:
        if (r36.hasNext() == false) goto L68;
        LayoutConfigModel.f r37 = (LayoutConfigModel.f) r36.next();
        m.e r38 = new m.e();
        r38.m(r37.g());
        r38.i(r37.c());
        r38.k(r37.e());
        r38.l(r37.f());
        r38.j(r37.d());
        r38.h(r37.b());
        r28.add(r38);
    L68:
        r0.A(r28);
        return r0;
    L61:
        r30 = null;
        goto L62
    }
}
