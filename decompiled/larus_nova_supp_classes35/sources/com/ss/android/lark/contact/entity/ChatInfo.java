package com.ss.android.lark.contact.entity;

import com.ss.android.lark.chat.entity.chat.Chat;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatInfo implements Serializable {
    private static final long serialVersionUID = 6384386750016337646L;
    private Chat chat;
    private boolean isMember;
    private UserPermission userPermission;

    public static final enum UserPermission extends Enum<UserPermission> {
        public static final UserPermission INVISIBLE = null;
        public static final UserPermission UNKNOWN = null;
        public static final UserPermission VISIBLE_AND_CREATE = null;
        public static final UserPermission VISIBLE_NOT_CREATE = null;
        public static final /* synthetic */ UserPermission[] a = null;
        private int value;

        static {
            UserPermission r0 = new UserPermission("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            UserPermission r1 = new UserPermission("VISIBLE_AND_CREATE", 1, 1);
            VISIBLE_AND_CREATE = r1;
            UserPermission r3 = new UserPermission("VISIBLE_NOT_CREATE", 2, 2);
            VISIBLE_NOT_CREATE = r3;
            UserPermission r5 = new UserPermission("INVISIBLE", 3, 3);
            INVISIBLE = r5;
            a = new UserPermission[]{r0, r1, r3, r5};
        }

        public static UserPermission[] values() {
            return (UserPermission[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static UserPermission forNumber(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return UNKNOWN;
        L12:
            return INVISIBLE;
        L14:
            return VISIBLE_NOT_CREATE;
        L16:
            return VISIBLE_AND_CREATE;
        L18:
            return UNKNOWN;
        }

        public static UserPermission valueOf(String r1) {
            return (UserPermission) a.a(UserPermission.class, r1);
        }

        public static UserPermission valueOf(int r0) {
            return forNumber(r0);
        }

        public UserPermission(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public ChatInfo() {
    }

    public Chat getChat() {
        return this.chat;
    }

    public UserPermission getUserPermission() {
        return this.userPermission;
    }

    public boolean isMember() {
        return this.isMember;
    }

    public void setChat(Chat r1) {
        this.chat = r1;
    }

    public void setMember(boolean r1) {
        this.isMember = r1;
    }

    public void setUserPermission(UserPermission r1) {
        this.userPermission = r1;
    }
}
