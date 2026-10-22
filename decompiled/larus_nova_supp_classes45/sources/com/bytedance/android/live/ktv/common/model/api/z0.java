package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.ig;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/z0;", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "song", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "b", "()Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "setSong", "(Lcom/bytedance/android/livesdk/message/model/KtvMusic;)V", "Lcom/bytedance/android/livesdk/message/model/ig;", "multiChorusSongItem", "Lcom/bytedance/android/livesdk/message/model/ig;", "a", "()Lcom/bytedance/android/livesdk/message/model/ig;", "setMultiChorusSongItem", "(Lcom/bytedance/android/livesdk/message/model/ig;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class z0 implements vh7.h {
    public final HashMap<String, py.k> a;

    @SerializedName("multi_chorus_song_item")
    protected ig multiChorusSongItem;

    @SerializedName("song")
    protected KtvMusic song;

    public z0() {
        this.a = new HashMap();
    }

    public final ig a() {
        return this.multiChorusSongItem;
    }

    public final KtvMusic b() {
        return this.song;
    }

    public z0(am3.g r5) {
        this.a = new HashMap();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.song = new KtvMusic(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.multiChorusSongItem = new ig(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }
}
