package org.apache.poi.sl.draw;

import java.io.InvalidObjectException;
import java.text.AttributedCharacterIterator;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes7.dex */
public class DrawTextParagraph {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final XlinkAttribute HYPERLINK_HREF = null;
    public static final XlinkAttribute HYPERLINK_LABEL = null;
    private static final c LOG = null;

    private static class XlinkAttribute extends AttributedCharacterIterator.Attribute {
        XlinkAttribute(String r1) {
            super(r1);
        }

        @Override // java.text.AttributedCharacterIterator.Attribute
        public Object readResolve() {
            if (DrawTextParagraph.HYPERLINK_HREF.getName().equals(getName()) == false) goto L7;
            return DrawTextParagraph.HYPERLINK_HREF;
        L7:
            if (DrawTextParagraph.HYPERLINK_LABEL.getName().equals(getName()) == false) goto L11;
            return DrawTextParagraph.HYPERLINK_LABEL;
        L11:
            throw new InvalidObjectException("unknown attribute name");
        }
    }

    static {
        LOG = b.a(DrawTextParagraph.class);
        HYPERLINK_HREF = new XlinkAttribute("href");
        HYPERLINK_LABEL = new XlinkAttribute(AnnotatedPrivateKey.LABEL);
    }
}
