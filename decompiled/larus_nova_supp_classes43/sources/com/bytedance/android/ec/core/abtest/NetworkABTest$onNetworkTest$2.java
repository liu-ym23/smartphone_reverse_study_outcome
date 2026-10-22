package com.bytedance.android.ec.core.abtest;

import com.bytedance.common.utility.Logger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.abtest.NetworkABTest$onNetworkTest$2", f = "NetworkABTest.kt", i = {}, l = {41, 44, 49}, m = "invokeSuspend", n = {}, s = {})
public final class NetworkABTest$onNetworkTest$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    int label;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.abtest.NetworkABTest$onNetworkTest$2$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.ec.core.abtest.NetworkABTest$onNetworkTest$2$1", f = "NetworkABTest.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ Map $getQuery;
        final /* synthetic */ Map $postBody;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.abtest.NetworkABTest$onNetworkTest$2$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "com.bytedance.android.ec.core.abtest.NetworkABTest$onNetworkTest$2$1$1", f = "NetworkABTest.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AnonymousClass1 this$0;

            public C01211(AnonymousClass1 r1, Continuation r10) {
                this.this$0 = r1;
                super(2, r10);
            }

            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                Intrinsics.checkNotNullParameter(r11, "completion");
                return new C01211(this.this$0, r11);
            }

            public final Object invoke(Object r1, Object r10) {
                return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r10) {
                Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r11 = this.label;
                if (r11 == 0) goto L11;
                if (r11 != 1) goto L10;
                ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L7
            L18:
            L17:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                ResultKt.throwOnFailure(r10);
                NetworkABTest.API r12 = NetworkABTest.c;     // Catch: Throwable -> L7
                String r0 = "https://ecom.snssdk.com" + NetworkABTest.b().d();     // Catch: Throwable -> L7
                Map<String, String> r13 = this.this$0.$getQuery;     // Catch: Throwable -> L7
                this.label = 1;     // Catch: Throwable -> L7
                if (r12.getApi(r0, r13, this) != r1) goto L18;
                return r1;
            L7:
                th = move-exception;
                Logger.e("NetworkABTest Get", th.getMessage());
                goto L17
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.abtest.NetworkABTest$onNetworkTest$2$1$2, reason: invalid class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "com.bytedance.android.ec.core.abtest.NetworkABTest$onNetworkTest$2$1$2", f = "NetworkABTest.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AnonymousClass1 this$0;

            public AnonymousClass2(AnonymousClass1 r1, Continuation r10) {
                this.this$0 = r1;
                super(2, r10);
            }

            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                Intrinsics.checkNotNullParameter(r11, "completion");
                return new AnonymousClass2(this.this$0, r11);
            }

            public final Object invoke(Object r1, Object r10) {
                return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r10) {
                Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r11 = this.label;
                if (r11 == 0) goto L11;
                if (r11 != 1) goto L10;
                ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L7
            L18:
            L17:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                ResultKt.throwOnFailure(r10);
                NetworkABTest.API r12 = NetworkABTest.c;     // Catch: Throwable -> L7
                String r0 = "https://ecom.snssdk.com" + NetworkABTest.b().e();     // Catch: Throwable -> L7
                Map<String, String> r13 = this.this$0.$postBody;     // Catch: Throwable -> L7
                this.label = 1;     // Catch: Throwable -> L7
                if (r12.postApi(r0, r13, this) != r1) goto L18;
                return r1;
            L7:
                th = move-exception;
                Logger.e("NetworkABTest Post", th.getMessage());
                goto L17
            }
        }

        public AnonymousClass1(Map r1, Map r10, Continuation r11) {
            this.$getQuery = r1;
            this.$postBody = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Intrinsics.checkNotNullParameter(r11, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.$getQuery, this.$postBody, r11);
            r0.L$0 = r10;
            return r0;
        }

        public final Object invoke(Object r1, Object r10) {
            return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r10);
            CoroutineScope r11 = (CoroutineScope) this.L$0;
            BuildersKt.launch$default(r11, null, null, new C01211(this, null), 3, null);
            return BuildersKt.launch$default(r11, null, null, new AnonymousClass2(this, null), 3, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public NetworkABTest$onNetworkTest$2(Continuation r10) {
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "completion");
        return new NetworkABTest$onNetworkTest$2(r10);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r12);
    L52:
        return r12;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r12);
    L24:
        Integer r13 = NetworkABTest.b().c();
        int r10 = 0;
        if (r13 == null) goto L27;
        int r14 = r13.intValue();
    L28:
        StringBuilder r11 = new StringBuilder();
    L30:
        if (r11.length() >= r14) goto L39;
        if (r11.length() != 0) goto L34;
        boolean r15 = true;
    L35:
        if (r15 == true) goto L36;
        r11.append(r11);
        goto L30
    L36:
        r11.append("z");
        goto L30
    L34:
        r15 = false;
        goto L35
    L39:
        if (r11.length() != r14) goto L41;
        String r16 = r11.toString();
    L42:
        Integer r17 = NetworkABTest.b().b();
        if (r17 == null) goto L45;
        int r18 = r17.intValue();
    L46:
        Map r19 = NetworkABTest.a(r18, r16);
        Integer r20 = NetworkABTest.b().f();
        if (r20 == null) goto L49;
        r10 = r20.intValue();
    L49:
        AnonymousClass1 r21 = new AnonymousClass1(r19, NetworkABTest.a(r10, r16), null);
        this.label = 3;
        r12 = SupervisorKt.supervisorScope(r21, this);
        if (r12 != r0) goto L52;
        return r0;
    L45:
        r18 = 0;
        goto L46
    L41:
        r16 = r11.substring(0, r14);
        goto L42
    L27:
        r14 = 0;
        goto L28
    L11:
        ResultKt.throwOnFailure(r12);
    L15:
        Long r110 = NetworkABTest.b().a();
        if (r110 == null) goto L18;
        long r22 = r110.longValue();
    L19:
        long r23 = r22 - 60;
        if (r23 <= 0) goto L24;
        this.label = 2;
        if (DelayKt.delay(r23 * 1000, this) != r0) goto L24;
        return r0;
    L18:
        r22 = 0;
        goto L19
    L12:
        ResultKt.throwOnFailure(r12);
        this.label = 1;
        if (DelayKt.delay(60000, this) != r0) goto L15;
        return r0;
    }
}
