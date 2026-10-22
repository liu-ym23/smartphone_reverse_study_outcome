package com.obric.capabilitykit;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.ICapabilityManager;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bo;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001c\u0010'\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bRQ\u0010\f\u001aB\u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\rj \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000f0\u000e`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/capabilitykit/AgentServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "SERVER_SERVICE", "", "TAG", "api", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "getApi", "()Lcom/obric/capabilitykit/AbstractCapabilityManager;", "setApi", "(Lcom/obric/capabilitykit/AbstractCapabilityManager;)V", "jobMap", "Ljava/util/LinkedHashMap;", "", "Lkotlin/Pair;", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/LinkedHashMap;", "getJobMap", "()Ljava/util/LinkedHashMap;", "mBindState", "Lcom/obric/capabilitykit/AgentServiceConnection$BindState;", "getMBindState", "()Lcom/obric/capabilitykit/AgentServiceConnection$BindState;", "setMBindState", "(Lcom/obric/capabilitykit/AgentServiceConnection$BindState;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "stateLock", "", "extBindFlags", "", "getApi$capabilitykit_release", "onNullBinding", "", ActivityLifecycle.NAME, "Landroid/content/ComponentName;", "onServiceConnected", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "BindState", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7476a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7477b = "AgentServiceConnection";
    public static final String c = "com.obric.aiagent.executionengine.CAPABILITY_REGISTER_SERVICE";
    private static com.obric.capabilitykit.a d;
    private static final Object e = null;
    private static final al f = null;
    private static final LinkedHashMap<String, Set<Pair<String, bx>>> g = null;
    private static a h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/capabilitykit/AgentServiceConnection$BindState;", "", "(Ljava/lang/String;I)V", "NotStart", "Started", "Connected", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7478a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f7479b = null;
        public static final a c = null;
        private static final /* synthetic */ a[] d = null;

        static {
            f7478a = new a("NotStart", 0);
            f7479b = new a("Started", 1);
            c = new a("Connected", 2);
            d = a();
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{f7478a, f7479b, c};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.memorydata.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(d.clone(), a[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002B\u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001j \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u0003`\u0006J.\u0010\t\u001a\u00020\n2$\u0010\u000b\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u00030\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"com/obric/capabilitykit/AgentServiceConnection$jobMap$1", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/Pair;", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/LinkedHashMap;", "MAX_SIZE", "", "removeEldestEntry", "", "eldest", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends LinkedHashMap<String, Set<Pair<? extends String, ? extends bx>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7480a;

        public b() {
            this.f7480a = 10;
        }

        public Set<Map.Entry<String, Set<Pair<String, bx>>>> a() {
            return super.entrySet();
        }

        public final Set<Pair<String, bx>> a(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        public final Set a(Object r3, Set r4) {
            Set<Pair<String, bx>> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return r5;
        L6:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), r5);
        }

        public Set<Pair<String, bx>> a(String r3, Set<Pair<String, bx>> r4) {
            return (Set) ZeusTransformUtils.preCheckCast(super.getOrDefault(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin");
        }

        public boolean a(String r1) {
            return super.containsKey(r1);
        }

        public boolean a(Set<Pair<String, bx>> r3) {
            return super.containsValue((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
        }

        public Set<String> b() {
            return super.keySet();
        }

        public final Set<Pair<String, bx>> b(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        public Set<Pair<String, bx>> b(String r2) {
            return (Set) ZeusTransformUtils.preCheckCast(super.get(r2), Set.class, "com.obric.memorydata.plugin");
        }

        public boolean b(String r3, Set<Pair<String, bx>> r4) {
            return super.remove(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin"));
        }

        public int c() {
            return super.size();
        }

        public Set<Pair<String, bx>> c(String r2) {
            return (Set) ZeusTransformUtils.preCheckCast(super.remove(r2), Set.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsValue(Object r3) {
            if (TypeIntrinsics.isMutableSet(r3) == true) goto L7;
            return false;
        L7:
            return a((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin"));
        }

        public Collection<Set<Pair<String, bx>>> d() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<String, Set<Pair<String, bx>>>> entrySet() {
            return a();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object get(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* synthetic */ Object getOrDefault(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return r4;
        L6:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<String> keySet() {
            return b();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.HashMap, java.util.Map
        public final boolean remove(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return false;
        L6:
            if (TypeIntrinsics.isMutableSet(r4) == true) goto L9;
            return false;
        L9:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Set<Pair<? extends String, ? extends bx>>> r3) {
            Intrinsics.checkNotNullParameter((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin"), "eldest");
            if (size() <= this.f7480a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<Set<Pair<String, bx>>> values() {
            return d();
        }
    }

    /* JADX INFO: renamed from: com.obric.capabilitykit.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.AgentServiceConnection$onServiceConnected$1$1$2", f = "AgentServiceConnection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0369c extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7481a;

        public C0369c(Continuation<? super C0369c> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object a(al r3, Continuation<? super Unit> r4) {
            return ((C0369c) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C0369c.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C0369c((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7481a != 0) goto L7;
            ResultKt.throwOnFailure(r1);
            AtomicCapabilitySdk.INSTANCE.onApiInitComplete$capabilitykit_release();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/capabilitykit/AgentServiceConnection$onServiceConnected$1$1$binder$1$1", "Landroid/os/IBinder$DeathRecipient;", "binderDied", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBinder f7482a;

        public d(IBinder r3) {
            this.f7482a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Logger r0 = Logger.INSTANCE;
            StringBuilder r1 = new StringBuilder().append("binderDied: before, mBindState=");
            c r2 = c.f7476a;
            r0.i(c.f7477b, r1.append(r2.d()).append(", thread=").append(Thread.currentThread().getName()).toString());
            this.f7482a.unlinkToDeath(this, 0);
            Object r4 = c.a();
            monitor-enter(r4);
            r2.a(a.f7478a);     // Catch: Throwable -> L8
            r2.a(null);     // Catch: Throwable -> L8
            monitor-exit(r4);
            r0.i(c.f7477b, "binderDied: done, set mBindState=NotStart, api=null");
            AtomicCapabilitySdk.INSTANCE.onConnectionClosed$capabilitykit_release();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        f7476a = new c();
        e = new Object();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$c$Cf2rZxHqwtd0XduQ0cCxclH8E.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r0, "newSingleThreadExecutor …entSvcConn-thread\")\n    }");
        f = am.a(bo.a(r0));
        g = new b();
        h = a.f7478a;
    }

    private c() {
    }

    public static final /* synthetic */ Object a() {
        return e;
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "AgentSvcConn-thread");
    }

    /* JADX INFO: renamed from: lambda$Cf2rZxHqwtd-0XduQ0-cCxclH8E, reason: not valid java name */
    public static /* synthetic */ Thread m410lambda$Cf2rZxHqwtd0XduQ0cCxclH8E(Runnable r0) {
        return a(r0);
    }

    public final com.obric.capabilitykit.a a(int r13) {
        Object r0 = e;
        monitor-enter(r0);
        Logger r1 = Logger.INSTANCE;     // Catch: Throwable -> L91
        StringBuilder r3 = new StringBuilder().append("getApi: enter, mBindState=").append(h).append(", api=");     // Catch: Throwable -> L91
        if (d != null) goto L9;
        String r4 = "null";
    L10:
        r1.i(f7477b, r3.append(r4).toString());     // Catch: Throwable -> L91
        com.obric.capabilitykit.a r2 = d;     // Catch: Throwable -> L91
        if (r2 == null) goto L94;
        monitor-exit(r0);
        return r2;
    L94:
    L67:
        th = move-exception;
        Object r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L91
    L69:
        Throwable r15 = Result.m1424exceptionOrNullimpl(r14);     // Catch: Throwable -> L91
        if (r15 != null) goto L73;
    L83:
        monitor-exit(r0);
        com.obric.capabilitykit.a r12 = d;
        if (r12 != null) goto L88;
        r12 = f.f7587a;
    L88:
        if (Intrinsics.areEqual(r12, f.f7587a) == false) goto L90;
        Logger.INSTANCE.i(f7477b, "getApi: return EmptyCapabilityManager, mBindState=" + h);
    L90:
        return r12;
    L73:
        Logger.INSTANCE.e(f7477b, "bindService throw exception: " + ExceptionsKt.stackTraceToString(r15));     // Catch: Throwable -> L91
        h = a.f7478a;     // Catch: Throwable -> L91
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), this, "com.obric.memorydata.plugin");     // Catch: Throwable -> L76
        Object r16 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L76
    L78:
        Throwable r17 = Result.m1424exceptionOrNullimpl(r16);     // Catch: Throwable -> L91
        if (r17 == null) goto L83;
        Logger.INSTANCE.e(f7477b, "unbindService throw exception: " + ExceptionsKt.stackTraceToString(r17));     // Catch: Throwable -> L91
        goto L83
    L76:
        th = move-exception;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L91
        goto L78
    L15:
        if (h != a.f7479b) goto L17;
        r1.i(f7477b, "getApi: api is null but mBindState=Started (connecting), wait onServiceConnected");     // Catch: Throwable -> L67
    L65:
        r14 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L67
        goto L69
    L17:
        r1.i(f7477b, "getApi: api is null, try rebind, current mBindState=" + h);     // Catch: Throwable -> L67
        Intent r5 = new Intent(c);     // Catch: Throwable -> L67
        List<ResolveInfo> r6 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getPackageManager().queryIntentServices(r5, 0);     // Catch: Throwable -> L67
        Intrinsics.checkNotNullExpressionValue(r6, "packageManager.queryIntentServices(intent, 0)");     // Catch: Throwable -> L67
        ServiceInfo r7 = null;
        Object r8 = null;
        if (r6 == null) goto L32;
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L67
        Iterator<T> r10 = r6.iterator();     // Catch: Throwable -> L67
    L21:
        if (r10.hasNext() == false) goto L25;
        ServiceInfo r11 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r10.next(), ResolveInfo.class, "com.obric.memorydata.plugin")).serviceInfo;     // Catch: Throwable -> L67
        if (r11 == null) goto L21;
        r9.add(r11);     // Catch: Throwable -> L67
        goto L21
    L25:
        Iterator r18 = r9.iterator();     // Catch: Throwable -> L67
    L27:
        if (r18.hasNext() == false) goto L31;
        Object r19 = r18.next();     // Catch: Throwable -> L67
        if (PackageUtils.INSTANCE.checkSignature(((ServiceInfo) ZeusTransformUtils.preCheckCast(r19, ServiceInfo.class, "com.obric.memorydata.plugin")).packageName) == false) goto L27;
        r8 = r19;
    L31:
        r7 = (ServiceInfo) ZeusTransformUtils.preCheckCast(r8, ServiceInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L67
    L32:
        if (r7 == null) goto L34;
        r5.setComponent(new ComponentName(r7.packageName, r7.name));     // Catch: Throwable -> L67
        r5.setPackage(r7.packageName);     // Catch: Throwable -> L67
    L34:
        AtomicCapabilitySdk.INSTANCE.setPendingCallsExecuted$capabilitykit_release(false);     // Catch: Throwable -> L67
        Ref.BooleanRef r20 = new Ref.BooleanRef();     // Catch: Throwable -> L67
        int r21 = 0;
    L35:
        if (r21 >= 3) goto L57;
        if (r20.element == true) goto L55;
    L44:
        th = move-exception;
        Object r22 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L67
    L46:
        Throwable r23 = Result.m1424exceptionOrNullimpl(r22);     // Catch: Throwable -> L67
        if (r23 != null) goto L50;
    L51:
        Boolean r24 = Boolean.FALSE;     // Catch: Throwable -> L67
        if (Result.m1427isFailureimpl(r22) == false) goto L54;
        r22 = r24;
    L54:
        r20.element = ((Boolean) ZeusTransformUtils.preCheckCast(r22, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L67
        goto L55
    L50:
        Logger.INSTANCE.e(f7477b, "startService attempt " + (r21 + 1) + " failed: " + ExceptionsKt.stackTraceToString(r23));     // Catch: Throwable -> L67
        goto L51
    L39:
        if (ZeusTransformUtils.startService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), r5, "com.obric.memorydata.plugin") == null) goto L41;
        boolean r25 = true;
    L42:
        r22 = Result.m1421constructorimpl(Boolean.valueOf(r25));     // Catch: Throwable -> L44
    L41:
        r25 = false;
    L55:
        r21 = r21 + 1;     // Catch: Throwable -> L67
        goto L35
    L57:
        if (r20.element == false) goto L63;
        AppHost.Companion r26 = AppHost.Companion;     // Catch: Throwable -> L67
        if (ZeusTransformUtils.bindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r26.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), r5, this, r13, "com.obric.memorydata.plugin") == false) goto L61;
        h = a.f7479b;     // Catch: Throwable -> L67
        goto L65
    L61:
        Logger.INSTANCE.i(f7477b, "bindService fail");     // Catch: Throwable -> L67
        h = a.f7478a;     // Catch: Throwable -> L67
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r26.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), this, "com.obric.memorydata.plugin");     // Catch: Throwable -> L67
        goto L65
    L63:
        throw new IllegalStateException("startService failed after 3 attempts");     // Catch: Throwable -> L67
    L9:
        r4 = "non-null";
    L91:
        th = move-exception;
        throw th;
    }

    public final void a(com.obric.capabilitykit.a r2) {
        d = (com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin");
    }

    public final void a(a r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        h = r1;
    }

    public final com.obric.capabilitykit.a b() {
        return d;
    }

    public final LinkedHashMap<String, Set<Pair<String, bx>>> c() {
        return g;
    }

    public final a d() {
        return h;
    }

    public final al e() {
        return f;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName r3) {
        Logger.INSTANCE.i(f7477b, "onNullBinding: " + Thread.currentThread().getName());
        Object r4 = e;
        monitor-enter(r4);
        h = a.f7478a;     // Catch: Throwable -> L12
        d = null;     // Catch: Throwable -> L12
        monitor-exit(r4);
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), this, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        AtomicCapabilitySdk.INSTANCE.onConnectionClosed$capabilitykit_release();
        return;
    L8:
        th = move-exception;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r8, IBinder r9) {
        IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r9, IBinder.class, "com.obric.memorydata.plugin");
        Logger r10 = Logger.INSTANCE;
        r10.i(f7477b, "onServiceConnected: " + Thread.currentThread().getName() + ", before mBindState=" + h);
        Object r11 = e;
        monitor-enter(r11);
        if (r7 != null) goto L23;
        r7 = null;
    L10:
        ICapabilityManager r12 = ICapabilityManager.Stub.asInterface(r7);     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r12, "asInterface(binder)");     // Catch: Throwable -> L7
        e r1 = new e(r12);     // Catch: Throwable -> L7
        r10.i(f7477b, "init binder api done");     // Catch: Throwable -> L7
        d = r1;     // Catch: Throwable -> L7
        h = a.c;     // Catch: Throwable -> L7
        Object r13 = Result.m1421constructorimpl(kotlinx.coroutines.i.a(f, null, null, new C0369c(null), 3, null));     // Catch: Throwable -> L7
    L13:
        Throwable r14 = Result.m1424exceptionOrNullimpl(r13);     // Catch: Throwable -> L20
        if (r14 == null) goto L18;
        h = a.f7478a;     // Catch: Throwable -> L20
        d = null;     // Catch: Throwable -> L20
        Logger.INSTANCE.e(f7477b, "onServiceConnected throw exception, reset to NotStart: " + ExceptionsKt.stackTraceToString(r14));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L18:
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L20
        goto L13
    L23:
        r7.linkToDeath(new d(r7), 0);     // Catch: Throwable -> L7
        goto L10
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r3) {
        Logger r2 = Logger.INSTANCE;
        StringBuilder r0 = new StringBuilder().append("onServiceDisconnected: before, mBindState=").append(h).append(", api=");
        if (d != null) goto L5;
        String r1 = "null";
    L6:
        r2.i(f7477b, r0.append(r1).append(", thread=").append(Thread.currentThread().getName()).toString());
        Object r4 = e;
        monitor-enter(r4);
        h = a.f7478a;     // Catch: Throwable -> L12
        d = null;     // Catch: Throwable -> L12
        monitor-exit(r4);
        AtomicCapabilitySdk.INSTANCE.onConnectionClosed$capabilitykit_release();
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        r1 = "non-null";
        goto L6
    }
}
