package kc;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10161a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f10162b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final DateFormat[] f10163c = null;

    public static final class a extends ThreadLocal<DateFormat> {
        a() {
        }

        protected DateFormat a() {
            SimpleDateFormat r10 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            r10.setLenient(false);
            r10.setTimeZone(hc.e.f9281e);
            return r10;
        }

        @Override // java.lang.ThreadLocal
        public /* bridge */ /* synthetic */ DateFormat initialValue() {
            return a();
        }
    }

    static {
        f10161a = new a();
        String[] r10 = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f10162b = r10;
        f10163c = new DateFormat[r10.length];
    }

    public static final Date a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() != 0) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L9;
        return null;
    L9:
        ParsePosition r12 = new ParsePosition(0);
        Date r13 = f10161a.get().parse(r10, r12);
        if (r12.getIndex() != r10.length()) goto L12;
        return r13;
    L12:
        String[] r14 = f10162b;
        monitor-enter(r14);
        int r15 = r14.length;     // Catch: Throwable -> L27
        int r16 = 0;
    L15:
        if (r16 >= r15) goto L24;
        DateFormat[] r17 = f10163c;     // Catch: Throwable -> L27
        DateFormat r18 = r17[r16];     // Catch: Throwable -> L27
        DateFormat r19 = r18;
        if (r18 != null) goto L19;
        SimpleDateFormat r20 = new SimpleDateFormat(f10162b[r16], Locale.US);     // Catch: Throwable -> L27
        r20.setTimeZone(hc.e.f9281e);     // Catch: Throwable -> L27
        r17[r16] = r20;     // Catch: Throwable -> L27
        r19 = r20;
    L19:
        r12.setIndex(0);     // Catch: Throwable -> L27
        Date r21 = r19.parse(r10, r12);     // Catch: Throwable -> L27
        if (r12.getIndex() != 0) goto L21;
        r16 = r16 + 1;
        goto L15
    L21:
        monitor-exit(r14);
        return r21;
    L24:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r14);
        return null;
    L27:
        th = move-exception;
        throw th;
    L5:
        r11 = false;
        goto L7
    }

    public static final String b(Date r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = f10161a.get().format(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "STANDARD_DATE_FORMAT.get().format(this)");
        return r11;
    }
}
