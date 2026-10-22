package i92;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;
import com.bytedance.android.livesdk.interactivity.notifications.LiveRoomNotifyWidget;
import com.bytedance.android.livesdk.message.model.ik;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends AnimatorListenerAdapter {
    public final /* synthetic */ LiveRoomNotifyWidget a;

    public m(LiveRoomNotifyWidget r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        this.a.a.setVisibility(8);
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        LiveRoomNotifyWidget r5 = this.a;
        if (r5.r.isEmpty() == true) goto L5;
        ik r0 = (ik) ListProtector.get(r5.r, 0);
        ListProtector.remove(r5.r, 0);
        r5.Aq(r0, Boolean.TRUE);
        return;
    L5:
        r5.s = Boolean.TRUE;
    }
}
