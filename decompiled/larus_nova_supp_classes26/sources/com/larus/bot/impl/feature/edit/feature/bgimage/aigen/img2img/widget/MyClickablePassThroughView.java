package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\u0014\u0010\u0018\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017J0\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/widget/MyClickablePassThroughView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "", "downY", "touchSlop", "isClicked", "", "handleParentTouchEvent", "", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "clickEvent", "Lkotlin/Function0;", "bindClickEvent", "onInvoke", "onLayout", "changed", "l", "t", "r", "b", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyClickablePassThroughView extends FrameLayout {
    public float a;
    public float b;
    public final int c;
    public boolean d;
    public Function0<Unit> e;

    public MyClickablePassThroughView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MyClickablePassThroughView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        if (r6 == null) goto L4;
        Integer r0 = Integer.valueOf(r6.getAction());
    L6:
        if (r0 == null) goto L12;
        if (r0.intValue() != 0) goto L12;
        this.a = r6.getX();
        this.b = r6.getY();
        this.d = true;
    L37:
        return super.dispatchTouchEvent(r6);
    L12:
        if (r0 != null) goto L15;
    L21:
        if (r0 != null) goto L24;
    L31:
        if (r0 == null) goto L37;
        if (r0.intValue() != 3) goto L37;
        this.d = false;
        goto L37
    L24:
        if (r0.intValue() != 1) goto L31;
        if (this.d == false) goto L30;
        Function0<Unit> r1 = this.e;
        if (r1 == null) goto L30;
        r1.invoke();
    L30:
        this.d = false;
        goto L37
    L15:
        if (r0.intValue() != 2) goto L21;
        if (Math.abs(r6.getX() - this.a) <= this.c) goto L19;
    L20:
        this.d = false;
        goto L37
    L19:
        if (Math.abs(r6.getY() - this.b) <= this.c) goto L37;
    L4:
        r0 = null;
        goto L6
    }

    public MyClickablePassThroughView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.d = true;
    }

    public /* synthetic */ MyClickablePassThroughView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        super.onLayout(r7, getLeft(), getTop(), getRight(), getBottom());
    }
}
