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
public final class ItemMemoryDetailBinding implements ViewBinding {
    public final LinearLayout cardWrapper;
    public final ImageView imageSource;
    public final LinearLayout llCalendar;
    public final LinearLayout llMemorySource;
    public final ItemMemoryDetailContentBinding memoryContent;
    private final LinearLayout rootView;
    public final TextView tvSourceContent;
    public final TextView tvSourceContentTitle;

    private ItemMemoryDetailBinding(LinearLayout r1, LinearLayout r2, ImageView r3, LinearLayout r4, LinearLayout r5, ItemMemoryDetailContentBinding r6, TextView r7, TextView r8) {
        this.rootView = r1;
        this.cardWrapper = r2;
        this.imageSource = r3;
        this.llCalendar = r4;
        this.llMemorySource = r5;
        this.memoryContent = r6;
        this.tvSourceContent = r7;
        this.tvSourceContentTitle = r8;
    }

    public static ItemMemoryDetailBinding bind(View r11) {
        LinearLayout r4 = (LinearLayout) ZeusTransformUtils.preCheckCast(r11, LinearLayout.class, "com.obric.memorydata.plugin");
        int r0 = ZeusTransformUtils.mapRes(R.id.image_source, OaidModel.KEY_ID, "image_source");
        ImageView r5 = (ImageView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.ll_calendar, OaidModel.KEY_ID, "ll_calendar");
        LinearLayout r6 = (LinearLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.ll_memory_source, OaidModel.KEY_ID, "ll_memory_source");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_content, OaidModel.KEY_ID, "memory_content");
        View r3 = r11.findViewById(r0);
        if (r3 == null) goto L17;
        ItemMemoryDetailContentBinding r8 = ItemMemoryDetailContentBinding.bind(r3);
        r0 = ZeusTransformUtils.mapRes(R.id.tv_source_content, OaidModel.KEY_ID, "tv_source_content");
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_source_content_title, OaidModel.KEY_ID, "tv_source_content_title");
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L17;
        return new ItemMemoryDetailBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r11, LinearLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7, r8, r9, r10);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemMemoryDetailBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemMemoryDetailBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_memory_detail, "layout", "item_memory_detail"), r4, false, "com.obric.memorydata.plugin");
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
