package com.obric.assistant.interaction.impl.service;

import android.widget.Toast;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IAuthenticationOnLockScreenService;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\b\n\u0002\u0010\b\n\u0000*\u0002\u0013\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/obric/assistant/interaction/impl/service/AuthenticationOnLockScreenService;", "Lcom/obric/assistant/interaction/api/service/IAuthenticationOnLockScreenService;", "<init>", "()V", "TAG", "", "toastOutInterval", "", "timeOutInterval", "timer", "Ljava/util/Timer;", "onTimeOutCallBack", "Lkotlin/Function0;", "", "start", WindowEvent.Params.REASON, "timeout", "stop", "toastTask", "com/obric/assistant/interaction/impl/service/AuthenticationOnLockScreenService$toastTask$1", "getToastTask", "()Lcom/obric/assistant/interaction/impl/service/AuthenticationOnLockScreenService$toastTask$1;", "timerTask", "com/obric/assistant/interaction/impl/service/AuthenticationOnLockScreenService$timerTask$1", "getTimerTask", "()Lcom/obric/assistant/interaction/impl/service/AuthenticationOnLockScreenService$timerTask$1;", "startTimeoutTimer", "startToastTimer", "stopTimer", "showToast", "msgId", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthenticationOnLockScreenService implements IAuthenticationOnLockScreenService {
    public static final AuthenticationOnLockScreenService INSTANCE = null;
    private static final String TAG = "AuthenticationOnLockScreenService";
    private static Function0<Unit> onTimeOutCallBack = null;
    private static final long timeOutInterval = 10000;
    private static Timer timer = null;
    private static final long toastOutInterval = 5000;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.service.AuthenticationOnLockScreenService$showToast$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.service.AuthenticationOnLockScreenService$showToast$1", f = "AuthenticationOnLockScreenService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $msgId;
        int label;

        public AnonymousClass1(int r1, Continuation<? super AnonymousClass1> r2) {
            this.$msgId = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$msgId, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            Toast.makeText(AppHost.a.getApplication(), this.$msgId, 1).show();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        INSTANCE = new AuthenticationOnLockScreenService();
    }

    private AuthenticationOnLockScreenService() {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.assistant.interaction.impl.service.AuthenticationOnLockScreenService$timerTask$1] */
    private final AuthenticationOnLockScreenService$timerTask$1 getTimerTask() {
        return new AuthenticationOnLockScreenService$timerTask$1();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.assistant.interaction.impl.service.AuthenticationOnLockScreenService$toastTask$1] */
    private final AuthenticationOnLockScreenService$toastTask$1 getToastTask() {
        return new AuthenticationOnLockScreenService$toastTask$1();
    }

    private final void startTimeoutTimer() {
        stopTimer("startTimeoutTimer");
        PthreadTimer r0 = new PthreadTimer("AuthenticationOnLockScreen", false);
        r0.schedule(INSTANCE.getTimerTask(), 10000);
        timer = r0;
    }

    private final void startToastTimer() {
        stopTimer("startToastTimer");
        PthreadTimer r0 = new PthreadTimer("AuthenticationOnLockScreen", false);
        r0.schedule(INSTANCE.getToastTask(), toastOutInterval);
        timer = r0;
    }

    public static final /* synthetic */ Function0 access$getOnTimeOutCallBack$p() {
        return onTimeOutCallBack;
    }

    public static final /* synthetic */ void access$startTimeoutTimer(AuthenticationOnLockScreenService r0) {
        r0.startTimeoutTimer();
    }

    private final void showToast(int r7) {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(r7, null), 3, null);
    }

    private final void stopTimer(String r4) {
        FLogger.a.i(TAG, "stopTimer reason: " + r4);
        Timer r5 = timer;
        if (r5 == null) goto L6;
        r5.cancel();
        return;
    }

    @Override // com.obric.assistant.interaction.api.service.IAuthenticationOnLockScreenService
    public void stop(String r4) {
        Intrinsics.checkNotNullParameter(r4, WindowEvent.Params.REASON);
        FLogger.a.i(TAG, "stop reason: " + r4);
        stopTimer("onStop");
    }

    public static final /* synthetic */ void access$showToast(AuthenticationOnLockScreenService r0, int r1) {
        r0.showToast(r1);
    }

    @Override // com.obric.assistant.interaction.api.service.IAuthenticationOnLockScreenService
    public void start(String r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, WindowEvent.Params.REASON);
        Intrinsics.checkNotNullParameter(r5, "timeout");
        FLogger.a.i(TAG, "start reason: " + r4);
        startToastTimer();
        onTimeOutCallBack = r5;
    }
}
