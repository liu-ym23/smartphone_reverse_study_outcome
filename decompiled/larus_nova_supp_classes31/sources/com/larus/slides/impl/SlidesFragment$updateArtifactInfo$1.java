package com.larus.slides.impl;

import com.tencent.open.log.TraceLevel;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.SlidesFragment$updateArtifactInfo$1", f = "SlidesFragment.kt", i = {}, l = {311}, m = "invokeSuspend", n = {}, s = {})
public final class SlidesFragment$updateArtifactInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $artifactMetaId;
    final /* synthetic */ String $artifactVersionId;
    final /* synthetic */ String $boundMessageId;
    final /* synthetic */ String $conversationId;
    Object L$0;
    int label;
    final /* synthetic */ SlidesFragment this$0;

    public SlidesFragment$updateArtifactInfo$1(SlidesFragment r1, String r2, String r3, String r4, String r5, Continuation<? super SlidesFragment$updateArtifactInfo$1> r6) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$artifactMetaId = r3;
        this.$artifactVersionId = r4;
        this.$boundMessageId = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new SlidesFragment$updateArtifactInfo$1(this.this$0, this.$conversationId, this.$artifactMetaId, this.$artifactVersionId, this.$boundMessageId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        SlidesFragment r2 = (SlidesFragment) this.L$0;
        ResultKt.throwOnFailure(r9);
    L14:
        List r10 = (List) r9;
        if (r10 == null) goto L17;
        String r11 = (String) CollectionsKt.firstOrNull(r10);
    L19:
        r2.w = r11;
        SlidesFragment r3 = this.this$0;
        r3.sa0(this.$artifactMetaId, this.$artifactVersionId, this.$conversationId, this.$boundMessageId, r3.w);
        return Unit.INSTANCE;
    L17:
        SlidesFragment r12 = r2;
    L18:
        r2 = r12;
        r11 = null;
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        r12 = this.this$0;
        String r4 = this.$conversationId;
        if (r4 == null) goto L18;
        this.L$0 = r12;
        this.label = 1;
        Object r5 = ic8.n.b(r4, this);
        if (r5 != r0) goto L13;
        return r0;
    L13:
        r2 = r12;
        r9 = r5;
        goto L14
    }
}
