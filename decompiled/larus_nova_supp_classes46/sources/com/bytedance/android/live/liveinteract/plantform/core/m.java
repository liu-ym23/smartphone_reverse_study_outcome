package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ n a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ LinkApplyType e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ String g;
    public final /* synthetic */ Integer h;
    public final /* synthetic */ Integer i;
    public final /* synthetic */ Integer j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ boolean l;
    public final /* synthetic */ int m;
    public final /* synthetic */ tf0.b n;
    public final /* synthetic */ long o;

    public m(n r4, int r5, int r6, int r7, LinkApplyType r8, boolean r9, String r10, Integer r11, Integer r12, Integer r13, boolean r14, boolean r15, int r16, tf0.b r17, long r18) {
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r18;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        new qh0.h(this.c, new GuestLinkManager$apply$4$1(this), GuestLinkManager$apply$4$2.INSTANCE).c(r9);
        int r0 = this.d;
        int r1 = this.c;
        String r2 = this.g;
        long r3 = this.o;
        InteractLinkFullLinkMonitor.c(r0, r1, r2, System.currentTimeMillis() - r3, r9);
        long r4 = this.o;
        long r5 = System.currentTimeMillis() - r4;
        int r6 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        LinkedHashMap r7 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.plantform.utils.x.X(r9, r7);
        r7.put("duration", Long.valueOf(r5));
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("guest_apply_failed", r7);
        TalkRoomBusinessFullLinkMonitor r10 = TalkRoomBusinessFullLinkMonitor.a;
        int r11 = this.d;
        LinkApplyType r12 = this.e;
        int r13 = this.c;
        long r14 = this.o;
        r10.getClass();
        TalkRoomBusinessFullLinkMonitor.G(r11, r12, r13, r9, r14);
        Iterator<s> r15 = this.a.c.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r15.next().Q2(r9);
        goto L4
    L6:
        this.a.getClass();
        tf0.b r16 = this.n;
        if (r16 == null) goto L11;
        r16.a();
        return;
    }
}
