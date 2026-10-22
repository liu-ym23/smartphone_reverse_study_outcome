package pc8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerSource;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public static final String a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r4 = r3.e;
        if (r4 == null) goto L15;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 == null) goto L16;
        boolean r2 = true;
        if ((!StringsKt.isBlank(r5)) == true) goto L9;
    L11:
        r2 = false;
    L12:
        if (r2 == true) goto L14;
        return null;
    L14:
        return r5;
    L9:
        if (Intrinsics.areEqual(r5, "-1") == true) goto L11;
    L16:
        return null;
    L15:
        return null;
    }

    public static final sc8.b b(e r17) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        d r2 = r17.b;
        String r3 = r2.c;
        String r4 = r17.a;
        String r5 = r2.b;
        String r6 = r17.b();
        d r0 = r17.b;
        com.larus.bmhome.chat.bubble.floating.a r7 = r0.d;
        String r8 = r7.b;
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        String r9 = r7.d;
        String r10 = r7.c;
        String r11 = r7.e;
        h r12 = r0.f;
        long r13 = r12.c;
        int r14 = r12.f;
        BubbleBannerSource r15 = r0.a;
        c r16 = r0.g;
        if (r16 == null) goto L8;
        Map<String, String> r1 = r16.d;
    L10:
        return new sc8.b(r3, r4, r5, r6, r8, r9, r10, r11, r13, r14, r15, r16, r1);
    L8:
        r1 = null;
        goto L10
    }
}
