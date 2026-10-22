package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ay extends gf {
    public static final DocumentFactory<ay> c = null;
    public static final SchemaType d = null;

    static {
        DocumentFactory<ay> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctdefinedname9413type");
        c = r0;
        d = r0.getType();
    }

    boolean getFunction();

    long getLocalSheetId();

    String getName();

    boolean isSetLocalSheetId();

    void setFunction(boolean r1);

    void setLocalSheetId(long r1);

    void setName(String r1);

    void unsetLocalSheetId();
}
