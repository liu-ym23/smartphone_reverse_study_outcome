package com.alibaba.excel.i;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f210a;

    static {
        f210a = String.class;
    }

    private static Class<?> a(Field r1, Class<?> r2) {
        if (r2 == null) goto L4;
        return r2;
    L4:
        if (r1 == null) goto L6;
        Type r3 = r1.getGenericType();
        if (ZeusTransformUtils.instanceOf(r3, ParameterizedType.class) == false) goto L10;
        Type[] r4 = ((ParameterizedType) ZeusTransformUtils.preCheckCast(r3, ParameterizedType.class, "com.obric.memorydata.plugin")).getActualTypeArguments();
        if (r4 == null) goto L23;
        if (r4.length == 0) goto L23;
        Type r5 = r4[0];
        if (ZeusTransformUtils.instanceOf(r5, Class.class) == true) goto L21;
        return f210a;
    L21:
        return (Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.memorydata.plugin");
    L23:
        return f210a;
    L10:
        return f210a;
    L6:
        return f210a;
    }

    private static Object a(com.alibaba.excel.metadata.data.f<?> r10, Class<?> r11, com.alibaba.excel.metadata.a.c r12, Map<com.alibaba.excel.f.c.a, com.alibaba.excel.f.b<?>> r13, com.alibaba.excel.e.a r14, Integer r15, Integer r16) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.e.a r3 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r14, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L5;
        com.alibaba.excel.f.b<?> r7 = r12.b();
    L7:
        if (r10.getType() == CellDataTypeEnum.EMPTY) goto L9;
    L11:
        boolean r8 = false;
    L12:
        if (r8 == false) goto L14;
        return null;
    L14:
        if (r7 != null) goto L17;
        r7 = (com.alibaba.excel.f.b) ZeusTransformUtils.preCheckCast(r0.get(com.alibaba.excel.f.c.a(r11, r10.getType())), com.alibaba.excel.f.b.class, "com.obric.memorydata.plugin");
    L17:
        if (r7 == null) goto L24;
        return r7.a(new com.alibaba.excel.f.f(r10, r12, r3));
    L20:
        e = move-exception;
        throw new ExcelDataConvertException(r15, r16, r10, r12, "Convert data " + r10 + " to " + r11 + " error ", e);
    L24:
        throw new ExcelDataConvertException(r15, r16, r10, r12, "Converter not found, convert " + r10.getType() + " to " + r11.getName());
    L9:
        if (ZeusTransformUtils.instanceOf(r7, com.alibaba.excel.f.e.class) == true) goto L11;
        r8 = true;
        goto L12
    L5:
        r7 = null;
        goto L7
    }

    public static Object a(com.alibaba.excel.metadata.data.f<?> r11, Field r12, com.alibaba.excel.metadata.a.c r13, Map<com.alibaba.excel.f.c.a, com.alibaba.excel.f.b<?>> r14, com.alibaba.excel.e.a r15, Integer r16, Integer r17) {
        return a(r11, r12, null, null, r13, (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin"), (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r15, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin"), r16, r17);
    }

    public static Object a(com.alibaba.excel.metadata.data.f<?> r10, Field r11, Class<?> r12, Class<?> r13, com.alibaba.excel.metadata.a.c r14, Map<com.alibaba.excel.f.c.a, com.alibaba.excel.f.b<?>> r15, com.alibaba.excel.e.a r16, Integer r17, Integer r18) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.e.a r7 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r16, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L8;
        if (r11 != null) goto L6;
        Class<?> r1 = String.class;
    L7:
        Class<?> r4 = r1;
    L10:
        if (r4 != com.alibaba.excel.metadata.data.a.class) goto L12;
    L16:
        com.alibaba.excel.metadata.data.f<Object> r2 = r10.i();
        r2.b(a(r10, a(r11, r13), r14, r6, r7, r17, r18));
        return r2;
    L12:
        if (r4 == com.alibaba.excel.metadata.data.f.class) goto L16;
        return a(r10, r4, r14, r6, r7, r17, r18);
    L6:
        r1 = r11.getType();
        goto L7
    L8:
        r4 = r12;
        goto L10
    }

    public static Map<Integer, String> a(Map<Integer, com.alibaba.excel.metadata.data.f<?>> r13, com.alibaba.excel.e.a r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.e.a r16 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r14, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        HashMap r0 = j.a(r15.size());
        com.alibaba.excel.h.c.a.d r2 = r16.b();
        Iterator r17 = r15.entrySet().iterator();
        int r3 = 0;
    L4:
        if (r17.hasNext() == false) goto L21;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r4.getKey(), Integer.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.metadata.data.f r9 = (com.alibaba.excel.metadata.data.f) ZeusTransformUtils.preCheckCast(r4.getValue(), com.alibaba.excel.metadata.data.f.class, "com.obric.memorydata.plugin");
    L7:
        if (r3 >= r8.intValue()) goto L9;
        r0.put(Integer.valueOf(r3), null);
        r3 = r3 + 1;
        goto L7
    L9:
        r3 = r3 + 1;
        if (r9.getType() == CellDataTypeEnum.EMPTY) goto L11;
        com.alibaba.excel.f.b r5 = (com.alibaba.excel.f.b) ZeusTransformUtils.preCheckCast(r2.a().get(com.alibaba.excel.f.c.a(String.class, r9.getType())), com.alibaba.excel.f.b.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L20;
        r0.put(r8, (String) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r5.a(new com.alibaba.excel.f.f(r9, null, r16)), String.class, "com.obric.memorydata.plugin"), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L16
    L16:
        e = move-exception;
        throw new ExcelDataConvertException(r16.c().b(), r8, r9, null, "Convert data " + r9 + " to String error ", e);
    L20:
        throw new ExcelDataConvertException(r16.c().b(), r8, r9, null, "Converter not found, convert " + r9.getType() + " to String");
    L11:
        r0.put(r8, null);
        goto L4
    L21:
        return r0;
    }
}
