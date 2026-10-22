package com.lynx.jsbridge;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.jsi.ILynxJSIObject;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.PiperData;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxModuleWrapper {
    public static final ConcurrentHashMap<Class<? extends LynxModule>, ArrayList<MethodDescriptor>> g = null;
    public final LynxModule a;
    public final ArrayList<MethodDescriptor> b;
    public final ArrayList<AttributeDescriptor> c;
    public final String d;
    public LynxModule.a e;
    public volatile com.lynx.jsbridge.b f;

    public class a implements Runnable {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ RuntimeException b;
        public final /* synthetic */ LynxModuleWrapper c;

        public final void a() {
            WeakReference r0 = this.a;
            if (r0 == null) goto L8;
            Context r1 = (Context) r0.get();
            if ((r1 instanceof LynxContext) == false) goto L9;
            LynxError r2 = new LynxError(99900, "NativeModules: GetMethodDescriptors error!moduleName: " + this.c.d + " exception: " + this.b.toString());
            r2.setLogBoxOnly(true);
            ((LynxContext) r1).handleLynxError(r2);
            return;
        L9:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LynxModuleWrapper r1, WeakReference r2, RuntimeException r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ RuntimeException b;
        public final /* synthetic */ LynxModuleWrapper c;

        public final void a() {
            WeakReference r0 = this.a;
            if (r0 == null) goto L8;
            Context r1 = (Context) r0.get();
            if ((r1 instanceof LynxContext) == false) goto L9;
            LynxError r2 = new LynxError(99900, "NativeModules: getAttributeDescriptors error!moduleName: " + this.c.d + " exception: " + this.b.toString());
            r2.setLogBoxOnly(true);
            ((LynxContext) r1).handleLynxError(r2);
            return;
        L9:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(LynxModuleWrapper r1, WeakReference r2, RuntimeException r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        g = new ConcurrentHashMap();
    }

    public final void a() {
        HashSet r0 = new HashSet();
        Field[] r1 = this.a.getClass().getDeclaredFields();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L17;
        Field r4 = r1[r3];
        if (((LynxAttribute) r4.getAnnotation(LynxAttribute.class)) == null) goto L16;
        String r5 = r4.getName();
        if (r0.contains(r5) == true) goto L15;
        r0.add(r5);
        JavaOnlyArray r6 = new JavaOnlyArray();
        r6.add(r4.get(this.a));     // Catch: IllegalAccessException -> L11
    L13:
        this.c.add(new AttributeDescriptor(r5, r6));
    L11:
        e = move-exception;
        LLog.e("NativeModule:LynxModuleWrapper", e.toString());
        goto L13
    L15:
        throw new IllegalArgumentException("Java Module " + getName() + " attribute name already registered: " + r5);
    L16:
        r3 = r3 + 1;
        goto L3
    }

    public final void b() {
        Class<?> r1 = this.a.getClass();
        ConcurrentHashMap<Class<? extends LynxModule>, ArrayList<MethodDescriptor>> r2 = g;
        if (r2.containsKey(r1) == false) goto L6;
        this.b.addAll(r2.get(r1));
        return;
    L6:
        Method[] r3 = r1.getDeclaredMethods();
        int r4 = r3.length;
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L95;
        Method r6 = r3[r5];
        if (((LynxMethod) r6.getAnnotation(LynxMethod.class)) == null) goto L94;
        String r7 = r6.getName();
        MethodDescriptor r8 = new MethodDescriptor();
        e r9 = new e(r6);
        r8.c = r7;
        boolean r10 = r9.b;
        if (r10 == true) goto L89;
        if (r10 == true) goto L89;
        r9.b = true;
        Class[] r11 = r9.a;
        StringBuilder r12 = new StringBuilder(r11.length + 2);
        Class<?> r13 = r6.getReturnType();
        char r14 = e.a(r13);
        if (r14 == 0) goto L18;
    L49:
        r12.append(r14);
        r12.append('.');
        int r15 = 0;
    L51:
        if (r15 >= r11.length) goto L88;
        Class r16 = r11[r15];
        if (r16 == Promise.class) goto L55;
    L62:
        char r17 = e.a(r16);
        if (r17 != 0) goto L85;
        if (r16 != Callback.class) goto L69;
        r17 = 'X';
        goto L85
    L69:
        if (r16 != Promise.class) goto L72;
        r17 = 'P';
        goto L85
    L72:
        if (((HashSet) e.d).contains(r16) == false) goto L75;
        r17 = 'M';
        goto L85
    L75:
        if (((HashSet) e.e).contains(r16) == false) goto L78;
        r17 = 'A';
        goto L85
    L78:
        if (r16 != f6a.a.class) goto L80;
        r17 = 'Y';
        goto L85
    L80:
        if (r16 != byte[].class) goto L83;
        r17 = 'a';
        goto L85
    L83:
        if (r16 != LynxContext.class) goto L87;
        r17 = 'K';
        goto L85
    L87:
        throw new RuntimeException("Got unknown param class: ".concat(r16.getSimpleName()));
    L85:
        r12.append(r17);
        r15 = r15 + 1;
        goto L51
    L55:
        if (r15 != (r11.length - 1)) goto L57;
        boolean r18 = true;
    L58:
        if (r18 == true) goto L62;
        throw new AssertionError("Promise must be used as last parameter only");
    L57:
        r18 = false;
        goto L58
    L88:
        r9.c = r12.toString();
        goto L89
    L18:
        if (r13 != Void.TYPE) goto L21;
        r14 = 'v';
        goto L49
    L21:
        if (r13 != WritableMap.class) goto L23;
    L48:
        r14 = 'M';
        goto L49
    L23:
        if (r13 == ReadableMap.class) goto L48;
        if (r13 == JavaOnlyMap.class) goto L48;
        if (r13 != WritableArray.class) goto L30;
    L47:
        r14 = 'A';
        goto L49
    L30:
        if (r13 == ReadableArray.class) goto L47;
        if (r13 == JavaOnlyArray.class) goto L47;
        if (r13 != byte[].class) goto L37;
        r14 = 'a';
        goto L49
    L37:
        if (r13 != PiperData.class) goto L40;
        r14 = 'J';
        goto L49
    L40:
        if (r13 != ILynxJSIObject.class) goto L43;
        r14 = 'O';
        goto L49
    L43:
        if (r13 != TemplateData.class) goto L46;
        r14 = 'E';
        goto L49
    L46:
        throw new RuntimeException("Got unknown return class: ".concat(r13.getSimpleName()));
    L89:
        String r19 = r9.c;
        if (r19 == null) goto L93;
        r8.b = r19;
        r8.a = r6;
        this.b.add(r8);
        goto L94
    L93:
        throw new AssertionError();
    L94:
        r5 = r5 + 1;
        goto L7
    L95:
        g.putIfAbsent((Class<? extends LynxModule>) r1, new ArrayList(this.b));
    }

    public Collection<AttributeDescriptor> getAttributeDescriptor() {
        WeakReference r0 = this.f.a();
        if (this.c.isEmpty() == false) goto L9;
        a();     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        UIThreadUtils.runOnUiThread(new b(this, r0, e));
        LLog.e("NativeModule:LynxModuleWrapper", e.toString());
    L9:
        return this.c;
    }

    public Collection<MethodDescriptor> getMethodDescriptors() {
        WeakReference r0 = this.f.a();
        if (this.b.isEmpty() == false) goto L9;
        b();     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        UIThreadUtils.runOnUiThread(new a(this, r0, e));
        LLog.e("NativeModule:LynxModuleWrapper", e.toString());
    L9:
        return this.b;
    }

    public boolean hasAuthValidator() {
        if (this.e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public LynxModule getModule() {
        return this.a;
    }

    public String getName() {
        return this.d;
    }

    public LynxContext getLynxContext(String r4) {
        WeakReference r0 = this.f.a();
        LLog.d("NativeModule:LynxModuleWrapper", " GetLynxContext instanceId:" + r4 + ", contextRef: " + r0 + ", module: " + this.a);
        if (r0 == null) goto L12;
        Context r5 = (Context) r0.get();
        if ((r5 instanceof LynxContext) == true) goto L7;
        if (r5 == null) goto L13;
        LLog.w("NativeModule:LynxModuleWrapper", "GetLynxContext , Context found but is not a LynxContext:".concat(r5.getClass().getName()));
        return null;
    L13:
        return null;
    L7:
        return (LynxContext) r5;
    L12:
        return null;
    }

    public LynxModuleWrapper(String r1, LynxModule r2) {
        this.d = r1;
        this.a = r2;
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public boolean verify(String r2, String r3, JavaOnlyArray r4) {
        LynxModule.a r0 = this.e;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.a(r2, r3, r4);
    }
}
