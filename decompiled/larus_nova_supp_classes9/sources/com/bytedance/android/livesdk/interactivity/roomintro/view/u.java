package com.bytedance.android.livesdk.interactivity.roomintro.view;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends q0 {
    public final /* synthetic */ RoomIntroDialogV2 a;

    public u(RoomIntroDialogV2 r1) {
        this.a = r1;
    }

    public final void h(py.k r2, int r3, int r4) {
        int r5 = (r4 * (s1.y() - UtilityKotlinExtentionsKt.i(32))) / r3;
        HSImageView r6 = this.a.f;
        if (r6 == null) goto L6;
        r6.setMinimumHeight(r5);
        r6.setClickable(false);
        return;
    }
}
