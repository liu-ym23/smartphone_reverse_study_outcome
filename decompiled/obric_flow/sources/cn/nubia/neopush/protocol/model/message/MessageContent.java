package cn.nubia.neopush.protocol.model.message;

import ai.j0;

/* JADX INFO: loaded from: classes.dex */
public class MessageContent {
    public String apiKey;
    public String content;
    public String description;
    public String extra;
    public Flag flag;
    public boolean isAlreadypush;
    public boolean isShowOnNotificationBar;
    public long messageId;
    public int notifyId;
    public int notifyType;
    public long overDatetime;
    public String packageName;
    public long randomTime;
    public boolean shouldUseSoundOrVibrate;
    public long showtime;
    public String title;
    public int trigger;
    public int type;
    public String zteMsg;

    public MessageContent() {
        this.isAlreadypush = false;
        this.shouldUseSoundOrVibrate = false;
        this.isShowOnNotificationBar = false;
    }

    public void setContent(String r5) {
        this.content = r5;
    }

    public void setDescription(String r5) {
        this.description = r5;
    }

    public void setExtra(String r5) {
        this.extra = r5;
    }

    public void setMessageId(long r5) {
        this.messageId = r5;
    }

    public void setNotifyId(int r5) {
        this.notifyId = r5;
    }

    public void setNotifyType(int r5) {
        this.notifyType = r5;
    }

    public void setPackageName(String r5) {
        this.packageName = r5;
    }

    public void setShouldUseSoundOrVibrate(boolean r5) {
        this.shouldUseSoundOrVibrate = r5;
    }

    public void setShowtime(long r5) {
        this.showtime = r5;
    }

    public void setTitle(String r5) {
        this.title = r5;
    }

    public void setType(int r5) {
        this.type = r5;
    }

    public void setZteMessageId(String r5) {
        this.zteMsg = r5;
    }

    public void setisAlreadypush(boolean r5) {
        this.isAlreadypush = r5;
    }

    public void setoverDatetime(long r5) {
        this.overDatetime = r5;
    }

    public void setrandomTime(long r5) {
        this.randomTime = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("MessageContent{flag=");
        r5.append(this.flag);
        r5.append(", messageId=");
        r5.append(this.messageId);
        r5.append(", packageName='");
        r5.append(this.packageName);
        r5.append("', type=");
        r5.append(this.type);
        r5.append(", title='");
        r5.append(this.title);
        r5.append("', description='");
        r5.append(this.description);
        r5.append("', content='");
        r5.append(this.content);
        r5.append("', notifyId=");
        r5.append(this.notifyId);
        r5.append(", notifyType=");
        r5.append(this.notifyType);
        r5.append(", trigger=");
        r5.append(this.trigger);
        r5.append(", extra='");
        r5.append(this.extra);
        r5.append("', apiKey='");
        return j0.q(r5, this.apiKey, "'}");
    }
}
