package com.larus.bmhome.music.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fR \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/music/protocol/BigMusicLyrics;", "Landroid/os/Parcelable;", "lyricsList", "", "", "<init>", "(Ljava/util/List;)V", "getLyricsList", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BigMusicLyrics implements Parcelable {
    public static final Parcelable.Creator<BigMusicLyrics> CREATOR = null;

    @SerializedName("lyrics_list")
    private final List<String> lyricsList;

    public static final class a implements Parcelable.Creator<BigMusicLyrics> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BigMusicLyrics createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new BigMusicLyrics(r2.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final BigMusicLyrics[] newArray(int r1) {
            return new BigMusicLyrics[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BigMusicLyrics() {
        this(null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof BigMusicLyrics) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.lyricsList, ((BigMusicLyrics) r4).lyricsList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<String> r0 = this.lyricsList;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "BigMusicLyrics(lyricsList=" + this.lyricsList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeStringList(this.lyricsList);
    }

    public final List<String> a() {
        return this.lyricsList;
    }

    public BigMusicLyrics(List<String> r1) {
        this.lyricsList = r1;
    }
}
