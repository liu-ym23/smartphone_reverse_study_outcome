package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryWidgetBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final RelativeLayout widgetContainer;
    public final LinearLayout widgetEmpty;
    public final ListView widgetItems;
    public final TextView widgetTitle;

    private MemoryWidgetBinding(RelativeLayout r1, RelativeLayout r2, LinearLayout r3, ListView r4, TextView r5) {
        this.rootView = r1;
        this.widgetContainer = r2;
        this.widgetEmpty = r3;
        this.widgetItems = r4;
        this.widgetTitle = r5;
    }

    public static MemoryWidgetBinding bind(View r8) {
        RelativeLayout r4 = (RelativeLayout) ZeusTransformUtils.preCheckCast(r8, RelativeLayout.class, "com.obric.memorydata.plugin");
        int r0 = ZeusTransformUtils.mapRes(R.id.widget_empty, OaidModel.KEY_ID, "widget_empty");
        LinearLayout r5 = (LinearLayout) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.widget_items, OaidModel.KEY_ID, "widget_items");
        ListView r6 = (ListView) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), ListView.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.widget_title, OaidModel.KEY_ID, "widget_title");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L11;
        return new MemoryWidgetBinding((RelativeLayout) ZeusTransformUtils.preCheckCast(r8, RelativeLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static MemoryWidgetBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MemoryWidgetBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.memory_widget, "layout", "memory_widget"), r4, false, "com.obric.memorydata.plugin");
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
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
