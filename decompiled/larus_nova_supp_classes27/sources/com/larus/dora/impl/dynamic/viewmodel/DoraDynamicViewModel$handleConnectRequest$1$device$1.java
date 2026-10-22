package com.larus.dora.impl.dynamic.viewmodel;

import com.bytedance.dora.device.DoraDevice;
import java.util.Iterator;
import java.util.List;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/dora/device/DoraDevice;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$handleConnectRequest$1$device$1", f = "DoraDynamicViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDynamicViewModel$handleConnectRequest$1$device$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DoraDevice>, Object> {
    final /* synthetic */ String $mac;
    int label;

    public DoraDynamicViewModel$handleConnectRequest$1$device$1(String r1, Continuation<? super DoraDynamicViewModel$handleConnectRequest$1$device$1> r2) {
        this.$mac = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraDynamicViewModel$handleConnectRequest$1$device$1(this.$mac, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super DoraDevice> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r5);
        List r6 = kj4.a.g().getDoraBindList();
        Object r0 = null;
        if (r6 == null) goto L19;
        String r1 = this.$mac;
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L13;
        Object r2 = r7.next();
        if (Intrinsics.areEqual(((DoraDevice) r2).mac, r1) == false) goto L8;
        r0 = r2;
    L13:
        return (DoraDevice) r0;
    L19:
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
