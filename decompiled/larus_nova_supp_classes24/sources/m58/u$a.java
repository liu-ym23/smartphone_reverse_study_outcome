package m58;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class u$a {
    public static /* synthetic */ void a(u r1, String r2, Integer r3, String r4) {
        r1.k(r2, r3, r4, null);
    }

    public static /* synthetic */ void b(u r8, String r9, String r10, Integer r11, String r12, JSONObject r13, int r14) {
        if ((r14 & 4) == 0) goto L5;
        Integer r5 = null;
    L7:
        if ((r14 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r14 & 16) == 0) goto L13;
        JSONObject r7 = null;
    L14:
        r8.h(r9, r10, r5, r6, r7);
        return;
    L13:
        r7 = r13;
        goto L14
    L9:
        r6 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }
}
