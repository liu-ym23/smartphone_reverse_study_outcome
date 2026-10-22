package kotlinx.serialization.internal;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f19281a = null;

    static {
        KClass r5 = Reflection.getOrCreateKotlinClass(String.class);
        du.a.b(StringCompanionObject.INSTANCE);
        Pair r10 = TuplesKt.to(r5, m1.f19311a);
        KClass r11 = Reflection.getOrCreateKotlinClass(Character.TYPE);
        Intrinsics.checkNotNullParameter(CharCompanionObject.INSTANCE, "<this>");
        Pair r12 = TuplesKt.to(r11, p.f19325a);
        Pair r13 = TuplesKt.to(Reflection.getOrCreateKotlinClass(char[].class), o.f19319c);
        KClass r14 = Reflection.getOrCreateKotlinClass(Double.TYPE);
        Intrinsics.checkNotNullParameter(DoubleCompanionObject.INSTANCE, "<this>");
        Pair r15 = TuplesKt.to(r14, u.f19348a);
        Pair r16 = TuplesKt.to(Reflection.getOrCreateKotlinClass(double[].class), t.f19345c);
        KClass r17 = Reflection.getOrCreateKotlinClass(Float.TYPE);
        Intrinsics.checkNotNullParameter(FloatCompanionObject.INSTANCE, "<this>");
        Pair r18 = TuplesKt.to(r17, b0.f19261a);
        Pair r19 = TuplesKt.to(Reflection.getOrCreateKotlinClass(float[].class), a0.f19251c);
        KClass r20 = Reflection.getOrCreateKotlinClass(Long.TYPE);
        Intrinsics.checkNotNullParameter(LongCompanionObject.INSTANCE, "<this>");
        Pair r21 = TuplesKt.to(r20, n0.f19315a);
        Pair r110 = TuplesKt.to(Reflection.getOrCreateKotlinClass(long[].class), m0.f19310c);
        KClass r22 = Reflection.getOrCreateKotlinClass(ULong.class);
        Intrinsics.checkNotNullParameter(ULong.Companion, "<this>");
        Pair r111 = TuplesKt.to(r22, x1.f19370a);
        Pair r112 = TuplesKt.to(Reflection.getOrCreateKotlinClass(ULongArray.class), w1.f19366c);
        KClass r23 = Reflection.getOrCreateKotlinClass(Integer.TYPE);
        Intrinsics.checkNotNullParameter(IntCompanionObject.INSTANCE, "<this>");
        Pair r113 = TuplesKt.to(r23, i0.f19295a);
        Pair r114 = TuplesKt.to(Reflection.getOrCreateKotlinClass(int[].class), h0.f19290c);
        KClass r24 = Reflection.getOrCreateKotlinClass(UInt.class);
        Intrinsics.checkNotNullParameter(UInt.Companion, "<this>");
        Pair r115 = TuplesKt.to(r24, u1.f19352a);
        Pair r25 = TuplesKt.to(Reflection.getOrCreateKotlinClass(UIntArray.class), t1.f19347c);
        KClass r116 = Reflection.getOrCreateKotlinClass(Short.TYPE);
        Intrinsics.checkNotNullParameter(ShortCompanionObject.INSTANCE, "<this>");
        Pair r26 = TuplesKt.to(r116, l1.f19307a);
        Pair r27 = TuplesKt.to(Reflection.getOrCreateKotlinClass(short[].class), k1.f19304c);
        KClass r117 = Reflection.getOrCreateKotlinClass(UShort.class);
        Intrinsics.checkNotNullParameter(UShort.Companion, "<this>");
        Pair r28 = TuplesKt.to(r117, a2.f19259a);
        Pair r29 = TuplesKt.to(Reflection.getOrCreateKotlinClass(UShortArray.class), z1.f19381c);
        KClass r118 = Reflection.getOrCreateKotlinClass(Byte.TYPE);
        Intrinsics.checkNotNullParameter(ByteCompanionObject.INSTANCE, "<this>");
        Pair r30 = TuplesKt.to(r118, j.f19297a);
        Pair r31 = TuplesKt.to(Reflection.getOrCreateKotlinClass(byte[].class), i.f19294c);
        KClass r119 = Reflection.getOrCreateKotlinClass(UByte.class);
        Intrinsics.checkNotNullParameter(UByte.Companion, "<this>");
        Pair r32 = TuplesKt.to(r119, r1.f19339a);
        Pair r33 = TuplesKt.to(Reflection.getOrCreateKotlinClass(UByteArray.class), q1.f19336c);
        KClass r120 = Reflection.getOrCreateKotlinClass(Boolean.TYPE);
        Intrinsics.checkNotNullParameter(BooleanCompanionObject.INSTANCE, "<this>");
        Pair r34 = TuplesKt.to(r120, g.f19282a);
        Pair r35 = TuplesKt.to(Reflection.getOrCreateKotlinClass(boolean[].class), f.f19279c);
        KClass r121 = Reflection.getOrCreateKotlinClass(Unit.class);
        Intrinsics.checkNotNullParameter(Unit.INSTANCE, "<this>");
        Pair r36 = TuplesKt.to(r121, b2.f19263b);
        Pair r37 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Void.class), u0.f19350a);
        KClass r122 = Reflection.getOrCreateKotlinClass(Duration.class);
        Intrinsics.checkNotNullParameter(Duration.Companion, "<this>");
        f19281a = MapsKt.mapOf(new Pair[]{r10, r12, r13, r15, r16, r18, r19, r21, r110, r111, r112, r113, r114, r115, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, TuplesKt.to(r122, v.f19354a)});
    }

    public static final String a(String r5) {
        if (r5.length() <= 0) goto L10;
        StringBuilder r10 = new StringBuilder();
        char r11 = r5.charAt(0);
        if (Character.isLowerCase(r11) == false) goto L7;
        String r12 = CharsKt.titlecase(r11);
    L8:
        r10.append(r12);
        r10.append(r5.substring(1));
        return r10.toString();
    L7:
        r12 = String.valueOf(r11);
        goto L8
    L10:
        return r5;
    }
}
