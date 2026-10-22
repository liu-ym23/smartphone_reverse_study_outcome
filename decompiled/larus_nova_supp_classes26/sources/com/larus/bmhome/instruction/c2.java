package com.larus.bmhome.instruction;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c2 implements j {
    public static final c2 a = null;

    static {
        a = new c2();
    }

    public c2() {
    }

    public static com.larus.bmhome.actionbar.model.h1 g(com.larus.bmhome.actionbar.model.h1 r3, String r4) {
        String r0 = r3.c;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L18;
        if (r4 != null) goto L12;
    L15:
        if (r1 == false) goto L17;
        return r3;
    L17:
        return com.larus.bmhome.actionbar.model.h1.a(r3, null, r4, 1019);
    L12:
        if (r4.length() == 0) goto L15;
        r1 = false;
        goto L15
    L18:
        return r3;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static com.larus.bmhome.actionbar.model.h1 h(com.larus.bmhome.actionbar.model.h1 r8, String r9) {
        if (r8 == null) goto L5;
        String r3 = r8.c;
    L6:
        if (r8 == null) goto L8;
        String r4 = r8.h;
    L9:
        if (r8 == null) goto L11;
        String r5 = r8.j;
    L13:
        return new com.larus.bmhome.actionbar.model.h1(null, r9, r3, r4, r5, 377);
    L11:
        r5 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.j
    public final com.larus.bmhome.actionbar.model.r a(Integer r28, String r29, List<com.larus.bmhome.actionbar.model.u> r30, com.larus.bmhome.actionbar.model.r r31, int r32) {
        if (r28 == null) goto L9;
        if (r28.intValue() != 0) goto L9;
        return null;
    L9:
        if (r28 == null) goto L62;
        if (r28.intValue() != 28) goto L62;
        com.larus.bmhome.actionbar.model.y r8 = new com.larus.bmhome.actionbar.model.y(0);
        if (r31 == null) goto L45;
        com.larus.bmhome.actionbar.model.y r4 = r31.i;
        if (r4 == null) goto L45;
        ArrayList r5 = r4.a;
        if (r5 == null) goto L45;
        com.larus.bmhome.actionbar.model.z0 r6 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.getOrNull(r5, r32);
        if (r6 == null) goto L45;
        com.larus.bmhome.actionbar.model.r r9 = r6.q;
        if (r9 == null) goto L26;
        com.larus.bmhome.actionbar.model.h1 r7 = r9.c;
        if (r7 == null) goto L26;
        String r10 = r7.c;
    L28:
        if (r9 == null) goto L30;
        com.larus.bmhome.actionbar.model.r r21 = com.larus.bmhome.actionbar.model.r.a(r9, null, null, null, null, 4095);
    L31:
        com.larus.bmhome.actionbar.model.z0 r11 = com.larus.bmhome.actionbar.model.z0.a(r6, null, null, null, null, null, null, null, null, r21, null, null, null, false, -65537);
        com.larus.bmhome.actionbar.model.r r12 = r11.q;
        if (r12 == null) goto L34;
        r12.b = r30;
    L34:
        if (r12 == null) goto L42;
        com.larus.bmhome.actionbar.model.r r13 = r6.q;
        if (r13 == null) goto L40;
        com.larus.bmhome.actionbar.model.h1 r14 = r13.c;
        if (r14 == null) goto L40;
        com.larus.bmhome.actionbar.model.h1 r15 = com.larus.bmhome.actionbar.model.h1.a(r14, r29, null, 1021);
    L41:
        r12.c = r15;
    L40:
        r15 = null;
    L42:
        ArrayList r16 = r8.a;
        if (r16 == null) goto L46;
        r16.add(r11);
    L46:
        if (r31 == null) goto L48;
        com.larus.bmhome.actionbar.model.h1 r17 = r31.c;
    L49:
        com.larus.bmhome.actionbar.model.h1 r18 = g(h(r17, r29), r10);
        if (r31 == null) goto L55;
        String r0 = r31.g;
        if (r0 == null) goto L55;
        String r19 = r0;
    L56:
        if (r31 == null) goto L58;
        com.larus.bmhome.actionbar.model.j1 r20 = r31.e;
    L60:
        return new com.larus.bmhome.actionbar.model.r(r28, r30, r18, r20, null, r19, null, r8, 3752);
    L58:
        r20 = null;
    L55:
        r19 = "";
        goto L56
    L48:
        r17 = null;
        goto L49
    L30:
        r21 = null;
    L26:
        r10 = null;
    L45:
        r10 = null;
    L62:
        if (r31 == null) goto L64;
        com.larus.bmhome.actionbar.model.h1 r22 = r31.c;
    L65:
        com.larus.bmhome.actionbar.model.h1 r23 = h(r22, r29);
        if (r31 == null) goto L71;
        String r1 = r31.g;
        if (r1 == null) goto L71;
        String r24 = r1;
    L72:
        if (r31 == null) goto L74;
        com.larus.bmhome.actionbar.model.j1 r25 = r31.e;
    L76:
        return new com.larus.bmhome.actionbar.model.r(r28, r30, r23, r25, null, r24, null, null, 4008);
    L74:
        r25 = null;
    L71:
        r24 = "";
        goto L72
    L64:
        r22 = null;
        goto L65
    }

    @Override // com.larus.bmhome.instruction.j
    public final boolean d(Context r9, String r10, boolean r11, com.larus.bmhome.view.actionbar.edit.c r12, Integer r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "input");
        if (r12 == null) goto L10;
        Integer r14 = r12.getInstructionType();
        if (r14 == null) goto L10;
        if (r14.intValue() != 1) goto L10;
        boolean r15 = true;
    L11:
        if (r15 == true) goto L13;
        if (r11 == true) goto L13;
    L68:
        return false;
    L13:
        int r16 = r10.length();
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r2 = 0;
        boolean r3 = false;
        int r4 = 0;
        int r5 = 0;
    L15:
        if (r2 >= r10.length()) goto L35;
        char r6 = r10.charAt(r2);
        if ('A' <= r6) goto L19;
    L21:
        boolean r7 = false;
    L22:
        if (r7 == true) goto L34;
        if ('a' <= r6) goto L26;
    L28:
        boolean r8 = false;
    L29:
        if (r8 == true) goto L34;
        if (r3 == false) goto L33;
        r4 = r4 + 1;
        r5 = r5 + 1;
        r3 = false;
    L33:
        r5 = r5 + 1;
        r2 = r2 + 1;
        goto L15
    L26:
        if (r6 >= '{') goto L28;
        r8 = true;
    L34:
        r2 = r2 + 1;
        r3 = true;
        goto L15
    L19:
        if (r6 >= '[') goto L21;
        r7 = true;
        goto L22
    L35:
        if (r3 == false) goto L37;
        r4 = r4 + 1;
        r5 = r5 + 1;
    L37:
        FLogger.a.d("getWordPercent", "word = " + r4 + ", total = " + r5);
        if ((r4 / r5) < 0.2f) goto L40;
        boolean r17 = true;
    L41:
        if (r17 == false) goto L44;
        String r18 = r9.getString(2131907198);
    L63:
        String r19 = r18;
        if (r19 == null) goto L68;
        t19.s.j(t19.s.a, r9, r19, null, false, 28);
        return true;
    L44:
        if (r13 != null) goto L47;
    L53:
        if (r13 != null) goto L56;
    L57:
        if (r11 == false) goto L64;
    L58:
        z2 r110 = z2.a;
        int r111 = r110.getMusicCreateConfig().d;
        int r112 = r110.getMusicCreateConfig().c;
        if (r16 >= r111) goto L61;
        r18 = r9.getString(2131907978, new Object[]{Integer.valueOf(r111)});
        goto L63
    L61:
        if (r16 <= r112) goto L64;
        r18 = r9.getString(2131907977, new Object[]{Integer.valueOf(r112)});
    L64:
        r18 = null;
        goto L63
    L56:
        if (r13.intValue() == 1) goto L58;
    L47:
        if (r13.intValue() != 2) goto L53;
        z2 r113 = z2.a;
        int r114 = r113.getMusicCreateConfig().b;
        int r115 = r113.getMusicCreateConfig().a;
        if (r16 >= r114) goto L51;
        r18 = r9.getString(2131907978, new Object[]{Integer.valueOf(r114)});
        goto L63
    L51:
        if (r16 <= r115) goto L64;
        r18 = r9.getString(2131907977, new Object[]{Integer.valueOf(r115)});
        goto L63
    L40:
        r17 = false;
    L10:
        r15 = false;
        goto L11
    }

    @Override // com.larus.bmhome.instruction.j
    public final com.larus.bmhome.actionbar.model.r e(Integer r29, String r30, com.larus.bmhome.view.actionbar.edit.b r31, com.larus.bmhome.actionbar.model.r r32, int r33) {
        if (r29 != null) goto L6;
    L8:
        if (r31 == null) goto L10;
        List<com.larus.bmhome.actionbar.model.u> r3 = r31.b();
    L11:
        Object r4 = "";
        if (r29 != null) goto L15;
    L68:
        if (r32 == null) goto L70;
        com.larus.bmhome.actionbar.model.h1 r5 = r32.c;
    L71:
        com.larus.bmhome.actionbar.model.h1 r6 = h(r5, r30);
        if (r32 == null) goto L77;
        String r0 = r32.g;
        if (r0 == null) goto L77;
        String r7 = r0;
    L78:
        if (r31 == null) goto L83;
        Long r1 = r31.d();
        if (r1 == null) goto L83;
        r4 = r1;
    L83:
        String r8 = r4.toString();
        if (r32 == null) goto L86;
        com.larus.bmhome.actionbar.model.j1 r9 = r32.e;
    L88:
        return new com.larus.bmhome.actionbar.model.r(r29, r3, r6, r9, r8, r7, null, null, 3976);
    L86:
        r9 = null;
    L77:
        r7 = "";
        goto L78
    L70:
        r5 = null;
        goto L71
    L15:
        if (r29.intValue() != 28) goto L68;
        com.larus.bmhome.actionbar.model.y r10 = new com.larus.bmhome.actionbar.model.y(0);
        if (r32 == null) goto L46;
        com.larus.bmhome.actionbar.model.y r11 = r32.i;
        if (r11 == null) goto L46;
        ArrayList r12 = r11.a;
        if (r12 == null) goto L46;
        com.larus.bmhome.actionbar.model.z0 r13 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.getOrNull(r12, r33);
        if (r13 == null) goto L46;
        com.larus.bmhome.actionbar.model.r r14 = r13.q;
        if (r14 == null) goto L29;
        com.larus.bmhome.actionbar.model.h1 r15 = r14.c;
        if (r15 == null) goto L29;
        String r16 = r15.c;
    L31:
        if (r14 == null) goto L33;
        com.larus.bmhome.actionbar.model.r r22 = com.larus.bmhome.actionbar.model.r.a(r14, null, null, null, null, 4095);
    L34:
        com.larus.bmhome.actionbar.model.z0 r17 = com.larus.bmhome.actionbar.model.z0.a(r13, null, null, null, null, null, null, null, null, r22, null, null, null, false, -65537);
        com.larus.bmhome.actionbar.model.r r18 = r17.q;
        if (r18 == null) goto L37;
        r18.b = r3;
    L37:
        if (r18 == null) goto L43;
        com.larus.bmhome.actionbar.model.r r19 = r13.q;
        if (r19 == null) goto L41;
        com.larus.bmhome.actionbar.model.h1 r20 = r19.c;
    L42:
        r18.c = h(r20, r30);
        goto L43
    L41:
        r20 = null;
    L43:
        ArrayList r21 = r10.a;
        if (r21 == null) goto L47;
        r21.add(r17);
    L47:
        if (r32 == null) goto L49;
        com.larus.bmhome.actionbar.model.h1 r23 = r32.c;
    L50:
        com.larus.bmhome.actionbar.model.h1 r24 = g(h(r23, r30), r16);
        if (r32 == null) goto L56;
        String r2 = r32.g;
        if (r2 == null) goto L56;
        String r25 = r2;
    L57:
        if (r31 == null) goto L62;
        Long r26 = r31.d();
        if (r26 == null) goto L62;
        r4 = r26;
    L62:
        String r27 = r4.toString();
        if (r32 == null) goto L65;
        com.larus.bmhome.actionbar.model.j1 r28 = r32.e;
    L67:
        return new com.larus.bmhome.actionbar.model.r(r29, r3, r24, r28, r27, r25, null, r10, 3720);
    L65:
        r28 = null;
    L56:
        r25 = "";
        goto L57
    L49:
        r23 = null;
        goto L50
    L33:
        r22 = null;
    L29:
        r16 = null;
    L46:
        r16 = null;
        goto L47
    L10:
        r3 = null;
        goto L11
    L6:
        if (r29.intValue() != 0) goto L8;
        return null;
    }

    @Override // com.larus.bmhome.instruction.j
    public final Map<String, String> b(String r3, String r4, String r5, boolean r6, Map<String, String> r7, Long r8) {
        Intrinsics.checkNotNullParameter(r3, "actionBarKey");
        Intrinsics.checkNotNullParameter(r4, "instructionType");
        if (r5 == null) goto L16;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("action_bar_key", r3);
        r0.put("action_bar_instruction_type", r4);
        r0.put("action_bar_instruction", r5);
        r0.put("is_manual_input", String.valueOf(r6));
        if (r8 == null) goto L9;
        String r9 = r8.toString();
        if (r9 == null) goto L9;
        r0.put("action_bar_item_id", r9);
    L9:
        if (r7 == null) goto L12;
        r0.putAll(r7);
    L12:
        if (Intrinsics.areEqual(r4, "21") == false) goto L15;
        com.larus.bmhome.view.actionbar.deepresearch.b r10 = com.larus.bmhome.view.actionbar.deepresearch.b.a;
        com.larus.bmhome.view.actionbar.deepresearch.b.b(r0);
    L15:
        return r0;
    L16:
        return r7;
    }

    @Override // com.larus.bmhome.instruction.j
    public final com.larus.bmhome.actionbar.model.r c(String r8, com.larus.bmhome.actionbar.model.r r9, com.larus.bmhome.view.actionbar.edit.c r10, com.larus.bmhome.view.actionbar.edit.b r11, com.larus.bmhome.actionbar.model.p1 r12, fq8.e r13) {
        Intrinsics.checkNotNullParameter(r8, "userInput");
        Intrinsics.checkNotNullParameter(r9, "instructionConf");
        com.larus.bmhome.view.actionbar.custom.e r0 = com.larus.bmhome.view.actionbar.custom.e.a;     // Catch: Exception -> L21
        if (r10 == null) goto L9;
        com.larus.bmhome.actionbar.model.r r1 = r10.getCurrentInstructionConf();     // Catch: Exception -> L21
        if (r1 == null) goto L9;
        com.larus.bmhome.actionbar.model.r r2 = r1;
    L10:
        if (r11 == null) goto L12;
        List<com.larus.bmhome.actionbar.model.u> r14 = r11.b();     // Catch: Exception -> L21
    L13:
        List<com.larus.bmhome.actionbar.model.u> r3 = r14;
        if (r10 == null) goto L18;
        kotlinx.coroutines.flow.i1<Integer> r15 = r10.getInstructionSelectMenuPosition();     // Catch: Exception -> L21
        if (r15 == null) goto L18;
        int r6 = ((Number) r15.getValue()).intValue();     // Catch: Exception -> L21
    L19:
        return com.larus.bmhome.view.actionbar.custom.e.d(r8, r9, r2, r3, r12, r13, r6);
    L18:
        r6 = -1;
        goto L19
    L12:
        r14 = null;
    L9:
        r2 = r9;
    L21:
        e = move-exception;
        FLogger.a.e("InstructionComponent", "buildInstructionConfWithClientExt error = " + e.getMessage());
        if (AppHost.a.isDebug() == true) goto L26;
        return r9;
    L26:
        throw new IllegalArgumentException("InstructionComponent, " + e.getMessage());
    }

    @Override // com.larus.bmhome.instruction.j
    public final String f(String r10, com.larus.bmhome.view.actionbar.edit.c r11, com.larus.bmhome.view.actionbar.edit.b r12, com.larus.bmhome.actionbar.model.p1 r13, fq8.e r14, f2 r15) {
        Intrinsics.checkNotNullParameter(r10, "userInput");
        com.larus.bmhome.view.actionbar.custom.e r1 = com.larus.bmhome.view.actionbar.custom.e.a;     // Catch: Exception -> L17
        if (r11 == null) goto L6;
        com.larus.bmhome.actionbar.model.r r3 = r11.getCurrentInstructionConf();     // Catch: Exception -> L17
    L7:
        if (r12 == null) goto L9;
        List<com.larus.bmhome.actionbar.model.u> r4 = r12.b();     // Catch: Exception -> L17
    L10:
        if (r11 == null) goto L14;
        kotlinx.coroutines.flow.i1<Integer> r16 = r11.getInstructionSelectMenuPosition();     // Catch: Exception -> L17
        if (r16 == null) goto L14;
        int r7 = ((Number) r16.getValue()).intValue();     // Catch: Exception -> L17
    L15:
        return r1.b(r10, r3, r4, r13, r14, r7, r15);
    L14:
        r7 = -1;
        goto L15
    L9:
        r4 = null;
        goto L10
    L6:
        r3 = null;
    L17:
        e = move-exception;
        FLogger.a.e("InstructionComponent", "buildContent error = " + e.getMessage());
        if (AppHost.a.isDebug() == true) goto L22;
        return r10;
    L22:
        throw new IllegalArgumentException("InstructionComponent, " + e.getMessage());
    }
}
