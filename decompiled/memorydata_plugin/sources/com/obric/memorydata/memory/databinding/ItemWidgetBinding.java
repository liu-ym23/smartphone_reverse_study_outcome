package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemWidgetBinding implements ViewBinding {
    public final LinearLayout containerSmallMargin;
    private final LinearLayout rootView;
    public final TextView widgetContent;
    public final ImageView widgetIcon;
    public final LinearLayout widgetItem;
    public final TextView widgetTime;

    private ItemWidgetBinding(LinearLayout r1, LinearLayout r2, TextView r3, ImageView r4, LinearLayout r5, TextView r6) {
        this.rootView = r1;
        this.containerSmallMargin = r2;
        this.widgetContent = r3;
        this.widgetIcon = r4;
        this.widgetItem = r5;
        this.widgetTime = r6;
    }

    public static ItemWidgetBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.container_small_margin, OaidModel.KEY_ID, "container_small_margin");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.widget_content, OaidModel.KEY_ID, "widget_content");
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.widget_icon, OaidModel.KEY_ID, "widget_icon");
        ImageView r9 = (ImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L13;
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12, LinearLayout.class, "com.obric.memorydata.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.widget_time, OaidModel.KEY_ID, "widget_time");
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L13;
        return new ItemWidgetBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r12, LinearLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemWidgetBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemWidgetBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_widget, "layout", "item_widget"), r4, false, "com.obric.memorydata.plugin");
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
