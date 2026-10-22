package com.larksuite.component.dybrid.h5api.api;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum H5Event$Error extends Enum<H5Event$Error> {
    public static final H5Event$Error FORBIDDEN = null;
    public static final H5Event$Error INVALID_PARAM = null;
    public static final H5Event$Error NONE = null;
    public static final H5Event$Error NOT_FOUND = null;
    public static final H5Event$Error UNKNOWN_ERROR = null;
    public static final /* synthetic */ H5Event$Error[] a = null;

    static {
        H5Event$Error r0 = new H5Event$Error("NONE", 0);
        NONE = r0;
        H5Event$Error r1 = new H5Event$Error("NOT_FOUND", 1);
        NOT_FOUND = r1;
        H5Event$Error r3 = new H5Event$Error("INVALID_PARAM", 2);
        INVALID_PARAM = r3;
        H5Event$Error r5 = new H5Event$Error("UNKNOWN_ERROR", 3);
        UNKNOWN_ERROR = r5;
        H5Event$Error r7 = new H5Event$Error("FORBIDDEN", 4);
        FORBIDDEN = r7;
        a = new H5Event$Error[]{r0, r1, r3, r5, r7};
    }

    public static H5Event$Error[] values() {
        return (H5Event$Error[]) a.clone();
    }

    public static H5Event$Error valueOf(String r1) {
        return (H5Event$Error) a.a(H5Event$Error.class, r1);
    }

    public H5Event$Error(String r1, int r2) {
        super(r1, r2);
    }
}
