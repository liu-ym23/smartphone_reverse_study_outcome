package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements d1.b<m> {
    public ProcessLifecycleInitializer() {
    }

    @Override // d1.b
    public final List<Class<? extends d1.b<?>>> a() {
        return yd.k.f14119a;
    }

    @Override // d1.b
    public final m b(Context r8) {
        he.i.f(r8, "context");
        d1.a r10 = d1.a.c(r8);
        he.i.e(r10, "getInstance(context)");
        if (r10.f6748b.contains(ProcessLifecycleInitializer.class) == false) goto L11;
        if (j.f2173a.getAndSet(true) == true) goto L8;
        Context r11 = r8.getApplicationContext();
        he.i.d(r11, "null cannot be cast to non-null type android.app.Application");
        ((Application) r11).registerActivityLifecycleCallbacks(new j.a());
    L8:
        w r12 = w.f2195r;
        r12.getClass();
        r12.f2200o = new Handler();
        r12.f2201p.f(h.a.ON_CREATE);
        Context r13 = r8.getApplicationContext();
        he.i.d(r13, "null cannot be cast to non-null type android.app.Application");
        ((Application) r13).registerActivityLifecycleCallbacks(new x(r12));
        return r12;
    L11:
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }
}
