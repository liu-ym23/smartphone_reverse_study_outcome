package com.bytedance.android.live.revlink.impl.multianchor.network;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.e7;
import com.bytedance.android.livesdk.link.model.f7;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public IBattleConfigSetting a;
    public final i11.b b;
    public final i11.b c;
    public final a d;
    public final b e;
    public d f;

    public static final class a extends i11.c.a {
        public final /* synthetic */ k a;

        public a(k r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void e(String r3) {
            com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.k0(64) != true) goto L14;
            d r1 = this.a.f;
            if (r1 == null) goto L15;
            if (r3 != null) goto L11;
            r3 = null;
        L11:
            r1.e(r3);
            return;
        L15:
            return;
        }

        @Override // i11.c.a, i11.c.b
        public final void b(int r10, List<? extends p> r12) {
            if (r10 == 7) goto L5;
            return;
        L5:
            this.a.getClass();
            e7 r13 = k.a();
            if (r13 != null) goto L8;
            return;
        L8:
            PlayMode r14 = h21.c.a(Integer.valueOf(r13.getModeTab()));
            k r0 = this.a;
            r0.getClass();
            ArrayList r4 = new ArrayList();
            i11.b r1 = r0.b;
            if (r1 == null) goto L13;
            List<p> r2 = r1.d();
            if (r2 == null) goto L13;
            r4.addAll(r2);
        L13:
            k r3 = this.a;
            r3.getClass();
            ArrayList r5 = new ArrayList();
            i11.b r6 = r3.b;
            if (r6 == null) goto L19;
            List<p> r7 = r6.a();
            if (r7 == null) goto L19;
            r5.addAll(r7);
        L19:
            if (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.f.a(this.a.a, f7.a(r13)) == true) goto L21;
            return;
        L21:
            Intrinsics.checkNotNullParameter(r13, "$this$userIdToTeamId");
            Map<String, Long> r8 = r13.getRevUserIdToTeamId();
            if (r14 != PlayMode.PERSONAL_PK) goto L35;
            d r15 = this.a.f;
            if (r15 == null) goto L49;
            long r9 = r13.getVersion();
            i11.b r16 = this.a.b;
            if (r16 == null) goto L28;
            List<IBaseUser> r17 = r16.getInviteeList();
        L29:
            i11.b r18 = this.a.b;
            if (r18 == null) goto L32;
            String r19 = r18.w();
        L33:
            r15.h(r9, r4, r5, r17, r19);
            return;
        L32:
            r19 = null;
            goto L33
        L28:
            r17 = null;
            goto L29
        L49:
            return;
        L35:
            if (r14 != PlayMode.TEAM_PK) goto L51;
            if (r8 == null) goto L52;
            d r110 = this.a.f;
            if (r110 == null) goto L53;
            long r20 = r13.getVersion();
            i11.b r111 = this.a.b;
            if (r111 == null) goto L42;
            List<IBaseUser> r22 = r111.getInviteeList();
        L43:
            i11.b r112 = this.a.b;
            if (r112 == null) goto L46;
            String r23 = r112.w();
        L47:
            r110.f(r20, r4, r5, r22, r23, r8);
            return;
        L46:
            r23 = null;
            goto L47
        L42:
            r22 = null;
            goto L43
        L53:
            return;
        L52:
            return;
        }

        @Override // i11.c.a, i11.c.b
        public final void c(int r2, List<? extends IBaseUser> r3) {
            com.bytedance.android.live.revlink.impl.service.internal.a r4 = com.bytedance.android.live.revlink.impl.global.b.n();
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.k0(64) != true) goto L11;
            d r5 = this.a.f;
            if (r5 == null) goto L12;
            r5.b(r3);
            return;
        L12:
            return;
        }
    }

    public static final class b extends i11.c.a {
        public final /* synthetic */ k a;

        public b(k r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void e(String r3) {
            com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.k0(4) != true) goto L11;
            d r1 = this.a.f;
            if (r1 == null) goto L12;
            r1.e(r3);
            return;
        L12:
            return;
        }

        @Override // i11.c.a, i11.c.b
        public final void a(int r10, List r12) {
            this.a.getClass();
            e7 r13 = k.a();
            if (r13 != null) goto L5;
            return;
        L5:
            PlayMode r14 = h21.c.a(Integer.valueOf(r13.getModeTab()));
            k r0 = this.a;
            r0.getClass();
            ArrayList r4 = new ArrayList();
            yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
            if (r1 == null) goto L14;
            IRoom r2 = r1.getRoom();
            if (r2 == null) goto L14;
            p r5 = vh7.f.c(p.class);
            r5.setUser(r2.getOwner());
            LinkCrossRoomDataHolder r3 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r3 == null) goto L12;
            String r6 = r3.e();
        L13:
            r5.setLinkMicIdStr(r6);
            r5.setStatus(2);
            r4.add(r5);
            goto L14
        L12:
            r6 = null;
        L14:
            q r7 = com.bytedance.android.live.revlink.impl.global.b.W();
            if (r7 == null) goto L27;
            com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r8 = r7.g();
            if (r8 == null) goto L27;
            LiveData<IBaseUser> r9 = r8.getGuestUser();
            if (r9 == null) goto L27;
            IBaseUser r15 = (IBaseUser) r9.getValue();
            if (r15 == null) goto L27;
            p r16 = vh7.f.c(p.class);
            r16.setUser(r15);
            w31.c r17 = com.bytedance.android.live.revlink.impl.global.b.T();
            if (r17 == null) goto L25;
            String r18 = r17.b();
        L26:
            r16.setLinkMicIdStr(r18);
            r16.setStatus(2);
            r4.add(r16);
            goto L27
        L25:
            r18 = null;
        L27:
            i11.b r19 = r0.b;
            if (r19 == null) goto L32;
            List<p> r20 = r19.a();
            if (r20 == null) goto L32;
            r4.addAll(r20);
        L32:
            k r22 = this.a;
            r22.getClass();
            ArrayList r23 = new ArrayList();
            i11.b r24 = r22.b;
            if (r24 == null) goto L38;
            List<p> r25 = r24.a();
            if (r25 == null) goto L38;
            r23.addAll(r25);
        L38:
            if (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.f.a(this.a.a, f7.a(r13)) == true) goto L40;
            return;
        L40:
            Intrinsics.checkNotNullParameter(r13, "$this$userIdToTeamId");
            Map<String, Long> r26 = r13.getRevUserIdToTeamId();
            if (r14 != PlayMode.PERSONAL_PK) goto L54;
            d r27 = this.a.f;
            if (r27 == null) goto L68;
            long r110 = r13.getVersion();
            i11.b r28 = this.a.c;
            if (r28 == null) goto L47;
            List<IBaseUser> r29 = r28.getInviteeList();
        L48:
            i11.b r30 = this.a.c;
            if (r30 == null) goto L51;
            String r32 = r30.w();
        L52:
            r27.h(r110, r4, r23, r29, r32);
            return;
        L51:
            r32 = null;
            goto L52
        L47:
            r29 = null;
            goto L48
        L68:
            return;
        L54:
            if (r14 != PlayMode.TEAM_PK) goto L70;
            if (r26 == null) goto L71;
            d r33 = this.a.f;
            if (r33 == null) goto L72;
            long r111 = r13.getVersion();
            i11.b r34 = this.a.c;
            if (r34 == null) goto L61;
            List<IBaseUser> r35 = r34.getInviteeList();
        L62:
            i11.b r36 = this.a.c;
            if (r36 == null) goto L65;
            String r37 = r36.w();
        L66:
            r33.f(r111, r4, r23, r35, r37, r26);
            return;
        L65:
            r37 = null;
            goto L66
        L61:
            r35 = null;
            goto L62
        L72:
            return;
        L71:
            return;
        }

        @Override // i11.c.a, i11.c.b
        public final void c(int r2, List<? extends IBaseUser> r3) {
            com.bytedance.android.live.revlink.impl.service.internal.a r4 = com.bytedance.android.live.revlink.impl.global.b.n();
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.k0(4) != true) goto L11;
            d r5 = this.a.f;
            if (r5 == null) goto L12;
            r5.b(r3);
            return;
        L12:
            return;
        }
    }

    public k() {
        com.bytedance.android.live.revlink.impl.multianchor.service.d r0 = com.bytedance.android.live.revlink.impl.global.b.z();
        i11.b r1 = null;
        if (r0 == null) goto L5;
        i11.b r2 = r0.getLinkUserCenter();
    L6:
        this.b = r2;
        com.bytedance.android.live.revlink.impl.pk.service.b r3 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r3 == null) goto L9;
        r1 = r3.getLinkUserCenter();
    L9:
        this.c = r1;
        this.d = new a(this);
        this.e = new b(this);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static e7 a() {
        MultiAnchorPkLaunchContext r0 = com.bytedance.android.live.revlink.impl.global.b.x();
        if (r0 == null) goto L9;
        n<com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g> r1 = r0.getMultiPkModeInfo();
        if (r1 == null) goto L9;
        com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g r2 = (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g) r1.getValue();
        if (r2 == null) goto L9;
        return r2.a;
    L9:
        return null;
    }
}
