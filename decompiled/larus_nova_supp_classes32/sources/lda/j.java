package lda;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j {
    public static /* synthetic */ String c(String r1) {
        return b(r1, 96);
    }

    public static final String a(long r3, long r5) {
        if (r5 > 0) goto L7;
        r5 = System.currentTimeMillis();
    L7:
        return Math.max(1, (int) Math.ceil(Math.max(0, r5 - r3) / 1000.0d)) + " 秒";
    }

    public static final String b(String r6, int r7) {
        String r8 = StringsKt.replace$default(r6, "\n", "\\n", false, 4, null);
        if (r8.length() > r7) goto L6;
        return r8;
    L6:
        return StringsKt.take(r8, r7) + "...";
    }
}
