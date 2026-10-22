package com.obric.memorydata.observation.api;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/observation/api/DefaultObservationIngest;", "Lcom/obric/memorydata/observation/api/ObservationIngest;", "<init>", "()V", "writeScreenshot", "", "input", "Lcom/obric/memorydata/observation/api/ScreenshotObservationInput;", "writeAgent", "", "timestamp", "agentText", "", ObricMemoryConstants.KEY_SESSION_ID, "writeOAuto", "writeGlasses", "Lcom/obric/memorydata/observation/api/GlassesObservationInput;", "observation_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultObservationIngest implements ObservationIngest {
    public static final DefaultObservationIngest INSTANCE = null;

    static {
        INSTANCE = new DefaultObservationIngest();
    }

    private DefaultObservationIngest() {
    }

    @Override // com.obric.memorydata.observation.api.ObservationIngest
    public void writeAgent(long r1, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "agentText");
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_SESSION_ID);
    }

    @Override // com.obric.memorydata.observation.api.ObservationIngest
    public void writeGlasses(a r1) {
        Intrinsics.checkNotNullParameter(r1, "input");
    }

    @Override // com.obric.memorydata.observation.api.ObservationIngest
    public void writeOAuto(long r1, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "agentText");
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_SESSION_ID);
    }

    @Override // com.obric.memorydata.observation.api.ObservationIngest
    public long writeScreenshot(b r1) {
        Intrinsics.checkNotNullParameter(r1, "input");
        return 0;
    }
}
