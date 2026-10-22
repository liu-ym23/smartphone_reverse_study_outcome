package com.bytedance.android.live.cloudgrouplive.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/model/CloudGroupLivePipelineStatus;", "", "END", "INVITING", "START", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CloudGroupLivePipelineStatus extends Enum<CloudGroupLivePipelineStatus> {
    public static final CloudGroupLivePipelineStatus END = null;
    public static final CloudGroupLivePipelineStatus INVITING = null;
    public static final CloudGroupLivePipelineStatus START = null;
    public static final /* synthetic */ CloudGroupLivePipelineStatus[] a = null;

    static {
        CloudGroupLivePipelineStatus r1 = new CloudGroupLivePipelineStatus("END", 0);
        END = r1;
        CloudGroupLivePipelineStatus r2 = new CloudGroupLivePipelineStatus("INVITING", 1);
        INVITING = r2;
        CloudGroupLivePipelineStatus r3 = new CloudGroupLivePipelineStatus("START", 2);
        START = r3;
        a = new CloudGroupLivePipelineStatus[]{r1, r2, r3};
    }

    public static CloudGroupLivePipelineStatus valueOf(String r1) {
        return (CloudGroupLivePipelineStatus) r27.a.a(CloudGroupLivePipelineStatus.class, r1);
    }

    public static CloudGroupLivePipelineStatus[] values() {
        return (CloudGroupLivePipelineStatus[]) a.clone();
    }

    public CloudGroupLivePipelineStatus(String r1, int r2) {
        super(r1, r2);
    }
}
