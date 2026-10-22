package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class AvatarIconView extends FrameLayout {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final int d;
    public final int e;
    public final int f;

    public AvatarIconView(Context r2) {
        this(r2, null);
    }

    public void setAvatar(py.k r4) {
        if (r4 == null) goto L5;
        ImageView r0 = this.a;
        int r1 = this.d;
        com.bytedance.android.livesdk.chatroom.utils.a1.x(r0, r4, r1, r1, 2131251889);
        return;
    }

    public void setAvatarBorder(py.k r4) {
        if (r4 == null) goto L4;
        this.b.setVisibility(0);
        ImageView r0 = this.b;
        int r1 = this.e;
        ImageUtil.loadImage(r0, r4, r1, r1, null);
        return;
    L4:
        this.b.setVisibility(8);
    }

    public void setIcon(py.k r9) {
        if (r9 == null) goto L4;
        this.c.setVisibility(0);
        ImageView r2 = this.c;
        int r5 = this.f;
        ImageUtil.loadImage(r2, r9, r5, r5, -1, null);
        return;
    L4:
        this.c.setVisibility(4);
    }

    public void setAvatar(int r3) {
        ImageUtil.loadRoundResource(this.a, r3, -1, -1);
    }

    public AvatarIconView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public AvatarIconView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        int r6 = (int) UIUtils.dip2Px(r3, 100.0f);
        this.d = r6;
        int r0 = (int) UIUtils.dip2Px(r3, 42.0f);
        this.f = r0;
        if (r4 == null) goto L5;
        TypedArray r7 = r3.obtainStyledAttributes(r4, new int[]{2130974694, 2130974695, 2130974762});
        this.d = r7.getDimensionPixelSize(1, r6);
        this.e = r7.getDimensionPixelSize(0, 0);
        this.f = r7.getDimensionPixelSize(2, r0);
        r7.recycle();
    L5:
        ImageView r8 = new ImageView(r3);
        this.a = r8;
        int r1 = this.d;
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(r1, r1);
        r9.gravity = 17;
        r8.setLayoutParams(r9);
        addView(r8);
        ImageView r10 = new ImageView(r3);
        this.b = r10;
        int r2 = this.e;
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(r2, r2);
        r11.gravity = 17;
        r10.setLayoutParams(r11);
        addView(r10);
        ImageView r12 = new ImageView(r3);
        this.c = r12;
        int r13 = this.f;
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(r13, r13);
        r14.bottomMargin = (int) UIUtils.dip2Px(r3, 3.0f);
        r14.rightMargin = (int) UIUtils.dip2Px(r3, 2.0f);
        r14.gravity = 8388693;
        r12.setLayoutParams(r14);
        addView(r12);
        r12.setVisibility(4);
    }
}
