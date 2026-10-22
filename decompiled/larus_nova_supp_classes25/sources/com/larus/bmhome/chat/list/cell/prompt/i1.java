package com.larus.bmhome.chat.list.cell.prompt;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import com.larus.im.bean.message.Message;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i1 {
    public static final Set<String> e = null;
    public final de8.c a;
    public final com.larus.bmhome.chat.component.cvs.y b;
    public final com.larus.bmhome.chat.component.trace.z c;
    public final com.larus.bmhome.instruction.g d;

    public static final class a {
    }

    static {
        e = new LinkedHashSet();
    }

    public final String b() {
        com.larus.bmhome.instruction.g r0 = this.d;
        ModelItemIdentity r1 = null;
        if (r0 == null) goto L7;
        MutableLiveData r2 = r0.zU();
        if (r2 == null) goto L7;
        ReplyOption r3 = (ReplyOption) r2.getValue();
    L8:
        if (r3 == null) goto L10;
        ModelItemIdentity r4 = r3.getModel();
    L12:
        if (Intrinsics.areEqual(r4, wa8.t0.d) == false) goto L14;
        return "pro_mode";
    L14:
        if (r3 == null) goto L17;
        r1 = r3.getModel();
    L17:
        if (Intrinsics.areEqual(r1, wa8.t0.e) == true) goto L27;
        com.larus.bmhome.instruction.g r5 = this.d;
        if (r5 == null) goto L23;
        boolean r6 = true;
        if (r5.yW() != true) goto L23;
    L24:
        if (r6 == true) goto L27;
        return "fast";
    L23:
        r6 = false;
    L27:
        return "moa";
    L10:
        r4 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final long e() {
        return de8.d.a(this.a);
    }

    public static boolean f(PromptContent.SuggestItem r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r3.isCategoryCandidate(), Boolean.TRUE) == true) goto L15;
        List<PromptContent.SuggestItem> r4 = r3.getChildCandidates();
        if (r4 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == false) goto L15;
        return false;
    L10:
        if (r4.isEmpty() == true) goto L13;
        r5 = false;
    L15:
        return true;
    }

    public static String d(PromptContent.SuggestV2 r4, PromptContent.SuggestItem r5) {
        if (r5 == null) goto L5;
        String r1 = r5.getShowFrom();
    L6:
        if (r1 != null) goto L23;
        boolean r6 = false;
        if (r4 == null) goto L18;
        Integer r2 = r4.getSuggestType();
        if (r2 == null) goto L18;
        Regex r3 = com.larus.bmhome.chat.bean.d.a;
        if (r2.intValue() != 5) goto L15;
        boolean r7 = true;
    L16:
        if (r7 != true) goto L18;
        r6 = true;
        goto L18
    L15:
        r7 = false;
    L18:
        if (r6 == false) goto L24;
        PromptContent.SuggestV2ExtraForMultiAction r8 = r4.getSuggestV2ExtForMultiAction();
        if (r8 != null) goto L22;
        return null;
    L22:
        return r8.getShowFrom();
    L24:
        return null;
    L23:
        return r5.getShowFrom();
    L5:
        r1 = null;
        goto L6
    }

    public final void g(PromptSpan.a.C0062a r9, PromptContent.SuggestItem r10) {
        if (r9 == null) goto L6;
        Boolean r0 = r9.h;
        if (r0 == null) goto L6;
        boolean r1 = r0.booleanValue();
    L7:
        if (r1 == true) goto L9;
        return;
    L9:
        String r2 = null;
        if (r9 == null) goto L15;
        String r3 = r9.k;
        if (r3 == null) goto L15;
    L14:
        String r4 = r3;
        if (r9 == null) goto L25;
        String r11 = r9.j;
        if (r11 == null) goto L25;
        String r5 = r11;
    L28:
        int r12 = gx9.o.a;
        long r13 = e();
        gx9.o.i(r13, "onClickOfficeOnboardingCard", new gx9.h(r4, r5, b(), r13));
        return;
    L25:
        if (r10 == null) goto L27;
        r2 = r10.getRawWcbCandidateType();
    L27:
        r5 = r2;
    L15:
        if (r10 == null) goto L17;
        r3 = r10.getCategoryId();
    L18:
        if (r3 != null) goto L14;
        return;
    L17:
        r3 = null;
    L6:
        r1 = f(r10);
        goto L7
    }

    public final Map<String, String> a(Message r10, PromptSpan.a.C0062a r11, PromptContent.SuggestItem r12) {
        String r1 = null;
        if (com.larus.bmhome.chat.bean.d.W0(r10) == true) goto L5;
        return null;
    L5:
        int r0 = gx9.o.a;
        String r13 = (String) com.larus.bmhome.chat.bean.d.x(r10).get("next_pulse_scene");
        if (r11 == null) goto L9;
        String r2 = r11.f;
        if (r2 == null) goto L9;
    L12:
        if (r11 == null) goto L15;
        Boolean r3 = r11.g;
        if (r3 == null) goto L15;
    L18:
        if (r11 == null) goto L22;
        Boolean r4 = r11.h;
        if (r4 == null) goto L22;
        boolean r5 = r4.booleanValue();
    L23:
        Boolean r6 = Boolean.valueOf(r5);
        if (r11 == null) goto L27;
        String r7 = r11.i;
        if (r7 == null) goto L27;
    L30:
        String r8 = b();
        if (r11 == null) goto L34;
        String r9 = r11.j;
        if (r9 == null) goto L34;
    L37:
        if (r11 == null) goto L40;
        String r14 = r11.k;
        if (r14 == null) goto L40;
    L43:
        if (r11 == null) goto L46;
        String r15 = r11.l;
        if (r15 == null) goto L46;
    L51:
        Pair[] r16 = new Pair[9];
        r16[0] = TuplesKt.to("next_pulse_scene", r13);
        r16[1] = TuplesKt.to("sug_biz_type", r2);
        if (r3 == null) goto L54;
        String r17 = r3.toString();
    L55:
        r16[2] = TuplesKt.to("is_continue_ask", r17);
        if (r6 == null) goto L58;
        r1 = r6.toString();
    L58:
        r16[3] = TuplesKt.to("has_category", r1);
        r16[4] = TuplesKt.to("rich_text_type", r7);
        r16[5] = TuplesKt.to("current_chat_type", r8);
        r16[6] = TuplesKt.to("candidate_type", r9);
        r16[7] = TuplesKt.to("category_id", r14);
        r16[8] = TuplesKt.to("skill_id", r15);
        return MapsKt.mapOf(r16);
    L54:
        r17 = null;
    L46:
        if (r12 == null) goto L50;
        j1 r18 = n1.b(r12);
        if (r18 == null) goto L50;
        r15 = r18.a;
    L50:
        r15 = null;
    L40:
        if (r12 == null) goto L42;
        r14 = r12.getCategoryId();
        goto L43
    L42:
        r14 = null;
    L34:
        if (r12 == null) goto L36;
        r9 = r12.getRawWcbCandidateType();
        goto L37
    L36:
        r9 = null;
    L27:
        if (r12 == null) goto L29;
        r7 = r12.getRichTextType();
        goto L30
    L29:
        r7 = null;
    L22:
        r5 = f(r12);
    L15:
        if (r12 == null) goto L17;
        r3 = r12.isContinueAsk();
        goto L18
    L17:
        r3 = null;
    L9:
        if (r12 == null) goto L11;
        r2 = r12.getSugBizType();
        goto L12
    L11:
        r2 = null;
        goto L12
    }

    public i1(de8.c r1, com.larus.bmhome.chat.component.cvs.y r2, com.larus.bmhome.chat.component.trace.z r3, com.larus.bmhome.instruction.g r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public static String c(Message r1, PromptContent.SuggestItem r2, PromptSpan r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "data");
        Intrinsics.checkNotNullParameter(r3, "span");
        if (r2 == null) goto L5;
        boolean r5 = Intrinsics.areEqual(r2.isHighlightPush(), Boolean.TRUE);
    L6:
        if (r5 == true) goto L8;
        if (r4 == false) goto L14;
        return "function_card";
    L14:
        if (r3.h == false) goto L16;
        return "multi_one_line";
    L16:
        return "single_one_line";
    L8:
        if (com.larus.bmhome.chat.bean.d.k0(r1) == false) goto L10;
        return "multi_one_line_highlight";
    L10:
        return "single_one_line_highlight";
    L5:
        r5 = false;
        goto L6
    }
}
