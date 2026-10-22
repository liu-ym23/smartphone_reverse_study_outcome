package com.larus.drive.sdk.impl;

import com.larus.utils.logger.FLogger;
import ik5.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.DriveSdkServiceImpl$getImageCoverUrl$coverLoader$1$1", f = "DriveSdkServiceImpl.kt", i = {0}, l = {534, 538}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class DriveSdkServiceImpl$getImageCoverUrl$coverLoader$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $height;
    final /* synthetic */ Function0<Unit> $onFailure;
    final /* synthetic */ Function1<String, Unit> $onSuccess;
    final /* synthetic */ String $token;
    final /* synthetic */ int $width;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DriveSdkServiceImpl this$0;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.DriveSdkServiceImpl$getImageCoverUrl$coverLoader$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.DriveSdkServiceImpl$getImageCoverUrl$coverLoader$1$1$1", f = "DriveSdkServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $height;
        final /* synthetic */ Function0<Unit> $onFailure;
        final /* synthetic */ Function1<String, Unit> $onSuccess;
        final /* synthetic */ String $token;
        final /* synthetic */ int $width;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DriveSdkServiceImpl this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(DriveSdkServiceImpl r1, String r2, int r3, int r4, Function1<? super String, Unit> r5, Function0<Unit> r6, Continuation<? super AnonymousClass1> r7) {
            this.this$0 = r1;
            this.$token = r2;
            this.$height = r3;
            this.$width = r4;
            this.$onSuccess = r5;
            this.$onFailure = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r8 = new AnonymousClass1(this.this$0, this.$token, this.$height, this.$width, this.$onSuccess, this.$onFailure, r11);
            r8.L$0 = r10;
            return r8;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r5);
            if (CoroutineScopeKt.isActive((CoroutineScope) this.L$0) == false) goto L7;
            a r6 = this.this$0.a;
            if (r6 == null) goto L11;
            com.bytedance.ee.bear.list.cover.a r7 = r6.F9();
        L12:
            if (r7 == null) goto L16;
            DriveSdkServiceImpl r0 = this.this$0;
            String r1 = this.$token;
            int r2 = this.$height;
            int r3 = this.$width;
            r0.getClass();
            String r8 = r7.a(r1, r2, r3, "near");
            Function1<String, Unit> r4 = this.$onSuccess;
            if (r4 == null) goto L20;
            r4.invoke(r8);
        L20:
            return Unit.INSTANCE;
        L16:
            Function0<Unit> r9 = this.$onFailure;
            if (r9 == null) goto L20;
            r9.invoke();
            goto L20
        L11:
            r7 = null;
            goto L12
        L7:
            return Unit.INSTANCE;
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DriveSdkServiceImpl$getImageCoverUrl$coverLoader$1$1(DriveSdkServiceImpl r1, Function0<Unit> r2, String r3, int r4, int r5, Function1<? super String, Unit> r6, Continuation<? super DriveSdkServiceImpl$getImageCoverUrl$coverLoader$1$1> r7) {
        this.this$0 = r1;
        this.$onFailure = r2;
        this.$token = r3;
        this.$height = r4;
        this.$width = r5;
        this.$onSuccess = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        DriveSdkServiceImpl$getImageCoverUrl$coverLoader$1$1 r8 = new DriveSdkServiceImpl$getImageCoverUrl$coverLoader$1$1(this.this$0, this.$onFailure, this.$token, this.$height, this.$width, this.$onSuccess, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L12;
        if (r1 != 2) goto L11;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L8
    L31:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        DriveSdkServiceImpl r2 = (DriveSdkServiceImpl) this.L$1;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L8
    L20:
        r2.a = (a) r13;     // Catch: Exception -> L8
        if (CoroutineScopeKt.isActive(r3) == false) goto L23;
        MainCoroutineDispatcher r14 = Dispatchers.getMain();     // Catch: Exception -> L8
        AnonymousClass1 r4 = new AnonymousClass1(this.this$0, this.$token, this.$height, this.$width, this.$onSuccess, this.$onFailure, null);     // Catch: Exception -> L8
        this.L$0 = null;     // Catch: Exception -> L8
        this.L$1 = null;     // Catch: Exception -> L8
        this.label = 2;     // Catch: Exception -> L8
        if (BuildersKt.withContext(r14, r4, this) != r0) goto L31;
        return r0;
    L23:
        return Unit.INSTANCE;
    L15:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        r2 = this.this$0;     // Catch: Exception -> L8
        this.L$0 = r15;     // Catch: Exception -> L8
        this.L$1 = r2;     // Catch: Exception -> L8
        this.label = 1;     // Catch: Exception -> L8
        Object r5 = DriveSdkServiceImpl.V(r2, this);     // Catch: Exception -> L8
        if (r5 != r0) goto L19;
        return r0;
    L19:
        r3 = r15;
        r13 = r5;
    L8:
        e = move-exception;
        FLogger.a.e("DriveSdkServiceImpl", "Load docSdk failed: " + e.getMessage(), e);
        Function0<Unit> r16 = this.$onFailure;
        if (r16 == null) goto L31;
        r16.invoke();
        goto L31
    }
}
