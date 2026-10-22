package org.apache.commons.csv;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes6.dex */
public final class CSVPrinter implements Closeable, Flushable {
    private final CSVFormat format;
    private boolean newRecord;
    private final Appendable out;

    public CSVPrinter(Appendable r5, CSVFormat r6) {
        Appendable r7 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r5, Appendable.class, "com.obric.memorydata.plugin");
        this.newRecord = true;
        Assertions.notNull(r7, "out");
        Assertions.notNull(r6, "format");
        this.out = r7;
        this.format = r6;
        if (r6.getHeaderComments() == null) goto L11;
        String[] r8 = r6.getHeaderComments();
        int r0 = r8.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L11;
        String r3 = r8[r2];
        if (r3 == null) goto L9;
        printComment(r3);
    L9:
        r2 = r2 + 1;
    L11:
        if (r6.getHeader() != null) goto L13;
        return;
    L13:
        if (r6.getSkipHeaderRecord() == true) goto L20;
        printRecord((Object[]) ZeusTransformUtils.preCheckCast(r6.getHeader(), Object[].class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close(false);
    }

    public void close(boolean r2) {
        if (r2 == false) goto L4;
    L5:
        flush();
    L7:
        if (ZeusTransformUtils.instanceOf(this.out, Closeable.class) == false) goto L10;
        ((Closeable) ZeusTransformUtils.preCheckCast(this.out, Closeable.class, "com.obric.memorydata.plugin")).close();
        return;
    L10:
        return;
    L4:
        if (this.format.getAutoFlush() == false) goto L7;
        goto L5
    }

    @Override // java.io.Flushable
    public void flush() {
        if (ZeusTransformUtils.instanceOf(this.out, Flushable.class) == false) goto L6;
        ((Flushable) ZeusTransformUtils.preCheckCast(this.out, Flushable.class, "com.obric.memorydata.plugin")).flush();
        return;
    }

    public void printComment(String r6) {
        if (this.format.isCommentMarkerSet() == true) goto L6;
        return;
    L6:
        if (this.newRecord == true) goto L8;
        println();
    L8:
        this.out.append(this.format.getCommentMarker().charValue());
        this.out.append(' ');
        int r0 = 0;
    L10:
        if (r0 >= r6.length()) goto L23;
        char r2 = r6.charAt(r0);
        if (r2 != '\n') goto L14;
    L21:
        println();
        this.out.append(this.format.getCommentMarker().charValue());
        this.out.append(' ');
    L22:
        r0 = r0 + 1;
        goto L10
    L14:
        if (r2 == '\r') goto L16;
        this.out.append(r2);
        goto L22
    L16:
        int r3 = r0 + 1;
        if (r3 >= r6.length()) goto L21;
        if (r6.charAt(r3) != '\n') goto L21;
        r0 = r3;
        goto L21
    L23:
        println();
    }

    public void printRecord(Object... r3) {
        this.format.printRecord(this.out, r3);
        this.newRecord = true;
    }

    public void println() {
        this.format.println(this.out);
        this.newRecord = true;
    }
}
