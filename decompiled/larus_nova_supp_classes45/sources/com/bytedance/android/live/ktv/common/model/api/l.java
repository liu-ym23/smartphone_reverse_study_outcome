package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/l;", "", "", "hasMore", "Z", "a", "()Z", "setHasMore", "(Z)V", "", "Lcom/bytedance/android/live/ktv/common/model/api/w0;", "sungSongInfos", "Ljava/util/List;", "c", "()Ljava/util/List;", "setSungSongInfos", "(Ljava/util/List;)V", "", "sungSongCount", "J", "b", "()J", "setSungSongCount", "(J)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class l implements vh7.h {

    @SerializedName("has_more")
    protected boolean hasMore;

    @SerializedName("sung_song_count")
    protected long sungSongCount;

    @SerializedName("list_info")
    protected List<w0> sungSongInfos;

    public l() {
    }

    public final boolean a() {
        return this.hasMore;
    }

    public final long b() {
        return this.sungSongCount;
    }

    public final List<w0> c() {
        return this.sungSongInfos;
    }

    public l(am3.g r5) {
        this.sungSongInfos = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.sungSongInfos.add(new w0(r5));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.hasMore = am3.h.a(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.sungSongCount = r5.j();
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }
}
