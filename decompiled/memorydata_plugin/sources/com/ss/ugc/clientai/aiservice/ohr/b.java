package com.ss.ugc.clientai.aiservice.ohr;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/ss/ugc/clientai/aiservice/ohr/OHRConfig;", "", "engineFactory", "Lcom/ss/ugc/clientai/aiservice/AIEngineFactory;", "(Lcom/ss/ugc/clientai/aiservice/AIEngineFactory;)V", "getEngineFactory", "()Lcom/ss/ugc/clientai/aiservice/AIEngineFactory;", "minInterval", "", "getMinInterval", "()J", "setMinInterval", "(J)V", "sampleCount", "", "getSampleCount", "()I", "setSampleCount", "(I)V", "workFlowTracker", "Lcom/ss/ugc/clientai/aiservice/ohr/WorkFlowTracker;", "getWorkFlowTracker", "()Lcom/ss/ugc/clientai/aiservice/ohr/WorkFlowTracker;", "setWorkFlowTracker", "(Lcom/ss/ugc/clientai/aiservice/ohr/WorkFlowTracker;)V", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f15786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f15787b;
    private int c;
    private final com.ss.ugc.clientai.aiservice.b d;

    public b(com.ss.ugc.clientai.aiservice.b r3) {
        com.ss.ugc.clientai.aiservice.b r4 = (com.ss.ugc.clientai.aiservice.b) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.ugc.clientai.aiservice.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "engineFactory");
        this.d = r4;
        this.f15787b = 5000;
        this.c = 9;
    }

    public final h a() {
        return this.f15786a;
    }

    public final long b() {
        return this.f15787b;
    }

    public final int c() {
        return this.c;
    }

    public final com.ss.ugc.clientai.aiservice.b d() {
        return this.d;
    }
}
