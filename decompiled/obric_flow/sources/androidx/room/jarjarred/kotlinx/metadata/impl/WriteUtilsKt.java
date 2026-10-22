package androidx.room.jarjarred.kotlinx.metadata.impl;

import androidx.room.jarjarred.kotlinx.metadata.ClassNameKt;
import androidx.room.jarjarred.kotlinx.metadata.KmAnnotation;
import androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.Flags;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.StringTable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\t\u001a\u00020\u0002¨\u0006\r"}, d2 = {"getClassNameIndex", "", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/StringTable;", "name", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "writeAnnotation", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Annotation$Builder;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "strings", "writeAnnotationArgument", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Annotation$Argument$Value$Builder;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument;", "kotlinx-metadata"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class WriteUtilsKt {
    public static final int getClassNameIndex(StringTable r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "name");
        if (ClassNameKt.isLocal(r10) == false) goto L6;
        return r5.getQualifiedClassNameIndex(r10.substring(1), true);
    L6:
        return r5.getQualifiedClassNameIndex(r10, false);
    }

    public static final ProtoBuf.Annotation.Builder writeAnnotation(KmAnnotation r5, StringTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "strings");
        ProtoBuf.Annotation.Builder r11 = ProtoBuf.Annotation.newBuilder();
        r11.setId(getClassNameIndex(r10, r5.getClassName()));
        Iterator<Map.Entry<String, KmAnnotationArgument>> r12 = r5.getArguments().entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<String, KmAnnotationArgument> r13 = r12.next();
        String r14 = r13.getKey();
        KmAnnotationArgument r15 = r13.getValue();
        ProtoBuf.Annotation.Argument.Builder r16 = ProtoBuf.Annotation.Argument.newBuilder();
        r16.setNameId(r10.getStringIndex(r14));
        r16.setValue(writeAnnotationArgument(r15, r10).build());
        r11.addArgument(r16);
        goto L4
    L6:
        return r11;
    }

    public static final ProtoBuf.Annotation.Argument.Value.Builder writeAnnotationArgument(KmAnnotationArgument r5, StringTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "strings");
        ProtoBuf.Annotation.Argument.Value.Builder r11 = ProtoBuf.Annotation.Argument.Value.newBuilder();
        if ((r5 instanceof KmAnnotationArgument.ByteValue) == false) goto L6;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.BYTE);
        r11.setIntValue(((KmAnnotationArgument.ByteValue) r5).getValue().byteValue());
    L60:
        return r11;
    L6:
        if ((r5 instanceof KmAnnotationArgument.CharValue) == false) goto L9;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.CHAR);
        r11.setIntValue(((KmAnnotationArgument.CharValue) r5).getValue().charValue());
        goto L60
    L9:
        if ((r5 instanceof KmAnnotationArgument.ShortValue) == false) goto L12;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.SHORT);
        r11.setIntValue(((KmAnnotationArgument.ShortValue) r5).getValue2().shortValue());
        goto L60
    L12:
        if ((r5 instanceof KmAnnotationArgument.IntValue) == false) goto L15;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.INT);
        r11.setIntValue(((KmAnnotationArgument.IntValue) r5).getValue().intValue());
        goto L60
    L15:
        if ((r5 instanceof KmAnnotationArgument.LongValue) == false) goto L18;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.LONG);
        r11.setIntValue(((KmAnnotationArgument.LongValue) r5).getValue().longValue());
        goto L60
    L18:
        if ((r5 instanceof KmAnnotationArgument.FloatValue) == false) goto L21;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.FLOAT);
        r11.setFloatValue(((KmAnnotationArgument.FloatValue) r5).getValue().floatValue());
        goto L60
    L21:
        if ((r5 instanceof KmAnnotationArgument.DoubleValue) == false) goto L24;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.DOUBLE);
        r11.setDoubleValue(((KmAnnotationArgument.DoubleValue) r5).getValue().doubleValue());
        goto L60
    L24:
        if ((r5 instanceof KmAnnotationArgument.BooleanValue) == false) goto L31;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN);
        if (((KmAnnotationArgument.BooleanValue) r5).getValue().booleanValue() == false) goto L28;
        long r12 = 1;
    L29:
        r11.setIntValue(r12);
        goto L60
    L28:
        r12 = 0;
        goto L29
    L31:
        if ((r5 instanceof KmAnnotationArgument.UByteValue) == false) goto L34;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.BYTE);
        r11.setIntValue(((long) ((KmAnnotationArgument.UByteValue) r5).m63getValuew2LRezQ()) & 255);
        r11.setFlags(Flags.IS_UNSIGNED.toFlags2(Boolean.TRUE));
        goto L60
    L34:
        if ((r5 instanceof KmAnnotationArgument.UShortValue) == false) goto L37;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.SHORT);
        r11.setIntValue(((long) ((KmAnnotationArgument.UShortValue) r5).m75getValueMh2AYeg()) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        r11.setFlags(Flags.IS_UNSIGNED.toFlags2(Boolean.TRUE));
        goto L60
    L37:
        if ((r5 instanceof KmAnnotationArgument.UIntValue) == false) goto L40;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.INT);
        r11.setIntValue(((long) ((KmAnnotationArgument.UIntValue) r5).m67getValuepVg5ArA()) & 4294967295L);
        r11.setFlags(Flags.IS_UNSIGNED.toFlags2(Boolean.TRUE));
        goto L60
    L40:
        if ((r5 instanceof KmAnnotationArgument.ULongValue) == false) goto L43;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.LONG);
        r11.setIntValue(((KmAnnotationArgument.ULongValue) r5).m71getValuesVKNKU());
        r11.setFlags(Flags.IS_UNSIGNED.toFlags2(Boolean.TRUE));
        goto L60
    L43:
        if ((r5 instanceof KmAnnotationArgument.StringValue) == false) goto L46;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.STRING);
        r11.setStringValue(r10.getStringIndex(((KmAnnotationArgument.StringValue) r5).getValue2()));
        goto L60
    L46:
        if ((r5 instanceof KmAnnotationArgument.KClassValue) == false) goto L49;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.CLASS);
        KmAnnotationArgument.KClassValue r13 = (KmAnnotationArgument.KClassValue) r5;
        r11.setClassId(getClassNameIndex(r10, r13.getClassName()));
        r11.setArrayDimensionCount(r13.getArrayDimensionCount());
        goto L60
    L49:
        if ((r5 instanceof KmAnnotationArgument.EnumValue) == false) goto L52;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.ENUM);
        KmAnnotationArgument.EnumValue r14 = (KmAnnotationArgument.EnumValue) r5;
        r11.setClassId(getClassNameIndex(r10, r14.getEnumClassName()));
        r11.setEnumValueId(r10.getStringIndex(r14.getEnumEntryName()));
        goto L60
    L52:
        if ((r5 instanceof KmAnnotationArgument.AnnotationValue) == false) goto L55;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION);
        r11.setAnnotation(writeAnnotation(((KmAnnotationArgument.AnnotationValue) r5).getAnnotation(), r10).build());
        goto L60
    L55:
        if ((r5 instanceof KmAnnotationArgument.ArrayValue) == false) goto L60;
        r11.setType(ProtoBuf.Annotation.Argument.Value.Type.ARRAY);
        Iterator<KmAnnotationArgument> r15 = ((KmAnnotationArgument.ArrayValue) r5).getElements().iterator();
    L58:
        if (r15.hasNext() == false) goto L60;
        r11.addArrayElement(writeAnnotationArgument(r15.next(), r10));
        goto L58
    }
}
