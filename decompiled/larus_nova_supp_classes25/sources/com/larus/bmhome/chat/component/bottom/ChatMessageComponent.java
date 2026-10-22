package com.larus.bmhome.chat.component.bottom;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.feishu.office.im.impl.base.FeishuInputAdapterComponent;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import gd8.g;
import gd8.h;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001VB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0095\u0001\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u001e\u0010\u001f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020\u0010\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010&JK\u0010'\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u00132\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\b\u0010.\u001a\u0004\u0018\u00010\u00132\b\u0010/\u001a\u0004\u0018\u00010\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0002\u00100J0\u00101\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u00010)2\u0006\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u00106J\"\u00107\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0016\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020!H\u0096@¢\u0006\u0002\u0010:Jk\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020\u00132\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00172\u0006\u0010?\u001a\u00020\u00192\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u00192\b\u0010E\u001a\u0004\u0018\u00010\u00132\b\u0010#\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0002\u0010FJ \u0010G\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\u00132\u0006\u0010I\u001a\u00020JH\u0016J\u001e\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u00132\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00100NH\u0002J4\u0010O\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u00132\u001c\u0010M\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100Q\u0012\u0006\u0012\u0004\u0018\u00010R0PH\u0082@¢\u0006\u0002\u0010SJ\u0012\u0010T\u001a\u00020\u00102\b\u0010U\u001a\u0004\u0018\u00010\fH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/ChatMessageComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/bmhome/chat/component/IChatMessageAbility;", "<init>", "()V", "chatMessageViewModel", "Lcom/larus/bmhome/chat/component/bottom/ChatMessageViewModel;", "getChatMessageViewModel", "()Lcom/larus/bmhome/chat/component/bottom/ChatMessageViewModel;", "chatMessageViewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "messageSendDelegate", "Lcom/larus/bmhome/chat/component/IMessageSendDelegate;", "currentChatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "onAttach", "", "sendText", "conversationId", "", "content", "scene", "extra", "", "isAutoInterrupt", "", "status", "Lcom/larus/im/bean/message/MessageStatus;", "referenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "creationSendTraceId", "callback", "Lkotlin/Function2;", "Lcom/larus/im/bean/message/Message;", "Lcom/larus/im/callback/IIMError;", "sendClickTimestamp", "", "restoreInputOnCancel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZLcom/larus/im/bean/message/MessageStatus;Lcom/larus/im/bean/message/ReferenceInfo;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Ljava/lang/Long;Z)V", "sendFileAndTxt", "conversationLiveData", "Lcom/larus/im/bean/conversation/Conversation;", "txtScene", "strategyList", "", "Lcom/larus/bmhome/chat/bean/ISendMessageStrategy;", "fromScene", "sameScene", "(Lcom/larus/im/bean/conversation/Conversation;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;)V", "resendMessage", "conversation", "replyMessage", "traceScene", "resendScene", "(Lcom/larus/im/bean/conversation/Conversation;Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSearch", "deleteOnModifySendBeforeAck", "msg", "(Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceMsgOnModifySendAfterAck", "message", "replaceText", "extras", "needReplaceTxtAndFile", "newAttachmentInfo", "Lcom/larus/bmhome/view/AttachmentInfo;", "newNestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "location", "attachmentEntityLocalMsgId", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/util/Map;ZLcom/larus/bmhome/view/AttachmentInfo;Lcom/larus/im/bean/message/NestedFileContent;ZLjava/lang/String;Ljava/lang/Long;)V", "breakAllMsg", "breakReason", "breakReasonCode", "Lcom/larus/im/internal/jni/bean/OmniBreakReason;", "runSafely", "functionName", "block", "Lkotlin/Function0;", "runSuspendSafely", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMessageSendDelegate", "delegate", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatMessageComponent extends ComponentFeature implements g {
    public static final /* synthetic */ int j = 0;
    public final com.larus.ui.arch.vm.internal.l h;
    public h i;

    public static final class a {
    }

    public static final class b implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public b(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class c implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public c(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return s1a.a.c(this.a);
        }
    }

    public static final class d implements Function0<ViewModelProvider.Factory> {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    static {
    }

    public final ChatPageContext F2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        return (ChatPageContext) s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).a(ChatPageContext.class);
    }

    public final ChatMessageViewModel L2() {
        return (ChatMessageViewModel) this.h.getValue();
    }

    public final void y2() {
        N2("onAttach", new i1(this));
    }

    public ChatMessageComponent() {
        this.h = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(ChatMessageViewModel.class), Reflection.getOrCreateKotlinClass(ChatMessageComponentState.class), new b(this), new c(this), d.a);
    }

    @Override // gd8.g
    public final void MU(FeishuInputAdapterComponent.e r4) {
        FLogger.a.i("ChatMessageComponent", "[setMessageSendDelegate] delegate:".concat("custom"));
        this.i = r4;
    }

    public static void N2(String r2, Function0 r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        r3.invoke();     // Catch: Throwable -> L4
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L12;
        FLogger.a.e("ChatMessageComponent", r2 + ' ' + r5);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // gd8.g
    public final Unit CQ(e r13, Message r14) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatMessageComponent$resendMessage$2(this, r13, r14, "regenerate", "nested_file_parse_regen", null), 3, null);
        return Unit.INSTANCE;
    }

    @Override // gd8.g
    public final Object hi(Message r3, Continuation<? super Unit> r4) {
        Object r5 = P2("deleteOnModifySendBeforeAck", new ChatMessageComponent$deleteOnModifySendBeforeAck$2(this, r3, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    @Override // gd8.g
    public final void ou(final String r3, final String r4) {
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter("action_search", "scene");
        N2("sendSearch", new k1(this, r3, r4));
    }

    public final Object P2(String r5, Function1<? super Continuation<? super Unit>, ? extends Object> r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof ChatMessageComponent$runSuspendSafely$1) == false) goto L7;
        ChatMessageComponent$runSuspendSafely$1 r0 = (ChatMessageComponent$runSuspendSafely$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L22
    L20:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L28;
        FLogger.a.e("ChatMessageComponent", r5 + ' ' + r10);
    L28:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L22
        r0.L$0 = r5;     // Catch: Throwable -> L22
        r0.label = 1;     // Catch: Throwable -> L22
        if (r6.invoke(r0) != r2) goto L20;
        return r2;
    L22:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new ChatMessageComponent$runSuspendSafely$1(this, r7);
        goto L8
    }

    @Override // gd8.g
    public final void mh(final String r2, final String r3, final OmniBreakReason r4) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "breakReason");
        Intrinsics.checkNotNullParameter(r4, "breakReasonCode");
        N2("breakAllMsg", new h1(this, r2, r3, r4));
    }

    @Override // gd8.g
    public final void sW(final e r10, final String r11, final List<? extends ic8.w> r12, final String r13, final Boolean r14, final Long r15) {
        Intrinsics.checkNotNullParameter(r11, "txtScene");
        Intrinsics.checkNotNullParameter(r12, "strategyList");
        N2("sendFileAndTxt", new g1(this, r12, r10, r11, r13, r14, r15));
    }

    @Override // gd8.g
    public final void J00(final Message r13, final String r14, final Map<String, String> r15, final boolean r16, final AttachmentInfo r17, final NestedFileContent r18, final boolean r19, final String r20, final Long r21) {
        Intrinsics.checkNotNullParameter(r13, "message");
        Intrinsics.checkNotNullParameter(r14, "replaceText");
        N2("replaceMsgOnModifySendAfterAck", new l1(this, r13, r14, r15, r16, r17, r18, r19, r20, r21));
    }

    @Override // gd8.g
    public final void sd(final String r15, final String r16, final String r17, final Map<String, String> r18, final boolean r19, final MessageStatus r20, final ReferenceInfo r21, final String r22, final Function2<? super Message, ? super IIMError, Unit> r23, final Long r24, final boolean r25) {
        Intrinsics.checkNotNullParameter(r16, "content");
        Intrinsics.checkNotNullParameter(r17, "scene");
        N2("sendText", new j1(this, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25));
    }
}
