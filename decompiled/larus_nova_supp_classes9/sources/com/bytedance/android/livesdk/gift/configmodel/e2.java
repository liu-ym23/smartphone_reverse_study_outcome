package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/e2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "b", "()Z", "setEnable", "(Z)V", BuildConfig.FLAVOR, "count", "I", "a", "()I", "setCount", "(I)V", BuildConfig.FLAVOR, "interval", "J", "getInterval", "()J", "setInterval", "(J)V", "sortInterval", "getSortInterval", "setSortInterval", "enablePk", "getEnablePk", "setEnablePk", BuildConfig.FLAVOR, "supportPageType", "Ljava/util/List;", "c", "()Ljava/util/List;", "setSupportPageType", "(Ljava/util/List;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e2 {

    @SerializedName("count")
    private int count;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_pk")
    private boolean enablePk;

    @SerializedName("interval")
    private long interval;

    @SerializedName("predict_interval")
    private long sortInterval;

    @SerializedName("support_gift_list_page_type")
    private List<Integer> supportPageType;

    public e2() {
        this.count = 1200;
        this.interval = 3000;
        this.sortInterval = 60000;
        this.supportPageType = CollectionsKt.mutableListOf(new Integer[]{1, 15});
    }

    public final int a() {
        return this.count;
    }

    public final boolean b() {
        return this.enable;
    }

    public final List<Integer> c() {
        return this.supportPageType;
    }
}
