package com.bytedance.android.livesdk.interactivity.api.publicscreen.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/model/PublicScreenHeatState;", BuildConfig.FLAVOR, "DEFAULT", "HOT", "COLD", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PublicScreenHeatState extends Enum<PublicScreenHeatState> {
    public static final PublicScreenHeatState COLD = null;
    public static final PublicScreenHeatState DEFAULT = null;
    public static final PublicScreenHeatState HOT = null;
    public static final /* synthetic */ PublicScreenHeatState[] a = null;

    static {
        PublicScreenHeatState r1 = new PublicScreenHeatState("DEFAULT", 0);
        DEFAULT = r1;
        PublicScreenHeatState r2 = new PublicScreenHeatState("HOT", 1);
        HOT = r2;
        PublicScreenHeatState r3 = new PublicScreenHeatState("COLD", 2);
        COLD = r3;
        a = new PublicScreenHeatState[]{r1, r2, r3};
    }

    public static PublicScreenHeatState valueOf(String r1) {
        return (PublicScreenHeatState) r27.a.a(PublicScreenHeatState.class, r1);
    }

    public static PublicScreenHeatState[] values() {
        return (PublicScreenHeatState[]) a.clone();
    }

    public PublicScreenHeatState(String r1, int r2) {
        super(r1, r2);
    }
}
