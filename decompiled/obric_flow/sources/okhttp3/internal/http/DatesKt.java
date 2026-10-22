package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\n\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u0005H\u0000\u001a\f\u0010\u000e\u001a\u00020\u0005*\u00020\rH\u0000\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u000f"}, d2 = {"BROWSER_COMPATIBLE_DATE_FORMATS", "", "Ljava/text/DateFormat;", "[Ljava/text/DateFormat;", "BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS", "", "[Ljava/lang/String;", "MAX_DATE", "", "STANDARD_DATE_FORMAT", "okhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1", "Lokhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1;", "toHttpDateOrNull", "Ljava/util/Date;", "toHttpDateString", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class DatesKt {
    private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS = null;
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = null;
    public static final long MAX_DATE = 253402300799999L;
    private static final DatesKt$STANDARD_DATE_FORMAT$1 STANDARD_DATE_FORMAT = null;

    /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http.DatesKt$STANDARD_DATE_FORMAT$1] */
    static {
        STANDARD_DATE_FORMAT = new DatesKt$STANDARD_DATE_FORMAT$1();
        String[] r5 = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = r5;
        BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[r5.length];
    }

    public static final Date toHttpDateOrNull(String r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toHttpDateOrNull");
        if (r10.length() != 0) goto L5;
        return null;
    L5:
        ParsePosition r5 = new ParsePosition(0);
        Date r11 = STANDARD_DATE_FORMAT.get().parse(r10, r5);
        if (r5.getIndex() != r10.length()) goto L8;
        return r11;
    L8:
        String[] r12 = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        monitor-enter(r12);
        int r13 = r12.length;     // Catch: Throwable -> L15
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L22;
        DateFormat[] r15 = BROWSER_COMPATIBLE_DATE_FORMATS;     // Catch: Throwable -> L15
        DateFormat r16 = r15[r14];     // Catch: Throwable -> L15
        if (r16 != null) goto L17;
        r16 = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[r14], Locale.US);     // Catch: Throwable -> L15
        r16.setTimeZone(Util.UTC);     // Catch: Throwable -> L15
        r15[r14] = r16;     // Catch: Throwable -> L15
    L17:
        r5.setIndex(0);     // Catch: Throwable -> L15
        Date r17 = r16.parse(r10, r5);     // Catch: Throwable -> L15
        if (r5.getIndex() != 0) goto L19;
        r14 = r14 + 1;
        goto L11
    L19:
        monitor-exit(r12);
        return r17;
    L22:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r12);
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public static final String toHttpDateString(Date r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toHttpDateString");
        return STANDARD_DATE_FORMAT.get().format(r5);
    }
}
