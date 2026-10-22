package com.bytedance.mira.plugin.hook.flipped.compat;

import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class FlippedV2Impl implements IFlipped {
    static {
        System.loadLibrary("flipped");
    }

    public FlippedV2Impl() {
    }

    private native Method getDeclaredMethod(Object r5, String r10, Class<?>[] r11);

    @Override // com.bytedance.mira.plugin.hook.flipped.compat.IFlipped
    public final void a() {
        Class<?> r5 = Class.forName("dalvik.system.VMRuntime");     // Catch: Exception -> L5
        Method r10 = getDeclaredMethod(r5, "getRuntime", new Class[0]);     // Catch: Exception -> L5
        r10.setAccessible(true);     // Catch: Exception -> L5
        Object r11 = r10.invoke(null, null);     // Catch: Exception -> L5
        Method r12 = getDeclaredMethod(r5, "setHiddenApiExemptions", new Class[]{String[].class});     // Catch: Exception -> L5
        r12.setAccessible(true);     // Catch: Exception -> L5
        r12.invoke(r11, new Object[]{new String[]{"L"}});     // Catch: Exception -> L5
        Log.e("FlippedV2Impl", "V2 invokeHiddenApiRestrictions success.");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("FlippedV2Impl", "V2 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
    }
}
