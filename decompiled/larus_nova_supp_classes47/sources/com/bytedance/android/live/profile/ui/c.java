package com.bytedance.android.live.profile.ui;

import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.NewLiveProfileDialogFragment;
import com.bytedance.android.live.profile.standard.honour.ProfileStandardHonourWallComponent;
import com.bytedance.android.live.profile.ui.base.BaseUiBehavior;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.android.live.profile.ui.component.y;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rs0.u0;
import st0.e;
import st0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends BaseUiBehavior {
    public static final /* synthetic */ int n = 0;

    public c(NewLiveProfileDialogFragment r2, com.bytedance.android.live.profile.model.d r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "type");
        super(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> d(DataAssembler<st0.b> r23, NewProfileUser r24) {
        Intrinsics.checkNotNullParameter(r23, "component");
        Intrinsics.checkNotNullParameter(r24, "user");
        if (this.b != 1) goto L5;
        r23.h(new st0.b(0, "", 0, 0, 0, false, 56));
        r23.i(new st0.b(14, s1.B(2131916267), 0, 0, 0, false, 56), new SeeLinkCrossAnchorBehavior$getButton$1(this));
        r23.h(new st0.b(3, null, 0, 2131251370, 0, true, 22));
        ot0.b r2 = new ot0.b(this.k, this.a);
        Intrinsics.checkNotNullParameter(r2, "listener");
        r23.c = r2;
    L10:
        return r23;
    L5:
        r23.i(new st0.b(6, s1.B(2131919731), 0, 0, 2131251371, false, 40), new SeeLinkCrossAnchorBehavior$getButton$2(this));
        if (isVertical() == false) goto L8;
        st0.b r3 = new st0.b(7, "", UtilityKotlinExtentionsKt.i(68), 2131251369, 0, false, 48);
    L9:
        r23.h(r3);
        r23.h(new st0.b(3, null, 0, 2131251370, 0, true, 22));
        ot0.b r4 = new ot0.b(this.k, this.a);
        Intrinsics.checkNotNullParameter(r4, "listener");
        r23.c = r4;
        goto L10
    L8:
        r3 = new st0.b(7, "", UtilityKotlinExtentionsKt.i(50), -1, 0, false, 48);
        goto L9
    }

    @Override // com.bytedance.android.live.profile.ui.base.BaseUiBehavior
    public final DataAssembler e(ProfileStandardHonourWallComponent r5, final NewProfileUser r6) {
        Intrinsics.checkNotNullParameter(r5, "component");
        Intrinsics.checkNotNullParameter(r6, "user");
        r5.h(new e(0, s1.B(2131919749), 4));
        r5.h(new e(2, s1.B(2131919747), true));
        DressSuitInfo r1 = r6.getDressSuitInfo();
        if (r1 == null) goto L6;
        String r2 = r1.getName();
        if (r2 == null) goto L6;
    L7:
        r5.i(new e(5, r2, true), new SeeLinkCrossAnchorBehavior$configHonourComponent$1(r6));
        ot0.a r0 = new ot0.a(this.k, this.a);
        Intrinsics.checkNotNullParameter(r0, "listener");
        r5.c = r0;
        Function1<DataAssembler<e>, Unit> r3 = new SeeLinkCrossAnchorBehavior$configHonourComponent$2(r6);
        Intrinsics.checkNotNullParameter(r3, "action");
        r3.invoke(r5);
        return r5;
    L6:
        r2 = "装扮";
        goto L7
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
