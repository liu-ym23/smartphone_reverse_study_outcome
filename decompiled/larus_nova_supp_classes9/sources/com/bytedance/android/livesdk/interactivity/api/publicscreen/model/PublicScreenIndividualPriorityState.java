package com.bytedance.android.livesdk.interactivity.api.publicscreen.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/model/PublicScreenIndividualPriorityState;", BuildConfig.FLAVOR, "DEFAULT", "HIGH_PROTECT", "LOW_DEGRADE", "HIT_ALL", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PublicScreenIndividualPriorityState extends Enum<PublicScreenIndividualPriorityState> {
    public static final PublicScreenIndividualPriorityState DEFAULT = null;
    public static final PublicScreenIndividualPriorityState HIGH_PROTECT = null;
    public static final PublicScreenIndividualPriorityState HIT_ALL = null;
    public static final PublicScreenIndividualPriorityState LOW_DEGRADE = null;
    public static final /* synthetic */ PublicScreenIndividualPriorityState[] a = null;

    static {
        PublicScreenIndividualPriorityState r1 = new PublicScreenIndividualPriorityState("DEFAULT", 0);
        DEFAULT = r1;
        PublicScreenIndividualPriorityState r2 = new PublicScreenIndividualPriorityState("HIGH_PROTECT", 1);
        HIGH_PROTECT = r2;
        PublicScreenIndividualPriorityState r3 = new PublicScreenIndividualPriorityState("LOW_DEGRADE", 2);
        LOW_DEGRADE = r3;
        PublicScreenIndividualPriorityState r4 = new PublicScreenIndividualPriorityState("HIT_ALL", 3);
        HIT_ALL = r4;
        a = new PublicScreenIndividualPriorityState[]{r1, r2, r3, r4};
    }

    public static PublicScreenIndividualPriorityState valueOf(String r1) {
        return (PublicScreenIndividualPriorityState) r27.a.a(PublicScreenIndividualPriorityState.class, r1);
    }

    public static PublicScreenIndividualPriorityState[] values() {
        return (PublicScreenIndividualPriorityState[]) a.clone();
    }

    public PublicScreenIndividualPriorityState(String r1, int r2) {
        super(r1, r2);
    }
}
