package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.math.BigInteger;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface q extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<q> f19781a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19782b = null;

    static {
        DocumentFactory<q> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcellalignmentb580type");
        f19781a = r0;
        f19782b = r0.getType();
    }

    long getIndent();

    BigInteger getTextRotation();
}
