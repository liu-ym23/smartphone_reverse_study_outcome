package com.bytedance.apm.block;

import android.os.Build;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static void a() {
        Class<?> r10 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Exception -> L12
        Object r11 = r10.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L12
        Field r12 = r10.getDeclaredField("mRoots");     // Catch: Exception -> L12
        r12.setAccessible(true);     // Catch: Exception -> L12
        ArrayList r13 = (ArrayList) r12.get(r11);     // Catch: Exception -> L12
        Field r14 = Class.forName("android.view.ViewRootImpl").getDeclaredField("mView");     // Catch: Exception -> L12
        r14.setAccessible(true);     // Catch: Exception -> L12
        Field r15 = View.class.getDeclaredField("mRenderNode");     // Catch: Exception -> L12
        r15.setAccessible(true);     // Catch: Exception -> L12
        if (Build.VERSION.SDK_INT <= 28) goto L6;
        String r16 = "android.graphics.RenderNode";
    L7:
        Method r17 = t.e.K(Class.forName(r16), "output", new Class[0]);     // Catch: Exception -> L12
        int r18 = 0;
    L9:
        if (r18 >= r13.size()) goto L18;
        r17.invoke(r15.get(r14.get(r13.get(r18))), new Object[0]);     // Catch: Exception -> L12
        r18 = r18 + 1;
        goto L9
    L18:
        return;
    L6:
        r16 = "android.view.RenderNode";
    L12:
        e = move-exception;
        e.printStackTrace();
    }
}
