package com.bytedance.android.live.ktv.common.model.bean;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/bean/i;", "", "", "Lcom/bytedance/android/live/ktv/common/model/bean/e;", "songList", "Ljava/util/List;", "getSongList", "()Ljava/util/List;", "setSongList", "(Ljava/util/List;)V", "", "totalCount", "J", "getTotalCount", "()J", "setTotalCount", "(J)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i implements vh7.h {

    @SerializedName("songs")
    protected List<e> songList;

    @SerializedName("total_count")
    protected long totalCount;

    public i() {
        this.songList = new ArrayList();
    }

    public i(am3.g r5) {
        this.songList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.songList.add(new e(r5));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.totalCount = r5.j();
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        if (this.songList.isEmpty() == false) goto L25;
        this.songList = new ArrayList();
        return;
    }
}
