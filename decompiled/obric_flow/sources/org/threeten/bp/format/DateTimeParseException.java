package org.threeten.bp.format;

import org.threeten.bp.DateTimeException;

/* JADX INFO: loaded from: classes3.dex */
public class DateTimeParseException extends DateTimeException {
    private static final long serialVersionUID = 4304633501674722597L;
    private final int errorIndex;
    private final String parsedString;

    public DateTimeParseException(String r5, CharSequence r10, int r11) {
        super(r5);
        this.parsedString = r10.toString();
        this.errorIndex = r11;
    }

    public int getErrorIndex() {
        return this.errorIndex;
    }

    public String getParsedString() {
        return this.parsedString;
    }

    public DateTimeParseException(String r5, CharSequence r10, int r11, Throwable r12) {
        super(r5, r12);
        this.parsedString = r10.toString();
        this.errorIndex = r11;
    }
}
