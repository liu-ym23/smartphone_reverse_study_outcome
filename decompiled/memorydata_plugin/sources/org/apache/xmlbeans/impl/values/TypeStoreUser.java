package org.apache.xmlbeans.impl.values;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;

/* JADX INFO: loaded from: classes7.dex */
public interface TypeStoreUser {
    void attach_store(TypeStore r1);

    boolean build_nil();

    String build_text(NamespaceManager r1);

    TypeStoreUser create_attribute_user(QName r1);

    TypeStoreUser create_element_user(QName r1, QName r2);

    void disconnect_store();

    SchemaField get_attribute_field(QName r1);

    SchemaType get_attribute_type(QName r1);

    int get_attributeflags(QName r1);

    String get_default_attribute_text(QName r1);

    String get_default_element_text(QName r1);

    QNameSet get_element_ending_delimiters(QName r1);

    SchemaType get_element_type(QName r1, QName r2);

    int get_elementflags(QName r1);

    SchemaType get_schema_type();

    TypeStore get_store();

    void invalidate_nilvalue();

    void invalidate_value();

    TypeStoreVisitor new_visitor();
}
