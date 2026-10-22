package org.apache.poi.xwpf.usermodel;

import org.apache.poi.ooxml.POIXMLFactory;
import org.apache.poi.ooxml.POIXMLRelation;

/* JADX INFO: loaded from: classes7.dex */
public final class XWPFFactory extends POIXMLFactory {
    private static final XWPFFactory inst = null;

    static {
        inst = new XWPFFactory();
    }

    private XWPFFactory() {
    }

    public static XWPFFactory getInstance() {
        return inst;
    }

    @Override // org.apache.poi.ooxml.POIXMLFactory
    public POIXMLRelation getDescriptor(String r1) {
        return XWPFRelation.getInstance(r1);
    }
}
