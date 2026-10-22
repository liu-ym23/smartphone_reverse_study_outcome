package el0;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.user.IUserService;
import dl0.m;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends g {
    public String b;
    public String c;
    public LinkPlayerInfo d;
    public long e;

    public final void b() {
        ((com.bytedance.android.livesdk.common.c) this).a = null;
    }

    @Override // el0.g
    public final User e() {
        LinkPlayerInfo r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return jm2.a.e(r0.getUser());
    }

    @Override // el0.g
    public final String c() {
        return this.c;
    }

    @Override // el0.g
    public final LinkPlayerInfo d() {
        return this.d;
    }

    @Override // el0.g
    public final String f() {
        return this.b;
    }

    public final void a(com.bytedance.android.livesdk.common.d r1) {
        ((com.bytedance.android.livesdk.common.c) this).a = (h) r1;
        j(true);
    }

    @Override // el0.g
    public final void g(LinkPlayerInfo r2) {
        LinkPlayerInfo r0 = this.d;
        if (r0 == null) goto L5;
        r0.update(r2);
    L6:
        LinkPlayerInfo r3 = this.d;
        if (r3 == null) goto L11;
        this.c = r3.getInteractId();
        if (this.d.getUser() == null) goto L11;
        this.b = this.d.getUser().getIdString();
    L11:
        j(false);
        return;
    L5:
        this.d = r2;
        goto L6
    }

    @Override // el0.g
    public final void h(int r2) {
        LinkPlayerInfo r0 = this.d;
        if (r0 == null) goto L5;
        r0.setInteractingState(r2);
    L5:
        com.bytedance.android.livesdk.common.d r1 = ((com.bytedance.android.livesdk.common.c) this).a;
        if (r1 == null) goto L13;
        h r3 = (h) r1;
        if (r2 != 0) goto L10;
        boolean r4 = true;
    L11:
        r3.B3(r4);
        return;
    L10:
        r4 = false;
        goto L11
    }

    public final void j(boolean r3) {
        com.bytedance.android.livesdk.common.d r4 = ((com.bytedance.android.livesdk.common.c) this).a;
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.d != null) goto L9;
        ((h) r4).setVisibility(false);
        return;
    L9:
        ((h) r4).setVisibility(true);
        if (this.d.getUser() == null) goto L12;
        ((h) ((com.bytedance.android.livesdk.common.c) this).a).Qb(this.d);
    L12:
        i(this.d.getFanTicket(), this.d.mFanTicketDisplayStr);
    }

    public i(String r2, LinkPlayerInfo r3) {
        this.b = "0";
        this.c = r2;
        LinkPlayerInfo r4 = this.d;
        if (r4 == null) goto L5;
        r4.update(r3);
    L6:
        LinkPlayerInfo r5 = this.d;
        if (r5 == null) goto L12;
        this.c = r5.getInteractId();
        if (this.d.getUser() == null) goto L13;
        this.b = this.d.getUser().getIdString();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        this.d = r3;
        goto L6
    }

    @Override // el0.g
    public final void i(long r4, String r6) {
        String r0 = "updateTicket interactId=" + this.c + " ticket=" + r4 + " ticketStr=" + r6 + " mTicketCount = " + this.e + " mView = " + ((com.bytedance.android.livesdk.common.c) this).a;
        m.a.getClass();
        m.C("guest_score_update_pre", r0);
        if (r4 >= this.e) goto L5;
        return;
    L5:
        this.e = r4;
        com.bytedance.android.livesdk.common.d r5 = ((com.bytedance.android.livesdk.common.c) this).a;
        if (r5 == null) goto L8;
        ((h) r5).i4(r6);
    L8:
        String r7 = this.b;
        if (r7 != null) goto L11;
    L13:
        boolean r8 = false;
    L14:
        if (r8 == false) goto L19;
        hd0.c r9 = hd0.c.f();
        long r10 = this.e;
        if (r10 <= r9.d) goto L20;
        r9.d = r10;
        return;
    L20:
        return;
    L19:
        return;
    L11:
        if (n0.a(r7, k.f(IUserService.class).user().b().getIdString()) == false) goto L13;
        r8 = true;
        goto L14
    }
}
