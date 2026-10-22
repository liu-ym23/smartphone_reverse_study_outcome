package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.remote.repo.ConfigFileProviderMode;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.processor.RemoteConfigProcessor$InternalHandler$handleMessage$1", f = "RemoteConfigProcessor.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteConfigProcessor$InternalHandler$handleMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public RemoteConfigProcessor$InternalHandler$handleMessage$1(Continuation r10) {
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r10) {
        return new RemoteConfigProcessor$InternalHandler$handleMessage$1(r10);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r11 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L17:
        j6.b r12 = (j6.b) r10;
        CoroutineScope r13 = RemoteConfigProcessor.a;
        if (r12 == null) goto L22;
        Boolean r14 = Boxing.boxBoolean(r12.b);
        if (r14 == null) goto L22;
        boolean r15 = r14.booleanValue();
    L23:
        RemoteConfigProcessor.e = r15;
        if (r12 != null) goto L26;
    L28:
        r11 = false;
    L29:
        RemoteConfigProcessor.a(r11);
        return Unit.INSTANCE;
    L26:
        if (r12.b != true) goto L28;
    L22:
        r15 = false;
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        com.bytedance.android.accessibilityLib_Core.config.remote.step.b r16 = RemoteConfigProcessor.b;
        if (r16 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadStep");
    L11:
        Boolean r17 = Boxing.boxBoolean(true);
        this.label = 1;
        r16.getClass();
        Context r18 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        j6.a r19 = r16.a;
        if (r17 == null) goto L14;
        r17.booleanValue();
    L14:
        ConfigFileProviderMode r20 = ConfigFileProviderMode.LOCAL;
        r10 = r19.a();
        if (r10 != r0) goto L17;
        return r0;
    }
}
