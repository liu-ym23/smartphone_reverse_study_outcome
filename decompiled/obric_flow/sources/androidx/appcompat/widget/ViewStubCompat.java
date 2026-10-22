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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewStubCompat extends View {
    private OnInflateListener mInflateListener;
    private int mInflatedId;
    private WeakReference<View> mInflatedViewRef;
    private LayoutInflater mInflater;
    private int mLayoutResource;

    public interface OnInflateListener {
        void onInflate(ViewStubCompat r5, View r10);
    }

    public ViewStubCompat(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas r5) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas r5) {
    }

    public int getInflatedId() {
        return this.mInflatedId;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    public int getLayoutResource() {
        return this.mLayoutResource;
    }

    public View inflate() {
        ViewParent r5 = getParent();
        if ((r5 instanceof ViewGroup) == false) goto L24;
        if (this.mLayoutResource == 0) goto L22;
        ViewGroup r10 = (ViewGroup) r5;
        LayoutInflater r11 = this.mInflater;
        if (r11 != null) goto L10;
        r11 = LayoutInflater.from(getContext());
    L10:
        View r12 = r11.inflate(this.mLayoutResource, r10, false);
        int r13 = this.mInflatedId;
        if (r13 == (-1)) goto L13;
        r12.setId(r13);
    L13:
        int r14 = r10.indexOfChild(this);
        r10.removeViewInLayout(this);
        ViewGroup.LayoutParams r15 = getLayoutParams();
        if (r15 == null) goto L16;
        r10.addView(r12, r14, r15);
    L17:
        this.mInflatedViewRef = new WeakReference(r12);
        OnInflateListener r16 = this.mInflateListener;
        if (r16 == null) goto L20;
        r16.onInflate(this, r12);
    L20:
        return r12;
    L16:
        r10.addView(r12, r14);
        goto L17
    L22:
        throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
    L24:
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    @Override // android.view.View
    public void onMeasure(int r5, int r10) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int r5) {
        this.mInflatedId = r5;
    }

    public void setLayoutInflater(LayoutInflater r5) {
        this.mInflater = r5;
    }

    public void setLayoutResource(int r5) {
        this.mLayoutResource = r5;
    }

    public void setOnInflateListener(OnInflateListener r5) {
        this.mInflateListener = r5;
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        WeakReference<View> r10 = this.mInflatedViewRef;
        if (r10 == null) goto L9;
        View r11 = r10.get();
        if (r11 == null) goto L8;
        r11.setVisibility(r5);
        return;
    L8:
        throw new IllegalStateException("setVisibility called on un-referenced view");
    L9:
        super.setVisibility(r5);
        if (r5 != 0) goto L12;
    L13:
        inflate();
        return;
    L12:
        if (r5 == 4) goto L13;
    }

    public ViewStubCompat(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mLayoutResource = 0;
        TypedArray r12 = r5.obtainStyledAttributes(r10, R.styleable.ViewStubCompat, r11, 0);
        this.mInflatedId = r12.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.mLayoutResource = r12.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
        setId(r12.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
        r12.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
