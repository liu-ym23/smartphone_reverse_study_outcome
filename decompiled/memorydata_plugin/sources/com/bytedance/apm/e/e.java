package com.bytedance.apm.e;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f1309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f1310b;

    static {
        d r0 = new AnonymousClass1();
        f1309a = r0;
        f1310b = r0;
    }

    static /* synthetic */ String a(String[] r0) {
        return b(r0);
    }

    public static void a(String r1, Throwable r2, String... r3) {
        d r0 = f1310b;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }

    public static void a(String r6, Object... r7) {
        if (f1310b == null) goto L15;
        JSONObject r0 = new JSONObject();
        int r1 = r7.length;
        if ((r1 % 2) != 0) goto L14;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L12;
        r0.put(String.valueOf(r7[r3]), String.valueOf(r7[r3 + 1]));     // Catch: JSONException -> L10
        r3 = r3 + 2;
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        f1310b.a(r6, new String[]{r0.toString()});
        return;
    L14:
        throw new IllegalArgumentException();
    }

    public static void a(String r1, String... r2) {
        d r0 = f1310b;
        if (r0 == null) goto L6;
        r0.d(r1, r2);
        return;
    }

    private static String b(String... r4) {
        StringBuilder r0 = new StringBuilder(400);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.append(r4[r2]);
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public static void b(String r1, String... r2) {
        d r0 = f1310b;
        if (r0 == null) goto L6;
        r0.b(r1, r2);
        return;
    }

    public static void c(String r1, String... r2) {
        d r0 = f1310b;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public static void d(String r1, String... r2) {
        d r0 = f1310b;
        if (r0 == null) goto L6;
        r0.c(r1, r2);
        return;
    }
}
