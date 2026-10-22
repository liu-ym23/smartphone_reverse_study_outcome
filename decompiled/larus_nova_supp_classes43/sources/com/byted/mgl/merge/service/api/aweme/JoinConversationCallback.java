package com.byted.mgl.merge.service.api.aweme;

import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface JoinConversationCallback {
    public static final int INTERNAL_ERROR = 0;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type APPLY_FAIL = null;
        public static final Type GROUP_FULL = null;
        public static final Type INTERNAL_ERROR = null;
        public static final Type JUMP_FAIL = null;
        public static final Type NOT_AUTHENTICATE = null;
        public static final Type REQUEST_FAIL = null;

        static {
            Type r0 = new Type("INTERNAL_ERROR", 0);
            INTERNAL_ERROR = r0;
            Type r1 = new Type("GROUP_FULL", 1);
            GROUP_FULL = r1;
            Type r10 = new Type("REQUEST_FAIL", 2);
            REQUEST_FAIL = r10;
            Type r11 = new Type("NOT_AUTHENTICATE", 3);
            NOT_AUTHENTICATE = r11;
            Type r12 = new Type("JUMP_FAIL", 4);
            JUMP_FAIL = r12;
            Type r13 = new Type("APPLY_FAIL", 5);
            APPLY_FAIL = r13;
            $VALUES = new Type[]{r0, r1, r10, r11, r12, r13};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        private Type(String r1, int r10) {
            super(r1, r10);
        }
    }

    void onFail(JSONObject r1, Type r10);

    void onSuccess();
}
