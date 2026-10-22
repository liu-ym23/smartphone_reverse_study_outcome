package hi8;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.d1;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.nestedmenu.NestedMenuRightModel;
import com.larus.bmhome.chat.nestedmenu.b;
import com.larus.bmhome.chat.nestedmenu.d;
import di8.b0;
import di8.c0;
import di8.d0;
import di8.f0;
import di8.g0;
import ei8.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.h;
import wa8.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements c {
    @Override // ei8.c
    public final String getKey() {
        return "fold";
    }

    public a() {
    }

    @Override // ei8.a
    public final LinkedHashMap<String, List<d0>> a(LinkedHashMap<String, List<d0>> r11, c0 r12) {
        Intrinsics.checkNotNullParameter(r11, "models");
        Intrinsics.checkNotNullParameter(r12, "config");
        z0 r0 = r12.f;
        ReplyOption r1 = r12.l;
        Integer r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getModeId();
    L6:
        di8.a r4 = com.larus.bmhome.chat.nestedmenu.a.a(r0, r3);
        d1 r5 = r4.b;
        List<d0> r6 = r11.get("mode");
        if (r6 != null) goto L9;
        r6 = CollectionsKt.emptyList();
    L9:
        List<d0> r7 = b(r6, "mode", r5, r12);
        if ((!r7.isEmpty()) == false) goto L12;
        r11.put("mode", r7);
    L12:
        d1 r8 = r4.d;
        List<d0> r9 = r11.get("model");
        if (r9 != null) goto L15;
        r9 = CollectionsKt.emptyList();
    L15:
        Iterator<d0> r10 = r9.iterator();
        boolean r13 = false;
        int r14 = 0;
    L17:
        if (r10.hasNext() == false) goto L31;
        f0 r15 = r10.next().c();
        if ((r15 instanceof b) == false) goto L21;
        b r16 = (b) r15;
    L22:
        if (r16 == null) goto L24;
        b.C0068b r17 = r16.a;
    L25:
        if (r17 != null) goto L27;
        boolean r18 = true;
    L28:
        if (r18 == true) goto L32;
        r14 = r14 + 1;
    L32:
        Integer r19 = Integer.valueOf(r14);
        if (r19.intValue() < 0) goto L35;
        r13 = true;
    L35:
        if (r13 == false) goto L37;
        r2 = r19;
    L37:
        if (r2 == null) goto L39;
        int r20 = r2.intValue();
    L40:
        List<d0> r21 = r9;
        List r22 = CollectionsKt.take(r21, r20);
        List<d0> r110 = CollectionsKt.plus(b(r22, "model", r8, r12), CollectionsKt.drop(r21, r20));
        if ((!r110.isEmpty()) == false) goto L43;
        r11.put("model", r110);
    L43:
        return r11;
    L39:
        r20 = r9.size();
        goto L40
    L27:
        r18 = false;
        goto L28
    L24:
        r17 = null;
        goto L25
    L21:
        r16 = null;
        goto L22
    L31:
        r14 = -1;
        goto L32
    L5:
        r3 = null;
        goto L6
    }

    public static List b(List r35, String r36, d1 r37, c0 r38) {
        if (r37 != null) goto L5;
        return r35;
    L5:
        Integer r1 = r37.a;
        if (r1 == null) goto L8;
        int r2 = r1.intValue();
    L9:
        boolean r3 = false;
        int r4 = RangesKt.coerceAtLeast(r2, 0);
        List r5 = r35;
        List r6 = CollectionsKt.take(r5, r4);
        List r7 = CollectionsKt.drop(r5, r4);
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L10:
        b r10 = null;
        if (r9.hasNext() == false) goto L26;
        Object r11 = (d0) r9.next();
        if ((r11 instanceof d) == false) goto L15;
        d r12 = (d) r11;
    L16:
        if (r12 == null) goto L24;
        f0 r13 = r12.h;
        if ((r13 instanceof b) == false) goto L21;
        r10 = (b) r13;
    L21:
        if (r10 == null) goto L24;
        r11 = d.e(r12, new b(r10.a, r10.b, r10.c, true));
    L24:
        r8.add(r11);
        goto L10
    L15:
        r12 = null;
        goto L16
    L26:
        if (r8.size() > 1) goto L28;
        return r35;
    L28:
        List r14 = r6;
        Iterator r15 = r8.iterator();
    L30:
        if (r15.hasNext() == false) goto L34;
        Object r16 = r15.next();
        if (((d0) r16).getRight().a == false) goto L30;
    L35:
        d0 r17 = (d0) r16;
        if (r8.isEmpty() == true) goto L56;
        Iterator r18 = r8.iterator();
    L40:
        if (r18.hasNext() == false) goto L56;
        f0 r19 = ((d0) r18.next()).c();
        if ((r19 instanceof b) == false) goto L44;
        b r20 = (b) r19;
    L45:
        if (r20 == null) goto L53;
        b.C0068b r21 = r20.a;
        if (r21 == null) goto L53;
        b2 r22 = r21.a;
        if (r22 == null) goto L53;
        if (r22.u != true) goto L53;
        boolean r23 = true;
    L54:
        if (r23 == false) goto L40;
        r3 = true;
    L53:
        r23 = false;
        goto L54
    L44:
        r20 = null;
    L56:
        boolean r24 = h.a;
        if (h.b(r38.c.getContext()) == false) goto L65;
        g1 r25 = r37.c;
        if (r25 == null) goto L62;
        String r26 = r25.b;
        if (r26 == null) goto L62;
    L70:
        if (r26 != null) goto L72;
        String r110 = "";
    L73:
        g0 r111 = new g0(null, r110, null, false, null, 61);
        String r0 = r37.d;
        if (r0 != null) goto L76;
        String r112 = "";
    L78:
        if (r3 == false) goto L80;
        String r27 = n0.a();
    L81:
        b0 r113 = new b0(r112, null, null, null, null, r27, Boolean.FALSE, null, null, null, 31486);
        if (r17 == null) goto L86;
        b0 r28 = r17.getCenter();
        if (r28 == null) goto L86;
        String r30 = r28.a;
    L88:
        return CollectionsKt.plus(r14, new d(r111, r113, new NestedMenuRightModel(r30, Integer.valueOf(v19.c.b(2130971886, null, 2131242741)), null, null, 863), true, null, true, new di8.n0(MapsKt.mapOf(TuplesKt.to(r36, r8)), CollectionsKt.listOf(r36)), null, false, false, false, 1936));
    L86:
        r30 = null;
        goto L88
    L80:
        r27 = null;
        goto L81
    L76:
        r112 = r0;
        goto L78
    L72:
        r110 = r26;
    L62:
        g1 r29 = r37.b;
        if (r29 == null) goto L68;
        r26 = r29.b;
    L68:
        r26 = null;
        goto L70
    L65:
        g1 r31 = r37.b;
        if (r31 == null) goto L68;
        r26 = r31.b;
        goto L70
    L34:
        r16 = null;
        goto L35
    L8:
        r2 = r35.size();
        goto L9
    }
}
