package com.bytedance.android.live.effect.utils;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LivePresetsLogger {
    public static Long a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/effect/utils/LivePresetsLogger$BtnType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SAVE", "DELETE", "SELECT", "EDIT", "RESET", "CONFIRM", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum BtnType extends Enum<BtnType> {
        public static final BtnType CONFIRM = null;
        public static final BtnType DELETE = null;
        public static final BtnType EDIT = null;
        public static final BtnType RESET = null;
        public static final BtnType SAVE = null;
        public static final BtnType SELECT = null;
        public static final /* synthetic */ BtnType[] a = null;
        private final String value;

        static {
            BtnType r1 = new BtnType("SAVE", 0, "save");
            SAVE = r1;
            BtnType r2 = new BtnType("DELETE", 1, "delete");
            DELETE = r2;
            BtnType r3 = new BtnType("SELECT", 2, "select");
            SELECT = r3;
            BtnType r4 = new BtnType("EDIT", 3, "edit");
            EDIT = r4;
            BtnType r5 = new BtnType("RESET", 4, "reset");
            RESET = r5;
            BtnType r6 = new BtnType("CONFIRM", 5, "confirm");
            CONFIRM = r6;
            a = new BtnType[]{r1, r2, r3, r4, r5, r6};
        }

        public static BtnType valueOf(String r1) {
            return (BtnType) r27.a.a(BtnType.class, r1);
        }

        public static BtnType[] values() {
            return (BtnType[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public BtnType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public LivePresetsLogger() {
    }

    static {
    }

    public static void c(int r4) {
        Long r0 = a;
        if (r0 == null) goto L6;
        long r1 = r0.longValue();
        int r2 = (int) ((System.currentTimeMillis() - r1) / ((long) 1000));
        HashMap r3 = new HashMap();
        r3.put("title_num", String.valueOf(r4));
        r3.put("duration", String.valueOf(r2));
        c.a("livesdk_anchor_presets_leave", r3, "");
        a = null;
        return;
    }

    public static void b(String r2, BtnType r3) {
        Intrinsics.checkNotNullParameter(r2, "tabName");
        Intrinsics.checkNotNullParameter(r3, "btnType");
        HashMap r0 = new HashMap();
        r0.put("tab_name", r2);
        r0.put("btn_type", r3.getValue());
        c.a("livesdk_anchor_beautify_detail_reset_click", r0, "");
    }

    public static void a(String r3, String r4, BtnType r5, String r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 8) == 0) goto L8;
        r6 = "0";
    L8:
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "desc");
        Intrinsics.checkNotNullParameter(r6, "isDefaultValue");
        HashMap r1 = new HashMap();
        r1.put("is_default_value", r6);
        r1.put("title", r3);
        r1.put("desc", r4);
        if (r5 == null) goto L12;
        String r8 = r5.getValue();
        if (r8 == null) goto L12;
    L13:
        r1.put("btn_type", r8);
        c.a("livesdk_anchor_presets_select", r1, "");
        return;
    L12:
        r8 = "";
        goto L13
    }
}
