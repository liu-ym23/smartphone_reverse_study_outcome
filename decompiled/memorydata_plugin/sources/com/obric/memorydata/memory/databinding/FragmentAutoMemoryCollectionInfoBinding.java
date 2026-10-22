package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAutoMemoryCollectionInfoBinding implements ViewBinding {
    public final FrameLayout bottomBar;
    public final LinearLayout contentContainer;
    public final NestedScrollView contentScroll;
    public final View cutOff;
    public final OInputLayout descInput;
    public final TextView descInputCounter;
    public final FrameLayout descInputLayer;
    public final TextView descLabel;
    public final LinearLayout generateLoadingContainer;
    public final TextView generateLoadingText;
    public final ODownloadProgressView generateProgress;
    public final OButton nextButton;
    public final LinearLayout nextButtonContainer;
    public final OPageStatus pageStatusVerticalLoading;
    public final FrameLayout rootContainer;
    private final FrameLayout rootView;
    public final OFloatingTitleBar titleBar;

    private FragmentAutoMemoryCollectionInfoBinding(FrameLayout r3, FrameLayout r4, LinearLayout r5, NestedScrollView r6, View r7, OInputLayout r8, TextView r9, FrameLayout r10, TextView r11, LinearLayout r12, TextView r13, ODownloadProgressView r14, OButton r15, LinearLayout r16, OPageStatus r17, FrameLayout r18, OFloatingTitleBar r19) {
        this.rootView = r3;
        this.bottomBar = r4;
        this.contentContainer = r5;
        this.contentScroll = r6;
        this.cutOff = r7;
        this.descInput = r8;
        this.descInputCounter = r9;
        this.descInputLayer = r10;
        this.descLabel = r11;
        this.generateLoadingContainer = r12;
        this.generateLoadingText = r13;
        this.generateProgress = r14;
        this.nextButton = r15;
        this.nextButtonContainer = r16;
        this.pageStatusVerticalLoading = r17;
        this.rootContainer = r18;
        this.titleBar = r19;
    }

    public static FragmentAutoMemoryCollectionInfoBinding bind(View r24) {
        int r1 = ZeusTransformUtils.mapRes(R.id.bottom_bar, OaidModel.KEY_ID, "bottom_bar");
        FrameLayout r8 = (FrameLayout) ZeusTransformUtils.preCheckCast(r24.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.content_container, OaidModel.KEY_ID, "content_container");
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r24.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.content_scroll, OaidModel.KEY_ID, "content_scroll");
        NestedScrollView r10 = (NestedScrollView) ZeusTransformUtils.preCheckCast(r24.findViewById(r1), NestedScrollView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r11 = r24.findViewById(r1);
        if (r11 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.desc_input, OaidModel.KEY_ID, "desc_input");
        OInputLayout r12 = (OInputLayout) ZeusTransformUtils.preCheckCast(r24.findViewById(r1), OInputLayout.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.desc_input_counter, OaidModel.KEY_ID, "desc_input_counter");
        TextView r13 = (TextView) ZeusTransformUtils.preCheckCast(r24.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.desc_input_layer, OaidModel.KEY_ID, "desc_input_layer");
        FrameLayout r14 = (FrameLayout) ZeusTransformUtils.preCheckCast(r24.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.desc_label, OaidModel.KEY_ID, "desc_label");
        TextView r15 = (TextView) ZeusTransformUtils.preCheckCast(r24.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.generate_loading_container, OaidModel.KEY_ID, "generate_loading_container");
        LinearLayout r16 = (LinearLayout) ZeusTransformUtils.preCheckCast(r24.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.generate_loading_text, OaidModel.KEY_ID, "generate_loading_text");
        TextView r17 = (TextView) ZeusTransformUtils.preCheckCast(r24.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.generate_progress, OaidModel.KEY_ID, "generate_progress");
        ODownloadProgressView r18 = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r24.findViewById(r1), ODownloadProgressView.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.next_button, OaidModel.KEY_ID, "next_button");
        OButton r19 = (OButton) ZeusTransformUtils.preCheckCast(r24.findViewById(r1), OButton.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.next_button_container, OaidModel.KEY_ID, "next_button_container");
        LinearLayout r20 = (LinearLayout) ZeusTransformUtils.preCheckCast(r24.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.page_status_vertical_loading, OaidModel.KEY_ID, "page_status_vertical_loading");
        OPageStatus r21 = (OPageStatus) ZeusTransformUtils.preCheckCast(r24.findViewById(r1), OPageStatus.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L35;
        FrameLayout r22 = (FrameLayout) ZeusTransformUtils.preCheckCast(r24, FrameLayout.class, "com.obric.memorydata.plugin");
        r1 = ZeusTransformUtils.mapRes(R.id.title_bar, OaidModel.KEY_ID, "title_bar");
        OFloatingTitleBar r23 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r24.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L35;
        return new FragmentAutoMemoryCollectionInfoBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r24, FrameLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r24, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static FragmentAutoMemoryCollectionInfoBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentAutoMemoryCollectionInfoBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.fragment_auto_memory_collection_info, "layout", "fragment_auto_memory_collection_info"), r4, false, "com.obric.memorydata.plugin");
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
