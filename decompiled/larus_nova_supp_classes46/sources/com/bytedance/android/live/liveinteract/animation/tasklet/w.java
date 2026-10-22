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
public final class w extends BaseAnimationListener {
    public int a;
    public final /* synthetic */ PathEffectAnimationTasklet b;
    public final /* synthetic */ HSImageView c;

    public static final class a implements Runnable {
        public final /* synthetic */ w a;

        public a(w r1) {
            this.a = r1;
        }

        public final void a() {
            PathEffectAnimationTasklet r0 = this.a.b;
            if (r0.k == true) goto L6;
            PathEffectAnimationTasklet.b(r0, r0.l);
            ALogger.d("InteractAnimation.PathEffectAnimationTasklet", "onAnimationStop#" + this.a.b.hashCode() + " cause timeout.");
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
        if (this.b.i.size() == 0) goto L6;
    L11:
        this.b.j.add(r5);
        return;
    L6:
        if (this.b.j.size() != 0) goto L11;
        ALogger.d("InteractAnimation.PathEffectAnimationTasklet", "onAnimationStart#" + this.b.hashCode());
        PathEffectAnimationTasklet r0 = this.b;
        Function2<d, Boolean, Unit> r1 = r0.r;
        if (r1 == null) goto L10;
        Unit r2 = (Unit) r1.invoke(r0, Boolean.TRUE);
    L10:
        this.b.m.j();
        this.c.postDelayed(new a(this), 10000);
        goto L11
    }

    public final void onAnimationStop(AnimatedDrawable2 r5) {
        PathEffectAnimationTasklet r0 = this.b;
        FrameLayout r1 = r0.h;
        if (r1 == null) goto L5;
        r1.post(new y(r0, this.c, r1));
    L5:
        if (r5 == null) goto L12;
        this.b.j.remove(r5);
        this.b.i.add(r5);
        if (this.b.j.size() == 0) goto L9;
        return;
    L9:
        if (this.b.i.size() != ((ArrayList) this.b.c).size()) goto L14;
        PathEffectAnimationTasklet r6 = this.b;
        PathEffectAnimationTasklet.b(r6, r6.l);
        ALogger.d("InteractAnimation.PathEffectAnimationTasklet", "onAnimationStop#" + this.b.hashCode());
        return;
    L14:
        return;
    }

    public w(PathEffectAnimationTasklet r1, HSImageView r2) {
        this.b = r1;
        this.c = r2;
        this.a = -1;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        if (r3 >= this.a) goto L6;
        r2.stop();
        return;
    L6:
        this.a = r3;
    }
}
