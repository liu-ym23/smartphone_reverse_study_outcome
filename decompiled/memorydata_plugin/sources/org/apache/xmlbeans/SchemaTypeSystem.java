package org.apache.xmlbeans;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaTypeSystem extends SchemaTypeLoader {
    ClassLoader getClassLoader();

    SchemaComponent resolveHandle(String r1);

    SchemaType typeForHandle(String r1);
}
