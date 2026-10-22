package com.obric.aiagent.product.platform.api.app;

import android.app.IObricSystemAnimationListener;
import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JS\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0013\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0002\u0010\u0018R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricSystemAnimationListener;", "", "<init>", "()V", "obricStub", "Landroid/app/IObricSystemAnimationListener;", "getObricStub", "()Landroid/app/IObricSystemAnimationListener;", "obricStub$delegate", "Lkotlin/Lazy;", "onSystemAnimationStateChanged", "", "event", "", "stillAnimating", "", "transitType", "transitionId", "topActivity", "Landroid/content/ComponentName;", "involvedActivities", "", "involvedModes", "", "(IZIILandroid/content/ComponentName;[Landroid/content/ComponentName;[I)V", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ObricSystemAnimationListener {
    private final Lazy obricStub$delegate;

    public ObricSystemAnimationListener() {
        this.obricStub$delegate = LazyKt.lazy(new $$Lambda$ObricSystemAnimationListener$Ozw1ma0MPUG1wz8M2o_IXvvxXk(this));
    }

    /* JADX INFO: renamed from: lambda$Ozw1ma0M-PUG1wz8M2o_IXvvxXk, reason: not valid java name */
    public static /* synthetic */ ObricSystemAnimationListener$obricStub$2$1 m158lambda$Ozw1ma0MPUG1wz8M2o_IXvvxXk(ObricSystemAnimationListener r0) {
        return obricStub_delegate$lambda$0(r0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricSystemAnimationListener$obricStub$2$1] */
    private static final ObricSystemAnimationListener$obricStub$2$1 obricStub_delegate$lambda$0(final ObricSystemAnimationListener r1) {
        return new ObricSystemAnimationListener$obricStub$2$1(r1);
    }

    public final IObricSystemAnimationListener getObricStub() {
        return (IObricSystemAnimationListener) ZeusTransformUtils.preCheckCast(this.obricStub$delegate.getValue(), IObricSystemAnimationListener.class, "com.obric.memorydata.plugin");
    }

    public abstract void onSystemAnimationStateChanged(int r1, boolean r2, int r3, int r4, ComponentName r5, ComponentName[] r6, int[] r7);
}
