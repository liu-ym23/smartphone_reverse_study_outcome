package org.apache.xmlbeans.impl.values;

import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlLocale;

/* JADX INFO: loaded from: classes7.dex */
public interface TypeStore extends NamespaceManager {
    TypeStoreUser add_attribute_user(QName r1);

    TypeStoreUser add_element_user(QName r1);

    TypeStoreUser change_type(SchemaType r1);

    String compute_default_text();

    int compute_flags();

    TypeStoreUser copy(SchemaTypeLoader r1, SchemaType r2, XmlOptions r3);

    TypeStoreUser copy_contents_from(TypeStore r1);

    int count_elements(QName r1);

    int count_elements(QNameSet r1);

    XmlObject[] exec_query(String r1, XmlOptions r2);

    String fetch_text(int r1);

    <T extends XmlObject> void find_all_element_users(QName r1, List<T> r2);

    <T extends XmlObject> void find_all_element_users(QNameSet r1, List<T> r2);

    TypeStoreUser find_attribute_user(QName r1);

    TypeStoreUser find_element_user(QName r1, int r2);

    TypeStoreUser find_element_user(QNameSet r1, int r2);

    boolean find_nil();

    XmlLocale get_locale();

    SchemaField get_schema_field();

    SchemaTypeLoader get_schematypeloader();

    TypeStoreUser insert_element_user(QName r1, int r2);

    TypeStoreUser insert_element_user(QNameSet r1, QName r2, int r3);

    void invalidate_nil();

    void invalidate_text();

    boolean is_attribute();

    XmlCursor new_cursor();

    void remove_attribute(QName r1);

    void remove_element(QName r1, int r2);

    void remove_element(QNameSet r1, int r2);

    void store_text(String r1);

    TypeStoreUser substitute(QName r1, SchemaType r2);

    void validate(ValidatorListener r1);

    boolean validate_on_set();
}
