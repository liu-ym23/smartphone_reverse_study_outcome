package com.obric.memorydata.recommend.screenshotupload;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.recommend.settings.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\u000fJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005J\u0016\u0010\u0019\u001a\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\u0016\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/MemoryRuleObserver;", "", "<init>", "()V", "TAG", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/memorydata/recommend/screenshotupload/MemoryRuleObserver$MemoryRuleListener;", "listenerCallbackMutex", "Lkotlinx/coroutines/sync/Mutex;", "settingEnablePackages", "registerListener", "", "listener", "unregisterListener", CommonConsts.APM_INNER_EVENT_COST_INIT, "getAllCollectPackages", "", "isCollectPackage", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isScreenObservationCollectPackage", "updateScreenObservationEnablePackages", "enabledApps", "", "notifyListeners", "dispatchListenerCallback", "callback", "Lkotlin/Function0;", "MemoryRuleListener", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12542a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f12543b = null;
    private static final CopyOnWriteArraySet<a> c = null;
    private static final kotlinx.coroutines.sync.a d = null;
    private static final CopyOnWriteArraySet<String> e = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/MemoryRuleObserver$MemoryRuleListener;", "", "onMemoryRuleAppsChanged", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a {
        void a();
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.screenshotupload.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/recommend/screenshotupload/MemoryRuleObserver$init$1", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsStore$EnabledAppListener;", "onEnabledAppsChanged", "", "enabledApps", "", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0677b implements t.a {
        C0677b() {
        }

        @Override // com.obric.memorydata.recommend.settings.t.a
        public void a(List<String> r8) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "enabledApps");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryRuleObserver", "screen observation apps changed, count=" + r7.size(), false, 4, null);
            b.a(b.f12542a, (Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"));
            b.a(b.f12542a);
        }
    }

    static {
        f12542a = new b();
        f12543b = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        c = new CopyOnWriteArraySet();
        d = kotlinx.coroutines.sync.c.a(false, 1, null);
        e = new CopyOnWriteArraySet();
    }

    private b() {
    }

    private static final Unit a(List r3) {
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        ((a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin")).a();
        goto L4
    L7:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(b r0) {
        r0.d();
    }

    public static final /* synthetic */ void a(b r2, Collection r3) {
        r2.a((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    private final synchronized void a(Collection<String> r3) {
        monitor-enter(this);
        Collection<? extends String> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        CopyOnWriteArraySet<String> r0 = e;     // Catch: Throwable -> L6
        r0.clear();     // Catch: Throwable -> L6
        r0.addAll(r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private final void a(Function0<Unit> r8) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.i.a(f12543b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryRuleObserver$dispatchListenerCallback$1(r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final Unit b(a r2) {
        ((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin")).a();
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a c() {
        return d;
    }

    private final void d() {
        final List r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin"));
        a(new $$Lambda$b$QdCvFPgX2S5AQhEmF33Q1zh8gbU(r0));
    }

    public static /* synthetic */ Unit lambda$5RZtGmE7ern8_MQ81H5pGduakIg(a r0) {
        return b(r0);
    }

    public static /* synthetic */ Unit lambda$QdCvFPgX2S5AQhEmF33Q1zh8gbU(List r0) {
        return a(r0);
    }

    public final void a() {
        a((Collection) ZeusTransformUtils.preCheckCast(t.f12630a.d(), Collection.class, "com.obric.memorydata.plugin"));
        d();
        t.f12630a.a((t.a) ZeusTransformUtils.preCheckCast(new C0677b(), t.a.class, "com.obric.memorydata.plugin"), true);
        k.b(k.f((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(t.f12630a.e(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MemoryRuleObserver$init$2(null), Function2.class, "com.obric.memorydata.plugin")), f12543b);
    }

    public final void a(a r3) {
        final a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        c.add(r4);
        a(new $$Lambda$b$5RZtGmE7ern8_MQ81H5pGduakIg(r4));
    }

    public final synchronized boolean a(String r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L11
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L6;
        boolean r4 = b(r3);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4;
    L6:
        monitor-exit(this);
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized Set<String> b() {
        monitor-enter(this);
        Set<String> r0 = g.f12558a.a(((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean b(String r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L11
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L6;
        boolean r7 = g.f12558a.a(r6, ((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Set) ZeusTransformUtils.preCheckCast(e, Set.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r7;
    L6:
        monitor-exit(this);
        return false;
    L11:
        th = move-exception;
        throw th;
    }
}
