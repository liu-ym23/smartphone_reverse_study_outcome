package com.obric.assistant.ipc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.voice.c;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.concurrent.ConcurrentHashMap;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/ipc/SvaSdkIPCService;", "Landroid/app/Service;", "<init>", "()V", "onCreate", "", "onStartCommand", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SvaSdkIPCService extends Service {
    public static final a Companion = null;
    public static final String TAG = "SvaSdkIPCService";

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.ipc.SvaSdkIPCService$onStartCommand$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.ipc.SvaSdkIPCService$onStartCommand$1", f = "SvaSdkIPCService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $cmd;
        int label;

        public AnonymousClass1(int r1, Continuation<? super AnonymousClass1> r2) {
            this.$cmd = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$cmd, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            IpcMessenger.k(IpcMessenger.a, this.$cmd, 0, null, 14);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    @Override // android.app.Service
    public void onCreate() {
        FLogger.a.i(TAG, "SvaSdkIPCService onCreate...");
        HostStateSyncManager r0 = HostStateSyncManager.a;
        Context r1 = getApplicationContext();
        r0.getClass();
        HostStateSyncManager.a(r1);
        HostStateSyncManager.b("ipc_service_create");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        FLogger.a.i(TAG, "SvaSdkIPC onDestroy()");
    }

    public SvaSdkIPCService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        FLogger.a.i(TAG, "SvaSdkIPC onBind() ---> return binder");
        HostStateSyncManager r4 = HostStateSyncManager.a;
        Context r0 = getApplicationContext();
        r4.getClass();
        HostStateSyncManager.a(r0);
        HostStateSyncManager.b("ipc_service_bind");
        IpcMessenger.a.getClass();
        return IpcMessenger.j.getBinder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("SvaSdkIPC Service onStartCommand...intent ");
        if (r10 == null) goto L5;
        String r3 = r10.getAction();
    L6:
        r1.append(r3);
        r0.i(TAG, r1.toString());
        if (r10 == null) goto L9;
        String r2 = r10.getAction();
    L11:
        if (Intrinsics.areEqual(r2, "com.obric.assistant.sva.sdk.service.action") == false) goto L25;
        int r4 = r10.getIntExtra("command", -1);
        r0.i(TAG, "SvaSdkIPC Service onStartCommand...command is " + r4);
        if (r4 != 1) goto L15;
        IpcMessenger.j(IpcMessenger.a, 1, !((ConcurrentHashMap) wna.a.a).isEmpty() ? 1 : 0, c.b);
        goto L25
    L15:
        if (r4 != 2) goto L17;
        IpcMessenger.j(IpcMessenger.a, 2, 1 ^ (((ConcurrentHashMap) wna.a.a).isEmpty() ? 1 : 0), c.b);
        goto L25
    L17:
        if (r4 != 4) goto L19;
    L21:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r4, null), 3, null);
        goto L25
    L19:
        if (r4 == 7) goto L21;
    L25:
        return super.onStartCommand(r10, r11, r12);
    L9:
        r2 = null;
        goto L11
    L5:
        r3 = null;
        goto L6
    }
}
