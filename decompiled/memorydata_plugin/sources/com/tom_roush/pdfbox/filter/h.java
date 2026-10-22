package com.tom_roush.pdfbox.filter;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f16105a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f16106b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;

    private static class a extends h {
        a(boolean r1) {
            super.a(r1);
        }

        @Override // com.tom_roush.pdfbox.filter.h
        public void a(Rect r1) {
            throw new UnsupportedOperationException("This instance may not be modified.");
        }

        @Override // com.tom_roush.pdfbox.filter.h
        void a(boolean r1) {
        }
    }

    static {
        f16105a = new a(true);
    }

    public h() {
        this.f16106b = null;
        this.c = 1;
        this.d = 1;
        this.e = 0;
        this.f = 0;
        this.g = false;
    }

    public h(int r2) {
        this.f16106b = null;
        this.c = 1;
        this.d = 1;
        this.e = 0;
        this.f = 0;
        this.g = false;
        this.c = r2;
        this.d = r2;
    }

    public void a(Rect r1) {
        this.f16106b = r1;
    }

    void a(boolean r1) {
        this.g = r1;
    }

    public boolean a() {
        return this.g;
    }
}
