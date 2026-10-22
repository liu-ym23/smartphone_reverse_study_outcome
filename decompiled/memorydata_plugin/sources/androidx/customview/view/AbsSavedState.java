package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
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

    public AbsSavedState(Parcel r2) {
        this(r2, null);
    }

    public AbsSavedState(Parcel r1, ClassLoader r2) {
        Parcelable r3 = r1.readParcelable(r2);
        if (r3 != null) goto L6;
        r3 = EMPTY_STATE;
    L6:
        this.mSuperState = r3;
    }

    public AbsSavedState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L11;
        if (r4 != EMPTY_STATE) goto L8;
        r4 = null;
    L8:
        this.mSuperState = r4;
        return;
    L11:
        throw new IllegalArgumentException("superState must not be null");
    }

    /* synthetic */ AbsSavedState(AnonymousClass1 r1) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeParcelable(this.mSuperState, r2);
    }
}
