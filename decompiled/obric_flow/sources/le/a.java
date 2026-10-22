package le;

import com.bytedance.ies.xbridge.model.idl.XDynamicType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f19600a = null;

    static {
        int[] r5 = new int[XDynamicType.values().length];
        r5[XDynamicType.String.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
    L25:
        r5[XDynamicType.Number.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
    L39:
        r5[XDynamicType.Boolean.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
    L29:
        r5[XDynamicType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
    L31:
        r5[XDynamicType.Int.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
    L23:
        r5[XDynamicType.Map.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
    L33:
        r5[XDynamicType.Array.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
    L35:
        r5[XDynamicType.ByteArray.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
    L27:
        r5[XDynamicType.Null.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
    L12:
        f19600a = r5;
    }
}
