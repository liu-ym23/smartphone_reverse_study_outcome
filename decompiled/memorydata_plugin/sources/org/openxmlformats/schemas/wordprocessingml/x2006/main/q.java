package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface q extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<q> f20234a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20235b = null;

    static {
        DocumentFactory<q> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcomments7674type");
        f20234a = r0;
        f20235b = r0.getType();
    }

    List<p> getCommentList();
}
