package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0003J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006 "}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/HeifOutputOption;", "Landroid/os/Parcelable;", "outputWidth", "", "outputHeight", "qp", "downScalePreference", "<init>", "(IIII)V", "getOutputWidth", "()I", "getOutputHeight", "getQp", "getDownScalePreference", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HeifOutputOption implements Parcelable {
    public static final Parcelable.Creator<HeifOutputOption> CREATOR = null;
    private final int downScalePreference;
    private final int outputHeight;
    private final int outputWidth;
    private final int qp;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<HeifOutputOption> {
        public a() {
        }

        public final HeifOutputOption a(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            return new HeifOutputOption(r4.readInt(), r4.readInt(), r4.readInt(), r4.readInt());
        }

        public final HeifOutputOption[] a(int r1) {
            return new HeifOutputOption[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ HeifOutputOption createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ HeifOutputOption[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public HeifOutputOption() {
        this(0, 0, 0, 0, 15, null);
    }

    public HeifOutputOption(int r1, int r2, int r3, int r4) {
        this.outputWidth = r1;
        this.outputHeight = r2;
        this.qp = r3;
        this.downScalePreference = r4;
    }

    public /* synthetic */ HeifOutputOption(int r2, int r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 35;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0;
    L14:
        this(r2, r3, r4, r5);
    }

    public static /* synthetic */ HeifOutputOption copy$default(HeifOutputOption r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.outputWidth;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.outputHeight;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.qp;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.downScalePreference;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.outputWidth;
    }

    public final int component2() {
        return this.outputHeight;
    }

    public final int component3() {
        return this.qp;
    }

    public final int component4() {
        return this.downScalePreference;
    }

    public final HeifOutputOption copy(int r1, int r2, int r3, int r4) {
        return new HeifOutputOption(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, HeifOutputOption.class) == true) goto L8;
        return false;
    L8:
        HeifOutputOption r6 = (HeifOutputOption) ZeusTransformUtils.preCheckCast(r5, HeifOutputOption.class, "com.obric.memorydata.plugin");
        if (this.outputWidth == r6.outputWidth) goto L12;
        return false;
    L12:
        if (this.outputHeight == r6.outputHeight) goto L15;
        return false;
    L15:
        if (this.qp == r6.qp) goto L18;
        return false;
    L18:
        if (this.downScalePreference == r6.downScalePreference) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getDownScalePreference() {
        return this.downScalePreference;
    }

    public final int getOutputHeight() {
        return this.outputHeight;
    }

    public final int getOutputWidth() {
        return this.outputWidth;
    }

    public final int getQp() {
        return this.qp;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.outputWidth) * 31) + Integer.hashCode(this.outputHeight)) * 31) + Integer.hashCode(this.qp)) * 31) + Integer.hashCode(this.downScalePreference);
    }

    public String toString() {
        return "HeifOutputOption(outputWidth=" + this.outputWidth + ", outputHeight=" + this.outputHeight + ", qp=" + this.qp + ", downScalePreference=" + this.downScalePreference + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(this.outputWidth);
        r1.writeInt(this.outputHeight);
        r1.writeInt(this.qp);
        r1.writeInt(this.downScalePreference);
    }
}
