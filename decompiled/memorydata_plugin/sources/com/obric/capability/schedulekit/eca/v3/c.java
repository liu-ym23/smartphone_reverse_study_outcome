package com.obric.capability.schedulekit.eca.v3;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.execution.eca.ECAAction;
import com.obric.capabilitykit.common.execution.eca.ECAInputParam;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECABuilderV3;", "", "()V", "mCurrentAction", "Lcom/obric/capability/schedulekit/eca/v3/ECAAppIntentV3;", "mCurrentActionsList", "", "mCurrentJob", "Lcom/obric/capability/schedulekit/eca/v3/ECAJobV3;", "mJobs", "addImpl", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "addInputParam", "paramName", "paramValue", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "build", "Lcom/obric/capability/schedulekit/eca/v3/ECAScriptV3;", "newAction", ActivityLifecycle.NAME, "ecaId", "newJob", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<f> f7397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f7398b;
    private List<b> c;
    private b d;

    public c() {
        this.f7397a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ c a(c r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = "";
    L6:
        return r0.a(r1, r2);
    }

    public final c a() {
        f r0 = this.f7398b;
        if (r0 == null) goto L5;
        r0.commit();
        this.f7397a.add(r0);
    L5:
        List<b> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.c = r1;
        f r2 = new f(r1);
        this.f7398b = r2;
        this.f7397a.add(r2);
        return this;
    }

    public final c a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        b r0 = this.d;
        if (r0 == null) goto L5;
        r0.getImpls().add(r2);
    L5:
        return this;
    }

    public final c a(String r3, ECAInputParam r4) {
        Intrinsics.checkNotNullParameter(r3, "paramName");
        Intrinsics.checkNotNullParameter(r4, "paramValue");
        b r0 = this.d;
        if (r0 == null) goto L5;
        d r1 = new d(r4);
        r0.getInputParams().put(r3, r1);
        r1.setParent((ECAAction) ZeusTransformUtils.preCheckCast(r0, ECAAction.class, "com.obric.memorydata.plugin"));
        r1.commit();
    L5:
        return this;
    }

    public final c a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "ecaId");
        List<b> r0 = this.c;
        if (r0 == null) goto L7;
        b r1 = new b();
        r1.setActionName(r4);
        r1.setEcaId(r5);
        r1.setInputParams((Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin"));
        r1.setImpls((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        r0.add(r1);
        this.d = r1;
        return this;
    L7:
        throw new IllegalStateException("no current job; use newJob() first.");
    }

    public final g b() {
        g r0 = new g();
        r0.setJobs(this.f7397a);
        return r0;
    }
}
