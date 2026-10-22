package z0;

import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.savedstate.Recreator;
import he.i;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f14169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.savedstate.a f14170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14171c;

    public static final class a {
        public static b a(c r8) {
            i.f(r8, "owner");
            return new b(r8);
        }
    }

    public b(c r8) {
        this.f14169a = r8;
        this.f14170b = new androidx.savedstate.a();
    }

    public final void a() {
        c r8 = this.f14169a;
        h r10 = r8.getLifecycle();
        if (r10.b() != h.b.f2158b) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L10;
        r10.a(new Recreator(r8));
        this.f14170b.c(r10);
        this.f14171c = true;
        return;
    L10:
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    L5:
        r11 = false;
        goto L6
    }

    public final void b(Bundle r8) {
        if (this.f14171c == true) goto L5;
        a();
    L5:
        h r10 = this.f14169a.getLifecycle();
        if ((!r10.b().a(h.b.f2160n)) == false) goto L10;
        this.f14170b.d(r8);
        return;
    L10:
        throw new IllegalStateException(("performRestore cannot be called when owner is " + r10.b()).toString());
    }

    public final void c(Bundle r8) {
        i.f(r8, "outBundle");
        androidx.savedstate.a r10 = this.f14170b;
        r10.getClass();
        Bundle r11 = new Bundle();
        Bundle r12 = r10.f2723c;
        if (r12 == null) goto L5;
        r11.putAll(r12);
    L5:
        j.b<String, androidx.savedstate.a.b> r13 = r10.f2721a;
        r13.getClass();
        j.b.d r14 = new j.b.d(r13);
        r13.f8358m.put(r14, Boolean.FALSE);
    L7:
        if (r14.hasNext() == false) goto L10;
        Map.Entry r15 = (Map.Entry) r14.next();
        r11.putBundle((String) r15.getKey(), ((androidx.savedstate.a.b) r15.getValue()).a());
        goto L7
    L10:
        if (r11.isEmpty() == true) goto L14;
        r8.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", r11);
        return;
    }
}
