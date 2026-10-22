package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p {
    public final View a;
    public final TextView b;
    public final HSImageView c;

    public p(View r2, TextView r3, HSImageView r4) {
        Intrinsics.checkNotNullParameter(r2, "tagLayout");
        Intrinsics.checkNotNullParameter(r3, "tagText");
        Intrinsics.checkNotNullParameter(r4, "tagIcon");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
