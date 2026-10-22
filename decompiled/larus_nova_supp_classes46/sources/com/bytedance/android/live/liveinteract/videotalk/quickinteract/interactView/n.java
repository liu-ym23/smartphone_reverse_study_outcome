package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n {
    public final ViewSwitcher a;
    public final HSImageView b;
    public final TextView c;
    public final View d;
    public QuickInteractTask e;

    public n(View r3) {
        Intrinsics.checkNotNullParameter(r3, "parentContext");
        ViewSwitcher r0 = (ViewSwitcher) r3.findViewById(2131375541);
        this.a = r0;
        this.b = r3.findViewById(2131375503);
        this.c = (TextView) r3.findViewById(2131375504);
        this.d = r3.findViewById(2131385176);
        r0.setMeasureAllChildren(false);
        r0.setInAnimation(AnimationUtils.loadAnimation(r0.getContext(), 2130772691));
        r0.setOutAnimation(AnimationUtils.loadAnimation(r0.getContext(), 2130772692));
    }
}
