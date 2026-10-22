package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/config/zj1;", "", "", "isOnWeakNet", "Z", "c", "()Z", "setOnWeakNet", "(Z)V", "", "", "waitTimesForWeakNet", "Ljava/util/List;", "b", "()Ljava/util/List;", "setWaitTimesForWeakNet", "(Ljava/util/List;)V", "splitRequestSkip", "a", "setSplitRequestSkip", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class zj1 {

    @SerializedName("is_on_weak_net")
    private boolean isOnWeakNet;

    @SerializedName("split_request_skip")
    private boolean splitRequestSkip;

    @SerializedName("wait_times_for_weak_net")
    private List<Long> waitTimesForWeakNet;

    public zj1() {
        this.waitTimesForWeakNet = CollectionsKt.mutableListOf(new Long[]{300L, 1500L, 3000L});
    }

    public final boolean a() {
        return this.splitRequestSkip;
    }

    public final List<Long> b() {
        return this.waitTimesForWeakNet;
    }

    public final boolean c() {
        return this.isOnWeakNet;
    }
}
