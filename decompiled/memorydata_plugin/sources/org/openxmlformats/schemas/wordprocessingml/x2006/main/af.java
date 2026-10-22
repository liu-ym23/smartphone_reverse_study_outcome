package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface af extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<af> f19906a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19907b = null;

    static {
        DocumentFactory<af> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctendnotescee2type");
        f19906a = r0;
        f19907b = r0.getType();
    }

    List<ap> getEndnoteList();
}
