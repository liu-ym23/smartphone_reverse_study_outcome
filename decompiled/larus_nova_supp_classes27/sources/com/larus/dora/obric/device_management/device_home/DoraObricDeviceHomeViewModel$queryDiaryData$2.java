package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$queryDiaryData$2", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {676}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricDeviceHomeViewModel$queryDiaryData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean>>, Object> {
    final /* synthetic */ boolean $forceRefresh;
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$queryDiaryData$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$queryDiaryData$2$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {677}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean>>, Object> {
        final /* synthetic */ boolean $forceRefresh;
        final /* synthetic */ String $userId;
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public AnonymousClass1(DoraObricDeviceHomeViewModel r1, String r2, boolean r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$userId = r2;
            this.$forceRefresh = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$userId, this.$forceRefresh, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Result<Boolean>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
            Object r6 = ((Result) r5).unbox-impl();
        L12:
            return Result.box-impl(r6);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            DoraObricDeviceHomeUsageRepository r7 = DoraObricDeviceHomeViewModel.access$getUsageRepository$p(this.this$0);
            String r2 = this.$userId;
            boolean r3 = this.$forceRefresh;
            this.label = 1;
            r6 = r7.c(r2, r3, this);
            if (r6 != r0) goto L12;
            return r0;
        }
    }

    public DoraObricDeviceHomeViewModel$queryDiaryData$2(DoraObricDeviceHomeViewModel r1, String r2, boolean r3, Continuation<? super DoraObricDeviceHomeViewModel$queryDiaryData$2> r4) {
        this.this$0 = r1;
        this.$userId = r2;
        this.$forceRefresh = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraObricDeviceHomeViewModel$queryDiaryData$2(this.this$0, this.$userId, this.$forceRefresh, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<Boolean>> r2) {
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
        CoroutineDispatcher r9 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$userId, this.$forceRefresh, null);
        this.label = 1;
        r8 = BuildersKt.withContext(r9, r2, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
