package com.alibaba.excel.h.c.a;

import com.alibaba.excel.enums.HolderEnum;
import com.alibaba.excel.enums.RowTypeEnum;
import com.alibaba.excel.metadata.j;
import com.alibaba.excel.metadata.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RowTypeEnum f188b;
    private Map<Integer, com.alibaba.excel.metadata.e> c;
    private Object d;
    private j e;

    public c(Integer r3, RowTypeEnum r4, j r5, Map<Integer, com.alibaba.excel.metadata.e> r6) {
        Map<Integer, com.alibaba.excel.metadata.e> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        this.f187a = r3;
        this.f188b = r4;
        this.e = r5;
        this.c = r7;
    }

    public Object a() {
        return this.d;
    }

    public void a(Object r1) {
        this.d = r1;
    }

    public Integer b() {
        return this.f187a;
    }

    public RowTypeEnum c() {
        return this.f188b;
    }

    public Map<Integer, com.alibaba.excel.metadata.e> d() {
        return this.c;
    }

    @Override // com.alibaba.excel.metadata.l
    public HolderEnum h() {
        return HolderEnum.ROW;
    }
}
