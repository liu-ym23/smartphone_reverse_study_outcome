package com.bytedance.ai.applet.render.core.lynx;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.jsbridge.WebAssemblyBridge;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.service.IServiceProvider;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J&\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\u0011\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0003J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/applet/render/core/lynx/LynxExtensionService;", "Lcom/lynx/tasm/service/ILynxExtensionService;", "<init>", "()V", "TAG", "", "LYNX_KRYPTON_MODULE", "onLynxEnvSetup", "", "onLynxViewSetup", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "group", "Lcom/lynx/tasm/LynxGroup;", "behaviorRegistry", "Lcom/lynx/tasm/behavior/BehaviorRegistry;", "onLynxViewDestroy", "setUpLynxKrypton", "destroyLynxKrypton", "applet-render-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxExtensionService implements i8a.b {
    public static final LynxExtensionService INSTANCE = null;
    private static final String LYNX_KRYPTON_MODULE = "LynxKryptonModule";
    private static final String TAG = "LynxExtensionService";

    static {
        INSTANCE = new LynxExtensionService();
    }

    private LynxExtensionService() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public final /* synthetic */ void onInitialize(Context r1) {
        IServiceProvider.-CC.$default$onInitialize(this, r1);
    }

    public void onLynxEnvSetup() {
        List r0 = LynxEnv.inst().getBehaviors();
        LynxThreadPool.b().execute(new com.lynx.tasm.b(r0));
        WebAssemblyBridge.a();
    }

    public Class getServiceClass() {
        return i8a.b.class;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_ai_applet_render_core_lynx_LynxExtensionService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r10) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r11 = access$000(r10);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L8
    L7:
        return r11;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r10);
    L12:
        throw th;
    L34:
        Class r12 = access$000(r10);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L17
    L16:
        return r12;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r10);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r10);
    }

    private final void destroyLynxKrypton(LynxContext r10) {
        if (r10 != null) goto L5;
        LLog.e(TAG, "LynxContext is null");
        return;
    L5:
        com.lynx.jsbridge.d r11 = r10.getExtensionModuleByKey(LYNX_KRYPTON_MODULE);
        if (r11 != null) goto L8;
        return;
    L8:
        r11.destroy();
    }

    public void onLynxViewDestroy(LynxContext r1) {
        destroyLynxKrypton(r1);
    }

    private final void setUpLynxKrypton(LynxContext r10, LynxGroup r11, com.lynx.tasm.behavior.c r12) {
        if (r10 != null) goto L11;
        LLog.e(TAG, "LynxContext is null");
        return;
    L11:
        Object r13 = INVOKESTATIC_com_bytedance_ai_applet_render_core_lynx_LynxExtensionService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.lynx.tasm.behavior.ui.krypton.LynxKryptonModule").getConstructor(new Class[]{LynxContext.class, LynxGroup.class, com.lynx.tasm.behavior.c.class}).newInstance(new Object[]{r10, r11, r12});     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.lynx.jsbridge.LynxExtensionModule");     // Catch: Exception -> L8
        r10.setExtensionModuleForKey((com.lynx.jsbridge.d) r13, LYNX_KRYPTON_MODULE);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        LLog.e(TAG, "Failed init LynxKryptonModule with exception: " + e);
    }

    public void onLynxViewSetup(LynxContext r1, LynxGroup r10, com.lynx.tasm.behavior.c r11) {
        setUpLynxKrypton(r1, r10, r11);
    }
}
