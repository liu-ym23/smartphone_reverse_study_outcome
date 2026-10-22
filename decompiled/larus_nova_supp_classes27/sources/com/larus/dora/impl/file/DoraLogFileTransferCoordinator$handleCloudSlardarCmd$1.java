package com.larus.dora.impl.file;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.util.b0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraLogFileTransferCoordinator$handleCloudSlardarCmd$1", f = "DoraLogFileTransferCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraLogFileTransferCoordinator$handleCloudSlardarCmd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Integer> $typeList;
    int label;

    public DoraLogFileTransferCoordinator$handleCloudSlardarCmd$1(List<Integer> r1, Continuation<? super DoraLogFileTransferCoordinator$handleCloudSlardarCmd$1> r2) {
        this.$typeList = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraLogFileTransferCoordinator$handleCloudSlardarCmd$1(this.$typeList, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r4);
        DoraDevice r5 = DoraAdapterExtKt.h(kj4.a.g());
        StringBuilder r0 = new StringBuilder("handleCloudSlardarCmd: device=");
        if (r5 == null) goto L7;
        String r1 = r5.sn;
    L8:
        r0.append(r1);
        r0.append(", typeList=");
        r0.append(this.$typeList);
        g49.d.d("DoraLogFileTransferCoordinator", r0.toString());
        if (r5 == null) goto L18;
        DoraLogFileTransferCoordinator r2 = DoraLogFileTransferCoordinator.a;
        String r3 = r5.sn;
        String r6 = "";
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        String r7 = r5.softVersion;
        if (r7 == null) goto L17;
        r6 = r7;
    L17:
        DoraLogFileTransferCoordinator.d(r3, r6, CollectionsKt.toIntArray(this.$typeList), "slardarCMD");
    L23:
        return Unit.INSTANCE;
    L18:
        b0.a.getClass();
        List r8 = b0.d();
        if (r8 != null) goto L21;
        r8 = CollectionsKt.emptyList();
    L21:
        b0.I(CollectionsKt.distinct(CollectionsKt.plus(r8, this.$typeList)));
        goto L23
    L7:
        r1 = null;
        goto L8
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
