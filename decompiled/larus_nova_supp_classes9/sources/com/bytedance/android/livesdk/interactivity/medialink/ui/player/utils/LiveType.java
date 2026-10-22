package com.bytedance.android.livesdk.interactivity.medialink.ui.player.utils;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/player/utils/LiveType;", BuildConfig.FLAVOR, "PC_LIVE", "VIDEO", "OTHERS", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveType extends Enum<LiveType> {
    public static final LiveType OTHERS = null;
    public static final LiveType PC_LIVE = null;
    public static final LiveType VIDEO = null;
    public static final /* synthetic */ LiveType[] a = null;

    static {
        LiveType r1 = new LiveType("PC_LIVE", 0);
        PC_LIVE = r1;
        LiveType r2 = new LiveType("VIDEO", 1);
        VIDEO = r2;
        LiveType r3 = new LiveType("OTHERS", 2);
        OTHERS = r3;
        a = new LiveType[]{r1, r2, r3};
    }

    public static LiveType valueOf(String r1) {
        return (LiveType) a.a(LiveType.class, r1);
    }

    public static LiveType[] values() {
        return (LiveType[]) a.clone();
    }

    public LiveType(String r1, int r2) {
        super(r1, r2);
    }
}
