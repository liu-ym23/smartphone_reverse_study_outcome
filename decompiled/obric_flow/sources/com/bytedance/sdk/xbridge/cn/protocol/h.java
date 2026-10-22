package com.bytedance.sdk.xbridge.cn.protocol;

import android.util.Log;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.lynx.tasm.behavior.ui.utils.p;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f7460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f7461b;

    public h() {
        this.f7460a = LazyKt.lazy(MethodFinder$creatorClassCache$2.f7438a);
        this.f7461b = LazyKt.lazy(MethodFinder$statefulMethodCache$2.f7439a);
    }

    public final IDLXBridgeMethod a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "bizId");
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Lazy r11 = this.f7461b;
        IDLXBridgeMethod r12 = ((j) r11.getValue()).a(r5, r10);
        if (r12 == null) goto L6;
        return r12;
    L6:
        if (c(r5) == true) goto L8;
        return null;
    L8:
        IDLXBridgeMethod r13 = d(r5, r10);
        if (r13 != null) goto L11;
        return null;
    L11:
        if ((r13 instanceof i) == false) goto L14;
        ((j) r11.getValue()).b(r5, r13);
        return r13;
    L14:
        k.f7462c.b(r5, r13);
        return r13;
    }

    public abstract String b();

    public boolean c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "bizId");
        return true;
    }

    public IDLXBridgeMethod d(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "namespace");
        Intrinsics.checkNotNullParameter(r10, "methodName");
        return f(r10);
    }

    public final Class e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Lazy r5 = this.f7460a;
        Class r11 = (Class) ((ConcurrentHashMap) r5.getValue()).get(r10);
        if (r11 != null) goto L10;
        Class<?> r12 = Class.forName(p.i(r10, b()));     // Catch: Throwable -> L7
        ((ConcurrentHashMap) r5.getValue()).put(r10, r12);     // Catch: Throwable -> L7
        return r12;
    L7:
        ((ConcurrentHashMap) r5.getValue()).put(r10, Object.class);
        Log.e("MethodFinder", b() + " creator class load failed: " + r10);
        return null;
    L10:
        if (Intrinsics.areEqual(r11, Object.class) == false) goto L12;
        return null;
    L12:
        return r11;
    }

    public abstract IDLXBridgeMethod f(String r5);
}
