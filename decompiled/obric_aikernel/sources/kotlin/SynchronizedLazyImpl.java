package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {
    private volatile Object _value;
    private Function0<? extends T> initializer;
    private final Object lock;

    public SynchronizedLazyImpl(Function0<? extends T> r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "initializer");
        this.initializer = r10;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
        if (r11 != null) goto L5;
        r11 = this;
    L5:
        this.lock = r11;
    }

    public /* synthetic */ SynchronizedLazyImpl(Function0 r10, Object r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T r10 = (T) this._value;
        UNINITIALIZED_VALUE r11 = UNINITIALIZED_VALUE.INSTANCE;
        if (r10 == r11) goto L5;
        return r10;
    L5:
        Object r12 = this.lock;
        monitor-enter(r12);
        T r13 = (T) this._value;
        if (r13 != r11) goto L11;
        Function0<? extends T> r14 = this.initializer;     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L13
        r13 = r14.invoke();     // Catch: Throwable -> L13
        this._value = r13;     // Catch: Throwable -> L13
        this.initializer = null;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r12);
        return r13;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this._value == UNINITIALIZED_VALUE.INSTANCE) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        if (isInitialized() == true) goto L7;
        return "Lazy value not initialized yet.";
    L7:
        return String.valueOf(getValue());
    }
}
