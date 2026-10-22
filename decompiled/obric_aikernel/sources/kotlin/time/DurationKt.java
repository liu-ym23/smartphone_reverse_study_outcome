package kotlin.time;

import com.bytedance.crash.dumper.Scraps;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1495:1\n1447#1,6:1497\n1450#1,3:1503\n1447#1,6:1506\n1447#1,6:1512\n1450#1,3:1521\n1#2:1496\n1726#3,3:1518\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n*L\n1371#1:1497,6\n1405#1:1503,3\n1408#1:1506,6\n1411#1:1512,6\n1447#1:1521,3\n1436#1:1518,3\n*E\n"})
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    public static final /* synthetic */ long access$durationOf(long r10, int r11) {
        return durationOf(r10, r11);
    }

    public static final /* synthetic */ long access$durationOfMillis(long r10) {
        return durationOfMillis(r10);
    }

    public static final /* synthetic */ long access$durationOfMillisNormalized(long r10) {
        return durationOfMillisNormalized(r10);
    }

    public static final /* synthetic */ long access$durationOfNanos(long r10) {
        return durationOfNanos(r10);
    }

    public static final /* synthetic */ long access$durationOfNanosNormalized(long r10) {
        return durationOfNanosNormalized(r10);
    }

    public static final /* synthetic */ long access$millisToNanos(long r10) {
        return millisToNanos(r10);
    }

    public static final /* synthetic */ long access$nanosToMillis(long r10) {
        return nanosToMillis(r10);
    }

    public static final /* synthetic */ long access$parseDuration(String r10, boolean r11) {
        return parseDuration(r10, r11);
    }

    private static final long durationOf(long r10, int r11) {
        return Duration.m1384constructorimpl((r10 << 1) + ((long) r11));
    }

    private static final long durationOfMillis(long r10) {
        return Duration.m1384constructorimpl((r10 << 1) + 1);
    }

    private static final long durationOfMillisNormalized(long r10) {
        if (new LongRange(-4611686018426L, MAX_NANOS_IN_MILLIS).contains(r10) == false) goto L6;
        return durationOfNanos(millisToNanos(r10));
    L6:
        return durationOfMillis(RangesKt.coerceIn(r10, -4611686018427387903L, MAX_MILLIS));
    }

    private static final long durationOfNanos(long r10) {
        return Duration.m1384constructorimpl(r10 << 1);
    }

    private static final long durationOfNanosNormalized(long r10) {
        if (new LongRange(-4611686018426999999L, MAX_NANOS).contains(r10) == false) goto L6;
        return durationOfNanos(r10);
    L6:
        return durationOfMillis(nanosToMillis(r10));
    }

    public static final /* synthetic */ long getDays(double r10) {
        return toDuration(r10, DurationUnit.DAYS);
    }

    public static final /* synthetic */ long getDays(int r10) {
        return toDuration(r10, DurationUnit.DAYS);
    }

    public static final /* synthetic */ long getDays(long r10) {
        return toDuration(r10, DurationUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(double r10) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(int r10) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(long r10) {
    }

    public static final /* synthetic */ long getHours(double r10) {
        return toDuration(r10, DurationUnit.HOURS);
    }

    public static final /* synthetic */ long getHours(int r10) {
        return toDuration(r10, DurationUnit.HOURS);
    }

    public static final /* synthetic */ long getHours(long r10) {
        return toDuration(r10, DurationUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(double r10) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(int r10) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(long r10) {
    }

    public static final /* synthetic */ long getMicroseconds(double r10) {
        return toDuration(r10, DurationUnit.MICROSECONDS);
    }

    public static final /* synthetic */ long getMicroseconds(int r10) {
        return toDuration(r10, DurationUnit.MICROSECONDS);
    }

    public static final /* synthetic */ long getMicroseconds(long r10) {
        return toDuration(r10, DurationUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(double r10) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(int r10) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(long r10) {
    }

    public static final /* synthetic */ long getMilliseconds(double r10) {
        return toDuration(r10, DurationUnit.MILLISECONDS);
    }

    public static final /* synthetic */ long getMilliseconds(int r10) {
        return toDuration(r10, DurationUnit.MILLISECONDS);
    }

    public static final /* synthetic */ long getMilliseconds(long r10) {
        return toDuration(r10, DurationUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(double r10) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(int r10) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(long r10) {
    }

    public static final /* synthetic */ long getMinutes(double r10) {
        return toDuration(r10, DurationUnit.MINUTES);
    }

    public static final /* synthetic */ long getMinutes(int r10) {
        return toDuration(r10, DurationUnit.MINUTES);
    }

    public static final /* synthetic */ long getMinutes(long r10) {
        return toDuration(r10, DurationUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(double r10) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(int r10) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(long r10) {
    }

    public static final /* synthetic */ long getNanoseconds(double r10) {
        return toDuration(r10, DurationUnit.NANOSECONDS);
    }

    public static final /* synthetic */ long getNanoseconds(int r10) {
        return toDuration(r10, DurationUnit.NANOSECONDS);
    }

    public static final /* synthetic */ long getNanoseconds(long r10) {
        return toDuration(r10, DurationUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(double r10) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(int r10) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(long r10) {
    }

    public static final /* synthetic */ long getSeconds(double r10) {
        return toDuration(r10, DurationUnit.SECONDS);
    }

    public static final /* synthetic */ long getSeconds(int r10) {
        return toDuration(r10, DurationUnit.SECONDS);
    }

    public static final /* synthetic */ long getSeconds(long r10) {
        return toDuration(r10, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(double r10) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(int r10) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(long r10) {
    }

    private static final long millisToNanos(long r10) {
        return r10 * ((long) 1000000);
    }

    private static final long nanosToMillis(long r10) {
        return r10 / ((long) 1000000);
    }

    private static final long parseDuration(String r27, boolean r28) {
        int r10 = r27.length();
        if (r10 == 0) goto L156;
        Duration.Companion r11 = Duration.Companion;
        long r12 = r11.m1487getZEROUwyO8pc();
        char r13 = r27.charAt(0);
        boolean r14 = true;
        if (r13 != '+') goto L7;
    L6:
        int r15 = 1;
    L10:
        if (r15 <= 0) goto L12;
        boolean r16 = true;
    L14:
        if (r16 == true) goto L16;
    L18:
        boolean r17 = false;
    L20:
        if (r10 <= r15) goto L154;
        char r18 = '9';
        char r19 = '0';
        String r110 = "this as java.lang.String…ing(startIndex, endIndex)";
        if (r27.charAt(r15) != 'P') goto L78;
        int r111 = r15 + 1;
        if (r111 == r10) goto L76;
        boolean r20 = false;
        DurationUnit r21 = null;
    L26:
        if (r111 >= r10) goto L148;
        if (r27.charAt(r111) == 'T') goto L29;
        int r22 = r111;
    L37:
        if (r22 >= r27.length()) goto L48;
        char r112 = r27.charAt(r22);
        if (new CharRange(r19, r18).contains(r112) == true) goto L44;
        int r113 = r10;
        if (StringsKt.contains$default("+-.", r112, false, 2, null) == true) goto L45;
        boolean r23 = false;
    L46:
        if (r23 == false) goto L49;
        r22 = r22 + 1;
        r10 = r113;
        r19 = '0';
        r18 = '9';
    L49:
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type java.lang.String");
        String r24 = r27.substring(r111, r22);
        Intrinsics.checkNotNullExpressionValue(r24, "this as java.lang.String…ing(startIndex, endIndex)");
        if (r24.length() != 0) goto L52;
        boolean r25 = true;
    L53:
        if (r25 == true) goto L74;
        int r114 = r111 + r24.length();
        if (r114 < 0) goto L72;
        if (r114 > StringsKt.getLastIndex(r27)) goto L72;
        char r26 = r27.charAt(r114);
        r111 = r114 + 1;
        DurationUnit r29 = DurationUnitKt__DurationUnitKt.durationUnitByIsoChar(r26, r20);
        if (r21 != null) goto L61;
    L65:
        int r30 = StringsKt.indexOf$default(r24, '.', 0, false, 6, null);
        if (r29 != DurationUnit.SECONDS) goto L69;
        if (r30 <= 0) goto L69;
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type java.lang.String");
        String r115 = r24.substring(0, r30);
        Intrinsics.checkNotNullExpressionValue(r115, "this as java.lang.String…ing(startIndex, endIndex)");
        long r31 = Duration.m1420plusLRDsOJo(r12, toDuration(parseOverLongIsoComponent(r115), r29));
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type java.lang.String");
        String r32 = r24.substring(r30);
        Intrinsics.checkNotNullExpressionValue(r32, "this as java.lang.String).substring(startIndex)");
        r12 = Duration.m1420plusLRDsOJo(r31, toDuration(Double.parseDouble(r32), r29));
    L70:
        r20 = r20;
        r21 = r29;
        r10 = r113;
        r19 = '0';
        r18 = '9';
        r14 = true;
    L69:
        r12 = Duration.m1420plusLRDsOJo(r12, toDuration(parseOverLongIsoComponent(r24), r29));
        goto L70
    L61:
        if (r21.compareTo(r29) > 0) goto L65;
        throw new IllegalArgumentException("Unexpected order of duration components");
    L72:
        throw new IllegalArgumentException("Missing unit for value " + r24);
    L74:
        throw new IllegalArgumentException();
    L52:
        r25 = false;
    L45:
        r23 = true;
        goto L46
    L44:
        r113 = r10;
        goto L45
    L48:
        r113 = r10;
        goto L49
    L29:
        if (r20 == true) goto L34;
        r111 = r111 + 1;
        if (r111 == r10) goto L34;
        r20 = r14;
    L34:
        throw new IllegalArgumentException();
    L148:
        if (r17 == true) goto L150;
        return r12;
    L150:
        return Duration.m1437unaryMinusUwyO8pc(r12);
    L76:
        throw new IllegalArgumentException();
    L78:
        if (r28 == true) goto L152;
        String r210 = "Unexpected order of duration components";
        DurationUnit r116 = null;
        if (StringsKt.regionMatches(r27, r15, "Infinity", 0, Math.max(r10 - r15, 8), true) == false) goto L82;
        r12 = r11.m1485getINFINITEUwyO8pc();
        goto L148
    L82:
        boolean r33 = !r16;
        if (r16 == true) goto L85;
    L93:
        int r34 = r10;
    L94:
        boolean r35 = false;
    L95:
        if (r15 >= r34) goto L148;
        if (r35 == false) goto L106;
        if (r33 == false) goto L106;
    L99:
        if (r15 >= r27.length()) goto L106;
        if (r27.charAt(r15) != ' ') goto L103;
        boolean r36 = true;
    L104:
        if (r36 == false) goto L106;
        r15 = r15 + 1;
        goto L99
    L103:
        r36 = false;
    L106:
        int r37 = r15;
    L108:
        if (r37 >= r27.length()) goto L119;
        char r38 = r27.charAt(r37);
        if (new CharRange('0', '9').contains(r38) == false) goto L112;
    L115:
        boolean r39 = true;
    L116:
        if (r39 == false) goto L119;
        r37 = r37 + 1;
        goto L108
    L112:
        if (r38 == '.') goto L115;
        r39 = false;
    L119:
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type java.lang.String");
        String r40 = r27.substring(r15, r37);
        Intrinsics.checkNotNullExpressionValue(r40, r110);
        if (r40.length() != 0) goto L122;
        boolean r41 = true;
    L123:
        if (r41 == true) goto L147;
        int r117 = r15 + r40.length();
        int r42 = r117;
    L126:
        if (r42 >= r27.length()) goto L130;
        if (new CharRange('a', 'z').contains(r27.charAt(r42)) == false) goto L130;
        r42 = r42 + 1;
    L130:
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type java.lang.String");
        String r43 = r27.substring(r117, r42);
        Intrinsics.checkNotNullExpressionValue(r43, r110);
        r15 = r117 + r43.length();
        DurationUnit r44 = DurationUnitKt__DurationUnitKt.durationUnitByShortName(r43);
        if (r116 != null) goto L133;
    L137:
        String r45 = r210;
        int r46 = StringsKt.indexOf$default(r40, '.', 0, false, 6, null);
        if (r46 <= 0) goto L144;
        Intrinsics.checkNotNull(r40, "null cannot be cast to non-null type java.lang.String");
        String r118 = r40.substring(0, r46);
        Intrinsics.checkNotNullExpressionValue(r118, r110);
        long r47 = Duration.m1420plusLRDsOJo(r12, toDuration(Long.parseLong(r118), r44));
        Intrinsics.checkNotNull(r40, "null cannot be cast to non-null type java.lang.String");
        String r48 = r40.substring(r46);
        Intrinsics.checkNotNullExpressionValue(r48, "this as java.lang.String).substring(startIndex)");
        r12 = Duration.m1420plusLRDsOJo(r47, toDuration(Double.parseDouble(r48), r44));
        if (r15 >= r34) goto L145;
        throw new IllegalArgumentException("Fractional component must be last");
    L145:
        r210 = r45;
        r116 = r44;
        r110 = r110;
        r35 = true;
        goto L95
    L144:
        r12 = Duration.m1420plusLRDsOJo(r12, toDuration(Long.parseLong(r40), r44));
        goto L145
    L133:
        if (r116.compareTo(r44) > 0) goto L137;
        throw new IllegalArgumentException(r210);
    L147:
        throw new IllegalArgumentException();
    L122:
        r41 = false;
        goto L123
    L85:
        if (r27.charAt(r15) != '(') goto L93;
        if (StringsKt.last(r27) != ')') goto L93;
        r15 = r15 + 1;
        int r49 = r10 - 1;
        if (r15 == r49) goto L92;
        r34 = r49;
        r33 = true;
        goto L94
    L92:
        throw new IllegalArgumentException("No components");
    L152:
        throw new IllegalArgumentException();
    L154:
        throw new IllegalArgumentException("No components");
    L16:
        if (StringsKt.startsWith$default(r27, '-', false, 2, null) == false) goto L18;
        r17 = true;
        goto L20
    L12:
        r16 = false;
        goto L14
    L7:
        if (r13 == '-') goto L6;
        r15 = 0;
        goto L10
    L156:
        throw new IllegalArgumentException("The string is empty");
    }

    private static final long parseOverLongIsoComponent(String r10) {
        int r11 = r10.length();
        if (r11 > 0) goto L5;
    L7:
        int r12 = 0;
    L9:
        if ((r11 - r12) <= 16) goto L28;
        Iterable r13 = new IntRange(r12, StringsKt.getLastIndex(r10));
        if ((r13 instanceof Collection) == true) goto L13;
    L15:
        Iterator r14 = r13.iterator();
    L17:
        if (r14.hasNext() == false) goto L14;
        if (new CharRange('0', '9').contains(r10.charAt(((IntIterator) r14).nextInt())) == true) goto L17;
        boolean r15 = false;
    L21:
        if (r15 == false) goto L28;
        if (r10.charAt(0) != '-') goto L25;
        return Long.MIN_VALUE;
    L25:
        return Long.MAX_VALUE;
    L14:
        r15 = true;
        goto L21
    L13:
        if (((Collection) r13).isEmpty() == false) goto L15;
    L28:
        if (StringsKt.startsWith$default(r10, "+", false, 2, null) == false) goto L31;
        r10 = StringsKt.drop(r10, 1);
    L31:
        return Long.parseLong(r10);
    L5:
        if (StringsKt.contains$default("+-", r10.charAt(0), false, 2, null) == false) goto L7;
        r12 = 1;
        goto L9
    }

    private static final int skipWhile(String r10, int r11, Function1<? super Character, Boolean> r12) {
    L3:
        if (r11 >= r10.length()) goto L7;
        if (r12.invoke(Character.valueOf(r10.charAt(r11))).booleanValue() == false) goto L7;
        r11 = r11 + 1;
    L7:
        return r11;
    }

    private static final String substringWhile(String r10, int r11, Function1<? super Character, Boolean> r12) {
        int r13 = r11;
    L4:
        if (r13 >= r10.length()) goto L8;
        if (r12.invoke(Character.valueOf(r10.charAt(r13))).booleanValue() == false) goto L8;
        r13 = r13 + 1;
    L8:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.String");
        String r14 = r10.substring(r11, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        return r14;
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InlineOnly
    /* JADX INFO: renamed from: times-kIfJnKk, reason: not valid java name */
    private static final long m1510timeskIfJnKk(double r10, long r11) {
        return Duration.m1421timesUwyO8pc(r11, r10);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InlineOnly
    /* JADX INFO: renamed from: times-mvk6XK0, reason: not valid java name */
    private static final long m1511timesmvk6XK0(int r10, long r11) {
        return Duration.m1422timesUwyO8pc(r11, r10);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(double r10, DurationUnit r11) {
        Intrinsics.checkNotNullParameter(r11, Scraps.INNER_UNIT);
        double r12 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r10, r11, DurationUnit.NANOSECONDS);
        if ((!Double.isNaN(r12)) == false) goto L10;
        long r13 = MathKt.roundToLong(r12);
        if (new LongRange(-4611686018426999999L, MAX_NANOS).contains(r13) == false) goto L8;
        return durationOfNanos(r13);
    L8:
        return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r10, r11, DurationUnit.MILLISECONDS)));
    L10:
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(int r10, DurationUnit r11) {
        Intrinsics.checkNotNullParameter(r11, Scraps.INNER_UNIT);
        if (r11.compareTo(DurationUnit.SECONDS) > 0) goto L6;
        return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(r10, r11, DurationUnit.NANOSECONDS));
    L6:
        return toDuration(r10, r11);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(long r10, DurationUnit r11) {
        Intrinsics.checkNotNullParameter(r11, Scraps.INNER_UNIT);
        DurationUnit r12 = DurationUnit.NANOSECONDS;
        long r13 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(MAX_NANOS, r12, r11);
        if (new LongRange(-r13, r13).contains(r10) == false) goto L7;
        return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(r10, r11, r12));
    L7:
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r10, r11, DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS));
    }
}
