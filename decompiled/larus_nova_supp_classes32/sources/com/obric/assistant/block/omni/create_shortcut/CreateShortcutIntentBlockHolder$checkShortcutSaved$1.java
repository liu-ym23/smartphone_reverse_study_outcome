package com.obric.assistant.block.omni.create_shortcut;

import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.aiagent.assistant.idl.IAgentTaskAppIDL;
import com.obric.aiagent.assistant.idl.s;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.block.omni.create_shortcut.CreateShortcutIntentBlockHolder$checkShortcutSaved$1", f = "CreateShortcutIntentBlockHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreateShortcutIntentBlockHolder$checkShortcutSaved$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $messageId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreateShortcutIntentBlockHolder this$0;

    public CreateShortcutIntentBlockHolder$checkShortcutSaved$1(String r1, CreateShortcutIntentBlockHolder r2, Continuation<? super CreateShortcutIntentBlockHolder$checkShortcutSaved$1> r3) {
        this.$messageId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CreateShortcutIntentBlockHolder$checkShortcutSaved$1 r0 = new CreateShortcutIntentBlockHolder$checkShortcutSaved$1(this.$messageId, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r4);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        String r6 = this.$messageId;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        IAgentTaskAppIDL r1 = s.a(Reflection.getOrCreateKotlinClass(IAgentTaskAppIDL.class));     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        boolean r7 = r1.hasShortcutForMessage(r6);     // Catch: Throwable -> L11
    L9:
        Object r8 = Result.constructor-impl(Boxing.boxBoolean(r7));     // Catch: Throwable -> L11
    L13:
        final String r2 = this.$messageId;
        final CreateShortcutIntentBlockHolder r3 = this.this$0;
        if (Result.isSuccess-impl(r8) == true) goto L16;
    L18:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L22;
        FLogger.a.w("CreateShortcutBlockHolder", "checkShortcutSaved failed. " + r9.getMessage(), r9);
    L22:
        return Unit.INSTANCE;
    L16:
        if (((Boolean) r8).booleanValue() == false) goto L18;
        t0.e(new d(r2, r3));
        goto L18
    L8:
        r7 = false;
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
