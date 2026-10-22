package com.bytedance.vmsdk.jsbridge;

import android.util.Log;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.CalledByNative;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class JSModuleWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSModule f7549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f7550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f7551c;
    public final String d;

    public JSModuleWrapper(String r5, JSModule r10) {
        this.d = r5;
        this.f7549a = r10;
        this.f7550b = new ArrayList();
        this.f7551c = new ArrayList();
    }

    public final void a() {
        HashSet r5 = new HashSet();
        JSModule r10 = this.f7549a;
        Field[] r11 = r10.getClass().getDeclaredFields();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L17;
        Field r14 = r11[r13];
        if (((a) r14.getAnnotation(a.class)) == null) goto L16;
        String r15 = r14.getName();
        if (r5.contains(r15) == true) goto L15;
        r5.add(r15);
        AttributeDescriptor r16 = new AttributeDescriptor();
        r16.f7544a = r15;
        JavaOnlyArray r17 = new JavaOnlyArray();
        r16.f7545b = r17;
        r17.add(r14.get(r10));     // Catch: IllegalAccessException -> L11
    L13:
        this.f7551c.add(r16);
    L11:
        e = move-exception;
        Log.e("VmsdkModuleWrapper", e.toString());
        goto L13
    L15:
        throw new IllegalArgumentException("Java Module " + getName() + " attribute name already registered: " + r15);
    L16:
        r13 = r13 + 1;
        goto L3
    }

    public final void b() {
        HashSet r5 = new HashSet();
        Method[] r10 = this.f7549a.getClass().getDeclaredMethods();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L67;
        Method r13 = r10[r12];
        if (((b) r13.getAnnotation(b.class)) == null) goto L66;
        String r14 = r13.getName();
        if (r5.contains(r14) == true) goto L65;
        r5.add(r14);
        MethodDescriptor r15 = new MethodDescriptor();
        r13.setAccessible(true);
        Class<?>[] r16 = r13.getParameterTypes();
        r15.f7554c = r14;
        StringBuilder r17 = new StringBuilder(r16.length + 2);
        Class<?> r18 = r13.getReturnType();
        char r19 = com.lynx.tasm.utils.a.a(r18);
        if (r19 == 0) goto L12;
    L22:
        r17.append(r19);
        r17.append('.');
        int r110 = 0;
    L24:
        if (r110 >= r16.length) goto L57;
        Class<?> r111 = r16[r110];
        if (r111 == Promise.class) goto L28;
    L35:
        char r112 = com.lynx.tasm.utils.a.a(r111);
        if (r112 != 0) goto L54;
        if (r111 != Callback.class) goto L41;
        r112 = 'X';
        goto L54
    L41:
        if (r111 != Promise.class) goto L44;
        r112 = 'P';
        goto L54
    L44:
        if (r111 != ReadableMap.class) goto L47;
        r112 = 'M';
        goto L54
    L47:
        if (r111 != ReadableArray.class) goto L50;
        r112 = 'A';
        goto L54
    L50:
        if (r111 != fk.a.class) goto L52;
        r112 = 'Y';
        goto L54
    L52:
        if (r111 != byte[].class) goto L56;
        r112 = 'a';
        goto L54
    L56:
        throw new RuntimeException("Got unknown param class: ".concat(r111.getSimpleName()));
    L54:
        r17.append(r112);
        r110 = r110 + 1;
        goto L24
    L28:
        if (r110 != (r16.length - 1)) goto L30;
        boolean r113 = true;
    L31:
        if (r113 == true) goto L35;
        throw new AssertionError("Promise must be used as last parameter only");
    L30:
        r113 = false;
        goto L31
    L57:
        String r20 = r17.toString();
        if (r20 == null) goto L61;
        r15.f7553b = r20;
        r15.f7552a = r13;
        this.f7550b.add(r15);
        goto L66
    L61:
        throw new AssertionError();
    L12:
        if (r18 != Void.TYPE) goto L15;
        r19 = 'v';
        goto L22
    L15:
        if (r18 != WritableMap.class) goto L18;
        r19 = 'M';
        goto L22
    L18:
        if (r18 != WritableArray.class) goto L20;
        r19 = 'A';
        goto L22
    L20:
        if (r18 != byte[].class) goto L63;
        r19 = 'a';
        goto L22
    L63:
        throw new RuntimeException("Got unknown return class: ".concat(r18.getSimpleName()));
    L65:
        throw new IllegalArgumentException("Java Module " + getName() + " method name already registered: " + r14);
    L66:
        r12 = r12 + 1;
        goto L3
    }

    @CalledByNative
    public Collection<AttributeDescriptor> getAttributeDescriptor() {
        ArrayList r5 = this.f7551c;
        if (r5.isEmpty() == true) goto L9;
    L8:
        return r5;
    L9:
        a();     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        Log.e("VmsdkModuleWrapper", e.toString());
        goto L8
    }

    @CalledByNative
    public Collection<MethodDescriptor> getMethodDescriptors() {
        ArrayList r5 = this.f7550b;
        if (r5.isEmpty() == true) goto L9;
    L8:
        return r5;
    L9:
        b();     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        Log.e("VmsdkModuleWrapper", e.toString());
        goto L8
    }

    @CalledByNative
    public JSModule getModule() {
        return this.f7549a;
    }

    @CalledByNative
    public String getName() {
        return this.d;
    }
}
