package com.larus.bmhome.chat.deepsearch;

import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepsearch.DeepSearchMessageAdapterCreator$setData$1", f = "DeepSearchMessageAdapter.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
final class DeepSearchMessageAdapterCreator$setData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ q0 $adapter;
    final /* synthetic */ List<Message> $messageList;
    final /* synthetic */ boolean $refreshAll;
    int label;

    public DeepSearchMessageAdapterCreator$setData$1(q0 r1, List<Message> r2, boolean r3, Continuation<? super DeepSearchMessageAdapterCreator$setData$1> r4) {
        this.$adapter = r1;
        this.$messageList = r2;
        this.$refreshAll = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DeepSearchMessageAdapterCreator$setData$1(this.$adapter, this.$messageList, this.$refreshAll, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L49:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        q0 r13 = this.$adapter;
        if ((r13 instanceof com.larus.bmhome.chat.adapter.i) == false) goto L11;
        com.larus.bmhome.chat.adapter.i r14 = (com.larus.bmhome.chat.adapter.i) r13;
    L12:
        if (r14 == null) goto L49;
        List<Message> r2 = this.$messageList;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r3 = r2.iterator();
    L15:
        if (r3.hasNext() == false) goto L45;
        Message r5 = (Message) r3.next();
        if (r5.getContentType() != 2) goto L31;
        int r7 = i.a;
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        Iterator r9 = CollectionsKt.listOf(new k()).iterator();
    L20:
        if (r9.hasNext() == false) goto L24;
        Object r10 = r9.next();
        if (((xc8.g) r10).a(r5) == false) goto L20;
    L25:
        xc8.g r11 = (xc8.g) r10;
        if (r11 == null) goto L28;
        xc8.b r15 = r11.b(r5);
        r15.c = false;
        r8.element = r15;
    L28:
        xc8.b r6 = (xc8.b) r8.element;
        if (r6 != null) goto L44;
        r6 = new xc8.b(r5);
    L44:
        r4.add(r6);
        goto L15
    L24:
        r10 = null;
        goto L25
    L31:
        int r16 = i.a;
        Ref.ObjectRef r17 = new Ref.ObjectRef();
        Iterator r18 = CollectionsKt.listOf(new l()).iterator();
    L33:
        if (r18.hasNext() == false) goto L37;
        Object r19 = r18.next();
        if (((xc8.g) r19).a(r5) == false) goto L33;
    L38:
        xc8.g r20 = (xc8.g) r19;
        if (r20 == null) goto L41;
        xc8.b r21 = r20.b(r5);
        r21.c = false;
        r17.element = r21;
    L41:
        r6 = (xc8.b) r17.element;
        if (r6 != null) goto L44;
        r6 = new xc8.b(r5);
        goto L44
    L37:
        r19 = null;
        goto L38
    L45:
        com.larus.bmhome.social.page.datasource.event.c r22 = new com.larus.bmhome.social.page.datasource.event.c(r4, 1, CollectionsKt.mutableListOf(new com.larus.bmhome.social.page.datasource.event.b.d[]{new com.larus.bmhome.social.page.datasource.event.b.d(this.$refreshAll)}));
        this.label = 1;
        if (r14.k1(r22, this) != r0) goto L49;
        return r0;
    L11:
        r14 = null;
        goto L12
    }
}
