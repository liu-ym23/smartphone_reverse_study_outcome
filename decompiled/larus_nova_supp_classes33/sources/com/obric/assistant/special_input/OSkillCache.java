package com.obric.assistant.special_input;

import android.os.IBinder;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL;
import com.obric.aiagent.assistant.idl.bean.OSkill;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class OSkillCache {
    public static final OSkillCache a = null;
    public static final CoroutineScope b = null;
    public static final CoroutineScope c = null;
    public static final AtomicBoolean d = null;
    public static final AtomicBoolean e = null;
    public static final AtomicBoolean f = null;
    public static final AtomicBoolean g = null;
    public static final AtomicBoolean h = null;
    public static final AtomicLong i = null;
    public static final AtomicLong j = null;
    public static final CopyOnWriteArraySet<WeakReference<Function1<s0, Unit>>> k = null;
    public static final Object l = null;
    public static volatile IBinder m;
    public static volatile s0 n;
    public static volatile List<OSkill> o;
    public static final OSkillCache$observer$1 p = null;

    public OSkillCache() {
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.obric.assistant.special_input.OSkillCache$observer$1] */
    static {
        a = new OSkillCache();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        d = new AtomicBoolean(false);
        e = new AtomicBoolean(false);
        f = new AtomicBoolean(false);
        g = new AtomicBoolean(false);
        h = new AtomicBoolean(false);
        i = new AtomicLong(0);
        j = new AtomicLong(0);
        k = new CopyOnWriteArraySet();
        l = new Object();
        n = new s0(0);
        o = CollectionsKt.emptyList();
        p = new OSkillCache$observer$1();
    }

    public static int c() {
        Iterator<WeakReference<Function1<s0, Unit>>> r0 = k.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L10;
        WeakReference<Function1<s0, Unit>> r2 = r0.next();
        if (r2.get() == null) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        k.remove(r2);
        goto L4
    L10:
        if (r1 <= 20) goto L12;
        FLogger.a.w("OSkillCache", "listener count too large, activeSize=" + r1);
    L12:
        return r1;
    }

    public static void g() {
        Intrinsics.checkNotNullParameter("chat_resume", WindowEvent.Params.REASON);
        if (g.compareAndSet(false, true) == true) goto L6;
        FLogger.a.i("OSkillCache", "refreshIfStale skipped, another version check is running, reason=chat_resume");
        return;
    L6:
        BuildersKt.launch$default(b, null, null, new OSkillCache$refreshIfStale$1("chat_resume", null), 3, null);
    }

    public static void k() {
        kotlinx.coroutines.flow.b1 r0 = j.a;
        Intrinsics.checkNotNullParameter("skill_cache_start", WindowEvent.Params.REASON);
        OSkillExtensionSettingRepository.a.getClass();
        OSkillExtensionSettingRepository.b("skill_cache_start");
        boolean r1 = e.compareAndSet(false, true);
        if (d.compareAndSet(false, true) == false) goto L6;
        com.obric.aiagent.assistant.idl.n.b(Reflection.getOrCreateKotlinClass(IAgentSkillManagerIDL.class), false, new d());
    L6:
        IAgentSkillManagerIDL r2 = com.obric.aiagent.assistant.idl.n.a(Reflection.getOrCreateKotlinClass(IAgentSkillManagerIDL.class));
        if (r2 != null) goto L10;
        FLogger.a.i("OSkillCache", "waiting for SkillManager IPC");
        return;
    L10:
        h(r2);
        if (r1 == false) goto L13;
    L16:
        if (r1 == false) goto L18;
        String r3 = "initial";
    L19:
        l(r3, null);
        return;
    L18:
        r3 = "restart";
        goto L19
    L13:
        if (n.b == false) goto L16;
        FLogger.a.i("OSkillCache", "start skipped, cache already started, version=" + n.d);
    }

    public static void d(IBinder r2) {
        Object r0 = l;
        monitor-enter(r0);
        if (r2 != null) goto L14;
    L7:
        m = null;     // Catch: Throwable -> L11
    L8:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        if (m != r2) goto L8;
        goto L7
    }

    public static void h(IAgentSkillManagerIDL r3) {
        IBinder r0 = r3.asBinder();
        Object r1 = l;
        monitor-enter(r1);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (m == r0) goto L7;
    L10:
        m = r0;     // Catch: Throwable -> L20
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r1);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        r3.registerSkillObserver(p);     // Catch: Throwable -> L14
        FLogger.a.i("OSkillCache", "register observer success");     // Catch: Throwable -> L14
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L27;
        a.getClass();
        d(r0);
        FLogger.a.e("OSkillCache", "register observer failed", r6);
        return;
    L27:
        return;
    L14:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L7:
        if (r0.isBinderAlive() == false) goto L10;
        monitor-exit(r1);
    }

    public static int i(Function1 r4) {
        Iterator<WeakReference<Function1<s0, Unit>>> r0 = k.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L12;
        WeakReference<Function1<s0, Unit>> r2 = r0.next();
        Function1<s0, Unit> r3 = r2.get();
        if (r3 == null) goto L10;
        if (r4 == null) goto L4;
        if (r3 != r4) goto L4;
    L10:
        if (k.remove(r2) == false) goto L4;
        r1 = r1 + 1;
        goto L4
    L12:
        return r1;
    }

    public static int j(OSkill r7) {
        Long r0 = r7.getLastUsedAt();
        boolean r3 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return 0;
    L10:
        Long r2 = r7.getLastUpdatedAt();
        if (r2 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == true) goto L30;
        Long r8 = r7.getCreatedAt();
        if (r8 != null) goto L21;
    L23:
        r3 = false;
    L24:
        if (r3 == false) goto L26;
        return 2;
    L26:
        return 3;
    L21:
        if (r8.longValue() <= 0) goto L23;
    L30:
        return 1;
    L13:
        if (r2.longValue() <= 0) goto L15;
        r4 = true;
        goto L16
    L5:
        if (r0.longValue() <= 0) goto L7;
        r1 = true;
        goto L8
    }

    public static String m(List r9) {
        return CollectionsKt.joinToString$default(r9, null, null, null, 20, null, new e(), 23, null);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.assistant.special_input.f] */
    public static final List b(OSkillCache r1, List r2) {
        r1.getClass();
        Iterable r3 = CollectionsKt.withIndex(r2);
        final ?? r4 = new f();
        List r5 = CollectionsKt.sortedWith(r3, new g(r4));
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r6.add((OSkill) ((IndexedValue) r7.next()).getValue());
        goto L4
    L6:
        return r6;
    }

    public static int e(Long r4, Long r5) {
        long r0 = Long.MIN_VALUE;
        if (r5 == null) goto L5;
        long r2 = r5.longValue();
    L6:
        Long r6 = Long.valueOf(r2);
        if (r4 == null) goto L10;
        r0 = r4.longValue();
    L10:
        return ComparisonsKt.compareValues(r6, Long.valueOf(r0));
    L5:
        r2 = Long.MIN_VALUE;
        goto L6
    }

    public static void l(String r7, Long r8) {
        if (f.compareAndSet(false, true) == true) goto L8;
        if (r8 == null) goto L6;
        i.set(r8.longValue());
    L6:
        FLogger.a.i("OSkillCache", "sync skipped, another sync is running, reason=" + r7 + ", expectedVersion=" + r8);
        return;
    L8:
        BuildersKt.launch$default(b, null, null, new OSkillCache$sync$2(r8, r7, null), 3, null);
    }

    public static final void a(OSkillCache r5, List r6, List r7) {
        r5.getClass();
        List r8 = r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r0.add(((OSkill) r9.next()).getSlug());
        goto L4
    L6:
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r1 = r7.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r10.add(((OSkill) r1.next()).getSlug());
        goto L8
    L10:
        FLogger.a.i("OSkillCache", "legacy comparison after sync, sameMembers=" + Intrinsics.areEqual(CollectionsKt.sorted(r0), CollectionsKt.sorted(r10)) + ", sameOrder=" + Intrinsics.areEqual(r0, r10) + ", rawCount=" + r6.size() + ", cacheCount=" + ((ArrayList) r7).size() + ", rawSkills=" + m(r6) + ", cacheSkills=" + m(r7));
    }

    public static void f(String r2, Function1 r3, int r4) {
        FLogger.a.i("OSkillCache", r2 + ", listenerHash=" + System.identityHashCode(r3) + ", removed=" + r4 + ", activeSize=" + c());
    }
}
