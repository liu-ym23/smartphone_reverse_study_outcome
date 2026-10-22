package com.obric.assistant.card.utils;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.card.utils.AppEntityEx$showEntity$1", f = "AppEntityEx.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
public final class AppEntityEx$showEntity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppEntityEx.a $key;
    private /* synthetic */ Object L$0;
    int label;

    public AppEntityEx$showEntity$1(AppEntityEx.a r1, Continuation<? super AppEntityEx$showEntity$1> r2) {
        this.$key = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AppEntityEx$showEntity$1 r0 = new AppEntityEx$showEntity$1(this.$key, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L32:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        AppEntityEx.a r11 = this.$key;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
        int r4 = AppEntityEx.a;     // Catch: Throwable -> L18
        String r5 = r11.getType() + '&' + r11.b();     // Catch: Throwable -> L18
        String r12 = r11.a();     // Catch: Throwable -> L18
        if (r12 != null) goto L12;
        r12 = NameKeys.UnloadStrategy_No_Strategy;
    L12:
        List r13 = AppEntityEx.a(MapsKt.mapOf(TuplesKt.to(r5, CollectionsKt.listOf(r12))));     // Catch: Throwable -> L18
        if (r13 == null) goto L15;
        AppEntity r14 = (AppEntity) CollectionsKt.firstOrNull(r13);     // Catch: Throwable -> L18
    L16:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L18
    L20:
        Throwable r6 = Result.exceptionOrNull-impl(r15);
        if (r6 == null) goto L24;
        FLogger.a.w("AppEntityEx", "showEntity failed: " + r6.getMessage(), r6);
    L24:
        if (Result.isSuccess-impl(r15) == false) goto L32;
        AppEntity r7 = (AppEntity) r15;
        if (r7 == null) goto L28;
        b.c(r7);
        goto L32
    L28:
        FLogger.a.w("AppEntityEx", "showEntity not found entity");
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        AppEntityEx$showEntity$1$3$1 r16 = new AppEntityEx$showEntity$1$3$1(null);
        this.L$0 = r15;
        this.label = 1;
        if (BuildersKt.withContext(r8, r16, this) != r0) goto L32;
        return r0;
    L15:
        r14 = null;
    L18:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
