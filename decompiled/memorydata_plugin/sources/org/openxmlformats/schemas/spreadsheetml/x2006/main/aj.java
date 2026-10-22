package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface aj extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<aj> f19427a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19428b = null;

    static {
        DocumentFactory<aj> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctconditionalformatting0deatype");
        f19427a = r0;
        f19428b = r0.getType();
    }

    x getCfRuleArray(int r1);

    List getSqref();

    int sizeOfCfRuleArray();
}
