package com.bytedance.android.live.openplatform.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/MemoryStatus;", "Landroid/os/Parcelable;", "liveopenplatform-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MemoryStatus implements Parcelable {
    public static final Parcelable.Creator<MemoryStatus> CREATOR = null;
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public static class a implements Parcelable.Creator<MemoryStatus> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MemoryStatus createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "in");
            return new MemoryStatus(r5.readInt(), r5.readInt(), r5.readInt(), r5.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final MemoryStatus[] newArray(int r1) {
            return new MemoryStatus[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public MemoryStatus() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof MemoryStatus) == false) goto L14;
        MemoryStatus r4 = (MemoryStatus) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "MemoryStatus(rememberMiniAppStatus=" + this.a + ", rememberCardStatus=" + this.b + ", showLiveData=" + this.c + ", showImportantCard=" + this.d + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.a);
        r1.writeInt(this.b);
        r1.writeInt(this.c);
        r1.writeInt(this.d);
    }

    public final boolean b() {
        if (this.b == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public /* synthetic */ MemoryStatus(int r2) {
        this(-1, -1, 1, -1);
    }

    public MemoryStatus(int r1, int r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public static MemoryStatus a(MemoryStatus r1, int r2, int r3, int r4, int r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.b;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.c;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = r1.d;
    L14:
        r1.getClass();
        return new MemoryStatus(r2, r3, r4, r5);
    }
}
