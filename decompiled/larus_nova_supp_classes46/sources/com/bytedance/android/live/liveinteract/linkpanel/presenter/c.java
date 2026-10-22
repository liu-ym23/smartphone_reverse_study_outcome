package com.bytedance.android.live.liveinteract.linkpanel.presenter;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListContract$View;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.interact.model.v;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ ILinkPlayerInfoBridge b;
    public final /* synthetic */ long c;

    public c(b r1, ILinkPlayerInfoBridge r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r8) {
        com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
        BaseTalkInviteListContract$View r0 = (BaseTalkInviteListContract$View) this.a.b;
        if (r0 == null) goto L5;
        IBaseUser r1 = this.b.getUser();
        Intrinsics.checkNotNull(r1);
        r0.ba0(r1, ((v) r9.data).getNoticeInfoList());
    L5:
        IBaseUser r2 = this.b.getUser();
        Intrinsics.checkNotNull(r2);
        String r3 = r2.getIdString();
        IBaseUser r4 = this.b.getUser();
        Intrinsics.checkNotNull(r4);
        String r5 = o.a(r4);
        long r6 = this.c;
        SimpleDateFormat r7 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
        InteractLinkFullLinkMonitor.o(r3, r5, System.currentTimeMillis() - r6, r9.logId, (v) r9.data);
    }
}
