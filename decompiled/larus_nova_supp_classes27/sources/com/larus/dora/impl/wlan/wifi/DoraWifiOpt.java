package com.larus.dora.impl.wlan.wifi;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/wlan/wifi/DoraWifiOpt;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "DELETE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraWifiOpt extends Enum<DoraWifiOpt> {
    public static final DoraWifiOpt ADD = null;
    public static final DoraWifiOpt DELETE = null;
    public static final /* synthetic */ DoraWifiOpt[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraWifiOpt> getEntries() {
        return b;
    }

    static {
        DoraWifiOpt r0 = new DoraWifiOpt("ADD", 0);
        ADD = r0;
        DoraWifiOpt r1 = new DoraWifiOpt("DELETE", 1);
        DELETE = r1;
        DoraWifiOpt[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DoraWifiOpt[] values() {
        return (DoraWifiOpt[]) a.clone();
    }

    public static DoraWifiOpt valueOf(String r1) {
        return (DoraWifiOpt) r27.a.a(DoraWifiOpt.class, r1);
    }

    public DoraWifiOpt(String r1, int r2) {
        super(r1, r2);
    }
}
