package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.y;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class e extends Activity implements androidx.lifecycle.m, j0.e {
    private n.h<Class<? extends a>, a> mExtraDataMap;
    private androidx.lifecycle.n mLifecycleRegistry;

    @Deprecated
    public static class a {
        public a() {
        }
    }

    public e() {
        this.mExtraDataMap = new n.h();
        this.mLifecycleRegistry = new androidx.lifecycle.n(this);
    }

    private static boolean shouldSkipDump(String[] r8) {
        if (r8 != null) goto L5;
    L35:
        return false;
    L5:
        if (r8.length <= 0) goto L35;
        String r10 = r8[0];
        r10.getClass();
        byte r11 = -1;
        switch(r10.hashCode()) {
            case -645125871: goto L26;
            case 100470631: goto L22;
            case 472614934: goto L18;
            case 1159329357: goto L14;
            case 1455016274: goto L10;
            default: goto L29;
        };
    L29:
        switch(r11) {
            case 0: goto L34;
            case 1: goto L33;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L31;
            default: goto L35;
        };
    L31:
        return true;
    L34:
        return true;
    L33:
        return f0.a.a();
    L10:
        if (r10.equals("--autofill") == false) goto L29;
        r11 = 4;
        goto L29
    L14:
        if (r10.equals("--contentcapture") == false) goto L29;
        r11 = 3;
        goto L29
    L18:
        if (r10.equals("--list-dumpables") == false) goto L29;
        r11 = 2;
        goto L29
    L22:
        if (r10.equals("--dump-dumpable") == false) goto L29;
        r11 = 1;
        goto L29
    L26:
        if (r10.equals("--translation") == false) goto L29;
        r11 = 0;
        goto L29
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r8) {
        if (getWindow().getDecorView() == null) goto L6;
        WeakHashMap<View, h0> r10 = w.f8437a;
    L6:
        return superDispatchKeyEvent(r8);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r8) {
        if (getWindow().getDecorView() == null) goto L6;
        WeakHashMap<View, h0> r10 = w.f8437a;
    L6:
        return super.dispatchKeyShortcutEvent(r8);
    }

    @Deprecated
    public <T extends a> T getExtraData(Class<T> r8) {
        return (T) this.mExtraDataMap.getOrDefault(r8, null);
    }

    public androidx.lifecycle.h getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        int r10 = y.f2204b;
        y.b.b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle r8) {
        androidx.lifecycle.n r10 = this.mLifecycleRegistry;
        androidx.lifecycle.h.b r11 = androidx.lifecycle.h.b.f2159m;
        r10.getClass();
        r10.e("markState");
        r10.h(r11);
        super.onSaveInstanceState(r8);
    }

    @Deprecated
    public void putExtraData(a r8) {
        this.mExtraDataMap.put((Class<? extends a>) r8.getClass(), r8);
    }

    public final boolean shouldDumpInternalState(String[] r8) {
        return !shouldSkipDump(r8);
    }

    @Override // j0.e
    public boolean superDispatchKeyEvent(KeyEvent r8) {
        return super.dispatchKeyEvent(r8);
    }
}
