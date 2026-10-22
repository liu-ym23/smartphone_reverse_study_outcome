package com.obric.memorydata.personalcontext.datausage.plugin.action.manager;

import android.os.Bundle;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCAppFcEntitySearchParams;
import com.obric.capabilitykit.common.intent.PCCommonGlobalSearchParams;
import com.obric.capabilitykit.common.intent.PCGlobalSearchParams;
import com.obric.capabilitykit.common.intent.PCIntentGlobalSearchParams;
import com.obric.capabilitykit.common.intent.PCPersonalContextFetchParams;
import com.obric.capabilitykit.common.intent.PCPersonalContextSearchParams;
import com.obric.capabilitykit.common.intent.PCSearchAppEntityParams;
import com.obric.capabilitykit.common.intent.RCSearchParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eR*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\b\u0012\u0006\b\u0001\u0012\u00020\u00010\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/IntentExecutorDispatcher;", "", "<init>", "()V", "MEMORY_INTENT_EXECUTOR_MAP", "", "", "Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/IntentExecutorData;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "dispatchMemoryIntentExecutor", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", "method", "extras", "Landroid/os/Bundle;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, e<? extends IntentParams, ? extends Object>> f12088b = null;

    static {
        f12087a = new f();
        f12088b = MapsKt.mapOf(new Pair[]{TuplesKt.to("pcGlobalSearchIntent", new e(PCGlobalSearchParams.class, (d) ZeusTransformUtils.preCheckCast(c.f12084a, d.class, "com.obric.memorydata.plugin"))), TuplesKt.to("pcCommonGlobalSearchIntent", new e(PCCommonGlobalSearchParams.class, (d) ZeusTransformUtils.preCheckCast(b.f12083a, d.class, "com.obric.memorydata.plugin"))), TuplesKt.to("pcPersonalContextFetchIntent", new e(PCPersonalContextFetchParams.class, (d) ZeusTransformUtils.preCheckCast(h.f12090a, d.class, "com.obric.memorydata.plugin"))), TuplesKt.to("pcPersonalContextSearchIntent", new e(PCPersonalContextSearchParams.class, (d) ZeusTransformUtils.preCheckCast(i.f12091a, d.class, "com.obric.memorydata.plugin"))), TuplesKt.to("pcIntentGlobalSearchIntent", new e(PCIntentGlobalSearchParams.class, (d) ZeusTransformUtils.preCheckCast(g.f12089a, d.class, "com.obric.memorydata.plugin"))), TuplesKt.to("pcSearchAppEntityIntent", new e(PCSearchAppEntityParams.class, (d) ZeusTransformUtils.preCheckCast(k.f12093a, d.class, "com.obric.memorydata.plugin"))), TuplesKt.to("pcAppFcEntitySearchIntent", new e(PCAppFcEntitySearchParams.class, (d) ZeusTransformUtils.preCheckCast(a.f12082a, d.class, "com.obric.memorydata.plugin"))), TuplesKt.to("rcGlobalSearchIntent", new e(RCSearchParams.class, (d) ZeusTransformUtils.preCheckCast(j.f12092a, d.class, "com.obric.memorydata.plugin")))});
    }

    private f() {
    }

    public final IntentResult<Empty> a(String r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r19, "method");
        Intrinsics.checkNotNullParameter(r20, "extras");
        e r2 = (e) ZeusTransformUtils.preCheckCast(f12088b.get(r19), e.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        IntentParams r0 = (IntentParams) ZeusTransformUtils.preCheckCast(r20.getParcelable("memoryIntentExecutorParams", r2.a()), IntentParams.class, "com.obric.memorydata.plugin");
        if (r20.containsKey("questionId") == false) goto L9;
        Long r1 = Long.valueOf(r20.getLong("questionId"));
    L10:
        d r3 = r2.b();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.memorydata.personalcontext.datausage.plugin.action.manager.IMemoryIntentExecutor<com.obric.capabilitykit.common.intent.IntentParams, com.obric.capabilitykit.common.intent.Empty>");
        return r3.a(r0, r1);
    L9:
        r1 = null;
        goto L10
    L5:
        return new IntentResult(1, null, null, "no executor for " + r19, false, false, 256, null, null, null, 950, null);
    }
}
