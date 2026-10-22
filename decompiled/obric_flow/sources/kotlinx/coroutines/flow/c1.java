package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18833a = null;

    static {
        int[] r5 = new int[SharingCommand.values().length];
        r5[SharingCommand.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r5[SharingCommand.STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r5[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f18833a = r5;
    }
}
