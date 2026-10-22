package com.ss.android.lark.contact.base.dto;

import com.bytedance.lark.pb.basic.v1.CertificationInfo;
import com.ss.android.lark.contact.base.entity.ExternalContactSummary;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatApplication implements Serializable {
    private long applyTime;
    private CertificationInfo certificationInfo;
    private String chatId;
    private ExternalContactSummary externalContactSummary;
    private String extraMessage;
    private String id;
    private boolean isRead;
    private long processedTime;
    private Status status;
    private Type type;

    public static final enum Status extends Enum<Status> {
        public static final Status AGREED = null;
        public static final Status DELETED = null;
        public static final Status EXPIRED = null;
        public static final Status PEDING = null;
        public static final Status REFUSED = null;
        public static final Status UNKNOWN_STATUS = null;
        public static final /* synthetic */ Status[] a = null;
        private int value;

        static {
            Status r0 = new Status("UNKNOWN_STATUS", 0, 0);
            UNKNOWN_STATUS = r0;
            Status r1 = new Status("PEDING", 1, 1);
            PEDING = r1;
            Status r3 = new Status("AGREED", 2, 2);
            AGREED = r3;
            Status r5 = new Status("REFUSED", 3, 3);
            REFUSED = r5;
            Status r7 = new Status("DELETED", 4, 4);
            DELETED = r7;
            Status r9 = new Status("EXPIRED", 5, 5);
            EXPIRED = r9;
            a = new Status[]{r0, r1, r3, r5, r7, r9};
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Status forNumber(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return null;
        L16:
            return EXPIRED;
        L18:
            return DELETED;
        L20:
            return REFUSED;
        L22:
            return AGREED;
        L24:
            return PEDING;
        L26:
            return UNKNOWN_STATUS;
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public static Status valueOf(int r0) {
            return forNumber(r0);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type FRIEND = null;
        public static final Type JOIN_CHAT = null;
        public static final Type UNKNOWN_TYPE = null;
        public static final /* synthetic */ Type[] a = null;
        private int value;

        static {
            Type r0 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r0;
            Type r1 = new Type("FRIEND", 1, 1);
            FRIEND = r1;
            Type r3 = new Type("JOIN_CHAT", 2, 2);
            JOIN_CHAT = r3;
            a = new Type[]{r0, r1, r3};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return JOIN_CHAT;
        L12:
            return FRIEND;
        L14:
            return UNKNOWN_TYPE;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public static Type valueOf(int r0) {
            return forNumber(r0);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public ChatApplication() {
    }

    public long getApplyTime() {
        return this.applyTime;
    }

    public CertificationInfo getCertificationInfo() {
        return this.certificationInfo;
    }

    public String getChatId() {
        return this.chatId;
    }

    public ExternalContactSummary getExternalContactSummary() {
        return this.externalContactSummary;
    }

    public String getExtraMessage() {
        return this.extraMessage;
    }

    public String getId() {
        return this.id;
    }

    public long getProcessedTime() {
        return this.processedTime;
    }

    public Status getStatus() {
        return this.status;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isRead() {
        return this.isRead;
    }

    public void setApplyTime(long r1) {
        this.applyTime = r1;
    }

    public void setCertificationInfo(CertificationInfo r1) {
        this.certificationInfo = r1;
    }

    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public void setExternalContactSummary(ExternalContactSummary r1) {
        this.externalContactSummary = r1;
    }

    public void setExtraMessage(String r1) {
        this.extraMessage = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setProcessedTime(long r1) {
        this.processedTime = r1;
    }

    public void setRead(boolean r1) {
        this.isRead = r1;
    }

    public void setStatus(Status r1) {
        this.status = r1;
    }

    public void setType(Type r1) {
        this.type = r1;
    }
}
