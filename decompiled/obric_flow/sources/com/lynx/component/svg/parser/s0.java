package com.lynx.component.svg.parser;

import org.xml.sax.Attributes;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 implements Attributes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XmlPullParser f9867a;

    public s0(XmlPullParser r5) {
        this.f9867a = r5;
    }

    @Override // org.xml.sax.Attributes
    public final int getIndex(String r5) {
        return -1;
    }

    @Override // org.xml.sax.Attributes
    public final int getLength() {
        return this.f9867a.getAttributeCount();
    }

    @Override // org.xml.sax.Attributes
    public final String getLocalName(int r5) {
        return this.f9867a.getAttributeName(r5);
    }

    @Override // org.xml.sax.Attributes
    public final String getQName(int r5) {
        XmlPullParser r10 = this.f9867a;
        String r11 = r10.getAttributeName(r5);
        if (r10.getAttributePrefix(r5) != null) goto L5;
        return r11;
    L5:
        return r10.getAttributePrefix(r5) + ':' + r11;
    }

    @Override // org.xml.sax.Attributes
    public final String getType(int r5) {
        return null;
    }

    @Override // org.xml.sax.Attributes
    public final String getURI(int r5) {
        return this.f9867a.getAttributeNamespace(r5);
    }

    @Override // org.xml.sax.Attributes
    public final String getValue(String r5) {
        return null;
    }

    @Override // org.xml.sax.Attributes
    public final int getIndex(String r5, String r10) {
        return -1;
    }

    @Override // org.xml.sax.Attributes
    public final String getType(String r5) {
        return null;
    }

    @Override // org.xml.sax.Attributes
    public final String getValue(String r5, String r10) {
        return null;
    }

    @Override // org.xml.sax.Attributes
    public final String getType(String r5, String r10) {
        return null;
    }

    @Override // org.xml.sax.Attributes
    public final String getValue(int r5) {
        return this.f9867a.getAttributeValue(r5);
    }
}
