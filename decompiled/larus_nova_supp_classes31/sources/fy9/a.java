package fy9;

import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    static {
    }

    public static String a() {
        StringBuilder r0 = new StringBuilder();
        r0.append(UUID.randomUUID());
        r0.append('_');
        r0.append(System.currentTimeMillis());
        return r0.toString();
    }
}
