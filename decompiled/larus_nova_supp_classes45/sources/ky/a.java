package ky;

import android.util.Log;
import androidx.core.util.Preconditions;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.n;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import iy.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import pn0.f;
import vm2.d;
import vm2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final boolean a = false;

    static {
        boolean r1 = true;
        if (d.c0().getEnable() == true) goto L6;
        r1 = false;
    L6:
        a = r1;
    }

    public static f a(LayoutConfigModel r17, Triple r18, Pair r19) {
        if (((Number) r18.getFirst()).intValue() != 0) goto L5;
    L6:
        boolean r0 = b.a;
        b.b("[config] calculateLayoutConfigV2: absContainerWH invalid, absContainerWH = [" + ((Number) r18.getFirst()).intValue() + ", " + ((Number) r18.getSecond()).intValue() + "], stack = " + Log.getStackTraceString(new Exception()));
    L7:
        LayoutConfigModel.b r1 = r17.e();
        if (r1 != null) goto L10;
    L16:
        boolean r2 = false;
    L17:
        boolean r4 = Intrinsics.areEqual((String) e.k().get(String.valueOf(((Number) r19.getSecond()).intValue())), String.valueOf(((Number) r19.getFirst()).intValue()));
        if (r2 == false) goto L23;
        if (r4 == false) goto L23;
        if (d.P0() == false) goto L23;
        boolean r3 = true;
    L24:
        LayoutConfigModel.g r7 = (LayoutConfigModel.g) Preconditions.checkNotNull(r17.p());
        LayoutConfigModel.b r8 = (LayoutConfigModel.b) Preconditions.checkNotNull(r17.e());
        LayoutConfigModel.d r9 = (LayoutConfigModel.d) Preconditions.checkNotNull(r17.f());
        Triple r5 = new Triple(Boolean.valueOf(r3), r19.getFirst(), r19.getSecond());
        if (r17.q() != 30) goto L27;
        boolean r6 = true;
    L28:
        oy.b r11 = new oy.b(r18, r17, r7, r8, r9, new mn0.a(r5, r6));
        Pair r12 = new Pair(r11.a.getFirst(), r11.a.getSecond());
        boolean r13 = b.a;
        b.e("NewLinkPlayerLayoutCalculator", "call calculate, adjustBase = " + r11.b.b() + ", scale = " + r11.b.j() + ", align = " + r11.b.d() + ", absContainerWHAndReason[" + r11.a + ']');
        if (r11.b.b() != 0) goto L52;
        oy.b.c r14 = r11.e(r11.c(r12), r11.c);
        float r15 = r11.e.c() / r11.e.b();
        int r16 = r11.b.j();
        if (r16 == 0) goto L38;
        if (r16 == 1) goto L37;
        if (r16 != 2) goto L36;
        oy.b.d r21 = oy.b.a(r14, r15);
    L39:
        oy.b.C0256b r22 = r11.d(r21, r14);
        b.e("NewLinkPlayerLayoutCalculator", "call calculateContent, \n传入参数：absContainerWHAndReason[" + ((Number) r12.getFirst()).intValue() + ", " + ((Number) r12.getSecond()).intValue() + ", " + ((String) r11.a.getThird()) + "], configParams=" + r11.f + ", uiMarginParams[" + r11.c.c() + ", " + r11.c.e() + ", " + r11.c.d() + ", " + r11.c.b() + "], \n过程参数：virUIContainer = " + r14 + ", contentRadioWH = " + r15 + ", contentVirSize[" + r21.a + ", " + r21.b + "], \n结果参数：contentVirPosition = " + r22 + ", contentVirSize = " + r21);
        oy.b.c r23 = new oy.b.c(r22, r21);
        oy.b.d r24 = r23.b;
        int r25 = r24.a;
        int r26 = r24.b;
        oy.b.C0256b r27 = r23.a;
        int r110 = r27.a;
        int r28 = r27.b;
        float r111 = ((float) r11.e.c()) / ((float) r11.d.d());
        float r29 = (float) 0;
        if (r111 <= r29) goto L42;
        r25 = (int) (r23.b.a / r111);
    L42:
        float r112 = r11.e.b() / r11.d.c();
        if (r112 <= r29) goto L45;
        r26 = (int) (r23.b.b / r112);
    L45:
        float r113 = ((float) r11.e.d()) / r11.d.d();
        if (r113 <= r29) goto L48;
        r110 = r23.a.a - ((int) (r25 * r113));
    L48:
        float r31 = ((float) r11.e.e()) / r11.d.c();
        if (r31 <= r29) goto L51;
        r28 = r23.a.b - ((int) (r26 * r31));
    L51:
        String r32 = "NewLinkPlayerLayoutCalculator";
        b.e(r32, "mapCanvasWithContent canvasResult[" + r110 + ", " + r28 + ", " + r25 + ", " + r26 + "], ratio[" + r113 + ", " + r31 + ", " + r111 + ", " + r112 + ']');
        oy.b.c r33 = new oy.b.c(new oy.b.C0256b(r110, r28), new oy.b.d(r25, r26));
    L74:
        oy.b.C0256b r34 = r33.a;
        int r35 = r34.a;
        int r36 = r34.b;
        oy.b.d r37 = r33.b;
        f.a r38 = new f.a(r35, r36, r37.a, r37.b);
        oy.b.C0256b r39 = r23.a;
        int r41 = r39.a;
        int r42 = r39.b;
        oy.b.d r43 = r23.b;
        f r44 = new f(r11.a, r38, new f.b(r41, r42, r43.a, r43.b), CollectionsKt.emptyList());
        boolean r45 = ((Boolean) r11.f.b.getFirst()).booleanValue();
        int r46 = ((Number) r11.f.b.getSecond()).intValue();
        int r47 = ((Number) r11.f.b.getThird()).intValue();
        if (r45 == false) goto L88;
        if (r46 == 0) goto L88;
        if (r47 == 0) goto L88;
        float r48 = r46;
        float r114 = r47;
        if ((r48 / r114) == (r11.d.d() / r11.d.c())) goto L88;
        float r115 = (r114 / r48) / (r11.d.c() / r11.d.d());
        b.e(r32, "call adjustForLivePlayerVideoSize, videoSize[" + r46 + ", " + r47 + "], configCanvasSize[" + r11.d.d() + ", " + r11.d.c() + "], radio = " + r115);
        StringBuilder r49 = new StringBuilder("modify before, result = ");
        r49.append(r44);
        b.e(r32, r49.toString());
        f.b r51 = r44.c;
        r51.b = (int) (((float) r51.b) * r115);
        r51.d = (int) (((float) r51.d) * r115);
        f.a r52 = r44.b;
        r52.b = (int) (((float) r52.b) * r115);
        r52.d = (int) (((float) r52.d) * r115);
        Iterator r53 = r44.d.iterator();
    L84:
        if (r53.hasNext() == false) goto L86;
        f.c r54 = (f.c) r53.next();
        r54.d = (int) (r54.d * r115);
        r54.f = (int) (r54.f * r115);
        goto L84
    L86:
        boolean r55 = b.a;
        b.e(r32, "modify after, result = " + r44);
    L88:
        if (r11.f.c == false) goto L99;
        int r56 = r44.c.d;
        int r57 = r11.e(r11.c(r12), r11.c).b.b;
        float r58 = r57 / r56;
        b.e(r32, "adjustForScaleFitHeightFull, currentContentHeight=" + r56 + ", targetContentHeight=" + r57 + ", radio=" + r58);
        StringBuilder r59 = new StringBuilder("modify before, result = ");
        r59.append(r44);
        b.e(r32, r59.toString());
        r44.c.d = r57;
        Iterator r61 = CollectionsKt.reversed(CollectionsKt.withIndex(r44.d)).iterator();
    L92:
        if (r61.hasNext() == false) goto L98;
        IndexedValue r62 = (IndexedValue) r61.next();
        int r63 = r62.component1();
        f.c r64 = (f.c) r62.component2();
        float r65 = r64.e;
        float r116 = r64.f;
        float r117 = r64.c;
        float r118 = r64.d;
        if (r63 == 0) goto L97;
        int r119 = (int) (r65 * r58);
        int r120 = (int) (r116 * r58);
        int r121 = (int) (r117 - (r119 - r65));
        int r66 = (int) (r118 * r58);
        r64.e = r119;
        r64.f = r120;
        r64.c = r121;
        r64.d = r66;
        boolean r67 = b.a;
        b.e(r32, "modify region#" + r63 + ", before [" + r117 + ", " + r118 + ", " + r65 + ", " + r116 + "], after [" + r121 + ", " + r66 + ", " + r119 + ", " + r120 + ']');
    L97:
        r61 = r61;
        goto L92
    L98:
        boolean r68 = b.a;
        b.e(r32, "modify after, result = " + r44);
    L99:
        int r69 = n.a;
        int r71 = n.a(r17.q()) * 2;
        List r72 = r44.d;
        ArrayList r73 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r72, 10));
        Iterator r74 = r72.iterator();
    L101:
        if (r74.hasNext() == false) goto L103;
        f.c r75 = (f.c) r74.next();
        r75.e -= r71;
        r75.f -= r71;
        r73.add(Unit.INSTANCE);
        goto L101
    L103:
        return r44;
    L36:
        throw new Exception("invalid scale = " + r11.b.j());
    L37:
        r21 = oy.b.b(r14, r15);
        goto L39
    L38:
        oy.b.d r76 = r14.b;
        r21 = new oy.b.d(r76.a, r76.b);
        goto L39
    L52:
        r32 = "NewLinkPlayerLayoutCalculator";
        oy.b.c r77 = r11.e(r11.c(r12), r11.c);
        float r78 = r11.d.d() / r11.d.c();
        int r79 = r11.b.j();
        if (r79 == 0) goto L60;
        if (r79 == 1) goto L59;
        if (r79 != 2) goto L58;
        oy.b.d r81 = oy.b.a(r77, r78);
    L61:
        oy.b.c r82 = new oy.b.c(r11.d(r81, r77), r81);
        oy.b.d r83 = r82.b;
        int r84 = r83.a;
        int r85 = r83.b;
        oy.b.C0256b r86 = r82.a;
        int r87 = r86.a;
        int r88 = r86.b;
        float r122 = r11.e.c() / r11.d.d();
        float r89 = 0;
        if (r122 <= r89) goto L64;
        r84 = (int) (r82.b.a * r122);
    L64:
        float r123 = r11.e.b() / r11.d.c();
        if (r123 <= r89) goto L67;
        r85 = (int) (r82.b.b * r123);
    L67:
        float r124 = ((float) r11.e.d()) / r11.d.d();
        if (r124 <= r89) goto L70;
        r87 = (int) (r82.b.a * r124);
    L70:
        float r125 = ((float) r11.e.e()) / r11.d.c();
        if (r125 <= r89) goto L73;
        r88 = (int) (r82.b.b * r125);
    L73:
        r23 = new oy.b.c(new oy.b.C0256b(r87, r88), new oy.b.d(r84, r85));
        r33 = r82;
        goto L74
    L58:
        throw new Exception("invalid scale = " + r11.b.j());
    L59:
        r81 = oy.b.b(r77, r78);
        goto L61
    L60:
        oy.b.d r91 = r77.b;
        r81 = new oy.b.d(r91.a, r91.b);
        goto L61
    L27:
        r6 = false;
    L23:
        r3 = false;
        goto L24
    L10:
        if (r1.d() != 360) goto L16;
        LayoutConfigModel.b r92 = r17.e();
        if (r92 == null) goto L16;
        if (r92.c() != 640) goto L16;
        r2 = true;
        goto L17
    L5:
        if (((Number) r18.getSecond()).intValue() != 0) goto L7;
        goto L6
    }
}
