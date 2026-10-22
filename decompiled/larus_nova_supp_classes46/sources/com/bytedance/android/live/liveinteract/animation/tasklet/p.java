package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.graphics.drawable.Animatable;
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
public final class p extends BaseAnimationListener {
    public int a;
    public final /* synthetic */ q b;
    public final /* synthetic */ Animatable c;

    public static final class a implements Runnable {
        public final /* synthetic */ p a;

        public a(p r1) {
            this.a = r1;
        }

        public final void a() {
            n r0 = this.a.b.a;
            if (r0.g == true) goto L6;
            n.b(r0);
            ALogger.d("InteractAnimation.MicSeatAnimationTasklet", "onAnimationStop#" + this.a.b.a.hashCode() + " cause timeout.");
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
        if (this.b.a.e.size() == 0) goto L6;
        return;
    L6:
        if (this.b.a.f.size() != 0) goto L14;
        ALogger.d("InteractAnimation.MicSeatAnimationTasklet", "onAnimationStart#" + this.b.a.hashCode());
        n r0 = this.b.a;
        Function2<d, Boolean, Unit> r1 = r0.q;
        if (r1 == null) goto L10;
        Unit r2 = (Unit) r1.invoke(r0, Boolean.TRUE);
    L10:
        this.b.a.i.l();
        this.b.b.postDelayed(new a(this), 10000);
        this.b.a.f.add(r5);
        return;
    }

    public final void onAnimationStop(AnimatedDrawable2 r5) {
        q r0 = this.b;
        n r1 = r0.a;
        FrameLayout r2 = r0.c;
        HSImageView r3 = r0.b;
        int r4 = n.r;
        r1.getClass();
        r2.post(new s(r1, r3, r2));
        if (r5 == null) goto L10;
        this.b.a.f.remove(r5);
        this.b.a.e.add(r5);
        if (this.b.a.f.size() == 0) goto L7;
        return;
    L7:
        if (this.b.a.e.size() != ((ArrayList) this.b.a.c).size()) goto L12;
        n.b(this.b.a);
        ALogger.d("InteractAnimation.MicSeatAnimationTasklet", "onAnimationStop#" + this.b.a.hashCode());
        return;
    L12:
        return;
    }

    public p(q r1, Animatable r2) {
        this.b = r1;
        this.c = r2;
        this.a = -1;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        if (r3 >= this.a) goto L6;
        this.c.stop();
        return;
    L6:
        this.a = r3;
    }
}
