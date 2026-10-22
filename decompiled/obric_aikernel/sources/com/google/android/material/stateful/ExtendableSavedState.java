package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = null;

    @NonNull
    public final SimpleArrayMap<String, Bundle> extendableStates;

    class a implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public ExtendableSavedState a(@NonNull Parcel r10) {
            return new ExtendableSavedState(r10, null, 0 == true ? 1 : 0);
        }

        @NonNull
        public ExtendableSavedState b(@NonNull Parcel r10, ClassLoader r11) {
            return new ExtendableSavedState(r10, r11, null);
        }

        @NonNull
        public ExtendableSavedState[] c(int r10) {
            return new ExtendableSavedState[r10];
        }

        @Override // android.os.Parcelable.Creator
        @Nullable
        public /* bridge */ /* synthetic */ Object createFromParcel(@NonNull Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        @NonNull
        public /* bridge */ /* synthetic */ ExtendableSavedState createFromParcel(@NonNull Parcel r10, ClassLoader r11) {
            return b(r10, r11);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return c(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    private ExtendableSavedState(@NonNull Parcel r10, ClassLoader r11) {
        super(r10, r11);
        int r12 = r10.readInt();
        String[] r13 = new String[r12];
        r10.readStringArray(r13);
        Bundle[] r14 = new Bundle[r12];
        r10.readTypedArray(r14, Bundle.CREATOR);
        this.extendableStates = new SimpleArrayMap(r12);
        int r15 = 0;
    L3:
        if (r15 >= r12) goto L5;
        this.extendableStates.put(r13[r15], r14[r15]);
        r15 = r15 + 1;
        goto L3
    }

    /* synthetic */ ExtendableSavedState(Parcel r10, ClassLoader r11, a r12) {
        this(r10, r11);
    }

    public ExtendableSavedState(Parcelable r10) {
        super(r10);
        this.extendableStates = new SimpleArrayMap();
    }

    @NonNull
    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.extendableStates + "}";
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        super.writeToParcel(r10, r11);
        int r12 = this.extendableStates.size();
        r10.writeInt(r12);
        String[] r13 = new String[r12];
        Bundle[] r14 = new Bundle[r12];
        int r15 = 0;
    L3:
        if (r15 >= r12) goto L5;
        r13[r15] = this.extendableStates.keyAt(r15);
        r14[r15] = this.extendableStates.valueAt(r15);
        r15 = r15 + 1;
        goto L3
    L5:
        r10.writeStringArray(r13);
        r10.writeTypedArray(r14, 0);
    }
}
