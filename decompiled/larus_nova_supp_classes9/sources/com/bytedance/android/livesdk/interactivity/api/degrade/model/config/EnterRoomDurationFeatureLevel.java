package com.bytedance.android.livesdk.interactivity.api.degrade.model.config;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/config/EnterRoomDurationFeatureLevel;", BuildConfig.FLAVOR, "InEnterRoomDuration", "OutEnterRoomDuration", "LEVEL_SMART", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EnterRoomDurationFeatureLevel extends Enum<EnterRoomDurationFeatureLevel> {
    public static final EnterRoomDurationFeatureLevel InEnterRoomDuration = null;
    public static final EnterRoomDurationFeatureLevel LEVEL_SMART = null;
    public static final EnterRoomDurationFeatureLevel OutEnterRoomDuration = null;
    public static final /* synthetic */ EnterRoomDurationFeatureLevel[] a = null;

    static {
        EnterRoomDurationFeatureLevel r1 = new EnterRoomDurationFeatureLevel("InEnterRoomDuration", 0);
        InEnterRoomDuration = r1;
        EnterRoomDurationFeatureLevel r2 = new EnterRoomDurationFeatureLevel("OutEnterRoomDuration", 1);
        OutEnterRoomDuration = r2;
        EnterRoomDurationFeatureLevel r3 = new EnterRoomDurationFeatureLevel("LEVEL_SMART", 2);
        LEVEL_SMART = r3;
        a = new EnterRoomDurationFeatureLevel[]{r1, r2, r3};
    }

    public static EnterRoomDurationFeatureLevel valueOf(String r1) {
        return (EnterRoomDurationFeatureLevel) a.a(EnterRoomDurationFeatureLevel.class, r1);
    }

    public static EnterRoomDurationFeatureLevel[] values() {
        return (EnterRoomDurationFeatureLevel[]) a.clone();
    }

    public EnterRoomDurationFeatureLevel(String r1, int r2) {
        super(r1, r2);
    }
}
