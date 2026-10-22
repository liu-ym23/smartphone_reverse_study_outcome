package com.bytedance.android.live.effect.beauty.body;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends View.AccessibilityDelegate {
    public final /* synthetic */ LiveBodyBeautyAdapter.b a;

    public d(LiveBodyBeautyAdapter.b r1) {
        this.a = r1;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "info");
        super.onInitializeAccessibilityNodeInfo(r2, r3);
        r3.setCheckable(false);
        r3.setContentDescription(((TextView) ((RecyclerView.ViewHolder) this.a).itemView.findViewById(2131387943)).getText());
    }
}
