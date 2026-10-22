package com.lynx.tasm.behavior.utils;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.utils.CallStackUtil;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxUIMethodsExecutor {
    public static final Map<Class<?>, a<?>> a = null;

    public static class FallbackLynxUIMethodInvoker<T extends LynxBaseUI> implements a<T> {
        public final Map<String, Method> a;

        public FallbackLynxUIMethodInvoker(Class<? extends LynxBaseUI> r1) {
            this.a = b.a(r1);
        }

        @Override // com.lynx.tasm.behavior.utils.a
        public final void invoke(T r7, String r8, ReadableMap r9, Callback r10) {
            Method r11 = this.a.get(r8);
            if (r11 != null) goto L28;
            r10.invoke(new Object[]{3});
            return;
        L28:
            Class<?>[] r3 = r11.getParameterTypes();     // Catch: Exception -> L24
            if (r3.length != 0) goto L10;
            r11.invoke(r7, new Object[0]);     // Catch: Exception -> L24
        L27:
            return;
        L10:
            if (r3.length != 1) goto L18;
            Class<?> r4 = r3[0];     // Catch: Exception -> L24
            if (r4 != ReadableMap.class) goto L15;
            r11.invoke(r7, new Object[]{r9});     // Catch: Exception -> L24
            goto L27
        L15:
            if (r4 != Callback.class) goto L27;
            r11.invoke(r7, new Object[]{r10});     // Catch: Exception -> L24
            goto L27
        L18:
            if (r3[0] == ReadableMap.class) goto L20;
        L22:
            r10.invoke(new Object[]{4});     // Catch: Exception -> L24
            LLog.d("FallbackMethodInvoker", "invoke target method: params invalid");     // Catch: Exception -> L24
            goto L27
        L20:
            if (r3[1] != Callback.class) goto L22;
            r11.invoke(r7, new Object[]{r9, r10});     // Catch: Exception -> L24
        L24:
            e = move-exception;
            r10.invoke(new Object[]{1});
            LLog.d("FallbackMethodInvoker", "invoke target method exception," + e.getMessage());
        }
    }

    public LynxUIMethodsExecutor() {
    }

    static {
        a = new HashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static void b(LynxBaseUI r3, String r4, ReadableMap r5, Callback r6) {
        if ((r3 instanceof UIShadowProxy) == false) goto L5;
        r3 = ((UIShadowProxy) r3).a;
    L5:
        if (r3 != null) goto L8;
        r6.invoke(new Object[]{2, "node does not have a LynxUI"});
        return;
    L8:
        Class<?> r0 = r3.getClass();
        a<?> r1 = a.get(r0);
        if (r1 != null) goto L35;
        String r2 = r0.getName().concat("$$MethodInvoker");
        Object r7 = a(r2).newInstance();     // Catch: IllegalAccessException -> L13 InstantiationException -> L15 ClassNotFoundException -> L18
    L19:
        r1 = (a) r7;
        if (r1 != null) goto L29;
        String r8 = "MethodInvoker not generated for class: " + r0.getName() + ". You should add module lynxProcessor";
        LLog.e("MethodsExecutor", r8);
        if (LynxEnv.inst().isCheckPropsSetter() == true) goto L24;
    L28:
        r1 = new FallbackLynxUIMethodInvoker(r0);
        goto L29
    L24:
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L28;
        throw new IllegalStateException(r8);
    L29:
        a.put(r0, r1);
        goto L35
    L18:
        r7 = null;
    L13:
        e = e;
    L17:
        throw new RuntimeException("Unable to instantiate methods invoker for " + r2, e);
    L15:
        e = e;
    L35:
        r1.invoke(r3, r4, r5, r6);     // Catch: Exception -> L32
        return;
    L32:
        e = move-exception;
        LynxError r9 = new LynxError(990100, "Invoke method '" + r4 + "' error: " + e.getMessage(), NameKeys.UnloadStrategy_No_Strategy, "error");
        r9.setCallStack(CallStackUtil.getStackTraceStringWithLineTrimmed(e));
        r9.setUserDefineInfo(r3.getPlatformCustomInfo());
        r3.getLynxContext().handleLynxError(r9);
    }
}
