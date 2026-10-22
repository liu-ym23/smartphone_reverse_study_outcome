package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import he.i;
import java.util.Iterator;
import java.util.Map;
import z0.c;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j.b<String, b> f2721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f2723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Recreator.a f2725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2726f;

    /* JADX INFO: renamed from: androidx.savedstate.a$a, reason: collision with other inner class name */
    public interface InterfaceC0022a {
        void a(c r8);
    }

    public interface b {
        Bundle a();
    }

    public a() {
        this.f2721a = new j.b();
        this.f2726f = true;
    }

    public final Bundle a(String r8) {
        if (this.f2724d == false) goto L20;
        Bundle r10 = this.f2723c;
        if (r10 == null) goto L18;
        Bundle r11 = r10.getBundle(r8);
        Bundle r12 = this.f2723c;
        if (r12 == null) goto L9;
        r12.remove(r8);
    L9:
        Bundle r13 = this.f2723c;
        if (r13 != null) goto L12;
    L14:
        boolean r14 = false;
    L15:
        if (r14 == true) goto L17;
        this.f2723c = null;
    L17:
        return r11;
    L12:
        if (r13.isEmpty() == true) goto L14;
        r14 = true;
        goto L15
    L18:
        return null;
    L20:
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final b b() {
        Iterator<Map.Entry<String, b>> r8 = this.f2721a.iterator();
    L3:
        j.b.e r10 = (j.b.e) r8;
        if (r10.hasNext() == false) goto L8;
        Map.Entry r11 = (Map.Entry) r10.next();
        i.e(r11, "components");
        String r12 = (String) r11.getKey();
        b r13 = (b) r11.getValue();
        if (i.a(r12, "androidx.lifecycle.internal.SavedStateHandlesProvider") == false) goto L3;
        return r13;
    L8:
        return null;
    }

    public final void c(h r8) {
        if ((!this.f2722b) == false) goto L7;
        r8.a(new z0.a(this));
        this.f2722b = true;
        return;
    L7:
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }

    public final void d(Bundle r8) {
        if (this.f2722b == false) goto L14;
        if ((!this.f2724d) == false) goto L12;
        if (r8 == null) goto L8;
        Bundle r10 = r8.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
    L9:
        this.f2723c = r10;
        this.f2724d = true;
        return;
    L8:
        r10 = null;
        goto L9
    L12:
        throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
    L14:
        throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
    }

    public final void e(String r8, b r10) {
        i.f(r8, "key");
        i.f(r10, "provider");
        if (this.f2721a.b(r8, r10) != null) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
    L5:
        r11 = false;
        goto L6
    }

    public final void f() {
        if (this.f2726f == false) goto L17;
        Recreator.a r8 = this.f2725e;
        if (r8 != null) goto L7;
        r8 = new Recreator.a(this);
    L7:
        this.f2725e = r8;
        g.a.class.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L13
        Recreator.a r10 = this.f2725e;
        if (r10 == null) goto L20;
        r10.f2720a.add(g.a.class.getName());
        return;
    L20:
        return;
    L13:
        e = move-exception;
        throw new IllegalArgumentException("Class " + g.a.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
    L17:
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
    }
}
