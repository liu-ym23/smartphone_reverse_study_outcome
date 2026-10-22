package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18924a = null;

    static {
        int[] r5 = new int[CoroutineStart.values().length];
        r5[CoroutineStart.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r5[CoroutineStart.ATOMIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r5[CoroutineStart.UNDISPATCHED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r5[CoroutineStart.LAZY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        f18924a = r5;
    }
}
