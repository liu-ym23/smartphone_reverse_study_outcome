package com.bytedance.android.live.profile.ui;

import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.NewLiveProfileDialogFragment;
import com.bytedance.android.live.profile.standard.honour.ProfileStandardHonourWallComponent;
import com.bytedance.android.live.profile.ui.base.BaseUiBehavior;
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
public final class AudienceSeeAnchorBehavior extends BaseUiBehavior {
    public static final /* synthetic */ int n = 0;

    public AudienceSeeAnchorBehavior(NewLiveProfileDialogFragment r2, com.bytedance.android.live.profile.model.d r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "type");
        super(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> d(DataAssembler<st0.b> r23, NewProfileUser r24) {
        Intrinsics.checkNotNullParameter(r23, "component");
        Intrinsics.checkNotNullParameter(r24, "user");
        if (this.a.showSquareButtonArea() == false) goto L6;
        r23.h(new st0.b(0, s1.B(2131919553), 0, 0, 0, false, 56));
        r23.h(new st0.b(3, null, 0, 2131251370, 0, true, 22));
        ot0.b r2 = new ot0.b(this.k, this.a);
        Intrinsics.checkNotNullParameter(r2, "listener");
        r23.c = r2;
        return r23;
    L6:
        r23.h(new st0.b(0, s1.B(2131919553), 0, 0, 0, false, 56));
        r23.i(new st0.b(14, s1.B(2131916267), 0, 0, 0, false, 56), new AudienceSeeAnchorBehavior$configButtonAreaComponent$1(this));
        if (this.a.needShowFansGroupIcon() == false) goto L9;
        st0.b r3 = new st0.b(1, null, 0, 0, 0, false, 62);
    L10:
        r23.i(r3, new AudienceSeeAnchorBehavior$configButtonAreaComponent$2(this));
        r23.h(new st0.b(3, null, 0, 2131251370, 0, true, 22));
        ot0.b r4 = new ot0.b(this.k, this.a);
        Intrinsics.checkNotNullParameter(r4, "listener");
        r23.c = r4;
        return r23;
    L9:
        r3 = new st0.b(2, null, 0, 2131251368, 0, true, 22);
        goto L10
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler e(ProfileStandardHonourWallComponent r6, final NewProfileUser r7) {
        Intrinsics.checkNotNullParameter(r6, "component");
        Intrinsics.checkNotNullParameter(r7, "user");
        r6.h(new e(0, s1.B(2131919749), 4));
        r6.i(new st0.d(true, true, false, 4), new q(r7));
        r6.h(new e(2, s1.B(2131919747), true));
        r6.i(new e(4, s1.B(2131919776), true), new AudienceSeeAnchorBehavior$configHonourComponent$1(r7));
        DressSuitInfo r2 = r7.getDressSuitInfo();
        if (r2 == null) goto L6;
        String r3 = r2.getName();
        if (r3 == null) goto L6;
    L7:
        r6.i(new e(5, r3, true), new AudienceSeeAnchorBehavior$configHonourComponent$2(r7));
        ot0.a r0 = new ot0.a(this.k, this.a);
        Intrinsics.checkNotNullParameter(r0, "listener");
        r6.c = r0;
        Function1<DataAssembler<e>, Unit> r1 = new AudienceSeeAnchorBehavior$configHonourComponent$3(r7);
        Intrinsics.checkNotNullParameter(r1, "action");
        r1.invoke(r6);
        return r6;
    L6:
        r3 = "装扮";
        goto L7
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final y h(y r8, final NewProfileUser r9) {
        Intrinsics.checkNotNullParameter(r8, "component");
        Intrinsics.checkNotNullParameter(r9, "user");
        String r4 = "";
        if (((Boolean) u0.a.getValue()).booleanValue() == false) goto L9;
        int r5 = y.g;
        String r6 = y.a.a(r9);
        if (r6 == null) goto L8;
        r4 = r6;
    L8:
        r8.h(new g(3, r4));
        r8.i(new g(7, s1.B(2131919560)), new AudienceSeeAnchorBehavior$configTextDescComponent$1(r9));
    L20:
        return r8;
    L9:
        int r7 = y.g;
        String r10 = y.a.b(r9);
        if (r10 != null) goto L12;
        r10 = "";
    L12:
        r8.h(new g(2, r10));
        String r12 = y.a.a(r9);
        if (r12 != null) goto L15;
        r12 = "";
    L15:
        r8.i(new g(3, r12), AudienceSeeAnchorBehavior$configTextDescComponent$2.INSTANCE);
        String r3 = y.a.a(r9);
        if (r3 == null) goto L19;
        r4 = r3;
    L19:
        r8.i(new g(6, r4), AudienceSeeAnchorBehavior$configTextDescComponent$3.INSTANCE);
        r8.i(new g(7, s1.B(2131919560)), new AudienceSeeAnchorBehavior$configTextDescComponent$4(r9));
        goto L20
    }
}
