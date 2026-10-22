package com.obric.assistant.activation.presentation.runtime.session.dispatch;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.service.voice.VoiceInteractionSession;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningChildCoordinator;
import com.obric.assistant.activation.presentation.runtime.manager.s;
import com.obric.assistant.activation.presentation.runtime.session.InteractionSessionProxy$controller$1;
import com.obric.assistant.activation.presentation.runtime.session.client.InteractionSessionProxyClient;
import com.obric.assistant.activation.presentation.runtime.session.client.b;
import com.obric.assistant.activation.presentation.runtime.session.client.h;
import com.obric.assistant.activation.presentation.runtime.session.client.j;
import com.obric.assistant.activation.presentation.runtime.session.client.k;
import com.obric.assistant.activation.presentation.runtime.session.client.l;
import com.obric.assistant.activation.presentation.runtime.session.client.m;
import com.obric.assistant.activation.presentation.runtime.session.client.n;
import com.obric.assistant.activation.presentation.runtime.session.client.o;
import com.obric.assistant.activation.presentation.runtime.session.client.p;
import com.obric.assistant.common.utils.i;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class InteractionSessionEventDispatcher {
    public static final InteractionSessionEventDispatcher a = null;
    public static final com.obric.assistant.activation.presentation.runtime.session.dispatch.a<a> b = null;
    public static Long c;

    public interface a {

        /* JADX INFO: renamed from: com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher$a$a, reason: collision with other inner class name */
        public static final class C0073a implements a {
            public final long a;
            public final VoiceInteractionSession.AssistState b;
            public final String c;

            public final boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof C0073a) == true) goto L8;
                return false;
            L8:
                C0073a r9 = (C0073a) r8;
                if (this.a == r9.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                long r0 = this.a;
                return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "Assist(sessionId=" + this.a + ", state=" + this.b + ')';
            }

            @Override // com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher.a
            public final String getName() {
                return this.c;
            }

            @Override // com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher.a
            public final long getSessionId() {
                return this.a;
            }

            public C0073a(long r2, VoiceInteractionSession.AssistState r4) {
                Intrinsics.checkNotNullParameter(r4, "state");
                this.a = r2;
                this.b = r4;
                this.c = "onHandleAssist";
            }
        }

        public static final class b implements a {
            public final long a;
            public final Bitmap b;

            public final boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof b) == true) goto L8;
                return false;
            L8:
                b r9 = (b) r8;
                if (this.a == r9.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            @Override // com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher.a
            public final String getName() {
                return "onHandleScreenshot";
            }

            public final int hashCode() {
                long r0 = this.a;
                int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
                Bitmap r2 = this.b;
                if (r2 != null) goto L5;
                int r3 = 0;
            L7:
                return r1 + r3;
            L5:
                r3 = r2.hashCode();
                goto L7
            }

            public final String toString() {
                return "Screenshot(sessionId=" + this.a + ", bitmap=" + this.b + ')';
            }

            @Override // com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher.a
            public final long getSessionId() {
                return this.a;
            }

            public b(long r1, Bitmap r3) {
                this.a = r1;
                this.b = r3;
            }
        }

        public static final class c implements a {
            public final long a;
            public final Bundle b;
            public final int c;
            public final String d;

            public final boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof c) == true) goto L8;
                return false;
            L8:
                c r9 = (c) r8;
                if (this.a == r9.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
                return false;
            L15:
                if (this.c == r9.c) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                long r0 = this.a;
                return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c;
            }

            public final String toString() {
                return "Show(sessionId=" + this.a + ", args=" + this.b + ", showFlags=" + this.c + ')';
            }

            @Override // com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher.a
            public final String getName() {
                return this.d;
            }

            @Override // com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher.a
            public final long getSessionId() {
                return this.a;
            }

            public c(long r2, Bundle r4, int r5) {
                Intrinsics.checkNotNullParameter(r4, "args");
                this.a = r2;
                this.b = r4;
                this.c = r5;
                this.d = "onShow";
            }
        }

        String getName();

        long getSessionId();
    }

    public InteractionSessionEventDispatcher() {
    }

    static {
        a = new InteractionSessionEventDispatcher();
        b = new com.obric.assistant.activation.presentation.runtime.session.dispatch.a();
    }

    public final synchronized void c(Context r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "context");     // Catch: Throwable -> L7
        Channel<InteractionSessionProxyClient.a> r1 = InteractionSessionProxyClient.a;     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r4, "context");     // Catch: Throwable -> L7
        final Context r5 = r4.getApplicationContext();     // Catch: Throwable -> L7
        InteractionSessionProxyClient.g("init", new b(r5));     // Catch: Throwable -> L7
        ObricListeningChildCoordinator r6 = ObricListeningChildCoordinator.a;     // Catch: Throwable -> L7
        final InteractionSessionEventDispatcher$init$1 r2 = new InteractionSessionEventDispatcher$init$1(this);     // Catch: Throwable -> L7
        r6.getClass();     // Catch: Throwable -> L7
        ObricListeningChildCoordinator.i(new s(r2));     // Catch: Throwable -> L7
        FLogger.a.i("InteractionSessionED", "dispatcher_initialized: activeSessionId=" + c + " waitingForAiKey=" + b.b);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean e(final long r6) {
        monitor-enter(this);
        Long r1 = c;     // Catch: Throwable -> L17
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L13;
        a("session_destroyed", Long.valueOf(r6));     // Catch: Throwable -> L17
        c = null;     // Catch: Throwable -> L17
    L14:
        InteractionSessionProxyClient.g("onSessionDestroyed", new h(r6));     // Catch: Throwable -> L17
        monitor-exit(this);
        return r2;
    L13:
        FLogger.a.i("InteractionSessionED", "stale_session_destroyed: incoming=" + r6 + " active=" + c);     // Catch: Throwable -> L17
        goto L14
    L8:
        if (r1.longValue() != r6) goto L10;
        r2 = true;
    L17:
        th = move-exception;
        throw th;
    }

    public static void a(String r5, Long r6) {
        com.obric.assistant.activation.presentation.runtime.session.dispatch.a<a> r0 = b;
        boolean r1 = r0.b;
        List<a> r2 = r0.b();
        r0.b = false;
        FLogger r3 = FLogger.a;
        r3.i("AiKeySessionEventGate", "gate_cleared: waitingBefore=" + r1 + " dropped=" + r2.size());
        r3.i("InteractionSessionED", "session_event_gate_cleared: reason=" + r5 + " sessionId=" + r6 + " dropped=" + r2.size());
    }

    public static void b(String r18, Integer r19, com.obric.assistant.activation.presentation.runtime.session.dispatch.a.b r20) {
        Iterator r2 = r20.c.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        a r3 = (a) r2.next();
        FLogger.a.w("InteractionSessionED", "gated_session_event_dropped: trigger=" + r18 + " dropped=" + r3.getName() + " sessionId=" + r3.getSessionId());
        goto L4
    L6:
        FLogger.a.i("InteractionSessionED", "session_event_gate_result: trigger=" + r18 + " invocationType=" + r19 + " buffered=" + r20.b + " released=" + r20.a.size() + " waiting=" + b.b);
        Iterator r0 = r20.a.iterator();
    L8:
        if (r0.hasNext() == false) goto L21;
        a r1 = (a) r0.next();
        FLogger.a.i("InteractionSessionED", "session_event_admitted: name=" + r1.getName() + " sessionId=" + r1.getSessionId());
        if ((r1 instanceof a.c) == false) goto L13;
        a.c r4 = (a.c) r1;
        r4.b.putLong("o_dispatch_to_main_process_time", SystemClock.uptimeMillis());
        Channel<InteractionSessionProxyClient.a> r5 = InteractionSessionProxyClient.a;
        final long r7 = r4.a;
        final Bundle r6 = r4.b;
        final int r9 = r4.c;
        Intrinsics.checkNotNullParameter(r6, "args");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        final int r10 = r6.getInt("invocation_type");
        final InteractionSessionProxyClient.b r11 = new InteractionSessionProxyClient.b("onShow", new j(r7, r6, r9));
        InteractionSessionProxyClient.g(r11.a, new k(r7, r9, r10, r11));
    L18:
        r0 = r0;
        goto L8
    L13:
        if ((r1 instanceof a.C0073a) == false) goto L16;
        Channel<InteractionSessionProxyClient.a> r8 = InteractionSessionProxyClient.a;
        a.C0073a r12 = (a.C0073a) r1;
        final long r13 = r12.a;
        VoiceInteractionSession.AssistState r14 = r12.b;
        Intrinsics.checkNotNullParameter(r14, "assistState");
        final int r15 = r14.getIndex();
        final int r16 = r14.getCount();
        final boolean r17 = r14.isFocused();
        final Bundle r110 = r14.getAssistData();
        final AssistStructure r111 = r14.getAssistStructure();
        final AssistContent r112 = r14.getAssistContent();
        final InteractionSessionProxyClient.b r21 = new InteractionSessionProxyClient.b("onHandleAssist", new l(r13, r15, r16, r17, r110, r111, r112));
        InteractionSessionProxyClient.g(r21.a, new m(r13, r15, r16, r17, r21));
        goto L18
    L16:
        if ((r1 instanceof a.b) == false) goto L20;
        Channel<InteractionSessionProxyClient.a> r22 = InteractionSessionProxyClient.a;
        a.b r23 = (a.b) r1;
        final long r24 = r23.a;
        final Bitmap r25 = r23.b;
        final InteractionSessionProxyClient.b r26 = new InteractionSessionProxyClient.b("onHandleScreenshot", new o(r24, r25));
        InteractionSessionProxyClient.g(r26.a, new p(r24, r25, r26));
        goto L18
    L20:
        throw new NoWhenBranchMatchedException();
    }

    public final synchronized void d(Context r7, final long r8, final InteractionSessionProxy$controller$1 r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "context");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r10, "controller");     // Catch: Throwable -> L18
        Long r1 = c;     // Catch: Throwable -> L18
        if (r1 != null) goto L7;
    L9:
        c = Long.valueOf(r8);     // Catch: Throwable -> L18
        FLogger r2 = FLogger.a;     // Catch: Throwable -> L18
        StringBuilder r4 = new StringBuilder("session_created: id=");     // Catch: Throwable -> L18
        r4.append(r8);     // Catch: Throwable -> L18
        r4.append(" replaced=");     // Catch: Throwable -> L18
        if (r1 != null) goto L12;
    L14:
        boolean r0 = false;
    L15:
        r4.append(r0);     // Catch: Throwable -> L18
        r2.i("InteractionSessionED", r4.toString());     // Catch: Throwable -> L18
        Channel<InteractionSessionProxyClient.a> r3 = InteractionSessionProxyClient.a;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r7, "context");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r10, "controller");     // Catch: Throwable -> L18
        final Context r9 = r7.getApplicationContext();     // Catch: Throwable -> L18
        InteractionSessionProxyClient.g("onSessionCreated", new n(r9, r8, r10));     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L12:
        if (r1.longValue() == r8) goto L14;
        r0 = true;
        goto L15
    L7:
        if (r1.longValue() == r8) goto L9;
        a("session_replaced", r1);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final synchronized void f(long r4, Bundle r6, int r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "args");     // Catch: Throwable -> L13
        i.a r0 = i.a("InteractionSessionED_onShow");     // Catch: Throwable -> L13
        int r1 = r6.getInt("invocation_type", Integer.MIN_VALUE);     // Catch: Throwable -> L9
        a.c r2 = new a.c(r4, r6, r7);     // Catch: Throwable -> L9
        InteractionSessionEventDispatcher r5 = a;     // Catch: Throwable -> L9
        String r8 = r2.d;     // Catch: Throwable -> L9
        Integer r9 = Integer.valueOf(r1);     // Catch: Throwable -> L9
        com.obric.assistant.activation.presentation.runtime.session.dispatch.a.b r10 = b.d(r1, r2);     // Catch: Throwable -> L9
        r5.getClass();     // Catch: Throwable -> L9
        b(r8, r9, r10);     // Catch: Throwable -> L9
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.a();     // Catch: Throwable -> L13
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        if (r0 == null) goto L12;
        r0.a();     // Catch: Throwable -> L13
    L12:
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
