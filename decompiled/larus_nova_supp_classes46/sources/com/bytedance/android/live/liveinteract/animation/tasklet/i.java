package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends BaseAnimationListener {
    public int a;
    public final /* synthetic */ IconMoveAnimationTasklet b;
    public final /* synthetic */ HSImageView c;
    public final /* synthetic */ AnimatedDrawable2 d;
    public final /* synthetic */ FrameLayout e;

    public static final class a implements Runnable {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        public final void a() {
            IconMoveAnimationTasklet r0 = this.a.b;
            if (r0.j == true) goto L6;
            IconMoveAnimationTasklet.b(r0);
            ALogger.d("InteractAnimation.IconMoveAnimationTasklet", "onAnimationStop#" + this.a.b.hashCode() + " cause timeout.");
            return;
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

    public final void onAnimationStart(AnimatedDrawable2 r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (this.b.f.size() == 0) goto L6;
    L11:
        this.b.g.add(r5);
        return;
    L6:
        if (this.b.g.size() != 0) goto L11;
        ALogger.d("InteractAnimation.IconMoveAnimationTasklet", "onAnimationStart#" + this.b.hashCode());
        IconMoveAnimationTasklet r0 = this.b;
        Function2<d, Boolean, Unit> r1 = r0.q;
        if (r1 == null) goto L10;
        Unit r2 = (Unit) r1.invoke(r0, Boolean.TRUE);
    L10:
        this.b.l.j();
        this.c.postDelayed(new a(this), 10000);
        goto L11
    }

    public final void onAnimationStop(AnimatedDrawable2 r5) {
        IconMoveAnimationTasklet r0 = this.b;
        FrameLayout r1 = this.e;
        HSImageView r2 = this.c;
        r0.getClass();
        r1.post(new k(r0, r2, r1));
        if (r5 == null) goto L10;
        this.b.g.remove(r5);
        this.b.f.add(r5);
        if (this.b.g.size() == 0) goto L7;
        return;
    L7:
        if (this.b.f.size() != ((ArrayList) this.b.c).size()) goto L12;
        IconMoveAnimationTasklet.b(this.b);
        ALogger.d("InteractAnimation.IconMoveAnimationTasklet", "onAnimationStop#" + this.b.hashCode());
        return;
    L12:
        return;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        if (r3 >= this.a) goto L6;
        this.d.stop();
        return;
    L6:
        this.a = r3;
    }

    public i(IconMoveAnimationTasklet r1, HSImageView r2, AnimatedDrawable2 r3, FrameLayout r4) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = -1;
    }
}
