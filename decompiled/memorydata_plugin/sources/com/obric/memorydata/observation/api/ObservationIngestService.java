package com.obric.memorydata.observation.api;

import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J!\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0010H\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/observation/api/ObservationIngestService;", "Lcom/obric/memorydata/observation/api/ObservationIngest;", "<init>", "()V", "writeAgent", "", "timestamp", "", "agentText", "", ObricMemoryConstants.KEY_SESSION_ID, "writeGlasses", "input", "Lcom/obric/memorydata/observation/api/GlassesObservationInput;", "writeOAuto", "writeScreenshot", "Lcom/obric/memorydata/observation/api/ScreenshotObservationInput;", "observation_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObservationIngestService implements ObservationIngest {
    public static final ObservationIngestService INSTANCE = null;
    private final /* synthetic */ ObservationIngest $$delegate_0;

    static {
        INSTANCE = new ObservationIngestService();
    }

    private ObservationIngestService() {
        ObservationIngest r0 = (ObservationIngest) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(ObservationIngest.class)), ObservationIngest.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = (ObservationIngest) ZeusTransformUtils.preCheckCast(DefaultObservationIngest.INSTANCE, ObservationIngest.class, "com.obric.memorydata.plugin");
    L5:
        this.$$delegate_0 = r0;
    }

    @Override // com.obric.memorydata.observation.api.ObservationIngest
    public void writeAgent(long r2, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "agentText");
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_SESSION_ID);
        this.$$delegate_0.writeAgent(r2, r4, r5);
    }

    @Override // com.obric.memorydata.observation.api.ObservationIngest
    public void writeGlasses(a r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        this.$$delegate_0.writeGlasses(r2);
    }

    @Override // com.obric.memorydata.observation.api.ObservationIngest
    public void writeOAuto(long r2, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "agentText");
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_SESSION_ID);
        this.$$delegate_0.writeOAuto(r2, r4, r5);
    }

    @Override // com.obric.memorydata.observation.api.ObservationIngest
    public long writeScreenshot(b r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        return this.$$delegate_0.writeScreenshot(r2);
    }
}
