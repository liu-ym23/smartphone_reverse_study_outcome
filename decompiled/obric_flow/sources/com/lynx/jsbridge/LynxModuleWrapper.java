package com.lynx.jsbridge;

import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.jsi.ILynxJSIObject;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.PiperData;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.CalledByNative;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class LynxModuleWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxModule f9895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f9896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f9897c;
    public final String d;
    public WeakReference e;

    public LynxModuleWrapper(String r5, LynxModule r10) {
        this.d = r5;
        this.f9895a = r10;
        this.f9896b = new ArrayList();
        this.f9897c = new ArrayList();
    }

    public final void a() {
        HashSet r5 = new HashSet();
        LynxModule r10 = this.f9895a;
        Field[] r11 = r10.getClass().getDeclaredFields();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L17;
        Field r14 = r11[r13];
        if (((d) r14.getAnnotation(d.class)) == null) goto L16;
        String r15 = r14.getName();
        if (r5.contains(r15) == true) goto L15;
        r5.add(r15);
        JavaOnlyArray r16 = new JavaOnlyArray();
        r16.add(r14.get(r10));     // Catch: IllegalAccessException -> L11
    L13:
        this.f9897c.add(new AttributeDescriptor(r15, r16));
    L11:
        e = move-exception;
        LynxLog.b(4, "LynxModuleWrapper", e.toString());
        goto L13
    L15:
        throw new IllegalArgumentException("Java Module " + getName() + " attribute name already registered: " + r15);
    L16:
        r13 = r13 + 1;
        goto L3
    }

    public final void b() {
        HashSet r5 = new HashSet();
        Method[] r10 = this.f9895a.getClass().getDeclaredMethods();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L88;
        Method r13 = r10[r12];
        if (((n) r13.getAnnotation(n.class)) == null) goto L87;
        String r14 = r13.getName();
        if (r5.contains(r14) == true) goto L86;
        r5.add(r14);
        MethodDescriptor r15 = new MethodDescriptor();
        o r16 = new o(r13);
        r15.f9900c = r14;
        boolean r17 = r16.f9932b;
        if (r17 == true) goto L80;
        if (r17 == true) goto L80;
        r16.f9932b = true;
        Class[] r18 = r16.f9931a;
        StringBuilder r19 = new StringBuilder(r18.length + 2);
        Class<?> r110 = r13.getReturnType();
        char r111 = o.a(r110);
        if (r111 == 0) goto L16;
    L47:
        r19.append(r111);
        r19.append('.');
        int r112 = 0;
    L49:
        if (r112 >= r18.length) goto L79;
        Class r113 = r18[r112];
        if (r113 == Promise.class) goto L53;
    L57:
        char r114 = o.a(r113);
        if (r114 != 0) goto L76;
        if (r113 != Callback.class) goto L63;
        r114 = 'X';
        goto L76
    L63:
        if (r113 != Promise.class) goto L66;
        r114 = 'P';
        goto L76
    L66:
        if (o.d.contains(r113) == false) goto L69;
        r114 = 'M';
        goto L76
    L69:
        if (o.e.contains(r113) == false) goto L72;
        r114 = 'A';
        goto L76
    L72:
        if (r113 != pm.a.class) goto L74;
        r114 = 'Y';
        goto L76
    L74:
        if (r113 != byte[].class) goto L78;
        r114 = 'a';
        goto L76
    L78:
        throw new RuntimeException("Got unknown param class: ".concat(r113.getSimpleName()));
    L76:
        r19.append(r114);
        r112 = r112 + 1;
        goto L49
    L53:
        if (r112 == (r18.length - 1)) goto L57;
        throw new AssertionError("Promise must be used as last parameter only");
    L79:
        r16.f9933c = r19.toString();
        goto L80
    L16:
        if (r110 != Void.TYPE) goto L19;
        r111 = 'v';
        goto L47
    L19:
        if (r110 != WritableMap.class) goto L21;
    L46:
        r111 = 'M';
        goto L47
    L21:
        if (r110 == ReadableMap.class) goto L46;
        if (r110 == JavaOnlyMap.class) goto L46;
        if (r110 != WritableArray.class) goto L28;
    L45:
        r111 = 'A';
        goto L47
    L28:
        if (r110 == ReadableArray.class) goto L45;
        if (r110 == JavaOnlyArray.class) goto L45;
        if (r110 != byte[].class) goto L35;
        r111 = 'a';
        goto L47
    L35:
        if (r110 != PiperData.class) goto L38;
        r111 = 'J';
        goto L47
    L38:
        if (r110 != ILynxJSIObject.class) goto L41;
        r111 = 'O';
        goto L47
    L41:
        if (r110 != TemplateData.class) goto L44;
        r111 = 'E';
        goto L47
    L44:
        throw new RuntimeException("Got unknown return class: ".concat(r110.getSimpleName()));
    L80:
        String r20 = r16.f9933c;
        if (r20 == null) goto L84;
        r15.f9899b = r20;
        r15.f9898a = r13;
        this.f9896b.add(r15);
        goto L87
    L84:
        throw new AssertionError();
    L86:
        throw new IllegalArgumentException("Java Module " + getName() + " method name already registered: " + r14);
    L87:
        r12 = r12 + 1;
        goto L3
    }

    @CalledByNative
    public Collection<AttributeDescriptor> getAttributeDescriptor() {
        ArrayList r5 = this.f9897c;
        if (r5.isEmpty() == true) goto L9;
    L8:
        return r5;
    L9:
        a();     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        p r10 = new p(this, e, 1);
        com.lynx.tasm.utils.j.a().post(r10);
        LynxLog.b(4, "LynxModuleWrapper", e.toString());
        goto L8
    }

    @CalledByNative
    public Collection<MethodDescriptor> getMethodDescriptors() {
        ArrayList r5 = this.f9896b;
        if (r5.isEmpty() == true) goto L9;
    L8:
        return r5;
    L9:
        b();     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        p r10 = new p(this, e, 0);
        com.lynx.tasm.utils.j.a().post(r10);
        LynxLog.b(4, "LynxModuleWrapper", e.toString());
        goto L8
    }

    @CalledByNative
    public LynxModule getModule() {
        return this.f9895a;
    }

    @CalledByNative
    public String getName() {
        return this.d;
    }

    @CalledByNative
    public boolean hasAuthValidator() {
        return false;
    }

    @CalledByNative
    public boolean verify(String r5, String r10, JavaOnlyArray r11) {
        return true;
    }
}
