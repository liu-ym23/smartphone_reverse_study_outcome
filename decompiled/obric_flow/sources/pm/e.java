package pm;

import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21366a = null;

    static {
        int[] r5 = new int[ReadableType.values().length];
        f21366a = r5;
        r5[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
    L24:
        f21366a[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
    L28:
        f21366a[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
    L38:
        f21366a[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
    L26:
        f21366a[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
    L30:
        f21366a[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
    L32:
        f21366a[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
    L34:
        f21366a[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
    L22:
        f21366a[ReadableType.ByteArray.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
        return;
    }
}
