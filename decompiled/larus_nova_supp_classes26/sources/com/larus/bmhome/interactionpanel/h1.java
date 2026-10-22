package com.larus.bmhome.interactionpanel;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.thread.ThreadData;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h1 implements Runnable {
    public final /* synthetic */ ThreadInteractionPanelMessageSourceComponent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;

    public /* synthetic */ h1(ThreadInteractionPanelMessageSourceComponent r1, String r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.bmhome.interactionpanel.ThreadInteractionPanelMessageSourceComponent] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() {
        ?? r0 = this.a;
        String r7 = this.b;
        List r1 = this.c;
        ThreadData r2 = r0.n;
        w r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getSourceConversationId();
    L6:
        String r5 = "";
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        if (StringsKt.isBlank(r4) == false) goto L20;
        fe8.c r6 = r0.h3();
        if (r6 == null) goto L16;
        ThreadData r8 = r6.VE();
        if (r8 == null) goto L16;
        r4 = r8.getSourceConversationId();
    L17:
        if (r4 != null) goto L20;
        r4 = "";
    L16:
        r4 = null;
    L20:
        if (StringsKt.isBlank(r4) == false) goto L27;
        fe8.a r9 = r0.Y2();
        if (r9 == null) goto L24;
        r4 = r9.K();
    L25:
        if (r4 != null) goto L27;
        r4 = "";
        goto L27
    L24:
        r4 = null;
    L27:
        ThreadData r10 = r0.n;
        if (r10 == null) goto L30;
        String r11 = r10.getThreadId();
    L31:
        if (r11 != null) goto L34;
        r11 = "";
    L34:
        if (StringsKt.isBlank(r11) == false) goto L44;
        fe8.c r12 = r0.h3();
        if (r12 == null) goto L40;
        ThreadData r13 = r12.VE();
        if (r13 == null) goto L40;
        r11 = r13.getThreadId();
    L41:
        if (r11 != null) goto L44;
        r11 = "";
    L40:
        r11 = null;
    L44:
        if (StringsKt.isBlank(r11) == false) goto L51;
        fe8.a r14 = r0.Y2();
        if (r14 == null) goto L48;
        r11 = r14.Kd();
    L49:
        if (r11 != null) goto L51;
    L53:
        if (StringsKt.isBlank(r4) == false) goto L55;
    L97:
        FLogger.a.w("ThreadInteractionPanelSource", "[" + r7 + "] skip sync, conversationId=" + r4 + ", threadId=" + r5);
        return;
    L55:
        if (StringsKt.isBlank(r5) == true) goto L97;
        String r15 = r0.o;
        String r16 = r0.p;
        boolean r17 = false;
        if (r15 != null) goto L60;
    L63:
        boolean r18 = true;
    L64:
        if (r18 == true) goto L77;
        if (r16 != null) goto L67;
    L68:
        r17 = true;
    L69:
        if (r17 == true) goto L77;
        if (Intrinsics.areEqual(r15, r4) == true) goto L74;
    L76:
        r0.q = CollectionsKt.emptyList();
        r0.m.i(r15, r16, CollectionsKt.emptyList(), r7 + "_thread_scope_changed");
        goto L77
    L74:
        if (Intrinsics.areEqual(r16, r5) == false) goto L76;
    L67:
        if (StringsKt.isBlank(r16) == false) goto L69;
    L77:
        boolean r19 = e.a(r1);
        if (r19 == false) goto L85;
        ?? r110 = new ArrayList();
        Iterator r20 = r1.iterator();
    L81:
        if (r20.hasNext() == false) goto L86;
        Object r111 = r20.next();
        if ((!com.larus.bmhome.chat.bean.d.j0((Message) r111)) == false) goto L81;
        r110.add(r111);
    L86:
        fe8.a r21 = r0.Y2();
        if (r21 == null) goto L89;
        r3 = r21.vF();
    L89:
        w r22 = r3;
        if (r19 == true) goto L92;
        List r23 = CollectionsKt.distinct(CollectionsKt.plus(r0.q, r0.p3(r4, r5, r1, r22)));
        r0.m.m(r4, r5, r23, r7 + "_streaming_finished");
    L92:
        r0.o = r4;
        r0.p = r5;
        if (r19 == false) goto L95;
        List<o> r24 = r0.p3(r4, r5, r110, r22);
    L96:
        r0.q = r24;
        r0.m.k(r4, r5, r110, r7, r22);
        FLogger.a.d("ThreadInteractionPanelSource", "[" + r7 + "] sync thread message snapshot, messageCount=" + r110.size());
        return;
    L95:
        r24 = CollectionsKt.emptyList();
        goto L96
    L85:
        r110 = CollectionsKt.emptyList();
        goto L86
    L60:
        if (StringsKt.isBlank(r15) == true) goto L63;
        r18 = false;
        goto L64
    L48:
        r11 = null;
    L51:
        r5 = r11;
        goto L53
    L30:
        r11 = null;
        goto L31
    L5:
        r4 = null;
        goto L6
    }
}
