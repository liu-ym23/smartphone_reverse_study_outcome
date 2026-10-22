package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1085b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WeakReference<View> f1086m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LayoutInflater f1087n;

    public interface a {
    }

    public ViewStubCompat(Context r8, AttributeSet r10) {
        super(r8, r10, 0);
        this.f1084a = 0;
        TypedArray r11 = r8.obtainStyledAttributes(r10, c.a.B, 0, 0);
        this.f1085b = r11.getResourceId(2, -1);
        this.f1084a = r11.getResourceId(1, 0);
        setId(r11.getResourceId(0, -1));
        r11.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final View a() {
        ViewParent r8 = getParent();
        if ((r8 instanceof ViewGroup) == false) goto L22;
        if (this.f1084a == 0) goto L20;
        ViewGroup r10 = (ViewGroup) r8;
        LayoutInflater r11 = this.f1087n;
        if (r11 != null) goto L10;
        r11 = LayoutInflater.from(getContext());
    L10:
        View r12 = r11.inflate(this.f1084a, r10, false);
        int r13 = this.f1085b;
        if (r13 == (-1)) goto L13;
        r12.setId(r13);
    L13:
        int r14 = r10.indexOfChild(this);
        r10.removeViewInLayout(this);
        ViewGroup.LayoutParams r15 = getLayoutParams();
        if (r15 == null) goto L16;
        r10.addView(r12, r14, r15);
    L17:
        this.f1086m = new WeakReference(r12);
        return r12;
    L16:
        r10.addView(r12, r14);
        goto L17
    L20:
        throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
    L22:
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas r8) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public final void draw(Canvas r8) {
    }

    public int getInflatedId() {
        return this.f1085b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1087n;
    }

    public int getLayoutResource() {
        return this.f1084a;
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r10) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int r8) {
        this.f1085b = r8;
    }

    public void setLayoutInflater(LayoutInflater r8) {
        this.f1087n = r8;
    }

    public void setLayoutResource(int r8) {
        this.f1084a = r8;
    }

    public void setOnInflateListener(a r8) {
    }

    @Override // android.view.View
    public void setVisibility(int r8) {
        WeakReference<View> r10 = this.f1086m;
        if (r10 == null) goto L9;
        View r11 = r10.get();
        if (r11 == null) goto L8;
        r11.setVisibility(r8);
        return;
    L8:
        throw new IllegalStateException("setVisibility called on un-referenced view");
    L9:
        super.setVisibility(r8);
        if (r8 != 0) goto L12;
    L13:
        a();
        return;
    L12:
        if (r8 == 4) goto L13;
    }
}
