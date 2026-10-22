package com.bytedance.android.livesdk.chatroom.widget;

import android.app.Activity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IVSCompatRoom;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q2 implements Function<IBaseUser, ObservableSource<FollowPair>> {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ IVSCompatRoom c;
    public final /* synthetic */ Runnable d;
    public final /* synthetic */ r2 e;

    public final Object apply(Object r5) throws Exception {
        IBaseUser r6 = (IBaseUser) r5;
        r2 r7 = this.e;
        Activity r0 = this.a;
        String r1 = this.b;
        Long r2 = Long.valueOf(this.c.getRoomId());
        Runnable r3 = this.d;
        r7.getClass();
        return r2.a(r0, r1, r2, r3);
    }

    public q2(Activity r2, String r3, IVSCompatRoom r4, o2.a r5) {
        this.e = r2.a.a;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
