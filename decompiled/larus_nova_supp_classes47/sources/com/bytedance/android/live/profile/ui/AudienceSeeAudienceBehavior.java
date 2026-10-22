package com.bytedance.android.live.profile.ui;

import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.SubscribeInfo;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.NewLiveProfileDialogFragment;
import com.bytedance.android.live.profile.standard.honour.ProfileStandardHonourWallComponent;
import com.bytedance.android.live.profile.ui.base.BaseUiBehavior;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.android.live.profile.ui.util.q;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.message.model.vh;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import st0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AudienceSeeAudienceBehavior extends BaseUiBehavior {
    public static final /* synthetic */ int n = 0;

    public AudienceSeeAudienceBehavior(NewLiveProfileDialogFragment r2, com.bytedance.android.live.profile.model.d r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "type");
        super(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> d(DataAssembler<st0.b> r24, NewProfileUser r25) {
        Intrinsics.checkNotNullParameter(r24, "component");
        Intrinsics.checkNotNullParameter(r25, "user");
        if (this.a.showSquareButtonArea() == true) goto L5;
        r24.h(new st0.b(0, s1.B(2131919553), 0, 0, 0, false, 56));
        r24.i(new st0.b(14, s1.B(2131916267), 0, 0, 0, false, 56), new AudienceSeeAudienceBehavior$configButtonAreaComponent$1(this));
        if (this.a.needShowFansGroupIcon() == false) goto L19;
        st0.b r2 = new st0.b(1, null, 0, 0, 0, false, 62);
    L20:
        r24.h(r2);
        if (this.a.canManage() == false) goto L23;
        st0.b r3 = new st0.b(4, s1.B(2131919759), UtilityKotlinExtentionsKt.i(52), 0, 0, false, 56);
    L24:
        r24.h(r3);
        ot0.b r4 = new ot0.b(this.k, this.a);
        Intrinsics.checkNotNullParameter(r4, "listener");
        r24.c = r4;
        return r24;
    L23:
        r3 = new st0.b(3, null, 0, 2131251370, 0, true, 22);
        goto L24
    L19:
        r2 = new st0.b(2, null, 0, 2131251368, 0, true, 22);
        goto L20
    L5:
        if (this.a.shouldShowJumpButton() == false) goto L14;
        UserProfileEvent r5 = this.a.getUserProfileEvent();
        if (r5 == null) goto L12;
        vh r6 = r5.originRoomInfo;
        if (r6 == null) goto L12;
        String r7 = r6.b();
        if (r7 == null) goto L12;
    L13:
        r24.h(new st0.b(17, r7, 0, 0, 2131251371, false, 40));
        r24.h(new st0.b(7, s1.B(2131919553), UtilityKotlinExtentionsKt.i(60), 2131251369, 0, false, 48));
        r24.h(new st0.b(3, null, 0, 2131251370, 0, true, 22));
        ot0.b r8 = new ot0.b(this.k, this.a);
        Intrinsics.checkNotNullParameter(r8, "listener");
        r24.c = r8;
    L15:
        return r24;
    L12:
        r7 = "";
        goto L13
    L14:
        r24.h(new st0.b(0, s1.B(2131919553), 0, 0, 0, false, 56));
        r24.h(new st0.b(3, null, 0, 2131251370, 0, true, 22));
        ot0.b r9 = new ot0.b(this.k, this.a);
        Intrinsics.checkNotNullParameter(r9, "listener");
        r24.c = r9;
        goto L15
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler e(ProfileStandardHonourWallComponent r5, final NewProfileUser r6) {
        Intrinsics.checkNotNullParameter(r5, "component");
        Intrinsics.checkNotNullParameter(r6, "user");
        r5.h(new e(0, s1.B(2131919749), 4));
        SubscribeInfo r1 = r6.subscribeInfo;
        if (r1 == null) goto L5;
        boolean r2 = r1.isMember;
    L6:
        r5.i(new st0.d(false, false, r2, 3), new q(r6));
        r5.h(new e(2, s1.B(2131919747), true));
        DressSuitInfo r3 = r6.getDressSuitInfo();
        if (r3 == null) goto L10;
        String r4 = r3.getName();
        if (r4 == null) goto L10;
    L11:
        r5.i(new e(5, r4, true), new AudienceSeeAudienceBehavior$configHonourComponent$1(r6));
        ot0.a r0 = new ot0.a(this.k, this.a);
        Intrinsics.checkNotNullParameter(r0, "listener");
        r5.c = r0;
        Function1<DataAssembler<e>, Unit> r7 = new AudienceSeeAudienceBehavior$configHonourComponent$2(r6);
        Intrinsics.checkNotNullParameter(r7, "action");
        r7.invoke(r5);
        return r5;
    L10:
        r4 = "装扮";
        goto L11
    L5:
        r2 = false;
        goto L6
    }
}
