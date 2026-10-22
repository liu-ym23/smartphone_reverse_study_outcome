package com.larus.avlink.simulInterpret.page.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.impl.databinding.LarusDoraAvlinkSliderTouchViewBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006%"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/SliderTouchView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LarusDoraAvlinkSliderTouchViewBinding;", "touchSlop", "isDragging", "", "downRawY", "", "onDragStart", "Lkotlin/Function0;", "", "getOnDragStart", "()Lkotlin/jvm/functions/Function0;", "setOnDragStart", "(Lkotlin/jvm/functions/Function0;)V", "onDrag", "Lkotlin/Function1;", "getOnDrag", "()Lkotlin/jvm/functions/Function1;", "setOnDrag", "(Lkotlin/jvm/functions/Function1;)V", "onDragEnd", "getOnDragEnd", "setOnDragEnd", "performClick", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SliderTouchView extends ConstraintLayout {
    public final LarusDoraAvlinkSliderTouchViewBinding a;
    public final int b;
    public boolean c;
    public float d;
    public Function0<Unit> e;
    public Function1<? super Float, Unit> f;
    public Function1<? super Float, Unit> g;

    public SliderTouchView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SliderTouchView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean performClick() {
        super/*android.view.ViewGroup*/.performClick();
        return true;
    }

    public final Function1<Float, Unit> getOnDrag() {
        return this.f;
    }

    public final Function1<Float, Unit> getOnDragEnd() {
        return this.g;
    }

    public final Function0<Unit> getOnDragStart() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = r5.getActionMasked();
        if (r0 == 0) goto L38;
        if (r0 != 1) goto L6;
        ViewParent r1 = getParent();
        if (r1 == null) goto L31;
        r1.requestDisallowInterceptTouchEvent(false);
    L31:
        if (this.c == false) goto L35;
        Function1<? super Float, Unit> r2 = this.g;
        if (r2 == null) goto L36;
        r2.invoke(Float.valueOf(r5.getRawY() - this.d));
    L36:
        this.a.b.setPressed(false);
        this.c = false;
        return true;
    L35:
        super/*android.view.ViewGroup*/.performClick();
        goto L36
    L6:
        if (r0 != 2) goto L8;
        float r6 = r5.getRawY() - this.d;
        if (this.c == true) goto L22;
        if (Math.abs(r6) <= this.b) goto L22;
        this.c = true;
    L22:
        if (this.c == false) goto L26;
        Function1<? super Float, Unit> r3 = this.f;
        if (r3 == null) goto L26;
        r3.invoke(Float.valueOf(r6));
    L26:
        return true;
    L8:
        if (r0 != 3) goto L10;
        ViewParent r7 = getParent();
        if (r7 == null) goto L14;
        r7.requestDisallowInterceptTouchEvent(false);
    L14:
        this.a.b.setPressed(false);
        this.c = false;
        return true;
    L10:
        return super/*android.view.ViewGroup*/.onTouchEvent(r5);
    L38:
        this.d = r5.getRawY();
        this.a.b.setPressed(true);
        this.c = false;
        ViewParent r8 = getParent();
        if (r8 == null) goto L41;
        r8.requestDisallowInterceptTouchEvent(true);
    L41:
        Function0<Unit> r9 = this.e;
        if (r9 == null) goto L44;
        r9.invoke();
    L44:
        return true;
    }

    public final void setOnDrag(Function1<? super Float, Unit> r1) {
        this.f = r1;
    }

    public final void setOnDragEnd(Function1<? super Float, Unit> r1) {
        this.g = r1;
    }

    public final void setOnDragStart(Function0<Unit> r1) {
        this.e = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SliderTouchView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ConstraintLayout r5 = LayoutInflater.from(r2).inflate(2131562142, this, false);
        addView(r5);
        ImageView r0 = (ImageView) ViewBindings.findChildViewById(r5, 2131386888);
        if (r0 == null) goto L7;
        this.a = new LarusDoraAvlinkSliderTouchViewBinding(r5, r0);
        this.b = ViewConfiguration.get(r2).getScaledTouchSlop();
        setClickable(true);
        setFocusable(true);
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131386888)));
    }

    public /* synthetic */ SliderTouchView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
