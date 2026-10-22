package gu;

import android.appwidget.AppWidgetHostView;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends AppWidgetHostView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f17247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f17248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17249c;

    public h(Context r5) {
        super(r5);
        this.f17247a = 1.0f;
        new PointF(0.0f, 0.0f);
        new PointF(0.0f, 0.0f);
        new PointF(0.0f, 0.0f);
        new PointF(0.0f, 0.0f);
        this.f17248b = 1.0f;
        new Rect();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void clearChildFocus(View r5) {
        super.clearChildFocus(r5);
        setSelected(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r5) {
        if (this.f17249c == false) goto L11;
        if (r5.getKeyCode() != 111) goto L11;
        if (r5.getAction() != 1) goto L11;
        this.f17249c = false;
        requestFocus();
        return true;
    L11:
        return super.dispatchKeyEvent(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchUnhandledMove(View r5, int r10) {
        return this.f17249c;
    }

    @Override // android.view.ViewGroup
    public int getDescendantFocusability() {
        if (this.f17249c == false) goto L5;
        return 131072;
    L5:
        return 393216;
    }

    public float getReorderBounceScale() {
        return this.f17248b;
    }

    public float getScaleToFit() {
        return this.f17247a;
    }

    public View getView() {
        return this;
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean r5, int r10, Rect r11) {
        if (r5 == false) goto L4;
        this.f17249c = false;
        setSelected(false);
    L4:
        super.onFocusChanged(r5, r10, r11);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r5, KeyEvent r10) {
        if (this.f17249c == true) goto L9;
        if (r5 != 66) goto L9;
        r10.startTracking();
        return true;
    L9:
        return super.onKeyDown(r5, r10);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int r5, KeyEvent r10) {
        if (r10.isTracking() == false) goto L17;
        if (this.f17249c == true) goto L17;
        if (r5 != 66) goto L17;
        this.f17249c = true;
        ArrayList<View> r11 = getFocusables(2);
        r11.remove(this);
        int r12 = r11.size();
        if (r12 == 0) goto L15;
        if (r12 == 1) goto L13;
        r11.get(0).requestFocus();
        return true;
    L13:
        r11.get(0).performClick();
        this.f17249c = false;
        return true;
    L15:
        this.f17249c = false;
    L17:
        return super.onKeyUp(r5, r10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View r5, View r10) {
        super.requestChildFocus(r5, r10);
        if (this.f17249c == false) goto L6;
        if (r10 == null) goto L6;
        boolean r11 = true;
    L7:
        setSelected(r11);
        if (r10 == null) goto L11;
        r10.setFocusableInTouchMode(false);
        return;
    L11:
        return;
    L6:
        r11 = false;
        goto L7
    }

    public void setReorderBounceScale(float r5) {
        this.f17248b = r5;
        super.setScaleX(this.f17247a * r5);
        super.setScaleY(this.f17247a * this.f17248b);
    }

    public void setScaleToFit(float r5) {
        this.f17247a = r5;
        super.setScaleX(r5 * this.f17248b);
        super.setScaleY(this.f17247a * this.f17248b);
    }
}
