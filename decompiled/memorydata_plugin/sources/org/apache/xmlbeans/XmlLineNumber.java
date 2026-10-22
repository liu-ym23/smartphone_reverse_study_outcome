package org.apache.xmlbeans;

/* JADX INFO: loaded from: classes7.dex */
public class XmlLineNumber extends XmlCursor.XmlBookmark {
    private int _column;
    private int _line;
    private int _offset;

    public XmlLineNumber(int r2, int r3, int r4) {
        super(false);
        this._line = r2;
        this._column = r3;
        this._offset = r4;
    }

    public int getColumn() {
        return this._column;
    }

    public int getLine() {
        return this._line;
    }

    public int getOffset() {
        return this._offset;
    }
}
