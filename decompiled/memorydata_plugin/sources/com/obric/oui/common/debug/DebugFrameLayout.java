package com.obric.oui.common.debug;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.obric.oui.common.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0014J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0014¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/common/debug/DebugFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onLayout", "", "changed", "", "left", "", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebugFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13478a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/common/debug/DebugFrameLayout$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13478a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DebugFrameLayout(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public DebugFrameLayout(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
    }

    public /* synthetic */ DebugFrameLayout(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        super.onLayout(r4, r5, r6, r7, r8);
        int r3 = r7 - r5;
        f.f13501a.a("DebugFrameLayout onLayout", "Layout left: " + r5 + ", top: " + r6 + ", right: " + r7 + ", bottom: " + r8);
        f.f13501a.a("DebugFrameLayout onLayout", new StringBuilder().append("Layout width: ").append(r3).append(", height: ").append(r8 - r6).toString());
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r0 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        int r1 = View.MeasureSpec.getMode(r11);
        int r13 = View.MeasureSpec.getSize(r11);
        int r2 = getMeasuredWidth();
        int r9 = getMeasuredHeight();
        String r3 = "UNKNOWN";
        if (r0 == Integer.MIN_VALUE) goto L9;
        if (r0 == 0) goto L8;
        if (r0 == 1073741824) goto L7;
        String r4 = "UNKNOWN";
    L10:
        if (r1 == Integer.MIN_VALUE) goto L16;
        if (r1 == 0) goto L15;
        if (r1 != 1073741824) goto L17;
        r3 = "EXACTLY";
    L17:
        f.f13501a.a("DebugFrameLayout onMeasure", "Width mode: " + r4 + ", width size: " + r12 + ", measured width: " + r2);
        f.f13501a.a("DebugFrameLayout onMeasure", "Height mode: " + r3 + ", height size: " + r13 + ", measured height: " + r9);
        return;
    L15:
        r3 = "UNSPECIFIED";
        goto L17
    L16:
        r3 = "AT_MOST";
        goto L17
    L7:
        r4 = "EXACTLY";
        goto L10
    L8:
        r4 = "UNSPECIFIED";
        goto L10
    L9:
        r4 = "AT_MOST";
        goto L10
    }
}
