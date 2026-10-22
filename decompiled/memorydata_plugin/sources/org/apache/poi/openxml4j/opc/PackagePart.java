package org.apache.poi.openxml4j.opc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.opc.internal.ContentType;

/* JADX INFO: loaded from: classes7.dex */
public abstract class PackagePart implements Comparable<PackagePart> {
    protected OPCPackage _container;
    protected ContentType _contentType;
    private boolean _isDeleted;
    private final boolean _isRelationshipPart;
    protected PackagePartName _partName;
    private PackageRelationshipCollection _relationships;

    public PackagePart(OPCPackage r2, PackagePartName r3, String r4) {
        this(r2, r3, new ContentType(r4));
    }

    public PackagePart(OPCPackage r2, PackagePartName r3, ContentType r4) {
        this(r2, r3, r4, true);
    }

    public PackagePart(OPCPackage r1, PackagePartName r2, ContentType r3, boolean r4) {
        this._partName = r2;
        this._contentType = r3;
        this._container = r1;
        this._isRelationshipPart = r2.isRelationshipPartURI();
        if (r4 == false) goto L6;
        loadRelationships();
        return;
    }

    private PackageRelationshipCollection getRelationshipsCore(String r2) {
        this._container.throwExceptionIfWriteOnly();
        if (this._relationships != null) goto L6;
        throwExceptionIfRelationship();
        this._relationships = new PackageRelationshipCollection(this);
    L6:
        return new PackageRelationshipCollection(this._relationships, r2);
    }

    private void throwExceptionIfRelationship() {
        if (this._isRelationshipPart == true) goto L6;
        return;
    L6:
        throw new InvalidOperationException("Can do this operation on a relationship part !");
    }

    public PackageRelationship addExternalRelationship(String r2, String r3) {
        return addExternalRelationship(r2, r3, null);
    }

    public PackageRelationship addExternalRelationship(String r2, String r3, String r4) {
        if (r2 == null) goto L16;
        if (r3 == null) goto L14;
        if (this._relationships != null) goto L17;
        this._relationships = new PackageRelationshipCollection();
    L17:
        return this._relationships.addRelationship(new URI(r2), TargetMode.EXTERNAL, r3, r4);
    L10:
        e = move-exception;
        throw new IllegalArgumentException("Invalid target - " + e);
    L14:
        throw new IllegalArgumentException("relationshipType");
    L16:
        throw new IllegalArgumentException("target is null for type " + r3);
    }

    public PackageRelationship addRelationship(PackagePartName r2, TargetMode r3, String r4) {
        return addRelationship(r2, r3, r4, null);
    }

    public PackageRelationship addRelationship(PackagePartName r2, TargetMode r3, String r4, String r5) {
        this._container.throwExceptionIfReadOnly();
        if (r2 == null) goto L22;
        if (r3 == null) goto L20;
        if (r4 == null) goto L18;
        if (this._isRelationshipPart == true) goto L16;
        if (r2.isRelationshipPartURI() == true) goto L16;
        if (this._relationships != null) goto L14;
        this._relationships = new PackageRelationshipCollection();
    L14:
        return this._relationships.addRelationship(r2.getURI(), r3, r4, r5);
    L16:
        throw new InvalidOperationException("Rule M1.25: The Relationships part shall not have relationships to any other part.");
    L18:
        throw new IllegalArgumentException("relationshipType");
    L20:
        throw new IllegalArgumentException("targetMode");
    L22:
        throw new IllegalArgumentException("targetPartName");
    }

    public void clear() {
    }

    public void clearRelationships() {
        PackageRelationshipCollection r0 = this._relationships;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(PackagePart r3) {
        return compareTo2((PackagePart) ZeusTransformUtils.preCheckCast(r3, PackagePart.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(PackagePart r1) {
        if (r1 != null) goto L6;
        return -1;
    L6:
        return PackagePartName.compare(this._partName, r1._partName);
    }

    public PackageRelationship findExistingRelation(PackagePart r1) {
        return this._relationships.findExistingInternalRelation(r1);
    }

    public String getContentType() {
        return this._contentType.toString();
    }

    public InputStream getInputStream() {
        InputStream r0 = getInputStreamImpl();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IOException("Can't obtain the input stream from " + this._partName.getName());
    }

    public abstract InputStream getInputStreamImpl();

    public OutputStream getOutputStream() {
        if (ZeusTransformUtils.instanceOf(this, ZipPackagePart.class) == false) goto L10;
        this._container.removePart(this._partName);
        PackagePart r0 = this._container.createPart(this._partName, this._contentType.toString(), false);
        if (r0 == null) goto L8;
        r0._relationships = this._relationships;
        return r0.getOutputStreamImpl();
    L8:
        throw new InvalidOperationException("Can't create a temporary part !");
    L10:
        return getOutputStreamImpl();
    }

    public abstract OutputStream getOutputStreamImpl();

    public OPCPackage getPackage() {
        return this._container;
    }

    public PackagePartName getPartName() {
        return this._partName;
    }

    public PackagePart getRelatedPart(PackageRelationship r6) {
        if (isRelationshipExists(r6) == false) goto L17;
        URI r0 = r6.getTargetURI();
        if (r0.getFragment() == null) goto L11;
        String r1 = r0.toString();
        r0 = new URI(r1.substring(0, r1.indexOf(35)));     // Catch: URISyntaxException -> L9
    L10:
        throw new InvalidFormatException("Invalid target URI: " + r0);
    L11:
        PackagePart r5 = this._container.getPart(PackagingURIHelper.createPartName(r0));
        if (r5 == null) goto L15;
        return r5;
    L15:
        throw new IllegalArgumentException("No part found for relationship " + r6);
    L17:
        throw new IllegalArgumentException("Relationship " + r6 + " doesn't start with this part " + this._partName);
    }

    public PackageRelationship getRelationship(String r1) {
        return this._relationships.getRelationshipByID(r1);
    }

    public PackageRelationshipCollection getRelationships() {
        return getRelationshipsCore(null);
    }

    public PackageRelationshipCollection getRelationshipsByType(String r2) {
        this._container.throwExceptionIfWriteOnly();
        return getRelationshipsCore(r2);
    }

    public long getSize() {
        return -1;
    }

    public boolean hasRelationships() {
        if (this._isRelationshipPart == true) goto L9;
        PackageRelationshipCollection r1 = this._relationships;
        if (r1 == null) goto L9;
        if (r1.isEmpty() == true) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isDeleted() {
        return this._isDeleted;
    }

    public boolean isRelationshipExists(PackageRelationship r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (this._relationships.getRelationshipByID(r1.getId()) == null) goto L6;
        return true;
    }

    public boolean isRelationshipPart() {
        return this._isRelationshipPart;
    }

    void loadRelationships() {
        if (this._relationships == null) goto L5;
        return;
    L5:
        if (this._isRelationshipPart == true) goto L9;
        throwExceptionIfRelationship();
        this._relationships = new PackageRelationshipCollection(this);
        return;
    }

    public void removeRelationship(String r2) {
        this._container.throwExceptionIfReadOnly();
        PackageRelationshipCollection r1 = this._relationships;
        if (r1 == null) goto L6;
        r1.removeRelationship(r2);
        return;
    }

    public abstract boolean save(OutputStream r1);

    public void setDeleted(boolean r1) {
        this._isDeleted = r1;
    }

    public String toString() {
        return "Name: " + this._partName + " - Content Type: " + this._contentType;
    }
}
