package com.larus.bmhome.chat.component.list;

import android.os.SystemClock;
import com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import wr8.d;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ h(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r8) {
        ChatListComponent r0 = this.a;
        com.larus.bmhome.social.page.datasource.event.c r9 = (com.larus.bmhome.social.page.datasource.event.c) r8;
        if (r9 == null) goto L64;
        com.larus.platform.api.e0 r1 = (com.larus.platform.api.e0) r0.Z.getValue();
        if (r1 == null) goto L7;
        r0.f1().g();
        r1.b();
    L7:
        CompletableDeferred r2 = d.a;
        d.b.c("preload msg has consumed");
        Iterator r3 = CollectionsKt.take(r9.a, 4).iterator();
    L8:
        String r4 = "";
        if (r3.hasNext() == false) goto L15;
        b r5 = (b) r3.next();
        ChatMessageCostTrace r6 = ChatMessageCostTrace.a;
        String r7 = r5.getMessage().getLocalMessageId();
        if (r7 == null) goto L14;
        r4 = r7;
    L14:
        long r10 = SystemClock.elapsedRealtime();
        r6.getClass();
        ChatMessageCostTrace.h(r4, "handleMessageEventFlow", r10);
        goto L8
    L15:
        FLogger.a.i(r0.o, "messageEventFlowWithSeparators V2 onEach: " + r9);
        com.larus.bmhome.social.page.datasource.event.c r11 = r0.d4(r9);
        LarusPageChatBinding r12 = r0.h4();
        if (r12 == null) goto L20;
        ChatMessageList r13 = r12.n;
        if (r13 == null) goto L20;
        r13.setToppingPageScopeId(r0.R5());
    L20:
        ConcurrentHashMap r14 = com.larus.bmhome.utils.v3.a;
        com.larus.bmhome.utils.v3.g(r11, new ChatListComponent$handleColdLaunchMessageEventFlow$2(r0), r0.R5());
        com.larus.bmhome.social.page.datasource.event.c r15 = com.larus.bmhome.utils.v3.c(r11, r0.R5());
        b r16 = (b) CollectionsKt.firstOrNull(r15.a);
        if (r16 == null) goto L46;
        Message r17 = r16.getMessage();
        if (r17 == null) goto L46;
        wc9.e r18 = r0.R4();
        StringBuilder r19 = new StringBuilder();
        if (r18 == null) goto L28;
        String r20 = r18.a;
        if (r20 == null) goto L28;
    L31:
        r19.append(r20);
        r19.append(':');
        if (r18 == null) goto L37;
        String r21 = r18.B;
        if (r21 == null) goto L37;
        r4 = r21;
    L41:
        r19.append(r4);
        String r22 = r19.toString();
        dh8.b r23 = dh8.b.a;
        List r24 = r15.a;
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r26 = r24.iterator();
    L43:
        if (r26.hasNext() == false) goto L45;
        r25.add(((b) r26.next()).getMessage());
        goto L43
    L45:
        r23.getClass();
        dh8.b.k(r22, r25);
    L37:
        String r27 = r17.getSectionId();
        if (r27 == null) goto L41;
        r4 = r27;
    L28:
        r20 = r17.getConversationId();
        if (r20 != null) goto L31;
        r20 = "";
    L46:
        r0.P7(r15);
        zd8.b r28 = (zd8.b) r0.x2.getValue();
        Message r29 = null;
        if (r28 == null) goto L57;
        b r30 = (b) CollectionsKt.firstOrNull(r15.a);
        if (r30 == null) goto L51;
        Message r31 = r30.getMessage();
    L52:
        List r32 = r15.a;
        ArrayList r33 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r32, 10));
        Iterator r34 = r32.iterator();
    L54:
        if (r34.hasNext() == false) goto L56;
        r33.add(((b) r34.next()).getMessage());
        goto L54
    L56:
        r28.Xt(r31, r33);
        goto L57
    L51:
        r31 = null;
    L57:
        com.larus.bmhome.chat.component.receive.m0 r35 = (com.larus.bmhome.chat.component.receive.m0) r0.P2.getValue();
        if (r35 == null) goto L60;
        r35.yy();
    L60:
        BuildersKt.runBlocking$default(null, new ChatListComponent$handleColdLaunchMessageEventFlow$5(r0, r15, null), 1, null);
        b r36 = (b) CollectionsKt.firstOrNull(r15.a);
        if (r36 == null) goto L63;
        r29 = r36.getMessage();
    L63:
        r0.R7(r29);
        r0.TP(false);
    L66:
        return Unit.INSTANCE;
    L64:
        int r37 = ChatListComponent.W3;
        goto L66
    }
}
