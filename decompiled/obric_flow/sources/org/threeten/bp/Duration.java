package org.threeten.bp;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.writer.DaoWriter;
import com.bytedance.ai.event.MessageIndication;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.time.DurationKt;
import okhttp3.internal.http2.Http2Connection;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes3.dex */
public final class Duration implements org.threeten.bp.temporal.f, Comparable<Duration>, Serializable {
    public static final Duration ZERO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f21119a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f21120b = null;
    private static final long serialVersionUID = 3078945930695997490L;
    private final int nanos;
    private final long seconds;

    static {
        ZERO = new Duration(0, 0);
        f21119a = BigInteger.valueOf(1000000000);
        f21120b = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    public Duration(int r5, long r10) {
        this.seconds = r10;
        this.nanos = r5;
    }

    public static Duration a(int r5, long r10) {
        if ((((long) r5) | r10) != 0) goto L7;
        return ZERO;
    L7:
        return new Duration(r5, r10);
    }

    public static Duration b(BigDecimal r5) {
        BigInteger r10 = r5.movePointRight(9).toBigIntegerExact();
        BigInteger[] r11 = r10.divideAndRemainder(f21119a);
        if (r11[0].bitLength() > 63) goto L7;
        return ofSeconds(r11[0].longValue(), r11[1].intValue());
    L7:
        throw new ArithmeticException("Exceeds capacity of Duration: " + r10);
    }

    public static Duration between(org.threeten.bp.temporal.c r14, org.threeten.bp.temporal.c r15) {
        ChronoUnit r5 = ChronoUnit.SECONDS;
        long r10 = r14.until(r15, r5);
        ChronoField r11 = ChronoField.NANO_OF_SECOND;
        long r12 = 0;
        if (r14.isSupported(r11) == false) goto L23;
        if (r15.isSupported(r11) == false) goto L23;
        long r13 = r14.getLong(r11);     // Catch: Throwable -> L25
        long r16 = r15.getLong(r11) - r13;
        if (r10 > 0) goto L10;
    L13:
        if (r10 < 0) goto L15;
    L17:
        if (r10 == 0) goto L19;
    L12:
        r12 = r16;
        goto L23
    L19:
        if (r16 == 0) goto L12;
        r10 = r14.until(r15.with(r11, r13), r5);     // Catch: Throwable -> L24
        goto L12
    L15:
        if (r16 <= 0) goto L17;
        r16 = r16 - 1000000000;
        goto L12
    L10:
        if (r16 >= 0) goto L13;
        r16 = r16 + 1000000000;
    L23:
        return ofSeconds(r10, r12);
    }

    public static long c(CharSequence r5, String r10, int r11, String r12) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.String r0 = "Text cannot be parsed to a Duration: "
            if (r5 != 0) goto L7
            r4 = 0
            return r4
        L7:
            r1 = 0
            java.lang.String r2 = "+"
            boolean r2 = r5.startsWith(r2)     // Catch: java.lang.ArithmeticException -> L16 java.lang.NumberFormatException -> L18
            if (r2 == 0) goto L1a
            r2 = 1
            java.lang.String r5 = r5.substring(r2)     // Catch: java.lang.ArithmeticException -> L16 java.lang.NumberFormatException -> L18
            goto L1a
        L16:
            r5 = move-exception
            goto L23
        L18:
            r5 = move-exception
            goto L33
        L1a:
            long r2 = java.lang.Long.parseLong(r5)     // Catch: java.lang.ArithmeticException -> L16 java.lang.NumberFormatException -> L18
            long r4 = jm.c.t(r6, r2)     // Catch: java.lang.ArithmeticException -> L16 java.lang.NumberFormatException -> L18
            return r4
        L23:
            org.threeten.bp.format.DateTimeParseException r6 = new org.threeten.bp.format.DateTimeParseException
            java.lang.String r7 = r0.concat(r7)
            r6.<init>(r7, r4, r1)
            java.lang.Throwable r4 = r6.initCause(r5)
            org.threeten.bp.format.DateTimeParseException r4 = (org.threeten.bp.format.DateTimeParseException) r4
            throw r4
        L33:
            org.threeten.bp.format.DateTimeParseException r6 = new org.threeten.bp.format.DateTimeParseException
            java.lang.String r7 = r0.concat(r7)
            r6.<init>(r7, r4, r1)
            java.lang.Throwable r4 = r6.initCause(r5)
            org.threeten.bp.format.DateTimeParseException r4 = (org.threeten.bp.format.DateTimeParseException) r4
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Duration.c(java.lang.CharSequence, java.lang.String, int, java.lang.String):long");
    }

