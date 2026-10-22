package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/TracePolicy;", "", "<init>", "(Ljava/lang/String;I)V", "Enabled", "Disabled", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TracePolicy extends Enum<TracePolicy> {
    public static final TracePolicy Disabled = null;
    public static final TracePolicy Enabled = null;
    public static final /* synthetic */ TracePolicy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TracePolicy> getEntries() {
        return b;
    }

    static {
        TracePolicy r0 = new TracePolicy("Enabled", 0);
        Enabled = r0;
        TracePolicy r1 = new TracePolicy("Disabled", 1);
        Disabled = r1;
        TracePolicy[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static TracePolicy[] values() {
        return (TracePolicy[]) a.clone();
    }

    public static TracePolicy valueOf(String r1) {
        return (TracePolicy) a.a(TracePolicy.class, r1);
    }

    public TracePolicy(String r1, int r2) {
        super(r1, r2);
    }
}
