package com.bytedance.android.live.base.model.message;

import android.text.Spannable;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006J\b\u0010\b\u001a\u00020\u0007H&R\u0014\u0010\f\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000eR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\"R\u001c\u0010$\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010&R\u001c\u0010)\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010\u000b\"\u0004\b(\u0010\"R\u001c\u0010,\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u000b\"\u0004\b+\u0010\"R\u0016\u00100\u001a\u0004\u0018\u00010-8&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0004\u0018\u0001018&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0016\u00108\u001a\u0004\u0018\u0001058&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u0010<\u001a\u0004\u0018\u0001098&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/bytedance/android/live/base/model/message/h4;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/h0;", "Lcom/bytedance/android/live/base/model/message/p0;", "Lcom/bytedance/android/live/base/model/message/t;", "Lcom/bytedance/android/live/base/model/message/u3;", "", "", "notShowInPublicScreen", "", "getEventTime", "()J", "eventTime", "getSendReview", "()Z", "sendReview", "isOfficialDanmaku", "Lcom/bytedance/android/live/base/model/data/k;", "getContentExt", "()Lcom/bytedance/android/live/base/model/data/k;", "contentExt", "isLocalInsertMsg", "", "getContent", "()Ljava/lang/String;", "content", "Landroid/text/Spannable;", "getRenderSpan", "()Landroid/text/Spannable;", "setRenderSpan", "(Landroid/text/Spannable;)V", "renderSpan", "getDanmakuReceiveTime", "setDanmakuReceiveTime", "(J)V", "danmakuReceiveTime", "isSelfAndMock", "setSelfAndMock", "(Z)V", "getStartSendTime", "setStartSendTime", "startSendTime", "getApiSuccessTime", "setApiSuccessTime", "apiSuccessTime", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUserInfo", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "userInfo", "Lcom/bytedance/android/live/base/model/message/v;", "getEffect", "()Lcom/bytedance/android/live/base/model/message/v;", NewBroadcastMonitor.STAGE.EFFECT, "Lpy/k;", "getBackground", "()Lpy/k;", KtvSubElement.BACKGROUND, "Lcom/bytedance/android/live/base/model/data/l;", "getOfficialCommentConfig", "()Lcom/bytedance/android/live/base/model/data/l;", "officialCommentConfig", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h4 extends vh7.c<h4>, h0, p0, t, u3 {
    @Override // com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ boolean canPin();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean canText();

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean currUserIsAnchor();

    long getApiSuccessTime();

    py.k getBackground();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ m0 getBaseMessage();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ Map getBuriedPoint();

    @Override // com.bytedance.android.live.base.model.message.h0
    /* synthetic */ String getChatContent();

    @Override // com.bytedance.android.live.base.model.message.h0
    /* synthetic */ IBaseUser getChatUserInfo();

    /* synthetic */ IPublicAreaCommon getCommonArea();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getConsumeTime();

    String getContent();

    com.bytedance.android.live.base.model.data.k getContentExt();

    long getDanmakuReceiveTime();

    @Override // com.bytedance.android.live.base.model.message.p0
    /* synthetic */ String getDefaultContent();

    /* synthetic */ long getDelayDispatchMs();

    v getEffect();

    long getEventTime();

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

    @Override // com.bytedance.android.live.base.model.message.q3
    /* synthetic */ String getMessageMethod();

    com.bytedance.android.live.base.model.data.l getOfficialCommentConfig();

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

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ byte[] getRawPayload();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getReceiveTime();

    @Override // com.bytedance.android.live.base.model.message.p0
    Spannable getRenderSpan();

    @Override // com.bytedance.android.live.base.model.message.h0, com.bytedance.android.live.base.model.message.x3
    /* synthetic */ a5 getRichText();

    @Override // com.bytedance.android.live.base.model.message.p0
    /* synthetic */ a5 getRichTextContent();

    /* synthetic */ long getRoomId();

    @Override // com.bytedance.android.live.base.model.message.x3
    /* synthetic */ j4 getSelfFakeRichContent();

    boolean getSendReview();

    long getStartSendTime();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getTimestamp();

    @Override // com.bytedance.android.live.base.model.message.u3
    /* synthetic */ IBaseUser getUserInMessage();

    IBaseUser getUserInfo();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

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

    boolean isLocalInsertMsg();

    boolean isOfficialDanmaku();

    boolean isSelfAndMock();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isTooMuchMsg();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    boolean notShowInPublicScreen();

    void setApiSuccessTime(long r1);

    /* synthetic */ void setBaseMessage(m0 r1);

    /* synthetic */ void setConsumeTime(long r1);

    void setDanmakuReceiveTime(long r1);

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

    /* synthetic */ void setReceiveTime(long r1);

    @Override // com.bytedance.android.live.base.model.message.p0
    void setRenderSpan(Spannable r1);

    void setSelfAndMock(boolean r1);

    @Override // com.bytedance.android.live.base.model.message.x3
    /* synthetic */ void setSelfFakeRichContent(j4 r1);

    void setStartSendTime(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setTooMuchMsg(boolean r1);

    /* synthetic */ void setWRDSMessage(boolean r1);

    /* synthetic */ void setWRDSSubKey(String r1);

    /* synthetic */ void setWRDSVersion(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean supportDisplayText();
}
