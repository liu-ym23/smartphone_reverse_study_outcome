package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class Suppliers {

    static class ExpiringMemoizingSupplier<T> implements r<T>, Serializable {
        private static final long serialVersionUID = 0;
        final r<T> delegate;
        final long durationNanos;
        volatile transient long expirationNanos;
        volatile transient T value;

        ExpiringMemoizingSupplier(r<T> r3, long r4, TimeUnit r6) {
            this.delegate = (r) ZeusTransformUtils.preCheckCast(n.a((r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.memorydata.plugin")), r.class, "com.obric.memorydata.plugin");
            this.durationNanos = r6.toNanos(r4);
            if (r4 <= 0) goto L5;
            boolean r2 = true;
        L6:
            n.a(r2, "duration (%s %s) must be > 0", r4, r6);
            return;
        L5:
            r2 = false;
            goto L6
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public T get() {
            long r0 = this.expirationNanos;
            long r2 = System.nanoTime();
            if (r0 != 0) goto L5;
        L6:
            monitor-enter(this);
        L18:
            th = move-exception;
            throw th;
        L8:
            if (r0 != this.expirationNanos) goto L15;
            T r1 = this.delegate.get();     // Catch: Throwable -> L18
            this.value = r1;     // Catch: Throwable -> L18
            long r3 = r2 + this.durationNanos;     // Catch: Throwable -> L18
            if (r3 != 0) goto L12;
            r3 = 1;
        L12:
            this.expirationNanos = r3;     // Catch: Throwable -> L18
            monitor-exit(this);     // Catch: Throwable -> L18
            return r1;
        L15:
            monitor-exit(this);     // Catch: Throwable -> L18
        L17:
            return (T) j.a(this.value);
        L5:
            if ((r2 - r0) < 0) goto L17;
            goto L6
        }

        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.delegate + ", " + this.durationNanos + ", NANOS)";
        }
    }

    static class MemoizingSupplier<T> implements r<T>, Serializable {
        private static final long serialVersionUID = 0;
        final r<T> delegate;
        volatile transient boolean initialized;
        transient T value;

        MemoizingSupplier(r<T> r3) {
            this.delegate = (r) ZeusTransformUtils.preCheckCast(n.a((r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.memorydata.plugin")), r.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public T get() {
            if (this.initialized == true) goto L16;
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L6:
            if (this.initialized == true) goto L10;
            T r0 = this.delegate.get();     // Catch: Throwable -> L12
            this.value = r0;     // Catch: Throwable -> L12
            this.initialized = true;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            return r0;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
        L16:
            return (T) j.a(this.value);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder().append("Suppliers.memoize(");
            if (this.initialized == false) goto L5;
            Object r3 = "<supplier that returned " + this.value + ">";
        L7:
            return r0.append(r3).append(")").toString();
        L5:
            r3 = this.delegate;
            goto L7
        }
    }

    private static class SupplierComposition<F, T> implements r<T>, Serializable {
        private static final long serialVersionUID = 0;
        final g<? super F, T> function;
        final r<F> supplier;

        SupplierComposition(g<? super F, T> r3, r<F> r4) {
            g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
            r r6 = (r) ZeusTransformUtils.wrapperContextForParams(r4, r.class, "com.obric.memorydata.plugin");
            this.function = (g) ZeusTransformUtils.preCheckCast(n.a(r5), g.class, "com.obric.memorydata.plugin");
            this.supplier = (r) ZeusTransformUtils.preCheckCast(n.a(r6), r.class, "com.obric.memorydata.plugin");
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, SupplierComposition.class) == false) goto L10;
            SupplierComposition r5 = (SupplierComposition) ZeusTransformUtils.preCheckCast(r4, SupplierComposition.class, "com.obric.memorydata.plugin");
            if (this.function.equals(r5.function) == true) goto L7;
            return false;
        L7:
            if (this.supplier.equals(r5.supplier) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public T get() {
            return this.function.apply(this.supplier.get());
        }

        public int hashCode() {
            return k.a(new Object[]{this.function, this.supplier});
        }

        public String toString() {
            return "Suppliers.compose(" + this.function + ", " + this.supplier + ")";
        }
    }

    private static final enum SupplierFunctionImpl extends Enum<SupplierFunctionImpl> implements s<Object> {
        private static final /* synthetic */ SupplierFunctionImpl[] $VALUES = null;
        public static final SupplierFunctionImpl INSTANCE = null;

        private static /* synthetic */ SupplierFunctionImpl[] $values() {
            return new SupplierFunctionImpl[]{INSTANCE};
        }

        static {
            INSTANCE = new SupplierFunctionImpl("INSTANCE", 0);
            $VALUES = $values();
        }

        private SupplierFunctionImpl(String r1, int r2) {
            super(r1, r2);
        }

        public static SupplierFunctionImpl valueOf(String r2) {
            return (SupplierFunctionImpl) ZeusTransformUtils.preCheckCast(Enum.valueOf(SupplierFunctionImpl.class, r2), SupplierFunctionImpl.class, "com.obric.memorydata.plugin");
        }

        public static SupplierFunctionImpl[] values() {
            return (SupplierFunctionImpl[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SupplierFunctionImpl[].class, "com.obric.memorydata.plugin");
        }

        public Object apply(r<Object> r2) {
            return ((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin")).get();
        }

        @Override // com.google.common.base.g, java.util.function.Function
        public /* synthetic */ Object apply(Object r3) {
            return apply((r) ZeusTransformUtils.preCheckCast(r3, r.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Suppliers.supplierFunction()";
        }
    }

    private static class SupplierOfInstance<T> implements r<T>, Serializable {
        private static final long serialVersionUID = 0;
        final T instance;

        SupplierOfInstance(T r1) {
            this.instance = r1;
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, SupplierOfInstance.class) == false) goto L6;
            SupplierOfInstance r4 = (SupplierOfInstance) ZeusTransformUtils.preCheckCast(r3, SupplierOfInstance.class, "com.obric.memorydata.plugin");
            return k.a(this.instance, r4.instance);
        L6:
            return false;
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return k.a(new Object[]{this.instance});
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }
    }

    private static class ThreadSafeSupplier<T> implements r<T>, Serializable {
        private static final long serialVersionUID = 0;
        final r<T> delegate;

        ThreadSafeSupplier(r<T> r3) {
            this.delegate = (r) ZeusTransformUtils.preCheckCast(n.a((r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.memorydata.plugin")), r.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public T get() {
            r<T> r0 = this.delegate;
            monitor-enter(r0);
            T r1 = this.delegate.get();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.delegate + ")";
        }
    }

    public static <T> r<T> a(T r1) {
        return new SupplierOfInstance(r1);
    }
}
