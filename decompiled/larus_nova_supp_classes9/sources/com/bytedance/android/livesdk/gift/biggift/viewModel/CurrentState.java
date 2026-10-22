package com.bytedance.android.livesdk.gift.biggift.viewModel;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/biggift/viewModel/CurrentState;", BuildConfig.FLAVOR, "Init", "Combo", "DisMiss", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CurrentState extends Enum<CurrentState> {
    public static final CurrentState Combo = null;
    public static final CurrentState DisMiss = null;
    public static final CurrentState Init = null;
    public static final /* synthetic */ CurrentState[] a = null;

    static {
        CurrentState r1 = new CurrentState("Init", 0);
        Init = r1;
        CurrentState r2 = new CurrentState("Combo", 1);
        Combo = r2;
        CurrentState r3 = new CurrentState("DisMiss", 2);
        DisMiss = r3;
        a = new CurrentState[]{r1, r2, r3};
    }

    public static CurrentState valueOf(String r1) {
        return (CurrentState) r27.a.a(CurrentState.class, r1);
    }

    public static CurrentState[] values() {
        return (CurrentState[]) a.clone();
    }

    public CurrentState(String r1, int r2) {
        super(r1, r2);
    }
}
