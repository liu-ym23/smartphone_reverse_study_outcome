package com.larus.search.impl.combine.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/search/impl/combine/model/AutoSearchType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "MESSAGE", "BOT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum AutoSearchType extends Enum<AutoSearchType> {
    public static final AutoSearchType BOT = null;
    public static final AutoSearchType MESSAGE = null;
    public static final AutoSearchType UNKNOWN = null;
    public static final /* synthetic */ AutoSearchType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AutoSearchType> getEntries() {
        return b;
    }

    static {
        AutoSearchType r0 = new AutoSearchType("UNKNOWN", 0);
        UNKNOWN = r0;
        AutoSearchType r1 = new AutoSearchType("MESSAGE", 1);
        MESSAGE = r1;
        AutoSearchType r3 = new AutoSearchType("BOT", 2);
        BOT = r3;
        AutoSearchType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AutoSearchType[] values() {
        return (AutoSearchType[]) a.clone();
    }

    public static AutoSearchType valueOf(String r1) {
        return (AutoSearchType) a.a(AutoSearchType.class, r1);
    }

    public AutoSearchType(String r1, int r2) {
        super(r1, r2);
    }
}
