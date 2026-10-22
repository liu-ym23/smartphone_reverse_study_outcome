package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/PanelOperateStatus;", BuildConfig.FLAVOR, "Idle", "Operate", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelOperateStatus extends Enum<PanelOperateStatus> {
    public static final PanelOperateStatus Idle = null;
    public static final PanelOperateStatus Operate = null;
    public static final /* synthetic */ PanelOperateStatus[] a = null;

    static {
        PanelOperateStatus r1 = new PanelOperateStatus("Idle", 0);
        Idle = r1;
        PanelOperateStatus r2 = new PanelOperateStatus("Operate", 1);
        Operate = r2;
        a = new PanelOperateStatus[]{r1, r2};
    }

    public static PanelOperateStatus valueOf(String r1) {
        return (PanelOperateStatus) r27.a.a(PanelOperateStatus.class, r1);
    }

    public static PanelOperateStatus[] values() {
        return (PanelOperateStatus[]) a.clone();
    }

    public PanelOperateStatus(String r1, int r2) {
        super(r1, r2);
    }
}
