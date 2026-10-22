package com.larus.sheet.impl;

import com.larus.sheet.sdk.api.ISheetSdkServiceV2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
@DebugMetadata(c = "com.larus.sheet.impl.SheetFragment$updateArtifactInfo$1", f = "SheetFragment.kt", i = {}, l = {1108}, m = "invokeSuspend", n = {}, s = {})
public final class SheetFragment$updateArtifactInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $artifactMetaId;
    final /* synthetic */ String $boundMessageId;
    final /* synthetic */ String $conversationId;
    Object L$0;
    int label;
    final /* synthetic */ SheetFragment this$0;

    public SheetFragment$updateArtifactInfo$1(SheetFragment r1, String r2, String r3, String r4, Continuation<? super SheetFragment$updateArtifactInfo$1> r5) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$artifactMetaId = r3;
        this.$boundMessageId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SheetFragment$updateArtifactInfo$1(this.this$0, this.$conversationId, this.$artifactMetaId, this.$boundMessageId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        SheetFragment r2 = (SheetFragment) this.L$0;
        ResultKt.throwOnFailure(r5);
    L14:
        List r6 = (List) r5;
        if (r6 == null) goto L17;
        String r7 = (String) CollectionsKt.firstOrNull(r6);
    L19:
        r2.C = r7;
        ISheetSdkServiceV2 r8 = (ISheetSdkServiceV2) ServiceManager.get().getService(ISheetSdkServiceV2.class);
        if (r8 == null) goto L23;
        String r3 = this.this$0.C;
        r8.G();
    L23:
        return Unit.INSTANCE;
    L17:
        SheetFragment r9 = r2;
    L18:
        r2 = r9;
        r7 = null;
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        r9 = this.this$0;
        String r4 = this.$conversationId;
        if (r4 == null) goto L18;
        this.L$0 = r9;
        this.label = 1;
        Object r10 = ic8.n.b(r4, this);
        if (r10 != r0) goto L13;
        return r0;
    L13:
        r2 = r9;
        r5 = r10;
        goto L14
    }
}
