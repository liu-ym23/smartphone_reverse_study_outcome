package com.bytedance.android.ec.core.address;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/core/address/a0;", "", "", "btm", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "desc", "getDesc", "", "type", "I", "getType", "()I", "", "nextBtmList", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "isMainPage", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    @SerializedName("btm")
    private final String btm;

    @SerializedName("desc")
    private final String desc;

    @SerializedName("is_main")
    private final Boolean isMainPage;

    @SerializedName("next_btm_list")
    private final List<a0> nextBtmList;

    @SerializedName("type")
    private final int type;

    public final String toString() {
        return "btm=" + this.btm + " desc=" + this.desc + " type=" + this.type + " is_main=" + this.isMainPage;
    }

    public final String a() {
        return this.btm;
    }

    public final List<a0> b() {
        return this.nextBtmList;
    }

    public final Boolean c() {
        return this.isMainPage;
    }

    public final int getType() {
        return this.type;
    }
}
