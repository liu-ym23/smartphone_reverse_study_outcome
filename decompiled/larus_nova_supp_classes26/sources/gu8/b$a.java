package gu8;

import com.bytedance.crash.CrashType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public /* synthetic */ class b$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[CrashType.values().length];
        r0[CrashType.JAVA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r0[CrashType.LAUNCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r0[CrashType.NATIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r0[CrashType.ANR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        a = r0;
    }
}
