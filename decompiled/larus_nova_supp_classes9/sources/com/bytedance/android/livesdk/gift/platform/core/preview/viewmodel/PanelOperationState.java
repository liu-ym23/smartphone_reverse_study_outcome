package com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/viewmodel/PanelOperationState;", BuildConfig.FLAVOR, "UNKNOWN", "Add", "Remove", "Top", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelOperationState extends Enum<PanelOperationState> {
    public static final PanelOperationState Add = null;
    public static final PanelOperationState Remove = null;
    public static final PanelOperationState Top = null;
    public static final PanelOperationState UNKNOWN = null;
    public static final /* synthetic */ PanelOperationState[] a = null;

    static {
        PanelOperationState r1 = new PanelOperationState("UNKNOWN", 0);
        UNKNOWN = r1;
        PanelOperationState r2 = new PanelOperationState("Add", 1);
        Add = r2;
        PanelOperationState r3 = new PanelOperationState("Remove", 2);
        Remove = r3;
        PanelOperationState r4 = new PanelOperationState("Top", 3);
        Top = r4;
        a = new PanelOperationState[]{r1, r2, r3, r4};
    }

    public static PanelOperationState valueOf(String r1) {
        return (PanelOperationState) r27.a.a(PanelOperationState.class, r1);
    }

    public static PanelOperationState[] values() {
        return (PanelOperationState[]) a.clone();
    }

    public PanelOperationState(String r1, int r2) {
        super(r1, r2);
    }
}
