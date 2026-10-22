package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.DynamicDrawableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class m extends LinkMovementMethod {
    public m() {
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView r17, Spannable r18, MotionEvent r19) {
        Intrinsics.checkNotNull(r19);
        int r1 = r19.getAction();
        if (r1 == 1) goto L7;
        if (r1 == 0) goto L7;
    L57:
        return super.onTouchEvent(r17, r18, r19);
    L7:
        int r3 = (int) r19.getX();
        int r4 = (int) r19.getY();
        Intrinsics.checkNotNull(r17);
        int r5 = r3 - r17.getTotalPaddingLeft();
        int r6 = r4 - r17.getTotalPaddingTop();
        int r7 = r5 + r17.getScrollX();
        int r8 = r6 + r17.getScrollY();
        Layout r9 = r17.getLayout();
        int r10 = r9.getLineForVertical(r8);
        float r11 = r7;
        int r13 = r9.getOffsetForHorizontal(r10, r11);
        Intrinsics.checkNotNull(r18);
        ClickableSpan[] r14 = (ClickableSpan[]) r18.getSpans(r13, r13, ClickableSpan.class);
        ClickableSpan[] r15 = null;
        if (r14.length <= 1) goto L37;
        LinkedHashMap r16 = new LinkedHashMap();
        int r110 = r14.length;
        int r111 = 0;
    L10:
        if (r111 >= r110) goto L22;
        ClickableSpan r112 = r14[r111];
        int r113 = r18.getSpanStart(r112);
        if (((DynamicDrawableSpan[]) r18.getSpans(r113, r18.getSpanEnd(r112), DynamicDrawableSpan.class)).length != 0) goto L14;
        boolean r114 = true;
    L16:
        if ((!r114) == false) goto L20;
        float r115 = r9.getPrimaryHorizontal(r113);
        if (r11 <= r115) goto L20;
        r16.put(r112, Float.valueOf(r11 - r115));
    L20:
        r111 = r111 + 1;
        goto L10
    L14:
        r114 = false;
        goto L16
    L22:
        if ((!r16.isEmpty()) == false) goto L37;
        Iterator r20 = r16.entrySet().iterator();
        float r116 = Float.MAX_VALUE;
        ClickableSpan r117 = null;
    L25:
        if (r20.hasNext() == false) goto L29;
        Map.Entry r118 = (Map.Entry) r20.next();
        if (((Number) r118.getValue()).floatValue() >= r116) goto L25;
        r117 = (ClickableSpan) r118.getKey();
        r116 = ((Number) r118.getValue()).floatValue();
        goto L25
    L29:
        List r21 = CollectionsKt.listOf(r117);
        if ((!r21.isEmpty()) == false) goto L37;
        Object[] r23 = r21.toArray(new ClickableSpan[0]);
        if (r23 == null) goto L35;
        r14 = (ClickableSpan[]) r23;
        goto L37
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L37:
        if (r10 == (r9.getLineCount() - 1)) goto L39;
    L41:
        r15 = r14;
    L42:
        if (r15 != null) goto L44;
    L55:
        Selection.removeSelection(r18);
        goto L57
    L44:
        if (r15.length != 0) goto L46;
        boolean r24 = true;
    L48:
        if ((!r24) == false) goto L55;
        ClickableSpan r25 = r15[0];
        if (r1 != 1) goto L52;
        r25.onClick(r17);
    L54:
        return true;
    L52:
        if (r1 != 0) goto L54;
        Selection.setSelection(r18, r18.getSpanStart(r25), r18.getSpanEnd(r25));
        goto L54
    L46:
        r24 = false;
        goto L48
    L39:
        if (r11 <= r9.getLineRight(r10)) goto L41;
        goto L41
    }
}
