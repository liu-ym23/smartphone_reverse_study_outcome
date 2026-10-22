package com.larus.bmhome.chat.component.list;

import androidx.collection.LruCache;
import com.bytedance.keva.Keva;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.bmhome.chat.stop.PendingAppletActionCancellation;
import com.larus.bmhome.chat.stop.a;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i1 implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ i1(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r1 = this.a;
        a r2 = r1.h1;
        if (r2 == null) goto L85;
        Message r3 = r2.a;
        Message r4 = r2.b;
        String r5 = r1.k1;
        final x1 r6 = r1.U5().getReader();
        com.larus.utils.t0.a(new s1(r6));
        ChatControlTrace r7 = ChatControlTrace.b;
        String r12 = r1.getBotId();
        boolean r8 = r1.pl();
        r7.getClass();
        if (r3 == null) goto L23;
        String r9 = com.larus.bmhome.utils.x3.a;
        String r10 = r3.getConversationId();
        String r11 = r3.getMessageId();
        if (r10 == null) goto L14;
        if (r11 == null) goto L14;
        ((Keva) com.larus.bmhome.utils.x3.b.getValue()).storeString(r10, r11);
    L14:
        long r13 = System.currentTimeMillis() - ChatControlTrace.i0;
        String r14 = r3.getSectionId();
        String r15 = r3.getConversationId();
        LruCache r16 = ChatControlTrace.o;
        String r17 = r3.getConversationId();
        if (r17 != null) goto L17;
        String r0 = "";
    L18:
        wc9.e r18 = (wc9.e) r16.get(r0);
        if (r18 == null) goto L21;
        String r19 = ic8.n.f(r18);
    L22:
        String r110 = r19;
        tx9.b0.a("stop", "chat", "input", null, r14, r12, r15, r110, ve8.c.b(r8), r13 / 1000, null, 3080);
        goto L23
    L21:
        r19 = null;
        goto L22
    L17:
        r0 = r17;
    L23:
        by7.a r20 = new by7.a("break_message");
        TrackParams r21 = new TrackParams();
        JSONObject r22 = new JSONObject();
        r22.put("click_from", "click_break_message");
        String r23 = r3.getConversationId();
        if (r23 != null) goto L26;
        r23 = "";
    L26:
        boolean r111 = true;
        if (r23.length() != 0) goto L29;
        boolean r24 = true;
    L30:
        if (r24 == false) goto L34;
        r23 = r1.G4();
        if (r23 != null) goto L34;
        r23 = "";
    L34:
        r22.put("conversation_id", r23);
        r22.put("current_page", "chat");
        String r25 = r3.getMessageId();
        if (r25 != null) goto L38;
        r25 = "";
    L38:
        if (r25.length() != 0) goto L40;
        boolean r26 = true;
    L41:
        if (r26 == false) goto L45;
        r25 = r3.getLocalMessageId();
        if (r25 != null) goto L45;
        r25 = "";
    L45:
        r22.put("message_id", r25);
        if (r5 != null) goto L48;
        String r27 = "";
    L49:
        r22.put("scene", r27);
        String r28 = r3.getSectionId();
        if (r28 != null) goto L53;
        r28 = "";
    L53:
        if (r28.length() != 0) goto L55;
        boolean r29 = true;
    L56:
        if (r29 == false) goto L61;
        r28 = r4.getSectionId();
        if (r28 != null) goto L61;
        r28 = "";
    L61:
        if (r28.length() == 0) goto L64;
        r111 = false;
    L64:
        if (r111 == false) goto L71;
        wc9.e r30 = r1.R4();
        if (r30 == null) goto L68;
        r28 = r30.B;
    L69:
        if (r28 != null) goto L71;
        r28 = "";
        goto L71
    L68:
        r28 = null;
    L71:
        r22.put("section_id", r28);
        Unit r31 = Unit.INSTANCE;
        TrackParams r32 = r21.merge(r22);
        r20.a.merge(r32);
        r20.b();
        PendingAppletActionCancellation.a.a(r2, r5);
        RepoDispatcher.a.getClass();
        ChatRepo r33 = RepoDispatcher.d;
        String r34 = r4.getMessageId();
        if (r34 != null) goto L74;
        r34 = "";
    L74:
        r33.r1(r34, new t1());
        String r112 = r1.G4();
        if (r112 == null) goto L84;
        ConversationRepo r113 = RepoDispatcher.f;
        wc9.e r35 = r1.R4();
        if (r35 == null) goto L81;
        Integer r36 = r35.j;
        if (r36 == null) goto L81;
        int r114 = r36.intValue();
    L82:
        ConversationRepo.C(r113, r112, r114, r2.c, false, false, OmniBreakReason.OmniBreakReason_CLICK_BREAK_BUTTON, 88);
    L81:
        r114 = 0;
    L84:
        return Unit.INSTANCE;
    L55:
        r29 = false;
        goto L56
    L48:
        r27 = r5;
        goto L49
    L40:
        r26 = false;
        goto L41
    L29:
        r24 = false;
        goto L30
    L85:
        return Unit.INSTANCE;
    }
}
