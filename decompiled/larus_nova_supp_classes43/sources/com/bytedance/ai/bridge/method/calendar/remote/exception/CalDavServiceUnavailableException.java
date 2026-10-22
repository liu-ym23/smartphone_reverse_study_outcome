package com.bytedance.ai.bridge.method.calendar.remote.exception;

import com.bytedance.ai.utils.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import org.apache.commons.lang3.time.DateUtils;
import q3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/remote/exception/CalDavServiceUnavailableException;", "Lcom/bytedance/ai/bridge/method/calendar/remote/exception/CalDavHttpException;", a.KEY_MSG, "", "<init>", "(Ljava/lang/String;)V", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "retryAfter", "Ljava/util/Date;", "getRetryAfter", "()Ljava/util/Date;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalDavServiceUnavailableException extends CalDavHttpException {
    private final Date retryAfter;

    public final Date getRetryAfter() {
        return this.retryAfter;
    }

    public CalDavServiceUnavailableException(Response r21) {
        Intrinsics.checkNotNullParameter(r21, "response");
        super(r21);
        String r0 = r21.header("Retry-After");
        Date r10 = null;
        if (r0 == null) goto L13;
        int r11 = b.a;
        Intrinsics.checkNotNullParameter(r0, "dateStr");
        Date r12 = DateUtils.parseDate(r0, Locale.ROOT, new String[]{"EEE, dd MMM yyyy HH:mm:ss 'GMT'", "EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"});     // Catch: ParseException -> L7
    L8:
        if (r12 == null) goto L15;
        r10 = r12;
        goto L13
    L15:
        int r13 = CastIntegerProtector.parseInt(r0);     // Catch: NumberFormatException -> L11
        Calendar r14 = Calendar.getInstance();     // Catch: NumberFormatException -> L11
        r14.add(13, r13);     // Catch: NumberFormatException -> L11
        r10 = r14.getTime();     // Catch: NumberFormatException -> L11
    L11:
        g.a.w("CalDavClient", "Received Retry-After which was not a HTTP-date nor delta-seconds: ".concat(r0));
    L7:
        g.a.w("CalDavClient", "Couldn't parse date: " + r0 + ", ignoring");
        r12 = null;
    L13:
        this.retryAfter = r10;
    }

    public CalDavServiceUnavailableException(String r10) {
        super(503, r10);
        this.retryAfter = null;
    }
}
