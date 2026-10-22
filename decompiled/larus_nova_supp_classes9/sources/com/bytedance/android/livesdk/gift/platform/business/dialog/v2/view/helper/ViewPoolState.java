package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.helper;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/helper/ViewPoolState;", BuildConfig.FLAVOR, "IDLE", "ON_USING", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ViewPoolState extends Enum<ViewPoolState> {
    public static final ViewPoolState IDLE = null;
    public static final ViewPoolState ON_USING = null;
    public static final /* synthetic */ ViewPoolState[] a = null;

    static {
        ViewPoolState r1 = new ViewPoolState("IDLE", 0);
        IDLE = r1;
        ViewPoolState r2 = new ViewPoolState("ON_USING", 1);
        ON_USING = r2;
        a = new ViewPoolState[]{r1, r2};
    }

    public static ViewPoolState valueOf(String r1) {
        return (ViewPoolState) a.a(ViewPoolState.class, r1);
    }

    public static ViewPoolState[] values() {
        return (ViewPoolState[]) a.clone();
    }

    public ViewPoolState(String r1, int r2) {
        super(r1, r2);
    }
}
