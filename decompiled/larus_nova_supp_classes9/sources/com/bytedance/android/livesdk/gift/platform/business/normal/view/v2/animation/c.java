package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ Ref.BooleanRef b;

    public c(b r1, Ref.BooleanRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    L19:
        return;
    L3:
        if (this.b.element == true) goto L15;
        b r0 = this.a;     // Catch: Throwable -> L12
        HSImageView r1 = r0.c;     // Catch: Throwable -> L12
        if (r1 == null) goto L7;
        r1.setVisibility(8);     // Catch: Throwable -> L12
    L7:
        r0.a(false);     // Catch: Throwable -> L12
        AnimatedDrawable2 r2 = r0.a;     // Catch: Throwable -> L12
        if (r2 == null) goto L10;
        r2.stop();     // Catch: Throwable -> L12
    L10:
        r0.a = null;     // Catch: Throwable -> L12
        return;
    }
}
