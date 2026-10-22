package com.larus.av_call.model;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/av_call/model/RealtimePageMode;", "", "<init>", "(Ljava/lang/String;I)V", "HALF_SCREEN", "FULL_SCREEN", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum RealtimePageMode extends Enum<RealtimePageMode> {
    public static final RealtimePageMode FULL_SCREEN = null;
    public static final RealtimePageMode HALF_SCREEN = null;
    public static final /* synthetic */ RealtimePageMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RealtimePageMode> getEntries() {
        return b;
    }

    static {
        RealtimePageMode r0 = new RealtimePageMode("HALF_SCREEN", 0);
        HALF_SCREEN = r0;
        RealtimePageMode r1 = new RealtimePageMode("FULL_SCREEN", 1);
        FULL_SCREEN = r1;
        RealtimePageMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static RealtimePageMode[] values() {
        return (RealtimePageMode[]) a.clone();
    }

    public static RealtimePageMode valueOf(String r1) {
        return (RealtimePageMode) a.a(RealtimePageMode.class, r1);
    }

    public RealtimePageMode(String r1, int r2) {
        super(r1, r2);
    }
}
