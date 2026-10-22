package com.larus.bmhome.chat.cotdetail.component;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.im.observer.MessageListState;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ\u0014\u0010\u0012\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014J\u001e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\fH\u0002J\u0016\u0010\u001f\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0002J6\u0010 \u001a\u00020\u0010*\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t`\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0002J6\u0010!\u001a\u00020\u0010*\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t`\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0002J\u0016\u0010\"\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u0016\u0010%\u001a\u00020$2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0002J\u0016\u0010&\u001a\u00020$2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0002J\u001e\u0010(\u001a\u00020\u00102\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001e\u001a\u00020\fH\u0002J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020$H\u0002J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0\u0014J\u0006\u0010,\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006."}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/component/CotDetailListViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/bmhome/chat/cotdetail/component/CotDetailListComponentState;", "<init>", "()V", "msgReceiverExecutor", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "messageList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/im/bean/message/Message;", "messageMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "threadId", "setThreadId", "", "id", "init", "msgList", "", "threadMessageChangedObserver", "Lcom/larus/im/observer/OnThreadMessageChangedObserver;", "getThreadMessageChangedObserver", "()Lcom/larus/im/observer/OnThreadMessageChangedObserver;", "safelyRunOnReceiverExecutor", "action", "Lkotlin/Function0;", "addOrUpdateMessage", "msg", "source", "addOrUpdateMessageList", "putAllMessages", "putAllMessagesByMessageId", "addOrUpdateDiscreteMessageList", "removeMessage", "", "removeMessageList", "batchRemoveMessageFromList", "removeMsgList", "notifyListChange", "postValue", "isFromChunk", "getMessageList", "clear", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CotDetailListViewModel extends ComponentViewModel<CotDetailListComponentState> {
    public static final a Companion = null;
    private static final String MSG_RECEIVER_THREAD_NAME = "cot_detail#msg_receiver";
    public static final String TAG = "CotDetailListViewModel";
    private final CopyOnWriteArrayList<Message> messageList;
    private final HashMap<String, Message> messageMap;
    private final ExecutorCoroutineDispatcher msgReceiverExecutor;
    private String threadId;
    private final nf9.d threadMessageChangedObserver;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements nf9.d {
        public final /* synthetic */ CotDetailListViewModel a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[MessageListState.values().length];
                r0[MessageListState.DELETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[MessageListState.INSERT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[MessageListState.UPDATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "threadId");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public b(CotDetailListViewModel r1) {
            this.a = r1;
        }

        public final void a(String r5, final Message r6) {
            Intrinsics.checkNotNullParameter(r5, "threadId");
            Intrinsics.checkNotNullParameter(r6, "msg");
            boolean r0 = AppHost.a.isDebug();
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("onSendMessage: threadId=");
            r2.append(r5);
            r2.append(", messageid=");
            r2.append(r6.getMessageId());
            r2.append(", === local_message_id=");
            r2.append(r6.getLocalMessageId());
            r2.append(", msg=");
            if (r0 == false) goto L5;
            Message r3 = r6;
        L6:
            r2.append(r3);
            r1.i(CotDetailListViewModel.TAG, r2.toString());
            final CotDetailListViewModel r4 = this.a;
            CotDetailListViewModel.access$safelyRunOnReceiverExecutor(r4, r5, new o(r4, r6));
            return;
        L5:
            r3 = "hiddenmsg";
            goto L6
        }

        public final void f(String r5, final Message r6) {
            Intrinsics.checkNotNullParameter(r5, "threadId");
            Intrinsics.checkNotNullParameter(r6, "msg");
            boolean r0 = AppHost.a.isDebug();
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("onMessageInvisible: threadId=");
            r2.append(r5);
            r2.append(", messageid=");
            r2.append(r6.getMessageId());
            r2.append(", === local_message_id=");
            r2.append(r6.getLocalMessageId());
            r2.append(", msg=");
            if (r0 == false) goto L5;
            Message r3 = r6;
        L6:
            r2.append(r3);
            r1.i(CotDetailListViewModel.TAG, r2.toString());
            final CotDetailListViewModel r4 = this.a;
            CotDetailListViewModel.access$safelyRunOnReceiverExecutor(r4, r5, new t(r4, r6));
            return;
        L5:
            r3 = "hiddenmsg";
            goto L6
        }

        public final void b(final String r4, final MessageListState r5, final List<Message> r6) {
            Intrinsics.checkNotNullParameter(r4, "threadId");
            Intrinsics.checkNotNullParameter(r5, "state");
            Intrinsics.checkNotNullParameter(r6, "msgList");
            FLogger.a.d(CotDetailListViewModel.TAG, "onMessageListChanged: threadId=" + r4 + ", state=" + r5 + ", msgList=" + r6);
            final CotDetailListViewModel r0 = this.a;
            CotDetailListViewModel.access$safelyRunOnReceiverExecutor(r0, r4, new p(r5, r0, r6, r4));
        }

        public final void c(String r4, final Message r5, Map<String, String> r6) {
            Intrinsics.checkNotNullParameter(r4, "threadId");
            Intrinsics.checkNotNullParameter(r5, "msg");
            FLogger.a.d(CotDetailListViewModel.TAG, "onUpdateMessage: threadId=" + r4 + ", msg=" + r5 + ", ext=" + r6);
            final CotDetailListViewModel r7 = this.a;
            CotDetailListViewModel.access$safelyRunOnReceiverExecutor(r7, r4, new s(r7, r5));
        }

        public final void e(String r5, final Message r6, Map<String, String> r7) {
            Intrinsics.checkNotNullParameter(r5, "threadId");
            Intrinsics.checkNotNullParameter(r6, "msg");
            boolean r0 = AppHost.a.isDebug();
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("onReceiveMessage: threadId=");
            r2.append(r5);
            r2.append(", messageid=");
            r2.append(r6.getMessageId());
            r2.append(", === local_message_id=");
            r2.append(r6.getLocalMessageId());
            r2.append(", msg=");
            if (r0 == false) goto L5;
            Message r3 = r6;
        L6:
            r2.append(r3);
            r2.append(", ext=");
            Object r8 = r7;
            if (r0 == true) goto L10;
            r8 = "hide ext";
        L10:
            r2.append(r8);
            r1.i(CotDetailListViewModel.TAG, r2.toString());
            final CotDetailListViewModel r9 = this.a;
            CotDetailListViewModel.access$safelyRunOnReceiverExecutor(r9, r5, new r(r9, r6));
            return;
        L5:
            r3 = "hiddenmsg";
            goto L6
        }

        public final void onMessageListReplaced(String r3, final List<Message> r4, final List<Message> r5) {
            Intrinsics.checkNotNullParameter(r3, "threadId");
            Intrinsics.checkNotNullParameter(r4, "oldMsgList");
            Intrinsics.checkNotNullParameter(r5, "newMsgList");
            final CotDetailListViewModel r0 = this.a;
            CotDetailListViewModel.access$safelyRunOnReceiverExecutor(r0, r3, new q(r0, r4, r5));
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.cotdetail.component.CotDetailListViewModel$notifyListChange$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.cotdetail.component.CotDetailListViewModel$notifyListChange$1", f = "CotDetailListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CotDetailListViewModel this$0;

        public AnonymousClass1(CotDetailListViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            CotDetailListViewModel.access$postValue(this.this$0, true);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.cotdetail.component.CotDetailListViewModel$safelyRunOnReceiverExecutor$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.cotdetail.component.CotDetailListViewModel$safelyRunOnReceiverExecutor$1", f = "CotDetailListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $action;
        int label;

        public C01531(Function0<Unit> r1, Continuation<? super C01531> r2) {
            this.$action = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01531(this.$action, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$action.invoke();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ boolean No(HashMap r0, Message r1) {
        return batchRemoveMessageFromList$lambda$10(r0, r1);
    }

    public static /* synthetic */ boolean Oo(HashMap r0, Message r1) {
        return batchRemoveMessageFromList$lambda$11(r0, r1);
    }

    public static /* synthetic */ CotDetailListComponentState Po(boolean r0, boolean r1, List r2, CotDetailListComponentState r3) {
        return postValue$lambda$13(r0, r1, r2, r3);
    }

    public static /* synthetic */ Thread Qo(Runnable r0) {
        return msgReceiverExecutor$lambda$1(r0);
    }

    public final void clear() {
        this.messageList.clear();
        this.messageMap.clear();
        NativeMessageServiceImpl r0 = com.larus.im.d.e();
        String r1 = this.threadId;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.unregisterOnThreadMessageChangedObserver(r1, this.threadMessageChangedObserver);
    }

    public final List<Message> getMessageList() {
        return CollectionsKt.toList(this.messageList);
    }

    public CotDetailListViewModel() {
        this.msgReceiverExecutor = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new m()));
        this.messageList = new CopyOnWriteArrayList();
        this.messageMap = new HashMap();
        this.threadMessageChangedObserver = new b(this);
    }

    public final nf9.d getThreadMessageChangedObserver() {
        return this.threadMessageChangedObserver;
    }

    public static final /* synthetic */ HashMap access$getMessageMap$p(CotDetailListViewModel r0) {
        return r0.messageMap;
    }

    private final void addOrUpdateDiscreteMessageList(List<Message> r9) {
        boolean r0 = batchRemoveMessageFromList(r9);
        FLogger.a.d(TAG, "addOrUpdateDiscreteMessageList hasItemRemoved " + r0);
        ArrayList r1 = new ArrayList();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= this.messageList.size()) goto L12;
        if (r3 >= r9.size()) goto L12;
        if (this.messageList.get(r2).getLocalIndex() > ((Message) ListProtector.get(r9, r3)).getLocalIndex()) goto L9;
        r1.add(ListProtector.get(r9, r3));
        r3 = r3 + 1;
        goto L4
    L9:
        r1.add(this.messageList.get(r2));
        r2 = r2 + 1;
    L12:
        if (r2 >= this.messageList.size()) goto L15;
        CopyOnWriteArrayList<Message> r4 = this.messageList;
        r1.addAll(new ArrayList(r4.subList(r2, r4.size())));
    L15:
        if (r3 >= r9.size()) goto L17;
        r1.addAll(new ArrayList(r9.subList(r3, r9.size())));
    L17:
        this.messageList.clear();
        this.messageList.addAll(r1);
        this.messageMap.clear();
        putAllMessages(this.messageMap, this.messageList);
        notifyListChange$default(this, null, "addOrUpdateDiscreteMessageList", 1, null);
    }

    private final void addOrUpdateMessageList(List<Message> r3) {
        if (this.messageList.isEmpty() == false) goto L6;
        this.messageList.addAll(r3);
        putAllMessages(this.messageMap, r3);
        notifyListChange$default(this, null, "addOrUpdateMessageList", 1, null);
        return;
    L6:
        addOrUpdateDiscreteMessageList(r3);
    }

    private final boolean batchRemoveMessageFromList(List<Message> r4) {
        final HashMap<String, Message> r0 = new HashMap();
        putAllMessages(r0, r4);
        boolean r1 = CollectionsKt.removeAll(this.messageList, new k(r0));
        final HashMap<String, Message> r2 = new HashMap();
        putAllMessagesByMessageId(r2, r4);
        boolean r5 = CollectionsKt.removeAll(this.messageList, new l(r2));
        if (r1 == true) goto L7;
        if (r5 == true) goto L7;
        return false;
    L7:
        return true;
    }

    private static final Thread msgReceiverExecutor$lambda$1(Runnable r2) {
        PthreadThreadV2 r0 = new PthreadThreadV2(r2, MSG_RECEIVER_THREAD_NAME);
        ThreadMethodProxy.setPriority(r0, 10);
        return r0;
    }

    private final void postValue(final boolean r5) {
        Message r0 = (Message) CollectionsKt.firstOrNull(this.messageList);
        final boolean r1 = false;
        if (r0 != null) goto L5;
    L9:
        final List r2 = CollectionsKt.toList(this.messageList);
        setState(new n(r1, r5, r2));
        return;
    L5:
        if (r0.getUserType() != 2) goto L9;
        if (com.larus.bmhome.chat.bean.d.j0(r0) == true) goto L9;
        r1 = true;
        goto L9
    }

    private final boolean removeMessage(Message r6) {
        if (this.messageMap.containsKey(r6.getLocalMessageId()) == false) goto L17;
        Iterator<Message> r0 = this.messageList.iterator();
        int r2 = 0;
    L6:
        if (r0.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(r0.next().getLocalMessageId(), r6.getLocalMessageId()) == true) goto L12;
        r2 = r2 + 1;
    L12:
        if (r2 < 0) goto L18;
        this.messageList.remove(r2);
        HashMap<String, Message> r1 = this.messageMap;
        String r7 = r6.getLocalMessageId();
        TypeIntrinsics.asMutableMap(r1).remove(r7);
        FLogger.a.d(TAG, "#removeMessage");
        notifyListChange$default(this, null, "removeMessage", 1, null);
        return true;
    L18:
        return false;
    L11:
        r2 = -1;
        goto L12
    L17:
        return false;
    }

    private final boolean removeMessageList(List<Message> r4) {
        Iterator<T> r5 = r4.iterator();
    L3:
        boolean r1 = false;
    L5:
        if (r5.hasNext() == false) goto L10;
        if (removeMessage((Message) r5.next()) == true) goto L9;
        if (r1 == false) goto L3;
    L9:
        r1 = true;
        goto L5
    L10:
        return r1;
    }

    public final void init(List<Message> r3) {
        Intrinsics.checkNotNullParameter(r3, "msgList");
        this.messageList.clear();
        this.messageList.addAll(r3);
        putAllMessages(this.messageMap, r3);
        postValue(false);
        NativeMessageServiceImpl r4 = com.larus.im.d.e();
        String r0 = this.threadId;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r4.registerOnThreadMessageChangedObserver(r0, this.threadMessageChangedObserver);
    }

    public final void setThreadId(String r1) {
        this.threadId = r1;
    }

    public static final /* synthetic */ void access$addOrUpdateMessageList(CotDetailListViewModel r0, List r1) {
        r0.addOrUpdateMessageList(r1);
    }

    public static final /* synthetic */ boolean access$batchRemoveMessageFromList(CotDetailListViewModel r0, List r1) {
        return r0.batchRemoveMessageFromList(r1);
    }

    public static final /* synthetic */ void access$postValue(CotDetailListViewModel r0, boolean r1) {
        r0.postValue(r1);
    }

    public static final /* synthetic */ boolean access$removeMessage(CotDetailListViewModel r0, Message r1) {
        return r0.removeMessage(r1);
    }

    public static final /* synthetic */ boolean access$removeMessageList(CotDetailListViewModel r0, List r1) {
        return r0.removeMessageList(r1);
    }

    private final void addOrUpdateMessage(Message r12, String r13) {
        int r1 = -1;
        String r2 = "";
        int r4 = 0;
        if (this.messageMap.containsKey(r12.getLocalMessageId()) == false) goto L30;
        Message r0 = this.messageMap.get(r12.getLocalMessageId());
        if (r0 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L28;
        Iterator<Message> r5 = this.messageList.iterator();
    L13:
        if (r5.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(r5.next().getLocalMessageId(), r12.getLocalMessageId()) == true) goto L16;
        r4 = r4 + 1;
        goto L13
    L16:
        r1 = r4;
    L18:
        if (r1 >= 0) goto L20;
    L22:
        HashMap<String, Message> r6 = this.messageMap;
        String r7 = r12.getLocalMessageId();
        if (r7 == null) goto L26;
        r2 = r7;
    L26:
        r6.put(r2, r12);
        notifyListChange$default(this, null, r13 + "_addOrUpdateMessage in messageMap", 1, null);
        return;
    L20:
        if (r1 >= this.messageList.size()) goto L22;
        this.messageList.set(r1, r12);
        goto L22
    L28:
        removeMessage(r12);
        goto L30
    L7:
        if (r0.getLocalIndex() != r12.getLocalIndex()) goto L9;
        r3 = true;
    L30:
        if (this.messageList.isEmpty() == true) goto L55;
        long r8 = r12.getLocalIndex();
        Message r9 = (Message) CollectionsKt.firstOrNull(this.messageList);
        if (r9 == null) goto L34;
        long r10 = r9.getLocalIndex();
    L36:
        if (r8 >= r10) goto L55;
        if (CollectionsKt.last(this.messageList) != null) goto L41;
    L43:
        Iterator<Message> r11 = this.messageList.iterator();
        int r14 = 0;
    L45:
        if (r11.hasNext() == false) goto L53;
        if (r11.next().getLocalIndex() >= r12.getLocalIndex()) goto L49;
        boolean r15 = true;
    L50:
        if (r15 == true) goto L51;
        r14 = r14 + 1;
        goto L45
    L51:
        r1 = r14;
        goto L53
    L49:
        r15 = false;
    L53:
        if (r1 < 0) goto L55;
        r4 = r1;
        goto L55
    L41:
        if (((Message) CollectionsKt.last(this.messageList)).getLocalIndex() <= r12.getLocalIndex()) goto L43;
        r4 = this.messageList.size();
        goto L55
    L34:
        r10 = -1;
    L55:
        this.messageList.add(r4, r12);
        HashMap<String, Message> r16 = this.messageMap;
        String r17 = r12.getLocalMessageId();
        if (r17 == null) goto L59;
        r2 = r17;
    L59:
        r16.put(r2, r12);
        FLogger.a.d(TAG, "addOrUpdateMessage source=" + r13 + " msg=" + r12.getMessageId() + " index=" + r12.getLocalIndex() + " newMsgIndex=" + r4);
        StringBuilder r18 = new StringBuilder();
        r18.append(r13);
        r18.append("_addOrUpdateMessage not in messageMap");
        notifyListChange(r12, r18.toString());
    }

    private static final boolean batchRemoveMessageFromList$lambda$10(HashMap r0, Message r1) {
        return r0.containsKey(r1.getLocalMessageId());
    }

    private static final boolean batchRemoveMessageFromList$lambda$11(HashMap r1, Message r2) {
        if (r1.containsKey(r2.getMessageId()) == true) goto L5;
    L7:
        return false;
    L5:
        if (com.larus.utils.o0.d(r2.getMessageId()) == false) goto L7;
        return true;
    }

    private final void notifyListChange(Message r8, String r9) {
        FLogger.a.d(TAG, "notifyListChange: msg=" + r8 + ", source=" + r9);
        BuildersKt.launch$default(getViewModelScope(), this.msgReceiverExecutor, null, new AnonymousClass1(this, null), 2, null);
    }

    private final void putAllMessages(HashMap<String, Message> r4, List<Message> r5) {
        List<Message> r6 = r5;
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Message r0 = (Message) r7.next();
        String r2 = r0.getLocalMessageId();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r1.put(r2, r0);
        goto L4
    L9:
        r4.putAll(r1);
    }

    private final void putAllMessagesByMessageId(HashMap<String, Message> r4, List<Message> r5) {
        List<Message> r6 = r5;
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Message r0 = (Message) r7.next();
        String r2 = r0.getMessageId();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r1.put(r2, r0);
        goto L4
    L9:
        r4.putAll(r1);
    }

    private final void safelyRunOnReceiverExecutor(String r7, Function0<Unit> r8) {
        if (Intrinsics.areEqual(this.threadId, r7) == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(getViewModelScope(), this.msgReceiverExecutor, null, new C01531(r8, null), 2, null);
    }

    public static final /* synthetic */ void access$addOrUpdateMessage(CotDetailListViewModel r0, Message r1, String r2) {
        r0.addOrUpdateMessage(r1, r2);
    }

    public static final /* synthetic */ void access$safelyRunOnReceiverExecutor(CotDetailListViewModel r0, String r1, Function0 r2) {
        r0.safelyRunOnReceiverExecutor(r1, r2);
    }

    private static final CotDetailListComponentState postValue$lambda$13(boolean r1, boolean r2, List r3, CotDetailListComponentState r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$setState");
        return r4.copy(r1, r2, r3);
    }

    public static /* synthetic */ void notifyListChange$default(CotDetailListViewModel r0, Message r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = "notifyListChangeDefault";
    L8:
        r0.notifyListChange(r1, r2);
    }
}
