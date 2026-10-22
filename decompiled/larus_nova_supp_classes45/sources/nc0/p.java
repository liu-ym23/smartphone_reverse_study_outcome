package nc0;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiRtcInfo;
import com.bytedance.android.livesdk.link.model.d7;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p implements lc0.d {
    public final kc0.q a;

    @Override // lc0.d
    public final long A() {
        return this.a.A();
    }

    @Override // lc0.d
    public final User C() {
        IBaseUser r0 = this.a.C();
        if ((r0 instanceof User) == true) goto L6;
        r0 = null;
    L6:
        return (User) r0;
    }

    @Override // lc0.d
    public final boolean F() {
        return this.a.F();
    }

    @Override // lc0.d
    public final void F0() {
        this.a.F0();
    }

    @Override // lc0.d
    public final oq2.d G() {
        return this.a.G();
    }

    @Override // lc0.d
    public final Room b() {
        return this.a.b();
    }

    @Override // lc0.d
    public final RevPkState d() {
        return this.a.d();
    }

    @Override // lc0.d
    public final pc0.e e() {
        return this.a.e();
    }

    @Override // lc0.d
    public final int getPkState() {
        return this.a.getPkState();
    }

    @Override // lc0.d
    public final boolean isInBreakThrough() {
        return this.a.isInBreakThrough();
    }

    @Override // lc0.d
    public final boolean isMatching() {
        return this.a.isMatching();
    }

    @Override // lc0.d
    public final MultiLiveCoreInfo multiLiveCoreInfo() {
        d7 r0 = this.a.multiLiveCoreInfo();
        if (r0 == null) goto L5;
        vh7.c r1 = k.a(r0);
    L7:
        return (MultiLiveCoreInfo) r1;
    L5:
        r1 = null;
        goto L7
    }

    @Override // lc0.d
    public final MultiRtcInfo multiRtcInfo() {
        vh7.c r0 = this.a.multiRtcInfo();
        if (r0 == null) goto L5;
        vh7.c r1 = k.a(r0);
    L7:
        return (MultiRtcInfo) r1;
    L5:
        r1 = null;
        goto L7
    }

    public p(p11.h r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }

    @Override // lc0.d
    public final void B(boolean r2) {
        this.a.B(r2);
    }

    @Override // lc0.d
    public final void E(Observer<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        this.a.E(r2);
    }

    @Override // lc0.d
    public final void a(Observer<RevPkState> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        this.a.a(r2);
    }

    @Override // lc0.d
    public final void c(Observer<RevPkState> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        this.a.c(r2);
    }

    @Override // lc0.d
    public final void f(Observer<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        this.a.f(r2);
    }

    @Override // lc0.d
    public final void g(FragmentActivity r2) {
        this.a.K(r2);
    }

    @Override // lc0.d
    public final HashMap<String, String> getFollowExtraParams(String r2) {
        Intrinsics.checkNotNullParameter(r2, "targetUid");
        return this.a.getFollowExtraParams(r2);
    }

    @Override // lc0.d
    public final void h(boolean r1, Boolean r2, List r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        this.a.I(r4);
    }
}
