package com.suite.lark.platform.component.widget_biz_billingtips;

import com.ss.android.lark.statistics.Statistics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class BillingTipsDialog {
    public static Boolean a;

    public static final enum Type extends Enum<Type> {
        public static final Type BUZZ_LIMIT_ADMIN = null;
        public static final Type BUZZ_LIMIT_USER = null;
        public static final Type CHAT_ADD_MEM_NUMBER_LIMIT = null;
        public static final Type CHAT_CREATE_EXTERNEL_GROUP_NUMBER_LIMIT = null;
        public static final Type CHAT_CREATE_GROUP_NUMBER_LIMIT = null;
        public static final Type CHAT_JOIN_EXTERNEL_GROUP_NUMBER_LIMIT = null;
        public static final Type CHAT_JOIN_GROUP_NUMBER_LIMIT = null;
        public static final Type UNKNOWN = null;
        public static final /* synthetic */ Type[] a = null;
        final int defaultTipsRes;
        final int leftBtnRes;
        final String reportType;
        final int rightBtnRes;
        final int value;

        static {
            Type r8 = new Type("UNKNOWN", 0, -1, 2131892298, 2131890756, 2131890831, "");
            UNKNOWN = r8;
            Type r0 = new Type("CHAT_ADD_MEM_NUMBER_LIMIT", 1, 1, 2131890832, 2131890756, 2131890831, "chat_number_limit");
            CHAT_ADD_MEM_NUMBER_LIMIT = r0;
            Type r1 = new Type("CHAT_CREATE_GROUP_NUMBER_LIMIT", 2, 2, 2131890833, 2131890756, 2131890831, "chat_number_limit");
            CHAT_CREATE_GROUP_NUMBER_LIMIT = r1;
            Type r2 = new Type("CHAT_JOIN_GROUP_NUMBER_LIMIT", 3, 3, 2131890834, 2131890756, 2131890831, "chat_number_limit");
            CHAT_JOIN_GROUP_NUMBER_LIMIT = r2;
            Type r3 = new Type("CHAT_CREATE_EXTERNEL_GROUP_NUMBER_LIMIT", 4, 4, 2131890828, 2131890756, 2131890831, "chat_number_limit");
            CHAT_CREATE_EXTERNEL_GROUP_NUMBER_LIMIT = r3;
            Type r4 = new Type("CHAT_JOIN_EXTERNEL_GROUP_NUMBER_LIMIT", 5, 5, 2131890829, 2131890756, 2131890831, "chat_number_limit");
            CHAT_JOIN_EXTERNEL_GROUP_NUMBER_LIMIT = r4;
            Type r5 = new Type("BUZZ_LIMIT_ADMIN", 6, 6, 2131890309, 2131890312, 2131890311, "buzz_limit");
            BUZZ_LIMIT_ADMIN = r5;
            Type r6 = new Type("BUZZ_LIMIT_USER", 7, 7, 2131890308, -1, 2131891840, "buzz_limit");
            BUZZ_LIMIT_USER = r6;
            a = new Type[]{r8, r0, r1, r2, r3, r4, r5, r6};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r0) {
            switch(r0) {
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
            return BUZZ_LIMIT_USER;
        L8:
            return BUZZ_LIMIT_ADMIN;
        L10:
            return CHAT_JOIN_EXTERNEL_GROUP_NUMBER_LIMIT;
        L12:
            return CHAT_CREATE_EXTERNEL_GROUP_NUMBER_LIMIT;
        L14:
            return CHAT_JOIN_GROUP_NUMBER_LIMIT;
        L16:
            return CHAT_CREATE_GROUP_NUMBER_LIMIT;
        L18:
            return CHAT_ADD_MEM_NUMBER_LIMIT;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public static Type valueOf(int r0) {
            return forNumber(r0);
        }

        public Type(String r1, int r2, int r3, int r4, int r5, int r6, String r7) {
            super(r1, r2);
            this.value = r3;
            this.defaultTipsRes = r4;
            this.leftBtnRes = r5;
            this.rightBtnRes = r6;
            this.reportType = r7;
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Type.values().length];
            a = r0;
            r0[Type.BUZZ_LIMIT_ADMIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[Type.CHAT_CREATE_GROUP_NUMBER_LIMIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[Type.CHAT_JOIN_GROUP_NUMBER_LIMIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[Type.CHAT_ADD_MEM_NUMBER_LIMIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[Type.CHAT_CREATE_EXTERNEL_GROUP_NUMBER_LIMIT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[Type.CHAT_JOIN_EXTERNEL_GROUP_NUMBER_LIMIT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static void a(Type r2) {
        JSONObject r0 = new JSONObject();
        r0.put("function_type", r2.reportType);     // Catch: JSONException -> L5
        r0.put("admin_flag", a);     // Catch: JSONException -> L5
    L7:
        Statistics.sendEvent("common_pricing_popup_click", r0);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void b(Type r2) {
        JSONObject r0 = new JSONObject();
        r0.put("function_type", r2.reportType);     // Catch: JSONException -> L5
        r0.put("admin_flag", a);     // Catch: JSONException -> L5
    L7:
        Statistics.sendEvent("common_pricing_popup_view", r0);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
