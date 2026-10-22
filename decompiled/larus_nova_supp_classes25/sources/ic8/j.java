package ic8;

import com.larus.bmhome.actionbar.model.m1;
import com.larus.bmhome.actionbar.model.p1;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j {
    public static final boolean a(Map<String, String> r6) {
        if (r6 == null) goto L85;
        String r7 = r6.get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);
        if (r7 == null) goto L86;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L59
        List<com.larus.bmhome.actionbar.model.u> r8 = ((com.larus.bmhome.actionbar.model.r) xt7.d.b.c(com.larus.bmhome.actionbar.model.r.Companion.serializer(), r7)).b;     // Catch: Throwable -> L59
        if (r8 == null) goto L56;
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L59
        Iterator<T> r9 = r8.iterator();     // Catch: Throwable -> L59
    L9:
        boolean r3 = true;
        if (r9.hasNext() == false) goto L21;
        Object r4 = r9.next();     // Catch: Throwable -> L59
        Integer r5 = ((com.larus.bmhome.actionbar.model.u) r4).b;     // Catch: Throwable -> L59
        if (r5 != null) goto L15;
    L17:
        r3 = false;
    L18:
        if (r3 == false) goto L9;
        r2.add(r4);     // Catch: Throwable -> L59
        goto L9
    L15:
        if (r5.intValue() != 8) goto L17;
    L21:
        if (r2.isEmpty() == true) goto L53;
        Iterator r10 = r2.iterator();     // Catch: Throwable -> L59
    L25:
        if (r10.hasNext() == false) goto L53;
        com.larus.bmhome.actionbar.model.u r11 = (com.larus.bmhome.actionbar.model.u) r10.next();     // Catch: Throwable -> L59
        ouc.v r12 = xt7.d.b;     // Catch: Throwable -> L59
        juc.c r13 = com.larus.bmhome.actionbar.model.b0.Companion.serializer();     // Catch: Throwable -> L59
        String r14 = r11.d;     // Catch: Throwable -> L59
        if (r14 != null) goto L29;
        r14 = "";
    L29:
        List<com.larus.bmhome.actionbar.model.c0> r15 = ((com.larus.bmhome.actionbar.model.b0) r12.c(r13, r14)).a;     // Catch: Throwable -> L59
        if (r15 == null) goto L50;
        List<com.larus.bmhome.actionbar.model.c0> r16 = r15;     // Catch: Throwable -> L59
        if ((r16 instanceof Collection) == true) goto L34;
    L36:
        Iterator<T> r17 = r16.iterator();     // Catch: Throwable -> L59
    L38:
        if (r17.hasNext() == false) goto L47;
        com.larus.bmhome.actionbar.model.c0 r18 = (com.larus.bmhome.actionbar.model.c0) r17.next();     // Catch: Throwable -> L59
        if (r18.b == 4) goto L42;
    L44:
        boolean r19 = false;
    L45:
        if (r19 == false) goto L38;
        boolean r20 = true;
    L48:
        if (r20 != true) goto L50;
        boolean r21 = true;
    L51:
        if (r21 == false) goto L25;
        boolean r22 = true;
    L54:
        if (r22 != true) goto L56;
    L57:
        Object r23 = Result.constructor-impl(Boolean.valueOf(r3));     // Catch: Throwable -> L59
    L62:
        if (Result.isFailure-impl(r23) == false) goto L64;
        r23 = null;
    L64:
        Boolean r24 = (Boolean) r23;
        if (r24 != null) goto L67;
        return false;
    L67:
        return r24.booleanValue();
    L42:
        if (com.larus.utils.o0.d(r18.c) == false) goto L44;
        r19 = true;
    L47:
        r20 = false;
        goto L48
    L34:
        if (r16.isEmpty() == false) goto L36;
    L50:
        r21 = false;
    L53:
        r22 = false;
    L56:
        r3 = false;
    L59:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L86:
        return false;
    L85:
        return false;
    }

    public static final Integer b(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 != null) goto L7;
        return null;
    L7:
        return c(r2);
    }

    public static final Integer c(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Object r2 = null;
        if (r3.containsKey(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION) == true) goto L5;
        return null;
    L5:
        String r4 = r3.get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        ouc.v r1 = xt7.d.b;     // Catch: Throwable -> L11
        juc.c r5 = com.larus.bmhome.actionbar.model.r.Companion.serializer();     // Catch: Throwable -> L11
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        Object r6 = Result.constructor-impl(((com.larus.bmhome.actionbar.model.r) r1.c(r5, r4)).a);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r6) == true) goto L18;
        r2 = r6;
    L18:
        return (Integer) r2;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static final m1 d(Map<String, String> r4) {
        if (r4 == null) goto L32;
        String r5 = r4.get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);
        if (r5 == null) goto L32;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L30
        List<com.larus.bmhome.actionbar.model.u> r6 = ((com.larus.bmhome.actionbar.model.r) xt7.d.b.c(com.larus.bmhome.actionbar.model.r.Companion.serializer(), r5)).b;     // Catch: Throwable -> L30
        if (r6 == null) goto L28;
        Iterator<T> r7 = r6.iterator();     // Catch: Throwable -> L30
    L10:
        if (r7.hasNext() == false) goto L20;
        Object r2 = r7.next();     // Catch: Throwable -> L30
        Integer r3 = ((com.larus.bmhome.actionbar.model.u) r2).b;     // Catch: Throwable -> L30
        if (r3 != null) goto L15;
    L17:
        boolean r8 = false;
    L18:
        if (r8 == false) goto L10;
    L21:
        com.larus.bmhome.actionbar.model.u r9 = (com.larus.bmhome.actionbar.model.u) r2;     // Catch: Throwable -> L30
        if (r9 == null) goto L28;
        ouc.v r10 = xt7.d.b;     // Catch: Throwable -> L30
        juc.c r11 = m1.Companion.serializer();     // Catch: Throwable -> L30
        String r12 = r9.d;     // Catch: Throwable -> L30
        if (r12 != null) goto L27;
        r12 = "";
    L27:
        return (m1) r10.c(r11, r12);
    L15:
        if (r3.intValue() != 14) goto L17;
        r8 = true;
        goto L18
    L20:
        r2 = null;
    L28:
        Result.constructor-impl(null);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L32:
        return null;
    }

    public static final p1 e(Map<String, String> r9) {
        if (r9 == null) goto L54;
        String r10 = r9.get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);
        if (r10 == null) goto L54;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L52
        List<com.larus.bmhome.actionbar.model.u> r11 = ((com.larus.bmhome.actionbar.model.r) xt7.d.b.c(com.larus.bmhome.actionbar.model.r.Companion.serializer(), r10)).b;     // Catch: Throwable -> L52
        if (r11 == null) goto L49;
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L52
        Iterator<T> r12 = r11.iterator();     // Catch: Throwable -> L52
    L9:
        boolean r3 = false;
        if (r12.hasNext() == false) goto L19;
        Object r4 = r12.next();     // Catch: Throwable -> L52
        Integer r5 = ((com.larus.bmhome.actionbar.model.u) r4).b;     // Catch: Throwable -> L52
        if (r5 != null) goto L15;
    L17:
        if (r3 == false) goto L9;
        r2.add(r4);     // Catch: Throwable -> L52
        goto L9
    L15:
        if (r5.intValue() != 8) goto L17;
        r3 = true;
        goto L17
    L19:
        Iterator r13 = r2.iterator();     // Catch: Throwable -> L52
    L21:
        if (r13.hasNext() == false) goto L48;
        com.larus.bmhome.actionbar.model.u r6 = (com.larus.bmhome.actionbar.model.u) r13.next();     // Catch: Throwable -> L52
        ouc.v r7 = xt7.d.b;     // Catch: Throwable -> L52
        juc.c r8 = com.larus.bmhome.actionbar.model.b0.Companion.serializer();     // Catch: Throwable -> L52
        String r14 = r6.d;     // Catch: Throwable -> L52
        String r15 = "";
        if (r14 != null) goto L26;
        r14 = "";
    L26:
        List<com.larus.bmhome.actionbar.model.c0> r16 = ((com.larus.bmhome.actionbar.model.b0) r7.c(r8, r14)).a;     // Catch: Throwable -> L52
        if (r16 == null) goto L21;
        Iterator<T> r17 = r16.iterator();     // Catch: Throwable -> L52
    L30:
        if (r17.hasNext() == false) goto L39;
        Object r18 = r17.next();     // Catch: Throwable -> L52
        com.larus.bmhome.actionbar.model.c0 r19 = (com.larus.bmhome.actionbar.model.c0) r18;     // Catch: Throwable -> L52
        if (r19.b == 4) goto L34;
    L36:
        boolean r20 = false;
    L37:
        if (r20 == false) goto L30;
    L40:
        com.larus.bmhome.actionbar.model.c0 r21 = (com.larus.bmhome.actionbar.model.c0) r18;     // Catch: Throwable -> L52
        if (r21 == null) goto L21;
        ouc.v r22 = xt7.d.b;     // Catch: Throwable -> L52
        juc.c r23 = p1.Companion.serializer();     // Catch: Throwable -> L52
        String r24 = r21.c;     // Catch: Throwable -> L52
        if (r24 == null) goto L47;
        r15 = r24;
    L47:
        return (p1) r22.c(r23, r15);
    L34:
        if (com.larus.utils.o0.d(r19.c) == false) goto L36;
        r20 = true;
        goto L37
    L39:
        r18 = null;
        goto L40
    L48:
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L52
    L50:
        Result.constructor-impl(r25);     // Catch: Throwable -> L52
        goto L54
    L49:
        r25 = null;
    L52:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L54:
        return null;
    }

    public static final String f(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 != null) goto L7;
        return "1";
    L7:
        return g(r2);
    }

    public static final String g(Map<String, String> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Integer r2 = c(r1);
        if (r2 != null) goto L6;
        return "1";
    L6:
        if (r2.intValue() != 4) goto L9;
        return "3";
    L9:
        return "1";
    }

    public static final boolean h(Map<String, String> r8) {
        String r9 = r8.get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);
        if (r9 == null) goto L94;
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L72
        com.larus.bmhome.actionbar.model.r r10 = (com.larus.bmhome.actionbar.model.r) xt7.d.b.c(com.larus.bmhome.actionbar.model.r.Companion.serializer(), r9);     // Catch: Throwable -> L72
        List<com.larus.bmhome.actionbar.model.u> r3 = r10.b;     // Catch: Throwable -> L72
        boolean r4 = true;
        String r5 = "";
        if (r3 == null) goto L36;
        Iterator<T> r6 = r3.iterator();     // Catch: Throwable -> L72
    L10:
        if (r6.hasNext() == false) goto L20;
        Object r7 = r6.next();     // Catch: Throwable -> L72
        Integer r11 = ((com.larus.bmhome.actionbar.model.u) r7).b;     // Catch: Throwable -> L72
        if (r11 != null) goto L15;
    L17:
        boolean r12 = false;
    L18:
        if (r12 == false) goto L10;
    L21:
        com.larus.bmhome.actionbar.model.u r13 = (com.larus.bmhome.actionbar.model.u) r7;     // Catch: Throwable -> L72
        if (r13 == null) goto L36;
        ouc.v r14 = xt7.d.b;     // Catch: Throwable -> L72
        juc.c r15 = com.larus.bmhome.actionbar.model.n.Companion.serializer();     // Catch: Throwable -> L72
        String r16 = r13.d;     // Catch: Throwable -> L72
        if (r16 != null) goto L26;
        r16 = "";
    L26:
        List<com.larus.bmhome.actionbar.model.w> r17 = ((com.larus.bmhome.actionbar.model.n) r14.c(r15, r16)).a;     // Catch: Throwable -> L72
        if (r17 != null) goto L29;
        Boolean r18 = null;
    L34:
        if (r18 == null) goto L36;
        boolean r19 = r18.booleanValue();     // Catch: Throwable -> L72
    L37:
        if (r19 == true) goto L70;
        List<com.larus.bmhome.actionbar.model.u> r20 = r10.b;     // Catch: Throwable -> L72
        if (r20 == null) goto L69;
        Iterator<T> r21 = r20.iterator();     // Catch: Throwable -> L72
    L42:
        if (r21.hasNext() == false) goto L52;
        Object r22 = r21.next();     // Catch: Throwable -> L72
        Integer r23 = ((com.larus.bmhome.actionbar.model.u) r22).b;     // Catch: Throwable -> L72
        if (r23 != null) goto L47;
    L49:
        boolean r24 = false;
    L50:
        if (r24 == false) goto L42;
    L53:
        com.larus.bmhome.actionbar.model.u r25 = (com.larus.bmhome.actionbar.model.u) r22;     // Catch: Throwable -> L72
        if (r25 == null) goto L69;
        ouc.v r26 = xt7.d.b;     // Catch: Throwable -> L72
        juc.c r27 = com.larus.bmhome.actionbar.model.m.Companion.serializer();     // Catch: Throwable -> L72
        String r28 = r25.d;     // Catch: Throwable -> L72
        if (r28 == null) goto L59;
        r5 = r28;
    L59:
        List<com.larus.bmhome.actionbar.model.o> r29 = ((com.larus.bmhome.actionbar.model.m) r26.c(r27, r5)).a;     // Catch: Throwable -> L72
        if (r29 != null) goto L62;
        Boolean r30 = null;
    L67:
        if (r30 == null) goto L69;
        r19 = r30.booleanValue();     // Catch: Throwable -> L72
        goto L70
    L62:
        if (r29.isEmpty() == false) goto L65;
        r4 = false;
    L65:
        r30 = Boolean.valueOf(r4);     // Catch: Throwable -> L72
        goto L67
    L47:
        if (r23.intValue() != 9) goto L49;
        r24 = true;
        goto L50
    L52:
        r22 = null;
    L69:
        r19 = false;
    L70:
        Object r31 = Result.constructor-impl(Boolean.valueOf(r19));     // Catch: Throwable -> L72
    L75:
        if (Result.isFailure-impl(r31) == true) goto L78;
        r1 = r31;
    L78:
        Boolean r32 = (Boolean) r1;
        if (r32 != null) goto L81;
        return false;
    L81:
        return r32.booleanValue();
    L29:
        if (r17.isEmpty() == true) goto L31;
        boolean r33 = true;
    L32:
        r18 = Boolean.valueOf(r33);     // Catch: Throwable -> L72
        goto L34
    L31:
        r33 = false;
        goto L32
    L15:
        if (r11.intValue() != 11) goto L17;
        r12 = true;
        goto L18
    L20:
        r7 = null;
    L36:
        r19 = false;
    L72:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L75
    L94:
        return false;
    }

    public static final boolean i(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Map r3 = r2.getExt();
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.containsKey(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final Boolean j(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.containsKey("is_manual_input") == true) goto L7;
        return null;
    L7:
        return Boolean.valueOf(Intrinsics.areEqual(r2.get("is_manual_input"), "true"));
    }

    public static final boolean k(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("pocket_map");
    L7:
        return com.larus.utils.o0.d(r3);
    L5:
        r3 = null;
        goto L7
    }
}
