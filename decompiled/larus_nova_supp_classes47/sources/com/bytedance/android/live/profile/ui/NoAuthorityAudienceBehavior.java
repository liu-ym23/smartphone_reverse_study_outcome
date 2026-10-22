package com.bytedance.android.live.profile.ui;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.NewLiveProfileDialogFragment;
import com.bytedance.android.live.profile.standard.honour.ProfileStandardHonourWallComponent;
import com.bytedance.android.live.profile.standard.tag.ProfileStandardTagListComponent;
import com.bytedance.android.live.profile.ui.base.BaseUiBehavior;
import com.bytedance.android.live.profile.ui.component.ProfileTextInfoComponent;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.android.live.profile.ui.component.y;
import kotlin.jvm.internal.Intrinsics;
import rs0.u0;
import st0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class NoAuthorityAudienceBehavior extends BaseUiBehavior {
    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler e(ProfileStandardHonourWallComponent r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(r3, "user");
        return null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> f(ProfileTextInfoComponent r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(r3, "user");
        return null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler g(ProfileStandardTagListComponent r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(r3, "user");
        return null;
    }

    public NoAuthorityAudienceBehavior(NewLiveProfileDialogFragment r2, com.bytedance.android.live.profile.model.d r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "type");
        super(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> d(DataAssembler<st0.b> r24, NewProfileUser r25) {
        Intrinsics.checkNotNullParameter(r24, "component");
        Intrinsics.checkNotNullParameter(r25, "user");
        r24.h(new st0.b(-1, "", 0, 0, 0, false, 56));
        r24.i(new st0.b(9, s1.B(2131919753), UtilityKotlinExtentionsKt.i(56), 0, 0, false, 56), new NoAuthorityAudienceBehavior$configButtonAreaComponent$1(this));
        r24.i(new st0.b(5, s1.B(2131919770), UtilityKotlinExtentionsKt.i(56), 0, 0, false, 56), new NoAuthorityAudienceBehavior$configButtonAreaComponent$2(this));
        r24.h(new st0.b(3, null, 0, 2131251370, 0, true, 22));
        ot0.b r2 = new ot0.b(this.k, this.a);
        Intrinsics.checkNotNullParameter(r2, "listener");
        r24.c = r2;
        return r24;
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final y h(y r3, NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, "component");
        Intrinsics.checkNotNullParameter(r4, "user");
        if (((Boolean) u0.a.getValue()).booleanValue() == false) goto L6;
        return null;
    L6:
        r3.h(new g(2, this.k.getResources().getString(2131915014)));
        return r3;
    }
}
