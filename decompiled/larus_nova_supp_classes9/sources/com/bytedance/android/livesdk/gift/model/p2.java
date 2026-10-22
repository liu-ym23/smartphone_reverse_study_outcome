package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.profit.privilege.ProfitCheckConfig;
import com.bytedance.android.livesdk.message.model.cb;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001c\u0010\b\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R\u001c\u0010\u001a\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u0007R\u001c\u0010\u001d\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0005\"\u0004\b\u001c\u0010\u0007R\u001c\u0010 \u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007R\u001c\u0010#\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0005\"\u0004\b\"\u0010\u0007R\u001c\u0010&\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010\u0007R\u0014\u0010(\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0005R\u001c\u0010+\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0005\"\u0004\b*\u0010\u0007R\u0016\u0010/\u001a\u0004\u0018\u00010,8&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u000bR\"\u00108\u001a\b\u0012\u0004\u0012\u000203028&@&X¦\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010;\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u0010\rR\u001e\u0010A\u001a\u0004\u0018\u00010<8&@&X¦\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010D\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\bB\u0010\u0005\"\u0004\bC\u0010\u0007R\u001c\u0010G\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\bE\u0010\u000b\"\u0004\bF\u0010\rR\u001c\u0010J\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\bH\u0010\u000b\"\u0004\bI\u0010\rR\u001c\u0010P\u001a\u00020K8&@&X¦\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010T\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u0001028&@&X¦\u000e¢\u0006\f\u001a\u0004\bR\u00105\"\u0004\bS\u00107R\u001c\u0010Y\u001a\u00020Q8&@&X¦\u000e¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010\\\u001a\u00020K8&@&X¦\u000e¢\u0006\f\u001a\u0004\bZ\u0010M\"\u0004\b[\u0010OR\u001c\u0010_\u001a\u00020K8&@&X¦\u000e¢\u0006\f\u001a\u0004\b]\u0010M\"\u0004\b^\u0010OR\u0016\u0010c\u001a\u0004\u0018\u00010`8&X¦\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0014\u0010e\u001a\u00020K8&X¦\u0004¢\u0006\u0006\u001a\u0004\bd\u0010MR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020\u0003028&X¦\u0004¢\u0006\u0006\u001a\u0004\bf\u00105R\"\u0010j\u001a\b\u0012\u0004\u0012\u00020\t028&@&X¦\u000e¢\u0006\f\u001a\u0004\bh\u00105\"\u0004\bi\u00107R\u001e\u0010p\u001a\u0004\u0018\u00010k8&@&X¦\u000e¢\u0006\f\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u0014\u0010r\u001a\u00020K8&X¦\u0004¢\u0006\u0006\u001a\u0004\bq\u0010MR\u001e\u0010x\u001a\u0004\u0018\u00010s8&@&X¦\u000e¢\u0006\f\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001e\u0010~\u001a\u0004\u0018\u00010y8&@&X¦\u000e¢\u0006\f\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R#\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u007f8&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001f\u0010\u0087\u0001\u001a\u00020K8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0085\u0001\u0010M\"\u0005\b\u0086\u0001\u0010OR$\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u0088\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R$\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u008e\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001f\u0010\u0096\u0001\u001a\u00020\u00038&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0094\u0001\u0010\u0005\"\u0005\b\u0095\u0001\u0010\u0007R\u001f\u0010\u0099\u0001\u001a\u00020\u00038&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0097\u0001\u0010\u0005\"\u0005\b\u0098\u0001\u0010\u0007R\u001f\u0010\u009c\u0001\u001a\u00020K8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u009a\u0001\u0010M\"\u0005\b\u009b\u0001\u0010OR$\u0010¢\u0001\u001a\u0005\u0018\u00010\u009d\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R(\u0010¦\u0001\u001a\u000b\u0012\u0005\u0012\u00030£\u0001\u0018\u0001028&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b¤\u0001\u00105\"\u0005\b¥\u0001\u00107R$\u0010¬\u0001\u001a\u0005\u0018\u00010§\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R\u0016\u0010®\u0001\u001a\u00020\t8&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u00ad\u0001\u0010\u000bR$\u0010´\u0001\u001a\u0005\u0018\u00010¯\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001¨\u0006µ\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/p2;", "Lvh7/c;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getFanTicketCount", "()J", "setFanTicketCount", "(J)V", "fanTicketCount", BuildConfig.FLAVOR, "getDescribe", "()Ljava/lang/String;", "setDescribe", "(Ljava/lang/String;)V", "describe", "getGiftId", "setGiftId", "giftId", "getGroupCount", "setGroupCount", "groupCount", "getLeftDiamonds", "setLeftDiamonds", "leftDiamonds", "getRepeatCount", "setRepeatCount", "repeatCount", "getComboCount", "setComboCount", "comboCount", "getPropId", "setPropId", "propId", "getPropType", "setPropType", "propType", "getMsgId", "setMsgId", "msgId", "getRoomFanTicketCount", "roomFanTicketCount", "getGroupId", "setGroupId", "groupId", "Lcom/bytedance/android/livesdk/gift/model/l;", "getComboHint", "()Lcom/bytedance/android/livesdk/gift/model/l;", "comboHint", "getDiyItemInfo", "diyItemInfo", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/y1;", "getGifts", "()Ljava/util/List;", "setGifts", "(Ljava/util/List;)V", "gifts", "getComment", "setComment", "comment", "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "displayText", "getConsumeDiamonds", "setConsumeDiamonds", "consumeDiamonds", "getLogId", "setLogId", "logId", "getTraceId", "setTraceId", "traceId", BuildConfig.FLAVOR, "getReqIndex", "()I", "setReqIndex", "(I)V", "reqIndex", "Lcom/bytedance/android/livesdk/gift/model/l2;", "getProps", "setProps", "props", "getProp", "()Lcom/bytedance/android/livesdk/gift/model/l2;", "setProp", "(Lcom/bytedance/android/livesdk/gift/model/l2;)V", "prop", "getSendType", "setSendType", "sendType", "getGiftCnt", "setGiftCnt", "giftCnt", "Lcom/bytedance/android/livesdk/gift/model/r;", "getDsAlertInfo", "()Lcom/bytedance/android/livesdk/gift/model/r;", "dsAlertInfo", "getCount", "count", "getMsgIdList", "msgIdList", "getToUserIds", "setToUserIds", "toUserIds", "Lcom/bytedance/android/livesdk/gift/model/v2;", "getNextSendParams", "()Lcom/bytedance/android/livesdk/gift/model/v2;", "setNextSendParams", "(Lcom/bytedance/android/livesdk/gift/model/v2;)V", "nextSendParams", "getMultiSendSuccessCount", "multiSendSuccessCount", "Lcom/bytedance/android/livesdk/gift/model/a1;", "getAnchorGift", "()Lcom/bytedance/android/livesdk/gift/model/a1;", "setAnchorGift", "(Lcom/bytedance/android/livesdk/gift/model/a1;)V", "anchorGift", "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h1;", "setGift", "(Lcom/bytedance/android/livesdk/gift/model/h1;)V", "gift", "Lcom/bytedance/android/live/core/model/profit/a;", "getCalmPeriod", "()Lcom/bytedance/android/live/core/model/profit/a;", "setCalmPeriod", "(Lcom/bytedance/android/live/core/model/profit/a;)V", "calmPeriod", "getClientGiftSource", "setClientGiftSource", "clientGiftSource", "Lcom/bytedance/android/livesdk/gift/model/j3;", "getSendTogetherInfo", "()Lcom/bytedance/android/livesdk/gift/model/j3;", "setSendTogetherInfo", "(Lcom/bytedance/android/livesdk/gift/model/j3;)V", "sendTogetherInfo", "Lcom/bytedance/android/livesdk/gift/model/w;", "getExtraEffectInfo", "()Lcom/bytedance/android/livesdk/gift/model/w;", "setExtraEffectInfo", "(Lcom/bytedance/android/livesdk/gift/model/w;)V", "extraEffectInfo", "getForceDisplayEffects", "setForceDisplayEffects", "forceDisplayEffects", "getSendGiftTime", "setSendGiftTime", "sendGiftTime", "getMultiSendEffectLevel", "setMultiSendEffectLevel", "multiSendEffectLevel", "Lcom/bytedance/android/live/profit/privilege/ProfitCheckConfig;", "getProfitCheckConfig", "()Lcom/bytedance/android/live/profit/privilege/ProfitCheckConfig;", "setProfitCheckConfig", "(Lcom/bytedance/android/live/profit/privilege/ProfitCheckConfig;)V", "profitCheckConfig", "Lcom/bytedance/android/livesdk/gift/model/n3;", "getSeriesGiftData", "setSeriesGiftData", "seriesGiftData", "Lcom/bytedance/android/livesdk/message/model/cb;", "getPetEffectInfo", "()Lcom/bytedance/android/livesdk/message/model/cb;", "setPetEffectInfo", "(Lcom/bytedance/android/livesdk/message/model/cb;)V", "petEffectInfo", "getMultiSendToUserId", "multiSendToUserId", "Lcom/bytedance/android/livesdk/gift/model/m0;", "getGiftRecommendInfo", "()Lcom/bytedance/android/livesdk/gift/model/m0;", "setGiftRecommendInfo", "(Lcom/bytedance/android/livesdk/gift/model/m0;)V", "giftRecommendInfo", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface p2 extends vh7.c<p2> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    a1 getAnchorGift();

    com.bytedance.android.live.core.model.profit.a getCalmPeriod();

    int getClientGiftSource();

    long getComboCount();

    l getComboHint();

    String getComment();

    long getConsumeDiamonds();

    int getCount();

    String getDescribe();

    a5 getDisplayText();

    String getDiyItemInfo();

    r getDsAlertInfo();

    w getExtraEffectInfo();

    long getFanTicketCount();

    long getForceDisplayEffects();

    h1 getGift();

    int getGiftCnt();

    long getGiftId();

    m0 getGiftRecommendInfo();

    List<y1> getGifts();

    long getGroupCount();

    long getGroupId();

    long getLeftDiamonds();

    String getLogId();

    long getMsgId();

    List<Long> getMsgIdList();

    int getMultiSendEffectLevel();

    int getMultiSendSuccessCount();

    String getMultiSendToUserId();

    v2 getNextSendParams();

    cb getPetEffectInfo();

    ProfitCheckConfig getProfitCheckConfig();

    l2 getProp();

    long getPropId();

    long getPropType();

    List<l2> getProps();

    long getRepeatCount();

    int getReqIndex();

    long getRoomFanTicketCount();

    long getSendGiftTime();

    j3 getSendTogetherInfo();

    int getSendType();

    List<n3> getSeriesGiftData();

    List<String> getToUserIds();

    String getTraceId();

    void setAnchorGift(a1 r1);

    void setCalmPeriod(com.bytedance.android.live.core.model.profit.a r1);

    void setClientGiftSource(int r1);

    void setComboCount(long r1);

    void setComment(String r1);

    void setConsumeDiamonds(long r1);

    void setDescribe(String r1);

    void setDisplayText(a5 r1);

    void setExtraEffectInfo(w r1);

    void setFanTicketCount(long r1);

    void setForceDisplayEffects(long r1);

    void setGift(h1 r1);

    void setGiftCnt(int r1);

    void setGiftId(long r1);

    void setGiftRecommendInfo(m0 r1);

    void setGifts(List<? extends y1> r1);

    void setGroupCount(long r1);

    void setGroupId(long r1);

    void setLeftDiamonds(long r1);

    void setLogId(String r1);

    void setMsgId(long r1);

    void setMultiSendEffectLevel(int r1);

    void setNextSendParams(v2 r1);

    void setPetEffectInfo(cb r1);

    void setProfitCheckConfig(ProfitCheckConfig r1);

    void setProp(l2 r1);

    void setPropId(long r1);

    void setPropType(long r1);

    void setProps(List<? extends l2> r1);

    void setRepeatCount(long r1);

    void setReqIndex(int r1);

    void setSendGiftTime(long r1);

    void setSendTogetherInfo(j3 r1);

    void setSendType(int r1);

    void setSeriesGiftData(List<? extends n3> r1);

    void setToUserIds(List<String> r1);

    void setTraceId(String r1);
}
