package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ah extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ah> f19910a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19911b = null;

    static {
        DocumentFactory<ah> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctffdataaa7etype");
        f19910a = r0;
        f19911b = r0.getType();
    }

    List<ag> getCheckBoxList();
}
