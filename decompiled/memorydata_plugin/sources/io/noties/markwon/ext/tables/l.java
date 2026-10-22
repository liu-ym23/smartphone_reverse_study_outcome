package io.noties.markwon.ext.tables;

import android.graphics.Paint;

/* JADX INFO: loaded from: classes6.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f16521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f16522b;
    protected final int c;
    protected final int d;
    protected final int e;
    protected final int f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f16523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f16524b;
        private int c;
        private int d;
        private int e;
        private int f;

        public a() {
            this.c = -1;
        }

        static /* synthetic */ int a(a r0) {
            return r0.f16523a;
        }

        static /* synthetic */ int b(a r0) {
            return r0.f16524b;
        }

        static /* synthetic */ int c(a r0) {
            return r0.c;
        }

        static /* synthetic */ int d(a r0) {
            return r0.d;
        }

        static /* synthetic */ int e(a r0) {
            return r0.e;
        }

        static /* synthetic */ int f(a r0) {
            return r0.f;
        }

        public a a(int r1) {
            this.f16524b = r1;
            return this;
        }

        public a b(int r1) {
            this.c = r1;
            return this;
        }

        public a c(int r1) {
            this.d = r1;
            return this;
        }

        public a d(int r1) {
            this.f = r1;
            return this;
        }
    }

    public l(a r2) {
        this.f16521a = a.a(r2);
        this.f16522b = a.b(r2);
        this.c = a.c(r2);
        this.d = a.d(r2);
        this.e = a.e(r2);
        this.f = a.f(r2);
    }

    public int a(Paint r2) {
        int r1 = this.c;
        if (r1 == (-1)) goto L5;
        return r1;
    L5:
        return (int) (r2.getStrokeWidth() + 0.5f);
    }

    public void b(Paint r2) {
        int r1 = this.f16522b;
        if (r1 != 0) goto L5;
        r1 = io.noties.markwon.g.a.a(r2.getColor(), 75);
    L5:
        r2.setColor(r1);
        r2.setStyle(Paint.Style.FILL);
    }
}
