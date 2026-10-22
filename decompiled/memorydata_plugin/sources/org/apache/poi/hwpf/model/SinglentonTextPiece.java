package org.apache.poi.hwpf.model;

import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class SinglentonTextPiece extends TextPiece {
    public SinglentonTextPiece(StringBuilder r5) {
        super(0, r5.length(), StringUtil.getToUnicodeLE(r5.toString()), new PieceDescriptor(new byte[8], 0));
    }

    @Override // org.apache.poi.hwpf.model.TextPiece
    public int bytesLength() {
        return getStringBuilder().length() * 2;
    }

    @Override // org.apache.poi.hwpf.model.TextPiece
    public int characterLength() {
        return getStringBuilder().length();
    }

    @Override // org.apache.poi.hwpf.model.PropertyNode
    public int getEnd() {
        return characterLength();
    }

    @Override // org.apache.poi.hwpf.model.PropertyNode
    public int getStart() {
        return 0;
    }

    @Override // org.apache.poi.hwpf.model.TextPiece
    public String toString() {
        return "SinglentonTextPiece (" + characterLength() + " chars)";
    }
}
