package kotlinx.coroutines.flow;

import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18850a = null;

    static {
        int[] r5 = new int[BufferOverflow.values().length];
        r5[BufferOverflow.SUSPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r5[BufferOverflow.DROP_LATEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r5[BufferOverflow.DROP_OLDEST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f18850a = r5;
    }
}
