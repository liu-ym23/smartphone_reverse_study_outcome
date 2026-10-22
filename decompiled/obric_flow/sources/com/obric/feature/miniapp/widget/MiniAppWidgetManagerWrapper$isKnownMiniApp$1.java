package com.obric.feature.miniapp.widget;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper$isKnownMiniApp$1", f = "MiniAppWidgetManagerWrapper.kt", i = {1}, l = {354, 750}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nMiniAppWidgetManagerWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MiniAppWidgetManagerWrapper.kt\ncom/obric/feature/miniapp/widget/MiniAppWidgetManagerWrapper$isKnownMiniApp$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,744:1\n116#2,11:745\n*S KotlinDebug\n*F\n+ 1 MiniAppWidgetManagerWrapper.kt\ncom/obric/feature/miniapp/widget/MiniAppWidgetManagerWrapper$isKnownMiniApp$1\n*L\n355#1:745,11\n*E\n"})
final class MiniAppWidgetManagerWrapper$isKnownMiniApp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kotlinx.coroutines.sync.a f11412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11414c;
    public final /* synthetic */ String d;

    public MiniAppWidgetManagerWrapper$isKnownMiniApp$1(String r5, Continuation r10) {
        this.d = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new MiniAppWidgetManagerWrapper$isKnownMiniApp$1(this.d, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Boolean> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f11414c;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        String r12 = this.f11413b;
        kotlinx.coroutines.sync.a r13 = this.f11412a;
        ResultKt.throwOnFailure(r5);
    L24:
        Boolean r14 = Boxing.boxBoolean(MiniAppWidgetManagerWrapper.access$getMiniAppInfosMap$p().containsKey(r12));     // Catch: Throwable -> L21
        ((d) r13).d(null);
        return r14;
    L21:
        th = move-exception;
        ((d) r13).d(null);
        throw th;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L13:
        kotlinx.coroutines.sync.a r15 = MiniAppWidgetManagerWrapper.access$getMutex$p();
        String r16 = this.d;
        this.f11412a = r15;
        this.f11413b = r16;
        this.f11414c = 2;
        d r17 = (d) r15;
        if (r17.c(this) != r10) goto L16;
    L15:
        return r10;
    L16:
        r13 = r17;
        r12 = r16;
        goto L24
    L10:
        ResultKt.throwOnFailure(r5);
        MiniAppWidgetManagerWrapper r18 = MiniAppWidgetManagerWrapper.INSTANCE;
        this.f11414c = 1;
        if (MiniAppWidgetManagerWrapper.access$awaitInit(r18, this) != r10) goto L13;
        goto L13
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Boolean> r10) {
        return ((MiniAppWidgetManagerWrapper$isKnownMiniApp$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
