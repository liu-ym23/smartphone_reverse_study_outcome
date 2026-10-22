package com.alibaba.excel.h.d;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.enums.HeadKindEnum;
import com.alibaba.excel.enums.RowTypeEnum;
import com.alibaba.excel.exception.ExcelAnalysisException;
import com.alibaba.excel.exception.ExcelAnalysisStopException;
import com.alibaba.excel.i.o;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.e;
import com.alibaba.excel.metadata.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.c;
import org.slf4j.d;

/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f201a = null;

    static {
        f201a = d.a(b.class);
    }

    public b() {
    }

    private void a(com.alibaba.excel.e.a r4, Exception r5) {
        com.alibaba.excel.e.a r3 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        Iterator<com.alibaba.excel.h.b.c<?>> r6 = r3.d().i().iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        ((com.alibaba.excel.h.b.c) ZeusTransformUtils.preCheckCast(r6.next(), com.alibaba.excel.h.b.c.class, "com.obric.memorydata.plugin")).a(r5, r3);     // Catch: Exception -> L8 RuntimeException -> L11
    L11:
        e = move-exception;
        throw e;
    L8:
        e = move-exception;
        throw new ExcelAnalysisException(e.getMessage(), e);
    }

    private static /* synthetic */ void a(com.alibaba.excel.e.a r2, Map.Entry r3) {
        com.alibaba.excel.e.a r4 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        r4.b().c((Integer) ZeusTransformUtils.preCheckCast(r5.getKey(), Integer.class, "com.obric.memorydata.plugin"));
    }

    private void a(com.alibaba.excel.e.a r10, Map<Integer, f<?>> r11) {
        final com.alibaba.excel.e.a r9 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r10, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        if (MapUtils.isNotEmpty(r12) == false) goto L6;
        r12.entrySet().stream().filter($$Lambda$b$JWbWf0U2zpIYvzxAuCzVTFped0Y.INSTANCE).forEach(new $$Lambda$b$7THs_ZFMHwdcaN2mBiRYcqJguc(r9));
    L6:
        if (HeadKindEnum.CLASS.equals(r9.d().j().c()) == true) goto L8;
        return;
    L8:
        Map<Integer, String> r13 = com.alibaba.excel.i.d.a(r12, r9);
        com.alibaba.excel.h.c.b.a r14 = r9.b().j();
        Map<Integer, k> r1 = r14.e();
        HashMap r2 = new HashMap(((r1.size() * 4) / 3) + 1);
        Iterator<Map.Entry<Integer, k>> r3 = r1.entrySet().iterator();
    L10:
        if (r3.hasNext() == false) goto L32;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        k r5 = (k) ZeusTransformUtils.preCheckCast(r4.getValue(), k.class, "com.obric.memorydata.plugin");
        if (r5.e().booleanValue() == true) goto L31;
        if (r5.f().booleanValue() == false) goto L31;
        List<String> r6 = r5.d();
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.get(r6.size() - 1), String.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<Integer, String>> r8 = r13.entrySet().iterator();
    L18:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L18;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.getValue(), String.class, "com.obric.memorydata.plugin");
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r15.getKey(), Integer.class, "com.obric.memorydata.plugin");
        if (o.a(r16) == true) goto L18;
        if (r9.d().b().a().booleanValue() == false) goto L29;
        r16 = r16.trim();
    L29:
        if (r7.equals(r16) == false) goto L18;
        r5.a(r17);
        r2.put(r17, r5);
    L31:
        r2.put(r4.getKey(), r5);
        goto L10
    L32:
        r14.a(r2);
    }

    private static /* synthetic */ boolean a(Map.Entry r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        if (CellDataTypeEnum.EMPTY == ((f) ZeusTransformUtils.preCheckCast(r4.getValue(), f.class, "com.obric.memorydata.plugin")).getType()) goto L5;
        return true;
    L5:
        return false;
    }

    private void d(com.alibaba.excel.e.a r5) {
        com.alibaba.excel.e.a r6 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r5, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        Iterator<com.alibaba.excel.h.b.c<?>> r0 = r6.d().i().iterator();
    L4:
        if (r0.hasNext() == false) goto L20;
        com.alibaba.excel.h.b.c r2 = (com.alibaba.excel.h.b.c) ZeusTransformUtils.preCheckCast(r0.next(), com.alibaba.excel.h.b.c.class, "com.obric.memorydata.plugin");
        r2.a(r6.b().t(), r6);     // Catch: Exception -> L12
        if (r2.b(r6) == true) goto L4;
        throw new ExcelAnalysisStopException();
    L12:
        e = move-exception;
        a(r6, e);
        return;
    }

    private void e(com.alibaba.excel.e.a r8) {
        com.alibaba.excel.e.a r9 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r8, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.h.c.a.c r0 = r9.c();
        Map<Integer, e> r2 = r0.d();
        r0.a(r2);
        int r3 = r0.b().intValue();
        int r4 = r9.b().k().intValue();
        if (r3 < r4) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L8;
    L10:
        Iterator<com.alibaba.excel.h.b.c<?>> r5 = r9.d().i().iterator();
    L12:
        if (r5.hasNext() == false) goto L30;
        com.alibaba.excel.h.b.c r7 = (com.alibaba.excel.h.b.c) ZeusTransformUtils.preCheckCast(r5.next(), com.alibaba.excel.h.b.c.class, "com.obric.memorydata.plugin");
        if (r6 == true) goto L25;
        r7.a(r2, r9);     // Catch: Exception -> L22
    L18:
        if (r7.b(r9) == true) goto L12;
        throw new ExcelAnalysisStopException();
    L25:
        r7.a(r0.a(), r9);     // Catch: Exception -> L22
    L22:
        e = move-exception;
        a(r9, e);
        return;
    L30:
        return;
    L8:
        if (r4 != (r3 + 1)) goto L10;
        a(r9, r2);
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$7THs_Z-FMHwdcaN2mBiRYcqJguc, reason: not valid java name */
    public static /* synthetic */ void m68lambda$7THs_ZFMHwdcaN2mBiRYcqJguc(com.alibaba.excel.e.a r0, Map.Entry r1) {
        a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$JWbWf0U2zpIYvzxAuCzVTFped0Y(Map.Entry r0) {
        return a(r0);
    }

    @Override // com.alibaba.excel.h.d.a
    public void a(com.alibaba.excel.e.a r3) {
        d((com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.alibaba.excel.h.d.a
    public void b(com.alibaba.excel.e.a r3) {
        com.alibaba.excel.e.a r4 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        if (RowTypeEnum.EMPTY.equals(r4.c().c()) == false) goto L10;
        c r0 = f201a;
        if (r0.isDebugEnabled() == false) goto L8;
        r0.debug("Empty row!");
    L8:
        if (r4.a().w().booleanValue() == false) goto L10;
        return;
    L10:
        e(r4);
    }

    @Override // com.alibaba.excel.h.d.a
    public void c(com.alibaba.excel.e.a r4) {
        com.alibaba.excel.e.a r3 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        Iterator<com.alibaba.excel.h.b.c<?>> r5 = r3.d().i().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((com.alibaba.excel.h.b.c) ZeusTransformUtils.preCheckCast(r5.next(), com.alibaba.excel.h.b.c.class, "com.obric.memorydata.plugin")).a(r3);
        goto L4
    }
}
