package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class BaseSlider$SliderState extends View.BaseSavedState {
    public static final Parcelable.Creator<BaseSlider$SliderState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f4944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f4945b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<Float> f4946m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f4947n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f4948o;

    public class a implements Parcelable.Creator<BaseSlider$SliderState> {
        @Override // android.os.Parcelable.Creator
        public final BaseSlider$SliderState createFromParcel(Parcel r8) {
            return new BaseSlider$SliderState(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final BaseSlider$SliderState[] newArray(int r8) {
            return new BaseSlider$SliderState[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public BaseSlider$SliderState(Parcel r8) {
        super(r8);
        this.f4944a = r8.readFloat();
        this.f4945b = r8.readFloat();
        ArrayList<Float> r10 = new ArrayList();
        this.f4946m = r10;
        r8.readList(r10, Float.class.getClassLoader());
        this.f4947n = r8.readFloat();
        this.f4948o = r8.createBooleanArray()[0];
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        super.writeToParcel(r8, r10);
        r8.writeFloat(this.f4944a);
        r8.writeFloat(this.f4945b);
        r8.writeList(this.f4946m);
        r8.writeFloat(this.f4947n);
        r8.writeBooleanArray(new boolean[]{this.f4948o});
    }
}
