package com.bytedance.android.live.profile.standard.honour.items.dressup;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.profile.ui.base.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends ct0.a {
    @Override // ct0.a, bt0.a
    public final bt0.b i() {
        h r0 = this.a;
        if (r0 == null) goto L9;
        NewProfileUser r1 = r0.getTargetUser();
        if (r1 == null) goto L9;
        if (r1.useStandardHonorWallV3() == true) goto L9;
        return new DressUpBusinessAreaViewHolder();
    L9:
        return null;
    }

    public a() {
    }

    @Override // ct0.a, bt0.a
    public final View e(h r5, Context r6) {
        Intrinsics.checkNotNullParameter(r5, "profileContext");
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r5.getTargetUser().useStandardHonorWallV3() == true) goto L5;
        DressUpHonourCardView r7 = new DressUpHonourCardView(r6, null, 6, 0);
        r7.setId(2131389677);
        return r7;
    L5:
        DressUpHonourCardViewV3 r8 = new DressUpHonourCardViewV3(r6, null, 6, 0);
        r8.setId(2131389677);
        return r8;
    }
}
