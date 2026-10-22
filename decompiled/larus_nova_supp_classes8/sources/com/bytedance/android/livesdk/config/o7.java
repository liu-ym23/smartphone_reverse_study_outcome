package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/config/o7;", "", "", "numberNotScale", "Z", "a", "()Z", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o7 {

    @SerializedName("number_not_scale")
    private final boolean numberNotScale;

    public o7() {
        this(0);
    }

    public final boolean a() {
        return this.numberNotScale;
    }

    public o7(int r1) {
        this.numberNotScale = false;
    }
}
