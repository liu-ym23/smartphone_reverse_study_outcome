package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemScreenContentAppMemoryHeaderBinding implements ViewBinding {
    public final DeviceAdaptiveCardListItem newMemorySetting;
    private final LinearLayout rootView;
    public final DeviceAdaptiveCardListItem screenObservationSwitch;
    public final TextView screenObservationTemporarilyDisabledTips;

    private ItemScreenContentAppMemoryHeaderBinding(LinearLayout r1, DeviceAdaptiveCardListItem r2, DeviceAdaptiveCardListItem r3, TextView r4) {
        this.rootView = r1;
        this.newMemorySetting = r2;
        this.screenObservationSwitch = r3;
        this.screenObservationTemporarilyDisabledTips = r4;
    }

    public static ItemScreenContentAppMemoryHeaderBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.new_memory_setting, OaidModel.KEY_ID, "new_memory_setting");
        DeviceAdaptiveCardListItem r2 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.screen_observation_switch, OaidModel.KEY_ID, "screen_observation_switch");
        DeviceAdaptiveCardListItem r3 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.screen_observation_temporarily_disabled_tips, OaidModel.KEY_ID, "screen_observation_temporarily_disabled_tips");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return new ItemScreenContentAppMemoryHeaderBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r6, LinearLayout.class, "com.obric.memorydata.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemScreenContentAppMemoryHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemScreenContentAppMemoryHeaderBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_screen_content_app_memory_header, "layout", "item_screen_content_app_memory_header"), r4, false, "com.obric.memorydata.plugin");
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
