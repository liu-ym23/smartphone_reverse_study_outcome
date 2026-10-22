package com.bytedance.ai.bridge.method.device.calendar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/calendar/RepeatInterval;", "", "<init>", "(Ljava/lang/String;I)V", "DAY", "WEEK", "MONTH", "YEAR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum RepeatInterval extends Enum<RepeatInterval> {
    public static final RepeatInterval DAY = null;
    public static final RepeatInterval MONTH = null;
    public static final RepeatInterval WEEK = null;
    public static final RepeatInterval YEAR = null;
    public static final /* synthetic */ RepeatInterval[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RepeatInterval> getEntries() {
        return b;
    }

    static {
        RepeatInterval r0 = new RepeatInterval("DAY", 0);
        DAY = r0;
        RepeatInterval r1 = new RepeatInterval("WEEK", 1);
        WEEK = r1;
        RepeatInterval r10 = new RepeatInterval("MONTH", 2);
        MONTH = r10;
        RepeatInterval r11 = new RepeatInterval("YEAR", 3);
        YEAR = r11;
        RepeatInterval[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static RepeatInterval[] values() {
        return (RepeatInterval[]) a.clone();
    }

    public static RepeatInterval valueOf(String r1) {
        return (RepeatInterval) r27.a.a(RepeatInterval.class, r1);
    }

    public RepeatInterval(String r1, int r10) {
        super(r1, r10);
    }
}
