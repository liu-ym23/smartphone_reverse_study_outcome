package com.bytedance.ai.model.widgets;

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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.widgets.LynxViewFloatingPage$changeTo$1", f = "LynxViewFloatingPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nLynxViewFloatingPage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LynxViewFloatingPage.kt\ncom/bytedance/ai/model/widgets/LynxViewFloatingPage$changeTo$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,540:1\n1#2:541\n*E\n"})
final class LynxViewFloatingPage$changeTo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifecycleRegistry f2310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Lifecycle.Event f2311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f2312c;

    public LynxViewFloatingPage$changeTo$1(LifecycleRegistry r5, Lifecycle.Event r10, Function0 r11, Continuation r12) {
        this.f2310a = r5;
        this.f2311b = r10;
        this.f2312c = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new LynxViewFloatingPage$changeTo$1(this.f2310a, this.f2311b, this.f2312c, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((LynxViewFloatingPage$changeTo$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r5);
        LifecycleRegistry r10 = this.f2310a;
        Lifecycle.Event r11 = this.f2311b;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        r10.handleLifecycleEvent(r11);     // Catch: Throwable -> L5
        Object r13 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (Result.m127exceptionOrNullimpl(r13) == null) goto L11;
        this.f2312c.invoke();
    L11:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
