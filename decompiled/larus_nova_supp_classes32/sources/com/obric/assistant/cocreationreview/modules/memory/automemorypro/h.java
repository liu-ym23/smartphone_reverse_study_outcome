package com.obric.assistant.cocreationreview.modules.memory.automemorypro;

import com.lynx.jsbridge.LynxAccessibilityModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.ModuleKey;
import hda.b1;
import hda.c1;
import hda.e1;
import hda.o0;
import hda.q0;
import hda.r0;
import hda.r1;
import hda.s1;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h implements r0<i> {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public static String d(String r9) {
        String r10 = CollectionsKt.joinToString$default(StringsKt.lines(r9), " ", null, null, 0, null, new g(), 30, null);
        return StringsKt.trim(new Regex("\\s+").replace(r10, " ")).toString();
    }

    @Override // hda.r0
    public final String a(com.obric.assistant.cocreationreview.a r2) {
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.k;
    }

    @Override // hda.r0
    public final String b(com.obric.assistant.cocreationreview.a r2) {
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.l;
    }

    @Override // hda.r0
    public final com.obric.assistant.cocreationreview.a c(q0 r24) {
        Intrinsics.checkNotNullParameter(r24, "record");
        o0 r1 = new o0(r24);
        r1.a.getClass();
        e1 r13 = r1.f(r24);
        String r2 = r1.c(new String[]{"currentContent", LynxAccessibilityModule.MSG_CONTENT, "displaySummary"});
        String r3 = r24.d;
        if (r3 != null) goto L6;
        if (r2 != null) goto L7;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r4 = b1.a(r2);
        String r9 = c1.a(r1.c(new String[]{"ruleTitle", "rule_title", "ruleName", "rule", "taskName", "memoryTaskName"}));
        String r5 = c1.a(r1.c(new String[]{"taskSubtitle", "displaySubtitle", "cardSubtitle", "realSubtitle", "subtitle"}));
        String r6 = r24.a;
        ModuleKey r7 = ModuleKey.AUTO_MEMORY_PRO;
        String r8 = s1.a(r24, r13.f);
        String r10 = r13.g;
        String r11 = r13.c;
        String r12 = null;
        if (r9 == null) goto L14;
        String r14 = d(r9);
        if (r14 == null) goto L14;
        if ((!StringsKt.isBlank(r14)) == false) goto L14;
    L16:
        if (r5 == null) goto L27;
        String r15 = d(r5);
        if (r15 == null) goto L27;
        if ((!StringsKt.isBlank(r15)) == true) goto L22;
    L24:
        boolean r16 = false;
    L25:
        if (r16 == false) goto L27;
    L28:
        List r17 = CollectionsKt.listOfNotNull(new String[]{r14, r15});
        if ((true ^ r17.isEmpty()) == true) goto L32;
        r17 = null;
    L32:
        if (r17 == null) goto L34;
        r12 = CollectionsKt.joinToString$default(r17, "\n", null, null, 0, null, null, 62, null);
    L34:
        String r18 = r13.d;
        if (StringsKt.isBlank(r18) == false) goto L37;
        String r19 = r4;
    L39:
        return new i(r6, r7, r8, r10, "记忆任务", r9, r11, r12, r19, r13, r24.e, r24.g);
    L37:
        r19 = r18;
        goto L39
    L22:
        if (Intrinsics.areEqual(r15, r14) == true) goto L24;
        r16 = true;
    L27:
        r15 = null;
    L14:
        r14 = null;
        goto L16
    L6:
        r2 = r3;
        goto L7
    }
}
