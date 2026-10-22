package com.bytedance.android.live.effect.sticker.ui.aigc;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/aigc/AigcTaskPanelStatus;", "", "Default", "Ready", "Running", "Done", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AigcTaskPanelStatus extends Enum<AigcTaskPanelStatus> {
    public static final AigcTaskPanelStatus Default = null;
    public static final AigcTaskPanelStatus Done = null;
    public static final AigcTaskPanelStatus Ready = null;
    public static final AigcTaskPanelStatus Running = null;
    public static final /* synthetic */ AigcTaskPanelStatus[] a = null;

    static {
        AigcTaskPanelStatus r1 = new AigcTaskPanelStatus("Default", 0);
        Default = r1;
        AigcTaskPanelStatus r2 = new AigcTaskPanelStatus("Ready", 1);
        Ready = r2;
        AigcTaskPanelStatus r3 = new AigcTaskPanelStatus("Running", 2);
        Running = r3;
        AigcTaskPanelStatus r4 = new AigcTaskPanelStatus("Done", 3);
        Done = r4;
        a = new AigcTaskPanelStatus[]{r1, r2, r3, r4};
    }

    public static AigcTaskPanelStatus valueOf(String r1) {
        return (AigcTaskPanelStatus) r27.a.a(AigcTaskPanelStatus.class, r1);
    }

    public static AigcTaskPanelStatus[] values() {
        return (AigcTaskPanelStatus[]) a.clone();
    }

    public AigcTaskPanelStatus(String r1, int r2) {
        super(r1, r2);
    }
}
