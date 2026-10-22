package com.larus.bmhome.interactionpanel;

import com.larus.bmhome.clarification.j2;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.thread.ThreadMessageListRequest;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u {
    public final Function0<j2> a;
    public final Function0<tp8.a> b;
    public final g c;
    public final Function1<m, t> d;
    public com.larus.bmhome.interactionpanel.a e;
    public k f;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[InteractionPanelType.values().length];
            r0[InteractionPanelType.CLARIFICATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[InteractionPanelType.INPUT_AREA_BLOCK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final m c(m r50) {
        t r2 = (t) this.d.invoke(r50);
        if (r2 != null) goto L7;
        return null;
    L7:
        if ((r2 instanceof t.b) == false) goto L16;
        t.b r3 = (t.b) r2;
        Message r4 = r3.a;
        if (Intrinsics.areEqual(r4.getConversationId(), r50.a.a) == true) goto L11;
    L13:
        o r6 = r50.a;
        r4 = Message.copy$default(r4, r6.a, r6.b, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4, 31, null);
    L14:
        List<Block> r5 = r3.b;
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "blocks");
        t r7 = new t.b(r4, r5);
    L19:
        return m.a(r50, null, r7, null, 0, null, null, null, null, 2035);
    L11:
        if (Intrinsics.areEqual(r4.getThreadId(), r50.a.b) == false) goto L13;
    L16:
        if ((r2 instanceof t.a) == false) goto L21;
        r7 = r2;
        goto L19
    L21:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(m r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        if (r4 == null) goto L7;
        o r6 = r4.a;
        if (r6 == null) goto L7;
        InteractionPanelType r7 = r6.d;
    L9:
        if (r7 != null) goto L11;
        int r8 = -1;
    L13:
        if (r8 != (-1)) goto L15;
        com.larus.bmhome.interactionpanel.a r9 = this.e;
        if (r9 == null) goto L35;
        Intrinsics.checkNotNullParameter(r5, "reason");
        r9.c.incrementAndGet();
        r9.a.MY(r5, false);
    L38:
        k r10 = this.f;
        if (r10 == null) goto L41;
        Intrinsics.checkNotNullParameter(r5, "reason");
        r10.c.incrementAndGet();
        r10.a.g0(r5);
        return;
    L41:
        tp8.a r11 = (tp8.a) this.b.invoke();
        if (r11 == null) goto L52;
        r11.g0(r5);
        return;
    L52:
        return;
    L35:
        j2 r12 = (j2) this.a.invoke();
        if (r12 == null) goto L38;
        r12.MY(r5, false);
        goto L38
    L15:
        if (r8 != 1) goto L17;
        com.larus.bmhome.interactionpanel.a r13 = this.e;
        if (r13 == null) goto L29;
        Intrinsics.checkNotNullParameter(r5, "reason");
        r13.c.incrementAndGet();
        r13.a.MY(r5, false);
        return;
    L29:
        j2 r14 = (j2) this.a.invoke();
        if (r14 == null) goto L49;
        r14.MY(r5, false);
        return;
    L49:
        return;
    L17:
        if (r8 != 2) goto L25;
        k r15 = this.f;
        if (r15 == null) goto L21;
        Intrinsics.checkNotNullParameter(r5, "reason");
        r15.c.incrementAndGet();
        r15.a.g0(r5);
        return;
    L21:
        tp8.a r16 = (tp8.a) this.b.invoke();
        if (r16 == null) goto L46;
        r16.g0(r5);
        return;
    L46:
        return;
    L25:
        throw new NoWhenBranchMatchedException();
    L11:
        r8 = b.a[r7.ordinal()];
    L7:
        r7 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(m r22, String r23) {
        Intrinsics.checkNotNullParameter(r22, "entry");
        Intrinsics.checkNotNullParameter(r23, "hostId");
        m r4 = c(r22);
        if (r4 != null) goto L6;
        FLogger.a.w("InteractionPanelRenderer", "skip render, host payload unavailable, key=" + r22.a + ", hostId=" + r23);
        return false;
    L6:
        int r1 = b.a[r4.a.d.ordinal()];
        Object r9 = null;
        if (r1 != 1) goto L9;
        j2 r2 = (j2) this.a.invoke();
        if (r2 != null) goto L50;
        FLogger.a.w("InteractionPanelRenderer", "clarification ability unavailable, key=" + r4.a);
        return false;
    L50:
        com.larus.bmhome.interactionpanel.a r6 = this.e;
        if (r6 != null) goto L53;
    L60:
        com.larus.bmhome.interactionpanel.a r7 = new com.larus.bmhome.interactionpanel.a(r2, this.c);
        this.e = r7;
        com.larus.bmhome.interactionpanel.a r8 = r7;
    L61:
        Intrinsics.checkNotNullParameter(r4, "entry");
        Intrinsics.checkNotNullParameter(r23, "hostId");
        t r3 = r4.c;
        if (r3 != null) goto L66;
        r3 = r4.d;
        if (r3 != null) goto L66;
        FLogger.a.w("ClarificationPanelAdapter", "skip clarification show, payload empty, key=" + r4.a);
        return false;
    L66:
        int r10 = r8.c.incrementAndGet();
        if ((r3 instanceof t.b) == false) goto L71;
        boolean r5 = r8.a(r4, r23, ((t.b) r3).a, r10);
    L84:
        return r5;
    L71:
        if ((r3 instanceof t.a) == false) goto L79;
        t.a r11 = (t.a) r3;
        String r12 = r11.d;
        if (StringsKt.isBlank(r12) == false) goto L75;
        FLogger.a.w("ClarificationPanelAdapter", "skip clarification show, messageId empty, key=" + r4.a);
        r8.b.e(r4.a, "clarification_message_id_empty");
        return false;
    L75:
        com.larus.im.d.e().q(new ThreadMessageListRequest(r11.b, null, 0, 50, true, 6, null), new c(r4, r12, r8, r23, r10));
    L76:
        return true;
    L79:
        throw new NoWhenBranchMatchedException();
    L53:
        if (r6.a != r2) goto L55;
        boolean r13 = true;
    L56:
        if (r13 == false) goto L58;
        r9 = r6;
    L58:
        if (r9 == null) goto L60;
        r8 = r9;
        goto L61
    L55:
        r13 = false;
        goto L56
    L9:
        if (r1 != 2) goto L45;
        tp8.a r14 = (tp8.a) this.b.invoke();
        if (r14 != null) goto L14;
        FLogger.a.w("InteractionPanelRenderer", "input area ability unavailable, key=" + r4.a);
        return false;
    L14:
        k r15 = this.f;
        if (r15 != null) goto L17;
    L24:
        k r16 = new k(r14, this.c);
        this.f = r16;
        k r17 = r16;
    L25:
        Intrinsics.checkNotNullParameter(r4, "entry");
        Intrinsics.checkNotNullParameter(r23, "hostId");
        t r18 = r4.c;
        if (r18 != null) goto L30;
        r18 = r4.d;
        if (r18 != null) goto L30;
        FLogger.a.w("InputAreaBlockPanelAdapter", "skip show, payload empty, key=" + r4.a);
        return false;
    L30:
        int r19 = r17.c.incrementAndGet();
        if ((r18 instanceof t.b) == false) goto L34;
        List<Block> r20 = k.a(r18, r4);
        r5 = r17.b(r4, r23, ((t.b) r18).a, r20, r19);
        goto L84
    L34:
        if ((r18 instanceof t.a) == false) goto L43;
        t.a r21 = (t.a) r18;
        String r24 = r21.d;
        if (StringsKt.isBlank(r24) == false) goto L38;
        FLogger.a.w("InputAreaBlockPanelAdapter", "skip cmd show, messageId empty, key=" + r4.a);
        r17.b.e(r4.a, "cmd_message_id_empty");
        return false;
    L38:
        List r110 = k.a(r21, r4);
        if (r110.isEmpty() == false) goto L41;
        FLogger.a.w("InputAreaBlockPanelAdapter", "skip cmd show, blocks empty, key=" + r4.a + ", messageId=" + r24);
        r17.b.e(r4.a, "cmd_blocks_empty");
        return false;
    L41:
        com.larus.im.d.e().q(new ThreadMessageListRequest(r21.b, null, 0, 50, true, 6, null), new l(r4, r24, r17, r23, r110, r19));
        goto L76
    L43:
        throw new NoWhenBranchMatchedException();
    L17:
        if (r15.a != r14) goto L19;
        boolean r111 = true;
    L20:
        if (r111 == false) goto L22;
        r9 = r15;
    L22:
        if (r9 == null) goto L24;
        r17 = r9;
        goto L25
    L19:
        r111 = false;
        goto L20
    L45:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean update(m r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "entry");
        Intrinsics.checkNotNullParameter(r5, "hostId");
        m r6 = c(r4);
        if (r6 != null) goto L5;
        return false;
    L5:
        InteractionPanelType r1 = r6.a.d;
        int r2 = b.a[r1.ordinal()];
        if (r2 != 1) goto L8;
        com.larus.bmhome.interactionpanel.a r3 = this.e;
        if (r3 != null) goto L15;
        return false;
    L15:
        if (r3.update(r6, r5) != true) goto L19;
        return true;
    L19:
        return false;
    L8:
        if (r2 != 2) goto L11;
        return false;
    L11:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(Function0<? extends j2> r2, Function0<? extends tp8.a> r3, g r4, Function1<? super m, ? extends t> r5) {
        Intrinsics.checkNotNullParameter(r2, "clarificationAbilityProvider");
        Intrinsics.checkNotNullParameter(r3, "inputAreaAbilityProvider");
        Intrinsics.checkNotNullParameter(r4, "manager");
        Intrinsics.checkNotNullParameter(r5, "payloadSelector");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
