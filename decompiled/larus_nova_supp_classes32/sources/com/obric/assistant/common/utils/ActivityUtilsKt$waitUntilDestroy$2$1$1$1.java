package com.obric.assistant.common.utils;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.common.utils.ActivityUtilsKt$waitUntilDestroy$2$1$1$1", f = "ActivityUtils.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
public final class ActivityUtilsKt$waitUntilDestroy$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ComponentActivity $activity;
    final /* synthetic */ Map<ComponentActivity, DefaultLifecycleObserver> $observers;
    Object L$0;
    Object L$1;
    int label;

    public ActivityUtilsKt$waitUntilDestroy$2$1$1$1(ComponentActivity r1, Map<ComponentActivity, DefaultLifecycleObserver> r2, Continuation<? super ActivityUtilsKt$waitUntilDestroy$2$1$1$1> r3) {
        this.$activity = r1;
        this.$observers = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ActivityUtilsKt$waitUntilDestroy$2$1$1$1(this.$activity, this.$observers, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Map r2 = (Map) this.L$1;
        ComponentActivity r3 = (ComponentActivity) this.L$0;
        ResultKt.throwOnFailure(r8);
    L24:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        FLogger.a.i("ActivityUtils", "waitUntilDestroy activity " + this.$activity);
        final ComponentActivity r9 = this.$activity;
        Map<ComponentActivity, DefaultLifecycleObserver> r4 = this.$observers;
        this.L$0 = r9;
        this.L$1 = r4;
        this.label = 1;
        final kotlinx.coroutines.j r5 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r5.C();
        if (r9.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L25;
        Lifecycle r6 = r9.getLifecycle();
        DefaultLifecycleObserver r7 = new ActivityUtilsKt$waitUntilDestroy$2$1$1$1$1$1(r9, r5);
        r4.put(r9, r7);
        r6.addObserver(r7);
    L19:
        r8 = r5.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(this);
    L22:
        if (r8 != r0) goto L24;
        return r0;
    L25:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L13
        r5.resumeWith(Result.constructor-impl(Boxing.boxBoolean(true)));     // Catch: Throwable -> L13
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L18;
        FLogger.a.w("ActivityUtils", "waitUntilDestroy resume failed", r12);
    L18:
        Result.box-impl(r11);
    L13:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }
}
