package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.chat.common.databinding.LarusLayoutExpendAllThinkBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u000eJ\u0010\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u0010J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010-\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010(X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ExpendAllThinkView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/view/textview/api/selector/IGestureTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusLayoutExpendAllThinkBinding;", "hide", "", "isDividerVisible", "", "setupDividerColor", "color", "setupExpandAllMaskRes", "resId", "setDividerVisible", "visible", "hideExpandAllThinkTitle", "show", "needShowTitle", "asTextView", "Landroid/widget/TextView;", "getContainer", "Landroid/widget/FrameLayout;", "clickY", "", "getClickY", "()F", "setClickY", "(F)V", "clickX", "getClickX", "setClickX", "downListener", "Lkotlin/Function0;", "getDownListener", "()Lkotlin/jvm/functions/Function0;", "setDownListener", "(Lkotlin/jvm/functions/Function0;)V", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ExpendAllThinkView extends ConstraintLayout implements st8.a {
    public final LarusLayoutExpendAllThinkBinding a;
    public float b;
    public float c;
    public Function0<Boolean> d;

    public static final class a {
    }

    static {
    }

    public ExpendAllThinkView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ExpendAllThinkView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final View l5() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FrameLayout getContainer() {
        ViewParent r0 = getParent();
        if (r0 != null) goto L6;
        return null;
    L6:
        if ((r0 instanceof FrameLayout) == true) goto L8;
        return null;
    L8:
        return (FrameLayout) r0;
    }

    public float getClickX() {
        return this.c;
    }

    public float getClickY() {
        return this.b;
    }

    public Function0<Boolean> getDownListener() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(boolean r3) {
        com.larus.utils.e1.x(this);
        if (r3 == false) goto L9;
        LarusLayoutExpendAllThinkBinding r4 = this.a;
        if (r4 == null) goto L9;
        TextView r5 = r4.b;
        if (r5 == null) goto L9;
        r5.setText(getContext().getString(2131901483));
    L9:
        LarusLayoutExpendAllThinkBinding r6 = this.a;
        if (r6 == null) goto L15;
        TextView r7 = r6.b;
        if (r7 == null) goto L16;
        r7.setVisibility(0);
        return;
    L16:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        setClickX(r2.getX());
        setClickY(r2.getY());
        return super/*android.view.ViewGroup*/.onTouchEvent(r2);
    }

    public void setClickX(float r1) {
        this.c = r1;
    }

    public void setClickY(float r1) {
        this.b = r1;
    }

    public final void setDividerVisible(boolean r2) {
        LarusLayoutExpendAllThinkBinding r0 = this.a;
        if (r0 == null) goto L11;
        AppCompatImageView r1 = r0.c;
        if (r1 == null) goto L12;
        if (r2 == false) goto L8;
        int r3 = 0;
    L9:
        r1.setVisibility(r3);
        return;
    L8:
        r3 = 8;
        goto L9
    L12:
        return;
    }

    public void setDownListener(Function0<Boolean> r1) {
        this.d = r1;
    }

    public final void setupDividerColor(int r2) {
        LarusLayoutExpendAllThinkBinding r0 = this.a;
        if (r0 == null) goto L8;
        AppCompatImageView r1 = r0.c;
        if (r1 == null) goto L9;
        r1.setBackgroundColor(r2);
        return;
    L9:
        return;
    }

    public final void setupExpandAllMaskRes(int r2) {
        LarusLayoutExpendAllThinkBinding r0 = this.a;
        if (r0 == null) goto L8;
        TextView r1 = r0.b;
        if (r1 == null) goto L9;
        r1.setBackgroundResource(r2);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExpendAllThinkView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        LayoutInflater.from(r7).inflate(2131562813, this);
        int r10 = 2131371876;
        TextView r0 = (TextView) ViewBindings.findChildViewById(this, 2131371876);
        if (r0 == null) goto L9;
        r10 = 2131392500;
        AppCompatImageView r11 = ViewBindings.findChildViewById(this, 2131392500);
        if (r11 == null) goto L9;
        this.a = new LarusLayoutExpendAllThinkBinding(this, r0, r11);
        we8.a.b(r0, i5.o(), false, null, null, 12);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r10)));
    }

    public /* synthetic */ ExpendAllThinkView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
