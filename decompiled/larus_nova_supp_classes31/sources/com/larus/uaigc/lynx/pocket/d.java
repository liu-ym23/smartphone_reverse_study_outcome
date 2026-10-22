package com.larus.uaigc.lynx.pocket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static final Boolean a(Object r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof Boolean) == false) goto L9;
        return (Boolean) r2;
    L9:
        if ((r2 instanceof String) == false) goto L17;
        String r3 = ((String) r2).toLowerCase(Locale.ROOT);
        if (Intrinsics.areEqual(r3, "true") == false) goto L14;
        return Boolean.TRUE;
    L14:
        if (Intrinsics.areEqual(r3, "false") == true) goto L27;
        return null;
    L27:
        return Boolean.FALSE;
    L17:
        if ((r2 instanceof Number) == false) goto L28;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Number");
        if (((Number) r2).intValue() == 0) goto L21;
        boolean r4 = true;
    L23:
        return Boolean.valueOf(r4);
    L21:
        r4 = false;
        goto L23
    L28:
        return null;
    }

    public static final Integer b(Object r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof Integer) == false) goto L9;
        return (Integer) r2;
    L9:
        if ((r2 instanceof Number) == false) goto L12;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Number");
        return Integer.valueOf(((Number) r2).intValue());
    L12:
        if ((r2 instanceof String) == true) goto L14;
        return null;
    L14:
        return StringsKt.toIntOrNull((String) r2);
    }

    public static final Map<String, Object> c(Object r3) {
        if ((r3 instanceof Map) == false) goto L5;
        Map r4 = (Map) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r5 = r4.entrySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L17;
        Map.Entry r1 = (Map.Entry) r5.next();
        Object r2 = r1.getKey();
        Object r6 = r1.getValue();
        if (r2 == null) goto L10;
        String r7 = r2.toString();
        if (r7 == null) goto L10;
        r0.put(r7, r6);
        goto L10
    L17:
        return r0;
    L5:
        r4 = null;
        goto L6
    }

    public static final String d(Object r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof String) == false) goto L9;
        return (String) r2;
    L9:
        if ((r2 instanceof Number) == false) goto L12;
        return ((Number) r2).toString();
    L12:
        if ((r2 instanceof Boolean) == true) goto L14;
        return null;
    L14:
        return String.valueOf(((Boolean) r2).booleanValue());
    }

    public static final Pocket e(Map<String, ? extends Object> r31) {
        Intrinsics.checkNotNullParameter(r31, "<this>");
        Map<String, Object> r1 = c(r31.get("send_msg_pocket"));
        ArrayList r4 = null;
        if (r1 == null) goto L5;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        SendMsgPocket r18 = new SendMsgPocket(a(r2.get("allow_photos")), b(r2.get("selected_photos_count")), d(r2.get("selected_model")), d(r2.get("preset_image_url")), d(r2.get("preset_image_uri")));
    L6:
        Map<String, Object> r3 = c(r31.get("keyboard_input_pocket"));
        if (r3 == null) goto L9;
        LinkedHashMap r5 = (LinkedHashMap) r3;
        KeyboardInputPocket r19 = new KeyboardInputPocket(d(r5.get("input_box_title")), d(r5.get("input_placeholder")), d(r5.get("input_placeholder_prompt")), d(r5.get("input_placeholder_prompt_for_model")), d(r5.get("selected_model")));
    L10:
        Map<String, Object> r6 = c(r31.get("upload_input_pocket"));
        if (r6 == null) goto L13;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        UploadInputPocket r20 = new UploadInputPocket(d(r7.get("input_box_title")), d(r7.get("input_placeholder")), d(r7.get("input_placeholder_prompt")), a(r7.get("must_photos")), b(r7.get("selected_photos_count")), d(r7.get("pre_set_photo_url")), d(r7.get("pre_set_photo_uri")), d(r7.get("selected_model")));
    L14:
        Map<String, Object> r8 = c(r31.get("jump_somewhere_pocket"));
        if (r8 == null) goto L30;
        LinkedHashMap r9 = (LinkedHashMap) r8;
        String r10 = d(r9.get("jump_schema_url"));
        String r11 = "";
        if (r10 != null) goto L19;
        r10 = "";
    L19:
        String r12 = d(r9.get("jump_instruction_id"));
        if (r12 != null) goto L22;
        r12 = "";
    L22:
        String r13 = d(r9.get("insert_prompt"));
        if (r13 != null) goto L25;
        r13 = "";
    L25:
        String r14 = d(r9.get("selected_model"));
        if (r14 == null) goto L29;
        r11 = r14;
    L29:
        JumpSomewherePocket r21 = new JumpSomewherePocket(r10, r12, r13, r11);
    L31:
        Map<String, Object> r15 = c(r31.get("supported_systems_and_versions"));
        if (r15 == null) goto L52;
        Object r16 = ((LinkedHashMap) r15).get("os_version");
        if ((r16 instanceof List) == false) goto L36;
        List r17 = (List) r16;
    L37:
        if (r17 != null) goto L39;
        ArrayList r22 = null;
    L46:
        if (r22 == null) goto L51;
        r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r23 = r22.iterator();
    L49:
        if (r23.hasNext() == false) goto L51;
        Map r24 = (Map) r23.next();
        r4.add(new OSVersion(b(r24.get("sys_type")), a(r24.get("is_support")), d(r24.get("lowest_version_code")), d(r24.get("highest_version_code"))));
    L51:
        SupportedOSAndVersion r25 = new SupportedOSAndVersion(r4);
    L54:
        return new Pocket(d(r31.get("pocket_id")), d(r31.get("config_name")), d(r31.get("icon_url")), d(r31.get("prompt")), b(r31.get("pocket_type")), r18, r19, r20, r21, b(r31.get("intention_type")), b(r31.get("status")), r25, d(r31.get("ext")), null, null, null, 57344, null);
    L39:
        r22 = new ArrayList();
        Iterator r26 = r17.iterator();
    L41:
        if (r26.hasNext() == false) goto L46;
        Map<String, Object> r27 = c(r26.next());
        if (r27 == null) goto L41;
        r22.add(r27);
        goto L41
    L36:
        r17 = null;
        goto L37
    L52:
        r25 = null;
        goto L54
    L30:
        r21 = null;
        goto L31
    L13:
        r20 = null;
        goto L14
    L9:
        r19 = null;
        goto L10
    L5:
        r18 = null;
        goto L6
    }
}
