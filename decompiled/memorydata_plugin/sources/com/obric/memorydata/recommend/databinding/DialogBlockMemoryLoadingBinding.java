package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.progress.ODownloadProgressView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class DialogBlockMemoryLoadingBinding implements ViewBinding {
    public final ODownloadProgressView blockMemoryLoadingProgress;
    private final FrameLayout rootView;

    private DialogBlockMemoryLoadingBinding(FrameLayout r1, ODownloadProgressView r2) {
        this.rootView = r1;
        this.blockMemoryLoadingProgress = r2;
    }

    public static DialogBlockMemoryLoadingBinding bind(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.block_memory_loading_progress, OaidModel.KEY_ID, "block_memory_loading_progress");
        ODownloadProgressView r1 = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), ODownloadProgressView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        return new DialogBlockMemoryLoadingBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.memorydata.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static DialogBlockMemoryLoadingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DialogBlockMemoryLoadingBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.dialog_block_memory_loading, "layout", "dialog_block_memory_loading"), r4, false, "com.obric.memorydata.plugin");
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
