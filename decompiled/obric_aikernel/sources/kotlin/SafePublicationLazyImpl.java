package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class SafePublicationLazyImpl<T> implements Lazy<T>, Serializable {
    public static final Companion Companion = null;
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater = null;
    private volatile Object _value;

    /* JADX INFO: renamed from: final, reason: not valid java name */
    private final Object f0final;
    private volatile Function0<? extends T> initializer;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    }

    public SafePublicationLazyImpl(Function0<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "initializer");
        this.initializer = r10;
        UNINITIALIZED_VALUE r11 = UNINITIALIZED_VALUE.INSTANCE;
        this._value = r11;
        this.f0final = r11;
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
        Function0<? extends T> r12 = this.initializer;
        if (r12 == null) goto L12;
        T r13 = r12.invoke();
        if (valueUpdater.compareAndSet(this, r11, r13) == false) goto L12;
        this.initializer = null;
        return r13;
    L12:
        return (T) this._value;
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
