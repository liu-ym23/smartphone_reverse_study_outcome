package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.widget.CircleProgressView;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k1 {
    public final int a;
    public final ViewGroup b;
    public HSImageView c;
    public TextView d;
    public CircleProgressView e;
    public long f;
    public ObjectAnimator g;
    public final Context h;
    public Bundle i;

    public k1(Context r3, Lifecycle r4, ViewGroup r5) {
        this.f = 0;
        this.b = r5;
        this.h = r3;
        if (r3 == null) goto L6;
        this.c = r5.findViewById(2131391990);
        this.d = (TextView) r5.findViewById(2131363786);
        this.e = r5.findViewById(2131365725);
        UIUtils.updateLayout(r5, -3, com.bytedance.android.live.core.utils.s1.f(26.0f));
        r5.setAlpha(0.9f);
    L6:
        this.a = (int) UIUtils.dip2Px(r3, 20.0f);
    }
}
