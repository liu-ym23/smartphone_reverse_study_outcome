package com.bytedance.android.live.liveinteract.revenuebase;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenuebase/PaidWidgetType;", "", "INTERACT", "VIDEO", "AUDIO", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PaidWidgetType extends Enum<PaidWidgetType> {
    public static final PaidWidgetType AUDIO = null;
    public static final PaidWidgetType INTERACT = null;
    public static final PaidWidgetType VIDEO = null;
    public static final /* synthetic */ PaidWidgetType[] a = null;

    static {
        PaidWidgetType r1 = new PaidWidgetType("INTERACT", 0);
        INTERACT = r1;
        PaidWidgetType r2 = new PaidWidgetType("VIDEO", 1);
        VIDEO = r2;
        PaidWidgetType r3 = new PaidWidgetType("AUDIO", 2);
        AUDIO = r3;
        a = new PaidWidgetType[]{r1, r2, r3};
    }

    public static PaidWidgetType valueOf(String r1) {
        return (PaidWidgetType) r27.a.a(PaidWidgetType.class, r1);
    }

    public static PaidWidgetType[] values() {
        return (PaidWidgetType[]) a.clone();
    }

    public PaidWidgetType(String r1, int r2) {
        super(r1, r2);
    }
}
