package androidx.constraintlayout.core;

/* JADX INFO: loaded from: classes.dex */
final class Pools {
    private static final boolean DEBUG = false;

    interface Pool<T> {
        T acquire();

        boolean release(T r10);

        void releaseAll(T[] r10, int r11);
    }

    static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        SimplePool(int r10) {
            if (r10 <= 0) goto L7;
            this.mPool = new Object[r10];
            return;
        L7:
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(T r10) {
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

        @Override // androidx.constraintlayout.core.Pools.Pool
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

        @Override // androidx.constraintlayout.core.Pools.Pool
        public boolean release(T r10) {
            int r11 = this.mPoolSize;
            Object[] r12 = this.mPool;
            if (r11 >= r12.length) goto L6;
            r12[r11] = r10;
            this.mPoolSize = r11 + 1;
            return true;
        L6:
            return false;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public void releaseAll(T[] r10, int r11) {
            if (r11 <= r10.length) goto L5;
            r11 = r10.length;
        L5:
            int r12 = 0;
        L6:
            if (r12 >= r11) goto L11;
            T r13 = r10[r12];
            int r14 = this.mPoolSize;
            Object[] r15 = this.mPool;
            if (r14 >= r15.length) goto L10;
            r15[r14] = r13;
            this.mPoolSize = r14 + 1;
        L10:
            r12 = r12 + 1;
            goto L6
        }
    }

    private Pools() {
    }
}
