package yg0;

import android.content.Context;
import android.util.Log;
import androidx.core.util.Preconditions;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.k;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.n;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.t;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public static ln0.a a;
    public static List<Integer> b;

    public h() {
    }

    static {
        zg0.a r0 = new zg0.a();
        int r1 = ln0.b.a.g;
        Context r2 = s1.getContext();
        Intrinsics.checkNotNullParameter(r2, "context");
        ln0.b.a r3 = new ln0.b.a(r2);
        Intrinsics.checkNotNullParameter("/dynamicconfigv2/multilink/", "geckoAccessKey");
        r3.b = "/dynamicconfigv2/multilink/";
        Intrinsics.checkNotNullParameter("dynamicconfigv2/multilink/", "assetsAccessKey");
        r3.a = "dynamicconfigv2/multilink/";
        pn0.b r4 = new pn0.b(vm2.d.M0().f(), vm2.d.M0().d(), vm2.d.M0().a(), vm2.d.M0().b(), vm2.d.M0().e());
        Intrinsics.checkNotNullParameter(r4, "setting");
        r3.c = r4;
        b r5 = new b(r0);
        Intrinsics.checkNotNullParameter(r5, "geckoResProvider");
        r3.d = r5;
        c r6 = new c();
        Intrinsics.checkNotNullParameter(r6, "monitorProvider");
        r3.e = r6;
        ln0.b r7 = new ln0.b(r3);
        int r8 = ln0.a.c;
        Intrinsics.checkNotNullParameter(r7, "layoutCoreConfig");
        a = new ln0.a(r7);
    }

    public static Pair c(zj0.c r4) {
        if ((r4 instanceof zj0.c.C0300c) == true) goto L5;
        zj0.c r0 = null;
    L6:
        zj0.c.C0300c r1 = (zj0.c.C0300c) r0;
        if (r1 == null) goto L9;
        int r2 = r1.b;
        int r3 = r1.c;
    L11:
        if ((r4 instanceof zj0.c.b) == true) goto L13;
        zj0.c r5 = null;
    L14:
        zj0.c.b r6 = (zj0.c.b) r5;
        if (r6 == null) goto L18;
        r2 = r6.b;
        r3 = r6.c;
    L18:
        if ((r4 instanceof zj0.c.a) == true) goto L20;
        zj0.c r7 = null;
    L21:
        zj0.c.a r8 = (zj0.c.a) r7;
        if (r8 == null) goto L25;
        r2 = r8.b;
        r3 = r8.c;
    L25:
        if ((r4 instanceof zj0.c.e) == true) goto L27;
        zj0.c r9 = null;
    L28:
        zj0.c.e r10 = (zj0.c.e) r9;
        if (r10 == null) goto L34;
        r2 = r10.b.getSubScene();
        r3 = r10.b.getUiLayout();
        if (r3 > 0) goto L34;
        r3 = e(r10.b.getVersion());
    L34:
        if ((r4 instanceof zj0.c.d) == true) goto L36;
        zj0.c r11 = null;
    L37:
        zj0.c.d r12 = (zj0.c.d) r11;
        if (r12 == null) goto L41;
        r2 = r12.b;
        r3 = r12.c;
    L41:
        if ((r4 instanceof zj0.c.f) == true) goto L43;
        r4 = null;
    L43:
        zj0.c.f r13 = (zj0.c.f) r4;
        if (r13 == null) goto L47;
        r2 = r13.b;
        r3 = r13.c;
    L47:
        return new Pair(Integer.valueOf(r2), Integer.valueOf(r3));
    L36:
        r11 = r4;
        goto L37
    L27:
        r9 = r4;
        goto L28
    L20:
        r7 = r4;
        goto L21
    L13:
        r5 = r4;
        goto L14
    L9:
        r2 = 0;
        r3 = 0;
        goto L11
    L5:
        r0 = r4;
        goto L6
    }

    public static int d(int r2) {
        if (r2 != 21) goto L5;
    L50:
        return 3;
    L5:
        if (r2 == 22) goto L50;
        if (r2 != 51) goto L9;
        return 17;
    L9:
        if (r2 == 61) goto L46;
        if (r2 != 65) goto L13;
        return 37;
    L13:
        if (r2 != 67) goto L15;
        return 39;
    L15:
        if (r2 != 113) goto L17;
    L42:
        return 30;
    L17:
        if (r2 == 1000) goto L50;
        if (r2 != 102) goto L21;
    L41:
        return 11;
    L21:
        if (r2 == 103) goto L41;
        switch(r2) {
            case 1: goto L33;
            case 2: goto L41;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L27;
            default: goto L23;
        };
    L23:
        switch(r2) {
            case 11: goto L37;
            case 12: goto L52;
            case 13: goto L36;
            case 14: goto L35;
            case 15: goto L42;
            case 16: goto L34;
            default: goto L24;
        };
    L24:
        switch(r2) {
            case 26: goto L50;
            case 27: goto L50;
            case 28: goto L50;
            case 29: goto L50;
            case 30: goto L50;
            default: goto L25;
        };
    L25:
        switch(r2) {
            case 56: goto L40;
            case 57: goto L39;
            case 58: goto L38;
            default: goto L48;
        };
    L38:
        return 33;
    L39:
        return 32;
    L40:
        return 31;
    L48:
        return 0;
    L34:
        return 35;
    L35:
        return 24;
    L36:
        return 23;
    L37:
        return 20;
    L52:
        return 21;
    L27:
        return 8;
    L28:
        return 15;
    L29:
        return 12;
    L30:
        return 9;
    L31:
        return 16;
    L32:
        return 13;
    L33:
        return 10;
    L46:
        if (KtvSettingHelper.w() == false) goto L48;
        goto L48
    }

    public static int e(int r3) {
        if (r3 != 15) goto L5;
        return 7;
    L5:
        if (r3 != 16) goto L7;
        return 4;
    L7:
        if (r3 != 20) goto L9;
        return 11;
    L9:
        if (r3 != 21) goto L11;
        return 12;
    L11:
        if (r3 != 23) goto L13;
        return 13;
    L13:
        if (r3 != 24) goto L15;
        return 14;
    L15:
        if (r3 != 30) goto L17;
        return 15;
    L17:
        if (r3 != 35) goto L19;
        return 16;
    L19:
        if (r3 == 37) goto L31;
        switch(r3) {
            case 8: goto L29;
            case 9: goto L28;
            case 10: goto L27;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            default: goto L22;
        };
    L24:
        return 3;
    L25:
        return 6;
    L26:
        return 2;
    L27:
        return 1;
    L28:
        return 5;
    L29:
        return 8;
    L22:
        if (aj0.b.b(Integer.valueOf(r3)) == false) goto L30;
        return 51;
    L30:
        return 0;
    L31:
        return 65;
    }

    public static boolean i(int r3) {
        if (((List) vm2.e.W.getValue(null, vm2.e.a[47])).contains(String.valueOf(r3)) == true) goto L6;
        return false;
    L6:
        return true;
    }

    public static boolean j(int r0, int r1) {
        if (r1 > 0) goto L5;
        r1 = e(r0);
    L5:
        return i(r1);
    }

    public static pn0.f a(m r9, Triple r10, Pair r11) {
        Intrinsics.checkNotNullParameter(r9, "layoutConfig");
        Intrinsics.checkNotNullParameter(r10, "absContainerWHAndReason");
        Intrinsics.checkNotNullParameter(r11, "livePlayerVideoSize");
        int r1 = ah0.a.a;
        Intrinsics.checkNotNullParameter(r9, "layoutConfig");
        LayoutConfigModel r0 = new LayoutConfigModel();
        r0.z(r9.j());
        r0.F(r9.getUiLayout());
        r0.v(r9.f());
        r0.w(r9.g());
        r0.D(r9.n());
        r0.C(r9.m());
        r0.B(r9.l());
        r0.r();
        m.a r2 = r9.c();
        if (r2 == null) goto L5;
        int r3 = r2.e();
    L6:
        r0.y(r3);
        m.a r4 = r9.c();
        if (r4 == null) goto L9;
        int r5 = r4.b();
    L10:
        r0.s(r5);
        r0.E(new LayoutConfigModel.g());
        LayoutConfigModel.g r6 = r0.p();
        int r7 = 0;
        if (r6 == null) goto L29;
        m.f r8 = r9.t();
        if (r8 == null) goto L15;
        int r12 = r8.c();
    L16:
        r6.g(r12);
        m.f r13 = r9.t();
        if (r13 == null) goto L19;
        int r14 = r13.e();
    L20:
        r6.i(r14);
        m.f r15 = r9.t();
        if (r15 == null) goto L23;
        int r16 = r15.d();
    L24:
        r6.h(r16);
        m.f r17 = r9.t();
        if (r17 == null) goto L27;
        int r18 = r17.b();
    L28:
        r6.f(r18);
        goto L29
    L27:
        r18 = 0;
        goto L28
    L23:
        r16 = 0;
        goto L24
    L19:
        r14 = 0;
        goto L20
    L15:
        r12 = 0;
    L29:
        r0.t(new LayoutConfigModel.b());
        LayoutConfigModel.b r19 = r0.e();
        if (r19 == null) goto L45;
        m.a r20 = r9.c();
        if (r20 == null) goto L34;
        int r21 = r20.f();
    L35:
        r19.g(r21);
        m.a r22 = r9.c();
        if (r22 == null) goto L38;
        int r23 = r22.d();
    L39:
        r19.f(r23);
        m.a r24 = r9.c();
        if (r24 == null) goto L43;
        String r25 = r24.c();
        if (r25 == null) goto L43;
    L44:
        r19.e(r25);
    L43:
        r25 = "#322542";
        goto L44
    L38:
        r23 = 0;
        goto L39
    L34:
        r21 = 0;
    L45:
        r0.u(new LayoutConfigModel.d());
        LayoutConfigModel.d r26 = r0.f();
        if (r26 == null) goto L62;
        m.c r27 = r9.d();
        double r28 = 0.0d;
        if (r27 == null) goto L50;
        double r29 = r27.d();
    L51:
        r26.h(r29);
        m.c r30 = r9.d();
        if (r30 == null) goto L54;
        r28 = r30.e();
    L54:
        r26.i(r28);
        m.c r31 = r9.d();
        if (r31 == null) goto L57;
        int r32 = r31.c();
    L58:
        r26.g(r32);
        m.c r33 = r9.d();
        if (r33 == null) goto L61;
        r7 = r33.b();
    L61:
        r26.f(r7);
        goto L62
    L57:
        r32 = 0;
        goto L58
    L50:
        r29 = 0.0d;
    L62:
        List<m.d> r34 = r9.h();
        ArrayList r35 = null;
        if (r34 == null) goto L68;
        List<m.d> r36 = r34;
        ArrayList r37 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r36, 10));
        Iterator<T> r38 = r36.iterator();
    L66:
        if (r38.hasNext() == false) goto L69;
        m.d r39 = (m.d) r38.next();
        LayoutConfigModel.e r40 = new LayoutConfigModel.e();
        r40.m(r39.g());
        r40.i(r39.c());
        r40.k(r39.e());
        r40.l(r39.f());
        r40.j(r39.d());
        r40.h(r39.b());
        r37.add(r40);
    L69:
        r0.x(r37);
        List<m.e> r41 = r9.k();
        if (r41 == null) goto L75;
        List<m.e> r42 = r41;
        r35 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r42, 10));
        Iterator<T> r43 = r42.iterator();
    L73:
        if (r43.hasNext() == false) goto L75;
        m.e r44 = (m.e) r43.next();
        LayoutConfigModel.f r45 = new LayoutConfigModel.f();
        r45.m(r44.g());
        r45.i(r44.c());
        r45.k(r44.e());
        r45.l(r44.f());
        r45.j(r44.d());
        r45.h(r44.b());
        r35.add(r45);
    L75:
        r0.A(r35);
        return b(r0, r10, r11);
    L68:
        r37 = null;
        goto L69
    L9:
        r5 = 8;
        goto L10
    L5:
        r3 = 1;
        goto L6
    }

    public static pn0.f b(LayoutConfigModel r23, Triple r24, Pair r25) {
        if (((Number) r24.getFirst()).intValue() != 0) goto L5;
    L6:
        ((Number) r24.getFirst()).intValue();
        ((Number) r24.getSecond()).intValue();
        Log.getStackTraceString(new Exception());
    L7:
        LayoutConfigModel.b r0 = r23.e();
        if (r0 != null) goto L10;
    L16:
        boolean r1 = false;
    L17:
        boolean r3 = Intrinsics.areEqual((String) vm2.e.k().get(String.valueOf(((Number) r25.getSecond()).intValue())), String.valueOf(((Number) r25.getFirst()).intValue()));
        if (r1 == false) goto L23;
        if (r3 == false) goto L23;
        if (vm2.d.P0() == false) goto L23;
        boolean r2 = true;
    L24:
        ln0.a r4 = a;
        if (r4 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("newLayoutConfigManager");
    L27:
        Triple r5 = new Triple(Boolean.valueOf(r2), r25.getFirst(), r25.getSecond());
        if (r23.q() != 30) goto L30;
        boolean r6 = true;
    L31:
        mn0.a r15 = new mn0.a(r5, r6);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r24, "absContainerWHAndReason");
        Intrinsics.checkNotNullParameter(r23, "layoutConfig");
        Intrinsics.checkNotNullParameter(r15, "configParams");
        mn0.b r7 = new mn0.b(r24, r23.b(), r23.j(), r23.d(), (LayoutConfigModel.g) Preconditions.checkNotNull(r23.p()), (LayoutConfigModel.b) Preconditions.checkNotNull(r23.e()), (LayoutConfigModel.d) Preconditions.checkNotNull(r23.f()), (List) Preconditions.checkNotNull(r23.i()), r4.b.e, r15);
        Pair r8 = new Pair(r7.a.getFirst(), r7.a.getSecond());
        r7.i.a("DefaultLayoutConfigCalculatorV2", "call calculate, adjustBase = " + r7.b + ", scale = " + r7.c + ", align = " + r7.d + ", absContainerWHAndReason[" + r7.a + ']', false);
        if (r7.b != 0) goto L55;
        mn0.b.c r9 = r7.e(r7.c(r8), r7.e);
        float r10 = r7.g.c() / r7.g.b();
        int r11 = r7.c;
        if (r11 == 0) goto L41;
        if (r11 == 1) goto L40;
        if (r11 != 2) goto L39;
        mn0.b.d r12 = mn0.b.a(r9, r10);
    L42:
        mn0.b.C0239b r13 = r7.d(r12, r9);
        r7.i.a("DefaultLayoutConfigCalculatorV2", "call calculateContent, \n传入参数：absContainerWHAndReason[" + ((Number) r8.getFirst()).intValue() + ", " + ((Number) r8.getSecond()).intValue() + ", " + ((String) r7.a.getThird()) + "], configParams=" + r7.j + ", uiMarginParams[" + r7.e.c() + ", " + r7.e.e() + ", " + r7.e.d() + ", " + r7.e.b() + "], \n过程参数：virUIContainer = " + r9 + ", contentRadioWH = " + r10 + ", contentVirSize[" + r12.a + ", " + r12.b + "], \n结果参数：contentVirPosition = " + r13 + ", contentVirSize = " + r12, false);
        mn0.b.c r14 = new mn0.b.c(r13, r12);
        mn0.b.d r16 = r14.b;
        int r17 = r16.a;
        int r18 = r16.b;
        mn0.b.C0239b r19 = r14.a;
        int r110 = r19.a;
        int r111 = r19.b;
        float r112 = ((float) r7.g.c()) / ((float) r7.f.d());
        float r113 = (float) 0;
        if (r112 <= r113) goto L45;
        r17 = (int) (r14.b.a / r112);
    L45:
        float r114 = r7.g.b() / r7.f.c();
        if (r114 <= r113) goto L48;
        r18 = (int) (r14.b.b / r114);
    L48:
        float r20 = ((float) r7.g.d()) / r7.f.d();
        if (r20 <= r113) goto L51;
        r110 = r14.a.a - ((int) (r17 * r20));
    L51:
        String r21 = "DefaultLayoutConfigCalculatorV2";
        float r22 = ((float) r7.g.e()) / r7.f.c();
        if (r22 <= r113) goto L54;
        r111 = r14.a.b - ((int) (r18 * r22));
    L54:
        r7.i.a(r21, "mapCanvasWithContent canvasResult[" + r110 + ", " + r111 + ", " + r17 + ", " + r18 + "], ratio[" + r20 + ", " + r22 + ", " + r112 + ", " + r114 + ']', false);
        mn0.b.c r26 = new mn0.b.c(new mn0.b.C0239b(r110, r111), new mn0.b.d(r17, r18));
    L79:
        mn0.b.C0239b r27 = r26.a;
        int r28 = r27.a;
        int r29 = r27.b;
        mn0.b.d r30 = r26.b;
        pn0.f.a r31 = new pn0.f.a(r28, r29, r30.a, r30.b);
        mn0.b.C0239b r32 = r14.a;
        int r33 = r32.a;
        int r34 = r32.b;
        mn0.b.d r35 = r14.b;
        pn0.f.b r36 = new pn0.f.b(r33, r34, r35.a, r35.b);
        List<LayoutConfigModel.e> r37 = r7.h;
        ArrayList r38 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r37, 10));
        Iterator<T> r39 = r37.iterator();
    L81:
        if (r39.hasNext() == false) goto L111;
        LayoutConfigModel.e r115 = (LayoutConfigModel.e) r39.next();
        mn0.b.C0239b r116 = r14.a;
        int r117 = r116.a;
        if (r117 < 0) goto L86;
        r117 = 0;
    L86:
        int r118 = r116.b;
        if (r118 < 0) goto L90;
        r118 = 0;
    L90:
        float r119 = ((float) r115.e()) / r7.g.c();
        float r120 = 0;
        if (r119 <= r120) goto L93;
        r117 = r117 + ((int) (r119 * r14.b.a));
    L93:
        float r121 = ((float) r115.f()) / r7.g.b();
        if (r121 <= r120) goto L96;
        r118 = r118 + ((int) (r121 * r14.b.b));
    L96:
        float r122 = ((float) r115.d()) / r7.g.c();
        if (r122 <= r120) goto L102;
        int r123 = (int) (r122 * r14.b.a);
        if (r117 >= 0) goto L101;
        int r210 = r117 + r123;
        int r124 = 0;
    L103:
        float r125 = ((float) r115.b()) / r7.g.b();
        if (r125 <= r120) goto L109;
        int r126 = (int) (r125 * r14.b.b);
        if (r118 >= 0) goto L108;
        int r211 = r118 + r126;
        int r212 = 0;
    L110:
        r38.add(new pn0.f.c(r115.c(), r115.g(), r124, r212, r210, r211));
        goto L81
    L108:
        r212 = r118;
        r211 = r126;
        goto L110
    L109:
        r212 = r118;
        r211 = 0;
        goto L110
    L101:
        r124 = r117;
        r210 = r123;
        goto L103
    L102:
        r124 = r117;
        r210 = 0;
        goto L103
    L111:
        r7.i.a(r21, "call calculate, seatItemResultList = " + r38, false);
        pn0.f r40 = new pn0.f(r7.a, r31, r36, r38);
        boolean r41 = ((Boolean) r7.j.b.getFirst()).booleanValue();
        int r42 = ((Number) r7.j.b.getSecond()).intValue();
        int r43 = ((Number) r7.j.b.getThird()).intValue();
        if (r41 == false) goto L125;
        if (r42 == 0) goto L125;
        if (r43 == 0) goto L125;
        float r44 = r42;
        float r127 = r43;
        if ((r44 / r127) == (r7.f.d() / r7.f.c())) goto L125;
        float r128 = (r127 / r44) / (r7.f.c() / r7.f.d());
        r7.i.a(r21, "call adjustForLivePlayerVideoSize, videoSize[" + r42 + ", " + r43 + "], configCanvasSize[" + r7.f.d() + ", " + r7.f.c() + "], radio = " + r128, false);
        nn0.a r45 = r7.i;
        StringBuilder r46 = new StringBuilder("modify before, result = ");
        r46.append(r40);
        r45.a(r21, r46.toString(), true);
        pn0.f.b r47 = r40.c;
        r47.b = (int) (((float) r47.b) * r128);
        r47.d = (int) (((float) r47.d) * r128);
        pn0.f.a r48 = r40.b;
        r48.b = (int) (((float) r48.b) * r128);
        r48.d = (int) (((float) r48.d) * r128);
        Iterator<T> r49 = r40.d.iterator();
    L121:
        if (r49.hasNext() == false) goto L123;
        pn0.f.c r50 = (pn0.f.c) r49.next();
        r50.d = (int) (r50.d * r128);
        r50.f = (int) (r50.f * r128);
        goto L121
    L123:
        r7.i.a(r21, "modify after, result = " + r40, true);
    L125:
        if (r7.j.c == true) goto L127;
        pn0.f r51 = r40;
    L136:
        int r52 = n.a;
        int r53 = n.a(r23.q()) * 2;
        List<pn0.f.c> r54 = r51.d;
        ArrayList r55 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r54, 10));
        Iterator<T> r56 = r54.iterator();
    L138:
        if (r56.hasNext() == false) goto L140;
        pn0.f.c r57 = (pn0.f.c) r56.next();
        r57.e -= r53;
        r57.f -= r53;
        r55.add(Unit.INSTANCE);
        goto L138
    L140:
        return r51;
    L127:
        int r58 = r40.c.d;
        int r59 = r7.e(r7.c(r8), r7.e).b.b;
        float r60 = r59 / r58;
        r7.i.a(r21, "adjustForScaleFitHeightFull, currentContentHeight=" + r58 + ", targetContentHeight=" + r59 + ", radio=" + r60, true);
        nn0.a r61 = r7.i;
        StringBuilder r62 = new StringBuilder("modify before, result = ");
        r62.append(r40);
        r61.a(r21, r62.toString(), true);
        r40.c.d = r59;
        Iterator r63 = CollectionsKt.reversed(CollectionsKt.withIndex(r40.d)).iterator();
    L129:
        if (r63.hasNext() == false) goto L135;
        IndexedValue r65 = (IndexedValue) r63.next();
        int r66 = r65.component1();
        pn0.f.c r67 = (pn0.f.c) r65.component2();
        float r129 = r67.e;
        float r130 = r67.f;
        float r131 = r67.c;
        float r132 = r67.d;
        if (r66 == 0) goto L134;
        int r133 = (int) (r129 * r60);
        int r134 = (int) (r130 * r60);
        int r68 = (int) (r131 - (r133 - r129));
        int r69 = (int) (r132 * r60);
        r67.e = r133;
        r67.f = r134;
        r67.c = r68;
        r67.d = r69;
        r7.i.a(r21, "modify region#" + r66 + ", before [" + r131 + ", " + r132 + ", " + r129 + ", " + r130 + "], after [" + r68 + ", " + r69 + ", " + r133 + ", " + r134 + ']', true);
    L134:
        r63 = r63;
        r60 = r60;
        r40 = r40;
        goto L129
    L135:
        nn0.a r70 = r7.i;
        StringBuilder r71 = new StringBuilder("modify after, result = ");
        r51 = r40;
        r71.append(r51);
        r70.a(r21, r71.toString(), true);
        goto L136
    L39:
        throw new Exception("invalid scale = " + r7.c);
    L40:
        r12 = mn0.b.b(r9, r10);
        goto L42
    L41:
        mn0.b.d r135 = r9.b;
        r12 = new mn0.b.d(r135.a, r135.b);
        goto L42
    L55:
        r21 = "DefaultLayoutConfigCalculatorV2";
        mn0.b.c r72 = r7.e(r7.c(r8), r7.e);
        float r73 = r7.f.d() / r7.f.c();
        int r74 = r7.c;
        if (r74 != 0) goto L58;
        mn0.b.d r75 = r72.b;
        mn0.b.d r76 = new mn0.b.d(r75.a, r75.b);
    L66:
        mn0.b.c r77 = new mn0.b.c(r7.d(r76, r72), r76);
        mn0.b.d r78 = r77.b;
        int r79 = r78.a;
        int r80 = r78.b;
        mn0.b.C0239b r81 = r77.a;
        int r82 = r81.a;
        int r83 = r81.b;
        float r84 = r7.g.c() / r7.f.d();
        float r136 = 0;
        if (r84 <= r136) goto L69;
        r79 = (int) (r77.b.a * r84);
    L69:
        float r85 = r7.g.b() / r7.f.c();
        if (r85 <= r136) goto L72;
        r80 = (int) (r77.b.b * r85);
    L72:
        float r86 = ((float) r7.g.d()) / r7.f.d();
        if (r86 <= r136) goto L75;
        r82 = (int) (r77.b.a * r86);
    L75:
        float r87 = ((float) r7.g.e()) / r7.f.c();
        if (r87 <= r136) goto L78;
        r83 = (int) (r77.b.b * r87);
    L78:
        mn0.b.c r88 = new mn0.b.c(new mn0.b.C0239b(r82, r83), new mn0.b.d(r79, r80));
        r26 = r77;
        r14 = r88;
        goto L79
    L58:
        if (r74 != 1) goto L60;
        r76 = mn0.b.b(r72, r73);
        goto L66
    L60:
        if (r74 != 2) goto L63;
        r76 = mn0.b.a(r72, r73);
        goto L66
    L63:
        throw new Exception("invalid scale = " + r7.c);
    L30:
        r6 = false;
    L23:
        r2 = false;
        goto L24
    L10:
        if (r0.d() != 360) goto L16;
        LayoutConfigModel.b r89 = r23.e();
        if (r89 == null) goto L16;
        if (r89.c() != 640) goto L16;
        r1 = true;
        goto L17
    L5:
        if (((Number) r24.getSecond()).intValue() != 0) goto L7;
        goto L6
    }

    public static int h(boolean r1, int r2, int r3) {
        int r0 = c1.a;
        if (c1.a(Integer.valueOf(r2), Integer.valueOf(r3)) == false) goto L10;
        if (r1 == false) goto L7;
    L9:
        return 1;
    L7:
        if (e5.n() == false) goto L9;
        return 2;
    L10:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v2 */
    public static void k(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r17, com.bytedance.android.live.liveinteract.plantform.commonwindow.g r18, List r19) {
        Intrinsics.checkNotNullParameter(r17, "request");
        Intrinsics.checkNotNullParameter(r18, "listener");
        if (((Number) r17.h.getFirst()).intValue() != 0) goto L5;
    L6:
        ALogger.e("LayoutConfigGeckoRes", "loadLayoutConfigV2: absContainerWH invalid, absContainerWH = [" + ((Number) r17.h.getFirst()).intValue() + ", " + ((Number) r17.h.getSecond()).intValue() + "], reason = " + ((String) r17.h.getThird()));
    L7:
        boolean r1 = hd0.c.f().h();
        List<Integer> r5 = r17.a();
        if (r19 == null) goto L10;
        b = r19;
    L10:
        List<Integer> r6 = b;
        if (r6 == null) goto L21;
        ?? r10 = new ArrayList();
        Iterator r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L22;
        Object r11 = r7.next();
        if (((Number) r11).intValue() != 8) goto L18;
        boolean r12 = true;
    L19:
        if (r12 == false) goto L14;
        r10.add(r11);
        goto L14
    L18:
        r12 = false;
    L22:
        if (r5 == null) goto L32;
        ?? r8 = new ArrayList();
        Iterator r9 = r5.iterator();
    L25:
        if (r9.hasNext() == false) goto L33;
        Object r13 = r9.next();
        if (((Number) r13).intValue() == 8) goto L29;
        boolean r14 = true;
    L30:
        if (r14 == false) goto L25;
        r8.add(r13);
        goto L25
    L29:
        r14 = false;
    L33:
        List<Integer> r15 = CollectionsKt.sortedWith(CollectionsKt.plus((Collection) r10, (Iterable) r8), new e());
        ALogger.i("LayoutConfigGeckoRes", "loadLayoutConfigV2, serverUiFeatureList: " + r17.a() + ", seiUiFeatureList: " + r19 + ", mergeUiFeatureList: " + r15 + ", isOnline: " + r1);
        if (vm2.d.S0() == false) goto L37;
        if (r1 == true) goto L37;
    L38:
        if (r15 != null) goto L40;
        List<Integer> r2 = CollectionsKt.emptyList();
    L41:
        Boolean r0 = (Boolean) h30.a.getValue();
        int r16 = r17.a;
        if (r16 != 2) goto L46;
        pn0.d r110 = new pn0.c(r16, r17.e, r17.b, r17.d, r17.f, r17.g, r0.booleanValue(), r2, r17.j, r17.k, 128);
    L44:
        pn0.d r20 = r110;
        long r4 = System.currentTimeMillis();
        ln0.a r21 = a;
        if (r21 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("newLayoutConfigManager");
    L52:
        r21.a(r20, new d(r2, r17, r18, r4));
        return;
    L46:
        if ((r17 instanceof t) == false) goto L48;
        r110 = new pn0.d(r16, r17.b, r17.d, ((t) r17).l, r17.f, null, r0.booleanValue(), r2, r17.j, r17.k, 64);
        goto L44
    L48:
        r110 = new pn0.d(r16, r17.b, r17.d, null, r17.f, null, r0.booleanValue(), r2, r17.j, r17.k, 64);
        goto L44
    L40:
        r2 = r15;
    L37:
        r15 = r17.a();
        goto L38
    L32:
        r8 = CollectionsKt.emptyList();
        goto L33
    L21:
        r10 = CollectionsKt.emptyList();
        goto L22
    L5:
        if (((Number) r17.h.getSecond()).intValue() != 0) goto L7;
        goto L6
    }

    public static void f(int r19, k r20, boolean r21, pn0.i r22, Triple r23, Pair r24, ClientUIInfo r25, Long r26, DataCenter r27) {
        Intrinsics.checkNotNullParameter(r20, "listener");
        Intrinsics.checkNotNullParameter(r23, "adjustWHAndReason");
        Intrinsics.checkNotNullParameter(r24, "livePlayerVideoSize");
        Boolean r4 = (Boolean) h30.a.getValue();
        ln0.a r5 = a;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("newLayoutConfigManager");
    L5:
        boolean r14 = r4.booleanValue();
        if (r25 == null) goto L8;
        List r6 = r25.getUiFeatureList();
    L9:
        r5.a(new pn0.c(2, r19, 0, r21, false, r22, r14, r6, r26, r27, 180), new a(r23, r24, r25, r20));
        return;
    L8:
        r6 = null;
        goto L9
    }

    public static /* synthetic */ void g(int r10, k r11, boolean r12, pn0.i r13, Triple r14, Pair r15, ClientUIInfo r16, DataCenter r17, int r18) {
        if ((r18 & 4) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r18 & 8) == 0) goto L9;
        pn0.i r4 = null;
    L11:
        if ((r18 & 64) == 0) goto L13;
        ClientUIInfo r7 = null;
    L14:
        f(r10, r11, r3, r4, r14, r15, r7, null, r17);
        return;
    L13:
        r7 = r16;
        goto L14
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }
}
