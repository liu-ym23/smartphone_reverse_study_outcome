package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/d0;", "", "", "curSongHot", "J", "a", "()J", "curSongLevel", "b", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "curSong", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "getCurSong", "()Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d0 implements vh7.h {

    @SerializedName("cur_song")
    protected KtvMusic curSong;

    @SerializedName("cur_song_hot")
    protected long curSongHot;

    @SerializedName("cur_song_hot_level")
    protected long curSongLevel;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d0) == false) goto L12;
        d0 r7 = (d0) r6;
        if (this.curSongHot == r7.curSongHot) goto L8;
        return false;
    L8:
        if (this.curSongLevel == r7.curSongLevel) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.curSong, r7.curSong) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r0 = this.curSongHot;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.curSongLevel;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        KtvMusic r4 = this.curSong;
        if (r4 == null) goto L5;
        int r5 = r4.hashCode();
    L7:
        return r2 + r5;
    L5:
        r5 = 0;
        goto L7
    }

    public final String toString() {
        return "KtvUserSongContributorRankResponse(curSongHot=" + this.curSongHot + ", curSongLevel=" + this.curSongLevel + ", curSong=" + this.curSong + ")";
    }

    public d0() {
        this.curSongHot = 0;
        this.curSongLevel = 0;
        this.curSong = null;
    }

    public final long a() {
        return this.curSongHot;
    }

    public final long b() {
        return this.curSongLevel;
    }

    public d0(am3.g r6) {
        long r0 = r6.c();
        int r2 = 0;
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 4) goto L8;
        this.curSongHot = r6.j();
        r2 = r2 | 1;
        goto L3
    L8:
        if (r3 != 5) goto L10;
        this.curSongLevel = r6.j();
        r2 = r2 | 2;
        goto L3
    L10:
        if (r3 != 6) goto L11;
        this.curSong = new KtvMusic(r6);
        goto L3
    L11:
        am3.h.e(r6);
        goto L3
    L15:
        r6.d(r0);
        if ((r2 & 1) != 0) goto L19;
        this.curSongHot = 0;
    L19:
        if ((r2 & 2) != 0) goto L22;
        this.curSongLevel = 0;
    L22:
        if (this.curSong != null) goto L37;
        this.curSong = null;
        return;
    }
}
