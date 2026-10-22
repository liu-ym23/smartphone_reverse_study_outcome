package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.v3;

import a20.e;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.qa;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/adapter/v3/OpenFeatureRecentUseItemViewHolderV3;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureRecentUseItemViewHolderV3 extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public final TextView b;
    public final View c;
    public final TextView d;
    public final View e;
    public final View f;
    public final e g;

    public OpenFeatureRecentUseItemViewHolderV3(View r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.g = r3;
        this.a = (HSImageView) r2.findViewById(2131374718);
        TextView r4 = (TextView) r2.findViewById(2131380593);
        this.b = r4;
        this.c = r2.findViewById(2131362039);
        this.d = (TextView) r2.findViewById(2131365292);
        this.e = r2.findViewById(2131369392);
        this.f = r2.findViewById(2131364174);
        if (Intrinsics.areEqual(qa.a.getValue(), Boolean.TRUE) == false) goto L6;
        ViewCompat.setAccessibilityDelegate(r4, new AnonymousClass1());
        return;
    }
}
