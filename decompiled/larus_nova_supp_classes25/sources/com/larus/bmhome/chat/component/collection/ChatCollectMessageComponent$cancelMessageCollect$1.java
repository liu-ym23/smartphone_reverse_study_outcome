package com.larus.bmhome.chat.component.collection;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.collection.CollectionReportDelegate;
import com.larus.bmhome.collection.ICollectionReport;
import com.larus.home.impl.sdk.j1;
import com.larus.im.bean.message.Message;
import com.larus.network.http.y;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.CancelCollectionResponse;
import com.larus.platform.model.CollectionDetail;
import com.larus.platform.model.MessageCollection;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.k0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$cancelMessageCollect$1", f = "ChatCollectMessageComponent.kt", i = {}, l = {403}, m = "invokeSuspend", n = {}, s = {})
final class ChatCollectMessageComponent$cancelMessageCollect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ String $clickFrom;
    final /* synthetic */ int $collectionType;
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ ChatCollectMessageComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$cancelMessageCollect$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$cancelMessageCollect$1$1", f = "ChatCollectMessageComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ com.larus.network.http.a<CancelCollectionResponse> $collectCancelResult;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super Boolean, Unit> r1, com.larus.network.http.a<CancelCollectionResponse> r2, Continuation<? super AnonymousClass1> r3) {
            this.$callback = r1;
            this.$collectCancelResult = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$callback, this.$collectCancelResult, r4);
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
            this.$callback.invoke(Boxing.boxBoolean(this.$collectCancelResult instanceof y));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatCollectMessageComponent$cancelMessageCollect$1(Message r1, int r2, String r3, ChatCollectMessageComponent r4, Function1<? super Boolean, Unit> r5, Continuation<? super ChatCollectMessageComponent$cancelMessageCollect$1> r6) {
        this.$message = r1;
        this.$collectionType = r2;
        this.$clickFrom = r3;
        this.this$0 = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatCollectMessageComponent$cancelMessageCollect$1(this.$message, this.$collectionType, this.$clickFrom, this.this$0, this.$callback, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L13:
        com.larus.network.http.a r13 = (com.larus.network.http.a) r12;
    L15:
        ICollectionReport.a.b(CollectionReportDelegate.b, r13, CollectionsKt.listOf(this.$message), this.$clickFrom, null, null, null, 120);
        if ((r13 instanceof y) == true) goto L18;
    L35:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(this.$callback, r13, null), 3, null);
        return Unit.INSTANCE;
    L18:
        if (this.$collectionType != 5) goto L35;
        CancelCollectionResponse r2 = (CancelCollectionResponse) ((com.larus.network.http.a) ((y) r13)).b;
        if (r2 == null) goto L31;
        MessageCollection r3 = r2.getCollectionInfo();
        if (r3 == null) goto L31;
        List r4 = r3.getCollectionDetails();
        if (r4 == null) goto L31;
        ?? r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L27:
        if (r6.hasNext() == false) goto L32;
        Message r7 = k0.a((CollectionDetail) r6.next());
        if (r7 == null) goto L27;
        r5.add(r7);
    L32:
        u7 r8 = (u7) this.this$0.q.getValue();
        if (r8 == null) goto L35;
        r8.iE(r5, false);
    L31:
        r5 = CollectionsKt.emptyList();
        goto L32
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        IFlowSdkDepend r14 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r14 == null) goto L14;
        r14.getCollectService();
        j1 r15 = j1.a;
        Message r9 = this.$message;
        int r10 = this.$collectionType;
        this.label = 1;
        r12 = r15.c(r9, r10, this);
        if (r12 != r0) goto L13;
        return r0;
    L14:
        r13 = null;
        goto L15
    }
}
