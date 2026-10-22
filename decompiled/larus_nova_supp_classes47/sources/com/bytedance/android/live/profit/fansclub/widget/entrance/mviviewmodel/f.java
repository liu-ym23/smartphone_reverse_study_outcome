package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.profit.fansclub.widget.entrance.facade.EntranceMVIFacade;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import eu0.w;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ FollowMVIViewModel a;
    public final /* synthetic */ com.bytedance.android.live.profit.fansclub.widget.entrance.data.i b;

    public f(FollowMVIViewModel r1, com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        final BaseResponse r6 = (BaseResponse) r5;
        IBaseUser r1 = null;
        if (com.bytedance.android.live.profit.fansclub.i.c() == false) goto L8;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r0 = this.b;
        if (r6 == null) goto L7;
        r1 = (IBaseUser) r6.data;
    L7:
        r0.J(r1, "FollowMVIViewModel-recheckFollowStatus", true, new FollowMVIViewModel$recheckFollowStatus$1$1(this, r6));
        return;
    L8:
        br2.a r2 = vh6.c.b(br2.a.class);
        if (r6 == null) goto L12;
        r1 = (IBaseUser) r6.data;
    L12:
        if (r2.Tg(r1, this.b.getRoom()) == false) goto L21;
        EntranceMVIFacade r3 = fu0.b.b(this.a.getDataCenter());
        if (r3 == null) goto L16;
        r3.a(new w(this.a.getDataCenter()));
    L16:
        IRoom r4 = this.b.getRoom();
        if (r4 == null) goto L21;
        IBaseUser r7 = r4.getOwner();
        if (r7 == null) goto L21;
        r7.setFollowInfoExt(((IBaseUser) r6.data).getFollowInfo());
    L21:
        this.a.u = false;
    }
}
