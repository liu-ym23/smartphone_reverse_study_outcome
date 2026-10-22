package com.lynx.tasm.behavior.utils;

import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.utils.CallStackUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f10791a = null;

    static {
        f10791a = new HashMap();
    }

    public static void a(LynxBaseUI r10, String r11, ReadableMap r12, Callback r13) {
        if ((r10 instanceof UIShadowProxy) == false) goto L5;
        r10 = ((UIShadowProxy) r10).f10388a;
    L5:
        if (r10 != null) goto L8;
        r13.invoke(new Object[]{2, "node does not have a LynxUI"});
        return;
    L8:
        final Class<?> r5 = r10.getClass();
        HashMap r14 = f10791a;
        a r15 = (a) r14.get(r5);
        if (r15 != null) goto L33;
        String r16 = r5.getName().concat("$$MethodInvoker");
        Object r17 = Class.forName(r16).newInstance();     // Catch: Throwable -> L13 ClassNotFoundException -> L16
    L17:
        r15 = (a) r17;
        if (r15 != null) goto L27;
        String r18 = "MethodInvoker not generated for class: " + r5.getName() + ". You should add module lynxProcessor";
        LynxLog.b(4, "MethodsExecutor", r18);
        if (LynxEnv.inst().isCheckPropsSetter() == true) goto L22;
    L26:
        r15 = new LynxUIMethodsExecutor$FallbackLynxUIMethodInvoker(r5);
        goto L27
    L22:
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L26;
        throw new IllegalStateException(r18);
    L27:
        r14.put(r5, r15);
        goto L33
    L16:
        r17 = null;
    L13:
        e = move-exception;
        throw new RuntimeException(td.d.b("Unable to instantiate methods invoker for ", r16), e);
    L33:
        r15.invoke(r10, r11, r12, r13);     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        LynxError r19 = new LynxError(990100, androidx.room.jarjarred.org.antlr.runtime.a.o(e, com.lynx.tasm.utils.e.b("Invoke method '", r11, "' error: ")), "", "error");
        String r20 = CallStackUtil.getStackTraceStringWithLineTrimmed(e);
        r19.g = null;
        r19.f9999n = r20;
        JSONObject r21 = r10.getPlatformCustomInfo();
        r19.g = null;
        r19.e = r21;
        r10.getLynxContext().b(r19);
    }
}
