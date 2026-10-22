package et0;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileFansClub;
import com.bytedance.android.live.base.model.user.ProfileFansClubData;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.base.model.user.SubscribeInfo;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.c1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.base.i;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.livesdk.common.LiveViewStub;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements bt0.b {
    public h a;
    public View b;
    public TextView c;
    public TextView d;
    public TextView e;
    public View f;
    public TextView g;
    public TextView h;

    public b() {
    }

    @Override // bt0.b
    public final void f() {
    }

    @Override // bt0.b
    public final void onViewShow() {
    }

    @Override // bt0.b
    public final void g() {
        h r0 = this.a;
        if (r0 == null) goto L16;
        NewProfileUser r1 = r0.getTargetUser();
        if (r1 == null) goto L17;
        ProfileSkin r2 = r1.mProfileSkin;
        if (r2 == null) goto L18;
        ProfileCustomSkin r3 = r2.skin;
        if (r3 == null) goto L19;
        ProfileCustomSkin.HonorWallUI r4 = r3.honorWallSkin;
        if (r4 == null) goto L20;
        String r5 = r4.contentColor;
        if (r5 == null) goto L21;
        int r6 = m.a;
        m.e(this.d, r5);
        m.e(this.e, r5);
        m.e(this.f, r5);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // bt0.b
    public final void p(LiveViewStub r5) {
        Intrinsics.checkNotNullParameter(r5, "container");
        TextView r2 = null;
        View r0 = LayoutInflater.from(r5.getContext()).inflate(2131567791, null, false);
        if (r0 != null) goto L5;
        return;
    L5:
        r5.a(r0);
        this.b = r0.findViewById(2131383264);
        this.d = (TextView) r0.findViewById(2131383267);
        this.e = (TextView) r0.findViewById(2131383268);
        View r6 = this.b;
        if (r6 == null) goto L8;
        r2 = (TextView) r6.findViewById(2131383265);
    L8:
        this.c = r2;
        this.f = r0.findViewById(2131383210);
        this.g = (TextView) r0.findViewById(2131383209);
        this.h = (TextView) r0.findViewById(2131383211);
    }

    @Override // com.bytedance.android.live.profile.profilecontext.c
    public final void setProfileContext(h r1) {
        this.a = r1;
    }

    @Override // bt0.b
    public final void h(ProfileText r12, HonorWallElement r13, NewProfileUser r14, h r15) {
        Intrinsics.checkNotNullParameter(r13, "elementInfo");
        Intrinsics.checkNotNullParameter(r14, "profileUser");
        Intrinsics.checkNotNullParameter(r15, "profileContext");
        c.g.getClass();
        Intrinsics.checkNotNullParameter(r13, "element");
        Intrinsics.checkNotNullParameter(r14, "user");
        Intrinsics.checkNotNullParameter(r15, "profileContext");
        int r16 = r13.getId();
        k r2 = null;
        if (r16 != HonorWallElement.TYPE_FANS_CLUB) goto L34;
        int r4 = HonorWallElement.TYPE_FANS_CLUB;
        if (i.k(r15) == false) goto L9;
        if (i.m(r15) == false) goto L9;
    L12:
        boolean r5 = true;
    L14:
        ProfileFansClub r6 = r14.fansClub;
        if (r6 == null) goto L19;
        ProfileFansClubData r17 = r6.getData();
        if (r17 == null) goto L19;
        String r7 = r17.clubName;
    L20:
        ProfileFansClub r18 = r14.fansClub;
        if (r18 == null) goto L27;
        ProfileFansClubData r19 = r18.getData();
        if (r19 == null) goto L27;
        ProfileFansClubData.ProfileUserBadge r110 = r19.badge;
        if (r110 == null) goto L27;
        r2 = r110.getToShowIcon();
    L27:
        k r8 = r2;
        SubscribeInfo r111 = r14.subscribeInfo;
        if (r111 == null) goto L30;
        boolean r9 = r111.isMember;
    L31:
        k r112 = new c(r4, r5, r6, r7, r8, r9);
    L32:
        r2 = r112;
    L63:
        if (r2 != null) goto L66;
        return;
    L66:
        if (r2.b == false) goto L97;
        ProfileFansClub r113 = r2.c;
        View r114 = this.f;
        if (r114 == null) goto L70;
        UtilityKotlinExtentionsKt.w(r114);
    L70:
        int r115 = m.a;
        m.a(this.g);
        if (r113 != null) goto L73;
        Pair r116 = c1.b(0);
    L78:
        TextView r117 = this.g;
        if (r117 == null) goto L81;
        r117.setText(((String) r116.first).toString());
    L81:
        TextView r118 = this.h;
        if (r118 == null) goto L113;
        Object[] r119 = new Object[1];
        String r120 = (String) r116.second;
        if (r120 != null) goto L87;
        r120 = "";
    L87:
        r119[0] = r120;
        r118.setText(s1.C(2131920685, r119));
        return;
    L113:
        return;
    L73:
        String r121 = r113.fansCountStr;
        if (r121 == null) goto L76;
    L88:
        if (r121 == null) goto L92;
        TextView r122 = this.g;
        if (r122 == null) goto L92;
        r122.setText(r121);
    L92:
        String r123 = r113.fansCountSubStr;
        if (r123 == null) goto L115;
        TextView r124 = this.h;
        if (r124 == null) goto L116;
        r124.setText(r123);
        return;
    L116:
        return;
    L115:
        return;
    L76:
        if (r113.fansCountSubStr != null) goto L88;
        r116 = c1.b(r113.totalFansCount);
        goto L78
    L97:
        k r125 = r2.e;
        String r126 = r2.d;
        boolean r127 = r2.f;
        if (r125 != null) goto L109;
        if (r127 == false) goto L103;
        TextView r128 = this.e;
        if (r128 == null) goto L106;
        UtilityKotlinExtentionsKt.w(r128);
    L106:
        View r129 = this.b;
        if (r129 == null) goto L118;
        UtilityKotlinExtentionsKt.u(r129);
        return;
    L118:
        return;
    L103:
        TextView r130 = this.d;
        if (r130 == null) goto L106;
        UtilityKotlinExtentionsKt.w(r130);
        goto L106
    L109:
        View r131 = this.b;
        if (r131 == null) goto L120;
        r131.post(new a(this, r125, r126));
        return;
    L120:
        return;
    L30:
        r9 = false;
    L19:
        r7 = null;
    L9:
        if (i.k(r15) == false) goto L11;
    L13:
        r5 = false;
        goto L14
    L11:
        if (i.l(r15) == false) goto L13;
    L34:
        if (r16 != HonorWallElement.TYPE_SHOP_FANS_CLUB) goto L63;
        int r10 = HonorWallElement.TYPE_SHOP_FANS_CLUB;
        if (i.k(r15) == false) goto L40;
        if (i.m(r15) == false) goto L40;
    L43:
        boolean r20 = true;
    L45:
        ProfileFansClub r22 = r14.shopFansClub;
        if (r22 == null) goto L50;
        ProfileFansClubData r132 = r22.getData();
        if (r132 == null) goto L50;
        String r23 = r132.clubName;
    L51:
        ProfileFansClub r133 = r14.shopFansClub;
        if (r133 == null) goto L58;
        ProfileFansClubData r134 = r133.getData();
        if (r134 == null) goto L58;
        ProfileFansClubData.ProfileUserBadge r135 = r134.badge;
        if (r135 == null) goto L58;
        r2 = r135.getToShowShopFansClubIcon();
    L58:
        k r24 = r2;
        SubscribeInfo r136 = r14.subscribeInfo;
        if (r136 == null) goto L61;
        boolean r25 = r136.isMember;
    L62:
        r112 = new c(r10, r20, r22, r23, r24, r25);
        goto L32
    L61:
        r25 = false;
    L50:
        r23 = null;
    L40:
        if (i.k(r15) == false) goto L42;
    L44:
        r20 = false;
        goto L45
    L42:
        if (i.l(r15) == false) goto L44;
        goto L43
    }

    @Override // bt0.b
    public void update(ProfileText r2, HonorWallElement r3, NewProfileUser r4, h r5) {
        Intrinsics.checkNotNullParameter(r3, "elementInfo");
        Intrinsics.checkNotNullParameter(r4, "profileUser");
        Intrinsics.checkNotNullParameter(r5, "profileContext");
        View r0 = this.f;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r0);
    L5:
        TextView r1 = this.d;
        if (r1 == null) goto L8;
        UtilityKotlinExtentionsKt.u(r1);
    L8:
        TextView r6 = this.e;
        if (r6 == null) goto L11;
        UtilityKotlinExtentionsKt.u(r6);
    L11:
        View r7 = this.b;
        if (r7 == null) goto L14;
        UtilityKotlinExtentionsKt.w(r7);
    L14:
        h(r2, r3, r4, r5);
        int r8 = m.a;
        m.g(CollectionsKt.listOf(new View[]{this.d, this.e, this.f}), s1.h(2131107936));
        g();
    }
}
