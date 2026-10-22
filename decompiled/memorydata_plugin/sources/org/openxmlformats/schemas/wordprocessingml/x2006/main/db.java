package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface db extends fj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<db> f20046a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20047b = null;

    static {
        DocumentFactory<db> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctruntrackchangea458type");
        f20046a = r0;
        f20047b = r0.getType();
    }

    db[] getInsArray();

    cq[] getRArray();
}
