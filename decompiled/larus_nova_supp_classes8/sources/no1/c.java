package no1;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends Animation {
    public final /* synthetic */ DoubleBallSwipeRefreshLayout a;

    public c(DoubleBallSwipeRefreshLayout r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r2, Transformation r3) {
        this.a.setAnimationProgress(1.0f - r2);
    }
}
