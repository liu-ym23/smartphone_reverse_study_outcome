package i2;

import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f17494a = null;

    static {
        int[] r5 = new int[ReadableType.values().length];
        r5[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
    L23:
        r5[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
    L35:
        r5[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
    L25:
        r5[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
    L27:
        r5[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
    L21:
        r5[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
    L29:
        r5[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
    L31:
        r5[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
    L11:
        f17494a = r5;
    }
}
