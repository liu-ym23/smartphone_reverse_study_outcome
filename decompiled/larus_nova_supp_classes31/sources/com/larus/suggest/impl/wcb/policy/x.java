package com.larus.suggest.impl.wcb.policy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x {
    public static final String a(Long r10, long r11) {
        if (r10 == null) goto L17;
        if (r10.longValue() <= 0) goto L17;
        long r0 = r10.longValue() - r11;
        long r12 = Math.abs(r0);
        if (r12 >= 60) goto L9;
        StringBuilder r5 = new StringBuilder();
        r5.append(r12);
        r5.append('s');
        String r13 = r5.toString();
    L11:
        if (r0 <= 0) goto L13;
        String r14 = "expires in " + r13;
    L15:
        return r10 + " (" + r14 + ')';
    L13:
        r14 = "expired " + r13 + " ago";
        goto L15
    L9:
        r13 = (r12 / 60) + "min " + (r12 % 60) + 's';
    L17:
        return r10 + " (no valid expiry)";
    }
}
