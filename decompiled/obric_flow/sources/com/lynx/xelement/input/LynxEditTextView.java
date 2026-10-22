package com.lynx.xelement.input;

import android.content.Context;
import android.view.MotionEvent;
import com.lynx.animax.i;
import com.lynx.tasm.r;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import po.c;
import po.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0002R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/lynx/xelement/input/LynxEditTextView;", "Lcom/lynx/xelement/input/LynxEditText;", "Lpo/c;", "f", "Lpo/c;", "getOnSelectionChangeListener", "()Lpo/c;", "setOnSelectionChangeListener", "(Lpo/c;)V", "onSelectionChangeListener", "Input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxEditTextView extends LynxEditText {
    public c f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11197h;

    public LynxEditTextView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(r5);
    }

    public final c getOnSelectionChangeListener() {
        return this.f;
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int r5, int r10) {
        super.onSelectionChanged(r5, r10);
        c r11 = this.f;
        if (r11 == null) goto L6;
        LynxUIBaseInput r12 = ((h) r11).f21379a;
        r r13 = r12.getLynxContext().g;
        i r14 = new i(r12.getSign(), "selection");
        r14.a("selectionStart", Integer.valueOf(r5));
        r14.a("selectionEnd", Integer.valueOf(r10));
        r13.b(r14);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        if (isFocusable() == true) goto L5;
        return false;
    L5:
        if (r10 == null) goto L7;
        int r5 = r10.getAction();
        if (r5 != 0) goto L11;
        getParent().requestDisallowInterceptTouchEvent(true);
        r10.getX();
        this.g = r10.getY();
        this.f11197h = getScrollY();
    L30:
        return super.onTouchEvent(r10);
    L11:
        if (r5 != 1) goto L13;
        getParent().requestDisallowInterceptTouchEvent(false);
        this.g = 0.0f;
        Math.abs(getScrollY() - this.f11197h);
        goto L30
    L13:
        if (r5 == 2) goto L19;
        if (r5 != 3) goto L30;
        getParent().requestDisallowInterceptTouchEvent(false);
        this.g = 0.0f;
        Math.abs(getScrollY() - this.f11197h);
        goto L30
    L19:
        if (canScrollVertically(1) == true) goto L23;
        if (r10.getY() >= this.g) goto L23;
    L26:
        getParent().requestDisallowInterceptTouchEvent(false);
    L23:
        if (canScrollVertically(-1) == true) goto L30;
        if (r10.getY() <= this.g) goto L30;
    L7:
        return super.onTouchEvent(null);
    }

    public final void setOnSelectionChangeListener(c r5) {
        this.f = r5;
    }
}
