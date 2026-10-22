package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ed extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ed> f20104a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20105b = null;

    static {
        DocumentFactory<ed> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctstyles8506type");
        f20104a = r0;
        f20105b = r0.getType();
    }

    w getDocDefaults();

    bf getLatentStyles();

    ec[] getStyleArray();

    boolean isSetDocDefaults();
}
