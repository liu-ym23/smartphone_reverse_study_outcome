package com.larus.dora.impl.device.settings.lab.env.timer.reels.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import v49.f;
import v49.g;
import v49.h;
import v49.i;
import v49.j;
import v49.k;
import v49.l;
import v49.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u009c\u00012\u00020\u0001:\u0002\u009c\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\u0010H\u0014J\b\u0010H\u001a\u00020EH\u0014J\b\u0010I\u001a\u00020EH\u0002J\u0010\u0010N\u001a\u00020E2\u0006\u0010O\u001a\u00020PH\u0014J\u0010\u0010Q\u001a\u00020E2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010R\u001a\u00020E2\u0006\u0010O\u001a\u00020PH\u0002J \u0010S\u001a\u00020E2\u0006\u0010O\u001a\u00020P2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010T\u001a\u00020\u0010H\u0002J\u0012\u0010U\u001a\u0004\u0018\u00010A2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010V\u001a\u00020E2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010W\u001a\u00020E2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020ZH\u0016J\b\u0010[\u001a\u00020EH\u0016J\u0006\u0010\\\u001a\u00020\u0010J\u0006\u0010]\u001a\u00020\u0010J\u0010\u0010{\u001a\u0004\u0018\u00010A2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0081\u0001\u001a\u00020E2\u0006\u0010\u000f\u001a\u00020\u00102\t\b\u0002\u0010\u0082\u0001\u001a\u00020\tJ#\u0010\u0083\u0001\u001a\u00020E2\u0014\u0010\u0084\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020A0\u0085\u0001\"\u00020A¢\u0006\u0003\u0010\u0086\u0001J\u0019\u0010\u0083\u0001\u001a\u00020E2\u0010\u0010\u0084\u0001\u001a\u000b\u0012\u0004\u0012\u00020A\u0018\u00010\u0087\u0001J\u0010\u0010\u0088\u0001\u001a\u00020E2\u0007\u0010\u0089\u0001\u001a\u00020CR$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R$\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R$\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b-\u0010)R\u001b\u0010/\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010+\u001a\u0004\b0\u0010)R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010+\u001a\u0004\b4\u00105R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010+\u001a\u0004\b8\u00105R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010+\u001a\u0004\b<\u0010=R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0013R\u0014\u0010L\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u0013R$\u0010_\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0013\"\u0004\ba\u0010\u0015R$\u0010c\u001a\u00020\t2\u0006\u0010b\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\f\"\u0004\bd\u0010\u000eR$\u0010g\u001a\u00020f2\u0006\u0010e\u001a\u00020f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR$\u0010m\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bn\u0010\u0013\"\u0004\bo\u0010\u0015R$\u0010p\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bq\u0010\u0013\"\u0004\br\u0010\u0015R$\u0010s\u001a\u00020f2\u0006\u0010e\u001a\u00020f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bt\u0010i\"\u0004\bu\u0010kR$\u0010v\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bw\u0010\u0013\"\u0004\bx\u0010\u0015R\u0011\u0010y\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bz\u0010\u0013R\u0013\u0010|\u001a\u0004\u0018\u00010A8F¢\u0006\u0006\u001a\u0004\b}\u0010~R&\u0010\u007f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0080\u0001\u0010\u0013\"\u0005\b\u0081\u0001\u0010\u0015R0\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00012\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001d\u0010\u0090\u0001\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010\f\"\u0005\b\u0092\u0001\u0010\u000eR\u001d\u0010\u0093\u0001\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\f\"\u0005\b\u0095\u0001\u0010\u000eR\u001d\u0010\u0096\u0001\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\f\"\u0005\b\u0098\u0001\u0010\u000eR\u001d\u0010\u0099\u0001\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010\f\"\u0005\b\u009b\u0001\u0010\u000e¨\u0006\u009d\u0001"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/WheelView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isShow", "", "showDivider", "getShowDivider", "()Z", "setShowDivider", "(Z)V", "index", "", "startIndex", "getStartIndex", "()I", "setStartIndex", "(I)V", "count", "itemCount", "getItemCount", "setItemCount", "width", "itemWidthPx", "getItemWidthPx", "setItemWidthPx", "height", "itemHeightPx", "getItemHeightPx", "setItemHeightPx", "mClipRectTop", "Landroid/graphics/Rect;", "mClipRectMiddle", "mClipRectBottom", "mTextPaint", "Landroid/text/TextPaint;", "getMTextPaint", "()Landroid/text/TextPaint;", "mTextPaint$delegate", "Lkotlin/Lazy;", "mTagTextPaint", "getMTagTextPaint", "mTagTextPaint$delegate", "mSelectedTextPaint", "getMSelectedTextPaint", "mSelectedTextPaint$delegate", "mDividerPaint", "Landroid/graphics/Paint;", "getMDividerPaint", "()Landroid/graphics/Paint;", "mDividerPaint$delegate", "mHighlightPaint", "getMHighlightPaint", "mHighlightPaint$delegate", "mScroller", "Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/WheelScroller;", "getMScroller", "()Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/WheelScroller;", "mScroller$delegate", "mEntries", "", "", "mTag", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onAttachedToWindow", "updateClipRect", "wheelWidth", "getWheelWidth", "wheelHeight", "getWheelHeight", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawTag", "drawItems", "drawItem", "offset", "getStringFromIndex", "drawHighlight", "drawDivider", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "computeScroll", "getClipMiddleRectTop", "getClipMiddleRectBottom", "radius", "highlightConorRadiusPx", "getHighlightConorRadiusPx", "setHighlightConorRadiusPx", "cyclic", "isCyclic", "setCyclic", "size", "", "textSizePx", "getTextSizePx", "()F", "setTextSizePx", "(F)V", "color", "textColor", "getTextColor", "setTextColor", "selectedTextColor", "getSelectedTextColor", "setSelectedTextColor", "selectedTextSizePx", "getSelectedTextSizePx", "setSelectedTextSizePx", "highlightColor", "getHighlightColor", "setHighlightColor", "itemSize", "getItemSize", "getItem", "currentItem", "getCurrentItem", "()Ljava/lang/String;", "currentIndex", "getCurrentIndex", "setCurrentIndex", "animated", "setEntries", "entries", "", "([Ljava/lang/String;)V", "", "setTagText", "tag", "onWheelChangedListener", "Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/OnWheelChangedListener;", "getOnWheelChangedListener", "()Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/OnWheelChangedListener;", "setOnWheelChangedListener", "(Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/OnWheelChangedListener;)V", "showTopLeftCorner", "getShowTopLeftCorner", "setShowTopLeftCorner", "showTopRightCorner", "getShowTopRightCorner", "setShowTopRightCorner", "showBottomLeftCorner", "getShowBottomLeftCorner", "setShowBottomLeftCorner", "showBottomRightCorner", "getShowBottomRightCorner", "setShowBottomRightCorner", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WheelView extends View {
    public static final /* synthetic */ int w = 0;
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public Rect f;
    public Rect g;
    public Rect h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final List<String> o;
    public CharSequence p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;

    public static final class a {
    }

    static {
    }

    private final Paint getMDividerPaint() {
        return (Paint) this.l.getValue();
    }

    private final Paint getMHighlightPaint() {
        return (Paint) this.m.getValue();
    }

    private final g getMScroller() {
        return (g) this.n.getValue();
    }

    private final TextPaint getMSelectedTextPaint() {
        return (TextPaint) this.k.getValue();
    }

    private final TextPaint getMTagTextPaint() {
        return (TextPaint) this.j.getValue();
    }

    private final TextPaint getMTextPaint() {
        return (TextPaint) this.i.getValue();
    }

    public final int getClipMiddleRectBottom() {
        Rect r0 = this.g;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.bottom;
    }

    public final int getClipMiddleRectTop() {
        Rect r0 = this.g;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.top;
    }

    public final int getItemSize() {
        return ((ArrayList) this.o).size();
    }

    private final int getWheelHeight() {
        return ((getPaddingTop() + getPaddingBottom()) + (this.e * this.c)) - MathKt.roundToInt(TypedValue.applyDimension(1, 30, a(Resources.getSystem())));
    }

    private final int getWheelWidth() {
        return (getPaddingLeft() + getPaddingRight()) + this.d;
    }

    @Override // android.view.View
    public final void computeScroll() {
        g r0 = getMScroller();
        if (r0.d == false) goto L9;
        r0.d = r0.computeScrollOffset();
        r0.a(r0.getCurrY() - r0.b, "computeScroll");
        if (r0.d == false) goto L7;
        r0.a.postInvalidate();
        return;
    L7:
        g.c(r0);
        return;
    }

    public final int getCurrentIndex() {
        return getMScroller().b();
    }

    public final String getCurrentItem() {
        int r0 = getCurrentIndex();
        if (r0 >= 0) goto L8;
        if (r0 < ((ArrayList) this.o).size()) goto L8;
        return null;
    L8:
        return (String) ListProtector.get(this.o, r0);
    }

    public final int getHighlightColor() {
        return getMHighlightPaint().getColor();
    }

    public final v49.a getOnWheelChangedListener() {
        return getMScroller().g;
    }

    public final int getSelectedTextColor() {
        return getMSelectedTextPaint().getColor();
    }

    public final float getSelectedTextSizePx() {
        return getMSelectedTextPaint().getTextSize();
    }

    public final int getTextColor() {
        return getMTextPaint().getColor();
    }

    public final float getTextSizePx() {
        return getMTextPaint().getTextSize();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        g r0 = getMScroller();
        Context r1 = getContext();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    public final int getHighlightConorRadiusPx() {
        return this.q;
    }

    public final int getItemCount() {
        return this.c;
    }

    public final int getItemHeightPx() {
        return this.e;
    }

    public final int getItemWidthPx() {
        return this.d;
    }

    public final boolean getShowBottomLeftCorner() {
        return this.u;
    }

    public final boolean getShowBottomRightCorner() {
        return this.v;
    }

    public final boolean getShowDivider() {
        return this.a;
    }

    public final boolean getShowTopLeftCorner() {
        return this.s;
    }

    public final boolean getShowTopRightCorner() {
        return this.t;
    }

    public final int getStartIndex() {
        return this.b;
    }

    public WheelView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static DisplayMetrics a(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    @Override // android.view.View
    public final void onDraw(Canvas r22) {
        Intrinsics.checkNotNullParameter(r22, "canvas");
        g r1 = getMScroller();
        if (r1.a.getItemHeightPx() != 0) goto L5;
        int r2 = 0;
    L6:
        g r3 = getMScroller();
        if (r3.a.getItemHeightPx() != 0) goto L9;
        int r10 = 0;
    L10:
        int r4 = (this.c + 1) / 2;
        int r5 = r2 - r4;
        if (r10 >= 0) goto L13;
        r5 = r5 - 1;
    L15:
        int r6 = r2 + r4;
    L16:
        int r13 = r6;
        int r14 = r5;
    L17:
        if (r14 >= r13) goto L61;
        int r7 = ((ArrayList) this.o).size();
        if (r7 != 0) goto L22;
    L33:
        String r8 = null;
    L34:
        String r15 = r8;
        if (r15 == null) goto L59;
        Rect r9 = this.g;
        Intrinsics.checkNotNull(r9);
        int r11 = r9.centerX();
        Rect r12 = this.g;
        Intrinsics.checkNotNull(r12);
        int r16 = r12.centerY();
        Paint.FontMetrics r17 = getMTextPaint().getFontMetrics();
        float r18 = r17.top + r17.bottom;
        float r20 = 2;
        int r21 = (int) (r18 / r20);
        Paint.FontMetrics r23 = getMSelectedTextPaint().getFontMetrics();
        int r24 = (int) ((r23.top + r23.bottom) / r20);
        g r25 = getMScroller();
        if (r25.a.getItemHeightPx() != 0) goto L40;
        int r26 = 0;
    L41:
        int r27 = r14 - r26;
        int r28 = this.e;
        int r30 = (r27 * r28) - r10;
        if (1 > r30) goto L45;
        if (r30 >= r28) goto L45;
        boolean r31 = true;
    L46:
        if (r31 == false) goto L49;
        r22.save();
        Rect r32 = this.g;
        Intrinsics.checkNotNull(r32);
        r22.clipRect(r32);
        float r33 = r11;
        int r110 = r30 + r16;
        r22.drawText(r15, 0, r15.length(), r33, r110 - r24, getMSelectedTextPaint());
        r22.restore();
        r22.save();
        Rect r34 = this.h;
        Intrinsics.checkNotNull(r34);
        r22.clipRect(r34);
        r22.drawText(r15, 0, r15.length(), r33, r110 - r21, getMTextPaint());
        r22.restore();
        goto L59
    L49:
        if (r30 < r28) goto L51;
        r22.save();
        Rect r35 = this.h;
        Intrinsics.checkNotNull(r35);
        r22.clipRect(r35);
        r22.drawText(r15, 0, r15.length(), r11, (r16 + r30) - r21, getMTextPaint());
        r22.restore();
        goto L59
    L51:
        if (r30 >= 0) goto L56;
        if (r30 <= (-r28)) goto L56;
        r22.save();
        Rect r36 = this.g;
        Intrinsics.checkNotNull(r36);
        r22.clipRect(r36);
        float r37 = r11;
        int r111 = r30 + r16;
        r22.drawText(r15, 0, r15.length(), r37, r111 - r24, getMSelectedTextPaint());
        r22.restore();
        r22.save();
        Rect r38 = this.f;
        Intrinsics.checkNotNull(r38);
        r22.clipRect(r38);
        r22.drawText(r15, 0, r15.length(), r37, r111 - r21, getMTextPaint());
        r22.restore();
    L56:
        if (r30 > (-r28)) goto L58;
        r22.save();
        Rect r40 = this.f;
        Intrinsics.checkNotNull(r40);
        r22.clipRect(r40);
        r22.drawText(r15, 0, r15.length(), r11, (r16 + r30) - r21, getMTextPaint());
        r22.restore();
        goto L59
    L58:
        r22.save();
        Rect r41 = this.g;
        Intrinsics.checkNotNull(r41);
        r22.clipRect(r41);
        r22.drawText(r15, 0, r15.length(), r11, (r16 + r30) - r24, getMSelectedTextPaint());
        r22.restore();
    L45:
        r31 = false;
        goto L46
    L40:
        r26 = r25.b / r25.a.getItemHeightPx();
    L59:
        r14 = r14 + 1;
        goto L17
    L22:
        if (this.r == false) goto L27;
        int r42 = r14 % r7;
        if (r42 >= 0) goto L26;
        r42 = r42 + r7;
    L26:
        r8 = (String) ListProtector.get(this.o, r42);
        goto L34
    L27:
        if (r14 < 0) goto L30;
        if (r14 >= r7) goto L30;
        boolean r43 = true;
    L31:
        if (r43 == false) goto L33;
        r8 = (String) ListProtector.get(this.o, r14);
    L30:
        r43 = false;
        goto L31
    L61:
        if (this.a == false) goto L66;
        Rect r44 = this.g;
        if (r44 == null) goto L66;
        float r45 = r44.left;
        float r46 = r44.top;
        r22.drawLine(r45, r46, r44.right, r46, getMDividerPaint());
        float r47 = r44.left;
        float r48 = r44.bottom;
        r22.drawLine(r47, r48, r44.right, r48, getMDividerPaint());
    L66:
        CharSequence r50 = this.p;
        if (r50 == null) goto L78;
        Rect r51 = this.g;
        Intrinsics.checkNotNull(r51);
        int r52 = r51.centerY();
        Rect r53 = this.g;
        Intrinsics.checkNotNull(r53);
        int r54 = r53.centerX();
        Paint.FontMetrics r55 = getMTagTextPaint().getFontMetrics();
        int r56 = (int) ((r55.top + r55.bottom) / 2);
        r22.drawText(r50, 0, r50.length(), MathKt.roundToInt(TypedValue.applyDimension(1, 14, a(Resources.getSystem()))) + r54, r52 - r56, getMTagTextPaint());
        return;
    L78:
        return;
    L13:
        if (r10 <= 0) goto L15;
        r6 = (r2 + r4) + 1;
        goto L16
    L9:
        r10 = r3.b % r3.a.getItemHeightPx();
        goto L10
    L5:
        r2 = r1.b / r1.a.getItemHeightPx();
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r13) {
        Intrinsics.checkNotNullParameter(r13, "event");
        g r8 = getMScroller();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r13, "event");
        if (r8.e != null) goto L5;
        r8.e = VelocityTracker.obtain();
    L5:
        VelocityTracker r0 = r8.e;
        if (r0 == null) goto L8;
        r0.addMovement(r13);
    L8:
        int r1 = r13.getAction();
        if (r1 != 0) goto L11;
        ViewParent r2 = r8.a.getParent();
        if (r2 == null) goto L58;
        r2.requestDisallowInterceptTouchEvent(true);
    L58:
        r8.c = r13.getY();
        r8.forceFinished(true);
        r8.f = false;
        r8.d = false;
    L59:
        return true;
    L11:
        if (r1 == 1) goto L29;
        if (r1 != 2) goto L14;
        float r14 = r13.getY();
        int r3 = (int) (r14 - r8.c);
        if (r3 == 0) goto L28;
        r8.f = true;
        r8.a(-r3, "touchEvent");
        r8.a.invalidate();
    L28:
        r8.c = r14;
        goto L59
    L14:
        if (r1 != 3) goto L59;
        if (r8.f == false) goto L19;
        g.c(r8);
    L19:
        VelocityTracker r15 = r8.e;
        if (r15 == null) goto L22;
        r15.recycle();
    L22:
        r8.e = null;
        r8.f = false;
        ViewParent r16 = r8.a.getParent();
        if (r16 == null) goto L59;
        r16.requestDisallowInterceptTouchEvent(false);
        goto L59
    L29:
        VelocityTracker r4 = r8.e;
        if (r4 == null) goto L32;
        r4.computeCurrentVelocity(1000);
    L32:
        VelocityTracker r5 = r8.e;
        if (r5 == null) goto L35;
        float r6 = r5.getYVelocity();
    L37:
        if (Math.abs(r6) <= 0.0f) goto L44;
        int r7 = (r8.a.getItemSize() - 1) * r8.a.getItemHeightPx();
        int r9 = r8.a.getItemHeightPx() * 0;
        r8.d = true;
        WheelView r17 = r8.a;
        if (r17.r == false) goto L41;
        Class<?> r10 = f.a;
        f.c(r8, r17.getItemHeightPx(), r8.b, ((int) (-r6)) / 2, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    L42:
        r8.a.invalidate();
    L49:
        VelocityTracker r18 = r8.e;
        if (r18 == null) goto L52;
        r18.recycle();
    L52:
        r8.e = null;
        ViewParent r110 = r8.a.getParent();
        if (r110 == null) goto L59;
        r110.requestDisallowInterceptTouchEvent(false);
        goto L59
    L41:
        Class<?> r11 = f.a;
        f.c(r8, r17.getItemHeightPx(), r8.b, ((int) (-r6)) / 2, 0, r7, r9);
        goto L42
    L44:
        if (r8.f == true) goto L48;
        float r111 = r13.getY() - (r8.a.getHeight() / 2.0f);
        if (Math.abs(r111) <= 1.0f) goto L49;
        r8.d = true;
        r8.g(r8.b, (int) r111, BaiduNaviStatus.WRONG_AK_PARAM, "ACTION_UP");
        r8.a.invalidate();
        goto L49
    L48:
        g.c(r8);
        goto L49
    L35:
        r6 = 0.0f;
        goto L37
    }

    public final void setCurrentIndex(int r2) {
        b(r2, false);
    }

    public final void setCyclic(boolean r1) {
        this.r = r1;
        getMScroller().e();
        invalidate();
    }

    public final void setEntries(List<String> r3) {
        ((ArrayList) this.o).clear();
        List<String> r4 = r3;
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        ((ArrayList) this.o).addAll(r4);
    L11:
        getMScroller().e();
        b(this.b, false);
        invalidate();
        return;
    L5:
        if (r4.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void setHighlightColor(int r2) {
        getMHighlightPaint().setColor(r2);
        invalidate();
    }

    public final void setHighlightConorRadiusPx(int r1) {
        this.q = r1;
        invalidate();
    }

    public final void setItemCount(int r1) {
        this.c = r1;
        invalidate();
    }

    public final void setItemHeightPx(int r1) {
        this.e = r1;
        invalidate();
    }

    public final void setItemWidthPx(int r1) {
        this.d = r1;
        invalidate();
    }

    public final void setOnWheelChangedListener(v49.a r2) {
        getMScroller().g = r2;
    }

    public final void setSelectedTextColor(int r2) {
        getMSelectedTextPaint().setColor(r2);
        invalidate();
    }

    public final void setSelectedTextSizePx(float r2) {
        getMSelectedTextPaint().setTextSize(r2);
        invalidate();
    }

    public final void setShowBottomLeftCorner(boolean r1) {
        this.u = r1;
    }

    public final void setShowBottomRightCorner(boolean r1) {
        this.v = r1;
    }

    public final void setShowDivider(boolean r1) {
        this.a = r1;
        invalidate();
    }

    public final void setShowTopLeftCorner(boolean r1) {
        this.s = r1;
    }

    public final void setShowTopRightCorner(boolean r1) {
        this.t = r1;
    }

    public final void setStartIndex(int r3) {
        this.b = r3;
        getMScroller().f(r3, false);
    }

    public final void setTagText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        if ((!StringsKt.isBlank(r2)) == false) goto L6;
        this.p = r2;
        invalidate();
        return;
    }

    public final void setTextColor(int r2) {
        getMTextPaint().setColor(r2);
        invalidate();
    }

    public final void setTextSizePx(float r2) {
        getMTextPaint().setTextSize(r2);
        invalidate();
    }

    public final void setEntries(String... r3) {
        Intrinsics.checkNotNullParameter(r3, "entries");
        ((ArrayList) this.o).clear();
        if (r3.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        CollectionsKt.addAll(this.o, r3);
    L8:
        getMScroller().e();
        b(this.b, false);
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public WheelView(final Context r22, AttributeSet r23) {
        Intrinsics.checkNotNullParameter(r22, "context");
        super(r22, r23);
        this.c = 7;
        float r3 = 343;
        this.d = MathKt.roundToInt(TypedValue.applyDimension(1, r3, a(Resources.getSystem())));
        this.e = MathKt.roundToInt(TypedValue.applyDimension(1, 48, a(Resources.getSystem())));
        this.i = LazyKt.lazy(new h());
        this.j = LazyKt.lazy(new i());
        this.k = LazyKt.lazy(new j());
        this.l = LazyKt.lazy(new k());
        this.m = LazyKt.lazy(new l());
        this.n = LazyKt.lazy(new m(r22, this));
        this.o = new ArrayList();
        float r6 = 8;
        this.q = MathKt.roundToInt(TypedValue.applyDimension(1, r6, a(Resources.getSystem())));
        this.r = true;
        TypedArray r7 = r22.obtainStyledAttributes(r23, new int[]{2130973352, 2130973353, 2130973354, 2130973355, 2130973356, 2130973357, 2130973358, 2130973359, 2130973360, 2130973361, 2130973362, 2130973363, 2130973364});
        boolean r9 = r7.getBoolean(0, true);
        int r10 = r7.getInt(10, 0);
        boolean r11 = r7.getBoolean(9, false);
        int r12 = r7.getInt(4, 7);
        int r4 = r7.getDimensionPixelOffset(6, MathKt.roundToInt(TypedValue.applyDimension(1, r3, a(Resources.getSystem()))));
        int r13 = r7.getDimensionPixelOffset(5, MathKt.roundToInt(TypedValue.applyDimension(1, 40, a(Resources.getSystem()))));
        int r14 = r7.getDimensionPixelSize(12, MathKt.roundToInt(TypedValue.applyDimension(2, 16, a(Resources.getSystem()))));
        int r5 = r7.getDimensionPixelSize(12, MathKt.roundToInt(TypedValue.applyDimension(2, 14, a(Resources.getSystem()))));
        int r8 = r7.getColor(11, ContextCompat.getColor(r22, 2131103041));
        int r2 = r7.getColor(7, ContextCompat.getColor(r22, 2131103136));
        int r15 = r7.getDimensionPixelSize(8, MathKt.roundToInt(TypedValue.applyDimension(2, 20, a(Resources.getSystem()))));
        int r16 = r7.getColor(2, ContextCompat.getColor(r22, 2131103188));
        int r17 = r7.getDimensionPixelOffset(3, MathKt.roundToInt(TypedValue.applyDimension(1, r6, a(Resources.getSystem()))));
        CharSequence[] r18 = r7.getTextArray(1);
        if (r18 == null) goto L7;
        ArrayList r20 = new ArrayList(r18.length);
        int r1 = r18.length;
        int r21 = 0;
    L5:
        if (r21 >= r1) goto L8;
        r20.add(r18[r21].toString());
        r21 = r21 + 1;
        r1 = r1;
    L8:
        r7.recycle();
        setCyclic(r9);
        setShowDivider(r11);
        setStartIndex(r10);
        setItemCount(r12);
        setItemWidthPx(r4);
        setItemHeightPx(r13);
        setHighlightConorRadiusPx(r17);
        TextPaint r24 = getMTextPaint();
        r24.setTextAlign(Paint.Align.CENTER);
        r24.setTextSize(r14);
        r24.setColor(r8);
        r24.setTypeface(Typeface.create(null, 480, false));
        TextPaint r25 = getMTagTextPaint();
        r25.setTextAlign(Paint.Align.LEFT);
        r25.setTextSize(r5);
        r25.setColor(r8);
        r25.setTypeface(Typeface.create(null, 600, false));
        TextPaint r26 = getMSelectedTextPaint();
        r26.setTextAlign(Paint.Align.CENTER);
        r26.setTextSize(r15);
        r26.setColor(r2);
        r26.setTypeface(Typeface.create(null, 640, false));
        Paint r27 = getMDividerPaint();
        r27.setStrokeWidth(TypedValue.applyDimension(1, (float) 0.5d, a(Resources.getSystem())));
        r27.setColor(ContextCompat.getColor(r22, 2131099885));
        Paint r28 = getMHighlightPaint();
        r28.setStyle(Paint.Style.FILL);
        r28.setColor(r16);
        ArrayList r30 = r20;
        if (r30 != null) goto L11;
    L14:
        boolean r31 = true;
    L15:
        if (r31 == true) goto L19;
        this.o.addAll(r20);
        b(r10, false);
        return;
    L19:
        return;
    L11:
        if (r30.isEmpty() == true) goto L14;
        r31 = false;
        goto L15
    L7:
        r20 = null;
        goto L8
    }

    public final void b(int r2, boolean r3) {
        getMScroller().f(r2, r3);
    }

    @Override // android.view.View
    public final void onMeasure(int r7, int r8) {
        int r0 = View.MeasureSpec.getMode(r7);
        int r9 = View.MeasureSpec.getSize(r7);
        int r1 = View.MeasureSpec.getMode(r8);
        int r10 = View.MeasureSpec.getSize(r8);
        if (r0 != 1073741824) goto L6;
        if (r1 != 1073741824) goto L6;
        setMeasuredDimension(r9, r10);
    L11:
        int r11 = getPaddingLeft();
        int r12 = getMeasuredWidth() - getPaddingRight();
        int r2 = getPaddingTop();
        int r3 = getMeasuredHeight() - getPaddingBottom();
        int r4 = (r2 + r3) / 2;
        Rect r5 = new Rect();
        r5.left = r11;
        r5.right = r12;
        int r6 = this.e / 2;
        r5.top = r4 - r6;
        r5.bottom = r6 + r4;
        this.g = r5;
        Rect r13 = new Rect();
        r13.left = r11;
        r13.right = r12;
        r13.top = r2;
        r13.bottom = r4 - (this.e / 2);
        this.f = r13;
        Rect r14 = new Rect();
        r14.left = r11;
        r14.right = r12;
        r14.top = r4 + (this.e / 2);
        r14.bottom = r3;
        this.h = r14;
        return;
    L6:
        if (r0 != 1073741824) goto L8;
        setMeasuredDimension(r9, getWheelHeight());
        goto L11
    L8:
        if (r1 != 1073741824) goto L10;
        setMeasuredDimension(getWheelWidth(), r10);
        goto L11
    L10:
        setMeasuredDimension(getWheelWidth(), getWheelHeight());
        goto L11
    }
}
