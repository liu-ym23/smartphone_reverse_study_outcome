package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/RoutePolicy;", "", "<init>", "(Ljava/lang/String;I)V", "Auto", "ForceResourceCenter", "ForceUploadAuthToken", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RoutePolicy extends Enum<RoutePolicy> {
    public static final RoutePolicy Auto = null;
    public static final RoutePolicy ForceResourceCenter = null;
    public static final RoutePolicy ForceUploadAuthToken = null;
    public static final /* synthetic */ RoutePolicy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RoutePolicy> getEntries() {
        return b;
    }

    static {
        RoutePolicy r0 = new RoutePolicy("Auto", 0);
        Auto = r0;
        RoutePolicy r1 = new RoutePolicy("ForceResourceCenter", 1);
        ForceResourceCenter = r1;
        RoutePolicy r3 = new RoutePolicy("ForceUploadAuthToken", 2);
        ForceUploadAuthToken = r3;
        RoutePolicy[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static RoutePolicy[] values() {
        return (RoutePolicy[]) a.clone();
    }

    public static RoutePolicy valueOf(String r1) {
        return (RoutePolicy) a.a(RoutePolicy.class, r1);
    }

    public RoutePolicy(String r1, int r2) {
        super(r1, r2);
    }
}
