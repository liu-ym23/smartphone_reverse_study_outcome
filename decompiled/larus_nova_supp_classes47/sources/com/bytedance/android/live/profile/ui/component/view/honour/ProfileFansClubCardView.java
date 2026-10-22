package com.bytedance.android.live.profile.ui.component.view.honour;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileFansClub;
import com.bytedance.android.live.base.model.user.ProfileFansClubData;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.SubscribeInfo;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import st0.d;
import st0.e;
import tt0.a;
import tt0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/honour/ProfileFansClubCardView;", "Lcom/bytedance/android/live/profile/ui/component/view/ProfileHonourCardView;", "", "getWallBgUiIndex", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileFansClubCardView extends ProfileHonourCardView {
    public b f;
    public int g;

    public ProfileFansClubCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileFansClubCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public int getWallBgUiIndex() {
        return this.g;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public final void b(e r5, NewProfileUser r6) {
        Intrinsics.checkNotNullParameter(r5, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r6, "user");
        o r0 = os0.b.a();
        boolean r1 = false;
        if (r0 == null) goto L11;
        m r2 = r0.getRoom();
        if (r2 == null) goto L11;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L11;
        IRoomAuthStatus r4 = r3.getRoomAuthStatus();
        if (r4 == null) goto L11;
        boolean r7 = r4.isShopFansClubMode();
    L12:
        if (r7 == false) goto L14;
        this.g = 6;
    L14:
        super.b(r5, r6);
        if ((r5 instanceof d) == true) goto L17;
        return;
    L17:
        b r8 = new b(getContainer());
        this.f = r8;
        if (((d) r5).d == false) goto L22;
        if (r7 == false) goto L21;
        r8.a(r6.shopFansClub);
        return;
    L21:
        r8.a(r6.fansClub);
        return;
    L22:
        String r9 = null;
        if (r7 == false) goto L37;
        ProfileFansClub r10 = r6.shopFansClub;
        if (r10 == null) goto L31;
        ProfileFansClubData r12 = r10.getData();
        if (r12 == null) goto L31;
        ProfileFansClubData.ProfileUserBadge r13 = r12.badge;
        if (r13 == null) goto L31;
        k r14 = r13.getToShowShopFansClubIcon();
    L32:
        ProfileFansClub r15 = r6.shopFansClub;
        if (r15 == null) goto L50;
        ProfileFansClubData r16 = r15.getData();
        if (r16 == null) goto L50;
        r9 = r16.clubName;
    L50:
        b r17 = this.f;
        if (r17 == null) goto L72;
        SubscribeInfo r18 = r6.subscribeInfo;
        if (r18 == null) goto L55;
        r1 = r18.isMember;
    L55:
        if (r14 != null) goto L66;
        if (r1 == false) goto L60;
        TextView r19 = r17.d;
        if (r19 == null) goto L63;
        UtilityKotlinExtentionsKt.w(r19);
    L63:
        View r20 = r17.a;
        if (r20 == null) goto L73;
        UtilityKotlinExtentionsKt.u(r20);
        return;
    L73:
        return;
    L60:
        TextView r22 = r17.c;
        if (r22 == null) goto L63;
        UtilityKotlinExtentionsKt.w(r22);
        goto L63
    L66:
        View r23 = r17.a;
        if (r23 == null) goto L75;
        r23.post(new a(r17, r14, r9));
        return;
    L75:
        return;
    L72:
        return;
    L31:
        r14 = null;
        goto L32
    L37:
        ProfileFansClub r24 = r6.fansClub;
        if (r24 == null) goto L44;
        ProfileFansClubData r25 = r24.getData();
        if (r25 == null) goto L44;
        ProfileFansClubData.ProfileUserBadge r26 = r25.badge;
        if (r26 == null) goto L44;
        r14 = r26.getToShowIcon();
    L45:
        ProfileFansClub r27 = r6.fansClub;
        if (r27 == null) goto L50;
        ProfileFansClubData r28 = r27.getData();
        if (r28 == null) goto L50;
        r9 = r28.clubName;
    L44:
        r14 = null;
    L11:
        r7 = false;
        goto L12
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void c(e r1, NewProfileUser r2) {
        b(r1, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void d(e r1, ProfileSkin r2) {
        f(r1, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public final void f(e r2, ProfileSkin r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "skin");
        ProfileCustomSkin r4 = r3.skin;
        if (r4 == null) goto L10;
        ProfileCustomSkin.HonorWallUI r5 = r4.honorWallSkin;
        if (r5 == null) goto L11;
        String r6 = r5.titleColor;
        String r7 = r5.contentColor;
        int r0 = com.bytedance.android.live.profile.ui.util.m.a;
        com.bytedance.android.live.profile.ui.util.m.e(getTitleView(), r6);
        com.bytedance.android.live.profile.ui.util.m.e(getArrowIcon(), r6);
        b r8 = this.f;
        if (r8 == null) goto L12;
        Intrinsics.checkNotNullParameter(r7, "color");
        com.bytedance.android.live.profile.ui.util.m.e(r8.c, r7);
        com.bytedance.android.live.profile.ui.util.m.e(r8.d, r7);
        com.bytedance.android.live.profile.ui.util.m.e(r8.e, r7);
        return;
    L12:
        return;
    L11:
        return;
    }

    public ProfileFansClubCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.g = 2;
    }

    public /* synthetic */ ProfileFansClubCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
