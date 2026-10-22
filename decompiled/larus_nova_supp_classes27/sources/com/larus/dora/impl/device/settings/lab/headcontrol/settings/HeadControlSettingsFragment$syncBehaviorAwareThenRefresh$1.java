package com.larus.dora.impl.device.settings.lab.headcontrol.settings;

import android.content.Context;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.headcontrol.settings.HeadControlSettingsFragment$syncBehaviorAwareThenRefresh$1", f = "HeadControlSettingsFragment.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
final class HeadControlSettingsFragment$syncBehaviorAwareThenRefresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HeadControlSettingsFragment this$0;

    public HeadControlSettingsFragment$syncBehaviorAwareThenRefresh$1(HeadControlSettingsFragment r1, Continuation<? super HeadControlSettingsFragment$syncBehaviorAwareThenRefresh$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new HeadControlSettingsFragment$syncBehaviorAwareThenRefresh$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L7
    L16:
        if (((Boolean) r5).booleanValue() == true) goto L20;
        Context r6 = this.this$0.getContext();     // Catch: Throwable -> L7
        if (r6 == null) goto L20;
        s.a.g(r6, 2131903992, false);     // Catch: Throwable -> L7
    L20:
        this.this$0.h = false;
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r5);
        HeadControlSettingsFragment r7 = this.this$0;     // Catch: Throwable -> L7
        int r2 = HeadControlSettingsFragment.i;     // Catch: Throwable -> L7
        HeadControlSettingsViewModel r8 = r7.W90();     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r5 = r8.syncBehaviorAwareEnable(true, this);     // Catch: Throwable -> L7
        if (r5 != r0) goto L16;
        return r0;
    L7:
        th = move-exception;
        this.this$0.h = false;
        throw th;
    }
}
