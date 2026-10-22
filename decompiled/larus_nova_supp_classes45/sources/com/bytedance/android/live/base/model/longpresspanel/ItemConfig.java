package com.bytedance.android.live.base.model.longpresspanel;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/longpresspanel/ItemConfig;", "", "()V", "identity", "", "getIdentity", "()Ljava/lang/String;", "setIdentity", "(Ljava/lang/String;)V", "priority", "", "getPriority", "()Ljava/lang/Integer;", "setPriority", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "type", "getType", "setType", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ItemConfig {

    @SerializedName("identity")
    private String identity;

    @SerializedName("priority")
    private Integer priority;

    @SerializedName("item_type")
    private Integer type;

    public ItemConfig() {
        this.identity = "";
        this.priority = 0;
        this.type = 0;
    }

    public final String getIdentity() {
        return this.identity;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setIdentity(String r1) {
        this.identity = r1;
    }

    public final void setPriority(Integer r1) {
        this.priority = r1;
    }

    public final void setType(Integer r1) {
        this.type = r1;
    }
}
