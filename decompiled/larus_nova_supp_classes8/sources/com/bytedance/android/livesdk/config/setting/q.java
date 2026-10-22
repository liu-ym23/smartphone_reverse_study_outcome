package com.bytedance.android.livesdk.config.setting;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/config/setting/q;", "", "", "heartbeatKeyCountLimit", "I", "a", "()I", "setHeartbeatKeyCountLimit", "(I)V", "", "", "heartbeatKeyWhiteList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setHeartbeatKeyWhiteList", "(Ljava/util/List;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("hb_key_count_limit")
    private int heartbeatKeyCountLimit;

    @SerializedName("hb_key_whitelist")
    private List<String> heartbeatKeyWhiteList;

    public q() {
        this.heartbeatKeyCountLimit = 20;
        this.heartbeatKeyWhiteList = new ArrayList();
    }

    public final int a() {
        return this.heartbeatKeyCountLimit;
    }

    public final List<String> b() {
        return this.heartbeatKeyWhiteList;
    }
}
