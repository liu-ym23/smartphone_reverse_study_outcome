package com.larus.dora.impl.dynamic;

import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraDeviceFoundListFragment$setupPage$1$1$navBarTitle$1", f = "DoraDeviceFoundListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDeviceFoundListFragment$setupPage$1$1$navBarTitle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ c59.l $pageInfo;
    int label;

    public DoraDeviceFoundListFragment$setupPage$1$1$navBarTitle$1(c59.l r1, Continuation<? super DoraDeviceFoundListFragment$setupPage$1$1$navBarTitle$1> r2) {
        this.$pageInfo = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraDeviceFoundListFragment$setupPage$1$1$navBarTitle$1(this.$pageInfo, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r2);
        c59.v r3 = this.$pageInfo.a;
        if (r3 == null) goto L17;
        Map<String, Object> r4 = r3.a;
        if (r4 == null) goto L17;
        Lazy r0 = c59.s.a;
        c59.x r5 = (c59.x) c59.s.c(r4, c59.x.class);
        if (r5 == null) goto L15;
        c59.w r6 = r5.a();
        if (r6 == null) goto L15;
        c59.t r7 = r6.a();
        if (r7 == null) goto L15;
        String r8 = c59.p.b(r7);
    L16:
        if (r8 == null) goto L17;
        return r8;
    L15:
        r8 = null;
    L17:
        return "";
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
