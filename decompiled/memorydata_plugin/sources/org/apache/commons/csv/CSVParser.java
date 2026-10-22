package org.apache.commons.csv;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes6.dex */
public final class CSVParser implements Closeable, Iterable<CSVRecord> {
    private final long characterOffset;
    private final CSVRecordIterator csvRecordIterator;
    private final CSVFormat format;
    private final Map<String, Integer> headerMap;
    private final List<String> headerNames;
    private final Lexer lexer;
    private final List<String> recordList;
    private long recordNumber;
    private final Token reusableToken;

    /* JADX INFO: renamed from: org.apache.commons.csv.CSVParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$csv$Token$Type = null;

        static {
            int[] r0 = new int[Token.Type.values().length];
            $SwitchMap$org$apache$commons$csv$Token$Type = r0;
            r0[Token.Type.TOKEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$commons$csv$Token$Type[Token.Type.EORECORD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$commons$csv$Token$Type[Token.Type.EOF.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$apache$commons$csv$Token$Type[Token.Type.INVALID.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$apache$commons$csv$Token$Type[Token.Type.COMMENT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    class CSVRecordIterator implements Iterator<CSVRecord> {
        private CSVRecord current;
        final /* synthetic */ CSVParser this$0;

        CSVRecordIterator(CSVParser r1) {
            this.this$0 = r1;
        }

