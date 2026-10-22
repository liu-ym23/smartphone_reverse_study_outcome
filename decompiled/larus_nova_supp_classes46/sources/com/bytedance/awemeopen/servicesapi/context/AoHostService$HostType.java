package com.bytedance.awemeopen.servicesapi.context;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/servicesapi/context/AoHostService$HostType;", "", "TOB", "TOC", "ao_basic_service_api_release"}, k = 1, mv = {1, 7, 1})
public final enum AoHostService$HostType extends Enum<AoHostService$HostType> {
    public static final AoHostService$HostType TOB = null;
    public static final AoHostService$HostType TOC = null;
    public static final /* synthetic */ AoHostService$HostType[] a = null;

    public static AoHostService$HostType valueOf(String r1) {
        return (AoHostService$HostType) a.a(AoHostService$HostType.class, r1);
    }

    public static AoHostService$HostType[] values() {
        return (AoHostService$HostType[]) a.clone();
    }

    static {
        AoHostService$HostType r0 = new AoHostService$HostType("TOB", 0);
        TOB = r0;
        AoHostService$HostType r1 = new AoHostService$HostType("TOC", 1);
        TOC = r1;
        a = new AoHostService$HostType[]{r0, r1};
    }

    public AoHostService$HostType(String r1, int r2) {
        super(r1, r2);
    }
}
