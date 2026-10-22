package com.bytedance.apm.block;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f779a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f780b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Object f781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Thread f785g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a f786h;

    public static class a {
        volatile boolean haveAdd;
        volatile boolean haveRemove;
        List<j> mAddObservers;
        final List<j> mObservers;
        List<j> mRemoveObservers;

        public a() {
            this.mObservers = new ArrayList();
            this.mRemoveObservers = new ArrayList();
            this.mAddObservers = new ArrayList();
            this.haveRemove = false;
            this.haveAdd = false;
        }

        public void addMessageObserver(j r10) {
            List<j> r11 = this.mObservers;
            monitor-enter(r11);
            if (r10 != null) goto L13;
        L8:
            monitor-exit(r11);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            if (this.mAddObservers.contains(r10) == true) goto L8;
            this.mAddObservers.add(r10);     // Catch: Throwable -> L10
            this.haveAdd = true;     // Catch: Throwable -> L10
            goto L8
        }

        protected void messageDispatchStarting(String r10) {
            if (this.haveAdd == false) goto L18;
            List<j> r11 = this.mObservers;
            monitor-enter(r11);
            Iterator<j> r12 = this.mAddObservers.iterator();     // Catch: Throwable -> L15
        L8:
            if (r12.hasNext() == false) goto L12;
            j r13 = r12.next();     // Catch: Throwable -> L15
            if (this.mObservers.contains(r13) == true) goto L8;
            this.mObservers.add(r13);     // Catch: Throwable -> L15
            goto L8
        L12:
            this.mAddObservers.clear();     // Catch: Throwable -> L15
            this.haveAdd = false;     // Catch: Throwable -> L15
            monitor-exit(r11);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        L18:
            Iterator<j> r14 = this.mObservers.iterator();
        L20:
            if (r14.hasNext() == false) goto L24;
            j r15 = r14.next();
            if (r15 == null) goto L20;
            r15.messageDispatchStarting(r10);
            goto L20
        }

        public void messageDispatched(String r10, Message r11) {
            Iterator<j> r12 = this.mObservers.iterator();
        L4:
            if (r12.hasNext() == false) goto L9;
            j r13 = r12.next();
            if (r13 == null) goto L4;
            r13.messageDispatched(r10, r11);
            goto L4
        L9:
            if (this.haveRemove == false) goto L22;
            List<j> r14 = this.mObservers;
            monitor-enter(r14);
            Iterator<j> r15 = this.mRemoveObservers.iterator();     // Catch: Throwable -> L19
        L14:
            if (r15.hasNext() == false) goto L16;
            j r16 = r15.next();     // Catch: Throwable -> L19
            this.mObservers.remove(r16);     // Catch: Throwable -> L19
            this.mAddObservers.remove(r16);     // Catch: Throwable -> L19
            goto L14
        L16:
            this.mRemoveObservers.clear();     // Catch: Throwable -> L19
            this.haveRemove = false;     // Catch: Throwable -> L19
            monitor-exit(r14);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        }

        public void removeMessageObserver(j r10) {
            List<j> r11 = this.mObservers;
            monitor-enter(r11);
            if (r10 != null) goto L13;
        L8:
            monitor-exit(r11);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            if (this.mRemoveObservers.contains(r10) == true) goto L8;
            this.mRemoveObservers.add(r10);     // Catch: Throwable -> L10
            this.haveRemove = true;     // Catch: Throwable -> L10
            goto L8
        }

        protected void setup(Object r10) {
        }
    }

    static {
        f785g = Looper.getMainLooper().getThread();
    }

    public static void a(j r10) {
        a r11 = f786h;
        if (r11 == null) goto L6;
        r11.addMessageObserver(r10);
        return;
    }

    public static void b() {
        if (f779a == true) goto L5;
        return;
    L5:
        if (f786h == null) goto L12;
        g(Looper.class, "setObserver", new Class[]{Class.forName("android.os.Looper$Observer")}).invoke(null, new Object[]{f786h});     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    public static List<j> c() {
        a r10 = f786h;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.mObservers;
    }

    public static synchronized boolean d(Printer r10) {
        monitor-enter(k.class);
    L32:
        th = move-exception;
        throw th;
    L6:
        if (f779a == false) goto L11;
        monitor-exit(k.class);
        return true;
    L11:
        if (Build.VERSION.SDK_INT >= 29) goto L35;
    L29:
        f786h = new a();     // Catch: Throwable -> L32
        f781c = null;     // Catch: Throwable -> L32
        f780b = true;     // Catch: Throwable -> L32
        f779a = true;     // Catch: Throwable -> L32
        boolean r11 = f779a;     // Catch: Throwable -> L32
        monitor-exit(k.class);
        return r11;
    L35:
        Object r12 = h(Looper.class, null, "sObserver");     // Catch: Throwable -> L28
        f781c = r12;     // Catch: Throwable -> L28
        if (r12 == null) goto L16;
        f782d = g(r12.getClass(), "messageDispatchStarting", new Class[0]);     // Catch: Throwable -> L28
        f783e = g(f781c.getClass(), "messageDispatched", new Class[]{Object.class, Message.class});     // Catch: Throwable -> L28
        f784f = g(f781c.getClass(), "dispatchingThrewException", new Class[]{Object.class, Message.class, Exception.class});     // Catch: Throwable -> L28
    L16:
        if (f782d != null) goto L18;
    L21:
        f781c = null;     // Catch: Throwable -> L28
    L22:
        f786h = (a) Class.forName("com.bytedance.observer.ObserverWrapper").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L28
        if (f781c == null) goto L25;
        System.out.println("LooperObserverMonitor.init: " + f781c);     // Catch: Throwable -> L28
        f786h.setup(f781c);     // Catch: Throwable -> L28
    L25:
        g(Looper.class, "setObserver", new Class[]{Class.forName("android.os.Looper$Observer")}).invoke(null, new Object[]{f786h});     // Catch: Throwable -> L28
        f779a = true;     // Catch: Throwable -> L28
        boolean r13 = f779a;     // Catch: Throwable -> L28
        monitor-exit(k.class);
        return r13;
    L18:
        if (f783e == null) goto L21;
        if (f784f != null) goto L22;
    L28:
        f781c = null;     // Catch: Throwable -> L32
        goto L29
    }

    public static void e(String r10) {
        a r11 = f786h;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.messageDispatchStarting(r10);
    }

    public static void f(String r10, Message r11) {
        a r12 = f786h;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.messageDispatched(r10, r11);
    }

    public static Method g(Class r10, String r11, Class<?>... r12) {
        Method r13 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r10, new Object[]{r11, r12});     // Catch: Exception -> L4
        r13.setAccessible(true);     // Catch: Exception -> L4
        return r13;
    L4:
        return null;
    }

    private static <T> T h(Class r10, Object r11, String r12) {
        Field r13 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r10, new Object[]{r12});     // Catch: Exception -> L4
        r13.setAccessible(true);     // Catch: Exception -> L4
        return (T) r13.get(r11);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void i(j r10) {
        a r11 = f786h;
        if (r11 == null) goto L6;
        r11.removeMessageObserver(r10);
        return;
    }

    public static void j() {
        if (f779a == true) goto L5;
        return;
    L5:
        if (f786h == null) goto L16;
        Method r10 = g(Looper.class, "setObserver", new Class[]{Class.forName("android.os.Looper$Observer")});     // Catch: Throwable -> L11
        Object r11 = f781c;     // Catch: Throwable -> L11
        if (r11 != null) goto L9;
        r10.invoke(null, new Object[]{null});     // Catch: Throwable -> L11
    L12:
        return;
    L9:
        r10.invoke(null, new Object[]{r11});     // Catch: Throwable -> L11
    L17:
        return;
    }
}
