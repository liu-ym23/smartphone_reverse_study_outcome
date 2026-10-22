package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl$sdkInitAwaiter$1", f = "UserManagerImpl.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
public final class UserManagerImpl$sdkInitAwaiter$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.internal.UserManagerImpl$sdkInitAwaiter$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl$sdkInitAwaiter$1$1", f = "UserManagerImpl.kt", i = {0}, l = {81}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.internal.UserManagerImpl$sdkInitAwaiter$1$1$a */
        public static final class a implements se6.d {
            public final /* synthetic */ CoroutineScope a;
            public final /* synthetic */ Continuation<Unit> b;

            public a(CoroutineScope r1, SafeContinuation r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void onInit() {
                Log.i("UserManagerImpl", "sdk initialized");
                Continuation<Unit> r0 = this.b;
                Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
                Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L5
                r0.resumeWith(Result.constructor-impl(r3));     // Catch: Throwable -> L5
                Object r1 = Result.constructor-impl(r3);     // Catch: Throwable -> L5
            L7:
                Throwable r4 = Result.exceptionOrNull-impl(r1);
                if (r4 == null) goto L13;
                Log.e("UserManagerImpl", "err:" + r4);
                return;
            L13:
                return;
            L5:
                th = move-exception;
                Result.Companion r5 = Result.Companion;
                r1 = Result.constructor-impl(ResultKt.createFailure(th));
                goto L7
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(r3);
            r0.L$0 = r2;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r6);
        L24:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            CoroutineScope r7 = (CoroutineScope) this.L$0;
            this.L$0 = r7;
            this.label = 1;
            SafeContinuation r4 = new SafeContinuation(IntrinsicsKt.intercepted(this));
            Map r5 = com.bytedance.lark.sdk.d.e;
            com.bytedance.lark.sdk.d r8 = com.bytedance.lark.sdk.d.f.a;
            a r9 = new a(r7, r4);
            r8.getClass();
            Set r10 = com.bytedance.lark.sdk.d.q;
            monitor-enter(r10);
        L25:
            th = move-exception;
            throw th;
        L11:
            if (com.bytedance.lark.sdk.d.p >= 0) goto L14;
            r2 = false;
        L14:
            if (r2 == false) goto L16;
            r9.onInit();     // Catch: Throwable -> L25
        L17:
            monitor-exit(r10);     // Catch: Throwable -> L25
            Object r11 = r4.getOrThrow();
            if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
            DebugProbesKt.probeCoroutineSuspended(this);
        L21:
            if (r11 != r0) goto L24;
            return r0;
        L16:
            ((HashSet) r10).add(r9);     // Catch: Throwable -> L25
            goto L17
        }
    }

    public UserManagerImpl$sdkInitAwaiter$1(Continuation<? super UserManagerImpl$sdkInitAwaiter$1> r2) {
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r2) {
        return new UserManagerImpl$sdkInitAwaiter$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CoroutineDispatcher r6 = Dispatchers.getDefault();
        AnonymousClass1 r2 = new AnonymousClass1(null);
        this.label = 1;
        if (BuildersKt.withContext(r6, r2, this) != r0) goto L12;
        return r0;
    }
}
