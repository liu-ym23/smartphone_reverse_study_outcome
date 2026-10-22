package com.lynx.debugrouter;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.debugrouter.app.MessageHandleResult;
import com.lynx.debugrouter.app.MessageHandler;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import el9.a;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/lynx/debugrouter/CallStaticVoidMethodHandler;", "Lcom/lynx/debugrouter/app/MessageHandler;", "()V", "getName", NameKeys.UnloadStrategy_No_Strategy, "handle", "Lcom/lynx/debugrouter/app/MessageHandleResult;", LynxResourceModule.PARAMS_KEY, NameKeys.UnloadStrategy_No_Strategy, "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CallStaticVoidMethodHandler implements MessageHandler {
    public CallStaticVoidMethodHandler() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    @Override // com.lynx.debugrouter.app.MessageHandler
    public String getName() {
        return "App.CallStaticVoidMethod";
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_debugrouter_CallStaticVoidMethodHandler_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
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
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
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

    @Override // com.lynx.debugrouter.app.MessageHandler
    public MessageHandleResult handle(Map<String, String> r7) {
        if (r7 == null) goto L5;
        String r1 = r7.get("className");
    L6:
        if (r7 == null) goto L8;
        String r8 = r7.get("methodName");
    L10:
        if (r1 == null) goto L20;
        if (r8 == null) goto L20;
        Method r9 = INVOKESTATIC_com_lynx_debugrouter_CallStaticVoidMethodHandler_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r1).getDeclaredMethod(r8, new Class[0]);     // Catch: Exception -> L16
        r9.setAccessible(true);     // Catch: Exception -> L16
        r9.invoke(null, new Object[0]);     // Catch: Exception -> L16
        return new MessageHandleResult(0, "invoke successfully", null);
    L16:
        e = move-exception;
        return new MessageHandleResult(-1, "exception: " + e.getMessage(), null);
    L20:
        return new MessageHandleResult(-1, "invalid params: className: " + r1 + ", methodName: " + r8, null);
    L8:
        r8 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
