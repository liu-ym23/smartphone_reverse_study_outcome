package com.larus.bmhome.chat.camera.command;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.camera.command.SuggestedActionCache$put$1", f = "SuggestedActionCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SuggestedActionCache$put$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ SuggestedActionData $data;
    int label;

    public SuggestedActionCache$put$1(SuggestedActionData r1, String r2, Continuation<? super SuggestedActionCache$put$1> r3) {
        this.$data = r1;
        this.$botId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SuggestedActionCache$put$1(this.$data, this.$botId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r4);
        SuggestedActionData r5 = this.$data;
        if (r5 != null) goto L8;
        FLogger.a.i("SuggestedActionCache", "store data is null");
        return Unit.INSTANCE;
    L8:
        bc8.e r0 = bc8.e.a;
        String r1 = this.$botId;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "botId");
        if (r1.length() != 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L15;
        ((Keva) bc8.e.b.getValue()).storeString(bc8.e.a(r0, r1), GsonProtectorUtils.toJson((Gson) bc8.e.c.getValue(), r5));
    L15:
        return Unit.INSTANCE;
    L11:
        r2 = false;
        goto L12
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
