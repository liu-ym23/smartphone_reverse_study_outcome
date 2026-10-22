package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import android.view.View;
import android.view.animation.ScaleAnimation;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.config.qy0;
import com.bytedance.android.livesdk.widget.VisibilityFrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public ScaleAnimation a;
    public final View b;
    public final Function0<Unit> c;
    public final Function0<Unit> d;

    public static final class a implements Runnable {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void b() {
        View r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        ScaleAnimation r10 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.0f, 1, 0.8f);
        r10.setDuration(440);
        Unit r1 = Unit.INSTANCE;
        this.a = r10;
        UtilityKotlinExtentionsKt.w(r0);
        r0.startAnimation(this.a);
    }

    public final void a(boolean r4) {
        View r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        ScaleAnimation r1 = this.a;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        if (r4 == false) goto L13;
        this.c.invoke();
        if (qy0.a.getValue().h() == true) goto L12;
        b();
        return;
    L12:
        i0.c().postDelayed(new a(this), 500);
        return;
    L13:
        UtilityKotlinExtentionsKt.w(r0);
        r0.setScaleX(1.0f);
        r0.setScaleY(1.0f);
        r0.setAlpha(1.0f);
        this.c.invoke();
    }

    public g(VisibilityFrameLayout r2, Function0 r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r3, "onShow");
        Intrinsics.checkNotNullParameter(r4, "onDismiss");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
