package com.bytedance.android.live.profile.ui.component;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.ActivityBadges;
import com.bytedance.android.live.base.model.user.GiftExhibitionHomeStats;
import com.bytedance.android.live.base.model.user.HonorWallUi;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.android.live.profile.ui.component.view.honour.ProfileHonourActivityBadgeView;
import com.bytedance.android.live.profile.ui.component.view.honour.ProfileLevelCardView;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileHonourWallComponent extends DataAssembler<st0.e> {
    public static final /* synthetic */ int g = 0;

    public static final class Companion {
        public static void a(ActivityBadges r2, DataAssembler r3) {
            Intrinsics.checkNotNullParameter(r3, "assembler");
            if (r2 == null) goto L10;
            List r4 = r2.badges;
            if (r4 == null) goto L12;
            Iterator r5 = r4.iterator();
        L8:
            if (r5.hasNext() == false) goto L13;
            r3.h(new st0.a((ActivityBadges.NewProfileBadge) r5.next()));
            goto L8
        L13:
            return;
        L12:
            return;
        }

        public static void b(final NewProfileUser r4, DataAssembler r5) {
            Intrinsics.checkNotNullParameter(r4, "user");
            Intrinsics.checkNotNullParameter(r5, "assembler");
            r5.i(new st0.e(8, s1.B(2131919748), true), new ProfileHonourWallComponent$Companion$configCommonProfileCard$1(r4));
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.OldHonourWall.INSTANCE;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileHonourWallComponent update");
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler
    public final View k(com.bytedance.android.live.profile.ui.component.base.b r7, NewProfileUser r8) {
        st0.e r9 = (st0.e) r7;
        Intrinsics.checkNotNullParameter(r9, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r8, "user");
        int r10 = r9.getType();
        int r2 = 0;
        boolean r3 = true;
        if (r10 != 0) goto L5;
        int r12 = com.bytedance.android.live.profile.ui.util.t.a;
        Intrinsics.checkNotNullParameter(r8, "user");
        HonorWallUi r13 = r8.honorWallUi;
        if (r13 == null) goto L54;
        Map r14 = r13.bgs;
        if (r14 == null) goto L54;
        HonorWallUi.HonorWallBg r15 = (HonorWallUi.HonorWallBg) r14.get(1);
    L55:
        if (r15 != null) goto L58;
        r3 = false;
    L58:
        if (r3 == false) goto L64;
        View r16 = new ProfileLevelCardView(this.f.getContext(), null, 6, 0);
    L61:
        return r16;
    L64:
        return null;
    L54:
        r15 = null;
        goto L55
    L5:
        if (r10 == 1) goto L38;
        if (r10 == 2) goto L23;
        if (r10 == 3) goto L20;
        if (r10 != 4) goto L12;
        throw null;
    L12:
        if (r10 != 5) goto L14;
        throw null;
    L14:
        if (r10 != 8) goto L65;
        throw null;
    L65:
        return null;
    L20:
        if (this.f.getChildCount() >= 6) goto L62;
        r16 = new ProfileHonourActivityBadgeView(this.f.getContext(), null, 6, 0);
        goto L61
    L62:
        return null;
    L23:
        if (com.bytedance.android.livesdk.chatroom.utils.q.a() == false) goto L66;
        GiftExhibitionHomeStats r17 = r8.giftExhibitionInfo;
        if (r17 == null) goto L28;
        int r18 = r17.unlightedNum;
    L29:
        if (r18 > 0) goto L33;
        if (r17 == null) goto L32;
        r2 = r17.lightedNum;
    L32:
        if (r2 > 0) goto L33;
        return null;
    L33:
        qs0.u r19 = os0.b.c().getIPkAudienceLinkOutServiceProxy();
        if (r19 == null) goto L36;
        r19.getPkLinkUserInfoCenter();
    L36:
        os0.b.c().getIInteractService().getLinkUserInfoCenter();
        new HashMap().put("card_type", "old");
        throw null;
    L28:
        r18 = 0;
        goto L29
    L66:
        return null;
    L38:
        int r20 = com.bytedance.android.live.profile.ui.util.t.a;
        Intrinsics.checkNotNullParameter(r8, "user");
        HonorWallUi r22 = r8.honorWallUi;
        if (r22 == null) goto L43;
        Map r23 = r22.bgs;
        if (r23 == null) goto L43;
        HonorWallUi.HonorWallBg r24 = (HonorWallUi.HonorWallBg) r23.get(2);
    L44:
        if (r24 == null) goto L46;
        r2 = 1;
    L46:
        if (r2 == 0) goto L67;
        throw null;
    L67:
        return null;
    L43:
        r24 = null;
        goto L44
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler
    public final ViewGroup.LayoutParams l(int r1, com.bytedance.android.live.profile.ui.component.base.b r2) {
        Intrinsics.checkNotNullParameter((st0.e) r2, Constants.Keys.DATA);
        throw null;
    }
}
