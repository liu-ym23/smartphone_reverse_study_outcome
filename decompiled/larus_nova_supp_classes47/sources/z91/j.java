package z91;

import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.live.room.navi.userinfo_p.mvi.UserInfoDataSource;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementMiddleVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.UserInfoVM;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import l81.q;
import l81.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ UserInfoDataSource a;
    public final /* synthetic */ DataCenter b;

    public j(UserInfoDataSource r1, DataCenter r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        IBaseUser r7 = (IBaseUser) r6;
        if (this.a.h.a() == false) goto L60;
        INavigationProxyService r0 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        py.j r1 = null;
        if (r0 == null) goto L10;
        u r2 = r0.getUserService();
        if (r2 == null) goto L10;
        User r8 = r2.a(r7);
    L11:
        Room r3 = (Room) this.b.get("data_room");
        if (r3 == null) goto L23;
        User r4 = r3.getOwner();
        if (r4 == null) goto L23;
        if (r8 == null) goto L17;
        py.j r5 = r8.getFollowInfo();
    L19:
        if ((r5 instanceof FollowInfo) == false) goto L22;
        r1 = r5;
    L22:
        r4.setFollowInfo((FollowInfo) r1);
        goto L23
    L17:
        r5 = null;
    L23:
        DataCenter r9 = this.b;
        if (r8 != null) goto L26;
    L28:
        boolean r10 = false;
    L29:
        r9.put("data_is_followed", Boolean.valueOf(r10));
        if (r8 != null) goto L32;
    L45:
        UserInfoDataSource r12 = this.a;
        if (r12.f == false) goto L48;
        r12.b(false);
        return;
    L48:
        UserInfoVM.Companion.getClass();
        aa1.a r13 = UserInfoVM.b.b();
        if (r13 == null) goto L58;
        ElementMiddleVM r14 = r13.getMiddleVm();
        if (r14 == null) goto L59;
        r14.sendAction(new b(false));
        return;
    L59:
        return;
    L58:
        return;
    L32:
        if (r8.isFollowing() != true) goto L45;
        INavigationProxyService r15 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r15 == null) goto L40;
        q r16 = r15.getRechargeServiceExternal();
        if (r16 == null) goto L40;
        RechargeCurrentCacheData r17 = r16.getCurrentRechargeCacheDataObject();
        if (r17 == null) goto L40;
        r17.setFollowed(true);
    L40:
        UserInfoVM.Companion.getClass();
        aa1.a r18 = UserInfoVM.b.b();
        if (r18 == null) goto L54;
        ElementMiddleVM r19 = r18.getMiddleVm();
        if (r19 == null) goto L55;
        r19.sendAction(new b(true));
        return;
    L55:
        return;
    L54:
        return;
    L26:
        if (r8.isFollowing() != true) goto L28;
        r10 = true;
    L10:
        r8 = null;
        goto L11
    }
}
