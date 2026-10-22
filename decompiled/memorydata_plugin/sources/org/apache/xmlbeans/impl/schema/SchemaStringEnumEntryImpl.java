package org.apache.xmlbeans.impl.schema;

import org.apache.xmlbeans.SchemaStringEnumEntry;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaStringEnumEntryImpl implements SchemaStringEnumEntry {
    private String _enumName;
    private int _int;
    private String _string;

    public SchemaStringEnumEntryImpl(String r1, int r2, String r3) {
        this._string = r1;
        this._int = r2;
        this._enumName = r3;
    }

    @Override // org.apache.xmlbeans.SchemaStringEnumEntry
    public int getIntValue() {
        return this._int;
    }

    @Override // org.apache.xmlbeans.SchemaStringEnumEntry
    public String getString() {
        return this._string;
    }
}
