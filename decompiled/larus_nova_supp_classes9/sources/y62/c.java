package y62;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.comment.mylive.MyLiveEntranceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ IBaseUser a;
    public final /* synthetic */ MyLiveEntranceManager b;

    public c(IBaseUser r1, MyLiveEntranceManager r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        UserProfileEvent r3 = new UserProfileEvent(this.a);
        r3.setClickUserPosition("my_live_entrance");
        xs2.b.a().post(r3);
        MyLiveEntranceManager.a(this.b);
    }
}
