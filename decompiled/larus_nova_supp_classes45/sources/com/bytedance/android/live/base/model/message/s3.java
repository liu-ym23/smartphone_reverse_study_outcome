package com.bytedance.android.live.base.model.message;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0013\bg\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001LR\u001c\u0010\r\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010$\u001a\u0004\u0018\u00010\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010*\u001a\u0004\u0018\u00010%8&@&X¦\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010-\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012R\u001c\u00100\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010\u0010\"\u0004\b/\u0010\u0012R\u001e\u00103\u001a\u0004\u0018\u00010%8&@&X¦\u000e¢\u0006\f\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u001c\u00106\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0010\"\u0004\b5\u0010\u0012R\u001c\u00109\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0010\"\u0004\b8\u0010\u0012R\u001e\u0010?\u001a\u0004\u0018\u00010:8&@&X¦\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010@\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b@\u0010\u0016\"\u0004\bA\u0010\u0018R\u001c\u0010D\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\bB\u0010\n\"\u0004\bC\u0010\fR\u001c\u0010G\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\bE\u0010\n\"\u0004\bF\u0010\fR\u001c\u0010J\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\bH\u0010\n\"\u0004\bI\u0010\f¨\u0006M"}, d2 = {"Lcom/bytedance/android/live/base/model/message/s3;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/t;", "Lcom/bytedance/android/live/base/model/message/u3;", "", "Lcom/bytedance/android/live/base/model/message/h0;", "Lcom/bytedance/android/live/base/model/message/x3;", "Lcom/bytedance/android/live/base/model/message/p0;", "", "getStyle", "()J", "setStyle", "(J)V", "style", "", "getSkin", "()I", "setSkin", "(I)V", "skin", "", "isLocalInsertMsgOld", "()Z", "setLocalInsertMsgOld", "(Z)V", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "content", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser2", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser2", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "user2", "Landroid/graphics/drawable/Drawable;", "getBadgeDrawable", "()Landroid/graphics/drawable/Drawable;", "setBadgeDrawable", "(Landroid/graphics/drawable/Drawable;)V", "badgeDrawable", "getBadgeHeight", "setBadgeHeight", "badgeHeight", "getBadgeWidth", "setBadgeWidth", "badgeWidth", "getRecentBadgeDrawable", "setRecentBadgeDrawable", "recentBadgeDrawable", "getRecentBadgeHeight", "setRecentBadgeHeight", "recentBadgeHeight", "getRecentBadgeWidth", "setRecentBadgeWidth", "recentBadgeWidth", "Landroid/text/Spannable;", "getRenderSpan", "()Landroid/text/Spannable;", "setRenderSpan", "(Landroid/text/Spannable;)V", "renderSpan", "isSelfAndMock", "setSelfAndMock", "getStartSendTime", "setStartSendTime", "startSendTime", "getApiSuccessTime", "setApiSuccessTime", "apiSuccessTime", "getDanmakuReceiveTime", "setDanmakuReceiveTime", "danmakuReceiveTime", "Companion", "a", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s3 extends vh7.c<s3>, t, u3, h0, x3, p0 {
    public static final long ADVANCED = 2;
    public static final long BASE = 1;
    public static final a Companion = null;
    public static final int SKIN_CEREMONY = 1;
    public static final int SKIN_NORMAL = 0;
    public static final long SUPREME = 3;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    @Override // com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ boolean canPin();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean canText();

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean currUserIsAnchor();

    long getApiSuccessTime();

    Drawable getBadgeDrawable();

    int getBadgeHeight();

    int getBadgeWidth();

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

    long getDanmakuReceiveTime();

    @Override // com.bytedance.android.live.base.model.message.p0
    /* synthetic */ String getDefaultContent();

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

    @Override // com.bytedance.android.live.base.model.message.q3
    /* synthetic */ String getMessageMethod();

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

    Drawable getRecentBadgeDrawable();

    int getRecentBadgeHeight();

    int getRecentBadgeWidth();

    @Override // com.bytedance.android.live.base.model.message.p0
    Spannable getRenderSpan();

    @Override // com.bytedance.android.live.base.model.message.h0, com.bytedance.android.live.base.model.message.x3
    /* synthetic */ a5 getRichText();

    @Override // com.bytedance.android.live.base.model.message.p0
    /* synthetic */ a5 getRichTextContent();

    /* synthetic */ long getRoomId();

    @Override // com.bytedance.android.live.base.model.message.x3
    /* synthetic */ j4 getSelfFakeRichContent();

    int getSkin();

    long getStartSendTime();

    long getStyle();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getTimestamp();

    IBaseUser getUser2();

    @Override // com.bytedance.android.live.base.model.message.u3
    /* synthetic */ IBaseUser getUserInMessage();

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

    boolean isLocalInsertMsgOld();

    boolean isSelfAndMock();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isTooMuchMsg();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    void setApiSuccessTime(long r1);

    void setBadgeDrawable(Drawable r1);

    void setBadgeHeight(int r1);

    void setBadgeWidth(int r1);

    /* synthetic */ void setBaseMessage(m0 r1);

    /* synthetic */ void setConsumeTime(long r1);

    void setContent(String r1);

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

    void setLocalInsertMsgOld(boolean r1);

    /* synthetic */ void setMessageIdentity(MessageIdentity r1);

    /* synthetic */ void setMessageMethod(String r1);

    /* synthetic */ void setReceiveTime(long r1);

    void setRecentBadgeDrawable(Drawable r1);

    void setRecentBadgeHeight(int r1);

    void setRecentBadgeWidth(int r1);

    @Override // com.bytedance.android.live.base.model.message.p0
    void setRenderSpan(Spannable r1);

    void setSelfAndMock(boolean r1);

    @Override // com.bytedance.android.live.base.model.message.x3
    /* synthetic */ void setSelfFakeRichContent(j4 r1);

    void setSkin(int r1);

    void setStartSendTime(long r1);

    void setStyle(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setTooMuchMsg(boolean r1);

    void setUser2(IBaseUser r1);

    /* synthetic */ void setWRDSMessage(boolean r1);

    /* synthetic */ void setWRDSSubKey(String r1);

    /* synthetic */ void setWRDSVersion(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean supportDisplayText();
}
