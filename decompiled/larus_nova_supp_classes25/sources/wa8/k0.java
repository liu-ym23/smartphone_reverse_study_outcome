package wa8;

import com.larus.bmhome.actionbar.model.c2;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k0 {
    public static final boolean a(com.larus.bmhome.actionbar.model.w r5) {
        List<c2> r0 = r5.v;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List<c2> r1 = r0;
        if ((r1 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L9;
        Integer r3 = ((c2) r2.next()).getType();
        if (r3 != null) goto L17;
    L19:
        boolean r4 = false;
    L20:
        if (r4 == false) goto L12;
        boolean r6 = true;
    L22:
        if (r6 == false) goto L35;
        com.larus.bmhome.actionbar.model.z1 r7 = r5.w;
        if (r7 == null) goto L26;
        String r8 = r7.a;
    L27:
        if (r8 != null) goto L29;
    L32:
        boolean r9 = true;
    L33:
        if (r9 == true) goto L35;
        return true;
    L29:
        if (StringsKt.isBlank(r8) == true) goto L32;
        r9 = false;
        goto L33
    L26:
        r8 = null;
    L35:
        return false;
    L17:
        if (r3.intValue() != 5) goto L19;
        r4 = true;
    L9:
        r6 = false;
        goto L22
    L8:
        if (r1.isEmpty() == false) goto L10;
        goto L9
    }

    public static final Long b(com.larus.bmhome.actionbar.model.h r11, long r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        List<com.larus.bmhome.actionbar.model.w> r0 = r11.e;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List<com.larus.bmhome.actionbar.model.w> r1 = r0;
        Iterator<T> r2 = r1.iterator();
    L6:
        boolean r4 = false;
        if (r2.hasNext() == false) goto L19;
        Object r3 = r2.next();
        com.larus.bmhome.actionbar.model.w r7 = (com.larus.bmhome.actionbar.model.w) r3;
        Long r8 = r7.a;
        if (r8 != null) goto L12;
    L16:
        boolean r9 = false;
    L17:
        if (r9 == false) goto L6;
    L20:
        com.larus.bmhome.actionbar.model.w r5 = (com.larus.bmhome.actionbar.model.w) r3;
        if (r5 == null) goto L26;
        Long r13 = r5.a;
        if (r13 == null) goto L26;
        return Long.valueOf(r13.longValue());
    L26:
        Long r14 = r11.g;
        if (r14 != null) goto L29;
    L57:
        Integer r15 = r11.f;
        if (r15 != null) goto L60;
    L77:
        Iterator<T> r16 = r1.iterator();
    L79:
        if (r16.hasNext() == false) goto L83;
        Object r17 = r16.next();
        if ((!a((com.larus.bmhome.actionbar.model.w) r17)) == false) goto L79;
    L84:
        com.larus.bmhome.actionbar.model.w r18 = (com.larus.bmhome.actionbar.model.w) r17;
        if (r18 != null) goto L87;
        return null;
    L87:
        return r18.a;
    L83:
        r17 = null;
        goto L84
    L60:
        if (r15.intValue() < 0) goto L62;
        r4 = true;
    L62:
        if (r4 == true) goto L65;
        r15 = null;
    L65:
        if (r15 == null) goto L77;
        com.larus.bmhome.actionbar.model.w r19 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.getOrNull(r0, r15.intValue());
        if (r19 == null) goto L77;
        if ((!a(r19)) == true) goto L72;
        r19 = null;
    L72:
        if (r19 == null) goto L77;
        Long r110 = r19.a;
        if (r110 == null) goto L77;
        return Long.valueOf(r110.longValue());
    L29:
        if (r14.longValue() == (-1)) goto L31;
        boolean r111 = true;
    L32:
        if (r111 == true) goto L35;
        r14 = null;
    L35:
        if (r14 == null) goto L57;
        long r112 = r14.longValue();
        Iterator<T> r6 = r1.iterator();
    L38:
        if (r6.hasNext() == false) goto L50;
        Object r10 = r6.next();
        com.larus.bmhome.actionbar.model.w r20 = (com.larus.bmhome.actionbar.model.w) r10;
        Long r21 = r20.a;
        if (r21 != null) goto L43;
    L47:
        boolean r22 = false;
    L48:
        if (r22 == false) goto L38;
    L51:
        com.larus.bmhome.actionbar.model.w r23 = (com.larus.bmhome.actionbar.model.w) r10;
        if (r23 == null) goto L57;
        Long r113 = r23.a;
        if (r113 == null) goto L57;
        return Long.valueOf(r113.longValue());
    L43:
        if (r21.longValue() != r112) goto L47;
        if (a(r20) == true) goto L47;
        r22 = true;
        goto L48
    L50:
        r10 = null;
        goto L51
    L31:
        r111 = false;
        goto L32
    L12:
        if (r8.longValue() != r12) goto L16;
        if (a(r7) == true) goto L16;
        r9 = true;
        goto L17
    L19:
        r3 = null;
        goto L20
    }
}
