package r;

import com.airbnb.lottie.model.content.Mask$MaskMode;
import com.airbnb.lottie.model.layer.Layer$LayerType;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21578a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f21579b = null;

    static {
        int[] r5 = new int[Mask$MaskMode.values().length];
        f21579b = r5;
        r5[Mask$MaskMode.MASK_MODE_NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
    L32:
        f21579b[Mask$MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
    L40:
        f21579b[Mask$MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
    L50:
        f21579b[Mask$MaskMode.MASK_MODE_ADD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
    L10:
        int[] r10 = new int[Layer$LayerType.values().length];
        f21578a = r10;
        r10[Layer$LayerType.SHAPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
    L34:
        f21578a[Layer$LayerType.PRE_COMP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
    L38:
        f21578a[Layer$LayerType.SOLID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
    L44:
        f21578a[Layer$LayerType.IMAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
    L30:
        f21578a[Layer$LayerType.NULL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
    L36:
        f21578a[Layer$LayerType.TEXT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
    L48:
        f21578a[Layer$LayerType.UNKNOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        return;
    }
}
