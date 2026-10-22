package com.obric.assistant.settings.voiceprint;

import android.os.Looper;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.SessionAuthenticationServiceDelegate;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.n4;
import com.obric.assistant.o4;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementActivity$startAuthentication$1", f = "ObricVoicePrintManagementActivity.kt", i = {}, l = {151, 153}, m = "invokeSuspend", n = {}, s = {})
public final class ObricVoicePrintManagementActivity$startAuthentication$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $requestId;
    int label;
    final /* synthetic */ ObricVoicePrintManagementActivity this$0;

    /* JADX INFO: renamed from: com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementActivity$startAuthentication$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementActivity$startAuthentication$1$1", f = "ObricVoicePrintManagementActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $requestId;
        int label;
        final /* synthetic */ ObricVoicePrintManagementActivity this$0;

        /* JADX INFO: renamed from: com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementActivity$startAuthentication$1$1$a */
        public static final class a implements n4 {
            public final /* synthetic */ ObricVoicePrintManagementActivity a;
            public final /* synthetic */ long b;

            public final void onAuthenticationCancelled() {
                if (this.a.m == this.b) goto L6;
                FLogger.a.i("[ObricVoicePrintManagementActivity]", "onAuthenticationCancelled: stale callback ignored");
                return;
            L6:
                FLogger.a.i("[ObricVoicePrintManagementActivity]", "onAuthenticationCancelled");
                ObricVoicePrintManagementActivity r0 = this.a;
                r0.p = false;
                b r1 = new b(r0);
                if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L9;
                r1.invoke();
                return;
            L9:
                t0.e(new c(r1));
            }

            public final void onAuthenticationFailed() {
                if (this.a.m == this.b) goto L6;
                FLogger.a.i("[ObricVoicePrintManagementActivity]", "onAuthenticationFailed: stale callback ignored");
                return;
            L6:
                FLogger.a.i("[ObricVoicePrintManagementActivity]", "onAuthenticationFailed");
                ObricVoicePrintManagementActivity r0 = this.a;
                r0.p = false;
                b r1 = new b(r0);
                if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L9;
                r1.invoke();
                return;
            L9:
                t0.e(new c(r1));
            }

            public final void onAuthenticationNotAvailable() {
                if (this.a.m == this.b) goto L6;
                FLogger.a.i("[ObricVoicePrintManagementActivity]", "onAuthenticationNotAvailable: stale callback ignored");
                return;
            L6:
                FLogger.a.i("[ObricVoicePrintManagementActivity]", "onAuthenticationNotAvailable");
                ObricVoicePrintManagementActivity r0 = this.a;
                r0.p = false;
                b r1 = new b(r0);
                if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L9;
                r1.invoke();
                return;
            L9:
                t0.e(new c(r1));
            }

            /* JADX WARN: Type inference failed for: r3v0, types: [com.obric.assistant.settings.voiceprint.d, kotlin.jvm.functions.Function0] */
            public final void onAuthenticationPass() {
                final ObricVoicePrintManagementActivity r0 = this.a;
                final long r1 = this.b;
                ?? r3 = new d(r0, r1);
                int r2 = ObricVoicePrintManagementActivity.q;
                r0.getClass();
                if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
                r3.invoke();
                return;
            L5:
                t0.e(new c(r3));
            }

            public final void onAuthenticationTimeout() {
                if (this.a.m == this.b) goto L6;
                FLogger.a.i("[ObricVoicePrintManagementActivity]", "onAuthenticationTimeout: stale callback ignored");
                return;
            L6:
                FLogger.a.i("[ObricVoicePrintManagementActivity]", "onAuthenticationTimeout");
                ObricVoicePrintManagementActivity r0 = this.a;
                r0.p = false;
                b r1 = new b(r0);
                if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L9;
                r1.invoke();
                return;
            L9:
                t0.e(new c(r1));
            }

            public a(ObricVoicePrintManagementActivity r1, long r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public AnonymousClass1(ObricVoicePrintManagementActivity r1, long r2, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$requestId = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$requestId, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L32;
            ResultKt.throwOnFailure(r9);
            if (this.this$0.isFinishing() == true) goto L20;
            if (this.this$0.isDestroyed() == true) goto L20;
            ObricVoicePrintManagementActivity r10 = this.this$0;
            if (r10.n == false) goto L20;
            if (r10.h != ObricVoicePrintManagementActivity.AuthState.AUTHENTICATING) goto L20;
            if (r10.m != this.$requestId) goto L20;
            if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == true) goto L20;
            SessionAuthenticationServiceDelegate.b.e(new o4(this.this$0.getString(2131912072), this.this$0.getString(2131912070), null, 4), new a(this.this$0, this.$requestId));
            this.this$0.p = true;
            return Unit.INSTANCE;
        L20:
            if (this.this$0.m == this.$requestId) goto L22;
        L24:
            ObricVoicePrintManagementActivity r1 = this.this$0;
            if (r1.m == this.$requestId) goto L27;
        L30:
            return Unit.INSTANCE;
        L27:
            if (r1.n == true) goto L30;
            FLogger.a.i("[ObricVoicePrintManagementActivity]", "startAuthentication: skip launching auth because activity is not started");
            this.this$0.U1(true, false);
            goto L30
        L22:
            if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L24;
            FLogger.a.i("[ObricVoicePrintManagementActivity]", "startAuthentication: skip launching auth because device is still locked");
            this.this$0.U1(true, false);
            this.this$0.Y1();
            goto L30
        L32:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ObricVoicePrintManagementActivity$startAuthentication$1(ObricVoicePrintManagementActivity r1, long r2, Continuation<? super ObricVoicePrintManagementActivity$startAuthentication$1> r4) {
        this.this$0 = r1;
        this.$requestId = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricVoicePrintManagementActivity$startAuthentication$1(this.this$0, this.$requestId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        FLogger.a.i("[ObricVoicePrintManagementActivity]", "requestAuthenticationJob, loop");
        MainCoroutineDispatcher r9 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$requestId, null);
        this.label = 2;
        if (BuildersKt.withContext(r9, r2, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        this.label = 1;
        if (DelayKt.delay(300, this) != r0) goto L13;
        return r0;
    }
}
