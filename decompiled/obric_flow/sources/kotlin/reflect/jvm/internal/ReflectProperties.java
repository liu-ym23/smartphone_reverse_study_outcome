package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public class ReflectProperties {

    public static class LazySoftVal<T> extends Val<T> implements Function0<T> {
        private final Function0<T> initializer;
        private volatile SoftReference<Object> value;

        private static /* synthetic */ void $$$reportNull$$$0(int r5) {
            throw new IllegalArgumentException("Argument for @NotNull parameter 'initializer' of kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal.<init> must not be null");
        }

        public LazySoftVal(T r5, Function0<T> r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.value = null;
            this.initializer = r10;
            if (r5 == null) goto L8;
            this.value = new SoftReference(escape(r5));
            return;
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.jvm.functions.Function0
        public T invoke() {
            SoftReference<Object> r5 = this.value;
            if (r5 == null) goto L8;
            Object r10 = r5.get();
            if (r10 == null) goto L8;
            return unescape(r10);
        L8:
            T r11 = this.initializer.invoke();
            this.value = new SoftReference(escape(r11));
            return r11;
        }
    }

    public static class LazyVal<T> extends Val<T> {
        private final Function0<T> initializer;
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int r5) {
            throw new IllegalArgumentException("Argument for @NotNull parameter 'initializer' of kotlin/reflect/jvm/internal/ReflectProperties$LazyVal.<init> must not be null");
        }

        public LazyVal(Function0<T> r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.value = null;
            this.initializer = r5;
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.jvm.functions.Function0
        public T invoke() {
            Object r5 = this.value;
            if (r5 != null) goto L5;
            T r10 = this.initializer.invoke();
            this.value = escape(r10);
            return r10;
        L5:
            return unescape(r5);
        }
    }

    public static abstract class Val<T> {
        private static final Object NULL_VALUE = null;

        static {
            NULL_VALUE = new AnonymousClass1();
        }

        public Val() {
        }

        public Object escape(T r5) {
            if (r5 == null) goto L4;
            return r5;
        L4:
            return NULL_VALUE;
        }

        public final T getValue(Object r5, Object r10) {
            return invoke();
        }

        public abstract T invoke();

        /* JADX WARN: Multi-variable type inference failed */
        public T unescape(Object r5) {
            if (r5 != NULL_VALUE) goto L6;
            return null;
        L6:
            return r5;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r5) {
        Object[] r10 = new Object[3];
        r10[0] = "initializer";
        r10[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (r5 == 1) goto L6;
        if (r5 == 2) goto L6;
        r10[2] = "lazy";
    L8:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r10));
    L6:
        r10[2] = "lazySoft";
        goto L8
    }

    public static <T> LazyVal<T> lazy(Function0<T> r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new LazyVal(r5);
    }

    public static <T> LazySoftVal<T> lazySoft(T r5, Function0<T> r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return new LazySoftVal(r5, r10);
    }

    public static <T> LazySoftVal<T> lazySoft(Function0<T> r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return lazySoft(null, r5);
    }
}
