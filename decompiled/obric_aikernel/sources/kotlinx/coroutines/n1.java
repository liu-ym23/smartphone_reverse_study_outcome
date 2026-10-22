package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class n1 implements l0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n1 f10613c = null;

    static {
        f10613c = new n1();
    }

    private n1() {
    }

    @Override // kotlinx.coroutines.l0
    public CoroutineContext getCoroutineContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
