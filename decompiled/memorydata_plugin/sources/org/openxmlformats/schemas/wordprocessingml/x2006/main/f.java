package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface f extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<f> f20144a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20145b = null;

    static {
        DocumentFactory<f> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctbody0f06type");
        f20144a = r0;
        f20145b = r0.getType();
    }

    dr addNewSectPr();

    dr getSectPr();

    boolean isSetSectPr();
}
