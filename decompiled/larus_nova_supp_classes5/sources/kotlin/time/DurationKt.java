package kotlin.time;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010&\u001a\u0015\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a\u001d\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002¢\u0006\u0002\u00106\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0002\u001a)\u00108\u001a\u00020\u0005*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a)\u0010=\u001a\u000203*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a\u001c\u0010>\u001a\u00020\u0007*\u00020\b2\u0006\u0010?\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b@\u0010A\u001a\u001c\u0010>\u001a\u00020\u0007*\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\bB\u0010C\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\b2\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010G\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010H\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\u00012\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\r\u001a\u0004\b\u000b\u0010\u000e\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000e\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0010\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000e\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0010\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000e\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010\"\u001e\u0010 \u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"\u001e\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000e\"\u001e\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0010¨\u0006J"}, d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", "unit", "Lkotlin/time/DurationUnit;", "(DLkotlin/time/DurationUnit;)J", "(ILkotlin/time/DurationUnit;)J", "(JLkotlin/time/DurationUnit;)J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

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

    private static final long durationOfMillis(long r2) {
        return Duration.m396constructorimpl((r2 << 1) + 1);
    }

    private static final long durationOfMillisNormalized(long r6) {
        boolean r2 = false;
        if ((-4611686018426L) <= r6) goto L5;
    L7:
        if (r2 == false) goto L10;
        return durationOfNanos(millisToNanos(r6));
    L10:
        return durationOfMillis(RangesKt.coerceIn(r6, -4611686018427387903L, MAX_MILLIS));
    L5:
        if (r6 >= 4611686018427L) goto L7;
        r2 = true;
        goto L7
    }

    private static final long durationOfNanos(long r1) {
        return Duration.m396constructorimpl(r1 << 1);
    }

    private static final long durationOfNanosNormalized(long r4) {
        boolean r2 = false;
        if ((-4611686018426999999L) <= r4) goto L5;
    L7:
        if (r2 == false) goto L10;
        return durationOfNanos(r4);
    L10:
        return durationOfMillis(nanosToMillis(r4));
    L5:
        if (r4 >= 4611686018427000000L) goto L7;
        r2 = true;
        goto L7
    }

    public static final /* synthetic */ long getDays(double r1) {
        return toDuration(r1, DurationUnit.DAYS);
    }

    public static final /* synthetic */ long getHours(double r1) {
        return toDuration(r1, DurationUnit.HOURS);
    }

    public static final /* synthetic */ long getMicroseconds(double r1) {
        return toDuration(r1, DurationUnit.MICROSECONDS);
    }

    public static final /* synthetic */ long getMilliseconds(double r1) {
        return toDuration(r1, DurationUnit.MILLISECONDS);
    }

    public static final /* synthetic */ long getMinutes(double r1) {
        return toDuration(r1, DurationUnit.MINUTES);
    }

    public static final /* synthetic */ long getNanoseconds(double r1) {
        return toDuration(r1, DurationUnit.NANOSECONDS);
    }

    public static final /* synthetic */ long getSeconds(double r1) {
        return toDuration(r1, DurationUnit.SECONDS);
    }

    private static final long nanosToMillis(long r2) {
        return r2 / ((long) 1000000);
    }

    private static final long parseOverLongIsoComponent(String r7) {
        int r0 = r7.length();
        if (r0 > 0) goto L5;
    L7:
        int r5 = 0;
    L9:
        if ((r0 - r5) <= 16) goto L33;
        KMappedMarker r1 = new IntRange(r5, StringsKt.getLastIndex(r7));
        if ((r1 instanceof Collection) == true) goto L13;
    L15:
        Iterator r2 = r1.iterator();
    L17:
        if (r2.hasNext() == false) goto L14;
        char r6 = r7.charAt(((IntIterator) r2).nextInt());
        if ('0' <= r6) goto L21;
    L23:
        boolean r8 = false;
    L24:
        if (r8 == true) goto L17;
        boolean r3 = false;
    L26:
        if (r3 == false) goto L33;
        if (r7.charAt(0) != '-') goto L30;
        return Long.MIN_VALUE;
    L30:
        return LongCompanionObject.MAX_VALUE;
    L21:
        if (r6 >= ':') goto L23;
        r8 = true;
    L14:
        r3 = true;
        goto L26
    L13:
        if (((Collection) r1).isEmpty() == false) goto L15;
    L33:
        if (StringsKt.startsWith$default(r7, "+", false, 2, null) == false) goto L36;
        r7 = StringsKt.drop(r7, 1);
    L36:
        return CastLongProtector.parseLong(r7);
    L5:
        if (StringsKt.contains$default("+-", r7.charAt(0), false, 2, null) == false) goto L7;
        r5 = 1;
        goto L9
    }

    public static final /* synthetic */ long getDays(int r2) {
        return toDuration(r2, DurationUnit.DAYS);
    }

    public static final /* synthetic */ long getHours(int r2) {
        return toDuration(r2, DurationUnit.HOURS);
    }

    public static final /* synthetic */ long getMicroseconds(int r2) {
        return toDuration(r2, DurationUnit.MICROSECONDS);
    }

    public static final /* synthetic */ long getMilliseconds(int r2) {
        return toDuration(r2, DurationUnit.MILLISECONDS);
    }

    public static final /* synthetic */ long getMinutes(int r2) {
        return toDuration(r2, DurationUnit.MINUTES);
    }

    public static final /* synthetic */ long getNanoseconds(int r2) {
        return toDuration(r2, DurationUnit.NANOSECONDS);
    }

    public static final /* synthetic */ long getSeconds(int r2) {
        return toDuration(r2, DurationUnit.SECONDS);
    }

    public static final /* synthetic */ long getDays(long r1) {
        return toDuration(r1, DurationUnit.DAYS);
    }

    public static final /* synthetic */ long getHours(long r1) {
        return toDuration(r1, DurationUnit.HOURS);
    }

    public static final /* synthetic */ long getMicroseconds(long r1) {
        return toDuration(r1, DurationUnit.MICROSECONDS);
    }

    public static final /* synthetic */ long getMilliseconds(long r1) {
        return toDuration(r1, DurationUnit.MILLISECONDS);
    }

    public static final /* synthetic */ long getMinutes(long r1) {
        return toDuration(r1, DurationUnit.MINUTES);
    }

    public static final /* synthetic */ long getNanoseconds(long r1) {
        return toDuration(r1, DurationUnit.NANOSECONDS);
    }

    public static final /* synthetic */ long getSeconds(long r1) {
        return toDuration(r1, DurationUnit.SECONDS);
    }

    public static final /* synthetic */ long access$durationOf(long r0, int r2) {
        return durationOf(r0, r2);
    }

    public static final /* synthetic */ long access$parseDuration(String r0, boolean r1) {
        return parseDuration(r0, r1);
    }

    private static final long durationOf(long r2, int r4) {
        return Duration.m396constructorimpl((r2 << 1) + ((long) r4));
    }

    private static final long parseDuration(String r24, boolean r25) {
        int r7 = r24.length();
        if (r7 == 0) goto L170;
        Duration.Companion r8 = Duration.Companion;
        long r9 = r8.m499getZEROUwyO8pc();
        char r0 = r24.charAt(0);
        if (r0 != '+') goto L7;
    L6:
        int r13 = 1;
    L10:
        if (r13 <= 0) goto L12;
        boolean r14 = true;
    L14:
        if (r14 == true) goto L16;
    L18:
        boolean r16 = false;
    L20:
        if (r7 <= r13) goto L168;
        char r5 = ':';
        char r1 = '0';
        if (r24.charAt(r13) != 'P') goto L84;
        int r15 = r13 + 1;
        if (r15 == r7) goto L83;
        Enum r2 = null;
        boolean r3 = false;
    L26:
        if (r15 >= r7) goto L162;
        if (r24.charAt(r15) == 'T') goto L29;
        int r4 = r15;
    L37:
        if (r4 >= r24.length()) goto L53;
        char r10 = r24.charAt(r4);
        if (r1 > r10) goto L42;
        if (r10 >= r5) goto L42;
        boolean r17 = true;
    L43:
        if (r17 == true) goto L49;
        if (StringsKt.contains$default("+-.", r10, false, 2, null) == true) goto L49;
        boolean r6 = false;
    L50:
        if (r6 == false) goto L53;
        r4 = r4 + 1;
        r1 = '0';
        r5 = ':';
    L49:
        r6 = true;
    L42:
        r17 = false;
    L53:
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type java.lang.String");
        String r11 = r24.substring(r15, r4);
        if (r11.length() != 0) goto L56;
        boolean r12 = true;
    L57:
        if (r12 == true) goto L81;
        int r18 = r15 + r11.length();
        if (r18 >= 0) goto L61;
    L63:
        boolean r19 = false;
    L64:
        if (r19 == false) goto L79;
        char r20 = r24.charAt(r18);
        r15 = r18 + 1;
        Enum r21 = DurationUnitKt__DurationUnitKt.durationUnitByIsoChar(r20, r3);
        if (r2 != null) goto L68;
    L72:
        int r22 = StringsKt.indexOf$default(r11, '.', 0, false, 6, null);
        if (r21 != DurationUnit.SECONDS) goto L76;
        if (r22 <= 0) goto L76;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.String");
        long r23 = Duration.m432plusLRDsOJo(r9, toDuration(parseOverLongIsoComponent(r11.substring(0, r22)), r21));
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.String");
        r9 = Duration.m432plusLRDsOJo(r23, toDuration(CastDoubleProtector.parseDouble(r11.substring(r22)), r21));
    L77:
        r3 = r3;
        r2 = r21;
        r1 = '0';
        r5 = ':';
    L76:
        r9 = Duration.m432plusLRDsOJo(r9, toDuration(parseOverLongIsoComponent(r11), r21));
        goto L77
    L68:
        if (r2.compareTo(r21) > 0) goto L72;
        throw new IllegalArgumentException("Unexpected order of duration components");
    L79:
        throw new IllegalArgumentException("Missing unit for value ".concat(r11));
    L61:
        if (r18 >= r24.length()) goto L63;
        r19 = true;
        goto L64
    L81:
        throw new IllegalArgumentException();
    L56:
        r12 = false;
        goto L57
    L29:
        if (r3 == true) goto L34;
        r15 = r15 + 1;
        if (r15 == r7) goto L34;
        r3 = true;
    L34:
        throw new IllegalArgumentException();
    L162:
        if (r16 == true) goto L164;
        return r9;
    L164:
        return Duration.m449unaryMinusUwyO8pc(r9);
    L83:
        throw new IllegalArgumentException();
    L84:
        if (r25 == true) goto L166;
        if (StringsKt.regionMatches(r24, r13, "Infinity", 0, Math.max(r7 - r13, 8), true) == false) goto L88;
        r9 = r8.m497getINFINITEUwyO8pc();
        goto L162
    L88:
        boolean r26 = !r14;
        if (r14 == true) goto L91;
    L99:
        Enum r27 = null;
        boolean r28 = false;
    L100:
        if (r13 >= r7) goto L162;
        if (r28 == false) goto L111;
        if (r26 == false) goto L111;
    L104:
        if (r13 >= r24.length()) goto L111;
        if (r24.charAt(r13) != ' ') goto L108;
        boolean r29 = true;
    L109:
        if (r29 == false) goto L111;
        r13 = r13 + 1;
        goto L104
    L108:
        r29 = false;
    L111:
        int r30 = r13;
    L113:
        if (r30 >= r24.length()) goto L128;
        char r31 = r24.charAt(r30);
        if ('0' > r31) goto L118;
        if (r31 >= ':') goto L118;
        boolean r32 = true;
    L119:
        if (r32 == false) goto L121;
    L124:
        boolean r33 = true;
    L125:
        if (r33 == false) goto L128;
        r30 = r30 + 1;
        goto L113
    L121:
        if (r31 == '.') goto L124;
        r33 = false;
    L118:
        r32 = false;
    L128:
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type java.lang.String");
        String r34 = r24.substring(r13, r30);
        if (r34.length() != 0) goto L131;
        boolean r35 = true;
    L132:
        if (r35 == true) goto L161;
        int r110 = r13 + r34.length();
        int r36 = r110;
    L135:
        if (r36 >= r24.length()) goto L144;
        char r37 = r24.charAt(r36);
        if ('a' <= r37) goto L139;
    L141:
        boolean r38 = false;
    L142:
        if (r38 == false) goto L144;
        r36 = r36 + 1;
        goto L135
    L139:
        if (r37 >= '{') goto L141;
        r38 = true;
    L144:
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type java.lang.String");
        String r39 = r24.substring(r110, r36);
        r13 = r110 + r39.length();
        Enum r40 = DurationUnitKt__DurationUnitKt.durationUnitByShortName(r39);
        if (r27 != null) goto L147;
    L151:
        int r41 = StringsKt.indexOf$default(r34, '.', 0, false, 6, null);
        if (r41 <= 0) goto L158;
        Intrinsics.checkNotNull(r34, "null cannot be cast to non-null type java.lang.String");
        long r42 = Duration.m432plusLRDsOJo(r9, toDuration(CastLongProtector.parseLong(r34.substring(0, r41)), r40));
        Intrinsics.checkNotNull(r34, "null cannot be cast to non-null type java.lang.String");
        r9 = Duration.m432plusLRDsOJo(r42, toDuration(CastDoubleProtector.parseDouble(r34.substring(r41)), r40));
        if (r13 >= r7) goto L159;
        throw new IllegalArgumentException("Fractional component must be last");
    L159:
        r27 = r40;
        r28 = true;
        goto L100
    L158:
        r9 = Duration.m432plusLRDsOJo(r9, toDuration(CastLongProtector.parseLong(r34), r40));
        goto L159
    L147:
        if (r27.compareTo(r40) > 0) goto L151;
        throw new IllegalArgumentException("Unexpected order of duration components");
    L161:
        throw new IllegalArgumentException();
    L131:
        r35 = false;
        goto L132
    L91:
        if (r24.charAt(r13) != '(') goto L99;
        if (StringsKt.last(r24) != ')') goto L99;
        r13 = r13 + 1;
        r7 = r7 - 1;
        if (r13 == r7) goto L98;
        r26 = true;
        goto L99
    L98:
        throw new IllegalArgumentException("No components");
    L166:
        throw new IllegalArgumentException();
    L168:
        throw new IllegalArgumentException("No components");
    L16:
        if (StringsKt.startsWith$default(r24, '-', false, 2, null) == false) goto L18;
        r16 = true;
        goto L20
    L12:
        r14 = false;
        goto L14
    L7:
        if (r0 == '-') goto L6;
        r13 = 0;
        goto L10
    L170:
        throw new IllegalArgumentException("The string is empty");
    }

    /* JADX INFO: renamed from: times-kIfJnKk, reason: not valid java name */
    private static final long m522timeskIfJnKk(double r0, long r2) {
        return Duration.m433timesUwyO8pc(r2, r0);
    }

    /* JADX INFO: renamed from: times-mvk6XK0, reason: not valid java name */
    private static final long m523timesmvk6XK0(int r0, long r1) {
        return Duration.m434timesUwyO8pc(r1, r0);
    }

    public static final long toDuration(double r7, DurationUnit r9) {
        Intrinsics.checkNotNullParameter(r9, "unit");
        double r0 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r7, r9, DurationUnit.NANOSECONDS);
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
        return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r7, r9, DurationUnit.MILLISECONDS)));
    L7:
        if (r1 >= 4611686018427000000L) goto L9;
    L15:
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    public static final long toDuration(long r7, DurationUnit r9) {
        Intrinsics.checkNotNullParameter(r9, "unit");
        DurationUnit r0 = DurationUnit.NANOSECONDS;
        long r1 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(MAX_NANOS, r0, r9);
        boolean r5 = false;
        if ((-r1) <= r7) goto L5;
    L7:
        if (r5 == false) goto L11;
        return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(r7, r9, r0));
    L11:
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r7, r9, DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS));
    L5:
        if (r7 > r1) goto L7;
        r5 = true;
        goto L7
    }

    public static final long toDuration(int r2, DurationUnit r3) {
        Intrinsics.checkNotNullParameter(r3, "unit");
        if (r3.compareTo(DurationUnit.SECONDS) > 0) goto L6;
        return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(r2, r3, DurationUnit.NANOSECONDS));
    L6:
        return toDuration(r2, r3);
    }

    private static final int skipWhile(String r1, int r2, Function1<? super Character, Boolean> r3) {
    L3:
        if (r2 >= r1.length()) goto L7;
        if (((Boolean) r3.invoke(Character.valueOf(r1.charAt(r2)))).booleanValue() == false) goto L7;
        r2 = r2 + 1;
    L7:
        return r2;
    }

    private static final String substringWhile(String r2, int r3, Function1<? super Character, Boolean> r4) {
        int r0 = r3;
    L4:
        if (r0 >= r2.length()) goto L8;
        if (((Boolean) r4.invoke(Character.valueOf(r2.charAt(r0)))).booleanValue() == false) goto L8;
        r0 = r0 + 1;
    L8:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.String");
        return r2.substring(r3, r0);
    }
}
