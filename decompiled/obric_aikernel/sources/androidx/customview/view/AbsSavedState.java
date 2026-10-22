package androidx.customview.view;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = null;
    public static final AbsSavedState EMPTY_STATE = null;
    private final Parcelable mSuperState;

    static {
        EMPTY_STATE = new AnonymousClass1();
        CREATOR = new AnonymousClass2();
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    protected AbsSavedState(@NonNull Parcel r10) {
        this(r10, null);
    }

    protected AbsSavedState(@NonNull Parcel r10, @Nullable ClassLoader r11) {
        Parcelable r12 = r10.readParcelable(r11);
        if (r12 != null) goto L6;
        r12 = EMPTY_STATE;
    L6:
        this.mSuperState = r12;
    }

    protected AbsSavedState(@NonNull Parcelable r10) {
        if (r10 == null) goto L11;
        if (r10 != EMPTY_STATE) goto L8;
        r10 = null;
    L8:
        this.mSuperState = r10;
        return;
    L11:
        throw new IllegalArgumentException("superState must not be null");
    }

    /* synthetic */ AbsSavedState(AnonymousClass1 r10) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeParcelable(this.mSuperState, r11);
    }
}
