package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u000bR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010#\u001a\u0004\u0018\u00010\u001f8&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b \u0010!R \u0010'\u001a\b\u0012\u0004\u0012\u00020$0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b%\u0010\u000bR\u001c\u0010,\u001a\u0004\u0018\u00010(8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0006\u001a\u0004\b)\u0010*R\u001a\u0010/\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0006\u001a\u0004\b-\u0010\u0004R&\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014008&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0006\u001a\u0004\b1\u00102R\u001c\u00109\u001a\u0004\u0018\u0001058&X§\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0006\u001a\u0004\b6\u00107R\u001c\u0010>\u001a\u0004\u0018\u00010:8&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0006\u001a\u0004\b;\u0010<R\u001c\u0010C\u001a\u0004\u0018\u00010?8&X§\u0004¢\u0006\f\u0012\u0004\bB\u0010\u0006\u001a\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/u;", "Lvh7/c;", BuildConfig.FLAVOR, "getFastGiftId", "()J", "getFastGiftId$annotations", "()V", "fastGiftId", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/platform/core/model/h;", "getGroupCountInfo", "()Ljava/util/List;", "getGroupCountInfo$annotations", "groupCountInfo", "getFansClubIds", "getFansClubIds$annotations", "fansClubIds", "getNewGiftId", "getNewGiftId$annotations", "newGiftId", BuildConfig.FLAVOR, "getNewGiftTip", "()Ljava/lang/String;", "getNewGiftTip$annotations", "newGiftTip", "getHonorLevelGiftIds", "getHonorLevelGiftIds$annotations", "honorLevelGiftIds", "getNobleGiftIds", "getNobleGiftIds$annotations", "nobleGiftIds", "Lpy/k;", "getGiftEntranceIcon", "()Lpy/k;", "getGiftEntranceIcon$annotations", "giftEntranceIcon", "Lcom/bytedance/android/livesdk/gift/platform/core/model/e;", "getGiftComboInfoList", "getGiftComboInfoList$annotations", "giftComboInfoList", "Lcom/bytedance/android/livesdk/gift/platform/core/model/e0;", "getSpeedyGiftPopupInfo", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/e0;", "getSpeedyGiftPopupInfo$annotations", "speedyGiftPopupInfo", "getFirstChargeSpeedyGiftId", "getFirstChargeSpeedyGiftId$annotations", "firstChargeSpeedyGiftId", BuildConfig.FLAVOR, "getMsgProcessFilter", "()Ljava/util/Map;", "getMsgProcessFilter$annotations", "msgProcessFilter", "Lcom/bytedance/android/livesdk/gift/platform/core/model/g;", "getExtraParam", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/g;", "getExtraParam$annotations", "extraParam", "Lcom/bytedance/android/livesdk/gift/platform/core/model/m;", "getGiftSearchConfig", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/m;", "getGiftSearchConfig$annotations", "giftSearchConfig", "Lcom/bytedance/android/livesdk/gift/platform/core/model/d;", "getGiftAgentConfig", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/d;", "getGiftAgentConfig$annotations", "giftAgentConfig", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface u extends vh7.c<u> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "extra_params")
    g getExtraParam();

    @FieldName(name = "fansclub_gift_ids")
    List<Long> getFansClubIds();

    @FieldName(name = "speedy_gift_id")
    long getFastGiftId();

    @FieldName(name = "first_recharge_speedy_gift_id")
    long getFirstChargeSpeedyGiftId();

    @FieldName(name = "gift_agent_config")
    d getGiftAgentConfig();

    @FieldName(name = "gift_combo_infos")
    List<e> getGiftComboInfoList();

    @FieldName(name = "gift_entrance_icon")
    py.k getGiftEntranceIcon();

    @FieldName(name = "gift_search_config")
    m getGiftSearchConfig();

    @FieldName(name = "gift_group_infos")
    List<h> getGroupCountInfo();

    @FieldName(name = "honor_gift_ids")
    List<Long> getHonorLevelGiftIds();

    @FieldName(name = "msg_process_filter")
    Map<String, String> getMsgProcessFilter();

    @FieldName(name = "new_gift_id")
    long getNewGiftId();

    @FieldName(name = "gift_words")
    String getNewGiftTip();

    @FieldName(name = "noble_gift_ids")
    List<Long> getNobleGiftIds();

    @FieldName(name = "speedy_gift_popup_info")
    e0 getSpeedyGiftPopupInfo();
}
