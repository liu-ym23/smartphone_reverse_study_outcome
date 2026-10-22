package org.apache.xmlbeans.impl.common;

import javax.xml.namespace.QName;
import javax.xml.stream.a;
import org.apache.xmlbeans.XmlCursor;

/* JADX INFO: loaded from: classes7.dex */
public interface ValidatorListener {

    public interface Event extends PrefixResolver {
        a getLocation();

        XmlCursor getLocationAsCursor();

        QName getName();

        String getText();

        String getText(int r1);

        String getXsiNil();

        String getXsiType();

        boolean textIsWhitespace();
    }

    void nextEvent(int r1, Event r2);
}
