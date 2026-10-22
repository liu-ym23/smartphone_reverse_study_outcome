package com.obric.aikernel.multiusr;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.multiusr.BaseMultiUsrService$onBind$1$2", f = "BaseMultiUsrService.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
final class BaseMultiUsrService$onBind$1$2 extends SuspendLambda implements Function2<l0, Continuation<? super IBinder>, Object> {
    final /* synthetic */ Intent $it;
    int label;
    final /* synthetic */ BaseMultiUsrService this$0;

    /* JADX INFO: renamed from: com.obric.aikernel.multiusr.BaseMultiUsrService$onBind$1$2$2, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.multiusr.BaseMultiUsrService$onBind$1$2$2", f = "BaseMultiUsrService.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<l0, Continuation<? super IBinder>, Object> {
        final /* synthetic */ w<IBinder> $deffer;
        int label;

        AnonymousClass2(w<IBinder> r10, Continuation<? super AnonymousClass2> r11) {
            this.$deffer = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass2(this.$deffer, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super IBinder> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super IBinder> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            w<IBinder> r13 = this.$deffer;
            this.label = 1;
            r10 = r13.r(this);
            if (r10 != r11) goto L11;
            return r11;
        }
    }

    public static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ w<IBinder> f4719c;

        a(w<IBinder> r10) {
            this.f4719c = r10;
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName r10) {
            this.f4719c.K(null);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            this.f4719c.K(r11);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            this.f4719c.K(null);
        }
    }

    BaseMultiUsrService$onBind$1$2(BaseMultiUsrService r10, Intent r11, Continuation<? super BaseMultiUsrService$onBind$1$2> r12) {
        this.this$0 = r10;
        this.$it = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new BaseMultiUsrService$onBind$1$2(this.this$0, this.$it, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super IBinder> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super IBinder> r11) {
        return ((BaseMultiUsrService$onBind$1$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        w r13 = y.a(null);
        this.this$0.getApplicationContext().bindService(this.$it, 1, m1.a(z0.b()), new a(r13));
        AnonymousClass2 r14 = new AnonymousClass2(r13, null);
        this.label = 1;
        r10 = TimeoutKt.d(5000, r14, this);
        if (r10 != r11) goto L11;
        return r11;
    }
}
