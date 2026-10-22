package com.bytedance.ies.argus.util;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.j0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.util.CommonUtils$safelyAwaitAll$1", f = "CommonUtils.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
final class CommonUtils$safelyAwaitAll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f5169b;

    /* JADX INFO: renamed from: com.bytedance.ies.argus.util.CommonUtils$safelyAwaitAll$1$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ies.argus.util.CommonUtils$safelyAwaitAll$1$1", f = "CommonUtils.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Object>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f5171b;

        public AnonymousClass1(ArrayList r5, Continuation r10) {
            this.f5171b = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r5, Continuation r10) {
            return new AnonymousClass1(this.f5171b, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super List<? extends Object>> r10) {
            ArrayList r11 = this.f5171b;
            return new AnonymousClass1(r11, r10).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.f5170a;
            if (r11 == 0) goto L9;
            if (r11 != 1) goto L8;
            ResultKt.throwOnFailure(r5);
            return r5;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
            ArrayList r12 = this.f5171b;
            this.f5170a = 1;
            Object r13 = j0.c(r12, this);
            if (r13 != r10) goto L12;
            return r10;
        L12:
            return r13;
        }
    }

    public CommonUtils$safelyAwaitAll$1(ArrayList r5, Continuation r10) {
        this.f5169b = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new CommonUtils$safelyAwaitAll$1(this.f5169b, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Boolean> r10) {
        ArrayList r11 = this.f5169b;
        return new CommonUtils$safelyAwaitAll$1(r11, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f5168a;
        boolean r12 = true;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L18
    L13:
        if (r10 == null) goto L17;
        r12 = false;
        goto L17
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        AnonymousClass1 r13 = new AnonymousClass1(this.f5169b, null);     // Catch: Exception -> L18
        this.f5168a = 1;     // Catch: Exception -> L18
        r10 = e2.b(WsConstants.EXIT_DELAY_TIME, r13, this);     // Catch: Exception -> L18
        if (r10 != r5) goto L13;
        return r5;
    L17:
        return Boxing.boxBoolean(r12);
    }
}
