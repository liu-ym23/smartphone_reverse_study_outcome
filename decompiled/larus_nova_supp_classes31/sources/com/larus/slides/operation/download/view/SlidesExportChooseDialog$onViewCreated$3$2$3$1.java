package com.larus.slides.operation.download.view;

import android.content.Context;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.operation.download.view.SlidesExportChooseDialog$onViewCreated$3$2$3$1", f = "SlidesExportChooseDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SlidesExportChooseDialog$onViewCreated$3$2$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $extraMsg;
    int label;
    final /* synthetic */ SlidesExportChooseDialog this$0;

    public SlidesExportChooseDialog$onViewCreated$3$2$3$1(SlidesExportChooseDialog r1, String r2, Continuation<? super SlidesExportChooseDialog$onViewCreated$3$2$3$1> r3) {
        this.this$0 = r1;
        this.$extraMsg = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SlidesExportChooseDialog$onViewCreated$3$2$3$1(this.this$0, this.$extraMsg, r4);
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
        Context r3 = this.this$0.getContext();
        String r15 = this.this$0.h;
        String r8 = this.$extraMsg;
        IShareService.a.d(r2, r3, "more", "file", new com.larus.bmhome.share.panel.b(null, null, null, null, null, null, null, r8, r15, null, null, r8, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67106431), null, 48);
        int r1 = SlidesExportChooseDialog.k;
        SlidesExportChooseDialog.a.a(this.this$0);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
