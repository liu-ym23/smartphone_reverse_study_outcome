package i11;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.link.model.t6;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b extends c {
    boolean N(String r1);

    int c();

    void clear(boolean r1);

    List<p> d();

    void e(d r1);

    void f(boolean r1);

    List<IBaseUser> getInviteeList();

    void h(int r1, int r2, String r3);

    t6 j();

    void k(int r1, int r2, String r3, long r4);

    List<IBaseUser> n();

    void o(Function1 r1);

    void p(List<? extends p> r1, String r2, Long r3);

    void q(IBaseUser r1);

    void r(IBaseUser r1);

    List<d> s();

    void t(IBaseUser r1);

    void u(String r1);

    p v(String r1);

    String w();

    void x(r r1);

    void y(IBaseUser r1);
}
