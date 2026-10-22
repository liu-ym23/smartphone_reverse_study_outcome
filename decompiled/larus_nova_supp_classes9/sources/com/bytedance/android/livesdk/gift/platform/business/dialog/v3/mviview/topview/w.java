package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.text.Spannable;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.android.live.profit.privilege.model.touch.PrivilegeEntranceInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w implements yr2.a {
    public final /* synthetic */ GiftMVIDetailTopView a;

    public w(GiftMVIDetailTopView r1) {
        this.a = r1;
    }

    public final void a(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "image");
        Intrinsics.checkNotNullParameter(r2, "image");
    }

    public final void b(Spannable r5, yr2.a.a r6) {
        Intrinsics.checkNotNullParameter(r5, "spannable");
        Intrinsics.checkNotNullParameter(r6, "info");
        GiftMVIDetailTopView r7 = this.a;
        PrivilegeEntranceInfo r0 = r7.A;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r0.getPanelUrl()) == false) goto L7;
        return;
    L7:
        if (r0.getAwardTips() == null) goto L15;
        TextView r1 = r7.o;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardDetailBtn");
    L11:
        r1.setVisibility(0);
        TextView r2 = r7.o;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardDetailBtn");
    L14:
        r2.setText(r5);
    L15:
        r7.B(r0.getPanelDetail(), r0.getBubbleText());
    }
}
