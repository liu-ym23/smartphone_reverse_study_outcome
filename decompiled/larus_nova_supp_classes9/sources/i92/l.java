package i92;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.notifications.LiveRoomNotifyWidget;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l extends AnimatorListenerAdapter {
    public final /* synthetic */ LiveRoomNotifyWidget a;

    public l(LiveRoomNotifyWidget r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r7) {
        if (this.a.isViewValid() == false) goto L26;
        LiveRoomNotifyWidget r8 = this.a;
        if (r8.e == null) goto L27;
        r8.i.start();
        boolean r0 = false;
        if (this.a.c.getLayout() == null) goto L15;
        int r9 = (int) this.a.c.getLayout().getLineWidth(0);
        int r1 = this.a.c.getWidth();
        if (r1 != 0) goto L12;
        r1 = this.a.c.getMeasuredWidth();
    L12:
        final int r10 = r9 - ((r1 - this.a.c.getCompoundPaddingRight()) - this.a.c.getCompoundPaddingLeft());
        if (r10 <= 0) goto L16;
        r0 = true;
    L16:
        LiveRoomNotifyWidget r2 = this.a;
        long r3 = r2.l - 1700;
        r2.l = r3;
        if (r0 == true) goto L24;
        View r11 = ((Widget) r2).contentView;
        Runnable r4 = new h(this);
        if (r3 > 0) goto L22;
        r3 = 2000;
    L22:
        r11.postDelayed(r4, r3);
        return;
    L24:
        ((Widget) r2).contentView.postDelayed(new i(this, r10), 500);
        return;
    L15:
        r10 = 0;
        goto L16
    L27:
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        this.a.a.setVisibility(0);
    }
}
