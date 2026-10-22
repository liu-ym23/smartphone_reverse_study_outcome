package com.larus.xbridge.custom;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.xbridge.custom.FlowSystemShareMethod$handle$1$1", f = "FlowSystemShareMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowSystemShareMethod$handle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletionBlock<p1.c> $callback;
    final /* synthetic */ Activity $context;
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $filePath;
    int label;

    public FlowSystemShareMethod$handle$1$1(Activity r1, String r2, String r3, CompletionBlock<p1.c> r4, Continuation<? super FlowSystemShareMethod$handle$1$1> r5) {
        this.$context = r1;
        this.$filePath = r2;
        this.$fileName = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new FlowSystemShareMethod$handle$1$1(this.$context, this.$filePath, this.$fileName, this.$callback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r36) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r36);
        ShareServiceDelegate r2 = ShareServiceDelegate.b;
        Activity r3 = this.$context;
        String r8 = this.$filePath;
        String r9 = this.$fileName;
        IShareService.a.d(r2, r3, "more", "file", new com.larus.bmhome.share.panel.b(null, null, null, null, null, null, null, r8, r9, null, null, r8, r9, null, null, null, false, false, null, null, false, false, null, false, null, null, 67102335), null, 48);
        CompletionBlock.DefaultImpls.onSuccess$default(this.$callback, ne7.e.b(p1.c.class), null, 2, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
