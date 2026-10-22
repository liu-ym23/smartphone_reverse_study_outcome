package org.apache.poi.ooxml;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.c;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.b;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.e;

/* JADX INFO: loaded from: classes7.dex */
public class POIXMLProperties {
    private static final c NEW_CUST_INSTANCE = null;
    private static final e NEW_EXT_INSTANCE = null;
    private final CoreProperties core;
    private final CustomProperties cust;
    private PackagePart custPart;
    private final ExtendedProperties ext;
    private PackagePart extPart;
    private final OPCPackage pkg;

    /* JADX INFO: renamed from: org.apache.poi.ooxml.POIXMLProperties$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class CoreProperties {
        private final PackagePropertiesPart part;

        private CoreProperties(PackagePropertiesPart r1) {
            this.part = r1;
        }

        /* synthetic */ CoreProperties(PackagePropertiesPart r1, AnonymousClass1 r2) {
            this(r1);
        }

        public String getIdentifier() {
            return (String) ZeusTransformUtils.preCheckCast(this.part.getIdentifierProperty().orElse(null), String.class, "com.obric.memorydata.plugin");
        }
    }

    public static class CustomProperties {
        private Integer lastPid;
        private final c props;

        private CustomProperties(c r3) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.lastPid = null;
            this.props = r4;
        }

        /* synthetic */ CustomProperties(c r2, AnonymousClass1 r3) {
            this((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ c access$400(CustomProperties r0) {
            return r0.props;
        }
    }

    public static class ExtendedProperties {
        private final e props;

        private ExtendedProperties(e r3) {
            this.props = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ ExtendedProperties(e r2, AnonymousClass1 r3) {
            this((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ e access$300(ExtendedProperties r0) {
            return r0.props;
        }

        public b getUnderlyingProperties() {
            return this.props.getProperties();
        }
    }

    static {
        e r0 = (e) ZeusTransformUtils.preCheckCast(e.f19098a.newInstance(), e.class, "com.obric.memorydata.plugin");
        NEW_EXT_INSTANCE = r0;
        r0.addNewProperties();
        c r1 = (c) ZeusTransformUtils.preCheckCast(c.f19084a.newInstance(), c.class, "com.obric.memorydata.plugin");
        NEW_CUST_INSTANCE = r1;
        r1.addNewProperties();
    }

    public POIXMLProperties(OPCPackage r8) {
        this.pkg = r8;
        AnonymousClass1 r2 = null;
        this.core = new CoreProperties((PackagePropertiesPart) ZeusTransformUtils.preCheckCast(r8.getPackageProperties(), PackagePropertiesPart.class, "com.obric.memorydata.plugin"), r2);
        PackageRelationshipCollection r0 = r8.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/extended-properties");
        if (r0.size() != 1) goto L20;
        PackagePart r1 = r8.getPart(r0.getRelationship(0));
        this.extPart = r1;
        if (r1 != null) goto L7;
        ExtendedProperties r3 = new ExtendedProperties((e) ZeusTransformUtils.preCheckCast(NEW_EXT_INSTANCE.copy(), e.class, "com.obric.memorydata.plugin"), r2);
    L21:
        this.ext = r3;
    L22:
        PackageRelationshipCollection r4 = r8.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/custom-properties");
        if (r4.size() != 1) goto L40;
        PackagePart r9 = r8.getPart(r4.getRelationship(0));
        this.custPart = r9;
        if (r9 != null) goto L27;
        CustomProperties r10 = new CustomProperties((c) ZeusTransformUtils.preCheckCast(NEW_CUST_INSTANCE.copy(), c.class, "com.obric.memorydata.plugin"), r2);
    L41:
        this.cust = r10;
        return;
    L27:
        InputStream r11 = r9.getInputStream();
        this.cust = new CustomProperties((c) ZeusTransformUtils.preCheckCast(c.f19084a.parse(r11, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), c.class, "com.obric.memorydata.plugin"), r2);     // Catch: Throwable -> L31
        if (r11 == null) goto L55;
        r11.close();
        return;
    L55:
        return;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        if (r11 != null) goto L45;
    L39:
        throw th;
    L45:
        r11.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        th.addSuppressed(th);
        goto L39
    L40:
        this.custPart = null;
        r10 = new CustomProperties((c) ZeusTransformUtils.preCheckCast(NEW_CUST_INSTANCE.copy(), c.class, "com.obric.memorydata.plugin"), r2);
        goto L41
    L7:
        InputStream r5 = r1.getInputStream();
        this.ext = new ExtendedProperties((e) ZeusTransformUtils.preCheckCast(e.f19098a.parse(r5, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), e.class, "com.obric.memorydata.plugin"), r2);     // Catch: Throwable -> L11
        if (r5 == null) goto L22;
        r5.close();
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (r5 != null) goto L43;
    L19:
        throw th;
    L43:
        r5.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    L20:
        this.extPart = null;
        r3 = new ExtendedProperties((e) ZeusTransformUtils.preCheckCast(NEW_EXT_INSTANCE.copy(), e.class, "com.obric.memorydata.plugin"), r2);
        goto L21
    }

    public void commit() {
        if (this.extPart != null) goto L16;
        ExtendedProperties r0 = this.ext;
        if (r0 == null) goto L16;
        if (ExtendedProperties.access$300(r0) == null) goto L16;
        if (NEW_EXT_INSTANCE.toString().equals(ExtendedProperties.access$300(this.ext).toString()) == true) goto L16;
        PackagePartName r1 = PackagingURIHelper.createPartName("/docProps/app.xml");     // Catch: InvalidFormatException -> L12
        this.pkg.addRelationship(r1, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/extended-properties");     // Catch: InvalidFormatException -> L12
        this.extPart = this.pkg.createPart(r1, "application/vnd.openxmlformats-officedocument.extended-properties+xml");     // Catch: InvalidFormatException -> L12
    L12:
        e = move-exception;
        throw new POIXMLException(e);
    L16:
        if (this.custPart != null) goto L29;
        CustomProperties r2 = this.cust;
        if (r2 == null) goto L29;
        if (CustomProperties.access$400(r2) == null) goto L29;
        if (NEW_CUST_INSTANCE.toString().equals(CustomProperties.access$400(this.cust).toString()) == true) goto L29;
        PackagePartName r3 = PackagingURIHelper.createPartName("/docProps/custom.xml");     // Catch: InvalidFormatException -> L25
        this.pkg.addRelationship(r3, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/custom-properties");     // Catch: InvalidFormatException -> L25
        this.custPart = this.pkg.createPart(r3, "application/vnd.openxmlformats-officedocument.custom-properties+xml");     // Catch: InvalidFormatException -> L25
    L25:
        e = move-exception;
        throw new POIXMLException(e);
    L29:
        if (this.extPart == null) goto L51;
        ExtendedProperties r4 = this.ext;
        if (r4 == null) goto L51;
        if (ExtendedProperties.access$300(r4) == null) goto L51;
        OutputStream r5 = this.extPart.getOutputStream();
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        if (r5 != null) goto L80;
    L49:
        throw th;
    L80:
        r5.close();     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        th.addSuppressed(th);
        goto L49
    L36:
        if (this.extPart.getSize() <= 0) goto L38;
        this.extPart.clear();     // Catch: Throwable -> L41
    L38:
        ExtendedProperties.access$300(this.ext).save(r5, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);     // Catch: Throwable -> L41
        if (r5 == null) goto L51;
        r5.close();
    L51:
        if (this.custPart == null) goto L69;
        CustomProperties r6 = this.cust;
        if (r6 != null) goto L55;
        return;
    L55:
        if (CustomProperties.access$400(r6) == null) goto L87;
        this.custPart.clear();
        OutputStream r7 = this.custPart.getOutputStream();
        CustomProperties.access$400(this.cust).save(r7, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);     // Catch: Throwable -> L60
        if (r7 == null) goto L88;
        r7.close();
        return;
    L88:
        return;
    L60:
        th = move-exception;
        throw th;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        if (r7 != null) goto L72;
    L68:
        throw th;
    L72:
        r7.close();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        th.addSuppressed(th);
        goto L68
    L87:
        return;
    }

    public ExtendedProperties getExtendedProperties() {
        return this.ext;
    }
}
