package com.bytedance.ai.bridge.method.calendar.remote.exception;

import com.bytedance.ai.utils.c;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.s0;
import t0.d;
import td.e;
import x1.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/remote/exception/CalDavServiceUnavailableException;", "Lcom/bytedance/ai/bridge/method/calendar/remote/exception/CalDavHttpException;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CalDavServiceUnavailableException extends CalDavHttpException {
    public CalDavServiceUnavailableException(s0 r22) {
        Intrinsics.checkNotNullParameter(r22, "response");
        super(r22);
        r22.getClass();
        Date r5 = null;
        String r10 = r22.d("Retry-After", null);
        if (r10 == null) goto L21;
        int r11 = a.f22943a;
        Intrinsics.checkNotNullParameter(r10, "dateStr");
        r5 = e.e(r10, Locale.ROOT, new String[]{"EEE, dd MMM yyyy HH:mm:ss 'GMT'", "EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"});     // Catch: ParseException -> L7
    L10:
        if (r5 != null) goto L22;
        int r12 = Integer.parseInt(r10);     // Catch: NumberFormatException -> L13
        Calendar r13 = Calendar.getInstance();     // Catch: NumberFormatException -> L13
        r13.add(13, r12);     // Catch: NumberFormatException -> L13
        r13.getTime();     // Catch: NumberFormatException -> L13
        return;
    L13:
        String r14 = "Received Retry-After which was not a HTTP-date nor delta-seconds: ".concat(r10);
        Intrinsics.checkNotNullParameter("CalDavClient", "tag");
        d r15 = c.f2846a;
        if (r15 == null) goto L23;
        r15.w("CalDavClient", r14);
        return;
    L23:
        return;
    L22:
        return;
    L7:
        String r16 = androidx.room.jarjarred.org.antlr.runtime.a.r("Couldn't parse date: ", r10, ", ignoring", "CalDavClient", "tag");
        d r17 = c.f2846a;
        if (r17 == null) goto L10;
        r17.w("CalDavClient", r16);
        goto L10
    }
}
