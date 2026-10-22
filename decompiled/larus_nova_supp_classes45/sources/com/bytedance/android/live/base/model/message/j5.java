package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000e\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010!\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\t\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001b¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/base/model/message/j5;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/c3;", "", "getLiveTogetherStatus", "()J", "setLiveTogetherStatus", "(J)V", "getLiveTogetherStatus$annotations", "()V", "liveTogetherStatus", "getEntranceScene", "setEntranceScene", "getEntranceScene$annotations", "entranceScene", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getTogetherAnchor", "()Ljava/util/List;", "setTogetherAnchor", "(Ljava/util/List;)V", "getTogetherAnchor$annotations", "togetherAnchor", "", "getAvatarTitle", "()Ljava/lang/String;", "setAvatarTitle", "(Ljava/lang/String;)V", "getAvatarTitle$annotations", "avatarTitle", "getSchemaUrl", "setSchemaUrl", "getSchemaUrl$annotations", "schemaUrl", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface j5 extends vh7.c<j5>, c3 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "title")
    String getAvatarTitle();

    /* synthetic */ m0 getCommon();

    /* synthetic */ long getConsumeTime();

    /* synthetic */ long getDecodeEndTime();

    /* synthetic */ long getDecodeStartTime();

    /* synthetic */ long getDelayDispatchMs();

    /* synthetic */ long getEnqueueDispatchTime();

    @FieldName(name = "scene")
    long getEntranceScene();

    /* synthetic */ int getGeneralMessageType();

    /* synthetic */ long getHttpSendTime();

    /* synthetic */ int getIntType();

    @FieldName(name = "is_together_live")
    long getLiveTogetherStatus();

    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ String getMessageMethod();

    /* synthetic */ int getPriority();

    /* synthetic */ byte[] getRawPayload();

    /* synthetic */ long getReceiveTime();

    /* synthetic */ long getRoomId();

    @FieldName(name = "schema_url")
    String getSchemaUrl();

    /* synthetic */ long getTimestamp();

    @FieldName(name = "user_list")
    List<IBaseUser> getTogetherAnchor();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    /* synthetic */ boolean isFromFirstRequest();

    /* synthetic */ boolean isGlobalMessage();

    /* synthetic */ boolean isTimeCostCanUse();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    @FieldName(name = "title#setter")
    void setAvatarTitle(String r1);

    /* synthetic */ void setCommon(m0 r1);

    /* synthetic */ void setCommonMessageData(m0 r1);

    /* synthetic */ void setConsumeTime(long r1);

    /* synthetic */ void setDecodeEndTime(long r1);

    /* synthetic */ void setDecodeStartTime(long r1);

    /* synthetic */ void setEnqueueDispatchTime(long r1);

    @FieldName(name = "scene#setter")
    void setEntranceScene(long r1);

    /* synthetic */ void setGeneralMessageType(int r1);

    /* synthetic */ void setHttpSendTime(long r1);

    /* synthetic */ void setIsFromFirstRequest(boolean r1);

    /* synthetic */ void setIsInsert(boolean r1);

    @FieldName(name = "is_together_live#setter")
    void setLiveTogetherStatus(long r1);

    /* synthetic */ void setMessageExtra(Map<String, String> r1);

    /* synthetic */ void setMessageFrom(int r1);

    /* synthetic */ void setMessageMethod(String r1);

    /* synthetic */ void setRawPayload(byte[] r1);

    /* synthetic */ void setReceiveTime(long r1);

    @FieldName(name = "schema_url#setter")
    void setSchemaUrl(String r1);

    /* synthetic */ void setTimestamp(long r1);

    @FieldName(name = "user_list#setter")
    void setTogetherAnchor(List<IBaseUser> r1);

    /* synthetic */ void setWRDSMessage(boolean r1);

    /* synthetic */ void setWRDSSubKey(String r1);

    /* synthetic */ void setWRDSVersion(long r1);
}
