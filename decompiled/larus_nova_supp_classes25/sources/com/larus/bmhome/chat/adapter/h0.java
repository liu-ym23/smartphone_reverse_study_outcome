package com.larus.bmhome.chat.adapter;

import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.OnboardingActionCardData;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.ChatAbility;
import com.larus.im.bean.message.ChatAbilityType;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h0 {
    public static final boolean c(Message r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        com.larus.bmhome.actionbar.model.r r0 = com.larus.bmhome.actionbar.util.h.a(r10);
        String r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = r0.a;
    L6:
        boolean r3 = false;
        if (r2 != null) goto L10;
    L11:
        if (r2 != null) goto L14;
    L15:
        if (r2 != null) goto L18;
    L20:
        boolean r4 = false;
    L22:
        if (r2 != null) goto L25;
    L26:
        if (r2 != null) goto L29;
    L31:
        boolean r5 = false;
    L33:
        int r6 = od8.h0.a;
        if (r2 != null) goto L37;
    L39:
        boolean r7 = false;
    L40:
        Map r8 = r10.getExt();
        if (r8 == null) goto L43;
        String r9 = (String) r8.get("extend_video_params");
    L44:
        if (r9 == null) goto L46;
        boolean r11 = true;
    L47:
        if (r2 != null) goto L50;
    L52:
        boolean r12 = false;
    L53:
        Map r13 = r10.getExt();
        if (r13 == null) goto L56;
        String r14 = (String) r13.get("action_bar_instruction_type");
    L58:
        if (Intrinsics.areEqual(r14, "30") == true) goto L70;
        Map r15 = r10.getExt();
        if (r15 == null) goto L93;
        r1 = (String) r15.get("chat_ability");
    L93:
        ChatAbility r16 = (ChatAbility) HttpExtKt.f.fromJson(r1, ChatAbility.class);     // Catch: Exception -> L71
        if (r16 == null) goto L68;
        if (r16.getAbilityType() != ChatAbilityType.SKILL_PPT_GENERATION.getValue()) goto L68;
        boolean r17 = true;
    L69:
        if (r17 == true) goto L70;
    L73:
        boolean r18 = false;
    L74:
        if (r18 == true) goto L91;
        if (r7 == true) goto L91;
        if (r4 == true) goto L82;
        if (r5 == true) goto L82;
        if (r11 == true) goto L91;
        if (r12 == true) goto L91;
    L90:
        r3 = true;
    L82:
        boolean r19 = ic8.j.a(r10.getExt());
        if (z2.a.h1().a != true) goto L85;
        boolean r20 = true;
    L86:
        if (r20 == false) goto L91;
        if (r19 == true) goto L91;
        if (com.larus.utils.o0.d(r10.getMessageId()) == false) goto L91;
    L85:
        r20 = false;
    L91:
        FLogger.a.i("ModifyMessage", "canModifyWithInstruction " + r3);
        return r3;
    L68:
        r17 = false;
    L71:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e);
    L70:
        r18 = true;
        goto L74
    L56:
        r14 = null;
        goto L58
    L50:
        if (r2.intValue() != 11) goto L52;
        r12 = true;
        goto L53
    L46:
        r11 = false;
        goto L47
    L43:
        r9 = null;
        goto L44
    L37:
        if (r2.intValue() != 23) goto L39;
        r7 = true;
        goto L40
    L29:
        if (r2.intValue() != 24) goto L31;
    L32:
        r5 = true;
        goto L33
    L25:
        if (r2.intValue() == 18) goto L32;
    L18:
        if (r2.intValue() != 28) goto L20;
    L21:
        r4 = true;
        goto L22
    L14:
        if (r2.intValue() == 16) goto L21;
    L10:
        if (r2.intValue() == 4) goto L21;
    L5:
        r2 = null;
        goto L6
    }

    public static final boolean e(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Map r3 = r2.getExt();
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.containsKey("deep_research_phase") != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Deprecated(message = "old data flow")
    public static final boolean a(Message r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (com.larus.bmhome.chat.bean.d.M0(r3) == false) goto L5;
        return false;
    L5:
        com.larus.platform.model.chat.f0 r0 = z2.a.messageModifyConfig();
        if (k99.d.a(r3) == false) goto L11;
        if (r0.c == true) goto L11;
        return false;
    L11:
        if (r0.b == false) goto L14;
        return true;
    L14:
        return b(r3, r4);
    }

    public static final boolean b(Message r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r1.getLocalMessageId(), r2);
    }

    public static final boolean d(Message r4, List<z0> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r5 == null) goto L25;
        List<z0> r6 = r5;
        if ((r6 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r7 = r6.iterator();
        int r2 = 0;
    L11:
        if (r7.hasNext() == false) goto L27;
        com.larus.bmhome.actionbar.model.r r3 = ((z0) r7.next()).q;
        if (r3 == null) goto L20;
        Integer r8 = r3.a;
        if (r8 == null) goto L20;
        if (r8.intValue() != 1) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L11;
        r2 = r2 + 1;
        if (r2 >= 0) goto L11;
        CollectionsKt.throwCountOverflow();
    L20:
        r9 = false;
    L27:
        if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.x(r4).getOnboardingCardType(), String.valueOf(OnboardingActionCardData.CardType.Music.getValue())) == false) goto L39;
        if (r2 > 0) goto L40;
        return false;
    L40:
        return true;
    L39:
        return true;
    L7:
        if (r6.isEmpty() == false) goto L9;
    L25:
        r2 = 0;
        goto L27
    }

    public static final boolean g(wq8.b r3, Message r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == false) goto L9;
        String r5 = r4.getLocalMessageId();
    L11:
        if (Intrinsics.areEqual(r3.T1(), r5) == true) goto L17;
        r3.F1(r5);
        if (r5 == null) goto L15;
        RepoDispatcherDelegate.b.e().r1(r5, new g0());
    L15:
        r3.notifyDataSetChanged();
    L17:
        return r3.s0();
    L9:
        r5 = null;
        goto L11
    L5:
        if (a(r4, r3.W()) != true) goto L7;
        r0 = true;
        goto L7
    }

    public static final boolean f(Message r4, String r5, List<z0> r6, Boolean r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.getContentType() == 1) goto L5;
        return false;
    L5:
        if (com.larus.bmhome.chat.bean.d.G0(r4) == true) goto L7;
        return false;
    L7:
        if (b(r4, r5) == true) goto L9;
        return false;
    L9:
        if (c(r4) == true) goto L11;
        return false;
    L11:
        if (d(r4, r6) == false) goto L41;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.getSourceFromAsr() == true) goto L15;
    L19:
        boolean r9 = false;
    L20:
        if (r9 == true) goto L42;
        Boolean r10 = Boolean.TRUE;
        if (Intrinsics.areEqual(r7, r10) == false) goto L24;
        return false;
    L24:
        if (e(r4) == false) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(r8, r10) == true) goto L45;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Map r11 = r4.getExt();
        if (r11 == null) goto L30;
        String r12 = (String) r11.get("o_omni_init_skill_ids");
    L31:
        if (r12 != null) goto L33;
        boolean r13 = true;
    L34:
        if (r13 == false) goto L46;
        return true;
    L46:
        return false;
    L33:
        r13 = false;
        goto L34
    L30:
        r12 = null;
        goto L31
    L45:
        return false;
    L42:
        return false;
    L15:
        if (r4.getContentType() != 1) goto L19;
        if (r4.getMessageStatusLocal() != 0) goto L19;
        r9 = true;
        goto L20
    L41:
        return false;
    }
}
