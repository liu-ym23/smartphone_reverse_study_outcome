package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityProactiveV2Binding implements ViewBinding {
    public final View bottomBlur;
    public final FrameLayout bottomMoreHandle;
    public final ImageView ivMoreHandle;
    private final FrameLayout rootView;
    public final View titleBlur;
    public final LinearLayout titleContainer;
    public final LinearLayout titleGroup;
    public final TextView tvTitle;
    public final ViewPager2 vpFeed;

    private ActivityProactiveV2Binding(FrameLayout r1, View r2, FrameLayout r3, ImageView r4, View r5, LinearLayout r6, LinearLayout r7, TextView r8, ViewPager2 r9) {
        this.rootView = r1;
        this.bottomBlur = r2;
        this.bottomMoreHandle = r3;
        this.ivMoreHandle = r4;
        this.titleBlur = r5;
        this.titleContainer = r6;
        this.titleGroup = r7;
        this.tvTitle = r8;
        this.vpFeed = r9;
    }

    public static ActivityProactiveV2Binding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.bottom_blur, OaidModel.KEY_ID, "bottom_blur");
        View r4 = r12.findViewById(r0);
        if (r4 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.bottom_more_handle, OaidModel.KEY_ID, "bottom_more_handle");
        FrameLayout r5 = (FrameLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.iv_more_handle, OaidModel.KEY_ID, "iv_more_handle");
        ImageView r6 = (ImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.title_blur, OaidModel.KEY_ID, "title_blur");
        View r7 = r12.findViewById(r0);
        if (r7 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.title_container, OaidModel.KEY_ID, "title_container");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.title_group, OaidModel.KEY_ID, "title_group");
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title");
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.vp_feed, OaidModel.KEY_ID, "vp_feed");
        ViewPager2 r11 = (ViewPager2) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), ViewPager2.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L21;
        return new ActivityProactiveV2Binding((FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityProactiveV2Binding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityProactiveV2Binding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_proactive_v2, "layout", "activity_proactive_v2"), r4, false, "com.obric.memorydata.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return bind(r6);
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
