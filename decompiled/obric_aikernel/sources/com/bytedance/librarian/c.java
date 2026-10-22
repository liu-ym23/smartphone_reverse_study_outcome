package com.bytedance.librarian;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public c() {
    }

    protected void a(String r10) {
        Log.d("librarian", r10);
    }

    protected void b(String r10) {
        Log.w("librarian", r10);
    }

    protected void c(String r10, Throwable r11) {
        Log.w("librarian", r10, r11);
    }

    protected void d(String r10) {
        System.load(r10);
    }

    protected void e(String r10) {
        System.loadLibrary(r10);
    }
}
