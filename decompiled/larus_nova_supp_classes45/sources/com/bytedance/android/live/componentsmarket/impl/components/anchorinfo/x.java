package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ MediaAnchorInfoWidget a;

    public x(MediaAnchorInfoWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        IBaseUser r5 = (IBaseUser) r4;
        if (this.a.isViewValid() == false) goto L16;
        User.Companion.getClass();
        User r6 = User.a.a(r5);
        Room r0 = (Room) ((Widget) this.a).dataCenter.get("data_room");
        if (r0 == null) goto L9;
        User r1 = r0.getOwner();
        if (r1 == null) goto L9;
        r1.setFollowInfo(r6.getFollowInfo());
    L9:
        ((Widget) this.a).dataCenter.put("data_is_followed", Boolean.valueOf(r6.isFollowing()));
        if (r6.isFollowing() == false) goto L12;
        MediaAnchorInfoWidget r7 = this.a;
        int r2 = MediaAnchorInfoWidget.x;
        r7.Kq();
        return;
    L12:
        MediaAnchorInfoWidget r8 = this.a;
        if (r8.r == false) goto L18;
        MediaAnchorInfoWidget.Eq(r8);
        return;
    L18:
        return;
    }
}
