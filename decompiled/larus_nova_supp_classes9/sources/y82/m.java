package y82;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorWindowV2;
import com.bytedance.android.livesdkapi.model.CropSeiData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import zg1.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements b, k {
    public final g a;
    public z82.d b;
    public final c92.a c;

    @Override // y82.b
    public final u1 c(a r13) {
        Intrinsics.checkNotNullParameter(r13, "windowFrame");
        z82.d r1 = this.b;
        if (r1 != null) goto L5;
        return null;
    L5:
        r13.isPortrait();
        r13.m();
        int r3 = r1.c;
        int r4 = r1.b;
        Intrinsics.checkNotNullParameter(r13, "windowFrame");
        Integer r5 = c.a(r3, r4, r13.n());
        if (r5 == null) goto L29;
        int r6 = r5.intValue();
        r13.isPortrait();
        r13.m();
        int r7 = r1.c;
        int r2 = r1.b;
        Intrinsics.checkNotNullParameter(r13, "windowFrame");
        List<MediaMultiAnchorWindowV2> r0 = r13.n();
        Intrinsics.checkNotNullParameter(r0, "windows");
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r0.iterator();
    L9:
        if (r9.hasNext() == false) goto L22;
        SeiRegion r10 = ((com.bytedance.android.livesdk.interactivity.medialink.ui.a) r9.next()).getMSeiRegion();
        if (r10 != null) goto L14;
    L19:
        Double r11 = null;
    L20:
        if (r11 == null) goto L9;
        r8.add(r11);
        goto L9
    L14:
        if (r10.getWidth() == 0.0d) goto L19;
        if (r10.getHeight() == 0.0d) goto L19;
        r11 = Double.valueOf(r10.getY() + r10.getHeight());
        goto L20
    L22:
        Double r14 = (Double) CollectionsKt.lastOrNull(CollectionsKt.sorted(r8));
        if (r14 == null) goto L25;
        Integer r15 = Integer.valueOf((int) ((r14.doubleValue() * ((double) r2)) + ((double) r7)));
    L26:
        if (r15 == null) goto L29;
        int r16 = r15.intValue();
        u1 r17 = new u1();
        r17.i = r13.h();
        r17.f = 1;
        r17.h = r6;
        r17.g = r16;
        return r17;
    L25:
        r15 = null;
    L29:
        return null;
    }

    public m(DataCenter r2, c92.a r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "transfer");
        this.c = r3;
        this.a = new g(this);
    }

    @Override // y82.b
    public final void b(a r25, String r26) {
        Intrinsics.checkNotNullParameter(r25, "windowFrame");
        Intrinsics.checkNotNullParameter(r26, "sei");
        Intrinsics.checkNotNullParameter(r26, "sei");
        JSONArray r1 = z82.f.b(r26);
        if (r1 == null) goto L5;
        int r2 = r1.length();
    L7:
        if (r2 >= 2) goto L9;
        return;
    L9:
        z82.b r3 = this.c.a(new a92.a(s1.y(), s1.w(), r26, new z82.g(jc1.k.n(ILinkServiceExternal.class).getMultiAnchorServiceExternal().c().a(r25.isPortrait(), r25.m(), true), s1.A()), new z82.a(new z82.c(0))));
        if (r3 != null) goto L12;
        return;
    L12:
        Intrinsics.checkNotNullParameter(r26, "sei");
        z82.e.a r4 = z82.e.g;
        int r5 = r3.a;
        int r6 = r3.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r26, "sei");
        CropSeiData r7 = z82.f.a(r26);
        JSONArray r8 = z82.f.b(r26);
        if (r8 != null) goto L16;
    L14:
        String r23 = "windowFrame";
    L40:
        z82.e r9 = null;
    L41:
        if (r9 != null) goto L43;
        z82.d r10 = null;
    L44:
        if (r10 == null) goto L68;
        CropSeiData r0 = z82.f.a(r26);
        if (r0 != null) goto L48;
        z82.d r11 = r10;
    L49:
        g r13 = this.a;
        l r14 = new l(r25, r11.c, (s1.y() - r11.a) / 2, r11.a, r11.b);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "params");
        com.bytedance.android.livesdk.interactivity.medialink.ui.o r15 = r14.a.f();
        if (r15 != null) goto L52;
        String r16 = r23;
    L58:
        a r17 = r14.a;
        Intrinsics.checkNotNullParameter(r17, r16);
        Iterator r18 = r17.n().iterator();
    L60:
        if (r18.hasNext() == false) goto L65;
        com.bytedance.android.livesdk.interactivity.medialink.ui.a r19 = (com.bytedance.android.livesdk.interactivity.medialink.ui.a) r18.next();
        SeiRegion r20 = r19.getMSeiRegion();
        if (r20 == null) goto L60;
        double r21 = ((double) r14.d) * r20.getWidth();
        double r110 = ((double) r14.e) * r20.getHeight();
        double r111 = (((double) r14.d) * r20.getX()) + ((double) r14.c);
        r13.a.a(r14.a, r19, new d((int) r21, (int) r110, (int) ((((double) r14.e) * r20.getY()) + ((double) r14.b)), (int) r111, 51));
        r18 = r18;
        r11 = r11;
        goto L60
    L65:
        this.b = r11;
        return;
    L52:
        r14.a.isPortrait();
        r14.a.m();
        int r24 = r14.b;
        int r27 = r14.e;
        a r28 = r14.a;
        r16 = r23;
        Intrinsics.checkNotNullParameter(r28, r16);
        Integer r29 = c.a(r24, r27, r28.n());
        if (r29 == null) goto L58;
        int r112 = r29.intValue();
        if (r15.a == false) goto L57;
        r13.a.d(r14.a, new d(-2, -2, r112 + r15.b, 0, 1));
        goto L58
    L57:
        r13.a.d(r14.a, new d(-2, -2, r112, 0, 1));
        goto L58
    L48:
        float r30 = r10.a;
        float r31 = r0.cropW * r30;
        float r33 = r0.strideW;
        float r34 = r10.b;
        float r35 = r0.cropH * r34;
        float r36 = r0.strideH;
        r11 = new z82.d((int) (r31 / r33), (int) (r35 / r36), ((int) ((r34 * r0.cropY) / r36)) + r10.c, ((int) ((r30 * r0.cropX) / r33)) + r10.d);
        goto L49
    L68:
        return;
    L43:
        r10 = new z82.d(r9.a, r9.b, r3.c - r9.d, r3.d - r9.c);
        goto L44
    L16:
        if (r7 != null) goto L29;
        double r113 = z82.f.f(r8);
        double r114 = z82.f.c(r8);
        if (r113 <= 0.0d) goto L14;
        if (r114 <= 0.0d) goto L14;
        int r37 = (int) (((double) r5) / r113);
        int r38 = (int) (((double) r6) / r114);
        double r115 = z82.f.f(r8);
        double r116 = z82.f.c(r8);
        if (r115 <= 0.0d) goto L14;
        if (r116 <= 0.0d) goto L14;
        double r117 = r37;
        double r118 = r38;
        r23 = "windowFrame";
        r9 = new z82.e(r37, r38, (int) (z82.f.d(r8) * r117), (int) (z82.f.e(r8) * r118), (int) (r117 * r115), (int) (r118 * r116));
        goto L41
    L29:
        r23 = "windowFrame";
        double r39 = z82.f.f(r8);
        double r119 = z82.f.c(r8);
        if (r39 <= 0.0d) goto L40;
        if (r119 <= 0.0d) goto L40;
        double r120 = ((((double) r5) / r39) * ((double) r7.strideW)) / ((double) r7.cropW);
        int r40 = (int) r120;
        int r41 = (int) (((((double) r6) / r119) * ((double) r7.strideH)) / ((double) r7.cropH));
        double r43 = z82.f.f(r8);
        double r121 = z82.f.c(r8);
        if (r43 <= 0.0d) goto L40;
        if (r121 <= 0.0d) goto L40;
        float r44 = r40;
        float r122 = r7.cropW * r44;
        float r123 = r7.strideW;
        int r124 = (int) (r122 / r123);
        float r125 = r41;
        float r126 = r7.cropH * r125;
        float r45 = r7.strideH;
        int r46 = (int) ((r44 * r7.cropX) / r123);
        int r47 = (int) ((r125 * r7.cropY) / r45);
        double r127 = r46;
        double r48 = r124;
        int r128 = (int) (r127 + (z82.f.d(r8) * r48));
        double r129 = r47;
        double r49 = (int) (r126 / r45);
        r9 = new z82.e(r40, r41, r128, (int) (r129 + (z82.f.e(r8) * r49)), (int) (r48 * r43), (int) (r49 * r121));
        goto L41
    L5:
        r2 = 0;
        goto L7
    }

    @Override // y82.k
    public final void d(a r5, d r6) {
        Intrinsics.checkNotNullParameter(r5, "windowFrame");
        Intrinsics.checkNotNullParameter(r6, "layoutData");
        com.bytedance.android.livesdk.interactivity.medialink.ui.o r0 = r5.f();
        Integer r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = r0.c;
    L6:
        if (r0 == null) goto L8;
        Integer r3 = r0.d;
    L9:
        if (r0 == null) goto L11;
        r1 = r0.e;
    L11:
        r5.k(r6, r2, r3, r1);
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    @Override // y82.k
    public final void a(a r2, com.bytedance.android.livesdk.interactivity.medialink.ui.a r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "windowFrame");
        Intrinsics.checkNotNullParameter(r3, "window");
        Intrinsics.checkNotNullParameter(r4, "layoutData");
        c.b(r3.getView(), r4);
        Integer r5 = r3.getMPosition();
        if (r5 == null) goto L6;
        int r6 = r5.intValue();
        r3.a(r2.isPortrait(), r6, r2.h());
        return;
    }
}
