package k;

import com.airbnb.lottie.model.content.PolystarShape$Type;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18539a = null;

    static {
        int[] r5 = new int[PolystarShape$Type.values().length];
        f18539a = r5;
        r5[PolystarShape$Type.STAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f18539a[PolystarShape$Type.POLYGON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
