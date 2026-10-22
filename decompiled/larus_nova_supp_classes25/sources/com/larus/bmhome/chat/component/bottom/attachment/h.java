package com.larus.bmhome.chat.component.bottom.attachment;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final String a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        StringBuilder r0 = new StringBuilder("imageId=");
        r0.append(r2.b);
        r0.append(", source=");
        r0.append(b(r2.c));
        r0.append(", baseScene=");
        r0.append(r2.d);
        r0.append(", bizScene=");
        r0.append(r2.e);
        r0.append(", useDraft=");
        r0.append(r2.g);
        r0.append(", allowDetection=");
        r0.append(!r2.g);
        return r0.toString();
    }

    public static final String b(a r2) {
        if ((r2 instanceof a.b) == false) goto L6;
        return "local:" + ((a.b) r2).a;
    L6:
        if ((r2 instanceof a.c) == false) goto L9;
        return "remote:" + ((a.c) r2).a;
    L9:
        if ((r2 instanceof a.C0043a) == true) goto L18;
        if (r2 != null) goto L15;
        return "none";
    L15:
        throw new NoWhenBranchMatchedException();
    L18:
        return "drive:" + ((a.C0043a) r2).a;
    }
}
