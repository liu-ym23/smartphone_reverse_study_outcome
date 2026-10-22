package kotlin.time;

import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.entity.EventBody;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.comparisons.ComparisonsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.6")
@JvmInline
@WasExperimental(markerClass = {ExperimentalTime.class})
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1495:1\n38#1:1496\n38#1:1497\n38#1:1498\n38#1:1499\n38#1:1500\n683#1,2:1501\n700#1,2:1510\n163#2,6:1503\n1#3:1509\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n*L\n39#1:1496\n40#1:1497\n458#1:1498\n478#1:1499\n662#1:1500\n979#1:1501,2\n1070#1:1510,2\n1021#1:1503,6\n*E\n"})
public final class Duration implements Comparable<Duration> {
    public static final Companion Companion = null;
    private static final long INFINITE = 0;
    private static final long NEG_INFINITE = 0;
    private static final long ZERO = 0;
    private final long rawValue;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1440getDaysUwyO8pc(double r10) {
            return DurationKt.toDuration(r10, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1441getDaysUwyO8pc(int r10) {
            return DurationKt.toDuration(r10, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1442getDaysUwyO8pc(long r10) {
            return DurationKt.toDuration(r10, DurationUnit.DAYS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1443getDaysUwyO8pc$annotations(double r10) {
        }

        @InlineOnly
        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1444getDaysUwyO8pc$annotations(int r10) {
        }

        @InlineOnly
        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1445getDaysUwyO8pc$annotations(long r10) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1446getHoursUwyO8pc(double r10) {
            return DurationKt.toDuration(r10, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1447getHoursUwyO8pc(int r10) {
            return DurationKt.toDuration(r10, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1448getHoursUwyO8pc(long r10) {
            return DurationKt.toDuration(r10, DurationUnit.HOURS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1449getHoursUwyO8pc$annotations(double r10) {
        }

        @InlineOnly
        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1450getHoursUwyO8pc$annotations(int r10) {
        }

        @InlineOnly
        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1451getHoursUwyO8pc$annotations(long r10) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1452getMicrosecondsUwyO8pc(double r10) {
            return DurationKt.toDuration(r10, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1453getMicrosecondsUwyO8pc(int r10) {
            return DurationKt.toDuration(r10, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1454getMicrosecondsUwyO8pc(long r10) {
            return DurationKt.toDuration(r10, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1455getMicrosecondsUwyO8pc$annotations(double r10) {
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1456getMicrosecondsUwyO8pc$annotations(int r10) {
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1457getMicrosecondsUwyO8pc$annotations(long r10) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1458getMillisecondsUwyO8pc(double r10) {
            return DurationKt.toDuration(r10, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1459getMillisecondsUwyO8pc(int r10) {
            return DurationKt.toDuration(r10, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1460getMillisecondsUwyO8pc(long r10) {
            return DurationKt.toDuration(r10, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1461getMillisecondsUwyO8pc$annotations(double r10) {
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1462getMillisecondsUwyO8pc$annotations(int r10) {
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1463getMillisecondsUwyO8pc$annotations(long r10) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1464getMinutesUwyO8pc(double r10) {
            return DurationKt.toDuration(r10, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1465getMinutesUwyO8pc(int r10) {
            return DurationKt.toDuration(r10, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1466getMinutesUwyO8pc(long r10) {
            return DurationKt.toDuration(r10, DurationUnit.MINUTES);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1467getMinutesUwyO8pc$annotations(double r10) {
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1468getMinutesUwyO8pc$annotations(int r10) {
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1469getMinutesUwyO8pc$annotations(long r10) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1470getNanosecondsUwyO8pc(double r10) {
            return DurationKt.toDuration(r10, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1471getNanosecondsUwyO8pc(int r10) {
            return DurationKt.toDuration(r10, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1472getNanosecondsUwyO8pc(long r10) {
            return DurationKt.toDuration(r10, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1473getNanosecondsUwyO8pc$annotations(double r10) {
        }

        @InlineOnly
        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1474getNanosecondsUwyO8pc$annotations(int r10) {
        }

        @InlineOnly
        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1475getNanosecondsUwyO8pc$annotations(long r10) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1476getSecondsUwyO8pc(double r10) {
            return DurationKt.toDuration(r10, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1477getSecondsUwyO8pc(int r10) {
            return DurationKt.toDuration(r10, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1478getSecondsUwyO8pc(long r10) {
            return DurationKt.toDuration(r10, DurationUnit.SECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1479getSecondsUwyO8pc$annotations(double r10) {
        }

        @InlineOnly
        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1480getSecondsUwyO8pc$annotations(int r10) {
        }

        @InlineOnly
        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1481getSecondsUwyO8pc$annotations(long r10) {
        }

        @ExperimentalTime
        public final double convert(double r10, DurationUnit r11, DurationUnit r12) {
            Intrinsics.checkNotNullParameter(r11, "sourceUnit");
            Intrinsics.checkNotNullParameter(r12, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r10, r11, r12);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1482daysUwyO8pc(double r10) {
            return DurationKt.toDuration(r10, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1483daysUwyO8pc(int r10) {
            return DurationKt.toDuration(r10, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1484daysUwyO8pc(long r10) {
            return DurationKt.toDuration(r10, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m1485getINFINITEUwyO8pc() {
            return Duration.access$getINFINITE$cp();
        }

        /* JADX INFO: renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m1486getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.access$getNEG_INFINITE$cp();
        }

        /* JADX INFO: renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m1487getZEROUwyO8pc() {
            return Duration.access$getZERO$cp();
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1488hoursUwyO8pc(double r10) {
            return DurationKt.toDuration(r10, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1489hoursUwyO8pc(int r10) {
            return DurationKt.toDuration(r10, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1490hoursUwyO8pc(long r10) {
            return DurationKt.toDuration(r10, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1491microsecondsUwyO8pc(double r10) {
            return DurationKt.toDuration(r10, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1492microsecondsUwyO8pc(int r10) {
            return DurationKt.toDuration(r10, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1493microsecondsUwyO8pc(long r10) {
            return DurationKt.toDuration(r10, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1494millisecondsUwyO8pc(double r10) {
            return DurationKt.toDuration(r10, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1495millisecondsUwyO8pc(int r10) {
            return DurationKt.toDuration(r10, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1496millisecondsUwyO8pc(long r10) {
            return DurationKt.toDuration(r10, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1497minutesUwyO8pc(double r10) {
            return DurationKt.toDuration(r10, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1498minutesUwyO8pc(int r10) {
            return DurationKt.toDuration(r10, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1499minutesUwyO8pc(long r10) {
            return DurationKt.toDuration(r10, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1500nanosecondsUwyO8pc(double r10) {
            return DurationKt.toDuration(r10, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1501nanosecondsUwyO8pc(int r10) {
            return DurationKt.toDuration(r10, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1502nanosecondsUwyO8pc(long r10) {
            return DurationKt.toDuration(r10, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m1503parseUwyO8pc(String r10) {
            Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
            return DurationKt.access$parseDuration(r10, false);
        L5:
            e = move-exception;
            throw new IllegalArgumentException("Invalid duration string format: '" + r10 + "'.", e);
        }

        /* JADX INFO: renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m1504parseIsoStringUwyO8pc(String r10) {
            Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
            return DurationKt.access$parseDuration(r10, true);
        L5:
            e = move-exception;
            throw new IllegalArgumentException("Invalid ISO duration string format: '" + r10 + "'.", e);
        }

        /* JADX INFO: renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final Duration m1505parseIsoStringOrNullFghU774(String r10) {
            Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
            return Duration.m1382boximpl(DurationKt.access$parseDuration(r10, true));
        L5:
            return null;
        }

        /* JADX INFO: renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final Duration m1506parseOrNullFghU774(String r10) {
            Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
            return Duration.m1382boximpl(DurationKt.access$parseDuration(r10, false));
        L5:
            return null;
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1507secondsUwyO8pc(double r10) {
            return DurationKt.toDuration(r10, DurationUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1508secondsUwyO8pc(int r10) {
            return DurationKt.toDuration(r10, DurationUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1509secondsUwyO8pc(long r10) {
            return DurationKt.toDuration(r10, DurationUnit.SECONDS);
        }
    }

    static {
        Companion = new Companion(null);
        ZERO = m1384constructorimpl(0);
        INFINITE = DurationKt.access$durationOfMillis(DurationKt.MAX_MILLIS);
        NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);
    }

    private /* synthetic */ Duration(long r10) {
        this.rawValue = r10;
    }

    public static final /* synthetic */ long access$getINFINITE$cp() {
        return INFINITE;
    }

    public static final /* synthetic */ long access$getNEG_INFINITE$cp() {
        return NEG_INFINITE;
    }

    public static final /* synthetic */ long access$getZERO$cp() {
        return ZERO;
    }

    /* JADX INFO: renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m1380addValuesMixedRangesUwyO8pc(long r10, long r11, long r12) {
        long r13 = DurationKt.access$nanosToMillis(r12);
        long r14 = r11 + r13;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(r14) == false) goto L6;
        long r15 = r12 - DurationKt.access$millisToNanos(r13);
        return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(r14) + r15);
    L6:
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(r14, -4611686018427387903L, DurationKt.MAX_MILLIS));
    }

    /* JADX INFO: renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m1381appendFractionalimpl(long r10, StringBuilder r11, int r12, int r13, int r14, String r15, boolean r16) {
        r11.append(r12);
        if (r13 == 0) goto L21;
        r11.append('.');
        String r17 = StringsKt.padStart(String.valueOf(r13), r14, '0');
        int r18 = -1;
        int r19 = r17.length() - 1;
        if (r19 < 0) goto L15;
    L6:
        int r20 = r19 - 1;
        if (r17.charAt(r19) == '0') goto L9;
        boolean r21 = true;
    L10:
        if (r21 == true) goto L11;
        if (r20 < 0) goto L15;
        r19 = r20;
        goto L6
    L11:
        r18 = r19;
        goto L15
    L9:
        r21 = false;
    L15:
        int r22 = r18 + 1;
        if (r16 == true) goto L19;
        if (r22 >= 3) goto L19;
    L20:
        r11.append(r17, 0, r22);
        Intrinsics.checkNotNullExpressionValue(r11, "this.append(value, startIndex, endIndex)");
    L19:
        r22 = ((r22 + 2) / 3) * 3;
    L21:
        r11.append(r15);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m1382boximpl(long r10) {
        return new Duration(r10);
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m1383compareToLRDsOJo(long r10, long r11) {
        long r12 = r10 ^ r11;
        if (r12 < 0) goto L12;
        if ((((int) r12) & 1) == 0) goto L12;
        int r13 = (((int) r10) & 1) - (((int) r11) & 1);
        if (m1417isNegativeimpl(r10) == true) goto L10;
        return r13;
    L10:
        return -r13;
    L12:
        return Intrinsics.compare(r10, r11);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1384constructorimpl(long r10) {
        if (DurationJvmKt.getDurationAssertionsEnabled() == true) goto L5;
    L20:
        return r10;
    L5:
        if (m1415isInNanosimpl(r10) == false) goto L12;
        if (new LongRange(-4611686018426999999L, DurationKt.MAX_NANOS).contains(m1411getValueimpl(r10)) == true) goto L20;
        throw new AssertionError(m1411getValueimpl(r10) + " ns is out of nanoseconds range");
    L12:
        if (new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS).contains(m1411getValueimpl(r10)) == false) goto L19;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(m1411getValueimpl(r10)) == false) goto L20;
        throw new AssertionError(m1411getValueimpl(r10) + " ms is denormalized");
    L19:
        throw new AssertionError(m1411getValueimpl(r10) + " ms is out of milliseconds range");
    }

    /* JADX INFO: renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m1385divLRDsOJo(long r10, long r11) {
        DurationUnit r12 = (DurationUnit) ComparisonsKt.maxOf(m1409getStorageUnitimpl(r10), m1409getStorageUnitimpl(r11));
        return m1427toDoubleimpl(r10, r12) / m1427toDoubleimpl(r11, r12);
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1386divUwyO8pc(long r10, double r11) {
        int r12 = MathKt.roundToInt(r11);
        if (r12 != r11) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L10;
        if (r12 == 0) goto L10;
        return m1387divUwyO8pc(r10, r12);
    L10:
        DurationUnit r14 = m1409getStorageUnitimpl(r10);
        return DurationKt.toDuration(m1427toDoubleimpl(r10, r14) / r11, r14);
    L5:
        r13 = false;
        goto L6
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1387divUwyO8pc(long r10, int r11) {
        if (r11 != 0) goto L13;
        if (m1418isPositiveimpl(r10) == false) goto L7;
        return INFINITE;
    L7:
        if (m1417isNegativeimpl(r10) == false) goto L11;
        return NEG_INFINITE;
    L11:
        throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
    L13:
        if (m1415isInNanosimpl(r10) == false) goto L17;
        return DurationKt.access$durationOfNanos(m1411getValueimpl(r10) / ((long) r11));
    L17:
        if (m1416isInfiniteimpl(r10) == true) goto L19;
        long r12 = r11;
        long r13 = m1411getValueimpl(r10) / r12;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(r13) == false) goto L25;
        return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(r13) + (DurationKt.access$millisToNanos(m1411getValueimpl(r10) - (r13 * r12)) / r12));
    L25:
        return DurationKt.access$durationOfMillis(r13);
    L19:
        return m1422timesUwyO8pc(r10, MathKt.getSign(r11));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1388equalsimpl(long r10, Object r11) {
        if ((r11 instanceof Duration) == true) goto L6;
        return false;
    L6:
        if (r10 == ((Duration) r11).m1439unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1389equalsimpl0(long r10, long r11) {
        if (r10 != r11) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m1390getAbsoluteValueUwyO8pc(long r10) {
        if (m1417isNegativeimpl(r10) == true) goto L5;
        return r10;
    L5:
        return m1437unaryMinusUwyO8pc(r10);
    }

    @PublishedApi
    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    /* JADX INFO: renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m1391getHoursComponentimpl(long r10) {
        if (m1416isInfiniteimpl(r10) == false) goto L6;
        return 0;
    L6:
        return (int) (m1400getInWholeHoursimpl(r10) % ((long) 24));
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInDays$annotations() {
    }

    /* JADX INFO: renamed from: getInDays-impl, reason: not valid java name */
    public static final /* synthetic */ double m1392getInDaysimpl(long r10) {
        return m1427toDoubleimpl(r10, DurationUnit.DAYS);
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInHours$annotations() {
    }

    /* JADX INFO: renamed from: getInHours-impl, reason: not valid java name */
    public static final /* synthetic */ double m1393getInHoursimpl(long r10) {
        return m1427toDoubleimpl(r10, DurationUnit.HOURS);
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    /* JADX INFO: renamed from: getInMicroseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m1394getInMicrosecondsimpl(long r10) {
        return m1427toDoubleimpl(r10, DurationUnit.MICROSECONDS);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    /* JADX INFO: renamed from: getInMilliseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m1395getInMillisecondsimpl(long r10) {
        return m1427toDoubleimpl(r10, DurationUnit.MILLISECONDS);
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    /* JADX INFO: renamed from: getInMinutes-impl, reason: not valid java name */
    public static final /* synthetic */ double m1396getInMinutesimpl(long r10) {
        return m1427toDoubleimpl(r10, DurationUnit.MINUTES);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    /* JADX INFO: renamed from: getInNanoseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m1397getInNanosecondsimpl(long r10) {
        return m1427toDoubleimpl(r10, DurationUnit.NANOSECONDS);
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    /* JADX INFO: renamed from: getInSeconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m1398getInSecondsimpl(long r10) {
        return m1427toDoubleimpl(r10, DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m1399getInWholeDaysimpl(long r10) {
        return m1430toLongimpl(r10, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m1400getInWholeHoursimpl(long r10) {
        return m1430toLongimpl(r10, DurationUnit.HOURS);
    }

    /* JADX INFO: renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m1401getInWholeMicrosecondsimpl(long r10) {
        return m1430toLongimpl(r10, DurationUnit.MICROSECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m1402getInWholeMillisecondsimpl(long r10) {
        if (m1414isInMillisimpl(r10) == false) goto L8;
        if (m1413isFiniteimpl(r10) == false) goto L8;
        return m1411getValueimpl(r10);
    L8:
        return m1430toLongimpl(r10, DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m1403getInWholeMinutesimpl(long r10) {
        return m1430toLongimpl(r10, DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m1404getInWholeNanosecondsimpl(long r10) {
        long r11 = m1411getValueimpl(r10);
        if (m1415isInNanosimpl(r10) == false) goto L6;
        return r11;
    L6:
        if (r11 <= 9223372036854L) goto L9;
        return Long.MAX_VALUE;
    L9:
        if (r11 >= (-9223372036854L)) goto L12;
        return Long.MIN_VALUE;
    L12:
        return DurationKt.access$millisToNanos(r11);
    }

    /* JADX INFO: renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m1405getInWholeSecondsimpl(long r10) {
        return m1430toLongimpl(r10, DurationUnit.SECONDS);
    }

    @PublishedApi
    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    /* JADX INFO: renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m1406getMinutesComponentimpl(long r10) {
        if (m1416isInfiniteimpl(r10) == false) goto L6;
        return 0;
    L6:
        return (int) (m1403getInWholeMinutesimpl(r10) % ((long) 60));
    }

    @PublishedApi
    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    /* JADX INFO: renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m1407getNanosecondsComponentimpl(long r10) {
        if (m1416isInfiniteimpl(r10) == false) goto L5;
        return 0;
    L5:
        boolean r11 = m1414isInMillisimpl(r10);
        long r12 = m1411getValueimpl(r10);
        if (r11 == false) goto L8;
        long r13 = DurationKt.access$millisToNanos(r12 % ((long) 1000));
    L10:
        return (int) r13;
    L8:
        r13 = r12 % ((long) 1000000000);
        goto L10
    }

    @PublishedApi
    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* JADX INFO: renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m1408getSecondsComponentimpl(long r10) {
        if (m1416isInfiniteimpl(r10) == false) goto L6;
        return 0;
    L6:
        return (int) (m1405getInWholeSecondsimpl(r10) % ((long) 60));
    }

    /* JADX INFO: renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m1409getStorageUnitimpl(long r10) {
        if (m1415isInNanosimpl(r10) == false) goto L6;
        return DurationUnit.NANOSECONDS;
    L6:
        return DurationUnit.MILLISECONDS;
    }

    /* JADX INFO: renamed from: getUnitDiscriminator-impl, reason: not valid java name */
    private static final int m1410getUnitDiscriminatorimpl(long r10) {
        return ((int) r10) & 1;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    private static final long m1411getValueimpl(long r10) {
        return r10 >> 1;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1412hashCodeimpl(long r10) {
        return Long.hashCode(r10);
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m1413isFiniteimpl(long r10) {
        return !m1416isInfiniteimpl(r10);
    }

    /* JADX INFO: renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m1414isInMillisimpl(long r10) {
        if ((((int) r10) & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m1415isInNanosimpl(long r10) {
        if ((((int) r10) & 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m1416isInfiniteimpl(long r10) {
        if (r10 != INFINITE) goto L5;
    L8:
        return true;
    L5:
        if (r10 == NEG_INFINITE) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m1417isNegativeimpl(long r10) {
        if (r10 >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m1418isPositiveimpl(long r10) {
        if (r10 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m1419minusLRDsOJo(long r10, long r11) {
        return m1420plusLRDsOJo(r10, m1437unaryMinusUwyO8pc(r11));
    }

    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m1420plusLRDsOJo(long r10, long r11) {
        if (m1416isInfiniteimpl(r10) == false) goto L13;
        if (m1413isFiniteimpl(r11) == false) goto L7;
    L11:
        return r10;
    L7:
        if ((r11 ^ r10) >= 0) goto L11;
        throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
    L13:
        if (m1416isInfiniteimpl(r11) == false) goto L16;
        return r11;
    L16:
        if ((((int) r10) & 1) != (((int) r11) & 1)) goto L22;
        long r12 = m1411getValueimpl(r10) + m1411getValueimpl(r11);
        if (m1415isInNanosimpl(r10) == false) goto L27;
        return DurationKt.access$durationOfNanosNormalized(r12);
    L27:
        return DurationKt.access$durationOfMillisNormalized(r12);
    L22:
        if (m1414isInMillisimpl(r10) == false) goto L25;
        return m1380addValuesMixedRangesUwyO8pc(r10, m1411getValueimpl(r10), m1411getValueimpl(r11));
    L25:
        return m1380addValuesMixedRangesUwyO8pc(r10, m1411getValueimpl(r11), m1411getValueimpl(r10));
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m1421timesUwyO8pc(long r10, double r11) {
        int r12 = MathKt.roundToInt(r11);
        if (r12 != r11) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L8;
        DurationUnit r14 = m1409getStorageUnitimpl(r10);
        return DurationKt.toDuration(m1427toDoubleimpl(r10, r14) * r11, r14);
    L8:
        return m1422timesUwyO8pc(r10, r12);
    L5:
        r13 = false;
        goto L6
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m1422timesUwyO8pc(long r16, int r18) {
        if (m1416isInfiniteimpl(r16) == false) goto L11;
        if (r18 == 0) goto L10;
        if (r18 <= 0) goto L8;
        return r16;
    L8:
        return m1437unaryMinusUwyO8pc(r16);
    L10:
        throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
    L11:
        if (r18 == 0) goto L13;
        long r10 = m1411getValueimpl(r16);
        long r11 = r18;
        long r12 = r10 * r11;
        if (m1415isInNanosimpl(r16) == false) goto L31;
        if (new LongRange(-2147483647L, 2147483647L).contains(r10) == false) goto L20;
        return DurationKt.access$durationOfNanos(r12);
    L20:
        if ((r12 / r11) == r10) goto L41;
        long r13 = DurationKt.access$nanosToMillis(r10);
        long r14 = r13 * r11;
        long r15 = DurationKt.access$nanosToMillis((r10 - DurationKt.access$millisToNanos(r13)) * r11) + r14;
        if ((r14 / r11) != r13) goto L28;
        if ((r15 ^ r14) < 0) goto L28;
        long r17 = RangesKt.coerceIn(r15, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS));
    L42:
        return DurationKt.access$durationOfMillis(r17);
    L28:
        if ((MathKt.getSign(r10) * MathKt.getSign(r18)) > 0) goto L43;
    L38:
        return NEG_INFINITE;
    L43:
        return INFINITE;
    L41:
        return DurationKt.access$durationOfNanosNormalized(r12);
    L31:
        if ((r12 / r11) != r10) goto L35;
        r17 = RangesKt.coerceIn(r12, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS));
        goto L42
    L35:
        if ((MathKt.getSign(r10) * MathKt.getSign(r18)) <= 0) goto L38;
    L13:
        return ZERO;
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1423toComponentsimpl(long r10, Function2<? super Long, ? super Integer, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r11, "action");
        return r11.invoke(Long.valueOf(m1405getInWholeSecondsimpl(r10)), Integer.valueOf(m1407getNanosecondsComponentimpl(r10)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1424toComponentsimpl(long r10, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r11, "action");
        return r11.invoke(Long.valueOf(m1403getInWholeMinutesimpl(r10)), Integer.valueOf(m1408getSecondsComponentimpl(r10)), Integer.valueOf(m1407getNanosecondsComponentimpl(r10)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1425toComponentsimpl(long r10, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r11, "action");
        return r11.invoke(Long.valueOf(m1400getInWholeHoursimpl(r10)), Integer.valueOf(m1406getMinutesComponentimpl(r10)), Integer.valueOf(m1408getSecondsComponentimpl(r10)), Integer.valueOf(m1407getNanosecondsComponentimpl(r10)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1426toComponentsimpl(long r10, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r11, "action");
        return r11.invoke(Long.valueOf(m1399getInWholeDaysimpl(r10)), Integer.valueOf(m1391getHoursComponentimpl(r10)), Integer.valueOf(m1406getMinutesComponentimpl(r10)), Integer.valueOf(m1408getSecondsComponentimpl(r10)), Integer.valueOf(m1407getNanosecondsComponentimpl(r10)));
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m1427toDoubleimpl(long r10, DurationUnit r11) {
        Intrinsics.checkNotNullParameter(r11, Scraps.INNER_UNIT);
        if (r10 != INFINITE) goto L6;
        return Double.POSITIVE_INFINITY;
    L6:
        if (r10 != NEG_INFINITE) goto L9;
        return Double.NEGATIVE_INFINITY;
    L9:
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m1411getValueimpl(r10), m1409getStorageUnitimpl(r10), r11);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m1428toIntimpl(long r10, DurationUnit r11) {
        Intrinsics.checkNotNullParameter(r11, Scraps.INNER_UNIT);
        return (int) RangesKt.coerceIn(m1430toLongimpl(r10, r11), -2147483648L, 2147483647L);
    }

    /* JADX INFO: renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m1429toIsoStringimpl(long r11) {
        StringBuilder r10 = new StringBuilder();
        if (m1417isNegativeimpl(r11) == false) goto L5;
        r10.append('-');
    L5:
        r10.append("PT");
        long r12 = m1390getAbsoluteValueUwyO8pc(r11);
        long r13 = m1400getInWholeHoursimpl(r12);
        int r14 = m1406getMinutesComponentimpl(r12);
        int r15 = m1408getSecondsComponentimpl(r12);
        int r16 = m1407getNanosecondsComponentimpl(r12);
        if (m1416isInfiniteimpl(r11) == false) goto L8;
        r13 = 9999999999999L;
    L8:
        boolean r17 = true;
        if (r13 == 0) goto L11;
        boolean r18 = true;
    L12:
        if (r15 != 0) goto L16;
        if (r16 != 0) goto L16;
        boolean r19 = false;
    L17:
        if (r14 != 0) goto L22;
        if (r19 == false) goto L21;
        if (r18 == true) goto L22;
    L21:
        r17 = false;
    L22:
        if (r18 == false) goto L24;
        r10.append(r13);
        r10.append('H');
    L24:
        if (r17 == false) goto L26;
        r10.append(r14);
        r10.append('M');
    L26:
        if (r19 == true) goto L29;
        if (r18 == true) goto L30;
        if (r17 == false) goto L29;
    L30:
        String r110 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r110, "StringBuilder().apply(builderAction).toString()");
        return r110;
    L29:
        m1381appendFractionalimpl(r11, r10, r15, r16, 9, "S", true);
    L16:
        r19 = true;
        goto L17
    L11:
        r18 = false;
        goto L12
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m1430toLongimpl(long r10, DurationUnit r11) {
        Intrinsics.checkNotNullParameter(r11, Scraps.INNER_UNIT);
        if (r10 != INFINITE) goto L6;
        return Long.MAX_VALUE;
    L6:
        if (r10 != NEG_INFINITE) goto L9;
        return Long.MIN_VALUE;
    L9:
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m1411getValueimpl(r10), m1409getStorageUnitimpl(r10), r11);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    /* JADX INFO: renamed from: toLongMilliseconds-impl, reason: not valid java name */
    public static final /* synthetic */ long m1431toLongMillisecondsimpl(long r10) {
        return m1402getInWholeMillisecondsimpl(r10);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    /* JADX INFO: renamed from: toLongNanoseconds-impl, reason: not valid java name */
    public static final /* synthetic */ long m1432toLongNanosecondsimpl(long r10) {
        return m1404getInWholeNanosecondsimpl(r10);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1433toStringimpl(long r14) {
        if (r14 != 0) goto L6;
        return "0s";
    L6:
        if (r14 != INFINITE) goto L9;
        return "Infinity";
    L9:
        if (r14 != NEG_INFINITE) goto L11;
        return "-Infinity";
    L11:
        boolean r10 = m1417isNegativeimpl(r14);
        StringBuilder r11 = new StringBuilder();
        if (r10 == false) goto L14;
        r11.append('-');
    L14:
        long r12 = m1390getAbsoluteValueUwyO8pc(r14);
        long r13 = m1399getInWholeDaysimpl(r12);
        int r15 = m1391getHoursComponentimpl(r12);
        int r16 = m1406getMinutesComponentimpl(r12);
        int r17 = m1408getSecondsComponentimpl(r12);
        int r18 = m1407getNanosecondsComponentimpl(r12);
        int r19 = 0;
        if (r13 == 0) goto L17;
        boolean r20 = true;
    L18:
        if (r15 == 0) goto L20;
        boolean r21 = true;
    L21:
        if (r16 == 0) goto L23;
        boolean r22 = true;
    L24:
        if (r17 != 0) goto L28;
        if (r18 != 0) goto L28;
        boolean r110 = false;
    L29:
        if (r20 == false) goto L32;
        r11.append(r13);
        r11.append('d');
        r19 = 1;
    L32:
        if (r21 == true) goto L36;
        if (r20 == false) goto L40;
        if (r22 == true) goto L36;
        if (r110 == true) goto L36;
    L40:
        if (r22 == true) goto L44;
        if (r110 == false) goto L48;
        if (r21 == true) goto L44;
        if (r20 == true) goto L44;
    L48:
        if (r110 == false) goto L68;
        int r111 = r19 + 1;
        if (r19 <= 0) goto L52;
        r11.append(' ');
    L52:
        if (r17 != 0) goto L65;
        if (r20 == true) goto L65;
        if (r21 == true) goto L65;
        if (r22 == true) goto L65;
        if (r18 < 1000000) goto L62;
        int r23 = r18 / 1000000;
        int r24 = r18 % 1000000;
        int r25 = 6;
        boolean r112 = false;
        String r26 = "ms";
    L66:
        m1381appendFractionalimpl(r14, r11, r23, r24, r25, r26, r112);
    L67:
        r19 = r111;
        goto L68
    L62:
        if (r18 < 1000) goto L64;
        r23 = r18 / 1000;
        r24 = r18 % 1000;
        r25 = 3;
        r112 = false;
        r26 = "us";
        goto L66
    L64:
        r11.append(r18);
        r11.append("ns");
    L65:
        r25 = 9;
        r23 = r17;
        r24 = r18;
        r26 = "s";
        r112 = false;
    L68:
        if (r10 == false) goto L71;
        if (r19 <= 1) goto L71;
        r11.insert(1, '(').append(')');
    L71:
        String r113 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r113, "StringBuilder().apply(builderAction).toString()");
        return r113;
    L44:
        int r27 = r19 + 1;
        if (r19 <= 0) goto L47;
        r11.append(' ');
    L47:
        r11.append(r16);
        r11.append('m');
        r19 = r27;
    L36:
        int r28 = r19 + 1;
        if (r19 <= 0) goto L39;
        r11.append(' ');
    L39:
        r11.append(r15);
        r11.append('h');
        r19 = r28;
    L28:
        r110 = true;
        goto L29
    L23:
        r22 = false;
        goto L24
    L20:
        r21 = false;
        goto L21
    L17:
        r20 = false;
        goto L18
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static final String m1434toStringimpl(long r10, DurationUnit r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, Scraps.INNER_UNIT);
        if (r12 < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L14;
        double r14 = m1427toDoubleimpl(r10, r11);
        if (Double.isInfinite(r14) == false) goto L12;
        return String.valueOf(r14);
    L12:
        return DurationJvmKt.formatToExactDecimals(r14, RangesKt.coerceAtMost(r12, 12)) + DurationUnitKt__DurationUnitKt.shortName(r11);
    L14:
        throw new IllegalArgumentException(("decimals must be not negative, but was " + r12).toString());
    L5:
        r13 = false;
        goto L6
    }

    /* JADX INFO: renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ String m1435toStringimpl$default(long r10, DurationUnit r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        return m1434toStringimpl(r10, r11, r12);
    }

    /* JADX INFO: renamed from: truncateTo-UwyO8pc$kotlin_stdlib, reason: not valid java name */
    public static final long m1436truncateToUwyO8pc$kotlin_stdlib(long r10, DurationUnit r11) {
        Intrinsics.checkNotNullParameter(r11, Scraps.INNER_UNIT);
        DurationUnit r12 = m1409getStorageUnitimpl(r10);
        if (r11.compareTo(r12) > 0) goto L5;
        return r10;
    L5:
        if (m1416isInfiniteimpl(r10) == true) goto L10;
        long r13 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1, r11, r12);
        return DurationKt.toDuration(m1411getValueimpl(r10) - (m1411getValueimpl(r10) % r13), r12);
    L10:
        return r10;
    }

    /* JADX INFO: renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m1437unaryMinusUwyO8pc(long r10) {
        return DurationKt.access$durationOf(-m1411getValueimpl(r10), ((int) r10) & 1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration r10) {
        return m1438compareToLRDsOJo(r10.m1439unboximpl());
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m1438compareToLRDsOJo(long r10) {
        return m1383compareToLRDsOJo(this.rawValue, r10);
    }

    public boolean equals(Object r10) {
        return m1388equalsimpl(this.rawValue, r10);
    }

    public int hashCode() {
        return m1412hashCodeimpl(this.rawValue);
    }

    public String toString() {
        return m1433toStringimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1439unboximpl() {
        return this.rawValue;
    }
}
