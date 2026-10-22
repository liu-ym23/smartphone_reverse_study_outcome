package com.obric.assistant.activation.presentation.runtime.session;

import android.app.SearchManager;
import android.os.Build;
import android.os.Bundle;
import com.larus.im.FlowRuntime;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.activation.presentation.runtime.session.ObricScreenshotRequester$request$1", f = "ObricScreenshotRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricScreenshotRequester$request$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $invocationType;
    final /* synthetic */ boolean $screenshotEnabled;
    final /* synthetic */ String $trigger;
    int label;

    public ObricScreenshotRequester$request$1(String r1, int r2, boolean r3, Continuation<? super ObricScreenshotRequester$request$1> r4) {
        this.$trigger = r1;
        this.$invocationType = r2;
        this.$screenshotEnabled = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricScreenshotRequester$request$1(this.$trigger, this.$invocationType, this.$screenshotEnabled, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r11);
        ObricScreenshotRequester r12 = ObricScreenshotRequester.a;
        String r0 = this.$trigger;
        int r1 = this.$invocationType;
        boolean r2 = this.$screenshotEnabled;
        r12.getClass();
        if (r2 == false) goto L7;
        int r3 = 3;
    L9:
        if (Build.VERSION.SDK_INT < 37) goto L11;
        r3 = r3 | 256;
    L11:
        FLogger.a.i("ObricScreenshotRequester", "request_started: trigger=" + r0 + " invocationType=" + r1 + " screenshotEnabled=" + r2 + " flags=" + r3);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        Object r5 = FlowRuntime.a().getApplication().getSystemService("search");     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.app.SearchManager");     // Catch: Throwable -> L14
        SearchManager r6 = (SearchManager) r5;     // Catch: Throwable -> L14
        Method r7 = r6.getClass().getMethod("launchAssist", new Class[]{Bundle.class});     // Catch: Throwable -> L14
        Bundle r8 = new Bundle();     // Catch: Throwable -> L14
        r8.putInt("custom_show_flags", r3);     // Catch: Throwable -> L14
        r8.putInt("invocation_type", -100);     // Catch: Throwable -> L14
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L14
        Object r13 = Result.constructor-impl(r7.invoke(r6, new Object[]{r8}));     // Catch: Throwable -> L14
    L17:
        if (Result.isSuccess-impl(r13) == false) goto L19;
        FLogger.a.i("ObricScreenshotRequester", "request_succeeded: trigger=" + r0 + " flags=" + r3);
    L19:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L23;
        FLogger.a.w("ObricScreenshotRequester", "request_failed: trigger=" + r0 + " flags=" + r3 + " message=" + r14.getMessage(), r14);
    L23:
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L7:
        r3 = 1;
        goto L9
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
