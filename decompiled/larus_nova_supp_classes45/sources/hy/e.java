package hy;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface e extends f {
    boolean N(String r1);

    int c();

    void clear(boolean r1);

    List<AnchorLinkUser> d();

    void e(User r1);

    AnchorLinkUser f(String r1, boolean r2);

    AnchorLinkUser g(String r1);

    List<User> getInviteeList();

    void j();

    void k(User r1);
}
