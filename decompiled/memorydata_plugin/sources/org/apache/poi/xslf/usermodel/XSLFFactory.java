package org.apache.poi.xslf.usermodel;

import org.apache.poi.ooxml.POIXMLFactory;
import org.apache.poi.ooxml.POIXMLRelation;

/* JADX INFO: loaded from: classes7.dex */
public final class XSLFFactory extends POIXMLFactory {
    private static final XSLFFactory inst = null;

    static {
        inst = new XSLFFactory();
    }

    private XSLFFactory() {
    }

    public static XSLFFactory getInstance() {
        return inst;
    }

    @Override // org.apache.poi.ooxml.POIXMLFactory
    public POIXMLRelation getDescriptor(String r1) {
        return XSLFRelation.getInstance(r1);
    }
}
