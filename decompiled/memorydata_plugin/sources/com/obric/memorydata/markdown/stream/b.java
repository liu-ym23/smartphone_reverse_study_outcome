package com.obric.memorydata.markdown.stream;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J4\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016JR\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/markdown/stream/BlinkingCursorSpan;", "Landroid/text/style/ReplacementSpan;", "cursorPaint", "Landroid/graphics/Paint;", "radiusPx", "", "<init>", "(Landroid/graphics/Paint;F)V", "textFontMetrics", "Landroid/graphics/Paint$FontMetrics;", "getSize", "", "paint", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "x", "top", "y", "bottom", "Companion", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10010a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f10011b;
    private final float c;
    private final Paint.FontMetrics d;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/markdown/stream/BlinkingCursorSpan$Companion;", "", "<init>", "()V", "create", "Lcom/obric/memorydata/markdown/stream/BlinkingCursorSpan;", "context", "Landroid/content/Context;", "colorRes", "", "radiusDp", "", "createWithTextColor", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final b a(Context r5, float r6) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "context");
            float r7 = ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDisplayMetrics().density;
            TypedArray r8 = r4.obtainStyledAttributes(new int[]{R.attr.textColorPrimary});
            Intrinsics.checkNotNullExpressionValue(r8, "obtainStyledAttributes(...)");
            int r1 = r8.getColor(0, ViewCompat.MEASURED_STATE_MASK);
            r8.recycle();
            Paint r9 = new Paint(1);
            r9.setColor(r1);
            r9.setStyle(Paint.Style.FILL);
            r9.setDither(true);
            return new b(r9, r6 * r7, null);
        }

        public final b a(Context r2, int r3, float r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            float r5 = ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getDisplayMetrics().density;
            int r6 = ContextCompat.getColor(r1, r3);
            Paint r7 = new Paint(1);
            r7.setColor(r6);
            r7.setStyle(Paint.Style.FILL);
            r7.setDither(true);
            return new b(r7, r4 * r5, null);
        }
    }

    static {
        f10010a = new a(null);
    }

    private b(Paint r1, float r2) {
        this.f10011b = r1;
        this.c = r2;
        this.d = new Paint.FontMetrics();
    }

    public /* synthetic */ b(Paint r1, float r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        float r11 = Math.min(this.c, (r8 - r6) / 3.0f);
        r1.drawCircle(r5 + r11, (r6 + r8) / 2.0f, r11, this.f10011b);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "paint");
        r1.getFontMetrics(this.d);
        if (r5 == null) goto L6;
        r5.top = (int) this.d.top;
        r5.ascent = (int) this.d.ascent;
        r5.descent = (int) this.d.descent;
        r5.bottom = (int) this.d.bottom;
        r5.leading = (int) this.d.leading;
    L6:
        return (int) (this.c * 2);
    }
}
