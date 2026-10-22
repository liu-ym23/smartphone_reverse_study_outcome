package com.larksuite.component.dybrid.h5api.api;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum H5Param$TitleBackgroundTranslate extends Enum<H5Param$TitleBackgroundTranslate> {
    public static final /* synthetic */ H5Param$TitleBackgroundTranslate[] a = null;
    public static final H5Param$TitleBackgroundTranslate always = null;
    public static final H5Param$TitleBackgroundTranslate auto = null;

    static {
        H5Param$TitleBackgroundTranslate r0 = new H5Param$TitleBackgroundTranslate("always", 0);
        always = r0;
        H5Param$TitleBackgroundTranslate r1 = new H5Param$TitleBackgroundTranslate("auto", 1);
        auto = r1;
        a = new H5Param$TitleBackgroundTranslate[]{r0, r1};
    }

    public static H5Param$TitleBackgroundTranslate[] values() {
        return (H5Param$TitleBackgroundTranslate[]) a.clone();
    }

    public static H5Param$TitleBackgroundTranslate valueOf(String r1) {
        return (H5Param$TitleBackgroundTranslate) a.a(H5Param$TitleBackgroundTranslate.class, r1);
    }

    public H5Param$TitleBackgroundTranslate(String r1, int r2) {
        super(r1, r2);
    }
}
