package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.revenue.user.RevLiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements DialogInterface.OnClickListener {
    public final /* synthetic */ p a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public l(p r1, String r2) {
        this.a = r1;
        this.b = r2;
        this.c = "connection_manage_setting";
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r9) {
        r8.dismiss();
        p r10 = this.a;
        String r12 = this.b;
        String r6 = this.c;
        if (r10.c == true) goto L19;
        r10.c = true;
        com.bytedance.android.livesdk.revenue.service.user.a r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L10;
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L10;
        long r3 = r2.getRoomId();
    L11:
        long r4 = r3;
        Context r5 = r10.d;
        if ((r5 instanceof Activity) == true) goto L14;
        r5 = null;
    L14:
        Disposable r13 = r0.rl(r12, r4, (Activity) r5, vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).Kh(RevLiveFollowScene.MultiAnchorPanel)).subscribe(new n(r10, r12, r6), new o(r10));
        if (r13 == null) goto L18;
        RxUtilKt.c(r13, r10.b);
        return;
    L18:
        return;
    L10:
        r3 = 0;
        goto L11
    }
}
