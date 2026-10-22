package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.smartreply;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 J2\u00020\u0001:\u0002JKB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\fJ\u0010\u0010.\u001a\u00020,2\b\b\u0001\u0010/\u001a\u00020\fJ\b\u00100\u001a\u00020,H\u0002J \u00101\u001a\u00020,2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\fH\u0014J8\u00105\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00106\u001a\u00020\fH\u0002J.\u00107\u001a\u0004\u0018\u00010\u000e2\b\u00108\u001a\u0004\u0018\u00010\t2\u0006\u00109\u001a\u00020\f2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010:\u001a\u00020\"H\u0002J\u0012\u0010;\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010\u000eH\u0002J8\u0010=\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010>\u001a\u00020\fH\u0002J\u000e\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020\u0015J\u0010\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020CH\u0014J\b\u0010D\u001a\u00020\"H\u0016J\u0012\u0010G\u001a\u00020\"2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/messagelist/render/block/smartreply/EllipsizeAddSuffixView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "content", BuildConfig.FLAVOR, "suffix", "maxLineCount", BuildConfig.FLAVOR, "originLayout", "Landroid/text/Layout;", "displayLayout", "lastMeasureWidth", "lastMeasureHeight", "textSize", "textColor", "lineSpacing", BuildConfig.FLAVOR, "textPaint", "Landroid/text/TextPaint;", "getTextPaint", "()Landroid/text/TextPaint;", "textPaint$delegate", "Lkotlin/Lazy;", "ellipsizeWidth", "getEllipsizeWidth", "()F", "ellipsizeWidth$delegate", "noEllipsizeWidth", "ellipsisV2", BuildConfig.FLAVOR, "getEllipsisV2", "()Z", "setEllipsisV2", "(Z)V", "clickableRect", "Landroid/graphics/Rect;", "clickableSpan", "Landroid/text/style/ClickableSpan;", "setTextSize", BuildConfig.FLAVOR, "size", "setTextColor", "color", "requestLayoutIfNeed", "setInfo", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "makeCombineLayoutIfNeed", "wantWidth", "makeNewLayout", "text", "width", "ellipsize", "getTextExcludeLastLine", "layout", "createDisplayLayout", "totalWidth", "setLineSpacing", "spacing", "onDraw", "canvas", "Landroid/graphics/Canvas;", "performClick", "lastTouchDownEventPosition", "Landroid/graphics/Point;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "SuffixSpan", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EllipsizeAddSuffixView extends View {
    public int a;
    public int b;
    public int c;
    public int d;
    public final Lazy e;
    public final Lazy f;
    public boolean g;
    public final Rect h;
    public final Point i;

    public static final class a {
    }

    static {
    }

    public final void setLineSpacing(float r1) {
    }

    private final float getEllipsizeWidth() {
        return ((Number) this.f.getValue()).floatValue();
    }

    private final TextPaint getTextPaint() {
        return (TextPaint) this.e.getValue();
    }

    @Override // android.view.View
    public final boolean performClick() {
        Rect r0 = this.h;
        Point r1 = this.i;
        r0.contains(r1.x, r1.y);
        return super.performClick();
    }

    public final boolean getEllipsisV2() {
        return this.g;
    }

    public EllipsizeAddSuffixView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ TextPaint a(EllipsizeAddSuffixView r0) {
        return r0.getTextPaint();
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        if (r4 == null) goto L7;
        if (r4.getActionMasked() != 0) goto L7;
        this.i.set((int) r4.getX(), (int) r4.getY());
    L7:
        return super.dispatchTouchEvent(r4);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.onDraw(r4);
        float r0 = getPaddingLeft();
        float r1 = getPaddingTop();
        int r2 = r4.save();
        r4.translate(r0, r1);
        r4.restoreToCount(r2);
    }

    public final void setEllipsisV2(boolean r1) {
        this.g = r1;
    }

    public final void setTextColor(int r2) {
        if (this.d == r2) goto L6;
        this.d = r2;
        return;
    }

    public final void setTextSize(int r2) {
        if (this.c == r2) goto L6;
        this.c = r2;
        return;
    }

    public EllipsizeAddSuffixView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.c = UIUtils.dp2px(r2, 14.0f);
        this.d = UIUtils.getColor(r2, 2131106607);
        LazyThreadSafetyMode r4 = LazyThreadSafetyMode.NONE;
        this.e = LazyKt.lazy(r4, new EllipsizeAddSuffixView$textPaint$2(this));
        this.f = LazyKt.lazy(r4, new EllipsizeAddSuffixView$ellipsizeWidth$2(this));
        this.h = new Rect();
        this.i = new Point();
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getSize(r4);
        int r1 = View.MeasureSpec.getSize(r5);
        if (r0 != this.a) goto L5;
        int r2 = this.b;
    L5:
        getPaddingLeft();
        getPaddingRight();
        View.MeasureSpec.getMode(r4);
        View.MeasureSpec.getMode(r5);
        setMeasuredDimension(r0, r1);
        this.a = r0;
        this.b = r1;
    }
}
