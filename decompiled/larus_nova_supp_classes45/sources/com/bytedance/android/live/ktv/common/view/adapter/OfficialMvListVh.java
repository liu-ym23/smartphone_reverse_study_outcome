package com.bytedance.android.live.ktv.common.view.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.message.model.ag;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/adapter/OfficialMvListVh;", "Lcom/bytedance/android/live/ktv/common/view/adapter/SoloMvListVh;", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OfficialMvListVh extends SoloMvListVh {
    public final TextView j;

    public OfficialMvListVh(View r5, b r6) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        Intrinsics.checkNotNullParameter(r6, "adapterClickCb");
        super(r5, r6);
        TextView r7 = new TextView(r5.getContext());
        r7.setTextColor(-1);
        r7.setTextSize(2, 13.0f);
        Unit r1 = Unit.INSTANCE;
        this.j = r7;
        ViewGroup r8 = (ViewGroup) r5;
        FrameLayout r2 = this.d;
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-1, SoloMvListVh.g);
        r3.gravity = 1;
        r8.addView(r2, r3);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-2, -2);
        r4.gravity = 1;
        r4.topMargin = SoloMvListVh.h;
        r8.addView(r7, r4);
    }

    @Override // com.bytedance.android.live.ktv.common.view.adapter.SoloMvListVh
    public final void T3(c r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        super.T3(r2, r3, r4);
        TextView r5 = this.j;
        ag r6 = r2.a.a();
        if (r6 == null) goto L9;
        String r7 = r6.c();
        if (r7 == null) goto L9;
        if ((!TextUtils.isEmpty(r7)) == false) goto L9;
    L10:
        r5.setText(r7);
        return;
    L9:
        r7 = null;
        goto L10
    }
}
