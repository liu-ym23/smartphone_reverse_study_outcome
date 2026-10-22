package com.bytedance.android.live.profile.ui;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.NewLiveProfileDialogFragment;
import com.bytedance.android.live.profile.standard.honour.ProfileStandardHonourWallComponent;
import com.bytedance.android.live.profile.ui.base.BaseUiBehavior;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import st0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MediaLiveRoomBehavior extends BaseUiBehavior {
    public static final /* synthetic */ int n = 0;

    public MediaLiveRoomBehavior(NewLiveProfileDialogFragment r2, com.bytedance.android.live.profile.model.d r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "type");
        super(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> d(DataAssembler<st0.b> r24, NewProfileUser r25) {
        Intrinsics.checkNotNullParameter(r24, "component");
        Intrinsics.checkNotNullParameter(r25, "user");
        if (this.c != 2) goto L6;
        return null;
    L6:
        r24.h(new st0.b(0, s1.B(2131919553), 0, 0, 0, false, 56));
        r24.i(new st0.b(14, s1.B(2131916267), 0, 0, 0, false, 56), new MediaLiveRoomBehavior$configButtonAreaComponent$1(this));
        r24.i(new st0.b(2, null, 0, 2131251368, 0, true, 22), new MediaLiveRoomBehavior$configButtonAreaComponent$2(this));
        if (this.a.canManage() == true) goto L9;
    L11:
        st0.b r2 = new st0.b(3, null, 0, 2131251370, 0, true, 22);
    L12:
        r24.h(r2);
        ot0.b r3 = new ot0.b(this.k, this.a);
        Intrinsics.checkNotNullParameter(r3, "listener");
        r24.c = r3;
        return r24;
    L9:
        if (this.c == 1) goto L11;
        r2 = new st0.b(4, s1.B(2131919759), UtilityKotlinExtentionsKt.i(52), 0, 0, false, 56);
        goto L12
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler e(ProfileStandardHonourWallComponent r2, final NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(r3, "user");
        Function1<DataAssembler<e>, Unit> r0 = new MediaLiveRoomBehavior$configHonourComponent$1(r3);
        Intrinsics.checkNotNullParameter(r0, "action");
        r0.invoke(r2);
        return r2;
    }
}
