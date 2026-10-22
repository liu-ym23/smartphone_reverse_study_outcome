package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaType extends SchemaComponent {

    public static final class Ref extends SchemaComponent.Ref {
        public Ref(SchemaType r3) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
        }

        public Ref(SchemaTypeSystem r3, String r4) {
            super((SchemaTypeSystem) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeSystem.class, "com.obric.memorydata.plugin"), r4);
        }

        public final SchemaType get() {
            return (SchemaType) ZeusTransformUtils.preCheckCast(getComponent(), SchemaType.class, "com.obric.memorydata.plugin");
        }
    }

    boolean blockExtension();

    boolean blockRestriction();

    StringEnumAbstractBase enumForString(String r1);

    SchemaType[] getAnonymousTypes();

    int getAnonymousUnionMemberOrdinal();

    SchemaAttributeModel getAttributeModel();

    SchemaProperty getAttributeProperty(QName r1);

    SchemaType getAttributeType(QName r1, SchemaTypeLoader r2);

    QName getAttributeTypeAttributeName();

    SchemaType getBaseType();

    int getBuiltinTypeCode();

    SchemaType getCommonBaseType(SchemaType r1);

    SchemaField getContainerField();

    SchemaType getContentBasedOnType();

    SchemaParticle getContentModel();

    int getContentType();

    int getDecimalSize();

    int getDerivationType();

    QName getDocumentElementName();

    SchemaProperty[] getElementProperties();

    SchemaProperty getElementProperty(QName r1);

    SchemaType getElementType(QName r1, QName r2, SchemaTypeLoader r3);

    Class<? extends StringEnumAbstractBase> getEnumJavaClass();

    XmlAnySimpleType[] getEnumerationValues();

    XmlAnySimpleType getFacet(int r1);

    String getFullJavaName();

    Class<? extends XmlObject> getJavaClass();

    SchemaType getListItemType();

    @Override // org.apache.xmlbeans.SchemaComponent
    QName getName();

    SchemaType getOuterType();

    SchemaType getPrimitiveType();

    SchemaProperty[] getProperties();

    Ref getRef();

    int getSimpleVariety();

    SchemaType[] getUnionConstituentTypes();

    SchemaType[] getUnionMemberTypes();

    int getWhiteSpaceRule();

    boolean hasPatternFacet();

    boolean hasStringEnumValues();

    boolean isAbstract();

    boolean isAssignableFrom(SchemaType r1);

    boolean isAttributeType();

    boolean isDocumentType();

    boolean isNoType();

    boolean isOrderSensitive();

    boolean isSimpleType();

    boolean isURType();

    boolean isValidSubstitution(QName r1);

    boolean matchPatternFacet(String r1);

    XmlAnySimpleType newValue(Object r1);
}
