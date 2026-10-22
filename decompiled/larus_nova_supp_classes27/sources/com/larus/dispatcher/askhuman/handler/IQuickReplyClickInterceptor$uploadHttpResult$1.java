package com.larus.dispatcher.askhuman.handler;

import android.app.Activity;
import com.larus.common.apphost.AppHost;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor$uploadHttpResult$1", f = "IQuickReplyClickInterceptor.kt", i = {}, l = {123, 135}, m = "invokeSuspend", n = {}, s = {})
final class IQuickReplyClickInterceptor$uploadHttpResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super dm9.a<Unit>>, Object> $call;
    final /* synthetic */ o $interceptorContext;
    int label;

    /* JADX INFO: renamed from: com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor$uploadHttpResult$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor$uploadHttpResult$1$1", f = "IQuickReplyClickInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            t19.s r3 = t19.s.a;
            Activity r0 = AppHost.a.a().getTopActivity();
            r3.getClass();
            t19.s.s(r0, 2131897943);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public IQuickReplyClickInterceptor$uploadHttpResult$1(Function1<? super Continuation<? super dm9.a<Unit>>, ? extends Object> r1, o r2, Continuation<? super IQuickReplyClickInterceptor$uploadHttpResult$1> r3) {
        this.$call = r1;
        this.$interceptorContext = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new IQuickReplyClickInterceptor$uploadHttpResult$1(this.$call, this.$interceptorContext, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L37:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L13:
        dm9.a.b r6 = (dm9.a) r5;
        boolean r2 = r6 instanceof dm9.a.b;
        if (r2 == true) goto L16;
    L22:
        if (r2 == true) goto L24;
    L27:
        o r7 = this.$interceptorContext;
        if (r7.l == false) goto L30;
        Set<Integer> r3 = n.a;
        n.c(r7.g);
    L30:
        Function1<com.larus.bmhome.taskskill.service.k, Unit> r8 = this.$interceptorContext.k;
        if (r8 == null) goto L33;
        r8.invoke(new com.larus.bmhome.taskskill.service.k.b("http_failed"));
    L33:
        MainCoroutineDispatcher r9 = Dispatchers.getMain();
        AnonymousClass1 r4 = new AnonymousClass1(null);
        this.label = 2;
        if (BuildersKt.withContext(r9, r4, this) != r0) goto L37;
        return r0;
    L24:
        if (this.$interceptorContext.l == false) goto L27;
        return Unit.INSTANCE;
    L16:
        if (r6.a.isSuccess() == false) goto L22;
        Function1<com.larus.bmhome.taskskill.service.k, Unit> r10 = this.$interceptorContext.k;
        if (r10 == null) goto L21;
        r10.invoke(com.larus.bmhome.taskskill.service.k.g.a);
    L21:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r5);
        Function1<Continuation<? super dm9.a<Unit>>, Object> r11 = this.$call;
        this.label = 1;
        r5 = r11.invoke(this);
        if (r5 != r0) goto L13;
        return r0;
    }
}
