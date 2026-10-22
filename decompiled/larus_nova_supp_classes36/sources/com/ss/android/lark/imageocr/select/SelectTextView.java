package com.ss.android.lark.imageocr.select;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\f\u001a\u00020\nJ\u0016\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0014J\u0012\u0010#\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001dH\u0014R\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Lcom/ss/android/lark/imageocr/select/SelectTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectionColor", "Ljava/lang/Integer;", "start", "end", "highlightPath", "Landroid/graphics/Path;", "highlightPaint", "Landroid/graphics/Paint;", "doubleTapListener", "Lcom/ss/android/lark/imageocr/select/SelectTextView$OnDoubleTapListener;", "delayCancelHandler", "Landroid/os/Handler;", "getDelayCancelHandler", "()Landroid/os/Handler;", "delayCancelHandler$delegate", "Lkotlin/Lazy;", "setSelectionColor", "", "setSelection", "setOnDoubleTapListener", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateUpdatedHighlightPath", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "isInDoubleTaping", "delayCancelDoubleTap", "cancelDoubleTap", "onDetachedFromWindow", "Companion", "OnDoubleTapListener", "imageocr_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class SelectTextView extends TextView {
    public Integer a;
    public int b;
    public int c;
    public Path d;
    public Paint e;
    public b f;
    public final Lazy g;

    public static final class a {
    }

    public interface b {
        void c();
    }

    static {
    }

    private final Handler getDelayCancelHandler() {
        return (Handler) this.g.getValue();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("SelectTextView", "cancelDoubleTap");
        getDelayCancelHandler().removeMessages(100);
    }

    public SelectTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        CharSequence r0 = getText();
        if ((r0 instanceof Spannable) == false) goto L35;
        int r1 = this.b;
        if (r1 < 0) goto L24;
        Spannable r2 = (Spannable) r0;
        if (r1 >= r2.length()) goto L24;
        int r3 = this.c;
        if (r3 <= 0) goto L24;
        if (r3 > r2.length()) goto L24;
        Path r4 = this.d;
        if (r4 != null) goto L16;
        this.d = new Path();
    L17:
        getLayout().getSelectionPath(this.b, this.c, this.d);
        if (this.e == null) goto L20;
    L25:
        Path r6 = this.d;
        if (r6 == null) goto L32;
        Paint r7 = this.e;
        if (r7 == null) goto L33;
        if (r5 == null) goto L34;
        r5.drawPath(r6, r7);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L20:
        if (this.a == null) goto L25;
        Paint r8 = new Paint(1);
        this.e = r8;
        Integer r9 = this.a;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Int");
        r8.setColor(r9.intValue());
        Paint r10 = this.e;
        if (r10 == null) goto L25;
        r10.setStyle(Paint.Style.FILL);
        goto L25
    L16:
        r4.reset();
    L24:
        this.d = null;
        this.e = null;
        goto L25
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        if (this.f != null) goto L7;
        return super.onTouchEvent(r5);
    L7:
        if (r5 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L21;
        if (getDelayCancelHandler().hasMessages(100) == false) goto L19;
        Log.i("SelectTextView", "onDoubleTap");
        Log.i("SelectTextView", "cancelDoubleTap");
        getDelayCancelHandler().removeMessages(100);
        b r6 = this.f;
        if (r6 == null) goto L18;
        r6.c();
    L18:
        return true;
    L19:
        Log.i("SelectTextView", "delayCancelDoubleTap");
        Handler r0 = getDelayCancelHandler();
        Message r2 = Message.obtain();
        r2.what = 100;
        r0.sendMessageDelayed(r2, ViewConfiguration.getDoubleTapTimeout());
    L21:
        return super.onTouchEvent(r5);
    L9:
        if (r5.getAction() != 0) goto L11;
        r1 = true;
        goto L12
    }

    public final void setOnDoubleTapListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "doubleTapListener");
        this.f = r2;
    }

    public final void setSelectionColor(int r1) {
        this.a = Integer.valueOf(r1);
    }

    public SelectTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public SelectTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = -1;
        this.c = -1;
        this.g = LazyKt.lazy(SelectTextView$delayCancelHandler$2.INSTANCE);
    }
}
