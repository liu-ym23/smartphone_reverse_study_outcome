package com.larus.share.impl.sdk;

import android.content.Context;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/share/panel/FlowShareContent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.sdk.SharePanelService$shareImage$1$finalShareContent$1", f = "SharePanelService.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
public final class SharePanelService$shareImage$1$finalShareContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.bmhome.share.panel.b>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $shareChannel;
    final /* synthetic */ com.larus.bmhome.share.panel.b $shareContent;
    int label;
    final /* synthetic */ SharePanelService this$0;

    public SharePanelService$shareImage$1$finalShareContent$1(SharePanelService r1, Context r2, String r3, com.larus.bmhome.share.panel.b r4, Continuation<? super SharePanelService$shareImage$1$finalShareContent$1> r5) {
        this.this$0 = r1;
        this.$context = r2;
        this.$shareChannel = r3;
        this.$shareContent = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SharePanelService$shareImage$1$finalShareContent$1(this.this$0, this.$context, this.$shareChannel, this.$shareContent, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.bmhome.share.panel.b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        SharePanelService r7 = this.this$0;
        Context r2 = this.$context;
        String r3 = this.$shareChannel;
        com.larus.bmhome.share.panel.b r4 = this.$shareContent;
        this.label = 1;
        r6 = SharePanelService.f(r7, r2, r3, r4, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
