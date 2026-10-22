package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ViewDefaultRecommendBinding implements ViewBinding {
    public final ImageView loadingIv;
    public final TextView loadingTv;
    public final LinearLayout loadingView;
    public final RelativeLayout recommendLayout;
    public final LKUIPtrClassicFrameLayout recommendPtrLayout;
    public final CommonRecyclerView recommendRv;
    private final RelativeLayout rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3342getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public RelativeLayout m3342getRoot() {
        return this.rootView;
    }

    public static ViewDefaultRecommendBinding bind(View r10) {
        int r0 = 2131379044;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r10, 2131379044);
        if (r4 == null) goto L15;
        r0 = 2131379090;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131379090);
        if (r5 == null) goto L15;
        r0 = 2131379091;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131379091);
        if (r6 == null) goto L15;
        RelativeLayout r7 = (RelativeLayout) r10;
        r0 = 2131383955;
        LKUIPtrClassicFrameLayout r8 = ViewBindings.findChildViewById(r10, 2131383955);
        if (r8 == null) goto L15;
        r0 = 2131383958;
        CommonRecyclerView r9 = ViewBindings.findChildViewById(r10, 2131383958);
        if (r9 == null) goto L15;
        return new ViewDefaultRecommendBinding(r7, r4, r5, r6, r7, r8, r9);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }

    public static ViewDefaultRecommendBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewDefaultRecommendBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131568154, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private ViewDefaultRecommendBinding(RelativeLayout r1, ImageView r2, TextView r3, LinearLayout r4, RelativeLayout r5, LKUIPtrClassicFrameLayout r6, CommonRecyclerView r7) {
        this.rootView = r1;
        this.loadingIv = r2;
        this.loadingTv = r3;
        this.loadingView = r4;
        this.recommendLayout = r5;
        this.recommendPtrLayout = r6;
        this.recommendRv = r7;
    }
}
