package com.obric.capabilitykit.common.execution.fileaccess;

import android.content.res.AssetFileDescriptor;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "Landroid/os/Parcelable;", "ErrorCode", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final class UriFileAccessSession implements Parcelable {
    public static final Parcelable.Creator<UriFileAccessSession> CREATOR = null;
    public final int a;
    public final String b;
    public final AssetFileDescriptor c;

    public static final class a implements Parcelable.Creator<UriFileAccessSession> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UriFileAccessSession createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            return new UriFileAccessSession(r5.readInt(), r5.readString(), (AssetFileDescriptor) r5.readParcelable(UriFileAccessSession.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final UriFileAccessSession[] newArray(int r1) {
            return new UriFileAccessSession[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public UriFileAccessSession() {
        int r2 = 0;
        this(r2, null, 7);
    }

    public /* synthetic */ UriFileAccessSession(int r2, String r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        this(r2, r3, null);
    }

    public UriFileAccessSession(int r2, String r3, AssetFileDescriptor r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UriFileAccessSession) == true) goto L8;
        return false;
    L8:
        UriFileAccessSession r6 = (UriFileAccessSession) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
        AssetFileDescriptor r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "UriFileAccessSession(status=" + this.a + ", message=" + this.b + ", fd=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeInt(this.a);
        r2.writeString(this.b);
        r2.writeParcelable(this.c, r3);
    }
}