        private CSVRecord getNextRecord() {
            return this.this$0.nextRecord();
        L4:
            e = move-exception;
            throw new IllegalStateException(e.getClass().getSimpleName() + " reading next record: " + e.toString(), e);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.this$0.isClosed() == false) goto L6;
            return false;
        L6:
            if (this.current != null) goto L9;
            this.current = getNextRecord();
        L9:
            if (this.current == null) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ CSVRecord next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public CSVRecord next2() {
            if (this.this$0.isClosed() == true) goto L13;
            CSVRecord r0 = this.current;
            this.current = null;
            if (r0 != null) goto L11;
            r0 = getNextRecord();
            if (r0 != null) goto L11;
            throw new NoSuchElementException("No more CSV records available");
        L11:
            return r0;
        L13:
            throw new NoSuchElementException("CSVParser has been closed");
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class Headers {
        final Map<String, Integer> headerMap;
        final List<String> headerNames;

        Headers(Map<String, Integer> r3, List<String> r4) {
            Map<String, Integer> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.headerMap = r5;
            this.headerNames = r6;
        }
    }

    public CSVParser(Reader r8, CSVFormat r9) {
        this(r8, r9, 0, 1);
    }

    public CSVParser(Reader r3, CSVFormat r4, long r5, long r7) {
        this.recordList = new ArrayList();
        this.reusableToken = new Token();
        Assertions.notNull(r3, "reader");
        Assertions.notNull(r4, "format");
        this.format = r4;
        this.lexer = new Lexer(r4, new ExtendedBufferedReader(r3));
        this.csvRecordIterator = new CSVRecordIterator(this);
        Headers r6 = createHeaders();
        this.headerMap = r6.headerMap;
        this.headerNames = r6.headerNames;
        this.characterOffset = r5;
        this.recordNumber = r7 - 1;
    }

    private void addRecordValue(boolean r3) {
        String r0 = this.reusableToken.content.toString();
        if (this.format.getTrim() == false) goto L5;
        r0 = r0.trim();
    L5:
        if (r3 == true) goto L7;
    L11:
        String r4 = this.format.getNullString();
        List<String> r2 = this.recordList;
        if (r0.equals(r4) == false) goto L14;
        r0 = null;
    L14:
        r2.add(r0);
        return;
    L7:
        if (r0.isEmpty() == false) goto L11;
        if (this.format.getTrailingDelimiter() == false) goto L11;
    }

    private Map<String, Integer> createEmptyHeaderMap() {
        if (this.format.getIgnoreHeaderCase() == false) goto L6;
        return new TreeMap(String.CASE_INSENSITIVE_ORDER);
    L6:
        return new LinkedHashMap();
    }

    private Headers createHeaders() {
        String[] r0 = this.format.getHeader();
        ArrayList r1 = null;
        if (r0 == null) goto L48;
        Map<String, Integer> r2 = createEmptyHeaderMap();
        if (r0.length != 0) goto L11;
        CSVRecord r3 = nextRecord();
        if (r3 == null) goto L9;
        r0 = r3.values();
    L13:
        if (r0 == null) goto L49;
        int r4 = 0;
    L16:
        if (r4 >= r0.length) goto L49;
        String r5 = r0[r4];
        if (r5 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == true) goto L26;
    L30:
        if (r5 != null) goto L32;
    L34:
        boolean r8 = false;
    L35:
        if (r8 == false) goto L42;
        if (r7 == true) goto L42;
        if (this.format.getAllowDuplicateHeaderNames() == true) goto L42;
        throw new IllegalArgumentException(String.format("The header contains a duplicate name: \"%s\" in %s. If this is valid then use CSVFormat.withAllowDuplicateHeaderNames().", new Object[]{r5, Arrays.toString(r0)}));
    L42:
        if (r5 == null) goto L47;
        r2.put(r5, Integer.valueOf(r4));
        if (r1 != null) goto L46;
        r1 = new ArrayList(r0.length);
    L46:
        r1.add(r5);
    L47:
        r4 = r4 + 1;
        goto L16
    L32:
        if (r2.containsKey(r5) == false) goto L34;
        r8 = true;
        goto L35
    L26:
        if (this.format.getAllowMissingColumnNames() == true) goto L30;
        throw new IllegalArgumentException("A header name is missing in " + Arrays.toString(r0));
    L20:
        if (r5.trim().isEmpty() == true) goto L23;
        r7 = false;
    L49:
        if (r1 != null) goto L51;
        List r9 = Collections.emptyList();
    L53:
        return new Headers(r2, r9);
    L51:
        r9 = Collections.unmodifiableList(r1);
        goto L53
    L9:
        r0 = null;
        goto L13
    L11:
        if (this.format.getSkipHeaderRecord() == false) goto L13;
        nextRecord();
        goto L13
    L48:
        r2 = null;
        goto L49
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Lexer r0 = this.lexer;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    public long getCurrentLineNumber() {
        return this.lexer.getCurrentLineNumber();
    }

    Map<String, Integer> getHeaderMapRaw() {
        return this.headerMap;
    }

    public boolean isClosed() {
        return this.lexer.isClosed();
    }

    @Override // java.lang.Iterable
    public Iterator<CSVRecord> iterator() {
        return this.csvRecordIterator;
    }

    CSVRecord nextRecord() {
        this.recordList.clear();
        long r10 = this.lexer.getCharacterPosition() + this.characterOffset;
        String r0 = null;
        StringBuilder r1 = null;
    L3:
        this.reusableToken.reset();
        this.lexer.nextToken(this.reusableToken);
        int r2 = AnonymousClass1.$SwitchMap$org$apache$commons$csv$Token$Type[this.reusableToken.type.ordinal()];
        if (r2 != 1) goto L6;
        addRecordValue(false);
    L26:
        if (this.reusableToken.type == Token.Type.TOKEN) goto L3;
        if (this.recordList.isEmpty() == true) goto L39;
        this.recordNumber++;
        if (r1 == null) goto L33;
        r0 = r1.toString();
    L33:
        List<String> r3 = this.recordList;
        return new CSVRecord(this, (String[]) ZeusTransformUtils.preCheckCast(r3.toArray(new String[r3.size()]), String[].class, "com.obric.memorydata.plugin"), r0, this.recordNumber, r10);
    L39:
        return null;
    L6:
        if (r2 != 2) goto L8;
    L23:
        addRecordValue(true);
        goto L26
    L8:
        if (r2 == 3) goto L22;
        if (r2 == 4) goto L20;
        if (r2 != 5) goto L18;
        if (r1 != null) goto L15;
        r1 = new StringBuilder();
    L16:
        r1.append(this.reusableToken.content);
        this.reusableToken.type = Token.Type.TOKEN;
        goto L26
    L15:
        r1.append('\n');
        goto L16
    L18:
        throw new IllegalStateException("Unexpected Token type: " + this.reusableToken.type);
    L20:
        throw new IOException("(line " + getCurrentLineNumber() + ") invalid parse sequence");
    L22:
        if (this.reusableToken.isReady == false) goto L26;
        goto L23
    }
}
