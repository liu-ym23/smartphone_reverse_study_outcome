package f2a;

import com.larus.utils.logger.LogLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public /* synthetic */ class h$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LogLevel.values().length];
        r0[LogLevel.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r0[LogLevel.INFO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r0[LogLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r0[LogLevel.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        a = r0;
    }
}
