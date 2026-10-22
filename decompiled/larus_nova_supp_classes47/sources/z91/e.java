package z91;

import com.bytedance.android.live.room.navi.userinfo_p.mvi.UserInfoDataSource;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ UserInfoDataSource a;

    public e(UserInfoDataSource r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        IFollowPair r4 = (IFollowPair) r3;
        if (this.a.h.a() == false) goto L15;
        if (r4 != null) goto L7;
    L9:
        if (r4 != null) goto L11;
    L12:
        jc1.k.n(ILiveRoomService.class).onFollowStatusChange().onNext(Boolean.TRUE);
    L13:
        UserInfoDataSource.a(this.a, r4);
        return;
    L11:
        if (r4.getFollowStatus() == 0) goto L13;
    L7:
        if (r4.getFollowStatus() != 0) goto L9;
        jc1.k.n(ILiveRoomService.class).onFollowStatusChange().onNext(Boolean.FALSE);
        goto L13
    }
}
