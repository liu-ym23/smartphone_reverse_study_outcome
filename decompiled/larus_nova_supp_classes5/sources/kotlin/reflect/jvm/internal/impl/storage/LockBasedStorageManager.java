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
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class LockBasedStorageManager implements StorageManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final StorageManager NO_LOCKS = null;
    private static final String PACKAGE_NAME = null;
    private final String debugText;
    private final ExceptionHandlingStrategy exceptionHandlingStrategy;
    protected final SimpleLock lock;

    public static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V> extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V> implements CacheWithNotNullValues<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r8) {
            if (r8 == 3) goto L5;
            String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r8 == 3) goto L9;
            int r3 = 3;
        L10:
            Object[] r4 = new Object[r3];
            if (r8 == 1) goto L17;
            if (r8 == 2) goto L16;
            if (r8 == 3) goto L15;
            r4[0] = "storageManager";
        L19:
            if (r8 == 3) goto L21;
            r4[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
        L22:
            if (r8 == 2) goto L25;
            if (r8 == 3) goto L26;
            r4[2] = "<init>";
        L26:
            String r2 = String.format(r1, r4);
            if (r8 == 3) goto L30;
            throw new IllegalArgumentException(r2);
        L30:
            throw new IllegalStateException(r2);
        L25:
            r4[2] = "computeIfAbsent";
            goto L26
        L21:
            r4[1] = "computeIfAbsent";
            goto L22
        L15:
            r4[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            goto L19
        L16:
            r4[0] = "computation";
            goto L19
        L17:
            r4[0] = "map";
            goto L19
        L9:
            r3 = 2;
            goto L10
        L5:
            r1 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        static {
        }

        private CacheWithNotNullValuesBasedOnMemoizedFunction(LockBasedStorageManager r2, ConcurrentMap<KeyWithComputation<K, V>, Object> r3) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r3 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r2, r3, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction, kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues
        public V computeIfAbsent(K r2, Function0<? extends V> r3) {
            if (r3 != null) goto L4;
            $$$reportNull$$$0(2);
        L4:
            V r4 = (V) super.computeIfAbsent(r2, r3);
            if (r4 != null) goto L7;
            $$$reportNull$$$0(3);
        L7:
            return r4;
        }

        public /* synthetic */ CacheWithNotNullValuesBasedOnMemoizedFunction(LockBasedStorageManager r1, ConcurrentMap r2, AnonymousClass1 r3) {
            this(r1, r2);
        }
    }

    public static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V> extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V> implements CacheWithNullableValues<K, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int r5) {
            Object[] r0 = new Object[3];
            if (r5 == 1) goto L7;
            if (r5 == 2) goto L6;
            r0[0] = "storageManager";
        L8:
            r0[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (r5 == 2) goto L11;
            r0[2] = "<init>";
        L13:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L11:
            r0[2] = "computeIfAbsent";
            goto L13
        L6:
            r0[0] = "computation";
            goto L8
        L7:
            r0[0] = "map";
            goto L8
        }

        private CacheWithNullableValuesBasedOnMemoizedFunction(LockBasedStorageManager r2, ConcurrentMap<KeyWithComputation<K, V>, Object> r3) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r3 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r2, r3, new AnonymousClass1());
        }

        public V computeIfAbsent(K r2, Function0<? extends V> r3) {
            if (r3 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return invoke(new KeyWithComputation(r2, r3));
        }

        public /* synthetic */ CacheWithNullableValuesBasedOnMemoizedFunction(LockBasedStorageManager r1, ConcurrentMap r2, AnonymousClass1 r3) {
            this(r1, r2);
        }
    }

    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = null;

        RuntimeException handleException(Throwable r1);

        static {
            THROW = new AnonymousClass1();
        }
    }

    public static class KeyWithComputation<K, V> {
        private final Function0<? extends V> computation;
        private final K key;

        public int hashCode() {
            return this.key.hashCode();
        }

        public static /* synthetic */ Function0 access$400(KeyWithComputation r0) {
            return r0.computation;
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

        public KeyWithComputation(K r1, Function0<? extends V> r2) {
            this.key = r1;
            this.computation = r2;
        }
    }

    public static class LockBasedLazyValue<T> implements NullableLazyValue<T> {
        private final Function0<? extends T> computable;
        private final LockBasedStorageManager storageManager;
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int r8) {
            if (r8 == 2) goto L6;
            if (r8 == 3) goto L6;
            String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r8 == 2) goto L10;
            if (r8 == 3) goto L10;
            int r3 = 3;
        L11:
            Object[] r4 = new Object[r3];
            if (r8 == 1) goto L17;
            if (r8 == 2) goto L16;
            if (r8 == 3) goto L16;
            r4[0] = "storageManager";
        L18:
            if (r8 == 2) goto L22;
            if (r8 == 3) goto L21;
            r4[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
        L23:
            if (r8 == 2) goto L26;
            if (r8 == 3) goto L26;
            r4[2] = "<init>";
        L26:
            String r5 = String.format(r2, r4);
            if (r8 == 2) goto L31;
            if (r8 == 3) goto L31;
            throw new IllegalArgumentException(r5);
        L31:
            throw new IllegalStateException(r5);
        L21:
            r4[1] = "renderDebugInformation";
            goto L23
        L22:
            r4[1] = "recursionDetected";
        L16:
            r4[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            goto L18
        L17:
            r4[0] = "computable";
        L10:
            r3 = 2;
        L6:
            r2 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        public void postCompute(T r1) {
        }

        public T invoke() {
            Object r0 = this.value;
            if ((r0 instanceof NotValue) == false) goto L5;
            this.storageManager.lock.lock();
            Object r1 = this.value;     // Catch: Throwable -> L35
            if ((r1 instanceof NotValue) == true) goto L12;
            T r2 = (T) WrappedValues.unescapeThrowable(r1);
        L10:
            this.storageManager.lock.unlock();
            return r2;
        L12:
            NotValue r3 = NotValue.COMPUTING;     // Catch: Throwable -> L35
            if (r1 != r3) goto L18;
            this.value = NotValue.RECURSION_WAS_DETECTED;     // Catch: Throwable -> L35
            RecursionDetectedResult<T> r4 = recursionDetected(true);     // Catch: Throwable -> L35
            if (r4.isFallThrough() == true) goto L18;
            r2 = (T) r4.getValue();
        L18:
            if (r1 != NotValue.RECURSION_WAS_DETECTED) goto L22;
            RecursionDetectedResult<T> r5 = recursionDetected(false);     // Catch: Throwable -> L35
            if (r5.isFallThrough() == true) goto L22;
            r2 = (T) r5.getValue();
        L22:
            this.value = r3;     // Catch: Throwable -> L35
            r2 = (T) this.computable.invoke();
            postCompute(r2);     // Catch: Throwable -> L25
            this.value = r2;     // Catch: Throwable -> L25
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
            return (T) WrappedValues.unescapeThrowable(r0);
        }

        public boolean isComputed() {
            if (this.value != NotValue.NOT_COMPUTED) goto L5;
        L7:
            return false;
        L5:
            if (this.value == NotValue.COMPUTING) goto L7;
            return true;
        }

        public RecursionDetectedResult<T> recursionDetected(boolean r3) {
            RecursionDetectedResult<T> r4 = this.storageManager.recursionDetectedDefault("in a lazy value", null);
            if (r4 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return r4;
        }

        public LockBasedLazyValue(LockBasedStorageManager r2, Function0<? extends T> r3) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r3 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            this.value = NotValue.NOT_COMPUTED;
            this.storageManager = r2;
            this.computable = r3;
        }
    }

    public static abstract class LockBasedLazyValueWithPostCompute<T> extends LockBasedLazyValue<T> {
        private volatile SingleThreadValue<T> valuePostCompute;

        private static /* synthetic */ void $$$reportNull$$$0(int r3) {
            Object[] r0 = new Object[3];
            if (r3 == 1) goto L5;
            r0[0] = "storageManager";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            r0[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L5:
            r0[0] = "computable";
            goto L6
        }

        public abstract void doPostCompute(T r1);

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
        public T invoke() {
            SingleThreadValue<T> r0 = this.valuePostCompute;
            if (r0 == null) goto L9;
            if (r0.hasValue() == false) goto L9;
            return r0.getValue();
        L9:
            return (T) super.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
        public final void postCompute(T r2) {
            this.valuePostCompute = new SingleThreadValue(r2);
            doPostCompute(r2);     // Catch: Throwable -> L6
            this.valuePostCompute = null;
            return;
        L6:
            th = move-exception;
            this.valuePostCompute = null;
            throw th;
        }

        public LockBasedLazyValueWithPostCompute(LockBasedStorageManager r2, Function0<? extends T> r3) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r3 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r2, r3);
            this.valuePostCompute = null;
        }
    }

    public static class LockBasedNotNullLazyValue<T> extends LockBasedLazyValue<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r7) {
            if (r7 == 2) goto L5;
            String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L6:
            if (r7 == 2) goto L8;
            int r2 = 3;
        L9:
            Object[] r3 = new Object[r2];
            if (r7 == 1) goto L14;
            if (r7 == 2) goto L13;
            r3[0] = "storageManager";
        L15:
            if (r7 == 2) goto L17;
            r3[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
        L18:
            if (r7 == 2) goto L20;
            r3[2] = "<init>";
        L20:
            String r4 = String.format(r1, r3);
            if (r7 == 2) goto L24;
            throw new IllegalArgumentException(r4);
        L24:
            throw new IllegalStateException(r4);
        L17:
            r3[1] = "invoke";
            goto L18
        L13:
            r3[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            goto L15
        L14:
            r3[0] = "computable";
            goto L15
        L8:
            r2 = 2;
            goto L9
        L5:
            r1 = "@NotNull method %s.%s must not return null";
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
        public T invoke() {
            T r0 = (T) super.invoke();
            if (r0 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return r0;
        }

        static {
        }

        public LockBasedNotNullLazyValue(LockBasedStorageManager r2, Function0<? extends T> r3) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r3 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r2, r3);
        }
    }

    public static abstract class LockBasedNotNullLazyValueWithPostCompute<T> extends LockBasedLazyValueWithPostCompute<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r7) {
            if (r7 == 2) goto L5;
            String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L6:
            if (r7 == 2) goto L8;
            int r2 = 3;
        L9:
            Object[] r3 = new Object[r2];
            if (r7 == 1) goto L14;
            if (r7 == 2) goto L13;
            r3[0] = "storageManager";
        L15:
            if (r7 == 2) goto L17;
            r3[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        L18:
            if (r7 == 2) goto L20;
            r3[2] = "<init>";
        L20:
            String r4 = String.format(r1, r3);
            if (r7 == 2) goto L24;
            throw new IllegalArgumentException(r4);
        L24:
            throw new IllegalStateException(r4);
        L17:
            r3[1] = "invoke";
            goto L18
        L13:
            r3[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            goto L15
        L14:
            r3[0] = "computable";
            goto L15
        L8:
            r2 = 2;
            goto L9
        L5:
            r1 = "@NotNull method %s.%s must not return null";
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
        public T invoke() {
            T r0 = (T) super.invoke();
            if (r0 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return r0;
        }

        static {
        }

        public LockBasedNotNullLazyValueWithPostCompute(LockBasedStorageManager r2, Function0<? extends T> r3) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r3 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r2, r3);
        }
    }

    public static class MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNullable<K, V> {
        private final ConcurrentMap<K, Object> cache;
        private final Function1<? super K, ? extends V> compute;
        private final LockBasedStorageManager storageManager;

        private static /* synthetic */ void $$$reportNull$$$0(int r9) {
            if (r9 == 3) goto L6;
            if (r9 == 4) goto L6;
            String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L8:
            if (r9 == 3) goto L11;
            if (r9 == 4) goto L11;
            int r4 = 3;
        L12:
            Object[] r5 = new Object[r4];
            if (r9 == 1) goto L20;
            if (r9 == 2) goto L19;
            if (r9 == 3) goto L18;
            if (r9 == 4) goto L18;
            r5[0] = "storageManager";
        L21:
            if (r9 == 3) goto L25;
            if (r9 == 4) goto L24;
            r5[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
        L26:
            if (r9 == 3) goto L29;
            if (r9 == 4) goto L29;
            r5[2] = "<init>";
        L29:
            String r3 = String.format(r2, r5);
            if (r9 == 3) goto L34;
            if (r9 == 4) goto L34;
            throw new IllegalArgumentException(r3);
        L34:
            throw new IllegalStateException(r3);
        L24:
            r5[1] = "raceCondition";
            goto L26
        L25:
            r5[1] = "recursionDetected";
        L18:
            r5[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            goto L21
        L19:
            r5[0] = "compute";
            goto L21
        L20:
            r5[0] = "map";
        L11:
            r4 = 2;
        L6:
            r2 = "@NotNull method %s.%s must not return null";
            goto L8
        }

        public LockBasedStorageManager getStorageManager() {
            return this.storageManager;
        }

        public V invoke(K r6) {
            Object r0 = this.cache.get(r6);
            if (r0 != null) goto L5;
        L8:
            this.storageManager.lock.lock();
            Object r1 = this.cache.get(r6);     // Catch: Throwable -> L57
            NotValue r2 = NotValue.COMPUTING;     // Catch: Throwable -> L57
            if (r1 != r2) goto L17;
            r1 = NotValue.RECURSION_WAS_DETECTED;     // Catch: Throwable -> L57
            RecursionDetectedResult<V> r3 = recursionDetected(r6, true);     // Catch: Throwable -> L57
            if (r3.isFallThrough() == true) goto L17;
            V r7 = (V) r3.getValue();
        L14:
            this.storageManager.lock.unlock();
            return r7;
        L17:
            if (r1 != NotValue.RECURSION_WAS_DETECTED) goto L21;
            RecursionDetectedResult<V> r4 = recursionDetected(r6, false);     // Catch: Throwable -> L57
            if (r4.isFallThrough() == true) goto L21;
            r7 = (V) r4.getValue();
        L21:
            if (r1 == null) goto L24;
            r7 = (V) WrappedValues.unescapeExceptionOrNull(r1);
            goto L14
        L24:
            AssertionError r5 = null;
            this.cache.put(r6, r2);     // Catch: Throwable -> L31
            V r8 = (V) this.compute.invoke(r6);
            Object r9 = this.cache.put(r6, WrappedValues.escapeNull(r8));     // Catch: Throwable -> L31
            if (r9 != r2) goto L29;
            this.storageManager.lock.unlock();
            return r8;
        L29:
            r5 = raceCondition(r6, r9);     // Catch: Throwable -> L31
            throw r5;     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            if (ExceptionUtilsKt.isProcessCanceledException(th) == true) goto L61;
            if (th == r5) goto L63;
            Object r10 = this.cache.put(r6, WrappedValues.escapeThrowable(th));     // Catch: Throwable -> L57
            if (r10 == NotValue.COMPUTING) goto L50;
            throw raceCondition(r6, r10);     // Catch: Throwable -> L57
        L50:
            throw LockBasedStorageManager.access$100(this.storageManager).handleException(th);     // Catch: Throwable -> L57
        L63:
            this.cache.remove(r6);     // Catch: Throwable -> L54
        L53:
            throw LockBasedStorageManager.access$100(this.storageManager).handleException(th);     // Catch: Throwable -> L57
        L54:
            th = move-exception;
            throw unableToRemoveKey(r6, th);     // Catch: Throwable -> L57
        L61:
            Object r11 = this.cache.remove(r6);     // Catch: Throwable -> L41
        L36:
            if (r11 == NotValue.COMPUTING) goto L40;
            throw inconsistentComputingKey(r6, r11);     // Catch: Throwable -> L57
        L40:
            throw th;     // Catch: Throwable -> L57
        L41:
            th = move-exception;
            throw unableToRemoveKey(r6, th);     // Catch: Throwable -> L57
        L57:
            th = move-exception;
            this.storageManager.lock.unlock();
            throw th;
        L5:
            if (r0 == NotValue.COMPUTING) goto L8;
            return (V) WrappedValues.unescapeExceptionOrNull(r0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable
        public boolean isComputed(K r2) {
            Object r3 = this.cache.get(r2);
            if (r3 != null) goto L5;
        L7:
            return false;
        L5:
            if (r3 == NotValue.COMPUTING) goto L7;
            return true;
        }

        private AssertionError inconsistentComputingKey(K r4, Object r5) {
            return (AssertionError) LockBasedStorageManager.access$200(new AssertionError("Inconsistent key detected. " + NotValue.COMPUTING + " is expected, was: " + r5 + ", most probably race condition detected on input " + r4 + " under " + this.storageManager));
        }

        private AssertionError raceCondition(K r4, Object r5) {
            AssertionError r6 = (AssertionError) LockBasedStorageManager.access$200(new AssertionError("Race condition detected on input " + r4 + ". Old value is " + r5 + " under " + this.storageManager));
            if (r6 != null) goto L5;
            $$$reportNull$$$0(4);
        L5:
            return r6;
        }

        private AssertionError unableToRemoveKey(K r4, Throwable r5) {
            return (AssertionError) LockBasedStorageManager.access$200(new AssertionError("Unable to remove " + r4 + " under " + this.storageManager, r5));
        }

        public RecursionDetectedResult<V> recursionDetected(K r2, boolean r3) {
            RecursionDetectedResult<V> r4 = this.storageManager.recursionDetectedDefault("", r2);
            if (r4 != null) goto L5;
            $$$reportNull$$$0(3);
        L5:
            return r4;
        }

        public MapBasedMemoizedFunction(LockBasedStorageManager r2, ConcurrentMap<K, Object> r3, Function1<? super K, ? extends V> r4) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r3 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            if (r4 != null) goto L8;
            $$$reportNull$$$0(2);
        L8:
            this.storageManager = r2;
            this.cache = r3;
            this.compute = r4;
        }
    }

    public static class MapBasedMemoizedFunctionToNotNull<K, V> extends MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNotNull<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r8) {
            if (r8 == 3) goto L5;
            String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r8 == 3) goto L9;
            int r3 = 3;
        L10:
            Object[] r4 = new Object[r3];
            if (r8 == 1) goto L17;
            if (r8 == 2) goto L16;
            if (r8 == 3) goto L15;
            r4[0] = "storageManager";
        L18:
            if (r8 == 3) goto L20;
            r4[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
        L21:
            if (r8 == 3) goto L23;
            r4[2] = "<init>";
        L23:
            String r2 = String.format(r1, r4);
            if (r8 == 3) goto L27;
            throw new IllegalArgumentException(r2);
        L27:
            throw new IllegalStateException(r2);
        L20:
            r4[1] = "invoke";
            goto L21
        L15:
            r4[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            goto L18
        L16:
            r4[0] = "compute";
            goto L18
        L17:
            r4[0] = "map";
            goto L18
        L9:
            r3 = 2;
            goto L10
        L5:
            r1 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        static {
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction
        public V invoke(K r2) {
            V r3 = (V) super.invoke(r2);
            if (r3 != null) goto L5;
            $$$reportNull$$$0(3);
        L5:
            return r3;
        }

        public MapBasedMemoizedFunctionToNotNull(LockBasedStorageManager r2, ConcurrentMap<K, Object> r3, Function1<? super K, ? extends V> r4) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r3 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            if (r4 != null) goto L8;
            $$$reportNull$$$0(2);
        L8:
            super(r2, r3, r4);
        }
    }

    public static final enum NotValue extends Enum<NotValue> {
        private static final /* synthetic */ NotValue[] $VALUES = null;
        public static final NotValue COMPUTING = null;
        public static final NotValue NOT_COMPUTED = null;
        public static final NotValue RECURSION_WAS_DETECTED = null;

        static {
            NotValue r0 = new NotValue("NOT_COMPUTED", 0);
            NOT_COMPUTED = r0;
            NotValue r1 = new NotValue("COMPUTING", 1);
            COMPUTING = r1;
            NotValue r3 = new NotValue("RECURSION_WAS_DETECTED", 2);
            RECURSION_WAS_DETECTED = r3;
            $VALUES = new NotValue[]{r0, r1, r3};
        }

        public static NotValue[] values() {
            return (NotValue[]) $VALUES.clone();
        }

        public static NotValue valueOf(String r1) {
            return (NotValue) a.a(NotValue.class, r1);
        }

        private NotValue(String r1, int r2) {
            super(r1, r2);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r13) {
        if (r13 == 10) goto L8;
        if (r13 == 13) goto L8;
        if (r13 == 20) goto L8;
        if (r13 == 37) goto L8;
        String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r13 == 10) goto L15;
        if (r13 == 13) goto L15;
        if (r13 == 20) goto L15;
        if (r13 == 37) goto L15;
        int r7 = 3;
    L16:
        Object[] r8 = new Object[r7];
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
        r8[0] = "debugText";
    L36:
        if (r13 == 10) goto L43;
        if (r13 == 13) goto L43;
        if (r13 == 20) goto L42;
        if (r13 == 37) goto L41;
        r8[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
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
        r8[2] = "createWithExceptionHandling";
        goto L59
    L46:
        r8[2] = "sanitizeStackTrace";
        goto L59
    L47:
        r8[2] = "recursionDetectedDefault";
        goto L59
    L48:
        r8[2] = "compute";
        goto L59
    L49:
        r8[2] = "createNullableLazyValueWithPostCompute";
        goto L59
    L50:
        r8[2] = "createRecursionTolerantNullableLazyValue";
        goto L59
    L51:
        r8[2] = "createNullableLazyValue";
        goto L59
    L52:
        r8[2] = "createLazyValueWithPostCompute";
        goto L59
    L53:
        r8[2] = "createRecursionTolerantLazyValue";
        goto L59
    L54:
        r8[2] = "createLazyValue";
        goto L59
    L55:
        r8[2] = "createMemoizedFunctionWithNullableValues";
        goto L59
    L56:
        r8[2] = "createMemoizedFunction";
        goto L59
    L57:
        r8[2] = "replaceExceptionHandling";
        goto L59
    L58:
        r8[2] = "<init>";
    L59:
        String r5 = String.format(r4, r8);
        if (r13 == 10) goto L66;
        if (r13 == 13) goto L66;
        if (r13 == 20) goto L66;
        if (r13 == 37) goto L66;
        throw new IllegalArgumentException(r5);
    L66:
        throw new IllegalStateException(r5);
    L41:
        r8[1] = "sanitizeStackTrace";
        goto L44
    L42:
        r8[1] = "createMemoizedFunctionWithNullableValues";
    L43:
        r8[1] = "createMemoizedFunction";
        goto L44
    L25:
        r8[0] = "throwable";
        goto L36
    L26:
        r8[0] = "source";
        goto L36
    L27:
        r8[0] = "postCompute";
        goto L36
    L28:
        r8[0] = "computable";
        goto L36
    L29:
        r8[0] = "map";
        goto L36
    L30:
        r8[0] = "onRecursiveCall";
        goto L36
    L31:
        r8[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
        goto L36
    L32:
        r8[0] = "compute";
        goto L36
    L33:
        r8[0] = "lock";
    L34:
        r8[0] = "exceptionHandlingStrategy";
    L15:
        r7 = 2;
    L8:
        r4 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    static {
        PACKAGE_NAME = StringsKt.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), ".", "");
        final ExceptionHandlingStrategy r1 = ExceptionHandlingStrategy.THROW;
        final EmptySimpleLock r2 = EmptySimpleLock.INSTANCE;
        final String r3 = "NO_LOCKS";
        NO_LOCKS = new AnonymousClass1(r3, r1, r2);
    }

    private static <K> ConcurrentMap<K, Object> createConcurrentHashMap() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new CacheWithNotNullValuesBasedOnMemoizedFunction(this, createConcurrentHashMap(), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        return new CacheWithNullableValuesBasedOnMemoizedFunction(this, createConcurrentHashMap(), null);
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.debugText + ")";
    }

    public LockBasedStorageManager(String r2) {
        this(r2, null, null);
    }

    public static /* synthetic */ ExceptionHandlingStrategy access$100(LockBasedStorageManager r0) {
        return r0.exceptionHandlingStrategy;
    }

    public static /* synthetic */ Throwable access$200(Throwable r0) {
        return sanitizeStackTrace(r0);
    }

    private static <T extends Throwable> T sanitizeStackTrace(T r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(36);
    L4:
        StackTraceElement[] r0 = r5.getStackTrace();
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        if (r0[r2].getClassName().startsWith(PACKAGE_NAME) == false) goto L11;
        r2 = r2 + 1;
    L11:
        List r3 = Arrays.asList(r0).subList(r2, r1);
        r5.setStackTrace((StackTraceElement[]) r3.toArray(new StackTraceElement[r3.size()]));
        return r5;
    L10:
        r2 = -1;
        goto L11
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> T compute(Function0<? extends T> r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(34);
    L4:
        this.lock.lock();
        T r3 = (T) r2.invoke();
        this.lock.unlock();
        return r3;
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
    public <T> NotNullLazyValue<T> createLazyValue(Function0<? extends T> r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(23);
    L5:
        return new LockBasedNotNullLazyValue(this, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        MemoizedFunctionToNotNull<K, V> r3 = createMemoizedFunction(r2, createConcurrentHashMap());
        if (r3 != null) goto L7;
        $$$reportNull$$$0(10);
    L7:
        return r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(19);
    L4:
        MemoizedFunctionToNullable<K, V> r3 = createMemoizedFunctionWithNullableValues(r2, createConcurrentHashMap());
        if (r3 != null) goto L7;
        $$$reportNull$$$0(20);
    L7:
        return r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NullableLazyValue<T> createNullableLazyValue(Function0<? extends T> r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(30);
    L5:
        return new LockBasedLazyValue(this, r2);
    }

    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> r2, ConcurrentMap<K, Object> r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        if (r3 != null) goto L7;
        $$$reportNull$$$0(15);
    L7:
        return new MapBasedMemoizedFunctionToNotNull(this, r3, r2);
    }

    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> r2, ConcurrentMap<K, Object> r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(21);
    L4:
        if (r3 != null) goto L7;
        $$$reportNull$$$0(22);
    L7:
        return new MapBasedMemoizedFunction(this, r3, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(final Function0<? extends T> r2, final T r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(26);
    L4:
        if (r3 != null) goto L7;
        $$$reportNull$$$0(27);
    L7:
        return new AnonymousClass4(this, this, r2, r3);
    }

    public <K, V> RecursionDetectedResult<V> recursionDetectedDefault(String r4, K r5) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(35);
    L4:
        StringBuilder r1 = new StringBuilder("Recursion detected ");
        r1.append(r4);
        if (r5 != null) goto L7;
        String r6 = "";
    L8:
        r1.append(r6);
        r1.append(" under ");
        r1.append(this);
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(r1.toString())));
    L7:
        r6 = "on input: " + r5;
        goto L8
    }

    private LockBasedStorageManager(String r2, ExceptionHandlingStrategy r3, SimpleLock r4) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        if (r4 != null) goto L8;
        $$$reportNull$$$0(6);
    L8:
        this.lock = r4;
        this.exceptionHandlingStrategy = r3;
        this.debugText = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(final Function0<? extends T> r8, final Function1<? super Boolean, ? extends T> r9, final Function1<? super T, Unit> r10) {
        if (r8 != null) goto L4;
        $$$reportNull$$$0(28);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(29);
    L7:
        return new AnonymousClass5(this, this, r8, r9, r10);
    }

    public LockBasedStorageManager(String r3, Runnable r4, Function1<InterruptedException, Unit> r5) {
        this(r3, ExceptionHandlingStrategy.THROW, SimpleLock.Companion.simpleLock(r4, r5));
    }

    public /* synthetic */ LockBasedStorageManager(String r1, ExceptionHandlingStrategy r2, SimpleLock r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }
}
