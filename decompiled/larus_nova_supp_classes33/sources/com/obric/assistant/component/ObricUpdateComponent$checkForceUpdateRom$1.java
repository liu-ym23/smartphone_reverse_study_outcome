package com.obric.assistant.component;

import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricUpdateComponent$checkForceUpdateRom$1", f = "ObricUpdateComponent.kt", i = {}, l = {588}, m = "invokeSuspend", n = {}, s = {})
final class ObricUpdateComponent$checkForceUpdateRom$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    int label;
    final /* synthetic */ ObricUpdateComponent this$0;

    public ObricUpdateComponent$checkForceUpdateRom$1(ObricUpdateComponent r1, FragmentActivity r2, Continuation<? super ObricUpdateComponent$checkForceUpdateRom$1> r3) {
        this.this$0 = r1;
        this.$activity = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricUpdateComponent$checkForceUpdateRom$1(this.this$0, this.$activity, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.assistant.component.p4] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.assistant.component.q4] */
    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: Exception -> L21
    L15:
        Boolean r5 = (Boolean) r4;     // Catch: Exception -> L21
    L18:
        if (Intrinsics.areEqual(r5, Boxing.boxBoolean(true)) == false) goto L24;
        final ObricUpdateComponent r6 = this.this$0;     // Catch: Exception -> L21
        final FragmentActivity r2 = this.$activity;     // Catch: Exception -> L21
        ObricUpdateComponent.p3(r6, new p4(r6, r2), new q4(r6, r2));     // Catch: Exception -> L21
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        IObricUpdateService r7 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);     // Catch: Exception -> L21
        if (r7 == null) goto L16;
        this.label = 1;     // Catch: Exception -> L21
        r4 = r7.g(this);     // Catch: Exception -> L21
        if (r4 != r0) goto L15;
        return r0;
    L16:
        r5 = null;
    L21:
        e = move-exception;
        FLogger.a.i("ObricUpdateComponent", "checkForceUpdateRom " + e);
        goto L24
    }
}
