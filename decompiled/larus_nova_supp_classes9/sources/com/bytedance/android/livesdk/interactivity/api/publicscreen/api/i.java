package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.bytedance.android.live.base.model.message.c3;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/i;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/c3;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/r;", "getLikeIconInfo", "()Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/r;", "setLikeIconInfo", "(Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/r;)V", "getLikeIconInfo$annotations", "()V", "likeIconInfo", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/c;", "getChatEmojiGuideInfo", "()Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/c;", "setChatEmojiGuideInfo", "(Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/c;)V", "getChatEmojiGuideInfo$annotations", "chatEmojiGuideInfo", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/d;", "getChatImageGuideInfo", "()Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/d;", "setChatImageGuideInfo", "(Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/d;)V", "getChatImageGuideInfo$annotations", "chatImageGuideInfo", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getUpdateInfoType", "()Ljava/util/List;", "setUpdateInfoType", "(Ljava/util/List;)V", "getUpdateInfoType$annotations", "updateInfoType", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface i extends vh7.c<i>, c3 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "chat_emoji_guide_info")
    c getChatEmojiGuideInfo();

    @FieldName(name = "chat_image_guide_info")
    d getChatImageGuideInfo();

    /* synthetic */ m0 getCommon();

    /* synthetic */ long getConsumeTime();

    /* synthetic */ long getDecodeEndTime();

    /* synthetic */ long getDecodeStartTime();

    /* synthetic */ long getDelayDispatchMs();

    /* synthetic */ long getEnqueueDispatchTime();

    /* synthetic */ int getGeneralMessageType();

    /* synthetic */ long getHttpSendTime();

    /* synthetic */ int getIntType();

    @FieldName(name = "like_icon_info")
    r getLikeIconInfo();

    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ String getMessageMethod();

    /* synthetic */ int getPriority();

    /* synthetic */ byte[] getRawPayload();

    /* synthetic */ long getReceiveTime();

    /* synthetic */ long getRoomId();

    /* synthetic */ long getTimestamp();

    @FieldName(name = "update_info_type")
    List<Integer> getUpdateInfoType();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    /* synthetic */ boolean isFromFirstRequest();

    /* synthetic */ boolean isGlobalMessage();

    /* synthetic */ boolean isTimeCostCanUse();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    @FieldName(name = "chat_emoji_guide_info#setter")
    void setChatEmojiGuideInfo(c r1);

    @FieldName(name = "chat_image_guide_info#setter")
    void setChatImageGuideInfo(d r1);

    /* synthetic */ void setCommon(m0 r1);

    /* synthetic */ void setCommonMessageData(m0 r1);

    /* synthetic */ void setConsumeTime(long r1);

    /* synthetic */ void setDecodeEndTime(long r1);

    /* synthetic */ void setDecodeStartTime(long r1);

    /* synthetic */ void setEnqueueDispatchTime(long r1);

    /* synthetic */ void setGeneralMessageType(int r1);

    /* synthetic */ void setHttpSendTime(long r1);

    /* synthetic */ void setIsFromFirstRequest(boolean r1);

    /* synthetic */ void setIsInsert(boolean r1);

    @FieldName(name = "like_icon_info#setter")
    void setLikeIconInfo(r r1);

    /* synthetic */ void setMessageExtra(Map<String, String> r1);

    /* synthetic */ void setMessageFrom(int r1);

    /* synthetic */ void setMessageMethod(String r1);

    /* synthetic */ void setRawPayload(byte[] r1);

    /* synthetic */ void setReceiveTime(long r1);

    /* synthetic */ void setTimestamp(long r1);

    @FieldName(name = "update_info_type#setter")
    void setUpdateInfoType(List<Integer> r1);

    /* synthetic */ void setWRDSMessage(boolean r1);

    /* synthetic */ void setWRDSSubKey(String r1);

    /* synthetic */ void setWRDSVersion(long r1);
}
