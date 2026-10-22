package com.larus.dora.impl.device.manage.viewmodel;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.NetworkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/larus/dora/api/entity/DiaryBetaLatestCardResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$refreshLatestCardContent$1$betaDeferred$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {639}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGDeviceManagementViewModel$refreshLatestCardContent$1$betaDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends a49.c>>, Object> {
    int label;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$refreshLatestCardContent$1$betaDeferred$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/larus/dora/api/entity/DiaryBetaLatestCardResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$refreshLatestCardContent$1$betaDeferred$1$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {640}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends a49.c>>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Result<a49.c>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
            Object r6 = ((Result) r5).unbox-impl();
        L18:
            return Result.box-impl(r6);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r7 == null) goto L16;
            NetworkService r8 = r7.network();
            if (r8 == null) goto L16;
            List r2 = CollectionsKt.listOf(new String[]{"widget", "device_card"});
            this.label = 1;
            r6 = r8.a(r2, this);
            if (r6 != r0) goto L18;
            return r0;
        L16:
            return null;
        }
    }

    public DoraGDeviceManagementViewModel$refreshLatestCardContent$1$betaDeferred$1(Continuation<? super DoraGDeviceManagementViewModel$refreshLatestCardContent$1$betaDeferred$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraGDeviceManagementViewModel$refreshLatestCardContent$1$betaDeferred$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<a49.c>> r2) {
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
        AnonymousClass1 r7 = new AnonymousClass1(null);     // Catch: TimeoutCancellationException -> L15
        this.label = 1;     // Catch: TimeoutCancellationException -> L15
        r6 = TimeoutKt.b(8000, r7, this);     // Catch: TimeoutCancellationException -> L15
        if (r6 != r0) goto L13;
        return r0;
    L15:
        g49.d.e(DoraGDeviceManagementViewModel.TAG, "refreshLatestCardContent: diary beta timeout after 8s");
        return null;
    }
}
