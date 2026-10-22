package com.larus.dora.impl.device.settings.camera.timeoptions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/device/settings/camera/timeoptions/TimeOptionsPageType;", "", "<init>", "(Ljava/lang/String;I)V", "INTERVAL", "MAX_DURATION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TimeOptionsPageType extends Enum<TimeOptionsPageType> {
    public static final TimeOptionsPageType INTERVAL = null;
    public static final TimeOptionsPageType MAX_DURATION = null;
    public static final /* synthetic */ TimeOptionsPageType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TimeOptionsPageType> getEntries() {
        return b;
    }

    static {
        TimeOptionsPageType r0 = new TimeOptionsPageType("INTERVAL", 0);
        INTERVAL = r0;
        TimeOptionsPageType r1 = new TimeOptionsPageType("MAX_DURATION", 1);
        MAX_DURATION = r1;
        TimeOptionsPageType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static TimeOptionsPageType[] values() {
        return (TimeOptionsPageType[]) a.clone();
    }

    public static TimeOptionsPageType valueOf(String r1) {
        return (TimeOptionsPageType) a.a(TimeOptionsPageType.class, r1);
    }

    public TimeOptionsPageType(String r1, int r2) {
        super(r1, r2);
    }
}
