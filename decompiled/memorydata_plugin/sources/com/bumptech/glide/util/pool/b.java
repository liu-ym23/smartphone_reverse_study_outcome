package com.bumptech.glide.util.pool;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: com.bumptech.glide.util.pool.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f994a;

        a() {
            super(null);
        }

        @Override // com.bumptech.glide.util.pool.b
        public void a(boolean r1) {
            this.f994a = r1;
        }

        @Override // com.bumptech.glide.util.pool.b
        public void b() {
            if (this.f994a == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("Already released");
        }
    }

    private b() {
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    public static b a() {
        return new a();
    }

    abstract void a(boolean r1);

    public abstract void b();
}
