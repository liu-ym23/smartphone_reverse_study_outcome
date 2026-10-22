package com.obric.aiproactive.ui.voice;

import android.content.Context;
import com.obric.aivoice.sdk.AIVoiceConfig;
import com.obric.aivoice.sdk.AIVoiceManager;
import com.obric.aivoice.sdk.AIVoiceTask;
import com.obric.aivoice.sdk.IAsrListener;
import com.obric.aivoice.sdk.IConnectListener;
import com.obric.aivoice.sdk.IOfflineServerListener;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0007J\"\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00052\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bJ\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/obric/aiproactive/ui/voice/AiVoiceSdkRuntime;", "", "<init>", "()V", "TAG", "", "COMPAT_APP_ID", "", "COMPAT_PROJECT_ID", "asrCallbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Function1;", "", "connectionLock", "Ljava/lang/Object;", "initialized", "", "listenerRegistered", "connected", "isConnected", "()Z", "initialize", "context", "Landroid/content/Context;", "awaitConnected", "timeoutMs", "registerAsrCallback", "taskId", "callback", "unregisterAsrCallback", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6903a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Function1<String, Unit>> f6904b = null;
    private static final Object c = null;
    private static volatile boolean d;
    private static volatile boolean e;
    private static volatile boolean f;

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.voice.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/aiproactive/ui/voice/AiVoiceSdkRuntime$initialize$1", "Lcom/obric/aivoice/sdk/IAsrListener;", "onAsrResponse", "", "taskId", "", ChatMessage.TYPE_RESPONSE, "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0317a implements IAsrListener {
        C0317a() {
        }

        public void onAsrResponse(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, "taskId");
            Intrinsics.checkNotNullParameter(r8, ChatMessage.TYPE_RESPONSE);
            Function1 r6 = (Function1) ZeusTransformUtils.preCheckCast(a.a().get(r7), Function1.class, "com.obric.memorydata.plugin");
            IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r9 = new StringBuilder().append("ASR callback received matched=");
            if (r6 == null) goto L5;
            boolean r1 = true;
        L6:
            IRunLog.a.a(r0, "AiVoiceSdkRuntime", r9.append(r1).toString(), false, 4, null);
            if (r6 == null) goto L10;
            r6.invoke(r8);
            return;
        L10:
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/aiproactive/ui/voice/AiVoiceSdkRuntime$initialize$2", "Lcom/obric/aivoice/sdk/IConnectListener;", "onServerConnected", "", "onServerDisconnected", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements IConnectListener {
        b() {
        }

        public void onServerConnected() {
            Object r6 = a.b();
            monitor-enter(r6);
            a r0 = a.f6903a;     // Catch: Throwable -> L8
            a.a(true);     // Catch: Throwable -> L8
            a.b().notifyAll();     // Catch: Throwable -> L8
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r6);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiVoiceSdkRuntime", "AIVoice service connected", false, 4, null);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void onServerDisconnected() {
            Object r6 = a.b();
            monitor-enter(r6);
            a r0 = a.f6903a;     // Catch: Throwable -> L8
            a.a(false);     // Catch: Throwable -> L8
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r6);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiVoiceSdkRuntime", "AIVoice service disconnected", null, 4, null);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/aiproactive/ui/voice/AiVoiceSdkRuntime$initialize$3", "Lcom/obric/aivoice/sdk/IOfflineServerListener;", "onOfflineServerStatusChanged", "", "started", "", "workMode", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements IOfflineServerListener {
        c() {
        }

        public void onOfflineServerStatusChanged(boolean r7, int r8) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiVoiceSdkRuntime", "offline status changed started=" + r7 + " workMode=" + r8, false, 4, null);
        }
    }

    static {
        f6903a = new a();
        f6904b = new ConcurrentHashMap();
        c = new Object();
    }

    private a() {
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return f6904b;
    }

    public static final /* synthetic */ void a(boolean r0) {
        f = r0;
    }

    public static final /* synthetic */ Object b() {
        return c;
    }

    public final synchronized void a(Context r7) {
        monitor-enter(this);
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r8, "context");     // Catch: Throwable -> L26
        if (d == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        d = true;     // Catch: Throwable -> L26
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (e == true) goto L30;
        AIVoiceTask.INSTANCE.addAsrListener((IAsrListener) ZeusTransformUtils.preCheckCast(new C0317a(), IAsrListener.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L26
        e = true;     // Catch: Throwable -> L26
    L30:
        Intrinsics.checkNotNull(r9);     // Catch: LinkageError -> L14 SecurityException -> L17 IllegalStateException -> L19 IllegalArgumentException -> L21 Throwable -> L26
        AIVoiceConfig.Builder r1 = new AIVoiceConfig.Builder(r9).appId(0).projectId(0);     // Catch: LinkageError -> L14 SecurityException -> L17 IllegalStateException -> L19 IllegalArgumentException -> L21 Throwable -> L26
        String r10 = r9.getPackageName();     // Catch: LinkageError -> L14 SecurityException -> L17 IllegalStateException -> L19 IllegalArgumentException -> L21 Throwable -> L26
        Intrinsics.checkNotNullExpressionValue(r10, "getPackageName(...)");     // Catch: LinkageError -> L14 SecurityException -> L17 IllegalStateException -> L19 IllegalArgumentException -> L21 Throwable -> L26
        AIVoiceConfig r11 = r1.packageName(r10).build();     // Catch: LinkageError -> L14 SecurityException -> L17 IllegalStateException -> L19 IllegalArgumentException -> L21 Throwable -> L26
        AIVoiceManager.INSTANCE.init(r11, (IConnectListener) ZeusTransformUtils.preCheckCast(new b(), IConnectListener.class, "com.obric.memorydata.plugin"), (IOfflineServerListener) ZeusTransformUtils.preCheckCast(new c(), IOfflineServerListener.class, "com.obric.memorydata.plugin"));     // Catch: LinkageError -> L14 SecurityException -> L17 IllegalStateException -> L19 IllegalArgumentException -> L21 Throwable -> L26
    L24:
        monitor-exit(this);
        return;
    L17:
        e = move-exception;
        d = false;     // Catch: Throwable -> L26
        RunLog r0 = RunLog.INSTANCE;     // Catch: Throwable -> L26
        String r2 = "AiVoiceSdkRuntime";
        String r3 = "AIVoice init permission failure";
        Throwable r12 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
    L16:
        r0.error(r2, r3, r12);     // Catch: Throwable -> L26
    L19:
        e = move-exception;
        d = false;     // Catch: Throwable -> L26
        r0 = RunLog.INSTANCE;     // Catch: Throwable -> L26
        r2 = "AiVoiceSdkRuntime";
        r3 = "AIVoice init state failure";
        r12 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
    L21:
        e = move-exception;
        d = false;     // Catch: Throwable -> L26
        r0 = RunLog.INSTANCE;     // Catch: Throwable -> L26
        r2 = "AiVoiceSdkRuntime";
        r3 = "AIVoice init argument failure";
        r12 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
    L14:
        e = move-exception;
        d = false;     // Catch: Throwable -> L26
        r0 = RunLog.INSTANCE;     // Catch: Throwable -> L26
        r2 = "AiVoiceSdkRuntime";
        r3 = "AIVoice init linkage failure";
        r12 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public final void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        f6904b.remove(r1);
    }

    public final void a(String r3, Function1<? super String, Unit> r4) {
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((Map) ZeusTransformUtils.preCheckCast(f6904b, Map.class, "com.obric.memorydata.plugin")).put(r3, r2);
    }

    public final boolean a(long r5) {
        long r0 = System.currentTimeMillis() + r5;
        Object r4 = c;
        monitor-enter(r4);
    L24:
    L19:
        th = move-exception;
        throw th;
    L5:
        if (f == true) goto L17;
        long r6 = r0 - System.currentTimeMillis();
        if (r6 <= 0) goto L9;
        c.wait(r6);     // Catch: InterruptedException -> L13 Throwable -> L19
    L13:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L19
        return false;
    L9:
        monitor-exit(r4);
        return false;
    L17:
        monitor-exit(r4);
        return true;
    }
}
