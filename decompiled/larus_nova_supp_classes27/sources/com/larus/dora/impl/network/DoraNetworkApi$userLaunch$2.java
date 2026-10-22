package com.larus.dora.impl.network;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.larus.bmhome.auth.LaunchBiz;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/larus/dora/impl/network/UserLaunchResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.network.DoraNetworkApi$userLaunch$2", f = "DoraNetworkApi.kt", i = {}, l = {1423}, m = "invokeSuspend", n = {}, s = {})
public final class DoraNetworkApi$userLaunch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends e0>>, Object> {
    int label;

    public static final class a<T> implements Observer {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ Ref.ObjectRef<Observer<c1<com.larus.bmhome.auth.e0>>> c;
        public final /* synthetic */ kotlinx.coroutines.i<Result<e0>> d;

        public a(Ref.BooleanRef r1, Ref.BooleanRef r2, Ref.ObjectRef r3, j r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void onChanged(Object r8) {
            c1 r9 = (c1) r8;
            Intrinsics.checkNotNullParameter(r9, "result");
            if (this.a.element == false) goto L19;
            int r0 = r9.b;
            if (r0 != 2) goto L8;
            DoraNetworkApi r1 = DoraNetworkApi.a;
            e0 r10 = DoraNetworkApi.a((com.larus.bmhome.auth.e0) r9.d);
            g49.d.d("DoraNetworkApi", "userLaunch split basic launch success");
            DoraNetworkApi$userLaunch$2.access$invokeSuspend$lambda$0$finish(this.b, this.c, this.d, Result.constructor-impl(r10));
            return;
        L8:
            if (r0 == 3) goto L10;
            g49.d.d("DoraNetworkApi", "userLaunch split basic launch wait status=" + r9.b);
            return;
        L10:
            com.larus.bmhome.auth.e0 r2 = (com.larus.bmhome.auth.e0) r9.d;
            if (r2 == null) goto L13;
            Ref.BooleanRef r3 = this.b;
            Ref.ObjectRef<Observer<c1<com.larus.bmhome.auth.e0>>> r4 = this.c;
            kotlinx.coroutines.i<Result<e0>> r5 = this.d;
            g49.d.b("DoraNetworkApi", "userLaunch split basic launch failed, use cache " + r9.e);
            Result.Companion r11 = Result.Companion;
            DoraNetworkApi$userLaunch$2.access$invokeSuspend$lambda$0$finish(r3, r4, r5, Result.constructor-impl(DoraNetworkApi.a(r2)));
            return;
        L13:
            g49.d.b("DoraNetworkApi", "userLaunch split basic launch failed " + r9.e);
            Ref.BooleanRef r6 = this.b;
            Ref.ObjectRef<Observer<c1<com.larus.bmhome.auth.e0>>> r7 = this.c;
            kotlinx.coroutines.i<Result<e0>> r12 = this.d;
            Result.Companion r13 = Result.Companion;
            DoraNetworkApi$userLaunch$2.access$invokeSuspend$lambda$0$finish(r6, r7, r12, Result.constructor-impl(ResultKt.createFailure(new RuntimeException("userLaunch split basic launch failed " + r9.e))));
            return;
        }
    }

    public static final class b implements Function1<Throwable, Unit> {
        public final /* synthetic */ Ref.ObjectRef<Observer<c1<com.larus.bmhome.auth.e0>>> a;

        public b(Ref.ObjectRef<Observer<c1<com.larus.bmhome.auth.e0>>> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            Throwable r3 = (Throwable) r2;
            LiveData r4 = AuthModelDelegate.b.l();
            Object r0 = this.a.element;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("observer");
            Observer r1 = null;
        L6:
            r4.removeObserver(r1);
            return Unit.INSTANCE;
        L5:
            r1 = (Observer) r0;
            goto L6
        }
    }

    public DoraNetworkApi$userLaunch$2(Continuation<? super DoraNetworkApi$userLaunch$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraNetworkApi$userLaunch$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<e0>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L17:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        this.label = 1;
        j r9 = new j(IntrinsicsKt.intercepted(this), 1);
        r9.C();
        Ref.BooleanRef r2 = new Ref.BooleanRef();
        Ref.BooleanRef r3 = new Ref.BooleanRef();
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = new a(r2, r3, r4, r9);
        AuthModelDelegate r5 = AuthModelDelegate.b;
        LiveData r6 = r5.l();
        Object r7 = r4.element;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("observer");
        Observer r10 = null;
    L12:
        r6.observeForever(r10);
        r9.i(new b(r4));
        r2.element = true;
        r5.t("dora_user_launch", SetsKt.setOf(LaunchBiz.BASIC), true);
        r8 = r9.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(this);
    L15:
        if (r8 != r0) goto L17;
        return r0;
    L11:
        r10 = (Observer) r7;
        goto L12
    }

    public static final void access$invokeSuspend$lambda$0$finish(Ref.BooleanRef r1, Ref.ObjectRef r2, kotlinx.coroutines.i r3, Object r4) {
        if (r1.element == true) goto L14;
        r1.element = true;
        LiveData r5 = AuthModelDelegate.b.l();
        Object r6 = r2.element;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("observer");
        Observer r7 = null;
    L9:
        r5.removeObserver(r7);
        if (r3.isActive() == false) goto L13;
        r3.resumeWith(Result.constructor-impl(Result.box-impl(r4)));
        return;
    L13:
        return;
    L8:
        r7 = (Observer) r6;
        goto L9
    }
}
