package com.bytedance.android.live.profile.ui;

import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.SubscribeInfo;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.NewLiveProfileDialogFragment;
import com.bytedance.android.live.profile.standard.honour.ProfileStandardHonourWallComponent;
import com.bytedance.android.live.profile.ui.base.BaseUiBehavior;
import com.bytedance.android.live.profile.ui.component.ProfileTextInfoComponent;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.android.live.profile.ui.component.y;
import com.bytedance.android.live.profile.ui.util.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rs0.u0;
import st0.e;
import st0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AudienceSeeSelfBehavior extends BaseUiBehavior {
    public AudienceSeeSelfBehavior(NewLiveProfileDialogFragment r2, com.bytedance.android.live.profile.model.d r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "type");
        super(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> d(DataAssembler<st0.b> r27, final NewProfileUser r28) {
        Intrinsics.checkNotNullParameter(r27, "component");
        Intrinsics.checkNotNullParameter(r28, "user");
        final boolean r3 = this.i.isMyLive();
        r27.i(new st0.b(-1, "", 0, 0, 0, false, 56), new AudienceSeeSelfBehavior$configButtonAreaComponent$1(r28, r3));
        r27.i(new st0.b(11, "", 0, 0, 0, false, 56), new AudienceSeeSelfBehavior$configButtonAreaComponent$2(r28, r3));
        r27.i(new st0.b(12, " 我的权益", 0, 2131251276, 0, false, 48), new AudienceSeeSelfBehavior$configButtonAreaComponent$3(r3));
        r27.i(new st0.b(13, "去开播", UtilityKotlinExtentionsKt.i(68), 0, 0, false, 56), new AudienceSeeSelfBehavior$configButtonAreaComponent$4(r3));
        ot0.b r2 = new ot0.b(this.k, this.a);
        Intrinsics.checkNotNullParameter(r2, "listener");
        r27.c = r2;
        return r27;
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler e(ProfileStandardHonourWallComponent r6, final NewProfileUser r7) {
        Intrinsics.checkNotNullParameter(r6, "component");
        Intrinsics.checkNotNullParameter(r7, "user");
        r6.h(new e(0, s1.B(2131919749), true));
        SubscribeInfo r1 = r7.subscribeInfo;
        if (r1 == null) goto L5;
        boolean r2 = r1.isMember;
    L6:
        r6.i(new st0.d(true, false, r2, 2), new q(r7));
        r6.h(new e(2, s1.B(2131919747), true));
        DressSuitInfo r3 = r7.getDressSuitInfo();
        if (r3 == null) goto L10;
        String r4 = r3.getName();
        if (r4 == null) goto L10;
    L11:
        r6.i(new e(5, r4, true), new AudienceSeeSelfBehavior$configHonourComponent$1(r7));
        ot0.a r0 = new ot0.a(this.k, this.a);
        Intrinsics.checkNotNullParameter(r0, "listener");
        r6.c = r0;
        Function1<DataAssembler<e>, Unit> r5 = new AudienceSeeSelfBehavior$configHonourComponent$2(r7);
        Intrinsics.checkNotNullParameter(r5, "action");
        r5.invoke(r6);
        return r6;
    L10:
        r4 = "装扮";
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> f(ProfileTextInfoComponent r3, NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, "component");
        Intrinsics.checkNotNullParameter(r4, "user");
        super.f(r3, r4);
        r3.i(new g(5), new AudienceSeeSelfBehavior$configInfoComponent$1(this));
        ot0.c r5 = new ot0.c(this.k, this.i);
        Intrinsics.checkNotNullParameter(r5, "listener");
        r3.c = r5;
        return r3;
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final y h(y r3, NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, "component");
        Intrinsics.checkNotNullParameter(r4, "user");
        if (((Boolean) u0.a.getValue()).booleanValue() == false) goto L5;
        return null;
    L5:
        int r1 = y.g;
        String r5 = y.a.b(r4);
        if (r5 != null) goto L8;
        r5 = s1.B(2131920697);
    L8:
        r3.h(new g(2, r5));
        return r3;
    }
}
