package com.larus.suggest.impl.wcb.request;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/suggest/impl/wcb/request/WcbTransportSource;", "", "<init>", "(Ljava/lang/String;I)V", "CACHE", "NETWORK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum WcbTransportSource extends Enum<WcbTransportSource> {
    public static final WcbTransportSource CACHE = null;
    public static final WcbTransportSource NETWORK = null;
    public static final /* synthetic */ WcbTransportSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<WcbTransportSource> getEntries() {
        return b;
    }

    static {
        WcbTransportSource r0 = new WcbTransportSource("CACHE", 0);
        CACHE = r0;
        WcbTransportSource r1 = new WcbTransportSource("NETWORK", 1);
        NETWORK = r1;
        WcbTransportSource[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static WcbTransportSource[] values() {
        return (WcbTransportSource[]) a.clone();
    }

    public static WcbTransportSource valueOf(String r1) {
        return (WcbTransportSource) r27.a.a(WcbTransportSource.class, r1);
    }

    public WcbTransportSource(String r1, int r2) {
        super(r1, r2);
    }
}
