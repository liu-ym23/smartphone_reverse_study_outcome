package org.apache.commons.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final enum StandardLineSeparator extends Enum<StandardLineSeparator> {
    private static final /* synthetic */ StandardLineSeparator[] $VALUES = null;
    public static final StandardLineSeparator CR = null;
    public static final StandardLineSeparator CRLF = null;
    public static final StandardLineSeparator LF = null;
    private final String lineSeparator;

    static {
        StandardLineSeparator r0 = new StandardLineSeparator("CR", 0, "\r");
        CR = r0;
        StandardLineSeparator r1 = new StandardLineSeparator("CRLF", 1, "\r\n");
        CRLF = r1;
        StandardLineSeparator r3 = new StandardLineSeparator("LF", 2, "\n");
        LF = r3;
        $VALUES = new StandardLineSeparator[]{r0, r1, r3};
    }

    private StandardLineSeparator(String r1, int r2, String r3) {
        super(r1, r2);
        this.lineSeparator = (String) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r3, "lineSeparator"), String.class, "com.obric.memorydata.plugin");
    }

    public static StandardLineSeparator valueOf(String r2) {
        return (StandardLineSeparator) ZeusTransformUtils.preCheckCast(Enum.valueOf(StandardLineSeparator.class, r2), StandardLineSeparator.class, "com.obric.memorydata.plugin");
    }

    public static StandardLineSeparator[] values() {
        return (StandardLineSeparator[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StandardLineSeparator[].class, "com.obric.memorydata.plugin");
    }

    public byte[] getBytes(Charset r1) {
        return this.lineSeparator.getBytes(r1);
    }

    public String getString() {
        return this.lineSeparator;
    }
}
