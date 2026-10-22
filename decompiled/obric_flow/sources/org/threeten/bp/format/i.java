package org.threeten.bp.format;

import com.bytedance.keva.KevaImpl;
import kotlin.time.DurationKt;
import okhttp3.internal.http2.Http2Connection;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements g {
    @Override // org.threeten.bp.format.g
    public final int parse(u r22, CharSequence r23, int r24) {
        u r5 = new u(r22);
        s r10 = new s();
        r10.a(b.f);
        r10.c('T');
        ChronoField r11 = ChronoField.HOUR_OF_DAY;
        r10.l(r11, 2);
        r10.c(':');
        ChronoField r12 = ChronoField.MINUTE_OF_HOUR;
        r10.l(r12, 2);
        r10.c(':');
        ChronoField r13 = ChronoField.SECOND_OF_MINUTE;
        r10.l(r13, 2);
        ChronoField r14 = ChronoField.NANO_OF_SECOND;
        int r15 = 0;
        r10.b(new h(r14, 0, 9, true));
        r10.c('Z');
        f r16 = r10.p().f21204a;
        if (r16.f21213b == false) goto L6;
        r16 = new f(r16.f21212a, false);
    L6:
        int r17 = r16.parse(r5, r23, r24);
        if (r17 >= 0) goto L9;
        return r17;
    L9:
        long r18 = r5.c(ChronoField.YEAR).longValue();
        int r19 = r5.c(ChronoField.MONTH_OF_YEAR).intValue();
        int r110 = r5.c(ChronoField.DAY_OF_MONTH).intValue();
        int r20 = r5.c(r11).intValue();
        int r21 = r5.c(r12).intValue();
        Long r25 = r5.c(r13);
        Long r26 = r5.c(r14);
        if (r25 == null) goto L12;
        int r27 = r25.intValue();
    L13:
        if (r26 == null) goto L15;
        int r28 = r26.intValue();
    L16:
        int r111 = ((int) r18) % KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        if (r20 != 24) goto L23;
        if (r21 != 0) goto L23;
        if (r27 != 0) goto L23;
        if (r28 != 0) goto L23;
        int r112 = r27;
        int r113 = 0;
        r15 = 1;
    L36:
        return r22.e(r14, r28, r24, r22.e(ChronoField.INSTANT_SECONDS, jm.c.u(r18 / 10000, 315569520000L) + LocalDateTime.of(r111, r19, r110, r113, r21, r112, 0).plusDays(r15).toEpochSecond(ZoneOffset.UTC), r24, r17));
    L35:
        return ~r24;
    L23:
        if (r20 == 23) goto L25;
    L29:
        r113 = r20;
        r112 = r27;
        goto L36
    L25:
        if (r21 != 59) goto L29;
        if (r27 != 60) goto L29;
        r22.b().d = true;
        r112 = 59;
        r113 = r20;
        goto L36
    L15:
        r28 = 0;
        goto L16
    L12:
        r27 = 0;
        goto L13
    }

    @Override // org.threeten.bp.format.g
    public final boolean print(w r19, StringBuilder r20) {
        Long r5 = r19.a(ChronoField.INSTANT_SECONDS);
        Long r10 = 0L;
        ChronoField r11 = ChronoField.NANO_OF_SECOND;
        org.threeten.bp.temporal.d r12 = r19.f21256a;
        if (r12.isSupported(r11) == false) goto L6;
        r10 = Long.valueOf(r12.getLong(r11));
    L6:
        if (r5 != null) goto L8;
        return false;
    L8:
        long r13 = r5.longValue();
        int r14 = r11.checkValidIntValue(r10.longValue());
        if (r13 < (-62167219200L)) goto L16;
        long r15 = r13 - 253402300800L;
        long r16 = jm.c.l(r15, 315569520000L) + 1;
        LocalDateTime r17 = LocalDateTime.ofEpochSecond(jm.c.o(r15, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
        if (r16 <= 0) goto L13;
        r20.append('+');
        r20.append(r16);
    L13:
        r20.append(r17);
        if (r17.getSecond() != 0) goto L28;
        r20.append(":00");
    L28:
        if (r14 == 0) goto L36;
        r20.append('.');
        if ((r14 % DurationKt.NANOS_IN_MILLIS) != 0) goto L33;
        r20.append(Integer.toString((r14 / DurationKt.NANOS_IN_MILLIS) + 1000).substring(1));
        goto L36
    L33:
        if ((r14 % 1000) != 0) goto L35;
        r20.append(Integer.toString((r14 / 1000) + DurationKt.NANOS_IN_MILLIS).substring(1));
        goto L36
    L35:
        r20.append(Integer.toString(r14 + Http2Connection.DEGRADED_PONG_TIMEOUT_NS).substring(1));
    L36:
        r20.append('Z');
        return true;
    L16:
        long r18 = r13 + 62167219200L;
        long r21 = r18 / 315569520000L;
        long r22 = r18 % 315569520000L;
        LocalDateTime r23 = LocalDateTime.ofEpochSecond(r22 - 62167219200L, 0, ZoneOffset.UTC);
        int r24 = r20.length();
        r20.append(r23);
        if (r23.getSecond() != 0) goto L20;
        r20.append(":00");
    L20:
        if (r21 >= 0) goto L28;
        if (r23.getYear() != (-10000)) goto L25;
        r20.replace(r24, r24 + 2, Long.toString(r21 - 1));
        goto L28
    L25:
        if (r22 != 0) goto L27;
        r20.insert(r24, r21);
        goto L28
    L27:
        r20.insert(r24 + 1, Math.abs(r21));
        goto L28
    }

    public final String toString() {
        return "Instant()";
    }
}
