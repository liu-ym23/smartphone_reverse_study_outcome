package kotlinx.serialization.json.internal;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f19434a = null;

    static {
        int[] r5 = new int[WriteMode.values().length];
        r5[WriteMode.LIST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r5[WriteMode.MAP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r5[WriteMode.POLY_OBJ.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r5[WriteMode.OBJ.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        f19434a = r5;
    }
}
