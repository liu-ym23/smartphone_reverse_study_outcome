package com.obric.assistant.component;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricUpdateComponent$showInstallTip$1$blocked$1", f = "ObricUpdateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricUpdateComponent$showInstallTip$1$blocked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ ObricUpdateComponent this$0;

    public ObricUpdateComponent$showInstallTip$1$blocked$1(ObricUpdateComponent r1, Continuation<? super ObricUpdateComponent$showInstallTip$1$blocked$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricUpdateComponent$showInstallTip$1$blocked$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r7);
        long r0 = com.obric.assistant.t1.a.L0().getObricUpdateMainInstallDialogInterval() * 1000;
        long r2 = this.this$0.r.getLong("obric_update_dialog_close_time", 0);
        FLogger.a.i("ObricUpdateComponent", "showInstallTip return, lastCloseTime(" + r2 + ") not match gap time(" + r0 + ')');
        if ((AppHost.a.getAppClock().currentTimeMillis() - r2) >= r0) goto L7;
        boolean r8 = true;
    L9:
        return Boxing.boxBoolean(r8);
    L7:
        r8 = false;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
