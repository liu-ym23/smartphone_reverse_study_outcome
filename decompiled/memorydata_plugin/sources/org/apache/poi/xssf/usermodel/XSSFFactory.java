package org.apache.poi.xssf.usermodel;

import org.apache.poi.ooxml.POIXMLFactory;
import org.apache.poi.ooxml.POIXMLRelation;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFFactory extends POIXMLFactory {
    private static final XSSFFactory inst = null;

    static {
        inst = new XSSFFactory();
    }

    public XSSFFactory() {
    }

    public static XSSFFactory getInstance() {
        return inst;
    }

    @Override // org.apache.poi.ooxml.POIXMLFactory
    public POIXMLRelation getDescriptor(String r1) {
        return XSSFRelation.getInstance(r1);
    }
}
