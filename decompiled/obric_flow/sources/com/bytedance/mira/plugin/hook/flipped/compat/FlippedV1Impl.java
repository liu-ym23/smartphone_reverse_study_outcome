package com.bytedance.mira.plugin.hook.flipped.compat;

import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class FlippedV1Impl implements IFlipped {
    public FlippedV1Impl() {
    }

    @Override // com.bytedance.mira.plugin.hook.flipped.compat.IFlipped
    public final void a() {
        Method r5 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});     // Catch: Exception -> L5
        Class<?> r10 = Class.forName("dalvik.system.VMRuntime");     // Catch: Exception -> L5
        Method r11 = (Method) r5.invoke(r10, new Object[]{"getRuntime", new Class[0]});     // Catch: Exception -> L5
        r11.setAccessible(true);     // Catch: Exception -> L5
        Object r12 = r11.invoke(null, null);     // Catch: Exception -> L5
        Method r13 = (Method) r5.invoke(r10, new Object[]{"setHiddenApiExemptions", new Class[]{String[].class}});     // Catch: Exception -> L5
        r13.setAccessible(true);     // Catch: Exception -> L5
        r13.invoke(r12, new Object[]{new String[]{"L"}});     // Catch: Exception -> L5
        Log.e("FlippedV1Impl", "V1 invokeHiddenApiRestrictions success.");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("FlippedV1Impl", "V1 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
    }
}
