package kotlinx.serialization.a;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.time.Duration;
import kotlinx.serialization.c;
import kotlinx.serialization.internal.aa;
import kotlinx.serialization.internal.ab;
import kotlinx.serialization.internal.af;
import kotlinx.serialization.internal.ag;
import kotlinx.serialization.internal.ap;
import kotlinx.serialization.internal.aq;
import kotlinx.serialization.internal.au;
import kotlinx.serialization.internal.az;
import kotlinx.serialization.internal.ba;
import kotlinx.serialization.internal.bb;
import kotlinx.serialization.internal.bg;
import kotlinx.serialization.internal.bi;
import kotlinx.serialization.internal.bv;
import kotlinx.serialization.internal.bz;
import kotlinx.serialization.internal.ca;
import kotlinx.serialization.internal.cb;
import kotlinx.serialization.internal.ce;
import kotlinx.serialization.internal.ch;
import kotlinx.serialization.internal.ci;
import kotlinx.serialization.internal.ck;
import kotlinx.serialization.internal.cl;
import kotlinx.serialization.internal.cn;
import kotlinx.serialization.internal.co;
import kotlinx.serialization.internal.cq;
import kotlinx.serialization.internal.cr;
import kotlinx.serialization.internal.cs;
import kotlinx.serialization.internal.f;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.i;
import kotlinx.serialization.internal.k;
import kotlinx.serialization.internal.l;
import kotlinx.serialization.internal.q;
import kotlinx.serialization.internal.r;
import kotlinx.serialization.internal.z;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aF\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\t0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010\n*\u0004\u0018\u0001H\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001H\u0007\u001a=\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\t0\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\f\b\u0001\u0010\n\u0018\u0001*\u0004\u0018\u0001H\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001H\u0087\b\u001a\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001\u001a\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001\u001a\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001\u001a\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001\u001a\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001\u001a\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001\u001a&\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001b0\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0001\u001a@\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!0\u001f0\u0001\"\u0004\b\u0000\u0010 \"\u0004\b\u0001\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H 0\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0\u0001\u001a@\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!0%0\u0001\"\u0004\b\u0000\u0010 \"\u0004\b\u0001\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H 0\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0\u0001\u001a@\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!0'0\u0001\"\u0004\b\u0000\u0010 \"\u0004\b\u0001\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H 0\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0\u0001\u001a&\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020)0\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0001\u001aZ\u0010,\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u0002H00-0\u0001\"\u0004\b\u0000\u0010.\"\u0004\b\u0001\u0010/\"\u0004\b\u0002\u001002\f\u00101\u001a\b\u0012\u0004\u0012\u0002H.0\u00012\f\u00102\u001a\b\u0012\u0004\u0012\u0002H/0\u00012\f\u00103\u001a\b\u0012\u0004\u0012\u0002H00\u0001\u001a\u0011\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0001H\u0007ø\u0001\u0000\u001a\u0011\u00106\u001a\b\u0012\u0004\u0012\u0002070\u0001H\u0007ø\u0001\u0000\u001a\u0011\u00108\u001a\b\u0012\u0004\u0012\u0002090\u0001H\u0007ø\u0001\u0000\u001a\u0011\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0001H\u0007ø\u0001\u0000\u001a\u0015\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0001*\u00020>¢\u0006\u0002\u0010?\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020@0\u0001*\u00020A\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020B0\u0001*\u00020C\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020D0\u0001*\u00020E\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020F0\u0001*\u00020G\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020H0\u0001*\u00020I\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020J0\u0001*\u00020K\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020L0\u0001*\u00020M\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020N0\u0001*\u00020O\u001a\u0013\u0010<\u001a\b\u0012\u0004\u0012\u00020P0\u0001*\u00020Qø\u0001\u0000\u001a\u0013\u0010<\u001a\b\u0012\u0004\u0012\u00020R0\u0001*\u00020Sø\u0001\u0000\u001a\u0013\u0010<\u001a\b\u0012\u0004\u0012\u00020T0\u0001*\u00020Uø\u0001\u0000\u001a\u0013\u0010<\u001a\b\u0012\u0004\u0012\u00020V0\u0001*\u00020Wø\u0001\u0000\u001a\u0015\u0010<\u001a\b\u0012\u0004\u0012\u00020X0\u0001*\u00020X¢\u0006\u0002\u0010Y\u001a\u0013\u0010<\u001a\b\u0012\u0004\u0012\u00020Z0\u0001*\u00020[ø\u0001\u0000\"3\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\\"}, d2 = {"nullable", "Lkotlinx/serialization/KSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "", "getNullable$annotations", "(Lkotlinx/serialization/KSerializer;)V", "getNullable", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "ArraySerializer", "", ExifInterface.LONGITUDE_EAST, "kClass", "Lkotlin/reflect/KClass;", "elementSerializer", "BooleanArraySerializer", "", "ByteArraySerializer", "", "CharArraySerializer", "", "DoubleArraySerializer", "", "FloatArraySerializer", "", "IntArraySerializer", "", "ListSerializer", "", "LongArraySerializer", "", "MapEntrySerializer", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "keySerializer", "valueSerializer", "MapSerializer", "", "PairSerializer", "Lkotlin/Pair;", "SetSerializer", "", "ShortArraySerializer", "", "TripleSerializer", "Lkotlin/Triple;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "aSerializer", "bSerializer", "cSerializer", "UByteArraySerializer", "Lkotlin/UByteArray;", "UIntArraySerializer", "Lkotlin/UIntArray;", "ULongArraySerializer", "Lkotlin/ULongArray;", "UShortArraySerializer", "Lkotlin/UShortArray;", "serializer", "", "Lkotlin/Boolean$Companion;", "(Lkotlin/jvm/internal/BooleanCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "Lkotlin/Byte$Companion;", "", "Lkotlin/Char$Companion;", "", "Lkotlin/Double$Companion;", "", "Lkotlin/Float$Companion;", "", "Lkotlin/Int$Companion;", "", "Lkotlin/Long$Companion;", "", "Lkotlin/Short$Companion;", "", "Lkotlin/String$Companion;", "Lkotlin/UByte;", "Lkotlin/UByte$Companion;", "Lkotlin/UInt;", "Lkotlin/UInt$Companion;", "Lkotlin/ULong;", "Lkotlin/ULong$Companion;", "Lkotlin/UShort;", "Lkotlin/UShort$Companion;", "", "(Lkotlin/Unit;)Lkotlinx/serialization/KSerializer;", "Lkotlin/time/Duration;", "Lkotlin/time/Duration$Companion;", "kotlinx-serialization-core"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class a {
    public static final c<char[]> a() {
        return (c) ZeusTransformUtils.preCheckCast(q.f17809a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<UByte> a(UByte.Companion r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(ci.f17775a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<UInt> a(UInt.Companion r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(cl.f17780a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<ULong> a(ULong.Companion r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(co.f17785a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<UShort> a(UShort.Companion r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(cr.f17790a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<Unit> a(Unit r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(cs.f17792a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<Boolean> a(BooleanCompanionObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(i.f17798a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<Byte> a(ByteCompanionObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(l.f17803a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<Character> a(CharCompanionObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(r.f17810a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<Double> a(DoubleCompanionObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(aa.f17701a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<Float> a(FloatCompanionObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(ag.f17712a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<Integer> a(IntCompanionObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(aq.f17721a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<Long> a(LongCompanionObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(ba.f17732a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<Short> a(ShortCompanionObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(ca.f17763a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<String> a(StringCompanionObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(cb.f17765a, c.class, "com.obric.memorydata.plugin");
    }

    public static final <T, E extends T> c<E[]> a(KClass<T> r2, c<E> r3) {
        KClass r4 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "kClass");
        Intrinsics.checkNotNullParameter(r5, "elementSerializer");
        return (c) ZeusTransformUtils.preCheckCast(new bv(r4, r5), c.class, "com.obric.memorydata.plugin");
    }

    public static final c<Duration> a(Duration.Companion r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (c) ZeusTransformUtils.preCheckCast(ab.f17703a, c.class, "com.obric.memorydata.plugin");
    }

    public static final <T> c<T> a(c<T> r2) {
        c<T> r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.a().d() == false) goto L6;
        return r3;
    L6:
        return (c) ZeusTransformUtils.preCheckCast(new bg(r3), c.class, "com.obric.memorydata.plugin");
    }

    public static final <K, V> c<Pair<K, V>> a(c<K> r2, c<V> r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "keySerializer");
        Intrinsics.checkNotNullParameter(r5, "valueSerializer");
        return (c) ZeusTransformUtils.preCheckCast(new bi(r4, r5), c.class, "com.obric.memorydata.plugin");
    }

    public static final <A, B, C> c<Triple<A, B, C>> a(c<A> r2, c<B> r3, c<C> r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "aSerializer");
        Intrinsics.checkNotNullParameter(r6, "bSerializer");
        Intrinsics.checkNotNullParameter(r7, "cSerializer");
        return (c) ZeusTransformUtils.preCheckCast(new ce(r5, r6, r7), c.class, "com.obric.memorydata.plugin");
    }

    public static final c<byte[]> b() {
        return (c) ZeusTransformUtils.preCheckCast(k.f17802a, c.class, "com.obric.memorydata.plugin");
    }

    public static final <T> c<List<T>> b(c<T> r2) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "elementSerializer");
        return (c) ZeusTransformUtils.preCheckCast(new f(r3), c.class, "com.obric.memorydata.plugin");
    }

    public static final <K, V> c<Map.Entry<K, V>> b(c<K> r2, c<V> r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "keySerializer");
        Intrinsics.checkNotNullParameter(r5, "valueSerializer");
        return (c) ZeusTransformUtils.preCheckCast(new bb(r4, r5), c.class, "com.obric.memorydata.plugin");
    }

    public static final c<UByteArray> c() {
        return (c) ZeusTransformUtils.preCheckCast(ch.f17774a, c.class, "com.obric.memorydata.plugin");
    }

    public static final <K, V> c<Map<K, V>> c(c<K> r2, c<V> r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "keySerializer");
        Intrinsics.checkNotNullParameter(r5, "valueSerializer");
        return (c) ZeusTransformUtils.preCheckCast(new au(r4, r5), c.class, "com.obric.memorydata.plugin");
    }

    public static final c<short[]> d() {
        return (c) ZeusTransformUtils.preCheckCast(bz.f17762a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<UShortArray> e() {
        return (c) ZeusTransformUtils.preCheckCast(cq.f17789a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<int[]> f() {
        return (c) ZeusTransformUtils.preCheckCast(ap.f17720a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<UIntArray> g() {
        return (c) ZeusTransformUtils.preCheckCast(ck.f17779a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<long[]> h() {
        return (c) ZeusTransformUtils.preCheckCast(az.f17731a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<ULongArray> i() {
        return (c) ZeusTransformUtils.preCheckCast(cn.f17784a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<float[]> j() {
        return (c) ZeusTransformUtils.preCheckCast(af.f17711a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<double[]> k() {
        return (c) ZeusTransformUtils.preCheckCast(z.f17824a, c.class, "com.obric.memorydata.plugin");
    }

    public static final c<boolean[]> l() {
        return (c) ZeusTransformUtils.preCheckCast(h.f17797a, c.class, "com.obric.memorydata.plugin");
    }
}
