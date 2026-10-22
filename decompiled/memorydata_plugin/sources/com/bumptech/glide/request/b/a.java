package com.bumptech.glide.request.b;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes.dex */
public class a<R> implements b<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a<?> f964a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c<?> f965b = null;

    /* JADX INFO: renamed from: com.bumptech.glide.request.b.a$a, reason: collision with other inner class name */
    public static class C0073a<R> implements c<R> {
        public C0073a() {
        }

        @Override // com.bumptech.glide.request.b.c
        public b<R> a(DataSource r1, boolean r2) {
            return a.f964a;
        }
    }

    static {
        f964a = new a();
        f965b = new C0073a();
    }

    public a() {
    }

    public static <R> c<R> a() {
        return (c<R>) f965b;
    }
}
