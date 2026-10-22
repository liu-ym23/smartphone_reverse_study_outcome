package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface an extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<an> f19922a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19923b = null;

    static {
        DocumentFactory<an> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctfootnotes691ftype");
        f19922a = r0;
        f19923b = r0.getType();
    }

    List<ap> getFootnoteList();
}
