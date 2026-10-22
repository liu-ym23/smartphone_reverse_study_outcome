package kotlin.reflect.jvm.internal.impl.storage;

import ai.j0;
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

    public static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V> extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V> implements CacheWithNotNullValues<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 3) goto L5;
            String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r10 == 3) goto L9;
            int r11 = 3;
        L10:
            Object[] r12 = new Object[r11];
            if (r10 == 1) goto L17;
            if (r10 == 2) goto L16;
            if (r10 == 3) goto L15;
            r12[0] = "storageManager";
        L19:
            if (r10 == 3) goto L21;
            r12[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
        L22:
            if (r10 == 2) goto L25;
            if (r10 == 3) goto L26;
            r12[2] = "<init>";
        L26:
            String r13 = String.format(r5, r12);
            if (r10 == 3) goto L30;
            throw new IllegalArgumentException(r13);
        L30:
            throw new IllegalStateException(r13);
        L25:
            r12[2] = "computeIfAbsent";
            goto L26
        L21:
            r12[1] = "computeIfAbsent";
            goto L22
        L15:
            r12[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            goto L19
        L16:
            r12[0] = "computation";
            goto L19
        L17:
            r12[0] = "map";
            goto L19
        L9:
            r11 = 2;
            goto L10
        L5:
            r5 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        public /* synthetic */ CacheWithNotNullValuesBasedOnMemoizedFunction(LockBasedStorageManager r5, ConcurrentMap r10, AnonymousClass1 r11) {
            this(r5, r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction, kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues
        public V computeIfAbsent(K r5, Function0<? extends V> r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(2);
        L4:
            V r11 = (V) super.computeIfAbsent(r5, r10);
            if (r11 != null) goto L7;
            $$$reportNull$$$0(3);
        L7:
            return r11;
        }

        private CacheWithNotNullValuesBasedOnMemoizedFunction(LockBasedStorageManager r5, ConcurrentMap<KeyWithComputation<K, V>, Object> r10) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r10 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r5, r10, null);
        }
    }

    public static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V> extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V> implements CacheWithNullableValues<K, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int r5) {
            Object[] r10 = new Object[3];
            if (r5 == 1) goto L7;
            if (r5 == 2) goto L6;
            r10[0] = "storageManager";
        L8:
            r10[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (r5 == 2) goto L11;
            r10[2] = "<init>";
        L13:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r10));
        L11:
            r10[2] = "computeIfAbsent";
            goto L13
        L6:
            r10[0] = "computation";
            goto L8
        L7:
            r10[0] = "map";
            goto L8
        }

        public /* synthetic */ CacheWithNullableValuesBasedOnMemoizedFunction(LockBasedStorageManager r5, ConcurrentMap r10, AnonymousClass1 r11) {
            this(r5, r10);
        }

        public V computeIfAbsent(K r5, Function0<? extends V> r10) {
            if (r10 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return invoke(new KeyWithComputation(r5, r10));
        }

        private CacheWithNullableValuesBasedOnMemoizedFunction(LockBasedStorageManager r5, ConcurrentMap<KeyWithComputation<K, V>, Object> r10) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r10 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r5, r10, new AnonymousClass1());
        }
    }

    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = null;

        static {
            THROW = new AnonymousClass1();
        }

        RuntimeException handleException(Throwable r5);
    }

    public static class KeyWithComputation<K, V> {
        private final Function0<? extends V> computation;
        private final K key;

        public KeyWithComputation(K r5, Function0<? extends V> r10) {
            this.key = r5;
            this.computation = r10;
        }

        public static /* synthetic */ Function0 access$400(KeyWithComputation r5) {
            return r5.computation;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L14:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L14;
            if (this.key.equals(((KeyWithComputation) r5).key) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }

    public static class LockBasedLazyValue<T> implements NullableLazyValue<T> {
        private final Function0<? extends T> computable;
        private final LockBasedStorageManager storageManager;
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 2) goto L6;
            if (r10 == 3) goto L6;
            String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r10 == 2) goto L10;
            if (r10 == 3) goto L10;
            int r11 = 3;
        L11:
            Object[] r12 = new Object[r11];
            if (r10 == 1) goto L17;
            if (r10 == 2) goto L16;
            if (r10 == 3) goto L16;
            r12[0] = "storageManager";
        L18:
            if (r10 == 2) goto L22;
            if (r10 == 3) goto L21;
            r12[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
        L23:
            if (r10 == 2) goto L26;
            if (r10 == 3) goto L26;
            r12[2] = "<init>";
        L26:
            String r13 = String.format(r5, r12);
            if (r10 == 2) goto L31;
            if (r10 == 3) goto L31;
            throw new IllegalArgumentException(r13);
        L31:
            throw new IllegalStateException(r13);
        L21:
            r12[1] = "renderDebugInformation";
            goto L23
        L22:
            r12[1] = "recursionDetected";
        L16:
            r12[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            goto L18
        L17:
            r12[0] = "computable";
        L10:
            r11 = 2;
        L6:
            r5 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        public LockBasedLazyValue(LockBasedStorageManager r5, Function0<? extends T> r10) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r10 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            this.value = NotValue.NOT_COMPUTED;
            this.storageManager = r5;
            this.computable = r10;
        }

        @Override // kotlin.jvm.functions.Function0
        public T invoke() {
            Object r5 = this.value;
            if ((r5 instanceof NotValue) == false) goto L5;
            this.storageManager.lock.lock();
            Object r10 = this.value;     // Catch: Throwable -> L12
            if ((r10 instanceof NotValue) == true) goto L14;
            T r11 = (T) WrappedValues.unescapeThrowable(r10);
        L10:
            this.storageManager.lock.unlock();
            return r11;
        L14:
            NotValue r12 = NotValue.COMPUTING;     // Catch: Throwable -> L12
            if (r10 != r12) goto L20;
            this.value = NotValue.RECURSION_WAS_DETECTED;     // Catch: Throwable -> L12
            RecursionDetectedResult<T> r13 = recursionDetected(true);     // Catch: Throwable -> L12
            if (r13.isFallThrough() == true) goto L20;
            r11 = r13.getValue();     // Catch: Throwable -> L12
        L20:
            if (r10 != NotValue.RECURSION_WAS_DETECTED) goto L24;
            RecursionDetectedResult<T> r14 = recursionDetected(false);     // Catch: Throwable -> L12
            if (r14.isFallThrough() == true) goto L24;
            r11 = r14.getValue();     // Catch: Throwable -> L12
        L24:
            this.value = r12;     // Catch: Throwable -> L12
            r11 = this.computable.invoke();     // Catch: Throwable -> L27
            postCompute(r11);     // Catch: Throwable -> L27
            this.value = r11;     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            if (ExceptionUtilsKt.isProcessCanceledException(th) == false) goto L31;
            this.value = NotValue.NOT_COMPUTED;     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L31:
            if (this.value != NotValue.COMPUTING) goto L34;
            this.value = WrappedValues.escapeThrowable(th);     // Catch: Throwable -> L12
        L34:
            throw LockBasedStorageManager.access$100(this.storageManager).handleException(th);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            this.storageManager.lock.unlock();
            throw th;
        L5:
            return (T) WrappedValues.unescapeThrowable(r5);
        }

        public boolean isComputed() {
            if (this.value != NotValue.NOT_COMPUTED) goto L5;
        L7:
            return false;
        L5:
            if (this.value == NotValue.COMPUTING) goto L7;
            return true;
        }

        public void postCompute(T r5) {
        }

        public RecursionDetectedResult<T> recursionDetected(boolean r5) {
            RecursionDetectedResult<T> r10 = this.storageManager.recursionDetectedDefault("in a lazy value", null);
            if (r10 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return r10;
        }
    }

    public static abstract class LockBasedLazyValueWithPostCompute<T> extends LockBasedLazyValue<T> {
        private volatile SingleThreadValue<T> valuePostCompute;

        private static /* synthetic */ void $$$reportNull$$$0(int r5) {
            Object[] r10 = new Object[3];
            if (r5 == 1) goto L5;
            r10[0] = "storageManager";
        L6:
            r10[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            r10[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r10));
        L5:
            r10[0] = "computable";
            goto L6
        }

        public LockBasedLazyValueWithPostCompute(LockBasedStorageManager r5, Function0<? extends T> r10) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r10 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r5, r10);
            this.valuePostCompute = null;
        }

        public abstract void doPostCompute(T r5);

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            SingleThreadValue<T> r5 = this.valuePostCompute;
            if (r5 == null) goto L9;
            if (r5.hasValue() == false) goto L9;
            return r5.getValue();
        L9:
            return (T) super.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
        public final void postCompute(T r5) {
            this.valuePostCompute = new SingleThreadValue(r5);
            doPostCompute(r5);     // Catch: Throwable -> L6
            this.valuePostCompute = null;
            return;
        L6:
            th = move-exception;
            this.valuePostCompute = null;
            throw th;
        }
    }

    public static class LockBasedNotNullLazyValue<T> extends LockBasedLazyValue<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 2) goto L5;
            String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L6:
            if (r10 == 2) goto L8;
            int r11 = 3;
        L9:
            Object[] r12 = new Object[r11];
            if (r10 == 1) goto L14;
            if (r10 == 2) goto L13;
            r12[0] = "storageManager";
        L15:
            if (r10 == 2) goto L17;
            r12[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
        L18:
            if (r10 == 2) goto L20;
            r12[2] = "<init>";
        L20:
            String r13 = String.format(r5, r12);
            if (r10 == 2) goto L24;
            throw new IllegalArgumentException(r13);
        L24:
            throw new IllegalStateException(r13);
        L17:
            r12[1] = "invoke";
            goto L18
        L13:
            r12[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            goto L15
        L14:
            r12[0] = "computable";
            goto L15
        L8:
            r11 = 2;
            goto L9
        L5:
            r5 = "@NotNull method %s.%s must not return null";
            goto L6
        }

        public LockBasedNotNullLazyValue(LockBasedStorageManager r5, Function0<? extends T> r10) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r10 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r5, r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            T r5 = (T) super.invoke();
            if (r5 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return r5;
        }
    }

    public static abstract class LockBasedNotNullLazyValueWithPostCompute<T> extends LockBasedLazyValueWithPostCompute<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 2) goto L5;
            String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L6:
            if (r10 == 2) goto L8;
            int r11 = 3;
        L9:
            Object[] r12 = new Object[r11];
            if (r10 == 1) goto L14;
            if (r10 == 2) goto L13;
            r12[0] = "storageManager";
        L15:
            if (r10 == 2) goto L17;
            r12[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        L18:
            if (r10 == 2) goto L20;
            r12[2] = "<init>";
        L20:
            String r13 = String.format(r5, r12);
            if (r10 == 2) goto L24;
            throw new IllegalArgumentException(r13);
        L24:
            throw new IllegalStateException(r13);
        L17:
            r12[1] = "invoke";
            goto L18
        L13:
            r12[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            goto L15
        L14:
            r12[0] = "computable";
            goto L15
        L8:
            r11 = 2;
            goto L9
        L5:
            r5 = "@NotNull method %s.%s must not return null";
            goto L6
        }

        public LockBasedNotNullLazyValueWithPostCompute(LockBasedStorageManager r5, Function0<? extends T> r10) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r10 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r5, r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            T r5 = (T) super.invoke();
            if (r5 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return r5;
        }
    }

    public static class MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNullable<K, V> {
        private final ConcurrentMap<K, Object> cache;
        private final Function1<? super K, ? extends V> compute;
        private final LockBasedStorageManager storageManager;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 3) goto L6;
            if (r10 == 4) goto L6;
            String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L8:
            if (r10 == 3) goto L11;
            if (r10 == 4) goto L11;
            int r11 = 3;
        L12:
            Object[] r12 = new Object[r11];
            if (r10 == 1) goto L20;
            if (r10 == 2) goto L19;
            if (r10 == 3) goto L18;
            if (r10 == 4) goto L18;
            r12[0] = "storageManager";
        L21:
            if (r10 == 3) goto L25;
            if (r10 == 4) goto L24;
            r12[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
        L26:
            if (r10 == 3) goto L29;
            if (r10 == 4) goto L29;
            r12[2] = "<init>";
        L29:
            String r13 = String.format(r5, r12);
            if (r10 == 3) goto L34;
            if (r10 == 4) goto L34;
            throw new IllegalArgumentException(r13);
        L34:
            throw new IllegalStateException(r13);
        L24:
            r12[1] = "raceCondition";
            goto L26
        L25:
            r12[1] = "recursionDetected";
        L18:
            r12[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            goto L21
        L19:
            r12[0] = "compute";
            goto L21
        L20:
            r12[0] = "map";
        L11:
            r11 = 2;
        L6:
            r5 = "@NotNull method %s.%s must not return null";
            goto L8
        }

        public MapBasedMemoizedFunction(LockBasedStorageManager r5, ConcurrentMap<K, Object> r10, Function1<? super K, ? extends V> r11) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r10 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            if (r11 != null) goto L8;
            $$$reportNull$$$0(2);
        L8:
            this.storageManager = r5;
            this.cache = r10;
            this.compute = r11;
        }

        private AssertionError raceCondition(K r5, Object r10) {
            AssertionError r11 = (AssertionError) LockBasedStorageManager.access$200(new AssertionError("Race condition detected on input " + r5 + ". Old value is " + r10 + " under " + this.storageManager));
            if (r11 != null) goto L5;
            $$$reportNull$$$0(4);
        L5:
            return r11;
        }

        public LockBasedStorageManager getStorageManager() {
            return this.storageManager;
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(K r10) {
            Object r5 = this.cache.get(r10);
            if (r5 != null) goto L5;
        L8:
            this.storageManager.lock.lock();
            Object r11 = this.cache.get(r10);     // Catch: Throwable -> L16
            NotValue r12 = NotValue.COMPUTING;     // Catch: Throwable -> L16
            if (r11 != r12) goto L19;
            r11 = NotValue.RECURSION_WAS_DETECTED;     // Catch: Throwable -> L16
            RecursionDetectedResult<V> r13 = recursionDetected(r10, true);     // Catch: Throwable -> L16
            if (r13.isFallThrough() == true) goto L19;
            V r14 = r13.getValue();     // Catch: Throwable -> L16
        L14:
            this.storageManager.lock.unlock();
            return r14;
        L19:
            if (r11 != NotValue.RECURSION_WAS_DETECTED) goto L23;
            RecursionDetectedResult<V> r15 = recursionDetected(r10, false);     // Catch: Throwable -> L16
            if (r15.isFallThrough() == true) goto L23;
            r14 = r15.getValue();     // Catch: Throwable -> L16
        L23:
            if (r11 == null) goto L26;
            r14 = (V) WrappedValues.unescapeExceptionOrNull(r11);
            goto L14
        L26:
            AssertionError r16 = null;
            this.cache.put(r10, r12);     // Catch: Throwable -> L33
            V r17 = this.compute.invoke(r10);     // Catch: Throwable -> L33
            Object r18 = this.cache.put(r10, WrappedValues.escapeNull(r17));     // Catch: Throwable -> L33
            if (r18 != r12) goto L31;
            this.storageManager.lock.unlock();
            return r17;
        L31:
            r16 = raceCondition(r10, r18);     // Catch: Throwable -> L33
            throw r16;     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            if (ExceptionUtilsKt.isProcessCanceledException(th) == true) goto L45;
            if (th == r16) goto L44;
            Object r19 = this.cache.put(r10, WrappedValues.escapeThrowable(th));     // Catch: Throwable -> L16
            if (r19 == NotValue.COMPUTING) goto L42;
            throw raceCondition(r10, r19);     // Catch: Throwable -> L16
        L42:
            throw LockBasedStorageManager.access$100(this.storageManager).handleException(th);     // Catch: Throwable -> L16
        L44:
            throw LockBasedStorageManager.access$100(this.storageManager).handleException(th);     // Catch: Throwable -> L16
        L45:
            this.cache.remove(r10);     // Catch: Throwable -> L16
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            this.storageManager.lock.unlock();
            throw th;
        L5:
            if (r5 == NotValue.COMPUTING) goto L8;
            return (V) WrappedValues.unescapeExceptionOrNull(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable
        public boolean isComputed(K r5) {
            Object r10 = this.cache.get(r5);
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10 == NotValue.COMPUTING) goto L7;
            return true;
        }

        public RecursionDetectedResult<V> recursionDetected(K r5, boolean r10) {
            RecursionDetectedResult<V> r11 = this.storageManager.recursionDetectedDefault("", r5);
            if (r11 != null) goto L5;
            $$$reportNull$$$0(3);
        L5:
            return r11;
        }
    }

    public static class MapBasedMemoizedFunctionToNotNull<K, V> extends MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNotNull<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 3) goto L5;
            String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r10 == 3) goto L9;
            int r11 = 3;
        L10:
            Object[] r12 = new Object[r11];
            if (r10 == 1) goto L17;
            if (r10 == 2) goto L16;
            if (r10 == 3) goto L15;
            r12[0] = "storageManager";
        L18:
            if (r10 == 3) goto L20;
            r12[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
        L21:
            if (r10 == 3) goto L23;
            r12[2] = "<init>";
        L23:
            String r13 = String.format(r5, r12);
            if (r10 == 3) goto L27;
            throw new IllegalArgumentException(r13);
        L27:
            throw new IllegalStateException(r13);
        L20:
            r12[1] = "invoke";
            goto L21
        L15:
            r12[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            goto L18
        L16:
            r12[0] = "compute";
            goto L18
        L17:
            r12[0] = "map";
            goto L18
        L9:
            r11 = 2;
            goto L10
        L5:
            r5 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        public MapBasedMemoizedFunctionToNotNull(LockBasedStorageManager r5, ConcurrentMap<K, Object> r10, Function1<? super K, ? extends V> r11) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r10 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            if (r11 != null) goto L8;
            $$$reportNull$$$0(2);
        L8:
            super(r5, r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction, kotlin.jvm.functions.Function1
        public V invoke(K r5) {
            V r10 = (V) super.invoke(r5);
            if (r10 != null) goto L5;
            $$$reportNull$$$0(3);
        L5:
            return r10;
        }
    }

    public static final enum NotValue extends Enum<NotValue> {
        private static final /* synthetic */ NotValue[] $VALUES = null;
        public static final NotValue COMPUTING = null;
        public static final NotValue NOT_COMPUTED = null;
        public static final NotValue RECURSION_WAS_DETECTED = null;

        static {
            NotValue r5 = new NotValue("NOT_COMPUTED", 0);
            NOT_COMPUTED = r5;
            NotValue r10 = new NotValue("COMPUTING", 1);
            COMPUTING = r10;
            NotValue r11 = new NotValue("RECURSION_WAS_DETECTED", 2);
            RECURSION_WAS_DETECTED = r11;
            $VALUES = new NotValue[]{r5, r10, r11};
        }

        private NotValue(String r5, int r10) {
            super(r5, r10);
        }

        public static NotValue valueOf(String r5) {
            return (NotValue) Enum.valueOf(NotValue.class, r5);
        }

        public static NotValue[] values() {
            return (NotValue[]) $VALUES.clone();
        }
    }

    public static class RecursionDetectedResult<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean fallThrough;
        private final T value;

        private RecursionDetectedResult(T r5, boolean r10) {
            this.value = r5;
            this.fallThrough = r10;
        }

        public static <T> RecursionDetectedResult<T> fallThrough() {
            return new RecursionDetectedResult(null, true);
        }

        public static <T> RecursionDetectedResult<T> value(T r5) {
            return new RecursionDetectedResult(r5, false);
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
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r13 == 10) goto L15;
        if (r13 == 13) goto L15;
        if (r13 == 20) goto L15;
        if (r13 == 37) goto L15;
        int r10 = 3;
    L16:
        Object[] r11 = new Object[r10];
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
        r11[0] = "debugText";
    L36:
        if (r13 == 10) goto L43;
        if (r13 == 13) goto L43;
        if (r13 == 20) goto L42;
        if (r13 == 37) goto L41;
        r11[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
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
        r11[2] = "createWithExceptionHandling";
        goto L59
    L46:
        r11[2] = "sanitizeStackTrace";
        goto L59
    L47:
        r11[2] = "recursionDetectedDefault";
        goto L59
    L48:
        r11[2] = "compute";
        goto L59
    L49:
        r11[2] = "createNullableLazyValueWithPostCompute";
        goto L59
    L50:
        r11[2] = "createRecursionTolerantNullableLazyValue";
        goto L59
    L51:
        r11[2] = "createNullableLazyValue";
        goto L59
    L52:
        r11[2] = "createLazyValueWithPostCompute";
        goto L59
    L53:
        r11[2] = "createRecursionTolerantLazyValue";
        goto L59
    L54:
        r11[2] = "createLazyValue";
        goto L59
    L55:
        r11[2] = "createMemoizedFunctionWithNullableValues";
        goto L59
    L56:
        r11[2] = "createMemoizedFunction";
        goto L59
    L57:
        r11[2] = "replaceExceptionHandling";
        goto L59
    L58:
        r11[2] = "<init>";
    L59:
        String r12 = String.format(r5, r11);
        if (r13 == 10) goto L66;
        if (r13 == 13) goto L66;
        if (r13 == 20) goto L66;
        if (r13 == 37) goto L66;
        throw new IllegalArgumentException(r12);
    L66:
        throw new IllegalStateException(r12);
    L41:
        r11[1] = "sanitizeStackTrace";
        goto L44
    L42:
        r11[1] = "createMemoizedFunctionWithNullableValues";
    L43:
        r11[1] = "createMemoizedFunction";
        goto L44
    L25:
        r11[0] = "throwable";
        goto L36
    L26:
        r11[0] = "source";
        goto L36
    L27:
        r11[0] = "postCompute";
        goto L36
    L28:
        r11[0] = "computable";
        goto L36
    L29:
        r11[0] = "map";
        goto L36
    L30:
        r11[0] = "onRecursiveCall";
        goto L36
    L31:
        r11[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
        goto L36
    L32:
        r11[0] = "compute";
        goto L36
    L33:
        r11[0] = "lock";
    L34:
        r11[0] = "exceptionHandlingStrategy";
    L15:
        r10 = 2;
    L8:
        r5 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    static {
        PACKAGE_NAME = StringsKt.Y(LockBasedStorageManager.class.getCanonicalName());
        final ExceptionHandlingStrategy r5 = ExceptionHandlingStrategy.THROW;
        final EmptySimpleLock r10 = EmptySimpleLock.INSTANCE;
        final String r11 = "NO_LOCKS";
        NO_LOCKS = new AnonymousClass1(r11, r5, r10);
    }

    public /* synthetic */ LockBasedStorageManager(String r5, ExceptionHandlingStrategy r10, SimpleLock r11, AnonymousClass1 r12) {
        this(r5, r10, r11);
    }

    public static /* synthetic */ ExceptionHandlingStrategy access$100(LockBasedStorageManager r5) {
        return r5.exceptionHandlingStrategy;
    }

    public static /* synthetic */ Throwable access$200(Throwable r5) {
        return sanitizeStackTrace(r5);
    }

    private static <K> ConcurrentMap<K, Object> createConcurrentHashMap() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    private static <T extends Throwable> T sanitizeStackTrace(T r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(36);
    L4:
        StackTraceElement[] r10 = r5.getStackTrace();
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L10;
        if (r10[r12].getClassName().startsWith(PACKAGE_NAME) == false) goto L11;
        r12 = r12 + 1;
    L11:
        List r13 = Arrays.asList(r10).subList(r12, r11);
        r5.setStackTrace((StackTraceElement[]) r13.toArray(new StackTraceElement[r13.size()]));
        return r5;
    L10:
        r12 = -1;
        goto L11
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> T compute(Function0<? extends T> r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(34);
    L4:
        this.lock.lock();
        T r10 = r5.invoke();     // Catch: Throwable -> L8
        this.lock.unlock();
        return r10;
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
    public <T> NotNullLazyValue<T> createLazyValue(Function0<? extends T> r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(23);
    L5:
        return new LockBasedNotNullLazyValue(this, r5);
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
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        MemoizedFunctionToNotNull<K, V> r10 = createMemoizedFunction(r5, createConcurrentHashMap());
        if (r10 != null) goto L7;
        $$$reportNull$$$0(10);
    L7:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(19);
    L4:
        MemoizedFunctionToNullable<K, V> r10 = createMemoizedFunctionWithNullableValues(r5, createConcurrentHashMap());
        if (r10 != null) goto L7;
        $$$reportNull$$$0(20);
    L7:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NullableLazyValue<T> createNullableLazyValue(Function0<? extends T> r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(30);
    L5:
        return new LockBasedLazyValue(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(final Function0<? extends T> r5, final T r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(26);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(27);
    L7:
        return new AnonymousClass4(this, this, r5, r10);
    }

    public <K, V> RecursionDetectedResult<V> recursionDetectedDefault(String r5, K r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(35);
    L4:
        StringBuilder r11 = new StringBuilder("Recursion detected ");
        r11.append(r5);
        if (r10 != null) goto L7;
        String r12 = "";
    L8:
        r11.append(r12);
        r11.append(" under ");
        r11.append(this);
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(r11.toString())));
    L7:
        r12 = "on input: " + r10;
        goto L8
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(getClass().getSimpleName());
        r5.append("@");
        r5.append(Integer.toHexString(hashCode()));
        r5.append(" (");
        return j0.q(r5, this.debugText, ")");
    }

    private LockBasedStorageManager(String r5, ExceptionHandlingStrategy r10, SimpleLock r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(6);
    L8:
        this.lock = r11;
        this.exceptionHandlingStrategy = r10;
        this.debugText = r5;
    }

    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> r5, ConcurrentMap<K, Object> r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(15);
    L7:
        return new MapBasedMemoizedFunctionToNotNull(this, r10, r5);
    }

    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> r5, ConcurrentMap<K, Object> r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(21);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(22);
    L7:
        return new MapBasedMemoizedFunction(this, r10, r5);
    }

    public LockBasedStorageManager(String r5) {
        this(r5, null, null);
    }

    public LockBasedStorageManager(String r5, Runnable r10, Function1<InterruptedException, Unit> r11) {
        this(r5, ExceptionHandlingStrategy.THROW, SimpleLock.Companion.simpleLock(r10, r11));
    }
}
