package com.larus.dora.impl.device.manage.viewmodel;

import a49.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/larus/dora/api/entity/LatestCardContentResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$refreshLatestCardContent$1$legacyDeferred$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {630}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGDeviceManagementViewModel$refreshLatestCardContent$1$legacyDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends h>>, Object> {
    final /* synthetic */ boolean $diaryBetaEnabled;
    int label;
    final /* synthetic */ DoraGDeviceManagementViewModel this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$refreshLatestCardContent$1$legacyDeferred$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/larus/dora/api/entity/LatestCardContentResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$refreshLatestCardContent$1$legacyDeferred$1$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {630}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends h>>, Object> {
        final /* synthetic */ boolean $diaryBetaEnabled;
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public AnonymousClass1(DoraGDeviceManagementViewModel r1, boolean r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$diaryBetaEnabled = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$diaryBetaEnabled, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Result<h>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
            Object r5 = ((Result) r4).unbox-impl();
        L12:
            return Result.box-impl(r5);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            DoraGDeviceManagementViewModel r6 = this.this$0;
            boolean r2 = this.$diaryBetaEnabled;
            this.label = 1;
            r5 = DoraGDeviceManagementViewModel.m65access$fetchLatestCardContentInternalgIAlus(r6, r2, this);
            if (r5 != r0) goto L12;
            return r0;
        }
    }

    public DoraGDeviceManagementViewModel$refreshLatestCardContent$1$legacyDeferred$1(DoraGDeviceManagementViewModel r1, boolean r2, Continuation<? super DoraGDeviceManagementViewModel$refreshLatestCardContent$1$legacyDeferred$1> r3) {
        this.this$0 = r1;
        this.$diaryBetaEnabled = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraGDeviceManagementViewModel$refreshLatestCardContent$1$legacyDeferred$1(this.this$0, this.$diaryBetaEnabled, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<h>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: TimeoutCancellationException -> L15
    L13:
        return (Result) r6;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        AnonymousClass1 r7 = new AnonymousClass1(this.this$0, this.$diaryBetaEnabled, null);     // Catch: TimeoutCancellationException -> L15
        this.label = 1;     // Catch: TimeoutCancellationException -> L15
        r6 = TimeoutKt.b(8000, r7, this);     // Catch: TimeoutCancellationException -> L15
        if (r6 != r0) goto L13;
        return r0;
    L15:
        g49.d.e(DoraGDeviceManagementViewModel.TAG, "refreshLatestCardContent: timeout after 8s");
        return null;
    }
}
