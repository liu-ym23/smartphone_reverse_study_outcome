package com.obric.oui.push;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import he.i;
import java.util.ArrayList;
import java.util.Iterator;
import o0.c;
import x.b;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationLabel extends CardView {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f6494r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewGroup f6495s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f6496t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6497u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6498v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View.OnClickListener f6499w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final oc.a f6500x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6501y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList<a> f6502z;

    public interface a {
        void a();

        void b();
    }

    public NotificationLabel(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
        this.f6494r = "NotificationLabel";
        this.f6500x = new oc.a(this);
        this.f6502z = new ArrayList();
    }

    @Override // android.view.View
    public final void computeScroll() {
        c r8 = this.f6496t;
        if (r8 == null) goto L19;
        boolean r10 = r8.g();
        String r11 = this.f6494r;
        if (r10 == false) goto L7;
        Log.d(r11, "scrolling");
        invalidate();
        return;
    L7:
        Log.d(r11, "settled");
        boolean r12 = this.f6497u;
        ArrayList<a> r13 = this.f6502z;
        if (r12 == false) goto L14;
        this.f6497u = false;
        Log.i(r11, "onDrag dismiss");
        Iterator<a> r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L24;
        r14.next().b();
        goto L11
    L24:
        return;
    L14:
        if (this.f6498v == false) goto L23;
        this.f6498v = false;
        Log.i(r11, "onDrag open");
        Iterator<a> r15 = r13.iterator();
    L17:
        if (r15.hasNext() == false) goto L25;
        r15.next().a();
        goto L17
    L25:
        return;
    L23:
        return;
    }

    public final boolean getDismissSettling() {
        return this.f6497u;
    }

    public final boolean getInterceptingEvents() {
        return this.f6501y;
    }

    public final boolean getOpenSettling() {
        return this.f6498v;
    }

    @Override // android.view.View, android.view.ViewParent
    public final ViewGroup getParent() {
        return this.f6495s;
    }

    public final String getTAG() {
        return this.f6494r;
    }

    public final c getViewDragHelper() {
        return this.f6496t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        i.f(r8, "event");
        boolean r10 = this.f6501y;
        int r11 = r8.getActionMasked();
        if (r11 != 0) goto L5;
        int r12 = (int) r8.getX();
        int r13 = (int) r8.getY();
        Rect r14 = new Rect();
        b.a(this.f6495s, this, r14);
        r10 = r14.contains(r12, r13);
        this.f6501y = r10;
        Log.i(this.f6494r, "intercept: " + this.f6501y);
    L11:
        if (r10 == false) goto L18;
        ViewGroup r15 = this.f6495s;
        if (this.f6496t != null) goto L16;
        if (r15 == null) goto L16;
        c r16 = new c(r15.getContext(), r15, this.f6500x);
        r16.f9589b = (int) (r16.f9589b * 1.0f);
        this.f6496t = r16;
    L16:
        c r17 = this.f6496t;
        i.c(r17);
        return r17.r(r8);
    L18:
        return false;
    L5:
        if (r11 != 1) goto L7;
    L9:
        this.f6501y = false;
        goto L11
    L7:
        if (r11 == 3) goto L9;
        goto L9
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        i.f(r8, "event");
        c r10 = this.f6496t;
        if (r10 == null) goto L8;
        if (r10 == null) goto L10;
        r10.k(r8);
        return true;
    L10:
        return true;
    L8:
        return false;
    }

    public final void setDismissSettling(boolean r8) {
        this.f6497u = r8;
    }

    public final void setInterceptingEvents(boolean r8) {
        this.f6501y = r8;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r8) {
        this.f6499w = r8;
    }

    public final void setOpenSettling(boolean r8) {
        this.f6498v = r8;
    }

    public final void setParent(ViewGroup r8) {
        this.f6495s = r8;
        if (this.f6496t != null) goto L7;
        if (r8 == null) goto L8;
        c r10 = new c(r8.getContext(), r8, this.f6500x);
        r10.f9589b = (int) (r10.f9589b * 1.0f);
        this.f6496t = r10;
        return;
    L8:
        return;
    }

    public final void setViewDragHelper(c r8) {
        this.f6496t = r8;
    }
}
