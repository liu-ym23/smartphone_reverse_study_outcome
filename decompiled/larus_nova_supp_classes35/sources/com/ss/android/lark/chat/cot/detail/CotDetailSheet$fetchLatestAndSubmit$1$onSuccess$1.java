package com.ss.android.lark.chat.cot.detail;

import com.ss.android.lark.chat.cot.CotViewModel;
import com.ss.android.lark.chat.entity.message.CotContent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.cot.detail.CotDetailSheet$fetchLatestAndSubmit$1$onSuccess$1", f = "CotDetailSheet.kt", i = {}, l = {282}, m = "invokeSuspend", n = {}, s = {})
public final class CotDetailSheet$fetchLatestAndSubmit$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CotContent $cot;
    int label;
    final /* synthetic */ CotDetailSheet this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.cot.detail.CotDetailSheet$fetchLatestAndSubmit$1$onSuccess$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/ss/android/lark/chat/cot/CotViewModel;", "Lcom/ss/android/lark/chat/cot/detail/CotDetailUiState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.cot.detail.CotDetailSheet$fetchLatestAndSubmit$1$onSuccess$1$1", f = "CotDetailSheet.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends CotViewModel, ? extends q>>, Object> {
        final /* synthetic */ CotContent $cot;
        int label;
        final /* synthetic */ CotDetailSheet this$0;

        public AnonymousClass1(CotContent r1, CotDetailSheet r2, Continuation<? super AnonymousClass1> r3) {
            this.$cot = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$cot, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Pair<CotViewModel, q>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            int r3 = com.ss.android.lark.chat.cot.g.a;
            CotViewModel r4 = com.ss.android.lark.chat.cot.g.a(this.$cot);
            return TuplesKt.to(r4, this.this$0.h.a(r4));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CotDetailSheet$fetchLatestAndSubmit$1$onSuccess$1(CotDetailSheet r1, CotContent r2, Continuation<? super CotDetailSheet$fetchLatestAndSubmit$1$onSuccess$1> r3) {
        this.this$0 = r1;
        this.$cot = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CotDetailSheet$fetchLatestAndSubmit$1$onSuccess$1(this.this$0, this.$cot, r4);
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
    L11:
        Pair r8 = (Pair) r7;
        CotViewModel r2 = (CotViewModel) r8.component1();
        q r9 = (q) r8.component2();
        CotDetailSheet r3 = this.this$0;
        if (r3.t == true) goto L19;
        if (Intrinsics.areEqual(r9, r3.s) == true) goto L19;
        CotDetailSheet r4 = this.this$0;
        r4.s = r9;
        r4.p = r4.c(r2);
        com.ss.android.lark.chat.cot.f.c("detail_fetch", "fetch latest submit, messageId=" + this.this$0.c + ", cotId=" + r2.getCotId() + ", status=" + r2.getOverallStatus());
        r r5 = this.this$0.h;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r9, "state");
        r5.b.setValue(r9);
        return Unit.INSTANCE;
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r10 = Dispatchers.getDefault();
        AnonymousClass1 r6 = new AnonymousClass1(this.$cot, this.this$0, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r10, r6, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
