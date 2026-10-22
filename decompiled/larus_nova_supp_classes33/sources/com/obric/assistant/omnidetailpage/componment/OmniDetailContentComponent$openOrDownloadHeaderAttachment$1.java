package com.obric.assistant.omnidetailpage.componment;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent$openOrDownloadHeaderAttachment$1", f = "OmniDetailContentComponent.kt", i = {}, l = {777}, m = "invokeSuspend", n = {}, s = {})
public final class OmniDetailContentComponent$openOrDownloadHeaderAttachment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ifa.a $attachment;
    final /* synthetic */ String $localPath;
    int label;
    final /* synthetic */ OmniDetailContentComponent this$0;

    public OmniDetailContentComponent$openOrDownloadHeaderAttachment$1(OmniDetailContentComponent r1, ifa.a r2, String r3, Continuation<? super OmniDetailContentComponent$openOrDownloadHeaderAttachment$1> r4) {
        this.this$0 = r1;
        this.$attachment = r2;
        this.$localPath = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new OmniDetailContentComponent$openOrDownloadHeaderAttachment$1(this.this$0, this.$attachment, this.$localPath, r5);
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
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        OmniDetailContentComponent r6 = this.this$0;
        String r2 = this.$attachment.a;
        String r3 = this.$localPath;
        this.label = 1;
        if (OmniDetailContentComponent.C3(r6, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
