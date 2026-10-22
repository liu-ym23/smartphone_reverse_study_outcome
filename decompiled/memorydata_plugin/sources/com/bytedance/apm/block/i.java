package com.bytedance.apm.block;

import android.os.Build;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static void a() {
        Class r1 = ZeusTransformUtils.forName("android.view.WindowManagerGlobal", "com.obric.memorydata.plugin");     // Catch: Exception -> L13
        Object r2 = r1.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L13
        Field r3 = r1.getDeclaredField("mRoots");     // Catch: Exception -> L13
        r3.setAccessible(true);     // Catch: Exception -> L13
        ArrayList r4 = (ArrayList) ZeusTransformUtils.preCheckCast(r3.get(r2), ArrayList.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
        Field r5 = ZeusTransformUtils.forName("android.view.ViewRootImpl", "com.obric.memorydata.plugin").getDeclaredField("mView");     // Catch: Exception -> L13
        r5.setAccessible(true);     // Catch: Exception -> L13
        Field r6 = View.class.getDeclaredField("mRenderNode");     // Catch: Exception -> L13
        r6.setAccessible(true);     // Catch: Exception -> L13
        if (Build.VERSION.SDK_INT <= 28) goto L7;
        String r7 = "android.graphics.RenderNode";
    L8:
        Method r0 = com.bytedance.apm.block.a.f.a(ZeusTransformUtils.forName(r7, "com.obric.memorydata.plugin"), "output", new Class[0]);     // Catch: Exception -> L13
        int r8 = 0;
    L10:
        if (r8 >= r4.size()) goto L19;
        r0.invoke(r6.get(r5.get(r4.get(r8))), new Object[0]);     // Catch: Exception -> L13
        r8 = r8 + 1;
        goto L10
    L19:
        return;
    L7:
        r7 = "android.view.RenderNode";
    L13:
        e = move-exception;
        e.printStackTrace();
    }
}
