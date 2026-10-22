package mq1;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.chatroom.replay.paid.PaidReplayPresenter;
import com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity.ReplayPrivilegeClarityManager;
import com.bytedance.android.livesdk.chatroom.replay.play.ReplayPlayFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface m {
    kq1.a a(com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r1, Context r2, FragmentActivity r3);

    ReplayPrivilegeClarityManager c(com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r1, Context r2, FragmentActivity r3, ReplayPlayFragment.n r4);

    PaidReplayPresenter d();
}
