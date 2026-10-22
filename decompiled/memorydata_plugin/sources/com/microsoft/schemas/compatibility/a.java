package com.microsoft.schemas.compatibility;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<a> f5657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5658b = null;

    /* JADX INFO: renamed from: com.microsoft.schemas.compatibility.a$a, reason: collision with other inner class name */
    public interface InterfaceC0224a extends XmlObject {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ElementFactory<InterfaceC0224a> f5659a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final SchemaType f5660b = null;

        /* JADX INFO: renamed from: com.microsoft.schemas.compatibility.a$a$a, reason: collision with other inner class name */
        public interface InterfaceC0225a extends XmlObject {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final ElementFactory<InterfaceC0225a> f5661a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final SchemaType f5662b = null;

            static {
                ElementFactory<InterfaceC0225a> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "choice69c6elemtype");
                f5661a = r0;
                f5662b = r0.getType();
            }

            String getRequires();
        }

        /* JADX INFO: renamed from: com.microsoft.schemas.compatibility.a$a$b */
        public interface b extends XmlObject {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final ElementFactory<b> f5663a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final SchemaType f5664b = null;

            static {
                ElementFactory<b> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "fallback4cc7elemtype");
                f5663a = r0;
                f5664b = r0.getType();
            }
        }

        static {
            ElementFactory<InterfaceC0224a> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "alternatecontenta8a9elemtype");
            f5659a = r0;
            f5660b = r0.getType();
        }

        InterfaceC0225a getChoiceArray(int r1);

        b getFallback();

        boolean isSetFallback();

        int sizeOfChoiceArray();
    }

    static {
        DocumentFactory<a> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "alternatecontentdd64doctype");
        f5657a = r0;
        f5658b = r0.getType();
    }

    InterfaceC0224a getAlternateContent();
}
