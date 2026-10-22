package com.larus.drive.sdk.impl;

import ik5.a;
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
import tx9.p1;
import u79.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.DriveSdkServiceImpl$retryListRequestAfterDocSdkInit$1", f = "DriveSdkServiceImpl.kt", i = {}, l = {1048, 1052, 1065, 1070}, m = "invokeSuspend", n = {}, s = {})
final class DriveSdkServiceImpl$retryListRequestAfterDocSdkInit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $callback;
    final /* synthetic */ DriveSdkServiceImpl.b $cancelable;
    final /* synthetic */ String $driveScene;
    final /* synthetic */ Function1<a, nc5.b> $fetch;
    int label;
    final /* synthetic */ DriveSdkServiceImpl this$0;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.DriveSdkServiceImpl$retryListRequestAfterDocSdkInit$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.DriveSdkServiceImpl$retryListRequestAfterDocSdkInit$1$1", f = "DriveSdkServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ b $callback;
        final /* synthetic */ DriveSdkServiceImpl.b $cancelable;
        final /* synthetic */ String $driveScene;
        int label;

        public AnonymousClass1(DriveSdkServiceImpl.b r1, String r2, b r3, Continuation<? super AnonymousClass1> r4) {
            this.$cancelable = r1;
            this.$driveScene = r2;
            this.$callback = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$cancelable, this.$driveScene, this.$callback, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            if (this.$cancelable.a == true) goto L7;
            p1.b(this.$driveScene);
            this.$callback.onError("not_initialized");
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.DriveSdkServiceImpl$retryListRequestAfterDocSdkInit$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.DriveSdkServiceImpl$retryListRequestAfterDocSdkInit$1$2", f = "DriveSdkServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DriveSdkServiceImpl.b $cancelable;
        final /* synthetic */ Function1<a, nc5.b> $fetch;
        final /* synthetic */ a $sdk;
        int label;

        public AnonymousClass2(DriveSdkServiceImpl.b r1, Function1<? super a, ? extends nc5.b> r2, a r3, Continuation<? super AnonymousClass2> r4) {
            this.$cancelable = r1;
            this.$fetch = r2;
            this.$sdk = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.$cancelable, this.$fetch, this.$sdk, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r3);
            if (this.$cancelable.a == true) goto L7;
            DriveSdkServiceImpl.b r4 = this.$cancelable;
            r4.b = (nc5.b) this.$fetch.invoke(this.$sdk);
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.DriveSdkServiceImpl$retryListRequestAfterDocSdkInit$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.DriveSdkServiceImpl$retryListRequestAfterDocSdkInit$1$3", f = "DriveSdkServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ b $callback;
        final /* synthetic */ DriveSdkServiceImpl.b $cancelable;
        final /* synthetic */ String $driveScene;
        final /* synthetic */ Exception $e;
        int label;

        public AnonymousClass3(DriveSdkServiceImpl.b r1, String r2, b r3, Exception r4, Continuation<? super AnonymousClass3> r5) {
            this.$cancelable = r1;
            this.$driveScene = r2;
            this.$callback = r3;
            this.$e = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass3(this.$cancelable, this.$driveScene, this.$callback, this.$e, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r2);
            if (this.$cancelable.a == true) goto L7;
            p1.b(this.$driveScene);
            b r3 = this.$callback;
            String r0 = this.$e.getMessage();
            if (r0 != null) goto L11;
            r0 = "not_initialized";
        L11:
            r3.onError(r0);
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DriveSdkServiceImpl$retryListRequestAfterDocSdkInit$1(DriveSdkServiceImpl r1, DriveSdkServiceImpl.b r2, String r3, b r4, Function1<? super a, ? extends nc5.b> r5, Continuation<? super DriveSdkServiceImpl$retryListRequestAfterDocSdkInit$1> r6) {
        this.this$0 = r1;
        this.$cancelable = r2;
        this.$driveScene = r3;
        this.$callback = r4;
        this.$fetch = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DriveSdkServiceImpl$retryListRequestAfterDocSdkInit$1(this.this$0, this.$cancelable, this.$driveScene, this.$callback, this.$fetch, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L17;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        ResultKt.throwOnFailure(r10);
    L39:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L15
        goto L39
    L12:
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L15
    L31:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L15
    L21:
        a r11 = (a) r10;     // Catch: Exception -> L15
        if (this.$cancelable.a == false) goto L26;
        return Unit.INSTANCE;
    L26:
        if (r11 != null) goto L32;
        MainCoroutineDispatcher r12 = Dispatchers.getMain();     // Catch: Exception -> L15
        AnonymousClass1 r3 = new AnonymousClass1(this.$cancelable, this.$driveScene, this.$callback, null);     // Catch: Exception -> L15
        this.label = 2;     // Catch: Exception -> L15
        if (BuildersKt.withContext(r12, r3, this) != r0) goto L31;
        return r0;
    L32:
        this.this$0.a = r11;     // Catch: Exception -> L15
        MainCoroutineDispatcher r4 = Dispatchers.getMain();     // Catch: Exception -> L15
        AnonymousClass2 r5 = new AnonymousClass2(this.$cancelable, this.$fetch, r11, null);     // Catch: Exception -> L15
        this.label = 3;     // Catch: Exception -> L15
        if (BuildersKt.withContext(r4, r5, this) != r0) goto L39;
        return r0;
    L17:
        ResultKt.throwOnFailure(r10);
        DriveSdkServiceImpl r13 = this.this$0;     // Catch: Exception -> L15
        this.label = 1;     // Catch: Exception -> L15
        r10 = DriveSdkServiceImpl.V(r13, this);     // Catch: Exception -> L15
        if (r10 != r0) goto L21;
        return r0;
    L15:
        e = move-exception;
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass3 r2 = new AnonymousClass3(this.$cancelable, this.$driveScene, this.$callback, e, null);
        this.label = 4;
        if (BuildersKt.withContext(r14, r2, this) != r0) goto L39;
        return r0;
    }
}
