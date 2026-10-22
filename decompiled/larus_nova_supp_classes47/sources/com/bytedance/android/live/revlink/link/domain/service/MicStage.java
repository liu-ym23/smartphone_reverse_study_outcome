package com.bytedance.android.live.revlink.link.domain.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/link/domain/service/MicStage;", "", "Idle", "Reuse", "NewCreated", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MicStage extends Enum<MicStage> {
    public static final MicStage Idle = null;
    public static final MicStage NewCreated = null;
    public static final MicStage Reuse = null;
    public static final /* synthetic */ MicStage[] a = null;

    static {
        MicStage r1 = new MicStage("Idle", 0);
        Idle = r1;
        MicStage r2 = new MicStage("Reuse", 1);
        Reuse = r2;
        MicStage r3 = new MicStage("NewCreated", 2);
        NewCreated = r3;
        a = new MicStage[]{r1, r2, r3};
    }

    public static MicStage valueOf(String r1) {
        return (MicStage) r27.a.a(MicStage.class, r1);
    }

    public static MicStage[] values() {
        return (MicStage[]) a.clone();
    }

    public MicStage(String r1, int r2) {
        super(r1, r2);
    }
}
