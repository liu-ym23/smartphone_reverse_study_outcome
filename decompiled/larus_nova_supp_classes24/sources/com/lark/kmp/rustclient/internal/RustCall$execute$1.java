package com.lark.kmp.rustclient.internal;

import com.bytedance.lark.sdk.InvokeResponse;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0003`\u0004\"\u0004\b\u0000\u0010\u0003*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/lark/kmp/rustclient/api/model/RustOutput;", "Lcom/bytedance/lark/sdk/InvokeResponse;", "Resp", "Lcom/lark/kmp/rustclient/api/RustResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.RustCall$execute$1", f = "RustCall.kt", i = {0}, l = {31}, m = "invokeSuspend", n = {"chain"}, s = {"L$0"})
final class RustCall$execute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.lark.kmp.rustclient.api.model.g<InvokeResponse, Object>>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ w<Object> this$0;

    public RustCall$execute$1(w<Object> r1, Continuation<? super RustCall$execute$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RustCall$execute$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.lark.kmp.rustclient.api.model.g<InvokeResponse, Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        com.lark.kmp.rustclient.api.h r2 = (com.lark.kmp.rustclient.api.h) this.L$0;
        ResultKt.throwOnFailure(r6);
    L12:
        com.lark.kmp.rustclient.api.model.g r3 = (com.lark.kmp.rustclient.api.model.g) r6;
        com.lark.kmp.rustclient.api.model.c<Resp> r4 = r2.c.a;
        StringBuilder r5 = new StringBuilder("sync invoke return response: ");
        com.lark.kmp.rustclient.api.model.f r7 = com.lark.kmp.rustclient.api.model.i.a;
        Intrinsics.checkNotNullParameter(r3, "response");
        if ((r3 instanceof com.lark.kmp.rustclient.api.model.k) == false) goto L16;
        String r8 = "succeed";
    L18:
        r5.append(r8);
        r5.append('.');
        com.lark.kmp.rustclient.a.a(r4, r5.toString());
        return r6;
    L16:
        if ((r3 instanceof com.lark.kmp.rustclient.api.model.b) == false) goto L21;
        r8 = "error";
        goto L18
    L21:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        w<Object> r9 = this.this$0;
        r9.getClass();
        com.lark.kmp.rustclient.api.h r10 = new com.lark.kmp.rustclient.api.h(r9.a, 0, r9.b);
        com.lark.kmp.rustclient.a.a(r10.c.a, "start to sync invoke.");
        com.lark.kmp.rustclient.api.a<Object> r11 = this.this$0.b;
        this.L$0 = r10;
        this.label = 1;
        r6 = r10.a(r11, this);
        if (r6 != r0) goto L11;
        return r0;
    L11:
        r2 = r10;
        goto L12
    }
}
