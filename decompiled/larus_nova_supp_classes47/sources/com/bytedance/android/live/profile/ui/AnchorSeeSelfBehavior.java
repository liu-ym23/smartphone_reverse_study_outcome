package com.bytedance.android.live.profile.ui;

import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
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
public final class AnchorSeeSelfBehavior extends BaseUiBehavior {
    public static final /* synthetic */ int n = 0;

    public AnchorSeeSelfBehavior(NewLiveProfileDialogFragment r2, com.bytedance.android.live.profile.model.d r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "type");
        super(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> d(DataAssembler<st0.b> r23, final NewProfileUser r24) {
        Intrinsics.checkNotNullParameter(r23, "component");
        Intrinsics.checkNotNullParameter(r24, "user");
        r23.i(new st0.b(-1, "", 0, 0, 0, false, 56), new AnchorSeeSelfBehavior$configButtonAreaComponent$1(r24));
        r23.i(new st0.b(11, "", 0, 0, 0, false, 56), new AnchorSeeSelfBehavior$configButtonAreaComponent$2(r24));
        r23.i(new st0.b(15, " 建群", 0, 2131252672, 0, false, 48), new AnchorSeeSelfBehavior$configButtonAreaComponent$3(r24));
        r23.i(new st0.b(16, " 群管理", 0, 2131252672, 0, false, 48), new AnchorSeeSelfBehavior$configButtonAreaComponent$4(r24));
        r23.i(new st0.b(10, null, 0, 2131252675, 0, true, 22), new AnchorSeeSelfBehavior$configButtonAreaComponent$5(this, r24));
        ot0.b r2 = new ot0.b(this.k, this.a);
        Intrinsics.checkNotNullParameter(r2, "listener");
        r23.c = r2;
        return r23;
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler e(ProfileStandardHonourWallComponent r6, final NewProfileUser r7) {
        Intrinsics.checkNotNullParameter(r6, "component");
        Intrinsics.checkNotNullParameter(r7, "user");
        r6.h(new e(0, s1.B(2131919749), true));
        r6.i(new st0.d(true, true, false, 4), new q(r7));
        r6.h(new e(2, s1.B(2131919747), true));
        r6.i(new e(4, s1.B(2131919776), true), new AnchorSeeSelfBehavior$configHonourComponent$1(r7));
        DressSuitInfo r1 = r7.getDressSuitInfo();
        if (r1 == null) goto L6;
        String r2 = r1.getName();
        if (r2 == null) goto L6;
    L7:
        r6.i(new e(5, r2, true), new AnchorSeeSelfBehavior$configHonourComponent$2(r7));
        ot0.a r0 = new ot0.a(this.k, this.a);
        Intrinsics.checkNotNullParameter(r0, "listener");
        r6.c = r0;
        Function1<DataAssembler<e>, Unit> r3 = new AnchorSeeSelfBehavior$configHonourComponent$3(r7);
        Intrinsics.checkNotNullParameter(r3, "action");
        r3.invoke(r6);
        return r6;
    L6:
        r2 = "装扮";
        goto L7
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> f(ProfileTextInfoComponent r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(r3, "user");
        super.f(r2, r3);
        return r2;
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final y h(y r6, NewProfileUser r7) {
        Intrinsics.checkNotNullParameter(r6, "component");
        Intrinsics.checkNotNullParameter(r7, "user");
        String r2 = "";
        if (((Boolean) u0.a.getValue()).booleanValue() == false) goto L9;
        int r3 = y.g;
        String r8 = y.a.a(r7);
        if (r8 == null) goto L8;
        r2 = r8;
    L8:
        r6.h(new g(3, r2));
    L17:
        return r6;
    L9:
        int r4 = y.g;
        String r5 = y.a.b(r7);
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        r6.h(new g(2, r5));
        String r9 = y.a.a(r7);
        if (r9 == null) goto L16;
        r2 = r9;
    L16:
        r6.h(new g(3, r2));
        goto L17
    }
}
