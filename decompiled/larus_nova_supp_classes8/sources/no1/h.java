package no1;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends Animation {
    public final /* synthetic */ SwipeRefreshLayout a;

    public h(SwipeRefreshLayout r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r1, Transformation r2) {
        this.a.setAnimationProgress(r1);
    }
}
