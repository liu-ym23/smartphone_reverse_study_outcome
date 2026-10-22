package com.larus.bmhome.view.actionbar.gaokao;

import com.larus.bmhome.view.actionbar.gaokao.network.GaokaoApi;
import com.larus.bmhome.view.actionbar.gaokao.network.GaokaoProvinceZhiyuanResponse;
import com.larus.bmhome.view.actionbar.gaokao.network.GaokaoZhiyuanRequest;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceZhiyuanResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.gaokao.GaokaoRankCalculator$calculateRank$result$1", f = "GaokaoRankCalculator.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
public final class GaokaoRankCalculator$calculateRank$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super dm9.a<? extends GaokaoProvinceZhiyuanResponse>>, Object> {
    final /* synthetic */ String $province;
    final /* synthetic */ String $score;
    final /* synthetic */ String $subject;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.gaokao.GaokaoRankCalculator$calculateRank$result$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceZhiyuanResponse;", "Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.gaokao.GaokaoRankCalculator$calculateRank$result$1$1", f = "GaokaoRankCalculator.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<GaokaoApi, Continuation<? super BizResponse<GaokaoProvinceZhiyuanResponse>>, Object> {
        final /* synthetic */ String $province;
        final /* synthetic */ String $score;
        final /* synthetic */ String $subject;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(String r1, String r2, String r3, Continuation<? super AnonymousClass1> r4) {
            this.$score = r1;
            this.$province = r2;
            this.$subject = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$score, this.$province, this.$subject, r6);
            r0.L$0 = r5;
            return r0;
        }

        public final Object invoke(GaokaoApi r1, Continuation<? super BizResponse<GaokaoProvinceZhiyuanResponse>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((GaokaoApi) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            GaokaoApi r8 = (GaokaoApi) this.L$0;
            GaokaoZhiyuanRequest r2 = new GaokaoZhiyuanRequest(this.$score, this.$province, this.$subject);
            this.label = 1;
            r7 = r8.getGaokaoZhiyuan(r2, this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    public GaokaoRankCalculator$calculateRank$result$1(String r1, String r2, String r3, Continuation<? super GaokaoRankCalculator$calculateRank$result$1> r4) {
        this.$score = r1;
        this.$province = r2;
        this.$subject = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GaokaoRankCalculator$calculateRank$result$1(this.$score, this.$province, this.$subject, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super dm9.a<GaokaoProvinceZhiyuanResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        GaokaoApi.a r9 = GaokaoApi.a;
        AnonymousClass1 r2 = new AnonymousClass1(this.$score, this.$province, this.$subject, null);
        this.label = 1;
        r9.getClass();
        r8 = GaokaoApi.a.a(r2, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
