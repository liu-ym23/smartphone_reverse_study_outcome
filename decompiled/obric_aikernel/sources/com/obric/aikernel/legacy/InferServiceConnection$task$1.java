package com.obric.aikernel.legacy;

import android.content.Intent;
import android.content.ServiceConnection;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
final class InferServiceConnection$task$1 extends Lambda implements Function1<Continuation<? super com.obric.aikernel.a>, Unit> {
    final /* synthetic */ InferServiceConnection this$0;

    InferServiceConnection$task$1(InferServiceConnection r10) {
        this.this$0 = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Continuation<? super com.obric.aikernel.a> r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Continuation<? super com.obric.aikernel.a> r10) {
        Intrinsics.checkNotNullParameter(r10, "cont");
        final InferServiceConnection r11 = this.this$0;
        ServiceConnection r12 = new InferServiceConnection$task$1$conn$1(r10, r11);
        InferServiceConnection.a(this.this$0).bindService(new Intent(InferServiceConnection.a(this.this$0), InferService.class), r12, 1);
        InferServiceConnection.e(this.this$0, r12);
    }
}
