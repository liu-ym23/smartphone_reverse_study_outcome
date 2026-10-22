package com.larus.bmhome.chat.cell.slot;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.ChatRetry;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tx9.n3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 [2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001[B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016J\u0010\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020?H\u0016J \u0010@\u001a\u00020A2\u0006\u0010B\u001a\u0002072\u0006\u0010>\u001a\u00020\u00022\u0006\u0010C\u001a\u00020;H\u0016J \u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IH\u0002J\b\u0010K\u001a\u00020EH\u0002J\u0018\u0010L\u001a\u00020A2\u0006\u0010F\u001a\u00020G2\u0006\u0010M\u001a\u00020EH\u0002J\u0018\u0010N\u001a\u00020A2\u0006\u0010F\u001a\u00020G2\u0006\u0010M\u001a\u00020EH\u0002J\u0018\u0010O\u001a\u00020A2\u0006\u0010F\u001a\u00020G2\u0006\u0010P\u001a\u000204H\u0002J\b\u0010Q\u001a\u00020EH\u0002J\n\u0010R\u001a\u0004\u0018\u00010GH\u0002J \u0010S\u001a\u00020E2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010I2\u0006\u0010F\u001a\u00020GH\u0002J\u0018\u0010T\u001a\u00020E2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IH\u0002J\n\u0010U\u001a\u0004\u0018\u00010VH\u0002J\u000e\u0010W\u001a\u00020A2\u0006\u0010X\u001a\u00020GJ\u0010\u0010Y\u001a\u00020A2\u0006\u0010X\u001a\u00020GH\u0002J\u0010\u0010Z\u001a\u00020A2\u0006\u0010X\u001a\u00020GH\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b+\u0010,R\u001d\u0010.\u001a\u0004\u0018\u00010/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\n\u001a\u0004\b0\u00101R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/larus/bmhome/chat/cell/slot/MessageInboxRightRegenForImmerseSlotCell;", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/bmhome/chat/cell/slot/MessageRegenBlockState;", "<init>", "()V", "conversationAbility", "Lcom/larus/bmhome/ability/IConversationCoreAbility;", "getConversationAbility", "()Lcom/larus/bmhome/ability/IConversationCoreAbility;", "conversationAbility$delegate", "Lkotlin/Lazy;", "chatListAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListAbility$delegate", "chatMessageShareAbility", "Lcom/larus/bmhome/ability/IChatShareCoreAbility;", "getChatMessageShareAbility", "()Lcom/larus/bmhome/ability/IChatShareCoreAbility;", "chatMessageShareAbility$delegate", "regenAnswerAbility", "Lcom/larus/bmhome/ability/IChatRegenCoreAbility;", "getRegenAnswerAbility", "()Lcom/larus/bmhome/ability/IChatRegenCoreAbility;", "regenAnswerAbility$delegate", "senderAbility", "Lcom/larus/bmhome/ability/IChatSenderCoreAbility;", "getSenderAbility", "()Lcom/larus/bmhome/ability/IChatSenderCoreAbility;", "senderAbility$delegate", "ttsRenderAbility", "Lcom/larus/bmhome/ability/IChatTTSRenderAbility;", "getTtsRenderAbility", "()Lcom/larus/bmhome/ability/IChatTTSRenderAbility;", "ttsRenderAbility$delegate", "chatTraceAbility", "Lcom/larus/bmhome/ability/IChatTraceCoreAbility;", "getChatTraceAbility", "()Lcom/larus/bmhome/ability/IChatTraceCoreAbility;", "chatTraceAbility$delegate", "chatUtilAbility", "Lcom/larus/bmhome/ability/IChatUtilsAbility;", "getChatUtilAbility", "()Lcom/larus/bmhome/ability/IChatUtilsAbility;", "chatUtilAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/data/ChatArgumentCoreData;", "getChatArgumentData", "()Lcom/larus/bmhome/data/ChatArgumentCoreData;", "chatArgumentData$delegate", "userBreakBtnClickTime", "", "userBreakBtnFirstShowTime", "onCreateView", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewType", "", "getContainerId", "transformState", "state", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "onBindView", "", "view", "position", "isLastMsgUserBreak", "", "msg", "Lcom/larus/im/bean/message/Message;", "streamingAnswerActions", "", "Lcom/larus/im/bean/bot/AnswerAction;", "isConversationEnable", "showUserBreakMob", "isImmersiveBackground", "clickUserBreak", "receiveStreamUserBreakMob", "duration", "checkUserBreakStateAndCallRegen", "getLastUserBreakMsg", "isUserBreak", "checkUserBreakInternal", "getCurrentChatBot", "Lcom/larus/im/bean/bot/BotModel;", "onRetry", "data", "beforeRetry", "performRetry", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageInboxRightRegenForImmerseSlotCell extends BaseMessageSlotCell<f0> {
    public static final /* synthetic */ int o = 0;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public long m;
    public long n;

    public static final class a {
    }

    public static final class b implements Function0<va8.a0> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.a0.class));
        }
    }

    public static final class c implements Function0<va8.p> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.p.class));
        }
    }

    public static final class d implements Function0<va8.t> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.t.class));
        }
    }

    public static final class e implements Function0<va8.q> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.q.class));
        }
    }

    public static final class f implements Function0<va8.s> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.s.class));
        }
    }

    public static final class g implements Function0<va8.v> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.v.class));
        }
    }

    public static final class h implements Function0<va8.x> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.x.class));
        }
    }

    public static final class i implements Function0<va8.y> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.y.class));
        }
    }

    public static final class j implements Function0<fp8.a> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(fp8.a.class));
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final int f() {
        return 2131380010;
    }

    public final va8.p m() {
        return (va8.p) this.e.getValue();
    }

    public final va8.y o() {
        return (va8.y) this.k.getValue();
    }

    public final va8.a0 r() {
        return (va8.a0) this.d.getValue();
    }

    public MessageInboxRightRegenForImmerseSlotCell() {
        this.d = LazyKt.lazy(new b(this));
        this.e = LazyKt.lazy(new c(this));
        this.f = LazyKt.lazy(new d(this));
        this.g = LazyKt.lazy(new e(this));
        this.h = LazyKt.lazy(new f(this));
        this.i = LazyKt.lazy(new g(this));
        this.j = LazyKt.lazy(new h(this));
        this.k = LazyKt.lazy(new i(this));
        this.l = LazyKt.lazy(new j(this));
    }

    public final Message s() {
        va8.p r0 = m();
        Object r1 = null;
        if (r0 == null) goto L25;
        List r2 = r0.getCurrentList();
        if (r2 == null) goto L26;
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L18;
        Object r4 = r3.next();
        Message r5 = (Message) r4;
        boolean r6 = true;
        if (ArraysKt.contains(new Integer[]{1, 6}, Integer.valueOf(r5.getContentType())) == true) goto L15;
        if (r5.getContentType() == 1001) goto L15;
        r6 = false;
    L15:
        if (r6 == false) goto L8;
        r1 = r4;
    L18:
        return (Message) r1;
    L26:
        return null;
    L25:
        return null;
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final ei9.f k(xc8.b r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        return new f0(r3, r3.e());
    }

    public final boolean l(List<AnswerAction> r5) {
        List<AnswerAction> r0 = r5;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        Iterator<T> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(((AnswerAction) r6.next()).getKey(), "user_break") == false) goto L13;
        return true;
    L17:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final View onCreateView(Context r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        List r6 = ad8.a.b;
        if (z2.a.enablePreloadChatPageView().b() == false) goto L15;
        o37.c.e.getClass();
        if (o37.c.f("chat_slot_cell_nita") == false) goto L15;
        if ((r4 instanceof Activity) == false) goto L15;
        View r7 = o37.c.e("chat_slot_cell_nita").i(-3, (Activity) r4, true);     // Catch: Exception -> L13
        if ((r7 instanceof ChatRetry) == true) goto L18;
        return new ChatRetry(r4);
    L18:
        return r7;
    L19:
        return new ChatRetry(r4);
    L15:
        return new ChatRetry(r4);
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final void onBindView(final View r20, ei9.f r21, int r22) {
        f0 r2 = (f0) r21;
        Intrinsics.checkNotNullParameter(r20, "view");
        Intrinsics.checkNotNullParameter(r2, "state");
        final Message r3 = r2.b.getMessage();
        String r4 = null;
        if ((r20 instanceof ChatRetry) == false) goto L5;
        ChatRetry r5 = (ChatRetry) r20;
    L6:
        if (r5 == null) goto L113;
        r5.b();
        r5.a(2131241532);
        if (r5.getRetryAlreadyShow() == true) goto L110;
        va8.t r6 = (va8.t) this.f.getValue();
        boolean r7 = false;
        if (r6 != null) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == true) goto L114;
        va8.a0 r9 = r();
        if (r9 == null) goto L21;
        BotModel r10 = r9.j0();
    L22:
        String r11 = "";
        if (r10 != null) goto L36;
        va8.a0 r12 = r();
        if (r12 == null) goto L31;
        wc9.e r13 = r12.h();
        if (r13 == null) goto L31;
        String r14 = r13.a;
        if (r14 == null) goto L31;
    L32:
        BotModel r15 = BotInfoCache.INSTANCE.get(r14);
        if (r15 != null) goto L35;
        r15 = null;
    L35:
        r10 = r15;
    L31:
        r14 = "";
    L36:
        if (r10 == null) goto L38;
        List<AnswerAction> r16 = r10.getStreamingAnswerActions();
    L40:
        if (l(r16) == true) goto L42;
    L50:
        boolean r17 = false;
    L51:
        if (r17 == false) goto L70;
        r5.a(2131242264);
        r5.e(new u(this));
        va8.y r1 = o();
        if (r1 != null) goto L55;
    L57:
        if (r7 == true) goto L115;
        this.n = System.currentTimeMillis();
        va8.y r18 = o();
        if (r18 == null) goto L62;
        r18.L00(r3.getMessageId());
    L62:
        String r19 = r3.getMessageId();
        String r110 = r3.getSectionId();
        String r111 = r3.getSenderId();
        String r112 = r3.getConversationId();
        va8.x r23 = (va8.x) this.j.getValue();
        if (r23 == null) goto L69;
        String r24 = r3.getConversationId();
        if (r24 == null) goto L68;
        r11 = r24;
    L68:
        r4 = r23.WJ(r11);
    L69:
        n3.a("stop", "chat", "receive_message", r19, r110, r111, r112, r4, ve8.c.b(true), 1536);
        return;
    L115:
        return;
    L55:
        if (r1.Du(r3.getMessageId()) != true) goto L57;
        r7 = true;
        goto L57
    L70:
        va8.q r25 = (va8.q) this.g.getValue();
        if (r25 == null) goto L83;
        va8.a0 r26 = r();
        if (r26 == null) goto L79;
        wc9.e r27 = r26.h();
        if (r27 == null) goto L79;
        if (r27.h() != true) goto L79;
        boolean r28 = true;
    L81:
        if (r25.Z2(r3, !r28) != true) goto L83;
        boolean r29 = true;
    L84:
        if (r29 == false) goto L86;
    L108:
        r5.a(2131241535);
        r5.d(new v(r20, this, r3));
        return;
    L86:
        if (l(r16) == false) goto L107;
        Message r30 = s();
        if (r30 == null) goto L91;
        String r31 = r30.getMessageId();
    L92:
        FLogger r32 = FLogger.a;
        StringBuilder r33 = new StringBuilder("isLastMsgUserBreak isSelf=");
        r33.append(com.larus.bmhome.chat.bean.d.G0(r3));
        r33.append(" lastActionMsgId=");
        r33.append(r31);
        r33.append(" msgId=");
        r33.append(r3.getMessageId());
        r33.append(" userBreakMsgId=");
        va8.y r113 = o();
        if (r113 == null) goto L95;
        String r114 = r113.e7(r3.getConversationId());
    L96:
        r33.append(r114);
        r32.i("MessageRightRegenForImmerseBlock", r33.toString());
        if (com.larus.bmhome.chat.bean.d.G0(r3) == true) goto L107;
        if (r31 == null) goto L107;
        if (Intrinsics.areEqual(r3.getMessageId(), r31) == false) goto L107;
        String r34 = r3.getMessageId();
        va8.y r35 = o();
        if (r35 == null) goto L105;
        r4 = r35.e7(r3.getConversationId());
    L105:
        if (Intrinsics.areEqual(r34, r4) == false) goto L107;
        r7 = true;
        goto L107
    L95:
        r114 = null;
        goto L96
    L91:
        r31 = null;
    L107:
        if (r7 == true) goto L108;
        return;
    L79:
        r28 = false;
    L83:
        r29 = false;
        goto L84
    L42:
        if (r3.getMessageStatusLocal() != 20) goto L44;
    L45:
        int r36 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r3, "message");
        if (com.larus.im.bean.message.a.r0(r3) == true) goto L50;
        if (r3.getMessageStatusLocal() == 24) goto L50;
        r17 = true;
        goto L51
    L44:
        if (com.larus.bmhome.chat.bean.d.Q0(r3) == false) goto L50;
    L38:
        r16 = null;
        goto L40
    L21:
        r10 = null;
        goto L22
    L114:
        return;
    L13:
        if (r6.H1() != true) goto L15;
        r8 = true;
        goto L16
    L110:
        return;
    L113:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
