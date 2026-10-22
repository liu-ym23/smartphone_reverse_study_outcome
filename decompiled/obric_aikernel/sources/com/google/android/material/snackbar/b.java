package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static b f3804e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final Object f3805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final Handler f3806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private c f3807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private c f3808d;

    class a implements Handler.Callback {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f3809c;

        a(b r10) {
            this.f3809c = r10;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message r10) {
            if (r10.what == 0) goto L6;
            return false;
        L6:
            this.f3809c.d((c) r10.obj);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.b$b, reason: collision with other inner class name */
    interface InterfaceC0085b {
        void a(int r10);

        void show();
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        final WeakReference<InterfaceC0085b> f3810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f3812c;

        boolean a(@Nullable InterfaceC0085b r10) {
            if (r10 != null) goto L4;
        L6:
            return false;
        L4:
            if (this.f3810a.get() != r10) goto L6;
            return true;
        }
    }

    private b() {
        this.f3805a = new Object();
        this.f3806b = new Handler(Looper.getMainLooper(), new a(this));
    }

    private boolean a(@NonNull c r10, int r11) {
        InterfaceC0085b r12 = r10.f3810a.get();
        if (r12 == null) goto L6;
        this.f3806b.removeCallbacksAndMessages(r10);
        r12.a(r11);
        return true;
    L6:
        return false;
    }

    static b c() {
        if (f3804e != null) goto L6;
        f3804e = new b();
    L6:
        return f3804e;
    }

    private boolean f(InterfaceC0085b r10) {
        c r11 = this.f3807c;
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.a(r10) == false) goto L7;
        return true;
    }

    private boolean g(InterfaceC0085b r10) {
        c r11 = this.f3808d;
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.a(r10) == false) goto L7;
        return true;
    }

    private void l(@NonNull c r10) {
        int r11 = r10.f3811b;
        if (r11 != (-2)) goto L6;
        return;
    L6:
        if (r11 <= 0) goto L9;
    L12:
        this.f3806b.removeCallbacksAndMessages(r10);
        Handler r12 = this.f3806b;
        r12.sendMessageDelayed(Message.obtain(r12, 0, r10), r11);
        return;
    L9:
        if (r11 != (-1)) goto L11;
        r11 = 1500;
        goto L12
    L11:
        r11 = 2750;
        goto L12
    }

    private void m() {
        c r10 = this.f3808d;
        if (r10 == null) goto L9;
        this.f3807c = r10;
        this.f3808d = null;
        InterfaceC0085b r11 = r10.f3810a.get();
        if (r11 == null) goto L7;
        r11.show();
        return;
    L7:
        this.f3807c = null;
        return;
    }

    public void b(InterfaceC0085b r10, int r11) {
        Object r12 = this.f3805a;
        monitor-enter(r12);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f(r10) == false) goto L9;
        c r13 = this.f3807c;     // Catch: Throwable -> L13
    L7:
        a(r13, r11);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L13
        return;
    L9:
        if (g(r10) == false) goto L11;
        r13 = this.f3808d;     // Catch: Throwable -> L13
        goto L7
    }

    void d(@NonNull c r10) {
        Object r11 = this.f3805a;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f3807c != r10) goto L7;
    L8:
        a(r10, 2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.f3808d != r10) goto L9;
        goto L8
    }

    public boolean e(InterfaceC0085b r10) {
        Object r11 = this.f3805a;
        monitor-enter(r11);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f(r10) == false) goto L7;
    L10:
        boolean r12 = true;
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L13
        return r12;
    L7:
        if (g(r10) == true) goto L10;
        r12 = false;
        goto L11
    }

    public void h(InterfaceC0085b r10) {
        Object r11 = this.f3805a;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f(r10) == false) goto L9;
        this.f3807c = null;     // Catch: Throwable -> L11
        if (this.f3808d == null) goto L9;
        m();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L11
    }

    public void i(InterfaceC0085b r10) {
        Object r11 = this.f3805a;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f(r10) == false) goto L7;
        l(this.f3807c);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L9
    }

    public void j(InterfaceC0085b r10) {
        Object r11 = this.f3805a;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f(r10) == false) goto L9;
        c r12 = this.f3807c;     // Catch: Throwable -> L11
        if (r12.f3812c == true) goto L9;
        r12.f3812c = true;     // Catch: Throwable -> L11
        this.f3806b.removeCallbacksAndMessages(r12);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L11
    }

    public void k(InterfaceC0085b r10) {
        Object r11 = this.f3805a;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f(r10) == false) goto L9;
        c r12 = this.f3807c;     // Catch: Throwable -> L11
        if (r12.f3812c == false) goto L9;
        r12.f3812c = false;     // Catch: Throwable -> L11
        l(r12);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L11
    }
}
