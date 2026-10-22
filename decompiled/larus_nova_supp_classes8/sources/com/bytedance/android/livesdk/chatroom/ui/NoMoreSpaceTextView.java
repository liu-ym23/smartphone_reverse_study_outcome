package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.widget.LiveTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class NoMoreSpaceTextView extends LiveTextView {
    public int c;
    public int d;
    public boolean e;
    public int f;

    public final void scrollBy(int r1, int r2) {
    }

    public final void scrollTo(int r1, int r2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getSpaceExtra() {
        if (getLineCount() == this.d) goto L5;
        int r0 = getLineCount();
        this.d = r0;
        this.c = 0;
        int r1 = r0 - 1;
        Layout r2 = getLayout();
        if (r1 < 0) goto L12;
        if (getMeasuredHeight() != r2.getHeight()) goto L12;
        Paint.FontMetricsInt r3 = r2.getPaint().getFontMetricsInt();
        Rect r4 = new Rect();
        this.c = (r4.bottom - (r3.ascent - r2.getLineAscent(r1))) - (getLineBounds(r1, r4) + r3.bottom);
    L12:
        return this.c;
    L5:
        return this.c;
    }

    public NoMoreSpaceTextView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r3) {
        super/*android.widget.TextView*/.onDraw(r3);     // Catch: Exception -> L4
    L7:
        if (this.e == false) goto L12;
        postInvalidateDelayed(this.f);
        return;
    L12:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void setAlwaysInvalidate(boolean r1) {
        this.e = r1;
    }

    public void setAlwaysInvalidateIntervalInMS(int r1) {
        this.f = r1;
    }

    public NoMoreSpaceTextView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r2, int r3) {
        super/*androidx.appcompat.widget.AppCompatTextView*/.onMeasure(r2, r3);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() - getSpaceExtra());
    }

    public NoMoreSpaceTextView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        SettingKey r5 = new SettingKey("live_text_message_invalidate_value", "延迟刷新值,默认50毫秒", 50, 50);
        this.e = false;
        this.f = ((Integer) com.bytedance.android.live.liveinteract.f.b(r5)).intValue();
    }
}
