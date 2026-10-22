package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemRecommendMemoryCardBinding implements ViewBinding {
    public final ViewStub cardContentVs;
    public final LinearLayout cardWrapper;
    public final FrameLayout deleteMemory;
    private final SwipeMenuLayout rootView;
    public final SwipeMenuLayout swipeLayout;

    private ItemRecommendMemoryCardBinding(SwipeMenuLayout r1, ViewStub r2, LinearLayout r3, FrameLayout r4, SwipeMenuLayout r5) {
        this.rootView = r1;
        this.cardContentVs = r2;
        this.cardWrapper = r3;
        this.deleteMemory = r4;
        this.swipeLayout = r5;
    }

    public static ItemRecommendMemoryCardBinding bind(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.card_content_vs, OaidModel.KEY_ID, "card_content_vs");
        ViewStub r7 = (ViewStub) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), ViewStub.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.card_wrapper, OaidModel.KEY_ID, "card_wrapper");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.delete_memory, OaidModel.KEY_ID, "delete_memory");
        FrameLayout r9 = (FrameLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L11;
        SwipeMenuLayout r10 = (SwipeMenuLayout) ZeusTransformUtils.preCheckCast(r11, SwipeMenuLayout.class, "com.obric.memorydata.plugin");
        return new ItemRecommendMemoryCardBinding((SwipeMenuLayout) ZeusTransformUtils.preCheckCast(r11, SwipeMenuLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemRecommendMemoryCardBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemRecommendMemoryCardBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_recommend_memory_card, "layout", "item_recommend_memory_card"), r4, false, "com.obric.memorydata.plugin");
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
    public SwipeMenuLayout getRoot() {
        return this.rootView;
    }
}
