package com.larus.community.impl.component;

import com.larus.platform.api.creation.UserCreation;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/platform/api/creation/UserCreation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.component.CreationFeedComponent$ensureProfileNoWatermarkBeforeOpen$1$selectedData$1", f = "CreationFeedComponent.kt", i = {}, l = {913}, m = "invokeSuspend", n = {}, s = {})
public final class CreationFeedComponent$ensureProfileNoWatermarkBeforeOpen$1$selectedData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UserCreation>, Object> {
    final /* synthetic */ UserCreation $data;
    int label;
    final /* synthetic */ CreationFeedComponent this$0;

    public CreationFeedComponent$ensureProfileNoWatermarkBeforeOpen$1$selectedData$1(UserCreation r1, CreationFeedComponent r2, Continuation<? super CreationFeedComponent$ensureProfileNoWatermarkBeforeOpen$1$selectedData$1> r3) {
        this.$data = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationFeedComponent$ensureProfileNoWatermarkBeforeOpen$1$selectedData$1(this.$data, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super UserCreation> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L15:
        UserCreation r7 = (UserCreation) r6;
        if (r7 == null) goto L18;
        return r7;
    L18:
        return this.$data;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CreationNoWatermarkManager r8 = CreationNoWatermarkManager.a;
        UserCreation r2 = this.$data;
        CreationFeedComponent r3 = this.this$0;
        int r4 = CreationFeedComponent.K;
        if (r3.B3() != 2) goto L11;
        String r5 = "profile_private_detail_open";
    L12:
        this.label = 1;
        r6 = r8.n(r2, r5, this);
        if (r6 != r0) goto L15;
        return r0;
    L11:
        r5 = "profile_public_detail_open";
        goto L12
    }
}
