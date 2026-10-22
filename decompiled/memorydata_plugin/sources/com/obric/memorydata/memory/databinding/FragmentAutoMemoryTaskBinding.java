package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskRootLayout;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskTabLayout;
import com.obric.memorydata.plugin.R;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OFloatingActionButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAutoMemoryTaskBinding implements ViewBinding {
    public final ConstraintLayout contentContainer;
    public final FrameLayout guideActionBar;
    public final ImageView guideBackground;
    public final ConstraintLayout guideContainer;
    public final LinearLayout guideContent;
    public final OCardListItem guideFeatureAuto;
    public final OCardListItem guideFeatureCustom;
    public final LinearLayout guideFeatureList;
    public final OCardListItem guideFeatureQa;
    public final ImageView guideImage;
    public final ONestedScrollView guideScroll;
    public final OButton guideStartButton;
    public final OTextView guideSubtitle;
    public final OTextView guideTitle;
    public final ViewPager2 memoryTabContainer;
    private final AutoMemoryTaskRootLayout rootView;
    public final OFloatingActionButton taskAddButton;
    public final FrameLayout taskLoadingOverlay;
    public final ODownloadProgressView taskLoadingProgress;
    public final LinearLayout taskLoadingSheet;
    public final OTextView taskLoadingSubtitle;
    public final OTextView taskLoadingTitle;
    public final AutoMemoryTaskTabLayout taskTabContainer;
    public final OBlurMaskView taskTitleBarMask;
    public final OBlurMaskView taskTitleTabMask;
    public final OFloatingTitleBar titleBar;

    private FragmentAutoMemoryTaskBinding(AutoMemoryTaskRootLayout r3, ConstraintLayout r4, FrameLayout r5, ImageView r6, ConstraintLayout r7, LinearLayout r8, OCardListItem r9, OCardListItem r10, LinearLayout r11, OCardListItem r12, ImageView r13, ONestedScrollView r14, OButton r15, OTextView r16, OTextView r17, ViewPager2 r18, OFloatingActionButton r19, FrameLayout r20, ODownloadProgressView r21, LinearLayout r22, OTextView r23, OTextView r24, AutoMemoryTaskTabLayout r25, OBlurMaskView r26, OBlurMaskView r27, OFloatingTitleBar r28) {
        this.rootView = r3;
        this.contentContainer = r4;
        this.guideActionBar = r5;
        this.guideBackground = r6;
        this.guideContainer = r7;
        this.guideContent = r8;
        this.guideFeatureAuto = r9;
        this.guideFeatureCustom = r10;
        this.guideFeatureList = r11;
        this.guideFeatureQa = r12;
        this.guideImage = r13;
        this.guideScroll = r14;
        this.guideStartButton = r15;
        this.guideSubtitle = r16;
        this.guideTitle = r17;
        this.memoryTabContainer = r18;
        this.taskAddButton = r19;
        this.taskLoadingOverlay = r20;
        this.taskLoadingProgress = r21;
        this.taskLoadingSheet = r22;
        this.taskLoadingSubtitle = r23;
        this.taskLoadingTitle = r24;
        this.taskTabContainer = r25;
        this.taskTitleBarMask = r26;
        this.taskTitleTabMask = r27;
        this.titleBar = r28;
    }

    public static FragmentAutoMemoryTaskBinding bind(View r33) {
        int r1 = ZeusTransformUtils.mapRes(R.id.content_container, OaidModel.KEY_ID, "content_container");
        ConstraintLayout r8 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.guide_action_bar, OaidModel.KEY_ID, "guide_action_bar");
        FrameLayout r9 = (FrameLayout) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.guide_background, OaidModel.KEY_ID, "guide_background");
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.guide_container, OaidModel.KEY_ID, "guide_container");
        ConstraintLayout r11 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.guide_content, OaidModel.KEY_ID, "guide_content");
        LinearLayout r12 = (LinearLayout) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.guide_feature_auto, OaidModel.KEY_ID, "guide_feature_auto");
        OCardListItem r13 = (OCardListItem) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.guide_feature_custom, OaidModel.KEY_ID, "guide_feature_custom");
        OCardListItem r14 = (OCardListItem) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.guide_feature_list, OaidModel.KEY_ID, "guide_feature_list");
        LinearLayout r15 = (LinearLayout) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.guide_feature_qa, OaidModel.KEY_ID, "guide_feature_qa");
        OCardListItem r16 = (OCardListItem) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.guide_image, OaidModel.KEY_ID, "guide_image");
        ImageView r17 = (ImageView) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.guide_scroll, OaidModel.KEY_ID, "guide_scroll");
        ONestedScrollView r18 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.guide_start_button, OaidModel.KEY_ID, "guide_start_button");
        OButton r19 = (OButton) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), OButton.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.guide_subtitle, OaidModel.KEY_ID, "guide_subtitle");
        OTextView r20 = (OTextView) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), OTextView.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.guide_title, OaidModel.KEY_ID, "guide_title");
        OTextView r21 = (OTextView) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), OTextView.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_tab_container, OaidModel.KEY_ID, "memory_tab_container");
        ViewPager2 r22 = (ViewPager2) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), ViewPager2.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.task_add_button, OaidModel.KEY_ID, "task_add_button");
        OFloatingActionButton r23 = (OFloatingActionButton) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), OFloatingActionButton.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.task_loading_overlay, OaidModel.KEY_ID, "task_loading_overlay");
        FrameLayout r24 = (FrameLayout) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.task_loading_progress, OaidModel.KEY_ID, "task_loading_progress");
        ODownloadProgressView r25 = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), ODownloadProgressView.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.task_loading_sheet, OaidModel.KEY_ID, "task_loading_sheet");
        LinearLayout r26 = (LinearLayout) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.task_loading_subtitle, OaidModel.KEY_ID, "task_loading_subtitle");
        OTextView r27 = (OTextView) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), OTextView.class, "com.obric.memorydata.plugin");
        if (r27 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.task_loading_title, OaidModel.KEY_ID, "task_loading_title");
        OTextView r28 = (OTextView) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), OTextView.class, "com.obric.memorydata.plugin");
        if (r28 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.task_tab_container, OaidModel.KEY_ID, "task_tab_container");
        AutoMemoryTaskTabLayout r29 = (AutoMemoryTaskTabLayout) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), AutoMemoryTaskTabLayout.class, "com.obric.memorydata.plugin");
        if (r29 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.task_title_bar_mask, OaidModel.KEY_ID, "task_title_bar_mask");
        OBlurMaskView r30 = (OBlurMaskView) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), OBlurMaskView.class, "com.obric.memorydata.plugin");
        if (r30 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.task_title_tab_mask, OaidModel.KEY_ID, "task_title_tab_mask");
        OBlurMaskView r31 = (OBlurMaskView) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), OBlurMaskView.class, "com.obric.memorydata.plugin");
        if (r31 == null) goto L55;
        r1 = ZeusTransformUtils.mapRes(R.id.title_bar, OaidModel.KEY_ID, "title_bar");
        OFloatingTitleBar r32 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r33.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r32 == null) goto L55;
        return new FragmentAutoMemoryTaskBinding((AutoMemoryTaskRootLayout) ZeusTransformUtils.preCheckCast(r33, AutoMemoryTaskRootLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    L55:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r33, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static FragmentAutoMemoryTaskBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentAutoMemoryTaskBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.fragment_auto_memory_task, "layout", "fragment_auto_memory_task"), r4, false, "com.obric.memorydata.plugin");
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
    public AutoMemoryTaskRootLayout getRoot() {
        return this.rootView;
    }
}
