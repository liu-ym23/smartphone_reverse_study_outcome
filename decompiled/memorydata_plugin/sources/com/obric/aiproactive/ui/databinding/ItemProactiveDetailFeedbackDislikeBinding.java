package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OIconButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemProactiveDetailFeedbackDislikeBinding implements ViewBinding {
    public final OIconButton btnDislike;
    private final OIconButton rootView;

    private ItemProactiveDetailFeedbackDislikeBinding(OIconButton r1, OIconButton r2) {
        this.rootView = r1;
        this.btnDislike = r2;
    }

    public static ItemProactiveDetailFeedbackDislikeBinding bind(View r4) {
        Objects.requireNonNull(r4, "rootView");
        OIconButton r0 = (OIconButton) ZeusTransformUtils.preCheckCast(r4, OIconButton.class, "com.obric.memorydata.plugin");
        return new ItemProactiveDetailFeedbackDislikeBinding((OIconButton) ZeusTransformUtils.preCheckCast(r4, OIconButton.class, "com.obric.memorydata.plugin"), r0);
    }

    public static ItemProactiveDetailFeedbackDislikeBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemProactiveDetailFeedbackDislikeBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_proactive_detail_feedback_dislike, "layout", "item_proactive_detail_feedback_dislike"), r4, false, "com.obric.memorydata.plugin");
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
    public OIconButton getRoot() {
        return this.rootView;
    }
}
