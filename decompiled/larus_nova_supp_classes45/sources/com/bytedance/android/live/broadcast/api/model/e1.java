package com.bytedance.android.live.broadcast.api.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/e1;", "", "Lcom/bytedance/android/live/broadcast/api/model/d1;", "replaySetting", "Lcom/bytedance/android/live/broadcast/api/model/d1;", "a", "()Lcom/bytedance/android/live/broadcast/api/model/d1;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e1 {

    @SerializedName("replay_setting")
    private final d1 replaySetting;

    public e1() {
    }

    public final d1 a() {
        return this.replaySetting;
    }
}
