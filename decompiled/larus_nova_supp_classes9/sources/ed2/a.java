package ed2;

import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.kickout.ui.BannedViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class a implements View.OnClickListener {
    public final /* synthetic */ User a;

    public /* synthetic */ a(User r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        User r4 = this.a;
        int r0 = BannedViewHolder.n;
        xs2.b.a().post(new UserProfileEvent(r4));
    }
}
