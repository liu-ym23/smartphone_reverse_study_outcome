package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/base/model/message/k1;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/c3;", "", "Lcom/bytedance/android/live/base/model/message/l1;", "getContainerDataList", "()Ljava/util/List;", "setContainerDataList", "(Ljava/util/List;)V", "getContainerDataList$annotations", "()V", "containerDataList", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k1 extends vh7.c<k1>, c3 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ m0 getCommon();

    /* synthetic */ long getConsumeTime();

    @FieldName(name = "data")
    List<l1> getContainerDataList();

    /* synthetic */ long getDecodeEndTime();

    /* synthetic */ long getDecodeStartTime();

    /* synthetic */ long getDelayDispatchMs();

    /* synthetic */ long getEnqueueDispatchTime();

    /* synthetic */ int getGeneralMessageType();

    /* synthetic */ long getHttpSendTime();

    /* synthetic */ int getIntType();

    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ String getMessageMethod();

    /* synthetic */ int getPriority();

    /* synthetic */ byte[] getRawPayload();

    /* synthetic */ long getReceiveTime();

    /* synthetic */ long getRoomId();

    /* synthetic */ long getTimestamp();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    /* synthetic */ boolean isFromFirstRequest();

    /* synthetic */ boolean isGlobalMessage();

    /* synthetic */ boolean isTimeCostCanUse();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    /* synthetic */ void setCommon(m0 r1);

    /* synthetic */ void setCommonMessageData(m0 r1);

    /* synthetic */ void setConsumeTime(long r1);

    @FieldName(name = "data#setter")
    void setContainerDataList(List<l1> r1);

    /* synthetic */ void setDecodeEndTime(long r1);

    /* synthetic */ void setDecodeStartTime(long r1);

    /* synthetic */ void setEnqueueDispatchTime(long r1);

    /* synthetic */ void setGeneralMessageType(int r1);

    /* synthetic */ void setHttpSendTime(long r1);

    /* synthetic */ void setIsFromFirstRequest(boolean r1);

    /* synthetic */ void setIsInsert(boolean r1);

    /* synthetic */ void setMessageExtra(Map<String, String> r1);

    /* synthetic */ void setMessageFrom(int r1);

    /* synthetic */ void setMessageMethod(String r1);

    /* synthetic */ void setRawPayload(byte[] r1);

    /* synthetic */ void setReceiveTime(long r1);

    /* synthetic */ void setTimestamp(long r1);

    /* synthetic */ void setWRDSMessage(boolean r1);

    /* synthetic */ void setWRDSSubKey(String r1);

    /* synthetic */ void setWRDSVersion(long r1);
}
