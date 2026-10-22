package com.bytedance.ai.lynx;

import android.util.Log;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2187c;

    public /* synthetic */ j(int r5) {
        this.f2187c = r5;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final String b() {
        switch(this.f2187c) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        return "xbridge2";
    L6:
        return "xbridge";
    L8:
        return "";
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final IDLXBridgeMethod f(String r5) {
        switch(this.f2187c) {
            case 0: goto L28;
            case 1: goto L16;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "methodName");
        Class r10 = e(r5);     // Catch: Throwable -> L14
        if (r10 == null) goto L15;
        Method r11 = r10.getDeclaredMethod("create", null);     // Catch: Throwable -> L14
        r11.setAccessible(true);     // Catch: Throwable -> L14
        Object r12 = r11.invoke(null, null);     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.ies.xbridge.IDLXBridgeMethod");     // Catch: Throwable -> L14
        if (r12 != null) goto L13;
        new LinkedHashMap();     // Catch: Throwable -> L14
        throw null;     // Catch: Throwable -> L14
    L13:
        throw new ClassCastException();     // Catch: Throwable -> L14
    L15:
        return null;
    L14:
        Log.e("XBridge2MethodFinder", "### Load method by reflect failed, method name: " + r5);
        goto L15
    L16:
        Intrinsics.checkNotNullParameter(r5, "methodName");
        Class r13 = e(r5);     // Catch: Throwable -> L26
        if (r13 == null) goto L27;
        Method r14 = r13.getDeclaredMethod("create", null);     // Catch: Throwable -> L26
        r14.setAccessible(true);     // Catch: Throwable -> L26
        Object r15 = r14.invoke(null, null);     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.bytedance.ies.xbridge.XBridgeMethod");     // Catch: Throwable -> L26
        if (r15 != null) goto L25;
        new LinkedHashMap();     // Catch: Throwable -> L26
        throw null;     // Catch: Throwable -> L26
    L25:
        throw new ClassCastException();     // Catch: Throwable -> L26
    L27:
        return null;
    L26:
        Log.e("OXBridgeMethodFinder", "### Load method by reflect failed, method name: " + r5);
        goto L27
    L28:
        Intrinsics.checkNotNullParameter(r5, "methodName");
        Iterator r16 = com.ivy.ivykit.plugin.impl.jsb.b.f9517c.f9518a.iterator();
    L30:
        if (r16.hasNext() == false) goto L34;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((IDLXBridgeMethod) r17).getName(), r5) == false) goto L30;
    L36:
        return (IDLXBridgeMethod) r17;
    L34:
        r17 = null;
        goto L36
    }

    public j(rb.b r5) {
        this.f2187c = 2;
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
    }
}
