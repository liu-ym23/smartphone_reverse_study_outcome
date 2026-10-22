package com.obric.memorydata.markdown.stream;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LineBackgroundSpan;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ`\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00030\u00030\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/markdown/stream/PreciseUnderlineSpan;", "Landroid/text/style/LineBackgroundSpan;", "textView", "Landroid/widget/TextView;", TypedValues.Custom.S_COLOR, "", "thicknessPx", "gapPx", "<init>", "(Landroid/widget/TextView;III)V", "getColor", "()I", "getThicknessPx", "getGapPx", "textViewRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "drawBackground", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "left", "right", "top", "baseline", "bottom", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "lineNumber", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i implements LineBackgroundSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f10026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10027b;
    private final int c;
    private final int d;
    private final WeakReference<TextView> e;

    public i(TextView r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        this.f10026a = r2;
        this.f10027b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new WeakReference(r2);
    }

    @Override // android.text.style.LineBackgroundSpan
    public void drawBackground(Canvas r15, Paint r16, int r17, int r18, int r19, int r20, int r21, CharSequence r22, int r23, int r24, int r25) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "canvas");
        Intrinsics.checkNotNullParameter(r16, "paint");
        Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        if (this.c > 0) goto L5;
        return;
    L5:
        TextView r5 = (TextView) ZeusTransformUtils.preCheckCast(this.e.get(), TextView.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L35;
        Layout r6 = r5.getLayout();
        if (r6 != null) goto L11;
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, Spanned.class) == false) goto L13;
        Spanned r4 = (Spanned) ZeusTransformUtils.preCheckCast(r3, Spanned.class, "com.obric.memorydata.plugin");
    L14:
        if (r4 != null) goto L16;
        return;
    L16:
        int r7 = r4.getSpanStart(this);
        int r8 = r4.getSpanEnd(this);
        RunLog.INSTANCE.debug("LinkUnderlineDebug", "spanStart=" + r7 + ", spanEnd=" + r8 + ", text.length=" + r3.length());
        if (r7 >= 0) goto L19;
    L21:
        int r9 = r6.getLineStart(r25);
        int r10 = r6.getLineEnd(r25);
        int r11 = r6.getLineVisibleEnd(r25);
        int r12 = Math.max(r7, r9);
        int r13 = Math.min(r8, r11);
        RunLog.INSTANCE.debug("LinkUnderlineDebug", "line=" + r25 + ", lineRange=" + r9 + '-' + r10 + ", visibleEnd=" + r11 + ", drawRange=" + r12 + '-' + r13);
        if (r12 < r13) goto L25;
        RunLog.INSTANCE.debug("LinkUnderlineDebug", "SKIP: drawStart >= drawEnd");
        return;
    L25:
        float r14 = r6.getPrimaryHorizontal(r12);
        if (r13 < r11) goto L28;
        float r26 = r6.getLineRight(r25);
    L29:
        float r27 = Math.min(r14, r26);
        float r28 = Math.max(r14, r26);
        RunLog.INSTANCE.debug("LinkUnderlineDebug", "xStart=" + r14 + ", xEnd=" + r26 + ", actualXStart=" + r27 + ", actualXEnd=" + r28);
        if (r28 > (1.0f + r27)) goto L33;
        RunLog.INSTANCE.debug("LinkUnderlineDebug", "SKIP: zero width");
        return;
    L33:
        int r29 = r20 + this.d;
        RunLog.INSTANCE.debug("LinkUnderlineDebug", "DRAW: line=" + r25 + ", x=[" + r27 + " - " + r28 + "], y=" + r29);
        int r2 = r16.getColor();
        Paint.Style r30 = r16.getStyle();
        r16.setColor(this.f10027b);
        r16.setStyle(Paint.Style.FILL);
        r15.drawRect(r27, r29, r28, r29 + this.c, r16);
        r16.setColor(r2);
        r16.setStyle(r30);
        return;
    L28:
        r26 = r6.getPrimaryHorizontal(r13);
        goto L29
    L19:
        if (r8 > r3.length()) goto L21;
        RunLog.INSTANCE.debug("LinkUnderlineDebug", "span text: [" + r3.subSequence(r7, r8) + ']');
        goto L21
    L13:
        r4 = null;
        goto L14
    }
}
