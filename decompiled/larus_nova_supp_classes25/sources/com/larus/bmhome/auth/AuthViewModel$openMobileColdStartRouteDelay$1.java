package com.larus.bmhome.auth;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.n3;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.auth.AuthViewModel$openMobileColdStartRouteDelay$1", f = "AuthViewModel.kt", i = {}, l = {2010, 2011}, m = "invokeSuspend", n = {}, s = {})
final class AuthViewModel$openMobileColdStartRouteDelay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $schema;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.auth.AuthViewModel$openMobileColdStartRouteDelay$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.auth.AuthViewModel$openMobileColdStartRouteDelay$1$1", f = "AuthViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $schema;
        int label;

        public AnonymousClass1(String r1, Continuation<? super AnonymousClass1> r2) {
            this.$schema = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$schema, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            FLogger.a.i("AuthViewModel", "open mobile cold start route");
            int r4 = n3.a;
            AppHost.Companion r5 = AppHost.a;
            Context r0 = r5.a().getCurrentActivity();
            if (r0 != null) goto L7;
            r0 = r5.getApplication();
        L7:
            n3.a(r0, this.$schema);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AuthViewModel$openMobileColdStartRouteDelay$1(String r1, Continuation<? super AuthViewModel$openMobileColdStartRouteDelay$1> r2) {
        this.$schema = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AuthViewModel$openMobileColdStartRouteDelay$1(this.$schema, r3);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L13:
        MainCoroutineDispatcher r7 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$schema, null);
        this.label = 2;
        if (BuildersKt.withContext(r7, r2, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(2000, this) != r0) goto L13;
        return r0;
    }
}
