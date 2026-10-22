package kotlin.reflect.jvm.internal.impl.storage;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
class SingleThreadValue<T> {
    private final Thread thread;
    private final T value;

    public boolean hasValue() {
        if (this.thread != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public T getValue() {
        if (hasValue() == false) goto L7;
        return this.value;
    L7:
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public SingleThreadValue(T r1) {
        this.value = r1;
        this.thread = ThreadMethodProxy.currentThread();
    }
}
