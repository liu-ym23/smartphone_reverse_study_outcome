package nuc;

import java.util.Map;
import juc.d;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class n2 {
    public static final Map<KClass<? extends Object>, d<? extends Object>> a = null;

    static {
        KClass r1 = Reflection.getOrCreateKotlinClass(String.class);
        kuc.a.f(StringCompanionObject.INSTANCE);
        KClass r2 = Reflection.getOrCreateKotlinClass(Character.TYPE);
        Intrinsics.checkNotNullParameter(CharCompanionObject.INSTANCE, "<this>");
        KClass r3 = Reflection.getOrCreateKotlinClass(Double.TYPE);
        Intrinsics.checkNotNullParameter(DoubleCompanionObject.INSTANCE, "<this>");
        KClass r4 = Reflection.getOrCreateKotlinClass(Float.TYPE);
        Intrinsics.checkNotNullParameter(FloatCompanionObject.INSTANCE, "<this>");
        KClass r5 = Reflection.getOrCreateKotlinClass(Long.TYPE);
        Intrinsics.checkNotNullParameter(LongCompanionObject.INSTANCE, "<this>");
        KClass r6 = Reflection.getOrCreateKotlinClass(ULong.class);
        Intrinsics.checkNotNullParameter(ULong.Companion, "<this>");
        KClass r7 = Reflection.getOrCreateKotlinClass(Integer.TYPE);
        kuc.a.e(IntCompanionObject.INSTANCE);
        KClass r8 = Reflection.getOrCreateKotlinClass(UInt.class);
        Intrinsics.checkNotNullParameter(UInt.Companion, "<this>");
        KClass r9 = Reflection.getOrCreateKotlinClass(Short.TYPE);
        Intrinsics.checkNotNullParameter(ShortCompanionObject.INSTANCE, "<this>");
        KClass r10 = Reflection.getOrCreateKotlinClass(UShort.class);
        Intrinsics.checkNotNullParameter(UShort.Companion, "<this>");
        KClass r11 = Reflection.getOrCreateKotlinClass(Byte.TYPE);
        Intrinsics.checkNotNullParameter(ByteCompanionObject.INSTANCE, "<this>");
        KClass r12 = Reflection.getOrCreateKotlinClass(UByte.class);
        Intrinsics.checkNotNullParameter(UByte.Companion, "<this>");
        KClass r13 = Reflection.getOrCreateKotlinClass(Boolean.TYPE);
        Intrinsics.checkNotNullParameter(BooleanCompanionObject.INSTANCE, "<this>");
        KClass r14 = Reflection.getOrCreateKotlinClass(Unit.class);
        Intrinsics.checkNotNullParameter(Unit.INSTANCE, "<this>");
        KClass r15 = Reflection.getOrCreateKotlinClass(Duration.class);
        Intrinsics.checkNotNullParameter(Duration.Companion, "<this>");
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r1, v2.a), TuplesKt.to(r2, r.a), TuplesKt.to(Reflection.getOrCreateKotlinClass(char[].class), q.c), TuplesKt.to(r3, b0.a), TuplesKt.to(Reflection.getOrCreateKotlinClass(double[].class), a0.c), TuplesKt.to(r4, l0.a), TuplesKt.to(Reflection.getOrCreateKotlinClass(float[].class), k0.c), TuplesKt.to(r5, g1.a), TuplesKt.to(Reflection.getOrCreateKotlinClass(long[].class), f1.c), TuplesKt.to(r6, j3.a), TuplesKt.to(Reflection.getOrCreateKotlinClass(ULongArray.class), i3.c), TuplesKt.to(r7, w0.a), TuplesKt.to(Reflection.getOrCreateKotlinClass(int[].class), v0.c), TuplesKt.to(r8, g3.a), TuplesKt.to(Reflection.getOrCreateKotlinClass(UIntArray.class), f3.c), TuplesKt.to(r9, u2.a), TuplesKt.to(Reflection.getOrCreateKotlinClass(short[].class), t2.c), TuplesKt.to(r10, m3.a), TuplesKt.to(Reflection.getOrCreateKotlinClass(UShortArray.class), l3.c), TuplesKt.to(r11, l.a), TuplesKt.to(Reflection.getOrCreateKotlinClass(byte[].class), k.c), TuplesKt.to(r12, d3.a), TuplesKt.to(Reflection.getOrCreateKotlinClass(UByteArray.class), c3.c), TuplesKt.to(r13, i.a), TuplesKt.to(Reflection.getOrCreateKotlinClass(boolean[].class), h.c), TuplesKt.to(r14, n3.b), TuplesKt.to(Reflection.getOrCreateKotlinClass(Void.class), q1.a), TuplesKt.to(r15, c0.a)});
    }

    public static final String a(String r4) {
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        StringBuilder r1 = new StringBuilder();
        char r2 = r4.charAt(0);
        if (Character.isLowerCase(r2) == false) goto L10;
        String r3 = CharsKt.titlecase(r2);
    L11:
        r1.append(r3);
        r1.append(r4.substring(1));
        return r1.toString();
    L10:
        r3 = String.valueOf(r2);
        goto L11
    L13:
        return r4;
    L5:
        r0 = false;
        goto L6
    }
}
