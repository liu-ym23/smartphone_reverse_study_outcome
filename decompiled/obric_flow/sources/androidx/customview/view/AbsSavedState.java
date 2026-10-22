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

    public /* synthetic */ AbsSavedState(AnonymousClass1 r5) {
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
    public void writeToParcel(Parcel r5, int r10) {
        r5.writeParcelable(this.mSuperState, r10);
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    public AbsSavedState(@NonNull Parcelable r5) {
        if (r5 == null) goto L11;
        if (r5 != EMPTY_STATE) goto L8;
        r5 = null;
    L8:
        this.mSuperState = r5;
        return;
    L11:
        throw new IllegalArgumentException("superState must not be null");
    }

    public AbsSavedState(@NonNull Parcel r5) {
        this(r5, null);
    }

    public AbsSavedState(@NonNull Parcel r5, @Nullable ClassLoader r10) {
        Parcelable r11 = r5.readParcelable(r10);
        if (r11 != null) goto L6;
        r11 = EMPTY_STATE;
    L6:
        this.mSuperState = r11;
    }
}
