package com.ss.android.lark.message;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.gradient.UDGradientDrawableKt;
import com.larksuite.component.universe_design.gradient.UDLinearGradientDrawable;
import com.larksuite.component.universe_design.gradient.b;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/message/SummarizeGradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pressedGradient", "Lcom/larksuite/component/universe_design/gradient/UDGradientDrawable;", "boundsRect", "Landroid/graphics/Rect;", "isTouching", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SummarizeGradientTextView extends AppCompatTextView {
    public final UDLinearGradientDrawable a;
    public final Rect b;
    public boolean c;

    public SummarizeGradientTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SummarizeGradientTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        this.b.set(0, 0, getWidth(), getHeight());
        if (this.c == false) goto L5;
        UDLinearGradientDrawable r0 = this.a;
        Rect r1 = this.b;
        r0.setBounds(r1);
        int r2 = r10.saveLayer(r1.left, r1.top, r1.right, r1.bottom, null);
        super/*android.widget.TextView*/.onDraw(r10);
        r0.b((PorterDuffXfermode) UDGradientDrawableKt.a.getValue());
        r0.draw(r10);
        r10.restoreToCount(r2);
        r0.b(null);
        return;
    L5:
        super/*android.widget.TextView*/.onDraw(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r4) {
        if (r4 == null) goto L4;
        Integer r0 = Integer.valueOf(r4.getAction());
    L6:
        if (r0 != null) goto L9;
    L11:
        if (r0 != null) goto L14;
    L15:
        if (r0 != null) goto L18;
    L21:
        return super/*android.widget.TextView*/.onTouchEvent(r4);
    L18:
        if (r0.intValue() != 3) goto L21;
    L19:
        this.c = false;
        invalidate();
        goto L21
    L14:
        if (r0.intValue() == 1) goto L19;
    L9:
        if (r0.intValue() != 0) goto L11;
        this.c = true;
        invalidate();
        goto L21
    L4:
        r0 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SummarizeGradientTextView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        int r6 = b.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        UDLinearGradientDrawable.Orientation r7 = UDLinearGradientDrawable.Orientation.TO_BOTTOM_RIGHT;
        UDLinearGradientDrawable r1 = new UDLinearGradientDrawable(UDColorUtils.getColor(r3, 2131100170), UDColorUtils.getColor(r3, 2131100171), r7);
        r1.mutate();
        this.a = r1;
        this.b = new Rect();
        setTextColor(UDColorUtils.getColor(r3, 2131106607));
    }

    public /* synthetic */ SummarizeGradientTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
