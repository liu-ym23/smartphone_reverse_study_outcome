package com.ss.android.lark.chat.export.entity.message.content;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class SystemMessageAction implements Serializable {
    private static final long serialVersionUID = -8206074036251753606L;
    private ActType actType;

    public static final enum ActType extends Enum<ActType> {
        public static final ActType INVITE_AT_CHATTERS = null;
        public static final ActType UNKNOWN_ACT_TYPE = null;
        public static final ActType URL = null;
        public static final /* synthetic */ ActType[] a = null;
        int value;

        static {
            ActType r0 = new ActType("UNKNOWN_ACT_TYPE", 0, 0);
            UNKNOWN_ACT_TYPE = r0;
            ActType r1 = new ActType("INVITE_AT_CHATTERS", 1, 1);
            INVITE_AT_CHATTERS = r1;
            ActType r3 = new ActType("URL", 2, 2);
            URL = r3;
            a = new ActType[]{r0, r1, r3};
        }

        public static ActType[] values() {
            return (ActType[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static ActType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return UNKNOWN_ACT_TYPE;
        L10:
            return URL;
        L12:
            return INVITE_AT_CHATTERS;
        L14:
            return UNKNOWN_ACT_TYPE;
        }

        public static ActType valueOf(String r1) {
            return (ActType) r27.a.a(ActType.class, r1);
        }

        public ActType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public ActType getActType() {
        return this.actType;
    }

    public SystemMessageAction(ActType r1) {
        this.actType = r1;
    }

    public void setActType(ActType r1) {
        this.actType = r1;
    }
}
