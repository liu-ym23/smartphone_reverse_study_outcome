package com.ss.android.lark.message.action.model;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ActionMessage {
    public String a;
    public Type b;

    public static final enum Type extends Enum<Type> {
        public static final Type FILE = null;
        public static final Type IMAGE = null;
        public static final Type MEDIA = null;
        public static final Type OTHERS = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r0 = new Type("FILE", 0);
            FILE = r0;
            Type r1 = new Type("IMAGE", 1);
            IMAGE = r1;
            Type r3 = new Type("MEDIA", 2);
            MEDIA = r3;
            Type r5 = new Type("OTHERS", 3);
            OTHERS = r5;
            a = new Type[]{r0, r1, r3, r5};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    public ActionMessage() {
    }

    public String getMessageId() {
        return this.a;
    }

    public Type getMessageType() {
        return this.b;
    }

    public void setMessageId(String r1) {
        this.a = r1;
    }

    public void setMessageType(Type r1) {
        this.b = r1;
    }
}
