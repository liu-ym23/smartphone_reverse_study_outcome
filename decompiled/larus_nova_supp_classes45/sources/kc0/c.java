package kc0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.d7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface c {
    long A();

    void B(boolean r1);

    IBaseUser C();

    String D();

    void E(Observer<Long> r1);

    boolean F();

    void F0();

    oq2.d G();

    void H(boolean r1);

    void I(String r1);

    Long J();

    void K(Object r1);

    com.bytedance.android.live.revlink.impl.pk.transfer.a L();

    void a(Observer<RevPkState> r1);

    IRoom b();

    void c(Observer<RevPkState> r1);

    RevPkState d();

    pc0.e e();

    void f(Observer<Long> r1);

    HashMap<String, String> getFollowExtraParams(String r1);

    String getInviteMode();

    int getPkState();

    boolean isInBreakThrough();

    boolean isMatching();

    d7 multiLiveCoreInfo();

    v1 multiRtcInfo();

    void sendGuestKickOut(String r1, String r2);
}
