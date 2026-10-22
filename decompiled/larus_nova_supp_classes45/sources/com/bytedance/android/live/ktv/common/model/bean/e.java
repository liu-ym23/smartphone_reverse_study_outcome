package com.bytedance.android.live.ktv.common.model.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/bean/e;", "", "", "songId", "J", "getSongId", "()J", "setSongId", "(J)V", "", "songName", "Ljava/lang/String;", "getSongName", "()Ljava/lang/String;", "setSongName", "(Ljava/lang/String;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e implements vh7.h {

    @SerializedName("song_id")
    protected long songId;

    @SerializedName("song_name")
    protected String songName;

    public e() {
        this.songName = "";
    }

    public e(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.songId = r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.songName = am3.h.c(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        if (this.songName != null) goto L25;
        this.songName = "";
        return;
    }
}
