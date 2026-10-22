package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface k0 extends vh7.c<k0>, h0, t, x3, q3, u3 {
    public static final int CHAT_MESSAGE_ACTION_TYPE = 1;
    public static final int INDIVIUAL_CHAT_PRIORITY_HIGH = 80;
    public static final int INDIVIUAL_CHAT_PRIORITY_LOW = 30;
    public static final int INDIVIUAL_CHAT_PRIORITY_MIDDLE = 50;
    public static final int INDIVIUAL_CHAT_PRIORITY_UNKNOWN = 0;
    public static final int PRIORITY_LEVEL_HIGH = 2;
    public static final int PRIORITY_LEVEL_LOW = 0;
    public static final int PRIORITY_LEVEL_MIDDLE = 1;
    public static final long SOURCE_LOTTERY = 9;
    public static final long SOURCE_SUPER_LOTTERY = 10;
    public static final long SOURCE_TOPIC = 13;
    public static final int TAG_HOT_CHAT = 1;
    public static final int TAG_UNKNOWN = 0;

    @Override // com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ boolean canPin();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean canText();

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean currUserIsAnchor();

    long getAgreeMsgId();

    py.k getBackground();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ m0 getBaseMessage();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ Map getBuriedPoint();

    @Override // com.bytedance.android.live.base.model.message.h0
    /* synthetic */ String getChatContent();

    long getChatId();

    long getChatSource();

    @Override // com.bytedance.android.live.base.model.message.h0
    /* synthetic */ IBaseUser getChatUserInfo();

    /* synthetic */ IPublicAreaCommon getCommonArea();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getConsumeTime();

    String getContent();

    int getContentSelfSeeStatus();

    long getDanmakuReceiveTime();

    /* synthetic */ long getDelayDispatchMs();

    long getEventTime();

    /* synthetic */ int getGeneralMessageType();

    py.k getGiftImage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getHttpSendTime();

    long getHttpSuccessTimestamps();

    /* synthetic */ int getIntType();

    q1 getLandscapeAreaCommon();

    /* synthetic */ long getLocalTimestamp();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ MessageIdentity getMessageIdentity();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* synthetic */ String getMessageMethod();

    String getMsgId();

    @Override // com.bytedance.android.live.base.model.message.u3
    /* synthetic */ IPublicAreaCommon getOrInitPublicAreaCommon();

    @Override // com.bytedance.android.live.base.model.message.h0, com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ long getPinBaseMessageId();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ long getPinCommenterId();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ long getPinMessageShowArea();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ IBaseUser getPinUser();

    /* synthetic */ int getPriority();

    int getPriorityLevel();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ byte[] getRawPayload();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getReceiveTime();

    a5 getRichDisplayText();

    @Override // com.bytedance.android.live.base.model.message.h0, com.bytedance.android.live.base.model.message.x3
    /* synthetic */ a5 getRichText();

    /* synthetic */ long getRoomId();

    @Override // com.bytedance.android.live.base.model.message.x3
    /* synthetic */ j4 getSelfFakeRichContent();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getTimestamp();

    @Override // com.bytedance.android.live.base.model.message.u3
    /* synthetic */ IBaseUser getUserInMessage();

    IBaseUser getUserInfo();

    py.k getUserLabel();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    int individualChatPriority();

    boolean intercomHideUserCard();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isCurrentRoom(long r1);

    boolean isFirstFetchShowMessage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFirstHistoryMessage();

    /* synthetic */ boolean isFromFirstRequest();

    @Override // com.bytedance.android.live.base.model.message.t
    boolean isFromOtherIntercomRoom();

    /* synthetic */ boolean isGlobalMessage();

    boolean isHighPriority();

    boolean isHotChat();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isInsert();

    boolean isLowPriority();

    void isSelfClickSend(boolean r1);

    boolean isSelfClickSend();

    boolean isSelfSendFake();

    boolean isSendReview();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isTooMuchMsg();

    boolean isVisibleToSender();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    void setBackground(py.k r1);

    /* synthetic */ void setBaseMessage(m0 r1);

    void setChatId(long r1);

    /* synthetic */ void setConsumeTime(long r1);

    void setContent(String r1);

    void setContentSelfSeeStatus(int r1);

    void setDanmakuReceiveTime(long r1);

    /* synthetic */ void setDecodeEndTime(long r1);

    /* synthetic */ void setDecodeStartTime(long r1);

    /* synthetic */ void setEnqueueDispatchTime(long r1);

    void setFirstFetchShowMessage(boolean r1);

    void setFullScreenTextColor(String r1);

    void setGiftImage(py.k r1);

    /* synthetic */ void setHttpSendTime(long r1);

    void setHttpSuccessTimestamps(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setIsFirstHistoryMessage(boolean r1);

    /* synthetic */ void setIsFromFirstRequest(boolean r1);

    /* synthetic */ void setIsInsert(boolean r1);

    void setLandscapeAreaCommon(q1 r1);

    /* synthetic */ void setLocalInsertMsg(boolean r1);

    /* synthetic */ void setMessageIdentity(MessageIdentity r1);

    /* synthetic */ void setMessageMethod(String r1);

    void setMsgId(String r1);

    void setPublicAreaCommon(IPublicAreaCommon r1);

    /* synthetic */ void setReceiveTime(long r1);

    void setRichDisplayText(a5 r1);

    @Override // com.bytedance.android.live.base.model.message.x3
    /* synthetic */ void setSelfFakeRichContent(j4 r1);

    void setSelfSendFake(boolean r1);

    void setStartSendTime(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setTooMuchMsg(boolean r1);

    void setUserInfo(IBaseUser r1);

    /* synthetic */ void setWRDSMessage(boolean r1);

    /* synthetic */ void setWRDSSubKey(String r1);

    /* synthetic */ void setWRDSVersion(long r1);

    long startSendTime();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean supportDisplayText();
}
