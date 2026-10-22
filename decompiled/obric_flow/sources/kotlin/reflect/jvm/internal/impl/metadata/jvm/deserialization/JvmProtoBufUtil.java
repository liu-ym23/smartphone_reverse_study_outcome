package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import ai.j0;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJvmProtoBufUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmProtoBufUtil.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmProtoBufUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,141:1\n1549#2:142\n1620#2,3:143\n1549#2:146\n1620#2,3:147\n1549#2:150\n1620#2,3:151\n1#3:154\n*S KotlinDebug\n*F\n+ 1 JvmProtoBufUtil.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmProtoBufUtil\n*L\n79#1:142\n79#1:143,3\n81#1:146\n81#1:147,3\n103#1:150\n103#1:151,3\n*E\n"})
public final class JvmProtoBufUtil {
    private static final ExtensionRegistryLite EXTENSION_REGISTRY = null;
    public static final JvmProtoBufUtil INSTANCE = null;

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
