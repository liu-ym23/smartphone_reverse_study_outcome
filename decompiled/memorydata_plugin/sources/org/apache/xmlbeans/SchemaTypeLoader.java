package org.apache.xmlbeans;

import java.io.InputStream;
import javax.xml.namespace.QName;
import javax.xml.stream.e;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaTypeLoader {
    SchemaGlobalAttribute findAttribute(QName r1);

    SchemaAttributeGroup.Ref findAttributeGroupRef(QName r1);

    SchemaGlobalAttribute.Ref findAttributeRef(QName r1);

    SchemaType findAttributeType(QName r1);

    SchemaType.Ref findAttributeTypeRef(QName r1);

    SchemaType findDocumentType(QName r1);

    SchemaType.Ref findDocumentTypeRef(QName r1);

    SchemaGlobalElement findElement(QName r1);

    SchemaGlobalElement.Ref findElementRef(QName r1);

    SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName r1);

    SchemaModelGroup.Ref findModelGroupRef(QName r1);

    SchemaType findType(QName r1);

    SchemaType.Ref findTypeRef(QName r1);

    XmlObject newInstance(SchemaType r1, XmlOptions r2);

    XmlObject parse(InputStream r1, SchemaType r2, XmlOptions r3);

    XmlObject parse(String r1, SchemaType r2, XmlOptions r3);

    XmlObject parse(e r1, SchemaType r2, XmlOptions r3);

    XmlObject parse(Node r1, SchemaType r2, XmlOptions r3);

    SchemaType typeForSignature(String r1);
}
