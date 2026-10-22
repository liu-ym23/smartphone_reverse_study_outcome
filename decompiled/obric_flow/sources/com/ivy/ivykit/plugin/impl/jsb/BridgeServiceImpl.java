package com.ivy.ivykit.plugin.impl.jsb;

import com.bytedance.ies.bullet.core.j;
import com.bytedance.keva.Keva;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostALogDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostExternalStorageDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostHeadSetDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLocationPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMemoryWaringDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostOpenDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPureNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostThreadPoolExecutorDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.ivy.ivykit.api.bridge.IBridgeService;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mn.h;
import xl.e;
import xl.g;
import xl.i;

/* JADX INFO: loaded from: classes2.dex */
@ServiceImpl
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/plugin/impl/jsb/BridgeServiceImpl;", "Lcom/ivy/ivykit/api/bridge/IBridgeService;", "<init>", "()V", "ivy_plugin_impl_bullet_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BridgeServiceImpl implements IBridgeService {
    public BridgeServiceImpl() {
    }

    @Override // com.ivy.ivykit.api.bridge.IBridgeService
    public final void init(com.ivy.ivykit.api.bridge.a r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeConfig");
        AtomicBoolean r5 = d.f9520a;
        Intrinsics.checkNotNullParameter(r10, "bridgeConfig");
        d.f9521b = r10;
        AtomicBoolean r11 = d.f9520a;
        if (r11.get() == true) goto L20;
        ki.a r12 = ki.a.f18646a;
        j r13 = new j();
        r13.f5319a = d.f9521b.f9469a;
        r13.f5320b = new f9.a(8);
        r13.d = new ib.d(8);
        monitor-enter(r12);
        Intrinsics.checkNotNullParameter(r13, "config");     // Catch: Throwable -> L12
        if (ki.a.f18647b == true) goto L14;
        ki.a.d = r13;     // Catch: Throwable -> L12
        ki.a.f18647b = true;     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
    L15:
        xl.a r14 = new xl.a();
        Intrinsics.checkNotNullParameter(r14, "hostContextDepend");
        h.f20139k = r14;
        xl.c r15 = new xl.c();
        Intrinsics.checkNotNullParameter(r15, "hostLogDependV2");
        h.f20151x = r15;
        xl.h r16 = new xl.h();
        Intrinsics.checkNotNullParameter(r16, "hostStyleUIDepend");
        h.f20140l = r16;
        i r17 = new i();
        Intrinsics.checkNotNullParameter(r17, "userDepend");
        h.f20142n = r17;
        Intrinsics.checkNotNullParameter(new g(), "hostRouterDepend");
        jj.b r18 = new jj.b(0);
        Intrinsics.checkNotNullParameter(r18, "hostNetworkDepend");
        h.f20143o = r18;
        Intrinsics.checkNotNullParameter(new xl.d(), "hostMediaDepend");
        e r19 = new e();
        ConcurrentHashMap r20 = com.ivy.ivykit.api.bridge.b.f9471a;
        Intrinsics.checkNotNullParameter(nl.c.class, "clazz");
        ConcurrentHashMap r21 = com.ivy.ivykit.api.bridge.b.f9471a;
        if (r21.get(nl.c.class) != null) goto L25;
        Intrinsics.checkNotNullParameter(r19, "hostPermissionDepend");
        xl.b r22 = new xl.b();
        Intrinsics.checkNotNullParameter(nl.c.class, "clazz");
        if (r21.get(nl.c.class) != null) goto L23;
        Intrinsics.checkNotNullParameter(r22, "hostLocationPermissionDepend");
        jj.b r23 = new jj.b(1);
        Intrinsics.checkNotNullParameter(r23, "hostNetworkDepend");
        h.f20143o = r23;
        b.f9517c.a(ie.a.class);
        r11.set(true);
        goto L20
    L23:
        throw new ClassCastException();
    L25:
        throw new ClassCastException();
    L14:
        monitor-exit(r12);
    L12:
        th = move-exception;
        throw th;
    L20:
        Keva r24 = wl.b.f22870a;
        ib.d r25 = new ib.d(17);
        boolean r26 = com.bytedance.sdk.xbridge.cn.auth.b.f7300a;
        Intrinsics.checkNotNullParameter(r25, "permissionConfigProvider");
        Intrinsics.checkNotNullParameter(r25, "permissionConfigProvider");
        com.bytedance.sdk.xbridge.cn.auth.b.f7300a = true;
        ConcurrentHashMap r27 = com.bytedance.sdk.xbridge.cn.auth.e.f7342a;
        com.lynx.tasm.utils.c r28 = new com.lynx.tasm.utils.c(7);
        Intrinsics.checkNotNullParameter(r28, "logDepend");
        com.bytedance.sdk.xbridge.cn.auth.e.f = r28;
        List r29 = oi.d.f20583c;
        h.f(false, r25).c();
        Intrinsics.checkNotNullParameter(r25, "permissionConfigProvider");
        a6.a r30 = new a6.a(h.f(true, r25), 24);
        Intrinsics.checkNotNullParameter(r30, "runnable");
        vl.a.f22588b.post(new c1.a(r30, 3, false));
        tc.c r31 = tc.c.f22119c;
        tc.c.f22119c.c(k5.d.f18613r, pb.a.class, new c(0));
    }

    @Override // com.ivy.ivykit.api.bridge.IBridgeService
    public final void registerHostDepend(Object r5) {
        if ((r5 instanceof IHostLogDependV2) == false) goto L7;
        IHostLogDependV2 r10 = (IHostLogDependV2) r5;
        Intrinsics.checkNotNullParameter(r10, "hostLogDependV2");
        h.f20151x = r10;
        return;
    L7:
        if ((r5 instanceof IHostLogDepend) == false) goto L11;
        IHostLogDepend r11 = (IHostLogDepend) r5;
        Intrinsics.checkNotNullParameter(r11, "hostLogDepend");
        h.g = r11;
        return;
    L11:
        if ((r5 instanceof IHostMediaDepend) == false) goto L15;
        IHostMediaDepend r12 = (IHostMediaDepend) r5;
        Intrinsics.checkNotNullParameter(r12, "hostMediaDepend");
        h.f20136h = r12;
        return;
    L15:
        if ((r5 instanceof IHostMediaDependV2) == false) goto L19;
        IHostMediaDependV2 r13 = (IHostMediaDependV2) r5;
        Intrinsics.checkNotNullParameter(r13, "hostMediaDependV2");
        h.f20137i = r13;
        return;
    L19:
        if ((r5 instanceof IHostContextDepend) == false) goto L23;
        IHostContextDepend r14 = (IHostContextDepend) r5;
        Intrinsics.checkNotNullParameter(r14, "hostContextDepend");
        h.f20139k = r14;
        return;
    L23:
        if ((r5 instanceof IHostRouterDepend) == false) goto L27;
        IHostRouterDepend r15 = (IHostRouterDepend) r5;
        Intrinsics.checkNotNullParameter(r15, "hostRouterDepend");
        h.f20141m = r15;
        return;
    L27:
        if ((r5 instanceof IHostStyleUIDepend) == false) goto L31;
        IHostStyleUIDepend r16 = (IHostStyleUIDepend) r5;
        Intrinsics.checkNotNullParameter(r16, "hostStyleUIDepend");
        h.f20140l = r16;
        return;
    L31:
        if ((r5 instanceof IHostPureNetworkDepend) == false) goto L35;
        IHostPureNetworkDepend r17 = (IHostPureNetworkDepend) r5;
        Intrinsics.checkNotNullParameter(r17, "hostPureNetworkDepend");
        h.f20144p = r17;
        return;
    L35:
        if ((r5 instanceof IHostNetworkDepend) == false) goto L39;
        IHostNetworkDepend r18 = (IHostNetworkDepend) r5;
        Intrinsics.checkNotNullParameter(r18, "hostNetworkDepend");
        h.f20143o = r18;
        return;
    L39:
        if ((r5 instanceof IHostPermissionDepend) == false) goto L43;
        IHostPermissionDepend r19 = (IHostPermissionDepend) r5;
        Intrinsics.checkNotNullParameter(r19, "hostPermissionDepend");
        h.f20145q = r19;
        return;
    L43:
        if ((r5 instanceof IHostLocationPermissionDepend) == false) goto L47;
        IHostLocationPermissionDepend r20 = (IHostLocationPermissionDepend) r5;
        Intrinsics.checkNotNullParameter(r20, "hostLocationPermissionDepend");
        h.f20146r = r20;
        return;
    L47:
        if ((r5 instanceof IHostUserDepend) == false) goto L51;
        IHostUserDepend r21 = (IHostUserDepend) r5;
        Intrinsics.checkNotNullParameter(r21, "userDepend");
        h.f20142n = r21;
        return;
    L51:
        if ((r5 instanceof IHostThreadPoolExecutorDepend) == false) goto L55;
        IHostThreadPoolExecutorDepend r22 = (IHostThreadPoolExecutorDepend) r5;
        Intrinsics.checkNotNullParameter(r22, "hostThreadPoolExecutorDepend");
        h.s = r22;
        return;
    L55:
        if ((r5 instanceof IHostOpenDepend) == false) goto L59;
        IHostOpenDepend r23 = (IHostOpenDepend) r5;
        Intrinsics.checkNotNullParameter(r23, "hostOpenDepend");
        h.f20138j = r23;
        return;
    L59:
        if ((r5 instanceof IHostExternalStorageDepend) == false) goto L63;
        IHostExternalStorageDepend r24 = (IHostExternalStorageDepend) r5;
        Intrinsics.checkNotNullParameter(r24, "hostExternalStorageDepend");
        h.f20147t = r24;
        return;
    L63:
        if ((r5 instanceof IHostHeadSetDepend) == false) goto L67;
        IHostHeadSetDepend r25 = (IHostHeadSetDepend) r5;
        Intrinsics.checkNotNullParameter(r25, "hostHeadSetDepend");
        h.f20148u = r25;
        return;
    L67:
        if ((r5 instanceof IHostALogDepend) == false) goto L71;
        IHostALogDepend r26 = (IHostALogDepend) r5;
        Intrinsics.checkNotNullParameter(r26, "hostALogDepend");
        h.f20149v = r26;
        return;
    L71:
        if ((r5 instanceof IHostMemoryWaringDepend) == false) goto L74;
        IHostMemoryWaringDepend r27 = (IHostMemoryWaringDepend) r5;
        Intrinsics.checkNotNullParameter(r27, "memoryWaringDepend");
        h.f20150w = r27;
        return;
    }

    @Override // com.ivy.ivykit.api.bridge.IBridgeService
    public final void registerIvyMethod(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        b.f9517c.a(r5);
    }

    @Override // com.ivy.ivykit.api.bridge.IBridgeService
    public final void registerMethod(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        b.f9517c.a(r5);
    }
}
