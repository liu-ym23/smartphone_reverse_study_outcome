package kotlin.time;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010&\u001a\u0015\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a\u001d\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002¢\u0006\u0002\u00106\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0002\u001a)\u00108\u001a\u00020\u0005*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a)\u0010=\u001a\u000203*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a\u001c\u0010>\u001a\u00020\u0007*\u00020\b2\u0006\u0010?\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b@\u0010A\u001a\u001c\u0010>\u001a\u00020\u0007*\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\bB\u0010C\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\b2\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010G\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010H\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\u00012\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\r\u001a\u0004\b\u000b\u0010\u000e\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000e\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0010\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000e\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0010\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000e\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010\"\u001e\u0010 \u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"\u001e\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000e\"\u001e\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0010¨\u0006J"}, d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", "unit", "Lkotlin/time/DurationUnit;", "(DLkotlin/time/DurationUnit;)J", "(ILkotlin/time/DurationUnit;)J", "(JLkotlin/time/DurationUnit;)J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1494:1\n1447#1,6:1496\n1450#1,3:1502\n1447#1,6:1505\n1447#1,6:1511\n1450#1,3:1520\n1#2:1495\n1734#3,3:1517\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n*L\n1371#1:1496,6\n1405#1:1502,3\n1408#1:1505,6\n1411#1:1511,6\n1447#1:1520,3\n1436#1:1517,3\n*E\n"})
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    public static final /* synthetic */ long access$durationOf(long r5, int r10) {
        return durationOf(r5, r10);
    }

    public static final /* synthetic */ long access$durationOfMillis(long r5) {
        return durationOfMillis(r5);
    }

    public static final /* synthetic */ long access$durationOfMillisNormalized(long r5) {
        return durationOfMillisNormalized(r5);
    }

    public static final /* synthetic */ long access$durationOfNanos(long r5) {
        return durationOfNanos(r5);
    }

    public static final /* synthetic */ long access$durationOfNanosNormalized(long r5) {
        return durationOfNanosNormalized(r5);
    }

    public static final /* synthetic */ long access$millisToNanos(long r5) {
        return millisToNanos(r5);
    }

    public static final /* synthetic */ long access$nanosToMillis(long r5) {
        return nanosToMillis(r5);
    }

    public static final /* synthetic */ long access$parseDuration(String r5, boolean r10) {
        return parseDuration(r5, r10);
    }

    private static final long durationOf(long r5, int r10) {
        return Duration.m1463constructorimpl((r5 << 1) + ((long) r10));
    }

    private static final long durationOfMillis(long r5) {
        return Duration.m1463constructorimpl((r5 << 1) + 1);
    }

    private static final long durationOfMillisNormalized(long r10) {
        if ((-4611686018426L) > r10) goto L8;
        if (r10 >= 4611686018427L) goto L8;
        return durationOfNanos(millisToNanos(r10));
    L8:
        return durationOfMillis(RangesKt.coerceIn(r10, -4611686018427387903L, MAX_MILLIS));
    }

    private static final long durationOfNanos(long r5) {
        return Duration.m1463constructorimpl(r5 << 1);
    }

    private static final long durationOfNanosNormalized(long r5) {
        if ((-4611686018426999999L) > r5) goto L8;
        if (r5 >= 4611686018427000000L) goto L8;
        return durationOfNanos(r5);
    L8:
        return durationOfMillis(nanosToMillis(r5));
    }

    public static final /* synthetic */ long getDays(int r5) {
        return toDuration(r5, DurationUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(double r5) {
    }

    public static final /* synthetic */ long getHours(int r5) {
        return toDuration(r5, DurationUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(double r5) {
    }

    public static final /* synthetic */ long getMicroseconds(int r5) {
        return toDuration(r5, DurationUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(double r5) {
    }

    public static final /* synthetic */ long getMilliseconds(int r5) {
        return toDuration(r5, DurationUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(double r5) {
    }

    public static final /* synthetic */ long getMinutes(int r5) {
        return toDuration(r5, DurationUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(double r5) {
    }

    public static final /* synthetic */ long getNanoseconds(int r5) {
        return toDuration(r5, DurationUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(double r5) {
    }

    public static final /* synthetic */ long getSeconds(int r5) {
        return toDuration(r5, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(double r5) {
    }

    private static final long millisToNanos(long r5) {
        return r5 * ((long) NANOS_IN_MILLIS);
    }

    private static final long nanosToMillis(long r5) {
        return r5 / ((long) NANOS_IN_MILLIS);
    }

    private static final long parseDuration(String r18, boolean r19) {
        int r5 = r18.length();
        if (r5 == 0) goto L141;
        Duration.Companion r10 = Duration.Companion;
        long r11 = r10.m1566getZEROUwyO8pc();
        char r12 = r18.charAt(0);
        boolean r13 = true;
        if (r12 == '+') goto L8;
        if (r12 == '-') goto L8;
        int r14 = 0;
    L10:
        if (r14 <= 0) goto L12;
        boolean r15 = true;
    L13:
        if (r15 == true) goto L15;
    L17:
        boolean r16 = false;
    L19:
        if (r5 <= r14) goto L139;
        char r17 = ':';
        char r110 = '0';
        String r111 = "null cannot be cast to non-null type java.lang.String";
        if (r18.charAt(r14) != 'P') goto L70;
        int r20 = r14 + 1;
        if (r20 == r5) goto L68;
        DurationUnit r21 = null;
        boolean r22 = false;
    L25:
        if (r20 >= r5) goto L133;
        if (r18.charAt(r20) == 'T') goto L28;
        int r112 = r20;
    L36:
        if (r112 >= r18.length()) goto L44;
        char r113 = r18.charAt(r112);
        if (r110 > r113) goto L42;
        if (r113 >= r17) goto L42;
    L43:
        r112 = r112 + 1;
    L42:
        if (StringsKt.f("+-.", r113) == true) goto L43;
    L44:
        Intrinsics.checkNotNull(r18, r111);
        String r114 = r18.substring(r20, r112);
        if (r114.length() == 0) goto L66;
        int r115 = r114.length() + r20;
        if (r115 < 0) goto L64;
        if (r115 >= r18.length()) goto L64;
        char r23 = r18.charAt(r115);
        int r116 = r115 + 1;
        DurationUnit r24 = DurationUnitKt__DurationUnitKt.durationUnitByIsoChar(r23, r22);
        if (r21 == null) goto L57;
        if (r21.compareTo(r24) > 0) goto L57;
        throw new IllegalArgumentException("Unexpected order of duration components");
    L57:
        int r25 = StringsKt.q(r114, '.', 0, 6);
        if (r24 != DurationUnit.SECONDS) goto L62;
        if (r25 <= 0) goto L62;
        Intrinsics.checkNotNull(r114, r111);
        long r26 = Duration.m1499plusLRDsOJo(r11, toDuration(parseOverLongIsoComponent(r114.substring(0, r25)), r24));
        String r27 = r111;
        Intrinsics.checkNotNull(r114, r27);
        r11 = Duration.m1499plusLRDsOJo(r26, toDuration(Double.parseDouble(r114.substring(r25)), r24));
    L61:
        r21 = r24;
        r111 = r27;
        r20 = r116;
        r17 = ':';
        r13 = true;
        r110 = '0';
    L62:
        r27 = r111;
        r11 = Duration.m1499plusLRDsOJo(r11, toDuration(parseOverLongIsoComponent(r114), r24));
    L64:
        throw new IllegalArgumentException("Missing unit for value ".concat(r114));
    L66:
        throw new IllegalArgumentException();
    L28:
        if (r22 == true) goto L33;
        r20 = r20 + 1;
        if (r20 == r5) goto L33;
        r22 = r13;
    L33:
        throw new IllegalArgumentException();
    L133:
        if (r16 == true) goto L135;
        return r11;
    L135:
        return Duration.m1516unaryMinusUwyO8pc(r11);
    L68:
        throw new IllegalArgumentException();
    L70:
        if (r19 == true) goto L137;
        if (StringsKt.y(r14, Math.max(r5 - r14, 8), r18) == false) goto L74;
        r11 = r10.m1564getINFINITEUwyO8pc();
        goto L133
    L74:
        boolean r28 = !r15;
        if (r15 == true) goto L77;
    L85:
        DurationUnit r29 = null;
        boolean r30 = r28;
        boolean r31 = false;
    L86:
        if (r14 >= r5) goto L132;
        if (r31 == false) goto L94;
        if (r30 == false) goto L94;
    L90:
        if (r14 >= r18.length()) goto L94;
        if (r18.charAt(r14) != ' ') goto L94;
        r14 = r14 + 1;
    L94:
        int r32 = r14;
    L96:
        if (r32 >= r18.length()) goto L105;
        char r117 = r18.charAt(r32);
        if ('0' > r117) goto L102;
        if (r117 >= ':') goto L102;
    L103:
        r32 = r32 + 1;
    L102:
        if (r117 == '.') goto L103;
    L105:
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type java.lang.String");
        String r33 = r18.substring(r14, r32);
        if (r33.length() == 0) goto L131;
        int r118 = r33.length() + r14;
        int r34 = r118;
    L109:
        if (r34 >= r18.length()) goto L115;
        char r119 = r18.charAt(r34);
        if ('a' > r119) goto L115;
        if (r119 >= '{') goto L115;
        r34 = r34 + 1;
    L115:
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type java.lang.String");
        String r35 = r18.substring(r118, r34);
        int r120 = r118 + r35.length();
        DurationUnit r36 = DurationUnitKt__DurationUnitKt.durationUnitByShortName(r35);
        if (r29 == null) goto L122;
        if (r29.compareTo(r36) > 0) goto L122;
        throw new IllegalArgumentException("Unexpected order of duration components");
    L122:
        int r121 = StringsKt.q(r33, '.', 0, 6);
        if (r121 <= 0) goto L129;
        Intrinsics.checkNotNull(r33, "null cannot be cast to non-null type java.lang.String");
        long r37 = Duration.m1499plusLRDsOJo(r11, toDuration(Long.parseLong(r33.substring(0, r121)), r36));
        Intrinsics.checkNotNull(r33, "null cannot be cast to non-null type java.lang.String");
        r11 = Duration.m1499plusLRDsOJo(r37, toDuration(Double.parseDouble(r33.substring(r121)), r36));
        if (r120 >= r5) goto L126;
        throw new IllegalArgumentException("Fractional component must be last");
    L126:
        r29 = r36;
        r14 = r120;
        r31 = true;
        goto L86
    L129:
        r11 = Duration.m1499plusLRDsOJo(r11, toDuration(Long.parseLong(r33), r36));
        goto L126
    L131:
        throw new IllegalArgumentException();
    L132:
        r11 = r11;
        goto L133
    L77:
        if (r18.charAt(r14) != '(') goto L85;
        if (StringsKt.last(r18) != ')') goto L85;
        r14 = r14 + 1;
        r5 = r5 - 1;
        if (r14 == r5) goto L84;
        r31 = false;
        r30 = true;
        r29 = null;
        goto L86
    L84:
        throw new IllegalArgumentException("No components");
    L137:
        throw new IllegalArgumentException();
    L139:
        throw new IllegalArgumentException("No components");
    L15:
        if (StringsKt.O(r18, '-') == false) goto L17;
        r16 = true;
        goto L19
    L12:
        r15 = false;
    L8:
        r14 = 1;
        goto L10
    L141:
        throw new IllegalArgumentException("The string is empty");
    }

    private static final long parseOverLongIsoComponent(String r5) {
        int r10 = r5.length();
        if (r10 > 0) goto L5;
    L7:
        int r11 = 0;
    L9:
        if ((r10 - r11) <= 16) goto L29;
        Iterable r12 = new IntRange(r11, StringsKt.getLastIndex(r5));
        if ((r12 instanceof Collection) == true) goto L13;
    L15:
        Iterator r13 = r12.iterator();
    L17:
        if (r13.hasNext() == false) goto L24;
        char r14 = r5.charAt(((IntIterator) r13).nextInt());
        if ('0' > r14) goto L29;
        if (r14 >= ':') goto L29;
    L24:
        if (r5.charAt(0) != '-') goto L26;
        return Long.MIN_VALUE;
    L26:
        return Long.MAX_VALUE;
    L13:
        if (((Collection) r12).isEmpty() == false) goto L15;
    L29:
        if (StringsKt.P(r5, "+") == false) goto L32;
        r5 = StringsKt.drop(r5, 1);
    L32:
        return Long.parseLong(r5);
    L5:
        if (StringsKt.f("+-", r5.charAt(0)) == false) goto L7;
        r11 = 1;
        goto L9
    }

    private static final int skipWhile(String r5, int r10, Function1<? super Character, Boolean> r11) {
    L3:
        if (r10 >= r5.length()) goto L7;
        if (r11.invoke(Character.valueOf(r5.charAt(r10))).booleanValue() == false) goto L7;
        r10 = r10 + 1;
    L7:
        return r10;
    }

    private static final String substringWhile(String r5, int r10, Function1<? super Character, Boolean> r11) {
        int r12 = r10;
    L4:
        if (r12 >= r5.length()) goto L8;
        if (r11.invoke(Character.valueOf(r5.charAt(r12))).booleanValue() == false) goto L8;
        r12 = r12 + 1;
    L8:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.String");
        return r5.substring(r10, r12);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InlineOnly
    /* JADX INFO: renamed from: times-kIfJnKk, reason: not valid java name */
    private static final long m1589timeskIfJnKk(double r5, long r10) {
        return Duration.m1500timesUwyO8pc(r10, r5);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InlineOnly
    /* JADX INFO: renamed from: times-mvk6XK0, reason: not valid java name */
    private static final long m1590timesmvk6XK0(int r5, long r10) {
        return Duration.m1501timesUwyO8pc(r10, r5);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(int r5, DurationUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "unit");
        if (r10.compareTo(DurationUnit.SECONDS) > 0) goto L6;
        return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(r5, r10, DurationUnit.NANOSECONDS));
    L6:
        return toDuration(r5, r10);
    }

    public static final /* synthetic */ long getDays(long r5) {
        return toDuration(r5, DurationUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(int r5) {
    }

    public static final /* synthetic */ long getHours(long r5) {
        return toDuration(r5, DurationUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(int r5) {
    }

    public static final /* synthetic */ long getMicroseconds(long r5) {
        return toDuration(r5, DurationUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(int r5) {
    }

    public static final /* synthetic */ long getMilliseconds(long r5) {
        return toDuration(r5, DurationUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(int r5) {
    }

    public static final /* synthetic */ long getMinutes(long r5) {
        return toDuration(r5, DurationUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(int r5) {
    }

    public static final /* synthetic */ long getNanoseconds(long r5) {
        return toDuration(r5, DurationUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(int r5) {
    }

    public static final /* synthetic */ long getSeconds(long r5) {
        return toDuration(r5, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(int r5) {
    }

    public static final /* synthetic */ long getDays(double r5) {
        return toDuration(r5, DurationUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(long r5) {
    }

    public static final /* synthetic */ long getHours(double r5) {
        return toDuration(r5, DurationUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(long r5) {
    }

    public static final /* synthetic */ long getMicroseconds(double r5) {
        return toDuration(r5, DurationUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(long r5) {
    }

    public static final /* synthetic */ long getMilliseconds(double r5) {
        return toDuration(r5, DurationUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(long r5) {
    }

    public static final /* synthetic */ long getMinutes(double r5) {
        return toDuration(r5, DurationUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(long r5) {
    }

    public static final /* synthetic */ long getNanoseconds(double r5) {
        return toDuration(r5, DurationUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(long r5) {
    }

    public static final /* synthetic */ long getSeconds(double r5) {
        return toDuration(r5, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(long r5) {
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(long r10, DurationUnit r11) {
        Intrinsics.checkNotNullParameter(r11, "unit");
        DurationUnit r5 = DurationUnit.NANOSECONDS;
        long r12 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(MAX_NANOS, r5, r11);
        if ((-r12) > r10) goto L9;
        if (r10 > r12) goto L9;
        return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(r10, r11, r5));
    L9:
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r10, r11, DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(double r5, DurationUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "unit");
        double r11 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r5, r10, DurationUnit.NANOSECONDS);
        if (Double.isNaN(r11) == true) goto L12;
        long r12 = MathKt.roundToLong(r11);
        if ((-4611686018426999999L) > r12) goto L10;
        if (r12 >= 4611686018427000000L) goto L10;
        return durationOfNanos(r12);
    L10:
        return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r5, r10, DurationUnit.MILLISECONDS)));
    L12:
        throw new IllegalArgumentException("Duration value cannot be NaN.");
    }
}
