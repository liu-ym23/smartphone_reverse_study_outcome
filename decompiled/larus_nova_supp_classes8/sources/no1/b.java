package no1;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends Animation {
    public final /* synthetic */ DoubleBallSwipeRefreshLayout a;

    public b(DoubleBallSwipeRefreshLayout r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r2, Transformation r3) {
        DoubleBallSwipeRefreshLayout r4 = this.a;
        r4.scrollTo(0, (int) (r4.e * r2));
    }
}
