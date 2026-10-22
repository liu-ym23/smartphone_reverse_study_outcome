package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityAilabBinding implements ViewBinding {
    public final FrameLayout aboutRootView;
    public final OListItemGeneral aiProactiveAgentItem;
    public final OTextView ailabSysteminfo;
    public final OListItemGeneral autoMemoryItem;
    public final View cutOff;
    public final LinearLayout featureListContainer;
    public final LinearLayout headerContainer;
    public final ImageView logoImg;
    private final FrameLayout rootView;
    public final OListItemGeneral screenMemoryItem;
    public final OScrollView scrollContent;
    public final TextView subTitle;
    public final TextView title;
    public final OFloatingTitleBar viewTitle;
    public final OListItemGeneral voiceMemoryItem;

    private ActivityAilabBinding(FrameLayout r1, FrameLayout r2, OListItemGeneral r3, OTextView r4, OListItemGeneral r5, View r6, LinearLayout r7, LinearLayout r8, ImageView r9, OListItemGeneral r10, OScrollView r11, TextView r12, TextView r13, OFloatingTitleBar r14, OListItemGeneral r15) {
        this.rootView = r1;
        this.aboutRootView = r2;
        this.aiProactiveAgentItem = r3;
        this.ailabSysteminfo = r4;
        this.autoMemoryItem = r5;
        this.cutOff = r6;
        this.featureListContainer = r7;
        this.headerContainer = r8;
        this.logoImg = r9;
        this.screenMemoryItem = r10;
        this.scrollContent = r11;
        this.subTitle = r12;
        this.title = r13;
        this.viewTitle = r14;
        this.voiceMemoryItem = r15;
    }

    public static ActivityAilabBinding bind(View r20) {
        FrameLayout r5 = (FrameLayout) ZeusTransformUtils.preCheckCast(r20, FrameLayout.class, "com.obric.memorydata.plugin");
        int r1 = ZeusTransformUtils.mapRes(R.id.ai_proactive_agent_item, OaidModel.KEY_ID, "ai_proactive_agent_item");
        OListItemGeneral r6 = (OListItemGeneral) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), OListItemGeneral.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L32;
        r1 = ZeusTransformUtils.mapRes(R.id.ailab_systeminfo, OaidModel.KEY_ID, "ailab_systeminfo");
        OTextView r7 = (OTextView) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), OTextView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L32;
        r1 = ZeusTransformUtils.mapRes(R.id.auto_memory_item, OaidModel.KEY_ID, "auto_memory_item");
        OListItemGeneral r8 = (OListItemGeneral) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), OListItemGeneral.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L32;
        r1 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r9 = r20.findViewById(r1);
        if (r9 == null) goto L32;
        r1 = ZeusTransformUtils.mapRes(R.id.feature_list_container, OaidModel.KEY_ID, "feature_list_container");
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L32;
        r1 = ZeusTransformUtils.mapRes(R.id.header_container, OaidModel.KEY_ID, "header_container");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L32;
        r1 = ZeusTransformUtils.mapRes(R.id.logo_img, OaidModel.KEY_ID, "logo_img");
        ImageView r12 = (ImageView) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L32;
        r1 = ZeusTransformUtils.mapRes(R.id.screen_memory_item, OaidModel.KEY_ID, "screen_memory_item");
        OListItemGeneral r13 = (OListItemGeneral) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), OListItemGeneral.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L32;
        r1 = ZeusTransformUtils.mapRes(R.id.scroll_content, OaidModel.KEY_ID, "scroll_content");
        OScrollView r14 = (OScrollView) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), OScrollView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L32;
        r1 = ZeusTransformUtils.mapRes(R.id.sub_title, OaidModel.KEY_ID, "sub_title");
        TextView r15 = (TextView) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L32;
        int r2 = ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title");
        int r16 = r2;
        TextView r3 = (TextView) ZeusTransformUtils.preCheckCast(r20.findViewById(r2), TextView.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L30;
        int r4 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        r16 = r4;
        OFloatingTitleBar r17 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r20.findViewById(r4), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L30;
        r1 = ZeusTransformUtils.mapRes(R.id.voice_memory_item, OaidModel.KEY_ID, "voice_memory_item");
        OListItemGeneral r19 = (OListItemGeneral) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), OListItemGeneral.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L32;
        return new ActivityAilabBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r20, FrameLayout.class, "com.obric.memorydata.plugin"), r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r3, r17, r19);
    L30:
        r1 = r16;
    L32:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r20, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityAilabBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityAilabBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_ailab, "layout", "activity_ailab"), r4, false, "com.obric.memorydata.plugin");
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
