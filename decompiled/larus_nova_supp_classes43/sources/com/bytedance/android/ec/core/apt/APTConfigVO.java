package com.bytedance.android.ec.core.apt;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/core/apt/APTConfigVO;", "Ljava/io/Serializable;", "()V", "ecomAptTestcase", "", "getEcomAptTestcase", "()Ljava/lang/String;", "eventKeys", "", "getEventKeys", "()Ljava/util/List;", "setEventKeys", "(Ljava/util/List;)V", "maxCount", "", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "switcher", "getSwitcher", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class APTConfigVO implements Serializable {

    @SerializedName("ecom_apt_testcase")
    private final String ecomAptTestcase;

    @SerializedName("apt_event_keys")
    private List<String> eventKeys;

    @SerializedName("apt_max_store_count")
    private Integer maxCount;

    @SerializedName("switcher")
    private final Integer switcher;

    public APTConfigVO() {
        this.eventKeys = CollectionsKt.emptyList();
        this.maxCount = 10;
        this.ecomAptTestcase = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_apt_testcase/apt_checker.js";
        this.switcher = 0;
    }

    public final String getEcomAptTestcase() {
        return this.ecomAptTestcase;
    }

    public final List<String> getEventKeys() {
        return this.eventKeys;
    }

    public final Integer getMaxCount() {
        return this.maxCount;
    }

    public final Integer getSwitcher() {
        return this.switcher;
    }

    public final void setEventKeys(List<String> r1) {
        this.eventKeys = r1;
    }

    public final void setMaxCount(Integer r1) {
        this.maxCount = r1;
    }
}
