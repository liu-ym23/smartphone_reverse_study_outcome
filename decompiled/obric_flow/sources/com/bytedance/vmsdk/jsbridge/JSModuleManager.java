package com.bytedance.vmsdk.jsbridge;

import android.content.Context;
import android.util.Log;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.vmsdk.jsbridge.utils.CalledByNative;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class JSModuleManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f7546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap f7547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f7548c;

    public JSModuleManager(Context r5) {
        this.f7546a = new ConcurrentHashMap();
        this.f7548c = r5;
    }

    @CalledByNative
    private JSModuleWrapper moduleWrapperForName(String r5) {
        return a(r5);
    }

    public final JSModuleWrapper a(String r15) {
        if (r15 != null) goto L7;
        Log.e("VmsdkModuleManager", "getModule failed, name is null");
        return null;
    L7:
        if (this.f7547b != null) goto L10;
        this.f7547b = new ConcurrentHashMap();
    L10:
        if (this.f7547b.get(r15) != null) goto L12;
        c r5 = (c) this.f7546a.get(r15);
        if (r5 != null) goto L16;
        return null;
    L16:
        Class r10 = r5.f7556b;
    L33:
        e = move-exception;
        Log.e("VmsdkModuleManager", "get Module failed" + e);
    L53:
        JSModule r11 = null;
    L54:
        if (r11 != null) goto L57;
        Log.v("VmsdkModuleManager", "getModule" + r15 + MessageIndication.STATUS_FAILED);
        return null;
    L57:
        JSModuleWrapper r12 = new JSModuleWrapper(r15, r11);
        this.f7547b.put(r15, r12);
        return r12;
    L35:
        e = move-exception;
        Log.e("VmsdkModuleManager", "get Module failed" + e);
    L31:
        e = move-exception;
        Log.e("VmsdkModuleManager", "get Module failed" + e);
    L29:
        e = move-exception;
        Log.e("VmsdkModuleManager", "get Module failed" + e);
    L27:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "get Module failed", "VmsdkModuleManager");
        goto L53
    L19:
        if (r5.f7557c != null) goto L45;
        Constructor<?>[] r13 = r10.getConstructors();     // Catch: Exception -> L27 InvocationTargetException -> L29 NoSuchMethodException -> L31 IllegalAccessException -> L33 InstantiationException -> L35
        int r14 = r13.length;     // Catch: Exception -> L27 InvocationTargetException -> L29 NoSuchMethodException -> L31 IllegalAccessException -> L33 InstantiationException -> L35
        int r16 = 0;
    L21:
        if (r16 >= r14) goto L53;
        Constructor<?> r17 = r13[r16];     // Catch: Exception -> L27 InvocationTargetException -> L29 NoSuchMethodException -> L31 IllegalAccessException -> L33 InstantiationException -> L35
        Class<?>[] r18 = r17.getParameterTypes();     // Catch: Exception -> L27 InvocationTargetException -> L29 NoSuchMethodException -> L31 IllegalAccessException -> L33 InstantiationException -> L35
        if (r18.length != 1) goto L38;
        if (Context.class.equals(r18[0]) == false) goto L38;
        r11 = (JSModule) r17.newInstance(new Object[]{this.f7548c});     // Catch: Exception -> L27 InvocationTargetException -> L29 NoSuchMethodException -> L31 IllegalAccessException -> L33 InstantiationException -> L35
    L38:
        if (r18.length != 2) goto L44;
        if (Context.class.equals(r18[0]) == false) goto L44;
        if (Object.class.equals(r18[1]) == false) goto L44;
        r11 = (JSModule) r17.newInstance(new Object[]{this.f7548c, null});     // Catch: Exception -> L27 InvocationTargetException -> L29 NoSuchMethodException -> L31 IllegalAccessException -> L33 InstantiationException -> L35
    L44:
        r16 = r16 + 1;     // Catch: Exception -> L27 InvocationTargetException -> L29 NoSuchMethodException -> L31 IllegalAccessException -> L33 InstantiationException -> L35
        goto L21
    L45:
        if (r10 == null) goto L53;
        r11 = (JSModule) r10.getConstructor(new Class[]{Context.class, Object.class}).newInstance(new Object[]{this.f7548c, r5.f7557c});     // Catch: Exception -> L27 InvocationTargetException -> L29 NoSuchMethodException -> L31 IllegalAccessException -> L33 InstantiationException -> L35
        goto L54
    L12:
        return (JSModuleWrapper) this.f7547b.get(r15);
    }

    public final void b(Class r5, Object r10, String r11) {
        c r12 = new c();
        r12.f7555a = r11;
        r12.f7556b = r5;
        r12.f7557c = r10;
        ConcurrentHashMap r13 = this.f7546a;
        c r14 = (c) r13.get(r11);
        if (r14 == null) goto L5;
        Log.e("VmsdkModuleManager", "Duplicated VmsdkModule For Name: " + r11 + ", " + r14 + " will be override");
    L5:
        r13.put(r11, r12);
        Log.v("VmsdkModuleManager", "registered module with name: " + r11 + " class" + r5);
    }

    @CalledByNative
    public void destroy() {
        this.f7548c = null;
        ConcurrentHashMap r5 = this.f7547b;
        if (r5 == null) goto L5;
        r5.clear();
        this.f7547b = null;
    L5:
        this.f7546a.clear();
    }
}
