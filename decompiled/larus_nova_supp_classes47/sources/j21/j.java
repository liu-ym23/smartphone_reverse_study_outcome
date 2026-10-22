package j21;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public final i11.b a;
    public final i11.b b;
    public final a c;
    public final b d;
    public c e;

    public static final class a extends i11.c.a {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void i(int r5) {
            if (r5 == 1) goto L5;
            return;
        L5:
            ArrayList<p> r6 = this.a.a();
            j r0 = this.a;
            r0.getClass();
            ArrayList r1 = new ArrayList();
            i11.b r2 = r0.b;
            if (r2 == null) goto L10;
            List<p> r3 = r2.a();
            if (r3 == null) goto L10;
            r1.addAll(r3);
        L10:
            j r4 = this.a;
            c r7 = r4.e;
            if (r7 == null) goto L21;
            i11.b r8 = r4.a;
            if (r8 == null) goto L15;
            List<IBaseUser> r9 = r8.getInviteeList();
        L16:
            i11.b r10 = this.a.a;
            if (r10 == null) goto L19;
            r10.w();
        L19:
            r7.a(r6, r1, r9);
            return;
        L15:
            r9 = null;
            goto L16
        }

        @Override // i11.c.a, i11.c.b
        public final void b(int r5, List<? extends p> r6) {
            if (r5 == 7) goto L5;
            return;
        L5:
            j r7 = this.a;
            r7.getClass();
            ArrayList r8 = new ArrayList();
            i11.b r9 = r7.a;
            if (r9 == null) goto L10;
            List<p> r10 = r9.d();
            if (r10 == null) goto L10;
            r8.addAll(r10);
        L10:
            j r12 = this.a;
            r12.getClass();
            ArrayList r0 = new ArrayList();
            i11.b r13 = r12.a;
            if (r13 == null) goto L15;
            List<p> r14 = r13.a();
            if (r14 == null) goto L15;
            r0.addAll(r14);
        L15:
            List<IBaseUser> r2 = null;
            jy0.b.f("ttlive_anchor_link_panel", "anchorCallback onUserStatusFetch", null, 4);
            j r15 = this.a;
            c r1 = r15.e;
            if (r1 == null) goto L25;
            i11.b r16 = r15.a;
            if (r16 == null) goto L20;
            r2 = r16.getInviteeList();
        L20:
            i11.b r17 = this.a.a;
            if (r17 == null) goto L23;
            r17.w();
        L23:
            r1.a(r8, r0, r2);
            return;
        }

        @Override // i11.c.a, i11.c.b
        public final void c(int r1, List<? extends IBaseUser> r2) {
            c r3 = this.a.e;
            if (r3 == null) goto L6;
            r3.b(r2);
            return;
        }
    }

    public static final class b extends i11.c.a {
        public final /* synthetic */ j a;

        public b(j r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void a(int r5, List r6) {
            ArrayList<p> r7 = this.a.a();
            j r8 = this.a;
            r8.getClass();
            ArrayList r0 = new ArrayList();
            i11.b r9 = r8.b;
            if (r9 == null) goto L7;
            List<p> r10 = r9.a();
            if (r10 == null) goto L7;
            r0.addAll(r10);
        L7:
            List<IBaseUser> r2 = null;
            jy0.b.f("ttlive_anchor_link_panel", "pkCallback onUserStatusFetch", null, 4);
            j r12 = this.a;
            c r1 = r12.e;
            if (r1 == null) goto L17;
            i11.b r13 = r12.b;
            if (r13 == null) goto L12;
            r2 = r13.getInviteeList();
        L12:
            i11.b r14 = this.a.b;
            if (r14 == null) goto L15;
            r14.w();
        L15:
            r1.a(r7, r0, r2);
            return;
        }

        @Override // i11.c.a, i11.c.b
        public final void c(int r2, List<? extends IBaseUser> r3) {
            com.bytedance.android.live.revlink.impl.service.internal.a r4 = com.bytedance.android.live.revlink.impl.global.b.n();
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.k0(4) != true) goto L11;
            c r5 = this.a.e;
            if (r5 == null) goto L12;
            r5.b(r3);
            return;
        L12:
            return;
        }
    }

    public final ArrayList<p> a() {
        ArrayList<p> r0 = new ArrayList();
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        String r3 = null;
        if (r1 == null) goto L11;
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L11;
        p r4 = (p) vh7.f.c(p.class);
        r4.setUser(r2.getOwner());
        LinkCrossRoomDataHolder r5 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r5 == null) goto L9;
        String r6 = r5.e();
    L10:
        r4.setLinkMicIdStr(r6);
        r4.setStatus(2);
        r0.add(r4);
        goto L11
    L9:
        r6 = null;
    L11:
        q r7 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r7 == null) goto L23;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r8 = r7.g();
        if (r8 == null) goto L23;
        LiveData<IBaseUser> r9 = r8.getGuestUser();
        if (r9 == null) goto L23;
        IBaseUser r10 = (IBaseUser) r9.getValue();
        if (r10 == null) goto L23;
        p r12 = (p) vh7.f.c(p.class);
        r12.setUser(r10);
        w31.c r13 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r13 == null) goto L22;
        r3 = r13.b();
    L22:
        r12.setLinkMicIdStr(r3);
        r12.setStatus(2);
        r0.add(r12);
    L23:
        i11.b r14 = this.b;
        if (r14 == null) goto L28;
        List<p> r15 = r14.a();
        if (r15 == null) goto L28;
        r0.addAll(r15);
    L28:
        return r0;
    }

    public j() {
        this.a = com.bytedance.android.live.revlink.impl.global.b.e();
        com.bytedance.android.live.revlink.impl.pk.service.b r0 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r0 == null) goto L5;
        i11.b r1 = r0.getLinkUserCenter();
    L6:
        this.b = r1;
        this.c = new a(this);
        this.d = new b(this);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
