package com.larus.dora.api.log;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/api/log/GLogType;", "", "id", "", "type", "", "<init>", "(Ljava/lang/String;IBLjava/lang/String;)V", "getId", "()B", "getType", "()Ljava/lang/String;", "SYSLOG", "POINT", "CORE_DUMP", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GLogType extends Enum<GLogType> {
    public static final GLogType CORE_DUMP = null;
    public static final a Companion = null;
    public static final GLogType POINT = null;
    public static final GLogType SYSLOG = null;
    public static final /* synthetic */ GLogType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final byte id;
    private final String type;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<GLogType> getEntries() {
        return b;
    }

    static {
        GLogType r0 = new GLogType("SYSLOG", 0, (byte) 0, "Syslog");
        SYSLOG = r0;
        GLogType r1 = new GLogType("POINT", 1, (byte) 1, "Point");
        POINT = r1;
        GLogType r3 = new GLogType("CORE_DUMP", 2, (byte) 2, "CoreDump");
        CORE_DUMP = r3;
        GLogType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static GLogType[] values() {
        return (GLogType[]) a.clone();
    }

    public final byte getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public static GLogType valueOf(String r1) {
        return (GLogType) r27.a.a(GLogType.class, r1);
    }

    public GLogType(String r1, int r2, byte r3, String r4) {
        super(r1, r2);
        this.id = r3;
        this.type = r4;
    }
}
