package com.obric.aikernel.res.task;

import android.content.IntentFilter;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.task.StorageCleanerDaemon$init$1", f = "StorageCleanerDaemon.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
final class StorageCleanerDaemon$init$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StorageCleanerDaemon this$0;

    StorageCleanerDaemon$init$1(StorageCleanerDaemon r10, Continuation<? super StorageCleanerDaemon$init$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new StorageCleanerDaemon$init$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((StorageCleanerDaemon$init$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        StorageCleanerDaemon.a(this.this$0).getConfig().getContext().registerReceiver(StorageCleanerDaemon.b(this.this$0), new IntentFilter("android.intent.action.SCREEN_OFF"));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Duration.Companion r13 = Duration.Companion;
        long r14 = Duration.m1430toLongimpl(DurationKt.toDuration(10, DurationUnit.MINUTES), DurationUnit.MILLISECONDS);
        this.label = 1;
        if (DelayKt.b(r14, this) != r11) goto L11;
        return r11;
    }
}
