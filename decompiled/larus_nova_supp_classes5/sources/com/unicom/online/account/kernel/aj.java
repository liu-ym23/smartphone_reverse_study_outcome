package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class aj {
    private static boolean a = false;
    private static int b = 2;
    private static long c;
    private static int d;
    private static int e;
    private static StringBuilder f;
    private static StringBuilder g;
    private static StringBuilder h;
    private static StringBuilder i;

    static {
        f = new StringBuilder();
        g = new StringBuilder();
        h = new StringBuilder();
        i = new StringBuilder();
    }

    public static String a(int r1) {
        if (r1 != 0) goto L4;
        StringBuilder r2 = g;
    L13:
        return r2.toString();
    L4:
        if (r1 != 1) goto L6;
        r2 = f;
        goto L13
    L6:
        if (r1 != 2) goto L8;
        r2 = h;
        goto L13
    L8:
        if (r1 == 3) goto L11;
        return "no info";
    L11:
        r2 = i;
        goto L13
    }

    public static void a() {
        d = 0;
        e = 0;
        g.setLength(0);
        g.append("\n\n■★■★■★■★■★■★■★■★■★■\n\ncom debug info\n\n■★■★■★■★■★■★■★■★■★■\n\n");
        f.setLength(0);
        f.append("\n\n■★■★■★■★■★■★■★■★■★■\n\nall debug info\n\n■★■★■★■★■★■★■★■★■★■\n\n");
        h.setLength(0);
        h.append("\n\n■★■★■★■★■★■★■★■★■★■\n\nresult  info\n\n■★■★■★■★■★■★■★■★■★■\n\n");
        i.setLength(0);
        i.append("\n\n■★■★■★■★■★■★■★■★■★■\n\ncost time  info\n\n■★■★■★■★■★■★■★■★■★■\n\n");
    }

    public static void a(int r5, String r6) {
        if (a == true) goto L6;
        return;
    L6:
        if (r5 != 3) goto L8;
        StringBuilder r0 = new StringBuilder("【");
        int r2 = e;
        e = r2 + 1;
        r0.append(r2);
        r0.append("】:");
        r0.append(r6);
        r0.append("\n");
        b(r5, r0.toString());
        r5 = 1;
    L8:
        StringBuilder r1 = new StringBuilder("【");
        int r3 = d;
        d = r3 + 1;
        r1.append(r3);
        r1.append("】\n时间戳:");
        r1.append(System.currentTimeMillis());
        r1.append("\n时间差:");
        r1.append(System.currentTimeMillis() - c);
        r1.append("\n数据:\n");
        r1.append(r6);
        r1.append("\n\n");
        b(r5, r1.toString());
        c = System.currentTimeMillis();
    }

    public static void a(Exception r1) {
        if (a == false) goto L6;
        r1.printStackTrace();
        return;
    }

    public static void a(String r1) {
        if (a == false) goto L6;
        ac.d();
        a(0, r1);
        return;
    }

    public static void a(boolean r0) {
        a = r0;
    }

    private static void b(int r1, String r2) {
        if (a == true) goto L5;
        return;
    L5:
        if (r1 != 0) goto L7;
        StringBuilder r3 = g;
    L14:
        r3.append(r2);
    L15:
        f.append(r2);
        return;
    L7:
        if (r1 != 2) goto L9;
        r3 = h;
        goto L14
    L9:
        if (r1 != 3) goto L15;
        r3 = i;
        goto L14
    }

    public static void b(String r1) {
        if (a == false) goto L6;
        ac.d();
        a(0, r1);
        return;
    }

    public static void c(String r1) {
        ac.d();
        a(0, r1);
    }
}
