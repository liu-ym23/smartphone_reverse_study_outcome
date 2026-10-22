package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.ui.preference.GuidedPreferenceInputEditText;
import com.obric.memorydata.plugin.R;
import com.obric.oui.checkbox.OCheckBox;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemGuidedPreferenceOptionBinding implements ViewBinding {
    public final OCheckBox cbOption;
    public final GuidedPreferenceInputEditText inputOption;
    public final ImageView ivOptionMark;
    public final CardView optionContainer;
    public final LinearLayout optionContent;
    public final View optionDivider;
    public final LinearLayout optionRow;
    private final LinearLayout rootView;
    public final TextView tvOptionDescription;
    public final TextView tvOptionTitle;

    private ItemGuidedPreferenceOptionBinding(LinearLayout r1, OCheckBox r2, GuidedPreferenceInputEditText r3, ImageView r4, CardView r5, LinearLayout r6, View r7, LinearLayout r8, TextView r9, TextView r10) {
        this.rootView = r1;
        this.cbOption = r2;
        this.inputOption = r3;
        this.ivOptionMark = r4;
        this.optionContainer = r5;
        this.optionContent = r6;
        this.optionDivider = r7;
        this.optionRow = r8;
        this.tvOptionDescription = r9;
        this.tvOptionTitle = r10;
    }

    public static ItemGuidedPreferenceOptionBinding bind(View r17) {
        int r1 = ZeusTransformUtils.mapRes(R.id.cb_option, OaidModel.KEY_ID, "cb_option");
        OCheckBox r8 = (OCheckBox) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OCheckBox.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.input_option, OaidModel.KEY_ID, "input_option");
        GuidedPreferenceInputEditText r9 = (GuidedPreferenceInputEditText) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), GuidedPreferenceInputEditText.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_option_mark, OaidModel.KEY_ID, "iv_option_mark");
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.option_container, OaidModel.KEY_ID, "option_container");
        CardView r11 = (CardView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), CardView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.option_content, OaidModel.KEY_ID, "option_content");
        LinearLayout r12 = (LinearLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.option_divider, OaidModel.KEY_ID, "option_divider");
        View r13 = r17.findViewById(r1);
        if (r13 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.option_row, OaidModel.KEY_ID, "option_row");
        LinearLayout r14 = (LinearLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_option_description, OaidModel.KEY_ID, "tv_option_description");
        TextView r15 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_option_title, OaidModel.KEY_ID, "tv_option_title");
        TextView r16 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L23;
        return new ItemGuidedPreferenceOptionBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r17, LinearLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r17, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ItemGuidedPreferenceOptionBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemGuidedPreferenceOptionBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_guided_preference_option, "layout", "item_guided_preference_option"), r4, false, "com.obric.memorydata.plugin");
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
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
