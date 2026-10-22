package com.larus.platform.model.album;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003JS\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0006\u0010&\u001a\u00020\u0005J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\u000bHÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001d¨\u00061"}, d2 = {"Lcom/larus/platform/model/album/AlbumSelectItem;", "Landroid/os/Parcelable;", "uri", "Landroid/net/Uri;", "width", "", "height", "duration", "", "size", "format", "", "isOriginalImageChecked", "", "<init>", "(Landroid/net/Uri;IIJJLjava/lang/String;Z)V", "getUri", "()Landroid/net/Uri;", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "getDuration", "()J", "getSize", "getFormat", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AlbumSelectItem implements Parcelable {
    public static final Parcelable.Creator<AlbumSelectItem> CREATOR = null;
    public final Uri a;
    public final int b;
    public final int c;
    public final long d;
    public final long e;
    public final String f;
    public final boolean g;

    public static final class a implements Parcelable.Creator<AlbumSelectItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AlbumSelectItem createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "parcel");
            Uri r2 = (Uri) r12.readParcelable(AlbumSelectItem.class.getClassLoader());
            int r3 = r12.readInt();
            int r4 = r12.readInt();
            long r5 = r12.readLong();
            long r7 = r12.readLong();
            String r9 = r12.readString();
            if (r12.readInt() == 0) goto L5;
            boolean r10 = true;
        L7:
            return new AlbumSelectItem(r2, r3, r4, r5, r7, r9, r10);
        L5:
            r10 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AlbumSelectItem[] newArray(int r1) {
            return new AlbumSelectItem[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public AlbumSelectItem() {
        this(null, 0, 0, 0, 0, null, 127);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AlbumSelectItem) == true) goto L8;
        return false;
    L8:
        AlbumSelectItem r9 = (AlbumSelectItem) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Uri r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.b) * 31) + this.c) * 31;
        long r4 = this.d;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.e;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        String r8 = this.f;
        if (r8 == null) goto L10;
        r1 = r8.hashCode();
    L10:
        int r9 = (r7 + r1) * 31;
        if (this.g == false) goto L13;
        int r10 = 1231;
    L15:
        return r9 + r10;
    L13:
        r10 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "AlbumSelectItem(uri=" + this.a + ", width=" + this.b + ", height=" + this.c + ", duration=" + this.d + ", size=" + this.e + ", format=" + this.f + ", isOriginalImageChecked=" + this.g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeParcelable(this.a, r4);
        r3.writeInt(this.b);
        r3.writeInt(this.c);
        r3.writeLong(this.d);
        r3.writeLong(this.e);
        r3.writeString(this.f);
        r3.writeInt(this.g ? 1 : 0);
    }

    public static AlbumSelectItem a(AlbumSelectItem r10, boolean r11) {
        Uri r1 = r10.a;
        int r2 = r10.b;
        int r3 = r10.c;
        long r4 = r10.d;
        long r6 = r10.e;
        String r8 = r10.f;
        r10.getClass();
        return new AlbumSelectItem(r1, r2, r3, r4, r6, r8, r11);
    }

    public /* synthetic */ AlbumSelectItem(Uri r13, int r14, int r15, long r16, long r18, String r20, int r21) {
        String r1 = null;
        if ((r21 & 1) == 0) goto L5;
        Uri r3 = null;
    L7:
        if ((r21 & 2) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r21 & 4) == 0) goto L13;
        int r5 = 0;
    L15:
        if ((r21 & 8) == 0) goto L17;
        long r8 = 0;
    L19:
        if ((r21 & 16) == 0) goto L21;
        long r10 = 0;
    L23:
        if ((r21 & 32) != 0) goto L26;
        r1 = r20;
    L26:
        this(r3, r4, r5, r8, r10, r1, false);
        return;
    L21:
        r10 = r18;
        goto L23
    L17:
        r8 = r16;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }

    public AlbumSelectItem(Uri r1, int r2, int r3, long r4, long r6, String r8, boolean r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r8;
        this.g = r9;
    }
}
