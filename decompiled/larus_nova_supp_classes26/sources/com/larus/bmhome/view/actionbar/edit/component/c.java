package com.larus.bmhome.view.actionbar.edit.component;

import com.larus.bmhome.chat.trace.ReeditType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String c(Integer r2) {
        if (r2 != null) goto L5;
    L6:
        if (r2 != null) goto L9;
    L11:
        if (r2 != null) goto L14;
    L15:
        if (r2 != null) goto L18;
    L19:
        if (r2 != null) goto L22;
    L23:
        if (r2 != null) goto L26;
    L27:
        if (r2 != null) goto L30;
    L32:
        return null;
    L30:
        if (r2.intValue() != 8) goto L32;
    L33:
        return "video";
    L26:
        if (r2.intValue() == 7) goto L33;
    L22:
        if (r2.intValue() == 6) goto L33;
    L18:
        if (r2.intValue() == 5) goto L33;
    L14:
        if (r2.intValue() == 1) goto L33;
    L9:
        if (r2.intValue() != 30) goto L11;
    L34:
        return ReeditType.IMAGE;
    L5:
        if (r2.intValue() == 2) goto L34;
        goto L6
    }

    public static JSONObject f(String r2) {
        JSONObject r0 = new JSONObject();
        if (r2 == null) goto L5;
        r0.put("ai_generate_board_tab_type", r2);
    L5:
        return r0;
    }

    public static Integer b(com.larus.bmhome.actionbar.model.j r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r4, "duration");
        if (r5 == null) goto L24;
        int r6 = r5.intValue();
        Integer r1 = r4.d;
        if (r1 == null) goto L24;
        int r2 = r1.intValue();
        Integer r7 = r4.f;
        if (r7 == null) goto L9;
        int r8 = r7.intValue();
    L10:
        Integer r9 = Integer.valueOf(r8);
        if (r9.intValue() <= 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L17;
        r9 = null;
    L17:
        if (r9 == null) goto L19;
        int r10 = r9.intValue();
    L20:
        if (r6 >= r2) goto L23;
        return null;
    L23:
        return Integer.valueOf(((r6 - r2) / r10) + 1);
    L19:
        r10 = 1;
        goto L20
    L13:
        r3 = false;
        goto L14
    L9:
        r8 = 1;
    L24:
        return null;
    }

    public static String a(Integer r5, Integer r6, com.larus.bmhome.actionbar.model.h r7) {
        Integer r0 = null;
        if (r5 != null) goto L6;
    L20:
        if (r5 != null) goto L23;
    L24:
        if (r5 != null) goto L27;
    L29:
        if (r5 != null) goto L32;
    L33:
        if (r5 != null) goto L36;
    L38:
        if (r7 == null) goto L45;
        r0 = r7.b;
    L45:
        return c(r0);
    L36:
        if (r5.intValue() != 24) goto L38;
    L41:
        return "video";
    L32:
        if (r5.intValue() == 18) goto L41;
    L27:
        if (r5.intValue() != 4) goto L29;
    L42:
        return ReeditType.IMAGE;
    L23:
        if (r5.intValue() == 16) goto L42;
    L6:
        if (r5.intValue() != 28) goto L20;
        if (r6 != null) goto L10;
    L12:
        if (r6 != null) goto L15;
    L17:
        if (r7 == null) goto L44;
        r0 = r7.b;
    L44:
        return c(r0);
    L15:
        if (r6.intValue() != 18) goto L17;
    L10:
        if (r6.intValue() != 4) goto L12;
        goto L12
    }

    public static int d(com.larus.bmhome.actionbar.model.h r8, com.larus.bmhome.actionbar.model.w r9, int r10) {
        if (r8 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r8.h, Boolean.TRUE);
    L6:
        if (r1 == false) goto L8;
        return 0;
    L8:
        Long r2 = null;
        if (r8 == null) goto L11;
        Long r3 = r8.g;
    L12:
        if (r3 != null) goto L14;
    L19:
        if (r8 == null) goto L27;
        Integer r11 = r8.f;
        if (r11 != null) goto L24;
        return 0;
    L24:
        if (r11.intValue() != r10) goto L28;
        return 1;
    L28:
        return 0;
    L27:
        return 0;
    L14:
        if (r3.longValue() < 0) goto L19;
        if (r9 == null) goto L18;
        r2 = r9.a;
    L18:
        return Intrinsics.areEqual(r2, r3) ? 1 : 0;
    L11:
        r3 = null;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public static String e(Integer r0, Integer r1, com.larus.bmhome.actionbar.model.h r2, com.larus.bmhome.actionbar.model.w r3) {
        if (a(r0, r1, r2) == null) goto L11;
        if (r3 == null) goto L26;
        String r4 = r3.e;
        if (r4 != null) goto L8;
        return null;
    L8:
        if ((!StringsKt.isBlank(r4)) == true) goto L10;
        return null;
    L10:
        return r4;
    L26:
        return null;
    L11:
        if (r3 == null) goto L19;
        String r5 = r3.t;
        if (r5 == null) goto L19;
        if ((!StringsKt.isBlank(r5)) == true) goto L18;
        r5 = null;
    L18:
        if (r5 == null) goto L19;
    L25:
        return r5;
    L19:
        if (r3 == null) goto L29;
        r5 = r3.b;
        if (r5 != null) goto L23;
        return null;
    L23:
        if ((!StringsKt.isBlank(r5)) == true) goto L25;
        return null;
    L29:
        return null;
    }
}
