package gy9;

import com.larus.bmhome.actionbar.model.g1;
import com.larus.platform.api.Image;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static final g1 a(Image r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        return new g1(null, r7.a, Integer.valueOf((int) r7.c), Integer.valueOf((int) r7.d), 17);
    }

    public static final Image b(g1 r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r2 = r10.b;
        Integer r1 = r10.c;
        long r4 = 0;
        if (r1 == null) goto L5;
        long r6 = r1.intValue();
    L6:
        Integer r11 = r10.d;
        if (r11 == null) goto L10;
        r4 = r11.intValue();
    L10:
        return new Image(r2, null, r6, r4, 18);
    L5:
        r6 = 0;
        goto L6
    }
}
