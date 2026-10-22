package kotlin.time;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
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
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.6")
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087@\u0018\u0000 ¦\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¦\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u0018\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\bK\u0010LJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010QJ\u0018\u0010M\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\bR\u0010SJ\u001a\u0010T\u001a\u00020U2\b\u0010J\u001a\u0004\u0018\u00010VHÖ\u0003¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\tHÖ\u0001¢\u0006\u0004\bZ\u0010\rJ\r\u0010[\u001a\u00020U¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020UH\u0002¢\u0006\u0004\b_\u0010]J\u000f\u0010`\u001a\u00020UH\u0002¢\u0006\u0004\ba\u0010]J\r\u0010b\u001a\u00020U¢\u0006\u0004\bc\u0010]J\r\u0010d\u001a\u00020U¢\u0006\u0004\be\u0010]J\r\u0010f\u001a\u00020U¢\u0006\u0004\bg\u0010]J\u0018\u0010h\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\bi\u0010jJ\u0018\u0010k\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\bl\u0010jJ\u001b\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010PJ\u001b\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010QJ\u009d\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2u\u0010q\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(u\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0rH\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010{J\u0088\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2`\u0010q\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0|H\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010}Js\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2K\u0010q\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0~H\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010\u007fJ`\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p27\u0010q\u001a3\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0\u0080\u0001H\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0005\bz\u0010\u0081\u0001J\u0019\u0010\u0082\u0001\u001a\u00020\u000f2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0011\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0019\u0010\u008d\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0011\u0010\u0090\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0091\u0001\u0010\u0005J\u0011\u0010\u0092\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0093\u0001\u0010\u0005J\u0013\u0010\u0094\u0001\u001a\u00030\u008a\u0001H\u0016¢\u0006\u0006\b\u0095\u0001\u0010\u008c\u0001J%\u0010\u0094\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u0083\u0001\u001a\u00020=2\t\b\u0002\u0010\u0096\u0001\u001a\u00020\t¢\u0006\u0006\b\u0095\u0001\u0010\u0097\u0001J\u001e\u0010\u0098\u0001\u001a\u00020\u00002\u0007\u0010\u0083\u0001\u001a\u00020=H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0099\u0001\u0010\u008f\u0001J\u0015\u0010\u009a\u0001\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0005\b\u009b\u0001\u0010\u0005JK\u0010\u009c\u0001\u001a\u00030\u009d\u0001*\b0\u009e\u0001j\u0003`\u009f\u00012\u0007\u0010 \u0001\u001a\u00020\t2\u0007\u0010¡\u0001\u001a\u00020\t2\u0007\u0010¢\u0001\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u008a\u00012\u0007\u0010£\u0001\u001a\u00020UH\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001R\u0014\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u0011\u0010%\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010\u0005R\u0011\u0010)\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b*\u0010\u0005R\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u0005R\u0011\u0010-\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010\u0005R\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u0005R\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\u0005R\u001a\u00103\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\rR\u001a\u00106\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\rR\u0014\u0010<\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0015\u0010@\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\rR\u0014\u0010B\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006§\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "times", "times-UwyO8pc", "toComponents", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "truncateTo", "truncateTo-UwyO8pc$kotlin_stdlib", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalTime.class})
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1494:1\n38#1:1495\n38#1:1496\n38#1:1497\n38#1:1498\n38#1:1499\n683#1,2:1500\n700#1,2:1509\n170#2,6:1502\n1#3:1508\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n*L\n39#1:1495\n40#1:1496\n458#1:1497\n478#1:1498\n662#1:1499\n979#1:1500,2\n1070#1:1509,2\n1021#1:1502,6\n*E\n"})
public final class Duration implements Comparable<Duration> {
    public static final Companion Companion = null;
    private static final long INFINITE = 0;
    private static final long NEG_INFINITE = 0;
    private static final long ZERO = 0;
    private final long rawValue;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0007J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0011J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0014J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0011J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0011J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0014J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0017J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0011J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0014J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0017J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0011J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0014J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0017J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0011J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0014J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0017J\u0018\u00105\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u0018\u00109\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0004\b:\u00108J\u0018\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0002\b<J\u0018\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0002\b>J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0011J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0014J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0016\u0010\n\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\"\u0010\f\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\f\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014R\"\u0010\f\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R\"\u0010\u0018\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\"\u0010\u0018\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0014R\"\u0010\u0018\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\"\u0010\u001b\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0014R\"\u0010\u001b\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R\"\u0010\u001e\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0014R\"\u0010\u001e\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0017R\"\u0010!\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\"\u0010!\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0014R\"\u0010!\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0017R\"\u0010$\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010\u0011R\"\u0010$\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0014R\"\u0010$\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0017R\"\u0010'\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011R\"\u0010'\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0014R\"\u0010'\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0017\u0082\u0002\u0004\n\u0002\b!¨\u0006@"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "days", "", "getDays-UwyO8pc$annotations", "(D)V", "getDays-UwyO8pc", "(D)J", "", "(I)V", "(I)J", "", "(J)V", "(J)J", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "nanoseconds", "getNanoseconds-UwyO8pc$annotations", "getNanoseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "convert", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "days-UwyO8pc", "hours-UwyO8pc", "microseconds-UwyO8pc", "milliseconds-UwyO8pc", "minutes-UwyO8pc", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1520getDaysUwyO8pc(int r5) {
            return DurationKt.toDuration(r5, DurationUnit.DAYS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1522getDaysUwyO8pc$annotations(double r5) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1526getHoursUwyO8pc(int r5) {
            return DurationKt.toDuration(r5, DurationUnit.HOURS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1528getHoursUwyO8pc$annotations(double r5) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1532getMicrosecondsUwyO8pc(int r5) {
            return DurationKt.toDuration(r5, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1534getMicrosecondsUwyO8pc$annotations(double r5) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1538getMillisecondsUwyO8pc(int r5) {
            return DurationKt.toDuration(r5, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1540getMillisecondsUwyO8pc$annotations(double r5) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1544getMinutesUwyO8pc(int r5) {
            return DurationKt.toDuration(r5, DurationUnit.MINUTES);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1546getMinutesUwyO8pc$annotations(double r5) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1550getNanosecondsUwyO8pc(int r5) {
            return DurationKt.toDuration(r5, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1552getNanosecondsUwyO8pc$annotations(double r5) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1556getSecondsUwyO8pc(int r5) {
            return DurationKt.toDuration(r5, DurationUnit.SECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1558getSecondsUwyO8pc$annotations(double r5) {
        }

        @ExperimentalTime
        public final double convert(double r5, DurationUnit r10, DurationUnit r11) {
            Intrinsics.checkNotNullParameter(r10, "sourceUnit");
            Intrinsics.checkNotNullParameter(r11, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r5, r10, r11);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1562daysUwyO8pc(int r5) {
            return DurationKt.toDuration(r5, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m1564getINFINITEUwyO8pc() {
            return Duration.access$getINFINITE$cp();
        }

        /* JADX INFO: renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m1565getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.access$getNEG_INFINITE$cp();
        }

        /* JADX INFO: renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m1566getZEROUwyO8pc() {
            return Duration.access$getZERO$cp();
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1568hoursUwyO8pc(int r5) {
            return DurationKt.toDuration(r5, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1571microsecondsUwyO8pc(int r5) {
            return DurationKt.toDuration(r5, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1574millisecondsUwyO8pc(int r5) {
            return DurationKt.toDuration(r5, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1577minutesUwyO8pc(int r5) {
            return DurationKt.toDuration(r5, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1580nanosecondsUwyO8pc(int r5) {
            return DurationKt.toDuration(r5, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m1582parseUwyO8pc(String r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            return DurationKt.access$parseDuration(r5, false);
        L5:
            e = move-exception;
            throw new IllegalArgumentException(j0.k("Invalid duration string format: '", r5, "'."), e);
        }

        /* JADX INFO: renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m1583parseIsoStringUwyO8pc(String r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            return DurationKt.access$parseDuration(r5, true);
        L5:
            e = move-exception;
            throw new IllegalArgumentException(j0.k("Invalid ISO duration string format: '", r5, "'."), e);
        }

        /* JADX INFO: renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final Duration m1584parseIsoStringOrNullFghU774(String r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            return Duration.m1461boximpl(DurationKt.access$parseDuration(r5, true));
        L5:
            return null;
        }

        /* JADX INFO: renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final Duration m1585parseOrNullFghU774(String r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            return Duration.m1461boximpl(DurationKt.access$parseDuration(r5, false));
        L5:
            return null;
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1587secondsUwyO8pc(int r5) {
            return DurationKt.toDuration(r5, DurationUnit.SECONDS);
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1521getDaysUwyO8pc(long r5) {
            return DurationKt.toDuration(r5, DurationUnit.DAYS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1523getDaysUwyO8pc$annotations(int r5) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1527getHoursUwyO8pc(long r5) {
            return DurationKt.toDuration(r5, DurationUnit.HOURS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1529getHoursUwyO8pc$annotations(int r5) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1533getMicrosecondsUwyO8pc(long r5) {
            return DurationKt.toDuration(r5, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1535getMicrosecondsUwyO8pc$annotations(int r5) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1539getMillisecondsUwyO8pc(long r5) {
            return DurationKt.toDuration(r5, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1541getMillisecondsUwyO8pc$annotations(int r5) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1545getMinutesUwyO8pc(long r5) {
            return DurationKt.toDuration(r5, DurationUnit.MINUTES);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1547getMinutesUwyO8pc$annotations(int r5) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1551getNanosecondsUwyO8pc(long r5) {
            return DurationKt.toDuration(r5, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1553getNanosecondsUwyO8pc$annotations(int r5) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1557getSecondsUwyO8pc(long r5) {
            return DurationKt.toDuration(r5, DurationUnit.SECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1559getSecondsUwyO8pc$annotations(int r5) {
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1563daysUwyO8pc(long r5) {
            return DurationKt.toDuration(r5, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1569hoursUwyO8pc(long r5) {
            return DurationKt.toDuration(r5, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1572microsecondsUwyO8pc(long r5) {
            return DurationKt.toDuration(r5, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1575millisecondsUwyO8pc(long r5) {
            return DurationKt.toDuration(r5, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1578minutesUwyO8pc(long r5) {
            return DurationKt.toDuration(r5, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1581nanosecondsUwyO8pc(long r5) {
            return DurationKt.toDuration(r5, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1588secondsUwyO8pc(long r5) {
            return DurationKt.toDuration(r5, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1519getDaysUwyO8pc(double r5) {
            return DurationKt.toDuration(r5, DurationUnit.DAYS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1524getDaysUwyO8pc$annotations(long r5) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1525getHoursUwyO8pc(double r5) {
            return DurationKt.toDuration(r5, DurationUnit.HOURS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1530getHoursUwyO8pc$annotations(long r5) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1531getMicrosecondsUwyO8pc(double r5) {
            return DurationKt.toDuration(r5, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1536getMicrosecondsUwyO8pc$annotations(long r5) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1537getMillisecondsUwyO8pc(double r5) {
            return DurationKt.toDuration(r5, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1542getMillisecondsUwyO8pc$annotations(long r5) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1543getMinutesUwyO8pc(double r5) {
            return DurationKt.toDuration(r5, DurationUnit.MINUTES);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1548getMinutesUwyO8pc$annotations(long r5) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1549getNanosecondsUwyO8pc(double r5) {
            return DurationKt.toDuration(r5, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1554getNanosecondsUwyO8pc$annotations(long r5) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1555getSecondsUwyO8pc(double r5) {
            return DurationKt.toDuration(r5, DurationUnit.SECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1560getSecondsUwyO8pc$annotations(long r5) {
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1561daysUwyO8pc(double r5) {
            return DurationKt.toDuration(r5, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1567hoursUwyO8pc(double r5) {
            return DurationKt.toDuration(r5, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1570microsecondsUwyO8pc(double r5) {
            return DurationKt.toDuration(r5, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1573millisecondsUwyO8pc(double r5) {
            return DurationKt.toDuration(r5, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1576minutesUwyO8pc(double r5) {
            return DurationKt.toDuration(r5, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1579nanosecondsUwyO8pc(double r5) {
            return DurationKt.toDuration(r5, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m1586secondsUwyO8pc(double r5) {
            return DurationKt.toDuration(r5, DurationUnit.SECONDS);
        }
    }

    static {
        Companion = new Companion(null);
        ZERO = m1463constructorimpl(0);
        INFINITE = DurationKt.access$durationOfMillis(DurationKt.MAX_MILLIS);
        NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);
    }

    private /* synthetic */ Duration(long r5) {
        this.rawValue = r5;
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
    private static final long m1459addValuesMixedRangesUwyO8pc(long r10, long r11, long r12) {
        long r13 = DurationKt.access$nanosToMillis(r12);
        long r5 = r11 + r13;
        if ((-4611686018426L) > r5) goto L8;
        if (r5 >= 4611686018427L) goto L8;
        long r14 = r12 - DurationKt.access$millisToNanos(r13);
        return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(r5) + r14);
    L8:
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(r5, -4611686018427387903L, DurationKt.MAX_MILLIS));
    }

    /* JADX INFO: renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m1460appendFractionalimpl(long r5, StringBuilder r10, int r11, int r12, int r13, String r14, boolean r15) {
        r10.append(r11);
        if (r12 == 0) goto L17;
        r10.append('.');
        String r16 = StringsKt.w(r13, String.valueOf(r12));
        int r17 = -1;
        int r18 = r16.length() - 1;
        if (r18 < 0) goto L12;
    L6:
        int r19 = r18 - 1;
        if (r16.charAt(r18) != '0') goto L8;
        if (r19 < 0) goto L12;
        r18 = r19;
        goto L6
    L8:
        r17 = r18;
    L12:
        int r20 = r17 + 1;
        if (r15 == true) goto L16;
        if (r20 >= 3) goto L16;
        r10.append(r16, 0, r20);
    L16:
        r10.append(r16, 0, ((r17 + 3) / 3) * 3);
    L17:
        r10.append(r14);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m1461boximpl(long r5) {
        return new Duration(r5);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1463constructorimpl(long r5) {
        if (DurationJvmKt.getDurationAssertionsEnabled() == true) goto L5;
    L26:
        return r5;
    L5:
        if (m1494isInNanosimpl(r5) == false) goto L13;
        long r10 = m1490getValueimpl(r5);
        if ((-4611686018426999999L) > r10) goto L12;
        if (r10 < 4611686018427000000L) goto L26;
    L12:
        throw new AssertionError(j0.o(new StringBuilder(), m1490getValueimpl(r5), " ns is out of nanoseconds range"));
    L13:
        long r11 = m1490getValueimpl(r5);
        if ((-4611686018427387903L) > r11) goto L25;
        if (r11 >= 4611686018427387904L) goto L25;
        long r12 = m1490getValueimpl(r5);
        if ((-4611686018426L) > r12) goto L26;
        if (r12 >= 4611686018427L) goto L26;
        throw new AssertionError(j0.o(new StringBuilder(), m1490getValueimpl(r5), " ms is denormalized"));
    L25:
        throw new AssertionError(j0.o(new StringBuilder(), m1490getValueimpl(r5), " ms is out of milliseconds range"));
    }

    /* JADX INFO: renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m1464divLRDsOJo(long r5, long r10) {
        DurationUnit r11 = (DurationUnit) ComparisonsKt.f(m1488getStorageUnitimpl(r5), m1488getStorageUnitimpl(r10));
        return m1506toDoubleimpl(r5, r11) / m1506toDoubleimpl(r10, r11);
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1466divUwyO8pc(long r10, int r11) {
        if (r11 != 0) goto L13;
        if (m1497isPositiveimpl(r10) == false) goto L7;
        return INFINITE;
    L7:
        if (m1496isNegativeimpl(r10) == false) goto L11;
        return NEG_INFINITE;
    L11:
        throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
    L13:
        if (m1494isInNanosimpl(r10) == false) goto L17;
        return DurationKt.access$durationOfNanos(m1490getValueimpl(r10) / ((long) r11));
    L17:
        if (m1495isInfiniteimpl(r10) == true) goto L19;
        long r5 = r11;
        long r12 = m1490getValueimpl(r10) / r5;
        if ((-4611686018426L) > r12) goto L27;
        if (r12 >= 4611686018427L) goto L27;
        return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(r12) + (DurationKt.access$millisToNanos(m1490getValueimpl(r10) - (r12 * r5)) / r5));
    L27:
        return DurationKt.access$durationOfMillis(r12);
    L19:
        return m1501timesUwyO8pc(r10, MathKt.getSign(r11));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1467equalsimpl(long r5, Object r10) {
        if ((r10 instanceof Duration) == true) goto L6;
        return false;
    L6:
        if (r5 == ((Duration) r10).m1518unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1468equalsimpl0(long r5, long r10) {
        if (r5 != r10) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m1469getAbsoluteValueUwyO8pc(long r5) {
        if (m1496isNegativeimpl(r5) == true) goto L5;
        return r5;
    L5:
        return m1516unaryMinusUwyO8pc(r5);
    }

    @PublishedApi
    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    /* JADX INFO: renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m1470getHoursComponentimpl(long r5) {
        if (m1495isInfiniteimpl(r5) == false) goto L6;
        return 0;
    L6:
        return (int) (m1479getInWholeHoursimpl(r5) % ((long) 24));
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInDays$annotations() {
    }

    /* JADX INFO: renamed from: getInDays-impl, reason: not valid java name */
    public static final /* synthetic */ double m1471getInDaysimpl(long r5) {
        return m1506toDoubleimpl(r5, DurationUnit.DAYS);
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInHours$annotations() {
    }

    /* JADX INFO: renamed from: getInHours-impl, reason: not valid java name */
    public static final /* synthetic */ double m1472getInHoursimpl(long r5) {
        return m1506toDoubleimpl(r5, DurationUnit.HOURS);
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    /* JADX INFO: renamed from: getInMicroseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m1473getInMicrosecondsimpl(long r5) {
        return m1506toDoubleimpl(r5, DurationUnit.MICROSECONDS);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    /* JADX INFO: renamed from: getInMilliseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m1474getInMillisecondsimpl(long r5) {
        return m1506toDoubleimpl(r5, DurationUnit.MILLISECONDS);
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    /* JADX INFO: renamed from: getInMinutes-impl, reason: not valid java name */
    public static final /* synthetic */ double m1475getInMinutesimpl(long r5) {
        return m1506toDoubleimpl(r5, DurationUnit.MINUTES);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    /* JADX INFO: renamed from: getInNanoseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m1476getInNanosecondsimpl(long r5) {
        return m1506toDoubleimpl(r5, DurationUnit.NANOSECONDS);
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    /* JADX INFO: renamed from: getInSeconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m1477getInSecondsimpl(long r5) {
        return m1506toDoubleimpl(r5, DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m1478getInWholeDaysimpl(long r5) {
        return m1509toLongimpl(r5, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m1479getInWholeHoursimpl(long r5) {
        return m1509toLongimpl(r5, DurationUnit.HOURS);
    }

    /* JADX INFO: renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m1480getInWholeMicrosecondsimpl(long r5) {
        return m1509toLongimpl(r5, DurationUnit.MICROSECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m1481getInWholeMillisecondsimpl(long r5) {
        if (m1493isInMillisimpl(r5) == false) goto L8;
        if (m1492isFiniteimpl(r5) == false) goto L8;
        return m1490getValueimpl(r5);
    L8:
        return m1509toLongimpl(r5, DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m1482getInWholeMinutesimpl(long r5) {
        return m1509toLongimpl(r5, DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m1483getInWholeNanosecondsimpl(long r5) {
        long r10 = m1490getValueimpl(r5);
        if (m1494isInNanosimpl(r5) == false) goto L6;
        return r10;
    L6:
        if (r10 <= 9223372036854L) goto L9;
        return Long.MAX_VALUE;
    L9:
        if (r10 >= (-9223372036854L)) goto L12;
        return Long.MIN_VALUE;
    L12:
        return DurationKt.access$millisToNanos(r10);
    }

    /* JADX INFO: renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m1484getInWholeSecondsimpl(long r5) {
        return m1509toLongimpl(r5, DurationUnit.SECONDS);
    }

    @PublishedApi
    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    /* JADX INFO: renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m1485getMinutesComponentimpl(long r5) {
        if (m1495isInfiniteimpl(r5) == false) goto L6;
        return 0;
    L6:
        return (int) (m1482getInWholeMinutesimpl(r5) % ((long) 60));
    }

    @PublishedApi
    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    /* JADX INFO: renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m1486getNanosecondsComponentimpl(long r5) {
        if (m1495isInfiniteimpl(r5) == false) goto L6;
        return 0;
    L6:
        if (m1493isInMillisimpl(r5) == false) goto L9;
        long r10 = DurationKt.access$millisToNanos(m1490getValueimpl(r5) % ((long) 1000));
    L11:
        return (int) r10;
    L9:
        r10 = m1490getValueimpl(r5) % ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
        goto L11
    }

    @PublishedApi
    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* JADX INFO: renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m1487getSecondsComponentimpl(long r5) {
        if (m1495isInfiniteimpl(r5) == false) goto L6;
        return 0;
    L6:
        return (int) (m1484getInWholeSecondsimpl(r5) % ((long) 60));
    }

    /* JADX INFO: renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m1488getStorageUnitimpl(long r5) {
        if (m1494isInNanosimpl(r5) == false) goto L6;
        return DurationUnit.NANOSECONDS;
    L6:
        return DurationUnit.MILLISECONDS;
    }

    /* JADX INFO: renamed from: getUnitDiscriminator-impl, reason: not valid java name */
    private static final int m1489getUnitDiscriminatorimpl(long r5) {
        return ((int) r5) & 1;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    private static final long m1490getValueimpl(long r5) {
        return r5 >> 1;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1491hashCodeimpl(long r5) {
        return Long.hashCode(r5);
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m1492isFiniteimpl(long r5) {
        return !m1495isInfiniteimpl(r5);
    }

    /* JADX INFO: renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m1493isInMillisimpl(long r5) {
        if ((((int) r5) & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m1494isInNanosimpl(long r5) {
        if ((((int) r5) & 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m1495isInfiniteimpl(long r5) {
        if (r5 != INFINITE) goto L5;
    L8:
        return true;
    L5:
        if (r5 == NEG_INFINITE) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m1496isNegativeimpl(long r5) {
        if (r5 >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m1497isPositiveimpl(long r5) {
        if (r5 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m1498minusLRDsOJo(long r5, long r10) {
        return m1499plusLRDsOJo(r5, m1516unaryMinusUwyO8pc(r10));
    }

    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m1499plusLRDsOJo(long r10, long r11) {
        if (m1495isInfiniteimpl(r10) == false) goto L13;
        if (m1492isFiniteimpl(r11) == false) goto L7;
    L11:
        return r10;
    L7:
        if ((r11 ^ r10) >= 0) goto L11;
        throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
    L13:
        if (m1495isInfiniteimpl(r11) == false) goto L16;
        return r11;
    L16:
        if ((((int) r10) & 1) != (((int) r11) & 1)) goto L22;
        long r5 = m1490getValueimpl(r10) + m1490getValueimpl(r11);
        if (m1494isInNanosimpl(r10) == false) goto L27;
        return DurationKt.access$durationOfNanosNormalized(r5);
    L27:
        return DurationKt.access$durationOfMillisNormalized(r5);
    L22:
        if (m1493isInMillisimpl(r10) == false) goto L25;
        return m1459addValuesMixedRangesUwyO8pc(r10, m1490getValueimpl(r10), m1490getValueimpl(r11));
    L25:
        return m1459addValuesMixedRangesUwyO8pc(r10, m1490getValueimpl(r11), m1490getValueimpl(r10));
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m1501timesUwyO8pc(long r12, int r14) {
        if (m1495isInfiniteimpl(r12) == false) goto L11;
        if (r14 == 0) goto L10;
        if (r14 <= 0) goto L8;
        return r12;
    L8:
        return m1516unaryMinusUwyO8pc(r12);
    L10:
        throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
    L11:
        if (r14 == 0) goto L13;
        long r5 = m1490getValueimpl(r12);
        long r10 = r14;
        long r11 = r5 * r10;
        if (m1494isInNanosimpl(r12) == false) goto L34;
        if ((-2147483647L) > r5) goto L22;
        if (r5 >= 2147483648L) goto L22;
        return DurationKt.access$durationOfNanos(r11);
    L22:
        if ((r11 / r10) == r5) goto L43;
        long r13 = DurationKt.access$nanosToMillis(r5);
        long r15 = r13 * r10;
        long r16 = DurationKt.access$nanosToMillis((r5 - DurationKt.access$millisToNanos(r13)) * r10) + r15;
        if ((r15 / r10) != r13) goto L30;
        if ((r16 ^ r15) < 0) goto L30;
        return DurationKt.access$durationOfMillis(RangesKt.b(r16, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
    L30:
        if ((MathKt.getSign(r14) * MathKt.getSign(r5)) <= 0) goto L46;
        return INFINITE;
    L46:
        return NEG_INFINITE;
    L43:
        return DurationKt.access$durationOfNanosNormalized(r11);
    L34:
        if ((r11 / r10) != r5) goto L37;
        return DurationKt.access$durationOfMillis(RangesKt.b(r11, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
    L37:
        if ((MathKt.getSign(r14) * MathKt.getSign(r5)) <= 0) goto L40;
        return INFINITE;
    L40:
        return NEG_INFINITE;
    L13:
        return ZERO;
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1505toComponentsimpl(long r10, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r11, "action");
        return r11.invoke(Long.valueOf(m1478getInWholeDaysimpl(r10)), Integer.valueOf(m1470getHoursComponentimpl(r10)), Integer.valueOf(m1485getMinutesComponentimpl(r10)), Integer.valueOf(m1487getSecondsComponentimpl(r10)), Integer.valueOf(m1486getNanosecondsComponentimpl(r10)));
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m1506toDoubleimpl(long r5, DurationUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "unit");
        if (r5 != INFINITE) goto L6;
        return Double.POSITIVE_INFINITY;
    L6:
        if (r5 != NEG_INFINITE) goto L9;
        return Double.NEGATIVE_INFINITY;
    L9:
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m1490getValueimpl(r5), m1488getStorageUnitimpl(r5), r10);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m1507toIntimpl(long r10, DurationUnit r11) {
        Intrinsics.checkNotNullParameter(r11, "unit");
        return (int) RangesKt.coerceIn(m1509toLongimpl(r10, r11), -2147483648L, 2147483647L);
    }

    /* JADX INFO: renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m1508toIsoStringimpl(long r11) {
        StringBuilder r10 = new StringBuilder();
        if (m1496isNegativeimpl(r11) == false) goto L5;
        r10.append('-');
    L5:
        r10.append("PT");
        long r5 = m1469getAbsoluteValueUwyO8pc(r11);
        long r12 = m1479getInWholeHoursimpl(r5);
        int r13 = m1485getMinutesComponentimpl(r5);
        int r14 = m1487getSecondsComponentimpl(r5);
        int r15 = m1486getNanosecondsComponentimpl(r5);
        if (m1495isInfiniteimpl(r11) == false) goto L8;
        r12 = 9999999999999L;
    L8:
        boolean r16 = false;
        if (r12 == 0) goto L11;
        boolean r17 = true;
    L12:
        if (r14 != 0) goto L16;
        if (r15 != 0) goto L16;
        boolean r18 = false;
    L17:
        if (r13 != 0) goto L20;
        if (r18 == false) goto L21;
        if (r17 == true) goto L20;
    L21:
        if (r17 == false) goto L23;
        r10.append(r12);
        r10.append('H');
    L23:
        if (r16 == false) goto L25;
        r10.append(r13);
        r10.append('M');
    L25:
        if (r18 == true) goto L28;
        if (r17 == true) goto L30;
        if (r16 == false) goto L28;
    L30:
        return r10.toString();
    L28:
        m1460appendFractionalimpl(r11, r10, r14, r15, 9, ExifInterface.LATITUDE_SOUTH, true);
    L20:
        r16 = true;
    L16:
        r18 = true;
        goto L17
    L11:
        r17 = false;
        goto L12
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m1509toLongimpl(long r5, DurationUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "unit");
        if (r5 != INFINITE) goto L6;
        return Long.MAX_VALUE;
    L6:
        if (r5 != NEG_INFINITE) goto L9;
        return Long.MIN_VALUE;
    L9:
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m1490getValueimpl(r5), m1488getStorageUnitimpl(r5), r10);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    /* JADX INFO: renamed from: toLongMilliseconds-impl, reason: not valid java name */
    public static final /* synthetic */ long m1510toLongMillisecondsimpl(long r5) {
        return m1481getInWholeMillisecondsimpl(r5);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    /* JADX INFO: renamed from: toLongNanoseconds-impl, reason: not valid java name */
    public static final /* synthetic */ long m1511toLongNanosecondsimpl(long r5) {
        return m1483getInWholeNanosecondsimpl(r5);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1512toStringimpl(long r14) {
        if (r14 != 0) goto L6;
        return "0s";
    L6:
        if (r14 != INFINITE) goto L9;
        return "Infinity";
    L9:
        if (r14 != NEG_INFINITE) goto L11;
        return "-Infinity";
    L11:
        boolean r5 = m1496isNegativeimpl(r14);
        StringBuilder r11 = new StringBuilder();
        if (r5 == false) goto L14;
        r11.append('-');
    L14:
        long r10 = m1469getAbsoluteValueUwyO8pc(r14);
        long r12 = m1478getInWholeDaysimpl(r10);
        int r13 = m1470getHoursComponentimpl(r10);
        int r15 = m1485getMinutesComponentimpl(r10);
        int r16 = m1487getSecondsComponentimpl(r10);
        int r17 = m1486getNanosecondsComponentimpl(r10);
        int r18 = 0;
        if (r12 == 0) goto L17;
        boolean r19 = true;
    L18:
        if (r13 == 0) goto L20;
        boolean r20 = true;
    L21:
        if (r15 == 0) goto L23;
        boolean r21 = true;
    L24:
        if (r16 != 0) goto L28;
        if (r17 != 0) goto L28;
        boolean r110 = false;
    L29:
        if (r19 == false) goto L32;
        r11.append(r12);
        r11.append('d');
        r18 = 1;
    L32:
        if (r20 == true) goto L36;
        if (r19 == false) goto L40;
        if (r21 == true) goto L36;
        if (r110 == true) goto L36;
    L40:
        if (r21 == true) goto L44;
        if (r110 == false) goto L48;
        if (r20 == true) goto L44;
        if (r19 == true) goto L44;
    L48:
        if (r110 == false) goto L66;
        int r111 = r18 + 1;
        if (r18 <= 0) goto L52;
        r11.append(' ');
    L52:
        if (r16 != 0) goto L64;
        if (r19 == true) goto L64;
        if (r20 == true) goto L64;
        if (r21 == true) goto L64;
        if (r17 < 1000000) goto L61;
        m1460appendFractionalimpl(r14, r11, r17 / DurationKt.NANOS_IN_MILLIS, r17 % DurationKt.NANOS_IN_MILLIS, 6, "ms", false);
    L65:
        r18 = r111;
        goto L66
    L61:
        if (r17 < 1000) goto L63;
        m1460appendFractionalimpl(r14, r11, r17 / 1000, r17 % 1000, 3, "us", false);
        goto L65
    L63:
        r11.append(r17);
        r11.append("ns");
    L64:
        m1460appendFractionalimpl(r14, r11, r16, r17, 9, "s", false);
    L66:
        if (r5 == false) goto L70;
        if (r18 <= 1) goto L70;
        r11.insert(1, '(').append(')');
    L70:
        return r11.toString();
    L44:
        int r22 = r18 + 1;
        if (r18 <= 0) goto L47;
        r11.append(' ');
    L47:
        r11.append(r15);
        r11.append('m');
        r18 = r22;
    L36:
        int r23 = r18 + 1;
        if (r18 <= 0) goto L39;
        r11.append(' ');
    L39:
        r11.append(r13);
        r11.append('h');
        r18 = r23;
    L28:
        r110 = true;
        goto L29
    L23:
        r21 = false;
        goto L24
    L20:
        r20 = false;
        goto L21
    L17:
        r19 = false;
        goto L18
    }

    /* JADX INFO: renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ String m1514toStringimpl$default(long r5, DurationUnit r10, int r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        return m1513toStringimpl(r5, r10, r11);
    }

    /* JADX INFO: renamed from: truncateTo-UwyO8pc$kotlin_stdlib, reason: not valid java name */
    public static final long m1515truncateToUwyO8pc$kotlin_stdlib(long r5, DurationUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "unit");
        DurationUnit r11 = m1488getStorageUnitimpl(r5);
        if (r10.compareTo(r11) > 0) goto L5;
        return r5;
    L5:
        if (m1495isInfiniteimpl(r5) == true) goto L10;
        long r12 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1, r10, r11);
        return DurationKt.toDuration(m1490getValueimpl(r5) - (m1490getValueimpl(r5) % r12), r11);
    L10:
        return r5;
    }

    /* JADX INFO: renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m1516unaryMinusUwyO8pc(long r5) {
        return DurationKt.access$durationOf(-m1490getValueimpl(r5), ((int) r5) & 1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration r5) {
        return m1517compareToLRDsOJo(r5.m1518unboximpl());
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m1517compareToLRDsOJo(long r5) {
        return m1462compareToLRDsOJo(this.rawValue, r5);
    }

    public boolean equals(Object r5) {
        return m1467equalsimpl(this.rawValue, r5);
    }

    public int hashCode() {
        return m1491hashCodeimpl(this.rawValue);
    }

    public String toString() {
        return m1512toStringimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1518unboximpl() {
        return this.rawValue;
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m1462compareToLRDsOJo(long r5, long r10) {
        long r11 = r5 ^ r10;
        if (r11 < 0) goto L12;
        if ((((int) r11) & 1) == 0) goto L12;
        int r12 = (((int) r5) & 1) - (((int) r10) & 1);
        if (m1496isNegativeimpl(r5) == true) goto L10;
        return r12;
    L10:
        return -r12;
    L12:
        return Intrinsics.compare(r5, r10);
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1504toComponentsimpl(long r5, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        return r10.invoke(Long.valueOf(m1479getInWholeHoursimpl(r5)), Integer.valueOf(m1485getMinutesComponentimpl(r5)), Integer.valueOf(m1487getSecondsComponentimpl(r5)), Integer.valueOf(m1486getNanosecondsComponentimpl(r5)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1503toComponentsimpl(long r5, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        return r10.invoke(Long.valueOf(m1482getInWholeMinutesimpl(r5)), Integer.valueOf(m1487getSecondsComponentimpl(r5)), Integer.valueOf(m1486getNanosecondsComponentimpl(r5)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1502toComponentsimpl(long r5, Function2<? super Long, ? super Integer, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        return r10.mo2invoke(Long.valueOf(m1484getInWholeSecondsimpl(r5)), Integer.valueOf(m1486getNanosecondsComponentimpl(r5)));
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1465divUwyO8pc(long r5, double r10) {
        int r11 = MathKt.roundToInt(r10);
        if (r11 != r10) goto L7;
        if (r11 == 0) goto L7;
        return m1466divUwyO8pc(r5, r11);
    L7:
        DurationUnit r12 = m1488getStorageUnitimpl(r5);
        return DurationKt.toDuration(m1506toDoubleimpl(r5, r12) / r10, r12);
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m1500timesUwyO8pc(long r5, double r10) {
        int r11 = MathKt.roundToInt(r10);
        if (r11 == r10) goto L5;
        DurationUnit r12 = m1488getStorageUnitimpl(r5);
        return DurationKt.toDuration(m1506toDoubleimpl(r5, r12) * r10, r12);
    L5:
        return m1501timesUwyO8pc(r5, r11);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static final String m1513toStringimpl(long r5, DurationUnit r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "unit");
        if (r11 < 0) goto L11;
        double r12 = m1506toDoubleimpl(r5, r10);
        if (Double.isInfinite(r12) == false) goto L9;
        return String.valueOf(r12);
    L9:
        return DurationJvmKt.formatToExactDecimals(r12, RangesKt.coerceAtMost(r11, 12)) + DurationUnitKt__DurationUnitKt.shortName(r10);
    L11:
        throw new IllegalArgumentException(j0.g(r11, "decimals must be not negative, but was ").toString());
    }
}
