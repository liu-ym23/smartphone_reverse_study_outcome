package kc2;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.r;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import vh7.e;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends c implements r {
    public static final int UPDATE_FIELD_CONTENT = 8;
    public static final int UPDATE_FIELD_MESSAGE_ID = 4;
    public static final int UPDATE_FIELD_NONE = 0;
    public static final int UPDATE_FIELD_READ_STATUS = 2;
    public static final int UPDATE_FIELD_SEND_STATUS = 1;
    public static final int UPDATE_FIELD_USER_INFO = 16;
    public long audioDuration;
    public String audioPath;
    public String audioUrl;
    public String content;
    public boolean isResend;
    private MessageIdentity messageIdentity;
    public transient String msgId;
    public IPublicAreaCommon publicAreaCommon;
    public int readStatus;
    private a5 rtfContent;
    public int sendStatus;
    public int updateField;
    public String updatePath;
    public IBaseUser userInfo;

    public <R extends e<r>> R castTo(Class<R> r1) {
        return null;
    }

    public <R extends e<r>> R castToOrNull(Class<R> r1) {
        return null;
    }

    public byte[] getRawPayload() {
        return null;
    }

    public IBaseUser getUserInMessage() {
        return null;
    }

    public void isAnchorAsrResult(boolean r1) {
    }

    public boolean isAnchorAsrResult() {
        return false;
    }

    public IPublicAreaCommon getOrInitPublicAreaCommon() {
        if (this.publicAreaCommon != null) goto L6;
        this.publicAreaCommon = f.c(IPublicAreaCommon.class);
    L6:
        return this.publicAreaCommon;
    }

    public a() {
        this.updateField = 0;
        this.userInfo = null;
        this.messageIdentity = null;
        this.rtfContent = null;
        this.sendStatus = 0;
        this.readStatus = 0;
        setMessageMethod("WebcastAudioChatMessage");
    }

    public long getAudioDuration() {
        return this.audioDuration;
    }

    public String getAudioPath() {
        return this.audioPath;
    }

    public String getAudioUrl() {
        return this.audioUrl;
    }

    public String getChatContent() {
        return this.content;
    }

    public String getContent() {
        return this.content;
    }

    public MessageIdentity getMessageIdentity() {
        return this.messageIdentity;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public int getReadStatus() {
        return this.readStatus;
    }

    public a5 getRtfContent() {
        return this.rtfContent;
    }

    public int getSendStatus() {
        return this.sendStatus;
    }

    public IBaseUser getUserInfo() {
        return this.userInfo;
    }

    public void setAudioDuration(long r1) {
        this.audioDuration = r1;
    }

    public void setAudioPath(String r1) {
        this.audioPath = r1;
    }

    public void setAudioUrl(String r1) {
        this.audioUrl = r1;
    }

    public void setContent(String r1) {
        this.content = r1;
    }

    public void setMessageIdentity(MessageIdentity r1) {
        this.messageIdentity = r1;
    }

    public void setMsgId(String r1) {
        this.msgId = r1;
    }

    public void setReadStatus(int r1) {
        this.readStatus = r1;
    }

    public void setRtfContent(a5 r1) {
        this.rtfContent = r1;
    }

    public void setSendStatus(int r1) {
        this.sendStatus = r1;
    }

    public void setUserInfo(IBaseUser r1) {
        this.userInfo = r1;
    }
}
