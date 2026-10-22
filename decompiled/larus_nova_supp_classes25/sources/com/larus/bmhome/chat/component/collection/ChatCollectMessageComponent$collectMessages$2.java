package com.larus.bmhome.chat.component.collection;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.collection.CollectionReportDelegate;
import com.larus.bmhome.collection.ICollectionReport;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.j1;
import com.larus.im.bean.message.Message;
import com.larus.network.http.f;
import com.larus.network.http.y;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.SaveCollectionResponse;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$collectMessages$2", f = "ChatCollectMessageComponent.kt", i = {0}, l = {367}, m = "invokeSuspend", n = {"qaStateMessages"}, s = {"L$0"})
public final class ChatCollectMessageComponent$collectMessages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, String, Unit> $callback;
    final /* synthetic */ String $clickFrom;
    final /* synthetic */ int $collectionType;
    final /* synthetic */ List<Message> $distinctMessages;
    final /* synthetic */ String $followingOtherAction;
    final /* synthetic */ JSONObject $traceInfo;
    Object L$0;
    int label;
    final /* synthetic */ ChatCollectMessageComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$collectMessages$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$collectMessages$2$1", f = "ChatCollectMessageComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Boolean, String, Unit> $callback;
        final /* synthetic */ com.larus.network.http.a<SaveCollectionResponse> $result;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function2<? super Boolean, ? super String, Unit> r1, com.larus.network.http.a<SaveCollectionResponse> r2, Continuation<? super AnonymousClass1> r3) {
            this.$callback = r1;
            this.$result = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$callback, this.$result, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r3);
            Function2<Boolean, String, Unit> r4 = this.$callback;
            Boolean r0 = Boxing.boxBoolean(true);
            SaveCollectionResponse r1 = (SaveCollectionResponse) ((com.larus.network.http.a) this.$result).b;
            if (r1 == null) goto L7;
            String r2 = r1.getCollectionId();
        L8:
            r4.invoke(r0, r2);
            return Unit.INSTANCE;
        L7:
            r2 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$collectMessages$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$collectMessages$2$2", f = "ChatCollectMessageComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            s.a.g(AppHost.a.getApplication(), 2131907394, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$collectMessages$2$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$collectMessages$2$3", f = "ChatCollectMessageComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Boolean, String, Unit> $callback;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function2<? super Boolean, ? super String, Unit> r1, Continuation<? super AnonymousClass3> r2) {
            this.$callback = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.$callback, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            this.$callback.invoke(Boxing.boxBoolean(false), null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatCollectMessageComponent$collectMessages$2(List<Message> r1, int r2, String r3, String r4, JSONObject r5, ChatCollectMessageComponent r6, Function2<? super Boolean, ? super String, Unit> r7, Continuation<? super ChatCollectMessageComponent$collectMessages$2> r8) {
        this.$distinctMessages = r1;
        this.$collectionType = r2;
        this.$clickFrom = r3;
        this.$followingOtherAction = r4;
        this.$traceInfo = r5;
        this.this$0 = r6;
        this.$callback = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ChatCollectMessageComponent$collectMessages$2(this.$distinctMessages, this.$collectionType, this.$clickFrom, this.$followingOtherAction, this.$traceInfo, this.this$0, this.$callback, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        List<Message> r3 = (List) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r5 = r18;
    L26:
        List<Message> r4 = r3;
        com.larus.network.http.a r6 = (com.larus.network.http.a) r5;
    L28:
        ICollectionReport.a.a(CollectionReportDelegate.b, r6, this.$distinctMessages, this.$clickFrom, this.$followingOtherAction, null, this.$traceInfo, 16);
        FLogger.a.i("ChatCollectMessageComponent", "collectMessages, result:" + r6);
        if ((r6 instanceof y) == false) goto L37;
        if ((!r4.isEmpty()) == false) goto L35;
        u7 r7 = (u7) this.this$0.q.getValue();
        if (r7 == null) goto L35;
        r7.iE(r4, true);
    L35:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(this.$callback, r6, null), 3, null);
    L43:
        return Unit.INSTANCE;
    L37:
        if ((r6 instanceof f) == true) goto L39;
    L41:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass3(this.$callback, null), 3, null);
        goto L43
    L39:
        if (((f) r6).d.getCode() != 710054001) goto L41;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass2(null), 3, null);
        goto L41
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        r4 = this.$distinctMessages;
        if (this.$collectionType != 5) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == true) goto L15;
        r4 = null;
    L15:
        if (r4 != null) goto L17;
        r4 = CollectionsKt.emptyList();
    L17:
        IFlowSdkDepend r9 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r9 == null) goto L20;
        r9.getCollectService();
        j1 r10 = j1.a;
    L21:
        if (r10 == null) goto L27;
        int r11 = this.$collectionType;
        List<Message> r12 = this.$distinctMessages;
        this.L$0 = r4;
        this.label = 1;
        r5 = r10.d(r11, r12, this);
        if (r5 != r1) goto L25;
        return r1;
    L25:
        r3 = r4;
        goto L26
    L27:
        r6 = null;
        goto L28
    L20:
        r10 = null;
        goto L21
    L11:
        r8 = false;
        goto L12
    }
}