    public static Duration from(org.threeten.bp.temporal.f r5) {
        jm.c.p(r5, "amount");
        Duration r10 = ZERO;
        Iterator r11 = r5.getUnits().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        org.threeten.bp.temporal.j r12 = (org.threeten.bp.temporal.j) r11.next();
        r10 = r10.plus(r5.get(r12), r12);
        goto L4
    L6:
        return r10;
    }

    public static Duration of(long r5, org.threeten.bp.temporal.j r10) {
        return ZERO.plus(r5, r10);
    }

    public static Duration ofDays(long r5) {
        return a(0, jm.c.t(86400, r5));
    }

    public static Duration ofHours(long r5) {
        return a(0, jm.c.t(3600, r5));
    }

    public static Duration ofMillis(long r5) {
        long r10 = r5 / 1000;
        int r11 = (int) (r5 % 1000);
        if (r11 >= 0) goto L6;
        r11 = r11 + 1000;
        r10 = r10 - 1;
    L6:
        return a(r11 * DurationKt.NANOS_IN_MILLIS, r10);
    }

    public static Duration ofMinutes(long r5) {
        return a(0, jm.c.t(60, r5));
    }

    public static Duration ofNanos(long r5) {
        long r10 = r5 / 1000000000;
        int r11 = (int) (r5 % 1000000000);
        if (r11 >= 0) goto L6;
        r11 = r11 + Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
        r10 = r10 - 1;
    L6:
        return a(r11, r10);
    }

    public static Duration ofSeconds(long r5) {
        return a(0, r5);
    }

    public static Duration parse(CharSequence r15) {
        jm.c.p(r15, MessageIndication.CONTENT_TYPE_TEXT);
        Matcher r5 = f21120b.matcher(r15);
        if (r5.matches() == false) goto L41;
        if (ExifInterface.GPS_DIRECTION_TRUE.equals(r5.group(3)) == true) goto L41;
        int r10 = 1;
        boolean r11 = DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD.equals(r5.group(1));
        String r12 = r5.group(2);
        String r13 = r5.group(4);
        String r14 = r5.group(5);
        String r16 = r5.group(6);
        String r17 = r5.group(7);
        if (r12 != null) goto L11;
        if (r13 != null) goto L11;
        if (r14 != null) goto L11;
        if (r16 == null) goto L41;
    L11:
        long r18 = c(r15, r12, 86400, "days");
        long r19 = c(r15, r13, 3600, "hours");
        long r110 = c(r15, r14, 60, "minutes");
        long r111 = c(r15, r16, 1, "seconds");
        if (r16 == null) goto L17;
        if (r16.charAt(0) != '-') goto L17;
        r10 = -1;
    L17:
        if (r17 != null) goto L19;
    L31:
        int r20 = 0;
    L42:
        long r21 = jm.c.r(r18, jm.c.r(r19, jm.c.r(r110, r111)));     // Catch: ArithmeticException -> L37
        if (r11 == false) goto L36;
        return ofSeconds(r21, r20).negated();
    L36:
        return ofSeconds(r21, r20);
    L37:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: overflow", r15, 0).initCause(e));
    L19:
        if (r17.length() == 0) goto L31;
        r20 = Integer.parseInt(r17.concat("000000000").substring(0, 9)) * r10;
        goto L42
    L23:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", r15, 0).initCause(e));
    L25:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", r15, 0).initCause(e));
    L41:
        throw new DateTimeParseException("Text cannot be parsed to a Duration", r15, 0);
    }

