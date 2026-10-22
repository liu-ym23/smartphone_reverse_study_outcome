package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ah extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ah> f19423a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19424b = null;

    static {
        DocumentFactory<ah> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcommentlist7a3ctype");
        f19423a = r0;
        f19424b = r0.getType();
    }

    ag[] getCommentArray();
}
