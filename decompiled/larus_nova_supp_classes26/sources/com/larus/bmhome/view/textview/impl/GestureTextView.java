package com.larus.bmhome.view.textview.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.platform.service.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import st8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0000H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006!"}, d2 = {"Lcom/larus/bmhome/view/textview/impl/GestureTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/larus/bmhome/view/textview/api/selector/IGestureTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downListener", "Lkotlin/Function0;", "", "getDownListener", "()Lkotlin/jvm/functions/Function0;", "setDownListener", "(Lkotlin/jvm/functions/Function0;)V", "clickX", "", "getClickX", "()F", "setClickX", "(F)V", "clickY", "getClickY", "setClickY", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "asTextView", "getContainer", "Landroid/widget/FrameLayout;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class GestureTextView extends AppCompatTextView implements a {
    public Function0<Boolean> a;
    public float b;
    public float c;

    public GestureTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GestureTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // st8.a
    public final View l5() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FrameLayout getContainer() {
        ViewParent r0 = getParent();
        if (r0 != null) goto L6;
        return null;
    L6:
        if ((r0 instanceof FrameLayout) == false) goto L8;
        FrameLayout r2 = (FrameLayout) r0;
    L9:
        if (r2 != null) goto L12;
        g.a.ensureNotReachHere(new IllegalStateException("this view must use FrameLayout as parent. current parent is " + r0), "");
        return null;
    L12:
        return r2;
    L8:
        r2 = null;
        goto L9
    }

    @Override // st8.a
    public float getClickX() {
        return this.b;
    }

    @Override // st8.a
    public float getClickY() {
        return this.c;
    }

    public Function0<Boolean> getDownListener() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r4) {
        boolean r0 = false;
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.getAction() != 0) goto L9;
        setClickX(r4.getX());
        setClickY(r4.getY());
    L9:
        if (r4.getAction() != 0) goto L18;
        Function0<Boolean> r1 = getDownListener();
        if (r1 != null) goto L13;
    L15:
        if (r0 == false) goto L18;
        return true;
    L13:
        if (((Boolean) r1.invoke()).booleanValue() != true) goto L15;
        r0 = true;
    L18:
        return super/*android.widget.TextView*/.onTouchEvent(r4);
    }

    public void setClickX(float r1) {
        this.b = r1;
    }

    public void setClickY(float r1) {
        this.c = r1;
    }

    public void setDownListener(Function0<Boolean> r1) {
        this.a = r1;
    }

    public GestureTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ GestureTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
