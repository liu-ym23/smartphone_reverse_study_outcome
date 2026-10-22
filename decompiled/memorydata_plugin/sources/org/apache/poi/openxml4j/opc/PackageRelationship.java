package org.apache.poi.openxml4j.opc;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class PackageRelationship {
    private static URI containerRelationshipPart;
    private final OPCPackage container;
    private final String id;
    private final String relationshipType;
    private final PackagePart source;
    private final TargetMode targetMode;
    private final URI targetUri;

    static {
        containerRelationshipPart = new URI("/_rels/.rels");     // Catch: URISyntaxException -> L4
        return;
    }

    public PackageRelationship(OPCPackage r1, PackagePart r2, URI r3, TargetMode r4, String r5, String r6) {
        if (r1 == null) goto L16;
        if (r3 == null) goto L14;
        if (r5 == null) goto L12;
        if (r6 == null) goto L10;
        this.container = r1;
        this.source = r2;
        this.targetUri = r3;
        this.targetMode = r4;
        this.relationshipType = r5;
        this.id = r6;
        return;
    L10:
        throw new IllegalArgumentException(OaidModel.KEY_ID);
    L12:
        throw new IllegalArgumentException("relationshipType");
    L14:
        throw new IllegalArgumentException("targetUri");
    L16:
        throw new IllegalArgumentException("pkg");
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, PackageRelationship.class) == true) goto L5;
        return false;
    L5:
        PackageRelationship r5 = (PackageRelationship) ZeusTransformUtils.preCheckCast(r4, PackageRelationship.class, "com.obric.memorydata.plugin");
        if (this.id.equals(r5.id) == true) goto L8;
        return false;
    L8:
        if (this.relationshipType.equals(r5.relationshipType) == false) goto L20;
        PackagePart r0 = r5.source;
        if (r0 == null) goto L14;
        if (r0.equals(this.source) == true) goto L14;
        return false;
    L14:
        if (this.targetMode == r5.targetMode) goto L16;
        return false;
    L16:
        if (this.targetUri.equals(r5.targetUri) == false) goto L23;
        return true;
    L23:
        return false;
    L20:
        return false;
    }

    public String getId() {
        return this.id;
    }

    public String getRelationshipType() {
        return this.relationshipType;
    }

    public URI getSourceURI() {
        PackagePart r0 = this.source;
        if (r0 != null) goto L7;
        return PackagingURIHelper.PACKAGE_ROOT_URI;
    L7:
        return r0._partName.getURI();
    }

    public TargetMode getTargetMode() {
        return this.targetMode;
    }

    public URI getTargetURI() {
        if (this.targetMode != TargetMode.EXTERNAL) goto L7;
        return this.targetUri;
    L7:
        if (this.targetUri.toASCIIString().startsWith("/") == true) goto L11;
        return PackagingURIHelper.resolvePartUri(getSourceURI(), this.targetUri);
    L11:
        return this.targetUri;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.relationshipType, this.source, this.targetMode, this.targetUri});
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("id=").append(this.id).append(" - container=").append(this.container).append(" - relationshipType=").append(this.relationshipType);
        if (this.source != null) goto L5;
        String r1 = " - source=null";
    L6:
        StringBuilder r2 = r0.append(r1).append(" - target=").append(getTargetURI().toASCIIString());
        if (this.targetMode != null) goto L9;
        String r3 = ",targetMode=null";
    L11:
        return r2.append(r3).toString();
    L9:
        r3 = ",targetMode=" + this.targetMode;
        goto L11
    L5:
        r1 = " - source=" + getSourceURI().toASCIIString();
        goto L6
    }
}
