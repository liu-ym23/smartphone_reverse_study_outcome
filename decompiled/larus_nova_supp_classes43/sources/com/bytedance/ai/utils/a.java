package com.bytedance.ai.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.ai.utils.a$a, reason: collision with other inner class name */
    public static final class C0050a {
        public static String a() {
            h2.a r0 = f2.b.c;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L7:
            boolean r10 = false;
        L8:
            if (r10 == true) goto L16;
            if (r0 != null) goto L11;
        L13:
            if (r1 == true) goto L16;
            return "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source";
        L11:
            if (r0.p != true) goto L13;
            r1 = true;
        L16:
            return "https://tosv.byted.org/obj/gecko-internal";
        L5:
            if (r0.n != true) goto L7;
            r10 = true;
            goto L8
        }

        public static boolean b() {
            h2.a r0 = f2.b.c;
            if (r0 != null) goto L5;
        L7:
            boolean r10 = false;
        L8:
            if (r10 == true) goto L15;
            if (r0 != null) goto L11;
        L13:
            boolean r1 = false;
        L14:
            if (r1 == true) goto L15;
            return false;
        L11:
            if (r0.p != true) goto L13;
            r1 = true;
        L15:
            return true;
        L5:
            if (r0.n != true) goto L7;
            r10 = true;
            goto L8
        }
    }

    static {
    }
}
