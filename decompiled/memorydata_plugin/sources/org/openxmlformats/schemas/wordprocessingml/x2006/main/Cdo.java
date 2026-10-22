package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: renamed from: org.openxmlformats.schemas.wordprocessingml.x2006.main.do, reason: invalid class name */
/* JADX INFO: loaded from: classes8.dex */
public interface Cdo extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<Cdo> f20072a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20073b = null;

    static {
        DocumentFactory<Cdo> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsdtpre24dtype");
        f20072a = r0;
        f20073b = r0.getType();
    }

    eb getAlias();

    eb getTag();

    boolean isSetAlias();

    boolean isSetTag();
}
