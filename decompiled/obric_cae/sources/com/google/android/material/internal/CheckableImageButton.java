package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.customview.view.AbsSavedState;
import j0.w;

/* JADX INFO: loaded from: classes.dex */
public class CheckableImageButton extends androidx.appcompat.widget.m implements Checkable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f4816q = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4817n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4818o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4819p;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f4820m;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r8) {
                return new SavedState(r8, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r8) {
                return new SavedState[r8];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r8, ClassLoader r10) {
                return new SavedState(r8, r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r8, ClassLoader r10) {
            super(r8, r10);
            boolean r11 = true;
            if (r8.readInt() == 1) goto L6;
            r11 = false;
        L6:
            this.f4820m = r11;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable(this.f1731a, r10);
            r8.writeInt(this.f4820m ? 1 : 0);
        }
    }

    static {
        f4816q = new int[]{R.attr.state_checked};
    }

    public CheckableImageButton(Context r8, AttributeSet r10) {
        super(r8, r10, com.obric.cae.R.attr.imageButtonStyle);
        this.f4818o = true;
        this.f4819p = true;
        w.m(this, new a(this));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f4817n;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int r8) {
        if (this.f4817n == false) goto L7;
        return ImageButton.mergeDrawableStates(super.onCreateDrawableState(r8 + 1), f4816q);
    L7:
        return super.onCreateDrawableState(r8);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        if ((r8 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r8);
        return;
    L6:
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.f1731a);
        setChecked(r10.f4820m);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        r8.f4820m = this.f4817n;
        return r8;
    }

    public void setCheckable(boolean r8) {
        if (this.f4818o == r8) goto L6;
        this.f4818o = r8;
        sendAccessibilityEvent(0);
        return;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r8) {
        if (this.f4818o == true) goto L5;
        return;
    L5:
        if (this.f4817n == r8) goto L9;
        this.f4817n = r8;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
        return;
    }

    public void setPressable(boolean r8) {
        this.f4819p = r8;
    }

    @Override // android.view.View
    public void setPressed(boolean r8) {
        if (this.f4819p == false) goto L6;
        super.setPressed(r8);
        return;
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f4817n);
    }
}
