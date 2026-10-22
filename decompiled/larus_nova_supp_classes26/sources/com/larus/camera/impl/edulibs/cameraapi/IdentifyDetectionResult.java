package com.larus.camera.impl.edulibs.cameraapi;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0005J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/larus/camera/impl/edulibs/cameraapi/IdentifyDetectionResult;", "Landroid/os/Parcelable;", "isPass", "", "failReason", "", "detectTime", "", "<init>", "(ZIJ)V", "()Z", "getFailReason", "()I", "getDetectTime", "()J", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IdentifyDetectionResult implements Parcelable {
    public static final Parcelable.Creator<IdentifyDetectionResult> CREATOR = null;
    public final boolean a;
    public final int b;
    public final long c;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<IdentifyDetectionResult> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final IdentifyDetectionResult createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            if (r6.readInt() == 0) goto L5;
            boolean r1 = true;
        L7:
            return new IdentifyDetectionResult(r1, r6.readInt(), r6.readLong());
        L5:
            r1 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final IdentifyDetectionResult[] newArray(int r1) {
            return new IdentifyDetectionResult[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    public IdentifyDetectionResult() {
        this(0, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof IdentifyDetectionResult) == true) goto L8;
        return false;
    L8:
        IdentifyDetectionResult r9 = (IdentifyDetectionResult) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.b) * 31;
        long r2 = this.c;
        return r1 + ((int) (r2 ^ (r2 >>> 32)));
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "IdentifyDetectionResult(isPass=" + this.a + ", failReason=" + this.b + ", detectTime=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeInt(this.a ? 1 : 0);
        r3.writeInt(this.b);
        r3.writeLong(this.c);
    }

    public /* synthetic */ IdentifyDetectionResult(long r3, int r5) {
        if ((r5 & 1) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r3 = 0;
    L9:
        this(r0, 0, r3);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public IdentifyDetectionResult(boolean r1, int r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
