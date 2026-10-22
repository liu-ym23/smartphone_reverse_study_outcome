package kotlin.reflect.jvm.internal.impl.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class WrappedValues {
    private static final Object NULL_VALUE = null;
    public static volatile boolean throwWrappedProcessCanceledException;

    public static final class ThrowableWrapper {
        private final Throwable throwable;

        private static /* synthetic */ void $$$reportNull$$$0(int r7) {
            if (r7 == 1) goto L5;
            String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r7 == 1) goto L9;
            int r3 = 3;
        L10:
            Object[] r4 = new Object[r3];
            if (r7 == 1) goto L13;
            r4[0] = "throwable";
        L14:
            if (r7 == 1) goto L16;
            r4[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
        L17:
            if (r7 == 1) goto L19;
            r4[2] = "<init>";
        L19:
            String r2 = String.format(r1, r4);
            if (r7 == 1) goto L23;
            throw new IllegalArgumentException(r2);
        L23:
            throw new IllegalStateException(r2);
        L16:
            r4[1] = "getThrowable";
            goto L17
        L13:
            r4[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            goto L14
        L9:
            r3 = 2;
            goto L10
        L5:
            r1 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        public Throwable getThrowable() {
            Throwable r0 = this.throwable;
            if (r0 != null) goto L5;
            $$$reportNull$$$0(1);
        L5:
            return r0;
        }

        public String toString() {
            return this.throwable.toString();
        }

        private ThrowableWrapper(Throwable r2) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.throwable = r2;
        }

        public /* synthetic */ ThrowableWrapper(Throwable r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r8) {
        if (r8 == 1) goto L6;
        if (r8 == 2) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r8 == 1) goto L11;
        if (r8 == 2) goto L11;
        int r4 = 3;
    L12:
        Object[] r5 = new Object[r4];
        if (r8 == 1) goto L18;
        if (r8 == 2) goto L18;
        if (r8 == 3) goto L17;
        r5[0] = "value";
    L19:
        if (r8 == 1) goto L22;
        if (r8 == 2) goto L22;
        r5[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
    L23:
        if (r8 == 1) goto L31;
        if (r8 == 2) goto L31;
        if (r8 != 3) goto L27;
        r5[2] = "escapeThrowable";
        goto L31
    L27:
        if (r8 == 4) goto L29;
        r5[2] = "unescapeNull";
        goto L31
    L29:
        r5[2] = "unescapeExceptionOrNull";
    L31:
        String r3 = String.format(r2, r5);
        if (r8 == 1) goto L36;
        if (r8 == 2) goto L36;
        throw new IllegalArgumentException(r3);
    L36:
        throw new IllegalStateException(r3);
    L22:
        r5[1] = "escapeNull";
        goto L23
    L17:
        r5[0] = "throwable";
    L18:
        r5[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
    L11:
        r4 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static {
        NULL_VALUE = new AnonymousClass1();
        throwWrappedProcessCanceledException = false;
    }

    public static <V> Object escapeNull(V r1) {
        if (r1 != null) goto L6;
        r1 = (V) NULL_VALUE;
        if (r1 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        return r1;
    }

    public static Object escapeThrowable(Throwable r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(3);
    L5:
        return new ThrowableWrapper(r2, null);
    }

    public static <V> V unescapeExceptionOrNull(Object r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return (V) unescapeNull(unescapeThrowable(r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V unescapeNull(Object r1) {
        if (r1 != 0) goto L5;
        $$$reportNull$$$0(0);
    L5:
        if (r1 != NULL_VALUE) goto L8;
        return null;
    L8:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V unescapeThrowable(Object r1) {
        if ((r1 instanceof ThrowableWrapper) == false) goto L12;
        Throwable r2 = ((ThrowableWrapper) r1).getThrowable();
        if (throwWrappedProcessCanceledException == false) goto L11;
        if (ExceptionUtilsKt.isProcessCanceledException(r2) == false) goto L11;
        throw new WrappedProcessCanceledException(r2);
    L11:
        throw ExceptionUtilsKt.rethrow(r2);
    L12:
        return r1;
    }
}
