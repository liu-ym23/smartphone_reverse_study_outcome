package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
class RangeSlider$RangeSliderState extends AbsSavedState {
    public static final Parcelable.Creator<RangeSlider$RangeSliderState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f4949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4950b;

    public class a implements Parcelable.Creator<RangeSlider$RangeSliderState> {
        @Override // android.os.Parcelable.Creator
        public final RangeSlider$RangeSliderState createFromParcel(Parcel r8) {
            return new RangeSlider$RangeSliderState(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final RangeSlider$RangeSliderState[] newArray(int r8) {
            return new RangeSlider$RangeSliderState[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public RangeSlider$RangeSliderState(Parcel r8) {
        super(r8.readParcelable(RangeSlider$RangeSliderState.class.getClassLoader()));
        this.f4949a = r8.readFloat();
        this.f4950b = r8.readInt();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        super.writeToParcel(r8, r10);
        r8.writeFloat(this.f4949a);
        r8.writeInt(this.f4950b);
    }
}
