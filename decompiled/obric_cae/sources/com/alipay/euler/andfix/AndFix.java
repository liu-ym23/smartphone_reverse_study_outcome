package com.alipay.euler.andfix;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class AndFix {
    static {
        Runtime.getRuntime().loadLibrary("andfix");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Log.e("AndFix", "loadLibrary", th);
    }

    public AndFix() {
    }

    private static native void replaceMethod(Method r8, Method r10);

    private static native void setFieldFlag(Field r8);

    private static native boolean setup(boolean r8, int r10);
}
