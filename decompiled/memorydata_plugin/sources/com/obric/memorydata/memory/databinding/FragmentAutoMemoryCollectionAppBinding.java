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
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAutoMemoryCollectionAppBinding implements ViewBinding {
    public final TextView allOpen;
    public final FrameLayout bottomBar;
    public final LinearLayout cardAllApps;
    public final LinearLayout cardRecApps;
    public final LinearLayout contentContainer;
    public final NestedScrollView contentScroll;
    public final View cutOff;
    public final FrameLayout rootContainer;
    private final FrameLayout rootView;
    public final OButton saveButton;
    public final OFloatingTitleBar titleBar;
    public final TextView tvAllLabel;
    public final TextView tvRecLabel;

    private FragmentAutoMemoryCollectionAppBinding(FrameLayout r1, TextView r2, FrameLayout r3, LinearLayout r4, LinearLayout r5, LinearLayout r6, NestedScrollView r7, View r8, FrameLayout r9, OButton r10, OFloatingTitleBar r11, TextView r12, TextView r13) {
        this.rootView = r1;
        this.allOpen = r2;
        this.bottomBar = r3;
        this.cardAllApps = r4;
        this.cardRecApps = r5;
        this.contentContainer = r6;
        this.contentScroll = r7;
        this.cutOff = r8;
        this.rootContainer = r9;
        this.saveButton = r10;
        this.titleBar = r11;
        this.tvAllLabel = r12;
        this.tvRecLabel = r13;
    }

    public static FragmentAutoMemoryCollectionAppBinding bind(View r20) {
        int r1 = ZeusTransformUtils.mapRes(R.id.all_open, OaidModel.KEY_ID, "all_open");
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.bottom_bar, OaidModel.KEY_ID, "bottom_bar");
        FrameLayout r9 = (FrameLayout) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.card_all_apps, OaidModel.KEY_ID, "card_all_apps");
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.card_rec_apps, OaidModel.KEY_ID, "card_rec_apps");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.content_container, OaidModel.KEY_ID, "content_container");
        LinearLayout r12 = (LinearLayout) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.content_scroll, OaidModel.KEY_ID, "content_scroll");
        NestedScrollView r13 = (NestedScrollView) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), NestedScrollView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r14 = r20.findViewById(r1);
        if (r14 == null) goto L27;
        FrameLayout r15 = (FrameLayout) ZeusTransformUtils.preCheckCast(r20, FrameLayout.class, "com.obric.memorydata.plugin");
        r1 = ZeusTransformUtils.mapRes(R.id.save_button, OaidModel.KEY_ID, "save_button");
        OButton r16 = (OButton) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), OButton.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.title_bar, OaidModel.KEY_ID, "title_bar");
        OFloatingTitleBar r17 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_all_label, OaidModel.KEY_ID, "tv_all_label");
        TextView r18 = (TextView) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_rec_label, OaidModel.KEY_ID, "tv_rec_label");
        TextView r19 = (TextView) ZeusTransformUtils.preCheckCast(r20.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L27;
        return new FragmentAutoMemoryCollectionAppBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r20, FrameLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r20, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static FragmentAutoMemoryCollectionAppBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentAutoMemoryCollectionAppBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.fragment_auto_memory_collection_app, "layout", "fragment_auto_memory_collection_app"), r4, false, "com.obric.memorydata.plugin");
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
