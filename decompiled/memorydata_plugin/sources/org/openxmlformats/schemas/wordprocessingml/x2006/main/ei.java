package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ei extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ei> f20114a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20115b = null;

    static {
        DocumentFactory<ei> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttblborders459ftype");
        f20114a = r0;
        f20115b = r0.getType();
    }

    i addNewBottom();

    i addNewInsideH();

    i addNewInsideV();

    i addNewLeft();

    i addNewRight();

    i addNewTop();
}
