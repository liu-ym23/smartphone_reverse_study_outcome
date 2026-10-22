package com.obric.oui.common.debug;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.obric.oui.common.util.d;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/obric/oui/common/debug/DebugFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugFrameLayout extends FrameLayout {

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public DebugFrameLayout(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public DebugFrameLayout(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
    }

    public /* synthetic */ DebugFrameLayout(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        int r15 = r13 - r11;
        d r16 = d.f6398b;
        r16.a("DebugFrameLayout onLayout", "Layout left: " + r11 + ", top: " + r12 + ", right: " + r13 + ", bottom: " + r14);
        StringBuilder r17 = new StringBuilder();
        r17.append("Layout width: ");
        r17.append(r15);
        r17.append(", height: ");
        r17.append(r14 - r12);
        r16.a("DebugFrameLayout onLayout", r17.toString());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        int r14 = View.MeasureSpec.getMode(r11);
        int r15 = View.MeasureSpec.getSize(r11);
        int r16 = getMeasuredWidth();
        int r17 = getMeasuredHeight();
        String r18 = "UNKNOWN";
        if (r12 == Integer.MIN_VALUE) goto L9;
        if (r12 == 0) goto L8;
        if (r12 == 1073741824) goto L7;
        String r19 = "UNKNOWN";
    L10:
        if (r14 == Integer.MIN_VALUE) goto L16;
        if (r14 == 0) goto L15;
        if (r14 != 1073741824) goto L17;
        r18 = "EXACTLY";
    L17:
        d r20 = d.f6398b;
        r20.a("DebugFrameLayout onMeasure", "Width mode: " + r19 + ", width size: " + r13 + ", measured width: " + r16);
        r20.a("DebugFrameLayout onMeasure", "Height mode: " + r18 + ", height size: " + r15 + ", measured height: " + r17);
        return;
    L15:
        r18 = "UNSPECIFIED";
        goto L17
    L16:
        r18 = "AT_MOST";
        goto L17
    L7:
        r19 = "EXACTLY";
        goto L10
    L8:
        r19 = "UNSPECIFIED";
        goto L10
    L9:
        r19 = "AT_MOST";
        goto L10
    }
}
