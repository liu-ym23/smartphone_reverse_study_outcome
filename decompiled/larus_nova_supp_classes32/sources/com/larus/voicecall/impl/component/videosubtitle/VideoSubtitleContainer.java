package com.larus.voicecall.impl.component.videosubtitle;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.common.apphost.AppHost;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/voicecall/impl/component/videosubtitle/VideoSubtitleContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "textView", "Landroid/widget/TextView;", "onFinishInflate", NameKeys.UnloadStrategy_No_Strategy, "onMeasure", "widthMeasureSpec", NameKeys.UnloadStrategy_No_Strategy, "heightMeasureSpec", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoSubtitleContainer extends FrameLayout {
    public TextView a;

    public static final class a {
    }

    static {
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r0 = getChildAt(0);
        if ((r0 instanceof TextView) == false) goto L5;
        TextView r1 = (TextView) r0;
    L6:
        this.a = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public VideoSubtitleContainer(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public VideoSubtitleContainer(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        super.onMeasure(r5, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r6), 0));
        TextView r7 = this.a;
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.getLayout().getLineCount() <= 2) goto L18;
        int r8 = getMeasuredWidth();
        if (Build.VERSION.SDK_INT < 34) goto L9;
        int r1 = (r7.getLayout().getLineBottom(1, false) - r7.getLayout().getLineTop(0)) + getPaddingBottom();
        int r9 = getPaddingTop();
    L10:
        int r2 = r1 + r9;
        AppHost.Companion r10 = AppHost.a;
        if (r10.isTestChannel() == false) goto L13;
    L14:
        int r11 = c68.b.a;
        c68.b.d("VideoSubtitleContainer", "onMeasure: targetWidth = " + r8 + ", targetHeight = " + r2);
    L15:
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(r8, 1073741824), View.MeasureSpec.makeMeasureSpec(r2, 1073741824));
        return;
    L13:
        if (r10.isDebugChannel() == false) goto L15;
    L9:
        r1 = ((r7.getLayout().getLineBottom(1) - ((int) r7.getLayout().getSpacingAdd())) - r7.getLayout().getLineTop(0)) + getPaddingBottom();
        r9 = getPaddingTop();
        goto L10
    }
}
