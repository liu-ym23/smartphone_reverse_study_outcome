package ie0;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.common.c;
import com.bytedance.android.livesdk.common.d;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import fj0.e;
import java.util.Objects;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends ge0.b {
    public final IRoom b;
    public String c;
    public String d;
    public ILinkPlayerInfoBridge e;
    public long f;
    public long g;

    public final void b() {
        ((c) this).a = null;
    }

    @Override // ge0.b
    public final IBaseUser e() {
        ILinkPlayerInfoBridge r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getUser();
    }

    @Override // ge0.b
    public final boolean g() {
        if (TextUtils.isEmpty(this.c) == true) goto L5;
    L7:
        return false;
    L5:
        if (Objects.equals(this.c, k.f(IMiddlewareUserService.class).user().n()) == false) goto L7;
        return true;
    }

    @Override // ge0.b
    public final String c() {
        return this.d;
    }

    @Override // ge0.b
    public final ILinkPlayerInfoBridge d() {
        return this.e;
    }

    @Override // ge0.b
    public final String f() {
        return this.c;
    }

    public final void a(d r1) {
        ((c) this).a = (ge0.c) r1;
        l(true);
    }

    @Override // ge0.b
    public final void h(long r1) {
        this.g = r1;
    }

    @Override // ge0.b
    public final void i(ILinkPlayerInfoBridge r3) {
        ILinkPlayerInfoBridge r0 = this.e;
        if (r0 == null) goto L5;
        r0.update(r3);
    L6:
        if (r3 == null) goto L8;
        this.f = r3.getFanTicket();
    L8:
        ILinkPlayerInfoBridge r4 = this.e;
        if (r4 == null) goto L13;
        this.d = r4.getInteractId();
        if (this.e.getUser() == null) goto L13;
        this.c = this.e.getUser().getIdString();
    L13:
        l(false);
        return;
    L5:
        this.e = r3;
        goto L6
    }

    @Override // ge0.b
    public final void j(int r2) {
        ILinkPlayerInfoBridge r0 = this.e;
        if (r0 == null) goto L5;
        r0.setInteractingState(r2);
    L5:
        d r1 = ((c) this).a;
        if (r1 == null) goto L13;
        ge0.c r3 = (ge0.c) r1;
        if (r2 != 0) goto L10;
        boolean r4 = true;
    L11:
        r3.B3(r4);
        return;
    L10:
        r4 = false;
        goto L11
    }

    public final void l(boolean r7) {
        d r0 = ((c) this).a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.e != null) goto L9;
        ((ge0.c) r0).setVisibility(false);
        return;
    L9:
        ((ge0.c) r0).setVisibility(true);
        if (this.e.getUser() == null) goto L12;
        ((ge0.c) ((c) this).a).mN(this.e);
    L12:
        k(this.e.getFanTicket(), this.e.getFanTicketDisplayStr());
        if (r7 == true) goto L15;
    L19:
        ((ge0.c) ((c) this).a).Rr(this.e.getExpectLeaveTime(), e.m(this.e));
        return;
    L15:
        if (this.g == 0) goto L19;
        if (((Boolean) vm2.d.P7.getValue(null, vm2.d.a[454(0x1c6, float:6.36E-43)])).booleanValue() == false) goto L19;
        ((ge0.c) ((c) this).a).Rr(this.e.getExpectLeaveTime(), this.e.getExpectLeaveTime() - this.g);
    }

    @Override // ge0.b
    public final void k(long r4, String r6) {
        if (r4 >= this.f) goto L5;
        return;
    L5:
        this.f = r4;
        d r5 = ((c) this).a;
        if (r5 == null) goto L9;
        ((ge0.c) r5).i4(r6);
    L9:
        if (g() == false) goto L14;
        hd0.c r7 = hd0.c.f();
        long r8 = this.f;
        if (r8 <= r7.d) goto L15;
        r7.d = r8;
        return;
    L15:
        return;
    }

    public b(IRoom r3, String r4, ILinkPlayerInfoBridge r5) {
        this.g = 0;
        this.b = r3;
        this.c = "";
        this.d = r4;
        ILinkPlayerInfoBridge r6 = this.e;
        if (r6 == null) goto L5;
        r6.update(r5);
    L6:
        ILinkPlayerInfoBridge r7 = this.e;
        if (r7 == null) goto L12;
        this.d = r7.getInteractId();
        if (this.e.getUser() == null) goto L13;
        this.c = this.e.getUser().getIdString();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        this.e = r5;
        goto L6
    }
}
