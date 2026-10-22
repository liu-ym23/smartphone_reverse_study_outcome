package com.bytedance.crash;

import androidx.core.app.NotificationCompat;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.constants.Constants;

/* JADX INFO: loaded from: classes.dex */
public final enum CrashType extends Enum<CrashType> {
    private static final /* synthetic */ CrashType[] $VALUES = null;
    public static final CrashType ALL = null;
    public static final CrashType ANR = null;
    public static final CrashType ASAN = null;
    public static final CrashType BLOCK = null;
    public static final CrashType CJAVA = null;
    public static final CrashType COREDUMP = null;
    public static final CrashType CUSTOM_JAVA = null;
    public static final CrashType DART = null;
    public static final CrashType ENSURE = null;
    public static final CrashType EVENT = null;
    public static final CrashType GAME = null;
    public static final CrashType JAVA = null;
    public static final CrashType LAUNCH = null;
    public static final CrashType NATIVE = null;
    public static final CrashType NATIVE_CUSTOMIZE = null;
    public static final CrashType OOM = null;
    public static final CrashType TSAN = null;
    public static final CrashType UNKNOWN = null;
    private final String mName;

    static {
        CrashType r10 = new CrashType("LAUNCH", 0, Constants.LAUNCH_TAG);
        LAUNCH = r10;
        CrashType r11 = new CrashType("JAVA", 1, "java");
        JAVA = r11;
        CrashType r12 = new CrashType("NATIVE", 2, "native");
        NATIVE = r12;
        CrashType r13 = new CrashType("ASAN", 3, "asan");
        ASAN = r13;
        CrashType r14 = new CrashType("TSAN", 4, "tsan");
        TSAN = r14;
        CrashType r15 = new CrashType("ANR", 5, AnrManager.ANR_ROOT_DIR);
        ANR = r15;
        CrashType r16 = new CrashType("NATIVE_CUSTOMIZE", 6, "ensure_zip");
        NATIVE_CUSTOMIZE = r16;
        CrashType r17 = new CrashType("BLOCK", 7, "block");
        BLOCK = r17;
        CrashType r18 = new CrashType("ENSURE", 8, "ensure");
        ENSURE = r18;
        CrashType r19 = new CrashType("DART", 9, "dart");
        DART = r19;
        CrashType r20 = new CrashType("GAME", 10, "game");
        GAME = r20;
        CrashType r21 = new CrashType("CUSTOM_JAVA", 11, "custom_java");
        CUSTOM_JAVA = r21;
        CrashType r22 = new CrashType("OOM", 12, "oom");
        OOM = r22;
        CrashType r23 = new CrashType("CJAVA", 13, "cjava");
        CJAVA = r23;
        CrashType r24 = new CrashType("COREDUMP", 14, "coredump");
        COREDUMP = r24;
        CrashType r25 = new CrashType("EVENT", 15, NotificationCompat.CATEGORY_EVENT);
        EVENT = r25;
        CrashType r26 = new CrashType("ALL", 16, "all");
        ALL = r26;
        CrashType r27 = new CrashType("UNKNOWN", 17, "unknown");
        UNKNOWN = r27;
        $VALUES = new CrashType[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27};
    }

    private CrashType(String r10, int r11, String r12) {
        super(r10, r11);
        this.mName = r12;
    }

    public static CrashType getType(String r10) {
        return valueOf(r10.toUpperCase());
    L5:
        return UNKNOWN;
    }

    public static CrashType valueOf(String r10) {
        return (CrashType) Enum.valueOf(CrashType.class, r10);
    }

    public static CrashType[] values() {
        return (CrashType[]) $VALUES.clone();
    }

    public String getName() {
        return this.mName;
    }

    @Override // java.lang.Enum
    public String toString() {
        return getName();
    }
}
