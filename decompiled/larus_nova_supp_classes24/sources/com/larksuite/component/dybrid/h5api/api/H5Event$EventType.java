package com.larksuite.component.dybrid.h5api.api;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum H5Event$EventType extends Enum<H5Event$EventType> {
    public static final H5Event$EventType CALL = null;
    public static final H5Event$EventType CALLBACK = null;
    public static final /* synthetic */ H5Event$EventType[] a = null;

    static {
        H5Event$EventType r0 = new H5Event$EventType("CALL", 0);
        CALL = r0;
        H5Event$EventType r1 = new H5Event$EventType("CALLBACK", 1);
        CALLBACK = r1;
        a = new H5Event$EventType[]{r0, r1};
    }

    public static H5Event$EventType[] values() {
        return (H5Event$EventType[]) a.clone();
    }

    public static H5Event$EventType valueOf(String r1) {
        return (H5Event$EventType) a.a(H5Event$EventType.class, r1);
    }

    public H5Event$EventType(String r1, int r2) {
        super(r1, r2);
    }
}
