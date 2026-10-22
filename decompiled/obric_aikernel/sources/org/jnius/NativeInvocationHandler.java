package org.jnius;

import androidx.annotation.Keep;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted, all sources:
  classes3.dex
  com.obric.aikernel.apk:assets/pap/packages/pyjnius-1.7.0-cp313-cp313-linux_android.whl:jnius/src/org/jnius/NativeInvocationHandler.class
 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class NativeInvocationHandler implements InvocationHandler {
    static boolean DEBUG = false;
    private long ptr;

    static {
    }

    public NativeInvocationHandler(long r10) {
        this.ptr = r10;
    }

    public long getPythonObjectPointer() {
        return this.ptr;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r10, Method r11, Object[] r12) {
        if (DEBUG == false) goto L5;
        System.out.print("+ java:invoke(<proxy>, " + r11 + ", " + r12);
        System.out.println(")");
        System.out.flush();
    L5:
        Object r13 = invoke0(r10, r11, r12);
        if (DEBUG == false) goto L8;
        System.out.print("+ java:invoke returned: ");
        System.out.println(r13);
    L8:
        return r13;
    }

    native Object invoke0(Object r10, Method r11, Object[] r12);
}
