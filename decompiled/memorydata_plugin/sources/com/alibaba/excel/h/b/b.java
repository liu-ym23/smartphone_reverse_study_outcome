package com.alibaba.excel.h.b;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.enums.HeadKindEnum;
import com.alibaba.excel.enums.ReadDefaultReturnEnum;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.excel.h.c.a.d;
import com.alibaba.excel.i.e;
import com.alibaba.excel.i.j;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b implements a<Map<Integer, f<?>>> {

    /* JADX INFO: renamed from: com.alibaba.excel.h.b.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f176a = null;

        static {
            int[] r0 = new int[CellDataTypeEnum.values().length];
            f176a = r0;
            r0[CellDataTypeEnum.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f176a[CellDataTypeEnum.DIRECT_STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f176a[CellDataTypeEnum.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f176a[CellDataTypeEnum.EMPTY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f176a[CellDataTypeEnum.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f176a[CellDataTypeEnum.NUMBER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public b() {
    }

    private int a(d r1) {
        if (r1.j().e().size() <= 0) goto L7;
        return r1.j().e().size();
    L7:
        if (r1.w() != null) goto L9;
        return 0;
    L9:
        return r1.w().intValue();
    }

    private f a(f<?> r10, ReadDefaultReturnEnum r11, d r12, com.alibaba.excel.e.a r13, Integer r14) {
        com.alibaba.excel.e.a r6 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r13, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        switch(AnonymousClass1.f176a[r10.getType().ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        Class r9 = com.alibaba.excel.i.d.f210a;
    L14:
        return (f) ZeusTransformUtils.preCheckCast(com.alibaba.excel.i.d.a(r10, null, f.class, r9, null, r12.a(), r6, r6.c().b(), r14), f.class, "com.obric.memorydata.plugin");
    L5:
        com.alibaba.excel.metadata.data.d r15 = r10.k();
        if (r15 != null) goto L8;
    L10:
        r9 = BigDecimal.class;
        goto L14
    L8:
        if (e.a(r15.b(), r15.c()) == false) goto L10;
        r9 = LocalDateTime.class;
        goto L14
    L11:
        r9 = Boolean.class;
        goto L14
    L12:
        r9 = String.class;
        goto L14
    }

    private Object a(Map<Integer, f<?>> r12, d r13, com.alibaba.excel.e.a r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.e.a r16 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r14, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        LinkedHashMap r0 = j.b(r15.size());
        Iterator r17 = r15.entrySet().iterator();
        int r2 = 0;
    L4:
        if (r17.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(r3.getKey(), Integer.class, "com.obric.memorydata.plugin");
        f<?> r4 = (f) ZeusTransformUtils.preCheckCast(r3.getValue(), f.class, "com.obric.memorydata.plugin");
    L7:
        if (r2 >= r9.intValue()) goto L9;
        r0.put(Integer.valueOf(r2), null);
        r2 = r2 + 1;
        goto L7
    L9:
        int r10 = r2 + 1;
        ReadDefaultReturnEnum r8 = r16.a().t();
        if (r8 != ReadDefaultReturnEnum.STRING) goto L13;
        Object r5 = (String) ZeusTransformUtils.preCheckCast(com.alibaba.excel.i.d.a(r4, null, null, r13.a(), r16, r16.c().b(), r9), String.class, "com.obric.memorydata.plugin");
    L12:
        r0.put(r9, r5);
        r2 = r10;
        goto L4
    L13:
        f r6 = a(r4, r16.a().t(), r13, r16, r9);
        r5 = r6;
        if (r8 == ReadDefaultReturnEnum.READ_CELL_DATA) goto L12;
        r5 = r6.g();
        goto L12
    L18:
        int r11 = a(r13);
    L19:
        if (r2 >= r11) goto L21;
        r0.put(Integer.valueOf(r2), null);
        r2 = r2 + 1;
        goto L19
    L21:
        return r0;
    }

    private Object b(Map<Integer, f<?>> r12, d r13, com.alibaba.excel.e.a r14) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.e.a r15 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r14, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.h.c.b.a r16 = r13.j();
        Object r8 = r16.b().newInstance();     // Catch: Exception -> L14
        Map<Integer, k> r17 = r16.e();
        com.alibaba.excel.support.cglib.beans.a r9 = com.alibaba.excel.i.a.a(r8);
        Iterator<Map.Entry<Integer, k>> r18 = r17.entrySet().iterator();
    L6:
        if (r18.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r1.getKey(), Integer.class, "com.obric.memorydata.plugin");
        k r2 = (k) ZeusTransformUtils.preCheckCast(r1.getValue(), k.class, "com.obric.memorydata.plugin");
        String r10 = r2.c();
        if (r11.containsKey(r7) == false) goto L6;
        Object r3 = com.alibaba.excel.i.d.a((f) ZeusTransformUtils.preCheckCast(r11.get(r7), f.class, "com.obric.memorydata.plugin"), r2.b(), com.alibaba.excel.i.c.a(r9, r13.j().b(), r10, r13), r13.a(), r15, r15.c().b(), r7);
        if (r3 == null) goto L6;
        r9.put(r10, r3);
        goto L6
    L13:
        return r8;
    L14:
        e = move-exception;
        throw new ExcelDataConvertException(r15.c().b(), 0, new f(CellDataTypeEnum.EMPTY), null, "Can not instance class: " + r16.b().getName(), e);
    }

    @Override // com.alibaba.excel.h.b.c
    public void a(com.alibaba.excel.e.a r2) {
        com.alibaba.excel.e.a r1 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.alibaba.excel.h.b.c
    public /* synthetic */ void a(Object r3, com.alibaba.excel.e.a r4) {
        com.alibaba.excel.e.a r5 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        b((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin"), r5);
    }

    public void b(Map<Integer, f<?>> r4, com.alibaba.excel.e.a r5) {
        Map<Integer, f<?>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.e.a r7 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r5, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        d r0 = r7.b();
        if (HeadKindEnum.CLASS.equals(r0.j().c()) == false) goto L7;
        com.alibaba.excel.h.c.a.c r1 = r7.c();
        Object r3 = b(r6, r0, r7);
    L5:
        r1.a(r3);
        return;
    L7:
        r1 = r7.c();
        r3 = a(r6, r0, r7);
        goto L5
    }
}
