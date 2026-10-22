package com.bytedance.ai.process.resource;

import android.os.RemoteException;
import com.bytedance.ai.process.g;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.process.resource.AIManagerRemoteProxy$getAIResourceFileDescriptor$1", f = "AIManagerRemoteProxy.kt", i = {0, 0, 1}, l = {218, 218}, m = "invokeSuspend", n = {"cbRef", "fileCallback", "cbRef"}, s = {"L$0", "L$1", "L$0"})
final class AIManagerRemoteProxy$getAIResourceFileDescriptor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public static final /* synthetic */ int g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicReference f2428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f2429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2430c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public AIManagerRemoteProxy$getAIResourceFileDescriptor$1(Function1 r5, String r10, String r11, Continuation r12) {
        this.d = r5;
        this.e = r10;
        this.f = r11;
        super(2, r12);
    }

    public static final Object a(String r10, String r11, a r12, ContinuationImpl r13) {
        if ((r13 instanceof AIManagerRemoteProxy$getAIResourceFileDescriptor$1$tryCallRemote$1) == false) goto L7;
        AIManagerRemoteProxy$getAIResourceFileDescriptor$1$tryCallRemote$1 r5 = (AIManagerRemoteProxy$getAIResourceFileDescriptor$1$tryCallRemote$1) r13;
        int r14 = r5.e;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r5.e = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r5.d;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r5.e;
        boolean r18 = true;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        r12 = r5.f2433c;
        r11 = r5.f2432b;
        r10 = r5.f2431a;
        ResultKt.throwOnFailure(r15);
    L17:
        g r19 = (g) r15;
        if (r19 == null) goto L20;
        ((com.bytedance.ai.process.e) r19).h(r10, r11, r12);     // Catch: Throwable -> L23 RemoteException -> L25
    L35:
        return Boxing.boxBoolean(r18);
    L25:
        e = move-exception;
        String r20 = "loadResourceFromClient RemoteException: " + e.getMessage();
        Intrinsics.checkNotNullParameter("AIManagerRemoteProxy", "tag");
        t0.d r21 = com.bytedance.ai.utils.c.f2846a;
        if (r21 == null) goto L33;
        r21.e("AIManagerRemoteProxy", r20, e);
    L33:
        r18 = false;
    L23:
        th = move-exception;
        String r22 = "loadResourceFromClient failed: " + th.getMessage();
        Intrinsics.checkNotNullParameter("AIManagerRemoteProxy", "tag");
        t0.d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L33;
        r23.e("AIManagerRemoteProxy", r22, th);
        goto L33
    L20:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        com.bytedance.ai.process.d r24 = com.bytedance.ai.process.d.f2415a;
        r5.f2431a = r10;
        r5.f2432b = r11;
        r5.f2433c = r12;
        r5.e = 1;
        r15 = r24.e(r5);
        if (r15 != r16) goto L17;
        return r16;
    L7:
        r5 = new AIManagerRemoteProxy$getAIResourceFileDescriptor$1$tryCallRemote$1(r13);
        goto L8
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AIManagerRemoteProxy$getAIResourceFileDescriptor$1(this.d, this.e, this.f, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((AIManagerRemoteProxy$getAIResourceFileDescriptor$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2430c;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        AtomicReference r12 = this.f2428a;
        ResultKt.throwOnFailure(r10);
    L20:
        if (((Boolean) r10).booleanValue() == true) goto L28;
        Intrinsics.checkNotNullParameter("AIManagerRemoteProxy", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L24;
        r13.e("AIManagerRemoteProxy", "failed to load resource from remote service");
    L24:
        Function1 r14 = (Function1) r12.getAndSet(null);
        if (r14 == null) goto L28;
        r14.invoke(null);
    L28:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        a r15 = this.f2429b;
        AtomicReference r16 = this.f2428a;
        ResultKt.throwOnFailure(r10);
        Object r17 = r10;
        AtomicReference r18 = r16;
    L14:
        if (((Boolean) r17).booleanValue() == true) goto L28;
        String r19 = this.e;
        String r20 = this.f;
        this.f2428a = r18;
        this.f2429b = null;
        this.f2430c = 2;
        Object r21 = a(r19, r20, r15, this);
        if (r21 != r5) goto L18;
    L17:
        return r5;
    L18:
        AtomicReference r22 = r18;
        r10 = r21;
        r12 = r22;
        goto L20
    L10:
        ResultKt.throwOnFailure(r10);
        r18 = new AtomicReference(this.d);
        r15 = new a(r18);
        String r23 = this.e;
        String r24 = this.f;
        this.f2428a = r18;
        this.f2429b = r15;
        this.f2430c = 1;
        r17 = a(r23, r24, r15, this);
        if (r17 != r5) goto L14;
        goto L17
    }
}
