package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e0<T> implements Consumer {
    public final /* synthetic */ LongPressPanelFollowWidget a;
    public final /* synthetic */ mt1.a b;
    public final /* synthetic */ boolean c;

    public e0(LongPressPanelFollowWidget r1, mt1.a r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        IBaseUser r5 = (IBaseUser) r4;
        LongPressPanelFollowWidget r6 = this.a;
        mt1.a r0 = this.b;
        boolean r1 = this.c;
        List<String> r2 = LongPressPanelFollowWidget.b;
        r6.zq(r0, r1);
    }
}
