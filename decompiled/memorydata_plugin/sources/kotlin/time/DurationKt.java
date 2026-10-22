package kotlin.time;

import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010&\u001a\u0015\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a\u001d\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002¢\u0006\u0002\u00106\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0002\u001a)\u00108\u001a\u00020\u0005*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a)\u0010=\u001a\u000203*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a\u001c\u0010>\u001a\u00020\u0007*\u00020\b2\u0006\u0010?\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b@\u0010A\u001a\u001c\u0010>\u001a\u00020\u0007*\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\bB\u0010C\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\b2\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010G\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010H\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\u00012\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\r\u001a\u0004\b\u000b\u0010\u000e\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000e\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0010\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000e\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0010\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000e\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010\"\u001e\u0010 \u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"\u001e\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000e\"\u001e\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0010¨\u0006J"}, d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", EventBody.KEY_VALUE, "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", Scraps.INNER_UNIT, "Lkotlin/time/DurationUnit;", "(DLkotlin/time/DurationUnit;)J", "(ILkotlin/time/DurationUnit;)J", "(JLkotlin/time/DurationUnit;)J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    public static final /* synthetic */ long access$durationOf(long r0, int r2) {
        return durationOf(r0, r2);
    }

    public static final /* synthetic */ long access$durationOfMillis(long r0) {
        return durationOfMillis(r0);
    }

    public static final /* synthetic */ long access$durationOfMillisNormalized(long r0) {
        return durationOfMillisNormalized(r0);
    }

    public static final /* synthetic */ long access$durationOfNanos(long r0) {
        return durationOfNanos(r0);
    }

    public static final /* synthetic */ long access$durationOfNanosNormalized(long r0) {
        return durationOfNanosNormalized(r0);
    }

    public static final /* synthetic */ long access$millisToNanos(long r0) {
        return millisToNanos(r0);
    }

    public static final /* synthetic */ long access$nanosToMillis(long r0) {
        return nanosToMillis(r0);
    }

    public static final /* synthetic */ long access$parseDuration(String r0, boolean r1) {
        return parseDuration(r0, r1);
    }

    private static final long durationOf(long r2, int r4) {
        return Duration.m2747constructorimpl((r2 << 1) + ((long) r4));
    }

    private static final long durationOfMillis(long r2) {
        return Duration.m2747constructorimpl((r2 << 1) + 1);
    }

    private static final long durationOfMillisNormalized(long r6) {
        boolean r1 = false;
        if ((-4611686018426L) <= r6) goto L5;
    L7:
        if (r1 == false) goto L10;
        return durationOfNanos(millisToNanos(r6));
    L10:
        return durationOfMillis(RangesKt.coerceIn(r6, -4611686018427387903L, MAX_MILLIS));
    L5:
        if (r6 >= 4611686018427L) goto L7;
        r1 = true;
        goto L7
    }

    private static final long durationOfNanos(long r1) {
        return Duration.m2747constructorimpl(r1 << 1);
    }

    private static final long durationOfNanosNormalized(long r4) {
        boolean r1 = false;
        if ((-4611686018426999999L) <= r4) goto L5;
    L7:
        if (r1 == false) goto L10;
        return durationOfNanos(r4);
    L10:
        return durationOfMillis(nanosToMillis(r4));
    L5:
        if (r4 >= 4611686018427000000L) goto L7;
        r1 = true;
        goto L7
    }

    public static final /* synthetic */ long getDays(double r1) {
        return toDuration(r1, DurationUnit.DAYS);
    }

    public static final /* synthetic */ long getDays(int r2) {
        return toDuration(r2, DurationUnit.DAYS);
    }

    public static final /* synthetic */ long getDays(long r1) {
        return toDuration(r1, DurationUnit.DAYS);
    }

    @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(long r0) {
    }

    public static final /* synthetic */ long getHours(double r1) {
        return toDuration(r1, DurationUnit.HOURS);
    }

    public static final /* synthetic */ long getHours(int r2) {
        return toDuration(r2, DurationUnit.HOURS);
    }

    public static final /* synthetic */ long getHours(long r1) {
        return toDuration(r1, DurationUnit.HOURS);
    }

    @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(long r0) {
    }

    public static final /* synthetic */ long getMicroseconds(double r1) {
        return toDuration(r1, DurationUnit.MICROSECONDS);
    }

    public static final /* synthetic */ long getMicroseconds(int r2) {
        return toDuration(r2, DurationUnit.MICROSECONDS);
    }

    public static final /* synthetic */ long getMicroseconds(long r1) {
        return toDuration(r1, DurationUnit.MICROSECONDS);
    }

    @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(long r0) {
    }

    public static final /* synthetic */ long getMilliseconds(double r1) {
        return toDuration(r1, DurationUnit.MILLISECONDS);
    }

    public static final /* synthetic */ long getMilliseconds(int r2) {
        return toDuration(r2, DurationUnit.MILLISECONDS);
    }

    public static final /* synthetic */ long getMilliseconds(long r1) {
        return toDuration(r1, DurationUnit.MILLISECONDS);
    }

    @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(long r0) {
    }

    public static final /* synthetic */ long getMinutes(double r1) {
        return toDuration(r1, DurationUnit.MINUTES);
    }

    public static final /* synthetic */ long getMinutes(int r2) {
        return toDuration(r2, DurationUnit.MINUTES);
    }

    public static final /* synthetic */ long getMinutes(long r1) {
        return toDuration(r1, DurationUnit.MINUTES);
    }

    @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(long r0) {
    }

    public static final /* synthetic */ long getNanoseconds(double r1) {
        return toDuration(r1, DurationUnit.NANOSECONDS);
    }

    public static final /* synthetic */ long getNanoseconds(int r2) {
        return toDuration(r2, DurationUnit.NANOSECONDS);
    }

    public static final /* synthetic */ long getNanoseconds(long r1) {
        return toDuration(r1, DurationUnit.NANOSECONDS);
    }

    @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(long r0) {
    }

    public static final /* synthetic */ long getSeconds(double r1) {
        return toDuration(r1, DurationUnit.SECONDS);
    }

    public static final /* synthetic */ long getSeconds(int r2) {
        return toDuration(r2, DurationUnit.SECONDS);
    }

    public static final /* synthetic */ long getSeconds(long r1) {
        return toDuration(r1, DurationUnit.SECONDS);
    }

    @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(long r0) {
    }

    private static final long millisToNanos(long r2) {
        return r2 * ((long) 1000000);
    }

    private static final long nanosToMillis(long r2) {
        return r2 / ((long) 1000000);
    }

    private static final long parseDuration(String r25, boolean r26) {
        String r6 = r25;
        int r7 = r25.length();
        if (r7 == 0) goto L173;
        long r8 = Duration.Companion.m2850getZEROUwyO8pc();
        char r0 = r6.charAt(0);
        if (r0 != '+') goto L7;
    L6:
        int r12 = 1;
    L10:
        if (r12 <= 0) goto L12;
        boolean r13 = true;
    L13:
        Object r14 = null;
        String r15 = "com.obric.memorydata.plugin";
        if (r13 == true) goto L16;
    L18:
        boolean r16 = false;
    L20:
        if (r7 <= r12) goto L171;
        char r3 = ':';
        char r5 = '0';
        if (r6.charAt(r12) != 'P') goto L85;
        int r17 = r12 + 1;
        if (r17 == r7) goto L83;
        DurationUnit r2 = null;
        boolean r1 = false;
    L26:
        if (r17 >= r7) goto L165;
        if (r6.charAt(r17) == 'T') goto L29;
        int r11 = r17;
    L37:
        if (r11 >= r25.length()) goto L52;
        char r18 = r6.charAt(r11);
        if (r5 > r18) goto L42;
        if (r18 >= r3) goto L42;
        boolean r19 = true;
    L43:
        if (r19 == true) goto L48;
        int r110 = r7;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast("+-.", CharSequence.class, r15), r18, false, 2, r14) == true) goto L49;
        boolean r4 = false;
    L50:
        if (r4 == false) goto L53;
        r11 = r11 + 1;
        r7 = r110;
        r3 = ':';
        r5 = '0';
    L53:
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.lang.String");
        String r9 = r6.substring(r17, r11);
        Intrinsics.checkNotNullExpressionValue(r9, "substring(...)");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, r15)).length() != 0) goto L56;
        boolean r10 = true;
    L57:
        if (r10 == true) goto L81;
        int r111 = r17 + r9.length();
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, r15);
        if (r111 >= 0) goto L61;
    L63:
        boolean r112 = false;
    L64:
        if (r112 == false) goto L79;
        char r21 = r20.charAt(r111);
        r17 = r111 + 1;
        DurationUnit r22 = DurationUnitKt.durationUnitByIsoChar(r21, r1);
        if (r2 != null) goto L68;
    L72:
        int r23 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, r15), '.', 0, false, 6, null);
        if (r22 != DurationUnit.SECONDS) goto L76;
        if (r23 <= 0) goto L76;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type java.lang.String");
        String r113 = r9.substring(0, r23);
        Intrinsics.checkNotNullExpressionValue(r113, "substring(...)");
        r8 = Duration.m2783plusLRDsOJo(r8, toDuration(parseOverLongIsoComponent(r113), r22));
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type java.lang.String");
        String r24 = r9.substring(r23);
        Intrinsics.checkNotNullExpressionValue(r24, "substring(...)");
        long r27 = toDuration(Double.parseDouble(r24), r22);
    L77:
        r8 = Duration.m2783plusLRDsOJo(r8, r27);
        r2 = r22;
        r7 = r110;
        r15 = r15;
        r3 = ':';
        r5 = '0';
        r14 = null;
    L76:
        r27 = toDuration(parseOverLongIsoComponent(r9), r22);
        goto L77
    L68:
        if (r2.compareTo((Enum) ZeusTransformUtils.preCheckCast(r22, Enum.class, r15)) > 0) goto L72;
        throw new IllegalArgumentException("Unexpected order of duration components");
    L79:
        throw new IllegalArgumentException("Missing unit for value " + r9);
    L61:
        if (r111 >= r20.length()) goto L63;
        r112 = true;
        goto L64
    L81:
        throw new IllegalArgumentException();
    L56:
        r10 = false;
    L49:
        r4 = true;
        goto L50
    L48:
        r110 = r7;
    L42:
        r19 = false;
        goto L43
    L52:
        r110 = r7;
        goto L53
    L29:
        if (r1 == true) goto L34;
        r17 = r17 + 1;
        if (r17 == r7) goto L34;
        r1 = true;
    L34:
        throw new IllegalArgumentException();
    L165:
        if (r16 == true) goto L167;
        return r8;
    L167:
        return Duration.m2800unaryMinusUwyO8pc(r8);
    L83:
        throw new IllegalArgumentException();
    L85:
        if (r26 == true) goto L169;
        if (StringsKt.regionMatches(r25, r12, "Infinity", 0, Math.max(r7 - r12, 8), true) == false) goto L89;
        r8 = Duration.Companion.m2848getINFINITEUwyO8pc();
        goto L165
    L89:
        boolean r28 = !r13;
        if (r13 == true) goto L92;
    L100:
        String r29 = "com.obric.memorydata.plugin";
    L101:
        int r30 = r7;
    L102:
        boolean r31 = false;
        DurationUnit r32 = null;
    L103:
        if (r12 >= r30) goto L165;
        if (r31 == false) goto L114;
        if (r28 == false) goto L114;
    L107:
        if (r12 >= r25.length()) goto L114;
        if (r6.charAt(r12) != ' ') goto L111;
        boolean r33 = true;
    L112:
        if (r33 == false) goto L114;
        r12 = r12 + 1;
        goto L107
    L111:
        r33 = false;
    L114:
        int r34 = r12;
    L116:
        if (r34 >= r25.length()) goto L131;
        char r35 = r6.charAt(r34);
        if ('0' > r35) goto L121;
        if (r35 >= ':') goto L121;
        boolean r114 = true;
    L122:
        if (r114 == false) goto L124;
    L127:
        boolean r36 = true;
    L128:
        if (r36 == false) goto L131;
        r34 = r34 + 1;
        goto L116
    L124:
        if (r35 == '.') goto L127;
        r36 = false;
    L121:
        r114 = false;
    L131:
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.lang.String");
        String r37 = r6.substring(r12, r34);
        Intrinsics.checkNotNullExpressionValue(r37, "substring(...)");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r37, CharSequence.class, r29)).length() != 0) goto L134;
        boolean r38 = true;
    L135:
        if (r38 == true) goto L164;
        int r115 = r12 + r37.length();
        int r39 = r115;
    L138:
        if (r39 >= r25.length()) goto L147;
        char r116 = r6.charAt(r39);
        if ('a' <= r116) goto L142;
    L144:
        boolean r40 = false;
    L145:
        if (r40 == false) goto L147;
        r39 = r39 + 1;
        goto L138
    L142:
        if (r116 >= '{') goto L144;
        r40 = true;
    L147:
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.lang.String");
        String r41 = r6.substring(r115, r39);
        Intrinsics.checkNotNullExpressionValue(r41, "substring(...)");
        r12 = r115 + r41.length();
        DurationUnit r42 = DurationUnitKt.durationUnitByShortName(r41);
        if (r32 != null) goto L150;
    L154:
        int r43 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r37, CharSequence.class, r29), '.', 0, false, 6, null);
        if (r43 <= 0) goto L161;
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type java.lang.String");
        String r117 = r37.substring(0, r43);
        Intrinsics.checkNotNullExpressionValue(r117, "substring(...)");
        long r44 = Duration.m2783plusLRDsOJo(r8, toDuration(Long.parseLong(r117), r42));
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type java.lang.String");
        String r45 = r37.substring(r43);
        Intrinsics.checkNotNullExpressionValue(r45, "substring(...)");
        r8 = Duration.m2783plusLRDsOJo(r44, toDuration(Double.parseDouble(r45), r42));
        if (r12 >= r30) goto L162;
        throw new IllegalArgumentException("Fractional component must be last");
    L162:
        r31 = true;
        r6 = r25;
        r32 = r42;
        goto L103
    L161:
        r8 = Duration.m2783plusLRDsOJo(r8, toDuration(Long.parseLong(r37), r42));
        goto L162
    L150:
        if (r32.compareTo((Enum) ZeusTransformUtils.preCheckCast(r42, Enum.class, r29)) > 0) goto L154;
        throw new IllegalArgumentException("Unexpected order of duration components");
    L164:
        throw new IllegalArgumentException();
    L134:
        r38 = false;
        goto L135
    L92:
        if (r6.charAt(r12) != '(') goto L100;
        r29 = "com.obric.memorydata.plugin";
        if (StringsKt.last((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, r29)) != ')') goto L101;
        r12 = r12 + 1;
        r30 = r7 - 1;
        if (r12 == r30) goto L99;
        r28 = true;
        goto L102
    L99:
        throw new IllegalArgumentException("No components");
    L169:
        throw new IllegalArgumentException();
    L171:
        throw new IllegalArgumentException("No components");
    L16:
        if (StringsKt.startsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), '-', false, 2, null) == false) goto L18;
        r16 = true;
        goto L20
    L12:
        r13 = false;
        goto L13
    L7:
        if (r0 == '-') goto L6;
        r12 = 0;
        goto L10
    L173:
        throw new IllegalArgumentException("The string is empty");
    }

    private static final long parseOverLongIsoComponent(String r8) {
        int r0 = r8.length();
        if (r0 > 0) goto L5;
    L7:
        int r6 = 0;
    L9:
        if ((r0 - r6) <= 16) goto L33;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(new IntRange(r6, StringsKt.getLastIndex((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L13;
    L15:
        Iterator r2 = r1.iterator();
    L17:
        if (r2.hasNext() == false) goto L14;
        char r7 = r8.charAt(((IntIterator) ZeusTransformUtils.preCheckCast(r2, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if ('0' <= r7) goto L21;
    L23:
        boolean r9 = false;
    L24:
        if (r9 == true) goto L17;
        boolean r3 = false;
    L26:
        if (r3 == false) goto L33;
        if (r8.charAt(0) != '-') goto L30;
        return Long.MIN_VALUE;
    L30:
        return Long.MAX_VALUE;
    L21:
        if (r7 >= ':') goto L23;
        r9 = true;
    L14:
        r3 = true;
        goto L26
    L13:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L15;
    L33:
        if (StringsKt.startsWith$default(r8, Marker.ANY_NON_NULL_MARKER, false, 2, null) == false) goto L36;
        r8 = StringsKt.drop(r8, 1);
    L36:
        return Long.parseLong(r8);
    L5:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast("+-", CharSequence.class, "com.obric.memorydata.plugin"), r8.charAt(0), false, 2, null) == false) goto L7;
        r6 = 1;
        goto L9
    }

    private static final int skipWhile(String r3, int r4, Function1<? super Character, Boolean> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
    L4:
        if (r4 >= r3.length()) goto L8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6.invoke(Character.valueOf(r3.charAt(r4))), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L8;
        r4 = r4 + 1;
    L8:
        return r4;
    }

    private static final String substringWhile(String r4, int r5, Function1<? super Character, Boolean> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r5;
    L4:
        if (r0 >= r4.length()) goto L8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(Character.valueOf(r4.charAt(r0))), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L8;
        r0 = r0 + 1;
    L8:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.lang.String");
        String r8 = r4.substring(r5, r0);
        Intrinsics.checkNotNullExpressionValue(r8, "substring(...)");
        return r8;
    }

    /* JADX INFO: renamed from: times-kIfJnKk, reason: not valid java name */
    private static final long m2873timeskIfJnKk(double r0, long r2) {
        return Duration.m2784timesUwyO8pc(r2, r0);
    }

    /* JADX INFO: renamed from: times-mvk6XK0, reason: not valid java name */
    private static final long m2874timesmvk6XK0(int r0, long r1) {
        return Duration.m2785timesUwyO8pc(r1, r0);
    }

    public static final long toDuration(double r7, DurationUnit r9) {
        Intrinsics.checkNotNullParameter(r9, Scraps.INNER_UNIT);
        double r0 = DurationUnitKt.convertDurationUnit(r7, r9, DurationUnit.NANOSECONDS);
        boolean r3 = true;
        if ((!Double.isNaN(r0)) == false) goto L15;
        long r1 = MathKt.roundToLong(r0);
        if ((-4611686018426999999L) <= r1) goto L7;
    L9:
        r3 = false;
    L10:
        if (r3 == false) goto L13;
        return durationOfNanos(r1);
    L13:
        return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt.convertDurationUnit(r7, r9, DurationUnit.MILLISECONDS)));
    L7:
        if (r1 >= 4611686018427000000L) goto L9;
    L15:
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    public static final long toDuration(int r3, DurationUnit r4) {
        Intrinsics.checkNotNullParameter(r4, Scraps.INNER_UNIT);
        if (r4.compareTo((Enum) ZeusTransformUtils.preCheckCast(DurationUnit.SECONDS, Enum.class, "com.obric.memorydata.plugin")) > 0) goto L6;
        return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(r3, r4, DurationUnit.NANOSECONDS));
    L6:
        return toDuration(r3, r4);
    }

    public static final long toDuration(long r7, DurationUnit r9) {
        Intrinsics.checkNotNullParameter(r9, Scraps.INNER_UNIT);
        long r0 = DurationUnitKt.convertDurationUnitOverflow(MAX_NANOS, DurationUnit.NANOSECONDS, r9);
        boolean r3 = false;
        if ((-r0) <= r7) goto L5;
    L7:
        if (r3 == false) goto L11;
        return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(r7, r9, DurationUnit.NANOSECONDS));
    L11:
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt.convertDurationUnit(r7, r9, DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS));
    L5:
        if (r7 > r0) goto L7;
        r3 = true;
        goto L7
    }
}
