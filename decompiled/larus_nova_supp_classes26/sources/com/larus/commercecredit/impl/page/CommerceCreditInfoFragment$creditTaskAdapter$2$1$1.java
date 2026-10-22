package com.larus.commercecredit.impl.page;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.commercecredit.api.CreditInfoScene;
import com.larus.commercecredit.impl.utils.CommerceCreditConfigManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.page.CommerceCreditInfoFragment$creditTaskAdapter$2$1$1", f = "CommerceCreditInfoFragment.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
public final class CommerceCreditInfoFragment$creditTaskAdapter$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommerceCreditInfoFragment this$0;

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.page.CommerceCreditInfoFragment$creditTaskAdapter$2$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "activityInfo", "Lcom/larus/commercecredit/impl/entity/UserActivityInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.page.CommerceCreditInfoFragment$creditTaskAdapter$2$1$1$1", f = "CommerceCreditInfoFragment.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<qz8.q, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CommerceCreditInfoFragment this$0;

        /* JADX INFO: renamed from: com.larus.commercecredit.impl.page.CommerceCreditInfoFragment$creditTaskAdapter$2$1$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.commercecredit.impl.page.CommerceCreditInfoFragment$creditTaskAdapter$2$1$1$1$1", f = "CommerceCreditInfoFragment.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ CommerceCreditInfoFragment this$0;

            public C01021(CommerceCreditInfoFragment r1, Continuation<? super C01021> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C01021(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r12) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r12);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r12);
                CommerceCreditConfigManager r13 = CommerceCreditConfigManager.a;
                CreditInfoScene r3 = CreditInfoScene.COMMERCE_CREDIT_INFO_PANEL_CLICK_MOBILE_ACTIVITY;
                int r14 = com.larus.commercecredit.impl.utils.k.a;
                String r6 = com.larus.commercecredit.impl.utils.k.a(this.this$0.getArguments(), "previous_page");
                String r7 = com.larus.commercecredit.impl.utils.k.a(this.this$0.getArguments(), "enter_method");
                final CommerceCreditInfoFragment r15 = this.this$0;
                Function3 r8 = new o(r15);
                this.label = 1;
                if (CommerceCreditConfigManager.b(r3, false, false, r6, r7, r8, this, 2) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(CommerceCreditInfoFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((qz8.q) r1, (Continuation) r2);
        }

        public final Object invoke(qz8.q r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            if (((qz8.q) this.L$0) == null) goto L11;
            CoroutineDispatcher r7 = Dispatchers.getIO();
            C01021 r2 = new C01021(this.this$0, null);
            this.label = 1;
            if (BuildersKt.withContext(r7, r2, this) != r0) goto L16;
            return r0;
        L11:
            return Unit.INSTANCE;
        }
    }

    public CommerceCreditInfoFragment$creditTaskAdapter$2$1$1(CommerceCreditInfoFragment r1, Continuation<? super CommerceCreditInfoFragment$creditTaskAdapter$2$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommerceCreditInfoFragment$creditTaskAdapter$2$1$1(this.this$0, r3);
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
        CommerceCreditConfigManager r7 = CommerceCreditConfigManager.a;
        DowngradeSource r8 = DowngradeSource.CLICK_ACTION;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (CommerceCreditConfigManager.j("clickMobileActivityAction", r8, r2, this) != r0) goto L12;
        return r0;
    }
}
