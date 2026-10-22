package com.bytedance.librarian;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public c() {
    }

    public void a(String r1) {
        Log.d("librarian", r1);
    }

    public void a(String r1, Throwable r2) {
        Log.w("librarian", r1, r2);
    }

    public void b(String r1) {
        Log.w("librarian", r1);
    }

    public void c(String r1) {
        System.loadLibrary(r1);
    }

    public void d(String r1) {
        System.load(r1);
    }
}
