package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.bridge.s;
import com.bytedance.android.livesdk.link.model.h5;
import com.bytedance.android.livesdk.link.model.j7;
import com.bytedance.android.livesdk.link.model.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ PkAutoMatchManager a;

    public h(PkAutoMatchManager r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        s r4 = (s) r3;
        s1 r0 = r4.castTo(s1.class);
        if (r0 == null) goto L11;
        IBattleLinkerInviteMessageExtra r1 = r0.getBattleExtra();
        if (r1 == null) goto L11;
        h5 r2 = r1.getLinkMicBizExtra();
        if (r2 == null) goto L11;
        j7 r5 = r2.getOpenGameConfig();
        if (r5 == null) goto L11;
        String r6 = r5.getGameAppId();
    L12:
        if (r6 != null) goto L14;
    L17:
        boolean r7 = true;
    L18:
        if (r7 == true) goto L20;
        this.a.k.c(r4, new f(this));
        vh6.c.b(qr2.c.class).hideInteractDialog();
        return;
    L20:
        this.a.k.j(r4, new g(this));
        this.a.getClass();
        return;
    L14:
        if (r6.length() == 0) goto L17;
        r7 = false;
    L11:
        r6 = null;
        goto L12
    }
}
