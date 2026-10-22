package n4;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import qa.h4;
import qa.i4;
import qa.k2;
import qa.k4;
import qa.l1;
import qa.t3;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f9430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f9431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f9432c;

    public /* synthetic */ b(int r8) {
        if (r8 != 1) goto L5;
        this.f9430a = "";
        this.f9431b = new ArrayList();
        this.f9432c = new ArrayList();
        return;
    }

    public IBinder a(Intent r8) {
        k2 r10 = (k2) this.f9430a;
        r10.getClass();
        String r11 = r8.getStringExtra("a");
        if (TextUtils.isEmpty(r11) == true) goto L10;
        int r12 = i4.f10541a;
        if (TextUtils.isEmpty(r11) == true) goto L10;
        h4.f10509d = r11;
        Context r13 = r10.f10731h;
        if (r13 == null) goto L10;
        l1.f10784d.a(new h4.a(r13, r11));
    L10:
        h4.f10507b = r8.getStringExtra("b");
        String r14 = r8.getStringExtra("d");
        if (TextUtils.isEmpty(r14) == true) goto L13;
        k4.f10751d = r14;
    L13:
        k2 r15 = (k2) this.f9430a;
        r15.getClass();
        if ("true".equals(r8.getStringExtra("as")) == false) goto L18;
        k2.a r16 = r15.f10730g;
        if (r16 == null) goto L18;
        r16.sendEmptyMessageDelayed(9, 100);
    L18:
        Messenger r17 = new Messenger(((k2) this.f9430a).f10730g);
        this.f9432c = r17;
        return r17.getBinder();
    }

    public void b() {
        k2.f10723w = false;     // Catch: Throwable -> L5
        k2 r8 = (k2) this.f9430a;     // Catch: Throwable -> L5
        r8.f10736m = SystemClock.elapsedRealtime();     // Catch: Throwable -> L5
        k2 r10 = (k2) this.f9430a;     // Catch: Throwable -> L5
        r10.f10737n = System.currentTimeMillis();     // Catch: Throwable -> L5
        ((k2) this.f9430a).i();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        t3.g("ApsServiceCore", "onCreate", th);
    }

    public Method c(Class r8) {
        String r10 = (String) this.f9431b;
        if (r10 != null) goto L22;
        return null;
    L22:
        Method r11 = r8.getMethod(r10, (Class[]) this.f9432c);     // Catch: NoSuchMethodException -> L19
        if ((r11.getModifiers() & 1) == 0) goto L9;
    L10:
        if (r11 == null) goto L17;
        Class r12 = (Class) this.f9430a;
        if (r12 == null) goto L17;
        if (r12.isAssignableFrom(r11.getReturnType()) == true) goto L17;
        return null;
    L17:
        return r11;
    L9:
        r11 = null;
        goto L10
    }

    public Object d(Object[] r8, Object r10) {
        Method r11 = c(r10.getClass());
        if (r11 == null) goto L10;
        return r11.invoke(r10, r8);
    L6:
        e = move-exception;
        AssertionError r12 = new AssertionError("Unexpectedly could not call: " + r11);
        r12.initCause(e);
        throw r12;
    L10:
        throw new AssertionError("Method " + ((String) this.f9431b) + " not supported for object " + r10);
    }

    public void e(Object[] r8, Object r10) {
        Method r11 = c(r10.getClass());     // Catch: InvocationTargetException -> L7
        if (r11 == null) goto L18;
        r11.invoke(r10, r8);     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L7
        return;
    L19:
        return;
    L18:
        return;
    L7:
        e = move-exception;
        Throwable r12 = e.getTargetException();
        if ((r12 instanceof RuntimeException) == true) goto L11;
        AssertionError r13 = new AssertionError("Unexpected exception");
        r13.initCause(r12);
        throw r13;
    L11:
        throw ((RuntimeException) r12);
    }

    public b(Context r8) {
        this.f9430a = null;
        this.f9431b = null;
        this.f9432c = null;
        Context r10 = r8.getApplicationContext();
        this.f9431b = r10;
        this.f9430a = new k2(r10);
    }

    public b(Class r8, String r10, Class... r11) {
        this.f9430a = r8;
        this.f9431b = r10;
        this.f9432c = r11;
    }
}
