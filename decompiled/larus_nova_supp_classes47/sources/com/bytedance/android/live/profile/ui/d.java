package com.bytedance.android.live.profile.ui;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.NewLiveProfileDialogFragment;
import com.bytedance.android.live.profile.standard.tag.ProfileStandardTagListComponent;
import com.bytedance.android.live.profile.ui.base.BaseUiBehavior;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import kotlin.jvm.internal.Intrinsics;
import st0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends BaseUiBehavior {
    public d(NewLiveProfileDialogFragment r2, com.bytedance.android.live.profile.model.d r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "type");
        super(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> d(DataAssembler<st0.b> r22, NewProfileUser r23) {
        Intrinsics.checkNotNullParameter(r22, "component");
        Intrinsics.checkNotNullParameter(r23, "user");
        if (this.c != 2) goto L6;
        return null;
    L6:
        r22.h(new st0.b(0, s1.B(2131919553), 0, 0, 0, false, 56));
        if (this.a.canManage() == true) goto L11;
        if (this.b == 1) goto L11;
    L13:
        st0.b r2 = new st0.b(3, null, 0, 2131251370, 0, true, 22);
    L14:
        r22.h(r2);
        ot0.b r3 = new ot0.b(this.k, this.a);
        Intrinsics.checkNotNullParameter(r3, "listener");
        r22.c = r3;
        return r22;
    L11:
        if (this.c == 1) goto L13;
        r2 = new st0.b(4, s1.B(2131919759), UtilityKotlinExtentionsKt.i(52), 0, 0, false, 56);
        goto L14
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler g(ProfileStandardTagListComponent r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(r3, "user");
        r2.h(new f(0));
        r2.h(new f(3));
        r2.h(new f(4));
        r2.h(new f(5));
        return r2;
    }
}
