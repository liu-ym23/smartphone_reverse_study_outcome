package com.tom_roush.pdfbox.pdmodel.interactive.annotation.layout;

import java.text.AttributedCharacterIterator;

/* JADX INFO: loaded from: classes6.dex */
public class PlainText {

    static class TextAttribute extends AttributedCharacterIterator.Attribute {
        public static final AttributedCharacterIterator.Attribute WIDTH = null;
        private static final long serialVersionUID = -3138885145941283005L;

        static {
            WIDTH = new TextAttribute("width");
        }

        public TextAttribute(String r1) {
            super(r1);
        }
    }
}
