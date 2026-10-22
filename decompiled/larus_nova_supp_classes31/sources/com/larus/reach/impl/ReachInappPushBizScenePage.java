package com.larus.reach.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/reach/impl/ReachInappPushBizScenePage;", "", "protocolValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getProtocolValue", "()Ljava/lang/String;", "COLD_START", "HOT_START", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ReachInappPushBizScenePage extends Enum<ReachInappPushBizScenePage> {
    public static final ReachInappPushBizScenePage COLD_START = null;
    public static final ReachInappPushBizScenePage HOT_START = null;
    public static final /* synthetic */ ReachInappPushBizScenePage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String protocolValue;

    public static EnumEntries<ReachInappPushBizScenePage> getEntries() {
        return b;
    }

    static {
        ReachInappPushBizScenePage r0 = new ReachInappPushBizScenePage("COLD_START", 0, "cold_start");
        COLD_START = r0;
        ReachInappPushBizScenePage r1 = new ReachInappPushBizScenePage("HOT_START", 1, "hot_start");
        HOT_START = r1;
        ReachInappPushBizScenePage[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static ReachInappPushBizScenePage[] values() {
        return (ReachInappPushBizScenePage[]) a.clone();
    }

    public final String getProtocolValue() {
        return this.protocolValue;
    }

    public static ReachInappPushBizScenePage valueOf(String r1) {
        return (ReachInappPushBizScenePage) r27.a.a(ReachInappPushBizScenePage.class, r1);
    }

    public ReachInappPushBizScenePage(String r1, int r2, String r3) {
        super(r1, r2);
        this.protocolValue = r3;
    }
}
