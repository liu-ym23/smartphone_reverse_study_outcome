package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
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
import kotlin.text.StringsKt;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a$\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u0004\"\b\b\u0000\u0010\u0010*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00100\u0002H\u0000\u001a\f\u0010\u0011\u001a\u00020\n*\u00020\nH\u0002\"2\u0010\u0000\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00040\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"BUILTIN_SERIALIZERS", "", "Lkotlin/reflect/KClass;", "", "Lkotlinx/serialization/KSerializer;", "getBUILTIN_SERIALIZERS$annotations", "()V", "PrimitiveDescriptorSafe", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lkotlinx/serialization/descriptors/PrimitiveKind;", "checkName", "", "builtinSerializerOrNull", ExifInterface.GPS_DIRECTION_TRUE, "capitalize", "kotlinx-serialization-core"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class bu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<KClass<? extends Object>, kotlinx.serialization.c<? extends Object>> f17755a = null;

    static {
        f17755a = MapsKt.mapOf(new Pair[]{TuplesKt.to(Reflection.getOrCreateKotlinClass(String.class), kotlinx.serialization.a.a.a(StringCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Character.TYPE), kotlinx.serialization.a.a.a(CharCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(char[].class), kotlinx.serialization.a.a.a()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Double.TYPE), kotlinx.serialization.a.a.a(DoubleCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(double[].class), kotlinx.serialization.a.a.k()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Float.TYPE), kotlinx.serialization.a.a.a(FloatCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(float[].class), kotlinx.serialization.a.a.j()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Long.TYPE), kotlinx.serialization.a.a.a(LongCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(long[].class), kotlinx.serialization.a.a.h()), TuplesKt.to(Reflection.getOrCreateKotlinClass(ULong.class), kotlinx.serialization.a.a.a(ULong.Companion)), TuplesKt.to(Reflection.getOrCreateKotlinClass(ULongArray.class), kotlinx.serialization.a.a.i()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Integer.TYPE), kotlinx.serialization.a.a.a(IntCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(int[].class), kotlinx.serialization.a.a.f()), TuplesKt.to(Reflection.getOrCreateKotlinClass(UInt.class), kotlinx.serialization.a.a.a(UInt.Companion)), TuplesKt.to(Reflection.getOrCreateKotlinClass(UIntArray.class), kotlinx.serialization.a.a.g()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Short.TYPE), kotlinx.serialization.a.a.a(ShortCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(short[].class), kotlinx.serialization.a.a.d()), TuplesKt.to(Reflection.getOrCreateKotlinClass(UShort.class), kotlinx.serialization.a.a.a(UShort.Companion)), TuplesKt.to(Reflection.getOrCreateKotlinClass(UShortArray.class), kotlinx.serialization.a.a.e()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Byte.TYPE), kotlinx.serialization.a.a.a(ByteCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(byte[].class), kotlinx.serialization.a.a.b()), TuplesKt.to(Reflection.getOrCreateKotlinClass(UByte.class), kotlinx.serialization.a.a.a(UByte.Companion)), TuplesKt.to(Reflection.getOrCreateKotlinClass(UByteArray.class), kotlinx.serialization.a.a.c()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Boolean.TYPE), kotlinx.serialization.a.a.a(BooleanCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(boolean[].class), kotlinx.serialization.a.a.l()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Unit.class), kotlinx.serialization.a.a.a(Unit.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Duration.class), kotlinx.serialization.a.a.a(Duration.Companion))});
    }

    public static final <T> kotlinx.serialization.c<T> a(KClass<T> r2) {
        KClass r3 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return (kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(f17755a.get(r3), kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
    }

    public static final kotlinx.serialization.descriptors.f a(String r1, kotlinx.serialization.descriptors.e r2) {
        Intrinsics.checkNotNullParameter(r1, "serialName");
        Intrinsics.checkNotNullParameter(r2, MemoryInfoSectionEditActivity.EXTRA_KIND);
        a(r1);
        return (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(new bt(r1, r2), kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
    }

    private static final void a(String r4) {
        Iterator<KClass<? extends Object>> r0 = f17755a.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r1 = ((KClass) ZeusTransformUtils.preCheckCast(r0.next(), KClass.class, "com.obric.memorydata.plugin")).getSimpleName();
        Intrinsics.checkNotNull(r1);
        String r2 = b(r1);
        if (StringsKt.equals(r4, "kotlin." + r2, true) == true) goto L11;
        if (StringsKt.equals(r4, r2, true) == false) goto L4;
    L11:
        throw new IllegalArgumentException(StringsKt.trimIndent("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + r4 + " there already exist " + b(r2) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
    }

    private static final String b(String r4) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        StringBuilder r1 = new StringBuilder();
        char r2 = r4.charAt(0);
        if (Character.isLowerCase(r2) == false) goto L10;
        String r3 = CharsKt.titlecase(r2);
    L11:
        StringBuilder r5 = r1.append(r3);
        String r6 = r4.substring(1);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).substring(startIndex)");
        return r5.append(r6).toString();
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
