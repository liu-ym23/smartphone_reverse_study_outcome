package com.larksuite.component.dybrid.h5api.api;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum H5Param$ParamType extends Enum<H5Param$ParamType> {
    public static final H5Param$ParamType BOOLEAN = null;
    public static final H5Param$ParamType DOUBLE = null;
    public static final H5Param$ParamType INT = null;
    public static final H5Param$ParamType STRING = null;
    public static final /* synthetic */ H5Param$ParamType[] a = null;

    static {
        H5Param$ParamType r0 = new H5Param$ParamType("BOOLEAN", 0);
        BOOLEAN = r0;
        H5Param$ParamType r1 = new H5Param$ParamType("STRING", 1);
        STRING = r1;
        H5Param$ParamType r3 = new H5Param$ParamType("INT", 2);
        INT = r3;
        H5Param$ParamType r5 = new H5Param$ParamType("DOUBLE", 3);
        DOUBLE = r5;
        a = new H5Param$ParamType[]{r0, r1, r3, r5};
    }

    public static H5Param$ParamType[] values() {
        return (H5Param$ParamType[]) a.clone();
    }

    public static H5Param$ParamType valueOf(String r1) {
        return (H5Param$ParamType) a.a(H5Param$ParamType.class, r1);
    }

    public H5Param$ParamType(String r1, int r2) {
        super(r1, r2);
    }
}