    public static Duration readExternal(DataInput r5) throws IOException {
        return ofSeconds(r5.readLong(), r5.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public Duration abs() {
        if (isNegative() == true) goto L5;
        return this;
    L5:
        return negated();
    }

    @Override // org.threeten.bp.temporal.f
    public org.threeten.bp.temporal.c addTo(org.threeten.bp.temporal.c r5) {
        long r10 = this.seconds;
        if (r10 == 0) goto L5;
        r5 = r5.plus(r10, ChronoUnit.SECONDS);
    L5:
        int r11 = this.nanos;
        if (r11 != 0) goto L8;
        return r5;
    L8:
        return r5.plus(r11, ChronoUnit.NANOS);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration r5) {
        return compareTo2(r5);
    }

    public final Duration d(long r5, long r10) {
        if ((r5 | r10) != 0) goto L6;
        return this;
    L6:
        return ofSeconds(jm.c.r(jm.c.r(this.seconds, r5), r10 / 1000000000), this.nanos + (r10 % 1000000000));
    }

    public Duration dividedBy(long r5) {
        if (r5 == 0) goto L10;
        if (r5 != 1) goto L8;
        return this;
    L8:
        return b(BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf(this.nanos, 9)).divide(BigDecimal.valueOf(r5), RoundingMode.DOWN));
    L10:
        throw new ArithmeticException("Cannot divide by zero");
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Duration) == false) goto L14;
        Duration r11 = (Duration) r10;
        if (this.seconds != r11.seconds) goto L13;
        if (this.nanos != r11.nanos) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // org.threeten.bp.temporal.f
    public long get(org.threeten.bp.temporal.j r5) {
        if (r5 != ChronoUnit.SECONDS) goto L7;
        return this.seconds;
    L7:
        if (r5 != ChronoUnit.NANOS) goto L11;
        return this.nanos;
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r5);
    }

    public int getNano() {
        return this.nanos;
    }

    public long getSeconds() {
        return this.seconds;
    }

    @Override // org.threeten.bp.temporal.f
    public List<org.threeten.bp.temporal.j> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new ChronoUnit[]{ChronoUnit.SECONDS, ChronoUnit.NANOS}));
    }

    public int hashCode() {
        long r5 = this.seconds;
        int r10 = this.nanos * 51;
        return r10 + ((int) (r5 ^ (r5 >>> 32)));
    }

    public boolean isNegative() {
        if (this.seconds >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isZero() {
        if ((this.seconds | ((long) this.nanos)) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Duration minus(Duration r5) {
        long r10 = r5.getSeconds();
        int r11 = r5.getNano();
        if (r10 != Long.MIN_VALUE) goto L7;
        return d(Long.MAX_VALUE, -r11).d(1, 0);
    L7:
        return d(-r10, -r11);
    }

    public Duration minusDays(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        Duration this = plusDays(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusDays(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public Duration minusHours(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        Duration this = plusHours(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusHours(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public Duration minusMillis(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        Duration this = plusMillis(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusMillis(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public Duration minusMinutes(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        Duration this = plusMinutes(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusMinutes(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public Duration minusNanos(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        Duration this = plusNanos(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusNanos(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public Duration minusSeconds(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        Duration this = plusSeconds(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusSeconds(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public Duration multipliedBy(long r5) {
        if (r5 != 0) goto L7;
        return ZERO;
    L7:
        if (r5 != 1) goto L10;
        return this;
    L10:
        return b(BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf(this.nanos, 9)).multiply(BigDecimal.valueOf(r5)));
    }

    public Duration negated() {
        return multipliedBy(-1);
    }

    public Duration plus(Duration r5) {
        return d(r5.getSeconds(), r5.getNano());
    }

    public Duration plusDays(long r5) {
        return d(jm.c.t(86400, r5), 0);
    }

    public Duration plusHours(long r5) {
        return d(jm.c.t(3600, r5), 0);
    }

    public Duration plusMillis(long r5) {
        return d(r5 / 1000, (r5 % 1000) * 1000000);
    }

    public Duration plusMinutes(long r5) {
        return d(jm.c.t(60, r5), 0);
    }

    public Duration plusNanos(long r5) {
        return d(0, r5);
    }

    public Duration plusSeconds(long r5) {
        return d(r5, 0);
    }

    @Override // org.threeten.bp.temporal.f
    public org.threeten.bp.temporal.c subtractFrom(org.threeten.bp.temporal.c r5) {
        long r10 = this.seconds;
        if (r10 == 0) goto L5;
        r5 = r5.minus(r10, ChronoUnit.SECONDS);
    L5:
        int r11 = this.nanos;
        if (r11 != 0) goto L8;
        return r5;
    L8:
        return r5.minus(r11, ChronoUnit.NANOS);
    }

    public long toDays() {
        return this.seconds / 86400;
    }

    public long toHours() {
        return this.seconds / 3600;
    }

    public long toMillis() {
        return jm.c.r(jm.c.t(1000, this.seconds), this.nanos / DurationKt.NANOS_IN_MILLIS);
    }

    public long toMinutes() {
        return this.seconds / 60;
    }

    public long toNanos() {
        return jm.c.r(jm.c.t(Http2Connection.DEGRADED_PONG_TIMEOUT_NS, this.seconds), this.nanos);
    }

    public String toString() {
        if (this != ZERO) goto L6;
        return "PT0S";
    L6:
        long r5 = this.seconds;
        long r10 = r5 / 3600;
        int r11 = (int) ((r5 % 3600) / 60);
        int r12 = (int) (r5 % 60);
        StringBuilder r13 = androidx.constraintlayout.motion.widget.a.x(24, "PT");
        if (r10 == 0) goto L9;
        r13.append(r10);
        r13.append('H');
    L9:
        if (r11 == 0) goto L11;
        r13.append(r11);
        r13.append('M');
    L11:
        if (r12 == 0) goto L13;
    L18:
        if (r12 < 0) goto L20;
    L25:
        r13.append(r12);
    L27:
        if (this.nanos <= 0) goto L36;
        int r14 = r13.length();
        if (r12 >= 0) goto L31;
        r13.append(2000000000 - this.nanos);
    L33:
        if (r13.charAt(r13.length() - 1) != '0') goto L35;
        r13.setLength(r13.length() - 1);
        goto L33
    L35:
        r13.setCharAt(r14, '.');
        goto L36
    L31:
        r13.append(this.nanos + Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
    L36:
        r13.append('S');
        return r13.toString();
    L20:
        if (this.nanos <= 0) goto L25;
        if (r12 != (-1)) goto L24;
        r13.append("-0");
        goto L27
    L24:
        r13.append(r12 + 1);
        goto L27
    L13:
        if (this.nanos != 0) goto L18;
        if (r13.length() <= 2) goto L18;
        return r13.toString();
    }

    public Duration withNanos(int r5) {
        ChronoField.NANO_OF_SECOND.checkValidIntValue(r5);
        return a(r5, this.seconds);
    }

    public Duration withSeconds(long r5) {
        return a(this.nanos, r5);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        r5.writeLong(this.seconds);
        r5.writeInt(this.nanos);
    }

    public static Duration ofSeconds(long r5, long r10) {
        long r11 = jm.c.r(r5, jm.c.l(r10, 1000000000));
        return a(jm.c.n(Http2Connection.DEGRADED_PONG_TIMEOUT_NS, r10), r11);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Duration r5) {
        int r10 = jm.c.j(this.seconds, r5.seconds);
        if (r10 == 0) goto L6;
        return r10;
    L6:
        return this.nanos - r5.nanos;
    }

    public Duration plus(long r10, org.threeten.bp.temporal.j r11) {
        jm.c.p(r11, "unit");
        if (r11 != ChronoUnit.DAYS) goto L7;
        return d(jm.c.t(86400, r10), 0);
    L7:
        if (r11.isDurationEstimated() == true) goto L34;
        if (r10 != 0) goto L12;
        return this;
    L12:
        if ((r11 instanceof ChronoUnit) == false) goto L31;
        int r5 = b.f21135a[((ChronoUnit) r11).ordinal()];
        if (r5 == 1) goto L30;
        if (r5 == 2) goto L28;
        if (r5 == 3) goto L26;
        if (r5 == 4) goto L24;
        return plusSeconds(jm.c.u(r11.getDuration().seconds, r10));
    L24:
        return plusSeconds(r10);
    L26:
        return plusMillis(r10);
    L28:
        return plusSeconds((r10 / 1000000000) * 1000).plusNanos((r10 % 1000000000) * 1000);
    L30:
        return plusNanos(r10);
    L31:
        Duration r12 = r11.getDuration().multipliedBy(r10);
        return plusSeconds(r12.getSeconds()).plusNanos(r12.getNano());
    L34:
        throw new DateTimeException("Unit must not have an estimated duration");
    }

    public Duration minus(long r5, org.threeten.bp.temporal.j r10) {
        if (r5 != Long.MIN_VALUE) goto L6;
        Duration this = plus(Long.MAX_VALUE, r10);
        long r11 = 1;
    L7:
        return this.plus(r11, r10);
    L6:
        r11 = -r5;
        goto L7
    }
}
