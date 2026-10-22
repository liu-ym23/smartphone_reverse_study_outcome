package com.larus.bmhome.chat.component.title;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.helper.CocoSubConversationSettingMenuTrigger;
import com.larus.bmhome.chat.helper.g;
import com.larus.bmhome.chat.helper.h;
import com.larus.bmhome.chat.helper.i;
import com.larus.bmhome.chat.helper.j;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.view.menu.CreateMenuV2;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.skydoves.balloon.Balloon;
import de8.c;
import ic8.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import s1a.a;
import tx9.i3;
import v19.i5;
import wc9.e;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponent$startSettings$1$1", f = "ChatTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatTitleComponent$startSettings$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ e $conversation;
    int label;
    final /* synthetic */ ChatTitleComponent this$0;

    public ChatTitleComponent$startSettings$1$1(e r1, ChatTitleComponent r2, BotModel r3, Continuation<? super ChatTitleComponent$startSettings$1$1> r4) {
        this.$conversation = r1;
        this.this$0 = r2;
        this.$bot = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatTitleComponent$startSettings$1$1(this.$conversation, this.this$0, this.$bot, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [com.larus.bmhome.chat.helper.g] */
    public final Object invokeSuspend(Object r99) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L225;
        ResultKt.throwOnFailure(r99);
        e r1 = this.$conversation;
        if (r1 == null) goto L9;
        Long r2 = r1.o;
        if (r2 == null) goto L9;
        long r3 = r2.longValue();
    L11:
        if (r3 > 1) goto L41;
        ChatTitleComponent r4 = this.this$0;
        int r5 = ChatTitleComponent.P1;
        u7 r6 = r4.X3();
        if (r6 == null) goto L15;
        MessageAdapter r7 = r6.MF();
    L17:
        if ((r7 instanceof MessageAdapter) == true) goto L20;
        r7 = null;
    L20:
        if (r7 == null) goto L37;
        List<b> r8 = r7.z2();
        if (r8 == null) goto L37;
        List<b> r9 = r8;
        if ((r9 instanceof Collection) == true) goto L26;
    L28:
        Iterator<T> r10 = r9.iterator();
    L30:
        if (r10.hasNext() == false) goto L34;
        if ((!d.k0(((b) r10.next()).getMessage())) == false) goto L30;
        boolean r11 = true;
    L35:
        if (r11 != true) goto L37;
        boolean r12 = true;
    L38:
        if (r12 == true) goto L41;
        boolean r13 = false;
    L42:
        ChatFragment r14 = a.c(this.this$0);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.larus.bmhome.chat.ChatFragment");
        ChatFragment r15 = r14;
        ChatTitleComponent r16 = this.this$0;
        com.larus.platform.api.g0 r17 = r16.n;
        c r18 = r16.f1();
        e r19 = this.$conversation;
        BotModel r110 = this.$bot;
        Intrinsics.checkNotNullParameter(r15, "fragment");
        Intrinsics.checkNotNullParameter(r18, "argumentData");
        if (r17 == null) goto L45;
        View r111 = r17.getTitleView();
    L46:
        com.larus.bmhome.chat.helper.o0 r20 = new com.larus.bmhome.chat.helper.o0(r15, r111, r18.d, r13, r19, r110);
        int r21 = j.a;
        Intrinsics.checkNotNullParameter(r20, "subConversationMenuContext");
        if (n.r(r20.e) == true) goto L223;
        View r22 = r20.b;
        if (r22 == null) goto L223;
        Context r23 = r20.a.getContext();
        if (r23 == null) goto L223;
        LifecycleOwner r24 = (LifecycleOwner) r20.a.getViewLifecycleOwnerLiveData().getValue();
        if (r24 == null) goto L223;
        final ArrayList r112 = new ArrayList();
        e r25 = r20.e;
        if (r25 == null) goto L66;
        Integer r26 = r25.t;
        if (r26 == null) goto L66;
        if (r26.intValue() != 8) goto L66;
        boolean r27 = true;
    L67:
        boolean r113 = n.r(r20.e);
        if (r27 == true) goto L137;
        if (r113 == true) goto L135;
        boolean r114 = n.d(r20.e);
        if (r114 == false) goto L73;
        r112.add(new com.larus.bmhome.view.screenmenu.l0(2, 2131900868, null, null, null, null, null, Integer.valueOf(v19.c.b(2130971829, null, 2131241973)), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -132, 127));
    L80:
        boolean r28 = n.A(r20.e);
        Integer r29 = Integer.valueOf(v19.c.b(2130971803, null, 2131241847));
        if (r28 == false) goto L83;
        Float r41 = Float.valueOf(0.3f);
    L84:
        r112.add(new com.larus.bmhome.view.screenmenu.l0(3, 2131900773, null, null, null, null, null, r29, null, false, false, null, null, null, true, false, null, null, null, null, null, null, null, r41, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -16810116, 127));
        if (r114 == true) goto L135;
        BotModel r30 = r20.f;
        if (r30 == null) goto L109;
        List r31 = r30.getMenuActions();
        if (r31 == null) goto L109;
        Iterator r32 = r31.iterator();
    L92:
        if (r32.hasNext() == false) goto L107;
        Object r33 = r32.next();
        AnswerAction r115 = (AnswerAction) r33;
        if (Intrinsics.areEqual(r115.getKey(), "fork_conv") == false) goto L104;
        String r116 = r115.getName();
        if (r116 != null) goto L98;
    L101:
        boolean r117 = true;
    L102:
        if (r117 == true) goto L104;
        boolean r118 = true;
    L105:
        if (r118 == false) goto L92;
    L108:
        AnswerAction r34 = (AnswerAction) r33;
    L111:
        if (n.v(r20.e) == false) goto L113;
    L116:
        boolean r35 = true;
    L118:
        if (z2.a.J3() == false) goto L135;
        if (n.o(r20.e) == true) goto L135;
        if (r35 == false) goto L135;
        e r36 = r20.e;
        if (r36 == null) goto L130;
        Integer r37 = r36.f;
        if (r37 == null) goto L130;
        if (r37.intValue() != 1) goto L130;
        boolean r38 = true;
    L131:
        if (r38 == true) goto L135;
        if (r34 == null) goto L135;
        String r210 = r34.getName();
        AppHost.Companion r39 = AppHost.a;
        r112.add(new com.larus.bmhome.view.screenmenu.l0(7, 0, r210, null, null, null, null, 2131242701, null, false, false, null, 2131242741, null, r20.d, false, Integer.valueOf(v19.c.c(2130972080, r39.a().getCurrentActivity(), ContextCompat.getColor(r39.getApplication(), 2131103140))), null, "fork_conv", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, true, -692358, 63));
    L130:
        r38 = false;
        goto L131
    L113:
        if (n.D(r20.e) == true) goto L116;
        r35 = false;
        goto L118
    L98:
        if (StringsKt.isBlank(r116) == true) goto L101;
        r117 = false;
    L104:
        r118 = false;
        goto L105
    L107:
        r33 = null;
    L109:
        r34 = null;
        goto L111
    L83:
        r41 = null;
        goto L84
    L73:
        z2.a.w3();
        if (AccountService.a.isEnterpriseAccount() == false) goto L76;
        int r59 = 2131901134;
    L77:
        r112.add(new com.larus.bmhome.view.screenmenu.l0(1, r59, null, null, null, null, null, Integer.valueOf(com.larus.bmhome.utils.t.a()), null, false, false, null, null, null, r20.d, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -32900, 127));
        if (AppHost.a.isPlugin() == true) goto L80;
        r112.add(new com.larus.bmhome.view.screenmenu.l0(2, 2131900868, null, null, null, null, null, Integer.valueOf(v19.c.b(2130971829, null, 2131241973)), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -132, 127));
        goto L80
    L76:
        r59 = 2131901131;
    L135:
        if (z2.a.q3() == false) goto L137;
        r112.add(new com.larus.bmhome.view.screenmenu.l0(5, 2131909108, null, null, null, null, null, Integer.valueOf(v19.c.b(2130971827, null, 2131241967)), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -132, 127));
    L137:
        z2 r40 = z2.a;
        if (r40.g2() == true) goto L140;
    L172:
        if (r113 == true) goto L174;
        r112.add(new com.larus.bmhome.view.screenmenu.l0(8, 2131909241, null, null, null, null, null, 2131241031, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(i5.Z()), null, null, null, Integer.valueOf(i5.A()), false, -132, 93));
    L174:
        if (r113 == true) goto L183;
        if (r27 == true) goto L179;
        if (n.d(r20.e) == true) goto L183;
    L179:
        if (n.p(r20.e) == false) goto L181;
        Float r42 = Float.valueOf(0.3f);
    L182:
        r112.add(new com.larus.bmhome.view.screenmenu.l0(4, 2131908799, null, null, null, 2131102650, null, 2131241933, null, false, false, null, null, null, true, false, null, null, null, null, null, null, null, r42, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -16810148, 127));
        goto L183
    L181:
        r42 = null;
    L183:
        final Ref.ObjectRef r119 = new Ref.ObjectRef();
        final CocoSubConversationSettingMenuTrigger r120 = new CocoSubConversationSettingMenuTrigger(r23, r22, r20.c, r20.a, r20.e, r20.f, null, null, new g(r119), 192);
        View r43 = CreateMenuV2.C(new CreateMenuV2(r23), r112, 0, true, Integer.valueOf(i5.D()), null, null, null, null, new h(r119, r120), r120, 986);
        Balloon r44 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r22, r43, false, null, new i(r112), r24, null, 76);
        if (com.larus.utils.i.h(r23) == false) goto L186;
        int r45 = -1;
    L188:
        if (r40.getChatNavigatorConfig().b == false) goto L190;
        r43.measure(0, 0);
        int r46 = (r45 * (r22.getMeasuredWidth() - r43.getMeasuredWidth())) / 2;
    L197:
        r44.x(r22, r46, -i5.Q());
        if (r40.q3() == false) goto L223;
        by7.e r47 = r20.a;
        if ((r47 instanceof by7.e) == false) goto L202;
        by7.e r121 = r47;
    L203:
        ChatControlTrace r48 = ChatControlTrace.b;
        e r49 = r20.e;
        if (r49 == null) goto L206;
        Integer r50 = r49.v;
    L207:
        BotModel r51 = r20.f;
        if (r51 == null) goto L210;
        Integer r52 = r51.getBotType();
    L211:
        BotModel r53 = r20.f;
        if (r53 == null) goto L216;
        BotCreatorInfo r54 = r53.getBotCreatorInfo();
        if (r54 == null) goto L216;
        String r55 = r54.getId();
    L217:
        String r56 = r48.g(r50, r52, Intrinsics.areEqual(r55, AccountService.a.getUserId()));
        JSONObject r57 = new JSONObject();
        BotModel r58 = r20.f;
        if (r58 == null) goto L220;
        String r60 = r58.getBotId();
    L221:
        i3.b(null, null, null, null, null, "chat", r57.put("bot_id", r60).put("function_type", "chat_search").put("show_method", "default").put("chat_type", r56), r121, 31);
        goto L223
    L220:
        r60 = null;
    L216:
        r55 = null;
        goto L217
    L210:
        r52 = null;
        goto L211
    L206:
        r50 = null;
        goto L207
    L202:
        r121 = null;
        goto L203
    L190:
        ViewGroup.LayoutParams r61 = r43.getLayoutParams();
        if ((r61 instanceof ViewGroup.MarginLayoutParams) == false) goto L193;
        ViewGroup.MarginLayoutParams r62 = (ViewGroup.MarginLayoutParams) r61;
    L194:
        if (r62 == null) goto L196;
        r62.setMarginEnd((-i5.Q()) + i5.r0());
    L196:
        r46 = r45 * r22.getMeasuredWidth();
        goto L197
    L193:
        r62 = null;
        goto L194
    L186:
        r45 = 1;
        goto L188
    L140:
        if (n.D(r20.e) == false) goto L172;
        if (n.r(r20.e) == true) goto L172;
        e r63 = r20.e;
        if (r63 == null) goto L151;
        Integer r64 = r63.t;
        if (r64 == null) goto L151;
        if (r64.intValue() != 1) goto L151;
        boolean r65 = true;
    L152:
        if (r65 == true) goto L164;
        e r66 = r20.e;
        if (r66 == null) goto L161;
        Integer r67 = r66.t;
        if (r67 == null) goto L161;
        if (r67.intValue() != 8) goto L161;
        boolean r68 = true;
    L162:
        if (r68 == false) goto L172;
    L161:
        r68 = false;
    L164:
        if (r27 == false) goto L166;
        int r122 = 2131906552;
    L168:
        if (r27 == false) goto L170;
        int r123 = v19.c.b(2130971723, null, 2131241355);
    L171:
        r112.add(new com.larus.bmhome.view.screenmenu.l0(6, r122, null, null, null, null, null, Integer.valueOf(r123), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -132, 127));
        goto L172
    L170:
        r123 = 2131241103;
        goto L171
    L166:
        r122 = 2131906549;
    L151:
        r65 = false;
    L66:
        r27 = false;
    L223:
        return Unit.INSTANCE;
    L45:
        r111 = null;
    L34:
        r11 = false;
        goto L35
    L26:
        if (r9.isEmpty() == false) goto L28;
    L37:
        r12 = false;
        goto L38
    L15:
        r7 = null;
    L41:
        r13 = true;
    L9:
        r3 = 0;
        goto L11
    L225:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
