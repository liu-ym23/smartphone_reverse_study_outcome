package lc0;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiRtcInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import java.util.List;
import pc0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface d {
    long A();

    void B(boolean r1);

    User C();

    void E(Observer<Long> r1);

    boolean F();

    void F0();

    oq2.d G();

    void a(Observer<RevPkState> r1);

    Room b();

    void c(Observer<RevPkState> r1);

    RevPkState d();

    e e();

    void f(Observer<Long> r1);

    void g(FragmentActivity r1);

    HashMap<String, String> getFollowExtraParams(String r1);

    int getPkState();

    void h(boolean r1, Boolean r2, List r3, String r4);

    boolean isInBreakThrough();

    boolean isMatching();

    MultiLiveCoreInfo multiLiveCoreInfo();

    MultiRtcInfo multiRtcInfo();
}
