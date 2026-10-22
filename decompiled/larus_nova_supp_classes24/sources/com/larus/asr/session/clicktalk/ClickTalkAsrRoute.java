package com.larus.asr.session.clicktalk;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/asr/session/clicktalk/ClickTalkAsrRoute;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO_STOP", "FLOW_ASR_TASK", "REALTIME_SERVICE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ClickTalkAsrRoute extends Enum<ClickTalkAsrRoute> {
    public static final ClickTalkAsrRoute AUTO_STOP = null;
    public static final ClickTalkAsrRoute FLOW_ASR_TASK = null;
    public static final ClickTalkAsrRoute REALTIME_SERVICE = null;
    public static final /* synthetic */ ClickTalkAsrRoute[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ClickTalkAsrRoute> getEntries() {
        return b;
    }

    static {
        ClickTalkAsrRoute r0 = new ClickTalkAsrRoute("AUTO_STOP", 0);
        AUTO_STOP = r0;
        ClickTalkAsrRoute r1 = new ClickTalkAsrRoute("FLOW_ASR_TASK", 1);
        FLOW_ASR_TASK = r1;
        ClickTalkAsrRoute r3 = new ClickTalkAsrRoute("REALTIME_SERVICE", 2);
        REALTIME_SERVICE = r3;
        ClickTalkAsrRoute[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ClickTalkAsrRoute[] values() {
        return (ClickTalkAsrRoute[]) a.clone();
    }

    public static ClickTalkAsrRoute valueOf(String r1) {
        return (ClickTalkAsrRoute) r27.a.a(ClickTalkAsrRoute.class, r1);
    }

    public ClickTalkAsrRoute(String r1, int r2) {
        super(r1, r2);
    }
}
