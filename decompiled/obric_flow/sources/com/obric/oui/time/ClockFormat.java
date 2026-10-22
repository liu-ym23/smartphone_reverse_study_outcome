package com.obric.oui.time;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/time/ClockFormat;", "", "H12", "H24", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum ClockFormat extends Enum<ClockFormat> {
    public static final ClockFormat H12 = null;
    public static final ClockFormat H24 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClockFormat[] f14761a = null;

    static {
        ClockFormat r5 = new ClockFormat("H12", 0);
        H12 = r5;
        ClockFormat r10 = new ClockFormat("H24", 1);
        H24 = r10;
        f14761a = new ClockFormat[]{r5, r10};
    }

    public static ClockFormat valueOf(String r5) {
        return (ClockFormat) Enum.valueOf(ClockFormat.class, r5);
    }

    public static ClockFormat[] values() {
        return (ClockFormat[]) f14761a.clone();
    }
}
