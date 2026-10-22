package androidx.activity;

import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f448a;

    public ImmLeaksCleaner() {
        throw null;
    }

    @Override // androidx.lifecycle.k
    public final void onStateChanged(androidx.lifecycle.m r8, androidx.lifecycle.h.a r10) {
        if (r10 == androidx.lifecycle.h.a.ON_DESTROY) goto L6;
        return;
    L6:
        if (f448a != 0) goto L10;
        f448a = 2;     // Catch: NoSuchFieldException -> L14
        InputMethodManager.class.getDeclaredField("mServedView").setAccessible(true);     // Catch: NoSuchFieldException -> L14
        InputMethodManager.class.getDeclaredField("mNextServedView").setAccessible(true);     // Catch: NoSuchFieldException -> L14
        InputMethodManager.class.getDeclaredField("mH").setAccessible(true);     // Catch: NoSuchFieldException -> L14
        f448a = 1;     // Catch: NoSuchFieldException -> L14
    L10:
        if (f448a == 1) goto L13;
        return;
    L13:
        throw null;
    }
}
