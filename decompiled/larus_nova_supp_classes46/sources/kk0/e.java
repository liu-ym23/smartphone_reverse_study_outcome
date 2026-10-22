package kk0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.PointF;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ a a;
    public final /* synthetic */ PointF b;
    public final /* synthetic */ PointF c;
    public final /* synthetic */ HSImageView d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ALogger.i("BaseMultiLinkWindowManager", "icon move anim end. startPoint " + this.b + ", endPoint " + this.c);
        this.a.c.removeView(this.d);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ALogger.i("BaseMultiLinkWindowManager", "icon move anim start. startPoint " + this.b + ", endPoint " + this.c);
    }

    public e(a r1, PointF r2, PointF r3, HSImageView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
