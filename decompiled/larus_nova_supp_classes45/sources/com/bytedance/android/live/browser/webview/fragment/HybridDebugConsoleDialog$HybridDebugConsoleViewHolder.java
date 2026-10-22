package com.bytedance.android.live.browser.webview.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/live/browser/webview/fragment/HybridDebugConsoleDialog$HybridDebugConsoleViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridDebugConsoleDialog$HybridDebugConsoleViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final RelativeLayout f;
    public final LinearLayout g;

    public HybridDebugConsoleDialog$HybridDebugConsoleViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = (TextView) r2.findViewById(2131380374);
        this.b = (TextView) r2.findViewById(2131380375);
        this.c = (TextView) r2.findViewById(2131380369);
        this.d = (TextView) r2.findViewById(2131380360);
        this.e = (TextView) r2.findViewById(2131380361);
        this.f = (RelativeLayout) r2.findViewById(2131380368);
        this.g = (LinearLayout) r2.findViewById(2131380365);
    }
}
