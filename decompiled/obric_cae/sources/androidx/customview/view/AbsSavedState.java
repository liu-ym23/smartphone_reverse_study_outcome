package androidx.customview.view;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbsSavedState f1730b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Parcelable f1731a;

    public class a implements Parcelable.ClassLoaderCreator<AbsSavedState> {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r8) {
            if (r8.readParcelable(null) != null) goto L7;
            return AbsSavedState.f1730b;
        L7:
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r8) {
            return new AbsSavedState[r8];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final AbsSavedState createFromParcel(Parcel r8, ClassLoader r10) {
            if (r8.readParcelable(r10) != null) goto L7;
            return AbsSavedState.f1730b;
        L7:
            throw new IllegalStateException("superState must be null");
        }
    }

    static {
        f1730b = new AnonymousClass1();
        CREATOR = new a();
    }

    private AbsSavedState() {
        this.f1731a = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeParcelable(this.f1731a, r10);
    }

    public /* synthetic */ AbsSavedState(int r8) {
        this();
    }

    public AbsSavedState(Parcel r8, ClassLoader r10) {
        Parcelable r11 = r8.readParcelable(r10);
        if (r11 != null) goto L6;
        r11 = f1730b;
    L6:
        this.f1731a = r11;
    }

    public AbsSavedState(Parcelable r8) {
        if (r8 == null) goto L11;
        if (r8 != f1730b) goto L8;
        r8 = null;
    L8:
        this.f1731a = r8;
        return;
    L11:
        throw new IllegalArgumentException("superState must not be null");
    }
}
