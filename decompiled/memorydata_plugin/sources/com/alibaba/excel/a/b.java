package com.alibaba.excel.a;

import com.alibaba.excel.exception.ExcelAnalysisException;
import com.alibaba.excel.exception.ExcelAnalysisStopException;
import com.alibaba.excel.i.e;
import com.alibaba.excel.i.g;
import com.alibaba.excel.i.k;
import com.alibaba.excel.i.o;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.poifs.filesystem.DocumentFactoryHelper;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;
import org.slf4j.d;

/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f120a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.alibaba.excel.e.a f121b;
    private c c;
    private boolean d;

    /* JADX INFO: renamed from: com.alibaba.excel.a.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f122a = null;

        static {
            int[] r0 = new int[ExcelTypeEnum.values().length];
            f122a = r0;
            r0[ExcelTypeEnum.XLS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f122a[ExcelTypeEnum.XLSX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f122a[ExcelTypeEnum.CSV.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f120a = d.a(b.class);
    }

    public b(com.alibaba.excel.h.c.c r2) {
        this.d = false;
        a(r2);     // Catch: Throwable -> L5 RuntimeException -> L8
        return;
    L8:
        e = move-exception;
        a();
        throw e;
    L5:
        th = move-exception;
        a();
        throw new ExcelAnalysisException(th);
    }

    private void a(com.alibaba.excel.h.c.c r5) {
        ExcelTypeEnum r0 = ExcelTypeEnum.valueOf(r5);
        int r1 = AnonymousClass1.f122a[r0.ordinal()];
        InputStream r2 = null;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L7;
        com.alibaba.excel.e.c.a r3 = new com.alibaba.excel.e.c.a(r5, ExcelTypeEnum.XLSX);
        this.f121b = r3;
        c r6 = new com.alibaba.excel.a.c.a(r3, null);
    L11:
        this.c = r6;
        return;
    L7:
        if (r1 != 3) goto L31;
        com.alibaba.excel.e.a.b r4 = new com.alibaba.excel.e.a.b(r5, ExcelTypeEnum.CSV);
        this.f121b = r4;
        r6 = new com.alibaba.excel.a.a.a(r4);
        goto L11
    L31:
        return;
    L13:
        if (r5.m() == null) goto L15;
        POIFSFileSystem r7 = new POIFSFileSystem(r5.m());
    L17:
        if (r7.getRoot().hasEntry("EncryptedPackage") == false) goto L25;
        r2 = DocumentFactoryHelper.getDecryptedStream(r7.getRoot().getFileSystem(), r5.u());     // Catch: Throwable -> L21
        com.alibaba.excel.e.c.a r8 = new com.alibaba.excel.e.c.a(r5, ExcelTypeEnum.XLSX);     // Catch: Throwable -> L21
        this.f121b = r8;     // Catch: Throwable -> L21
        this.c = new com.alibaba.excel.a.c.a(r8, r2);     // Catch: Throwable -> L21
        IOUtils.closeQuietly(r2);
        r7.close();
        return;
    L21:
        th = move-exception;
        IOUtils.closeQuietly(r2);
        r7.close();
        throw th;
    L25:
        if (r5.u() == null) goto L27;
        Biff8EncryptionKey.setCurrentUserPassword(r5.u());
    L27:
        com.alibaba.excel.e.b.a r9 = new com.alibaba.excel.e.b.a(r5, ExcelTypeEnum.XLS);
        r9.f().a(r7);
        this.f121b = r9;
        r6 = new com.alibaba.excel.a.b.c(r9);
        goto L11
    L15:
        r7 = new POIFSFileSystem(r5.l());
        goto L17
    }

    private void b() {
        k.a();
        e.a();
        com.alibaba.excel.i.c.a();
    }

    private void c() {
        if (o.a(this.f121b.a().A()) == false) goto L5;
        return;
    L5:
        if (ExcelTypeEnum.XLS.equals(this.f121b.a().u()) == false) goto L10;
        Biff8EncryptionKey.setCurrentUserPassword(null);
        return;
    }

    @Override // com.alibaba.excel.a.a
    public void a() {
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = true;
        com.alibaba.excel.e.a r1 = this.f121b;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.a() == null) goto L72;
        com.alibaba.excel.h.c.a.e r2 = this.f121b.a();
        Throwable th = null;
    L15:
        th = th;
    L66:
    L22:
        th = th;
    L68:
    L29:
        th = th;
    L64:
    L38:
        th = move-exception;
        th = th;
    L62:
    L46:
        th = move-exception;
        th = th;
    L60:
    L52:
        th = move-exception;
        th = th;
    L54:
        c();
        b();
        if (th != null) goto L58;
        return;
    L58:
        throw new ExcelAnalysisException("Can not close IO.", th);
    L49:
        if (r2.z() == null) goto L54;
        g.delete(r2.z());     // Catch: Throwable -> L52
        goto L54
    L41:
        if (this.f121b.a().s().booleanValue() == false) goto L60;
        if (r2.o() == null) goto L60;
        r2.o().close();     // Catch: Throwable -> L46
        goto L60
    L31:
        if (ZeusTransformUtils.instanceOf(r2, com.alibaba.excel.h.c.a.a.b.class) == false) goto L62;
        if (((com.alibaba.excel.h.c.a.a.b) ZeusTransformUtils.preCheckCast(r2, com.alibaba.excel.h.c.a.a.b.class, "com.obric.memorydata.plugin")).H() == null) goto L62;
        if (this.f121b.a().s().booleanValue() == false) goto L62;
        ((com.alibaba.excel.h.c.a.a.b) ZeusTransformUtils.preCheckCast(r2, com.alibaba.excel.h.c.a.a.b.class, "com.obric.memorydata.plugin")).H().close();     // Catch: Throwable -> L38
        goto L62
    L24:
        if (ZeusTransformUtils.instanceOf(r2, com.alibaba.excel.h.c.a.b.b.class) == false) goto L64;
        if (((com.alibaba.excel.h.c.a.b.b) ZeusTransformUtils.preCheckCast(r2, com.alibaba.excel.h.c.a.b.b.class, "com.obric.memorydata.plugin")).G() == null) goto L64;
        ((com.alibaba.excel.h.c.a.b.b) ZeusTransformUtils.preCheckCast(r2, com.alibaba.excel.h.c.a.b.b.class, "com.obric.memorydata.plugin")).G().close();     // Catch: Throwable -> L29
        goto L64
    L17:
        if (ZeusTransformUtils.instanceOf(r2, com.alibaba.excel.h.c.a.c.b.class) == false) goto L68;
        if (((com.alibaba.excel.h.c.a.c.b) ZeusTransformUtils.preCheckCast(r2, com.alibaba.excel.h.c.a.c.b.class, "com.obric.memorydata.plugin")).G() == null) goto L68;
        ((com.alibaba.excel.h.c.a.c.b) ZeusTransformUtils.preCheckCast(r2, com.alibaba.excel.h.c.a.c.b.class, "com.obric.memorydata.plugin")).G().revert();     // Catch: Throwable -> L22
        goto L68
    L12:
        if (r2.x() == null) goto L66;
        r2.x().b();     // Catch: Throwable -> L15
        goto L66
    }

    @Override // com.alibaba.excel.a.a
    public void a(List<com.alibaba.excel.h.c.b> r3, Boolean r4) {
        List<com.alibaba.excel.h.c.b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    L20:
        e = move-exception;
        a();
        throw e;
    L17:
        th = move-exception;
        a();
        throw new ExcelAnalysisException(th);
    L4:
        if (r4.booleanValue() == false) goto L6;
    L10:
        this.f121b.a().b(r5);     // Catch: Throwable -> L17 RuntimeException -> L20
        this.f121b.a().a(r4);     // Catch: Throwable -> L17 RuntimeException -> L20
        this.c.a();     // Catch: ExcelAnalysisStopException -> L13 Throwable -> L17 RuntimeException -> L20
    L27:
        return;
    L13:
        org.slf4j.c r6 = f120a;     // Catch: Throwable -> L17 RuntimeException -> L20
        if (r6.isDebugEnabled() == false) goto L26;
        r6.debug("Custom stop!");     // Catch: Throwable -> L17 RuntimeException -> L20
        return;
    L26:
        return;
    L6:
        if (CollectionUtils.isEmpty(r5) == false) goto L10;
        throw new IllegalArgumentException("Specify at least one read sheet.");     // Catch: Throwable -> L17 RuntimeException -> L20
    }
}
