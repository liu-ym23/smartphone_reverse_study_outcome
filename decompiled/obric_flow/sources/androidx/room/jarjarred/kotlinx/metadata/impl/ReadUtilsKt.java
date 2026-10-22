package androidx.room.jarjarred.kotlinx.metadata.impl;

import ai.j0;
import androidx.room.jarjarred.kotlinx.metadata.KmAnnotation;
import androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.Flags;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0003\u001a\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\f2\u0006\u0010\t\u001a\u00020\u0003¨\u0006\r"}, d2 = {"getClassName", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/NameResolver;", "index", "", "readAnnotation", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Annotation;", "strings", "readAnnotationArgument", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Annotation$Argument$Value;", "kotlinx-metadata"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ReadUtilsKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            r5[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r5[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r5[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r5[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r5[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r5[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r5[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r5[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r5[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r5[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r5[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r5[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r5[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public static final String getClassName(NameResolver r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r11 = r5.getQualifiedClassName(r10);
        if (r5.isLocalClassName(r10) == true) goto L5;
        return r11;
    L5:
        return j0.C(".", r11);
    }

    public static final KmAnnotation readAnnotation(ProtoBuf.Annotation r5, NameResolver r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "strings");
        String r11 = getClassName(r10, r5.getId());
        List<ProtoBuf.Annotation.Argument> r12 = r5.getArgumentList();
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L12;
        ProtoBuf.Annotation.Argument r15 = (ProtoBuf.Annotation.Argument) r14.next();
        KmAnnotationArgument r16 = readAnnotationArgument(r15.getValue(), r10);
        if (r16 == null) goto L8;
        Pair r17 = TuplesKt.to(r10.getString(r15.getNameId()), r16);
    L9:
        if (r17 == null) goto L4;
        r13.add(r17);
        goto L4
    L8:
        r17 = null;
        goto L9
    L12:
        return new KmAnnotation(r11, MapsKt.toMap(r13));
    }

    public static final KmAnnotationArgument readAnnotationArgument(ProtoBuf.Annotation.Argument.Value r10, NameResolver r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "strings");
        boolean r5 = true;
        int r12 = -1;
        if (Flags.IS_UNSIGNED.get(r10.getFlags()).booleanValue() == false) goto L22;
        ProtoBuf.Annotation.Argument.Value.Type r13 = r10.getType();
        if (r13 == null) goto L8;
        r12 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
    L8:
        if (r12 == 1) goto L21;
        if (r12 == 2) goto L60;
        if (r12 == 3) goto L59;
        if (r12 != 4) goto L17;
        return new KmAnnotationArgument.ULongValue(ULong.m298constructorimpl(r10.getIntValue()), null);
    L17:
        throw new IllegalStateException(("Cannot read value of unsigned type: " + r10.getType()).toString());
    L59:
        return new KmAnnotationArgument.UIntValue(UInt.m219constructorimpl((int) r10.getIntValue()), null);
    L60:
        return new KmAnnotationArgument.UShortValue(UShort.m405constructorimpl((short) r10.getIntValue()), null);
    L21:
        return new KmAnnotationArgument.UByteValue(UByte.m142constructorimpl((byte) r10.getIntValue()), null);
    L22:
        ProtoBuf.Annotation.Argument.Value.Type r14 = r10.getType();
        if (r14 == null) goto L26;
        r12 = WhenMappings.$EnumSwitchMapping$0[r14.ordinal()];
    L26:
        switch(r12) {
            case -1: goto L61;
            case 0: goto L28;
            case 1: goto L52;
            case 2: goto L73;
            case 3: goto L72;
            case 4: goto L71;
            case 5: goto L70;
            case 6: goto L69;
            case 7: goto L68;
            case 8: goto L41;
            case 9: goto L66;
            case 10: goto L65;
            case 11: goto L64;
            case 12: goto L63;
            case 13: goto L29;
            default: goto L28;
        };
    L29:
        List<ProtoBuf.Annotation.Argument.Value> r15 = r10.getArrayElementList();
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L31:
        if (r17.hasNext() == false) goto L62;
        KmAnnotationArgument r18 = readAnnotationArgument((ProtoBuf.Annotation.Argument.Value) r17.next(), r11);
        if (r18 == null) goto L31;
        r16.add(r18);
        goto L31
    L62:
        return new KmAnnotationArgument.ArrayValue(r16);
    L61:
        return null;
    L28:
        throw new NoWhenBranchMatchedException();
    L63:
        return new KmAnnotationArgument.AnnotationValue(readAnnotation(r10.getAnnotation(), r11));
    L64:
        return new KmAnnotationArgument.EnumValue(getClassName(r11, r10.getClassId()), r11.getString(r10.getEnumValueId()));
    L65:
        return new KmAnnotationArgument.KClassValue(getClassName(r11, r10.getClassId()), r10.getArrayDimensionCount());
    L66:
        return new KmAnnotationArgument.StringValue(r11.getString(r10.getStringValue()));
    L41:
        if (r10.getIntValue() != 0) goto L67;
        r5 = false;
    L67:
        return new KmAnnotationArgument.BooleanValue(r5);
    L68:
        return new KmAnnotationArgument.DoubleValue(r10.getDoubleValue());
    L69:
        return new KmAnnotationArgument.FloatValue(r10.getFloatValue());
    L70:
        return new KmAnnotationArgument.CharValue((char) r10.getIntValue());
    L71:
        return new KmAnnotationArgument.LongValue(r10.getIntValue());
    L72:
        return new KmAnnotationArgument.IntValue((int) r10.getIntValue());
    L73:
        return new KmAnnotationArgument.ShortValue((short) r10.getIntValue());
    L52:
        return new KmAnnotationArgument.ByteValue((byte) r10.getIntValue());
    }
}
