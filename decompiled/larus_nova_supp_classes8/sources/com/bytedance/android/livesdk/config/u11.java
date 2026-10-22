package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/config/u11;", "", "", "closeRetryEnable", "Z", "b", "()Z", "setCloseRetryEnable", "(Z)V", "", "closeRetryTimes", "I", "c", "()I", "setCloseRetryTimes", "(I)V", "", "closeErrorCode", "Ljava/util/List;", "a", "()Ljava/util/List;", "setCloseErrorCode", "(Ljava/util/List;)V", "blockContinueClick", "getBlockContinueClick", "setBlockContinueClick", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u11 {

    @SerializedName("continue_click_block")
    private boolean blockContinueClick;

    @SerializedName("close_retry_code")
    private List<Integer> closeErrorCode;

    @SerializedName("close_retry_enable")
    private boolean closeRetryEnable;

    @SerializedName("close_retry_times")
    private int closeRetryTimes;

    public u11() {
        this.closeRetryTimes = 1;
        this.closeErrorCode = CollectionsKt.mutableListOf(new Integer[]{-106, 500, 501, 502, 503, -998, -997, -999});
    }

    public final List<Integer> a() {
        return this.closeErrorCode;
    }

    public final boolean b() {
        return this.closeRetryEnable;
    }

    public final int c() {
        return this.closeRetryTimes;
    }
}
