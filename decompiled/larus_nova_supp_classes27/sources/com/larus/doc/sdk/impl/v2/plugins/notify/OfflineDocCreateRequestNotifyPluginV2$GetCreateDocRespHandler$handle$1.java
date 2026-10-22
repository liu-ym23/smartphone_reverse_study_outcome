package com.larus.doc.sdk.impl.v2.plugins.notify;

import com.larus.doc.sdk.impl.service.ServiceManager;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.sdk.impl.v2.plugins.notify.OfflineDocCreateRequestNotifyPluginV2$GetCreateDocRespHandler$handle$1", f = "OfflineDocCreateRequestNotifyPluginV2.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
public final class OfflineDocCreateRequestNotifyPluginV2$GetCreateDocRespHandler$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ m $callback;
    final /* synthetic */ String $docLogicKey;
    int label;
    final /* synthetic */ OfflineDocCreateRequestNotifyPluginV2 this$0;

    /* JADX INFO: renamed from: com.larus.doc.sdk.impl.v2.plugins.notify.OfflineDocCreateRequestNotifyPluginV2$GetCreateDocRespHandler$handle$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.sdk.impl.v2.plugins.notify.OfflineDocCreateRequestNotifyPluginV2$GetCreateDocRespHandler$handle$1$1", f = "OfflineDocCreateRequestNotifyPluginV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ m $callback;
        final /* synthetic */ String $createDocResp;
        int label;
        final /* synthetic */ OfflineDocCreateRequestNotifyPluginV2 this$0;

        public AnonymousClass1(m r1, OfflineDocCreateRequestNotifyPluginV2 r2, String r3, Continuation<? super AnonymousClass1> r4) {
            this.$callback = r1;
            this.this$0 = r2;
            this.$createDocResp = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$callback, this.this$0, this.$createDocResp, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            m r4 = this.$callback;
            if (r4 == null) goto L8;
            r4.b(OfflineDocCreateRequestNotifyPluginV2.access$parseCreateDocResp(this.this$0, this.$createDocResp));
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public OfflineDocCreateRequestNotifyPluginV2$GetCreateDocRespHandler$handle$1(String r1, m r2, OfflineDocCreateRequestNotifyPluginV2 r3, Continuation<? super OfflineDocCreateRequestNotifyPluginV2$GetCreateDocRespHandler$handle$1> r4) {
        this.$docLogicKey = r1;
        this.$callback = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new OfflineDocCreateRequestNotifyPluginV2$GetCreateDocRespHandler$handle$1(this.$docLogicKey, this.$callback, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        String r9 = ServiceManager.INSTANCE.getOperationService(this.$docLogicKey).getCreateDocResp();
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("finish get create doc resp, docLogicKey=");
        r3.append(this.$docLogicKey);
        r3.append(", hasResp=");
        if (r9 == null) goto L11;
        boolean r4 = true;
    L12:
        r3.append(r4);
        r2.i("OfflineDocCreateRequestNotifyPluginV2", r3.toString());
        MainCoroutineDispatcher r5 = Dispatchers.getMain();
        AnonymousClass1 r6 = new AnonymousClass1(this.$callback, this.this$0, r9, null);
        this.label = 1;
        if (BuildersKt.withContext(r5, r6, this) != r0) goto L16;
        return r0;
    L11:
        r4 = false;
        goto L12
    }
}
