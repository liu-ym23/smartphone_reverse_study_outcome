package cn.nubia.neopush.sdk;

import android.os.Bundle;
import cn.nubia.neopush.commons.AppUtil;
import cn.nubia.neopush.commons.Constant;
import cn.nubia.neopush.commons.NeoLog;
import cn.nubia.neopush.protocol.model.message.MessageContent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NeoPushMessage {
    private String content;
    private String description;
    private Map<String, String> extra;
    private long messageId;
    private int messageNum;
    private int notifyId;
    private int notifyType;
    private String packageName;
    private String title;
    private int type;
    private String zteMessageId;

    public NeoPushMessage() {
    }

    public static MessageContent TransBundle(Bundle r5) {
        MessageContent r10 = new MessageContent();
        r10.setPackageName(r5.getString(Constant.PACKAGE_NAME));
        r10.setContent(r5.getString("content"));
        r10.setDescription(r5.getString(Constant.DESCRIPTION));
        r10.setMessageId(r5.getLong("message_id"));
        r10.setZteMessageId(r5.getString(Constant.ZTE_MESSAGE_ID));
        r10.setNotifyType(r5.getInt(Constant.NOTIFY_TYPE));
        r10.setNotifyId(r5.getInt(Constant.NOTIFY_ID));
        r10.setTitle(r5.getString(Constant.TITLE));
        r10.setType(r5.getInt(Constant.MESSAGE_TYPE));
        r10.setExtra(r5.getString("extra"));
        r10.setoverDatetime(r5.getLong(Constant.OVERDATE_TIME));
        return r10;
    }

    public static NeoPushMessage fromBundle(Bundle r5) {
        NeoPushMessage r10 = new NeoPushMessage();
        r10.setPackageName(r5.getString(Constant.PACKAGE_NAME));
        r10.setContent(r5.getString("content"));
        r10.setDescription(r5.getString(Constant.DESCRIPTION));
        r10.setMessageId(r5.getLong("message_id"));
        r10.setZteMessageId(r5.getString(Constant.ZTE_MESSAGE_ID));
        r10.setMessageNum(r5.getInt(Constant.MESSAGE_NUM));
        r10.setNotifyType(r5.getInt(Constant.NOTIFY_TYPE));
        r10.setNotifyId(r5.getInt(Constant.NOTIFY_ID));
        r10.setTitle(r5.getString(Constant.TITLE));
        r10.setType(r5.getInt(Constant.MESSAGE_TYPE));
        r10.setExtra(AppUtil.parseExtra(r5.getString("extra")));
        return r10;
    }

    public static List<NeoPushMessage> fromBundleList(Bundle r10) {
        ArrayList r5 = new ArrayList();
        if (r10 == null) goto L9;
        Iterator<String> r11 = r10.keySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L9;
        String r12 = r11.next();
        Bundle r13 = r10.getBundle(r12);
        NeoLog.i("fromBundleList key = " + r12 + ";data=" + r13);
        r5.add(fromBundle(r13));
    L9:
        Collections.sort(r5, new AnonymousClass1());
        return r5;
    }

    public String getContent() {
        return this.content;
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, String> getExtra() {
        return this.extra;
    }

    public long getMessageId() {
        return this.messageId;
    }

    public int getMessageNum() {
        return this.messageNum;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public int getNotifyType() {
        return this.notifyType;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getZteMessageId() {
        return this.zteMessageId;
    }

    public void setContent(String r5) {
        this.content = r5;
    }

    public void setDescription(String r5) {
        this.description = r5;
    }

    public void setExtra(Map<String, String> r5) {
        this.extra = r5;
    }

    public void setMessageId(long r5) {
        this.messageId = r5;
    }

    public void setMessageNum(int r5) {
        this.messageNum = r5;
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

    public void setTitle(String r5) {
        this.title = r5;
    }

    public void setType(int r5) {
        this.type = r5;
    }

    public void setZteMessageId(String r5) {
        this.zteMessageId = r5;
    }

    public String toString() {
        return "NeoPushMessage{messageNum=" + this.messageNum + ", messageId=" + this.messageId + ", zteMessageId=" + this.zteMessageId + ", packageName='" + this.packageName + "', type=" + this.type + ", title='" + this.title + "', description='" + this.description + "', content='" + this.content + "', notifyId=" + this.notifyId + ", notifyType=" + this.notifyType + ", extra=" + this.extra + '}';
    }
}
