package mt;

import io.reactivex.BackpressureStrategy;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f20171a = null;

    static {
        int[] r5 = new int[BackpressureStrategy.values().length];
        f20171a = r5;
        r5[BackpressureStrategy.DROP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L12:
        f20171a[BackpressureStrategy.LATEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L14:
        f20171a[BackpressureStrategy.MISSING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L18:
        f20171a[BackpressureStrategy.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
        return;
    }
}
