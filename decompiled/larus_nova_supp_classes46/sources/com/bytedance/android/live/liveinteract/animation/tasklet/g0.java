package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g0 implements Runnable {
    public final /* synthetic */ WebPAnimationTasklet a;

    public g0(WebPAnimationTasklet r1) {
        this.a = r1;
    }

    public final void a() {
        WebPAnimationTasklet.b(this.a).setController(null);
        WebPAnimationTasklet.b(this.a).setVisibility(8);
        FrameLayout r0 = this.a.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAnimContainer");
    L5:
        r0.removeView(WebPAnimationTasklet.b(this.a));
        WebPAnimationTasklet r1 = this.a;
        r1.j.a(WebPAnimationTasklet.b(r1));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
