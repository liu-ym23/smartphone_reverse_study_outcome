package com.alibaba.excel.f;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.i.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f152a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Class<?> f153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CellDataTypeEnum f154b;

        public a(Class<?> r1, CellDataTypeEnum r2) {
            this.f153a = r1;
            this.f154b = r2;
        }

        public Class<?> a() {
            return this.f153a;
        }

        public boolean a(Object r1) {
            return ZeusTransformUtils.instanceOf(r1, a.class);
        }

        public CellDataTypeEnum b() {
            return this.f154b;
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (r6.a(this) == true) goto L11;
            return false;
        L11:
            Class<?> r0 = a();
            Class<?> r2 = r6.a();
            if (r0 != null) goto L16;
            if (r2 != null) goto L17;
        L18:
            CellDataTypeEnum r4 = b();
            CellDataTypeEnum r7 = r6.b();
            if (r4 != null) goto L23;
            if (r7 != null) goto L24;
        L25:
            return true;
        L24:
            return false;
        L23:
            if (r4.equals(r7) == true) goto L25;
        L17:
            return false;
        L16:
            if (r0.equals(r2) == true) goto L18;
            goto L17
        }

        public int hashCode() {
            Class<?> r0 = a();
            int r1 = 43;
            if (r0 != null) goto L5;
            int r2 = 43;
        L6:
            CellDataTypeEnum r3 = b();
            int r4 = (r2 + 59) * 59;
            if (r3 == null) goto L11;
            r1 = r3.hashCode();
        L11:
            return r4 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }
    }

    static {
        HashMap r0 = j.a();
        f152a = r0;
        r0.put(Integer.TYPE, Integer.class);
        r0.put(Byte.TYPE, Byte.class);
        r0.put(Long.TYPE, Long.class);
        r0.put(Double.TYPE, Double.class);
        r0.put(Float.TYPE, Float.class);
        r0.put(Character.TYPE, Character.class);
        r0.put(Short.TYPE, Short.class);
        r0.put(Boolean.TYPE, Boolean.class);
    }

    public static a a(Class<?> r1) {
        return a(r1, null);
    }

    public static a a(Class<?> r3, CellDataTypeEnum r4) {
        Class r0 = (Class) ZeusTransformUtils.preCheckCast(f152a.get(r3), Class.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        return new a(r0, r4);
    L7:
        return new a(r3, r4);
    }
}
