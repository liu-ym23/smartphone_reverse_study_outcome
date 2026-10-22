package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dB\u001d\b\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001c\u0010 B%\b\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b\u001c\u0010#RV\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECConstrainLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/Function2;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "view", "Landroid/view/MotionEvent;", "ev", "", "a", "Lkotlin/jvm/functions/Function2;", "getInterceptTouchEventListener", "()Lkotlin/jvm/functions/Function2;", "setInterceptTouchEventListener", "(Lkotlin/jvm/functions/Function2;)V", "interceptTouchEventListener", "Lkotlin/Function0;", "", "b", "Lkotlin/jvm/functions/Function0;", "getViewOnClickListener", "()Lkotlin/jvm/functions/Function0;", "setViewOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "viewOnClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECConstrainLayout extends ConstraintLayout {
    public Function2<? super ViewGroup, ? super MotionEvent, Boolean> a;
    public Function0<Unit> b;
    public boolean c;

    public final Function2<ViewGroup, MotionEvent, Boolean> getInterceptTouchEventListener() {
        return this.a;
    }

    public final Function0<Unit> getViewOnClickListener() {
        return this.b;
    }

    public ECConstrainLayout(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        r10.getAction();
        boolean r11 = false;
        if (r10.getAction() != 3) goto L6;
    L13:
        this.c = r11;
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r10);
    L6:
        if (r10.getAction() == 1) goto L8;
    L12:
        r11 = true;
        goto L13
    L8:
        if (this.c == false) goto L12;
        Function0<Unit> r0 = this.b;
        if (r0 == null) goto L13;
        Unit r1 = (Unit) r0.invoke();
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        Function2<? super ViewGroup, ? super MotionEvent, Boolean> r0 = this.a;
        if (r0 == null) goto L8;
        Boolean r1 = (Boolean) r0.invoke(this, r10);
        if (r1 == null) goto L8;
        return r1.booleanValue();
    L8:
        return super/*android.view.ViewGroup*/.onInterceptTouchEvent(r10);
    }

    public final void setInterceptTouchEventListener(Function2<? super ViewGroup, ? super MotionEvent, Boolean> r1) {
        this.a = r1;
    }

    public final void setViewOnClickListener(Function0<Unit> r1) {
        this.b = r1;
    }

    public ECConstrainLayout(Context r1, AttributeSet r10) {
        super(r1, r10);
    }

    public ECConstrainLayout(Context r1, AttributeSet r10, int r11) {
        super(r1, r10, r11);
    }
}
