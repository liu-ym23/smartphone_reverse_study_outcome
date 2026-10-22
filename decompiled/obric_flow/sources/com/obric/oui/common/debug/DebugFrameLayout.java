package com.obric.oui.common.debug;

import ai.j0;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/common/debug/DebugFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebugFrameLayout extends FrameLayout {
    @JvmOverloads
    public DebugFrameLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        int r14 = r12 - r10;
        StringBuilder r15 = j0.v("Layout left: ", r10, r11, ", top: ", ", right: ");
        r15.append(r12);
        r15.append(", bottom: ");
        r15.append(r13);
        String r16 = r15.toString();
        Intrinsics.checkNotNullParameter("DebugFrameLayout onLayout", "tag");
        Intrinsics.checkNotNullParameter(r16, "msg");
        Log.d("DebugFrameLayout onLayout", r16);
        String r17 = "Layout width: " + r14 + ", height: " + (r13 - r11);
        Intrinsics.checkNotNullParameter("DebugFrameLayout onLayout", "tag");
        Intrinsics.checkNotNullParameter(r17, "msg");
        Log.d("DebugFrameLayout onLayout", r17);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r5 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        int r13 = View.MeasureSpec.getMode(r11);
        int r14 = View.MeasureSpec.getSize(r11);
        int r15 = getMeasuredWidth();
        int r16 = getMeasuredHeight();
        String r17 = "AT_MOST";
        if (r5 == Integer.MIN_VALUE) goto L9;
        if (r5 == 0) goto L8;
        if (r5 == 1073741824) goto L7;
        String r18 = "UNKNOWN";
    L10:
        if (r13 == Integer.MIN_VALUE) goto L16;
        if (r13 == 0) goto L15;
        if (r13 == 1073741824) goto L14;
        r17 = "UNKNOWN";
        goto L16
    L14:
        r17 = "EXACTLY";
        goto L16
    L15:
        r17 = "UNSPECIFIED";
    L16:
        String r19 = "Width mode: " + r18 + ", width size: " + r12 + ", measured width: " + r15;
        Intrinsics.checkNotNullParameter("DebugFrameLayout onMeasure", "tag");
        Intrinsics.checkNotNullParameter(r19, "msg");
        Log.d("DebugFrameLayout onMeasure", r19);
        String r20 = "Height mode: " + r17 + ", height size: " + r14 + ", measured height: " + r16;
        Intrinsics.checkNotNullParameter("DebugFrameLayout onMeasure", "tag");
        Intrinsics.checkNotNullParameter(r20, "msg");
        Log.d("DebugFrameLayout onMeasure", r20);
        return;
    L7:
        r18 = "EXACTLY";
        goto L10
    L8:
        r18 = "UNSPECIFIED";
        goto L10
    L9:
        r18 = "AT_MOST";
        goto L10
    }

    @JvmOverloads
    public DebugFrameLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
    }
}
