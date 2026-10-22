package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/model/objects/Icons;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "1x", "", "get1x", "()Ljava/lang/String;", "set1x", "(Ljava/lang/String;)V", "2x", "get2x", "set2x", "3x", "get3x", "set3x", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Icons implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: 1x, reason: not valid java name */
    private String f01x;

    /* JADX INFO: renamed from: 2x, reason: not valid java name */
    private String f12x;

    /* JADX INFO: renamed from: 3x, reason: not valid java name */
    private String f23x;

    public static final class a implements Parcelable.Creator<Icons> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Icons createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new Icons(r10);
        }

        @Override // android.os.Parcelable.Creator
        public final Icons[] newArray(int r1) {
            return new Icons[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Icons() {
        this.f01x = "";
        this.f12x = "";
        this.f23x = "";
    }

    public final String get1x() {
        return this.f01x;
    }

    public final String get2x() {
        return this.f12x;
    }

    public final String get3x() {
        return this.f23x;
    }

    public Icons(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        this();
        this.f01x = r10.readString();
        this.f12x = r10.readString();
        this.f23x = r10.readString();
    }

    public final void set1x(String r1) {
        this.f01x = r1;
    }

    public final void set2x(String r1) {
        this.f12x = r1;
    }

    public final void set3x(String r1) {
        this.f23x = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.f01x);
        r1.writeString(this.f12x);
        r1.writeString(this.f23x);
    }
}
