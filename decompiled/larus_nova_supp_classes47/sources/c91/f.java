package c91;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends AnimatorListenerAdapter {
    public final /* synthetic */ a a;

    public f(a r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r8) {
        Intrinsics.checkNotNullParameter(r8, "animation");
        this.a.a.setVisibility(0);
        if (this.a.e.getWidth() <= 0) goto L5;
        int r9 = this.a.e.getWidth();
    L6:
        UIUtils.updateLayoutMargin(this.a.i, s1.f(38.0f) + r9, s1.f(7.0f), 0, 0);
        this.a.getClass();
        j0 r10 = j0.l();
        Pair[] r2 = new Pair[2];
        Long r3 = null;
        o r5 = z51.a.h(null, 3);
        if (r5 == null) goto L13;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L13;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L13;
        r3 = Long.valueOf(r7.getId());
    L13:
        r2[0] = TuplesKt.to("room_id", String.valueOf(r3));
        r2[1] = TuplesKt.to("user_id", jc1.k.n(IMiddlewareUserService.class).user().n());
        r10.sendLog("livesdk_giftwall_animated_icon_show", MapsKt.mapOf(r2), new Object[]{IRoom.class, new x(), am2.n.f()});
        return;
    L5:
        r9 = s1.f(12.0f) * this.a.e.getText().length();
        goto L6
    }
}
