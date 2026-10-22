package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\t\u0010\u0004\"\u0004\b\n\u0010\u0006R$\u0010\u0012\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0016\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R$\u0010\u001a\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0019\u0010\b\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R$\u0010!\u001a\u0004\u0018\u00010\u001b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/o0;", "Lvh7/c;", "", "isHasExpired", "()Z", "setHasExpired", "(Z)V", "isHasExpired$annotations", "()V", "isMutualFollow", "setMutualFollow", "isMutualFollow$annotations", "", "getApplyReason", "()Ljava/lang/String;", "setApplyReason", "(Ljava/lang/String;)V", "getApplyReason$annotations", "applyReason", "getLast7DaysGiftCountTxt", "setLast7DaysGiftCountTxt", "getLast7DaysGiftCountTxt$annotations", "last7DaysGiftCountTxt", "getFuzzyFanTicketStr", "setFuzzyFanTicketStr", "getFuzzyFanTicketStr$annotations", "fuzzyFanTicketStr", "", "getApplyTimeSec", "()Ljava/lang/Long;", "setApplyTimeSec", "(Ljava/lang/Long;)V", "getApplyTimeSec$annotations", "applyTimeSec", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o0 extends vh7.c<o0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "application_reason")
    String getApplyReason();

    @FieldName(name = "apply_time_sec")
    Long getApplyTimeSec();

    @FieldName(name = "fuzzy_fan_ticket_str")
    String getFuzzyFanTicketStr();

    @FieldName(name = "last_7_days_gift_count_text")
    String getLast7DaysGiftCountTxt();

    @FieldName(name = "application_has_expired")
    boolean isHasExpired();

    @FieldName(name = "is_mutual_following")
    boolean isMutualFollow();

    @FieldName(name = "application_reason#setter")
    void setApplyReason(String r1);

    @FieldName(name = "apply_time_sec#setter")
    void setApplyTimeSec(Long r1);

    @FieldName(name = "fuzzy_fan_ticket_str#setter")
    void setFuzzyFanTicketStr(String r1);

    @FieldName(name = "application_has_expired#setter")
    void setHasExpired(boolean r1);

    @FieldName(name = "last_7_days_gift_count_text#setter")
    void setLast7DaysGiftCountTxt(String r1);

    @FieldName(name = "is_mutual_following#setter")
    void setMutualFollow(boolean r1);
}
