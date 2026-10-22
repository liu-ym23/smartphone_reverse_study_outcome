package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface eh extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<eh> f20112a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20113b = null;

    static {
        DocumentFactory<eh> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttblc014type");
        f20112a = r0;
        f20113b = r0.getType();
    }

    er addNewTblPr();

    cw addNewTr();

    List<cw> getTrList();

    int sizeOfTrArray();
}
