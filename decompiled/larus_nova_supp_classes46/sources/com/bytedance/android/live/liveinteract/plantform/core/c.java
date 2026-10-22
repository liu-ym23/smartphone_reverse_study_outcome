package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ e a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ long g;
    public final /* synthetic */ IBaseUser h;

    public c(e r1, String r2, String r3, long r4, int r6, long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = -1;
        this.f = r6;
        this.g = r7;
        this.h = null;
    }

    public final void accept(Object r9) {
        com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
        this.a.g.remove(this.b);
        if (r10 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.interact.model.v r0 = (com.bytedance.android.livesdk.chatroom.interact.model.v) r10.data;
        if (r0 == null) goto L21;
        InteractLinkFullLinkMonitor.o(this.b, this.c, System.currentTimeMillis() - this.d, r10.logId, (com.bytedance.android.livesdk.chatroom.interact.model.v) r10.data);
        com.bytedance.android.live.liveinteract.plantform.utils.x.s(this.b.toString(), System.currentTimeMillis() - this.d, "pos=" + this.e + ", teamId=" + this.f + ", msgBoardItemId=" + this.g);
        TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
        String r2 = this.b;
        String r3 = this.c;
        long r4 = this.d;
        r1.getClass();
        TalkRoomBusinessFullLinkMonitor.L(r2, r3, r10, r4);
        Iterator<uf0.a> r11 = this.a.e.iterator();
    L8:
        if (r11.hasNext() == false) goto L14;
        uf0.a r5 = r11.next();
        String r6 = this.b;
        IBaseUser r7 = this.h;
        if (r7 != null) goto L12;
        r7 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L12:
        r5.e6(r6, r7, r0);
        goto L8
    L14:
        if (this.g == 0) goto L22;
        xs2.b.a().post(new jd0.b(true));
        return;
    L22:
        return;
    L21:
        return;
    }
}
