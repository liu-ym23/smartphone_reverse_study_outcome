package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class SurnameGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6335b;

    public interface a {
    }

    public SurnameGridView(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f6334a = -1;
        this.f6335b = -1;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        i.f(r8, "ev");
        int r10 = pointToPosition((int) r8.getX(), (int) r8.getY());
        int r11 = r8.getActionMasked();
        if (r11 != 0) goto L5;
        this.f6334a = r10;
    L15:
        if (this.f6335b == r10) goto L17;
        i.c(null);
        throw null;
    L17:
        return super.onTouchEvent(r8);
    L5:
        if (r11 != 1) goto L7;
    L9:
        r10 = -1;
        goto L15
    L7:
        if (r11 != 2) goto L9;
        int r12 = this.f6334a;
        if (r12 != r10) goto L9;
        r10 = r12;
        goto L15
    }

    public final void setOnPressChangeListener(a r8) {
    }
}
