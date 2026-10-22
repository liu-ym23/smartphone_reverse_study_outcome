package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemProactiveFeedbackOchipBinding implements ViewBinding {
    private final AppCompatTextView rootView;

    private ItemProactiveFeedbackOchipBinding(AppCompatTextView r1) {
        this.rootView = r1;
    }

    public static ItemProactiveFeedbackOchipBinding bind(View r3) {
        Objects.requireNonNull(r3, "rootView");
        return new ItemProactiveFeedbackOchipBinding((AppCompatTextView) ZeusTransformUtils.preCheckCast(r3, AppCompatTextView.class, "com.obric.memorydata.plugin"));
    }

    public static ItemProactiveFeedbackOchipBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemProactiveFeedbackOchipBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_proactive_feedback_ochip, "layout", "item_proactive_feedback_ochip"), r4, false, "com.obric.memorydata.plugin");
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
    public AppCompatTextView getRoot() {
        return this.rootView;
    }
}
