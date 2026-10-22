package com.bytedance.crash.dumper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class l {
    public static String a(int r1) {
        if (r1 <= 750) goto L7;
        return "(750 - MAX)";
    L7:
        if (r1 <= 650) goto L11;
        return "(650 - 750]";
    L11:
        if (r1 <= 550) goto L15;
        return "(550 - 650]";
    L15:
        if (r1 <= 450) goto L19;
        return "(450 - 550]";
    L19:
        if (r1 <= 350) goto L23;
        return "(350 - 450]";
    L23:
        if (r1 <= 250) goto L27;
        return "(250 - 350]";
    L27:
        if (r1 <= 150) goto L30;
        return "(150 - 250]";
    L30:
        return "[0 - 150]";
    }

    public static String b(long r3) {
        long r4 = r3 * 1024;
        if (r4 <= 25769803776L) goto L7;
        return "(24GB - MAX)";
    L7:
        if (r4 <= 21474836480L) goto L11;
        return "(20GB - 24GB]";
    L11:
        if (r4 <= 17179869184L) goto L15;
        return "(16GB - 20GB]";
    L15:
        if (r4 <= 12884901888L) goto L19;
        return "(12GB - 16GB]";
    L19:
        if (r4 <= 10737418240L) goto L23;
        return "(10GB - 12GB]";
    L23:
        if (r4 <= 9663676416L) goto L27;
        return "(9GB - 10GB]";
    L27:
        if (r4 <= 8589934592L) goto L31;
        return "(8GB - 9GB]";
    L31:
        if (r4 <= 7516192768L) goto L35;
        return "(7GB - 8GB]";
    L35:
        if (r4 <= 6442450944L) goto L39;
        return "(6GB - 7GB]";
    L39:
        if (r4 <= 5368709120L) goto L43;
        return "(5GB - 6GB]";
    L43:
        if (r4 <= 4294967296L) goto L46;
        return "(4GB - 5GB]";
    L46:
        return "[0GB - 4GB]";
    }

    public static String c(long r4, boolean r6) {
        if (r6 == false) goto L4;
        long r0 = 4294967296L;
    L5:
        float r5 = r4 * 1024;
        float r7 = r0;
        if (r5 <= (0.95f * r7)) goto L10;
        return "(95% - 100%]";
    L10:
        if (r5 <= (0.9f * r7)) goto L14;
        return "(90% - 95%]";
    L14:
        if (r5 <= (0.85f * r7)) goto L18;
        return "(85% - 90%]";
    L18:
        if (r5 <= (0.8f * r7)) goto L22;
        return "(80% - 85%]";
    L22:
        if (r5 <= (0.7f * r7)) goto L26;
        return "(70% - 80%]";
    L26:
        if (r5 <= (0.6f * r7)) goto L30;
        return "(60% - 70%]";
    L30:
        if (r5 <= (r7 * 0.5f)) goto L33;
        return "(50% - 60%]";
    L33:
        return "[0% - 50%]";
    L4:
        r0 = 3221225472L;
        goto L5
    }
}
