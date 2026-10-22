package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ e a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;

    public d(e r1, String r2, String r3, long r4, long r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        this.a.g.remove(this.b);
        Iterator<uf0.a> r0 = this.a.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().L2(this.b, r8);
        goto L4
    L6:
        String r1 = this.b;
        String r2 = this.c;
        long r3 = this.d;
        InteractLinkFullLinkMonitor.n(r1, r2, System.currentTimeMillis() - r3, r8);
        String r4 = this.b.toString();
        long r5 = this.d;
        com.bytedance.android.live.liveinteract.plantform.utils.x.t(r4, r8, System.currentTimeMillis() - r5, null);
        TalkRoomBusinessFullLinkMonitor r6 = TalkRoomBusinessFullLinkMonitor.a;
        String r9 = this.b;
        String r10 = this.c;
        long r11 = this.d;
        r6.getClass();
        TalkRoomBusinessFullLinkMonitor.K(r9, r10, r8, r11);
        if (this.e == 0) goto L11;
        xs2.b.a().post(new jd0.b(false));
        return;
    }
}
