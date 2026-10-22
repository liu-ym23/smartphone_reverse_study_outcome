package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e0 extends i0.d implements i0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f2143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0.a f2144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f2145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f2146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.savedstate.a f2147e;

    @SuppressLint({"LambdaLast"})
    public e0(Application r8, z0.c r10, Bundle r11) {
        he.i.f(r10, "owner");
        this.f2147e = r10.getSavedStateRegistry();
        this.f2146d = r10.getLifecycle();
        this.f2145c = r11;
        this.f2143a = r8;
        if (r8 == null) goto L5;
        i0.a r12 = i0.a.C0017a.a(r8);
    L6:
        this.f2144b = r12;
        return;
    L5:
        r12 = new i0.a();
        goto L6
    }

    @Override // androidx.lifecycle.i0.b
    public final <T extends h0> T a(Class<T> r8) {
        String r10 = r8.getCanonicalName();
        if (r10 == null) goto L7;
        return (T) d(r8, r10);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.i0.b
    public final h0 b(Class r8, t0.d r10) {
        j0 r11 = j0.f2174a;
        LinkedHashMap r12 = r10.f12206a;
        String r13 = (String) r12.get(r11);
        if (r13 == null) goto L28;
        if (r12.get(b0.f2133a) == null) goto L22;
        if (r12.get(b0.f2134b) == null) goto L22;
        Application r14 = (Application) r12.get(i0.a.C0017a.C0018a.f2171a);
        boolean r15 = a.class.isAssignableFrom(r8);
        if (r15 == false) goto L12;
        if (r14 == null) goto L12;
        List<Class<?>> r16 = f0.f2148a;
    L13:
        Constructor r17 = f0.a(r8, r16);
        if (r17 == null) goto L16;
        if (r15 == false) goto L30;
        if (r14 == null) goto L30;
        return f0.b(r8, r17, new Object[]{r14, b0.a(r10)});
    L30:
        return f0.b(r8, r17, new Object[]{b0.a(r10)});
    L16:
        return this.f2144b.b(r8, r10);
    L12:
        r16 = f0.f2149b;
    L22:
        if (this.f2146d == null) goto L26;
        return d(r8, r13);
    L26:
        throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
    L28:
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.i0.d
    public final void c(h0 r8) {
        h r10 = this.f2146d;
        if (r10 == null) goto L6;
        androidx.savedstate.a r11 = this.f2147e;
        he.i.c(r11);
        g.a(r8, r11, r10);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final h0 d(Class r8, String r10) {
        h r11 = this.f2146d;
        if (r11 == null) goto L43;
        boolean r12 = a.class.isAssignableFrom(r8);
        if (r12 == true) goto L7;
    L9:
        List<Class<?>> r13 = f0.f2149b;
    L10:
        Constructor r14 = f0.a(r8, r13);
        if (r14 == null) goto L13;
        androidx.savedstate.a r15 = this.f2147e;
        he.i.c(r15);
        Bundle r16 = this.f2145c;
        Bundle r17 = r15.a(r10);
        Class<? extends Object>[] r18 = a0.f2120f;
        a0 r19 = a0.a.a(r17, r16);
        SavedStateHandleController r20 = new SavedStateHandleController(r10, r19);
        r20.b(r11, r15);
        g.b(r11, r15);
        if (r12 == false) goto L25;
        Application r21 = this.f2143a;
        if (r21 == null) goto L25;
        h0 r22 = f0.b(r8, r14, new Object[]{r21, r19});
    L26:
        HashMap r23 = r22.f2163a;
        monitor-enter(r23);
        Object r24 = r22.f2163a.get("androidx.lifecycle.savedstate.vm.tag");     // Catch: Throwable -> L39
        if (r24 != null) goto L31;
        r22.f2163a.put("androidx.lifecycle.savedstate.vm.tag", r20);     // Catch: Throwable -> L39
    L31:
        monitor-exit(r23);     // Catch: Throwable -> L39
        if (r24 == null) goto L36;
        r20 = r24;
    L36:
        if (r22.f2165c == false) goto L38;
        h0.a(r20);
    L38:
        return r22;
    L39:
        th = move-exception;
        throw th;
    L25:
        r22 = f0.b(r8, r14, new Object[]{r19});
        goto L26
    L13:
        if (this.f2143a == null) goto L16;
        return this.f2144b.a(r8);
    L16:
        if (i0.c.f2172a != null) goto L18;
        i0.c.f2172a = new i0.c();
    L18:
        i0.c r25 = i0.c.f2172a;
        he.i.c(r25);
        return r25.a(r8);
    L7:
        if (this.f2143a == null) goto L9;
        r13 = f0.f2148a;
        goto L10
    L43:
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }
}
