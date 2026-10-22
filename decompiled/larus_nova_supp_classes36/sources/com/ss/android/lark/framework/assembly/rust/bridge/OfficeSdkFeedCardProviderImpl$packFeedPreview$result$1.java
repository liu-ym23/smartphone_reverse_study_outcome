package com.ss.android.lark.framework.assembly.rust.bridge;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.framework.assembly.rust.bridge.OfficeSdkFeedCardProviderImpl$packFeedPreview$result$1", f = "OfficeSdkFeedCardProviderImpl.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeSdkFeedCardProviderImpl$packFeedPreview$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ byte[] $payload;
    int label;
    final /* synthetic */ OfficeSdkFeedCardProviderImpl this$0;

    public OfficeSdkFeedCardProviderImpl$packFeedPreview$result$1(OfficeSdkFeedCardProviderImpl r1, byte[] r2, Continuation<? super OfficeSdkFeedCardProviderImpl$packFeedPreview$result$1> r3) {
        this.this$0 = r1;
        this.$payload = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OfficeSdkFeedCardProviderImpl$packFeedPreview$result$1(this.this$0, this.$payload, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super byte[]> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L16:
        return (byte[]) r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        OfficeSdkFeedCardProviderImpl r5 = this.this$0;
        int r2 = OfficeSdkFeedCardProviderImpl.b;
        qtb.b r6 = r5.b();
        if (r6 == null) goto L14;
        byte[] r3 = this.$payload;
        this.label = 1;
        r4 = r6.g0(r3, this);
        if (r4 != r0) goto L16;
        return r0;
    L14:
        return null;
    }
}
