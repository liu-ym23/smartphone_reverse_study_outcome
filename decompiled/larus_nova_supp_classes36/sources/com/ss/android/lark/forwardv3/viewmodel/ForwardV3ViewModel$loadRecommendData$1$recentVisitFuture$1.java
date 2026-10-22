package com.ss.android.lark.forwardv3.viewmodel;

import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.data.services.ForwardGetServicesV2;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.ArrayList;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel$loadRecommendData$1$recentVisitFuture$1", f = "ForwardV3ViewModel.kt", i = {}, l = {445}, m = "invokeSuspend", n = {}, s = {})
public final class ForwardV3ViewModel$loadRecommendData$1$recentVisitFuture$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<SearchBaseInfo>>, Object> {
    final /* synthetic */ long $activityStartTime;
    final /* synthetic */ boolean $isLocal;
    int label;
    final /* synthetic */ ForwardV3ViewModel this$0;

    public ForwardV3ViewModel$loadRecommendData$1$recentVisitFuture$1(long r1, ForwardV3ViewModel r3, boolean r4, Continuation<? super ForwardV3ViewModel$loadRecommendData$1$recentVisitFuture$1> r5) {
        this.$activityStartTime = r1;
        this.this$0 = r3;
        this.$isLocal = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ForwardV3ViewModel$loadRecommendData$1$recentVisitFuture$1(this.$activityStartTime, this.this$0, this.$isLocal, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<SearchBaseInfo>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L15
    L13:
        return (List) r6;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        int r7 = ForwardGetServicesV2.a;     // Catch: Throwable -> L15
        long r3 = this.$activityStartTime;     // Catch: Throwable -> L15
        IncludeConfig r8 = ForwardV3ViewModel.access$getTemplateNew$p(this.this$0).getForwardTargetConfig().d;     // Catch: Throwable -> L15
        boolean r2 = this.$isLocal;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r6 = ForwardGetServicesV2.c(r3, r8, r2, this);     // Catch: Throwable -> L15
        if (r6 != r0) goto L13;
        return r0;
    L16:
        return new ArrayList();
    }
}
