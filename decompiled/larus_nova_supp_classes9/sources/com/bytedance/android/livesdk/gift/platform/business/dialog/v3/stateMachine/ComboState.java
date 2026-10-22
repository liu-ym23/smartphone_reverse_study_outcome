package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "IDLE", "ON_SINGLE_CLICK", "ON_LONG_CLICK", "ON_COUNT_DOWN", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ComboState extends Enum<ComboState> {
    private static final /* synthetic */ ComboState[] $VALUES = null;
    public static final ComboState IDLE = null;
    public static final ComboState ON_COUNT_DOWN = null;
    public static final ComboState ON_LONG_CLICK = null;
    public static final ComboState ON_SINGLE_CLICK = null;

    static {
        ComboState r1 = new ComboState("IDLE", 0);
        IDLE = r1;
        ComboState r2 = new ComboState("ON_SINGLE_CLICK", 1);
        ON_SINGLE_CLICK = r2;
        ComboState r3 = new ComboState("ON_LONG_CLICK", 2);
        ON_LONG_CLICK = r3;
        ComboState r4 = new ComboState("ON_COUNT_DOWN", 3);
        ON_COUNT_DOWN = r4;
        $VALUES = new ComboState[]{r1, r2, r3, r4};
    }

    public static ComboState valueOf(String r1) {
        return (ComboState) a.a(ComboState.class, r1);
    }

    public static ComboState[] values() {
        return (ComboState[]) $VALUES.clone();
    }

    private ComboState(String r1, int r2) {
        super(r1, r2);
    }
}
