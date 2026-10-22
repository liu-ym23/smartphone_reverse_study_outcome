package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class Pools {

    public interface Pool<T> {
        @Nullable
        T acquire();

        boolean release(@NonNull T r10);
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int r10) {
            if (r10 <= 0) goto L7;
            this.mPool = new Object[r10];
            return;
        L7:
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(@NonNull T r10) {
            int r11 = 0;
        L4:
            if (r11 >= this.mPoolSize) goto L10;
            if (this.mPool[r11] == r10) goto L7;
            r11 = r11 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int r10 = this.mPoolSize;
            if (r10 <= 0) goto L6;
            int r11 = r10 - 1;
            Object[] r12 = this.mPool;
            T r13 = (T) r12[r11];
            r12[r11] = null;
            this.mPoolSize = r10 - 1;
            return r13;
        L6:
            return null;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T r10) {
            if (isInPool(r10) == true) goto L11;
            int r11 = this.mPoolSize;
            Object[] r12 = this.mPool;
            if (r11 >= r12.length) goto L8;
            r12[r11] = r10;
            this.mPoolSize = r11 + 1;
            return true;
        L8:
            return false;
        L11:
            throw new IllegalStateException("Already in the pool!");
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        public SynchronizedPool(int r10) {
            super(r10);
            this.mLock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            Object r10 = this.mLock;
            monitor-enter(r10);
            T r11 = (T) super.acquire();
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(@NonNull T r10) {
            Object r11 = this.mLock;
            monitor-enter(r11);
            boolean r12 = super.release(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private Pools() {
    }
}
