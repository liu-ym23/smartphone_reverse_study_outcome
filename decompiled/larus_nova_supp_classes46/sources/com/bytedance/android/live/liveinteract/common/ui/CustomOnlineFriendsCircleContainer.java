package com.bytedance.android.live.liveinteract.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.bytedance.android.livesdk.utils.t6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class CustomOnlineFriendsCircleContainer extends RelativeLayout {
    public int a;
    public int b;
    public int c;
    public int d;

    public CustomOnlineFriendsCircleContainer(Context r2) {
        this(r2, null);
    }

    public CustomOnlineFriendsCircleContainer(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public CustomOnlineFriendsCircleContainer(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = (int) t6.a(getContext(), 18.0f);
        this.a = (int) t6.a(getContext(), 4.0f);
        this.c = (int) t6.a(getContext(), 12.0f);
        this.d = (int) t6.a(getContext(), 3.0f);
    }
}
