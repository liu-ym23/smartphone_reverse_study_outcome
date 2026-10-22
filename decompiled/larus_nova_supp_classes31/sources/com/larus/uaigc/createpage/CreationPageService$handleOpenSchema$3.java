package com.larus.uaigc.createpage;

import android.os.Bundle;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.CreationPageService$handleOpenSchema$3", f = "CreationPageService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreationPageService$handleOpenSchema$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $item;
    final /* synthetic */ String $schemaUrl;
    int label;

    public CreationPageService$handleOpenSchema$3(String r1, com.larus.bmhome.actionbar.model.z0 r2, Bundle r3, Continuation<? super CreationPageService$handleOpenSchema$3> r4) {
        this.$schemaUrl = r1;
        this.$item = r2;
        this.$args = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationPageService$handleOpenSchema$3(this.$schemaUrl, this.$item, this.$args, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r5);
        Iterator<com.larus.bmhome.view.actionbar.custom.router.b> r6 = IAIChatUgcAIGCService.a.P().iterator();
    L6:
        if (r6.hasNext() == false) goto L13;
        com.larus.bmhome.view.actionbar.custom.router.b r0 = r6.next();
        if (r0.b(this.$schemaUrl) == false) goto L6;
        if (r0.a(null, this.$schemaUrl, this.$args) == false) goto L6;
        FLogger.a.i("CreationPageService", "[handleOpenSchema] handled by " + Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName());
    L13:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
