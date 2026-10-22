package com.bytedance.common.utility.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class Reflect$1 implements InvocationHandler {
    final /* synthetic */ Reflect this$0;
    final /* synthetic */ boolean val$isMap;

    public Reflect$1(Reflect r1, boolean r2) {
        this.this$0 = r1;
        this.val$isMap = r2;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r6, Method r7, Object[] r8) throws Throwable {
        String r9 = r7.getName();
        return Reflect.on(Reflect.access$100(this.this$0)).call(r9, Reflect.access$000(r8), r8).get();
    L5:
        e = move-exception;
        if (this.val$isMap == false) goto L29;
        Map r0 = (Map) Reflect.access$100(this.this$0);
        if (r8 != null) goto L11;
        int r2 = 0;
    L13:
        if (r2 == 0) goto L15;
    L18:
        if (r2 != 0) goto L24;
        if (r9.startsWith("is") == false) goto L24;
        return r0.get(Reflect.access$200(r9.substring(2)));
    L24:
        if (r2 != 1) goto L29;
        if (r9.startsWith("set") == false) goto L29;
        r0.put(Reflect.access$200(r9.substring(3)), r8[0]);
        return null;
    L15:
        if (r9.startsWith("get") == false) goto L18;
        return r0.get(Reflect.access$200(r9.substring(3)));
    L11:
        r2 = r8.length;
    L29:
        throw e;
    }
}
