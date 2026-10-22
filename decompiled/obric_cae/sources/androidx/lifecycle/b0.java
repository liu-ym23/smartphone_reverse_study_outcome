package androidx.lifecycle;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f2133a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f2134b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f2135c = null;

    public static final class a {
    }

    public static final class b {
    }

    public static final class c {
    }

    public static final class d extends he.j implements ge.l<t0.a, d0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f2136a = null;

        static {
            f2136a = new d();
        }

        public d() {
            super(1);
        }

        @Override // ge.l
        public final d0 invoke(t0.a r8) {
            he.i.f(r8, "$this$initializer");
            return new d0();
        }
    }

    static {
        f2133a = new b();
        f2134b = new c();
        f2135c = new a();
    }

    public static final a0 a(t0.d r8) {
        b r10 = f2133a;
        LinkedHashMap r11 = r8.f12206a;
        z0.c r12 = (z0.c) r11.get(r10);
        if (r12 == null) goto L42;
        l0 r13 = (l0) r11.get(f2134b);
        if (r13 == null) goto L40;
        Bundle r14 = (Bundle) r11.get(f2135c);
        String r15 = (String) r11.get(j0.f2174a);
        if (r15 == null) goto L38;
        androidx.savedstate.a.b r16 = r12.getSavedStateRegistry().b();
        if ((r16 instanceof c0) == false) goto L11;
        c0 r17 = (c0) r16;
    L12:
        if (r17 == null) goto L36;
        LinkedHashMap r18 = c(r13).f2142d;
        a0 r19 = (a0) r18.get(r15);
        if (r19 != null) goto L43;
        Class<? extends Object>[] r20 = a0.f2120f;
        boolean r21 = true;
        if (r17.f2138b == true) goto L18;
        r17.f2139c = r17.f2137a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        r17.f2138b = true;
        d0 r22 = (d0) r17.f2140d.getValue();
    L18:
        Bundle r23 = r17.f2139c;
        if (r23 == null) goto L21;
        Bundle r24 = r23.getBundle(r15);
    L22:
        Bundle r25 = r17.f2139c;
        if (r25 == null) goto L25;
        r25.remove(r15);
    L25:
        Bundle r26 = r17.f2139c;
        if (r26 != null) goto L28;
    L30:
        r21 = false;
    L31:
        if (r21 == false) goto L33;
        r17.f2139c = null;
    L33:
        a0 r27 = a0.a.a(r24, r14);
        r18.put(r15, r27);
        return r27;
    L28:
        if (r26.isEmpty() != true) goto L30;
    L21:
        r24 = null;
        goto L22
    L43:
        return r19;
    L36:
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    L11:
        r17 = null;
        goto L12
    L38:
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    L40:
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
    L42:
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends z0.c & l0> void b(T r8) {
        he.i.f(r8, "<this>");
        h.b r10 = r8.getLifecycle().b();
        if (r10 != h.b.f2158b) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L15;
        if (r8.getSavedStateRegistry().b() != null) goto L16;
        c0 r12 = new c0(r8.getSavedStateRegistry(), r8);
        r8.getSavedStateRegistry().e("androidx.lifecycle.internal.SavedStateHandlesProvider", r12);
        r8.getLifecycle().a(new SavedStateHandleAttacher(r12));
        return;
    L16:
        return;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r10 == h.b.f2159m) goto L8;
        r11 = false;
        goto L9
    }

    public static final d0 c(l0 r8) {
        he.i.f(r8, "<this>");
        t0.c r10 = new t0.c();
        he.d r11 = he.p.a(d0.class);
        d r12 = d.f2136a;
        he.i.f(r12, "initializer");
        ArrayList r13 = r10.f12209a;
        Class<?> r14 = r11.a();
        he.i.d(r14, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        r13.add(new t0.e(r14, r12));
        t0.e[] r15 = (t0.e[]) r13.toArray(new t0.e[0]);
        t0.b r16 = new t0.b((t0.e[]) Arrays.copyOf(r15, r15.length));
        k0 r17 = r8.getViewModelStore();
        if ((r8 instanceof f) == false) goto L5;
        t0.a r18 = ((f) r8).getDefaultViewModelCreationExtras();
    L7:
        return (d0) new i0(r17, r16, r18).b(d0.class, "androidx.lifecycle.internal.SavedStateHandlesVM");
    L5:
        r18 = t0.a.C0158a.f12207b;
        goto L7
    }
}
