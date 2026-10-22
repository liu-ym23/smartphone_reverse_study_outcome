package com.larus.slides.operation.download.view;

import android.app.Application;
import com.larus.common.apphost.AppHost;
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
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.operation.download.view.SlidesExportChooseDialog$onViewCreated$3$2$3$2", f = "SlidesExportChooseDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SlidesExportChooseDialog$onViewCreated$3$2$3$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $code;
    int label;
    final /* synthetic */ SlidesExportChooseDialog this$0;

    public SlidesExportChooseDialog$onViewCreated$3$2$3$2(Integer r1, SlidesExportChooseDialog r2, Continuation<? super SlidesExportChooseDialog$onViewCreated$3$2$3$2> r3) {
        this.$code = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SlidesExportChooseDialog$onViewCreated$3$2$3$2(this.$code, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r3);
        Integer r4 = this.$code;
        if (r4 != null) goto L8;
    L10:
        if (r4 != null) goto L13;
    L15:
        s r5 = s.a;
        Application r0 = AppHost.a.getApplication();
        r5.getClass();
        s.s(r0, 2131909776);
    L16:
        int r6 = SlidesExportChooseDialog.k;
        SlidesExportChooseDialog.a.a(this.this$0);
        return Unit.INSTANCE;
    L13:
        if (r4.intValue() != 900099003) goto L15;
        s r7 = s.a;
        Application r1 = AppHost.a.getApplication();
        r7.getClass();
        s.s(r1, 2131905531);
        goto L16
    L8:
        if (r4.intValue() != 900099001) goto L10;
        s r8 = s.a;
        Application r2 = AppHost.a.getApplication();
        r8.getClass();
        s.s(r2, 2131905533);
        goto L16
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
