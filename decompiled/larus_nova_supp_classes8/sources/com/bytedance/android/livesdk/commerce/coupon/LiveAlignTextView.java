package com.bytedance.android.livesdk.commerce.coupon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveAlignTextView extends View {
    public List<m> a;
    public final Paint b;
    public List<Rect> c;

    public LiveAlignTextView(Context r1) {
        super(r1);
        this.b = new Paint();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        super.onDraw(r9);
        int r0 = getHeight();
        if (this.a != null) goto L5;
        return;
    L5:
        if (this.c == null) goto L20;
        int r1 = 0;
        int r2 = 0;
    L9:
        if (r1 >= this.a.size()) goto L21;
        m r3 = (m) ListProtector.get(this.a, r1);
        Rect r4 = (Rect) ListProtector.get(this.c, r1);
        Paint r5 = this.b;
        if (r3 == null) goto L14;
        if (r5 == null) goto L14;
        r5.setTextSize(r3.b);
        r5.setColor(r3.c);
        r5.setTypeface(r3.e);
    L14:
        int r6 = r2 + r3.d;
        r9.drawText(r3.a, r6 - r4.left, r0 - r4.bottom, this.b);
        r2 = r6 + r4.width();
        r1 = r1 + 1;
        goto L9
    L21:
        return;
    }

    public void setTextList(List<m> r6) {
        if (r6 != null) goto L5;
        List<m> r1 = null;
    L14:
        this.a = r1;
        if (r1 != null) goto L17;
    L28:
        this.c = null;
        return;
    L17:
        if (r1.isEmpty() == true) goto L28;
        this.c = new ArrayList();
        Iterator<m> r7 = r6.iterator();
    L21:
        if (r7.hasNext() == false) goto L27;
        m r0 = r7.next();
        Rect r2 = new Rect();
        Paint r3 = this.b;
        if (r0 == null) goto L26;
        if (r3 == null) goto L26;
        r3.setTextSize(r0.b);
        r3.setColor(r0.c);
        r3.setTypeface(r0.e);
    L26:
        String r4 = r0.a;
        this.b.getTextBounds(r4, 0, r4.length(), r2);
        ((ArrayList) this.c).add(r2);
        goto L21
    L27:
        return;
    L5:
        Iterator<m> r5 = r6.iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        m r8 = r5.next();
        if (r8 == null) goto L12;
        if (TextUtils.isEmpty(r8.a) == false) goto L7;
    L12:
        r5.remove();
        goto L7
    L13:
        r1 = r6;
        goto L14
    }

    public LiveAlignTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = new Paint();
    }

    @Override // android.view.View
    public final void onMeasure(int r7, int r8) {
        int r0 = View.MeasureSpec.getMode(r7);
        int r9 = View.getDefaultSize(getMinimumWidth(), r7);
        int r2 = 0;
        if (r0 != 1073741824) goto L6;
    L18:
        int r1 = View.MeasureSpec.getMode(r8);
        int r10 = View.getDefaultSize(getMinimumHeight(), r8);
        if (r1 != 1073741824) goto L21;
        r2 = r10;
    L33:
        setMeasuredDimension(r9, r2);
        return;
    L21:
        List<Rect> r3 = this.c;
        if (r3 == null) goto L33;
        Iterator r4 = ((ArrayList) r3).iterator();
    L26:
        if (r4.hasNext() == false) goto L30;
        Rect r5 = (Rect) r4.next();
        if (r5.height() <= r2) goto L26;
        r2 = r5.height();
        goto L26
    L30:
        if (r10 == 0) goto L33;
        r2 = Math.min(r2, r10);
        goto L33
    L6:
        if (this.a != null) goto L8;
    L17:
        r9 = 0;
        goto L18
    L8:
        if (this.c == null) goto L17;
        int r6 = 0;
        int r11 = 0;
    L12:
        if (r6 >= this.a.size()) goto L14;
        Rect r12 = (Rect) ListProtector.get(this.c, r6);
        r11 = (r11 + ((m) ListProtector.get(this.a, r6)).d) + r12.width();
        r6 = r6 + 1;
        goto L12
    L14:
        if (r9 != 0) goto L16;
        r9 = r11;
        goto L18
    L16:
        r9 = Math.min(r11, r9);
        goto L18
    }

    public LiveAlignTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = new Paint();
    }
}
