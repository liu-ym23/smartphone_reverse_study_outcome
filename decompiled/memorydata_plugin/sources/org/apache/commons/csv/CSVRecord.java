package org.apache.commons.csv;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class CSVRecord implements Serializable, Iterable<String> {
    private static final String[] EMPTY_STRING_ARRAY = null;
    private static final long serialVersionUID = 1;
    private final long characterPosition;
    private final String comment;
    private final transient CSVParser parser;
    private final long recordNumber;
    private final String[] values;

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    CSVRecord(CSVParser r1, String[] r2, String r3, long r4, long r6) {
        this.recordNumber = r4;
        if (r2 != null) goto L6;
        r2 = EMPTY_STRING_ARRAY;
    L6:
        this.values = r2;
        this.parser = r1;
        this.comment = r3;
        this.characterPosition = r6;
    }

    private Map<String, Integer> getHeaderMapRaw() {
        CSVParser r0 = this.parser;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getHeaderMapRaw();
    }

    private List<String> toList() {
        return Arrays.asList(this.values);
    }

    public String get(int r1) {
        return this.values[r1];
    }

    public String get(Enum<?> r2) {
        return get(Objects.toString(r2, null));
    }

    public String get(String r7) {
        Map<String, Integer> r0 = getHeaderMapRaw();
        if (r0 == null) goto L13;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.get(r7), Integer.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return this.values[r1.intValue()];
    L9:
        throw new IllegalArgumentException(String.format("Index for header '%s' is %d but CSVRecord only has %d values!", new Object[]{r7, r1, Integer.valueOf(this.values.length)}));
    L11:
        throw new IllegalArgumentException(String.format("Mapping for %s not found, expected one of %s", new Object[]{r7, r0.keySet()}));
    L13:
        throw new IllegalStateException("No header mapping was specified, the record values can't be accessed by name");
    }

    public long getCharacterPosition() {
        return this.characterPosition;
    }

    public String getComment() {
        return this.comment;
    }

    public CSVParser getParser() {
        return this.parser;
    }

    public long getRecordNumber() {
        return this.recordNumber;
    }

    public boolean hasComment() {
        if (this.comment == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isConsistent() {
        Map<String, Integer> r0 = getHeaderMapRaw();
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.size() == this.values.length) goto L8;
        return false;
    }

    public boolean isMapped(String r1) {
        Map<String, Integer> r0 = getHeaderMapRaw();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.containsKey(r1) == false) goto L7;
        return true;
    }

    public boolean isSet(int r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 >= this.values.length) goto L6;
        return true;
    }

    public boolean isSet(String r3) {
        if (isMapped(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Integer) ZeusTransformUtils.preCheckCast(getHeaderMapRaw().get(r3), Integer.class, "com.obric.memorydata.plugin")).intValue() >= this.values.length) goto L7;
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return toList().iterator();
    }

    <M extends Map<String, String>> M putIn(M r6) {
        M r7 = (M) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (getHeaderMapRaw() != null) goto L5;
        return r7;
    L5:
        Iterator<Map.Entry<String, Integer>> r0 = getHeaderMapRaw().entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r3 = ((Integer) ZeusTransformUtils.preCheckCast(r2.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r3 >= this.values.length) goto L7;
        r7.put(r2.getKey(), this.values[r3]);
        goto L7
    L11:
        return r7;
    }

    public int size() {
        return this.values.length;
    }

    public Map<String, String> toMap() {
        return putIn(new LinkedHashMap(this.values.length));
    }

    public String toString() {
        return "CSVRecord [comment='" + this.comment + "', recordNumber=" + this.recordNumber + ", values=" + Arrays.toString(this.values) + "]";
    }

    String[] values() {
        return this.values;
    }
}
