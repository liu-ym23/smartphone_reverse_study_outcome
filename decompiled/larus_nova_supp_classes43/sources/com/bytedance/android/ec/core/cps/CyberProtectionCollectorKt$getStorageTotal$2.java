package com.bytedance.android.ec.core.cps;

import com.facebook.common.statfs.StatFsHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionCollectorKt$getStorageTotal$2", f = "CyberProtectionCollector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CyberProtectionCollectorKt$getStorageTotal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    int label;

    public CyberProtectionCollectorKt$getStorageTotal$2(Continuation r10) {
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "completion");
        return new CyberProtectionCollectorKt$getStorageTotal$2(r10);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r10);
        long r0 = StatFsHelper.getInstance().getTotalStorageSpace(StatFsHelper.StorageType.EXTERNAL);
        long r11 = StatFsHelper.getInstance().getTotalStorageSpace(StatFsHelper.StorageType.INTERNAL);
        if (r0 <= 0) goto L7;
        long r1 = r0 + 0;
    L9:
        if (r11 <= 0) goto L12;
        r1 = r1 + r11;
    L12:
        if (r1 > 0) goto L18;
        return null;
    L18:
        return Boxing.boxLong(r1);
    L7:
        r1 = 0;
        goto L9
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
