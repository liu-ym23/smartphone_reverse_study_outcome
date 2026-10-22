package kotlin.reflect.jvm.internal.impl.storage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public class LockBasedStorageManager implements StorageManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final StorageManager NO_LOCKS = null;
    private static final String PACKAGE_NAME = null;
    private final String debugText;
    private final ExceptionHandlingStrategy exceptionHandlingStrategy;
    protected final SimpleLock lock;

    private static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V> extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V> implements CacheWithNotNullValues<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 3) goto L5;
            String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r10 == 3) goto L9;
            int r12 = 3;
        L10:
            Object[] r13 = new Object[r12];
            if (r10 == 1) goto L17;
            if (r10 == 2) goto L16;
            if (r10 == 3) goto L15;
            r13[0] = "storageManager";
        L19:
            if (r10 == 3) goto L21;
            r13[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
        L22:
            if (r10 == 2) goto L25;
            if (r10 == 3) goto L26;
            r13[2] = "<init>";
        L26:
            String r14 = String.format(r11, r13);
            if (r10 == 3) goto L30;
            throw new IllegalArgumentException(r14);
        L30:
            throw new IllegalStateException(r14);
        L25:
            r13[2] = "computeIfAbsent";
            goto L26
        L21:
            r13[1] = "computeIfAbsent";
            goto L22
        L15:
            r13[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            goto L19
        L16:
            r13[0] = "computation";
            goto L19
        L17:
            r13[0] = "map";
            goto L19
        L9:
            r12 = 2;
            goto L10
        L5:
            r11 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        static {
        }

        private CacheWithNotNullValuesBasedOnMemoizedFunction(LockBasedStorageManager r10, ConcurrentMap<KeyWithComputation<K, V>, Object> r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r10, r11, null);
        }

        /* synthetic */ CacheWithNotNullValuesBasedOnMemoizedFunction(LockBasedStorageManager r10, ConcurrentMap r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction, kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues
        public V computeIfAbsent(K r10, Function0<? extends V> r11) {
            if (r11 != null) goto L4;
            $$$reportNull$$$0(2);
        L4:
            V r12 = (V) super.computeIfAbsent(r10, r11);
            if (r12 != null) goto L7;
            $$$reportNull$$$0(3);
        L7:
            return r12;
        }
    }

    private static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V> extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V> implements CacheWithNullableValues<K, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            Object[] r11 = new Object[3];
            if (r10 == 1) goto L7;
            if (r10 == 2) goto L6;
            r11[0] = "storageManager";
        L8:
            r11[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (r10 == 2) goto L11;
            r11[2] = "<init>";
        L13:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
        L11:
            r11[2] = "computeIfAbsent";
            goto L13
        L6:
            r11[0] = "computation";
            goto L8
        L7:
            r11[0] = "map";
            goto L8
        }

        private CacheWithNullableValuesBasedOnMemoizedFunction(LockBasedStorageManager r10, ConcurrentMap<KeyWithComputation<K, V>, Object> r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r10, r11, new AnonymousClass1());
        }

        /* synthetic */ CacheWithNullableValuesBasedOnMemoizedFunction(LockBasedStorageManager r10, ConcurrentMap r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        public V computeIfAbsent(K r10, Function0<? extends V> r11) {
            if (r11 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return invoke(new KeyWithComputation(r10, r11));
        }
    }

    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = null;

        static {
            THROW = new AnonymousClass1();
        }

        RuntimeException handleException(Throwable r10);
    }

    private static class KeyWithComputation<K, V> {
        private final Function0<? extends V> computation;
        private final K key;

        public KeyWithComputation(K r10, Function0<? extends V> r11) {
            this.key = r10;
            this.computation = r11;
        }

        static /* synthetic */ Function0 access$400(KeyWithComputation r10) {
            return r10.computation;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if (r10 != null) goto L8;
        L14:
            return false;
        L8:
            if (getClass() != r10.getClass()) goto L14;
            if (this.key.equals(((KeyWithComputation) r10).key) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }

    private static class LockBasedLazyValue<T> implements NullableLazyValue<T> {
        private final Function0<? extends T> computable;
        private final LockBasedStorageManager storageManager;
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 2) goto L6;
            if (r10 == 3) goto L6;
            String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r10 == 2) goto L10;
            if (r10 == 3) goto L10;
            int r12 = 3;
        L11:
            Object[] r13 = new Object[r12];
            if (r10 == 1) goto L17;
            if (r10 == 2) goto L16;
            if (r10 == 3) goto L16;
            r13[0] = "storageManager";
        L18:
            if (r10 == 2) goto L22;
            if (r10 == 3) goto L21;
            r13[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
        L23:
            if (r10 == 2) goto L26;
            if (r10 == 3) goto L26;
            r13[2] = "<init>";
        L26:
            String r14 = String.format(r11, r13);
            if (r10 == 2) goto L31;
            if (r10 == 3) goto L31;
            throw new IllegalArgumentException(r14);
        L31:
            throw new IllegalStateException(r14);
        L21:
            r13[1] = "renderDebugInformation";
            goto L23
        L22:
            r13[1] = "recursionDetected";
        L16:
            r13[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            goto L18
        L17:
            r13[0] = "computable";
        L10:
            r12 = 2;
        L6:
            r11 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        public LockBasedLazyValue(LockBasedStorageManager r10, Function0<? extends T> r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            this.value = NotValue.NOT_COMPUTED;
            this.storageManager = r10;
            this.computable = r11;
        }

        @Override // kotlin.jvm.functions.Function0
        public T invoke() {
            Object r10 = this.value;
            if ((r10 instanceof NotValue) == false) goto L5;
            this.storageManager.lock.lock();
            Object r11 = this.value;     // Catch: Throwable -> L35
            if ((r11 instanceof NotValue) == true) goto L12;
            T r12 = (T) WrappedValues.unescapeThrowable(r11);
        L10:
            this.storageManager.lock.unlock();
            return r12;
        L12:
            NotValue r13 = NotValue.COMPUTING;     // Catch: Throwable -> L35
            if (r11 != r13) goto L18;
            this.value = NotValue.RECURSION_WAS_DETECTED;     // Catch: Throwable -> L35
            RecursionDetectedResult<T> r14 = recursionDetected(true);     // Catch: Throwable -> L35
            if (r14.isFallThrough() == true) goto L18;
            r12 = r14.getValue();     // Catch: Throwable -> L35
        L18:
            if (r11 != NotValue.RECURSION_WAS_DETECTED) goto L22;
            RecursionDetectedResult<T> r15 = recursionDetected(false);     // Catch: Throwable -> L35
            if (r15.isFallThrough() == true) goto L22;
            r12 = r15.getValue();     // Catch: Throwable -> L35
        L22:
            this.value = r13;     // Catch: Throwable -> L35
            r12 = this.computable.invoke();     // Catch: Throwable -> L25
            postCompute(r12);     // Catch: Throwable -> L25
            this.value = r12;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            if (ExceptionUtilsKt.isProcessCanceledException(th) == false) goto L29;
            this.value = NotValue.NOT_COMPUTED;     // Catch: Throwable -> L35
            throw th;     // Catch: Throwable -> L35
        L29:
            if (this.value != NotValue.COMPUTING) goto L32;
            this.value = WrappedValues.escapeThrowable(th);     // Catch: Throwable -> L35
        L32:
            throw LockBasedStorageManager.access$100(this.storageManager).handleException(th);     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            this.storageManager.lock.unlock();
            throw th;
        L5:
            return (T) WrappedValues.unescapeThrowable(r10);
        }

        public boolean isComputed() {
            if (this.value != NotValue.NOT_COMPUTED) goto L5;
        L7:
            return false;
        L5:
            if (this.value == NotValue.COMPUTING) goto L7;
            return true;
        }

        protected void postCompute(T r10) {
        }

        protected RecursionDetectedResult<T> recursionDetected(boolean r10) {
            RecursionDetectedResult<T> r11 = this.storageManager.recursionDetectedDefault("in a lazy value", null);
            if (r11 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return r11;
        }
    }

    private static abstract class LockBasedLazyValueWithPostCompute<T> extends LockBasedLazyValue<T> {
        private volatile SingleThreadValue<T> valuePostCompute;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            Object[] r11 = new Object[3];
            if (r10 == 1) goto L5;
            r11[0] = "storageManager";
        L6:
            r11[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            r11[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
        L5:
            r11[0] = "computable";
            goto L6
        }

        public LockBasedLazyValueWithPostCompute(LockBasedStorageManager r10, Function0<? extends T> r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r10, r11);
            this.valuePostCompute = null;
        }

        protected abstract void doPostCompute(T r10);

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            SingleThreadValue<T> r10 = this.valuePostCompute;
            if (r10 == null) goto L9;
            if (r10.hasValue() == false) goto L9;
            return r10.getValue();
        L9:
            return (T) super.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
        protected final void postCompute(T r10) {
            this.valuePostCompute = new SingleThreadValue(r10);
            doPostCompute(r10);     // Catch: Throwable -> L6
            this.valuePostCompute = null;
            return;
        L6:
            th = move-exception;
            this.valuePostCompute = null;
            throw th;
        }
    }

    private static class LockBasedNotNullLazyValue<T> extends LockBasedLazyValue<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 2) goto L5;
            String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L6:
            if (r10 == 2) goto L8;
            int r12 = 3;
        L9:
            Object[] r13 = new Object[r12];
            if (r10 == 1) goto L14;
            if (r10 == 2) goto L13;
            r13[0] = "storageManager";
        L15:
            if (r10 == 2) goto L17;
            r13[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
        L18:
            if (r10 == 2) goto L20;
            r13[2] = "<init>";
        L20:
            String r14 = String.format(r11, r13);
            if (r10 == 2) goto L24;
            throw new IllegalArgumentException(r14);
        L24:
            throw new IllegalStateException(r14);
        L17:
            r13[1] = "invoke";
            goto L18
        L13:
            r13[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            goto L15
        L14:
            r13[0] = "computable";
            goto L15
        L8:
            r12 = 2;
            goto L9
        L5:
            r11 = "@NotNull method %s.%s must not return null";
            goto L6
        }

        static {
        }

        public LockBasedNotNullLazyValue(LockBasedStorageManager r10, Function0<? extends T> r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            T r10 = (T) super.invoke();
            if (r10 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return r10;
        }
    }

    private static abstract class LockBasedNotNullLazyValueWithPostCompute<T> extends LockBasedLazyValueWithPostCompute<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 2) goto L5;
            String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L6:
            if (r10 == 2) goto L8;
            int r12 = 3;
        L9:
            Object[] r13 = new Object[r12];
            if (r10 == 1) goto L14;
            if (r10 == 2) goto L13;
            r13[0] = "storageManager";
        L15:
            if (r10 == 2) goto L17;
            r13[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        L18:
            if (r10 == 2) goto L20;
            r13[2] = "<init>";
        L20:
            String r14 = String.format(r11, r13);
            if (r10 == 2) goto L24;
            throw new IllegalArgumentException(r14);
        L24:
            throw new IllegalStateException(r14);
        L17:
            r13[1] = "invoke";
            goto L18
        L13:
            r13[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            goto L15
        L14:
            r13[0] = "computable";
            goto L15
        L8:
            r12 = 2;
            goto L9
        L5:
            r11 = "@NotNull method %s.%s must not return null";
            goto L6
        }

        static {
        }

        public LockBasedNotNullLazyValueWithPostCompute(LockBasedStorageManager r10, Function0<? extends T> r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            T r10 = (T) super.invoke();
            if (r10 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return r10;
        }
    }

    private static class MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNullable<K, V> {
        private final ConcurrentMap<K, Object> cache;
        private final Function1<? super K, ? extends V> compute;
        private final LockBasedStorageManager storageManager;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 3) goto L6;
            if (r10 == 4) goto L6;
            String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L8:
            if (r10 == 3) goto L11;
            if (r10 == 4) goto L11;
            int r12 = 3;
        L12:
            Object[] r13 = new Object[r12];
            if (r10 == 1) goto L20;
            if (r10 == 2) goto L19;
            if (r10 == 3) goto L18;
            if (r10 == 4) goto L18;
            r13[0] = "storageManager";
        L21:
            if (r10 == 3) goto L25;
            if (r10 == 4) goto L24;
            r13[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
        L26:
            if (r10 == 3) goto L29;
            if (r10 == 4) goto L29;
            r13[2] = "<init>";
        L29:
            String r14 = String.format(r11, r13);
            if (r10 == 3) goto L34;
            if (r10 == 4) goto L34;
            throw new IllegalArgumentException(r14);
        L34:
            throw new IllegalStateException(r14);
        L24:
            r13[1] = "raceCondition";
            goto L26
        L25:
            r13[1] = "recursionDetected";
        L18:
            r13[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            goto L21
        L19:
            r13[0] = "compute";
            goto L21
        L20:
            r13[0] = "map";
        L11:
            r12 = 2;
        L6:
            r11 = "@NotNull method %s.%s must not return null";
            goto L8
        }

        public MapBasedMemoizedFunction(LockBasedStorageManager r10, ConcurrentMap<K, Object> r11, Function1<? super K, ? extends V> r12) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            if (r12 != null) goto L8;
            $$$reportNull$$$0(2);
        L8:
            this.storageManager = r10;
            this.cache = r11;
            this.compute = r12;
        }

        private AssertionError raceCondition(K r10, Object r11) {
            AssertionError r12 = (AssertionError) LockBasedStorageManager.access$200(new AssertionError("Race condition detected on input " + r10 + ". Old value is " + r11 + " under " + this.storageManager));
            if (r12 != null) goto L5;
            $$$reportNull$$$0(4);
        L5:
            return r12;
        }

        protected LockBasedStorageManager getStorageManager() {
            return this.storageManager;
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(K r10) {
            Object r11 = this.cache.get(r10);
            if (r11 != null) goto L5;
        L8:
            this.storageManager.lock.lock();
            Object r12 = this.cache.get(r10);     // Catch: Throwable -> L45
            NotValue r13 = NotValue.COMPUTING;     // Catch: Throwable -> L45
            if (r12 != r13) goto L17;
            r12 = NotValue.RECURSION_WAS_DETECTED;     // Catch: Throwable -> L45
            RecursionDetectedResult<V> r14 = recursionDetected(r10, true);     // Catch: Throwable -> L45
            if (r14.isFallThrough() == true) goto L17;
        L13:
            V r15 = r14.getValue();     // Catch: Throwable -> L45
        L14:
            this.storageManager.lock.unlock();
            return r15;
        L17:
            if (r12 != NotValue.RECURSION_WAS_DETECTED) goto L21;
            r14 = recursionDetected(r10, false);     // Catch: Throwable -> L45
            if (r14.isFallThrough() == false) goto L13;
        L21:
            if (r12 == null) goto L24;
            r15 = (V) WrappedValues.unescapeExceptionOrNull(r12);
            goto L14
        L24:
            AssertionError r16 = null;
            this.cache.put(r10, r13);     // Catch: Throwable -> L31
            V r17 = this.compute.invoke(r10);     // Catch: Throwable -> L31
            Object r18 = this.cache.put(r10, WrappedValues.escapeNull(r17));     // Catch: Throwable -> L31
            if (r18 != r13) goto L29;
            this.storageManager.lock.unlock();
            return r17;
        L29:
            r16 = raceCondition(r10, r18);     // Catch: Throwable -> L31
            throw r16;     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            if (ExceptionUtilsKt.isProcessCanceledException(th) == true) goto L43;
            if (th == r16) goto L42;
            Object r19 = this.cache.put(r10, WrappedValues.escapeThrowable(th));     // Catch: Throwable -> L45
            if (r19 == NotValue.COMPUTING) goto L40;
            throw raceCondition(r10, r19);     // Catch: Throwable -> L45
        L40:
            throw LockBasedStorageManager.access$100(this.storageManager).handleException(th);     // Catch: Throwable -> L45
        L42:
            throw LockBasedStorageManager.access$100(this.storageManager).handleException(th);     // Catch: Throwable -> L45
        L43:
            this.cache.remove(r10);     // Catch: Throwable -> L45
            throw th;     // Catch: Throwable -> L45
        L45:
            th = move-exception;
            this.storageManager.lock.unlock();
            throw th;
        L5:
            if (r11 == NotValue.COMPUTING) goto L8;
            return (V) WrappedValues.unescapeExceptionOrNull(r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable
        public boolean isComputed(K r10) {
            Object r11 = this.cache.get(r10);
            if (r11 != null) goto L5;
        L7:
            return false;
        L5:
            if (r11 == NotValue.COMPUTING) goto L7;
            return true;
        }

        protected RecursionDetectedResult<V> recursionDetected(K r10, boolean r11) {
            RecursionDetectedResult<V> r12 = this.storageManager.recursionDetectedDefault("", r10);
            if (r12 != null) goto L5;
            $$$reportNull$$$0(3);
        L5:
            return r12;
        }
    }

    private static class MapBasedMemoizedFunctionToNotNull<K, V> extends MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNotNull<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 3) goto L5;
            String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r10 == 3) goto L9;
            int r12 = 3;
        L10:
            Object[] r13 = new Object[r12];
            if (r10 == 1) goto L17;
            if (r10 == 2) goto L16;
            if (r10 == 3) goto L15;
            r13[0] = "storageManager";
        L18:
            if (r10 == 3) goto L20;
            r13[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
        L21:
            if (r10 == 3) goto L23;
            r13[2] = "<init>";
        L23:
            String r14 = String.format(r11, r13);
            if (r10 == 3) goto L27;
            throw new IllegalArgumentException(r14);
        L27:
            throw new IllegalStateException(r14);
        L20:
            r13[1] = "invoke";
            goto L21
        L15:
            r13[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            goto L18
        L16:
            r13[0] = "compute";
            goto L18
        L17:
            r13[0] = "map";
            goto L18
        L9:
            r12 = 2;
            goto L10
        L5:
            r11 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        static {
        }

        public MapBasedMemoizedFunctionToNotNull(LockBasedStorageManager r10, ConcurrentMap<K, Object> r11, Function1<? super K, ? extends V> r12) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            if (r12 != null) goto L8;
            $$$reportNull$$$0(2);
        L8:
            super(r10, r11, r12);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction, kotlin.jvm.functions.Function1
        public V invoke(K r10) {
            V r11 = (V) super.invoke(r10);
            if (r11 != null) goto L5;
            $$$reportNull$$$0(3);
        L5:
            return r11;
        }
    }

    private static final enum NotValue extends Enum<NotValue> {
        private static final /* synthetic */ NotValue[] $VALUES = null;
        public static final NotValue COMPUTING = null;
        public static final NotValue NOT_COMPUTED = null;
        public static final NotValue RECURSION_WAS_DETECTED = null;

        static {
            NotValue r10 = new NotValue("NOT_COMPUTED", 0);
            NOT_COMPUTED = r10;
            NotValue r11 = new NotValue("COMPUTING", 1);
            COMPUTING = r11;
            NotValue r12 = new NotValue("RECURSION_WAS_DETECTED", 2);
            RECURSION_WAS_DETECTED = r12;
            $VALUES = new NotValue[]{r10, r11, r12};
        }

        private NotValue(String r10, int r11) {
            super(r10, r11);
        }

        public static NotValue valueOf(String r10) {
            return (NotValue) Enum.valueOf(NotValue.class, r10);
        }

        public static NotValue[] values() {
            return (NotValue[]) $VALUES.clone();
        }
    }

    private static class RecursionDetectedResult<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean fallThrough;
        private final T value;

        static {
        }

        private RecursionDetectedResult(T r10, boolean r11) {
            this.value = r10;
            this.fallThrough = r11;
        }

        public static <T> RecursionDetectedResult<T> fallThrough() {
            return new RecursionDetectedResult(null, true);
        }

        public static <T> RecursionDetectedResult<T> value(T r10) {
            return new RecursionDetectedResult(r10, false);
        }

        public T getValue() {
            return this.value;
        }

        public boolean isFallThrough() {
            return this.fallThrough;
        }

        public String toString() {
            if (isFallThrough() == false) goto L6;
            return "FALL_THROUGH";
        L6:
            return String.valueOf(this.value);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r13) {
        if (r13 == 10) goto L8;
        if (r13 == 13) goto L8;
        if (r13 == 20) goto L8;
        if (r13 == 37) goto L8;
        String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r13 == 10) goto L15;
        if (r13 == 13) goto L15;
        if (r13 == 20) goto L15;
        if (r13 == 37) goto L15;
        int r11 = 3;
    L16:
        Object[] r12 = new Object[r11];
        if (r13 == 1) goto L34;
        if (r13 == 3) goto L34;
        if (r13 == 5) goto L34;
        if (r13 == 6) goto L33;
        switch(r13) {
            case 8: goto L34;
            case 9: goto L32;
            case 10: goto L31;
            case 11: goto L32;
            case 12: goto L30;
            case 13: goto L31;
            case 14: goto L32;
            case 15: goto L29;
            case 16: goto L32;
            case 17: goto L30;
            case 18: goto L29;
            case 19: goto L32;
            case 20: goto L31;
            case 21: goto L32;
            case 22: goto L29;
            case 23: goto L28;
            case 24: goto L28;
            case 25: goto L30;
            case 26: goto L28;
            case 27: goto L30;
            case 28: goto L28;
            case 29: goto L27;
            case 30: goto L28;
            case 31: goto L28;
            case 32: goto L28;
            case 33: goto L27;
            case 34: goto L28;
            case 35: goto L26;
            case 36: goto L25;
            case 37: goto L31;
            default: goto L24;
        };
    L24:
        r12[0] = "debugText";
    L36:
        if (r13 == 10) goto L43;
        if (r13 == 13) goto L43;
        if (r13 == 20) goto L42;
        if (r13 == 37) goto L41;
        r12[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
    L44:
        switch(r13) {
            case 4: goto L58;
            case 5: goto L58;
            case 6: goto L58;
            case 7: goto L57;
            case 8: goto L57;
            case 9: goto L56;
            case 10: goto L59;
            case 11: goto L56;
            case 12: goto L56;
            case 13: goto L59;
            case 14: goto L56;
            case 15: goto L56;
            case 16: goto L56;
            case 17: goto L56;
            case 18: goto L56;
            case 19: goto L55;
            case 20: goto L59;
            case 21: goto L55;
            case 22: goto L55;
            case 23: goto L54;
            case 24: goto L54;
            case 25: goto L54;
            case 26: goto L53;
            case 27: goto L53;
            case 28: goto L52;
            case 29: goto L52;
            case 30: goto L51;
            case 31: goto L50;
            case 32: goto L49;
            case 33: goto L49;
            case 34: goto L48;
            case 35: goto L47;
            case 36: goto L46;
            case 37: goto L59;
            default: goto L45;
        };
    L45:
        r12[2] = "createWithExceptionHandling";
        goto L59
    L46:
        r12[2] = "sanitizeStackTrace";
        goto L59
    L47:
        r12[2] = "recursionDetectedDefault";
        goto L59
    L48:
        r12[2] = "compute";
        goto L59
    L49:
        r12[2] = "createNullableLazyValueWithPostCompute";
        goto L59
    L50:
        r12[2] = "createRecursionTolerantNullableLazyValue";
        goto L59
    L51:
        r12[2] = "createNullableLazyValue";
        goto L59
    L52:
        r12[2] = "createLazyValueWithPostCompute";
        goto L59
    L53:
        r12[2] = "createRecursionTolerantLazyValue";
        goto L59
    L54:
        r12[2] = "createLazyValue";
        goto L59
    L55:
        r12[2] = "createMemoizedFunctionWithNullableValues";
        goto L59
    L56:
        r12[2] = "createMemoizedFunction";
        goto L59
    L57:
        r12[2] = "replaceExceptionHandling";
        goto L59
    L58:
        r12[2] = "<init>";
    L59:
        String r14 = String.format(r10, r12);
        if (r13 == 10) goto L66;
        if (r13 == 13) goto L66;
        if (r13 == 20) goto L66;
        if (r13 == 37) goto L66;
        throw new IllegalArgumentException(r14);
    L66:
        throw new IllegalStateException(r14);
    L41:
        r12[1] = "sanitizeStackTrace";
        goto L44
    L42:
        r12[1] = "createMemoizedFunctionWithNullableValues";
    L43:
        r12[1] = "createMemoizedFunction";
        goto L44
    L25:
        r12[0] = "throwable";
        goto L36
    L26:
        r12[0] = "source";
        goto L36
    L27:
        r12[0] = "postCompute";
        goto L36
    L28:
        r12[0] = "computable";
        goto L36
    L29:
        r12[0] = "map";
        goto L36
    L30:
        r12[0] = "onRecursiveCall";
        goto L36
    L31:
        r12[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
        goto L36
    L32:
        r12[0] = "compute";
        goto L36
    L33:
        r12[0] = "lock";
    L34:
        r12[0] = "exceptionHandlingStrategy";
    L15:
        r11 = 2;
    L8:
        r10 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    static {
        PACKAGE_NAME = StringsKt.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), ".", "");
        final ExceptionHandlingStrategy r10 = ExceptionHandlingStrategy.THROW;
        final EmptySimpleLock r11 = EmptySimpleLock.INSTANCE;
        final String r12 = "NO_LOCKS";
        NO_LOCKS = new AnonymousClass1(r12, r10, r11);
    }

    public LockBasedStorageManager(String r10) {
        this(r10, null, null);
    }

    public LockBasedStorageManager(String r10, Runnable r11, Function1<InterruptedException, Unit> r12) {
        this(r10, ExceptionHandlingStrategy.THROW, SimpleLock.Companion.simpleLock(r11, r12));
    }

    private LockBasedStorageManager(String r10, ExceptionHandlingStrategy r11, SimpleLock r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(6);
    L8:
        this.lock = r12;
        this.exceptionHandlingStrategy = r11;
        this.debugText = r10;
    }

    /* synthetic */ LockBasedStorageManager(String r10, ExceptionHandlingStrategy r11, SimpleLock r12, AnonymousClass1 r13) {
        this(r10, r11, r12);
    }

    static /* synthetic */ ExceptionHandlingStrategy access$100(LockBasedStorageManager r10) {
        return r10.exceptionHandlingStrategy;
    }

    static /* synthetic */ Throwable access$200(Throwable r10) {
        return sanitizeStackTrace(r10);
    }

    private static <K> ConcurrentMap<K, Object> createConcurrentHashMap() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    private static <T extends Throwable> T sanitizeStackTrace(T r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(36);
    L4:
        StackTraceElement[] r11 = r10.getStackTrace();
        int r12 = r11.length;
        int r13 = -1;
        int r14 = 0;
    L5:
        if (r14 >= r12) goto L10;
        if (r11[r14].getClassName().startsWith(PACKAGE_NAME) == false) goto L8;
        r14 = r14 + 1;
        goto L5
    L8:
        r13 = r14;
    L10:
        List r15 = Arrays.asList(r11).subList(r13, r12);
        r10.setStackTrace((StackTraceElement[]) r15.toArray(new StackTraceElement[r15.size()]));
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> T compute(Function0<? extends T> r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(34);
    L4:
        this.lock.lock();
        T r11 = r10.invoke();     // Catch: Throwable -> L8
        this.lock.unlock();
        return r11;
    L8:
        th = move-exception;
    L11:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L10:
        throw this.exceptionHandlingStrategy.handleException(th);     // Catch: Throwable -> L11
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new CacheWithNotNullValuesBasedOnMemoizedFunction(this, createConcurrentHashMap(), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        return new CacheWithNullableValuesBasedOnMemoizedFunction(this, createConcurrentHashMap(), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createLazyValue(Function0<? extends T> r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(23);
    L5:
        return new LockBasedNotNullLazyValue(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(final Function0<? extends T> r10, final Function1<? super Boolean, ? extends T> r11, final Function1<? super T, Unit> r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(28);
    L4:
        if (r12 != null) goto L7;
        $$$reportNull$$$0(29);
    L7:
        return new AnonymousClass5(this, this, r10, r11, r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        MemoizedFunctionToNotNull<K, V> r11 = createMemoizedFunction(r10, createConcurrentHashMap());
        if (r11 != null) goto L7;
        $$$reportNull$$$0(10);
    L7:
        return r11;
    }

    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> r10, ConcurrentMap<K, Object> r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(15);
    L7:
        return new MapBasedMemoizedFunctionToNotNull(this, r11, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(19);
    L4:
        MemoizedFunctionToNullable<K, V> r11 = createMemoizedFunctionWithNullableValues(r10, createConcurrentHashMap());
        if (r11 != null) goto L7;
        $$$reportNull$$$0(20);
    L7:
        return r11;
    }

    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> r10, ConcurrentMap<K, Object> r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(21);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(22);
    L7:
        return new MapBasedMemoizedFunction(this, r11, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NullableLazyValue<T> createNullableLazyValue(Function0<? extends T> r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(30);
    L5:
        return new LockBasedLazyValue(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(final Function0<? extends T> r10, final T r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(26);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(27);
    L7:
        return new AnonymousClass4(this, this, r10, r11);
    }

    protected <K, V> RecursionDetectedResult<V> recursionDetectedDefault(String r10, K r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(35);
    L4:
        StringBuilder r12 = new StringBuilder();
        r12.append("Recursion detected ");
        r12.append(r10);
        if (r11 != null) goto L7;
        String r13 = "";
    L8:
        r12.append(r13);
        r12.append(" under ");
        r12.append(this);
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(r12.toString())));
    L7:
        r13 = "on input: " + r11;
        goto L8
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.debugText + ")";
    }
}
