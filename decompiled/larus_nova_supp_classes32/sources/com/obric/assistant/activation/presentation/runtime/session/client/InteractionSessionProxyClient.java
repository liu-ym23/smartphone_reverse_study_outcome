package com.obric.assistant.activation.presentation.runtime.session.client;

import android.content.ComponentName;
import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.larus.utils.logger.FLogger;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService;
import com.obric.assistant.activation.presentation.contract.ipc.VoiceInteractionSessionController;
import com.obric.assistant.activation.presentation.runtime.manager.ObricInteractorPresentationBridge$binder$1;
import com.obric.assistant.activation.presentation.runtime.service.ObricMainProcessVoiceInteractionGatewayService;
import java.util.ArrayDeque;
import java.util.concurrent.CancellationException;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class InteractionSessionProxyClient {
    public static final Channel<a> a = null;
    public static final CoroutineScope b = null;
    public static com.obric.assistant.activation.presentation.runtime.session.client.a c;
    public static Context d;
    public static Long e;
    public static VoiceInteractionSessionController f;
    public static ObricInteractorPresentationBridge$binder$1 g;
    public static IInteractionSessionProxy h;
    public static Long i;
    public static boolean j;
    public static final ArrayDeque<b> k = null;

    /* JADX INFO: renamed from: com.obric.assistant.activation.presentation.runtime.session.client.InteractionSessionProxyClient$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.activation.presentation.runtime.session.client.InteractionSessionProxyClient$1", f = "InteractionSessionProxyClient.kt", i = {}, l = {MessageContentType.CONTENT_TYPE_LYRICS_TO_SONG}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0034 -> B:13:0x0039). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ChannelIterator r2 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r10);
            ChannelIterator r3 = r2;
            Object r4 = r0;
            AnonymousClass1 r5 = this;
        L14:
            if (((Boolean) r10).booleanValue() == false) goto L26;
            a r11 = (a) r3.next();
            r11.b.invoke();     // Catch: Exception -> L18 CancellationException -> L20
        L23:
            AnonymousClass1 r12 = r5;
            r0 = r4;
            ChannelIterator r6 = r3;
        L9:
            r12.L$0 = r6;
            r12.label = 1;
            Object r7 = r6.hasNext(r12);
            if (r7 != r0) goto L12;
            return r0;
        L12:
            Object r8 = r0;
            r5 = r12;
            r10 = r7;
            r3 = r6;
            r4 = r8;
            goto L14
        L20:
            e = move-exception;
            throw e;
        L18:
            e = move-exception;
            FLogger.a.w("InteractionSessionPC", "command " + r11.a + " failed", e);
            goto L23
        L26:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            r6 = InteractionSessionProxyClient.a.iterator();
            r12 = this;
            goto L9
        }
    }

    public static final class a {
        public final String a;
        public final Function0<Unit> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ClientCommand(name=" + this.a + ", action=" + this.b + ')';
        }

        public a(String r2, Function0<Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, EasyGoDbTable.Server.NAME);
            Intrinsics.checkNotNullParameter(r3, "action");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final String a;
        public final Function1<IInteractionSessionProxy, Unit> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PendingSessionEvent(name=" + this.a + ", dispatch=" + this.b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r2, Function1<? super IInteractionSessionProxy, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, EasyGoDbTable.Server.NAME);
            Intrinsics.checkNotNullParameter(r3, "dispatch");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        CoroutineScope r2 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        b = r2;
        k = new ArrayDeque();
        BuildersKt.launch$default(r2, null, null, new AnonymousClass1(null), 3, null);
    }

    public static String a() {
        StringBuilder r0 = new StringBuilder("activeSessionId=");
        r0.append(e);
        r0.append(", serviceAlive=");
        com.obric.assistant.activation.presentation.runtime.session.client.a r1 = c;
        if (r1 == null) goto L5;
        IObricInteractorBridgeService r2 = r1.c();
    L6:
        boolean r3 = false;
        if (r2 == null) goto L9;
        boolean r4 = true;
    L10:
        r0.append(r4);
        r0.append(", sessionAlive=");
        if (b() == null) goto L13;
        r3 = true;
    L13:
        r0.append(r3);
        r0.append(", pending=");
        r0.append(k.size());
        return r0.toString();
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static IInteractionSessionProxy b() {
        IInteractionSessionProxy r0 = h;
        if (r0 != null) goto L5;
    L7:
        return null;
    L5:
        if (r0.asBinder().isBinderAlive() == false) goto L7;
        return r0;
    }

    public static void c(b r7) {
        if (j == true) goto L6;
        FLogger.a.i("InteractionSessionPC", "drop " + r7.a + ": client is not initialized");
        return;
    L6:
        IInteractionSessionProxy r0 = b();
        if (r0 != null) goto L11;
        d(r7);
        FLogger.a.i("InteractionSessionPC", r7.a + " queued, size=" + k.size());
        f(r7.a);
        return;
    L11:
        if (e(r0) == true) goto L27;
        d(r7);
        FLogger.a.i("InteractionSessionPC", r7.a + " queued after handshake failure, size=" + k.size());
        StringBuilder r1 = new StringBuilder();
        r1.append(r7.a);
        r1.append("_handshake");
        f(r1.toString());
        return;
    L27:
        r7.b.invoke(r0);     // Catch: RemoteException -> L16
        FLogger.a.i("InteractionSessionPC", r7.a + " dispatched");     // Catch: RemoteException -> L16
        return;
    L16:
        e = move-exception;
        if ((e instanceof DeadObjectException) == false) goto L25;
        ArrayDeque<b> r2 = k;
        if (r2.size() < 32) goto L22;
        b r3 = r2.removeLast();
        FLogger.a.w("InteractionSessionPC", "pending queue full, drop newest " + r3.a + " to preserve failed " + r7.a);
    L22:
        r2.addFirst(r7);
        FLogger.a.w("InteractionSessionPC", r7.a + " hit dead Session Binder, queued for replay, pending=" + r2.size(), e);
        h = null;
        i = null;
        com.obric.assistant.activation.presentation.runtime.session.client.a r8 = c;
        if (r8 == null) goto L29;
        r8.d(d);
        return;
    L29:
        return;
    L25:
        FLogger.a.w("InteractionSessionPC", r7.a + " dispatch failed and dropped", e);
    }

    public static void d(b r5) {
        ArrayDeque<b> r0 = k;
        if (r0.size() < 32) goto L5;
        b r1 = r0.removeFirst();
        FLogger.a.w("InteractionSessionPC", "pending queue full, drop oldest " + r1.a + ", capacity=32");
    L5:
        r0.addLast(r5);
    }

    public static boolean e(IInteractionSessionProxy r9) {
        Long r2 = e;
        if (r2 == null) goto L23;
        long r4 = r2.longValue();
        VoiceInteractionSessionController r3 = f;
        if (r3 != null) goto L7;
        return true;
    L7:
        Long r6 = i;
        if (r6 != null) goto L11;
    L21:
        r9.onSessionCreated(r4, r3);     // Catch: RemoteException -> L15
        i = Long.valueOf(r4);     // Catch: RemoteException -> L15
        FLogger.a.i("InteractionSessionPC", "active session handshake dispatched on demand, id=" + r4);     // Catch: RemoteException -> L15
        return true;
    L15:
        e = move-exception;
        FLogger.a.w("InteractionSessionPC", "session handshake failed, id=" + r4, e);
        h = null;
        i = null;
        com.obric.assistant.activation.presentation.runtime.session.client.a r10 = c;
        if (r10 == null) goto L19;
        r10.d(d);
    L19:
        return false;
    L11:
        if (r6.longValue() != r4) goto L21;
        return true;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.obric.assistant.activation.presentation.runtime.session.client.c] */
    public static void f(String r5) {
        Context r0 = d;
        if (r0 != null) goto L6;
        FLogger.a.e("InteractionSessionPC", "cannot bind main process: application context is null, reason=" + r5);
        return;
    L6:
        FLogger r1 = FLogger.a;
        r1.i("InteractionSessionPC", "main process connection requested, reason=" + r5);
        if (c != null) goto L20;
        r1.i("InteractionSessionPC", "create service connection with class reference, component=".concat(ObricMainProcessVoiceInteractionGatewayService.class.getName()));
        com.obric.assistant.activation.presentation.runtime.session.client.a.C0072a r6 = com.obric.assistant.activation.presentation.runtime.session.client.a.i;
        ComponentName r2 = new ComponentName(r0, ObricMainProcessVoiceInteractionGatewayService.class);
        Intrinsics.checkNotNullParameter(r2, "connName");
        com.obric.assistant.activation.presentation.runtime.session.client.a r3 = com.obric.assistant.activation.presentation.runtime.session.client.a.j;
        if (r3 != 0) goto L19;
        monitor-enter(r6);
        com.obric.assistant.activation.presentation.runtime.session.client.a r4 = com.obric.assistant.activation.presentation.runtime.session.client.a.j;     // Catch: Throwable -> L16
        r3 = r4;
        if (r4 != null) goto L14;
        com.obric.assistant.activation.presentation.runtime.session.client.a r7 = new com.obric.assistant.activation.presentation.runtime.session.client.a(r2);     // Catch: Throwable -> L16
        com.obric.assistant.activation.presentation.runtime.session.client.a.j = r7;     // Catch: Throwable -> L16
        r3 = r7;
    L14:
        monitor-exit(r6);
    L16:
        th = move-exception;
        throw th;
    L19:
        r3.f(new c());
        r3.e(new d());
        c = r3;
    L20:
        r1.i("InteractionSessionPC", "ensure service connection, " + a());
        com.obric.assistant.activation.presentation.runtime.session.client.a r8 = c;
        if (r8 == null) goto L26;
        r8.a(r0);
        return;
    }

    public static void g(String r3, Function0 r4) {
        Object r5 = a.trySend-JP2dKIU(new a(r3, r4));
        kotlinx.coroutines.channels.g.c r0 = kotlinx.coroutines.channels.g.b;
        if ((r5 instanceof kotlinx.coroutines.channels.g.c) == false) goto L9;
        FLogger r1 = FLogger.a;
        String r2 = "enqueue command failed, name=".concat(r3);
        Throwable r6 = kotlinx.coroutines.channels.g.a(r5);
        if (r6 != null) goto L7;
        r6 = new IllegalStateException("command queue rejected ".concat(r3));
    L7:
        r1.w("InteractionSessionPC", r2, r6);
        return;
    }
}
