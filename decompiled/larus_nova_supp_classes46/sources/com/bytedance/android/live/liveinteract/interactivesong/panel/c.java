package com.bytedance.android.live.liveinteract.interactivesong.panel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.bytedance.android.livesdk.ktvapi.model.mv.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements j<i> {
    public c() {
    }

    public final IMvPreviewViewHolder<i> a(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        LayoutInflater r0 = LayoutInflater.from(r5.getContext());
        ViewParent r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.inflate(2131566216, r5, false);
    L6:
        if (r2 == null) goto L8;
        ViewParent r3 = r2.getParent();
    L9:
        if (r3 == null) goto L17;
        ViewParent r4 = r2.getParent();
        if ((r4 instanceof ViewGroup) == false) goto L14;
        r1 = r4;
    L14:
        ViewGroup r6 = (ViewGroup) r1;
        if (r6 == null) goto L17;
        r6.removeView(r2);
    L17:
        r5.addView(r2, new FrameLayout.LayoutParams(-1, -1));
        return new InteractiveSongMvPreviewVH(r5);
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }
}
