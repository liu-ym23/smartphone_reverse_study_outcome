package gu;

import android.content.Context;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends h {
    public final Rect d;
    public final float e;
    public final br.c f;

    public b(Context r5) {
        super(r5);
        this.d = new Rect();
        this.f = new br.c(this, 8);
        new RectF();
        new Path();
        setExecutor(hu.b.f17472a);
        LayoutInflater.from(r5);
        this.e = (28 * r5.getResources().getDisplayMetrics().density) + 0.5f;
    }

    @Override // android.appwidget.AppWidgetHostView
    public View getDefaultView() {
        return super.getDefaultView();
    }

    public float getEnforcedCornerRadius() {
        return this.e;
    }

    @Override // android.appwidget.AppWidgetHostView
    public View getErrorView() {
        return new View(getContext());
    }

    @Override // android.appwidget.AppWidgetHostView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);     // Catch: RuntimeException -> L4
    L6:
        if (this.e <= 0.0f) goto L28;
        ArrayList r14 = new ArrayList();
        td.b.g(this, r14);
        if (r14.size() != 1) goto L11;
        View r15 = (View) r14.get(0);
    L14:
        if (r15 != null) goto L16;
    L27:
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        setClipToOutline(false);
        return;
    L16:
        if (r15.getId() == 16908288) goto L18;
    L20:
        Rect r16 = this.d;
        r16.left = 0;
        r16.right = r15.getWidth();
        r16.top = 0;
        r16.bottom = r15.getHeight();
    L21:
        if (r15 == this) goto L23;
        r16.offset(r15.getLeft(), r15.getTop());
        r15 = (View) r15.getParent();
        goto L21
    L23:
        View r17 = (View) getParent();
        if (r17 == null) goto L26;
        int r18 = r17.getPaddingLeft();
        int r19 = r17.getPaddingTop();
        int r20 = r17.getPaddingRight();
        int r21 = r17.getPaddingBottom();
        int r22 = r17.getWidth() - r20;
        int r23 = r17.getHeight() - r21;
        r16.left = Math.max(r16.left, r18);
        r16.top = Math.max(r16.top, r19);
        r16.right = Math.min(r16.right, r22);
        r16.bottom = Math.min(r16.bottom, r23);
    L26:
        setOutlineProvider(this.f);
        setClipToOutline(true);
        return;
    L18:
        if (r15.getClipToOutline() == false) goto L20;
    L11:
        if (getChildCount() <= 0) goto L13;
        r15 = td.b.h(getChildAt(0));
        goto L14
    L13:
        r15 = this;
        goto L14
    L28:
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        setClipToOutline(false);
        return;
    L4:
        post(new com.obric.oui.lisitem.a(this, 8));
        goto L6
    }
}
