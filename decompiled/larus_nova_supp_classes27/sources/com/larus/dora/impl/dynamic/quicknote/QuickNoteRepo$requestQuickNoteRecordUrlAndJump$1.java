package com.larus.dora.impl.dynamic.quicknote;

import android.app.Activity;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.network.y;
import com.larus.utils.o0;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo$requestQuickNoteRecordUrlAndJump$1", f = "QuickNoteRepo.kt", i = {}, l = {232, 236}, m = "invokeSuspend", n = {}, s = {})
public final class QuickNoteRepo$requestQuickNoteRecordUrlAndJump$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $deviceParam;
    final /* synthetic */ Activity $routeContext;
    int label;

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo$requestQuickNoteRecordUrlAndJump$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo$requestQuickNoteRecordUrlAndJump$1$1", f = "QuickNoteRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $routeContext;
        final /* synthetic */ String $url;
        int label;

        public AnonymousClass1(Activity r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$routeContext = r1;
            this.$url = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$routeContext, this.$url, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r3);
            if (this.$routeContext.isFinishing() == false) goto L7;
        L11:
            g49.d.e("QuickNoteRepo", "open quick note route skipped because activity is unavailable");
            return Unit.INSTANCE;
        L7:
            if (this.$routeContext.isDestroyed() == true) goto L11;
            g49.d.d("QuickNoteRepo", "open quick note route from=".concat(this.$routeContext.getClass().getSimpleName()));
            com.bytedance.router.i r4 = SmartRouter.buildRoute(this.$routeContext, this.$url);
            r4.d = 2130772401;
            r4.e = 2130772399;
            r4.d();
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public QuickNoteRepo$requestQuickNoteRecordUrlAndJump$1(DoraDevice r1, Activity r2, Continuation<? super QuickNoteRepo$requestQuickNoteRecordUrlAndJump$1> r3) {
        this.$deviceParam = r1;
        this.$routeContext = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new QuickNoteRepo$requestQuickNoteRecordUrlAndJump$1(this.$deviceParam, this.$routeContext, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L36:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L20:
        if (Result.isSuccess-impl(r8) == true) goto L22;
        s.a.g(AppHost.a.getApplication(), 2131908080, false);
        g49.d.b("QuickNoteRepo", "requestQuickNoteRecordUrlAndJump failed.");
        goto L36
    L22:
        if (Result.isFailure-impl(r8) == false) goto L24;
        r8 = null;
    L24:
        y r9 = (y) r8;
        if (r9 == null) goto L27;
        String r10 = r9.a();
    L29:
        if (o0.d(r10) == false) goto L33;
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r4 = new AnonymousClass1(this.$routeContext, r10, null);
        this.label = 2;
        if (BuildersKt.withContext(r2, r4, this) != r0) goto L36;
        return r0;
    L33:
        g49.d.b("QuickNoteRepo", "requestQuickNoteRecordUrlAndJump url is null or empty.");
        goto L36
    L27:
        r10 = null;
        goto L29
    L10:
        ResultKt.throwOnFailure(r7);
        DoraDevice r11 = this.$deviceParam;
        if (r11 != null) goto L13;
        r11 = DoraAdapterExtKt.h(kj4.a.g());
    L13:
        if (r11 != null) goto L16;
        g49.d.b("QuickNoteRepo", "requestQuickNoteRecordUrlAndJump device is null");
        return Unit.INSTANCE;
    L16:
        DoraNetworkApi r3 = DoraNetworkApi.a;
        this.label = 1;
        r8 = r3.u(r11, this);
        if (r8 != r0) goto L20;
        return r0;
    }
}
