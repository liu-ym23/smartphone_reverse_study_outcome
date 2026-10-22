package com.bytedance.android.livesdk.ktvapi.model;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/SeiLyricsInfo;", BuildConfig.FLAVOR, "row", BuildConfig.FLAVOR, "lyrics", BuildConfig.FLAVOR, "(ILjava/lang/String;)V", "getLyrics", "()Ljava/lang/String;", "setLyrics", "(Ljava/lang/String;)V", "getRow", "()I", "setRow", "(I)V", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SeiLyricsInfo {

    @SerializedName("lyrics")
    private String lyrics;

    @SerializedName("row")
    private int row;

    public SeiLyricsInfo() {
        String r0 = null;
        int r2 = 0;
        this(r2, r0, 3, r0);
    }

    public static /* synthetic */ SeiLyricsInfo copy$default(SeiLyricsInfo r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.row;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.lyrics;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.row;
    }

    public final String component2() {
        return this.lyrics;
    }

    public final SeiLyricsInfo copy(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "lyrics");
        return new SeiLyricsInfo(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SeiLyricsInfo) == false) goto L10;
        SeiLyricsInfo r4 = (SeiLyricsInfo) r3;
        if (this.row == r4.row) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lyrics, r4.lyrics) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r0 = this.row * 31;
        String r1 = this.lyrics;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public String toString() {
        return "SeiLyricsInfo(row=" + this.row + ", lyrics=" + this.lyrics + ")";
    }

    public final String getLyrics() {
        return this.lyrics;
    }

    public final int getRow() {
        return this.row;
    }

    public final void setLyrics(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.lyrics = r2;
    }

    public final void setRow(int r1) {
        this.row = r1;
    }

    public SeiLyricsInfo(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "lyrics");
        this.row = r2;
        this.lyrics = r3;
    }

    public /* synthetic */ SeiLyricsInfo(int r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = BuildConfig.FLAVOR;
    L8:
        this(r1, r2);
    }
}
