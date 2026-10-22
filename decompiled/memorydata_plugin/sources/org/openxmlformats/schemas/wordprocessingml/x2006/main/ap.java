package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.math.BigInteger;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ap extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ap> f19926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19927b = null;

    static {
        DocumentFactory<ap> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctftnedncad9type");
        f19926a = r0;
        f19927b = r0.getType();
    }

    BigInteger getId();

    STFtnEdn.Enum getType();
}
