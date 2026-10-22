package com.obric.aiagent.product.platform.impl.windoweffects.effects.os_specific;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Point;
import android.os.IBinder;
import android.view.Display;
import android.view.WindowManager;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e²\u0006\f\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u008a\u0084\u0002"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects/os_specific/OSGlobalEffectManager;", "", "<init>", "()V", "TAG", "", "lastEffectAnimator", "Landroid/animation/Animator;", "playRippleEffect", "", "getRealScreenSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "product-platform_release", "displayToken", "Landroid/os/IBinder;"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OSGlobalEffectManager {
    public static final OSGlobalEffectManager INSTANCE = null;
    private static final String TAG = "OSGlobalEffectManager";
    private static Animator lastEffectAnimator;

    static {
        INSTANCE = new OSGlobalEffectManager();
    }

    private OSGlobalEffectManager() {
    }

    public static final /* synthetic */ Animator access$getLastEffectAnimator$p() {
        return lastEffectAnimator;
    }

    public static final /* synthetic */ Point access$getRealScreenSize(OSGlobalEffectManager r2, Context r3) {
        return r2.getRealScreenSize((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ IBinder access$playRippleEffect$lambda$4$lambda$0(Lazy r2) {
        return playRippleEffect$lambda$4$lambda$0((Lazy) ZeusTransformUtils.wrapperContextForParams(r2, Lazy.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$setLastEffectAnimator$p(Animator r0) {
        lastEffectAnimator = r0;
    }

    private final Point getRealScreenSize(Context r2) {
        Object r1 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService("window");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.WindowManager");
        Display r3 = ((WindowManager) ZeusTransformUtils.preCheckCast(r1, WindowManager.class, "com.obric.memorydata.plugin")).getDefaultDisplay();
        Point r4 = new Point();
        r3.getRealSize(r4);
        return r4;
    }

    private static final IBinder playRippleEffect$lambda$4$lambda$0(Lazy<? extends IBinder> r2) {
        return (IBinder) ZeusTransformUtils.preCheckCast(((Lazy) ZeusTransformUtils.wrapperContextForParams(r2, Lazy.class, "com.obric.memorydata.plugin")).getValue(), IBinder.class, "com.obric.memorydata.plugin");
    }

    public final void playRippleEffect() {
        if (b.f5974a.b().e() == true) goto L6;
        d.f5954a.b(TAG, "not play ripple effect");
        return;
    L6:
        d.f5954a.b(TAG, "play ripple effect start");
        com.obric.aiagent.product.a.d.f5969a.b((Runnable) ZeusTransformUtils.preCheckCast(new OSGlobalEffectManager$playRippleEffect$$inlined$runInMain$1(), Runnable.class, "com.obric.memorydata.plugin"));
    }
}
