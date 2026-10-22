package pm;

import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21365a = null;

    static {
        int[] r5 = new int[ReadableType.values().length];
        f21365a = r5;
        r5[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
    L24:
        f21365a[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
    L28:
        f21365a[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
    L38:
        f21365a[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
    L26:
        f21365a[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
    L30:
        f21365a[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
    L32:
        f21365a[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
    L34:
        f21365a[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
    L22:
        f21365a[ReadableType.ByteArray.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
        return;
    }
}
