package com.ss.android.lark.chatwindow.view.burn;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CountDownView extends AppCompatTextView {
    public static final /* synthetic */ int c = 0;
    public CountDownTimer a;
    public volatile boolean b;

    public interface a {
    }

    public void setOnCountDownListener(a r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.TextView*/.onAttachedToWindow();
        if (this.b == true) goto L5;
        return;
    L5:
        if (0 > SystemClock.elapsedRealtime()) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        this.b = false;
        return;
    L10:
        this.b = false;
        CountDownTimer r1 = this.a;
        if (r1 == null) goto L13;
        r1.cancel();
        this.a = null;
    L13:
        this.b = true;
        long r4 = 0 - SystemClock.elapsedRealtime();
        setText(x(r4));
        this.a = new n7b.a(this, r4).start();
        return;
    L7:
        r0 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        CountDownTimer r0 = this.a;
        if (r0 == null) goto L6;
        r0.cancel();
        this.a = null;
        return;
    }

    public CountDownView(Context r2) {
        this(r2, null);
    }

    public static String x(long r6) {
        int r7 = (int) Math.round((r6 * 1.0d) / 1000.0d);
        int r0 = r7 / 86400;
        int r8 = r7 % 86400;
        int r9 = r8 / 3600;
        int r10 = r8 % 3600;
        int r1 = r10 / 60;
        int r11 = r10 % 60;
        if (r0 <= 0) goto L7;
        return String.format("%dd:%02dh:%02dm", new Object[]{Integer.valueOf(r0), Integer.valueOf(r9), Integer.valueOf(r1)});
    L7:
        return String.format("%02dh:%02dm:%02ds", new Object[]{Integer.valueOf(r9), Integer.valueOf(r1), Integer.valueOf(r11)});
    }

    public CountDownView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CountDownView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setMinimumWidth((int) getPaint().measureText(x(0)));
    }
}
