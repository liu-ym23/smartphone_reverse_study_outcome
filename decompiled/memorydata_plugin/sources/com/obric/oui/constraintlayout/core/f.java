package com.obric.oui.constraintlayout.core;

/* JADX INFO: loaded from: classes5.dex */
final class f {

    interface a<T> {
        T a();

        void a(T[] r1, int r2);

        boolean a(T r1);
    }

    static class b<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object[] f13549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f13550b;

        b(int r1) {
            if (r1 <= 0) goto L7;
            this.f13549a = new Object[r1];
            return;
        L7:
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        @Override // com.obric.oui.constraintlayout.core.f.a
        public T a() {
            int r0 = this.f13550b;
            if (r0 <= 0) goto L6;
            int r2 = r0 - 1;
            Object[] r3 = this.f13549a;
            T r4 = (T) r3[r2];
            r3[r2] = null;
            this.f13550b = r0 - 1;
            return r4;
        L6:
            return null;
        }

        @Override // com.obric.oui.constraintlayout.core.f.a
        public void a(T[] r6, int r7) {
            if (r7 <= r6.length) goto L5;
            r7 = r6.length;
        L5:
            int r0 = 0;
        L6:
            if (r0 >= r7) goto L11;
            T r1 = r6[r0];
            int r2 = this.f13550b;
            Object[] r3 = this.f13549a;
            if (r2 >= r3.length) goto L10;
            r3[r2] = r1;
            this.f13550b = r2 + 1;
        L10:
            r0 = r0 + 1;
            goto L6
        }

        @Override // com.obric.oui.constraintlayout.core.f.a
        public boolean a(T r4) {
            int r0 = this.f13550b;
            Object[] r1 = this.f13549a;
            if (r0 >= r1.length) goto L6;
            r1[r0] = r4;
            this.f13550b = r0 + 1;
            return true;
        L6:
            return false;
        }
    }
}
