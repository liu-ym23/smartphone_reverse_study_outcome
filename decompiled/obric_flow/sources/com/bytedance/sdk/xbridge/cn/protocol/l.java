package com.bytedance.sdk.xbridge.cn.protocol;

import android.util.Log;
import com.bytedance.sdk.xbridge.annotations.NamespaceValidator;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.lynx.tasm.behavior.ui.utils.p;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f7463c;

    public l() {
        this.f7463c = LazyKt.lazy(XBridge3MethodFinder$creatorClassCacheWithBiz$2.f7440a);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final String b() {
        return "xbridge3";
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final boolean c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "bizId");
        if (Intrinsics.areEqual("webcast", r5) == false) goto L5;
        return true;
    L5:
        if (Intrinsics.areEqual("host", r5) == false) goto L8;
        return true;
    L8:
        return NamespaceValidator.validate(r5);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final IDLXBridgeMethod d(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "namespace");
        Intrinsics.checkNotNullParameter(r10, "methodName");
        if (Intrinsics.areEqual("webcast", r5) == true) goto L10;
        if (Intrinsics.areEqual("host", r5) == true) goto L10;
        return h(r5, r10);
    L10:
        return h("", r10);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final IDLXBridgeMethod f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return h("", r5);
    }

    public final Class g(String r10, String r11) {
        Lazy r5 = this.f7463c;
        if (((ConcurrentHashMap) r5.getValue()).get(r10) != null) goto L5;
        ConcurrentHashMap r12 = new ConcurrentHashMap(100);
        ((ConcurrentHashMap) r5.getValue()).put(r10, r12);
    L6:
        Class r13 = (Class) r12.get(r11);
        if (r13 != null) goto L19;
        if (r10 != null) goto L10;
    L13:
        String r14 = p.i(r11, "xbridge3");
    L22:
        Class<?> r15 = Class.forName(r14);     // Catch: Throwable -> L16
        r12.put(r11, r15);     // Catch: Throwable -> L16
        return r15;
    L16:
        r12.put(r11, Object.class);
        Log.e("MethodFinder", "xbridge3 creator class load failed: " + r11);
        return null;
    L10:
        if (r10.length() == 0) goto L13;
        Intrinsics.checkNotNullParameter(r10, "namespace");
        Intrinsics.checkNotNullParameter(r11, "methodName");
        r14 = com.lynx.tasm.utils.b.j("com.bytedance.xbridge.cn.gen.xbridge3_", r10, "_Creator_", StringsKt.F(r11, ".", "_"));
        goto L22
    L19:
        if (Intrinsics.areEqual(r13, Object.class) == false) goto L21;
        return null;
    L21:
        return r13;
    L5:
        Object r16 = ((ConcurrentHashMap) r5.getValue()).get(r10);
        Intrinsics.checkNotNull(r16);
        r12 = (ConcurrentHashMap) r16;
        goto L6
    }

    public final IDLXBridgeMethod h(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "namespace");
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Class r11 = g(r5, r10);     // Catch: Throwable -> L8
        if (r11 != null) goto L6;
        return null;
    L6:
        Method r12 = r11.getDeclaredMethod("create", null);     // Catch: Throwable -> L8
        r12.setAccessible(true);     // Catch: Throwable -> L8
        return (IDLXBridgeMethod) r12.invoke(null, null);
    L8:
        Log.e("XBridge3MethodFinder", "### Load method by reflect failed, method name: " + r10);
        return null;
    }
}
