package com.bytedance.android.live.profit.lottery;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001a\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\nR\u001a\u0010\u0017\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\u001a\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\u001d\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010 \u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u000fR\u001a\u0010#\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b!\u0010\u0004R\u001a\u0010&\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0006\u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/h;", "Lvh7/c;", "", "getConditionId", "()J", "getConditionId$annotations", "()V", "conditionId", "", "getType", "()I", "getType$annotations", "type", "", "getContent", "()Ljava/lang/String;", "getContent$annotations", "content", "getStatus", "getStatus$annotations", "status", "getDescription", "getDescription$annotations", "description", "getGiftId", "getGiftId$annotations", "giftId", "getGiftCount", "getGiftCount$annotations", "giftCount", "getGiftName", "getGiftName$annotations", "giftName", "getNeedDiamondCount", "getNeedDiamondCount$annotations", "needDiamondCount", "getMinFansLevel", "getMinFansLevel$annotations", "minFansLevel", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h extends vh7.c<h> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "condition_id")
    long getConditionId();

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "description")
    String getDescription();

    @FieldName(name = "gift_count")
    long getGiftCount();

    @FieldName(name = "gift_id")
    long getGiftId();

    @FieldName(name = "gift_name")
    String getGiftName();

    @FieldName(name = "min_fans_level")
    long getMinFansLevel();

    @FieldName(name = "need_diamond_count")
    long getNeedDiamondCount();

    @FieldName(name = "status")
    int getStatus();

    @FieldName(name = "type")
    int getType();
}
