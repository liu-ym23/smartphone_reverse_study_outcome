package com.obric.flow.cardlistpage.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\fR$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\"\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/obric/flow/cardlistpage/ui/view/WidgetBox;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "translationX", "", "setTranslationX", "(F)V", "translationY", "setTranslationY", "scaleX", "setScaleX", "scaleY", "setScaleY", "x", "setX", "y", "setY", "Landroid/view/View;", "a", "Landroid/view/View;", "getShadowView", "()Landroid/view/View;", "setShadowView", "(Landroid/view/View;)V", "shadowView", "b", "getWidgetView", "setWidgetView", "widgetView", "c", "getAnchorView", "setAnchorView", "anchorView", "", "d", "Z", "getSelectedStatus", "()Z", "setSelectedStatus", "(Z)V", "selectedStatus", "", "i", "I", "getStatus", "()I", "setStatus", "(I)V", NotificationCompat.CATEGORY_STATUS, "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetBox extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f11830j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f11831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f11832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f11833c;
    public boolean d;
    public com.obric.flow.cardlistpage.util.a e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f11834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11835i;

    public WidgetBox(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "attrs");
        super(r5, r10);
        this.f11834h = ViewConfiguration.get(r5).getScaledTouchSlop();
    }

    public final void a(boolean r5) {
        if (this.d == true) goto L5;
        return;
    L5:
        this.d = false;
        ViewParent r10 = getParent();
        if (r10 == null) goto L9;
        r10.requestDisallowInterceptTouchEvent(false);
    L9:
        if (r5 == false) goto L11;
        int r11 = obric.flow.nlwidget.utils.a.f20526a;
        Intrinsics.checkNotNullParameter(this, "view");
        obric.flow.nlwidget.utils.a.a(this, 1.0f);
        return;
    L11:
        setScaleX(1.0f);
        setScaleY(1.0f);
    }

    public final void b() {
        animate().cancel();
        setAlpha(1.0f);
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        setScaleX(1.0f);
        setScaleY(1.0f);
        this.d = false;
        this.f11835i = 0;
        this.f11831a = null;
        com.obric.flow.cardlistpage.util.a r5 = this.e;
        if (r5 == null) goto L8;
        r5.e = false;
        androidx.fragment.app.d r10 = r5.f;
        if (r10 == null) goto L9;
        r5.f11880a.removeCallbacks(r10);
        r5.f = null;
        return;
    L9:
        return;
    }

    public final void c(boolean r5, boolean r10) {
        if (r5 == false) goto L4;
        int r11 = this.f11835i | 2;
    L5:
        this.f11835i = r11;
        if ((r11 & 3) == 0) goto L8;
        e();
    L9:
        if (r5 == false) goto L14;
        ViewParent r12 = getParent();
        if (r12 == null) goto L15;
        r12.requestDisallowInterceptTouchEvent(false);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        a(r10);
        goto L9
    L4:
        r11 = this.f11835i & (-3);
        goto L5
    }

    public final void d(boolean r5, boolean r10) {
        if (r5 == false) goto L4;
        int r11 = this.f11835i | 1;
    L5:
        this.f11835i = r11;
        if ((r11 & 3) == 0) goto L8;
        e();
        return;
    L8:
        a(r10);
        return;
    L4:
        r11 = this.f11835i & (-2);
        goto L5
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r12, "event");
        int r5 = r12.getActionMasked();
        if (r5 == 0) goto L12;
        if (r5 == 1) goto L8;
        if (r5 == 2) goto L12;
        if (r5 == 3) goto L8;
    L20:
        if (this.e != null) goto L22;
        this.e = new com.obric.flow.cardlistpage.util.a(this, new j(this));
    L22:
        int r10 = r12.getActionMasked();
        if (r10 == 0) goto L40;
        if (r10 == 1) goto L38;
        if (r10 == 2) goto L28;
        if (r10 == 3) goto L38;
    L43:
        com.obric.flow.cardlistpage.util.a r11 = this.e;
        if (r11 == null) goto L84;
        Intrinsics.checkNotNullParameter(r12, "ev");
        int r13 = r12.getAction();
        WidgetBox r14 = r11.f11880a;
        if (r13 == 0) goto L72;
        if (r13 == 1) goto L69;
        if (r13 == 2) goto L51;
        if (r13 == 3) goto L69;
    L51:
        float r15 = r12.getX();
        float r16 = r12.getY();
        float r17 = r11.f11882c;
        Intrinsics.checkNotNullParameter(r14, "v");
        float r18 = -r17;
        if (r15 >= r18) goto L54;
    L66:
        r11.e = false;
        androidx.fragment.app.d r19 = r11.f;
        if (r19 == null) goto L84;
        r14.removeCallbacks(r19);
        r11.f = null;
        goto L84
    L54:
        if (r16 < r18) goto L66;
        if (r15 >= (r14.getWidth() + r17)) goto L66;
        if (r16 >= (r14.getHeight() + r17)) goto L66;
        if (r11.f == null) goto L84;
        if (r12.getToolType(0) != 2) goto L84;
        if (r12.isButtonPressed(2) == false) goto L84;
        r11.a();
    L69:
        r11.e = false;
        androidx.fragment.app.d r20 = r11.f;
        if (r20 == null) goto L84;
        r14.removeCallbacks(r20);
        r11.f = null;
        goto L84
    L72:
        r11.e = false;
        androidx.fragment.app.d r21 = r11.f;
        if (r21 == null) goto L75;
        r14.removeCallbacks(r21);
        r11.f = null;
    L75:
        r11.e = false;
        if (r11.f != null) goto L78;
        r11.f = new androidx.fragment.app.d(r11, 27);
    L78:
        r14.postDelayed(r11.f, (long) (ViewConfiguration.getLongPressTimeout() * r11.d));
        if (r12.getToolType(0) != 2) goto L84;
        if (r12.isButtonPressed(2) == false) goto L84;
        r11.a();
    L84:
        if (this.d == false) goto L86;
        return true;
    L86:
        return super.dispatchTouchEvent(r12);
    L28:
        float r22 = Math.abs(r12.getRawX() - this.f);
        float r23 = this.f11834h;
        if (r22 <= r23) goto L31;
    L32:
        com.obric.flow.cardlistpage.util.a r24 = this.e;
        if (r24 == null) goto L43;
        r24.e = false;
        androidx.fragment.app.d r25 = r24.f;
        if (r25 == null) goto L43;
        r24.f11880a.removeCallbacks(r25);
        r24.f = null;
        goto L43
    L31:
        if (Math.abs(r12.getRawY() - this.g) <= r23) goto L43;
    L38:
        if (this.d == true) goto L43;
        int r26 = obric.flow.nlwidget.utils.a.f20526a;
        Intrinsics.checkNotNullParameter(this, "view");
        obric.flow.nlwidget.utils.a.a(this, 1.0f);
        goto L43
    L40:
        this.f = r12.getRawX();
        this.g = r12.getRawY();
        int r27 = obric.flow.nlwidget.utils.a.f20526a;
        Intrinsics.checkNotNullParameter(this, "view");
        obric.flow.nlwidget.utils.a.a(this, 0.95f);
        if (this.d == true) goto L43;
        super.dispatchTouchEvent(r12);
    L8:
        ViewParent r28 = getParent();
        if (r28 == null) goto L20;
        r28.requestDisallowInterceptTouchEvent(false);
    L12:
        if (this.d == false) goto L20;
        if ((this.f11835i & 2) != 0) goto L20;
        ViewParent r29 = getParent();
        if (r29 == null) goto L20;
        r29.requestDisallowInterceptTouchEvent(true);
        goto L20
    }

    public final void e() {
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = true;
        if ((this.f11835i & 2) != 0) goto L11;
        ViewParent r5 = getParent();
        if (r5 == null) goto L11;
        r5.requestDisallowInterceptTouchEvent(true);
    L11:
        int r10 = obric.flow.nlwidget.utils.a.f20526a;
        Intrinsics.checkNotNullParameter(this, "view");
        obric.flow.nlwidget.utils.a.a(this, 1.06f);
    }

    public final View getAnchorView() {
        return this.f11833c;
    }

    public final boolean getSelectedStatus() {
        return this.d;
    }

    public final View getShadowView() {
        return this.f11831a;
    }

    public final int getStatus() {
        return this.f11835i;
    }

    public final View getWidgetView() {
        return this.f11832b;
    }

    public final void setAnchorView(View r5) {
        this.f11833c = r5;
    }

    @Override // android.view.View
    public void setScaleX(float r5) {
        View r10 = this.f11831a;
        if (r10 == null) goto L5;
        r10.setScaleX(r5);
    L5:
        super.setScaleX(r5);
    }

    @Override // android.view.View
    public void setScaleY(float r5) {
        View r10 = this.f11831a;
        if (r10 == null) goto L5;
        r10.setScaleY(r5);
    L5:
        super.setScaleY(r5);
    }

    public final void setSelectedStatus(boolean r5) {
        this.d = r5;
    }

    public final void setShadowView(View r5) {
        this.f11831a = r5;
    }

    public final void setStatus(int r5) {
        this.f11835i = r5;
    }

    @Override // android.view.View
    public void setTranslationX(float r5) {
        View r10 = this.f11831a;
        if (r10 == null) goto L5;
        r10.setX(getX());
        float r11 = r10.getTranslationX();
        r10.setTranslationX((r5 - getTranslationX()) + r11);
    L5:
        super.setTranslationX(r5);
    }

    @Override // android.view.View
    public void setTranslationY(float r5) {
        View r10 = this.f11831a;
        if (r10 == null) goto L5;
        r10.setY(getY());
        float r11 = r10.getTranslationY();
        r10.setTranslationY((r5 - getTranslationY()) + r11);
    L5:
        super.setTranslationY(r5);
    }

    public final void setWidgetView(View r5) {
        this.f11832b = r5;
    }

    @Override // android.view.View
    public void setX(float r5) {
        View r10 = this.f11831a;
        if (r10 == null) goto L5;
        r10.setX(r5);
    L5:
        super.setX(r5);
    }

    @Override // android.view.View
    public void setY(float r5) {
        View r10 = this.f11831a;
        if (r10 == null) goto L5;
        r10.setY(r5);
    L5:
        super.setY(r5);
    }
}
