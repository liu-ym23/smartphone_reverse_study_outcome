package com.obric.assistant.authenticationsession;

import android.os.CancellationSignal;
import androidx.appcompat.app.AppCompatActivity;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.n4;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.authenticationsession.SessionAuthenticationServiceImpl$biometricAuthenticate$1$1$onActivityStart$1", f = "SessionAuthenticationServiceImpl.kt", i = {}, l = {926, 944}, m = "invokeSuspend", n = {}, s = {})
public final class SessionAuthenticationServiceImpl$biometricAuthenticate$1$1$onActivityStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ Function0<Result<Unit>> $authenticateAction;
    final /* synthetic */ n4 $callback;
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ z0<Boolean> $isAuthFinished;
    final /* synthetic */ boolean $isChatWindowShowing;
    final /* synthetic */ boolean $waitAiFingerprintUnlockBeforeAuthenticate;
    int label;
    final /* synthetic */ SessionAuthenticationServiceImpl this$0;

    /* JADX INFO: renamed from: com.obric.assistant.authenticationsession.SessionAuthenticationServiceImpl$biometricAuthenticate$1$1$onActivityStart$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.authenticationsession.SessionAuthenticationServiceImpl$biometricAuthenticate$1$1$onActivityStart$1$1", f = "SessionAuthenticationServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(r3);
            r0.Z$0 = ((Boolean) r2).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Boolean> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxBoolean(this.Z$0);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public SessionAuthenticationServiceImpl$biometricAuthenticate$1$1$onActivityStart$1(CancellationSignal r1, boolean r2, SessionAuthenticationServiceImpl r3, AppCompatActivity r4, z0<Boolean> r5, n4 r6, boolean r7, Function0<Result<Unit>> r8, Continuation<? super SessionAuthenticationServiceImpl$biometricAuthenticate$1$1$onActivityStart$1> r9) {
        this.$cancellationSignal = r1;
        this.$waitAiFingerprintUnlockBeforeAuthenticate = r2;
        this.this$0 = r3;
        this.$activity = r4;
        this.$isAuthFinished = r5;
        this.$callback = r6;
        this.$isChatWindowShowing = r7;
        this.$authenticateAction = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new SessionAuthenticationServiceImpl$biometricAuthenticate$1$1$onActivityStart$1(this.$cancellationSignal, this.$waitAiFingerprintUnlockBeforeAuthenticate, this.this$0, this.$activity, this.$isAuthFinished, this.$callback, this.$isChatWindowShowing, this.$authenticateAction, r12);
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
        boolean r2 = false;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L37:
        FLogger.a.i("SessionAuthenticationServiceImpl", "auth finished, finish helper activity");
        if (this.$isChatWindowShowing == false) goto L42;
        IAssistantChatWindow r9 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r9 == null) goto L42;
        IAssistantChatWindow.DefaultImpls.pop$default(r9, null, 1, null);
    L42:
        this.$activity.finish();
    L45:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L20:
        if (((Boolean) r8).booleanValue() == false) goto L23;
        r2 = true;
    L23:
        if (this.$cancellationSignal.isCanceled() == false) goto L26;
        FLogger.a.i("SessionAuthenticationServiceImpl", "onActivityStart, cancellationSignal is canceled after waiting");
        this.$activity.finish();
        return Unit.INSTANCE;
    L26:
        if (r2 == false) goto L34;
        FLogger.a.i("SessionAuthenticationServiceImpl", "onActivityStart: device unlocked by ai fingerprint, skip authenticate");
        this.$isAuthFinished.setValue(Boxing.boxBoolean(true));
        this.$callback.onAuthenticationPass();
        if (this.$isChatWindowShowing == false) goto L32;
        IAssistantChatWindow r10 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r10 == null) goto L32;
        IAssistantChatWindow.DefaultImpls.pop$default(r10, null, 1, null);
    L32:
        this.$activity.finish();
        return Unit.INSTANCE;
    L34:
        this.$authenticateAction.invoke();
        FLogger.a.i("SessionAuthenticationServiceImpl", "wait for auth finished");
        z0<Boolean> r11 = this.$isAuthFinished;
        AnonymousClass1 r3 = new AnonymousClass1(null);
        this.label = 2;
        if (kotlinx.coroutines.flow.e.t(r11, r3, this) != r0) goto L37;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        if (this.$cancellationSignal.isCanceled() == false) goto L13;
        FLogger.a.i("SessionAuthenticationServiceImpl", "onActivityStart, cancellationSignal is canceled");
        goto L45
    L13:
        if (this.$waitAiFingerprintUnlockBeforeAuthenticate == false) goto L23;
        SessionAuthenticationServiceImpl r12 = this.this$0;
        int r4 = SessionAuthenticationServiceImpl.r;
        r12.c("isAiFingerprintExistCached", false);
        if (Intrinsics.areEqual(r12.n, Boolean.TRUE) == false) goto L23;
        SessionAuthenticationServiceImpl r13 = this.this$0;
        CancellationSignal r5 = this.$cancellationSignal;
        this.label = 1;
        r8 = SessionAuthenticationServiceImpl.a(r13, r5, this);
        if (r8 != r0) goto L20;
        return r0;
    }
}
