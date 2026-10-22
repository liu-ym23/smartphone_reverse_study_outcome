package com.bytedance.android.livesdk.ktvapi;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/KtvRoomUserLabel;", BuildConfig.FLAVOR, "UNKNOWN", "SINGER", "NEXT", "ORDERED", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KtvRoomUserLabel extends Enum<KtvRoomUserLabel> {
    public static final KtvRoomUserLabel NEXT = null;
    public static final KtvRoomUserLabel ORDERED = null;
    public static final KtvRoomUserLabel SINGER = null;
    public static final KtvRoomUserLabel UNKNOWN = null;
    public static final /* synthetic */ KtvRoomUserLabel[] a = null;

    static {
        KtvRoomUserLabel r1 = new KtvRoomUserLabel("UNKNOWN", 0);
        UNKNOWN = r1;
        KtvRoomUserLabel r2 = new KtvRoomUserLabel("SINGER", 1);
        SINGER = r2;
        KtvRoomUserLabel r3 = new KtvRoomUserLabel("NEXT", 2);
        NEXT = r3;
        KtvRoomUserLabel r4 = new KtvRoomUserLabel("ORDERED", 3);
        ORDERED = r4;
        a = new KtvRoomUserLabel[]{r1, r2, r3, r4};
    }

    public static KtvRoomUserLabel valueOf(String r1) {
        return (KtvRoomUserLabel) a.a(KtvRoomUserLabel.class, r1);
    }

    public static KtvRoomUserLabel[] values() {
        return (KtvRoomUserLabel[]) a.clone();
    }

    public KtvRoomUserLabel(String r1, int r2) {
        super(r1, r2);
    }
}
