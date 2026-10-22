package com.bytedance.ai.process.resource;

import android.os.RemoteException;
import com.bytedance.ai.process.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.process.resource.AIManagerRemoteProxy$onMarkOutOfUseFromClient$1", f = "AIManagerRemoteProxy.kt", i = {}, l = {178, 178}, m = "invokeSuspend", n = {}, s = {})
final class AIManagerRemoteProxy$onMarkOutOfUseFromClient$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2448c;

    public AIManagerRemoteProxy$onMarkOutOfUseFromClient$1(String r5, String r10, Continuation r11) {
        this.f2447b = r5;
        this.f2448c = r10;
        super(2, r11);
    }

    public static final Object a(String r10, String r11, ContinuationImpl r12) {
        if ((r12 instanceof AIManagerRemoteProxy$onMarkOutOfUseFromClient$1$tryCallRemote$1) == false) goto L7;
        AIManagerRemoteProxy$onMarkOutOfUseFromClient$1$tryCallRemote$1 r5 = (AIManagerRemoteProxy$onMarkOutOfUseFromClient$1$tryCallRemote$1) r12;
        int r13 = r5.d;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r5.d = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.f2451c;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.d;
        boolean r17 = true;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r11 = r5.f2450b;
        r10 = r5.f2449a;
        ResultKt.throwOnFailure(r14);
    L17:
        g r18 = (g) r14;
        if (r18 == null) goto L20;
        ((com.bytedance.ai.process.e) r18).e(com.bytedance.ai.process.d.f2418h, r10, r11);     // Catch: Throwable -> L23 RemoteException -> L27
    L33:
        return Boxing.boxBoolean(r17);
    L27:
        e = move-exception;
        String r19 = "markOutOfUseFromClient RemoteException: " + e.getMessage();
        Intrinsics.checkNotNullParameter("AIManagerRemoteProxy", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L31;
        r20.e("AIManagerRemoteProxy", r19, e);
    L31:
        r17 = false;
    L23:
        th = move-exception;
        String r21 = "markOutOfUseFromClient failed: " + th.getMessage();
        Intrinsics.checkNotNullParameter("AIManagerRemoteProxy", "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L31;
        r22.e("AIManagerRemoteProxy", r21, th);
        goto L31
    L20:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        com.bytedance.ai.process.d r23 = com.bytedance.ai.process.d.f2415a;
        r5.f2449a = r10;
        r5.f2450b = r11;
        r5.d = 1;
        r14 = r23.e(r5);
        if (r14 != r15) goto L17;
        return r15;
    L7:
        r5 = new AIManagerRemoteProxy$onMarkOutOfUseFromClient$1$tryCallRemote$1(r12);
        goto L8
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AIManagerRemoteProxy$onMarkOutOfUseFromClient$1(this.f2447b, this.f2448c, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        String r11 = this.f2447b;
        String r12 = this.f2448c;
        return new AIManagerRemoteProxy$onMarkOutOfUseFromClient$1(r11, r12, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2446a;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L19:
        if (((Boolean) r5).booleanValue() == true) goto L24;
        Intrinsics.checkNotNullParameter("AIManagerRemoteProxy", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L24;
        r12.e("AIManagerRemoteProxy", "failed to markOutOfUse on remote service");
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L14:
        if (((Boolean) r5).booleanValue() == true) goto L24;
        String r13 = this.f2447b;
        String r14 = this.f2448c;
        this.f2446a = 2;
        r5 = a(r13, r14, this);
        if (r5 != r10) goto L19;
    L17:
        return r10;
    L10:
        ResultKt.throwOnFailure(r5);
        String r15 = this.f2447b;
        String r16 = this.f2448c;
        this.f2446a = 1;
        r5 = a(r15, r16, this);
        if (r5 != r10) goto L14;
        goto L17
    }
}
