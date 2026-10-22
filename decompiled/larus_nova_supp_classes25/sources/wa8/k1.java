package wa8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k1 {
    public static final String a(com.larus.bmhome.actionbar.model.z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.b);
        r0.append('&');
        com.larus.bmhome.actionbar.model.r r3 = r2.q;
        if (r3 == null) goto L7;
        Integer r4 = r3.a;
        if (r4 == null) goto L7;
        int r5 = r4.intValue();
    L8:
        r0.append(r5);
        return r0.toString();
    L7:
        r5 = 0;
        goto L8
    }

    public static final boolean b(com.larus.bmhome.actionbar.model.z0 r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        com.larus.bmhome.actionbar.model.d r2 = r1.J;
        if (r2 == null) goto L5;
        Integer r0 = r2.a;
    L6:
        if (r0 == null) goto L13;
        Integer r3 = r2.a;
        if (r3 != null) goto L11;
    L12:
        return true;
    L11:
        if (r3.intValue() != 0) goto L12;
    L13:
        return false;
    L5:
        r0 = null;
        goto L6
    }

    public static final boolean c(com.larus.bmhome.actionbar.model.z0 r1) {
        if (r1 == null) goto L4;
        String r2 = r1.b;
    L6:
        return Intrinsics.areEqual(r2, "coco_spring_pocket");
    L4:
        r2 = null;
        goto L6
    }
}
