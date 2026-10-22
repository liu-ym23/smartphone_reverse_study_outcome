package kotlin.reflect.jvm.internal.impl.storage;

/* JADX INFO: loaded from: classes3.dex */
class SingleThreadValue<T> {
    private final Thread thread;
    private final T value;

    SingleThreadValue(T r10) {
        this.value = r10;
        this.thread = Thread.currentThread();
    }

    public T getValue() {
        if (hasValue() == false) goto L7;
        return this.value;
    L7:
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean hasValue() {
        if (this.thread != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }
}
