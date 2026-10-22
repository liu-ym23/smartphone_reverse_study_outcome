package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b \bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0007\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010%\u001a\u00020!8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0007\u001a\u0004\b\"\u0010#R\u001a\u0010(\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0007\u001a\u0004\b&\u0010\u0010R\u001a\u0010+\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0007\u001a\u0004\b)\u0010\u0010R\u001a\u0010.\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0007\u001a\u0004\b,\u0010\u000bR\u001a\u00101\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0007\u001a\u0004\b/\u0010\u000bR\u001a\u00104\u001a\u00020!8&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0007\u001a\u0004\b2\u0010#R\u001a\u00107\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b6\u0010\u0007\u001a\u0004\b5\u0010\u000bR\u001a\u0010:\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0007\u001a\u0004\b8\u0010\u0010R\u001a\u0010=\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0007\u001a\u0004\b;\u0010\u000bR\u001a\u0010@\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0007\u001a\u0004\b>\u0010\u0010¨\u0006A"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/m0;", "Lvh7/c;", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/n0;", "getMWaitingUserInfo", "()Ljava/util/List;", "getMWaitingUserInfo$annotations", "()V", "mWaitingUserInfo", "", "getHasMore", "()Z", "getHasMore$annotations", "hasMore", "", "getTotalCount", "()J", "getTotalCount$annotations", "totalCount", "", "getNextCursor", "()Ljava/lang/String;", "getNextCursor$annotations", "nextCursor", "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText$annotations", "displayText", "getWaitingUser", "()Lcom/bytedance/android/live/liveinteract/plantform/model/n0;", "getWaitingUser$annotations", "waitingUser", "", "getSortStrategy", "()I", "getSortStrategy$annotations", "sortStrategy", "getNow", "getNow$annotations", "now", "getAddPriceAudienceNum", "getAddPriceAudienceNum$annotations", "addPriceAudienceNum", "getShowPaidLinkGuide", "getShowPaidLinkGuide$annotations", "showPaidLinkGuide", "getHasPreApply", "getHasPreApply$annotations", "hasPreApply", "getWaitingListType", "getWaitingListType$annotations", "waitingListType", "getShowPaidListTab", "getShowPaidListTab$annotations", "showPaidListTab", "getPaidListTotalCount", "getPaidListTotalCount$annotations", "paidListTotalCount", "getOpenPaidQueue", "getOpenPaidQueue$annotations", "openPaidQueue", "getNormalListTotalCount", "getNormalListTotalCount$annotations", "normalListTotalCount", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m0 extends vh7.c<m0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "add_price_audience_num")
    long getAddPriceAudienceNum();

    @FieldName(name = "display_text")
    a5 getDisplayText();

    @FieldName(name = "has_more")
    boolean getHasMore();

    @FieldName(name = "has_prepare_apply")
    boolean getHasPreApply();

    @FieldName(name = "user")
    List<n0> getMWaitingUserInfo();

    @FieldName(name = "next_cursor")
    String getNextCursor();

    @FieldName(name = "normal_list_total_count")
    long getNormalListTotalCount();

    @FieldName(name = "now")
    long getNow();

    @FieldName(name = "open_paid_queue")
    boolean getOpenPaidQueue();

    @FieldName(name = "paid_list_total_count")
    long getPaidListTotalCount();

    @FieldName(name = "show_paid_linkmic_guide")
    boolean getShowPaidLinkGuide();

    @FieldName(name = "show_paid_list_tab")
    boolean getShowPaidListTab();

    @FieldName(name = "sort_strategy")
    int getSortStrategy();

    @FieldName(name = "total_count")
    long getTotalCount();

    @FieldName(name = "type")
    int getWaitingListType();

    @FieldName(name = "waiting_user")
    n0 getWaitingUser();
}
