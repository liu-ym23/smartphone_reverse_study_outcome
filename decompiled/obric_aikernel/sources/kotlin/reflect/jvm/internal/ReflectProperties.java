package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public class ReflectProperties {

    public static class LazySoftVal<T> extends Val<T> implements Function0<T> {
        private final Function0<T> initializer;
        private volatile SoftReference<Object> value;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"}));
        }

        public LazySoftVal(T r10, Function0<T> r11) {
            if (r11 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.value = null;
            this.initializer = r11;
            if (r10 == null) goto L8;
            this.value = new SoftReference(escape(r10));
            return;
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.jvm.functions.Function0
        public T invoke() {
            SoftReference<Object> r10 = this.value;
            if (r10 == null) goto L8;
            Object r11 = r10.get();
            if (r11 == null) goto L8;
            return unescape(r11);
        L8:
            T r12 = this.initializer.invoke();
            this.value = new SoftReference(escape(r12));
            return r12;
        }
    }

    public static class LazyVal<T> extends Val<T> {
        private final Function0<T> initializer;
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"}));
        }

        public LazyVal(Function0<T> r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.value = null;
            this.initializer = r10;
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.jvm.functions.Function0
        public T invoke() {
            Object r10 = this.value;
            if (r10 != null) goto L5;
            T r11 = this.initializer.invoke();
            this.value = escape(r11);
            return r11;
        L5:
            return unescape(r10);
        }
    }

    public static abstract class Val<T> {
        private static final Object NULL_VALUE = null;

        static {
            NULL_VALUE = new AnonymousClass1();
        }

        public Val() {
        }

        protected Object escape(T r10) {
            if (r10 == null) goto L4;
            return r10;
        L4:
            return NULL_VALUE;
        }

        public final T getValue(Object r10, Object r11) {
            return invoke();
        }

        public abstract T invoke();

        /* JADX WARN: Multi-variable type inference failed */
        protected T unescape(Object r10) {
            if (r10 != NULL_VALUE) goto L6;
            return null;
        L6:
            return r10;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        Object[] r11 = new Object[3];
        r11[0] = "initializer";
        r11[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (r10 == 1) goto L6;
        if (r10 == 2) goto L6;
        r11[2] = "lazy";
    L8:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
    L6:
        r11[2] = "lazySoft";
        goto L8
    }

    public static <T> LazyVal<T> lazy(Function0<T> r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new LazyVal(r10);
    }

    public static <T> LazySoftVal<T> lazySoft(T r10, Function0<T> r11) {
        if (r11 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return new LazySoftVal(r10, r11);
    }

    public static <T> LazySoftVal<T> lazySoft(Function0<T> r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return lazySoft(null, r10);
    }
}
