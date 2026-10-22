package com.bytedance.vmsdk.registry;

import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.worker.JsWorker;
import com.bytedance.vmsdk.worker.VmSdkException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsWorker f7560a;

    public c(JsWorker r5) {
        this.f7560a = r5;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r10, Method r11, Object[] r12) {
        if (r12 != null) goto L4;
        JavaOnlyArray r13 = new JavaOnlyArray();
    L5:
        Class<?>[] r14 = r11.getExceptionTypes();
        int r5 = r14.length;
        boolean r15 = false;
        int r16 = 0;
    L6:
        if (r16 >= r5) goto L12;
        if (VmSdkException.class == r14[r16]) goto L9;
        r16 = r16 + 1;
        goto L6
    L9:
        r15 = true;
    L12:
        return this.f7560a.invokeJavaScriptFunction(r11.getName(), r13, JavaScriptRegistry.returnTypeToChar(r11.getReturnType()), r15);
    L4:
        r13 = new JavaOnlyArray(Arrays.asList(r12));
        goto L5
    }
}
