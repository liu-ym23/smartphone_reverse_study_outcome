package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u00032\u00020\u00032\u00020\u0004J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\u000f\u001a\u00020\nH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0013H&R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010'\u001a\u0004\u0018\u00010\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\u001c\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010.\u001a\u00020(8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b-\u0010\u001c\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010/8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b4\u0010\u001c\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/bytedance/android/live/base/model/message/r;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/t;", "", "Lcom/bytedance/android/live/base/model/message/u3;", "", "getAudioPath", "path", "", "setAudioPath", "", "status", "setReadStatus", "getReadStatus", "setSendStatus", "getSendStatus", "getMsgId", "msgId", "setMsgId", "", "isAnchorAsrResult", "astResult", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUserInfo", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUserInfo", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getUserInfo$annotations", "()V", "userInfo", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getContent$annotations", "content", "getAudioUrl", "setAudioUrl", "getAudioUrl$annotations", "audioUrl", "", "getAudioDuration", "()J", "setAudioDuration", "(J)V", "getAudioDuration$annotations", "audioDuration", "Lcom/bytedance/android/live/base/model/message/a5;", "getRtfContent", "()Lcom/bytedance/android/live/base/model/message/a5;", "setRtfContent", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "getRtfContent$annotations", "rtfContent", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface r extends vh7.c<r>, t, u3 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean canText();

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean currUserIsAnchor();

    @FieldName(name = "audio_duration")
    long getAudioDuration();

    String getAudioPath();

    @FieldName(name = "audio_url")
    String getAudioUrl();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ m0 getBaseMessage();

    /* synthetic */ String getChatContent();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getConsumeTime();

    @FieldName(name = "content")
    String getContent();

    /* synthetic */ long getDelayDispatchMs();

    /* synthetic */ int getGeneralMessageType();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getHttpSendTime();

    /* synthetic */ int getIntType();

    /* synthetic */ long getLocalTimestamp();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ MessageIdentity getMessageIdentity();

    /* synthetic */ String getMessageMethod();

    String getMsgId();

    @Override // com.bytedance.android.live.base.model.message.u3
    /* synthetic */ IPublicAreaCommon getOrInitPublicAreaCommon();

    /* synthetic */ int getPriority();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ byte[] getRawPayload();

    int getReadStatus();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getReceiveTime();

    /* synthetic */ long getRoomId();

    @FieldName(name = "rtf_content")
    a5 getRtfContent();

    int getSendStatus();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getTimestamp();

    @Override // com.bytedance.android.live.base.model.message.u3
    /* synthetic */ IBaseUser getUserInMessage();

    @FieldName(name = "user")
    IBaseUser getUserInfo();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    void isAnchorAsrResult(boolean r1);

    boolean isAnchorAsrResult();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isCurrentRoom(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFirstHistoryMessage();

    /* synthetic */ boolean isFromFirstRequest();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFromOtherIntercomRoom();

    /* synthetic */ boolean isGlobalMessage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isInsert();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isTooMuchMsg();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    @FieldName(name = "audio_duration#setter")
    void setAudioDuration(long r1);

    void setAudioPath(String r1);

    @FieldName(name = "audio_url#setter")
    void setAudioUrl(String r1);

    /* synthetic */ void setBaseMessage(m0 r1);

    /* synthetic */ void setConsumeTime(long r1);

    @FieldName(name = "content#setter")
    void setContent(String r1);

    /* synthetic */ void setDecodeEndTime(long r1);

    /* synthetic */ void setDecodeStartTime(long r1);

    /* synthetic */ void setEnqueueDispatchTime(long r1);

    /* synthetic */ void setHttpSendTime(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setIsFirstHistoryMessage(boolean r1);

    /* synthetic */ void setIsFromFirstRequest(boolean r1);

    /* synthetic */ void setIsInsert(boolean r1);

    /* synthetic */ void setLocalInsertMsg(boolean r1);

    /* synthetic */ void setMessageIdentity(MessageIdentity r1);

    /* synthetic */ void setMessageMethod(String r1);

    void setMsgId(String r1);

    void setReadStatus(int r1);

    /* synthetic */ void setReceiveTime(long r1);

    @FieldName(name = "rtf_content#setter")
    void setRtfContent(a5 r1);

    void setSendStatus(int r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setTooMuchMsg(boolean r1);

    @FieldName(name = "user#setter")
    void setUserInfo(IBaseUser r1);

    /* synthetic */ void setWRDSMessage(boolean r1);

    /* synthetic */ void setWRDSSubKey(String r1);

    /* synthetic */ void setWRDSVersion(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean supportDisplayText();
}
