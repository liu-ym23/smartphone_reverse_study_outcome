package org.jnius;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted, all sources:
  classes7.dex
  memorydata_plugin.apk:assets/pap/packages/pyjnius-1.7.0-cp313-cp313-linux_android.whl:jnius/src/org/jnius/NativeInvocationHandler.class
 */
/* JADX INFO: loaded from: classes7.dex */
public class NativeInvocationHandler implements InvocationHandler {
    private long ptr;

    public NativeInvocationHandler(long r1) {
        this.ptr = r1;
    }

    public long getPythonObjectPointer() {
        return this.ptr;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r1, Method r2, Object[] r3) {
        return invoke0(r1, r2, r3);
    }

    native Object invoke0(Object r1, Method r2, Object[] r3);
}
