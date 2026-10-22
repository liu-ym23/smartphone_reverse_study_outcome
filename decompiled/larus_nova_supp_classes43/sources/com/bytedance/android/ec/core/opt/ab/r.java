package com.bytedance.android.ec.core.opt.ab;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/core/opt/ab/r;", "", "", "timesWithoutAction", "Ljava/lang/Integer;", "getTimesWithoutAction", "()Ljava/lang/Integer;", "setTimesWithoutAction", "(Ljava/lang/Integer;)V", "daysWithoutAction", "getDaysWithoutAction", "setDaysWithoutAction", "hideListForDays", "getHideListForDays", "setHideListForDays", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("days_without_action")
    private Integer daysWithoutAction;

    @SerializedName("hide_list_for_days")
    private Integer hideListForDays;

    @SerializedName("times_without_action")
    private Integer timesWithoutAction;

    public r() {
    }
}
