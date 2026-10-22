package com.obric.assistant.upload.internal;

import com.larus.im.bean.message.UplinkFileEntity;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mr9.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.upload.internal.ObricUploadDispatcher$onSuccess$1", f = "ObricUploadDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricUploadDispatcher$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $identifier;
    final /* synthetic */ mr9.d $imageResult;
    final /* synthetic */ String $resId;
    final /* synthetic */ String $tosKey;
    final /* synthetic */ n $videoResult;
    int label;

    public ObricUploadDispatcher$onSuccess$1(String r1, UplinkFileEntity r2, String r3, String r4, mr9.d r5, n r6, Continuation<? super ObricUploadDispatcher$onSuccess$1> r7) {
        this.$identifier = r1;
        this.$entity = r2;
        this.$tosKey = r3;
        this.$resId = r4;
        this.$imageResult = r5;
        this.$videoResult = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ObricUploadDispatcher$onSuccess$1(this.$identifier, this.$entity, this.$tosKey, this.$resId, this.$imageResult, this.$videoResult, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r10);
        int r11 = m.a;
        m.c("ObricUploadDispatcher", "onSuccess called, identifier = " + this.$identifier);
        Set<oha.a> r12 = e.a.get(this.$identifier);
        if (r12 == null) goto L11;
        UplinkFileEntity r0 = this.$entity;
        String r7 = this.$tosKey;
        String r8 = this.$resId;
        Iterator<T> r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L11;
        oha.a r1 = (oha.a) r13.next();
        r1.c(r0, r7, r8);
        r1.onResult(true, r7, r8, null, null);
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
