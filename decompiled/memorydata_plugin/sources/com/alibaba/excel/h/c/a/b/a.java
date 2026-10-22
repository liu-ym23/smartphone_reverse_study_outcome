package com.alibaba.excel.h.c.a.b;

import com.alibaba.excel.enums.RowTypeEnum;
import com.alibaba.excel.h.c.a.d;
import com.alibaba.excel.h.c.a.e;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RowTypeEnum f183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f184b;
    private Map<Integer, String> c;

    public a(com.alibaba.excel.h.c.b r1, e r2) {
        super(r1, r2);
        this.f183a = RowTypeEnum.EMPTY;
        this.c = new HashMap(16);
    }

    public void a(RowTypeEnum r1) {
        this.f183a = r1;
    }

    public void d(Integer r1) {
        this.f184b = r1;
    }

    public RowTypeEnum x() {
        return this.f183a;
    }

    public Integer y() {
        return this.f184b;
    }

    public Map<Integer, String> z() {
        return this.c;
    }
}
