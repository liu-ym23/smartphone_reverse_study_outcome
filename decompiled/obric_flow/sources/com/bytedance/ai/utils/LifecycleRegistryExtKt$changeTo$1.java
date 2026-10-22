package com.bytedance.ai.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.utils.LifecycleRegistryExtKt$changeTo$1", f = "LifecycleRegistryExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nLifecycleRegistryExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LifecycleRegistryExt.kt\ncom/bytedance/ai/utils/LifecycleRegistryExtKt$changeTo$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,24:1\n1#2:25\n*E\n"})
final class LifecycleRegistryExtKt$changeTo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Lifecycle.Event f2841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LifecycleRegistry f2842b;

    public LifecycleRegistryExtKt$changeTo$1(Lifecycle.Event r5, LifecycleRegistry r10, Continuation r11) {
        this.f2841a = r5;
        this.f2842b = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new LifecycleRegistryExtKt$changeTo$1(this.f2841a, this.f2842b, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        Lifecycle.Event r11 = this.f2841a;
        LifecycleRegistry r12 = this.f2842b;
        return new LifecycleRegistryExtKt$changeTo$1(r11, r12, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r5);
        String r10 = "LifecycleRegistry changeTo " + this.f2841a;
        Intrinsics.checkNotNullParameter("LifecycleRegistry", "tag");
        t0.d r11 = c.f2846a;
        if (r11 == null) goto L6;
        r11.d("LifecycleRegistry", r10);
    L6:
        if (this.f2841a != Lifecycle.Event.ON_DESTROY) goto L8;
    L12:
        LifecycleRegistry r12 = this.f2842b;
        Lifecycle.Event r13 = this.f2841a;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L15
        r12.handleLifecycleEvent(r13);     // Catch: Throwable -> L15
        Object r15 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r16 = Result.m127exceptionOrNullimpl(r15);
        if (r16 == null) goto L23;
        Lifecycle.Event r17 = this.f2841a;
        StringBuilder r18 = new StringBuilder("Unable to handleLifecycleEvent ");
        r18.append(r17);
        r18.append(' ');
        r16.printStackTrace();
        r18.append(Unit.INSTANCE);
        String r19 = r18.toString();
        Intrinsics.checkNotNullParameter("LifecycleRegistry", "tag");
        t0.d r20 = c.f2846a;
        if (r20 == null) goto L23;
        r20.e("LifecycleRegistry", r19);
    L23:
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L17
    L8:
        if (this.f2842b.getCurrentState() != Lifecycle.State.DESTROYED) goto L12;
        String r22 = "Unable to " + this.f2841a + " current state is " + this.f2842b.getCurrentState();
        Intrinsics.checkNotNullParameter("LifecycleRegistry", "tag");
        t0.d r23 = c.f2846a;
        if (r23 == null) goto L23;
        r23.e("LifecycleRegistry", r22);
        goto L23
    }
}
