package com.obric.oui.popover.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class CheckableImageView extends AppCompatImageView implements Checkable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6458n;

    public CheckableImageView(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f6458n;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r8) {
        if (this.f6458n == false) goto L6;
        super.onDraw(r8);
        return;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r8) {
        this.f6458n = r8;
        invalidate();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f6458n);
    }
}
