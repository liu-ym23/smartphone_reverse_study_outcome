package z91;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.navi.userinfo_p.mvi.UserInfoDataSource;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ UserInfoDataSource a;

    public h(UserInfoDataSource r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.profit.fansclub.c r6 = (com.bytedance.android.live.profit.fansclub.c) r5;
        if ((r6 instanceof com.bytedance.android.live.profit.fansclub.c.C0019c) == false) goto L23;
        UserInfoDataSource r0 = this.a;
        IBaseUser r7 = ((com.bytedance.android.live.profit.fansclub.c.C0019c) r6).a;
        if (r7 == null) goto L21;
        r0.getClass();
        if (jc1.k.n(IMiddlewareUserService.class).user().isLogin() == false) goto L45;
        IRoom r2 = r0.h.getRoom();
        if (r2 == null) goto L38;
        IBaseUser r3 = r2.getOwner();
        if (r3 != null) goto L15;
        return;
    L15:
        if (r3.isFollowing() == true) goto L17;
        ALogger.i(r0.a, "auto follow after join fans club");
        r0.b(true);
    L17:
        IBaseUser r1 = (IBaseUser) r0.h.getDataCenter().get("data_user_in_room", null);
        if (r1 == null) goto L39;
        r1.setFansClub(r7.getFansClub());
        return;
    L39:
        return;
    L38:
        return;
    L45:
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.IBaseUser");
    L23:
        if ((r6 instanceof com.bytedance.android.live.profit.fansclub.c.a) == true) goto L25;
        return;
    L25:
        if (((com.bytedance.android.live.profit.fansclub.c.a) r6).b != 2) goto L42;
        UserInfoDataSource r8 = this.a;
        r8.getClass();
        if (jc1.k.n(IMiddlewareUserService.class).user().isLogin() == false) goto L47;
        IRoom r4 = r8.h.getRoom();
        if (r4 == null) goto L43;
        IBaseUser r9 = r4.getOwner();
        if (r9 != null) goto L35;
        return;
    L35:
        if (r9.isFollowing() == true) goto L44;
        r8.b(true);
        return;
    L44:
        return;
    L43:
        return;
    L47:
        return;
    }
}
