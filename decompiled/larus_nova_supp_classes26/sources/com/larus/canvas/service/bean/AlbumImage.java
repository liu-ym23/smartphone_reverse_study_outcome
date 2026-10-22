package com.larus.canvas.service.bean;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larus/canvas/service/bean/AlbumImage;", "Lcom/larus/canvas/service/bean/IImageInfo;", "uri", "Landroid/net/Uri;", "needReview", "", "isAiCreation", "<init>", "(Landroid/net/Uri;ZZ)V", "getUri", "()Landroid/net/Uri;", "getNeedReview", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumImage implements IImageInfo {
    public static final Parcelable.Creator<AlbumImage> CREATOR = null;
    public final Uri a;
    public final boolean b;
    public final boolean c;

    public static final class a implements Parcelable.Creator<AlbumImage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AlbumImage createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            Uri r1 = (Uri) r6.readParcelable(AlbumImage.class.getClassLoader());
            boolean r3 = false;
            if (r6.readInt() == 0) goto L5;
            boolean r2 = true;
        L7:
            if (r6.readInt() == 0) goto L10;
            r3 = true;
        L10:
            return new AlbumImage(r1, r2, r3);
        L5:
            r2 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AlbumImage[] newArray(int r1) {
            return new AlbumImage[r1];
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
        if ((r5 instanceof AlbumImage) == true) goto L8;
        return false;
    L8:
        AlbumImage r6 = (AlbumImage) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "AlbumImage(uri=" + this.a + ", needReview=" + this.b + ", isAiCreation=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeParcelable(this.a, r3);
        r2.writeInt(this.b ? 1 : 0);
        r2.writeInt(this.c ? 1 : 0);
    }

    public /* synthetic */ AlbumImage(Uri r3, boolean r4, int r5) {
        if ((r5 & 2) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        this(r3, r0, r4);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public AlbumImage(Uri r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
