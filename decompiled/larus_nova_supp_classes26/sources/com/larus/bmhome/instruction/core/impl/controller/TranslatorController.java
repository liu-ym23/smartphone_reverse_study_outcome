package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.l0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.core.model.widget.TranslatorSelectorType;
import com.larus.im.FlowRuntime;
import cq8.a0;
import cq8.v0;
import cq8.w0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import ouc.d0;
import ouc.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class TranslatorController extends com.larus.bmhome.instruction.core.impl.base.b {
    public l0 p;
    public final Lazy q;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TranslatorSelectorType.values().length];
            r0[TranslatorSelectorType.SOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[TranslatorSelectorType.TARGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[TranslatorSelectorType.VOICE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 5;
    }

    public TranslatorController() {
        super("TranslatorController");
        this.q = LazyKt.lazy(new t());
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        String r2 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C0015b r3 = this.o;
        l0 r4 = this.p;
        com.larus.bmhome.actionbar.model.u r1 = this.b;
        String r5 = null;
        if (r1 == null) goto L9;
        String r6 = r1.c;
        if (r6 == null) goto L9;
        if ((!StringsKt.isBlank(r6)) == false) goto L9;
        String r7 = r6;
    L10:
        com.larus.bmhome.instruction.core.impl.base.c r8 = this.c;
        if (r8 == null) goto L21;
        aq8.d r9 = r8.a;
        if (r9 == null) goto L21;
        dq8.h r10 = r9.a;
        if (r10 == null) goto L21;
        String r11 = r10.d();
        if (r11 == null) goto L21;
        if ((!StringsKt.isBlank(r11)) == false) goto L21;
        String r12 = r11;
    L22:
        com.larus.bmhome.actionbar.model.u r13 = this.b;
        if (r13 == null) goto L25;
        boolean r14 = Intrinsics.areEqual(r13.f, Boolean.TRUE);
    L26:
        com.larus.bmhome.instruction.core.impl.base.c r15 = this.c;
        if (r15 == null) goto L33;
        aq8.d r16 = r15.a;
        if (r16 == null) goto L33;
        dq8.h r17 = r16.a;
        if (r17 == null) goto L33;
        String r18 = r17.getBotId();
    L34:
        com.larus.bmhome.instruction.core.impl.base.c r19 = this.c;
        if (r19 == null) goto L41;
        aq8.d r20 = r19.a;
        if (r20 == null) goto L41;
        dq8.h r21 = r20.a;
        if (r21 == null) goto L41;
        String r110 = r21.getChatType();
    L42:
        com.larus.bmhome.instruction.core.impl.base.c r22 = this.c;
        if (r22 == null) goto L49;
        aq8.d r23 = r22.a;
        if (r23 == null) goto L49;
        dq8.h r24 = r23.a;
        if (r24 == null) goto L49;
        String r111 = r24.getTemplateType();
    L50:
        com.larus.bmhome.instruction.core.impl.base.c r25 = this.c;
        if (r25 == null) goto L59;
        aq8.d r26 = r25.a;
        if (r26 == null) goto L59;
        dq8.h r27 = r26.a;
        if (r27 == null) goto L59;
        Integer r28 = r27.getInstructionType();
        if (r28 == null) goto L59;
        String r112 = r28.toString();
    L60:
        com.larus.bmhome.instruction.core.impl.base.c r29 = this.c;
        if (r29 == null) goto L67;
        aq8.d r30 = r29.a;
        if (r30 == null) goto L67;
        dq8.h r31 = r30.a;
        if (r31 == null) goto L67;
        String r113 = r31.a();
    L68:
        com.larus.bmhome.instruction.core.impl.base.c r32 = this.c;
        if (r32 == null) goto L75;
        aq8.d r33 = r32.a;
        if (r33 == null) goto L75;
        dq8.h r34 = r33.a;
        if (r34 == null) goto L75;
        String r114 = r34.b();
    L76:
        com.larus.bmhome.instruction.core.impl.base.c r35 = this.c;
        if (r35 == null) goto L83;
        aq8.d r36 = r35.a;
        if (r36 == null) goto L83;
        dq8.h r37 = r36.a;
        if (r37 == null) goto L83;
        Boolean r115 = r37.isCreationActionBar();
    L84:
        com.larus.bmhome.actionbar.model.u r38 = this.b;
        if (r38 == null) goto L91;
        String r39 = r38.c;
        if (r39 == null) goto L91;
        if ((!StringsKt.isBlank(r39)) == false) goto L91;
        String r116 = r39;
    L92:
        com.larus.bmhome.instruction.core.impl.base.c r40 = this.c;
        if (r40 == null) goto L100;
        aq8.d r41 = r40.a;
        if (r41 == null) goto L100;
        dq8.h r42 = r41.a;
        if (r42 == null) goto L100;
        r5 = r42.c();
    L100:
        return new v0(r2, r3, r4, r7, r12, r14, new z0(r18, r110, r111, r5, r112, r113, r114, r115, r116, 2));
    L91:
        r116 = null;
    L83:
        r115 = null;
    L75:
        r114 = null;
    L67:
        r113 = null;
    L59:
        r112 = null;
    L49:
        r111 = null;
    L41:
        r110 = null;
    L33:
        r18 = null;
        goto L34
    L25:
        r14 = false;
    L21:
        r12 = null;
    L9:
        r7 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        l0 r0 = this.p;
        Object r2 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        com.larus.bmhome.actionbar.model.h r1 = r0.a;
        if (r1 == null) goto L22;
        List r3 = r1.e;
        if (r3 == null) goto L22;
        ArrayList r5 = new ArrayList();
        Iterator r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L21;
        Object r6 = r4.next();
        Integer r7 = ((w) r6).s;
        if (r7 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        if (r8 == false) goto L11;
        r5.add(r6);
        goto L11
    L16:
        if (r7.intValue() != 1) goto L18;
        r8 = true;
        goto L19
    L21:
        ArrayList r12 = r5;
    L23:
        l0 r9 = this.p;
        if (r9 == null) goto L28;
        com.larus.bmhome.actionbar.model.h r10 = r9.a;
        if (r10 == null) goto L28;
        com.larus.bmhome.actionbar.model.h r11 = com.larus.bmhome.actionbar.model.h.a(r10, null, null, null, r12, null, null, 4079);
    L29:
        l0 r13 = this.p;
        if (r13 == null) goto L48;
        com.larus.bmhome.actionbar.model.h r14 = r13.b;
        if (r14 == null) goto L48;
        List r15 = r14.e;
        if (r15 == null) goto L48;
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.iterator();
    L37:
        if (r17.hasNext() == false) goto L47;
        Object r18 = r17.next();
        Integer r19 = ((w) r18).s;
        if (r19 != null) goto L42;
    L44:
        boolean r20 = false;
    L45:
        if (r20 == false) goto L37;
        r16.add(r18);
        goto L37
    L42:
        if (r19.intValue() != 1) goto L44;
        r20 = true;
        goto L45
    L47:
        ArrayList r110 = r16;
    L49:
        l0 r21 = this.p;
        if (r21 == null) goto L54;
        com.larus.bmhome.actionbar.model.h r22 = r21.b;
        if (r22 == null) goto L54;
        com.larus.bmhome.actionbar.model.h r23 = com.larus.bmhome.actionbar.model.h.a(r22, null, null, null, r110, null, null, 4079);
    L55:
        l0 r24 = this.p;
        if (r24 == null) goto L74;
        com.larus.bmhome.actionbar.model.h r25 = r24.c;
        if (r25 == null) goto L74;
        List r26 = r25.e;
        if (r26 == null) goto L74;
        ArrayList r27 = new ArrayList();
        Iterator r28 = r26.iterator();
    L63:
        if (r28.hasNext() == false) goto L73;
        Object r29 = r28.next();
        Integer r30 = ((w) r29).s;
        if (r30 != null) goto L68;
    L70:
        boolean r31 = false;
    L71:
        if (r31 == false) goto L63;
        r27.add(r29);
        goto L63
    L68:
        if (r30.intValue() != 1) goto L70;
        r31 = true;
        goto L71
    L73:
        ArrayList r111 = r27;
    L75:
        l0 r32 = this.p;
        if (r32 == null) goto L80;
        com.larus.bmhome.actionbar.model.h r112 = r32.c;
        if (r112 == null) goto L80;
        com.larus.bmhome.actionbar.model.h r33 = com.larus.bmhome.actionbar.model.h.a(r112, null, null, null, r111, null, null, 4079);
    L81:
        l0 r34 = this.p;
        if (r34 == null) goto L84;
        l0 r35 = l0.d(r34, r11, r23, r33, 24);
    L95:
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L87
        Object r37 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(l0.Companion.serializer()), r35));     // Catch: Throwable -> L87
    L90:
        if (Result.isFailure-impl(r37) == true) goto L94;
        r2 = r37;
    L94:
        return (String) r2;
    L87:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L90
    L84:
        r35 = null;
    L80:
        r33 = null;
    L74:
        r111 = null;
    L54:
        r23 = null;
    L48:
        r110 = null;
    L28:
        r11 = null;
    L22:
        r12 = null;
        goto L23
    }

    public static void q(com.larus.bmhome.actionbar.model.h r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r(r5) == false) goto L7;
        return;
    L7:
        List r0 = r5.e;
        w r1 = null;
        if (r0 == null) goto L17;
        Iterator r2 = r0.iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((w) r3).a, r5.g) == false) goto L11;
    L16:
        w r4 = (w) r3;
    L18:
        if (r4 == null) goto L21;
        u(r5, r4.a);
        return;
    L21:
        List r6 = r5.e;
        if (r6 == null) goto L28;
        Integer r7 = r5.f;
        if (r7 == null) goto L26;
        int r8 = r7.intValue();
    L27:
        r1 = (w) CollectionsKt.getOrNull(r6, r8);
        goto L28
    L26:
        r8 = -1;
    L28:
        if (r1 == null) goto L34;
        u(r5, r1.a);
        return;
    L34:
        return;
    L15:
        r3 = null;
        goto L16
    L17:
        r4 = null;
        goto L18
    }

    public static boolean r(com.larus.bmhome.actionbar.model.h r3) {
        if (r3 == null) goto L32;
        List r4 = r3.e;
        if (r4 == null) goto L33;
        List r5 = r4;
        if ((r5 instanceof Collection) == true) goto L9;
    L11:
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L23;
        Integer r1 = ((w) r6.next()).s;
        if (r1 != null) goto L18;
    L20:
        boolean r2 = false;
    L21:
        if (r2 == false) goto L13;
        boolean r7 = true;
    L24:
        if (r7 != true) goto L34;
        return true;
    L34:
        return false;
    L18:
        if (r1.intValue() != 1) goto L20;
        r2 = true;
    L23:
        r7 = false;
        goto L24
    L9:
        if (r5.isEmpty() == false) goto L11;
    L33:
        return false;
    L32:
        return false;
    }

    public static String v(String r2) {
        return FlowRuntime.b().h().getUserId() + '-' + r2;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r8) {
        Intrinsics.checkNotNullParameter(r8, "action");
        if ((r8 instanceof w0) == false) goto L37;
        w0 r9 = (w0) r8;
        TranslatorSelectorType r0 = r9.c;
        int[] r1 = b.a;
        int r2 = r1[r0.ordinal()];
        if (r2 == 1) goto L16;
        if (r2 == 2) goto L13;
        if (r2 != 3) goto L12;
        l0 r3 = this.p;
        if (r3 == null) goto L19;
        com.larus.bmhome.actionbar.model.h r4 = r3.c;
    L21:
        if (u(r4, Long.valueOf(r9.d)) == false) goto L38;
        int r5 = r1[r9.c.ordinal()];
        if (r5 == 1) goto L35;
        if (r5 == 2) goto L29;
        if (r5 != 3) goto L28;
        p(r4);
        goto L35
    L28:
        throw new NoWhenBranchMatchedException();
    L29:
        String r6 = v("selected_target_language");
        long r7 = r9.d;
        if (com.flow.kmp.common.thread.a.a() == false) goto L34;
        gb6.c r10 = (gb6.c) this.q.getValue();
        if (r10 == null) goto L35;
        r10.storeLong(r6, r7);
        goto L35
    L34:
        BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new TranslatorController$storeLong$$inlined$runOnMainThreadIfNeed$1(null, this, r6, r7));
    L35:
        j();
        return;
    L38:
        return;
    L19:
        r4 = null;
        goto L21
    L12:
        throw new NoWhenBranchMatchedException();
    L13:
        l0 r11 = this.p;
        if (r11 == null) goto L19;
        r4 = r11.b;
        goto L21
    L16:
        l0 r12 = this.p;
        if (r12 == null) goto L19;
        r4 = r12.a;
        goto L21
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r14) {
        boolean r0 = true;
        if (r14 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r15 = Result.constructor-impl((l0) xt7.d.b.c(l0.Companion.serializer(), r14));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r15);
        if (r4 != null) goto L111;
        l0 r16 = (l0) r15;
        Object r5 = null;
        if (r16 == null) goto L21;
        com.larus.bmhome.actionbar.model.h r6 = r16.a;
    L22:
        if (r6 == null) goto L109;
        if (r16.b == null) goto L109;
        this.p = r16;
        q(r16.a);
        l0 r17 = this.p;
        if (r17 == null) goto L29;
        com.larus.bmhome.actionbar.model.h r18 = r17.b;
    L31:
        if (r(r18) == true) goto L43;
        String r7 = v("selected_target_language");
        if (com.flow.kmp.common.thread.a.a() == false) goto L39;
        gb6.c r8 = (gb6.c) this.q.getValue();
        if (r8 == null) goto L37;
        long r9 = r8.getLong(r7, -1);
    L38:
        Object r10 = Long.valueOf(r9);
    L40:
        long r11 = ((Number) r10).longValue();
        if (r11 == (-1)) goto L43;
        u(r18, Long.valueOf(r11));
        goto L43
    L37:
        r9 = -1;
        goto L38
    L39:
        r10 = BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new TranslatorController$getLong$$inlined$runOnMainThreadIfNeed$1(null, this, r7, -1));
    L43:
        q(r18);
        l0 r19 = this.p;
        if (r19 == null) goto L46;
        com.larus.bmhome.actionbar.model.h r110 = r19.c;
    L47:
        if (r110 == null) goto L49;
        List r12 = r110.e;
    L50:
        List r13 = r12;
        if (r13 != null) goto L53;
    L56:
        boolean r20 = true;
    L58:
        if (r20 == false) goto L61;
        t(v("selected_translator_mode"), "-1");
    L107:
        return new wa8.a0(Boolean.TRUE, "");
    L61:
        if (r(r110) == false) goto L114;
        p(r110);
        goto L107
    L114:
        Object r21 = FlowRuntime.b().b().e("simultaneous_interpretation_client_configs", new d0(MapsKt.emptyMap()), false).get("enabled_simultaneous_interpretation_record_status");     // Catch: Throwable -> L81
        if ((r21 instanceof g0) == false) goto L66;
        g0 r22 = (g0) r21;     // Catch: Throwable -> L81
    L67:
        if (r22 == null) goto L71;
        Boolean r23 = ouc.k.f(r22);     // Catch: Throwable -> L81
        if (r23 == null) goto L71;
        boolean r24 = r23.booleanValue();     // Catch: Throwable -> L81
    L79:
        Object r25 = Result.constructor-impl(Boolean.valueOf(r24));     // Catch: Throwable -> L81
    L83:
        Boolean r26 = Boolean.FALSE;
        if (Result.isFailure-impl(r25) == false) goto L87;
        r25 = r26;
    L87:
        if (((Boolean) r25).booleanValue() == true) goto L89;
        s(r110, "1");
        t(v("selected_translator_mode"), "1");
        goto L107
    L89:
        String r27 = v("selected_translator_mode");
        if (com.flow.kmp.common.thread.a.a() == false) goto L94;
        gb6.c r28 = (gb6.c) this.q.getValue();
        if (r28 == null) goto L95;
        r5 = r28.getString(r27, "1");
    L95:
        String r29 = (String) r5;
        if (r29 != null) goto L98;
    L101:
        if (r0 == false) goto L103;
    L105:
        q(r110);
        p(r110);
        goto L107
    L103:
        if (Intrinsics.areEqual(r29, "1") == true) goto L105;
        s(r110, r29);
        goto L105
    L98:
        if (r29.length() == 0) goto L101;
        r0 = false;
        goto L101
    L94:
        r5 = BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new TranslatorController$getString$$inlined$runOnMainThreadIfNeed$1(null, this, r27, "1"));
    L71:
        if (r22 == null) goto L75;
        String r30 = ouc.k.g(r22);     // Catch: Throwable -> L81
        if (r30 == null) goto L75;
        Boolean r31 = StringsKt.toBooleanStrictOrNull(r30);     // Catch: Throwable -> L81
    L76:
        if (r31 == null) goto L78;
        r24 = r31.booleanValue();     // Catch: Throwable -> L81
        goto L79
    L78:
        r24 = false;
    L75:
        r31 = null;
        goto L76
    L66:
        r22 = null;
    L81:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L83
    L53:
        if (r13.isEmpty() == true) goto L56;
        r20 = false;
        goto L58
    L49:
        r12 = null;
        goto L50
    L46:
        r110 = null;
        goto L47
    L29:
        r18 = null;
    L109:
        return new wa8.a0(Boolean.FALSE, "translator source or target is null");
    L21:
        r6 = null;
        goto L22
    L111:
        return new wa8.a0(Boolean.FALSE, r4.getMessage());
    L14:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "translator is empty template");
    L5:
        if (r14.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void p(com.larus.bmhome.actionbar.model.h r4) {
        if (r4 == null) goto L25;
        List r5 = r4.e;
        if (r5 == null) goto L25;
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L17;
        Object r0 = r6.next();
        Integer r1 = ((w) r0).s;
        if (r1 == null) goto L14;
        boolean r2 = true;
        if (r1.intValue() != 1) goto L14;
    L15:
        if (r2 == false) goto L7;
    L18:
        w r3 = (w) r0;
        if (r3 == null) goto L25;
        Map r7 = r3.q;
        if (r7 == null) goto L25;
        String r8 = (String) r7.get("speaker_mode");
        if (r8 == null) goto L25;
    L26:
        t(v("selected_translator_mode"), r8);
        return;
    L14:
        r2 = false;
        goto L15
    L17:
        r0 = null;
    L25:
        r8 = "1";
        goto L26
    }

    public static void s(com.larus.bmhome.actionbar.model.h r5, String r6) {
        if (r5 == null) goto L32;
        if (r6 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L33;
        List r1 = r5.e;
        Long r2 = null;
        if (r1 == null) goto L27;
        Iterator r3 = r1.iterator();
    L15:
        if (r3.hasNext() == false) goto L23;
        Object r4 = r3.next();
        Map r7 = ((w) r4).q;
        if (r7 == null) goto L19;
        String r8 = (String) r7.get("speaker_mode");
    L21:
        if (Intrinsics.areEqual(r8, r6) == false) goto L15;
    L24:
        w r9 = (w) r4;
        if (r9 == null) goto L27;
        r2 = r9.a;
        goto L27
    L19:
        r8 = null;
        goto L21
    L23:
        r4 = null;
    L27:
        u(r5, r2);
        return;
    L33:
        return;
    L5:
        if (r6.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static boolean u(com.larus.bmhome.actionbar.model.h r4, Long r5) {
        if (r4 == null) goto L32;
        if (r5 == null) goto L32;
        List r6 = r4.e;
        if (r6 != null) goto L9;
        return false;
    L9:
        List r7 = r6;
        if ((r7 instanceof Collection) == true) goto L12;
    L14:
        Iterator r1 = r7.iterator();
    L16:
        if (r1.hasNext() == false) goto L20;
        if (Intrinsics.areEqual(((w) r1.next()).a, r5) == false) goto L16;
        boolean r2 = false;
    L21:
        if (r2 == false) goto L23;
        return false;
    L23:
        Iterator r8 = r7.iterator();
    L25:
        if (r8.hasNext() == false) goto L31;
        w r3 = (w) r8.next();
        if (Intrinsics.areEqual(r3.a, r5) == false) goto L29;
        int r9 = 1;
    L30:
        r3.s = r9;
        goto L25
    L29:
        r9 = 0;
        goto L30
    L31:
        return true;
    L20:
        r2 = true;
        goto L21
    L12:
        if (r7.isEmpty() == false) goto L14;
    L32:
        return false;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "defaultStateTemplate");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.constructor-impl((l0) xt7.d.b.c(l0.Companion.serializer(), r8));     // Catch: Throwable -> L5
    L7:
        com.larus.bmhome.actionbar.model.h r0 = null;
        if (Result.isFailure-impl(r11) == false) goto L10;
        r11 = null;
    L10:
        l0 r12 = (l0) r11;
        if (r12 != null) goto L13;
        return;
    L13:
        com.larus.bmhome.actionbar.model.h r13 = r12.a;
        if (r13 == null) goto L33;
        List r14 = r13.e;
        if (r14 == null) goto L33;
        w r15 = (w) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L33;
        l0 r3 = this.p;
        if (r3 == null) goto L33;
        com.larus.bmhome.actionbar.model.h r4 = r3.a;
        if (r4 == null) goto L33;
        List r5 = r4.e;
        if (r5 == null) goto L33;
        Iterator r6 = r5.iterator();
    L27:
        if (r6.hasNext() == false) goto L33;
        w r7 = (w) r6.next();
        if (Intrinsics.areEqual(r7.a, r15.a) == false) goto L31;
        int r16 = 1;
    L32:
        r7.s = r16;
        goto L27
    L31:
        r16 = 0;
    L33:
        com.larus.bmhome.actionbar.model.h r17 = r12.b;
        if (r17 == null) goto L53;
        List r18 = r17.e;
        if (r18 == null) goto L53;
        w r19 = (w) CollectionsKt.firstOrNull(r18);
        if (r19 == null) goto L53;
        l0 r20 = this.p;
        if (r20 == null) goto L53;
        com.larus.bmhome.actionbar.model.h r21 = r20.b;
        if (r21 == null) goto L53;
        List r22 = r21.e;
        if (r22 == null) goto L53;
        Iterator r23 = r22.iterator();
    L47:
        if (r23.hasNext() == false) goto L53;
        w r24 = (w) r23.next();
        if (Intrinsics.areEqual(r24.a, r19.a) == false) goto L51;
        int r25 = 1;
    L52:
        r24.s = r25;
        goto L47
    L51:
        r25 = 0;
    L53:
        com.larus.bmhome.actionbar.model.h r26 = r12.c;
        if (r26 == null) goto L89;
        List r27 = r26.e;
        if (r27 == null) goto L90;
        w r28 = (w) CollectionsKt.firstOrNull(r27);
        if (r28 == null) goto L91;
        l0 r29 = this.p;
        if (r29 == null) goto L73;
        com.larus.bmhome.actionbar.model.h r30 = r29.c;
        if (r30 == null) goto L73;
        List r31 = r30.e;
        if (r31 == null) goto L73;
        Iterator r32 = r31.iterator();
    L67:
        if (r32.hasNext() == false) goto L73;
        w r33 = (w) r32.next();
        if (Intrinsics.areEqual(r33.a, r28.a) == false) goto L71;
        int r34 = 1;
    L72:
        r33.s = r34;
        goto L67
    L71:
        r34 = 0;
    L73:
        l0 r35 = this.p;
        if (r35 == null) goto L76;
        r0 = r35.c;
    L76:
        p(r0);
        return;
    L91:
        return;
    L90:
        return;
    L89:
        return;
    L5:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void t(String r4, String r5) {
        if (com.flow.kmp.common.thread.a.a() == false) goto L7;
        gb6.c r0 = (gb6.c) this.q.getValue();
        if (r0 == null) goto L9;
        r0.storeString(r4, r5);
        return;
    L9:
        return;
    L7:
        BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new TranslatorController$storeString$$inlined$runOnMainThreadIfNeed$1(null, this, r4, r5));
    }
}
