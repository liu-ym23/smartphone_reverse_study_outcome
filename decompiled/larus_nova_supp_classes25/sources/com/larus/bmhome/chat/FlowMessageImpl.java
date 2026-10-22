package com.larus.bmhome.chat;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.IFlowMessageService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J:\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00182\u0006\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00180\u0014H\u0016J6\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J@\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u001cH\u0002J\u0012\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\u0012\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010(\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010)\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u000bH\u0016J'\u0010*\u001a\u00020+2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0002\u0010.J<\u0010/\u001a\u0002002\u0006\u0010\u000f\u001a\u00020\u000b2\f\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00182\b\u00103\u001a\u0004\u0018\u00010\u000b2\b\u00104\u001a\u0004\u0018\u00010\u000b2\b\u00105\u001a\u0004\u0018\u00010\u000bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/bmhome/chat/FlowMessageImpl;", "Lcom/larus/platform/IFlowMessageService;", "<init>", "()V", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "getIoScope", "()Lkotlinx/coroutines/CoroutineScope;", "ioScope$delegate", "Lkotlin/Lazy;", "remainQuestionLocalMessageIdInModify", "", "invisibleLocalMessageIdInModify", "sendMessage", "", "cvsId", "strategy", "Lcom/larus/bmhome/chat/bean/ISendMessageStrategy;", "scene", "callback", "Lcom/larus/im/callback/IIMCallback;", "Lcom/larus/im/bean/message/Message;", "batchSendMessage", "strategies", "", "reSendMessageThroughModify", "messageId", "isQuestion", "", "extras", "", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "isSendAllowed", "interruptBeforeSend", "conversationId", "isChatLimited", "isQuestionShouldRemainInModify", "localMessageId", "getRemainInModifyQuestionLocalId", "isMessageReAnswerInModify", "markMessageReAnswerInModify", "toMessageRequest", "Lcom/larus/im/bean/message/MessageRequest;", "messageStatusLocal", "", "(Lcom/larus/bmhome/chat/bean/ISendMessageStrategy;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/im/bean/message/MessageRequest;", "toMessageRequestV2FromBlockJson", "Lcom/larus/im/bean/message/MessageRequestV2;", "requests", "Lcom/larus/platform/model/BlockJsonMessageRequestItem;", "botId", "localConversationId", "localOnBoardingMessageId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FlowMessageImpl implements IFlowMessageService {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public String b;
    public String c;

    public static final class a {
    }

    static {
    }

    public final String e() {
        String r0 = this.b;
        if (r0 == null) goto L6;
        this.b = null;
        return r0;
    L6:
        return null;
    }

    public FlowMessageImpl() {
        this.a = LazyKt.lazy(new x2());
    }

    public final boolean a(String r2) {
        if (com.larus.utils.o0.d(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.b, r2) == false) goto L7;
        return true;
    }

    public final void b(String r1) {
        this.c = r1;
    }

    public final boolean f(String r2) {
        if (com.larus.utils.o0.d(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.c, r2) == false) goto L7;
        return true;
    }

    public final yc9.f0 c(ic8.w r2, String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        Intrinsics.checkNotNullParameter(r3, "cvsId");
        if (r4 != null) goto L5;
        com.larus.bmhome.chat.model.strategy.block.d0.a.getClass();
        return com.larus.bmhome.chat.model.strategy.block.d0.m(r2, r3, -1);
    L5:
        com.larus.bmhome.chat.model.strategy.block.d0 r0 = com.larus.bmhome.chat.model.strategy.block.d0.a;
        int r5 = r4.intValue();
        r0.getClass();
        return com.larus.bmhome.chat.model.strategy.block.d0.m(r2, r3, r5);
    }

    public final void g(String r8, boolean r9, Map<String, String> r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "messageId");
        Intrinsics.checkNotNullParameter(r11, "scene");
        d(r8, r9, r10, r11, null);
    }

    public final void d(String r15, boolean r16, Map<String, String> r17, String r18, ChatPageContext r19) {
        Intrinsics.checkNotNullParameter(r15, "messageId");
        Intrinsics.checkNotNullParameter(r18, "scene");
        if (r19 != null) goto L5;
        ChatPageContext r7 = null;
    L6:
        BuildersKt.launch$default((CoroutineScope) this.a.getValue(), null, null, new FlowMessageImpl$reSendMessageThroughModify$1(r15, r16, r17, r18, this, r7, null), 3, null);
        return;
    L5:
        r7 = r19;
        goto L6
    }
}
