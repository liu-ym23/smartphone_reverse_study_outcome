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
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.cot.detail.CotDetailSheet$subscribePush$1", f = "CotDetailSheet.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
final class CotDetailSheet$subscribePush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CotDetailSheet this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.cot.detail.CotDetailSheet$subscribePush$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "cot", "Lcom/ss/android/lark/chat/entity/message/CotContent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.cot.detail.CotDetailSheet$subscribePush$1$1", f = "CotDetailSheet.kt", i = {}, l = {226}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CotContent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CotDetailSheet this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.cot.detail.CotDetailSheet$subscribePush$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/ss/android/lark/chat/cot/CotViewModel;", "Lcom/ss/android/lark/chat/cot/detail/CotDetailUiState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.chat.cot.detail.CotDetailSheet$subscribePush$1$1$1", f = "CotDetailSheet.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends CotViewModel, ? extends q>>, Object> {
            final /* synthetic */ CotContent $cot;
            int label;
            final /* synthetic */ CotDetailSheet this$0;

            public C00881(CotContent r1, CotDetailSheet r2, Continuation<? super C00881> r3) {
                this.$cot = r1;
                this.this$0 = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00881(this.$cot, this.this$0, r4);
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

        public AnonymousClass1(CotDetailSheet r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(CotContent r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CotContent) r1, (Continuation) r2);
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
            if (Intrinsics.areEqual(r9, this.this$0.s) == false) goto L15;
            com.ss.android.lark.chat.cot.f.c("detail_push", "skip unchanged cot state, messageId=" + this.this$0.c + ", cotId=" + r2.getCotId());
            return Unit.INSTANCE;
        L15:
            CotDetailSheet r3 = this.this$0;
            if (r3.t == true) goto L18;
            r3.s = r9;
            r3.p = r3.c(r2);
            com.ss.android.lark.chat.cot.f.c("detail_submit", "submit live refresh, messageId=" + this.this$0.c + ", cotId=" + r2.getCotId() + ", blocks=" + r2.getBlocks().size() + ", status=" + r2.getOverallStatus());
            r r4 = this.this$0.h;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r9, "state");
            r4.b.setValue(r9);
        L20:
            return Unit.INSTANCE;
        L18:
            com.ss.android.lark.chat.cot.f.c("detail_submit", "drop released live refresh, messageId=" + this.this$0.c + ", cotId=" + r2.getCotId() + ", released=" + this.this$0.t);
            goto L20
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            CotContent r10 = (CotContent) this.L$0;
            CoroutineDispatcher r5 = Dispatchers.getDefault();
            C00881 r6 = new C00881(r10, this.this$0, null);
            this.label = 1;
            r7 = BuildersKt.withContext(r5, r6, this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    public CotDetailSheet$subscribePush$1(CotDetailSheet r1, Continuation<? super CotDetailSheet$subscribePush$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CotDetailSheet$subscribePush$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CotDetailSheet r7 = this.this$0;
        MutableSharedFlow<CotContent> r2 = r7.r;
        AnonymousClass1 r3 = new AnonymousClass1(r7, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r2, r3, this) != r0) goto L12;
        return r0;
    }
}
