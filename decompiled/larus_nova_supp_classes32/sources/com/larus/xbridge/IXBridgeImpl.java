package com.larus.xbridge;

import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.ivy.ivykit.api.bridge.IBridgeService;
import com.larus.im.FlowRuntime;
import com.larus.xbridge.custom.FlowFetchPocketPageData;
import com.larus.xbridge.custom.a;
import com.larus.xbridge.custom.b0;
import com.larus.xbridge.custom.b1;
import com.larus.xbridge.custom.d0;
import com.larus.xbridge.custom.e1;
import com.larus.xbridge.custom.f;
import com.larus.xbridge.custom.i1;
import com.larus.xbridge.custom.j;
import com.larus.xbridge.custom.j1;
import com.larus.xbridge.custom.j2;
import com.larus.xbridge.custom.k;
import com.larus.xbridge.custom.k1;
import com.larus.xbridge.custom.l;
import com.larus.xbridge.custom.m;
import com.larus.xbridge.custom.m0;
import com.larus.xbridge.custom.n;
import com.larus.xbridge.custom.n0;
import com.larus.xbridge.custom.o;
import com.larus.xbridge.custom.p;
import com.larus.xbridge.custom.p0;
import com.larus.xbridge.custom.q;
import com.larus.xbridge.custom.q1;
import com.larus.xbridge.custom.r;
import com.larus.xbridge.custom.r0;
import com.larus.xbridge.custom.s1;
import com.larus.xbridge.custom.t0;
import com.larus.xbridge.custom.t1;
import com.larus.xbridge.custom.v1;
import com.larus.xbridge.custom.w;
import com.larus.xbridge.custom.w1;
import com.larus.xbridge.custom.x;
import com.larus.xbridge.custom.x0;
import com.larus.xbridge.custom.y;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.launch.ObricLazyInitSettingsServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import e4a.b;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J0\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/xbridge/IXBridgeImpl;", "Lcom/larus/xbridge/IXBridgeApi;", "<init>", "()V", "registerLock", NameKeys.UnloadStrategy_No_Strategy, "customBridgesRegistered", NameKeys.UnloadStrategy_No_Strategy, "init", NameKeys.UnloadStrategy_No_Strategy, "registerCustomBridges", "sendEvent", "eventName", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.PARAMS_KEY, NameKeys.UnloadStrategy_No_Strategy, "containerID", "registerIvyBridges", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IXBridgeImpl implements IXBridgeApi {
    public final Object b;
    public volatile boolean c;

    public static void c() {
        Iterator r0 = ServiceManager.get().getServices(IXBridgeMethodRegistry.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IXBridgeMethodRegistry) r0.next()).a();
        goto L4
    L6:
        IBridgeService.Companion r1 = IBridgeService.a;
        r1.c(r.class);
        r1.c(m0.class);
        r1.c(b0.class);
        r1.e(b1.class);
        r1.e(FlowFetchPocketPageData.class);
        r1.e(i1.class);
        r1.e(e1.class);
        r1.e(k1.class);
        r1.e(j1.class);
        r1.e(v1.class);
        r1.e(d0.class);
        r1.e(x0.class);
        r1.c(t0.class);
        r1.c(s1.class);
        r1.c(n.class);
        r1.c(w.class);
        r1.c(p0.class);
        r1.c(q1.class);
        r1.c(j2.class);
        r1.c(t1.class);
        r1.c(r0.class);
        r1.c(y.class);
        r1.c(m.class);
        r1.c(x.class);
        r1.c(f.class);
        r1.c(n0.class);
        r1.c(j.class);
        r1.c(q.class);
        r1.c(a.class);
        r1.c(o.class);
        r1.c(w1.class);
        r1.c(p.class);
        r1.c(l.class);
        r1.c(k.class);
        FlowRuntime.a().isOversea();
    }

    @Override // com.larus.xbridge.IXBridgeApi
    public final void a() {
        if (ObricLazyInitSettingsServiceDelegate.a.e() == true) goto L7;
        c();
        return;
    L7:
        if (this.c == false) goto L9;
        return;
    L9:
        Object r0 = this.b;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L12:
        if (this.c == false) goto L15;
        monitor-exit(r0);
        return;
    L15:
        c();     // Catch: Throwable -> L18
        this.c = true;     // Catch: Throwable -> L18
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
    }

    @Override // com.larus.xbridge.IXBridgeApi
    public final void init() {
        Object r0 = b.a;
        if (ObricLazyInitSettingsServiceDelegate.a.e() == false) goto L5;
        AtomicBoolean r1 = b.b;
        if (r1.get() == true) goto L27;
        Object r2 = b.a;
        monitor-enter(r2);
    L20:
        th = move-exception;
        throw th;
    L14:
        if (r1.get() == false) goto L17;
        monitor-exit(r2);
        return;
    L17:
        b.a();     // Catch: Throwable -> L20
        r1.set(true);     // Catch: Throwable -> L20
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r2);
        return;
    L27:
        return;
    L5:
        if (b.b.compareAndSet(false, true) == false) goto L26;
        b.a();
        return;
    }

    public IXBridgeImpl() {
        this.b = new Object();
    }

    @Override // com.larus.xbridge.IXBridgeApi
    public final void b(String r10, Map<String, ? extends Object> r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        int r1 = e4a.a.a;
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Event r0 = new Event(r10, System.currentTimeMillis(), null, 4, null);
        r0.setMapParams(r11);
        r0.setTargetContainerID(r12);
        EventCenter.enqueueEvent(r0);
    }
}
