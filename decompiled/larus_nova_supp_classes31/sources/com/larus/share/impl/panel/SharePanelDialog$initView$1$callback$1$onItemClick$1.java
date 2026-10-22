package com.larus.share.impl.panel;

import com.larus.home.impl.sdk.k1;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.panel.SharePanelDialog$initView$1$callback$1$onItemClick$1", f = "SharePanelDialog.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
public final class SharePanelDialog$initView$1$callback$1$onItemClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SharePanelDialog this$0;

    public SharePanelDialog$initView$1$callback$1$onItemClick$1(SharePanelDialog r1, Continuation<? super SharePanelDialog$initView$1$callback$1$onItemClick$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SharePanelDialog$initView$1$callback$1$onItemClick$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r8 == null) goto L21;
        r8.w();
        k1 r9 = k1.a;
        SharePanelDialog r2 = this.this$0;
        com.larus.bmhome.share.panel.h r3 = r2.i;
        String r4 = null;
        if (r3 == null) goto L13;
        String r5 = r3.S;
    L14:
        String r6 = r2.U90();
        com.larus.bmhome.share.panel.h r10 = this.this$0.i;
        if (r10 == null) goto L17;
        r4 = r10.h;
    L17:
        this.label = 1;
        if (r9.h1(r5, r6, r4, this) != r0) goto L21;
        return r0;
    L13:
        r5 = null;
        goto L14
    }
}
