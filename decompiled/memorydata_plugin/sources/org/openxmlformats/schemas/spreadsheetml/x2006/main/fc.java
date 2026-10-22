package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fc extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fc> f19677a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19678b = null;

    static {
        DocumentFactory<fc> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttablestylea24ctype");
        f19677a = r0;
        f19678b = r0.getType();
    }

    String getName();

    List<fd> getTableStyleElementList();
}
