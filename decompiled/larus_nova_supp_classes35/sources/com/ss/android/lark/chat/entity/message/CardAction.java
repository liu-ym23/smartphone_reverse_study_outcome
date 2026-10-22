package com.ss.android.lark.chat.entity.message;

import com.squareup.wire.WireEnum;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CardAction implements Serializable {
    private int cmd;
    private Method method;
    private OpenUrl openUrl;
    private CardActionPacket packet;
    private Parameters parameters;
    private RequiredParameters requiredParameters;
    private String url;

    public static class MessageInfo implements Serializable {
        private String messageOpenId;

        public MessageInfo() {
        }

        public String getMessageOpenId() {
            return this.messageOpenId;
        }

        public void setMessageOpenId(String r1) {
            this.messageOpenId = r1;
        }
    }

    public static final enum Method extends Enum<Method> implements WireEnum {
        private static final /* synthetic */ Method[] $VALUES = null;
        public static final Method GET = null;
        public static final Method LARK_COMMAND = null;
        public static final Method OPEN_URL = null;
        public static final Method POST = null;
        private final int value;

        static {
            Method r0 = new Method("GET", 0, 1);
            GET = r0;
            Method r1 = new Method("POST", 1, 2);
            POST = r1;
            Method r4 = new Method("LARK_COMMAND", 2, 3);
            LARK_COMMAND = r4;
            Method r6 = new Method("OPEN_URL", 3, 4);
            OPEN_URL = r6;
            $VALUES = new Method[]{r0, r1, r4, r6};
        }

        public static Method[] values() {
            return (Method[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static Method fromValue(int r1) {
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L17;
            if (r1 == 3) goto L15;
            if (r1 == 4) goto L13;
            return null;
        L13:
            return OPEN_URL;
        L15:
            return LARK_COMMAND;
        L17:
            return POST;
        L19:
            return GET;
        }

        public static Method valueOf(String r1) {
            return (Method) r27.a.a(Method.class, r1);
        }

        private Method(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static class OpenUrl implements Serializable {
        private String androidUrl;
        private String iosUrl;
        private String pcUrl;
        private String url;

        public OpenUrl() {
        }

        public String getAndroidUrl() {
            return this.androidUrl;
        }

        public String getIosUrl() {
            return this.iosUrl;
        }

        public String getPcUrl() {
            return this.pcUrl;
        }

        public String getUrl() {
            return this.url;
        }

        public void setAndroidUrl(String r1) {
            this.androidUrl = r1;
        }

        public void setIosUrl(String r1) {
            this.iosUrl = r1;
        }

        public void setPcUrl(String r1) {
            this.pcUrl = r1;
        }

        public void setUrl(String r1) {
            this.url = r1;
        }
    }

    public static class Parameters implements Serializable {
        private String messageId;
        private MessageInfo messageInfo;
        private Map<String, String> parameters;
        private String userId;
        private UserInfo userInfo;

        public Parameters() {
        }

        public String getMessageId() {
            return this.messageId;
        }

        public MessageInfo getMessageInfo() {
            return this.messageInfo;
        }

        public Map<String, String> getParameters() {
            return this.parameters;
        }

        public String getUserId() {
            return this.userId;
        }

        public UserInfo getUserInfo() {
            return this.userInfo;
        }

        public void setMessageId(String r1) {
            this.messageId = r1;
        }

        public void setMessageInfo(MessageInfo r1) {
            this.messageInfo = r1;
        }

        public void setParameters(Map<String, String> r1) {
            this.parameters = r1;
        }

        public void setUserId(String r1) {
            this.userId = r1;
        }

        public void setUserInfo(UserInfo r1) {
            this.userInfo = r1;
        }
    }

    public static class RequiredParameters implements Serializable {
        private boolean needMessageId;
        private boolean needMessageInfo;
        private boolean needUserId;
        private boolean needUserInfo;

        public RequiredParameters() {
        }

        public boolean isNeedMessageId() {
            return this.needMessageId;
        }

        public boolean isNeedMessageInfo() {
            return this.needMessageInfo;
        }

        public boolean isNeedUserId() {
            return this.needUserId;
        }

        public boolean isNeedUserInfo() {
            return this.needUserInfo;
        }

        public void setNeedMessageId(boolean r1) {
            this.needMessageId = r1;
        }

        public void setNeedMessageInfo(boolean r1) {
            this.needMessageInfo = r1;
        }

        public void setNeedUserId(boolean r1) {
            this.needUserId = r1;
        }

        public void setNeedUserInfo(boolean r1) {
            this.needUserInfo = r1;
        }
    }

    public static class UserInfo implements Serializable {
        private String userOpenId;

        public UserInfo() {
        }

        public String getUserOpenId() {
            return this.userOpenId;
        }

        public void setUserOpenId(String r1) {
            this.userOpenId = r1;
        }
    }

    public CardAction() {
    }

    public int getCmd() {
        return this.cmd;
    }

    public Method getMethod() {
        return this.method;
    }

    public OpenUrl getOpenUrl() {
        return this.openUrl;
    }

    public CardActionPacket getPacket() {
        return this.packet;
    }

    public Parameters getParameters() {
        return this.parameters;
    }

    public RequiredParameters getRequiredParameters() {
        return this.requiredParameters;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCmd(int r1) {
        this.cmd = r1;
    }

    public void setMethod(Method r1) {
        this.method = r1;
    }

    public void setOpenUrl(OpenUrl r1) {
        this.openUrl = r1;
    }

    public void setPacket(CardActionPacket r1) {
        this.packet = r1;
    }

    public void setParameters(Parameters r1) {
        this.parameters = r1;
    }

    public void setRequiredParameters(RequiredParameters r1) {
        this.requiredParameters = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }
}
