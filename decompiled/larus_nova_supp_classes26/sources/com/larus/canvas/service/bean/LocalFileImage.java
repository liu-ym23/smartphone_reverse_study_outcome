package com.larus.canvas.service.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JF\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0006J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/larus/canvas/service/bean/LocalFileImage;", "Lcom/larus/canvas/service/bean/IImageInfo;", "localFilePath", "", "uri", "width", "", "height", "needReview", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "getLocalFilePath", "()Ljava/lang/String;", "getUri", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getNeedReview", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Z)Lcom/larus/canvas/service/bean/LocalFileImage;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalFileImage implements IImageInfo {
    public static final Parcelable.Creator<LocalFileImage> CREATOR = null;
    public final String a;
    public final String b;
    public final Integer c;
    public final Integer d;
    public final boolean e;

    public static final class a implements Parcelable.Creator<LocalFileImage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LocalFileImage createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            String r2 = r8.readString();
            String r3 = r8.readString();
            if (r8.readInt() != 0) goto L5;
            Integer r5 = null;
        L7:
            if (r8.readInt() != 0) goto L9;
            Integer r6 = null;
        L11:
            if (r8.readInt() == 0) goto L13;
            boolean r9 = true;
        L15:
            return new LocalFileImage(r2, r3, r5, r6, r9);
        L13:
            r9 = false;
            goto L15
        L9:
            r6 = Integer.valueOf(r8.readInt());
            goto L11
        L5:
            r5 = Integer.valueOf(r8.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final LocalFileImage[] newArray(int r1) {
            return new LocalFileImage[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LocalFileImage) == true) goto L8;
        return false;
    L8:
        LocalFileImage r6 = (LocalFileImage) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.d;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        int r9 = (r7 + r2) * 31;
        if (this.e == false) goto L17;
        int r10 = 1231;
    L19:
        return r9 + r10;
    L17:
        r10 = 1237;
        goto L19
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "LocalFileImage(localFilePath=" + this.a + ", uri=" + this.b + ", width=" + this.c + ", height=" + this.d + ", needReview=" + this.e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.a);
        r3.writeString(this.b);
        Integer r5 = this.c;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Integer r6 = this.d;
        if (r6 != null) goto L9;
        r3.writeInt(0);
    L10:
        r3.writeInt(this.e ? 1 : 0);
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.intValue());
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
        goto L6
    }

    public LocalFileImage(String r2, String r3, Integer r4, Integer r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "localFilePath");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
