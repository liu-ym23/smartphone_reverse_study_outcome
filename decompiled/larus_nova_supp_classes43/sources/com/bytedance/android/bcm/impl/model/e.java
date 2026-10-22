package com.bytedance.android.bcm.impl.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/bcm/impl/model/e;", "", "", "btmLevel", "Ljava/lang/String;", "getBtmLevel", "()Ljava/lang/String;", "btmFullCode", "getBtmFullCode", "setBtmFullCode", "(Ljava/lang/String;)V", "btmName", "getBtmName", "", "Lcom/bytedance/android/bcm/impl/model/f;", "btmSummaryList", "Ljava/util/List;", "getBtmSummaryList", "()Ljava/util/List;", "extraRules", "getExtraRules", "<init>", "()V", "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class e {

    @SerializedName("btm_full_code")
    private String btmFullCode;

    @SerializedName("btm_level")
    private final String btmLevel;

    @SerializedName("btm_name")
    private final String btmName;

    @SerializedName("bcm_summary_list")
    private final List<f> btmSummaryList;

    @SerializedName("extra_rules")
    private final String extraRules;

    public e() {
    }
}
