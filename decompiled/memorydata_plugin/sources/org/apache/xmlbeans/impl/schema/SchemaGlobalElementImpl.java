package org.apache.xmlbeans.impl.schema;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaGlobalElement;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaGlobalElementImpl extends SchemaLocalElementImpl implements SchemaGlobalElement {
    private static final QName[] _namearray = null;
    private SchemaContainer _container;
    private String _filename;
    private boolean _finalExt;
    private boolean _finalRest;
    private SchemaGlobalElement.Ref _selfref;
    private SchemaGlobalElement.Ref _sg;
    private Set _sgMembers;

    static {
        _namearray = new QName[0];
    }

    public SchemaGlobalElementImpl(SchemaContainer r2) {
        this._sgMembers = new LinkedHashSet();
        this._selfref = new SchemaGlobalElement.Ref(this);
        this._container = r2;
    }

    public void addSubstitutionGroupMember(QName r1) {
        mutate();
        this._sgMembers.add(r1);
    }

    public void setFilename(String r1) {
        this._filename = r1;
    }

    void setFinal(boolean r1, boolean r2) {
        mutate();
        this._finalExt = r1;
        this._finalRest = r2;
    }

    public void setSubstitutionGroup(SchemaGlobalElement.Ref r1) {
        this._sg = r1;
    }
}
