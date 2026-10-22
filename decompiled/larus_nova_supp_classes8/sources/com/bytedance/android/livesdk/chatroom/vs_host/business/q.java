package com.bytedance.android.livesdk.chatroom.vs_host.business;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.ui.LiveProfileAnonymousFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q implements wr1.e {
    public final LiveProfileAnonymousFragment a;
    public final /* synthetic */ IBaseUser b;

    @Override // wr1.e
    public final void a(IBaseUser r3) {
        this.a.S90((User) com.bytedance.android.live.base.model.m.b(r3, User.class));
    }

    public q(String r2, String r3, IBaseUser r4, long r5, boolean r7) {
        this.b = r4;
        User r6 = (User) com.bytedance.android.live.base.model.m.b(r4, User.class);
        LiveProfileAnonymousFragment r0 = new LiveProfileAnonymousFragment();
        r0.j = r2;
        r0.k = r3;
        r0.l = r5;
        r0.i = r6;
        r0.m = r7;
        this.a = r0;
    }
}
