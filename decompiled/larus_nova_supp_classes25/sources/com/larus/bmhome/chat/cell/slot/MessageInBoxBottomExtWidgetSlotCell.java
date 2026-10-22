package com.larus.bmhome.chat.cell.slot;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.MessageBottomExtActionView;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.chat.common.databinding.LarusLayoutMessageBottomExtActionViewBinding;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.IFlowMessageService;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020(H\u0016J \u00101\u001a\u0002022\u0006\u0010%\u001a\u00020-2\u0006\u0010*\u001a\u00020\u00022\u0006\u00103\u001a\u00020(H\u0016J \u00104\u001a\u0002022\u0006\u00105\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00022\u0006\u00103\u001a\u00020(H\u0002J\u0018\u00106\u001a\u0002072\u0006\u0010\u001f\u001a\u00020 2\u0006\u00103\u001a\u00020(H\u0002J\u0010\u00108\u001a\u0002022\u0006\u00109\u001a\u000207H\u0016J\b\u0010:\u001a\u000202H\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u0010=\u001a\u0002022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010>\u001a\u00020\"H\u0002J0\u0010?\u001a\u0002022\u0006\u0010\u001f\u001a\u00020 2\u0016\b\u0002\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0018\u00010A2\u0006\u0010B\u001a\u00020\"H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/larus/bmhome/chat/cell/slot/MessageInBoxBottomExtWidgetSlotCell;", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/bmhome/chat/cell/slot/MessageInBoxBottomExtWidgetState;", "<init>", "()V", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "getChatPageContext", "()Lcom/larus/bmhome/chat/bean/ChatPageContext;", "chatPageContext$delegate", "chatMessageAbility", "Lcom/larus/bmhome/chat/component/IChatMessageAbility;", "getChatMessageAbility", "()Lcom/larus/bmhome/chat/component/IChatMessageAbility;", "chatMessageAbility$delegate", "chatTraceAbility", "Lcom/larus/bmhome/ability/IChatTraceCoreAbility;", "getChatTraceAbility", "()Lcom/larus/bmhome/ability/IChatTraceCoreAbility;", "chatTraceAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "message", "Lcom/larus/im/bean/message/Message;", "preBindMessageId", "", "actionData", "Lcom/larus/bmhome/chat/cell/slot/MessageBottomExtAction;", "view", "Lcom/larus/bmhome/chat/layout/widget/MessageBottomExtActionView;", "getContainerId", "", "transformState", "state", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "onCreateView", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewType", "onBindView", "", "position", "renderData", "messageBottomExtActionView", "enableShowStreamSuggest", "", "onSlotCellVisibilityChange", "isVisible", "trackExtWidgetShow", "getDefaultBackground", "Landroid/graphics/drawable/Drawable;", "handleWithActionClick", "suggestType", "reSendMessage", "extra", "", "scene", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageInBoxBottomExtWidgetSlotCell extends BaseMessageSlotCell<k> {
    public static final /* synthetic */ int m = 0;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public Message i;
    public String j;
    public com.larus.bmhome.chat.cell.slot.b k;
    public MessageBottomExtActionView l;

    public static final class a {
    }

    public static final class b implements Function0<gd8.g> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(gd8.g.class));
        }
    }

    public static final class c implements Function0<va8.x> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
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

    public static final class d implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.cvs.y.class));
        }
    }

    public static final class e implements Function0<de8.c> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(de8.c.class));
        }
    }

    public static final class f implements Function0<ChatPageContext> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(ChatPageContext.class));
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final int f() {
        return 2131379969;
    }

    public final String o() {
        com.larus.bmhome.chat.cell.slot.b r0 = this.k;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getType());
    L6:
        int r2 = MessageBottomExtActionType.JUMP_DEEP_THINK.getValue();
        if (r1 != null) goto L10;
    L12:
        int r3 = MessageBottomExtActionType.FORCE_DEEP_THINK.getValue();
        if (r1 != null) goto L16;
    L18:
        return "";
    L16:
        if (r1.intValue() != r3) goto L18;
        return "deep_thinking";
    L10:
        if (r1.intValue() != r2) goto L12;
        return "disable_deep_thinking";
    L5:
        r1 = null;
        goto L6
    }

    public MessageInBoxBottomExtWidgetSlotCell() {
        this.d = LazyKt.lazy(new e(this));
        this.e = LazyKt.lazy(new f(this));
        this.f = LazyKt.lazy(new b(this));
        this.g = LazyKt.lazy(new c(this));
        this.h = LazyKt.lazy(new d(this));
        this.j = "";
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final void g(boolean r12) {
        if (r12 == false) goto L60;
        RecyclerView r13 = this.b;
        String r0 = null;
        if (r13 == null) goto L6;
        Object r14 = r13.getTag(2131384073);
    L8:
        if (TypeIntrinsics.isMutableSet(r14) == false) goto L10;
        Set r15 = (Set) r14;
    L58:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L55
        va8.x r2 = (va8.x) this.g.getValue();     // Catch: Throwable -> L55
        if (r2 == null) goto L61;
        Message r3 = this.i;     // Catch: Throwable -> L55
        if (r3 == null) goto L18;
        String r4 = r3.getMessageId();     // Catch: Throwable -> L55
    L20:
        if (r4 != null) goto L22;
        r4 = "";
    L22:
        Pair r5 = new Pair(r4, "onShowSuggestedPromptSingleQuestion");     // Catch: Throwable -> L55
        boolean r6 = false;
        if (r15 != null) goto L25;
    L27:
        boolean r7 = false;
    L28:
        if (r7 == false) goto L53;
        MessageBottomExtActionView r8 = this.l;     // Catch: Throwable -> L55
        if (r8 != null) goto L32;
    L37:
        if (r6 == false) goto L53;
        r15.add(r5);     // Catch: Throwable -> L55
        Message r16 = this.i;     // Catch: Throwable -> L55
        if (r16 == null) goto L41;
        String r17 = r16.getMessageId();     // Catch: Throwable -> L55
    L42:
        if (r17 != null) goto L44;
        String r9 = "";
    L45:
        String r10 = o();     // Catch: Throwable -> L55
        long r11 = de8.d.a((de8.c) this.d.getValue());     // Catch: Throwable -> L55
        Message r18 = this.i;     // Catch: Throwable -> L55
        if (r18 == null) goto L48;
        String r19 = r18.getSectionId();     // Catch: Throwable -> L55
    L49:
        Message r110 = this.i;     // Catch: Throwable -> L55
        if (r110 == null) goto L52;
        r0 = com.larus.bmhome.chat.bean.d.x(r110).getActionBarKey();     // Catch: Throwable -> L55
    L52:
        LruCache r111 = ko8.a.a;     // Catch: Throwable -> L55
        String r20 = ko8.a.c(this.i);     // Catch: Throwable -> L55
        com.larus.bmhome.chat.cell.slot.b r112 = this.k;     // Catch: Throwable -> L55
        r2.ig(r9, r10, r11, r19, r0, r20, Boolean.TRUE);     // Catch: Throwable -> L55
        goto L53
    L48:
        r19 = null;
        goto L49
    L44:
        r9 = r17;
        goto L45
    L41:
        r17 = null;
        goto L42
    L32:
        if (r8.getVisibility() != 0) goto L34;
        boolean r21 = true;
    L35:
        if (r21 != true) goto L37;
        r6 = true;
        goto L37
    L34:
        r21 = false;
    L53:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L55
        return;
    L25:
        if (r15.contains(r5) == true) goto L27;
        r7 = true;
        goto L28
    L18:
        r4 = null;
        goto L20
    L61:
        return;
    L55:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L10:
        r15 = null;
        goto L58
    L6:
        r14 = null;
        goto L8
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final ei9.f k(xc8.b r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        return new k(r3, r3.e());
    }

    public final boolean l(Message r4, int r5) {
        com.larus.bmhome.chat.cell.slot.b r0 = this.k;
        if (r0 != null) goto L5;
    L22:
        return false;
    L5:
        if (r0.c() == true) goto L7;
    L14:
        Map r6 = r4.getExt();
        if (r6 == null) goto L17;
        String r7 = (String) r6.get("is_oauto_show_action_view");
    L19:
        if (Intrinsics.areEqual(r7, "1") == false) goto L22;
        if (r5 != 0) goto L22;
    L21:
        return true;
    L17:
        r7 = null;
        goto L19
    L7:
        if (r0.getType() != MessageBottomExtActionType.FORCE_DEEP_THINK.getValue()) goto L11;
        if (com.larus.bmhome.chat.bean.d.Q0(r4) == true) goto L21;
    L11:
        if (r0.getType() != MessageBottomExtActionType.JUMP_DEEP_THINK.getValue()) goto L14;
        if (com.larus.bmhome.chat.bean.d.f0(r4) == true) goto L21;
        goto L14
    }

    public final View onCreateView(Context r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        List r9 = ad8.a.b;
        if (z2.a.enablePreloadChatPageView().b() == false) goto L14;
        o37.c.e.getClass();
        if (o37.c.f("chat_slot_cell_nita") == false) goto L14;
        if ((r7 instanceof Activity) == false) goto L14;
        View r10 = o37.c.e("chat_slot_cell_nita").i(-4, (Activity) r7, true);     // Catch: Exception -> L13
        if ((r10 instanceof MessageBottomExtActionView) == true) goto L19;
        MessageBottomExtActionView r11 = new MessageBottomExtActionView(r7, null, 6, 0);     // Catch: Exception -> L13
        this.l = r11;     // Catch: Exception -> L13
        return r11;
    L19:
        return r10;
    L13:
        MessageBottomExtActionView r12 = new MessageBottomExtActionView(r7, null, 6, 0);
    L15:
        this.l = r12;
        return r12;
    L14:
        r12 = new MessageBottomExtActionView(r7, null, 6, 0);
        goto L15
    }

    public final void m(Message r8, Map<String, String> r9, String r10) {
        IFlowMessageService r1 = (IFlowMessageService) ServiceManager.get().getService(IFlowMessageService.class);
        if (r1 == null) goto L9;
        String r11 = r8.getMessageId();
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        r1.d(r11, false, r9, r10, (ChatPageContext) this.e.getValue());
        return;
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final void onBindView(View r18, ei9.f r19, int r20) {
        k r3 = (k) r19;
        Intrinsics.checkNotNullParameter(r18, "view");
        Intrinsics.checkNotNullParameter(r3, "state");
        super.onBindView(r18, r3, r20);
        this.i = r3.b.getMessage();
        Integer r5 = null;
        if ((r18 instanceof MessageBottomExtActionView) == false) goto L5;
        MessageBottomExtActionView r1 = (MessageBottomExtActionView) r18;
    L6:
        if (r1 == null) goto L84;
        final Message r4 = r3.b.getMessage();
        if (Intrinsics.areEqual(this.j, r4.getMessageId()) == true) goto L11;
    L19:
        String r6 = r4.getMessageId();
        String r8 = "";
        if (r6 != null) goto L22;
        r6 = "";
    L22:
        this.j = r6;
        e1.o(r1);
        Map r7 = r4.getExt();
        if (r7 == null) goto L25;
        String r9 = (String) r7.get("message_action_config");
    L26:
        if (r9 != null) goto L28;
    L31:
        boolean r10 = true;
    L32:
        if (r10 == true) goto L86;
        Gson r11 = com.larus.utils.z.a;
        this.k = (com.larus.bmhome.chat.cell.slot.b) com.larus.utils.z.a(r9, com.larus.bmhome.chat.cell.slot.b.class);
        if (l(r4, r20) == false) goto L82;
        final com.larus.bmhome.chat.cell.slot.b r2 = this.k;
        if (r2 != null) goto L39;
        return;
    L39:
        if ((r1.getResources().getConfiguration().uiMode & 48) != 32) goto L41;
        boolean r12 = true;
    L42:
        if (r12 == false) goto L44;
        String r13 = r2.a();
    L45:
        String r14 = r2.b();
        if (r14 != null) goto L48;
        r14 = "";
    L48:
        de8.c r15 = (de8.c) this.d.getValue();
        if (r15 == null) goto L51;
        Integer r16 = r15.m();
    L52:
        if (r16 == null) goto L54;
        boolean r17 = true;
    L55:
        Intrinsics.checkNotNullParameter(r14, ChatDraftItem.TYPE_TEXT);
        LarusLayoutMessageBottomExtActionViewBinding r21 = r1.a;
        if (r21 == null) goto L60;
        AppCompatTextView r22 = r21.c;
        if (r22 == null) goto L60;
        r22.setText(r14);
    L60:
        LarusLayoutMessageBottomExtActionViewBinding r23 = r1.a;
        if (r23 == null) goto L65;
        AppCompatTextView r110 = r23.c;
        if (r110 == null) goto L65;
        we8.a.b(r110, i5.m(), r17, Float.valueOf(i5.h()), null, 8);
    L65:
        if (r13 == null) goto L68;
        r8 = r13;
    L68:
        Intrinsics.checkNotNullParameter(r8, "icon");
        LarusLayoutMessageBottomExtActionViewBinding r24 = r1.a;
        if (r24 == null) goto L73;
        SimpleDraweeView r25 = r24.b;
        if (r25 == null) goto L73;
        ImageLoaderKt.u(r25, r8, "message_bottom_action_view");
    L73:
        Context r26 = r1.getContext();
        de8.c r27 = (de8.c) this.d.getValue();
        if (r27 == null) goto L76;
        r5 = r27.m();
    L76:
        if (r5 == null) goto L78;
        Drawable r28 = ContextCompat.getDrawable(r26, 2131239438);
    L79:
        r1.setBackground(r28);
        e1.d(r1, new j(this, r4, r2));
        e1.x(r1);
        return;
    L78:
        r28 = ContextCompat.getDrawable(r26, v19.c.b(2130970758, r26, 2131239436));
        goto L79
    L54:
        r17 = false;
        goto L55
    L51:
        r16 = null;
        goto L52
    L44:
        r13 = r2.d();
        goto L45
    L41:
        r12 = false;
        goto L42
    L82:
        return;
    L86:
        return;
    L28:
        if (r9.length() == 0) goto L31;
        r10 = false;
        goto L32
    L25:
        r9 = null;
        goto L26
    L11:
        if (l(r4, r20) == true) goto L14;
        e1.o(r1);
        return;
    L14:
        if (r1.getVisibility() != 0) goto L16;
        boolean r29 = true;
    L17:
        if (r29 == false) goto L19;
        return;
    L16:
        r29 = false;
        goto L17
    L84:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
