package com.obric.oui.common.debug;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/obric/oui/common/debug/DebugFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class DebugFrameLayout extends FrameLayout {

    public static final class a {
    }

    static {
    }

    public DebugFrameLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public DebugFrameLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r11, int r12) {
        super.onMeasure(r11, r12);
        int r0 = View.MeasureSpec.getMode(r11);
        int r13 = View.MeasureSpec.getSize(r11);
        int r1 = View.MeasureSpec.getMode(r12);
        int r14 = View.MeasureSpec.getSize(r12);
        int r2 = getMeasuredWidth();
        int r3 = getMeasuredHeight();
        String r4 = "UNKNOWN";
        if (r0 == Integer.MIN_VALUE) goto L9;
        if (r0 == 0) goto L8;
        if (r0 == 1073741824) goto L7;
        String r5 = "UNKNOWN";
    L10:
        if (r1 == Integer.MIN_VALUE) goto L16;
        if (r1 == 0) goto L15;
        if (r1 != 1073741824) goto L17;
        r4 = "EXACTLY";
    L17:
        int r6 = b.a;
        b.a("DebugFrameLayout onMeasure", "Width mode: " + r5 + ", width size: " + r13 + ", measured width: " + r2);
        b.a("DebugFrameLayout onMeasure", "Height mode: " + r4 + ", height size: " + r14 + ", measured height: " + r3);
        return;
    L15:
        r4 = "UNSPECIFIED";
        goto L17
    L16:
        r4 = "AT_MOST";
        goto L17
    L7:
        r5 = "EXACTLY";
        goto L10
    L8:
        r5 = "UNSPECIFIED";
        goto L10
    L9:
        r5 = "AT_MOST";
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        super.onLayout(r4, r5, r6, r7, r8);
        int r9 = r7 - r5;
        int r1 = b.a;
        b.a("DebugFrameLayout onLayout", "Layout left: " + r5 + ", top: " + r6 + ", right: " + r7 + ", bottom: " + r8);
        StringBuilder r10 = new StringBuilder("Layout width: ");
        r10.append(r9);
        r10.append(", height: ");
        r10.append(r8 - r6);
        b.a("DebugFrameLayout onLayout", r10.toString());
    }
}
