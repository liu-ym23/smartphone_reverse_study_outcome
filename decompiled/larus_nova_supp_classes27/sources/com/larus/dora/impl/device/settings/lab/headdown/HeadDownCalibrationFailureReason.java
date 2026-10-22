package com.larus.dora.impl.device.settings.lab.headdown;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownCalibrationFailureReason;", "", "<init>", "(Ljava/lang/String;I)V", "MOTION", "NOT_WEARING", "TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HeadDownCalibrationFailureReason extends Enum<HeadDownCalibrationFailureReason> {
    public static final HeadDownCalibrationFailureReason MOTION = null;
    public static final HeadDownCalibrationFailureReason NOT_WEARING = null;
    public static final HeadDownCalibrationFailureReason TIMEOUT = null;
    public static final /* synthetic */ HeadDownCalibrationFailureReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HeadDownCalibrationFailureReason> getEntries() {
        return b;
    }

    static {
        HeadDownCalibrationFailureReason r0 = new HeadDownCalibrationFailureReason("MOTION", 0);
        MOTION = r0;
        HeadDownCalibrationFailureReason r1 = new HeadDownCalibrationFailureReason("NOT_WEARING", 1);
        NOT_WEARING = r1;
        HeadDownCalibrationFailureReason r3 = new HeadDownCalibrationFailureReason("TIMEOUT", 2);
        TIMEOUT = r3;
        HeadDownCalibrationFailureReason[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static HeadDownCalibrationFailureReason[] values() {
        return (HeadDownCalibrationFailureReason[]) a.clone();
    }

    public static HeadDownCalibrationFailureReason valueOf(String r1) {
        return (HeadDownCalibrationFailureReason) r27.a.a(HeadDownCalibrationFailureReason.class, r1);
    }

    public HeadDownCalibrationFailureReason(String r1, int r2) {
        super(r1, r2);
    }
}
