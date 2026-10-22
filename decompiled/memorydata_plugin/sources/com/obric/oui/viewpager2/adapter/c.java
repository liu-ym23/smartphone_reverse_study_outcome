package com.obric.oui.viewpager2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends RecyclerView.v {
    private c(FrameLayout r1) {
        super(r1);
    }

    static c a(ViewGroup r3) {
        FrameLayout r0 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r0.setId(View.generateViewId());
        r0.setSaveEnabled(false);
        return new c(r0);
    }

    FrameLayout a() {
        return (FrameLayout) ZeusTransformUtils.preCheckCast(this.c, FrameLayout.class, "com.obric.memorydata.plugin");
    }
}
