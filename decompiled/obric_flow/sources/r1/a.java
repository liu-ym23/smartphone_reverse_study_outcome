package r1;

import com.bytedance.ai.bridge.core.annotation.DefaultType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21639a = null;

    static {
        int[] r5 = new int[DefaultType.values().length];
        r5[DefaultType.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
    L15:
        r5[DefaultType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
    L23:
        r5[DefaultType.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
    L17:
        r5[DefaultType.BOOL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
    L19:
        r5[DefaultType.STRING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
    L8:
        f21639a = r5;
    }
}
