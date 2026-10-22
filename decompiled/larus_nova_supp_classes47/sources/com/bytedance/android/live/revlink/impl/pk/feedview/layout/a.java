package com.bytedance.android.live.revlink.impl.pk.feedview.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.Guideline;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revlink.impl.pk.ui.IMProgressBarLayout;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final Context a;
    public final Guideline b;
    public final View c;
    public final HSImageView d;
    public final HSImageView e;
    public final FrameLayout f;
    public final IMProgressBarLayout g;
    public final FrameLayout h;
    public final FrameLayout i;
    public final FrameLayout j;

    public final Context getContext() {
        return this.a;
    }

    public a(FrameLayout r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        this.j = r4;
        Context r0 = r4.getContext();
        if (r0 != null) goto L5;
        r0 = s1.getContext();
    L5:
        this.a = r0;
        LayoutInflater.from(r0).inflate(2131565998, r4, true);
        this.b = r4.findViewById(2131373803);
        this.c = r4.findViewById(2131367833);
        this.d = r4.findViewById(2131376475);
        this.e = r4.findViewById(2131376470);
        this.f = (FrameLayout) r4.findViewById(2131382354);
        this.i = (FrameLayout) r4.findViewById(2131382353);
        this.g = (IMProgressBarLayout) r4.findViewById(2131374913);
        this.h = (FrameLayout) r4.findViewById(2131364565);
        LivePlayerView r5 = r4.findViewById(2131373460);
    }
}
