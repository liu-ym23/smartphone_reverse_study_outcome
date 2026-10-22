package com.bytedance.android.live.profile.usecase;

import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileOwnRoom;
import com.bytedance.android.live.profile.model.ProfileRoomProxy;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public boolean f;
    public final ps0.b g;
    public final String h;
    public final boolean i;

    public final boolean b() {
        if (this.g.a() == true) goto L6;
        return false;
    L6:
        IRoom r0 = this.g.b();
        String r2 = null;
        if ((r0 instanceof IRoom) == true) goto L9;
        r0 = null;
    L9:
        IRoom r1 = r0;
        String r3 = this.h;
        if (r1 == null) goto L17;
        IOfficialChannelInfo r4 = r1.getOfficialChannelInfo();
        if (r4 == null) goto L17;
        IBaseUser r5 = r4.getChannelUser();
        if (r5 == null) goto L17;
        r2 = r5.getIdString();
    L17:
        return Intrinsics.areEqual(r3, r2);
    }

    public final com.bytedance.android.live.profile.model.d a(NewProfileUser r9) {
        int r1 = 0;
        boolean r2 = true;
        if (this.g.getOwner() != null) goto L6;
    L8:
        int r0 = 0;
    L10:
        if (b() == false) goto L13;
        int r3 = 4;
    L53:
        this.f = this.g.a();
        if (r9 == null) goto L59;
        if (r9.isVcdContentAuthorized() == true) goto L59;
        r1 = 1;
    L73:
        return new com.bytedance.android.live.profile.model.d(r0, r3, r1);
    L59:
        if (this.g.isMediaRoom() == false) goto L62;
        r1 = 2;
        goto L73
    L62:
        if (this.f == false) goto L64;
        r1 = 3;
        goto L73
    L64:
        qs0.i r10 = os0.b.c().getIInteractService();
        if (r10 != null) goto L67;
    L69:
        r2 = false;
    L70:
        if (r2 == false) goto L73;
        r1 = 4;
        goto L73
    L67:
        if (r10.getCurrentScene() != 10) goto L69;
    L13:
        if (this.a == false) goto L16;
        r3 = 2;
        goto L53
    L16:
        if (this.b == false) goto L19;
        r3 = 1;
        goto L53
    L19:
        if (this.d == false) goto L21;
    L52:
        r3 = 3;
        goto L53
    L21:
        if (this.e == true) goto L52;
        if (r9 == null) goto L33;
        BaseProfileInfo r4 = r9.baseProfileInfo;
        if (r4 == null) goto L33;
        String r5 = r4.getIdStr();
        if (r5 == null) goto L33;
        String r7 = os0.b.c().getPlayerUgcRoomUser();
        if (r7 == null) goto L33;
        boolean r6 = Intrinsics.areEqual(r5, r7);
    L34:
        if (r6 == true) goto L52;
        if (this.g.isVSRoom() == false) goto L46;
        if (r9 == null) goto L46;
        ProfileOwnRoom r8 = r9.ownRoom;
        if (r8 == null) goto L46;
        List r12 = r8.getRoomIdList();
        if (r12 == null) goto L46;
        if ((!r12.isEmpty()) != true) goto L46;
        boolean r13 = true;
    L47:
        if (r13 == true) goto L52;
        if (this.i == true) goto L52;
        r3 = 0;
    L46:
        r13 = false;
    L33:
        r6 = false;
        goto L34
    L6:
        if (this.c == false) goto L8;
        r0 = 1;
        goto L10
    }

    public q(ProfileRoomProxy r4, String r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "mRoom");
        Intrinsics.checkNotNullParameter(r5, "selfUserId");
        Intrinsics.checkNotNullParameter(r6, "mTargetUserId");
        this.g = r4;
        this.h = r6;
        this.i = r7;
        this.a = Intrinsics.areEqual(r5, r6);
        this.c = Intrinsics.areEqual(r5, r4.getOwnerUserIdStr());
        boolean r8 = com.bytedance.android.live.revenue.core.util.h.a;
        p11.j r9 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).mo471getRevenueLinkDataHolder();
        String r10 = null;
        if (r9 == null) goto L5;
        String r12 = r9.a();
    L6:
        boolean r0 = true;
        boolean r1 = false;
        if (Intrinsics.areEqual(r12, r6) == false) goto L9;
    L20:
        boolean r13 = true;
    L21:
        this.d = r13;
        qs0.i r14 = os0.b.c().getIInteractService();
        if (r14 == null) goto L30;
        mv0.k.e r15 = r14.getVideoTalkService();
        if (r15 == null) goto L30;
        Pair<Boolean, Long> r16 = r15.k(r6.toString());
        if (r16 == null) goto L30;
        if (((Boolean) r16.getFirst()).booleanValue() != true) goto L30;
    L31:
        this.e = r0;
        qs0.i r17 = os0.b.c().getIInteractService();
        if (r17 == null) goto L37;
        mv0.k.b r18 = r17.h(null);
        if (r18 == null) goto L37;
        r18.k();
    L37:
        if (r4.getOwner() == null) goto L43;
        IBaseUser r19 = r4.getOwner();
        if (r19 == null) goto L42;
        r10 = r19.getIdString();
    L42:
        r1 = Intrinsics.areEqual(r10, r6.toString());
    L43:
        this.b = r1;
        this.f = r4.a();
        return;
    L30:
        r0 = false;
        goto L31
    L9:
        if (os0.b.c().getMultiAnchorOutService().a(r6) == true) goto L20;
        qs0.r r20 = os0.b.c().getIMediaLinkOutService();
        if (r20 != null) goto L13;
    L14:
        qs0.d r22 = os0.b.c().getIBroadcastService();
        if (r22 != null) goto L17;
    L19:
        r13 = false;
        goto L21
    L17:
        if (r22.isUserInAnchorLink(r6) != true) goto L19;
    L13:
        if (r20.isUserInMediaLink(r6) == true) goto L20;
    L5:
        r12 = null;
        goto L6
    }
}
