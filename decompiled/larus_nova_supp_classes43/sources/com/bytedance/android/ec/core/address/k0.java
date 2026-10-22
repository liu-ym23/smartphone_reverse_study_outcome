package com.bytedance.android.ec.core.address;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/core/address/k0;", "", "", "disableRequestTag", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k0 {

    @SerializedName("disable_request_tag")
    private final Boolean disableRequestTag;

    public k0() {
        this.disableRequestTag = Boolean.FALSE;
    }

    public final Boolean a() {
        return this.disableRequestTag;
    }
}
