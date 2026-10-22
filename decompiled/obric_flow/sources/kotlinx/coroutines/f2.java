package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class f2 extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f2 f18826a = null;

    static {
        f18826a = new f2();
    }

    @Override // kotlinx.coroutines.z
    public final void dispatch(CoroutineContext r5, Runnable r10) {
        k2 r11 = (k2) r5.get(k2.f18976b);
        if (r11 == null) goto L7;
        r11.f18977a = true;
        return;
    L7:
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // kotlinx.coroutines.z
    public final boolean isDispatchNeeded(CoroutineContext r5) {
        return false;
    }

    @Override // kotlinx.coroutines.z
    public final z limitedParallelism(int r5, String r10) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // kotlinx.coroutines.z
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
