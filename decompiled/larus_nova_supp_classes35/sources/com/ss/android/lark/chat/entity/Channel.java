package com.ss.android.lark.chat.entity;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Channel implements Serializable {
    private String id;
    private Type type;

    public static final enum Type extends Enum<Type> {
        public static final Type APP = null;
        public static final Type APP_FEED = null;
        public static final Type CHAT = null;
        public static final Type DOC = null;
        public static final Type EMAIL = null;
        public static final Type OPEN_APP_CHAT = null;
        public static final Type SUBSCRIPTION = null;
        public static final Type UNKNOWN = null;
        public static final /* synthetic */ Type[] a = null;
        private int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("CHAT", 1, 1);
            CHAT = r1;
            Type r3 = new Type("EMAIL", 2, 2);
            EMAIL = r3;
            Type r5 = new Type("DOC", 3, 3);
            DOC = r5;
            Type r7 = new Type("APP", 4, 4);
            APP = r7;
            Type r9 = new Type("OPEN_APP_CHAT", 5, 5);
            OPEN_APP_CHAT = r9;
            Type r11 = new Type("SUBSCRIPTION", 6, 10);
            SUBSCRIPTION = r11;
            Type r13 = new Type("APP_FEED", 7, 13);
            APP_FEED = r13;
            a = new Type[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r1) {
            if (r1 == 0) goto L34;
            if (r1 == 1) goto L32;
            if (r1 == 2) goto L30;
            if (r1 == 3) goto L28;
            if (r1 == 4) goto L26;
            if (r1 == 5) goto L24;
            if (r1 == 10) goto L22;
            if (r1 == 13) goto L20;
            return UNKNOWN;
        L20:
            return APP_FEED;
        L22:
            return SUBSCRIPTION;
        L24:
            return OPEN_APP_CHAT;
        L26:
            return APP;
        L28:
            return DOC;
        L30:
            return EMAIL;
        L32:
            return CHAT;
        L34:
            return UNKNOWN;
        }

        public static Type fromFeedType(int r1) {
            if (r1 == 1) goto L31;
            if (r1 == 2) goto L29;
            if (r1 == 3) goto L27;
            if (r1 == 6) goto L25;
            if (r1 == 8) goto L23;
            if (r1 == 10) goto L21;
            if (r1 == 13) goto L19;
            return UNKNOWN;
        L19:
            return APP_FEED;
        L21:
            return SUBSCRIPTION;
        L23:
            return OPEN_APP_CHAT;
        L25:
            return APP;
        L27:
            return DOC;
        L29:
            return EMAIL;
        L31:
            return CHAT;
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        public static Type valueOf(int r0) {
            return forNumber(r0);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public String toString() {
        return "Channel{id='" + this.id + "', type=" + this.type + '}';
    }

    public String getId() {
        return this.id;
    }

    public Type getType() {
        return this.type;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setType(Type r1) {
        this.type = r1;
    }

    public Channel(int r1, String r2) {
        this.type = Type.valueOf(r1);
        this.id = r2;
    }

    public Channel(Type r1, String r2) {
        this.type = r1;
        this.id = r2;
    }
}
