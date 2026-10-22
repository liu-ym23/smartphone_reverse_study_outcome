package com.obric.assistant.component;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricUpdateComponent$checkActivityExpandState$1", f = "ObricUpdateComponent.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
final class ObricUpdateComponent$checkActivityExpandState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricUpdateComponent this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AssistantActivityExpandState.values().length];
            r0[AssistantActivityExpandState.FULL_SCREEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AssistantActivityExpandState.HALF_WINDOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public ObricUpdateComponent$checkActivityExpandState$1(ObricUpdateComponent r1, Continuation<? super ObricUpdateComponent$checkActivityExpandState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricUpdateComponent$checkActivityExpandState$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L11;
        if (r2 != 1) goto L10;
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L7
    L15:
        AssistantActivityExpandState r9 = IAssistantInteractionServiceKt.getInteractionStateService().getInteractionActivityExpandState();     // Catch: Exception -> L7
        FLogger.a.i("ObricUpdateComponent", "checkActivityExpandState hostId=" + this.this$0.w + " expandState=" + r9);     // Catch: Exception -> L7
        int r10 = a.a[r9.ordinal()];     // Catch: Exception -> L7
        if (r10 != 1) goto L18;
        this.this$0.B3();     // Catch: Exception -> L7
    L24:
        this.this$0.u = null;
        return Unit.INSTANCE;
    L18:
        if (r10 != 2) goto L24;
        this.this$0.C3();     // Catch: Exception -> L7
        goto L24
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r8);
        this.label = 1;     // Catch: Exception -> L7
        if (DelayKt.delay(1000, this) != r1) goto L15;
        return r1;
    L7:
        e = move-exception;
        FLogger.a.e("ObricUpdateComponent", "Error in fullScreenCheckJob: " + e);
        goto L24
    }
}
