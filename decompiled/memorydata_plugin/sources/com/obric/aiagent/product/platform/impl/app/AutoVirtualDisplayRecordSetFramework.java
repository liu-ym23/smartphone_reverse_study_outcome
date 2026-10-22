package com.obric.aiagent.product.platform.impl.app;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\tJ\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ!\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/AutoVirtualDisplayRecordSetFramework;", "", "api", "Lcom/obric/aiagent/product/platform/impl/app/AutoVirtualDisplayRecordSetApiShape;", "<init>", "(Lcom/obric/aiagent/product/platform/impl/app/AutoVirtualDisplayRecordSetApiShape;)V", LocationMonitorConst.TAG, "", "runtimeSupported", "", "getRuntimeSupported", "()Z", "runtimeSupported$delegate", "Lkotlin/Lazy;", "officialApiCalls", "Lcom/obric/aiagent/product/platform/impl/app/AutoVirtualDisplayRecordSetCalls;", "getOfficialApiCalls", "()Lcom/obric/aiagent/product/platform/impl/app/AutoVirtualDisplayRecordSetCalls;", "officialApiCalls$delegate", "isSupported", "begin", "", "displayId", "", "userId", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener;", "add", ObricMemoryConstants.KEY_SESSION_ID, "packageNames", "", "(J[Ljava/lang/String;)Z", "end", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoVirtualDisplayRecordSetFramework {
    private final AutoVirtualDisplayRecordSetApiShape api;
    private final Lazy officialApiCalls$delegate;
    private final Lazy runtimeSupported$delegate;
    private final String tag;

    public AutoVirtualDisplayRecordSetFramework(AutoVirtualDisplayRecordSetApiShape r2) {
        Intrinsics.checkNotNullParameter(r2, "api");
        this.api = r2;
        this.tag = "ObricVDRecordSet";
        this.runtimeSupported$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new $$Lambda$AutoVirtualDisplayRecordSetFramework$JqJvb6WFMm_FRupidGULRKFZmFg(this));
        this.officialApiCalls$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new $$Lambda$AutoVirtualDisplayRecordSetFramework$47Cr0Q8t8Ib3RdC7c2zjmONtA(this));
    }

    private final AutoVirtualDisplayRecordSetCalls getOfficialApiCalls() {
        return (AutoVirtualDisplayRecordSetCalls) ZeusTransformUtils.preCheckCast(this.officialApiCalls$delegate.getValue(), AutoVirtualDisplayRecordSetCalls.class, "com.obric.memorydata.plugin");
    }

    private final boolean getRuntimeSupported() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.runtimeSupported$delegate.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    /* JADX INFO: renamed from: lambda$47Cr-0Q8t8Ib3Rd-C7c2zjmONtA, reason: not valid java name */
    public static /* synthetic */ AutoVirtualDisplayRecordSetCalls m175lambda$47Cr0Q8t8Ib3RdC7c2zjmONtA(AutoVirtualDisplayRecordSetFramework r0) {
        return officialApiCalls_delegate$lambda$5(r0);
    }

    public static /* synthetic */ boolean lambda$JqJvb6WFMm_FRupidGULRKFZmFg(AutoVirtualDisplayRecordSetFramework r0) {
        return runtimeSupported_delegate$lambda$3(r0);
    }

    public static /* synthetic */ Unit lambda$gCWbWmGt8wgTsbvvJf217dUv9XM(AutoVirtualDisplayRecordSetFramework r0, Throwable r1) {
        return runtimeSupported_delegate$lambda$3$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ro9bFttH0ardPvi1rOuYF-2d2zI, reason: not valid java name */
    public static /* synthetic */ Unit m176lambda$ro9bFttH0ardPvi1rOuYF2d2zI(AutoVirtualDisplayRecordSetFramework r0, Class r1) {
        return runtimeSupported_delegate$lambda$3$lambda$0(r0, r1);
    }

    private static final AutoVirtualDisplayRecordSetCalls officialApiCalls_delegate$lambda$5(AutoVirtualDisplayRecordSetFramework r2) {
        if (r2.getRuntimeSupported() == false) goto L7;
        Object r3 = Class.forName(r2.api.getInvokerClassName(), true, AutoVirtualDisplayRecordSetFramework.class.getClassLoader()).getField("INSTANCE").get(null);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.aiagent.product.platform.impl.app.AutoVirtualDisplayRecordSetCalls");
        return (AutoVirtualDisplayRecordSetCalls) ZeusTransformUtils.preCheckCast(r3, AutoVirtualDisplayRecordSetCalls.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalStateException((r2.api.getNamespace() + " record-set API is unavailable").toString());
    }

    private static final boolean runtimeSupported_delegate$lambda$3(final AutoVirtualDisplayRecordSetFramework r5) {
        boolean r0 = ObricAutoVirtualDisplayRecordSetFrameworkKt.isAutoVirtualDisplayRecordSetApiSupported(r5.api, AutoVirtualDisplayRecordSetFramework.class.getClassLoader(), new $$Lambda$AutoVirtualDisplayRecordSetFramework$ro9bFttH0ardPvi1rOuYF2d2zI(r5), new $$Lambda$AutoVirtualDisplayRecordSetFramework$gCWbWmGt8wgTsbvvJf217dUv9XM(r5));
        d.f5954a.b(r5.tag, "runtime capability supported=" + r0 + " namespace=" + r5.api.getNamespace());
        return r0;
    }

    private static final Unit runtimeSupported_delegate$lambda$3$lambda$0(AutoVirtualDisplayRecordSetFramework r4, Class r5) {
        Intrinsics.checkNotNullParameter(r5, "managerClass");
        d.b r0 = d.f5954a;
        String r1 = r4.tag;
        StringBuilder r6 = new StringBuilder().append("resolved manager=").append(r4.api.getManagerClassName()).append(" classLoader=");
        ClassLoader r7 = r5.getClassLoader();
        if (r7 == null) goto L8;
        Class<?> r8 = r7.getClass();
        if (r8 == null) goto L8;
        String r9 = r8.getName();
        if (r9 == null) goto L8;
    L9:
        r0.b(r1, r6.append(r9).toString());
        return Unit.INSTANCE;
    L8:
        r9 = "bootstrap";
        goto L9
    }

    private static final Unit runtimeSupported_delegate$lambda$3$lambda$1(AutoVirtualDisplayRecordSetFramework r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        d.f5954a.b(r4.tag, "runtime capability unavailable namespace=" + r4.api.getNamespace() + " reason=" + r5.getClass().getSimpleName());
        return Unit.INSTANCE;
    }

    public final boolean add(long r4, String[] r6) {
        Intrinsics.checkNotNullParameter(r6, "packageNames");
        if (getRuntimeSupported() == true) goto L13;
        return false;
    L13:
    L15:
        return getOfficialApiCalls().add(r4, r6);
    L9:
        e = e;
        d.b r5 = d.f5954a;
        String r7 = this.tag;
        StringBuilder r3 = new StringBuilder().append(this.api.getNamespace());
        String r1 = " addAutoVirtualDisplayRecordPackages failed";
    L11:
        r5.b(r7, r3.append(r1).toString(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    L7:
        e = e;
        r5 = d.f5954a;
        r7 = this.tag;
        r3 = new StringBuilder().append(this.api.getNamespace());
        r1 = " addAutoVirtualDisplayRecordPackages linkage failed";
        goto L11
    }

    public final long begin(int r5, int r6, ObricAutoVirtualDisplayRecordSetListener r7) {
        Intrinsics.checkNotNullParameter(r7, "listener");
        if (getRuntimeSupported() == true) goto L13;
        return 0;
    L13:
    L15:
        return getOfficialApiCalls().begin(r5, r6, r7);
    L9:
        e = e;
        d.b r8 = d.f5954a;
        String r9 = this.tag;
        StringBuilder r4 = new StringBuilder().append(this.api.getNamespace());
        String r1 = " beginAutoVirtualDisplayRecordSet failed";
    L11:
        r8.b(r9, r4.append(r1).toString(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return 0;
    L7:
        e = e;
        r8 = d.f5954a;
        r9 = this.tag;
        r4 = new StringBuilder().append(this.api.getNamespace());
        r1 = " beginAutoVirtualDisplayRecordSet linkage failed";
        goto L11
    }

    public final void end(long r4) {
        if (getRuntimeSupported() == true) goto L13;
        return;
    L13:
        getOfficialApiCalls().end(r4);     // Catch: LinkageError -> L7 Exception -> L9
    L15:
        return;
    L9:
        e = e;
        d.b r5 = d.f5954a;
        String r1 = this.tag;
        StringBuilder r3 = new StringBuilder().append(this.api.getNamespace());
        String r2 = " endAutoVirtualDisplayRecordSet failed";
    L11:
        r5.b(r1, r3.append(r2).toString(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        e = e;
        r5 = d.f5954a;
        r1 = this.tag;
        r3 = new StringBuilder().append(this.api.getNamespace());
        r2 = " endAutoVirtualDisplayRecordSet linkage failed";
        goto L11
    }

    public final boolean isSupported() {
        return getRuntimeSupported();
    }
}
