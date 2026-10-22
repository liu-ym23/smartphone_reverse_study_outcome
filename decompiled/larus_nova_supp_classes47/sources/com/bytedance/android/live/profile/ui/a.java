package com.bytedance.android.live.profile.ui;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.profile.NewLiveProfileDialogFragment;
import com.bytedance.android.live.profile.ui.base.BaseUiBehavior;
import com.bytedance.android.live.profile.ui.component.y;
import kotlin.jvm.internal.Intrinsics;
import rs0.u0;
import st0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends BaseUiBehavior {
    public a(NewLiveProfileDialogFragment r2, com.bytedance.android.live.profile.model.d r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "type");
        super(r2, r3);
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
