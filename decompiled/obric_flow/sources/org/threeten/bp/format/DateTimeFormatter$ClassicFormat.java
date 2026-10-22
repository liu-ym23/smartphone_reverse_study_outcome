package org.threeten.bp.format;

import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.event.MessageIndication;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;

/* JADX INFO: loaded from: classes3.dex */
class DateTimeFormatter$ClassicFormat extends Format {
    private final b formatter;
    private final org.threeten.bp.temporal.i query;

    public DateTimeFormatter$ClassicFormat(b r5, org.threeten.bp.temporal.i r10) {
        this.formatter = r5;
        this.query = r10;
    }

    @Override // java.text.Format
    public StringBuffer format(Object r5, StringBuffer r10, FieldPosition r11) {
        jm.c.p(r5, "obj");
        jm.c.p(r10, "toAppendTo");
        jm.c.p(r11, OpenPageMethod.KEY_POS);
        if ((r5 instanceof org.threeten.bp.temporal.d) == false) goto L11;
        r11.setBeginIndex(0);
        r11.setEndIndex(0);
        this.formatter.b((org.threeten.bp.temporal.d) r5, r10);     // Catch: RuntimeException -> L7
        return r10;
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage(), e);
    L11:
        throw new IllegalArgumentException("Format target must implement TemporalAccessor");
    }

    @Override // java.text.Format
    public Object parseObject(String r5) throws ParseException {
        jm.c.p(r5, MessageIndication.CONTENT_TYPE_TEXT);
        org.threeten.bp.temporal.i r10 = this.query;     // Catch: RuntimeException -> L7 DateTimeParseException -> L9
        if (r10 != null) goto L12;
        b r11 = this.formatter;     // Catch: RuntimeException -> L7 DateTimeParseException -> L9
        b r12 = b.f;     // Catch: RuntimeException -> L7 DateTimeParseException -> L9
        a r13 = r11.d(r5);     // Catch: RuntimeException -> L7 DateTimeParseException -> L9
        r13.i(this.formatter.d);     // Catch: RuntimeException -> L7 DateTimeParseException -> L9
        return r13;
    L12:
        return this.formatter.c(r5, r10);
    L9:
        e = move-exception;
        throw new ParseException(e.getMessage(), e.getErrorIndex());
    L7:
        e = move-exception;
        throw ((ParseException) new ParseException(e.getMessage(), 0).initCause(e));
    }

    @Override // java.text.Format
    public Object parseObject(String r5, ParsePosition r10) {
        jm.c.p(r5, MessageIndication.CONTENT_TYPE_TEXT);
        b r11 = this.formatter;     // Catch: IndexOutOfBoundsException -> L16
        b r12 = b.f;     // Catch: IndexOutOfBoundsException -> L16
        t r13 = r11.e(r5, r10);     // Catch: IndexOutOfBoundsException -> L16
        if (r13 == null) goto L6;
        a r14 = r13.a();     // Catch: RuntimeException -> L14
        r14.i(this.formatter.d);     // Catch: RuntimeException -> L14
        org.threeten.bp.temporal.i r15 = this.query;     // Catch: RuntimeException -> L14
        if (r15 != null) goto L12;
        return r14;
    L12:
        return r15.d(r14);
    L14:
        r10.setErrorIndex(0);
        return null;
    L6:
        if (r10.getErrorIndex() >= 0) goto L8;
        r10.setErrorIndex(0);
    L8:
        return null;
    L17:
        if (r10.getErrorIndex() >= 0) goto L19;
        r10.setErrorIndex(0);
    L19:
        return null;
    }
}
