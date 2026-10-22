package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ai extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ai> f19425a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19426b = null;

    static {
        DocumentFactory<ai> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcommentse3bdtype");
        f19425a = r0;
        f19426b = r0.getType();
    }

    a addNewAuthors();

    ah addNewCommentList();

    ah getCommentList();
}
