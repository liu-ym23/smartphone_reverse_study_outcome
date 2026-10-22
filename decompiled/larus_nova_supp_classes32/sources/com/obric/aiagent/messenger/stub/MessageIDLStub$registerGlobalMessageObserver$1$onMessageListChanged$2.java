package com.obric.aiagent.messenger.stub;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$registerGlobalMessageObserver$1$onMessageListChanged$2", f = "MessageIDLStub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageIDLStub$registerGlobalMessageObserver$1$onMessageListChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<IMMessage> $imMsgList;
    final /* synthetic */ boolean $isDeleteState;
    final /* synthetic */ List<MessageIDLStub$e> $widgetSnapshots;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$registerGlobalMessageObserver$1$onMessageListChanged$2(List<MessageIDLStub$e> r1, List<IMMessage> r2, MessageIDLStub r3, boolean r4, Continuation<? super MessageIDLStub$registerGlobalMessageObserver$1$onMessageListChanged$2> r5) {
        this.$widgetSnapshots = r1;
        this.$imMsgList = r2;
        this.this$0 = r3;
        this.$isDeleteState = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MessageIDLStub$registerGlobalMessageObserver$1$onMessageListChanged$2(this.$widgetSnapshots, this.$imMsgList, this.this$0, this.$isDeleteState, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L52;
        ResultKt.throwOnFailure(r13);
        List<MessageIDLStub$e> r14 = this.$widgetSnapshots;
        MessageIDLStub r0 = this.this$0;
        Iterator<T> r15 = r14.iterator();
    L6:
        if (r15.hasNext() == false) goto L8;
        MessageIDLStub.access$restoreOrBufferPendingWidgetUpdates(r0, (MessageIDLStub$e) r15.next());
        goto L6
    L8:
        List<IMMessage> r16 = this.$imMsgList;
        boolean r1 = this.$isDeleteState;
        MessageIDLStub r2 = this.this$0;
        Iterator<T> r17 = r16.iterator();
    L10:
        if (r17.hasNext() == false) goto L50;
        final IMMessage r3 = (IMMessage) r17.next();
        if (r1 == true) goto L13;
        if (MessageIDLStub.access$shouldDispatchUpdate(r2, r3) == false) goto L10;
    L48:
        FLogger.a.i("IFlowMessageIDLSPI", "onMessageListChanged, messageId:" + r3.getMessageId() + ", lists size:" + MessageIDLStub.access$getMessageCallbackList$p(r2).getRegisteredCallbackCount());
        MessageIDLStub.access$dispatchMessageEvent(r2, 4, new a1(r3));
        goto L10
    L13:
        String r4 = r3.getMessageId();
        if (r4.length() <= 0) goto L16;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        String r6 = r4;
    L21:
        if (r6 == null) goto L23;
        String r7 = (String) MessageIDLStub.access$getLastUpdateFingerprintMap$p(r2).remove(r6);
    L23:
        MessageIDLStub.access$removeConfirmedWidgetUpdate(r2, r3.getLocalMessageId(), r4);
        Set r8 = MessageIDLStub.access$getPendingWidgetUpdates$p(r2).entrySet();
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L25:
        if (r10.hasNext() == false) goto L35;
        Object r11 = r10.next();
        Map.Entry r12 = (Map.Entry) r11;
        if (Intrinsics.areEqual(((MessageIDLStub$c) r12.getValue()).b, r4) == false) goto L29;
    L32:
        boolean r18 = true;
    L33:
        if (r18 == false) goto L25;
        r9.add(r11);
        goto L25
    L29:
        if (Intrinsics.areEqual(r12.getKey(), r3.getLocalMessageId()) == true) goto L32;
        r18 = false;
        goto L33
    L35:
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r20 = r9.iterator();
    L37:
        if (r20.hasNext() == false) goto L39;
        r19.add((String) ((Map.Entry) r20.next()).getKey());
        goto L37
    L39:
        Iterator r21 = r19.iterator();
    L41:
        if (r21.hasNext() == false) goto L48;
        String r22 = (String) r21.next();
        MessageIDLStub$c r23 = (MessageIDLStub$c) MessageIDLStub.access$getPendingWidgetUpdates$p(r2).remove(r22);
        MessageIDLStub.access$getInFlightWidgetUpdateRevisions$p(r2).remove(r22);
        MessageIDLStub.access$getBufferedWidgetSnapshots$p(r2).remove(r22);
        if (r23 == null) goto L41;
        MessageIDLStub.notifyForegroundWidgetSyncProgress$default(r2, r23.c, false, 2, null);
        goto L41
    L20:
        r6 = null;
        goto L21
    L16:
        r5 = false;
        goto L18
    L50:
        return Unit.INSTANCE;
    L52:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
