package com.ss.android.lark.doc.entity;

import com.ss.android.lark.chameleon.error.DocErrorCode;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DocPermPair implements Serializable {
    private String docToken;
    private String messageId;
    private PermType perm;

    public static final enum PermType extends Enum<PermType> {
        public static final PermType EDIT = null;
        public static final PermType FORBIDDEN = null;
        public static final PermType READ = null;
        public static final PermType UNKNOWN = null;
        public static final /* synthetic */ PermType[] a = null;
        private int value;

        static {
            PermType r0 = new PermType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            PermType r1 = new PermType("READ", 1, 1);
            READ = r1;
            PermType r3 = new PermType("EDIT", 2, 4);
            EDIT = r3;
            PermType r5 = new PermType("FORBIDDEN", 3, DocErrorCode.ERRCODE_RENDERING_NOT_READY);
            FORBIDDEN = r5;
            a = new PermType[]{r0, r1, r3, r5};
        }

        public static PermType[] values() {
            return (PermType[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static PermType forNumber(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 4) goto L14;
            if (r1 == 501) goto L12;
            return UNKNOWN;
        L12:
            return FORBIDDEN;
        L14:
            return EDIT;
        L16:
            return READ;
        L18:
            return UNKNOWN;
        }

        public static PermType valueOf(String r1) {
            return (PermType) a.a(PermType.class, r1);
        }

        public static PermType valueOf(int r0) {
            return forNumber(r0);
        }

        public PermType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public String getDocToken() {
        return this.docToken;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public PermType getPerm() {
        return this.perm;
    }

    public void setDocToken(String r1) {
        this.docToken = r1;
    }

    public void setMessageId(String r1) {
        this.messageId = r1;
    }

    public void setPerm(PermType r1) {
        this.perm = r1;
    }

    public DocPermPair(String r1, String r2, PermType r3) {
        this.messageId = r1;
        this.docToken = r2;
        this.perm = r3;
    }
}
