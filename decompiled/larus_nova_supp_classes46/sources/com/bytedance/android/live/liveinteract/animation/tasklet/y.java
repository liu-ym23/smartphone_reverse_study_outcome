package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y implements Runnable {
    public final /* synthetic */ PathEffectAnimationTasklet a;
    public final /* synthetic */ HSImageView b;
    public final /* synthetic */ FrameLayout c;

    public y(PathEffectAnimationTasklet r1, HSImageView r2, FrameLayout r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HSImageView r0 = this.b;     // Catch: Throwable -> L4
        this.c.removeView(r0);     // Catch: Throwable -> L4
        this.a.o.a(r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
