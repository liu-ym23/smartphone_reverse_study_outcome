package com.bytedance.ai.applet.render.core.lynx;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.WebAssemblyBridge;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonModule;
import com.lynx.tasm.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0003J-\u0010\u0010\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u0019\u0010\u0011\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/applet/render/core/lynx/LynxExtensionService;", "Lko/b;", "<init>", "()V", "Lcom/lynx/tasm/behavior/LynxContext;", "context", "Lcom/lynx/tasm/u;", "group", "Lcom/lynx/tasm/behavior/c;", "behaviorRegistry", "", "setUpLynxKrypton", "(Lcom/lynx/tasm/behavior/LynxContext;Lcom/lynx/tasm/u;Lcom/lynx/tasm/behavior/c;)V", "destroyLynxKrypton", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "onLynxEnvSetup", "onLynxViewSetup", "onLynxViewDestroy", "", "TAG", "Ljava/lang/String;", "LYNX_KRYPTON_MODULE", "applet-render-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LynxExtensionService implements ko.b {
    public static final LynxExtensionService INSTANCE = null;
    private static final String LYNX_KRYPTON_MODULE = "LynxKryptonModule";
    private static final String TAG = "LynxExtensionService";

    static {
        INSTANCE = new LynxExtensionService();
    }

    private LynxExtensionService() {
    }

    @SuppressLint({"RestrictedApi"})
    private final void destroyLynxKrypton(LynxContext r5) {
        if (r5 != null) goto L5;
        LynxLog.b(4, TAG, "LynxContext is null");
        return;
    L5:
        LynxKryptonModule r10 = (LynxKryptonModule) r5.G.get(LYNX_KRYPTON_MODULE);
        if (r10 != null) goto L8;
        return;
    L8:
        r10.a();
    }

    @SuppressLint({"RestrictedApi"})
    private final void setUpLynxKrypton(LynxContext r10, u r11, com.lynx.tasm.behavior.c r12) {
        if (r10 != null) goto L14;
        LynxLog.b(4, TAG, "LynxContext is null");
        return;
    L14:
        Object r13 = LynxKryptonModule.class.getConstructor(new Class[]{LynxContext.class, u.class, com.lynx.tasm.behavior.c.class}).newInstance(new Object[]{r10, r11, r12});     // Catch: Exception -> L11
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.lynx.jsbridge.LynxExtensionModule");     // Catch: Exception -> L11
        LynxKryptonModule r14 = (LynxKryptonModule) r13;     // Catch: Exception -> L11
        if (r14 == null) goto L16;
        r10.G.put(LYNX_KRYPTON_MODULE, r14);     // Catch: Exception -> L11
        return;
    L16:
        return;
    L11:
        e = move-exception;
        LynxLog.b(4, TAG, "Failed init LynxKryptonModule with exception: " + e);
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    @NonNull
    public /* bridge */ /* synthetic */ Class getServiceClass() {
        return ko.b.class;
    }

    @Override // ko.b
    public void onLynxEnvSetup() {
        List<com.lynx.tasm.behavior.a> r5 = LynxEnv.inst().getBehaviors();
        mn.h.i().execute(new com.lynx.tasm.n(r5, 1));
        WebAssemblyBridge.a();
    }

    @Override // ko.b
    public void onLynxViewDestroy(LynxContext r5) {
        destroyLynxKrypton(r5);
    }

    @Override // ko.b
    public void onLynxViewSetup(LynxContext r5, u r10, com.lynx.tasm.behavior.c r11) {
        setUpLynxKrypton(r5, r10, r11);
    }
}
