package io.noties.markwon.core.spans.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJR\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\u000fH\u0016J4\u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lio/noties/markwon/core/spans/codeblock/CustomDynamicDrawableSpan;", "Landroid/text/style/DynamicDrawableSpan;", "context", "Landroid/content/Context;", "resourceId", "", "verticalPadding", "endPadding", "startPadding", "verticalAlignment", "isFinished", "", "(Landroid/content/Context;IIIIIZ)V", "mDrawableRef", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/Drawable;", "draw", "", "canvas", "Landroid/graphics/Canvas;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getCachedDrawable", "getDrawable", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d extends DynamicDrawableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f16450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16451b;
    private final int c;
    private final int d;
    private final int e;
    private final boolean f;
    private WeakReference<Drawable> g;

    public d(Context r3, int r4, int r5, int r6, int r7, int r8, boolean r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r8);
        this.f16450a = ZeusTransformUtils.wrapperContext(r10, "com.obric.memorydata.plugin");
        this.f16451b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r9;
    }

    private final Drawable a() {
        WeakReference<Drawable> r0 = this.g;
        if (r0 == null) goto L5;
        Drawable r1 = (Drawable) ZeusTransformUtils.preCheckCast(r0.get(), Drawable.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L9;
        Drawable r2 = getDrawable();
        this.g = new WeakReference(r2);
        return r2;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        Drawable r11 = a();
        if (r11 != null) goto L5;
        return;
    L5:
        r1.save();
        int r12 = r8 - r11.getBounds().bottom;
        if (((DynamicDrawableSpan) this).mVerticalAlignment != 1) goto L9;
        r12 = r12 - r9.getFontMetricsInt().descent;
    L11:
        r1.translate(r5 + this.e, r12 - this.c);
        if (this.f == false) goto L14;
        int r0 = 255;
    L15:
        r11.setAlpha(r0);
        r11.draw(r1);
        r1.restore();
        return;
    L14:
        r0 = 127;
        goto L15
    L9:
        if (((DynamicDrawableSpan) this).mVerticalAlignment != 2) goto L11;
        r12 = (r6 + ((r8 - r6) / 2)) - (r11.getBounds().height() / 2);
        goto L11
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable r3 = ContextCompat.getDrawable(this.f16450a, this.f16451b);
        if (r3 == null) goto L5;
        r3.setBounds(0, 0, r3.getIntrinsicWidth(), r3.getIntrinsicHeight());
        return r3;
    L5:
        return null;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "paint");
        Drawable r7 = a();
        if (r7 != null) goto L5;
        return 0;
    L5:
        Rect r8 = r7.getBounds();
        Intrinsics.checkNotNullExpressionValue(r8, "d.getBounds()");
        if (r5 == null) goto L9;
        r5.ascent = -r8.bottom;
        r5.descent = 0;
        r5.top = r5.ascent;
        r5.bottom = 0;
    L9:
        return (r8.right + this.d) + this.e;
    }
}
