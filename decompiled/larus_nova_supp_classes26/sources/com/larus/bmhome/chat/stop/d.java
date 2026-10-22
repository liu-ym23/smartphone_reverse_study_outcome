package com.larus.bmhome.chat.stop;

import com.larus.im.bean.message.Message;
import ic8.j;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Message r5) {
        String r0 = null;
        if (r5 == null) goto L5;
        Map r1 = r5.getExt();
    L7:
        if (r5 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == true) goto L30;
        if (r1 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == true) goto L30;
        if (e(r5, 2) == true) goto L30;
        if (r1 == null) goto L23;
        r0 = (String) r1.get("doc_ref_block_info");
    L23:
        if (r0 != null) goto L25;
    L28:
        boolean r7 = true;
    L29:
        if (r7 == false) goto L30;
        return false;
    L25:
        if (StringsKt.isBlank(r0) == true) goto L28;
        r7 = false;
        goto L29
    L15:
        if (r1.containsKey("flow_ai_office_doc_version") != true) goto L17;
        r6 = true;
    L30:
        return true;
    L9:
        if (com.larus.im.bean.message.a.g0(r5) != true) goto L11;
        r4 = true;
        goto L12
    L5:
        r1 = null;
        goto L7
    }

    public static boolean b(Message r1) {
        if (r1 == null) goto L8;
        Map r2 = r1.getExt();
        if (r2 == null) goto L8;
        String r3 = (String) r2.get("action_bar_key");
        if (r3 == null) goto L8;
        String r4 = StringsKt.trim(r3).toString();
    L10:
        return Intrinsics.areEqual(r4, "coco_music_random_play");
    L8:
        r4 = null;
        goto L10
    }

    public static boolean c(Message r7) {
        String r0 = null;
        if (r7 == null) goto L5;
        Map r1 = r7.getExt();
    L7:
        if (r7 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == true) goto L35;
        if (r1 == null) goto L19;
        String r5 = (String) r1.get("chat_ability");
        if (r5 == null) goto L19;
        if (StringsKt.contains$default(r5, "5003", false, 2, null) != true) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L22;
        return true;
    L22:
        if (e(r7, 34) == true) goto L37;
        if (r1 == null) goto L25;
        r0 = (String) r1.get("office_sheet_ref_block_info");
    L25:
        if (r0 != null) goto L27;
    L30:
        boolean r8 = true;
    L31:
        if (r8 == false) goto L38;
        return false;
    L38:
        return true;
    L27:
        if (StringsKt.isBlank(r0) == true) goto L30;
        r8 = false;
        goto L31
    L37:
        return true;
    L19:
        r6 = false;
        goto L20
    L35:
        return true;
    L9:
        if (com.larus.im.bean.message.a.t0(r7) != true) goto L11;
        r4 = true;
        goto L12
    L5:
        r1 = null;
        goto L7
    }

    public static boolean d(Message r5) {
        String r0 = null;
        if (r5 == null) goto L5;
        Map r1 = r5.getExt();
    L7:
        if (r5 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == true) goto L44;
        if (r1 == null) goto L15;
        String r6 = (String) r1.get("is_slides_gen_message");
    L16:
        if (r6 != null) goto L18;
    L21:
        boolean r7 = true;
    L22:
        if (r7 == false) goto L44;
        if (r1 == null) goto L25;
        String r8 = (String) r1.get("slides_ability_param");
    L26:
        if (r8 != null) goto L28;
    L31:
        boolean r9 = true;
    L32:
        if (r9 == false) goto L44;
        if (e(r5, 30) == true) goto L44;
        if (r1 == null) goto L37;
        r0 = (String) r1.get("office_ref_block_info");
    L37:
        if (r0 != null) goto L39;
    L42:
        boolean r10 = true;
    L43:
        if (r10 == false) goto L44;
        return false;
    L39:
        if (StringsKt.isBlank(r0) == true) goto L42;
        r10 = false;
        goto L43
    L28:
        if (StringsKt.isBlank(r8) == true) goto L31;
        r9 = false;
        goto L32
    L25:
        r8 = null;
        goto L26
    L18:
        if (StringsKt.isBlank(r6) == true) goto L21;
        r7 = false;
        goto L22
    L15:
        r6 = null;
    L44:
        return true;
    L9:
        if (com.larus.im.bean.message.a.l0(r5) != true) goto L11;
        r4 = true;
        goto L12
    L5:
        r1 = null;
        goto L7
    }

    public static String f(Integer r2) {
        if (r2 != null) goto L5;
    L6:
        if (r2 != null) goto L9;
    L10:
        if (r2 != null) goto L13;
    L14:
        if (r2 != null) goto L17;
    L18:
        if (r2 != null) goto L21;
    L22:
        if (r2 != null) goto L25;
    L26:
        if (r2 != null) goto L29;
    L31:
        if (r2 != null) goto L34;
    L36:
        if (r2 != null) goto L39;
    L41:
        return null;
    L39:
        if (r2.intValue() != 12) goto L41;
        return "office_sheet";
    L34:
        if (r2.intValue() != 9) goto L36;
        return "office_slides";
    L29:
        if (r2.intValue() != 11) goto L31;
    L42:
        return "office_doc";
    L25:
        if (r2.intValue() == 6) goto L42;
    L21:
        if (r2.intValue() == 4) goto L42;
    L17:
        if (r2.intValue() == 3) goto L42;
    L13:
        if (r2.intValue() == 10) goto L42;
    L9:
        if (r2.intValue() == 2) goto L42;
    L5:
        if (r2.intValue() == 1) goto L42;
        goto L6
    }

    public static boolean e(Message r3, int r4) {
        if (r3 == null) goto L10;
        Integer r2 = j.b(r3);
        if (r2 == null) goto L10;
        if (r2.intValue() != r4) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == true) goto L25;
        if (r3 == null) goto L23;
        Map r6 = r3.getExt();
        if (r6 == null) goto L23;
        String r7 = (String) r6.get("action_bar_instruction_type");
        if (r7 == null) goto L23;
        Integer r8 = StringsKt.toIntOrNull(r7);
        if (r8 == null) goto L23;
        if (r8.intValue() != r4) goto L23;
        boolean r9 = true;
    L24:
        if (r9 == true) goto L25;
        return false;
    L23:
        r9 = false;
    L25:
        return true;
    L10:
        r5 = false;
        goto L11
    }
}
