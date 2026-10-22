package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import java.util.Map;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class IConversationRepoService$a {
    public static /* synthetic */ Object d(IConversationRepoService r6, String r7, Continuation r8) {
        return r6.b(r7, 0, 50, true, r8);
    }

    public static /* synthetic */ Object g(ConversationRepo r6, String r7, OmniBreakReason r8, Continuation r9) {
        return r6.B(r7, true, false, r8, r9);
    }

    public static /* synthetic */ Object b(IConversationRepoService r1, BotModel r2, Map r3, Continuation r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        return r1.k(r2, r3, null, r4);
    }

    public static /* synthetic */ Object e(IConversationRepoService r2, String r3, String r4, Continuation r5, int r6) {
        String r1 = "";
        if ((r6 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = "";
    L9:
        if ((r6 & 4) != 0) goto L13;
        r1 = null;
    L13:
        return r2.j(r3, r4, r1, r5);
    }

    public static /* synthetic */ Object c(IConversationRepoService r1, String r2, boolean r3, String r4, Continuation r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = true;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r1.v(r2, r3, r4, r5);
    }

    public static /* synthetic */ void f(IConversationRepoService r1, String r2, boolean r3, boolean r4, OmniBreakReason r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = true;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = OmniBreakReason.OmniBreakReason_OTHER;
    L11:
        r1.w(r2, r3, r4, r5);
    }

    public static /* synthetic */ Object a(IConversationRepoService r14, String r15, int r16, String r17, String r18, boolean r19, String r20, String r21, String r22, Map r23, Continuation r24, int r25) {
        if ((r25 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r25 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r25 & 16) == 0) goto L13;
        boolean r8 = false;
    L15:
        if ((r25 & 32) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r25 & 64) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r25 & 128) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r25 & 256) == 0) goto L29;
        Map r12 = null;
    L31:
        return r14.t(r15, r16, r6, r7, r8, r9, r10, r11, r12, r24);
    L29:
        r12 = r23;
        goto L31
    L25:
        r11 = r22;
        goto L27
    L21:
        r10 = r21;
        goto L23
    L17:
        r9 = r20;
        goto L19
    L13:
        r8 = r19;
        goto L15
    L9:
        r7 = r18;
        goto L11
    L5:
        r6 = r17;
        goto L7
    }
}
