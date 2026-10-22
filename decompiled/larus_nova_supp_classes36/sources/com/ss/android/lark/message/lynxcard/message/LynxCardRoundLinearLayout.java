package com.ss.android.lark.message.lynxcard.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.larksuite.component.card.navigation.UniversalCardLargeScreenAdapt;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001'B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u001c\u001a\u00020\u00122\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u0016\u0010\u001e\u001a\u00020\u00122\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/message/lynxcard/message/LynxCardRoundLinearLayout;", "Lcom/larksuite/component/ui/layout/LKUIRoundLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMode", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$WidthMode;", "getWidthMode", "()Lcom/ss/android/lark/chat/entity/message/content/CardContent$WidthMode;", "setWidthMode", "(Lcom/ss/android/lark/chat/entity/message/content/CardContent$WidthMode;)V", "cardTapListener", "Lkotlin/Function0;", "", "cardTapObserver", "downX", "", "downY", "downTime", "", "trackingTap", "", "touchSlop", "setOnCardTapListener", "listener", "setOnCardTapObserver", "observer", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "handleCardTap", "Companion", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LynxCardRoundLinearLayout extends LKUIRoundLinearLayout {
    public CardContent.WidthMode r;
    public Function0<Unit> s;
    public Function0<Unit> t;
    public float u;
    public float v;
    public long w;
    public boolean x;
    public final int y;

    public static final class a {
    }

    static {
    }

    public LynxCardRoundLinearLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LynxCardRoundLinearLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final CardContent.WidthMode getWidthMode() {
        return this.r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        if (this.s == null) goto L5;
        boolean r0 = true;
    L6:
        boolean r3 = super/*android.widget.LinearLayout*/.dispatchTouchEvent(r9);
        int r4 = r9.getActionMasked();
        if (r4 == 0) goto L33;
        if (r4 == 1) goto L23;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L34;
        this.x = false;
    L34:
        if (r3 == true) goto L39;
        if (r0 == true) goto L40;
        return false;
    L40:
        return true;
    L39:
        return true;
    L16:
        if (this.x == false) goto L34;
        if (Math.abs(r9.getX() - this.u) <= this.y) goto L20;
    L21:
        this.x = false;
        goto L34
    L20:
        if (Math.abs(r9.getY() - this.v) <= this.y) goto L34;
    L23:
        if (this.x == true) goto L25;
    L32:
        this.x = false;
        goto L34
    L25:
        if ((r9.getEventTime() - this.w) >= ViewConfiguration.getLongPressTimeout()) goto L32;
        Function0<Unit> r10 = this.t;
        if (r10 == null) goto L29;
        r10.invoke();
    L29:
        Function0<Unit> r11 = this.s;
        if (r11 == null) goto L32;
        r11.invoke();
        goto L32
    L33:
        this.u = r9.getX();
        this.v = r9.getY();
        this.w = r9.getEventTime();
        this.x = true;
        goto L34
    L5:
        r0 = false;
        goto L6
    }

    public final void setOnCardTapListener(Function0<Unit> r1) {
        this.s = r1;
        this.x = false;
    }

    public final void setOnCardTapObserver(Function0<Unit> r1) {
        this.t = r1;
    }

    public final void setWidthMode(CardContent.WidthMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.r = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r7, int r8) {
        int r0 = View.MeasureSpec.getMode(r7);
        int r1 = View.MeasureSpec.getSize(r7);
        Log.d("LynxCardRoundLinearLayout", "onMeasure: widthMode=" + r0 + ", widthSize=" + r1 + ", heightMode=" + View.MeasureSpec.getMode(r8) + ", heightSize=" + View.MeasureSpec.getSize(r8));
        Lazy r2 = UniversalCardLargeScreenAdapt.a;
        if (UniversalCardLargeScreenAdapt.d(getContext(), this.r) == false) goto L6;
        super/*android.widget.LinearLayout*/.onMeasure(r7, r8);
        return;
    L6:
        super/*android.widget.LinearLayout*/.onMeasure(View.MeasureSpec.makeMeasureSpec(UniversalCardLargeScreenAdapt.a(getContext(), r1, this.r), 1073741824), r8);
    }

    public LynxCardRoundLinearLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.r = CardContent.WidthMode.DEFAULT;
        this.y = ViewConfiguration.get(r2).getScaledTouchSlop();
    }

    public /* synthetic */ LynxCardRoundLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
