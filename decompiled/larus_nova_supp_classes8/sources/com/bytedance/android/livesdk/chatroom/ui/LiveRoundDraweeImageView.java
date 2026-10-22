package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveRoundDraweeImageView extends HSImageView {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public LiveRoundDraweeImageView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r8) {
        int r0 = getWidth();
        int r1 = getHeight();
        int r2 = Math.max(this.a, this.c) + Math.max(this.b, this.d);
        int r3 = Math.max(this.a, this.b) + Math.max(this.c, this.d);
        if (r0 < r2) goto L6;
        if (r1 <= r3) goto L6;
        Path r4 = new Path();
        r4.moveTo(this.a, 0.0f);
        r4.lineTo(r0 - this.b, 0.0f);
        float r5 = r0;
        r4.quadTo(r5, 0.0f, r5, this.b);
        r4.lineTo(r5, r1 - this.d);
        float r6 = r1;
        r4.quadTo(r5, r6, r0 - this.d, r6);
        r4.lineTo(this.c, r6);
        r4.quadTo(0.0f, r6, 0.0f, r1 - this.c);
        r4.lineTo(0.0f, this.a);
        r4.quadTo(0.0f, 0.0f, this.a, 0.0f);
        r8.clipPath(r4);
    L6:
        super/*android.widget.ImageView*/.onDraw(r8);
    }

    public LiveRoundDraweeImageView(Context r6, AttributeSet r7) {
        super(r6, r7);
        if (r7 == null) goto L15;
        TypedArray r8 = r6.obtainStyledAttributes(r7, new int[]{2130974772, 2130974773, 2130974774, 2130974775, 2130974776});
        int r0 = r8.getDimensionPixelOffset(0, 0);
        int r1 = r8.getDimensionPixelOffset(3, 0);
        this.a = r1;
        int r2 = r8.getDimensionPixelOffset(4, 0);
        this.b = r2;
        int r3 = r8.getDimensionPixelOffset(1, 0);
        this.c = r3;
        int r9 = r8.getDimensionPixelOffset(2, 0);
        this.d = r9;
        if (r1 != 0) goto L7;
        this.a = r0;
    L7:
        if (r2 != 0) goto L9;
        this.b = r0;
    L9:
        if (r3 != 0) goto L11;
        this.c = r0;
    L11:
        if (r9 != 0) goto L13;
        this.d = r0;
    L13:
        r8.recycle();
        return;
    }
}
