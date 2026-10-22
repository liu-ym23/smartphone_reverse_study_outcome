package com.obric.assistant.activation.presentation.runtime.session;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.service.voice.VoiceInteractionSession;
import android.view.View;
import bba.b;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningChildCoordinator;
import com.obric.assistant.activation.presentation.runtime.manager.ObricMainProcessStateManager;
import com.obric.assistant.activation.presentation.runtime.manager.f;
import com.obric.assistant.activation.presentation.runtime.manager.l;
import com.obric.assistant.activation.presentation.runtime.precheck.ObricChildListeningPrecheck;
import com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher;
import com.obric.assistant.common.utils.i;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class InteractionSessionProxy extends VoiceInteractionSession {
    public static final AtomicLong d = null;
    public final long a;
    public final CoroutineScope b;
    public final InteractionSessionProxy$controller$1 c;

    public static final class a {
    }

    static {
        d = new AtomicLong(SystemClock.elapsedRealtimeNanos());
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onCreate() {
        i.a r3 = i.a("InteractionSessionProxy_onCreate");
        FLogger r4 = FLogger.a;     // Catch: Throwable -> L7
        r4.i("InteractionSessionProxy", "onCreate start, id=" + this.a);     // Catch: Throwable -> L7
        super.onCreate();     // Catch: Throwable -> L7
        final Context r2 = getContext();     // Catch: Throwable -> L7
        ObricListeningChildCoordinator r5 = ObricListeningChildCoordinator.a;     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r2, "context");     // Catch: Throwable -> L7
        final b r6 = new b(r2);     // Catch: Throwable -> L7
        final ObricChildListeningPrecheck r7 = new ObricChildListeningPrecheck(r2);     // Catch: Throwable -> L7
        ObricListeningChildCoordinator r8 = ObricListeningChildCoordinator.a;     // Catch: Throwable -> L7
        Function0 r9 = new l(r2, r7, r6);     // Catch: Throwable -> L7
        r8.getClass();     // Catch: Throwable -> L7
        ObricListeningChildCoordinator.i(r9);     // Catch: Throwable -> L7
        InteractionSessionEventDispatcher r10 = InteractionSessionEventDispatcher.a;     // Catch: Throwable -> L7
        r10.c(getContext());     // Catch: Throwable -> L7
        r10.d(getContext(), this.a, this.c);     // Catch: Throwable -> L7
        r4.i("InteractionSessionProxy", "onCreate complete, id=" + this.a);     // Catch: Throwable -> L7
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L7
        if (r3 == null) goto L13;
        r3.a();
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (r3 == null) goto L10;
        r3.a();
    L10:
        throw th;
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final View onCreateContentView() {
        FLogger.a.i("InteractionSessionProxy", "onCreateContentView, id=" + this.a);
        return null;
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onDestroy() {
        i.a r3 = i.a("InteractionSessionProxy_onDestroy");
        FLogger r4 = FLogger.a;     // Catch: Throwable -> L10
        r4.i("InteractionSessionProxy", "onDestroy start, id=" + this.a);     // Catch: Throwable -> L10
        if (InteractionSessionEventDispatcher.a.e(this.a) == false) goto L6;
        ObricListeningChildCoordinator r2 = ObricListeningChildCoordinator.a;     // Catch: Throwable -> L10
        Function0 r5 = new f();     // Catch: Throwable -> L10
        r2.getClass();     // Catch: Throwable -> L10
        ObricListeningChildCoordinator.i(r5);     // Catch: Throwable -> L10
    L6:
        super.onDestroy();     // Catch: Throwable -> L10
        r4.i("InteractionSessionProxy", "onDestroy complete, id=" + this.a);     // Catch: Throwable -> L10
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L10
        if (r3 == null) goto L16;
        r3.a();
        return;
    L16:
        return;
    L10:
        th = move-exception;
        if (r3 == null) goto L13;
        r3.a();
    L13:
        throw th;
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [com.obric.assistant.activation.presentation.runtime.session.InteractionSessionProxy$controller$1] */
    public InteractionSessionProxy(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        long r0 = d.incrementAndGet();
        this.a = r0;
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.c = new InteractionSessionProxy$controller$1(this);
        FLogger.a.i("InteractionSessionProxy", "constructor, id=" + r0);
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onHandleAssist(VoiceInteractionSession.AssistState r8) {
        Intrinsics.checkNotNullParameter(r8, "assistState");
        i.a r1 = i.a("InteractionSessionProxy_onHandleAssist");
        FLogger.a.i("InteractionSessionProxy", "onHandleAssist, id=" + this.a + ", index=" + r8.getIndex() + ", count=" + r8.getCount() + ", focused=" + r8.isFocused());     // Catch: Throwable -> L14
        super.onHandleAssist(r8);     // Catch: Throwable -> L14
        InteractionSessionEventDispatcher r0 = InteractionSessionEventDispatcher.a;     // Catch: Throwable -> L14
        long r2 = this.a;     // Catch: Throwable -> L14
        monitor-enter(r0);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r8, "assistState");     // Catch: Throwable -> L11
        InteractionSessionEventDispatcher.a.C0073a r4 = new InteractionSessionEventDispatcher.a.C0073a(r2, r8);     // Catch: Throwable -> L11
        InteractionSessionEventDispatcher.b(r4.c, null, InteractionSessionEventDispatcher.b.c(r4));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L14
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L14
        if (r1 == null) goto L21;
        r1.a();
        return;
    L21:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (r1 == null) goto L17;
        r1.a();
    L17:
        throw th;
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onHandleScreenshot(Bitmap r8) {
        i.a r1 = i.a("InteractionSessionProxy_onHandleScreenshot");
        FLogger r2 = FLogger.a;     // Catch: Throwable -> L18
        StringBuilder r4 = new StringBuilder("onHandleScreenshot, id=");     // Catch: Throwable -> L18
        r4.append(this.a);     // Catch: Throwable -> L18
        r4.append(", hasScreenshot=");     // Catch: Throwable -> L18
        if (r8 == null) goto L6;
        boolean r0 = true;
    L7:
        r4.append(r0);     // Catch: Throwable -> L18
        r2.i("InteractionSessionProxy", r4.toString());     // Catch: Throwable -> L18
        super.onHandleScreenshot(r8);     // Catch: Throwable -> L18
        InteractionSessionEventDispatcher r3 = InteractionSessionEventDispatcher.a;     // Catch: Throwable -> L18
        long r5 = this.a;     // Catch: Throwable -> L18
        monitor-enter(r3);     // Catch: Throwable -> L18
        InteractionSessionEventDispatcher.a.b r6 = new InteractionSessionEventDispatcher.a.b(r5, r8);     // Catch: Throwable -> L15
        InteractionSessionEventDispatcher.b("onHandleScreenshot", null, InteractionSessionEventDispatcher.b.c(r6));     // Catch: Throwable -> L15
        monitor-exit(r3);     // Catch: Throwable -> L18
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L18
        if (r1 == null) goto L25;
        r1.a();
        return;
    L25:
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L6:
        r0 = false;
    L18:
        th = move-exception;
        if (r1 == null) goto L21;
        r1.a();
    L21:
        throw th;
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onPrepareShow(Bundle r8, int r9) {
        i.a r1 = i.a("InteractionSessionProxy_onPrepareShow");
        FLogger r2 = FLogger.a;     // Catch: Throwable -> L19
        StringBuilder r4 = new StringBuilder("onPrepareShow, id=");     // Catch: Throwable -> L19
        r4.append(this.a);     // Catch: Throwable -> L19
        r4.append(", invocationType=");     // Catch: Throwable -> L19
        Integer r5 = null;
        if (r8 == null) goto L7;
        Intrinsics.checkNotNullParameter(r8, "<this>");     // Catch: Throwable -> L19
        Integer r6 = Integer.valueOf(r8.getInt("invocation_type"));     // Catch: Throwable -> L19
    L8:
        r4.append(r6);     // Catch: Throwable -> L19
        r4.append(", showSessionId=");     // Catch: Throwable -> L19
        if (r8 == null) goto L11;
        Intrinsics.checkNotNullParameter(r8, "<this>");     // Catch: Throwable -> L19
        r5 = Integer.valueOf(r8.getInt("android.service.voice.SHOW_SESSION_ID"));     // Catch: Throwable -> L19
    L11:
        r4.append(r5);     // Catch: Throwable -> L19
        r4.append(", showFlags=");     // Catch: Throwable -> L19
        r4.append(r9);     // Catch: Throwable -> L19
        r4.append(", hasArgs=");     // Catch: Throwable -> L19
        if (r8 == null) goto L14;
        boolean r7 = true;
    L15:
        r4.append(r7);     // Catch: Throwable -> L19
        r2.i("InteractionSessionProxy", r4.toString());     // Catch: Throwable -> L19
        super.onPrepareShow(r8, r9);     // Catch: Throwable -> L19
        setUiEnabled(false);     // Catch: Throwable -> L19
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L19
        if (r1 == null) goto L25;
        r1.a();
        return;
    L25:
        return;
    L14:
        r7 = false;
        goto L15
    L7:
        r6 = null;
    L19:
        th = move-exception;
        if (r1 == null) goto L22;
        r1.a();
    L22:
        throw th;
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onShow(Bundle r10, int r11) {
        i.a r4 = i.a("InteractionSessionProxy_onShow");
        if (r10 != null) goto L37;
    L7:
        FLogger r5 = FLogger.a;     // Catch: Throwable -> L5
        StringBuilder r6 = new StringBuilder("onShow, id=");     // Catch: Throwable -> L5
        r6.append(this.a);     // Catch: Throwable -> L5
        r6.append(", invocationType=");     // Catch: Throwable -> L5
        Integer r7 = null;
        if (r10 == null) goto L11;
        Intrinsics.checkNotNullParameter(r10, "<this>");     // Catch: Throwable -> L5
        Integer r8 = Integer.valueOf(r10.getInt("invocation_type"));     // Catch: Throwable -> L5
    L12:
        r6.append(r8);     // Catch: Throwable -> L5
        r6.append(", showSessionId=");     // Catch: Throwable -> L5
        if (r10 == null) goto L15;
        Intrinsics.checkNotNullParameter(r10, "<this>");     // Catch: Throwable -> L5
        r7 = Integer.valueOf(r10.getInt("android.service.voice.SHOW_SESSION_ID"));     // Catch: Throwable -> L5
    L15:
        r6.append(r7);     // Catch: Throwable -> L5
        r6.append(", showFlags=");     // Catch: Throwable -> L5
        r6.append(r11);     // Catch: Throwable -> L5
        r6.append(", hasArgs=");     // Catch: Throwable -> L5
        if (r10 == null) goto L18;
        boolean r9 = true;
    L19:
        r6.append(r9);     // Catch: Throwable -> L5
        r5.i("InteractionSessionProxy", r6.toString());     // Catch: Throwable -> L5
        super.onShow(r10, r11);     // Catch: Throwable -> L5
        if (r10 != null) goto L24;
        r5.e("InteractionSessionProxy", "drop onShow with null args, id=" + this.a);     // Catch: Throwable -> L31
    L27:
        r5.i("InteractionSessionProxy", "hide framework Session after onShow, id=" + this.a);     // Catch: Throwable -> L5
        onHide();     // Catch: Throwable -> L5
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L5
        if (r4 == null) goto L40;
        r4.a();
        return;
    L40:
        return;
    L24:
        if (r10.getInt("REQUEST_PULL_UP_ONCE") != 1) goto L26;
        r5.i("InteractionSessionProxy", "ignore pull up once onShow, id=" + this.a);     // Catch: Throwable -> L31
        goto L27
    L26:
        ObricListeningChildCoordinator.a.getClass();     // Catch: Throwable -> L31
        ObricListeningChildCoordinator.j(r10);     // Catch: Throwable -> L31
        InteractionSessionEventDispatcher.a.f(this.a, r10, r11);     // Catch: Throwable -> L31
        ObricScreenshotRequester.a.getClass();     // Catch: Throwable -> L31
        ObricScreenshotRequester.a(r10);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        FLogger.a.i("InteractionSessionProxy", "hide framework Session after onShow, id=" + this.a);     // Catch: Throwable -> L5
        onHide();     // Catch: Throwable -> L5
        throw th;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        if (r4 == null) goto L36;
        r4.a();
    L36:
        throw th;
    L18:
        r9 = false;
        goto L19
    L11:
        r8 = null;
        goto L12
    L37:
        r10.putBoolean("o_main_process_ready", ((Boolean) ObricMainProcessStateManager.c.getValue()).booleanValue());     // Catch: Throwable -> L5
        goto L7
    }
}
