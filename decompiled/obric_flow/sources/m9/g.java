package m9;

import com.bytedance.crash.CrashType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f20053a = null;

    static {
        int[] r5 = new int[CrashType.values().length];
        f20053a = r5;
        r5[CrashType.JAVA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
    L20:
        f20053a[CrashType.LAUNCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
    L24:
        f20053a[CrashType.NATIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
    L34:
        f20053a[CrashType.ANR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
    L22:
        f20053a[CrashType.DART.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
    L26:
        f20053a[CrashType.GAME.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
    L28:
        f20053a[CrashType.CUSTOM_JAVA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
    L30:
        f20053a[CrashType.ENSURE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
        return;
    }
}
