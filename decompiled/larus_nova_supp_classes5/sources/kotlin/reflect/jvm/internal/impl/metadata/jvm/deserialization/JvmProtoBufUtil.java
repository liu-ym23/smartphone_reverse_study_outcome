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
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JvmProtoBufUtil {
    private static final ExtensionRegistryLite EXTENSION_REGISTRY = null;
    public static final JvmProtoBufUtil INSTANCE = null;

    private JvmProtoBufUtil() {
    }

    static {
        INSTANCE = new JvmProtoBufUtil();
        ExtensionRegistryLite r0 = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(r0);
        EXTENSION_REGISTRY = r0;
    }

    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return EXTENSION_REGISTRY;
    }

    @JvmStatic
    public static final boolean isMovedFromInterfaceCompanion(ProtoBuf$Property r2) {
        Intrinsics.checkNotNullParameter(r2, "proto");
        return JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION().get(((Number) r2.getExtension(JvmProtoBuf.flags)).intValue()).booleanValue();
    }

    private final String mapTypeDefault(ProtoBuf$Type r2, NameResolver r3) {
        if (r2.hasClassName() == true) goto L7;
        return null;
    L7:
        return ClassMapperLite.mapClass(r3.getQualifiedClassName(r2.getClassName()));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf$Class> readClassDataFrom(byte[] r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r2, "bytes");
        Intrinsics.checkNotNullParameter(r3, "strings");
        ByteArrayInputStream r0 = new ByteArrayInputStream(r2);
        return new Pair(INSTANCE.readNameResolver(r0, r3), ProtoBuf$Class.parseFrom(r0, EXTENSION_REGISTRY));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf$Function> readFunctionDataFrom(String[] r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "strings");
        ByteArrayInputStream r0 = new ByteArrayInputStream(BitEncoding.decodeBytes(r2));
        return new Pair(INSTANCE.readNameResolver(r0, r3), ProtoBuf$Function.parseFrom(r0, EXTENSION_REGISTRY));
    }

    private final JvmNameResolver readNameResolver(InputStream r3, String[] r4) {
        return new JvmNameResolver(JvmProtoBuf.StringTableTypes.parseDelimitedFrom(r3, EXTENSION_REGISTRY), r4);
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf$Package> readPackageDataFrom(byte[] r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r2, "bytes");
        Intrinsics.checkNotNullParameter(r3, "strings");
        ByteArrayInputStream r0 = new ByteArrayInputStream(r2);
        return new Pair(INSTANCE.readNameResolver(r0, r3), ProtoBuf$Package.parseFrom(r0, EXTENSION_REGISTRY));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf$Class> readClassDataFrom(String[] r1, String[] r2) {
        Intrinsics.checkNotNullParameter(r1, "data");
        Intrinsics.checkNotNullParameter(r2, "strings");
        return readClassDataFrom(BitEncoding.decodeBytes(r1), r2);
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf$Package> readPackageDataFrom(String[] r1, String[] r2) {
        Intrinsics.checkNotNullParameter(r1, "data");
        Intrinsics.checkNotNullParameter(r2, "strings");
        return readPackageDataFrom(BitEncoding.decodeBytes(r1), r2);
    }

    public final JvmMemberSignature.Method getJvmConstructorSignature(ProtoBuf$Constructor r12, NameResolver r13, TypeTable r14) {
        Intrinsics.checkNotNullParameter(r12, "proto");
        Intrinsics.checkNotNullParameter(r13, "nameResolver");
        Intrinsics.checkNotNullParameter(r14, "typeTable");
        JvmProtoBuf.JvmMethodSignature r0 = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(r12, JvmProtoBuf.constructorSignature);
        if (r0 != null) goto L5;
    L7:
        String r1 = "<init>";
    L8:
        if (r0 != null) goto L10;
    L12:
        List<ProtoBuf$ValueParameter> r15 = r12.getValueParameterList();
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r16 = r15.iterator();
    L14:
        if (r16.hasNext() == false) goto L20;
        ProtoBuf$ValueParameter r3 = (ProtoBuf$ValueParameter) r16.next();
        JvmProtoBufUtil r4 = INSTANCE;
        Intrinsics.checkNotNull(r3);
        String r5 = r4.mapTypeDefault(ProtoTypeTableUtilKt.type(r3, r14), r13);
        if (r5 == null) goto L17;
        r2.add(r5);
        goto L14
    L17:
        return null;
    L20:
        String r17 = CollectionsKt.joinToString$default(r2, "", "(", ")V", 0, null, null, 56, null);
    L22:
        return new JvmMemberSignature.Method(r1, r17);
    L10:
        if (r0.hasDesc() == false) goto L12;
        r17 = r13.getString(r0.getDesc());
        goto L22
    L5:
        if (r0.hasName() == false) goto L7;
        r1 = r13.getString(r0.getName());
        goto L8
    }

    public final JvmMemberSignature.Method getJvmMethodSignature(ProtoBuf$Function r18, NameResolver r19, TypeTable r20) {
        Intrinsics.checkNotNullParameter(r18, "proto");
        Intrinsics.checkNotNullParameter(r19, "nameResolver");
        Intrinsics.checkNotNullParameter(r20, "typeTable");
        JvmProtoBuf.JvmMethodSignature r3 = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(r18, JvmProtoBuf.methodSignature);
        if (r3 != null) goto L5;
    L7:
        int r4 = r18.getName();
    L8:
        if (r3 != null) goto L10;
    L12:
        List r5 = CollectionsKt.listOfNotNull(ProtoTypeTableUtilKt.receiverType(r18, r20));
        List<ProtoBuf$ValueParameter> r6 = r18.getValueParameterList();
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        ProtoBuf$ValueParameter r9 = (ProtoBuf$ValueParameter) r8.next();
        Intrinsics.checkNotNull(r9);
        r7.add(ProtoTypeTableUtilKt.type(r9, r20));
        goto L14
    L16:
        List r10 = CollectionsKt.plus(r5, r7);
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L18:
        if (r12.hasNext() == false) goto L23;
        String r13 = INSTANCE.mapTypeDefault((ProtoBuf$Type) r12.next(), r19);
        if (r13 == null) goto L21;
        r11.add(r13);
        goto L18
    L21:
        return null;
    L23:
        String r0 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(r18, r20), r19);
        if (r0 != null) goto L26;
        return null;
    L26:
        String r1 = CollectionsKt.joinToString$default(r11, "", "(", ")", 0, null, null, 56, null) + r0;
    L28:
        return new JvmMemberSignature.Method(r19.getString(r4), r1);
    L10:
        if (r3.hasDesc() == false) goto L12;
        r1 = r19.getString(r3.getDesc());
        goto L28
    L5:
        if (r3.hasName() == false) goto L7;
        r4 = r3.getName();
        goto L8
    }

    public final JvmMemberSignature.Field getJvmFieldSignature(ProtoBuf$Property r4, NameResolver r5, TypeTable r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "proto");
        Intrinsics.checkNotNullParameter(r5, "nameResolver");
        Intrinsics.checkNotNullParameter(r6, "typeTable");
        JvmProtoBuf.JvmPropertySignature r0 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(r4, JvmProtoBuf.propertySignature);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.hasField() == false) goto L8;
        JvmProtoBuf.JvmFieldSignature r1 = r0.getField();
    L9:
        if (r1 != null) goto L12;
        if (r7 == false) goto L12;
        return null;
    L12:
        if (r1 != null) goto L14;
    L16:
        int r8 = r4.getName();
    L17:
        if (r1 != null) goto L19;
    L21:
        String r9 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(r4, r6), r5);
        if (r9 != null) goto L25;
        return null;
    L25:
        return new JvmMemberSignature.Field(r5.getString(r8), r9);
    L19:
        if (r1.hasDesc() == false) goto L21;
        r9 = r5.getString(r1.getDesc());
        goto L25
    L14:
        if (r1.hasName() == false) goto L16;
        r8 = r1.getName();
        goto L17
    L8:
        r1 = null;
        goto L9
    }

    public static /* synthetic */ JvmMemberSignature.Field getJvmFieldSignature$default(JvmProtoBufUtil r0, ProtoBuf$Property r1, NameResolver r2, TypeTable r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = true;
    L6:
        return r0.getJvmFieldSignature(r1, r2, r3, r4);
    }
}
