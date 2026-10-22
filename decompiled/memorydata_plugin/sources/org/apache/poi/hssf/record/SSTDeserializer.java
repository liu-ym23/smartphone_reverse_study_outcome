package org.apache.poi.hssf.record;

import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.util.IntMapper;

/* JADX INFO: loaded from: classes7.dex */
class SSTDeserializer {
    private static final c LOG = null;
    private IntMapper<UnicodeString> strings;

    static {
        LOG = b.a(SSTDeserializer.class);
    }

    public SSTDeserializer(IntMapper<UnicodeString> r1) {
        this.strings = r1;
    }

    public static void addToStringTable(IntMapper<UnicodeString> r0, UnicodeString r1) {
        r0.add(r1);
    }

    public void manufactureStrings(int r5, RecordInputStream r6) {
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L11;
        if (r6.available() == 0) goto L7;
    L9:
        UnicodeString r1 = new UnicodeString(r6);
    L10:
        addToStringTable(this.strings, r1);
        r0 = r0 + 1;
        goto L3
    L7:
        if (r6.hasNextRecord() == true) goto L9;
        LOG.atError().a("Ran out of data before creating all the strings! String at index {}", v.a(r0));
        r1 = new UnicodeString("");
        goto L10
    }
}
