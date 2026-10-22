package com.larus.voicecall.impl.component.core;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.core.RealtimeCoreComponent$checkArgumentParam$1", f = "RealtimeCoreComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCoreComponent$checkArgumentParam$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCoreComponent this$0;

    public static final class a implements IIMCallback<BotModel> {
        public final /* synthetic */ RealtimeCoreComponent a;

        public final boolean mustInMain() {
            return true;
        }

        public a(RealtimeCoreComponent r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("RealtimeCoreComponent", "get bot failed, error: " + r4);
        }

        public final void onSuccess(Object r3) {
            BotModel r4 = (BotModel) r3;
            Intrinsics.checkNotNullParameter(r4, "result");
            RealtimeCoreComponent r0 = this.a;
            int r1 = RealtimeCoreComponent.P;
            r0.E3().H0 = r4;
        }
    }

    public RealtimeCoreComponent$checkArgumentParam$1(RealtimeCoreComponent r1, Continuation<? super RealtimeCoreComponent$checkArgumentParam$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCoreComponent$checkArgumentParam$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r7);
        RealtimeCoreComponent r8 = this.this$0;
        int r0 = RealtimeCoreComponent.P;
        String r1 = ((h88.a) r8.E3()).d;
        if (this.this$0.E3().H0 != null) goto L10;
        if ((!StringsKt.isBlank(r1)) == false) goto L10;
        com.larus.im.service.o.a.a(com.larus.im.d.a(), r1, false, "RealtimeCoreComponent", new a(this.this$0), 8);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
