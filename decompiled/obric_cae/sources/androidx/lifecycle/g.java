package androidx.lifecycle;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    public static final class a implements androidx.savedstate.a.InterfaceC0022a {
        public a() {
        }

        @Override // androidx.savedstate.a.InterfaceC0022a
        public final void a(z0.c r8) {
            he.i.f(r8, "owner");
            if ((r8 instanceof l0) == false) goto L13;
            k0 r10 = ((l0) r8).getViewModelStore();
            androidx.savedstate.a r11 = r8.getSavedStateRegistry();
            Iterator r12 = r10.c().iterator();
        L6:
            if (r12.hasNext() == false) goto L9;
            h0 r13 = r10.b((String) r12.next());
            he.i.c(r13);
            g.a(r13, r11, r8.getLifecycle());
            goto L6
        L9:
            if ((!r10.c().isEmpty()) == false) goto L15;
            r11.f();
            return;
        L15:
            return;
        L13:
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
        }
    }

    public static final void a(h0 r8, androidx.savedstate.a r10, h r11) {
        he.i.f(r10, "registry");
        he.i.f(r11, "lifecycle");
        HashMap r12 = r8.f2163a;
        if (r12 != null) goto L5;
        Object r13 = null;
    L8:
        SavedStateHandleController r14 = (SavedStateHandleController) r13;
        if (r14 != null) goto L11;
        return;
    L11:
        if (r14.f2118m == true) goto L20;
        r14.b(r11, r10);
        b(r11, r10);
        return;
    L20:
        return;
    L5:
        monitor-enter(r12);
        r13 = r8.f2163a.get("androidx.lifecycle.savedstate.vm.tag");     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static void b(final h r8, final androidx.savedstate.a r10) {
        h.b r11 = r8.b();
        if (r11 != h.b.f2158b) goto L5;
    L11:
        r10.f();
        return;
    L5:
        if (r11.compareTo(h.b.f2160n) < 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L11;
        r8.a(new LegacySavedStateHandleController$tryToAddRecreator$1(r8, r10));
        return;
    L7:
        r12 = false;
        goto L8
    }
}
