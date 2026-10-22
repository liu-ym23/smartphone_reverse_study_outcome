package com.bytedance.android.ec.core.address;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/core/address/i0;", "", "", "curType", "I", "a", "()I", "preType", "b", "strategy", "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i0 {

    @SerializedName("cur_type")
    private final int curType;

    @SerializedName("pre_type")
    private final int preType;

    @SerializedName("strategy")
    private final int strategy;

    public i0() {
        this.curType = 0;
        this.preType = 0;
        this.strategy = 0;
    }

    public final int a() {
        return this.curType;
    }

    public final int b() {
        return this.preType;
    }

    public final int c() {
        return this.strategy;
    }
}
