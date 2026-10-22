package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements CoroutineContext.Key {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal f18959a;

    public x(ThreadLocal r5) {
        this.f18959a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f18959a, ((x) r5).f18959a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f18959a.hashCode();
    }

    public final String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f18959a + ')';
    }
}
