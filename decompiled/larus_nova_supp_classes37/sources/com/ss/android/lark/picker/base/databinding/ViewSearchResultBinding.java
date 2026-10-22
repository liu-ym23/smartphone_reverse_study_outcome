package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ViewSearchResultBinding implements ViewBinding {
    public final LinearLayout llTopTips;
    public final RelativeLayout resultLayout;
    private final RelativeLayout rootView;
    public final FrameLayout searchResultHeadContainer;
    public final LinearLayout searchResultLoading;
    public final ImageView searchResultLoadingImg;
    public final TextView searchResultLoadingTxt;
    public final LKUIPtrClassicFrameLayout searchResultPtrFl;
    public final CommonRecyclerView searchResultRv;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3348getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public RelativeLayout m3348getRoot() {
        return this.rootView;
    }

    public static ViewSearchResultBinding bind(View r12) {
        int r0 = 2131378920;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131378920);
        if (r4 == null) goto L19;
        RelativeLayout r5 = (RelativeLayout) r12;
        r0 = 2131385570;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131385570);
        if (r6 == null) goto L19;
        r0 = 2131385575;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131385575);
        if (r7 == null) goto L19;
        r0 = 2131385576;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r12, 2131385576);
        if (r8 == null) goto L19;
        r0 = 2131385577;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r12, 2131385577);
        if (r9 == null) goto L19;
        r0 = 2131385579;
        LKUIPtrClassicFrameLayout r10 = ViewBindings.findChildViewById(r12, 2131385579);
        if (r10 == null) goto L19;
        r0 = 2131385582;
        CommonRecyclerView r11 = ViewBindings.findChildViewById(r12, 2131385582);
        if (r11 == null) goto L19;
        return new ViewSearchResultBinding(r5, r4, r5, r6, r7, r8, r9, r10, r11);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }

    public static ViewSearchResultBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewSearchResultBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131568199, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private ViewSearchResultBinding(RelativeLayout r1, LinearLayout r2, RelativeLayout r3, FrameLayout r4, LinearLayout r5, ImageView r6, TextView r7, LKUIPtrClassicFrameLayout r8, CommonRecyclerView r9) {
        this.rootView = r1;
        this.llTopTips = r2;
        this.resultLayout = r3;
        this.searchResultHeadContainer = r4;
        this.searchResultLoading = r5;
        this.searchResultLoadingImg = r6;
        this.searchResultLoadingTxt = r7;
        this.searchResultPtrFl = r8;
        this.searchResultRv = r9;
    }
}
