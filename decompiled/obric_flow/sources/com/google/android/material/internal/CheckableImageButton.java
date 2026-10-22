package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED = null;
    private boolean checkable;
    private boolean checked;
    private boolean pressable;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean checked;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }

        private void readFromParcel(@NonNull Parcel r5) {
            boolean r10 = true;
            if (r5.readInt() == 1) goto L6;
            r10 = false;
        L6:
            this.checked = r10;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeInt(this.checked ? 1 : 0);
        }

        public SavedState(@NonNull Parcel r5, ClassLoader r10) {
            super(r5, r10);
            readFromParcel(r5);
        }
    }

    static {
        DRAWABLE_STATE_CHECKED = new int[]{R.attr.state_checked};
    }

    public CheckableImageButton(Context r5) {
        this(r5, null);
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    public boolean isPressable() {
        return this.pressable;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r5) {
        if (this.checked == false) goto L7;
        int[] r10 = DRAWABLE_STATE_CHECKED;
        return View.mergeDrawableStates(super.onCreateDrawableState(r5 + r10.length), r10);
    L7:
        return super.onCreateDrawableState(r5);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        setChecked(r10.checked);
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        r5.checked = this.checked;
        return r5;
    }

    public void setCheckable(boolean r5) {
        if (this.checkable == r5) goto L6;
        this.checkable = r5;
        sendAccessibilityEvent(0);
        return;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r5) {
        if (this.checkable == true) goto L5;
        return;
    L5:
        if (this.checked == r5) goto L9;
        this.checked = r5;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
        return;
    }

    public void setPressable(boolean r5) {
        this.pressable = r5;
    }

    @Override // android.view.View
    public void setPressed(boolean r5) {
        if (this.pressable == false) goto L6;
        super.setPressed(r5);
        return;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    public CheckableImageButton(Context r5, AttributeSet r10) {
        this(r5, r10, androidx.appcompat.R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.checkable = true;
        this.pressable = true;
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass1(this));
    }
}
