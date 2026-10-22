package com.larus.photopicker.v2.impl.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.platform.model.album.CreationReferenceAlbumConfig;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J?\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u0005J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2 = {"Lcom/larus/photopicker/v2/impl/model/MediaNonUISettings;", "Landroid/os/Parcelable;", "enableSeparateMediaSelection", "", "maxSelectVideoCount", "", "creationReferenceConfig", "Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;", "maxVideoDuration", "", "clickFrom", "", "<init>", "(ZILcom/larus/platform/model/album/CreationReferenceAlbumConfig;JLjava/lang/String;)V", "getEnableSeparateMediaSelection", "()Z", "getMaxSelectVideoCount", "()I", "getCreationReferenceConfig", "()Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;", "getMaxVideoDuration", "()J", "getClickFrom", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaNonUISettings implements Parcelable {
    public static final Parcelable.Creator<MediaNonUISettings> CREATOR = null;
    public static final MediaNonUISettings f = null;
    public final boolean a;
    public final int b;
    public final CreationReferenceAlbumConfig c;
    public final long d;
    public final String e;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<MediaNonUISettings> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final MediaNonUISettings createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            if (r9.readInt() == 0) goto L5;
            boolean r2 = true;
        L7:
            return new MediaNonUISettings(r2, r9.readInt(), (CreationReferenceAlbumConfig) r9.readSerializable(), r9.readLong(), r9.readString());
        L5:
            r2 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final MediaNonUISettings[] newArray(int r1) {
            return new MediaNonUISettings[r1];
        }
    }

    public MediaNonUISettings() {
        long r2 = 0;
        this(r2, null, 31);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MediaNonUISettings) == true) goto L8;
        return false;
    L8:
        MediaNonUISettings r9 = (MediaNonUISettings) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.b) * 31;
        CreationReferenceAlbumConfig r2 = this.c;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        long r5 = this.d;
        int r6 = (((r1 + r4) * 31) + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        String r7 = this.e;
        if (r7 == null) goto L15;
        r3 = r7.hashCode();
    L15:
        return r6 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MediaNonUISettings(enableSeparateMediaSelection=" + this.a + ", maxSelectVideoCount=" + this.b + ", creationReferenceConfig=" + this.c + ", maxVideoDuration=" + this.d + ", clickFrom=" + this.e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeInt(this.a ? 1 : 0);
        r3.writeInt(this.b);
        r3.writeSerializable(this.c);
        r3.writeLong(this.d);
        r3.writeString(this.e);
    }

    static {
        CREATOR = new b();
        long r3 = 0;
        f = new MediaNonUISettings(r3, null, 31);
    }

    public /* synthetic */ MediaNonUISettings(long r8, String r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        int r2 = -1;
    L7:
        if ((r11 & 8) == 0) goto L9;
        r8 = 0;
    L9:
        long r4 = r8;
        if ((r11 & 16) == 0) goto L12;
        r10 = null;
    L12:
        this(false, r2, null, r4, r10);
        return;
    L5:
        r2 = 0;
        goto L7
    }

    public MediaNonUISettings(boolean r1, int r2, CreationReferenceAlbumConfig r3, long r4, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }
}
