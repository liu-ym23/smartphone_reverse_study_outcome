package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization;

import ai.j0;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolver;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.ProtoBufUtilKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.ProtoTypeTableUtilKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.TypeTable;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.serialization.JvmStringTable;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ExtensionRegistryLite;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J*\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0016J \u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0014H\u0007J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u001bH\u0007J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J5\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001b0 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0007¢\u0006\u0002\u0010%J/\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001b0 2\u0006\u0010&\u001a\u00020'2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0007¢\u0006\u0002\u0010(J5\u0010)\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00180 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0007¢\u0006\u0002\u0010%J5\u0010*\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020+0 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0007¢\u0006\u0002\u0010%J/\u0010*\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020+0 2\u0006\u0010&\u001a\u00020'2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0007¢\u0006\u0002\u0010(J#\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040#2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u00101J \u00102\u001a\n 3*\u0004\u0018\u00010'0'2\u0006\u0010/\u001a\u0002002\u0006\u0010-\u001a\u00020.H\u0007J\u001f\u00104\u001a\u00020!*\u0002052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0002¢\u0006\u0002\u00106R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmProtoBufUtil;", "", "()V", "DEFAULT_MODULE_NAME", "", "EXTENSION_REGISTRY", "Landroidx/room/jarjarred/kotlinx/metadata/internal/protobuf/ExtensionRegistryLite;", "getEXTENSION_REGISTRY", "()Lorg/jetbrains/kotlin/protobuf/ExtensionRegistryLite;", "PLATFORM_TYPE_ID", "getJvmConstructorSignature", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMemberSignature$Method;", "proto", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Constructor;", "nameResolver", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/NameResolver;", "typeTable", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/TypeTable;", "getJvmFieldSignature", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMemberSignature$Field;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Property;", "requireHasFieldFlag", "", "getJvmMethodSignature", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Function;", "isMovedFromInterfaceCompanion", "isNewPlaceForBodyGeneration", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Class;", "mapTypeDefault", "type", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Type;", "readClassDataFrom", "Lkotlin/Pair;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmNameResolver;", "data", "", "strings", "([Ljava/lang/String;[Ljava/lang/String;)Lkotlin/Pair;", "bytes", "", "([B[Ljava/lang/String;)Lkotlin/Pair;", "readFunctionDataFrom", "readPackageDataFrom", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Package;", "writeData", "message", "Landroidx/room/jarjarred/kotlinx/metadata/internal/protobuf/MessageLite;", "stringTable", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/serialization/JvmStringTable;", "(Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/jvm/serialization/JvmStringTable;)[Ljava/lang/String;", "writeDataBytes", "kotlin.jvm.PlatformType", "readNameResolver", "Ljava/io/InputStream;", "(Ljava/io/InputStream;[Ljava/lang/String;)Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolver;", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmProtoBufUtil {
    public static final String DEFAULT_MODULE_NAME = "main";
    private static final ExtensionRegistryLite EXTENSION_REGISTRY = null;
    public static final JvmProtoBufUtil INSTANCE = null;
    public static final String PLATFORM_TYPE_ID = "kotlin.jvm.PlatformType";

    static {
        INSTANCE = new JvmProtoBufUtil();
        ExtensionRegistryLite r5 = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(r5);
        EXTENSION_REGISTRY = r5;
    }

    private JvmProtoBufUtil() {
    }

    public static /* synthetic */ JvmMemberSignature.Field getJvmFieldSignature$default(JvmProtoBufUtil r5, ProtoBuf.Property r10, NameResolver r11, TypeTable r12, boolean r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = true;
    L6:
        return r5.getJvmFieldSignature(r10, r11, r12, r13);
    }

    @JvmStatic
    public static final boolean isMovedFromInterfaceCompanion(ProtoBuf.Property r5) {
        Intrinsics.checkNotNullParameter(r5, "proto");
        return JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION().get(((Number) r5.getExtension(JvmProtoBuf.flags)).intValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean isNewPlaceForBodyGeneration(ProtoBuf.Class r5) {
        Intrinsics.checkNotNullParameter(r5, "proto");
        return JvmFlags.INSTANCE.getIS_COMPILED_IN_JVM_DEFAULT_MODE().get(((Number) r5.getExtension(JvmProtoBuf.jvmClassFlags)).intValue()).booleanValue();
    }

    private final String mapTypeDefault(ProtoBuf.Type r5, NameResolver r10) {
        if (r5.hasClassName() == true) goto L7;
        return null;
    L7:
        return ClassMapperLite.mapClass(r10.getQualifiedClassName(r5.getClassName()));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(String[] r5, String[] r10) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r10, "strings");
        return readClassDataFrom(BitEncoding.decodeBytes(r5), r10);
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Function> readFunctionDataFrom(String[] r5, String[] r10) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r10, "strings");
        ByteArrayInputStream r11 = new ByteArrayInputStream(BitEncoding.decodeBytes(r5));
        return new Pair(INSTANCE.readNameResolver(r11, r10), ProtoBuf.Function.parseFrom(r11, EXTENSION_REGISTRY));
    }

    private final JvmNameResolver readNameResolver(InputStream r5, String[] r10) {
        return new JvmNameResolver(JvmProtoBuf.StringTableTypes.parseDelimitedFrom(r5, EXTENSION_REGISTRY), r10);
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(String[] r5, String[] r10) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r10, "strings");
        return readPackageDataFrom(BitEncoding.decodeBytes(r5), r10);
    }

    @JvmStatic
    public static final String[] writeData(MessageLite r5, JvmStringTable r10) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r10, "stringTable");
        return BitEncoding.encodeBytes(writeDataBytes(r10, r5));
    }

    @JvmStatic
    public static final byte[] writeDataBytes(JvmStringTable r5, MessageLite r10) {
        Intrinsics.checkNotNullParameter(r5, "stringTable");
        Intrinsics.checkNotNullParameter(r10, "message");
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        r5.serializeTo(r11);
        r10.writeTo(r11);
        return r11.toByteArray();
    }

    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return EXTENSION_REGISTRY;
    }

    public final JvmMemberSignature.Method getJvmConstructorSignature(ProtoBuf.Constructor r10, NameResolver r11, TypeTable r12) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        Intrinsics.checkNotNullParameter(r12, "typeTable");
        JvmProtoBuf.JvmMethodSignature r13 = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(r10, JvmProtoBuf.constructorSignature);
        if (r13 != null) goto L5;
    L7:
        String r5 = "<init>";
    L8:
        if (r13 != null) goto L10;
    L12:
        List<ProtoBuf.ValueParameter> r14 = r10.getValueParameterList();
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator<T> r16 = r14.iterator();
    L14:
        if (r16.hasNext() == false) goto L20;
        ProtoBuf.ValueParameter r17 = (ProtoBuf.ValueParameter) r16.next();
        String r18 = INSTANCE.mapTypeDefault(ProtoTypeTableUtilKt.type(r17, r12), r11);
        if (r18 == null) goto L17;
        r15.add(r18);
        goto L14
    L17:
        return null;
    L20:
        String r19 = CollectionsKt.q(r15, "", "(", ")V", 0, null, null, 56);
    L22:
        return new JvmMemberSignature.Method(r5, r19);
    L10:
        if (r13.hasDesc() == false) goto L12;
        r19 = r11.getString(r13.getDesc());
        goto L22
    L5:
        if (r13.hasName() == false) goto L7;
        r5 = r11.getString(r13.getName());
        goto L8
    }

    public final JvmMemberSignature.Field getJvmFieldSignature(ProtoBuf.Property r5, NameResolver r10, TypeTable r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "proto");
        Intrinsics.checkNotNullParameter(r10, "nameResolver");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        JvmProtoBuf.JvmPropertySignature r13 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(r5, JvmProtoBuf.propertySignature);
        if (r13 != null) goto L6;
        return null;
    L6:
        if (r13.hasField() == false) goto L8;
        JvmProtoBuf.JvmFieldSignature r14 = r13.getField();
    L9:
        if (r14 != null) goto L12;
        if (r12 == false) goto L12;
        return null;
    L12:
        if (r14 != null) goto L14;
    L16:
        int r15 = r5.getName();
    L17:
        if (r14 != null) goto L19;
    L21:
        String r16 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(r5, r11), r10);
        if (r16 != null) goto L25;
        return null;
    L25:
        return new JvmMemberSignature.Field(r10.getString(r15), r16);
    L19:
        if (r14.hasDesc() == false) goto L21;
        r16 = r10.getString(r14.getDesc());
        goto L25
    L14:
        if (r14.hasName() == false) goto L16;
        r15 = r14.getName();
        goto L17
    L8:
        r14 = null;
        goto L9
    }

    public final JvmMemberSignature.Method getJvmMethodSignature(ProtoBuf.Function r11, NameResolver r12, TypeTable r13) {
        Intrinsics.checkNotNullParameter(r11, "proto");
        Intrinsics.checkNotNullParameter(r12, "nameResolver");
        Intrinsics.checkNotNullParameter(r13, "typeTable");
        JvmProtoBuf.JvmMethodSignature r5 = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(r11, JvmProtoBuf.methodSignature);
        if (r5 != null) goto L5;
    L7:
        int r10 = r11.getName();
    L8:
        if (r5 != null) goto L10;
    L12:
        List r14 = CollectionsKt.listOfNotNull(ProtoTypeTableUtilKt.receiverType(r11, r13));
        List<ProtoBuf.ValueParameter> r15 = r11.getValueParameterList();
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L14:
        if (r17.hasNext() == false) goto L16;
        r16.add(ProtoTypeTableUtilKt.type((ProtoBuf.ValueParameter) r17.next(), r13));
        goto L14
    L16:
        List r18 = CollectionsKt.plus(r14, r16);
        ArrayList r19 = new ArrayList(CollectionsKt.h(r18));
        Iterator r20 = r18.iterator();
    L18:
        if (r20.hasNext() == false) goto L23;
        ProtoBuf.Type r21 = (ProtoBuf.Type) r20.next();
        String r22 = INSTANCE.mapTypeDefault(r21, r12);
        if (r22 == null) goto L21;
        r19.add(r22);
        goto L18
    L21:
        return null;
    L23:
        String r110 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(r11, r13), r12);
        if (r110 != null) goto L26;
        return null;
    L26:
        String r111 = j0.q(new StringBuilder(), CollectionsKt.q(r19, "", "(", ")", 0, null, null, 56), r110);
    L28:
        return new JvmMemberSignature.Method(r12.getString(r10), r111);
    L10:
        if (r5.hasDesc() == false) goto L12;
        r111 = r12.getString(r5.getDesc());
        goto L28
    L5:
        if (r5.hasName() == false) goto L7;
        r10 = r5.getName();
        goto L8
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(byte[] r5, String[] r10) {
        Intrinsics.checkNotNullParameter(r5, "bytes");
        Intrinsics.checkNotNullParameter(r10, "strings");
        ByteArrayInputStream r11 = new ByteArrayInputStream(r5);
        return new Pair(INSTANCE.readNameResolver(r11, r10), ProtoBuf.Class.parseFrom(r11, EXTENSION_REGISTRY));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(byte[] r5, String[] r10) {
        Intrinsics.checkNotNullParameter(r5, "bytes");
        Intrinsics.checkNotNullParameter(r10, "strings");
        ByteArrayInputStream r11 = new ByteArrayInputStream(r5);
        return new Pair(INSTANCE.readNameResolver(r11, r10), ProtoBuf.Package.parseFrom(r11, EXTENSION_REGISTRY));
    }
}
