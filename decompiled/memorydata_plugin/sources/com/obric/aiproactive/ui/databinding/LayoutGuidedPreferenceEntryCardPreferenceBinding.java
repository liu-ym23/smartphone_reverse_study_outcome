package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class LayoutGuidedPreferenceEntryCardPreferenceBinding implements ViewBinding {
    public final ImageView guidedPreferenceEntryArrow;
    public final ImageView guidedPreferenceEntryBg;
    public final ConstraintLayout guidedPreferenceEntryCard;
    public final LinearLayout guidedPreferenceEntryContent;
    public final View guidedPreferenceEntryOverlay;
    public final View guidedPreferenceEntryTint;
    public final TextView guidedPreferenceEntryTitle;
    private final ConstraintLayout rootView;

    private LayoutGuidedPreferenceEntryCardPreferenceBinding(ConstraintLayout r1, ImageView r2, ImageView r3, ConstraintLayout r4, LinearLayout r5, View r6, View r7, TextView r8) {
        this.rootView = r1;
        this.guidedPreferenceEntryArrow = r2;
        this.guidedPreferenceEntryBg = r3;
        this.guidedPreferenceEntryCard = r4;
        this.guidedPreferenceEntryContent = r5;
        this.guidedPreferenceEntryOverlay = r6;
        this.guidedPreferenceEntryTint = r7;
        this.guidedPreferenceEntryTitle = r8;
    }

    public static LayoutGuidedPreferenceEntryCardPreferenceBinding bind(View r14) {
        int r0 = ZeusTransformUtils.mapRes(R.id.guided_preference_entry_arrow, OaidModel.KEY_ID, "guided_preference_entry_arrow");
        ImageView r7 = (ImageView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.guided_preference_entry_bg, OaidModel.KEY_ID, "guided_preference_entry_bg");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L17;
        ConstraintLayout r9 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r14, ConstraintLayout.class, "com.obric.memorydata.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.guided_preference_entry_content, OaidModel.KEY_ID, "guided_preference_entry_content");
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.guided_preference_entry_overlay, OaidModel.KEY_ID, "guided_preference_entry_overlay");
        View r11 = r14.findViewById(r0);
        if (r11 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.guided_preference_entry_tint, OaidModel.KEY_ID, "guided_preference_entry_tint");
        View r12 = r14.findViewById(r0);
        if (r12 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.guided_preference_entry_title, OaidModel.KEY_ID, "guided_preference_entry_title");
        TextView r13 = (TextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L17;
        return new LayoutGuidedPreferenceEntryCardPreferenceBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r14, ConstraintLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12, r13);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r14, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static LayoutGuidedPreferenceEntryCardPreferenceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LayoutGuidedPreferenceEntryCardPreferenceBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.layout_guided_preference_entry_card_preference, "layout", "layout_guided_preference_entry_card_preference"), r4, false, "com.obric.memorydata.plugin");
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
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
