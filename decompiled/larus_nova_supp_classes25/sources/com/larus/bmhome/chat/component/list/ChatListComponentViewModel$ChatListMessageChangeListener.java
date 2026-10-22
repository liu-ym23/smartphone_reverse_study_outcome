package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.social.page.datasource.event.RefreshTraceSource;
import com.larus.bmhome.social.page.datasource.event.d;
import com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatListComponentViewModel$ChatListMessageChangeListener implements ChatMessageReceiverModel.c {
    public final Function0<wc9.e> a;
    public final Function0<BotModel> b;
    public final /* synthetic */ ChatListComponentViewModel c;

    public final void b(Runnable r25) {
        ChatListComponentViewModel.access$setLoadCompleted$p(this.c, true);
        com.larus.bmhome.social.page.datasource.event.c r2 = ChatListComponentViewModel.access$getCurrentMessageListData$p(this.c);
        if (r2 != null) goto L5;
        r2 = new com.larus.bmhome.social.page.datasource.event.c(CollectionsKt.emptyList(), 0, CollectionsKt.emptyList());
    L5:
        com.larus.bmhome.social.page.datasource.event.c r17 = com.larus.bmhome.social.page.datasource.event.c.a(r2, null, 0, null, d.a(RefreshTraceSource.REPROCESS), 7);
        ChatListComponentViewModel r14 = this.c;
        Function0<wc9.e> r3 = this.a;
        if (r3 == null) goto L8;
        wc9.e r15 = (wc9.e) r3.invoke();
    L9:
        Function0<BotModel> r4 = this.b;
        if (r4 == null) goto L12;
        BotModel r16 = (BotModel) r4.invoke();
    L13:
        ChatListComponentViewModel.submitMessageListChangeByPipeline$default(r14, r15, r16, r17, "onLoadCompleted", 0, null, 48, null);
        if (r25 == null) goto L17;
        BuildersKt.launch$default(ChatListComponentViewModel.access$getViewModelScope(this.c), null, null, new ChatListComponentViewModel$ChatListMessageChangeListener$onLoadCompleted$1(r25, null), 3, null);
        return;
    L17:
        return;
    L12:
        r16 = null;
        goto L13
    L8:
        r15 = null;
        goto L9
    }

    public final void c(com.larus.bmhome.social.page.datasource.event.c r26, String r27) {
        Intrinsics.checkNotNullParameter(r26, "changeData");
        Intrinsics.checkNotNullParameter(r27, "source");
        Intrinsics.checkNotNullParameter(r26, "changeData");
        Intrinsics.checkNotNullParameter(r27, "source");
        FLogger r3 = FLogger.a;
        String r4 = "ChatMessageReceiverModel_" + hashCode();
        StringBuilder r5 = new StringBuilder();
        r5.append(ThreadMethodProxy.currentThread().getName());
        r5.append("  onMessageListChange dataVersion: ");
        r5.append(r26.b);
        r5.append(" ; actions:");
        r5.append(r26.c);
        r5.append(";   localMessageIds: ");
        List r6 = r26.a;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r7.add(String.valueOf(((Message) r8.next()).getLocalMessageId()));
        goto L4
    L6:
        r5.append(r7);
        r5.append(";  size: ");
        r5.append(r26.a.size());
        r5.append(' ');
        r3.i(r4, r5.toString());
        FLogger.a.i("FeedShowTrace", "nMessageListChange, changeData: " + r26.a.size());
        List r9 = r26.a;
        ChatListComponentViewModel r10 = this.c;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r12 = r9.iterator();
    L7:
        Function1 r13 = null;
        if (r12.hasNext() == false) goto L14;
        Message r14 = (Message) r12.next();
        Function1 r15 = ChatListComponentViewModel.access$getMessageCellStateConverter$p(r10);
        if (r15 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("messageCellStateConverter");
    L13:
        r11.add((b) r13.invoke(r14));
        goto L7
    L12:
        r13 = r15;
        goto L13
    L14:
        com.larus.bmhome.social.page.datasource.event.c r18 = new com.larus.bmhome.social.page.datasource.event.c(r11, r26.b, r26.c, r26.d);
        Function0<wc9.e> r16 = this.a;
        if (r16 == null) goto L17;
        wc9.e r17 = (wc9.e) r16.invoke();
    L19:
        if ((ChatListComponentViewModel.access$getChatMessageReceiverRepo$p(this.c) instanceof ChatMessageReceiverModel) == false) goto L27;
        IFlowSdkDepend r19 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r19 == null) goto L27;
        r19.C0();
        hc9.d r20 = hc9.d.a;
        if (r17 == null) goto L25;
        String r21 = r17.a;
    L26:
        r20.f(r21, r26.a);
        goto L27
    L25:
        r21 = null;
    L27:
        ChatListComponentViewModel r110 = this.c;
        Function0<BotModel> r1 = this.b;
        if (r1 == null) goto L30;
        r13 = (BotModel) r1.invoke();
    L30:
        ChatListComponentViewModel.submitMessageListChangeByPipeline$default(r110, r17, r13, r18, r27 + "_onMessageListChange", 0, null, 48, null);
        return;
    L17:
        r17 = null;
        goto L19
    }

    public ChatListComponentViewModel$ChatListMessageChangeListener(ChatListComponentViewModel r1, Function0<wc9.e> r2, Function0<BotModel> r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }

    public final void a(boolean r22, List<Message> r23, long r24, boolean r26, Runnable r27, String r28, String r29) {
        Intrinsics.checkNotNullParameter(r23, "changeData");
        Intrinsics.checkNotNullParameter(r28, "source");
        Intrinsics.checkNotNullParameter(r29, "refreshTraceId");
        ChatListComponentViewModel r3 = this.c;
        ChatListComponentViewModel.access$setMessageChangeVersion$p(r3, ChatListComponentViewModel.access$getMessageChangeVersion$p(r3) + 1);
        ChatListComponentViewModel.access$setRegen$p(this.c, r26);
        ChatListComponentViewModel r4 = this.c;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator<T> r6 = r23.iterator();
    L3:
        Function1 r10 = null;
        if (r6.hasNext() == false) goto L10;
        Message r7 = (Message) r6.next();
        Function1 r8 = ChatListComponentViewModel.access$getMessageCellStateConverter$p(r4);
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("messageCellStateConverter");
    L9:
        r5.add((b) r10.invoke(r7));
        goto L3
    L8:
        r10 = r8;
        goto L9
    L10:
        com.larus.bmhome.social.page.datasource.event.c r14 = new com.larus.bmhome.social.page.datasource.event.c(r5, ChatListComponentViewModel.access$getMessageChangeVersion$p(this.c), CollectionsKt.listOf(new com.larus.bmhome.social.page.datasource.event.b.d(r22)), r29);
        Function0<wc9.e> r9 = this.a;
        if (r9 == null) goto L13;
        wc9.e r12 = (wc9.e) r9.invoke();
    L15:
        if ((ChatListComponentViewModel.access$getChatMessageReceiverRepo$p(this.c) instanceof ChatMessageReceiverModel) == false) goto L23;
        IFlowSdkDepend r11 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r11 == null) goto L23;
        r11.C0();
        hc9.d r13 = hc9.d.a;
        if (r12 == null) goto L21;
        String r15 = r12.a;
    L22:
        r13.f(r15, r23);
        goto L23
    L21:
        r15 = null;
    L23:
        ChatListComponentViewModel r16 = this.c;
        Function0<BotModel> r1 = this.b;
        if (r1 == null) goto L26;
        r10 = (BotModel) r1.invoke();
    L26:
        ChatListComponentViewModel.submitMessageListChangeByPipeline$default(r16, r12, r10, r14, r28 + "_onMessageListChange", r24, null, 32, null);
        if (r27 == null) goto L33;
        r27.run();
        return;
    L33:
        return;
    L13:
        r12 = null;
        goto L15
    }
}
