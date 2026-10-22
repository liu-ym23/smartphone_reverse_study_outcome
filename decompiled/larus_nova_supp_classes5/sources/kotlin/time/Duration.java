package kotlin.time;

import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
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
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087@\u0018\u0000 ¦\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¦\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u0018\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\bK\u0010LJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010QJ\u0018\u0010M\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\bR\u0010SJ\u001a\u0010T\u001a\u00020U2\b\u0010J\u001a\u0004\u0018\u00010VHÖ\u0003¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\tHÖ\u0001¢\u0006\u0004\bZ\u0010\rJ\r\u0010[\u001a\u00020U¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020UH\u0002¢\u0006\u0004\b_\u0010]J\u000f\u0010`\u001a\u00020UH\u0002¢\u0006\u0004\ba\u0010]J\r\u0010b\u001a\u00020U¢\u0006\u0004\bc\u0010]J\r\u0010d\u001a\u00020U¢\u0006\u0004\be\u0010]J\r\u0010f\u001a\u00020U¢\u0006\u0004\bg\u0010]J\u0018\u0010h\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\bi\u0010jJ\u0018\u0010k\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\bl\u0010jJ\u001b\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010PJ\u001b\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010QJ\u009d\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2u\u0010q\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(u\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0rH\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010{J\u0088\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2`\u0010q\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0|H\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010}Js\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2K\u0010q\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0~H\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010\u007fJ`\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p27\u0010q\u001a3\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0\u0080\u0001H\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0005\bz\u0010\u0081\u0001J\u0019\u0010\u0082\u0001\u001a\u00020\u000f2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0011\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0019\u0010\u008d\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0011\u0010\u0090\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0091\u0001\u0010\u0005J\u0011\u0010\u0092\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0093\u0001\u0010\u0005J\u0013\u0010\u0094\u0001\u001a\u00030\u008a\u0001H\u0016¢\u0006\u0006\b\u0095\u0001\u0010\u008c\u0001J%\u0010\u0094\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u0083\u0001\u001a\u00020=2\t\b\u0002\u0010\u0096\u0001\u001a\u00020\t¢\u0006\u0006\b\u0095\u0001\u0010\u0097\u0001J\u001e\u0010\u0098\u0001\u001a\u00020\u00002\u0007\u0010\u0083\u0001\u001a\u00020=H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0099\u0001\u0010\u008f\u0001J\u0015\u0010\u009a\u0001\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0005\b\u009b\u0001\u0010\u0005JK\u0010\u009c\u0001\u001a\u00030\u009d\u0001*\b0\u009e\u0001j\u0003`\u009f\u00012\u0007\u0010 \u0001\u001a\u00020\t2\u0007\u0010¡\u0001\u001a\u00020\t2\u0007\u0010¢\u0001\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u008a\u00012\u0007\u0010£\u0001\u001a\u00020UH\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001R\u0014\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u0011\u0010%\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010\u0005R\u0011\u0010)\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b*\u0010\u0005R\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u0005R\u0011\u0010-\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010\u0005R\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u0005R\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\u0005R\u001a\u00103\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\rR\u001a\u00106\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\rR\u0014\u0010<\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0015\u0010@\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\rR\u0014\u0010B\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006§\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "times", "times-UwyO8pc", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", DBDefinition.NAME, "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "truncateTo", "truncateTo-UwyO8pc$kotlin_stdlib", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class Duration implements Comparable<Duration> {
    public static final Companion Companion = null;
    private static final long INFINITE = 0;
    private static final long NEG_INFINITE = 0;
    private static final long ZERO = 0;
    private final long rawValue;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0007J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0011J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0014J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0011J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0011J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0014J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0017J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0011J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0014J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0017J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0011J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0014J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0017J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0011J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0014J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0017J\u0018\u00105\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u0018\u00109\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0004\b:\u00108J\u0018\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0002\b<J\u0018\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0002\b>J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0011J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0014J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0016\u0010\n\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\"\u0010\f\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\f\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014R\"\u0010\f\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R\"\u0010\u0018\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\"\u0010\u0018\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0014R\"\u0010\u0018\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\"\u0010\u001b\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0014R\"\u0010\u001b\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R\"\u0010\u001e\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0014R\"\u0010\u001e\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0017R\"\u0010!\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\"\u0010!\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0014R\"\u0010!\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0017R\"\u0010$\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010\u0011R\"\u0010$\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0014R\"\u0010$\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0017R\"\u0010'\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011R\"\u0010'\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0014R\"\u0010'\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0017\u0082\u0002\u0004\n\u0002\b!¨\u0006@"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "days", "", "getDays-UwyO8pc$annotations", "(D)V", "getDays-UwyO8pc", "(D)J", "", "(I)V", "(I)J", "", "(J)V", "(J)J", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "nanoseconds", "getNanoseconds-UwyO8pc$annotations", "getNanoseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "convert", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "days-UwyO8pc", "hours-UwyO8pc", "microseconds-UwyO8pc", "milliseconds-UwyO8pc", "minutes-UwyO8pc", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m455getDaysUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m456getDaysUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m457getDaysUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m461getHoursUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m462getHoursUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m463getHoursUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m467getMicrosecondsUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m468getMicrosecondsUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m469getMicrosecondsUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m473getMillisecondsUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m474getMillisecondsUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m475getMillisecondsUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m479getMinutesUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m480getMinutesUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m481getMinutesUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m485getNanosecondsUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m486getNanosecondsUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m487getNanosecondsUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m491getSecondsUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m492getSecondsUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m493getSecondsUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m497getINFINITEUwyO8pc() {
            return Duration.access$getINFINITE$cp();
        }

        /* JADX INFO: renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m498getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.access$getNEG_INFINITE$cp();
        }

        /* JADX INFO: renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m499getZEROUwyO8pc() {
            return Duration.access$getZERO$cp();
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m452getDaysUwyO8pc(double r2) {
            return DurationKt.toDuration(r2, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m458getHoursUwyO8pc(double r2) {
            return DurationKt.toDuration(r2, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m464getMicrosecondsUwyO8pc(double r2) {
            return DurationKt.toDuration(r2, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m470getMillisecondsUwyO8pc(double r2) {
            return DurationKt.toDuration(r2, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m476getMinutesUwyO8pc(double r2) {
            return DurationKt.toDuration(r2, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m482getNanosecondsUwyO8pc(double r2) {
            return DurationKt.toDuration(r2, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m488getSecondsUwyO8pc(double r2) {
            return DurationKt.toDuration(r2, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m494daysUwyO8pc(double r2) {
            return DurationKt.toDuration(r2, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m500hoursUwyO8pc(double r2) {
            return DurationKt.toDuration(r2, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m503microsecondsUwyO8pc(double r2) {
            return DurationKt.toDuration(r2, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m506millisecondsUwyO8pc(double r2) {
            return DurationKt.toDuration(r2, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m509minutesUwyO8pc(double r2) {
            return DurationKt.toDuration(r2, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m512nanosecondsUwyO8pc(double r2) {
            return DurationKt.toDuration(r2, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m515parseUwyO8pc(String r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            return DurationKt.access$parseDuration(r5, false);
        L5:
            e = move-exception;
            throw new IllegalArgumentException("Invalid duration string format: '" + r5 + "'.", e);
        }

        /* JADX INFO: renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m516parseIsoStringUwyO8pc(String r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            return DurationKt.access$parseDuration(r5, true);
        L5:
            e = move-exception;
            throw new IllegalArgumentException("Invalid ISO duration string format: '" + r5 + "'.", e);
        }

        /* JADX INFO: renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final Duration m517parseIsoStringOrNullFghU774(String r3) {
            Intrinsics.checkNotNullParameter(r3, "value");
            return Duration.m394boximpl(DurationKt.access$parseDuration(r3, true));
        L5:
            return null;
        }

        /* JADX INFO: renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final Duration m518parseOrNullFghU774(String r3) {
            Intrinsics.checkNotNullParameter(r3, "value");
            return Duration.m394boximpl(DurationKt.access$parseDuration(r3, false));
        L5:
            return null;
        }

        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m519secondsUwyO8pc(double r2) {
            return DurationKt.toDuration(r2, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m453getDaysUwyO8pc(int r3) {
            return DurationKt.toDuration(r3, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m459getHoursUwyO8pc(int r3) {
            return DurationKt.toDuration(r3, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m465getMicrosecondsUwyO8pc(int r3) {
            return DurationKt.toDuration(r3, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m471getMillisecondsUwyO8pc(int r3) {
            return DurationKt.toDuration(r3, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m477getMinutesUwyO8pc(int r3) {
            return DurationKt.toDuration(r3, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m483getNanosecondsUwyO8pc(int r3) {
            return DurationKt.toDuration(r3, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m489getSecondsUwyO8pc(int r3) {
            return DurationKt.toDuration(r3, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m495daysUwyO8pc(int r3) {
            return DurationKt.toDuration(r3, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m501hoursUwyO8pc(int r3) {
            return DurationKt.toDuration(r3, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m504microsecondsUwyO8pc(int r3) {
            return DurationKt.toDuration(r3, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m507millisecondsUwyO8pc(int r3) {
            return DurationKt.toDuration(r3, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m510minutesUwyO8pc(int r3) {
            return DurationKt.toDuration(r3, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m513nanosecondsUwyO8pc(int r3) {
            return DurationKt.toDuration(r3, DurationUnit.NANOSECONDS);
        }

        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m520secondsUwyO8pc(int r3) {
            return DurationKt.toDuration(r3, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m454getDaysUwyO8pc(long r2) {
            return DurationKt.toDuration(r2, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m460getHoursUwyO8pc(long r2) {
            return DurationKt.toDuration(r2, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m466getMicrosecondsUwyO8pc(long r2) {
            return DurationKt.toDuration(r2, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m472getMillisecondsUwyO8pc(long r2) {
            return DurationKt.toDuration(r2, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m478getMinutesUwyO8pc(long r2) {
            return DurationKt.toDuration(r2, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m484getNanosecondsUwyO8pc(long r2) {
            return DurationKt.toDuration(r2, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m490getSecondsUwyO8pc(long r2) {
            return DurationKt.toDuration(r2, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m496daysUwyO8pc(long r2) {
            return DurationKt.toDuration(r2, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m502hoursUwyO8pc(long r2) {
            return DurationKt.toDuration(r2, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m505microsecondsUwyO8pc(long r2) {
            return DurationKt.toDuration(r2, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m508millisecondsUwyO8pc(long r2) {
            return DurationKt.toDuration(r2, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m511minutesUwyO8pc(long r2) {
            return DurationKt.toDuration(r2, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m514nanosecondsUwyO8pc(long r2) {
            return DurationKt.toDuration(r2, DurationUnit.NANOSECONDS);
        }

        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m521secondsUwyO8pc(long r2) {
            return DurationKt.toDuration(r2, DurationUnit.SECONDS);
        }

        public final double convert(double r2, DurationUnit r4, DurationUnit r5) {
            Intrinsics.checkNotNullParameter(r4, "sourceUnit");
            Intrinsics.checkNotNullParameter(r5, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r2, r4, r5);
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m394boximpl(long r1) {
        return new Duration(r1);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m400equalsimpl(long r4, Object r6) {
        if ((r6 instanceof Duration) == true) goto L6;
        return false;
    L6:
        if (r4 == ((Duration) r6).m451unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m401equalsimpl0(long r1, long r3) {
        if (r1 != r3) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInDays$annotations() {
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInHours$annotations() {
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* JADX INFO: renamed from: getUnitDiscriminator-impl, reason: not valid java name */
    private static final int m422getUnitDiscriminatorimpl(long r0) {
        return ((int) r0) & 1;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    private static final long m423getValueimpl(long r1) {
        return r1 >> 1;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m424hashCodeimpl(long r2) {
        return (int) (r2 ^ (r2 >>> 32));
    }

    /* JADX INFO: renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m426isInMillisimpl(long r0) {
        if ((((int) r0) & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m427isInNanosimpl(long r0) {
        if ((((int) r0) & 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m429isNegativeimpl(long r3) {
        if (r3 >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m430isPositiveimpl(long r3) {
        if (r3 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r3) {
        return m400equalsimpl(this.rawValue, r3);
    }

    public int hashCode() {
        return m424hashCodeimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m451unboximpl() {
        return this.rawValue;
    }

    static {
        Companion = new Companion(null);
        ZERO = m396constructorimpl(0);
        INFINITE = DurationKt.access$durationOfMillis(DurationKt.MAX_MILLIS);
        NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);
    }

    public String toString() {
        return m445toStringimpl(this.rawValue);
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

    private /* synthetic */ Duration(long r1) {
        this.rawValue = r1;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m396constructorimpl(long r7) {
        if (DurationJvmKt.getDurationAssertionsEnabled() == false) goto L35;
        boolean r1 = true;
        if (m427isInNanosimpl(r7) == false) goto L16;
        long r3 = m423getValueimpl(r7);
        if ((-4611686018426999999L) <= r3) goto L9;
    L11:
        r1 = false;
    L12:
        if (r1 == true) goto L35;
        throw new AssertionError(m423getValueimpl(r7) + " ns is out of nanoseconds range");
    L9:
        if (r3 >= 4611686018427000000L) goto L11;
    L16:
        long r4 = m423getValueimpl(r7);
        if ((-4611686018427387903L) <= r4) goto L19;
    L21:
        boolean r0 = false;
    L22:
        if (r0 == false) goto L34;
        long r5 = m423getValueimpl(r7);
        if ((-4611686018426L) <= r5) goto L26;
    L28:
        r1 = false;
    L29:
        if (r1 == false) goto L35;
        throw new AssertionError(m423getValueimpl(r7) + " ms is denormalized");
    L26:
        if (r5 >= 4611686018427L) goto L28;
    L34:
        throw new AssertionError(m423getValueimpl(r7) + " ms is out of milliseconds range");
    L19:
        if (r4 >= 4611686018427387904L) goto L21;
        r0 = true;
    L35:
        return r7;
    }

    /* JADX INFO: renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m402getAbsoluteValueUwyO8pc(long r1) {
        if (m429isNegativeimpl(r1) == true) goto L5;
        return r1;
    L5:
        return m449unaryMinusUwyO8pc(r1);
    }

    /* JADX INFO: renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m403getHoursComponentimpl(long r2) {
        if (m428isInfiniteimpl(r2) == false) goto L6;
        return 0;
    L6:
        return (int) (m412getInWholeHoursimpl(r2) % ((long) 24));
    }

    /* JADX INFO: renamed from: getInDays-impl, reason: not valid java name */
    public static final /* synthetic */ double m404getInDaysimpl(long r1) {
        return m439toDoubleimpl(r1, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: getInHours-impl, reason: not valid java name */
    public static final /* synthetic */ double m405getInHoursimpl(long r1) {
        return m439toDoubleimpl(r1, DurationUnit.HOURS);
    }

    /* JADX INFO: renamed from: getInMicroseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m406getInMicrosecondsimpl(long r1) {
        return m439toDoubleimpl(r1, DurationUnit.MICROSECONDS);
    }

    /* JADX INFO: renamed from: getInMilliseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m407getInMillisecondsimpl(long r1) {
        return m439toDoubleimpl(r1, DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: getInMinutes-impl, reason: not valid java name */
    public static final /* synthetic */ double m408getInMinutesimpl(long r1) {
        return m439toDoubleimpl(r1, DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: getInNanoseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m409getInNanosecondsimpl(long r1) {
        return m439toDoubleimpl(r1, DurationUnit.NANOSECONDS);
    }

    /* JADX INFO: renamed from: getInSeconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m410getInSecondsimpl(long r1) {
        return m439toDoubleimpl(r1, DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m411getInWholeDaysimpl(long r1) {
        return m442toLongimpl(r1, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m412getInWholeHoursimpl(long r1) {
        return m442toLongimpl(r1, DurationUnit.HOURS);
    }

    /* JADX INFO: renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m413getInWholeMicrosecondsimpl(long r1) {
        return m442toLongimpl(r1, DurationUnit.MICROSECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m414getInWholeMillisecondsimpl(long r1) {
        if (m426isInMillisimpl(r1) == false) goto L8;
        if (m425isFiniteimpl(r1) == false) goto L8;
        return m423getValueimpl(r1);
    L8:
        return m442toLongimpl(r1, DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m415getInWholeMinutesimpl(long r1) {
        return m442toLongimpl(r1, DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m416getInWholeNanosecondsimpl(long r3) {
        long r0 = m423getValueimpl(r3);
        if (m427isInNanosimpl(r3) == false) goto L6;
        return r0;
    L6:
        if (r0 <= 9223372036854L) goto L9;
        return LongCompanionObject.MAX_VALUE;
    L9:
        if (r0 >= (-9223372036854L)) goto L12;
        return Long.MIN_VALUE;
    L12:
        return DurationKt.access$millisToNanos(r0);
    }

    /* JADX INFO: renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m417getInWholeSecondsimpl(long r1) {
        return m442toLongimpl(r1, DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m418getMinutesComponentimpl(long r2) {
        if (m428isInfiniteimpl(r2) == false) goto L6;
        return 0;
    L6:
        return (int) (m415getInWholeMinutesimpl(r2) % ((long) 60));
    }

    /* JADX INFO: renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m419getNanosecondsComponentimpl(long r2) {
        if (m428isInfiniteimpl(r2) == false) goto L6;
        return 0;
    L6:
        if (m426isInMillisimpl(r2) == false) goto L8;
        long r3 = DurationKt.access$millisToNanos(m423getValueimpl(r2) % ((long) 1000));
    L10:
        return (int) r3;
    L8:
        r3 = m423getValueimpl(r2) % ((long) 1000000000);
        goto L10
    }

    /* JADX INFO: renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m420getSecondsComponentimpl(long r2) {
        if (m428isInfiniteimpl(r2) == false) goto L6;
        return 0;
    L6:
        return (int) (m417getInWholeSecondsimpl(r2) % ((long) 60));
    }

    /* JADX INFO: renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m421getStorageUnitimpl(long r0) {
        if (m427isInNanosimpl(r0) == false) goto L6;
        return DurationUnit.NANOSECONDS;
    L6:
        return DurationUnit.MILLISECONDS;
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m425isFiniteimpl(long r0) {
        return !m428isInfiniteimpl(r0);
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m428isInfiniteimpl(long r3) {
        if (r3 != INFINITE) goto L5;
    L8:
        return true;
    L5:
        if (r3 == NEG_INFINITE) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m441toIsoStringimpl(long r11) {
        StringBuilder r8 = new StringBuilder();
        if (m429isNegativeimpl(r11) == false) goto L5;
        r8.append('-');
    L5:
        r8.append("PT");
        long r0 = m402getAbsoluteValueUwyO8pc(r11);
        long r2 = m412getInWholeHoursimpl(r0);
        int r4 = m418getMinutesComponentimpl(r0);
        int r5 = m420getSecondsComponentimpl(r0);
        int r6 = m419getNanosecondsComponentimpl(r0);
        if (m428isInfiniteimpl(r11) == false) goto L8;
        r2 = 9999999999999L;
    L8:
        boolean r7 = true;
        if (r2 == 0) goto L11;
        boolean r1 = true;
    L12:
        if (r5 != 0) goto L16;
        if (r6 != 0) goto L16;
        boolean r3 = false;
    L17:
        if (r4 != 0) goto L22;
        if (r3 == false) goto L21;
        if (r1 == true) goto L22;
    L21:
        r7 = false;
    L22:
        if (r1 == false) goto L24;
        r8.append(r2);
        r8.append('H');
    L24:
        if (r7 == false) goto L26;
        r8.append(r4);
        r8.append('M');
    L26:
        if (r3 == true) goto L29;
        if (r1 == true) goto L31;
        if (r7 == false) goto L29;
    L31:
        return r8.toString();
    L29:
        m393appendFractionalimpl(r11, r8, r5, r6, 9, "S", true);
    L16:
        r3 = true;
        goto L17
    L11:
        r1 = false;
        goto L12
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    /* JADX INFO: renamed from: toLongMilliseconds-impl, reason: not valid java name */
    public static final /* synthetic */ long m443toLongMillisecondsimpl(long r0) {
        return m414getInWholeMillisecondsimpl(r0);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    /* JADX INFO: renamed from: toLongNanoseconds-impl, reason: not valid java name */
    public static final /* synthetic */ long m444toLongNanosecondsimpl(long r0) {
        return m416getInWholeNanosecondsimpl(r0);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m445toStringimpl(long r14) {
        if (r14 != 0) goto L6;
        return "0s";
    L6:
        if (r14 != INFINITE) goto L9;
        return "Infinity";
    L9:
        if (r14 != NEG_INFINITE) goto L11;
        return "-Infinity";
    L11:
        boolean r2 = m429isNegativeimpl(r14);
        StringBuilder r11 = new StringBuilder();
        if (r2 == false) goto L14;
        r11.append('-');
    L14:
        long r3 = m402getAbsoluteValueUwyO8pc(r14);
        long r5 = m411getInWholeDaysimpl(r3);
        int r7 = m403getHoursComponentimpl(r3);
        int r8 = m418getMinutesComponentimpl(r3);
        int r9 = m420getSecondsComponentimpl(r3);
        int r10 = m419getNanosecondsComponentimpl(r3);
        int r4 = 0;
        if (r5 == 0) goto L17;
        boolean r0 = true;
    L18:
        if (r7 == 0) goto L20;
        boolean r1 = true;
    L21:
        if (r8 == 0) goto L23;
        boolean r6 = true;
    L24:
        if (r9 != 0) goto L28;
        if (r10 != 0) goto L28;
        boolean r13 = false;
    L29:
        if (r0 == false) goto L32;
        r11.append(r5);
        r11.append('d');
        r4 = 1;
    L32:
        if (r1 == true) goto L36;
        if (r0 == false) goto L40;
        if (r6 == true) goto L36;
        if (r13 == true) goto L36;
    L40:
        if (r6 == true) goto L44;
        if (r13 == false) goto L48;
        if (r1 == true) goto L44;
        if (r0 == true) goto L44;
    L48:
        if (r13 == false) goto L66;
        int r15 = r4 + 1;
        if (r4 <= 0) goto L52;
        r11.append(' ');
    L52:
        if (r9 != 0) goto L64;
        if (r0 == true) goto L64;
        if (r1 == true) goto L64;
        if (r6 == true) goto L64;
        if (r10 < 1000000) goto L61;
        m393appendFractionalimpl(r14, r11, r10 / 1000000, r10 % 1000000, 6, "ms", false);
    L65:
        r4 = r15;
        goto L66
    L61:
        if (r10 < 1000) goto L63;
        m393appendFractionalimpl(r14, r11, r10 / 1000, r10 % 1000, 3, "us", false);
        goto L65
    L63:
        r11.append(r10);
        r11.append("ns");
    L64:
        m393appendFractionalimpl(r14, r11, r9, r10, 9, "s", false);
    L66:
        if (r2 == false) goto L70;
        if (r4 <= 1) goto L70;
        r11.insert(1, '(').append(')');
    L70:
        return r11.toString();
    L44:
        int r12 = r4 + 1;
        if (r4 <= 0) goto L47;
        r11.append(' ');
    L47:
        r11.append(r8);
        r11.append('m');
        r4 = r12;
    L36:
        int r16 = r4 + 1;
        if (r4 <= 0) goto L39;
        r11.append(' ');
    L39:
        r11.append(r7);
        r11.append('h');
        r4 = r16;
    L28:
        r13 = true;
        goto L29
    L23:
        r6 = false;
        goto L24
    L20:
        r1 = false;
        goto L21
    L17:
        r0 = false;
        goto L18
    }

    /* JADX INFO: renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m449unaryMinusUwyO8pc(long r2) {
        return DurationKt.access$durationOf(-m423getValueimpl(r2), ((int) r2) & 1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration r3) {
        return m450compareToLRDsOJo(r3.m451unboximpl());
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m450compareToLRDsOJo(long r3) {
        return m395compareToLRDsOJo(this.rawValue, r3);
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m395compareToLRDsOJo(long r5, long r7) {
        long r0 = r5 ^ r7;
        if (r0 < 0) goto L12;
        if ((((int) r0) & 1) == 0) goto L12;
        int r1 = (((int) r5) & 1) - (((int) r7) & 1);
        if (m429isNegativeimpl(r5) == true) goto L10;
        return r1;
    L10:
        return -r1;
    L12:
        return Intrinsics.compare(r5, r7);
    }

    /* JADX INFO: renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m397divLRDsOJo(long r2, long r4) {
        DurationUnit r0 = ComparisonsKt.maxOf(m421getStorageUnitimpl(r2), m421getStorageUnitimpl(r4));
        return m439toDoubleimpl(r2, r0) / m439toDoubleimpl(r4, r0);
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m399divUwyO8pc(long r7, int r9) {
        if (r9 != 0) goto L13;
        if (m430isPositiveimpl(r7) == false) goto L7;
        return INFINITE;
    L7:
        if (m429isNegativeimpl(r7) == false) goto L11;
        return NEG_INFINITE;
    L11:
        throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
    L13:
        if (m427isInNanosimpl(r7) == false) goto L17;
        return DurationKt.access$durationOfNanos(m423getValueimpl(r7) / ((long) r9));
    L17:
        if (m428isInfiniteimpl(r7) == true) goto L19;
        long r2 = r9;
        long r0 = m423getValueimpl(r7) / r2;
        boolean r10 = false;
        if ((-4611686018426L) <= r0) goto L23;
    L25:
        if (r10 == false) goto L29;
        return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(r0) + (DurationKt.access$millisToNanos(m423getValueimpl(r7) - (r0 * r2)) / r2));
    L29:
        return DurationKt.access$durationOfMillis(r0);
    L23:
        if (r0 >= 4611686018427L) goto L25;
        r10 = true;
        goto L25
    L19:
        return m434timesUwyO8pc(r7, MathKt.getSign(r9));
    }

    /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m431minusLRDsOJo(long r0, long r2) {
        return m432plusLRDsOJo(r0, m449unaryMinusUwyO8pc(r2));
    }

    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m432plusLRDsOJo(long r7, long r9) {
        if (m428isInfiniteimpl(r7) == false) goto L13;
        if (m425isFiniteimpl(r9) == false) goto L7;
    L11:
        return r7;
    L7:
        if ((r9 ^ r7) >= 0) goto L11;
        throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
    L13:
        if (m428isInfiniteimpl(r9) == false) goto L16;
        return r9;
    L16:
        if ((((int) r7) & 1) != (((int) r9) & 1)) goto L22;
        long r0 = m423getValueimpl(r7) + m423getValueimpl(r9);
        if (m427isInNanosimpl(r7) == false) goto L27;
        return DurationKt.access$durationOfNanosNormalized(r0);
    L27:
        return DurationKt.access$durationOfMillisNormalized(r0);
    L22:
        if (m426isInMillisimpl(r7) == false) goto L25;
        return m392addValuesMixedRangesUwyO8pc(r7, m423getValueimpl(r7), m423getValueimpl(r9));
    L25:
        return m392addValuesMixedRangesUwyO8pc(r7, m423getValueimpl(r9), m423getValueimpl(r7));
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m434timesUwyO8pc(long r13, int r15) {
        if (m428isInfiniteimpl(r13) == false) goto L11;
        if (r15 == 0) goto L10;
        if (r15 <= 0) goto L8;
        return r13;
    L8:
        return m449unaryMinusUwyO8pc(r13);
    L10:
        throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
    L11:
        if (r15 == 0) goto L13;
        long r0 = m423getValueimpl(r13);
        long r2 = r15;
        long r4 = r0 * r2;
        if (m427isInNanosimpl(r13) == false) goto L36;
        boolean r10 = false;
        if ((-2147483647L) <= r0) goto L19;
    L21:
        if (r10 == false) goto L24;
        return DurationKt.access$durationOfNanos(r4);
    L24:
        if ((r4 / r2) == r0) goto L45;
        long r14 = DurationKt.access$nanosToMillis(r0);
        long r11 = r14 * r2;
        long r5 = DurationKt.access$nanosToMillis((r0 - DurationKt.access$millisToNanos(r14)) * r2) + r11;
        if ((r11 / r2) != r14) goto L32;
        if ((r5 ^ r11) < 0) goto L32;
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(r5, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
    L32:
        if ((MathKt.getSign(r0) * MathKt.getSign(r15)) <= 0) goto L48;
        return INFINITE;
    L48:
        return NEG_INFINITE;
    L45:
        return DurationKt.access$durationOfNanosNormalized(r4);
    L19:
        if (r0 >= 2147483648L) goto L21;
        r10 = true;
        goto L21
    L36:
        if ((r4 / r2) != r0) goto L39;
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(r4, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
    L39:
        if ((MathKt.getSign(r0) * MathKt.getSign(r15)) <= 0) goto L42;
        return INFINITE;
    L42:
        return NEG_INFINITE;
    L13:
        return ZERO;
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m438toComponentsimpl(long r8, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        return r10.invoke(Long.valueOf(m411getInWholeDaysimpl(r8)), Integer.valueOf(m403getHoursComponentimpl(r8)), Integer.valueOf(m418getMinutesComponentimpl(r8)), Integer.valueOf(m420getSecondsComponentimpl(r8)), Integer.valueOf(m419getNanosecondsComponentimpl(r8)));
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m439toDoubleimpl(long r3, DurationUnit r5) {
        Intrinsics.checkNotNullParameter(r5, "unit");
        if (r3 != INFINITE) goto L6;
        return Double.POSITIVE_INFINITY;
    L6:
        if (r3 != NEG_INFINITE) goto L9;
        return Double.NEGATIVE_INFINITY;
    L9:
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m423getValueimpl(r3), m421getStorageUnitimpl(r3), r5);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m440toIntimpl(long r7, DurationUnit r9) {
        Intrinsics.checkNotNullParameter(r9, "unit");
        return (int) RangesKt.coerceIn(m442toLongimpl(r7, r9), -2147483648L, 2147483647L);
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m442toLongimpl(long r3, DurationUnit r5) {
        Intrinsics.checkNotNullParameter(r5, "unit");
        if (r3 != INFINITE) goto L6;
        return LongCompanionObject.MAX_VALUE;
    L6:
        if (r3 != NEG_INFINITE) goto L9;
        return Long.MIN_VALUE;
    L9:
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m423getValueimpl(r3), m421getStorageUnitimpl(r3), r5);
    }

    /* JADX INFO: renamed from: truncateTo-UwyO8pc$kotlin_stdlib, reason: not valid java name */
    public static final long m448truncateToUwyO8pc$kotlin_stdlib(long r5, DurationUnit r7) {
        Intrinsics.checkNotNullParameter(r7, "unit");
        DurationUnit r0 = m421getStorageUnitimpl(r5);
        if (r7.compareTo(r0) > 0) goto L5;
        return r5;
    L5:
        if (m428isInfiniteimpl(r5) == true) goto L10;
        long r1 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1, r7, r0);
        return DurationKt.toDuration(m423getValueimpl(r5) - (m423getValueimpl(r5) % r1), r0);
    L10:
        return r5;
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m398divUwyO8pc(long r4, double r6) {
        int r0 = MathKt.roundToInt(r6);
        if (r0 != r6) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        if (r0 == 0) goto L10;
        return m399divUwyO8pc(r4, r0);
    L10:
        DurationUnit r2 = m421getStorageUnitimpl(r4);
        return DurationKt.toDuration(m439toDoubleimpl(r4, r2) / r6, r2);
    L5:
        r1 = false;
        goto L6
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m433timesUwyO8pc(long r4, double r6) {
        int r0 = MathKt.roundToInt(r6);
        if (r0 != r6) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        DurationUnit r2 = m421getStorageUnitimpl(r4);
        return DurationKt.toDuration(m439toDoubleimpl(r4, r2) * r6, r2);
    L8:
        return m434timesUwyO8pc(r4, r0);
    L5:
        r1 = false;
        goto L6
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m437toComponentsimpl(long r3, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        return r5.invoke(Long.valueOf(m412getInWholeHoursimpl(r3)), Integer.valueOf(m418getMinutesComponentimpl(r3)), Integer.valueOf(m420getSecondsComponentimpl(r3)), Integer.valueOf(m419getNanosecondsComponentimpl(r3)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m436toComponentsimpl(long r2, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        return (T) r4.invoke(Long.valueOf(m415getInWholeMinutesimpl(r2)), Integer.valueOf(m420getSecondsComponentimpl(r2)), Integer.valueOf(m419getNanosecondsComponentimpl(r2)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m435toComponentsimpl(long r2, Function2<? super Long, ? super Integer, ? extends T> r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        return (T) r4.invoke(Long.valueOf(m417getInWholeSecondsimpl(r2)), Integer.valueOf(m419getNanosecondsComponentimpl(r2)));
    }

    /* JADX INFO: renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m392addValuesMixedRangesUwyO8pc(long r6, long r8, long r10) {
        long r7 = DurationKt.access$nanosToMillis(r10);
        long r0 = r8 + r7;
        boolean r2 = false;
        if ((-4611686018426L) <= r0) goto L5;
    L7:
        if (r2 == false) goto L10;
        long r11 = r10 - DurationKt.access$millisToNanos(r7);
        return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(r0) + r11);
    L10:
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(r0, -4611686018427387903L, DurationKt.MAX_MILLIS));
    L5:
        if (r0 >= 4611686018427L) goto L7;
        r2 = true;
        goto L7
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static final String m446toStringimpl(long r2, DurationUnit r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "unit");
        if (r5 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        double r3 = m439toDoubleimpl(r2, r4);
        if (Double.isInfinite(r3) == false) goto L12;
        return String.valueOf(r3);
    L12:
        return DurationJvmKt.formatToExactDecimals(r3, RangesKt.coerceAtMost(r5, 12)) + DurationUnitKt__DurationUnitKt.shortName(r4);
    L14:
        throw new IllegalArgumentException(("decimals must be not negative, but was " + r5).toString());
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ String m447toStringimpl$default(long r0, DurationUnit r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        return m446toStringimpl(r0, r2, r3);
    }

    /* JADX INFO: renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m393appendFractionalimpl(long r3, StringBuilder r5, int r6, int r7, int r8, String r9, boolean r10) {
        r5.append(r6);
        if (r7 == 0) goto L20;
        r5.append('.');
        String r4 = StringsKt.padStart(String.valueOf(r7), r8, '0');
        int r11 = -1;
        int r12 = r4.length() - 1;
        if (r12 < 0) goto L15;
    L6:
        int r1 = r12 - 1;
        if (r4.charAt(r12) == '0') goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L11;
        if (r1 < 0) goto L15;
        r12 = r1;
        goto L6
    L11:
        r11 = r12;
        goto L15
    L9:
        r2 = false;
    L15:
        int r13 = r11 + 1;
        if (r10 == true) goto L19;
        if (r13 >= 3) goto L19;
        r5.append(r4, 0, r13);
    L19:
        r5.append(r4, 0, ((r13 + 2) / 3) * 3);
    L20:
        r5.append(r9);
    }
}
