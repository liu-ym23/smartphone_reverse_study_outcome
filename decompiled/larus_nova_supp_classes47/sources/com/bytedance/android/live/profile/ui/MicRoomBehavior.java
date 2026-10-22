package com.bytedance.android.live.profile.ui;

import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.NewLiveProfileDialogFragment;
import com.bytedance.android.live.profile.ui.base.BaseUiBehavior;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.android.live.profile.ui.component.y;
import kotlin.jvm.internal.Intrinsics;
import rs0.u0;
import st0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MicRoomBehavior extends BaseUiBehavior {
    public static final /* synthetic */ int n = 0;

    public MicRoomBehavior(NewLiveProfileDialogFragment r2, com.bytedance.android.live.profile.model.d r3) {
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
        r24.i(new st0.b(14, s1.B(2131916267), 0, 0, 0, false, 56), new MicRoomBehavior$configButtonAreaComponent$1(this));
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
        if (((Boolean) u0.a.getValue()).booleanValue() == false) goto L5;
        return null;
    L5:
        BaseProfileInfo r5 = r4.baseProfileInfo;
        if (r5 == null) goto L9;
        String r6 = r5.signature;
        if (r6 == null) goto L9;
    L10:
        r3.h(new g(4, r6));
        return r3;
    L9:
        r6 = "";
        goto L10
    }
}
