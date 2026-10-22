package com.ss.android.lark.doc.entity;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DocMessage implements Serializable {
    private String content;
    private long createTime;
    private String docFeedId;
    private String fromId;
    private String fromName;
    private String id;
    private Type type;
    private long updateTime;

    public static final enum Type extends Enum<Type> {
        public static final Type COMMENT = null;
        public static final Type MENTION = null;
        public static final Type REACTION = null;
        public static final Type REOPEN = null;
        public static final Type REPLY = null;
        public static final Type SHARE = null;
        public static final Type SOLVE = null;
        public static final Type UNKNOWN = null;
        public static final /* synthetic */ Type[] a = null;
        private int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("MENTION", 1, 1);
            MENTION = r1;
            Type r3 = new Type("COMMENT", 2, 2);
            COMMENT = r3;
            Type r5 = new Type("REPLY", 3, 3);
            REPLY = r5;
            Type r7 = new Type("SOLVE", 4, 4);
            SOLVE = r7;
            Type r9 = new Type("SHARE", 5, 5);
            SHARE = r9;
            Type r11 = new Type("REOPEN", 6, 6);
            REOPEN = r11;
            Type r13 = new Type("REACTION", 7, 7);
            REACTION = r13;
            a = new Type[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r0) {
            switch(r0) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L4;
            };
        L4:
            return UNKNOWN;
        L6:
            return REACTION;
        L8:
            return REOPEN;
        L10:
            return SHARE;
        L12:
            return SOLVE;
        L14:
            return REPLY;
        L16:
            return COMMENT;
        L18:
            return MENTION;
        L20:
            return UNKNOWN;
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

    public DocMessage() {
    }

    public String getContent() {
        return this.content;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getDocFeedId() {
        return this.docFeedId;
    }

    public String getFromId() {
        return this.fromId;
    }

    public String getFromName() {
        return this.fromName;
    }

    public String getId() {
        return this.id;
    }

    public Type getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this != r5) goto L9;
        return true;
    L9:
        if ((r5 instanceof DocMessage) == true) goto L11;
        return false;
    L11:
        DocMessage r6 = (DocMessage) r5;
        String r2 = this.id;
        if (r2 == null) goto L14;
        boolean r3 = r2.equals(r6.getId());
    L18:
        if (r3 == true) goto L20;
        return false;
    L20:
        Type r4 = this.type;
        if (r4 == null) goto L23;
        boolean r7 = r4.equals(r6.getType());
    L27:
        if (r7 == true) goto L29;
        return false;
    L29:
        String r8 = this.docFeedId;
        String r9 = r6.getDocFeedId();
        if (r8 != null) goto L34;
        if (r9 != null) goto L35;
        return true;
    L35:
        return false;
    L34:
        return r8.equals(r9);
    L23:
        if (r6.getType() != null) goto L25;
        r7 = true;
        goto L27
    L25:
        r7 = false;
        goto L27
    L14:
        if (r6.getId() != null) goto L16;
        r3 = true;
        goto L18
    L16:
        r3 = false;
        goto L18
    }

    public boolean exactlyCompare(DocMessage r1) {
        return equals(r1);
    }

    public void setContent(String r1) {
        this.content = r1;
    }

    public void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public void setDocFeedId(String r1) {
        this.docFeedId = r1;
    }

    public void setFromId(String r1) {
        this.fromId = r1;
    }

    public void setFromName(String r1) {
        this.fromName = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setType(Type r1) {
        this.type = r1;
    }

    public void setUpdateTime(long r1) {
        this.updateTime = r1;
    }
}
