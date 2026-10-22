package com.larus.extension.summary_card.impl.cell;

import android.content.Context;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.h0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.c0;
import com.larus.bmhome.view.screenmenu.f0;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.j0;
import com.larus.bmhome.view.screenmenu.s0;
import com.larus.bmhome.view.screenmenu.u0;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import tx9.t1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class SummaryCardCell$innerBind$1 extends FunctionReferenceImpl implements Function3<Message, BotModel, CustomMarkdownTextView, Unit> {
    public SummaryCardCell$innerBind$1(Object r8) {
        super(3, r8, SummaryCardCell.class, "performLongClick", "performLongClick(Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/bot/BotModel;Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;)V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r46v0, types: [android.view.View, android.widget.TextView, com.larus.bmhome.view.textview.impl.CustomMarkdownTextView, java.lang.Object, st8.a] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.extension.summary_card.impl.cell.v, kotlin.jvm.functions.Function0] */
    public final void invoke(final Message r44, BotModel r45, CustomMarkdownTextView r46) {
        Intrinsics.checkNotNullParameter(r45, "p1");
        final SummaryCardCell r10 = (SummaryCardCell) ((CallableReference) this).receiver;
        int r0 = SummaryCardCell.k;
        r10.getClass();
        if (r44 == null) goto L97;
        String r1 = r44.getMessageId();
        boolean r11 = false;
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L98;
        if (r46 == 0) goto L99;
        hc8.c r3 = hc8.c.a;
        if (r3.j(r44) == false) goto L24;
        String r4 = r45.getBotId();
        if (r4 != null) goto L22;
        r4 = "";
    L22:
        if (r3.e(r44, r4) == true) goto L24;
        return;
    L24:
        com.larus.bmhome.chat.component.cvs.y r5 = (com.larus.bmhome.chat.component.cvs.y) r10.g.getValue();
        if (r5 == null) goto L96;
        BotModel r15 = r5.j0();
        if (r15 == null) goto L101;
        q0 r16 = lf8.a.b(r10);
        if (r16 == null) goto L102;
        ChatMessageList r17 = r16.B7();
        if (r17 == null) goto L103;
        Fragment r18 = (Fragment) r16.getHostFragment().invoke();
        q0 r6 = lf8.a.b(r10);
        String r19 = null;
        if (r6 == null) goto L40;
        h0 r7 = r6.A7();
        if (r7 == null) goto L40;
        wc9.e r9 = (wc9.e) r7.invoke();
    L41:
        com.larus.bmhome.chat.component.cvs.y r8 = (com.larus.bmhome.chat.component.cvs.y) r10.g.getValue();
        if (r8 == null) goto L48;
        wc9.e r12 = r8.h();
        if (r12 == null) goto L48;
        if (ic8.n.d(r12) != true) goto L48;
        boolean r13 = true;
    L49:
        if (r13 == true) goto L104;
        boolean r14 = z2.a.enableMessageMenuTimestamp();
        if (r14 == false) goto L54;
        final Message r20 = r10.o(r44);
    L55:
        ?? r21 = new v(r20, r10, r44);
        IAIChatService.Companion r22 = IAIChatService.a;
        t0 r23 = r22.O7(r44, r9);
        Context r24 = r46.getContext();
        if (r14 == false) goto L58;
        ?? r25 = r21;
    L59:
        q0 r26 = lf8.a.b(r10);
        q0 r27 = lf8.a.b(r10);
        if (r27 == null) goto L62;
        q0.a r28 = r27.getProvider();
    L63:
        wc9.e r29 = r9;
        List r30 = t0.a.a(r23, r24, r44, r25, r26, r15, r9, r28, null, 128);
        Context r31 = r18.getContext();
        if (r31 != null) goto L66;
        CommonMenu r32 = null;
    L77:
        if (r32 == null) goto L105;
        r22.I7(r18, r17, r46, r44, r32);
        String r210 = r15.getBotId();
        String r33 = r44.getConversationId();
        if (r33 == null) goto L82;
        Long r211 = StringsKt.toLongOrNull(r33);
    L84:
        if (com.larus.bmhome.chat.bean.d.G0(r44) == false) goto L86;
        String r34 = "user";
    L87:
        String r212 = r34;
        String r35 = r44.getMessageId();
        Boolean r36 = Boolean.valueOf(com.larus.bmhome.chat.bean.d.Q0(r44));
        by7.e r37 = by7.h.g(r46);
        LruCache<String, wc9.e> r38 = ko8.a.a;
        if (r29 == null) goto L90;
        Integer r39 = r29.v;
    L91:
        Integer r40 = r15.getBotType();
        BotCreatorInfo r41 = r15.getBotCreatorInfo();
        if (r41 == null) goto L94;
        r19 = r41.getId();
    L94:
        t1.a(r210, r211, "chat", r212, r35, r36, null, r37, null, ko8.a.f(r39, r40, Intrinsics.areEqual(r19, AccountService.a.getUserId())), null, "private", "main_text", Boolean.valueOf(com.larus.bmhome.chat.bean.d.f0(r44)), null, null, 101024);
        return;
    L90:
        r39 = null;
        goto L91
    L86:
        r34 = "assistant";
        goto L87
    L82:
        r211 = null;
        goto L84
    L105:
        return;
    L66:
        q0.a r42 = r16.getProvider();
        de8.c r43 = (de8.c) r10.f.getValue();
        if (r43 == null) goto L69;
        Integer r47 = r43.m();
    L70:
        if (r47 == null) goto L72;
        r11 = true;
    L72:
        Function1 r48 = IAIChatService.a.a(r22, r18, r17, r16, r46, null, r42, r44, r21, r11, null, 1536);
        if (r14 == false) goto L75;
        Calendar r49 = oo8.b.a;
        String r50 = oo8.b.a(((Message) r21.invoke()).getCreateTime() * 1000, true);
    L76:
        List<ot8.a> r51 = u0.b(r30, r14, r50);
        CommonMenu r52 = new CommonMenu(r31);
        r52.h(Reflection.getOrCreateKotlinClass(i0.class), new j0());
        r52.h(Reflection.getOrCreateKotlinClass(s0.class), new com.larus.bmhome.view.screenmenu.t0());
        r52.h(Reflection.getOrCreateKotlinClass(f0.class), new com.larus.bmhome.view.screenmenu.h0());
        r52.h(Reflection.getOrCreateKotlinClass(com.larus.bmhome.view.screenmenu.y.class), new c0());
        u0.a(r52, r14);
        r52.g(r51, r48);
        r48.l0(r52);
        r32 = r52;
        goto L77
    L75:
        r50 = null;
        goto L76
    L69:
        r47 = null;
        goto L70
    L62:
        r28 = null;
        goto L63
    L58:
        r25 = 0;
        goto L59
    L54:
        r20 = null;
        goto L55
    L104:
        return;
    L48:
        r13 = false;
    L40:
        r9 = null;
        goto L41
    L103:
        return;
    L102:
        return;
    L101:
        return;
    L96:
        return;
    L99:
        return;
    L98:
        return;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((Message) r1, (BotModel) r2, (CustomMarkdownTextView) r3);
        return Unit.INSTANCE;
    }
}
