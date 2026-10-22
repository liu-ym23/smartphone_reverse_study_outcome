package com.microsoft.schemas.office.visio.x2012.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface r extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<r> f5735a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5736b = null;

    static {
        DocumentFactory<r> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "shapesheettype59bbtype");
        f5735a = r0;
        f5736b = r0.getType();
    }

    String getType();
}
