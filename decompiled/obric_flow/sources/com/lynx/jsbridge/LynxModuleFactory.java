package com.lynx.jsbridge;

import android.content.Context;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.p0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class LynxModuleFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f9892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap f9893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference f9894c;
    public p0 d;
    public long e;
    public boolean f;
    public boolean g;

    public LynxModuleFactory(Context r5) {
        this.e = 0;
        this.f = false;
        this.g = false;
        this.f9892a = new ConcurrentHashMap();
        if ((r5 instanceof LynxContext) == false) goto L5;
        this.d = ((LynxContext) r5).f10150r;
    L5:
        this.f9894c = new WeakReference(r5);
    }

    @CalledByNative
    private LynxModuleWrapper moduleWrapperForName(String r5) {
        return a(r5);
    }

    private native boolean nativeRetainJniObject(long r5);

    @CalledByNative
    private void setNativePtr(long r5) {
        this.e = r5;
    }

    public final LynxModuleWrapper a(String r17) {
        if (r17 != null) goto L7;
        LynxLog.b(4, "LynxModuleFactory", "getModule failed, name is null");
        return null;
    L7:
        if (this.f9893b != null) goto L10;
        this.f9893b = new HashMap();
    L10:
        if (this.f9893b.get(r17) != null) goto L12;
        r r5 = (r) this.f9892a.get(r17);
        if (r5 != null) goto L18;
        r5 = (r) LynxEnv.inst().getModuleFactory().f9892a.get(r17);
        if (r5 != null) goto L18;
        return null;
    L18:
        Class r10 = r5.f9940b;
        boolean r11 = LynxContextModule.class.isAssignableFrom(r10);     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
        Context r12 = (Context) this.f9894c.get();     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
        if (r12 != null) goto L35;
        LynxLog.b(4, "LynxModuleFactory", r10.getCanonicalName() + " called with Null context");     // Catch: Exception -> L24 InvocationTargetException -> L26 NoSuchMethodException -> L28 IllegalAccessException -> L30 InstantiationException -> L32
        return null;
    L30:
        e = e;
        int r13 = 4;
    L91:
        LynxLog.b(r13, "LynxModuleFactory", "get Module failed" + e);
    L93:
        LynxModule r14 = null;
    L94:
        if (r14 != null) goto L97;
        LynxLog.b(0, "LynxModuleFactory", "getModule" + r17 + MessageIndication.STATUS_FAILED);
        return null;
    L97:
        r14.setExtraData(null);
        LynxModuleWrapper r15 = new LynxModuleWrapper(r17, r14);
        r15.e = this.f9894c;
        this.f9893b.put(r17, r15);
        return r15;
    L32:
        e = e;
        int r16 = 4;
    L92:
        LynxLog.b(r16, "LynxModuleFactory", "get Module failed" + e);
    L28:
        e = e;
        int r18 = 4;
    L90:
        LynxLog.b(r18, "LynxModuleFactory", "get Module failed" + e);
    L26:
        e = e;
        int r19 = 4;
    L89:
        LynxLog.b(r19, "LynxModuleFactory", "get Module failed" + e);
        LynxLog.b(r19, "LynxModuleFactory", "get TargetException " + e.getTargetException());
        goto L93
    L35:
        if (r11 == false) goto L69;
        if ((r12 instanceof LynxContext) == false) goto L66;
        if (r5.f9941c != null) goto L64;
        Constructor<?>[] r20 = r10.getConstructors();     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
        int r21 = r20.length;     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
        int r22 = 0;
    L42:
        if (r22 >= r21) goto L93;
        Constructor<?> r110 = r20[r22];     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
        Class<?>[] r23 = r110.getParameterTypes();     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
        if (r23.length != 1) goto L57;
        if (LynxContext.class.equals(r23[0]) == false) goto L57;
        LynxModule r24 = (LynxModule) r110.newInstance(new Object[]{(LynxContext) r12});     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
    L84:
        r14 = r24;
    L57:
        if (r23.length != 2) goto L63;
        if (LynxContext.class.equals(r23[0]) == false) goto L63;
        if (Object.class.equals(r23[1]) == false) goto L63;
        r24 = (LynxModule) r110.newInstance(new Object[]{(LynxContext) r12, null});     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
    L63:
        r22 = r22 + 1;     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
        goto L42
    L64:
        r24 = (LynxModule) r10.getConstructor(new Class[]{LynxContext.class, Object.class}).newInstance(new Object[]{(LynxContext) r12, r5.f9941c});     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
        goto L84
    L66:
        throw new Exception(r10.getCanonicalName() + " must be created with LynxContext");     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
    L69:
        if (r5.f9941c != null) goto L86;
        Constructor<?>[] r25 = r10.getConstructors();     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
        int r26 = r25.length;     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
        int r27 = 0;
    L71:
        if (r27 >= r26) goto L93;
        Constructor<?> r28 = r25[r27];     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
        Class<?>[] r111 = r28.getParameterTypes();     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
        if (r111.length != 1) goto L78;
        if (Context.class.equals(r111[0]) == false) goto L78;
        r24 = (LynxModule) r28.newInstance(new Object[]{r12});     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
    L78:
        if (r111.length != 2) goto L85;
        if (Context.class.equals(r111[0]) == false) goto L85;
        if (Object.class.equals(r111[1]) == false) goto L85;
        r24 = (LynxModule) r28.newInstance(new Object[]{r12, null});     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
    L85:
        r27 = r27 + 1;     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
        goto L71
    L86:
        r14 = (LynxModule) r10.getConstructor(new Class[]{Context.class, Object.class}).newInstance(new Object[]{r12, r5.f9941c});     // Catch: Exception -> L24 InvocationTargetException -> L48 NoSuchMethodException -> L50 IllegalAccessException -> L52 InstantiationException -> L54
    L24:
        e = move-exception;
        LynxLog.b(4, "LynxModuleFactory", "get Module failed" + e);
    L52:
        e = e;
        r13 = 4;
    L54:
        e = e;
        r16 = 4;
    L50:
        e = e;
        r18 = 4;
    L48:
        e = e;
        r19 = 4;
        goto L89
    L12:
        return (LynxModuleWrapper) this.f9893b.get(r17);
    }

    public final void b() {
        if (nativeRetainJniObject(this.e) == true) goto L6;
        LynxLog.b(4, "LynxModuleFactory", "LynxModuleFactory try to retainJniObject failed");
        destroy();
        return;
    }

    public final void c(Class r5, Object r10, String r11) {
        r r12 = new r();
        r12.f9939a = r11;
        r12.f9940b = r5;
        r12.f9941c = r10;
        ConcurrentHashMap r13 = this.f9892a;
        r r14 = (r) r13.get(r11);
        if (r14 == null) goto L5;
        LynxLog.b(4, "LynxModuleFactory", "Duplicated LynxModule For Name: " + r11 + ", " + r14 + " will be override");
    L5:
        r13.put(r11, r12);
        LynxLog.b(0, "LynxModuleFactory", "registered module with name: " + r11 + " class" + r5);
    }

    public final void d(ArrayList r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.size() == 0) goto L17;
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L18;
        r r5 = (r) r11.next();
        String r12 = r5.f9939a;
        ConcurrentHashMap r13 = this.f9892a;
        r r14 = (r) r13.get(r12);
        if (r14 == null) goto L12;
        LynxLog.b(4, "LynxModuleFactory", "Duplicated LynxModule For Name: " + r12 + ", " + r14 + " will be override");
    L12:
        r13.put(r12, r5);
        goto L8
    L18:
        return;
    }

    @CalledByNative
    public void destroy() {
        if (this.g == false) goto L5;
        return;
    L5:
        this.g = true;
        HashMap r5 = this.f9893b;
        if (r5 == null) goto L12;
        Iterator r10 = r5.values().iterator();
    L9:
        if (r10.hasNext() == false) goto L12;
        ((LynxModuleWrapper) r10.next()).f9895a.destroy();
    L12:
        if (this.f == false) goto L14;
        a6.a r11 = new a6.a(this, 27);
        com.lynx.tasm.utils.j.a().post(r11);
    L14:
        this.e = 0;
        this.f9893b = null;
        this.f9892a.clear();
    }
}
