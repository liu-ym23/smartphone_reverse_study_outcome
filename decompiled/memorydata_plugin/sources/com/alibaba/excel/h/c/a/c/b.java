package com.alibaba.excel.h.c.a.c;

import com.alibaba.excel.h.c.a.e;
import com.alibaba.excel.h.c.c;
import com.alibaba.excel.i.j;
import com.alibaba.excel.metadata.data.d;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

/* JADX INFO: loaded from: classes.dex */
public class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OPCPackage f191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f192b;
    private StylesTable c;
    private Map<Integer, d> d;
    private Map<Integer, PackageRelationshipCollection> e;

    public b(c r1) {
        super(r1);
        this.f192b = r1.v();
        a(ExcelTypeEnum.XLSX);
        this.d = j.a();
    }

    private /* synthetic */ d a(int r3, Integer r4) {
        d r5 = new d();
        StylesTable r0 = this.c;
        if (r0 != null) goto L5;
        return null;
    L5:
        XSSFCellStyle r6 = r0.getStyleAt(r3);
        if (r6 != null) goto L8;
        return null;
    L8:
        r5.a(Short.valueOf(r6.getDataFormat()));
        r5.a(com.alibaba.excel.d.a.a(r5.b(), r6.getDataFormatString(), b().c()));
        return r5;
    }

    public static /* synthetic */ d lambda$OrOfeInUIS4fCThHs9wDLIo3mP4(b r0, int r1, Integer r2) {
        return r0.a(r1, r2);
    }

    public OPCPackage G() {
        return this.f191a;
    }

    public String H() {
        return this.f192b;
    }

    public StylesTable I() {
        return this.c;
    }

    public Map<Integer, d> J() {
        return this.d;
    }

    public Map<Integer, PackageRelationshipCollection> K() {
        return this.e;
    }

    public d a(final int r4) {
        return (d) ZeusTransformUtils.preCheckCast(this.d.computeIfAbsent(Integer.valueOf(r4), new $$Lambda$b$OrOfeInUIS4fCThHs9wDLIo3mP4(this, r4)), d.class, "com.obric.memorydata.plugin");
    }

    public void a(OPCPackage r1) {
        this.f191a = r1;
    }

    public void a(StylesTable r1) {
        this.c = r1;
    }

    @Override // com.alibaba.excel.h.c.a.e, com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, b.class);
    }

    public void b(Map<Integer, PackageRelationshipCollection> r3) {
        this.e = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.alibaba.excel.h.c.a.e, com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r0 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        OPCPackage r6 = G();
        OPCPackage r2 = r0.G();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        String r7 = H();
        String r3 = r0.H();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        StylesTable r8 = I();
        StylesTable r4 = r0.I();
        if (r8 != null) goto L33;
        if (r4 != null) goto L34;
    L35:
        Map<Integer, d> r9 = J();
        Map<Integer, d> r10 = r0.J();
        if (r9 != null) goto L40;
        if (r10 != null) goto L41;
    L42:
        Map<Integer, PackageRelationshipCollection> r11 = K();
        Map<Integer, PackageRelationshipCollection> r12 = r0.K();
        if (r11 != null) goto L47;
        if (r12 != null) goto L48;
    L49:
        return true;
    L48:
        return false;
    L47:
        if (r11.equals(r12) == true) goto L49;
    L41:
        return false;
    L40:
        if (r9.equals(r10) == true) goto L42;
    L34:
        return false;
    L33:
        if (r8.equals(r4) == true) goto L35;
    L27:
        return false;
    L26:
        if (r7.equals(r3) == true) goto L28;
    L20:
        return false;
    L19:
        if (r6.equals(r2) == true) goto L21;
        goto L20
    }

    @Override // com.alibaba.excel.h.c.a.e, com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public int hashCode() {
        int r0 = super.hashCode();
        OPCPackage r1 = G();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        String r6 = H();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        int r9 = r7 + r8;
        StylesTable r10 = I();
        int r11 = r9 * 59;
        if (r10 != null) goto L13;
        int r12 = 43;
    L14:
        int r13 = r11 + r12;
        Map<Integer, d> r14 = J();
        int r15 = r13 * 59;
        if (r14 != null) goto L17;
        int r16 = 43;
    L18:
        Map<Integer, PackageRelationshipCollection> r17 = K();
        int r18 = (r15 + r16) * 59;
        if (r17 == null) goto L23;
        r3 = r17.hashCode();
    L23:
        return r18 + r3;
    L17:
        r16 = r14.hashCode();
        goto L18
    L13:
        r12 = r10.hashCode();
        goto L14
    L9:
        r8 = r6.hashCode();
        goto L10
    L5:
        r4 = r1.hashCode();
        goto L6
    }
}
