package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import n.h;

/* JADX INFO: loaded from: classes.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final h<String, Bundle> f4966m;

    public class a implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r8) {
            return new ExtendableSavedState(r8, null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r8) {
            return new ExtendableSavedState[r8];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final ExtendableSavedState createFromParcel(Parcel r8, ClassLoader r10) {
            return new ExtendableSavedState(r8, r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public ExtendableSavedState(Parcel r8, ClassLoader r10) {
        super(r8, r10);
        int r11 = r8.readInt();
        String[] r12 = new String[r11];
        r8.readStringArray(r12);
        Bundle[] r13 = new Bundle[r11];
        r8.readTypedArray(r13, Bundle.CREATOR);
        this.f4966m = new h(r11);
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        this.f4966m.put(r12[r14], r13[r14]);
        r14 = r14 + 1;
        goto L3
    }

    public final String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f4966m + "}";
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeParcelable(this.f1731a, r10);
        h<String, Bundle> r11 = this.f4966m;
        int r12 = r11.f9401m;
        r8.writeInt(r12);
        String[] r13 = new String[r12];
        Bundle[] r14 = new Bundle[r12];
        int r15 = 0;
    L3:
        if (r15 >= r12) goto L5;
        r13[r15] = r11.i(r15);
        r14[r15] = r11.k(r15);
        r15 = r15 + 1;
        goto L3
    L5:
        r8.writeStringArray(r13);
        r8.writeTypedArray(r14, 0);
    }

    public ExtendableSavedState(Parcelable r8) {
        super(r8);
        this.f4966m = new h();
    }
}
