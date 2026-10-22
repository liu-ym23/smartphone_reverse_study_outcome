package com.bytedance.ies.argus.api.params;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/api/params/TimestampStatus;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum TimestampStatus extends Enum<TimestampStatus> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimestampStatus f4967b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimestampStatus f4968c = null;
    public static final TimestampStatus d = null;
    public static final /* synthetic */ TimestampStatus[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4969a;

    static {
        TimestampStatus r5 = new TimestampStatus("UNKNOWN", 0, "unknown");
        f4967b = r5;
        TimestampStatus r10 = new TimestampStatus("LessOrEqual", 1, "le");
        f4968c = r10;
        TimestampStatus r11 = new TimestampStatus("Greater", 2, "g");
        d = r11;
        e = new TimestampStatus[]{r5, r10, r11};
    }

    public TimestampStatus(String r5, int r10, String r11) {
        super(r5, r10);
        this.f4969a = r11;
    }

    public static TimestampStatus valueOf(String r5) {
        return (TimestampStatus) Enum.valueOf(TimestampStatus.class, r5);
    }

    public static TimestampStatus[] values() {
        return (TimestampStatus[]) e.clone();
    }
}
