package kotlin.reflect.jvm.internal.impl.utils;

/* JADX INFO: loaded from: classes3.dex */
public class WrappedValues {
    private static final Object NULL_VALUE = null;
    public static volatile boolean throwWrappedProcessCanceledException;

    public static final class ThrowableWrapper {
        private final Throwable throwable;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 1) goto L5;
            String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r10 == 1) goto L9;
            int r11 = 3;
        L10:
            Object[] r12 = new Object[r11];
            if (r10 == 1) goto L13;
            r12[0] = "throwable";
        L14:
            if (r10 == 1) goto L16;
            r12[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
        L17:
            if (r10 == 1) goto L19;
            r12[2] = "<init>";
        L19:
            String r13 = String.format(r5, r12);
            if (r10 == 1) goto L23;
            throw new IllegalArgumentException(r13);
        L23:
            throw new IllegalStateException(r13);
        L16:
            r12[1] = "getThrowable";
            goto L17
        L13:
            r12[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            goto L14
        L9:
            r11 = 2;
            goto L10
        L5:
            r5 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        public /* synthetic */ ThrowableWrapper(Throwable r5, AnonymousClass1 r10) {
            this(r5);
        }

        public Throwable getThrowable() {
            Throwable r5 = this.throwable;
            if (r5 != null) goto L5;
            $$$reportNull$$$0(1);
        L5:
            return r5;
        }

        public String toString() {
            return this.throwable.toString();
        }

        private ThrowableWrapper(Throwable r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.throwable = r5;
        }
    }

    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable r5) {
            super("Rethrow stored exception", r5);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 1) goto L6;
        if (r10 == 2) goto L6;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L11;
        int r11 = 3;
    L12:
        Object[] r12 = new Object[r11];
        if (r10 == 1) goto L18;
        if (r10 == 2) goto L18;
        if (r10 == 3) goto L17;
        r12[0] = "value";
    L19:
        if (r10 == 1) goto L22;
        if (r10 == 2) goto L22;
        r12[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
    L23:
        if (r10 == 1) goto L31;
        if (r10 == 2) goto L31;
        if (r10 != 3) goto L27;
        r12[2] = "escapeThrowable";
        goto L31
    L27:
        if (r10 == 4) goto L29;
        r12[2] = "unescapeNull";
        goto L31
    L29:
        r12[2] = "unescapeExceptionOrNull";
    L31:
        String r13 = String.format(r5, r12);
        if (r10 == 1) goto L36;
        if (r10 == 2) goto L36;
        throw new IllegalArgumentException(r13);
    L36:
        throw new IllegalStateException(r13);
    L22:
        r12[1] = "escapeNull";
        goto L23
    L17:
        r12[0] = "throwable";
    L18:
        r12[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
    L11:
        r11 = 2;
    L6:
        r5 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static {
        NULL_VALUE = new AnonymousClass1();
        throwWrappedProcessCanceledException = false;
    }

    public static <V> Object escapeNull(V r5) {
        if (r5 != null) goto L6;
        r5 = (V) NULL_VALUE;
        if (r5 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        return r5;
    }

    public static Object escapeThrowable(Throwable r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(3);
    L5:
        return new ThrowableWrapper(r5, null);
    }

    public static <V> V unescapeExceptionOrNull(Object r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return (V) unescapeNull(unescapeThrowable(r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V unescapeNull(Object r5) {
        if (r5 != 0) goto L5;
        $$$reportNull$$$0(0);
    L5:
        if (r5 != NULL_VALUE) goto L8;
        return null;
    L8:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V unescapeThrowable(Object r5) {
        if ((r5 instanceof ThrowableWrapper) == false) goto L12;
        Throwable r10 = ((ThrowableWrapper) r5).getThrowable();
        if (throwWrappedProcessCanceledException == false) goto L11;
        if (ExceptionUtilsKt.isProcessCanceledException(r10) == false) goto L11;
        throw new WrappedProcessCanceledException(r10);
    L11:
        throw ExceptionUtilsKt.rethrow(r10);
    L12:
        return r5;
    }
}
