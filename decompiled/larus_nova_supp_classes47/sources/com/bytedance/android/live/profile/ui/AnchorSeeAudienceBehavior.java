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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import st0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AnchorSeeAudienceBehavior extends BaseUiBehavior {
    public static final /* synthetic */ int n = 0;

    public AnchorSeeAudienceBehavior(NewLiveProfileDialogFragment r2, com.bytedance.android.live.profile.model.d r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "type");
        super(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> d(DataAssembler<st0.b> r33, final NewProfileUser r34) {
        Intrinsics.checkNotNullParameter(r33, "component");
        Intrinsics.checkNotNullParameter(r34, "user");
        if (this.a.showSquareButtonArea() == false) goto L6;
        r33.h(new st0.b(0, s1.B(2131919553), 0, 0, 0, false, 56));
        r33.h(new st0.b(3, null, 0, 2131251370, 0, true, 22));
        ot0.b r2 = new ot0.b(this.k, this.a);
        Intrinsics.checkNotNullParameter(r2, "listener");
        r33.c = r2;
        return r33;
    L6:
        r33.h(new st0.b(0, s1.B(2131919553), 0, 0, 0, false, 56));
        r33.i(new st0.b(8, s1.B(2131919730), UtilityKotlinExtentionsKt.i(82), 0, 0, false, 56), new AnchorSeeAudienceBehavior$configButtonAreaComponent$1(r34));
        r33.i(new st0.b(14, s1.B(2131916267), 0, 0, 0, false, 56), new AnchorSeeAudienceBehavior$configButtonAreaComponent$2(this));
        r33.h(new st0.b(4, s1.B(2131919732), UtilityKotlinExtentionsKt.i(52), 0, 0, false, 56));
        ot0.b r3 = new ot0.b(this.k, this.a);
        Intrinsics.checkNotNullParameter(r3, "listener");
        r33.c = r3;
        return r33;
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
        r5.i(new e(5, r4, true), new AnchorSeeAudienceBehavior$configHonourComponent$1(r6));
        ot0.a r0 = new ot0.a(this.k, this.a);
        Intrinsics.checkNotNullParameter(r0, "listener");
        r5.c = r0;
        Function1<DataAssembler<e>, Unit> r7 = new AnchorSeeAudienceBehavior$configHonourComponent$2(r6);
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
