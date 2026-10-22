package hy;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface f {

    public static class a implements b {
        public a() {
        }

        @Override // hy.f.b
        public void a(int r1, List r2) {
        }

        @Override // hy.f.b
        public void b(int r1, List<AnchorLinkUser> r2) {
        }

        @Override // hy.f.b
        public void c(int r1, List<User> r2) {
        }

        @Override // hy.f.b
        public void d(int r1, List<AnchorLinkUser> r2) {
        }
    }

    public interface b {
        void a(int r1, List r2);

        void b(int r1, List<AnchorLinkUser> r2);

        void c(int r1, List<User> r2);

        void d(int r1, List<AnchorLinkUser> r2);
    }

    List<AnchorLinkUser> a();

    void attach();

    void b(int r1, String r2);

    AnchorLinkUser getGuestInfo(String r1, String r2);

    List<AnchorLinkUser> getOnlineUserList();

    void h(a r1);

    void i(a r1);

    void r0();

    void v();
}
