package com.larus.dora.impl.dynamic.quicknote;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.network.z;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo$resetNetworkConfig$1", f = "QuickNoteRepo.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {})
public final class QuickNoteRepo$resetNetworkConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public QuickNoteRepo$resetNetworkConfig$1(Continuation<? super QuickNoteRepo$resetNetworkConfig$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new QuickNoteRepo$resetNetworkConfig$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
        Object r7 = ((Result) r6).unbox-impl();
    L15:
        g49.d.a("QuickNoteRepo", "resetNetworkConfig resetNetworkConfig result: " + Result.toString-impl(r7));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        DoraDevice r8 = DoraAdapterExtKt.h(kj4.a.g());
        if (r8 != null) goto L12;
        g49.d.b("QuickNoteRepo", "syncQuickNoteConfig device is null");
        return Unit.INSTANCE;
    L12:
        z r2 = new z("", "", "", "");
        QuickNoteRepo.a.getClass();
        QuickNoteRepo.n(r8, r2);
        DoraNetworkApi r4 = DoraNetworkApi.a;
        this.label = 1;
        r7 = r4.B(r8, r2, this);
        if (r7 != r0) goto L15;
        return r0;
    }
}
