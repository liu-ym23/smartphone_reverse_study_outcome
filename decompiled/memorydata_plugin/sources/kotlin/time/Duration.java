package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087@\u0018\u0000 ¦\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¦\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u0018\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\bK\u0010LJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010QJ\u0018\u0010M\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\bR\u0010SJ\u001a\u0010T\u001a\u00020U2\b\u0010J\u001a\u0004\u0018\u00010VHÖ\u0003¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\tHÖ\u0001¢\u0006\u0004\bZ\u0010\rJ\r\u0010[\u001a\u00020U¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020UH\u0002¢\u0006\u0004\b_\u0010]J\u000f\u0010`\u001a\u00020UH\u0002¢\u0006\u0004\ba\u0010]J\r\u0010b\u001a\u00020U¢\u0006\u0004\bc\u0010]J\r\u0010d\u001a\u00020U¢\u0006\u0004\be\u0010]J\r\u0010f\u001a\u00020U¢\u0006\u0004\bg\u0010]J\u0018\u0010h\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\bi\u0010jJ\u0018\u0010k\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\bl\u0010jJ\u001b\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010PJ\u001b\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010QJ\u009d\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2u\u0010q\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(u\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0rH\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010{J\u0088\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2`\u0010q\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0|H\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010}Js\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2K\u0010q\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0~H\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010\u007fJ`\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p27\u0010q\u001a3\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0\u0080\u0001H\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0005\bz\u0010\u0081\u0001J\u0019\u0010\u0082\u0001\u001a\u00020\u000f2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0011\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0019\u0010\u008d\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0011\u0010\u0090\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0091\u0001\u0010\u0005J\u0011\u0010\u0092\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0093\u0001\u0010\u0005J\u0013\u0010\u0094\u0001\u001a\u00030\u008a\u0001H\u0016¢\u0006\u0006\b\u0095\u0001\u0010\u008c\u0001J%\u0010\u0094\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u0083\u0001\u001a\u00020=2\t\b\u0002\u0010\u0096\u0001\u001a\u00020\t¢\u0006\u0006\b\u0095\u0001\u0010\u0097\u0001J\u001e\u0010\u0098\u0001\u001a\u00020\u00002\u0007\u0010\u0083\u0001\u001a\u00020=H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0099\u0001\u0010\u008f\u0001J\u0015\u0010\u009a\u0001\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0005\b\u009b\u0001\u0010\u0005JK\u0010\u009c\u0001\u001a\u00030\u009d\u0001*\b0\u009e\u0001j\u0003`\u009f\u00012\u0007\u0010 \u0001\u001a\u00020\t2\u0007\u0010¡\u0001\u001a\u00020\t2\u0007\u0010¢\u0001\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u008a\u00012\u0007\u0010£\u0001\u001a\u00020UH\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001R\u0014\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u0011\u0010%\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010\u0005R\u0011\u0010)\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b*\u0010\u0005R\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u0005R\u0011\u0010-\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010\u0005R\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u0005R\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\u0005R\u001a\u00103\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\rR\u001a\u00106\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\rR\u0014\u0010<\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0015\u0010@\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\rR\u0014\u0010B\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006§\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", EventBody.KEY_VALUE, "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "times", "times-UwyO8pc", "toComponents", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", Scraps.INNER_UNIT, "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "truncateTo", "truncateTo-UwyO8pc$kotlin_stdlib", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class Duration implements Comparable<Duration> {
    public static final Companion Companion = null;
    private static final long INFINITE = 0;
    private static final long NEG_INFINITE = 0;
    private static final long ZERO = 0;
    private final long rawValue;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0007J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0011J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0014J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0011J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0011J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0014J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0017J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0011J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0014J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0017J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0011J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0014J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0017J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0011J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0014J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0017J\u0018\u00105\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u0018\u00109\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0004\b:\u00108J\u0018\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0002\b<J\u0018\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0002\b>J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0011J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0014J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0016\u0010\n\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\"\u0010\f\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\f\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014R\"\u0010\f\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R\"\u0010\u0018\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\"\u0010\u0018\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0014R\"\u0010\u0018\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\"\u0010\u001b\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0014R\"\u0010\u001b\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R\"\u0010\u001e\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0014R\"\u0010\u001e\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0017R\"\u0010!\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\"\u0010!\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0014R\"\u0010!\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0017R\"\u0010$\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010\u0011R\"\u0010$\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0014R\"\u0010$\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0017R\"\u0010'\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011R\"\u0010'\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0014R\"\u0010'\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0017\u0082\u0002\u0004\n\u0002\b!¨\u0006@"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "days", "", "getDays-UwyO8pc$annotations", "(D)V", "getDays-UwyO8pc", "(D)J", "", "(I)V", "(I)J", "", "(J)V", "(J)J", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "nanoseconds", "getNanoseconds-UwyO8pc$annotations", "getNanoseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "convert", EventBody.KEY_VALUE, "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "days-UwyO8pc", "hours-UwyO8pc", "microseconds-UwyO8pc", "milliseconds-UwyO8pc", "minutes-UwyO8pc", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m2803getDaysUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m2804getDaysUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m2805getDaysUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2806getDaysUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2807getDaysUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2808getDaysUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m2809getHoursUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m2810getHoursUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m2811getHoursUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2812getHoursUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2813getHoursUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2814getHoursUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m2815getMicrosecondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m2816getMicrosecondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m2817getMicrosecondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2818getMicrosecondsUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2819getMicrosecondsUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2820getMicrosecondsUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m2821getMillisecondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m2822getMillisecondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m2823getMillisecondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2824getMillisecondsUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2825getMillisecondsUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2826getMillisecondsUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m2827getMinutesUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m2828getMinutesUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m2829getMinutesUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2830getMinutesUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2831getMinutesUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2832getMinutesUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m2833getNanosecondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m2834getNanosecondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m2835getNanosecondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2836getNanosecondsUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2837getNanosecondsUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2838getNanosecondsUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m2839getSecondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m2840getSecondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m2841getSecondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2842getSecondsUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2843getSecondsUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2844getSecondsUwyO8pc$annotations(long r0) {
        }

        public final double convert(double r1, DurationUnit r3, DurationUnit r4) {
            Intrinsics.checkNotNullParameter(r3, "sourceUnit");
            Intrinsics.checkNotNullParameter(r4, "targetUnit");
            return DurationUnitKt.convertDurationUnit(r1, r3, r4);
        }

        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2845daysUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2846daysUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2847daysUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m2848getINFINITEUwyO8pc() {
            return Duration.access$getINFINITE$cp();
        }

        /* JADX INFO: renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m2849getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.access$getNEG_INFINITE$cp();
        }

        /* JADX INFO: renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m2850getZEROUwyO8pc() {
            return Duration.access$getZERO$cp();
        }

        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2851hoursUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2852hoursUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2853hoursUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2854microsecondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2855microsecondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2856microsecondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2857millisecondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2858millisecondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2859millisecondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2860minutesUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2861minutesUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2862minutesUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2863nanosecondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.NANOSECONDS);
        }

        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2864nanosecondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.NANOSECONDS);
        }

        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2865nanosecondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m2866parseUwyO8pc(String r4) {
            Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
            return DurationKt.access$parseDuration(r4, false);
        L5:
            e = move-exception;
            throw new IllegalArgumentException("Invalid duration string format: '" + r4 + "'.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m2867parseIsoStringUwyO8pc(String r4) {
            Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
            return DurationKt.access$parseDuration(r4, true);
        L5:
            e = move-exception;
            throw new IllegalArgumentException("Invalid ISO duration string format: '" + r4 + "'.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final Duration m2868parseIsoStringOrNullFghU774(String r1) {
            Intrinsics.checkNotNullParameter(r1, EventBody.KEY_VALUE);
            return Duration.m2745boximpl(DurationKt.access$parseDuration(r1, true));
        L5:
            return null;
        }

        /* JADX INFO: renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final Duration m2869parseOrNullFghU774(String r1) {
            Intrinsics.checkNotNullParameter(r1, EventBody.KEY_VALUE);
            return Duration.m2745boximpl(DurationKt.access$parseDuration(r1, false));
        L5:
            return null;
        }

        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2870secondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2871secondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m2872secondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.SECONDS);
        }
    }

    static {
        Companion = new Companion(null);
        ZERO = m2747constructorimpl(0);
        INFINITE = DurationKt.access$durationOfMillis(DurationKt.MAX_MILLIS);
        NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);
    }

    private /* synthetic */ Duration(long r1) {
        this.rawValue = r1;
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
    private static final long m2743addValuesMixedRangesUwyO8pc(long r6, long r8, long r10) {
        long r7 = DurationKt.access$nanosToMillis(r10);
        long r0 = r8 + r7;
        boolean r9 = false;
        if ((-4611686018426L) <= r0) goto L5;
    L7:
        if (r9 == false) goto L10;
        long r11 = r10 - DurationKt.access$millisToNanos(r7);
        return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(r0) + r11);
    L10:
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(r0, -4611686018427387903L, DurationKt.MAX_MILLIS));
    L5:
        if (r0 >= 4611686018427L) goto L7;
        r9 = true;
        goto L7
    }

    /* JADX INFO: renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m2744appendFractionalimpl(long r5, StringBuilder r7, int r8, int r9, int r10, String r11, boolean r12) {
        r7.append(r8);
        if (r9 == 0) goto L21;
        r7.append('.');
        String r6 = StringsKt.padStart(String.valueOf(r9), r10, '0');
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = -1;
        int r14 = r13.length() - 1;
        if (r14 < 0) goto L15;
    L6:
        int r3 = r14 - 1;
        if (r13.charAt(r14) == '0') goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L11;
        if (r3 < 0) goto L15;
        r14 = r3;
        goto L6
    L11:
        r0 = r14;
        goto L15
    L9:
        r4 = false;
    L15:
        int r1 = r0 + 1;
        if (r12 == true) goto L19;
        if (r1 >= 3) goto L19;
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
    L20:
        Intrinsics.checkNotNullExpressionValue(r7.append(r15, 0, r1), "append(...)");
    L19:
        r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        r1 = ((r1 + 2) / 3) * 3;
    L21:
        r7.append(r11);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m2745boximpl(long r1) {
        return new Duration(r1);
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m2746compareToLRDsOJo(long r4, long r6) {
        long r0 = r4 ^ r6;
        if (r0 < 0) goto L12;
        if ((((int) r0) & 1) == 0) goto L12;
        int r1 = (((int) r4) & 1) - (((int) r6) & 1);
        if (m2780isNegativeimpl(r4) == true) goto L10;
        return r1;
    L10:
        return -r1;
    L12:
        return Intrinsics.compare(r4, r6);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2747constructorimpl(long r7) {
        if (DurationJvmKt.getDurationAssertionsEnabled() == false) goto L35;
        boolean r0 = m2778isInNanosimpl(r7);
        boolean r1 = true;
        long r3 = m2774getValueimpl(r7);
        if (r0 == false) goto L17;
        if ((-4611686018426999999L) <= r3) goto L9;
    L11:
        r1 = false;
    L12:
        if (r1 == true) goto L35;
        throw new AssertionError(m2774getValueimpl(r7) + " ns is out of nanoseconds range");
    L9:
        if (r3 >= 4611686018427000000L) goto L11;
    L17:
        if ((-4611686018427387903L) <= r3) goto L19;
    L21:
        boolean r2 = false;
    L22:
        if (r2 == false) goto L34;
        long r4 = m2774getValueimpl(r7);
        if ((-4611686018426L) <= r4) goto L26;
    L28:
        r1 = false;
    L29:
        if (r1 == false) goto L35;
        throw new AssertionError(m2774getValueimpl(r7) + " ms is denormalized");
    L26:
        if (r4 >= 4611686018427L) goto L28;
    L34:
        throw new AssertionError(m2774getValueimpl(r7) + " ms is out of milliseconds range");
    L19:
        if (r3 >= 4611686018427387904L) goto L21;
        r2 = true;
    L35:
        return r7;
    }

    /* JADX INFO: renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m2748divLRDsOJo(long r4, long r6) {
        DurationUnit r0 = (DurationUnit) ZeusTransformUtils.preCheckCast(ComparisonsKt.maxOf((Comparable) ZeusTransformUtils.preCheckCast(m2772getStorageUnitimpl(r4), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(m2772getStorageUnitimpl(r6), Comparable.class, "com.obric.memorydata.plugin")), DurationUnit.class, "com.obric.memorydata.plugin");
        return m2790toDoubleimpl(r4, r0) / m2790toDoubleimpl(r6, r0);
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m2749divUwyO8pc(long r3, double r5) {
        int r0 = MathKt.roundToInt(r5);
        if (r0 != r5) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        if (r0 == 0) goto L10;
        return m2750divUwyO8pc(r3, r0);
    L10:
        DurationUnit r2 = m2772getStorageUnitimpl(r3);
        return DurationKt.toDuration(m2790toDoubleimpl(r3, r2) / r5, r2);
    L5:
        r1 = false;
        goto L6
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m2750divUwyO8pc(long r7, int r9) {
        if (r9 != 0) goto L13;
        if (m2781isPositiveimpl(r7) == false) goto L7;
        return INFINITE;
    L7:
        if (m2780isNegativeimpl(r7) == false) goto L11;
        return NEG_INFINITE;
    L11:
        throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
    L13:
        if (m2778isInNanosimpl(r7) == false) goto L17;
        return DurationKt.access$durationOfNanos(m2774getValueimpl(r7) / ((long) r9));
    L17:
        if (m2779isInfiniteimpl(r7) == true) goto L19;
        long r2 = r9;
        long r0 = m2774getValueimpl(r7) / r2;
        boolean r4 = false;
        if ((-4611686018426L) <= r0) goto L23;
    L25:
        if (r4 == false) goto L29;
        return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(r0) + (DurationKt.access$millisToNanos(m2774getValueimpl(r7) - (r0 * r2)) / r2));
    L29:
        return DurationKt.access$durationOfMillis(r0);
    L23:
        if (r0 >= 4611686018427L) goto L25;
        r4 = true;
        goto L25
    L19:
        return m2785timesUwyO8pc(r7, MathKt.getSign(r9));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2751equalsimpl(long r3, Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, Duration.class) == true) goto L6;
        return false;
    L6:
        if (r3 == ((Duration) ZeusTransformUtils.preCheckCast(r5, Duration.class, "com.obric.memorydata.plugin")).m2802unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2752equalsimpl0(long r0, long r2) {
        if (r0 != r2) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m2753getAbsoluteValueUwyO8pc(long r1) {
        if (m2780isNegativeimpl(r1) == true) goto L5;
        return r1;
    L5:
        return m2800unaryMinusUwyO8pc(r1);
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    /* JADX INFO: renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m2754getHoursComponentimpl(long r2) {
        if (m2779isInfiniteimpl(r2) == false) goto L6;
        return 0;
    L6:
        return (int) (m2763getInWholeHoursimpl(r2) % ((long) 24));
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInDays$annotations() {
    }

    /* JADX INFO: renamed from: getInDays-impl, reason: not valid java name */
    public static final /* synthetic */ double m2755getInDaysimpl(long r1) {
        return m2790toDoubleimpl(r1, DurationUnit.DAYS);
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInHours$annotations() {
    }

    /* JADX INFO: renamed from: getInHours-impl, reason: not valid java name */
    public static final /* synthetic */ double m2756getInHoursimpl(long r1) {
        return m2790toDoubleimpl(r1, DurationUnit.HOURS);
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    /* JADX INFO: renamed from: getInMicroseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m2757getInMicrosecondsimpl(long r1) {
        return m2790toDoubleimpl(r1, DurationUnit.MICROSECONDS);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    /* JADX INFO: renamed from: getInMilliseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m2758getInMillisecondsimpl(long r1) {
        return m2790toDoubleimpl(r1, DurationUnit.MILLISECONDS);
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    /* JADX INFO: renamed from: getInMinutes-impl, reason: not valid java name */
    public static final /* synthetic */ double m2759getInMinutesimpl(long r1) {
        return m2790toDoubleimpl(r1, DurationUnit.MINUTES);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    /* JADX INFO: renamed from: getInNanoseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m2760getInNanosecondsimpl(long r1) {
        return m2790toDoubleimpl(r1, DurationUnit.NANOSECONDS);
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    /* JADX INFO: renamed from: getInSeconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m2761getInSecondsimpl(long r1) {
        return m2790toDoubleimpl(r1, DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m2762getInWholeDaysimpl(long r1) {
        return m2793toLongimpl(r1, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m2763getInWholeHoursimpl(long r1) {
        return m2793toLongimpl(r1, DurationUnit.HOURS);
    }

    /* JADX INFO: renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m2764getInWholeMicrosecondsimpl(long r1) {
        return m2793toLongimpl(r1, DurationUnit.MICROSECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m2765getInWholeMillisecondsimpl(long r1) {
        if (m2777isInMillisimpl(r1) == false) goto L8;
        if (m2776isFiniteimpl(r1) == false) goto L8;
        return m2774getValueimpl(r1);
    L8:
        return m2793toLongimpl(r1, DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m2766getInWholeMinutesimpl(long r1) {
        return m2793toLongimpl(r1, DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m2767getInWholeNanosecondsimpl(long r2) {
        long r0 = m2774getValueimpl(r2);
        if (m2778isInNanosimpl(r2) == false) goto L6;
        return r0;
    L6:
        if (r0 <= 9223372036854L) goto L9;
        return Long.MAX_VALUE;
    L9:
        if (r0 >= (-9223372036854L)) goto L12;
        return Long.MIN_VALUE;
    L12:
        return DurationKt.access$millisToNanos(r0);
    }

    /* JADX INFO: renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m2768getInWholeSecondsimpl(long r1) {
        return m2793toLongimpl(r1, DurationUnit.SECONDS);
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    /* JADX INFO: renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m2769getMinutesComponentimpl(long r2) {
        if (m2779isInfiniteimpl(r2) == false) goto L6;
        return 0;
    L6:
        return (int) (m2766getInWholeMinutesimpl(r2) % ((long) 60));
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    /* JADX INFO: renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m2770getNanosecondsComponentimpl(long r2) {
        if (m2779isInfiniteimpl(r2) == false) goto L5;
        return 0;
    L5:
        boolean r0 = m2777isInMillisimpl(r2);
        long r3 = m2774getValueimpl(r2);
        if (r0 == false) goto L8;
        long r4 = DurationKt.access$millisToNanos(r3 % ((long) 1000));
    L10:
        return (int) r4;
    L8:
        r4 = r3 % ((long) 1000000000);
        goto L10
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* JADX INFO: renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m2771getSecondsComponentimpl(long r2) {
        if (m2779isInfiniteimpl(r2) == false) goto L6;
        return 0;
    L6:
        return (int) (m2768getInWholeSecondsimpl(r2) % ((long) 60));
    }

    /* JADX INFO: renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m2772getStorageUnitimpl(long r0) {
        if (m2778isInNanosimpl(r0) == false) goto L6;
        return DurationUnit.NANOSECONDS;
    L6:
        return DurationUnit.MILLISECONDS;
    }

    /* JADX INFO: renamed from: getUnitDiscriminator-impl, reason: not valid java name */
    private static final int m2773getUnitDiscriminatorimpl(long r0) {
        return ((int) r0) & 1;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    private static final long m2774getValueimpl(long r1) {
        return r1 >> 1;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2775hashCodeimpl(long r0) {
        return Long.hashCode(r0);
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m2776isFiniteimpl(long r0) {
        return !m2779isInfiniteimpl(r0);
    }

    /* JADX INFO: renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m2777isInMillisimpl(long r0) {
        if ((((int) r0) & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m2778isInNanosimpl(long r0) {
        if ((((int) r0) & 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m2779isInfiniteimpl(long r2) {
        if (r2 != INFINITE) goto L5;
    L8:
        return true;
    L5:
        if (r2 == NEG_INFINITE) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m2780isNegativeimpl(long r2) {
        if (r2 >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m2781isPositiveimpl(long r2) {
        if (r2 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m2782minusLRDsOJo(long r0, long r2) {
        return m2783plusLRDsOJo(r0, m2800unaryMinusUwyO8pc(r2));
    }

    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m2783plusLRDsOJo(long r7, long r9) {
        if (m2779isInfiniteimpl(r7) == false) goto L13;
        if (m2776isFiniteimpl(r9) == false) goto L7;
    L11:
        return r7;
    L7:
        if ((r9 ^ r7) >= 0) goto L11;
        throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
    L13:
        if (m2779isInfiniteimpl(r9) == false) goto L16;
        return r9;
    L16:
        if ((((int) r7) & 1) != (((int) r9) & 1)) goto L22;
        long r0 = m2774getValueimpl(r7) + m2774getValueimpl(r9);
        if (m2778isInNanosimpl(r7) == false) goto L27;
        return DurationKt.access$durationOfNanosNormalized(r0);
    L27:
        return DurationKt.access$durationOfMillisNormalized(r0);
    L22:
        if (m2777isInMillisimpl(r7) == false) goto L25;
        return m2743addValuesMixedRangesUwyO8pc(r7, m2774getValueimpl(r7), m2774getValueimpl(r9));
    L25:
        return m2743addValuesMixedRangesUwyO8pc(r7, m2774getValueimpl(r9), m2774getValueimpl(r7));
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m2784timesUwyO8pc(long r3, double r5) {
        int r0 = MathKt.roundToInt(r5);
        if (r0 != r5) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        DurationUnit r2 = m2772getStorageUnitimpl(r3);
        return DurationKt.toDuration(m2790toDoubleimpl(r3, r2) * r5, r2);
    L8:
        return m2785timesUwyO8pc(r3, r0);
    L5:
        r1 = false;
        goto L6
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m2785timesUwyO8pc(long r17, int r19) {
        if (m2779isInfiniteimpl(r17) == false) goto L11;
        if (r19 == 0) goto L10;
        if (r19 <= 0) goto L8;
        return r17;
    L8:
        return m2800unaryMinusUwyO8pc(r17);
    L10:
        throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
    L11:
        if (r19 == 0) goto L13;
        long r1 = m2774getValueimpl(r17);
        long r3 = r19;
        long r5 = r1 * r3;
        if (m2778isInNanosimpl(r17) == false) goto L35;
        boolean r13 = false;
        if ((-2147483647L) <= r1) goto L19;
    L21:
        if (r13 == false) goto L24;
        return DurationKt.access$durationOfNanos(r5);
    L24:
        if ((r5 / r3) == r1) goto L45;
        long r6 = DurationKt.access$nanosToMillis(r1);
        long r15 = r6 * r3;
        long r14 = DurationKt.access$nanosToMillis((r1 - DurationKt.access$millisToNanos(r6)) * r3) + r15;
        if ((r15 / r3) != r6) goto L32;
        if ((r14 ^ r15) < 0) goto L32;
        long r0 = RangesKt.coerceIn(r14, (ClosedRange) ZeusTransformUtils.preCheckCast(new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS), ClosedRange.class, "com.obric.memorydata.plugin"));
    L46:
        return DurationKt.access$durationOfMillis(r0);
    L32:
        if ((MathKt.getSign(r1) * MathKt.getSign(r19)) > 0) goto L47;
    L42:
        return NEG_INFINITE;
    L47:
        return INFINITE;
    L45:
        return DurationKt.access$durationOfNanosNormalized(r5);
    L19:
        if (r1 >= 2147483648L) goto L21;
        r13 = true;
        goto L21
    L35:
        if ((r5 / r3) != r1) goto L39;
        r0 = RangesKt.coerceIn(r5, (ClosedRange) ZeusTransformUtils.preCheckCast(new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS), ClosedRange.class, "com.obric.memorydata.plugin"));
        goto L46
    L39:
        if ((MathKt.getSign(r1) * MathKt.getSign(r19)) <= 0) goto L42;
    L13:
        return ZERO;
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m2786toComponentsimpl(long r2, Function2<? super Long, ? super Integer, ? extends T> r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "action");
        return (T) r5.invoke(Long.valueOf(m2768getInWholeSecondsimpl(r2)), Integer.valueOf(m2770getNanosecondsComponentimpl(r2)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m2787toComponentsimpl(long r2, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> r4) {
        Function3 r5 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "action");
        return (T) r5.invoke(Long.valueOf(m2766getInWholeMinutesimpl(r2)), Integer.valueOf(m2771getSecondsComponentimpl(r2)), Integer.valueOf(m2770getNanosecondsComponentimpl(r2)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m2788toComponentsimpl(long r3, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> r5) {
        Function4 r6 = (Function4) ZeusTransformUtils.wrapperContextForParams(r5, Function4.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "action");
        return (T) r6.invoke(Long.valueOf(m2763getInWholeHoursimpl(r3)), Integer.valueOf(m2769getMinutesComponentimpl(r3)), Integer.valueOf(m2771getSecondsComponentimpl(r3)), Integer.valueOf(m2770getNanosecondsComponentimpl(r3)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m2789toComponentsimpl(long r6, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> r8) {
        Function5 r0 = (Function5) ZeusTransformUtils.wrapperContextForParams(r8, Function5.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "action");
        return (T) r0.invoke(Long.valueOf(m2762getInWholeDaysimpl(r6)), Integer.valueOf(m2754getHoursComponentimpl(r6)), Integer.valueOf(m2769getMinutesComponentimpl(r6)), Integer.valueOf(m2771getSecondsComponentimpl(r6)), Integer.valueOf(m2770getNanosecondsComponentimpl(r6)));
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m2790toDoubleimpl(long r2, DurationUnit r4) {
        Intrinsics.checkNotNullParameter(r4, Scraps.INNER_UNIT);
        if (r2 != INFINITE) goto L6;
        return Double.POSITIVE_INFINITY;
    L6:
        if (r2 != NEG_INFINITE) goto L9;
        return Double.NEGATIVE_INFINITY;
    L9:
        return DurationUnitKt.convertDurationUnit(m2774getValueimpl(r2), m2772getStorageUnitimpl(r2), r4);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m2791toIntimpl(long r7, DurationUnit r9) {
        Intrinsics.checkNotNullParameter(r9, Scraps.INNER_UNIT);
        return (int) RangesKt.coerceIn(m2793toLongimpl(r7, r9), -2147483648L, 2147483647L);
    }

    /* JADX INFO: renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m2792toIsoStringimpl(long r11) {
        StringBuilder r8 = new StringBuilder();
        if (m2780isNegativeimpl(r11) == false) goto L5;
        r8.append('-');
    L5:
        r8.append("PT");
        long r0 = m2753getAbsoluteValueUwyO8pc(r11);
        long r2 = m2763getInWholeHoursimpl(r0);
        int r4 = m2769getMinutesComponentimpl(r0);
        int r5 = m2771getSecondsComponentimpl(r0);
        int r6 = m2770getNanosecondsComponentimpl(r0);
        if (m2779isInfiniteimpl(r11) == false) goto L8;
        r2 = 9999999999999L;
    L8:
        boolean r1 = true;
        if (r2 == 0) goto L11;
        boolean r3 = true;
    L12:
        if (r5 != 0) goto L16;
        if (r6 != 0) goto L16;
        boolean r9 = false;
    L17:
        if (r4 != 0) goto L22;
        if (r9 == false) goto L21;
        if (r3 == true) goto L22;
    L21:
        r1 = false;
    L22:
        if (r3 == false) goto L24;
        r8.append(r2).append('H');
    L24:
        if (r1 == false) goto L26;
        r8.append(r4).append('M');
    L26:
        if (r9 == true) goto L29;
        if (r3 == true) goto L30;
        if (r1 == false) goto L29;
    L30:
        String r12 = r8.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        return r12;
    L29:
        m2744appendFractionalimpl(r11, r8, r5, r6, 9, "S", true);
    L16:
        r9 = true;
        goto L17
    L11:
        r3 = false;
        goto L12
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m2793toLongimpl(long r2, DurationUnit r4) {
        Intrinsics.checkNotNullParameter(r4, Scraps.INNER_UNIT);
        if (r2 != INFINITE) goto L6;
        return Long.MAX_VALUE;
    L6:
        if (r2 != NEG_INFINITE) goto L9;
        return Long.MIN_VALUE;
    L9:
        return DurationUnitKt.convertDurationUnit(m2774getValueimpl(r2), m2772getStorageUnitimpl(r2), r4);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    /* JADX INFO: renamed from: toLongMilliseconds-impl, reason: not valid java name */
    public static final /* synthetic */ long m2794toLongMillisecondsimpl(long r0) {
        return m2765getInWholeMillisecondsimpl(r0);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    /* JADX INFO: renamed from: toLongNanoseconds-impl, reason: not valid java name */
    public static final /* synthetic */ long m2795toLongNanosecondsimpl(long r0) {
        return m2767getInWholeNanosecondsimpl(r0);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2796toStringimpl(long r14) {
        if (r14 != 0) goto L6;
        return "0s";
    L6:
        if (r14 != INFINITE) goto L9;
        return "Infinity";
    L9:
        if (r14 != NEG_INFINITE) goto L11;
        return "-Infinity";
    L11:
        boolean r2 = m2780isNegativeimpl(r14);
        StringBuilder r11 = new StringBuilder();
        if (r2 == false) goto L14;
        r11.append('-');
    L14:
        long r3 = m2753getAbsoluteValueUwyO8pc(r14);
        long r5 = m2762getInWholeDaysimpl(r3);
        int r7 = m2754getHoursComponentimpl(r3);
        int r8 = m2769getMinutesComponentimpl(r3);
        int r9 = m2771getSecondsComponentimpl(r3);
        int r10 = m2770getNanosecondsComponentimpl(r3);
        int r1 = 0;
        if (r5 == 0) goto L17;
        boolean r0 = true;
    L18:
        if (r7 == 0) goto L20;
        boolean r4 = true;
    L21:
        if (r8 == 0) goto L23;
        boolean r6 = true;
    L24:
        if (r9 != 0) goto L28;
        if (r10 != 0) goto L28;
        boolean r13 = false;
    L29:
        if (r0 == false) goto L32;
        r11.append(r5).append('d');
        r1 = 1;
    L32:
        if (r4 == true) goto L36;
        if (r0 == false) goto L40;
        if (r6 == true) goto L36;
        if (r13 == true) goto L36;
    L40:
        if (r6 == true) goto L44;
        if (r13 == false) goto L48;
        if (r4 == true) goto L44;
        if (r0 == true) goto L44;
    L48:
        if (r13 == false) goto L68;
        int r15 = r1 + 1;
        if (r1 <= 0) goto L52;
        r11.append(' ');
    L52:
        if (r9 != 0) goto L65;
        if (r0 == true) goto L65;
        if (r4 == true) goto L65;
        if (r6 == true) goto L65;
        if (r10 < 1000000) goto L62;
        int r12 = r10 / 1000000;
        int r16 = r10 % 1000000;
        int r17 = 6;
        boolean r18 = false;
        String r19 = "ms";
    L66:
        m2744appendFractionalimpl(r14, r11, r12, r16, r17, r19, r18);
    L67:
        r1 = r15;
        goto L68
    L62:
        if (r10 < 1000) goto L64;
        r12 = r10 / 1000;
        r16 = r10 % 1000;
        r17 = 3;
        r18 = false;
        r19 = "us";
        goto L66
    L64:
        r11.append(r10).append("ns");
    L65:
        r17 = 9;
        r12 = r9;
        r16 = r10;
        r19 = "s";
        r18 = false;
    L68:
        if (r2 == false) goto L71;
        if (r1 <= 1) goto L71;
        r11.insert(1, '(').append(')');
    L71:
        String r110 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r110, "toString(...)");
        return r110;
    L44:
        int r20 = r1 + 1;
        if (r1 <= 0) goto L47;
        r11.append(' ');
    L47:
        r11.append(r8).append('m');
        r1 = r20;
    L36:
        int r21 = r1 + 1;
        if (r1 <= 0) goto L39;
        r11.append(' ');
    L39:
        r11.append(r7).append('h');
        r1 = r21;
    L28:
        r13 = true;
        goto L29
    L23:
        r6 = false;
        goto L24
    L20:
        r4 = false;
        goto L21
    L17:
        r0 = false;
        goto L18
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static final String m2797toStringimpl(long r2, DurationUnit r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, Scraps.INNER_UNIT);
        if (r5 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        double r3 = m2790toDoubleimpl(r2, r4);
        if (Double.isInfinite(r3) == false) goto L12;
        return String.valueOf(r3);
    L12:
        return DurationJvmKt.formatToExactDecimals(r3, RangesKt.coerceAtMost(r5, 12)) + DurationUnitKt.shortName(r4);
    L14:
        throw new IllegalArgumentException(("decimals must be not negative, but was " + r5).toString());
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ String m2798toStringimpl$default(long r0, DurationUnit r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        return m2797toStringimpl(r0, r2, r3);
    }

    /* JADX INFO: renamed from: truncateTo-UwyO8pc$kotlin_stdlib, reason: not valid java name */
    public static final long m2799truncateToUwyO8pc$kotlin_stdlib(long r5, DurationUnit r7) {
        Intrinsics.checkNotNullParameter(r7, Scraps.INNER_UNIT);
        DurationUnit r0 = m2772getStorageUnitimpl(r5);
        if (r7.compareTo((Enum) ZeusTransformUtils.preCheckCast(r0, Enum.class, "com.obric.memorydata.plugin")) > 0) goto L5;
        return r5;
    L5:
        if (m2779isInfiniteimpl(r5) == true) goto L10;
        long r1 = DurationUnitKt.convertDurationUnit(1, r7, r0);
        return DurationKt.toDuration(m2774getValueimpl(r5) - (m2774getValueimpl(r5) % r1), r0);
    L10:
        return r5;
    }

    /* JADX INFO: renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m2800unaryMinusUwyO8pc(long r2) {
        return DurationKt.access$durationOf(-m2774getValueimpl(r2), ((int) r2) & 1);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Duration r3) {
        return m2801compareToLRDsOJo(((Duration) ZeusTransformUtils.preCheckCast(r3, Duration.class, "com.obric.memorydata.plugin")).m2802unboximpl());
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m2801compareToLRDsOJo(long r3) {
        return m2746compareToLRDsOJo(this.rawValue, r3);
    }

    public boolean equals(Object r3) {
        return m2751equalsimpl(this.rawValue, r3);
    }

    public int hashCode() {
        return m2775hashCodeimpl(this.rawValue);
    }

    public String toString() {
        return m2796toStringimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2802unboximpl() {
        return this.rawValue;
    }
}
