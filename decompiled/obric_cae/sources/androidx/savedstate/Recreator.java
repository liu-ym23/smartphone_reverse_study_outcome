package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.lifecycle.k;
import androidx.lifecycle.m;
import defpackage.b;
import he.i;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import z0.c;

/* JADX INFO: loaded from: classes.dex */
public final class Recreator implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f2719a;

    public static final class a implements androidx.savedstate.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashSet f2720a;

        public a(androidx.savedstate.a r8) {
            i.f(r8, "registry");
            this.f2720a = new LinkedHashSet();
            r8.e("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.a.b
        public final Bundle a() {
            Bundle r8 = new Bundle();
            r8.putStringArrayList("classes_to_restore", new ArrayList(this.f2720a));
            return r8;
        }
    }

    public Recreator(c r8) {
        i.f(r8, "owner");
        this.f2719a = r8;
    }

    @Override // androidx.lifecycle.k
    public final void onStateChanged(m r8, h.a r10) {
        if (r10 != h.a.ON_CREATE) goto L31;
        r8.getLifecycle().c(this);
        c r11 = this.f2719a;
        Bundle r12 = r11.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (r12 != null) goto L7;
        return;
    L7:
        ArrayList<String> r13 = r12.getStringArrayList("classes_to_restore");
        if (r13 == null) goto L29;
        Iterator<String> r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L27;
        String r15 = r14.next();
        Class<? extends U> r16 = Class.forName(r15, false, Recreator.class.getClassLoader()).asSubclass(androidx.savedstate.a.InterfaceC0022a.class);     // Catch: ClassNotFoundException -> L24
        i.e(r16, "{\n                Class.…class.java)\n            }");     // Catch: ClassNotFoundException -> L24
        Constructor r17 = r16.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L21
        r17.setAccessible(true);
        Object r18 = r17.newInstance(new Object[0]);     // Catch: Exception -> L18
        i.e(r18, "{\n                constr…wInstance()\n            }");     // Catch: Exception -> L18
        ((androidx.savedstate.a.InterfaceC0022a) r18).a(r11);
    L18:
        e = move-exception;
        throw new RuntimeException(b.c("Failed to instantiate ", r15), e);
    L21:
        e = move-exception;
        throw new IllegalStateException("Class " + r16.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
    L24:
        e = move-exception;
        throw new RuntimeException(b.d("Class ", r15, " wasn't found"), e);
    L27:
        return;
    L29:
        throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
    L31:
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
