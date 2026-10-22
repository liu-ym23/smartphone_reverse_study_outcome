package i92;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.notifications.LiveRoomNotifyWidget;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    public k(l r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r9) {
        LiveRoomNotifyWidget r10 = this.a.a;
        View r0 = ((Widget) r10).contentView;
        Runnable r1 = new j(this);
        long r2 = r10.l;
        long r4 = 500;
        if (r2 <= 2000) goto L5;
        r4 = 500 + (r2 - 2000);
    L5:
        r0.postDelayed(r1, r4);
    }
}
