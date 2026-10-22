package com.obric.capabilitykit;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.ICapabilityManager;
import com.obric.capabilitykit.logger.Logger;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
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
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import wia.n;
import wia.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c implements ServiceConnection {
    public static final c a = null;
    public static n b;
    public static final Object c = null;
    public static final CoroutineScope d = null;
    public static final b e = null;
    public static a f;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/capabilitykit/AgentServiceConnection$BindState;", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1})
    public static final enum a extends Enum<a> {
        public static final a a = null;
        public static final a b = null;
        public static final a c = null;
        public static final /* synthetic */ a[] d = null;

        static {
            a r0 = new a("NotStart", 0);
            a = r0;
            a r1 = new a("Started", 1);
            b = r1;
            a r3 = new a("Connected", 2);
            c = r3;
            d = new a[]{r0, r1, r3};
        }

        public a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) r27.a.a(a.class, r1);
        }

        public static a[] values() {
            return (a[]) d.clone();
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002B\u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001j \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u0003`\u0006J.\u0010\t\u001a\u00020\n2$\u0010\u000b\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u00030\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"com/obric/capabilitykit/AgentServiceConnection$jobMap$1", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/Pair;", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/LinkedHashMap;", "MAX_SIZE", "", "removeEldestEntry", "", "eldest", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class b extends LinkedHashMap<String, Set<Pair<? extends String, ? extends Job>>> {
        private final int a;

        public b() {
            this.a = 10;
        }

        public /* bridge */ Set<Map.Entry<String, Set<Pair<String, Job>>>> a() {
            return super.entrySet();
        }

        public final /* bridge */ Set<Pair<String, Job>> a(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return b((String) r2);
        }

        public final /* bridge */ Set a(Object r2, Set r3) {
            if ((r2 instanceof String) == true) goto L6;
            return r3;
        L6:
            return a((String) r2, r3);
        }

        public /* bridge */ Set<Pair<String, Job>> a(String r1, Set<Pair<String, Job>> r2) {
            return (Set) super.getOrDefault(r1, r2);
        }

        public /* bridge */ boolean a(String r1) {
            return super.containsKey(r1);
        }

        public /* bridge */ boolean a(Set<Pair<String, Job>> r1) {
            return super.containsValue(r1);
        }

        public /* bridge */ Set<String> b() {
            return super.keySet();
        }

        public final /* bridge */ Set<Pair<String, Job>> b(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return c((String) r2);
        }

        public /* bridge */ Set<Pair<String, Job>> b(String r1) {
            return (Set) super.get(r1);
        }

        public /* bridge */ boolean b(String r1, Set<Pair<String, Job>> r2) {
            return super.remove(r1, r2);
        }

        public /* bridge */ int c() {
            return super.size();
        }

        public /* bridge */ Set<Pair<String, Job>> c(String r1) {
            return (Set) super.remove(r1);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return false;
        L7:
            return a((String) r2);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object r2) {
            if (TypeIntrinsics.isMutableSet(r2) == true) goto L7;
            return false;
        L7:
            return a((Set) r2);
        }

        public /* bridge */ Collection<Set<Pair<String, Job>>> d() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Set<Pair<String, Job>>>> entrySet() {
            return a();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return b((String) r2);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object r2, Object r3) {
            if ((r2 instanceof String) == true) goto L6;
            return r3;
        L6:
            return a((String) r2, (Set) r3);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return b();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return c((String) r2);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object r3, Object r4) {
            if ((r3 instanceof String) == true) goto L6;
            return false;
        L6:
            if (TypeIntrinsics.isMutableSet(r4) == true) goto L9;
            return false;
        L9:
            return b((String) r3, (Set) r4);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Set<Pair<? extends String, ? extends Job>>> r2) {
            Intrinsics.checkNotNullParameter(r2, "eldest");
            if (size() <= this.a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<Set<Pair<String, Job>>> values() {
            return d();
        }
    }

    /* JADX INFO: renamed from: com.obric.capabilitykit.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.obric.capabilitykit.AgentServiceConnection$onServiceConnected$1$1$2", f = "AgentServiceConnection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0001c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        public C0001c(Continuation<? super C0001c> r2) {
            super(2, r2);
        }

        public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C0001c(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return a((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            AtomicCapabilitySdk.INSTANCE.onApiInitComplete$capabilitykit_release();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class d implements IBinder.DeathRecipient {
        public final /* synthetic */ IBinder a;

        public d(IBinder r1) {
            this.a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            Logger r0 = Logger.INSTANCE;
            StringBuilder r1 = new StringBuilder("binderDied: before, mBindState=");
            c r2 = c.a;
            r1.append(c.f);
            r1.append(", thread=");
            r1.append(ThreadMethodProxy.currentThread().getName());
            r0.i("AgentServiceConnection", r1.toString());
            this.a.unlinkToDeath(this, 0);
            Object r3 = c.c;
            monitor-enter(r3);
            a r4 = a.a;     // Catch: Throwable -> L8
            Intrinsics.checkNotNullParameter(r4, "<set-?>");     // Catch: Throwable -> L8
            c.f = r4;     // Catch: Throwable -> L8
            c.b = null;     // Catch: Throwable -> L8
            monitor-exit(r3);
            r0.i("AgentServiceConnection", "binderDied: done, set mBindState=NotStart, api=null");
            AtomicCapabilitySdk.INSTANCE.onConnectionClosed$capabilitykit_release();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        a = new c();
        c = new Object();
        d = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new o())));
        e = new b();
        f = a.a;
    }

    public c() {
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName r3) {
        Logger.INSTANCE.i("AgentServiceConnection", "onNullBinding: " + ThreadMethodProxy.currentThread().getName());
        Object r4 = c;
        monitor-enter(r4);
        f = a.a;     // Catch: Throwable -> L12
        b = null;     // Catch: Throwable -> L12
        monitor-exit(r4);
        AppHost.Companion.getApplication().unbindService(this);     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        AtomicCapabilitySdk.INSTANCE.onConnectionClosed$capabilitykit_release();
        return;
    L8:
        th = move-exception;
        Result.constructor-impl(ResultKt.createFailure(th));
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r10, IBinder r11) {
        Logger r0 = Logger.INSTANCE;
        r0.i("AgentServiceConnection", "onServiceConnected: " + ThreadMethodProxy.currentThread().getName() + ", before mBindState=" + f);
        Object r1 = c;
        monitor-enter(r1);
        if (r11 != null) goto L25;
        r11 = null;
    L10:
        wia.p r3 = new wia.p(ICapabilityManager.Stub.asInterface(r11));     // Catch: Throwable -> L7
        r0.i("AgentServiceConnection", "init binder api done");     // Catch: Throwable -> L7
        b = r3;     // Catch: Throwable -> L7
        f = a.c;     // Catch: Throwable -> L7
        Object r12 = Result.constructor-impl(BuildersKt.launch$default(d, null, null, new C0001c(null), 3, null));     // Catch: Throwable -> L7
    L13:
        Throwable r13 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L20
        if (r13 == null) goto L18;
        f = a.a;     // Catch: Throwable -> L20
        b = null;     // Catch: Throwable -> L20
        Logger.INSTANCE.e("AgentServiceConnection", "onServiceConnected throw exception, reset to NotStart: " + ExceptionsKt.stackTraceToString(r13));     // Catch: Throwable -> L20
    L18:
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L20
        goto L13
    L25:
        r11.linkToDeath(new d(r11), 0);     // Catch: Throwable -> L7
    L20:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r4) {
        Logger r5 = Logger.INSTANCE;
        StringBuilder r1 = new StringBuilder("onServiceDisconnected: before, mBindState=");
        r1.append(f);
        r1.append(", api=");
        if (b != null) goto L5;
        String r2 = "null";
    L6:
        r1.append(r2);
        r1.append(", thread=");
        r1.append(ThreadMethodProxy.currentThread().getName());
        r5.i("AgentServiceConnection", r1.toString());
        Object r6 = c;
        monitor-enter(r6);
        f = a.a;     // Catch: Throwable -> L12
        b = null;     // Catch: Throwable -> L12
        monitor-exit(r6);
        AtomicCapabilitySdk.INSTANCE.onConnectionClosed$capabilitykit_release();
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        r2 = "non-null";
        goto L6
    }
}
