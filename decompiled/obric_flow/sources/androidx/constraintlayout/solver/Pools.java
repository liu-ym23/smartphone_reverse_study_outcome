package androidx.constraintlayout.solver;

/* JADX INFO: loaded from: classes.dex */
final class Pools {
    private static final boolean DEBUG = false;

    public interface Pool<T> {
        T acquire();

        boolean release(T r5);

        void releaseAll(T[] r5, int r10);
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int r5) {
            if (r5 <= 0) goto L7;
            this.mPool = new Object[r5];
            return;
        L7:
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(T r5) {
            int r10 = 0;
        L4:
            if (r10 >= this.mPoolSize) goto L10;
            if (this.mPool[r10] == r5) goto L7;
            r10 = r10 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public T acquire() {
            int r5 = this.mPoolSize;
            if (r5 <= 0) goto L6;
            int r10 = r5 - 1;
            Object[] r11 = this.mPool;
            T r12 = (T) r11[r10];
            r11[r10] = null;
            this.mPoolSize = r5 - 1;
            return r12;
        L6:
            return null;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public boolean release(T r5) {
            int r10 = this.mPoolSize;
            Object[] r11 = this.mPool;
            if (r10 >= r11.length) goto L6;
            r11[r10] = r5;
            this.mPoolSize = r10 + 1;
            return true;
        L6:
            return false;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public void releaseAll(T[] r10, int r11) {
            if (r11 <= r10.length) goto L5;
            r11 = r10.length;
        L5:
            int r5 = 0;
        L6:
            if (r5 >= r11) goto L11;
            T r12 = r10[r5];
            int r13 = this.mPoolSize;
            Object[] r14 = this.mPool;
            if (r13 >= r14.length) goto L10;
            r14[r13] = r12;
            this.mPoolSize = r13 + 1;
        L10:
            r5 = r5 + 1;
            goto L6
        }
    }

    private Pools() {
    }
}
