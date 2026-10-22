package no1;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.MaterialProgressDrawable;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j extends Animation {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ SwipeRefreshLayout c;

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r4, Transformation r5) {
        MaterialProgressDrawable r6 = this.c.x;
        int r0 = this.a;
        r6.b.u = (int) (r0 + ((this.b - r0) * r4));
    }

    public j(SwipeRefreshLayout r1, int r2, int r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
