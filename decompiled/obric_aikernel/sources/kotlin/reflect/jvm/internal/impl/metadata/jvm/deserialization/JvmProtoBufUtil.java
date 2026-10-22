package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmProtoBufUtil {
    private static final ExtensionRegistryLite EXTENSION_REGISTRY = null;
    public static final JvmProtoBufUtil INSTANCE = null;

    static {
        INSTANCE = new JvmProtoBufUtil();
        ExtensionRegistryLite r10 = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(r10);
        Intrinsics.checkNotNullExpressionValue(r10, "newInstance().apply(JvmP…f::registerAllExtensions)");
        EXTENSION_REGISTRY = r10;
    }

    private JvmProtoBufUtil() {
    }

    public static /* synthetic */ JvmMemberSignature.Field getJvmFieldSignature$default(JvmProtoBufUtil r10, ProtoBuf.Property r11, NameResolver r12, TypeTable r13, boolean r14, int r15, Object r16) {
        if ((r15 & 8) == 0) goto L6;
        r14 = true;
    L6:
        return r10.getJvmFieldSignature(r11, r12, r13, r14);
    }

    @JvmStatic
    public static final boolean isMovedFromInterfaceCompanion(ProtoBuf.Property r10) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        Flags.BooleanFlagField r11 = JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION();
        Object r12 = r10.getExtension(JvmProtoBuf.flags);
        Intrinsics.checkNotNullExpressionValue(r12, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean r13 = r11.get(((Number) r12).intValue());
        Intrinsics.checkNotNullExpressionValue(r13, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
        return r13.booleanValue();
    }

    private final String mapTypeDefault(ProtoBuf.Type r10, NameResolver r11) {
        if (r10.hasClassName() == true) goto L7;
        return null;
    L7:
        return ClassMapperLite.mapClass(r11.getQualifiedClassName(r10.getClassName()));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(byte[] r10, String[] r11) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        Intrinsics.checkNotNullParameter(r11, "strings");
        ByteArrayInputStream r12 = new ByteArrayInputStream(r10);
        return new Pair(INSTANCE.readNameResolver(r12, r11), ProtoBuf.Class.parseFrom(r12, EXTENSION_REGISTRY));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(String[] r10, String[] r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "strings");
        byte[] r12 = BitEncoding.decodeBytes(r10);
        Intrinsics.checkNotNullExpressionValue(r12, "decodeBytes(data)");
        return readClassDataFrom(r12, r11);
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Function> readFunctionDataFrom(String[] r10, String[] r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "strings");
        ByteArrayInputStream r12 = new ByteArrayInputStream(BitEncoding.decodeBytes(r10));
        return new Pair(INSTANCE.readNameResolver(r12, r11), ProtoBuf.Function.parseFrom(r12, EXTENSION_REGISTRY));
    }

    private final JvmNameResolver readNameResolver(InputStream r10, String[] r11) {
        JvmProtoBuf.StringTableTypes r12 = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(r10, EXTENSION_REGISTRY);
        Intrinsics.checkNotNullExpressionValue(r12, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new JvmNameResolver(r12, r11);
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(byte[] r10, String[] r11) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        Intrinsics.checkNotNullParameter(r11, "strings");
        ByteArrayInputStream r12 = new ByteArrayInputStream(r10);
        return new Pair(INSTANCE.readNameResolver(r12, r11), ProtoBuf.Package.parseFrom(r12, EXTENSION_REGISTRY));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(String[] r10, String[] r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "strings");
        byte[] r12 = BitEncoding.decodeBytes(r10);
        Intrinsics.checkNotNullExpressionValue(r12, "decodeBytes(data)");
        return readPackageDataFrom(r12, r11);
    }

    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return EXTENSION_REGISTRY;
    }

    public final JvmMemberSignature.Method getJvmConstructorSignature(ProtoBuf.Constructor r11, NameResolver r12, TypeTable r13) {
        Intrinsics.checkNotNullParameter(r11, "proto");
        Intrinsics.checkNotNullParameter(r12, "nameResolver");
        Intrinsics.checkNotNullParameter(r13, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmProtoBuf.JvmMethodSignature> r10 = JvmProtoBuf.constructorSignature;
        Intrinsics.checkNotNullExpressionValue(r10, "constructorSignature");
        JvmProtoBuf.JvmMethodSignature r14 = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(r11, r10);
        if (r14 != null) goto L5;
    L7:
        String r15 = "<init>";
    L8:
        if (r14 != null) goto L10;
    L12:
        List<ProtoBuf.ValueParameter> r16 = r11.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(r16, "proto.valueParameterList");
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L14:
        if (r18.hasNext() == false) goto L20;
        ProtoBuf.ValueParameter r19 = (ProtoBuf.ValueParameter) r18.next();
        JvmProtoBufUtil r20 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r19, "it");
        String r110 = r20.mapTypeDefault(ProtoTypeTableUtilKt.type(r19, r13), r12);
        if (r110 == null) goto L17;
        r17.add(r110);
        goto L14
    L17:
        return null;
    L20:
        String r111 = CollectionsKt.joinToString$default(r17, "", "(", ")V", 0, null, null, 56, null);
    L22:
        return new JvmMemberSignature.Method(r15, r111);
    L10:
        if (r14.hasDesc() == false) goto L12;
        r111 = r12.getString(r14.getDesc());
        goto L22
    L5:
        if (r14.hasName() == false) goto L7;
        r15 = r12.getString(r14.getName());
        goto L8
    }

    public final JvmMemberSignature.Field getJvmFieldSignature(ProtoBuf.Property r10, NameResolver r11, TypeTable r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        Intrinsics.checkNotNullParameter(r12, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> r14 = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(r14, "propertySignature");
        JvmProtoBuf.JvmPropertySignature r15 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(r10, r14);
        if (r15 != null) goto L6;
        return null;
    L6:
        if (r15.hasField() == false) goto L8;
        JvmProtoBuf.JvmFieldSignature r16 = r15.getField();
    L9:
        if (r16 != null) goto L12;
        if (r13 == false) goto L12;
        return null;
    L12:
        if (r16 != null) goto L14;
    L16:
        int r17 = r10.getName();
    L17:
        if (r16 != null) goto L19;
    L21:
        String r18 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(r10, r12), r11);
        if (r18 != null) goto L25;
        return null;
    L25:
        return new JvmMemberSignature.Field(r11.getString(r17), r18);
    L19:
        if (r16.hasDesc() == false) goto L21;
        r18 = r11.getString(r16.getDesc());
        goto L25
    L14:
        if (r16.hasName() == false) goto L16;
        r17 = r16.getName();
        goto L17
    L8:
        r16 = null;
        goto L9
    }

    public final JvmMemberSignature.Method getJvmMethodSignature(ProtoBuf.Function r18, NameResolver r19, TypeTable r20) {
        Intrinsics.checkNotNullParameter(r18, "proto");
        Intrinsics.checkNotNullParameter(r19, "nameResolver");
        Intrinsics.checkNotNullParameter(r20, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmProtoBuf.JvmMethodSignature> r10 = JvmProtoBuf.methodSignature;
        Intrinsics.checkNotNullExpressionValue(r10, "methodSignature");
        JvmProtoBuf.JvmMethodSignature r11 = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(r18, r10);
        if (r11 != null) goto L5;
    L7:
        int r12 = r18.getName();
    L8:
        if (r11 != null) goto L10;
    L12:
        List r13 = CollectionsKt.listOfNotNull(ProtoTypeTableUtilKt.receiverType(r18, r20));
        List<ProtoBuf.ValueParameter> r14 = r18.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(r14, "proto.valueParameterList");
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        ProtoBuf.ValueParameter r17 = (ProtoBuf.ValueParameter) r16.next();
        Intrinsics.checkNotNullExpressionValue(r17, "it");
        r15.add(ProtoTypeTableUtilKt.type(r17, r20));
        goto L14
    L16:
        List r21 = CollectionsKt.plus(r13, r15);
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator r23 = r21.iterator();
    L18:
        if (r23.hasNext() == false) goto L23;
        String r24 = INSTANCE.mapTypeDefault((ProtoBuf.Type) r23.next(), r19);
        if (r24 == null) goto L21;
        r22.add(r24);
        goto L18
    L21:
        return null;
    L23:
        String r25 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(r18, r20), r19);
        if (r25 != null) goto L26;
        return null;
    L26:
        String r26 = CollectionsKt.joinToString$default(r22, "", "(", ")", 0, null, null, 56, null) + r25;
    L28:
        return new JvmMemberSignature.Method(r19.getString(r12), r26);
    L10:
        if (r11.hasDesc() == false) goto L12;
        r26 = r19.getString(r11.getDesc());
        goto L28
    L5:
        if (r11.hasName() == false) goto L7;
        r12 = r11.getName();
        goto L8
    }
}
