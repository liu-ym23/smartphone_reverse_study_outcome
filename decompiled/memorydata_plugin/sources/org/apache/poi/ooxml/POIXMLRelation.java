package org.apache.poi.ooxml;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.openxml4j.opc.PackagePart;

/* JADX INFO: loaded from: classes7.dex */
public abstract class POIXMLRelation {
    private static final c LOGGER = null;
    private final String _defaultName;
    private final String _relation;
    private final String _type;
    private final NoArgConstructor noArgConstructor;
    private final PackagePartConstructor packagePartConstructor;
    private final ParentPartConstructor parentPartConstructor;

    public interface NoArgConstructor {
        POIXMLDocumentPart init();
    }

    public interface PackagePartConstructor {
        POIXMLDocumentPart init(PackagePart r1);
    }

    public interface ParentPartConstructor {
        POIXMLDocumentPart init(POIXMLDocumentPart r1, PackagePart r2);
    }

    static {
        LOGGER = b.a(POIXMLRelation.class);
    }

    public POIXMLRelation(String r8, String r9, String r10) {
        this(r8, r9, r10, null, null, null);
    }

    public POIXMLRelation(String r3, String r4, String r5, NoArgConstructor r6, PackagePartConstructor r7, ParentPartConstructor r8) {
        NoArgConstructor r9 = (NoArgConstructor) ZeusTransformUtils.wrapperContextForParams(r6, NoArgConstructor.class, "com.obric.memorydata.plugin");
        PackagePartConstructor r10 = (PackagePartConstructor) ZeusTransformUtils.wrapperContextForParams(r7, PackagePartConstructor.class, "com.obric.memorydata.plugin");
        ParentPartConstructor r11 = (ParentPartConstructor) ZeusTransformUtils.wrapperContextForParams(r8, ParentPartConstructor.class, "com.obric.memorydata.plugin");
        this._type = r3;
        this._relation = r4;
        this._defaultName = r5;
        this.noArgConstructor = r9;
        this.packagePartConstructor = r10;
        this.parentPartConstructor = r11;
    }

    public String getContentType() {
        return this._type;
    }

    public String getDefaultFileName() {
        return this._defaultName;
    }

    public String getFileName(int r3) {
        if (this._defaultName.contains("#") == true) goto L7;
        return getDefaultFileName();
    L7:
        return this._defaultName.replace("#", Integer.toString(r3));
    }

    public NoArgConstructor getNoArgConstructor() {
        return this.noArgConstructor;
    }

    public PackagePartConstructor getPackagePartConstructor() {
        return this.packagePartConstructor;
    }

    public ParentPartConstructor getParentPartConstructor() {
        return this.parentPartConstructor;
    }

    public String getRelation() {
        return this._relation;
    }
}
