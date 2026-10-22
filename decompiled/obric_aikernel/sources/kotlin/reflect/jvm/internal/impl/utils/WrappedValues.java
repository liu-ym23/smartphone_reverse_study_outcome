package kotlin.reflect.jvm.internal.impl.utils;

import com.bytedance.crash.entity.EventBody;

/* JADX INFO: loaded from: classes3.dex */
public class WrappedValues {
    private static final Object NULL_VALUE = null;
    public static volatile boolean throwWrappedProcessCanceledException;

    private static final class ThrowableWrapper {
        private final Throwable throwable;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 1) goto L5;
            String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r10 == 1) goto L9;
            int r12 = 3;
        L10:
            Object[] r13 = new Object[r12];
            if (r10 == 1) goto L13;
            r13[0] = "throwable";
        L14:
            if (r10 == 1) goto L16;
            r13[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
        L17:
            if (r10 == 1) goto L19;
            r13[2] = "<init>";
        L19:
            String r14 = String.format(r11, r13);
            if (r10 == 1) goto L23;
            throw new IllegalArgumentException(r14);
        L23:
            throw new IllegalStateException(r14);
        L16:
            r13[1] = "getThrowable";
            goto L17
        L13:
            r13[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            goto L14
        L9:
            r12 = 2;
            goto L10
        L5:
            r11 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        private ThrowableWrapper(Throwable r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.throwable = r10;
        }

        /* synthetic */ ThrowableWrapper(Throwable r10, AnonymousClass1 r11) {
            this(r10);
        }

        public Throwable getThrowable() {
            Throwable r10 = this.throwable;
            if (r10 != null) goto L5;
            $$$reportNull$$$0(1);
        L5:
            return r10;
        }

        public String toString() {
            return this.throwable.toString();
        }
    }

    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable r10) {
            super("Rethrow stored exception", r10);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 1) goto L6;
        if (r10 == 2) goto L6;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L11;
        int r12 = 3;
    L12:
        Object[] r13 = new Object[r12];
        if (r10 == 1) goto L18;
        if (r10 == 2) goto L18;
        if (r10 == 3) goto L17;
        r13[0] = EventBody.KEY_VALUE;
    L19:
        if (r10 == 1) goto L22;
        if (r10 == 2) goto L22;
        r13[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
    L23:
        if (r10 == 1) goto L31;
        if (r10 == 2) goto L31;
        if (r10 != 3) goto L27;
        r13[2] = "escapeThrowable";
        goto L31
    L27:
        if (r10 == 4) goto L29;
        r13[2] = "unescapeNull";
        goto L31
    L29:
        r13[2] = "unescapeExceptionOrNull";
    L31:
        String r14 = String.format(r11, r13);
        if (r10 == 1) goto L36;
        if (r10 == 2) goto L36;
        throw new IllegalArgumentException(r14);
    L36:
        throw new IllegalStateException(r14);
    L22:
        r13[1] = "escapeNull";
        goto L23
    L17:
        r13[0] = "throwable";
    L18:
        r13[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
    L11:
        r12 = 2;
    L6:
        r11 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static {
        NULL_VALUE = new AnonymousClass1();
        throwWrappedProcessCanceledException = false;
    }

    public static <V> Object escapeNull(V r10) {
        if (r10 != null) goto L6;
        r10 = (V) NULL_VALUE;
        if (r10 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        return r10;
    }

    public static Object escapeThrowable(Throwable r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(3);
    L5:
        return new ThrowableWrapper(r10, null);
    }

    public static <V> V unescapeExceptionOrNull(Object r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return (V) unescapeNull(unescapeThrowable(r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V unescapeNull(Object r10) {
        if (r10 != 0) goto L5;
        $$$reportNull$$$0(0);
    L5:
        if (r10 != NULL_VALUE) goto L8;
        return null;
    L8:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V unescapeThrowable(Object r10) {
        if ((r10 instanceof ThrowableWrapper) == false) goto L12;
        Throwable r11 = ((ThrowableWrapper) r10).getThrowable();
        if (throwWrappedProcessCanceledException == false) goto L11;
        if (ExceptionUtilsKt.isProcessCanceledException(r11) == false) goto L11;
        throw new WrappedProcessCanceledException(r11);
    L11:
        throw ExceptionUtilsKt.rethrow(r11);
    L12:
        return r10;
    }
}
