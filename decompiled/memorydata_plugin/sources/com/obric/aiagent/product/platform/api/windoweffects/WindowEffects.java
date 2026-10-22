package com.obric.aiagent.product.platform.api.windoweffects;

import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.platform.impl.windoweffects.WindowEffectsImpl;
import com.ss.android.ugc.aweme.framework.services.f;
import com.ss.android.ugc.aweme.framework.services.g;
import com.ss.android.ugc.aweme.framework.services.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/product/platform/api/windoweffects/WindowEffects;", "Lcom/obric/aiagent/product/platform/api/windoweffects/IWindowEffects;", "<init>", "()V", "TAG", "", "instance", "startActivateEffect", "", "withRipple", "", "stopActivateEffect", "showScreenShotEffect", "skipWindowLayer", "windowLayerName", "playRippleEffect", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WindowEffects implements IWindowEffects {
    public static final WindowEffects INSTANCE = null;
    private static final String TAG = "WindowEffects";
    private static final IWindowEffects instance = null;

    static {
        INSTANCE = new WindowEffects();
        f.a().a(IWindowEffects.class, (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$WindowEffects$fvpm2jN8tJ_Gt27EEPt5F3z3de8.INSTANCE), g.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L9
        Object r3 = f.a().a(IWindowEffects.class, false);     // Catch: Exception -> L9
        if (((IWindowEffects) ZeusTransformUtils.preCheckCast(r3, IWindowEffects.class, "com.obric.memorydata.plugin")) != null) goto L6;
        d.f5954a.c(TAG, "bind WindowEffectsImpl failed");     // Catch: Exception -> L9
    L7:
        IWindowEffects r4 = (IWindowEffects) ZeusTransformUtils.preCheckCast(r3, IWindowEffects.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L9
    L11:
        instance = r4;
        return;
    L6:
        d.f5954a.b(TAG, "bind WindowEffectsImpl success");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        d.f5954a.b(TAG, "bind WindowEffectsImpl failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r4 = null;
        goto L11
    }

    private WindowEffects() {
    }

    private static final Object instance$lambda$0() {
        return new WindowEffectsImpl();
    }

    public static /* synthetic */ Object lambda$fvpm2jN8tJ_Gt27EEPt5F3z3de8() {
        return instance$lambda$0();
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void playRippleEffect(boolean r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "windowLayerName");
        IWindowEffects r0 = instance;
        if (r0 == null) goto L6;
        r0.playRippleEffect(r1, r2);
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void showScreenShotEffect(boolean r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "windowLayerName");
        IWindowEffects r0 = instance;
        if (r0 == null) goto L6;
        r0.showScreenShotEffect(r1, r2);
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void startActivateEffect(boolean r1) {
        IWindowEffects r0 = instance;
        if (r0 == null) goto L6;
        r0.startActivateEffect(r1);
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void stopActivateEffect() {
        IWindowEffects r0 = instance;
        if (r0 == null) goto L6;
        r0.stopActivateEffect();
        return;
    }
}
