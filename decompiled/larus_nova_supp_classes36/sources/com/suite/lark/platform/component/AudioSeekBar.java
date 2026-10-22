package com.suite.lark.platform.component;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.SeekBar;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/suite/lark/platform/component/AudioSeekBar;", "Landroid/widget/SeekBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "touchDownX", "", "dragging", "", "touchSlop", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "widget-biz-chatkeyboard_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioSeekBar extends SeekBar {
    public float a;
    public boolean b;
    public final int c;

    public AudioSeekBar(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 14, 0);
    }

    public AudioSeekBar(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 12, 0);
    }

    public AudioSeekBar(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, r10, 8, 0);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = r5.getAction();
        if (r0 == 0) goto L30;
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L11;
        return true;
    L11:
        if (this.b == true) goto L13;
        setPressed(false);
        return true;
    L13:
        return super.onTouchEvent(r5);
    L17:
        if (this.b == false) goto L19;
    L22:
        this.b = true;
        return super.onTouchEvent(r5);
    L19:
        if (Math.abs(r5.getX() - this.a) > this.c) goto L22;
        return true;
    L25:
        if (this.b == true) goto L27;
        setPressed(false);
        performClick();
        return true;
    L27:
        return super.onTouchEvent(r5);
    L30:
        this.a = r5.getX();
        this.b = false;
        setPressed(true);
        super.onTouchEvent(r5);
        return true;
    }

    public AudioSeekBar(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, r5);
        this.c = ViewConfiguration.get(r2).getScaledTouchSlop();
    }

    public /* synthetic */ AudioSeekBar(Context r1, AttributeSet r2, int r3, int r4, int r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = R.attr.seekBarStyle;
    L8:
        this(r1, r2, r3, 0);
    }
}
