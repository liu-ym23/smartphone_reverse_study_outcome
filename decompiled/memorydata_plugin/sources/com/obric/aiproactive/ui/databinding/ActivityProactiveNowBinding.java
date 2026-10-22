package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityProactiveNowBinding implements ViewBinding {
    public final FrameLayout fragmentContainer;
    private final FrameLayout rootView;

    private ActivityProactiveNowBinding(FrameLayout r1, FrameLayout r2) {
        this.rootView = r1;
        this.fragmentContainer = r2;
    }

    public static ActivityProactiveNowBinding bind(View r4) {
        Objects.requireNonNull(r4, "rootView");
        FrameLayout r0 = (FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.memorydata.plugin");
        return new ActivityProactiveNowBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.memorydata.plugin"), r0);
    }

    public static ActivityProactiveNowBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityProactiveNowBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_proactive_now, "layout", "activity_proactive_now"), r4, false, "com.obric.memorydata.plugin");
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
