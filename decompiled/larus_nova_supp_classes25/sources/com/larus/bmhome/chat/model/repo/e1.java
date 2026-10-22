package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ReferenceInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e1 implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ String d;
    public final /* synthetic */ ReferenceInfo e;
    public final /* synthetic */ ChatSender f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ List j;
    public final /* synthetic */ MessageStatus k;
    public final /* synthetic */ Function2 l;
    public final /* synthetic */ boolean m;
    public final /* synthetic */ String n;
    public final /* synthetic */ ChatPageContext o;
    public final /* synthetic */ Long p;

    public /* synthetic */ e1(String r3, String r4, Map r5, String r6, ReferenceInfo r7, ChatSender r8, String r9, String r10, String r11, List r12, MessageStatus r13, Function2 r14, boolean r15, String r16, ChatPageContext r17, Long r18) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
    }

    public final Object invoke() {
        String r1 = this.a;
        String r4 = this.b;
        Map r3 = this.c;
        String r2 = this.d;
        ReferenceInfo r13 = this.e;
        ChatSender r5 = this.f;
        String r6 = this.g;
        String r7 = this.h;
        String r8 = this.i;
        List r9 = this.j;
        MessageStatus r10 = this.k;
        Function2 r11 = this.l;
        boolean r12 = this.m;
        String r14 = this.n;
        ChatPageContext r15 = this.o;
        Long r16 = this.p;
        ko8.b.a(r1, r4);
        if (r3 == null) goto L5;
        String r17 = (String) r3.get("enter_method_trace");
    L6:
        boolean r18 = true;
        if (r17 != null) goto L9;
    L12:
        boolean r20 = true;
    L13:
        if (r20 == true) goto L15;
        ChatControlTrace.b.getClass();
        ChatControlTrace.G.put(r4, r17);
    L15:
        if (r3 == null) goto L17;
        String r0 = (String) r3.get("trace_item_type");
    L19:
        if (com.larus.utils.o0.d(r0) == false) goto L21;
        ChatControlTrace.b.Ga(r4, r0);
    L21:
        com.larus.bmhome.chat.trace.z r19 = com.larus.bmhome.chat.trace.z.a;
        Intrinsics.checkNotNullParameter(r4, "messageId");
        if (r2 != null) goto L24;
    L27:
        if (r18 == true) goto L40;
        Iterator r21 = com.larus.bmhome.chat.trace.z.b.iterator();
    L31:
        if (r21.hasNext() == false) goto L36;
        Object r22 = r21.next();
        Iterator r110 = r21;
        if (Intrinsics.areEqual(((com.larus.bmhome.chat.trace.z.a) r22).a, r2) == true) goto L37;
        r21 = r110;
    L37:
        com.larus.bmhome.chat.trace.z.a r23 = (com.larus.bmhome.chat.trace.z.a) r22;
        if (r23 == null) goto L40;
        r23.c = r4;
        goto L40
    L36:
        r22 = null;
    L40:
        if (r13 == null) goto L42;
        Map r24 = r13.getTraceExtra();
    L43:
        if (r24 == null) goto L69;
        Map r25 = r13.getTraceExtra();
        if (r25 == null) goto L50;
        Object r26 = r25.get("suggested_click_from");
        if (r26 != null) goto L49;
        r26 = null;
    L49:
        String r27 = (String) r26;
    L51:
        Map r28 = r13.getTraceExtra();
        if (r28 == null) goto L54;
        String r29 = (String) r28.get("deep_research_id");
    L55:
        Map r30 = r13.getTraceExtra();
        if (r30 == null) goto L58;
        String r31 = (String) r30.get("deep_research_phase");
    L59:
        ChatControlTrace r111 = ChatControlTrace.b;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r4, "msgId");
        ChatControlTrace.Z.put(r4, new ChatControlTrace.a(r27, r29, r31));
        Map r32 = r13.getTraceExtra();
        if (r32 == null) goto L66;
        Object r33 = r32.get("suggested_item_id");
        if (r33 != null) goto L64;
        Object r34 = null;
    L65:
        String r35 = (String) r34;
    L67:
        r111.qb(r4, r35);
        goto L69
    L64:
        r34 = r33;
        goto L65
    L66:
        r35 = null;
        goto L67
    L58:
        r31 = null;
        goto L59
    L54:
        r29 = null;
        goto L55
    L50:
        r27 = null;
    L69:
        BuildersKt.launch$default(r5.b, null, null, new ChatSender$sendTextNew$sendAction$1$1(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, null), 3, null);
        return Unit.INSTANCE;
    L42:
        r24 = null;
        goto L43
    L24:
        if (r2.length() == 0) goto L27;
        r18 = false;
        goto L27
    L17:
        r0 = null;
        goto L19
    L9:
        if (r17.length() == 0) goto L12;
        r20 = false;
        goto L13
    L5:
        r17 = null;
        goto L6
    }
}
