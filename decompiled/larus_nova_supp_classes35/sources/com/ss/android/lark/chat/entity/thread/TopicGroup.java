package com.ss.android.lark.chat.entity.thread;

import com.ss.android.lark.chat.entity.chat.Chat;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TopicGroup implements Serializable {
    private Chat chat;
    private String id;
    private Type type;
    private UserSetting userSetting;

    public static final enum TopicGroupRole extends Enum<TopicGroupRole> {
        public static final TopicGroupRole MEMBER = null;
        public static final TopicGroupRole PARTICIPANT = null;
        public static final TopicGroupRole UNAUTHORIZED_USER = null;
        public static final TopicGroupRole UNKNOWN_ROLE = null;
        public static final /* synthetic */ TopicGroupRole[] a = null;
        private int value;

        static {
            TopicGroupRole r0 = new TopicGroupRole("UNKNOWN_ROLE", 0, 0);
            UNKNOWN_ROLE = r0;
            TopicGroupRole r1 = new TopicGroupRole("UNAUTHORIZED_USER", 1, 1);
            UNAUTHORIZED_USER = r1;
            TopicGroupRole r3 = new TopicGroupRole("MEMBER", 2, 2);
            MEMBER = r3;
            TopicGroupRole r5 = new TopicGroupRole("PARTICIPANT", 3, 3);
            PARTICIPANT = r5;
            a = new TopicGroupRole[]{r0, r1, r3, r5};
        }

        public static TopicGroupRole[] values() {
            return (TopicGroupRole[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static TopicGroupRole fromValue(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return UNKNOWN_ROLE;
        L11:
            return PARTICIPANT;
        L13:
            return MEMBER;
        L15:
            return UNAUTHORIZED_USER;
        }

        public static TopicGroupRole valueOf(String r1) {
            return (TopicGroupRole) a.a(TopicGroupRole.class, r1);
        }

        public static TopicGroupRole valueOf(int r0) {
            return fromValue(r0);
        }

        public TopicGroupRole(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type DEFAULT = null;
        public static final Type NORMAL = null;
        public static final Type UNKNOWN_TYPE = null;
        public static final /* synthetic */ Type[] a = null;
        private int value;

        static {
            Type r0 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r0;
            Type r1 = new Type("NORMAL", 1, 1);
            NORMAL = r1;
            Type r3 = new Type("DEFAULT", 2, 2);
            DEFAULT = r3;
            a = new Type[]{r0, r1, r3};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type fromValue(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return UNKNOWN_TYPE;
        L9:
            return DEFAULT;
        L11:
            return NORMAL;
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        public static Type valueOf(int r0) {
            return fromValue(r0);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static class UserSetting implements Serializable {
        private boolean isFavorite;
        private TopicGroupRole topicGroupRole;
        private long updateTime;

        public UserSetting() {
        }

        public TopicGroupRole getTopicGroupRole() {
            return this.topicGroupRole;
        }

        public long getUpdateTime() {
            return this.updateTime;
        }

        public boolean isFavorite() {
            return this.isFavorite;
        }

        public static /* synthetic */ boolean access$000(UserSetting r0) {
            return r0.isFavorite;
        }

        public static /* synthetic */ long access$100(UserSetting r2) {
            return r2.updateTime;
        }

        public void setFavorite(boolean r1) {
            this.isFavorite = r1;
        }

        public void setTopicGroupRole(TopicGroupRole r1) {
            this.topicGroupRole = r1;
        }

        public void setUpdateTime(long r1) {
            this.updateTime = r1;
        }
    }

    public TopicGroup() {
    }

    public String toString() {
        if (this.userSetting == null) goto L7;
        return "TopicGroup{id='" + this.id + "', type=" + this.type + ", role =" + this.userSetting.getTopicGroupRole() + ", isFavorite =" + UserSetting.access$000(this.userSetting) + ", updateTime=" + UserSetting.access$100(this.userSetting) + '}';
    L7:
        return "TopicGroup{id='" + this.id + "', type=" + this.type + ", usersetting =null}";
    }

    public Chat getChat() {
        return this.chat;
    }

    public String getId() {
        return this.id;
    }

    public Type getType() {
        return this.type;
    }

    public UserSetting getUserSetting() {
        return this.userSetting;
    }

    public void setChat(Chat r1) {
        this.chat = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setType(Type r1) {
        this.type = r1;
    }

    public void setUserSetting(UserSetting r1) {
        this.userSetting = r1;
    }
}
