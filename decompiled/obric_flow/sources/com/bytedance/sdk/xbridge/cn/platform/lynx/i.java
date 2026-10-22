package com.bytedance.sdk.xbridge.cn.platform.lynx;

import android.text.TextUtils;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.registry.JavaScriptRegistry;
import com.bytedance.vmsdk.worker.JsWorker;
import com.bytedance.vmsdk.worker.VmSdkException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f7375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f7376c;
    public Object d;

    public /* synthetic */ i(com.bytedance.sdk.xbridge.cn.protocol.g r5, Class r10, Object r11, int r12) {
        this.f7374a = r12;
        this.f7376c = r5;
        this.f7375b = r10;
        this.d = r11;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r5, Method r10, Object[] r11) {
        switch(this.f7374a) {
            case 0: goto L26;
            case 1: goto L21;
            default: goto L4;
        };
    L4:
        if (r11 != null) goto L6;
        JavaOnlyArray r12 = new JavaOnlyArray();
    L7:
        Class<?>[] r13 = r10.getExceptionTypes();
        int r14 = r13.length;
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L14;
        if (VmSdkException.class == r13[r15]) goto L14;
        r15 = r15 + 1;
    L14:
        if (TextUtils.isEmpty((String) this.d) == false) goto L19;
        Class r16 = this.f7375b;
        String r17 = ((fk.d) r16.getAnnotation(fk.d.class)).name();
        if ("".equals(r17) == false) goto L18;
        r17 = r16.getSimpleName();
    L18:
        this.d = r17;
    L19:
        String r18 = (String) this.d;
        String r19 = r10.getName();
        char r20 = JavaScriptRegistry.returnTypeToChar(r10.getReturnType());
        return ((JsWorker) this.f7376c).invokeJavaScriptModule(r18, r19, r12, r20);
    L6:
        r12 = new JavaOnlyArray(Arrays.asList(r11));
        goto L7
    L21:
        boolean r21 = Intrinsics.areEqual(r10.getName(), "toJSON");
        JSONObject r22 = (JSONObject) this.d;
        com.bytedance.sdk.xbridge.cn.platform.web.g r23 = (com.bytedance.sdk.xbridge.cn.platform.web.g) this.f7376c;
        if (r21 == true) goto L33;
        dj.c r24 = (dj.c) r10.getAnnotation(dj.c.class);
        return com.bytedance.sdk.xbridge.cn.platform.web.g.d(r23, r22.opt(r24.keyPath()), r24);
    L33:
        return r23.h(this.f7375b, r22);
    L26:
        boolean r25 = Intrinsics.areEqual(r10.getName(), "toJSON");
        HashMap r26 = (HashMap) this.d;
        ym.g r27 = (ym.g) this.f7376c;
        if (r25 == false) goto L29;
        r27.getClass();
        return new JSONObject(ym.g.f(this.f7375b, r26));
    L29:
        dj.c r28 = (dj.c) r10.getAnnotation(dj.c.class);
        return r27.d(r26.get(r28.keyPath()), r28);
    }

    public i(JsWorker r5, Class r10) {
        this.f7374a = 2;
        this.f7376c = r5;
        this.f7375b = r10;
    }
}
