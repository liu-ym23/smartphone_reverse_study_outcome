package com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate;

import android.content.Context;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher$asyncGetResource$1", f = "ChameleonDefaultResFetcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChameleonDefaultResFetcher$asyncGetResource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChameleonConfig $chameleonConfig;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $session;
    int label;
    final /* synthetic */ ChameleonDefaultResFetcher this$0;

    public ChameleonDefaultResFetcher$asyncGetResource$1(ChameleonDefaultResFetcher r1, ChameleonConfig r2, Context r3, String r4, Continuation<? super ChameleonDefaultResFetcher$asyncGetResource$1> r5) {
        this.this$0 = r1;
        this.$chameleonConfig = r2;
        this.$context = r3;
        this.$session = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChameleonDefaultResFetcher$asyncGetResource$1(this.this$0, this.$chameleonConfig, this.$context, this.$session, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        ChameleonDefaultResFetcher r6 = this.this$0;
        ChameleonConfig r0 = this.$chameleonConfig;
        Context r1 = this.$context;
        String r2 = this.$session;
        int r3 = ChameleonDefaultResFetcher.b;
        r6.b(r0, r1, r2);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
